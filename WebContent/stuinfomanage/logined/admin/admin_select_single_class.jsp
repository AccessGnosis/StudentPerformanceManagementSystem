<%@page import="cn.qingmukj.domain.ClassBean"%>
<%@page import="java.util.List"%>
<%@page import="cn.qingmukj.dao.imp.ClassDAOImp"%>
<%@page import="cn.qingmukj.dao.ClassDAO"%>
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
				<h3 class="text-center">查询课程信息</h3>
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-4 column">
						<form action="admin_select_single_class.jsp" method="post">
							<input type="text" name="str" class="form-control"
								placeholder="请输入课程号或课程名查询">
							<button class="btn btn-default btn-block">查询</button>
						</form>
					</div>
					<div class="col-md-4 column"></div>
				</div>
				<table class="table table-hover table-condensed table-striped">
					<thead>
						<tr>
							<th>操作</th>
							<th>课程ID</th>
							<th>课名</th>
							<th>课时</th>
							<th>教室</th>
							<th>课程类型</th>
							<th>学分</th>
							<th>课程描述</th>
						</tr>
					</thead>
					<tbody>
						<%
							String str = request.getParameter("str");
							ClassDAO ClassDAO = new ClassDAOImp();
							List<ClassBean> classes = ClassDAO.getLikedClass(str);
							for (int i = 0; i < classes.size(); ++i) {
						%>
						<tr>
							<td>
								<button class="btn btn-default btn-block"
									onClick="window.location='admin_edit_class.jsp?uid=<%out.print(classes.get(i).getCid());%>'">修改</button>
								<button class="btn btn-default btn-block"
									onclick="javascript:if(confirm('确实要删除课程<%out.print(classes.get(i).getCname());%>吗?'))location='admin_delete_class.jsp?uid=<%out.print(classes.get(i).getCid());%>'">删除</button>
							</td>
							<td>
								<%
									out.print(classes.get(i).getCid());
								%>
							</td>
							<td>
								<%
									out.print(classes.get(i).getCname());
								%>
							</td>
							<td>
								<%
									out.print(classes.get(i).getCtimelength());
								%>
							</td>
							<td>
								<%
									out.print(classes.get(i).getCloc());
								%>
							</td>
							<td>
								<%
									out.print(classes.get(i).getCtype());
								%>
							</td>
							<td>
								<%
									out.print(classes.get(i).getCpoint());
								%>
							</td>
							<td>
								<%
									out.print(classes.get(i).getCdesc());
									}
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>