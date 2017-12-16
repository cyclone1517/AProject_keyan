<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="Bean.ManagerBean,Dao.ManagerDao,Impl.ManagerImpl,java.util.*,Bean.TeacherBean,
    Dao.TeacherDao,Impl.TeacherImpl,Impl.*,Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/elem.css">
	<link rel="stylesheet" type="text/css" href="css/head.css">
	<link rel="stylesheet" type="text/css" href="css/container.css">
	<link rel="stylesheet" type="text/css" href="css/add.css">
	<title>系统管理</title>
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
			background-image:url("bgimg.jpg");
			background-repeat: repeat;
		}
		.block2-1{
			flex-wrap: nowrap;
			margin:0 auto;
			display:flex;
			justify-content:center;
			flex-direction:row;
			width:100%;
			height:auto;
			margin-bottom:30px;
			padding-top:70px;
			background-image:url("picture/bgimg.jpg");
			background-repeat: repeat;
		}
		.block2-2{
			flex-wrap: nowrap;
			margin:auto;
			display:flex;
			justify-content:flex-start;
			flex-direction:row;
			width:100%;
			height:auto;
			margin-top: 40px;
			background-image:url("bgimg.jpg");
			background-repeat: repeat;
			text-align:center;
		}
</style>
 <script type="text/javascript">
      function jinggao(){
     var myAnswer=confirm("确认删除此用户?");
    if(myAnswer==true)
    {
    	
    }
    else
    {
       
     }
 }
  </script>
<script  type="text/javascript">
function ccz_forbid(){
	var x=document.getElementById("yewu");
	var y=document.getElementById("xitong");
	var z=document.getElementById("teacher");
	if(z.checked)
	{
		document.getElementById("duty").disabled = false;
	}
	else{
	if(x.checked ||y.checked){
		document.getElementById("duty").disabled = true;
	}
	else
	{
		document.getElementById("duty").disabled = false;
	}
}
}
  </script>
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
					</h1>
			</div>
			<div class="dropdown">
			<button type="button" class="btn btn-primary btn-lg dropdown-toggle" id="UserMenue1" data-toggle="dropdown" style="margin-right: 20px;margin-top:35px;padding: 2px;padding-top: 2px;padding-right: 12px;padding-left: 12px">
			<span class="glyphicon glyphicon-user" style="color: white; font-size: 12px;"></span>
			<span class="caret"></span>
			</button>
			<ul class="dropdown-menu pull-right" role="menu" aria-labelledby="UserMenue1">
				<li role="presentation">
					<a role="menuitem" tabindex="-1" href="IndivCenter.jsp">个人中心</a></li>
				<li role="presentation">
					<a role="menuitem" tabindex="-1" href="Login.jsp">退出</a></li>
				</ul>
			</div>
			
		</div>
		<div id="ccz_container">
			<ul id="myTab" class="nav nav-tabs" >
			    <li class="active">
					<a href="#chaxun" data-toggle="tab" style="font-size: 18px"><b>查询用户</b></a>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="font-size: 18px;color:black">导入用户<b class="caret"></b></a>
				<ul class="dropdown-menu">
				<li >
					<a href="#shoudong" data-toggle="tab" style="font-size: 18px"><b>手动导入</b></a>
				</li>
				<li >
					<a href="#xitong1" data-toggle="tab" style="font-size: 18px"><b>系统导入</b></a>
				</li>
				</ul>
				</li>
			</ul>
<div id="myTabContent" class="tab-content" >
	
	<div class="tab-pane fade in active" id="chaxun">
					
	<div class="block2">
	<%
		String type1=(String)session.getAttribute("type1");
		String type2=(String)session.getAttribute("type2");
		%>
		<form method="post" action="/AProject_keyan/Mng_Servlet?action=query&ide=sys">
		<select name="type1">
		<option value="所有" <%=(type1.equals("所有")?"selected":"")%>>所有</option>
		<option value="教师" <%=(type1.equals("教师")?"selected":"")%>>教师</option>
		<option value="业务管理员" <%=(type1.equals("业务管理员")?"selected":"")%>>业务管理员</option>
		<option value="系统管理员" <%=(type1.equals("系统管理员")?"selected":"")%>>系统管理员</option>
		</select>&nbsp&nbsp&nbsp
		<select name="type2">
		<option value="不限" <%=(type2.equals("不限")?"selected":"")%>>不限</option>
		<option value="用户ID" <%=(type2.equals("用户ID")?"selected":"")%>>用户ID</option>
		<option value="学院" <%=(type2.equals("学院")?"selected":"")%>>学院</option>
		<option value="姓名" <%=(type2.equals("姓名")?"selected":"")%>>姓名</option>
		</select>&nbsp&nbsp&nbsp
		<input type="text" name="keywords" style="width:180px">
		<input class="tijiao" type="submit"  value="检索">
		</form>
		</form>
		</div>
		<div class="block2-2">
		<table class="table table-hover" style="text-align:center;font-size:14px" >
			
			<thead   class="biao" >
			<tr >
			<th style="text-align:center">用户编号</th>
			<th style="text-align:center">用户姓名</th>
			<th style="text-align:center">身份</th>
			<th style="text-align:center">院系</th>
			<th colspan="1" style="text-align:center">邮箱</th>
			<th colspan="2"></th>
			
			</tr>
			</thead>
			<tbody>
			<%
			if(request.getAttribute("list")!=null){
				List<ManagerBean> list=(List<ManagerBean>) request.getAttribute("list"); 
				for(ManagerBean mng:list){
					String dpmt=mng.getDpmt();//new String(mng.getDpmt().getBytes("iso-8859-1"), "gbk");
					String name=mng.getMng_name();//new String(mng.getMng_name().getBytes("iso-8859-1"), "gbk");
					RoleOfUserDao dao=new RoleOfUserImpl();
			%>
			<tr>
			<td><%=mng.getMng_no()%></td>
			<td><%=name %></td>
			<td><%List<String> str=dao.queryUserno(mng.getMng_no()) ;
			for(String ss:str){
			String s=ss;//new String(ss.getBytes("iso-8859-1"), "GB2312");%>
			<%=s %>
			<%} %></td>
			<td><%=dpmt %></td>
			<td><%=mng.getEmail() %></td>
			<td><a href="http://localhost:8080/AProject_keyan/Mng_Servlet?action=get&ide=sys&id=<%=mng.getMng_no()%>">修改</a></td>
			<td><a href="http://localhost:8080/AProject_keyan/Mng_Servlet?action=delete&ide=sys&id=<%=mng.getMng_no() %>">删除</a></td>
			</tr>
			<%}} %>
			
			<%
			if(request.getAttribute("list1")!=null){
				List<TeacherBean> list=(List<TeacherBean>) request.getAttribute("list1"); 
				for(TeacherBean mng:list){
					String dpmt=mng.getDpmt();//new String(mng.getDpmt().getBytes("iso-8859-1"), "gbk");
					String name=mng.getTch_name();//new String(mng.getTch_name().getBytes("iso-8859-1"), "gbk");
					RoleOfUserDao dao=new RoleOfUserImpl();
			%>
			<tr>
			<td><%=mng.getTch_no() %></td>
			<td><%=name %></td>
			<td><%List<String> str=dao.queryUserno(mng.getTch_no()) ;
			for(String ss:str){
			String s=ss;//new String(ss.getBytes("iso-8859-1"), "GB2312");%>
			<%=s %>
			<%} %></td>
			<td><%=dpmt %></td>
			<td><%=mng.getEmail() %></td>
			<td><a href="http://localhost:8080/AProject_keyan/Mng_Servlet?action=get&ide=sys&id=<%=mng.getTch_no()%>">修改</a></td>
			<td><a href="http://localhost:8080/AProject_keyan/Mng_Servlet?action=delete&ide=tch&id=<%=mng.getTch_no() %>">删除</a></td>
			</tr>
			<%} }%>
			
			<%
			if(request.getAttribute("list2")!=null){
				List<ManagerBean> list=(List<ManagerBean>) request.getAttribute("list2"); 
				for(ManagerBean mng:list){
					String dpmt=mng.getDpmt();//new String(mng.getDpmt().getBytes("iso-8859-1"), "gbk");
					String name=mng.getMng_name();//new String(mng.getMng_name().getBytes("iso-8859-1"), "gbk");
					RoleOfUserDao dao=new RoleOfUserImpl();
			%>
			<tr>
			<td><%=mng.getMng_no()%></td>
			<td><%=name %></td>
			<td><%List<String> str=dao.queryUserno(mng.getMng_no()) ;
			for(String ss:str){
			String s=ss;//new String(ss.getBytes("iso-8859-1"), "GB2312");%>
			<%=s %>
			<%} %></td>
			<td><%=dpmt %></td>
			<td><%=mng.getEmail() %></td>
			<td><a href="http://localhost:8080/AProject_keyan/Mng_Servlet?action=get&ide=sys&id=<%=mng.getMng_no()%>">修改</a></td>
			<td><a href="http://localhost:8080/AProject_keyan/Mng_Servlet?action=delete&ide=bus&id=<%=mng.getMng_no() %>">删除</a></td>
			</tr>
			<%}} %>
			</tbody>
			</table>
			
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

			<div class="tab-pane fade " id="shoudong">
				<div class="block2">

				<div class=cyl_codeUI>
				<p class=cyl_titile>新增用户</p>
				<p style="font-weight:bold">基本信息</p>
				<div class="cyl_basicInfo1">
					<form name="f1" action="/AProject_keyan/Mng_Servlet?action=add&ide=sys" method="post">
					<table>
						<tr>
							<td width=90px>职工号</td>
							<td><input type="text" name="no" id="cyl_emain" style="width:300px"></td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
							<td>用户身份</td>
							<td>
							        <input type="checkbox" name="tch" value="教师" id="teacher" onchange="ccz_forbid()">教师&nbsp&nbsp&nbsp&nbsp
							        <input type="checkbox" name="bus" value="业务管理员" id="yewu" onchange="ccz_forbid()">业务管理员&nbsp&nbsp&nbsp&nbsp
							        <input type="checkbox" name="sys" value="系统管理员" id="xitong" onchange="ccz_forbid()">系统管理员
							</td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
						 <td>姓名</td>
						 <td><input type="text" name="name" id="cyl_emain" style="width:300px"></td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
						 <td>邮箱</td>
						 <td><input type="text" name="email" id="cyl_emain" style="width:300px"></td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
						 <td>院系</td>
						 <td><input type="text" name="dpmt" id="cyl_emain" style="width:300px"></td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
						 <td>职称</td>
						 <td >
						     <select style="width:150px" name="job" id="duty">
		                         <option value="教授">教授</option>
		                         <option value="副教授">副教授</option>
		                         <option value="助理教授">助理教授</option>
		                     </select>
						 </td>
						</tr>
					</table>
				
				
				<br/><br/><br/>
				
				
				<div style="text-align:center">
					<input type="submit" value="提交"/>
				</div>
				</form>
			</div>
		</div>

	</div>
				<div class="block2-1">
				</div>
	</div>

      		<div class="tab-pane fade " id="xitong1">
				<div class="block2">

				<div class=cyl_codeUI>
				<p class=cyl_titile>新增用户</p>
				<div class="cyl_basicInfo3">
				<form method="post" action="/AProject_keyan/Excel_Servlet?type=excToMqsql" enctype="multipart/form-data" name="f">
					<table>
					   <tr>
					      <td>用户类型</td>
					      <td>
					        <select name="identity">
		                      <option value="tch">教师</option>
		                      <option value="bus">业务管理员</option>
		                      <option value="sys">系统管理员</option>
		                   </select>
		                   </td>
		                 </tr>
		                 <tr><td><br/></td></tr>
						<tr>
							<td width=90px>文件导入</td>
							<td><input type="file" name="file" id="cyl_emain" style="width:300px"></td>
							<!--<td><input type="submit" value="Browse..."></td>-->
						</tr>
						<tr><td><br/></td></tr>
					</table>
				
				
				<br/><br/><br/>
				
				<div style="margin-left:480px;padding-bottom:80px">
					<input type="submit" value="提交"/>
				</div>
				
				</form>
				
				
			</div>
		</div>

	</div>
			<div class="block2-1"></div>	
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