<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/cylStyle.css" rel="stylesheet" type="text/css"/>
	<style type="text/css">
		 #ccz_banmian{
			width:100%;
			height:auto;
			padding-top:0;
			margin:auto;
		}
		.block1{
			position:relative;
			width:100%;
			height:92px;
			padding:0px;
			margin:0px;
			background-image:url("背景图5.jpg");
			background-repeat: no-repeat;
			background-position: 100%, 100%;
			background-size:cover; 
		
			
		}	
		.bottom{
			width:100%;
			height:65px;
			display:flex;
			background-image:url("背景图5.jpg");
			padding-bottom: 10px;
			background-repeat: no-repeat
			background-position: 100%, 100%;
			background-size: cover;;
			justify-content:flex-end;
			align-items:center;
		}
		.bottom1{
			width:100%;
			height:65px;
			display:flex;/*#2196F3*/
			background-color: rgba(255, 255, 255, 0);
			justify-content:center;
			align-items:center;
		}
		.bottom2{

			bottom:10px;
			color:#2196F3;
			font-size:15px;	
			background-color: #2196F3;
			margin-right: 10px;
			align-self:flex-end;

		}

		.title{
			color:white;
			text-align:right;
			display:flex;
			font-size:15px;
		}
		.logo{
			position:absolute;
			top:20%;
			bottom:10%;
			left:1%;
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
		.banben{
			position:absolute;
			left:80%;
			margin:0px;
			text-align:right;
			font-size:10px;
			float:right;
			top:50px;
			color:white;
			bottom:20%;
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
			width:480px;
			height:240px;
			padding:30px 20px 45px 20px;
			box-shadow: 2px 3px 10px #8BC34A;
			background-color:rgb(203, 247, 176);
			border:5px;
		}
	</style>
</head>
<body background-color="rgb(231, 244, 241)">
		<div class="liukong">
			<div class="cyl_codeUI">
				<p class="cyl_titile">基本信息</p>
				<div id="cyl_basicInfo">
				<form method="post" action="../WorkServlet?action=addwork&ide=work&wid=5&tid=201526010307">
					<table>
						<tr>
							<td width=90px>成果名称</td>
							<td><input type="text" name="wname" id="cyl_emain" style="width:300px"></td>
						</tr>
						<tr>
							<td>标签</td>
							<td><input type="text" name="wlabel" id="cyl_emain" style="width:300px"></td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
							<td>分类</td>
							<td><select name="type">
								<option value="金融">金融</option>
								<option value="数学">数学</option>
								<option value="科技">科技</option>
								<option value="人文">人文</option>
							</select></td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
							<td valign="top">简介</td>
							<td><textarea cols="50" rows="7" name="intro">简要文字描述...</textarea></td>
						</tr>
					</table>
					<div style="text-align:right">
					<a href="../WorkServlet?action=addwork&ide=work&wid=5&tid=201526010307"><input type="submit" value="下一步"></input></a>
					</div>
					</form>
				</div>
				<br/><br/>
				
			</div>
		</div>
		

	</div>
</body>
</html>