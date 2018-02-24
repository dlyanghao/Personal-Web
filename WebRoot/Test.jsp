<%@page import="com.yanghao.utils.CookieUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>很高兴遇到你</title>
    <meta charset="UTF-8">

	<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
	<link href="css/project/login.css" rel="stylesheet">
	
	<script src="js/jquery/jquery-3.2.1.js" type="text/javascript"></script>
	
	<script type="text/javascript" src="js/sketch/sketch.min.js"></script>
	<script type="text/javascript" src="js/sketch/mousefun.js"></script>
	
	
	<script src="js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery/jquery.validate.js"></script>		
	<script type="text/javascript" src="js/jquery/messages_zh.js"></script>
	<script type="text/javascript" src="js/jquery/popover.js"></script>
	<script type="text/javascript" src="js/pop/plug-in.js"></script>
	<script type="text/javascript" src="js/project/login.js"></script>
  </head>
  <%
  	  //显示验证码输入情况
      //获取请求中的验证码值(用户填入)，如果是第一次
  	  String vCodeTip = request.getParameter("vCode");
  	  String vCodeClass = "";
  	  if(vCodeTip == null)
  	  {
  	  	vCodeTip = "";
  	  }
  	  else
  	  {
  	  	vCodeTip = "验证码错误";
  	  	vCodeClass = "has-error";
  	  }
  
	  String username = CookieUtil.getCookieValue("username", request);
	  String checkStr = "";
	  if(username == null)
	  {
	  	username="";
	  }
	  else
	  {
	  	checkStr = "checked=true";
	  }
  %>
  
  <body>
	<div id="background" style="background-color:#00FFFF;">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		     <div class="container">
		       <div class="navbar-header">
		         <button type="button" class="navbar-toggle collapsed">
		           <span class="icon-bar"></span>
		           <span class="icon-bar"></span>
		           <span class="icon-bar"></span>
		         </button>
		         <a class="navbar-brand" href="#">@YangHao</a>
		       </div>
		       <div id="navbar" class="navbar-collapse collapse">
		         <form id="registerForm" class="navbar-form navbar-right" method="post" action="register">
		           <div class="form-group">
		             <input name="registerName" type="text" placeholder="用户名" class="form-control" data-toggle="popover">
		           </div>
		           <div class="form-group">
		             <input name="registerPsd" type="password" placeholder="用户密码" class="form-control" data-toggle="popover">
		           </div>
		           <button type="submit" class="btn btn-success">注册</button>
		         </form>
		       </div><!--/.navbar-collapse -->
		     </div>
		  </nav>

    	<HR style="border: 5 dotted #987cb9" width="100%" color=#FFFF00 SIZE=1>
		
		<div class="container" style="border-radius:15px; border:1px solid #000;background-color:#FFFF00;">

			<form id="loginForm" class="form-horizontal" action="login" method="post">
				<div class=form-group>
					<div class="col-sm-6">
						<h2 class="form-signin-heading text-center">欢迎！</h2>
					</div>
				</div>
				
				<div class="form-group has-feedback has-warning">
					<div class="col-sm-6 ">
						<label for="inputEmail" class="sr-only">你的账号</label>
						<input name="username" type="text" id="inputEmail" class="form-control input-lg" placeholder="你的账号"  autofocus required value=<%=username %> >
						<span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
					</div>
				</div>
				
				<div class="form-group has-feedback has-warning">
					<div class="col-sm-6">
						<label for="inputPassword" class="sr-only">你的密码</label>
	        			<input name="password" type="password" id="inputPassword" class="form-control input-lg" required placeholder="你的密码">
	        			<span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
					</div>
				</div>
				
				<div class="form-group has-feedback has-warning">
					<div class="col-sm-4">
						<label for="inputVCode" class="sr-only">验证码</label>
	        			<input name="vCode" type="text" id="inputVCode" class="form-control" required placeholder="请输入验证码">
	        			<span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
					</div>
					<div class="text-center col-sm-2">
		        		<img id="vCodeId" class="img-responsive" style="border-radius:5px;border:1px solid #000" height=100% src="vCode">
		        	</div>
				</div>
				
	        	<div class="row">
	        		<div class="col-sm-5">
	        			<input type="checkbox" name="remember" value="remember-me" <%=checkStr %> > 记住我
	        		</div>
	        		<div class="col-sm-7">
						<span><%=vCodeTip %></span>
					</div>
	        	</div>
		        
		        <div class="row">
		        	<div class="col-sm-6">
		        		<HR style="border: 1 double #987cb9" width="100%" align="left" color=#FFFFFF SIZE=1>
		        	</div>
		        </div>
		        
	        	<div class="row">
					<div class="col-sm-6">
						<button class="btn btn-lg btn-info btn-block" type="submit">登录</button>
					</div>
				</div>       	
			</form>
		</div>
	</div>
</body>
</html>