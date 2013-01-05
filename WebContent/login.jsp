<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用工程技术部培训课程及考核题库管理系统</title>
<link href="${base}/dwz/themes/css/login.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${base}/dwz/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#login_form").submit(function() {
			$.ajax({
				url : "${base}/Account/login",
				data : $("#login_form").serialize(),
				success : function(res) {
					if (res == "true") {
						window.location.href = "index.jsp";
					} else {
						alert("登陆失败!!");
					}
					return false;
				},
				fail : function(res) {
					alert("系统错误?!");
				}
			});
			return false;
		});
	});
</script>
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<img src="${base}/dwz/themes/default/images/login_logo.gif" />
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href="#">反馈</a></li>
					</ul>
				</div>
				<h2 class="login_title">
					<img src="${base}/dwz/themes/default/images/login_title.png" />
				</h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form action="" id="login_form" method="post">
					<p>
						<label>用户名：</label> <input type="text" name="name" size="20"
							class="login_input" />
					</p>
					<p>
						<label>密&nbsp;&nbsp;&nbsp;码：</label> <input type="password"
							name="passwd" size="20" class="login_input" />
					</p>
					<!--  
					<p>
						<label>验证码：</label>
						<input class="code" type="text" size="5" />
						<span><img src="dwz/themes/default/images/header_bg.png" alt="" width="75" height="24" /></span>
					</p>
					-->
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner">
				<img src="${base}/dwz/themes/default/images/login_banner.jpg" />
			</div>
			<div class="login_main">
				<!-- 
				<ul class="helpList">
					<li><a href="#">下载驱动程序</a></li>
					<li><a href="#">如何安装密钥驱动程序？</a></li>
					<li><a href="#">忘记密码怎么办？</a></li>
					<li><a href="#">为什么登录失败？</a></li>
				</ul>
			 
				<div class="login_inner">
					<p>您可以使用 网易网盘 ，随时存，随地取</p>
					<p>您还可以使用 闪电邮 在桌面随时提醒邮件到达，快速收发邮件。</p>
					<p>在 百宝箱 里您可以查星座，订机票，看小说，学做菜…</p>
				</div>
				-->
			</div>
		</div>
		<div id="login_footer">Copyright &copy; 2012 工程技术部信息中心 Inc. All
			Rights Reserved.</div>
	</div>
</body>
</html>