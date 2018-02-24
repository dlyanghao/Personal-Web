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
    
    <title>实现下载和上传文件功能,显示进度</title>
	<meta charset="UTF-8">
	<script type="text/javascript" src="js/jquery/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/project/forbid.js"></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css">
	<style type="text/css">
			.textStyle{
				font-family: "微软雅黑"
			},
			
			a{
				text-decoration: none;
			}
	</style>
	<script type="text/javascript">
	$(function(){
		$("#refresh").click(function(){
			$.post("filesReflesh");
			window.location.reload();
		});
	//使用定时器每隔100毫秒发送异步请求检测当前文件的下载进度，并在进度条上显示
		var id = setInterval(function(){
			$.get("downloadSize",{},function(date){
				if(date=="")
				{
					date = "0";
				}
				var state = date+"%";
				$(".progress-bar").text(state);	
				$(".progress-bar").prop("aria-valuenow",date).prop("style","width: "+state);
			if(date == "100")
				{
					clearInterval(id);
				}
			});
		},100);
		
	//如何通过js获取后台的数据？疑问
	/*
		var datas = $("#datas");
		var str = datas.val();
		var list = str.substring(1,str.length-1);
		var arr = list.split(", ");
		$.each(arr,function(n,value){
			var $li = $("<li></li>");
			var $a = $("<a></a>");
			$a.text(value);
			var action = "download?downfilename="+value;
			$a.prop("href",action);
			$li.append($a);
			//$node.attr("filename",value);
			var $span = $("<span class='badge'>0</span>");
			$li.append($span);
			$li.addClass("list-group-item");
			$("ul").append($li);
		});
		*/
		/*$("li").click(function(){
				
				var filename = $(this).attr("filename");
				//设置请求的页面或者动作，参数
				$.get("Download",{downfilename:filename},function(data){alert(data);});
			});*/
		
		
	});	
	</script>
  </head>
  <body>
  	<div class="container"> 
			<h1 class="text-center textStyle">请选择你要下载的文件</h1>
			<div>
				<ul class="list-group">
					<c:forEach items="${allFilesName}" var="item">
						<li class="list-group-item">
							<a href="download?downfilename=${item}">${item}</a>
							<span class='badge'>0</span>
						</li>
					</c:forEach>
				</ul>
			</div>
			<input type="button" id="refresh" class="btn btn-block btn-danger" value="刷新下载文件"/>
			<p class="text-center text-warning"><strong>下载进度</strong></p>
			<div class="progress">
			  <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
			    0%
			  </div>
			</div>
		</div>
  </body>
</html>