<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
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
			background-image:url("����ͼ5.jpg");
			background-repeat: no-repeat;
			background-position: 100%, 100%;
			background-size:cover; 
		
			
		}	
		.bottom{
			width:100%;
			height:65px;
			display:flex;
			background-image:url("����ͼ5.jpg");
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
			/*height:500px; ģ��߶ȼ̳У��������Զ�ģ��ʹ��*/
			width:522px;
			margin:0 auto;
		}
		.cyl_codemain{	/*�����ɹ�����:�м�*/
			width:100%;
			padding:50px 60px 0px 60px;
		}
		#cyl_daiding{	/*��ʾ����ͼƬ*/
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
		#cyl_lanmuHead{	/*��ʾ����ͼƬ*/
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
	
	<script type="text/javascript">
	
		function previewImg(obj) {
			var str=obj.value;
			document.getElementById('cyl_daiding').innerHTML=str;
		}
		function nopreviewImg() {
			document.getElementById('cyl_daiding').innerHTML =null;
			
		}
	</script>
</head>
<body  background-color="rgb(231, 244, 241)">
<div class="liukong">
	<div class=cyl_codeUI>
		<div id="cyl_choosePic">
			<p class="cyl_titile">��Ƶ����</p>
			<!--  <input type="text" style="width:400px" value="(����ͼƬС��1M)"/>
			<input type="button" value="ѡ��·��"/><br/>
			<div id="cyl_daiding">
				<div style="text-align:center;line-height:300px"><p>��ѡ��һ����Ƶ...</p></div>
				<img src=""/ name=daidingPic/>
			</div>-->
			
			<form action="../LoadServlet?action=upload&ide=video" enctype="multipart/form-data" method="post">
                ��ѡ���ļ���<input id="myfile" name="myfile" type="file" onchange="previewImg(this)"/>
                <br>
                <button type="submit" class="btn" >�ύ</button>
                <button type="reset" class="btn" onclick="nopreviewImg()">����</button>
                <br>
                <div id="cyl_daiding" style="margin-top:30px">
                </div>
                
            </form>
		</div>
		<br/><br/>
		<div style="text-align:right">
			<a href="��Ŀ���÷���.html"><input type="button" value="��һ��"></input></a>
		</div>
	</div>
	<br/><br/>
	
</div>
</body>
</html>