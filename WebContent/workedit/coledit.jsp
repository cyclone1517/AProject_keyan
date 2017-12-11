<%@page import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.WorkColumnBean" %>
<%@page import="Dao.WorkColumnDao" %>
<%@page import="Impl.WorkColumnImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			height:360px;
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
		.cyl_entry{
			padding-top:1px;
			padding-left:20px;
			height:35px;
			border-bottom:1px solid #bbb;
		}
		.cyl_entry a{
			text-decoration:none;
		}
	</style>
	<script type="text/javascript">
	function update() {
	    //获取模态框数据
	    var colname = $('#colname').val();
	    $.ajax({
	        type: "post",
	        url: "../LoadServlet?wid=1&tid=201526010307&state=1",
	        data: "colname="+colname,
	        dataType: 'html', 
	        success: function(msg){
                $.messager.alert('信息','增加成功');
        }
	    });
	}
	
	
	</script>
</head>
<body style="background-color:rgb(231, 244, 241)">
		<div class="liukong">
		<div class=cyl_codeUI style="margin-top:50px">
			<form>
			<table class="table table-hover"style="text-align: center">
			
			<thead class="thead-dark" style="background-color:#337ab7;color:white;text-align: center">
			<tr>
			<th colspan="7" style="text-align: right;background-color:rgb(231, 244, 241)">
			  <button type="submit" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addCol" style="margin-left: 55%;margin-top:5px;height:25px;width:70px;padding: auto;text-align: center;font-size:12px;padding-top:5px;padding-left:12px" ><a href="#" style="color:white">添加用户</a></button>
			</th>
			</tr>
			<tr>
			<th colspan="5" style="text-align: center">栏目</th>
			<th colspan="2" style="text-align: center">栏目编辑</th>
			<!-- <th >删除</th> -->
			</tr>
			</thead>
			<tbody>
			<%
			List<WorkColumnBean>wcbs=new ArrayList<WorkColumnBean>();
			WorkColumnDao wcd=new WorkColumnImpl();
			
			//wcbs=wcd.queryTC("201526010307", "1", 1);
			wcbs=wcd.queryTC("201526010307","1",0);
			for(int i=0;i<wcbs.size();i++)
			{
			%>
			<%
			WorkColumnBean wcb=wcbs.get(i);
			%>
			<tr>
			<td colspan="5">
			<%=wcb.getCol_name() %>
			</td>
			<td>
			<a href="" onclick="return false;" data-toggle='modal' data-target='#updateCol' style="text-decoration: none">修改</a>
			<!-- <a href="" class="btn-lg" data-toggle="modal" data-toggle="#updateCol" style="margin-left: 55%;margin-top:5px;height:25px;width:70px;padding: auto;text-align: center;font-size:12px;padding-top:5px;padding-left:12px">修改</a> -->
			</td>
			<td>
			<a href="javascript:if(confirm('确定删除此用户?'))location='http://localhost:8088/Javaee_program/UserServlet?action=del';">删除</a>
			</td>
			</tr>
			<%
			}
			%>
			</tbody>
			</table>
			
		<div style="text-align:right">
			<a href="个人成果.html"><input type="submit"></input></a>
		</div>
	 	<div class="modal fade" id="addCol" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
					<h4 class="modal-title" id="myModalLabel">
						新增栏目
					</h4>
					</div>
				<div class="modal-body">
				<form role="form" id="addform" method="post" action="../LoadServlet?action=addcol&ide=col&wid=1&tid=201526010307&state=1">
					 <input type="text" value="${colname}" class="form-control" id="colname" placeholder="请输入栏目名称" name="colname">
				
					 </div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
					<button type="submit" class="btn btn-primary" >
						<a href="../LoadServlet?action=addcol&ide=col&wid=1&tid=201526010307&state=1">提交</a>
					</button>
				</div>
				</form>
				
				</div>
			</div><!--  /.modal --> 
			</div> 
		<div class="modal fade" id="updateCol" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
					<h4 class="modal-title" id="myModalLabel">
						修改栏目
					</h4>
					</div>
				<form method="post" action="../LoadServlet?wid=1&tid=201526010307&state=1">
				<div class="modal-body">
					 <input type="text" class="form-control" id="colalname" placeholder="请输入栏目名称">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary">
						提交修改
					</button>
				</div>
				</form>
				</div>
			</div><!-- /.modal 
			</div>
		
		</form>
		</div>
		</div>
	
</body>
</html>