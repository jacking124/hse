<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">用戶信查看页面</h2>
<div class="pageContent">
	<div class="viewInfo" layoutH="97">


		<fieldset>
			<legend>选择题详细信息</legend>
			<p>
				<label>题目内容：</label> ${obj.content}
			</p>
			<dl>
				<dt>类型：</dt>
				<dd>${obj.type==0?'单选题':'多选题' }</dd>
			</dl>
			<dl>
				<dt>选项A：</dt>
				<dd>${obj.aOption}</dd>
			</dl>
			<dl>
				<dt>选项B：</dt>
				<dd>${obj.bOption}</dd>
			</dl>
			<dl>
				<dt>选项C：</dt>
				<dd>${obj.cOption}</dd>
			</dl>
			<dl>
				<dt>选项D：</dt>
				<dd>${obj.dOption}</dd>
			</dl>
			<dl>
				<dt>岗位：</dt>
				<dd>${obj.gwInfo}</dd>
			</dl>
			<dl>
				<dt>难度系数：</dt>
				<dd>${obj.ndxs}</dd>
			</dl>
			<dl>
				<dt>状态：</dt>
				<dd>${obj.status}</dd>
			</dl>
			<p>
				<label>正确答案：</label>${obj.answer }
			</p>
			<p>
				<label>备 注:</label>${obj.remark}
			</p>
			<div class="divider"></div>
		</fieldset>
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
