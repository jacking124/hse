<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="Account/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 名称 --%>
	<input type="hidden" name="userName" value="${obj.o.userName}"/>
	<%-- 账套状态 --%>
	<input type="hidden" name="status" value="${obj.o.status}"/>
	<%-- 描述 --%>
	<input type="hidden" name="description" value="${obj.o.description}"/>
	<%-- 组织机构 --%>
	<input type="hidden" name="organization" value="${obj.o.organization}"/>
	<%-- 创建人 --%>
<%--<input type="hidden" name="createUser" value="${obj.o.createUser}/> --%>
	<%-- 创建时间 --%>
<%--<input type="hidden" name="createDate" value="${obj.o.createDate}/> --%>
	<%-- 修改人 --%>
<%--<input type="hidden" name="modifyUser" value="${obj.o.modifyUser}/> --%>
	<%-- 修改时间 --%>
<%--<input type="hidden" name="modifyDate" value="${obj.o.modifyDate}/> --%>
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="Account/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>用户名称：<input type="text" name="userName" value="${obj.o.userName}"/></td>
					<td>用户状态：<input type="text" name="status" value="${obj.o.status}"/></td>
					<td>描述：<input type="text" name="description" value="${obj.o.description}"/></td>
<%-- 			    	<td>组织机构：<input type="text" name="organization" value="${obj.o.organization}/></td> --%>			        
<%-- 			    	<td>创建人：<input type="text" name="createUser" value="${obj.o.createUser}/></td> --%>			        
<%-- 			    	<td>创建时间：<input type="text" name="createDate" value="${obj.o.createDate}/></td> --%>			        
<%-- 			    	<td>修改人：<input type="text" name="modifyUser" value="${obj.o.modifyUser}/></td> --%>			        
<%-- 			    	<td>修改时间：<input type="text" name="modifyDate" value="${obj.o.modifyDate}/></td> --%>			        
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
					<li><a class="button" href="Account/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="Account/addUi" target="dialog" mask="true" title="添加用户信息"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="Account/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="Account/editUi?ID={sid_account}" target="dialog" mask="true" title="修改用户信息"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>用户ID</th>
				<th>真实姓名</th>
				<th>当前密码</th>
				<th>部门信息</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>当前状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="acc">
				<tr target="sid_account" rel="${acc.ID }">
				<td><input name="ids" value="'${acc.ID}'" type="checkbox"></td>
					<td>${acc.ID}</td>
					<td>${acc.description}</td>
					<td>${acc.password}</td>
					<td>${acc.dName}</td>
					<td>${acc.createUser}</td>
					<td>${acc.createDate}</td>
					<td>${acc.status==0?'有效':'无效'}</td>
				<td>
				<a title="删除用户信息" target="ajaxTodo" href="Account/delete?ID=${acc.ID}" class="btnDel">删除用户信息</a>
				<%-- 
				<a title="查看用户信息" target="dialog" href="Account/view?ID=${acc.ID}" class="btnView">查看用户信息</a>
				--%>
				<a title="编辑用户信息" target="dialog" href="Account/editUi?ID=${acc.ID}" class="btnEdit">编辑用户信息</a>
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span> 
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			<c:forEach begin="10" end="40" step="10" varStatus="s">
				<option value="${s.index}" ${obj.pager.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
			<span>条，共${obj.pager.recordCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="${obj.pager.recordCount}" numPerPage="${obj.pager.pageSize}" pageNumShown="10" currentPage="${obj.pager.pageNumber}"></div>

	</div>
</div>