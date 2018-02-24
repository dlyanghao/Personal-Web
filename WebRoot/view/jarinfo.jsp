<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jar Information</title>
        <script src="../js/jquery/jquery-3.2.1.js" type="text/javascript"></script>
    	<script src="../js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
    	<link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
    	<link rel="stylesheet" href="../css/project/jarinfo.css"/>
    	<script>
    		
    		//更新操作
    		var i=false;
    		function update(element,id){
    		
    			if(!i){
				var ele = $(element).parent().parent();
    			var tr = $("<tr id='newInput'>"+
    			"<td class='text-center success'><input class='form-control' type='text' placeholder='包名'/></td>"+
    			"<td class='text-center warning'><input class='form-control' type='text' placeholder='模块'/></td>"+
    			"<td class='text-center danger'><input class='form-control' type='text' placeholder='描述'/></td>"+
    			"<td class='text-center info'><input class='form-control' type='text' placeholder='日期'/></td>"+
    			"<td class='text-center success'><a class='btn btn-default btn-success'>重置</a></td>"+
    			"<td class='text-center danger'><a class='btn btn-default btn-danger'>提交</a></td>"+
    			"</tr>");
    			ele.after(tr);
    			i=true;
    			}
    			else
    			{
    				$("#newInput").remove();
    				i=false;
    			}
    		}
    		
    		
    		$(function(){
    			//初始化时隐藏更新表单
    			$("#addJar").hide();
    			//注册点击响应事件
    			$("#package").click(function(){
    				$("#addJar").toggle("slow");
    			});
    			
    			//设置添加jar包表单按钮的点击事件
    			$("#addReset").click(function(){
    				$(".addflag").val("");
    			});
    			$("#addSubmit").click(function(){
    				$("#addForm").submit();
    			});
    		});
    		
    		
    		
    		
    	</script>
    </head>
    <body>
    	<div class="header">
			<div class="wrapper">
				<div class="christmas-tree tree1"></div>
				<div class="christmas-tree tree2"></div>
				<div class="christmas-tree tree3"></div>
			  <div class="snowman"></div>	
				<div class="christmas-tree tree4"></div>
				<div class="christmas-tree tree5"></div>
				<div class="christmas-tree tree6"></div>
			</div>
		</div>
	    <div class="container">
	    	<table class="table table-hover table-striped">
	    		<thead>
	    			<tr class="bg-primary">
	    				<th id="package" class="text-center col-md-4"><kbd>包名(单击添加新包)</kbd></th>
	    				<th class="text-center col-md-1"><kbd>所属模块</kbd></th>
	    				<th class="text-center col-md-4"><kbd>包描述</kbd></th>
	    				<th class="text-center col-md-1"><kbd>更新日期</kbd></th>
	    				<th class="text-center col-md-1"><kbd>更新</kbd></th>
	    				<th class="text-center col-md-1"><kbd>删除</kbd></th>
	    			</tr>
	    		</thead>
	    		<tbody>
					<form id="addForm" action="${pageContext.request.contextPath }/jarInfo?do=addjar" method="post">
						<div id="addJar" class="container-fluid">
							<div class="row">
								<div class="col-md-4"> 
									<input name="name" class="form-control addflag" type="text" placeholder="新包名"/>
								</div>
								<div class="col-md-1">
									<input name="module" class="form-control addflag" type="text" placeholder="模块"/>
								</div>
								<div class="col-md-4">
									<input name="description" class="form-control addflag" type="text" placeholder="包描述"/>
								</div>
								<div class="col-md-1">
									<input name="updateTime" class="form-control addflag" type="text" placeholder="日期"/>
								</div>
								<div class="col-md-1">
									<a id="addReset" class="btn btn-default btn-primary">重置</a>
								</div>
								<div class="col-md-1">
									<a id="addSubmit" class="btn btn-default btn-danger">提交</a>
								</div>
							</div>
						</div>
					</form>
					
					<hr />
	    			
	    			<c:forEach items="${jarFilesPage.list}" var="jarbean">
						<tr>
	    					<td class="text-center success">${jarbean.name}</td>
	    					<td class="text-center warning">${jarbean.module}</td>
	    					<td class="text-center danger">${jarbean.description}</td>
	    					<td class="text-center info">${jarbean.updateTime}</td>
	    					<td class="text-center success">
	    						<a id="updateBtn" class="btn btn-default btn-success" onclick="update(this,${jarbean.id})">Update</a>
	    					</td>
	    					<td class="text-center danger">
	    						<a class="btn btn-default btn-danger" href="#">Delete</a>
	    					</td>
	    				</tr>
		        	</c:forEach>
	    		</tbody>
	    	</table>
   			<nav>
			  <ul class="pagination">
			  	<c:if test="${!(jarFilesPage.currentPage==1) }">
			  		<li>
				      <a href="${pageContext.request.contextPath }/jarInfo?do=lookup&currentPage=${jarFilesPage.currentPage-1}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			  	</c:if>
			    <c:forEach begin="1" end="${jarFilesPage.pageNumber }" var="i">
			    	<c:if test="${jarFilesPage.currentPage==i}">
			    		<li><a disable="disable">${i}</a></li>
			    	</c:if>
			    	<c:if test="${!(jarFilesPage.currentPage==i)}">
			    		<li><a href="${pageContext.request.contextPath }/jarInfo?do=lookup&currentPage=${i}">${i}</a></li>
			    	</c:if>
			    </c:forEach>
			    <c:if test="${!(jarFilesPage.currentPage==jarFilesPage.pageNumber) }">
			    	<li>
				      <a href="${pageContext.request.contextPath }/jarInfo?do=lookup&currentPage=${jarFilesPage.currentPage+1}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
			    </c:if>
			    
			  </ul>
			</nav>
	    </div>
 	</body>
</html>