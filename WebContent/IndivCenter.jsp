<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>个人中心</title>
	<link href="css/cylStyle.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="css/head.css">
	<link rel="stylesheet" type="text/css" href="css/container.css">
	<style type="text/css">
		 #ccz_banmian{
			width:100%;
			height:auto;
			padding-top:0;
			margin:auto;
			background-image:url("picture/bgimg.jpg");
			background-repeat: repeat;
		}

		.title{
			color:white;
			text-align:right;
			display:flex;
			font-size:15px;
		}
	
		.title1{
			position:absolute;
			width: 300px;
            height: 80px;
			left:50%;
			top:50%; 
			margin-left:-150px;
			margin-top:-40px;
			text-align:right;
			padding:0;
			margin-bottom:0;
		}
		.titlecop{
			margin:center;
			text-align:center;
			padding:0px;
			margin-bottom:0px;
			color:white
		}
		
		.buttonsty{
			background-color:rgb(33, 150, 243);
			color:white;
			width:60px;
			height:20px;
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
		}

	</style>
</head>
<body background-color="rgb(231, 244, 241)">
	<div id="ccz_yewuguanli">
		<div class="block1">
			<div class="logo">
				<image src="picture/LOGO3.jpg" alt="加载失败" title="logo" width="100%"  height="100%"></image>
			</div>
			<div class="title">
					<h1 style="color: white">科研成果展示系统
						<small style="color: white">版本号</small>
					</h1>
			</div>		
			<div class="logo"></div>	
		</div>
		<div id="ccz_container">
		<div class="liukongTotal">
			<div id="Navigation">
			<ul>
				<li><a href="subIndivCenter/IndivInfo.jsp" target="rightFrame">基本信息</a></li>
				<li><a href="subIndivCenter/PswdChange.jsp" target="rightFrame">修改密码</a></li>
				<li><a href="subIndivCenter/EmailSaving.jsp" target="rightFrame">邮箱绑定</a></li>
				<li><a href="SysControl.jsp" target="_self">返回主页</a></li>
				<li id="space"> </li>
			</ul>
			</div>
			<div class="myframe">
				<iframe name="rightFrame" width="100%" height="100%" src="subIndivCenter/IndivInfo.jsp" frameborder="0" scrolling="no"></iframe>
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