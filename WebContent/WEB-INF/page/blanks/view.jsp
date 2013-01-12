<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">用戶信查看页面</h2>
<div class="pageContent">
	<div class="viewInfo" layoutH="97">
		<dl>
			<dt>题目内容：</dt>
			<dd>${obj.pContent}</dd>
		</dl>

		<dl>
			<dt>岗位：</dt>
			<dd>${obj.gwName}</dd>
		</dl>
		<dl>
			<dt>难度系数：</dt>
			<dd>${obj.ndxs}</dd>
		</dl>
		<dl>
			<dt>正确答案：</dt>
			<dd>${obj.answer}</dd>
		</dl>
		<dl>
			<dt>备注：</dt>
			<dd>${obj.remark}</dd>
		</dl>
		<dl>
			<dt>状态：</dt>
			<dd>${obj.status}</dd>
		</dl>
		<div class="divider"></div>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="button">
					<div class="buttonContent">
						<button type="button" class="close">关闭</button>
					</div>
				</div></li>
		</ul>
	</div>
</div>
