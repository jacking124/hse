<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="Account/list" class="pageForm"
			onsubmit="return navTabSearch(this, 'account');">
			<div class="pageFormContent" layoutH="58">
				<!-- 				<div> -->
				<!-- 					<label>请输入检索条件：</label> -->
				<!-- 					<input type="text" size="50" minlength="3" maxlength="10"/> -->
				<!-- 				</div> -->
				<div class="divDeider">divDeider</div>
				<div>
					<label>考试名称：</label> <input type="text" name="testName"
						value="${obj.o.testName}" /> <span class="inputInfo">考试名称</span>
				</div>
				<div>
					<label>员工信息：</label><input type="text" name="eName"
						value="${obj.o.eName}" />
				</div>
				<div>
					<label>岗位名称：</label><input type="text" name="gwName"
						value="${obj.o.gwName}" />
				</div>
				<div>
					<label>部门名称：</label><input type="text" name="dName"
						value="${obj.o.dName}" />
				</div>
				<div>
					<label>部门名称：</label> <<input type="text" name="dName"
						value="${obj.o.dName}" /> <span class="inputInfo">部门名称</span>
				</div>
				<div>
					<label>考试日期：</label> <input type="text" name="ksDate" class="date"
						readonly="true" value="${obj.o.ksDate}" /> <span
						class="inputInfo">考试日期</span>
				</div>
				<%-- 			    <div>
					<label>创建人：</label>
					<input type="text" name="createUser" value="${obj.o.createUser}" size="25" />
					<span class="inputInfo">创建人</span>
					</div> --%>
				<%-- 			    <div>
					<label>创建时间：</label>
					<input type="text" name="createDate" value="${obj.o.createDate}" size="25" />
					<span class="inputInfo">创建时间</span>
					</div> --%>
				<%-- 			    <div>
					<label>修改人：</label>
					<input type="text" name="modifyUser" value="${obj.o.modifyUser}" size="25" />
					<span class="inputInfo">修改人</span>
					</div> --%>
				<%-- 			    <div>
					<label>修改时间：</label>
					<input type="text" name="modifyDate" value="${obj.o.modifyDate}" size="25" />
					<span class="inputInfo">修改时间</span>
					</div> --%>
				<!-- 				<div class="divDeider">divDeider</div> -->
				<!-- 				<div> -->
				<!-- 					<label>排序条件：</label> -->
				<!-- 					<select> -->
				<!-- 						<option>按客户号倒排</option> -->
				<!-- 						<option>按建档日期倒排</option> -->
				<!-- 						<option>按信用等级顺排</option> -->
				<!-- 						<option>按客户号顺排</option> -->
				<!-- 						<option>按建档日期顺排</option> -->
				<!-- 						<option>按所属行业顺排</option> -->
				<!-- 					</select> -->
				<!-- 				</div> -->
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">开始检索</button>
							</div>
						</div></li>
					<li><div class="button">
							<div class="buttonContent">
								<button type="reset">清空重输</button>
							</div>
						</div></li>
				</ul>
			</div>
		</form>
	</div>
</div>