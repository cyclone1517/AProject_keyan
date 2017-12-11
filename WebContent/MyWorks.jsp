<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/elem.css" rel="stylesheet" type="text/css">
<link href="css/head.css" rel="stylesheet" type="text/css">
<link href="css/container.css" rel="stylesheet" type="text/css">
<title>业务管理</title>
<style type="text/css">
		.block2{
			flex-wrap: nowrap;
			margin:auto;
			margin-left: 5px;
			display:flex;
			justify-content:flex-start;
			flex-direction:row;
			width:90%;
			height:auto;
			margin-top: 40px;
			background-image:url("picture/bgimg.jpg");
			background-repeat: repeat;
		}
		.block2-1{
			flex-wrap: nowrap;
			margin:0;
			display:flex;
			justify-content:center;
			flex-direction:row;
			width:100%;
			height:auto;
			margin-bottom: 30px;
			padding-top: 20px;
			background-image:url("picture/bgimg.jpg");
			background-repeat: repeat;
		}

</style>
</head>
<body>
<div id="ccz_yewuguanli">
		<div class="block1">
			<div class="logo">
				<image src="picture/LOGO3.jpg" alt="加载失败" title="logo" width="100%"  height="100%"></image>
			</div>
			<div class="title">
					<h1 style="color: white">科研成果展示系统
						<small style="color: white">版本号</small>
					</h1><%=request.getAttribute("result") %>
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
		<div id="ccz_container">
			<ul id="myTab" class="nav nav-tabs" >
				<li class="active" >
					<a href="#yitijiao" data-toggle="tab" style="font-size: 18px"><b>已提交成果</b></a>
				</li>
				<li>
					<a href="#weitijiao" data-toggle="tab" style="font-size: 18px"><b>未提交成果</b></a>
				</li>
			</ul>
			<div id="myTabContent" class="tab-content" >
				<div class="tab-pane fade in active" id="yitijiao">
					<div class="block2">
					
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果1.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2" style="margin-top: 0px">
							<p>成果1的标题</p>
						</div>
						<div class="overlay">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><div class="text">成果1的介绍</div></a>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果2.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2" style="margin-top: 0px">
							<p>成果2的标题</p>
						</div>
						<a href="workedit/addwork.jsp" style="text-decoration: none"><div class="overlay">
							<div class="text">成果2的介绍</div>
						</div></a>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果3.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2">
							<p>成果3的标题</p>
						</div>
						<a href="workedit/addwork.jsp" style="text-decoration: none"><div class="overlay">
							<div class="text">成果3的介绍</div>
						</div></a>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果4.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2">
							<p>成果4的标题</p>
						</div>
						<div class="overlay">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><div class="text">成果4的介绍</div></a>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果5.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2">
							<p>成果5的标题</p>
						</div>
						<div class="overlay">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><div class="text">成果5的介绍</div></a>
						</div>
					</div>
				</div>
				<div class="block2">
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果6.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2">
							<p>成果3的标题</p>
						</div>
						<div class="overlay">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><div class="text">成果3的介绍</div></a>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果7.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2">
							<p>成果3的标题</p>
						</div>
						<div class="overlay">
							<a href="#成果审核" style="text-decoration: none"><div class="text">成果3的介绍</div></a>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果8.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2">
							<p>成果3的标题</p>
						</div>
						<div class="overlay">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><div class="text">成果3的介绍</div></a>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<a href="/workedit/addwork.jsp"><img src="picture/plus.png" alt="加载失败" class="image1" ></a>
						</div>
					</div>
				</div>
				<div class="block2-1">
					<ul class="pagination">
						<li><a href="#">首页</a></li>
						<li><a href="#">上一页</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">下一页</a></li>
						<li><a href="#">尾页</a></li>
					</ul>
				</div>
				
			</div>
				<div class="tab-pane fade" id="weitijiao">
					<div class="block2">
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果1.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2" style="margin-top: 0px">
							<p>成果1的标题</p>
						</div>
						<a href="workedit/addwork.jsp" style="text-decoration: none"><div class="overlay">
							<div class="text">成果1的介绍</div>
						</div></a>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><img src="picture/成果2.jpg" alt="加载失败" class="image1" ></a>
						</div>
						<div class="elem1-2" style="margin-top: 0px">
							<p>成果2的标题</p>
						</div>
						<div class="overlay">
							<a href="workedit/addwork.jsp" style="text-decoration: none"><div class="text">成果2的介绍</div></a>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<img src="picture/成果3.jpg" alt="加载失败" class="image1" >
						</div>
						<div class="elem1-2">
							<p>成果3的标题</p>
						</div>
						<div class="overlay">
							<div class="text">成果3的介绍</div>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<img src="picture/成果4.jpg" alt="加载失败" class="image1" >
						</div>
						<div class="elem1-2">
							<p>成果4的标题</p>
						</div>
						<div class="overlay">
							<div class="text">成果4的介绍</div>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<img src="picture/成果5.jpg" alt="加载失败" class="image1" >
						</div>
						<div class="elem1-2">
							<p>成果5的标题</p>
						</div>
						<div class="overlay">
							<div class="text">成果5的介绍</div>
						</div>
					</div>
				</div>
				<div class="block2">
					<div class="elem1">
						<div class="elemimage">
							<img src="picture/成果6.jpg" alt="加载失败" class="image1" >
						</div>
						<div class="elem1-2">
							<p>成果3的标题</p>
						</div>
						<div class="overlay">
							<div class="text">成果3的介绍</div>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<img src="picture/成果7.jpg" alt="加载失败" class="image1" >
						</div>
						<div class="elem1-2">
							<p>成果3的标题</p>
						</div>
						<div class="overlay">
							<div class="text">成果3的介绍</div>
						</div>
					</div>
					<div class="elem1">
						<div class="elemimage">
							<img src="picture/成果8.jpg" alt="加载失败" class="image1" >
						</div>
						<div class="elem1-2">
							<p>成果3的标题</p>
						</div>
						<div class="overlay">
							<div class="text">成果3的介绍</div>
						</div>
					</div>
				</div>
				<div class="block2-1">
					<ul class="pagination">
						<li><a href="#">首页</a></li>
						<li><a href="#">上一页</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">下一页</a></li>
						<li><a href="#">尾页</a></li>
					</ul>
				</div>
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