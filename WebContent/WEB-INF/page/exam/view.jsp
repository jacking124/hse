<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷展示页面</title>
<style type="text/css">
<!--
#title {
	text-align: center;
	margin: 0 auto;
	line-height: 180%;
}
-->
</style>
</head>

<body>
	<div class="pageContent">
		<div id="title">
			<h1>${obj.main.exName}</h1>
			<div>
				<span>姓名：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>分数:${obj.main.exScore}</span>
			</div>
		</div>
		<c:if test="${obj.judgeInfo ne null}">
			<div id="jude">
				<h2>一、判断题</h2>
				<c:forEach items="${obj.judgeInfo}" var="jude" step="1"
					varStatus="j">
					<p>
						<strong>${j.index+1}、</strong><span>${jude.pContent}</span>
					</p>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${obj.singles ne null }">
			<div id="options">
				<h2>二、选择题</h2>
				<table>
					<c:forEach items="${obj.singles}" var="op" step="1" varStatus="o">
						<tr>
							<td colspan="4"><strong>${o.index+1} 、</strong>${op.pContent}</td>
						</tr>
						<tr>
							<td>A:${op.aOption}</td>
							<td>B:${op.bOption}</td>
							<td>C:${op.cOption}</td>
							<td>D:${op.dOption}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<c:if test="${obj.jdtInfo ne null }">
			<div id="options">
				<h2>三、解答题</h2>
				<c:forEach items="${obj.jdtInfo}" var="jdt" step="1" varStatus="j">
					<p>
						<strong>${j.index+1}、</strong><span>${jdt.pContent}</span>
					</p>
				</c:forEach>
			</div>
		</c:if>
	</div>
</body>
</html>