<%@page import="cn.qingmukj.domain.UserBean"%>
<%@page import="cn.qingmukj.domain.SettingBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cn.qingmukj.dao.imp.SettingDAOImp"%>
<%@page import="cn.qingmukj.dao.SettingDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到学生信息管理系统 —— 管理员登录</title>
<link rel="stylesheet" href="../dist/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="../dist/css/bootstrap-theme.min.css"
	type="text/css">
<script src="../dist/js/jquery-3.1.1.min.js"></script>
<script src="../dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	/* 	function switchTab(tabpage, tabid) {
	 var oItem = document.getElementById(tabpage);
	 for (var i = 0; i < oItem.children.length; i++) {
	 var x = oItem.children(i);
	 x.className = "";
	 var y = x.getElementsByTagName('a');
	 y[0].style.color = "#333333";
	 }
	 document.getElementById(tabid).className = "Selected";
	 } */
	/* function judgeNull(){
		var inputNodes = document.getElementById("settingForm").getElementsByTagName("input");
		for(var i = 0; i < inputNodes.length; ++i){
			if(inputNodes[i].value == ""){
				alert("请将所有的值填入框中");
				break;
			}
		}
	} */
</script>
</head>
<body>
	<%
		SettingDAO settingdao = new SettingDAOImp();
		List<SettingBean> settings = new ArrayList<SettingBean>();
		settings = settingdao.getSettingInfo();
		UserBean user = (UserBean) session.getAttribute("user");
		String username = user.getUid();
	%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-center"><%=username%>&nbsp;&nbsp;欢迎来到学生信息管理系统
				</h3>
				<div class="tabbable" id="tabs-737661">
					<ul class="nav nav-tabs">
						<li><a href="#panel-1" data-toggle="tab">参数设置</a></li>
						<li><a href="#panel-2" data-toggle="tab">学生管理</a></li>
						<li><a href="#panel-3" data-toggle="tab">教师管理</a></li>
						<li><a href="#panel-4" data-toggle="tab">课程管理</a></li>
						<li><a href="#panel-5" data-toggle="tab">成绩管理</a></li>
						<li><a href="#panel-6" data-toggle="tab">修改信息</a></li>
						<li><a href="#panel-7" data-toggle="tab"
							onclick="location='Logout'">退&nbsp;&nbsp;出</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane" id="panel-1">
							<div class="row clearfix">
								<div class="col-md-2 column"></div>
								<div class="col-md-8 column">
									<br>
									<form id="settingForm" action="ParameterSetting" method="post">
										<label>请输入国家奖学金名额</label> <input type="text"
											name="NationalScholarship" class="form-control"
											placeholder="<%out.print(settings.get(0).getSetvalue());%>">
										<br> <label>请输入国家励志奖学金名额</label> <input type="text"
											name="NationalEncouragementScholarship" class="form-control"
											placeholder="<%out.print(settings.get(1).getSetvalue());%>">
										<br> <label>请输入校级一等奖学金名额</label> <input type="text"
											name="SchoolFirstScholarship" class="form-control"
											placeholder="<%out.print(settings.get(2).getSetvalue());%>">
										<br> <label>请输入校级二等奖学金名额</label> <input type="text"
											name="SchoolSecondScholarship" class="form-control"
											placeholder="<%out.print(settings.get(3).getSetvalue());%>">
										<br> <label>请输入校级三等奖学金名额</label> <input type="text"
											name="SchoolThirdScholarship" class="form-control"
											placeholder="<%out.print(settings.get(4).getSetvalue());%>">
										<br> <label>请输入国家特殊贫困名额</label> <input type="text"
											name="NationalSpecialPoverty" class="form-control"
											placeholder="<%out.print(settings.get(5).getSetvalue());%>">
										<br> <label>请输入国家一般贫困名额</label> <input type="text"
											name="NationalNormalPoverty" class="form-control"
											placeholder="<%out.print(settings.get(6).getSetvalue());%>">
										<br> <input type="submit"
											class="btn btn-default btn-block" onclick="judgeNull()">
										<br>
									</form>
								</div>
								<div class="col-md-2 column"></div>
							</div>
						</div>

						<div class="tab-pane" id="panel-2">
							<br>
							<div class="row clearfix">
								<div class="col-md-3 column"></div>
								<div class="col-md-2 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_select_total_stu.jsp'">查看所有学生信息</button>
								</div>
								<div class="col-md-2 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_select_single_stu.jsp'">查询学生</button>
								</div>
								<div class="col-md-2 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_insert_stu.jsp'">新增学生</button>
								</div>
								<div class="col-md-3 column"></div>
							</div>
						</div>

						<div class="tab-pane" id="panel-3">
							<br>
							<div class="row clearfix">
								<div class="col-md-3 column"></div>
								<div class="col-md-2 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_select_total_tech.jsp'">查看所有教师信息</button>
								</div>
								<div class="col-md-2 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_select_single_tech.jsp'">查询教师</button>
								</div>
								<div class="col-md-2 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_insert_tech.jsp'">新增教师</button>
								</div>
								<div class="col-md-3 column"></div>
							</div>
						</div>

						<div class="tab-pane" id="panel-4">
							<br>
							<div class="row clearfix">
								<div class="col-md-3 column"></div>
								<div class="col-md-2 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_select_total_class.jsp'">查看所有课程信息</button>
								</div>
								<div class="col-md-2 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_select_single_class.jsp'">查询课程</button>
								</div>
								<div class="col-md-2 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_insert_class.jsp'">新增课程</button>
								</div>
								<div class="col-md-3 column"></div>
							</div>
						</div>

						<div class="tab-pane" id="panel-5">
							<br>
							<div class="row clearfix">
								<div class="col-md-3 column"></div>
								<div class="col-md-3 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_select_point_byclass.jsp'">查看学生成绩</button>
								</div>
								<div class="col-md-3 column">
									<button type="button" class="btn btn-default btn-block"
										onclick="location='admin_insert_point_byclass.jsp'">录入学生成绩</button>
								</div>
								<div class="col-md-3 column"></div>
							</div>
						</div>

						<div class="tab-pane" id="panel-6">
							<br>
							<div class="row clearfix">
								<div class="col-md-4 column"></div>
								<div class="col-md-4 column">
									<form id="settingForm" action="UserEditor" method="post">
										<label>用户名</label> <input type="text" name="username"
											class="form-control" value="<%out.print(user.getUid());%>">
										<br> <label>密码</label> <input type="text" name="password"
											class="form-control" value="<%out.print(user.getUpass());%>">
										<br> <label>权限</label> <input type="text" name="auth"
											class="form-control" value="1"> <br> <input
											type="submit" class="btn btn-default btn-block"> <br>
									</form>
								</div>
								<div class="col-md-4 column"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>