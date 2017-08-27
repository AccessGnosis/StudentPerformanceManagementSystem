<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询课程信息 —— 欢迎来到学生信息管理系统 —— 管理员登录</title>
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
				<h3 class="text-center">课程信息新增</h3>
				<div class="row clearfix">
					<div class="col-md-3 column"></div>
					<form action="AdminInsertClass" method="post">
						<div class="col-md-6 column">
							<label>课程ID</label> <input type="text" class="form-control"
								name="cid"> <br> <label>课程名</label> <input
								type="text" class="form-control" name="cname"> <br>
							<label>课时</label> <input type="text" class="form-control"
								name="ctimelength"> <br> <label>教室</label> <input
								type="text" class="form-control" name="cloc"> <br>
							<label>课程类型</label> <input type="text" class="form-control"
								name="ctype"> <br> <label>学分</label> <input
								type="text" class="form-control" name="cpoint"> <br>
							<label>课程描述</label> <input type="text" class="form-control"
								name="cdesc"> <br>
							<button class="btn btn-default btn-block">新增课程信息</button>
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