<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post"
		action="GradeInfo/add"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="SID" value="${obj.SID}">
			<p>
				<label>员工姓名：</label> <input name="employeeInfo.eName" type="text"
					size="30" value="${obj.employeeInfo.eName}" class="required"
					maxlength="150" />
			</p>
			<p>
				<label>员工性别：</label> <select name="employeeInfo.gender" class="combox">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</p>
			<p>
				<label>员工岗位：</label> <select name="employeeID"  class="combox">
					<c:forEach var="di" items="${obj.gwinfo}">
						<option value="${di.ID}">${di.gwName}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>部门信息：</label> <select name="employeeInfo.department"  class="combox">
					<c:forEach var="di" items="${obj.departmentInfoList}">
						<option value="${di.dID}">${di.dName}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>考试名称：</label> <input name="testName" type="text" size="30"
					value="${obj.testName}" class="required" maxlength="150" />
			</p>
			<p>
				<label>考试成绩：</label> <input name="score" type="text" size="30"
					value="${obj.score}" class="required" maxlength="150" />
			</p>
			<p>
				<label>考试时间：</label> <input type="text" name="ksDate" class="date"
					readonly="true" value="${obj.o.ksDate}" class="required" />
			</p>
			<p>
				<label>备注信息：</label> <input name="remark" type="text" size="30"
					value="${obj.remark}" maxlength="150" />
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
