<%@ page contentType="text/html;charset=GBK" %>
<!DOCTYPE html>
<html>
 <head> 
   	<title>登录</title>
   	<meta http-equiv="content-type" content="text/html; charset=gbk"/>
  	<link type="text/css" rel="stylesheet" href="/css/bootstrap/bootstrap.min.css"/>
  	<link type="text/css" rel="stylesheet" href="/css/supersized/supersized.css"/>
  	<link type="text/css" rel="stylesheet" href="/css/style.css"/>
	<script type="text/javascript" src="/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/jquery/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="/js/supersized/supersized.3.2.7.min.js"></script>
	<script type="text/javascript" src="/js/login.js"></script>
 </head>
<body>
	<div class="page-container">
		<h1>Sign in</h1>
		<form action="" method="post">
			<input type="text" name="username" placeholder="用户名">
			<input type="password" name="password" placeholder="密码">
			<button class="submit">提交</button>
			<div class="error"><span>+</span></div>
		</form>
		<div class="connect">
			<p>Or connect with by</p>
			<p>
			   	<a class="facebook" href="#"></a>
				<a class="twitter" href="#"></a>
			</p>
		</div>
	</div>

</body>
</html>
