<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>你的世界</title>
    <meta charset="UTF-8">
  	<script src="js/jquery/jquery-3.2.1.js" type="text/javascript"></script>
  	<script type="text/javascript" src="js/project/forbid.js"></script>
    <script src="js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/project/index.css">
  </head>
  
  <body>
     <nav class="navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath }/view/index2.jsp">
            <c:if test="${empty sessionScope.user.description }">
            	你好游客
            </c:if>
            <c:if test="${not empty sessionScope.user.description }">
            	${sessionScope.user.description}的世界
            </c:if>
            </a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">主页</a></li>
              <li><a href="#">关于</a></li>
              <li><a href="#">更多</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的足迹 <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">行动</a></li>
                  <li><a href="#">日志</a></li>
                  <li><a href="view/webstatus.jsp">繁荣山丘</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">规划</li>
                  <li><a href="jarInfo?do=lookup&currentPage=1">进度</a></li>
                  <li><a href="view/download.jsp">夹克</a></li>
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="active"><a href="./">世界 <span class="sr-only">(current)</span></a></li>
              <li><a href="../navbar-static-top/">联系我</a></li>
              <li><a href="loginOut">退出</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>


    
    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>文件服务</h2>
          <p>页面中包含了服务器中所有可下载的文件，你可以通过点击文件名进行下载</p>
          <p><a class="btn btn-default" href="view/download.jsp" role="button">查看细节 &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>信息查询</h2>
          <p>页面包含了开发中用到的jar包，内容随着学习不断添加，点击包名也可以直接下载最新的jar包/未完成</p>
          <p><a class="btn btn-default" href="jarInfo?do=lookup&currentPage=1" role="button">查看细节 &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>待添加</h2>
          <p>这是等待添加的功能</p>
          <p><a class="btn btn-default" href="#" role="button">查看细节 &raquo;</a></p>
        </div>
      </div>
    
  </body>
</html>
