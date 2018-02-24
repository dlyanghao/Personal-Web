<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'webstatus.jsp' starting page</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">

  </head>
  
  <body>
  <h1>服务器开启至今总访问(即总请求request)次数</h1>
  <p>总请求次数为：${applicationScope.requestCount}</p>
  <h1>统计当前在线人数（包括游客和用户）</h1>
  <p>登陆的用户:${applicationScope.loginUsers}</p>
  <p>在线的用户:${applicationScope.onlineUsers }</p>
  <h1></h1>
  
  
    
  </body>
</html>
