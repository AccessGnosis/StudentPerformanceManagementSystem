<%@page import="cn.qingmukj.domain.TeachClassBean"%>
<%@page import="java.util.List"%>
<%@page import="cn.qingmukj.dao.imp.ClassDAOImp"%>
<%@page import="cn.qingmukj.dao.ClassDAO"%>
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
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center">查询所带课程</h3>
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-4 column">
						<!-- <form action="admin_select_single_class.jsp" method="post">
							<input type="text" name="str" class="form-control"
								placeholder="请输入课程名查询成绩">
							<button class="btn btn-default btn-block">查询</button>
						</form> -->
					</div>
					<div class="col-md-4 column"></div>
				</div>
				<table class="table table-hover table-condensed table-striped">
					<thead>
						<tr>
							<th>课程号</th>
							<th>课程名</th>
							<th>代课教师</th>
							<th>教室</th>
						</tr>
					</thead>
					<tbody>
						<%
							String sid = request.getParameter("sid");
							ClassDAO ClassDAO = new ClassDAOImp();
							List<TeachClassBean> points = ClassDAO.selectTeachClass(sid);
							for (int i = 0; i < points.size(); ++i) {
						%>
						<tr>
							<td>
								<%
									out.print(points.get(i).getCid());
								%>
							</td>
							<td>
								<%
									out.print(points.get(i).getCname());
								%>
							</td>
							<td>
								<%
									out.print(points.get(i).getTname());
								%>
							</td>
							<td>
								<%
									out.print(points.get(i).getCloc());
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