<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Success</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css">
	<link rel="sthlesheet" type="text/css" href="css/project/registerSuccess.css">
	<style type="text/css">
		.absolute{
			position:absolute;
			z-index:1;
		}
		
		.page{
			width:100%;
			height:100%;
		 	left:50%;
		 	top:50%;
		 	margin-top:-50px;
		 	margin-left:-50px;
		}
		.textCenter{
			width:100%;
			height:100%;
		 	left:50%;
		 	top:50%;
		 	margin-top:30px;
		 	margin-left:-120px;
		}
	
	</style>
	
	<script type="text/javascript" src="js/jquery/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/sketch/sketch.min.js"></script>
	<script type="text/javascript" src="js/sketch/mousefun.js"></script>

  </head>
  
  <body>
  	<div id="background" style="background-color:#00FFFF;">
  		<h1 class="absolute textCenter">恭喜你，注册成功！</h1>
		<div class="absolute page">
			<a class="btn btn-lg btn-success" href="${pageContext.request.contextPath}/login.jsp">点击返回登陆</a>
		</div>	
  	</div>
  </body>
</html>
