<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="Employee/add"
		class="pageForm required-validate" enctype="multipart/form-data"
		onsubmit="return iframeCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="empID" value="${obj.empID}">
			<p>
				<label>员工姓名：</label> <input name="eName" type="text" size="30"
					value="${obj.eName}" class="required" maxlength="150" />
			</p>
			<p>
				<label>人员照片信息：</label>
				 <input type="file" name="picPath" class="required">
			</p>
			<p>
				<label>性别：</label> <select name="gender" class="combox">
					<option value="男">男</option>
					<option value="女">女</option>
				</select> <label>民族：</label> <select name="nation" class="combox">
					<option value="汉族">汉族</option>
					<option value="维吾尔族">维吾尔族</option>
					<option value="蒙古族">蒙古族</option>
					<option value="回族">回族</option>
					<option value="哈萨克族">哈萨克族</option>
				</select>
			</p>
			<p>
				<label>年龄：</label> <input name="eAge" type="text" size="30"
					value="${obj.eAge}" maxlength="36" class="required" />
			</p>
			<p>
				<label>出生年月：</label> <input name="birthday" type="text" class="date"
					value="${obj.birthday}" maxlength="36" class="required" />
			</p>
			<p>
				<label>学历：</label> <select name="education" class="combox">
					<option value="高中">高中</option>
					<option value="专科">专科</option>
					<option value="本科">本科</option>
					<option value="硕士">硕士</option>
					<option value="博士">博士</option>
				</select>
			</p>
			<p>
				<label>毕业时间：</label> <input name="graduationTime" type="text"
					class="date" size="30" value="${obj.graduationTime}" maxlength="36"
					class="required" />
			</p>
			<p>
				<label>专业：</label> <input name="profession" type="text" size="30"
					value="${obj.profession}" maxlength="36" class="required" />
			</p>
			<p>
				<label>单位：</label> <input name="company" type="text" size="30"
					value="${obj.company}" maxlength="36" class="required" />
			</p>
			<p>
				<label>部门信息：</label> <select name="department" class="combox">
					<c:forEach var="di" items="${obj.departmentInfoList}">
						<option value="${di.dID}">${di.dName}</option>
					</c:forEach>
				</select>
			</p>
			<!--  
			<p>
				<label>岗位信息：</label> <select name="gwName" class="combox"
					class="required">
					<c:forEach var="di" items="${obj.gwinfo}">
						<option value="${di.ID}">${di.gwName}</option>
					</c:forEach>
				</select>
			</p>
			-->
			<p>
				<label>工作时间：</label> <input name="workingDate" type="text"
					 value="${obj.workingDate}" maxlength="36"
					class="required" />
			</p>
			<p>
				<label>职称：</label> <input name="zcInfo" type="text" size="30"
					value="${obj.zcInfo}" maxlength="36" class="required" />
			</p>
			<p>
				<label>任职时间：</label> <input name="rzTime" type="text" class="date"
					readonly="readonly" value="${obj.rzTime}" maxlength="36"
					class="required" />
			</p>
			<p>
				<label>技能等级：</label> <input name="skillLevel" type="text" size="30"
					value="${obj.skillLevel}" maxlength="36" class="required" />
			</p>
			<p>
				<label>资格认证：</label> <input name="post_zg" type="text" size="30"
					value="${obj.post_zg}" maxlength="36" class="required" />
			</p>
			<p>
				<label>描述：</label> <input name="userID" type="text" size="30"
					value="${obj.userID}" maxlength="36" />
			</p>
			<p>
				<label>密码：</label> <input name="password" type="text" size="30"
					value="${obj.password}" maxlength="36" />
			</p>
			<p>
				<label>联系方式：</label> <input name="telphone" type="text" size="30"
					value="${obj.telphone}" maxlength="36" />
			</p>
			<p>
				<label>备注信息：</label> <input name="remark" type="text" size="30"
					value="${obj.remark}" maxlength="36" />
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
