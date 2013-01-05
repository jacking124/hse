<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post"
		action="Job/<c:choose><c:when test="${obj==null}">add</c:when><c:otherwise>update</c:otherwise></c:choose>"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="ID" value="${obj.ID}">
			<p>
				<label>岗位名称：</label> <input name="gwName" type="text" size="30"
					value="${obj.gwName}" class="required" maxlength="150" />
			</p>
			<p>
				<label>备注信息：</label> <input name="remark" type="text" size="30"
					value="${obj.remark}"  maxlength="150" />
			</p>
			<p>
				<label>岗位状态：</label> <select name="status" value="${obj.status}"
					class="required">
					<option value="0">有效</option>
					<option value="1">无效</option>
				</select>

			</p>
			<%--  
			<p>
				<label>描述：</label> <input name="description" type="text" size="30"
					value="${obj.description}" maxlength="255" />
			</p>
			<p>
				<label>组织机构：</label>
			    <input name="organization" type="text"
					size="30" value="${obj.organization}" class="required"
					maxlength="36" />
			</p>
            --%>
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
