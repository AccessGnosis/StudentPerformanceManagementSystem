<%@page import="cn.qingmukj.domain.StudentBean"%>
<%@page import="java.util.List"%>
<%@page import="cn.qingmukj.dao.imp.StudentDAOImp"%>
<%@page import="cn.qingmukj.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看学生信息 —— 欢迎来到学生信息管理系统 —— 管理员登录</title>
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
				<h3 class="text-center">查询学生信息</h3>
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-4 column">
						<form action="admin_select_single_stu.jsp" method="post">
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
							<th>学号</th>
							<th>班级</th>
							<th>姓名</th>
							<th>民族</th>
							<th>性别</th>
							<th>生日</th>
							<th>政治面貌</th>
							<th>户口类型</th>
							<th>身份证号</th>
							<th>联系方式</th>
							<th>户籍所在地</th>
							<th>家长姓名1</th>
							<th>家长姓名1电话</th>
							<th>家长姓名2</th>
							<th>家长姓名2电话</th>
							<th>宿舍</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
						<%
							String str = request.getParameter("str");
							StudentDAO studentdao = new StudentDAOImp();
							List<StudentBean> students = studentdao.getStudentInfo(str);
						%>
						<%
							for (int i = 0; i < students.size(); ++i) {
						%>
						<tr>
							<td>
								<button class="btn btn-default btn-block"
									onClick="window.location='admin_edit_stu.jsp?uid=<%out.print(students.get(i).getUid());%>'">修改</button>
								<button class="btn btn-default btn-block"
									onclick="javascript:if(confirm('确实要删除学生<%out.print(students.get(i).getSname());%>吗?'))location='admin_delete_stu.jsp?uid=<%out.print(students.get(i).getUid());%>'">删除</button>
							</td>
							<td>
								<%
									out.print(students.get(i).getSid());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSclass());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSname());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSnation());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSgender());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSbirth());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSpolitics());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSpermanent());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSidnum());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getStele());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSloc());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSparent1());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSparent1tele());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSparent2());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSparent2tele());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSdorm());
								%>
							</td>
							<td>
								<%
									out.print(students.get(i).getSremark());
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