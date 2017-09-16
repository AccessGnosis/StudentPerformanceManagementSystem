<%@page import="cn.qingmukj.domain.TeacherBean"%>
<%@page import="java.util.List"%>
<%@page import="cn.qingmukj.dao.imp.TeacherDAOImp"%>
<%@page import="cn.qingmukj.dao.TeacherDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询教师信息 —— 欢迎来到学生信息管理系统 —— 管理员登录</title>
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
				<h3 class="text-center">查询教师信息</h3>
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-4 column">
						<form action="admin_select_single_tech.jsp" method="post">
							<input type="text" name="str" class="form-control"
								placeholder="请输入学号或姓名查询">
							<button class="btn btn-default btn-block">查询</button>
						</form>
					</div>
					<div class="col-md-4 column"></div>
				</div>
				<table class="table table-hover table-condensed table-striped">
					<thead>
						<tr>
							<th>操作</th>
							<th>工号</th>
							<th>教师姓名</th>
							<th>学历</th>
							<th>职称</th>
							<th>所属学院</th>
						</tr>
					</thead>
					<tbody>
						<%
							String str = request.getParameter("str");
							TeacherDAO TeacherDAO = new TeacherDAOImp();
							List<TeacherBean> teachers = TeacherDAO.getTeacherInfo(str);
						%>
						<%
							for (int i = 0; i < teachers.size(); ++i) {
						%>
						<tr>
							<td>
								<button class="btn btn-default btn-block"
									onClick="window.location='admin_edit_tech.jsp?uid=<%out.print(teachers.get(i).getUid());%>'">修改</button>
								<button class="btn btn-default btn-block"
									onclick="javascript:if(confirm('确实要删除教师<%out.print(teachers.get(i).getTname());%>吗?'))location='admin_delete_teacher.jsp?uid=<%out.print(teachers.get(i).getUid());%>'">删除</button>
							</td>
							<td>
								<%
									out.print(teachers.get(i).getTid());
								%>
							</td>
							<td>
								<%
									out.print(teachers.get(i).getTname());
								%>
							</td>
							<td>
								<%
									out.print(teachers.get(i).getTedubag());
								%>
							</td>
							<td>
								<%
									out.print(teachers.get(i).getTlevel());
								%>
							</td>
							<td>
								<%
									out.print(teachers.get(i).getTdepart());
								%>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>