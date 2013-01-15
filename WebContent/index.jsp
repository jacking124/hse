<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>欢迎工程技术部培训考核题库管理系统v1.0</title>

<link href="dwz/themes/default/style.css" rel="stylesheet"
	type="text/css" />
<link href="dwz/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="dwz/themes/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<link href="dwz/uploadify/css/uploadify.css" rel="stylesheet"
	type="text/css" />
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="dwz/js/speedup.js" type="text/javascript"></script>
<script src="dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="dwz/xheditor/xheditor-1.1.14-zh-cn.min.js"
	type="text/javascript"></script>
<script src="dwz/uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="dwz/uploadify/scripts/jquery.uploadify.v2.1.0.js"
	type="text/javascript"></script>

<script src="dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="dwz/js/dwz.combox.js" type="text/javascript"></script>

<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		DWZ.init("dwz.frag.xml", {
			loginUrl : "login.jsp",
			loginTitle : "登录", // 弹出登录对话框
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<ul class="nav">
					<li id="switchEnvBox"><a href="javascript:">（<span>北京</span>）切换城市
					</a>
						<ul>
							<li><a href="sidebar_1.html">北京</a></li>
							<li><a href="sidebar_2.html">上海</a></li>
							<li><a href="sidebar_2.html">南京</a></li>
							<li><a href="sidebar_2.html">深圳</a></li>
							<li><a href="sidebar_2.html">广州</a></li>
							<li><a href="sidebar_2.html">天津</a></li>
							<li><a href="sidebar_2.html">杭州</a></li>
						</ul></li>
					<li><a href="changepwd.html" target="dialog" width="600">设置</a></li>
					<!--  
					<li><a href="http://www.cnblogs.com/dwzjs" target="_blank">博客</a></li>
					<li><a href="http://weibo.com/dwzui" target="_blank">微博</a></li>
					<li><a href="http://bbs.dwzjs.com" target="_blank">论坛</a></li>
					-->
					<li><a href="${base}/Account/logout">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->

		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>界面组件
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>用户信息管理</a>
								<ul>
									<%--  
									<li><a href="Product/list" target="navTab" rel="product">产品设置</a></li>
									<li><a href="Salary/list" target="navTab" rel="salary">薪资表</a></li>
									<li><a href="RevenueInfoSet/list" target="navTab" rel="revenueInfoSet">税收信息设置</a></li>
									<li><a href="WageInterface/list" target="navTab" rel="wageInterface">薪资表接口设置</a></li>
									--%>

									<li><a href="Account/list" target="navTab" rel="account">用户信息管理</a></li>


									<li><a href="GradeInfo/list" target="navTab"
										rel="gradeInfo">成绩信息管理</a></li>
								</ul></li>
							<li><a>基础信息管理</a>
								<ul>
									<li><a href="Job/list" target="navTab" rel="JobInfo">岗位信息管理</a></li>
									<li><a href="Department/list" target="navTab"
										rel="department">部门信息管理</a></li>
									<li><a href="Employee/list" target="navTab" rel="employee">员工信息管理</a></li>
									<li><a href="Tsub/list" target="navTab" rel="trainSubject">科目信息管理</a></li>
								</ul></li>
							<li><a>试题信息管理</a>
								<ul>
								
									<li><a href="blanks/list" target="navTab" rel="blanks">填空题信息管理</a></li>
									
									<li><a href="Judge/list" target="navTab" rel="judge">判断题信息管理</a></li>
									<li><a href="Option/list" target="navTab" rel="option">选择题信息管理</a></li>
									<li><a href="Jdt/list" target="navTab" rel="eaxmjdt">解答题信息管理</a></li>
								</ul></li>
							<li><a>试卷信息管理</a>
								<ul>
									<li><a href="ExamMain/list" target="navTab" rel="examMain">试卷信息管理</a></li>
								</ul></li>
					</div>
					<%-- 
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>典型页面
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder treeCheck">
							<li><a href="demo_page1.html" target="navTab"
								rel="demo_page1">查询我的客户</a></li>
							<li><a href="demo_page1.html" target="navTab"
								rel="demo_page2">表单查询页面</a></li>
							<li><a href="demo_page4.html" target="navTab"
								rel="demo_page4">表单录入页面</a></li>
							<li><a href="demo_page5.html" target="navTab"
								rel="demo_page5">有文本输入的表单</a></li>
							<li><a href="javascript:;">有提示的表单输入页面</a>
								<ul>
									<li><a href="javascript:;">页面一</a></li>
									<li><a href="javascript:;">页面二</a></li>
								</ul></li>
							<li><a href="javascript:;">选项卡和图形的页面</a>
								<ul>
									<li><a href="javascript:;">页面一</a></li>
									<li><a href="javascript:;">页面二</a></li>
								</ul></li>
							<li><a href="javascript:;">选项卡和图形切换的页面</a></li>
							<li><a href="javascript:;">左右两个互动的页面</a></li>
							<li><a href="javascript:;">列表输入的页面</a></li>
							<li><a href="javascript:;">双层栏目列表的页面</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>流程演示
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">列表</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">列表</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">列表</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">列表</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page2">列表</a></li>
						</ul>
					</div>
					--%>
				</div>

			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						  
						<div class="accountInfo">
						<!--
							<div class="alertInfo">
								<h2>
									<a href="doc/dwz-user-guide.pdf" target="_blank">DWZ框架使用手册(PDF)</a>
								</h2>
								<a href="doc/dwz-user-guide.swf" target="_blank">DWZ框架演示视频</a>
							</div>
							<div class="right">
								<p>
									<a href="doc/dwz-user-guide.zip" target="_blank"
										style="line-height: 19px">DWZ框架使用手册(CHM)</a>
								</p>
								<p>
									<a href="doc/dwz-ajax-develop.swf" target="_blank"
										style="line-height: 19px">DWZ框架Ajax开发视频教材</a>
								</p>
							</div>
							<p>
								<span>DWZ富客户端框架</span>
							</p>
							<p>
								DWZ官方微博:<a href="http://weibo.com/dwzui" target="_blank">http://weibo.com/dwzui</a>
							</p>
							-->
					</div>
					<div class="pageFormContent" layoutH="80"
						style="margin-right: 230px">
						<h2>常见问题及解决:</h2>
						<pre style="margin: 5px; line-height: 1.4em">
Error loading XML document: dwz.frag.xml
直接用IE打开index.html弹出一个对话框：Error loading XML document: dwz.frag.xml
原因：没有加载成功dwz.frag.xml。IE ajax laod本地文件有限制, 是ie安全级别的问题, 不是框架的问题。
解决方法：用firefox打开或部署到apache下。
</pre>

						<div class="divider"></div>
						<h2>有偿服务请联系:</h2>
						<pre style="margin: 5px; line-height: 1.4em;">

公司培训，技术支持
</pre>
					</div>

					<div style="width: 230px; position: absolute; top: 60px; right: 0"
						layoutH="80"></div>
				</div>

			</div>
		</div>
	</div>

	</div>

	<div id="footer">
		Copyright &copy; 2012 <a href="#" target="dialog">工程技术部</a>
	</div>

</body>
</html>