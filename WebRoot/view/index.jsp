<%@ page contentType="text/html;charset=GBK" %>
<!DOCTYPE html>
<html>
<head> 
<title></title>
<meta http-equiv="content-type" content="text/html; charset=gbk"/>
</head>
<body>
<div>
	<a>这是主页</a>
	<a href="/index2.do">跳转到页面2</a>
    <button onclick="window.location = '/index2.do'">跳转到主页2</button>
    <button onclick="location = '/index2.do'">跳转到主页2</button>
    <button onclick="location.href = '/index2.do'">跳转到主页2</button>
    <button onclick="window.open('/index2.do')">跳转到主页2</button>
</div>
</body>
</html>
