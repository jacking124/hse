<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">用戶信查看页面</h2>
<div class="pageContent">

	<div class="viewInfo" layoutH="97">
		<dl>
			<dt>名称：</dt>
			<dd>${obj.userName}</dd>
		</dl>
		<dl>
			<dt>账套状态：</dt>
			<dd>${obj.status}</dd>
		</dl>
		<dl>
			<dt>描述：</dt>
			<dd>${obj.description}</dd>
		</dl>
		<dl>
			<dt>组织机构：</dt>
			<dd>${obj.organization}</dd>
		</dl>
		<dl>
			<dt>创建人：</dt>
			<dd>${obj.createUser}</dd>
		</dl>
		<dl>
			<dt>创建时间：</dt>
			<dd>${obj.createDate}</dd>
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
