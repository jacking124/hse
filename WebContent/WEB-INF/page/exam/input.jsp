<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageHeader">
	<form action="Examination/randomTo" method="post"
		onsubmit="return navTabSearch(this)">
		<input type="hidden" name="resourceStatus"
			value="${param.resourceStatus}" /> <input type="hidden"
			name="pageNum" value="1" /> 
		<div class="searchBar">
			<div class="searchContent">
				<fieldset>
					<legend>试卷生成选项</legend>
					<dl class="nowrap">
						<dt>试卷名称：</dt>
						<dd>
							<input type="text" name="title" class="required" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>岗位信息：</dt>
						<dd>
							<select name="gwName" class="combox" class="required">
								<c:forEach var="di" items="${obj.gwinfo}">
									<option value="${di.ID}">${di.gwName}</option>
								</c:forEach>
							</select>
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>难度系数：</dt>
						<dd>
							<select name="ndxs" class="combox">
								<option value="1">一般难度</option>
								<option value="2">中间难度</option>
								<option value="3">高难度</option>
							</select>
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>填空题数目：</dt>
						<dd>
							<input type="text" name="blanksNum" class="required" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>判断题数目：</dt>
						<dd>
							<input type="text" name="judgesNum" class="required" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>单选题数目：</dt>
						<dd>
							<input type="text" name="singleOptionNum" class="required" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>多选题数目：</dt>
						<dd>
							<input type="text" name="doubleOptionNum" class="required" />
						</dd>
					</dl>
					<dl class="nowrap">
						<dt>解答题数目：</dt>
						<dd>
							<input type="text" name="jdtNum" class="required" />
						</dd>
					</dl>
				</fieldset>
			</div>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</form>
</div>

<div class="pageContent">


</div>
