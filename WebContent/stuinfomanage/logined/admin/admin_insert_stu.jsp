<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增学生 —— 欢迎来到学生信息管理系统 —— 管理员登录</title>
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
				<h3 class="text-center">新增学生</h3>
				<div class="row clearfix">
					<div class="col-md-3 column"></div>
					<form action="InsertStudentServlet" method="post">
						<div class="col-md-6 column">
							<label>学号</label> <input type="text" class="form-control"
								name="sid"> <br> <label>班级</label> <input
								type="text" class="form-control" name="sclass"> <br>
							<label>姓名</label> <input type="text" class="form-control"
								name="sname"> <br> <label>民族</label> <input
								type="text" class="form-control" name="snation"> <br>
							<label>性别</label> <input type="text" class="form-control"
								name="sgender"> <br> <label>生日</label> <input
								type="text" class="form-control" name="sbirth"> <br>
							<label>政治面貌</label> <input type="text" class="form-control"
								name="spolitics"> <br> <label>户口类型</label> <input
								type="text" class="form-control" name="spermanent"> <br>
							<label>身份证号</label> <input type="text" class="form-control"
								name="sidnum"> <br> <label>联系方式</label> <input
								type="text" class="form-control" name="stele"> <br>
							<label>户籍所在地</label> <input type="text" class="form-control"
								name="sloc"> <br> <label>家长1姓名</label> <input
								type="text" class="form-control" name="sparent1"> <br>
							<label>家长1联系方式</label> <input type="text" class="form-control"
								name="sparent1tele"> <br> <label>家长2姓名</label> <input
								type="text" class="form-control" name="sparent2"> <br>
							<label>家长2联系方式</label> <input type="text" class="form-control"
								name="sparent2tele"> <br> <label>现住宿舍</label> <input
								type="text" class="form-control" name="sdorm"> <br>
							<label>备注</label> <input type="text" class="form-control"
								name="sremark"> <br>
							<button class="btn btn-default btn-block">新增学生</button>
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