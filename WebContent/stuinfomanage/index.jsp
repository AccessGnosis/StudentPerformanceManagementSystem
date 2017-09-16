<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生基本信息管理系统 - 青木科技</title>
<link rel="stylesheet" href="../dist/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="../dist/css/bootstrap-theme.min.css"
	type="text/css">
<link rel="stylesheet" href="css/index.css" type="text/css">
<script src="../dist/js/jquery-3.1.1.min.js"></script>
<script src="../dist/js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
</head>
<body>
	<%@ include file="../nav.jsp"%>
	<div style="margin-bottom: 120px"></div>
	<div class="row clearfix" style="margin-top: 70px">
		<div class="col-md-12 column">
			<h3 class="nofollow text-center text-info">登录</h3>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-3 column"></div>
		<div class="col-md-6 column">
			<form role="form" class="nofollow" action="UserLoginServlet"
				method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">用户名：</label><input
						class="form-control" id="exampleInputEmail1" placeholder="请输入用户名"
						name="username" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">密码：</label><input
						class="form-control" id="exampleInputPassword1" type="password"
						name="password" placeholder="请输入密码" />
				</div>
				<div class="form-group" id="optionbtn">
					<input type="radio" class="" value="stu" name="judge"
						checked="checked" /> <span>学生</span> <input type="radio" class=""
						value="mgr" name="judge" /> <span>老师</span> <input type="radio"
						class="" value="admin" name="judge" /> <span>管理员</span>
				</div>
				<br>
				<button type="submit" class="btn btn-block btn-info">提交</button>
			</form>
		</div>
		<div class="col-md-3 column"></div>
	</div>

	<div style="margin-bottom: 120px"></div>
	<%@ include file="../footer.jsp"%>
</body>
</html>