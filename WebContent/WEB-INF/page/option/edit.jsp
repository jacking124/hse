<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
<c:set var="ex" value="${obj.optionP}"/>
	<form method="post" action="Option/update"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="ID" value="${obj.zID}">
			<fieldset>
				<legend>选择题添加内容</legend>
				<dl class="nowrap">
					<dt>解答题目：</dt>
					<dd>
						<textarea name="content" cols="80" rows="3" class="required">${ex.content}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>类型：</dt>
					<dd>
						<select name="type" class="combox" class="required">
							<option value="0">---单选题---</option>
							<option value="1">---多选题---</option>
						</select>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>科目名称：</dt>
					<dd>
						<select name="subjectName" class="combox" class="required">
							<c:forEach var="di" items="${obj.subject}">
								<option value="${di.subID}">${di.subName}</option>
							</c:forEach>
						</select>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>选项A：</dt>
					<dd>
						<textarea name="aOption" cols="80" rows="2" class="required">${ex.aOption}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>选项B：</dt>
					<dd>
						<textarea name="bOption" cols="80" rows="2" class="required">${ex.bOption}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>选项C：</dt>
					<dd>
						<textarea name="cOption" cols="80" rows="2" class="required">${ex.cOption}</textarea>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt>选项D：</dt>
					<dd>
						<textarea name="dOption" cols="80" rows="2" class="required">${ex.dOption}</textarea>
					</dd>
				</dl>
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
			<dl class="nowrap">
				<dt>正确答案：</dt>
				<dd>
					<textarea name="answer" cols="80" rows="3" class="required">${ex.answer}</textarea>
				</dd>
			</dl>
			<p>
				<label>备注信息：</label> <input name="remark" type="text" size="30"
					value="${ex.remark}" maxlength="150" />
			</p>
			<p>
				<label>状态：</label> <select name="status" 
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
