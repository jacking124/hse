<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form id="pagerForm" method="post" action="ExamMain/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" />
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="ExamMain/list"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>题目内容：<input type="text" name="content"
						value="${obj.o.exName}" /></td>
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
					<li><a class="button" href="ExamMain/queryUi" target="dialog"
						mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="ExamMain/autoAddUi" target="dialog"
				mask="true" rel="newPage" title="自动生成试卷"><span>自动生成</span></a></li>
			<li><a class="add" href="ExamMain/rgaddUi" target="navTab"
				mask="true" rel="newPage" title="手动生成试卷"><span>手动生成</span></a></li>
				<%--
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids"
				postType="string" href="ExamMain/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="ExamMain/editUi?exID={sid_eaxm}"
				target="dialog" mask="true" title="修改选择题信息"><span>自动生成</span></a></li>
				 --%>
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
				<th>试卷名称</th>
				<th>科目名称</th>
				<th>岗位信息</th>
				<th>难度系数</th>
				<th>分数</th>
				<th>创建时间</th>
				<th>创建人</th>
				<th>备注信息</th>
				<th>当前状态</th>
				<th>操 作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="acc">
				<tr target="sid_eaxm" rel="${acc.exID }">
					<td><input name="ids" value="'${acc.exID}'" type="checkbox"></td>
					<td>${acc.exName}</td>
					<td>${acc.exSubject}</td>
					<td>${acc.gwInfo}</td>
					<td>${acc.exNdxs}</td>
					<td>${acc.exScore }</td>
					<td>${acc.createDate }</td>
					<td>${acc.createUser }</td>
					<td>${acc.remark}</td>
					<td>${acc.status==0?'有效':'无效'}</td>
					<td><a title="删选试卷信息" target="ajaxTodo"
						href="ExamMain/delete?exID=${acc.exID}" class="btnDel">删除试卷信息</a>
						<a title="查看试卷信息" target="navTab"
						href="ExamMain/view?exID=${acc.exID}" class="btnView">查看试卷信息</a>
						<!--  
						<a title="编辑选择题信息" target="dialog"
						href="ExamMain/editUi?exID=${acc.exID}" class="btnEdit">编辑试卷信息</a></td>
						-->
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