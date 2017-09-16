<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增教师 —— 欢迎来到学生信息管理系统 —— 管理员登录</title>
<link rel="stylesheet" href="../dist/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="../dist/css/bootstrap-theme.min.css"
	type="text/css">
<script src="../dist/js/jquery-3.1.1.min.js"></script>
<script src="../dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center">新增教师</h3>
				<div class="row clearfix">
					<div class="col-md-3 column"></div>
					<form action="InsertTeacherServlet" method="post">
						<div class="col-md-6 column">
							<label>工号</label> <input type="text" class="form-control"
								name="tid"> <br> <label>教师姓名</label> <input
								type="text" class="form-control" name="tname"> <br>
							<label>学历</label> <input type="text" class="form-control"
								name="tedubag"> <br> <label>职称</label> <input
								type="text" class="form-control" name="slevel"> <br>
							<label>所属学院</label> <input type="text" class="form-control"
								name="tdepart"> <br>
							<button class="btn btn-default btn-block">新增教师</button>
							<br>
						</div>
					</form>
					<div class="col-md-3 column"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>