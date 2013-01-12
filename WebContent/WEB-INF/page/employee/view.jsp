<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h2 class="contentTitle">用戶信查看页面</h2>
<div class="pageContent">

	<div class="viewInfo" layoutH="97">
		<div class="divider"></div>
		<table border="1" width="100%" bordercolor="black"
			style="border-collapse: collapse; padding: 5px;">
			<tr>
				<td width="14%">姓名</td>
				<td width="14%">${obj.eName}</td>
				<td width="14%">性别</td>
				<td width="14%">${obj.gender }</td>
				<td width="14%">出生日期</td>
				<td width="14%">${obj.birthday}</td>
				<td width="14%" rowspan="4"><img alt="照片信息" src="${obj.picturePath }"> </td>
			</tr>
			<tr>
				<td>民族</td>
				<td>${obj.nation}</td>
				<td>年龄</td>
				<td>${obj.eAge }</td>
				<td>毕业日期</td>
				<td><fmt:formatDate value="${obj.graduationTime }"
						pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>文化程度</td>
				<td>${obj.education }</td>
				<td>专业</td>
				<td>${obj.professional }</td>
				<td>工作时间</td>
				<td>${obj.workingDate }</td>
			</tr>
			<tr>
				<td>职称</td>
				<td>${obj.zcInfo }</td>
				<td>技能等级</td>
				<td>${obj.skillLevel }</td>
				<td>资格认证</td>
				<td>${obj.post_zg }</td>
			</tr>
			<tr>
				<td>工作单位</td>
				<td colspan="6">${obj.company }</td>
			</tr>
			<tr>
				<td height="18">部门</td>
				<td colspan="2">${obj.dName}</td>
				<td>岗位</td>
				<td colspan="3">${obj.gwName }</td>
			</tr>
			<tr>
				<td height="18">任职时间</td>
				<td colspan="2">${obj.rzTime }</td>
				<td>电话号码</td>
				<td colspan="3">${obj.telphone }</td>
			</tr>
			<tr>
				<td>备注信息</td>
				<td colspan="6">${obj.remark}</td>
			</tr>
		</table>

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
