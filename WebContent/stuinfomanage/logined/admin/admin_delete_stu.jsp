<%@page import="cn.qingmukj.dao.imp.StudentDAOImp"%>
<%@page import="cn.qingmukj.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除学生页面</title>
</head>
<body>
	<%
		StudentDAO studentdao = new StudentDAOImp();
		String uid = request.getParameter("uid");

		if (studentdao.deleteStudent(uid)) {
			out.println("删除成功");
			out.println("即将返回学生信息页面");
			response.setHeader("refresh", "2;URL=admin_select_total_stu.jsp");
		} else {
			out.println("删除失败");
			response.setHeader("refresh", "2;URL=admin_select_total_stu.jsp");
		}
	%>
</body>
</html>