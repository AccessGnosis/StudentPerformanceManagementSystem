<%@page import="cn.qingmukj.domain.PointGenBean"%>
<%@page import="java.util.List"%>
<%@page import="cn.qingmukj.dao.imp.PointDAOImp"%>
<%@page import="cn.qingmukj.dao.PointDAO"%>
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
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center">查询成绩</h3>
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
							<th>学生学号</th>
							<th>学生姓名</th>
							<th>学生成绩</th>
							<th>学期</th>
						</tr>
					</thead>
					<tbody>
						<%
							String sid = request.getParameter("sid");
							PointDAO ClassDAO = new PointDAOImp();
							List<PointGenBean> points = ClassDAO.getSinglePointList(sid);
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
									out.print(points.get(i).getSid());
								%>
							</td>
							<td>
								<%
									out.print(points.get(i).getSname());
								%>
							</td>
							<td>
								<%
									out.print(points.get(i).getSpoint());
								%>
							</td>
							<td>
								<%
									out.print(points.get(i).getSession());
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