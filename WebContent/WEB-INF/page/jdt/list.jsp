<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form id="pagerForm" method="post" action="Jdt/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" />
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="Jdt/list"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>题目内容：<input type="text" name="content"
						value="${obj.o.pContent}" /></td>
					<td>题目状态：<input type="text" name="status"
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
					<li><a class="button" href="Jdt/queryUi" target="dialog"
						mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="Jdt/addUi" target="navTab" mask="true"
				rel="newPage" title="添加解答题信息"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids"
				postType="string" href="Jdt/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="Jdt/editUi?pID={sid_eaxmjdt}"
				target="dialog" mask="true" title="修改解答题信息"><span>修改</span></a></li>
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
				<th>题目内容</th>
				<th>科目名称</th>
				<th>岗位信息</th>
				<th>难度系数</th>
				<th>备注信息</th>
				<th>当前状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="acc">
				<tr target="sid_eaxmjdt" rel="${acc.pID }">
					<td><input name="ids" value="'${acc.pID}'" type="checkbox"></td>
					<td>${acc.pContent}</td>
					<td>${acc.subjectName}</td>
					<td>${acc.gwName}</td>
					<td>${acc.ndxs}</td>
					<td>${acc.remark}</td>
					<td>${acc.status==0?'有效':'无效'}</td>

					<td><a title="删解答题信息" target="ajaxTodo"
						href="Jdt/delete?pID=${acc.pID}" class="btnDel">删除解答题信息</a> <a
						title="查看解答题信息" target="dialog" href="Jdt/view?pID=${acc.pID}"
						class="btnView">查看部门信息</a> <a title="编辑解答题信息" target="dialog"
						href="Jdt/editUi?pID=${acc.pID}" class="btnEdit">编辑解答题信息</a></td>
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