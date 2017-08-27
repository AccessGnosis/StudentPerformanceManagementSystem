<%@page import="cn.qingmukj.domain.TeacherBean"%>
<%@page import="cn.qingmukj.dao.imp.TeacherDAOImp"%>
<%@page import="cn.qingmukj.dao.TeacherDAO"%>
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
<title>欢迎来到学生信息管理系统 —— 教师登录</title>
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
		TeacherDAO studentdao = new TeacherDAOImp();
		TeacherBean teacher = studentdao.getTeacher(username);
	%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center">
					<%=teacher.getTname()%>&nbsp;&nbsp;欢迎来到学生信息管理系统
				</h3>
			</div>
		</div>
		<br> <br>
		<div class="row clearfix">
			<div class="col-md-1 column"></div>
			<div class="col-md-3 column">
				<!-- 
				<button type="button" class="btn btn-default btn-block"
					onclick="location='tech_insert_grade_point.jsp'">录入学生成绩</button>
					 -->
				<br>
				<button type="button" class="btn btn-default btn-block"
					onclick="location='tech_select_class.jsp?sid=<%=teacher.getTid()%>'">查看课程</button>
			</div>
			<div class="col-md-8 column">
				<form action="TechUpdateTeacher" method="post">
					<div class="col-md-6 column">
						<label>工号</label> <input type="text" class="form-control"
							value="<%out.print(teacher.getTid());%>" name="tid"
							readonly="readonly"> <br> <label>教师姓名</label> <input
							type="text" class="form-control"
							value="<%out.print(teacher.getTname());%>" name="tname">
						<br> <label>学历</label> <input type="text"
							class="form-control" value="<%out.print(teacher.getTedubag());%>"
							name="tedubag"> <br> <label>职称</label> <input
							type="text" class="form-control"
							value="<%out.print(teacher.getTlevel());%>" name="slevel">
						<br> <label>所属学院</label> <input type="text"
							class="form-control" value="<%out.print(teacher.getTdepart());%>"
							name="tdepart"> <br>
						<button class="btn btn-default btn-block">
							修改
							<%
							out.print(teacher.getTname());
						%>
							的信息
						</button>
						<br> <br>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>