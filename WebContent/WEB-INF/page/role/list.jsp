<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form id="pagerForm" method="post" action="role/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" />
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 名称 --%>
	<input type="hidden" name="gwName" value="${obj.o.roleName}" />
	<%--状态 --%>
	<input type="hidden" name="status" value="${obj.o.status}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="role/list"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>角色名称：<input type="text" name="roleName"
						value="${obj.o.gwName}" /></td>
					<td>状 态：<input type="text" name="status"
						value="${obj.o.status}" /></td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
					<li><a class="button" href="role/queryUi" target="dialog"
						mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="role/addUi" target="dialog" mask="true"
				title="添加用户信息"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids"
				postType="string" href="role/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="role/editUi?roleID={sid_roleInfo}"
				target="dialog" mask="true" title="修改用户信息"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport"
				targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids"
					class="checkboxCtrl"></th>
				<th>角色名称</th>
				<th>角色描述</th>
				<th>备注信息</th>
				<th>当前状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="acc">
				<tr target="sid_roleInfo" rel="${acc.roleID }">
					<td><input name="ids" value="'${acc.roleID}'" type="checkbox"></td>
					<td>${acc.roleName}</td>
					<td>${acc.roleDesc}</td>
					<td>${acc.remark}</td>
					<td>${acc.status==0?'有效':'无效'}</td>
					
					<td><a title="删除角色信息" target="ajaxTodo"
						href="role/delete?roleID=${acc.roleID}" class="btnDel">删除角色信息</a> 
				<a title="授权" target="dialog" href="role/permUi?roleID=${acc.roleID}" class="btnView">授权</a>
				 <a title="编辑角色信息" target="dialog"
						href="role/editUi?roleID=${acc.roleID}" class="btnEdit">编辑角色信息</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span> <select class="combox" name="numPerPage"
				onchange="navTabPageBreak({numPerPage:this.value})">
				<c:forEach begin="10" end="40" step="10" varStatus="s">
					<option value="${s.index}"
						${obj.pager.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
				</c:forEach>
			</select> <span>条，共${obj.pager.recordCount}条</span>
		</div>

		<div class="pagination" targetType="navTab"
			totalCount="${obj.pager.recordCount}"
			numPerPage="${obj.pager.pageSize}" pageNumShown="10"
			currentPage="${obj.pager.pageNumber}"></div>

	</div>
</div>