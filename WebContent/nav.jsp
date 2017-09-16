<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/index.jsp">青木科技</a>
	</div>

	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="/comfix/index.jsp">维修服务</a></li>
			<li><a href="/stuinfomanage/index.jsp">学生信息管理系统</a></li>
			<li><a href="/biaobai/index.jsp">表白墙</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">其他服务 <strong class="caret"></strong></a>
				<ul class="dropdown-menu">
					<li><a href="/stuforum/index.jsp">学生论坛</a></li>
					<li><a href="#">预留服务B</a></li>
					<li><a href="#">预留服务C</a></li>
					<li class="divider"></li>
					<li><a href="#">预留服务D</a></li>
					<li class="divider"></li>
					<li><a href="/stuforum/user/login">管理员登录</a></li>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/stuforum/user/login">登录</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">注册<strong class="caret"></strong></a>
				<ul class="dropdown-menu">
					<li><a href="/stuforum/user/add">用户注册</a></li>
					<li class="divider"></li>
					<li><a href="/stuforum/user/add">管理员注册</a></li>
				</ul></li>
		</ul>
	</div>

</nav>