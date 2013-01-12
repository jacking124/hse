<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="ExamMain/autoAdd"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>试卷名称：</label><input type="text" name="title" class="required"
					autofocus="autofocus" />
			</p>
			<p>
				<label>试卷总分：</label><input type="text" name="exscore" class="required" />
			</p>
			<p>
				<label>考试科目：</label><select title="科目信息选择">
					<c:forEach var="su" items="${obj.subject}">
						<option value="${su.subID}">${su.subName}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>岗位信息：</label> <select name="gwName" class="combox">
					<c:forEach var="di" items="${obj.gwinfo}">
						<option value="${di.ID}">${di.gwName}</option>
					</c:forEach>
				</select>
			<p>
				<label>难度系数：</label> <select name="ndxs" class="combox">
					<option value="初级">一般难度</option>
					<option value="中级">中间难度</option>
					<option value="高级">高难度</option>
				</select>
			</p>
			<!--  
			<p>
				<label>填空题数：</label><input type="text" name="blanksNum"
					class="required" />
			</p>
			-->
			<p>
				<label>判断题数：</label><input type="text" name="judgesNum"
					class="required" />
			</p>
			<p>
				<label>单选题数：</label><input type="text" name="singleOptionNum"
					class="required" />
			</p>
			<p>
				<label>多选题数：</label><input type="text" name="doubleOptionNum"
					class="required" />
			</p>
			<p>
				<label>解答题数：</label><input type="text" name="jdtNum"
					class="required" />
			</p>
			<p>
				<label>备注信息：</label><input type="text" name="remark" />
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

<div class="pageContent"></div>
