<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
<c:set var="ex" value="${obj.judge}"/>
	<form method="post" action="Judge/update" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="pID" value="${ex.pID}">
			<fieldset>
				<legend>判断题添加内容</legend>
				<dl class="nowrap">
					<dt>判断题题目：</dt>
					<dd>
						<textarea name="content" cols="80" rows="3" class="required">${ex.content}</textarea>
					</dd>
				</dl>
				<p>
					<label>科目名称：</label> <select name="subjectID" class="combox"
						class="required">
						<c:forEach var="di" items="${obj.subject}">
							<option value="${di.subID}">${di.subName}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label>岗位信息：</label> <select name="gwName" class="combox"
						class="required">
						<c:forEach var="di" items="${obj.gwinfo}">
							<option value="${di.ID}">${di.gwName}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label>难度系数：</label> <select name="ndxs" class="combox">
						<option value="1">一般难度</option>
						<option value="2">中间难度</option>
						<option value="3">高难度</option>
					</select>
				</p>
				<p>
					<label>正确答案：</label> <select name="answer" class="combox">
						<option value="0">----对----</option>
						<option value="1">----错----</option>
					</select>
				</p>
				<dl class="nowrap">
					<dt>备注信息：</dt>
					<dd>
						<textarea name="remark" cols="80" rows="2" >${ex.remark}</textarea>
					</dd>
				</dl>
				<p>
					<label>状态：</label> <select name="status" value="${ex.status}"
						class="required">
						<option value="0">有效</option>
						<option value="1">无效</option>
					</select>

				</p>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
