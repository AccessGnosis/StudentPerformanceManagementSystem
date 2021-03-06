<%@page import="cn.qingmukj.domain.StudentBean"%>
<%@page import="cn.qingmukj.dao.imp.StudentDAOImp"%>
<%@page import="cn.qingmukj.dao.StudentDAO"%>
<%@page import="cn.qingmukj.domain.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到学生信息管理系统 —— 学生登录</title>
<link rel="stylesheet" href="../dist/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="../dist/css/bootstrap-theme.min.css"
	type="text/css">
<script src="../dist/js/jquery-3.1.1.min.js"></script>
<script src="../dist/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		UserBean user = (UserBean) session.getAttribute("user");
		String username = user.getUid();
		StudentDAO studentdao = new StudentDAOImp();
		StudentBean student = studentdao.getStudent(username);
	%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center">
					<%=student.getSname()%>&nbsp;&nbsp;欢迎来到学生信息管理系统
				</h3>
			</div>
		</div>
		<br> <br>
		<div class="row clearfix">
			<div class="col-md-1 column"></div>
			<div class="col-md-3 column">
				<button type="button" class="btn btn-default btn-block"
					onclick="location='stu_select_grade_point.jsp?sid=<%=student.getSid()%>'">查看课程和成绩</button>
			</div>
			<div class="col-md-8 column">
				<form action="StuUpdateStudent" method="post">
					<div class="col-md-6 column">
						<label>学号</label> <input type="text" class="form-control"
							value="<%out.print(student.getSid());%>" name="sid" readonly="readonly"> <br>
						<label>班级</label> <input type="text" class="form-control"
							value="<%out.print(student.getSclass());%>" name="sclass" readonly="readonly">
						<br> <label>姓名</label> <input type="text"
							class="form-control" value="<%out.print(student.getSname());%>"
							name="sname"> <br> <label>民族</label> <input
							type="text" class="form-control"
							value="<%out.print(student.getSnation());%>" name="snation">
						<br> <label>性别</label> <input type="text"
							class="form-control" value="<%out.print(student.getSgender());%>"
							name="sgender"> <br> <label>生日</label> <input
							type="text" class="form-control"
							value="<%out.print(student.getSbirth());%>" name="sbirth">
						<br> <label>政治面貌</label> <input type="text"
							class="form-control"
							value="<%out.print(student.getSpolitics());%>" name="spolitics">
						<br> <label>户口类型</label> <input type="text"
							class="form-control"
							value="<%out.print(student.getSpermanent());%>" name="spermanent">
						<br> <label>身份证号</label> <input type="text"
							class="form-control" value="<%out.print(student.getSidnum());%>"
							name="sidnum"> <br> <label>联系方式</label> <input
							type="text" class="form-control"
							value="<%out.print(student.getStele());%>" name="stele">
						<br> <label>户籍所在地</label> <input type="text"
							class="form-control" value="<%out.print(student.getSloc());%>"
							name="sloc"> <br> <label>家长1姓名</label> <input
							type="text" class="form-control"
							value="<%out.print(student.getSparent1());%>" name="sparent1">
						<br> <label>家长1联系方式</label> <input type="text"
							class="form-control"
							value="<%out.print(student.getSparent1tele());%>"
							name="sparent1tele"> <br> <label>家长2姓名</label> <input
							type="text" class="form-control"
							value="<%out.print(student.getSparent2());%>" name="sparent2">
						<br> <label>家长2联系方式</label> <input type="text"
							class="form-control"
							value="<%out.print(student.getSparent2tele());%>"
							name="sparent2tele"> <br> <label>现住宿舍</label> <input
							type="text" class="form-control"
							value="<%out.print(student.getSdorm());%>" name="sdorm">
						<br> <label>备注</label> <input type="text"
							class="form-control" value="<%out.print(student.getSremark());%>"
							name="sremark"> <br>
						<button class="btn btn-default btn-block">
							修改
							<%
							out.print(student.getSname());
						%>
							的信息
						</button>
						<br>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>