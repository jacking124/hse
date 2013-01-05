<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="ExamMain/autoAdd" class="pageForm required-validate"
		onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="searchBar" layoutH="56">
			<table class="searchContent">
				<tr>
					<td colspan="2">试卷名称：<input type="text" name="title"
						class="required" /></td>
					<td colspan="2">试卷总分：<input type="text" name="exscore" /></td>
				</tr>
				<tr>
					<td>岗位信息：</td>
					<td><select name="gwName" class="combox" class="required">
							<c:forEach var="di" items="${obj.gwinfo}">
								<option value="${di.ID}">${di.gwName}</option>
							</c:forEach>
					</select></td>
					<td>难度系数：</td>
					<td><select name="exndxs" class="combox">
							<option value="1">一般难度</option>
							<option value="2">中间难度</option>
							<option value="3">高难度</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2">填空题数：<input type="text" name="blanksNum"
						class="required" /></td>
					<td colspan="2">判断题数：<input type="text" name="judgesNum"
						class="required" /></td>
				</tr>
				<tr>
					<td colspan="2">单选题数：<input type="text" name="singleOptionNum"
						class="required" /></td>
					<td colspan="2">多选题数：<input type="text" name="doubleOptionNum"
						class="required" /></td>
				</tr>
				<tr>
					<td colspan="2">解答题数：<input type="text" name="jdtNum"
						class="required" /></td>
					<td colspan="2">备注信息：<input type="text" name="remark"
						class="required" /></td>
				</tr>
			</table>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">生成</button>
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
