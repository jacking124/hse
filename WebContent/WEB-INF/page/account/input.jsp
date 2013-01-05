<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post"
		action="Account/add"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="ID" value="${obj.ID}">
			<p>
				<label>用户名称：</label> <input name="userName" type="text" size="30"
					value="${obj.userName}" class="required" maxlength="150" />
			</p>
			<p>
				<label>真实姓名：</label> <input name="description" type="text" size="30"
					value="${obj.description}" maxlength="255" />
			</p>
			<p>
				<label>用户密码：</label> <input name="password" type="text" size="30"
					value="${obj.password}" class="required" maxlength="150" />
			</p>
			<p>
				<label>部门信息：</label> <select name="organization" class="combox">
					<c:forEach var="di" items="${obj.departmentInfoList}">
						<option value="${di.dID}">${di.dName}</option>
					</c:forEach>
				</select>
			</p>
			<p>
			   <label>用户组：</label><input name="roleID" type="text" value="${obj.roleID}">
			</p>
			<p>
				<label>用户状态：</label> <select name="status" class="combox">
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
