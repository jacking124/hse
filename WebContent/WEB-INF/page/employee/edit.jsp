<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<c:set var="ui" value="${obj.employee}" />
	<form method="post" action="Employee/update"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="empID" value="${ui.empID}">
			<p>
				<label>员工姓名：</label> <input name="eName" type="text" size="30"
					value="${ui.eName}" class="required" maxlength="150" />
			</p>
			<p>
				<label>性别：</label> <select name="gender" class="combox">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</p>
			<p>
				<label>部门信息：</label><select name="department" class="combox">
					<c:forEach var="di" items="${obj.departmentInfoList}">
						<c:if test="${di.dID == ui.department}">
							<option value="${di.dID}" selected="selected">${di.dName}</option>
						</c:if>
						<c:if test="${di.dID != ui.department}">
							<option value="${di.dID}">${di.dName}</option>
						</c:if>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>联系方式：</label> <input name="telphone" type="text" size="30"
					value="${ui.telphone}" maxlength="36" />
			</p>
			<p>
				<label>备注信息：</label> <input name="remark" type="text" size="30"
					value="${ui.remark}" maxlength="36" />
			</p>
			<p>
				<label>状态：</label> <select name="status" class="combox">
					<option value="0">有效</option>
					<option value="1">无效</option>
				</select>
			</p>

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
