<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form id="pagerForm" method="post" action="GradeInfo/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" />
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 名称 --%>
	<input type="hidden" name="dName" value="${obj.o.testName}" />
	<%-- 描述 --%>
	<input type="hidden" name="remark" value="${obj.o.remark}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="GradeInfo/list"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>考试名称：<input type="text" name="testName"
						value="${obj.o.testName}" /></td>
					<td>考试成绩：<input type="text" name="score"
						value="${obj.o.score==0?'':obj.o.score}" /></td>
					<td>考试日期： <input type="text" name="ksDate"
						class="date" readonly="true" value="${obj.o.ksDate}" />
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
					<li><a class="button" href="GradeInfo/queryUi" target="dialog"
						mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="GradeInfo/addUi" target="dialog"
				mask="true" title="添加用户信息"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids"
				postType="string" href="GradeInfo/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="GradeInfo/editUi?SID={sid_GradeInfo}"
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
				<th>考试项目</th>
				<th>员工名称</th>
				<th>岗位名称</th>
				<th>成 绩</th>
				<th>考试日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="acc">
				<tr target="sid_GradeInfo" rel="${acc.SID }">
					<td><input name="ids" value="'${acc.SID}'" type="checkbox"></td>
					<td>${acc.testName}</td>
					<td>${acc.eName}</td>
					<td>${acc.gwInfo}</td>
					<td>${acc.score}</td>
					<td>${acc.ksDate}</td>
					<td>${acc.remark}</td>

					<td><a title="删除部门信息" target="ajaxTodo"
						href="GradeInfo/delete?SID=${acc.SID}" class="btnDel">删除部门信息</a> <%-- 
				<a title="查看部门信息" target="dialog" href="Job/view?ID=${acc.ID}" class="btnView">查看部门信息</a>
				--%> <a title="编辑部门信息" target="dialog"
						href="GradeInfo/editUi?SID=${acc.SID}" class="btnEdit">编辑部门信息</a></td>
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