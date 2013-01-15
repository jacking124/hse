<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageHeader">
	<form action="Examination/randomTo" method="post"
		onsubmit="return navTabSearch(this)">
		<input type="hidden" name="resourceStatus"
			value="${param.resourceStatus}" /> <input type="hidden"
			name="pageNum" value="1" />
		<div class="searchBar">
			<div class="searchContent">
				<fieldset>
					<legend>试卷生成选项</legend>
					<dl class="nowrap">
						<dt>试卷名称：</dt>
						<dd>
							<input type="text" name="title" class="required"
								autofocus="autofocus" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>岗位信息：</dt>
						<dd>
							<select name="gwName" class="combox" class="required">
								<c:forEach var="di" items="${obj.gwinfo}">
									<option value="${di.ID}">${di.gwName}</option>
								</c:forEach>
							</select>
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>难度系数：</dt>
						<dd>
							<select name="ndxs" class="combox">
								<option value="1">一般难度</option>
								<option value="2">中间难度</option>
								<option value="3">高难度</option>
							</select>
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>填空题数目：</dt>
						<dd>
							<input type="text" name="blanksNum" class="required" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>判断题数目：</dt>
						<dd>
							<input type="text" name="judgesNum" class="required" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>单选题数目：</dt>
						<dd>
							<input type="text" name="singleOptionNum" class="required" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>多选题数目：</dt>
						<dd>
							<input type="text" name="doubleOptionNum" class="required" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>解答题数目：</dt>
						<dd>
							<input type="text" name="jdtNum" class="required" />
						</dd>
					</dl>
				</fieldset>
			</div>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<!-- 显示的试卷题目 -->
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="Option/addUi" target="navTab"
				mask="true" rel="newPage" title="添加选择题信息"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="Option/editUi?pID={sid_eaxmOption}"
				target="dialog" mask="true" title="修改选择题信息"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><select name="type">
					<option value="判断题">判断题</option>
					<option value="选择题">选择题</option>
					<option value="解答题">解答题</option>
			</select></li>
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
				<th>类 型</th>
				<th>难度系数</th>
				<th>备注信息</th>
				<th>当前状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="acc">
				<tr target="sid_eaxmOption" rel="${acc.pID }">
					<td><input name="ids" value="'${acc.pID}'" type="checkbox"></td>
					<td>${acc.pContent}</td>
					<td>${acc.subjectName}</td>
					<td>${acc.gwName}</td>
					<td>${acc.typeID==0?'单选题':'多选题'}</td>
					<td>${acc.ndxs}</td>
					<td>${acc.remark}</td>
					<td>${acc.status==0?'有效':'无效'}</td>
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