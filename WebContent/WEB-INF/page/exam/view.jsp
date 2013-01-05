<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<div>随机生成的试卷内容如下所示：</div>
	<div>
		<span>一、填空题</span>
		<c:forEach items="${obj.blanks}" var="blank">
			<div>
				<b>1、</b>${blank.content}
			</div>
		</c:forEach>
	</div>
	<div><span>二、判断题</span></div>
</div>
