<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增成果</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="../css/cylStyle.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="../css/head.css">
	<link rel="stylesheet" type="text/css" href="../css/container.css">
	<style type="text/css">
		 #ccz_yiji{
			width:100%;
			height:100%;
			min-width: 1200px;
			padding-top:0;
			margin:auto;
			background-image:url("../picture/bgimg.jpg");
			background-repeat: repeat;
		}
		
		.cyl_codeUI{
			/*height:500px; 模块高度继承，这个类可以多模块使用*/
			width:522px;
			margin:0 auto;
		}
		.cyl_codemain{	/*新增成果主体:中间*/
			width:100%;
			padding:50px 60px 0px 60px;
		}
		#cyl_daiding{	/*表示待定图片*/
			width:100%;
			height:310px;
			box-shadow: 2px 3px 10px #8BC34A;
			background-color:rgb(203, 247, 176);
		}
		#cyl_lanmuMain{
			width:100%;
			height:400px;
			box-shadow: 2px 3px 10px #8BC34A;
		}
		#cyl_lanmuHead{	/*表示待定图片*/
			width:100%;
			height:8%;
			background-color:rgb(185, 245, 148);
		}
		#cyl_lanmuBody{
			width:100%;
			height:92%;
			background-color:rgb(203, 247, 176);
		}
		#cyl_submit1{
			position:relative;
			left:360px;
		}
		#cyl_basicInfo{
			width:470px;
			height:100px;
			padding:35px 20px 45px 20px;
			box-shadow: 2px 3px 10px #8BC34A;
			background-color:rgb(203, 247, 176);
			border:5px;
		}

		
		/*导航栏*/
		#Navigation{
			float:left;
			width:200px;
			height:100%;
		}
		ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
			height:100%;
			width:100%;
			overflow: hidden;
			border-right:1px solid #bbb;
			background-color: #f3f3f3;
		}
		li {
			/*float: left;*/
		}
		li a {
			display: block;
			color: #666;
			text-align: center;
			padding: 16px 16px;
			text-decoration: none;
			font-size:18px;
		}
		li a:hover:not(.active) {
			background-color: #ddd;
		}
		li #space{
			height:60px;
		}
		
		.myframe{
			width:100%;
			height:100%;
		}/*background-color="rgb(231, 244, 241)*/
	</style>
</head>
<body>
<div id="ccz_yiji">
	<div class="block1">
			<div class="logo">
				<image src="../picture/LOGO3.jpg" alt="加载失败" title="logo" width="100%"  height="100%"></image>
			</div>
			<div class="title">
					<h1 style="color: white">科研成果展示系统
						<small style="color: white">版本号</small>
					</h1>
			</div>
			<div class="dropdown">
			<button type="button" class="btn btn-primary btn-lg dropdown-toggle" id="UserMenue1" data-toggle="dropdown" style="margin-right: 20px;margin-top:35px;padding: 2px;padding-top: 2px;padding-right: 12px;padding-left: 12px">
			<span class="glyphicon glyphicon-user" style="color: white; font-size: 12px;"></span>
			<span class="caret"></span>
			</button>
			<ul class="dropdown-menu pull-right" role="menu" aria-labelledby="UserMenue1">
				<li role="presentation">
					<a role="menuitem" tabindex="-1" href="#">个人中心</a></li>
				<li role="presentation">
					<a role="menuitem" tabindex="-1" href="#">退出</a></li>
				</ul>
			</div>
			
		</div>
	<div id="ccz_container" style="width:1200px;">
	<div class="liukongTotal">
		<div id="Navigation">
		<ul>
			<li><a href="workinfoedit.jsp" target="rightFrame">基本信息</a></li>
			<li><a href="imgedit.jsp" target="rightFrame">封面图片</a></li>
			<li><a href="videoedit.jsp" target="rightFrame">视频介绍</a></li>
			<li><a href="coledit.jsp" target="rightFrame">栏目设置</a></li>
			<li><a href="../MyWorks.jsp" target="_self">返回主页</a></li>
		</ul>
		</div>
		<div class="myframe">
			<iframe name="rightFrame" width="100%" height="100%" src="workinfoedit.jsp" frameborder="0" scrolling="no"></iframe>
		</div>
	</div>
	</div>
	<div class="bottom">
			<div class="bottom1">
				<div class="title">
					<h4 style="text-align:right;color:white">湖南大学信息科学与工程学院科研成果展示小组</h4>
				</div>
			</div>
		</div>
</div>
</body>
</html>