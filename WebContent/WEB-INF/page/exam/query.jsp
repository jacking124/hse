<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="Examination/randomTo" class="pageForm"
			onsubmit="return navTabSearch(this, 'exam');">
			<div class="pageFormContent" layoutH="58">
				<div class="divDeider"></div>
				<table class="searchContent">
					<tr>
						<td>岗位名称:</td>
						<td><select name="gwName" class="combox" class="required">
								<c:forEach var="di" items="${obj.gwinfo}">
									<option value="${di.ID}">${di.gwName}</option>
								</c:forEach>
						</select></td>
						<td>难度系数:</td>
						<td><select name="ndxs" class="combox">
								<option value="1">一般难度</option>
								<option value="2">中间难度</option>
								<option value="3">高难度</option>
						</select></td>
					</tr>
					<tr>
						<td>填空题数目:</td>
						<td><input type="text" name="blanksNum" class="digits" /></td>
						<td>判断题数目:</td>
						<td><input type="text" name="judgesNum" class="digits" /></td>
					</tr>
					<tr>
						<td>单选题数目:</td>
						<td><input type="text" name="singleOptionNum" class="digits" /></td>
						<td>多选题数目:</td>
						<td><input type="text" name="doubleOptionNum" class="digits" /></td>
					</tr>
					<tr>
						<td>解答题数目:</td>
						<td char="3"><input type="text" name="jdtNum" class="digits" /></td>
					</tr>
				</table>
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