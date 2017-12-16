<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="Bean.ManagerBean,Dao.ManagerDao,Impl.ManagerImpl,java.util.*,Bean.TeacherBean,
    Dao.TeacherDao,Impl.TeacherImpl,Impl.*,Dao.*"%>
    
<!DOCTYPE html>
<!--崔程子-->
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/elem.css">
	<link rel="stylesheet" type="text/css" href="css/head.css">
	<link rel="stylesheet" type="text/css" href="css/container.css">
	<link rel="stylesheet" type="text/css" href="css/add.css">
	<title>修改</title>
	<style type="text/css">
		.block2{
			flex-wrap: nowrap;
			margin:0 auto;
			/*margin-left: 5px;*/
			display:flex;
			justify-content:center;
			flex-direction:row;
			width:90%;
			height:auto;
			margin-top: 5px;
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
			margin-bottom: 20px;
			margin-top: 20px;
			background-image:url("picture/bgimg.jpg");
			background-repeat: repeat;
			
		}

</style>
<script type="text/javascript">
function forbid(){
	var a1=document.getElementById("eno1");
	var b1=document.getElementById("status1");
	var y1=document.getElementById("yw1");
	var x1=document.getElementById("xt1");
	var c1=document.getElementById("job1");
	var d1=document.getElementById("academy1");
	var e1=document.getElementById("fd1");
	var n1=document.getElementById("name1");
	/*if(true){
		document.getElementById("eno1").disabled=true;
        document.getElementById("name1").disabled=true;
	}*/
    
	if(e1.checked){
		//document.getElementById("eno1").disabled=true;
		document.getElementById("status1").disabled=true;
		document.getElementById("yw1").disabled=true;
		document.getElementById("xt1").disabled=true;
		document.getElementById("job1").disabled=true;
		document.getElementById("academy1").disabled=true;
	}
	else{
		//document.getElementById("eno1").disabled=false;
		document.getElementById("status1").disabled=false;
		document.getElementById("yw1").disabled=false;
		document.getElementById("xt1").disabled=false;
		document.getElementById("job1").disabled=false;
		document.getElementById("academy1").disabled=false;
	}
	if(b1.checked){
		document.getElementById("status1").disabled=false;
	}
	else{
		if(x1.checked||y1.checked){
		document.getElementById("job1").disabled=true;
	}
	    else{
		document.getElementById("job1").disabled=false;
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
					<a role="menuitem" tabindex="-1" href="个人中心.html">个人中心</a></li>
				<li role="presentation">
					<a role="menuitem" tabindex="-1" href="登录.html">退出</a></li>
				</ul>
			</div>
			
		</div>
		<form name="f1" method="post" action="/AProject_keyan/Mng_Servlet?action=update&ide=sys">
		<div id="ccz_container">
					<div class="block2">
					<div class=cyl_codeUI>
				<p class=cyl_titile>修改用户</p>
				<p style="font-weight:bold">基本信息</p>
				<div class="cyl_basicInfo2">
					<table>
					<%
					String no=null,name=null,dpmt=null,title="";
					if(request.getAttribute("bean")!=null){
						TeacherBean bean=(TeacherBean)request.getAttribute("bean");
						title=bean.getTitle();
						no=bean.getTch_no();
						name=bean.getTch_name();
						dpmt=bean.getDpmt();
					}
					if(request.getAttribute("bean2")!=null){
						ManagerBean bean=(ManagerBean)request.getAttribute("bean2");
						no=bean.getMng_no();
						name=bean.getMng_name();
						dpmt=bean.getDpmt();
					}
					if(request.getAttribute("bean3")!=null){
						ManagerBean bean=(ManagerBean)request.getAttribute("bean3");
						no=bean.getMng_no();
						name=bean.getMng_name();
						dpmt=bean.getDpmt();
					}
					%>
						<tr>
							<td width=90px>职工号</td>
							<td><input type="text" name="no" id="eno1" style="width:245px" readonly="readonly" value="<%=no%>"></td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
							<td width=90px>姓名</td>
							<td><input type="text" name="name" id="name1" style="width:245px" readonly="readonly" value="<%=name%>"></td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
							<td>用户身份</td>
							<%String sysmark=(String)session.getAttribute("sysmark"); 
							String tchmark=(String)session.getAttribute("tchmark"); 
							String busmark=(String)session.getAttribute("busmark"); 
							%>
							<td>
							    <input type="checkbox" name="tch" value="教师" id="status1" onchange="forbid()" <%=(tchmark.equals("2")?"checked":"")%>>教师&nbsp&nbsp&nbsp&nbsp
							    <input type="checkbox" name="bus" value="业务管理员" id="yw1" onchange="forbid()" <%=(busmark.equals("3")?"checked":"")%>>业务管理员&nbsp&nbsp&nbsp&nbsp
					            <input type="checkbox" name="sys" value="系统管理员" id="xt1" onchange="forbid()" <%=(sysmark.equals("1")?"checked":"")%>>系统管理员
							</td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
							<td>职称</td>
							<td>
						      <select id="job1" onchange="forbid()" name="job">
		                         <option value="教授" <%=(title.equals("教授")?"selected":"")%>>教授</option>
		                         <option value="副教授" <%=(title.equals("副教授")?"selected":"")%>>副教授</option>
		                         <option value="助理教授" <%=(title.equals("助理教授")?"selected":"")%>>助理教授</option>
		                      </select>
							</td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
							<td>院系</td>
							<td><input type="text" name="dpmt" id="academy1" style="width:245px" onchange="forbid()" value="<%=dpmt%>"></td>
						</tr>
						<tr><td><br/></td></tr>
						<tr>
							<td>状态</td>
							<td>
							<input type="checkbox" name="state" value="禁用" id="fd1" onchange="forbid()">禁用
							</td>
						</tr>
						<tr><td><br/></td></tr>
					</table>
				
				
				<br/><br/><br/>
				
				
				
			</div>
		</div>
		</div>
		<div class="block2-1">
				<div class="def">
					<input type="submit" value="确定">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<a href="http://localhost:8080/AProject_keyan/Mng_Servlet?action=queryagain&ide=sys" style="color:black" ><input type="button" value="返回"></a>
				</div>
				</div>
		</div>
		</form>
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