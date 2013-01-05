<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int i = 0;
%>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="Examination/randomTo" method="post">
		<div class="searchBar">
			<div class="subBar">
				<ul>
					<li><a class="button" href="Examination/queryUi"
						target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div>随机生成的试卷内容如下所示：</div>
	<div>
		<span>一、填空题</span>
		<c:forEach items="${obj.blanks}" var="blank" varStatus="status"
			begin="1">
			<div>
				<b>${status.index}、</b>${blank.content}
			</div>
		</c:forEach>
	</div>
	<div>
		<span>二、判断题</span>
		<c:forEach var="judge" items="${obj.judges}" varStatus="ju" begin="1">
			<div>
				<b>${ju.index}、</b>${judge.content}
			</div>
		</c:forEach>
	</div>
	<div>
		<span>三、单选题</span>
		<c:forEach var="single" items="${obj.single}" varStatus="si" begin="1">
			<div>
				<b>${si.index}、</b>${single.content} <br> <b>A </b><span>${single.aOption}
				</span> <b>B </b><span>${single.bOption} </span> <b>C </b><span>${single.cOption}
				</span> <b>D </b><span>${single.dOption} </span>
			</div>
		</c:forEach>
	</div>
	<div>
		<span>三、多项选题</span>
		<c:forEach var="double" items="${obj.doubleOption}" varStatus="du"
			begin="1">
			<div>
				<b>${du.index}、</b>${double.content} <br> <b>A </b><span>${double.aOption}
				</span> <b>B </b><span>${double.bOption} </span> <b>C </b><span>${double.cOption}
				</span> <b>D </b><span>${double.dOption} </span>
			</div>
		</c:forEach>
	</div>
	<div>
		<span>四、解答题</span>
		<c:forEach var="jdt" items="${obj.examJdt}" varStatus="jd" begin="1">
			<div>
				<b>${jd.index}、</b>${jdt.content} <br> <br> <br>

			</div>
		</c:forEach>
	</div>
</div>
