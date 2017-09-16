<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>~青木科技校园生活服务网站~</title>
<link rel="stylesheet" href="dist/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="dist/css/bootstrap-theme.min.css"
	type="text/css">
<script src="dist/js/jquery-3.1.1.min.js"></script>
<script src="dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix" style="margin-top: 70px">
			<div class="col-md-12 column">
				<div class="carousel slide" id="carousel-379506"
					data-ride="carousel" data-interval="3000">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-379506"></li>
						<li data-slide-to="1" data-target="#carousel-379506"></li>
						<li data-slide-to="2" data-target="#carousel-379506"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="img/cos_biaobai.jpg" />
							<div class="carousel-caption">
								<h4>
									<a href="biaobai/index.jsp" class="h4">表白墙</a>
								</h4>
								<p>我喜欢你 和我交往吧 我能不能和你在一起</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="img/cos_stumanage.jpg" />
							<div class="carousel-caption">
								<h4>
									<a href="stumanage/index.jsp" class="h4">学生信息管理系统</a>
								</h4>
								<p>青木科技服务平台为学校学生提供一套优质的学生基本信息检索平台</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="img/cos_comfix.jpg" />
							<div class="carousel-caption">
								<h4>
									<a href="comfix/index.jsp" class="h4">维修服务</a>
								</h4>
								<p>青木科技维修小分队。 带给您最专业的电脑维修服务。</p>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-379506"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-379506"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
				<%@ include file="nav.jsp" %>
			</div>
		</div>

		<br>
		<br>

		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row">
					<div class="col-md-4">
						<div class="thumbnail" style="border: none">
							<img alt="300x200" src="img/computerfix.jpg"
								style="width: 150px; height: 100px" />
							<div class="caption">
								<h3>维修服务</h3>
								<p>
									电脑突然出问题怎么办?<br> 数据无缘无故丢失怎么办?<br> 软件装不上,流量太贵舍不得下载。<br>
									统统交给我们。青木科技维修小分队。<br> 带给您最专业的电脑维修服务。
								</p>
								<p>
								<li class="dropdown btn" style="list-style: none"><a
									href="#" class="dropdown-toggle" data-toggle="dropdown">点击预约维修<strong
										class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li><a href="comfix/index.jsp">学生维修服务</a></li>
										<li class="divider"></li>
										<li><a href="comfix/fixtoteach.jsp">老师预约维修服务</a></li>
									</ul></li>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="thumbnail" style="border: none">
							<img alt="300x200" src="img/stumange.jpg"
								style="width: 150px; height: 100px" />
							<div class="caption">
								<h3>学生信息管理系统</h3>
								<p>
									青木科技服务平台为学校学生提供一套优质的学生基本信息检索平台。<br>
									在该平台中,学生可以非常方便地查看和修改自己的信息。<br> 老师可以高效率地查询到学生的信息。<br>
								</p>
								<p>
									<a rel="nofollow" class="btn" href="stuinfomanage">进入学生信息管理系统 »</a>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="thumbnail" style="border: none">
							<img alt="300x200" src="img/biaobai.jpg"
								style="width: 150px; height: 100px" />
							<div class="caption">
								<h3>表白墙</h3>
								<p>
									对暗恋的ta不好意思开口？<br> 进入表白墙表白，替你说出心中的爱！<br> 我喜欢你 <br>
									和我交往吧 <br> 我能不能和你在一起
								</p>
								<p>
									<a rel="nofollow" class="btn" href="biaobai/index.jsp">进入表白墙
										»</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<br>
		<br>

		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>