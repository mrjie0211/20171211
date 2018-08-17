<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>图书馆后台管理系统</title>
<style type="text/css">
		@import url("<c:url value= "css/bootstrap.min.css"/>");	
		[class^='row main-title']{
    		background: -webkit-linear-gradient(left  top, #2d2d86, #df9fbf);
    		border: 1px solid #ccc;
    		color:white;
    	}
    	.main-title{
    		height:100px;
    	}
</style>
<script type="text/javascript" src='<c:url value="js/jquery.min.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="js/bootstrap.min.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="js/bootstrap.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="js/dropdown.js"></c:url>'></script>
  </head>
  
  <body>
  <div class="container">
			<nav>
				<div class="row main-title"><h1>图书后台管理系统</h1></div>
				<div class="row">
				<ul class="nav nav-tabs ">
					<li><a href="">首页</a></li>
  					<li role="presentation" class="dropdown">
			    		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
			     		借阅信息    <span class="caret"></span>
			    		</a>
			    		<ul class="dropdown-menu">
			     			<li class="list-group-item"><a href="">当前借阅图书</a></li>
			     	 		<li class="list-group-item"><a href="">已归还图书</a></li>
			      			<li class="list-group-item"><a href="">当前已逾期未归还图书</a></li>
			      		</ul>
			  		</li>
			  		<li><a href="book_list_detail_request?operateCode=${operateCode}&key=${key}" target="myFrameName">图书信息</a></li>
			  		<li role="presentation" class="dropdown">
			    		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
			     		系统信息管理 <span class="caret"></span>
			    		</a>
			    		<ul class="dropdown-menu">
			     			<li class="list-group-item"><a href="admin_list_detail_request?operateCode=${operateCode}" target="myFrameName">用户信息</a></li>
			     	 		<li class="list-group-item"><a href="department_list_detail_request?operateCode=${operateCode}" target="myFrameName">部门信息</a></li>
			      			<li class="list-group-item"><a href="juese_list_detail_request?operateCode=${operateCode}" target="myFrameName">角色信息</a></li>
			      			<li class="list-group-item"><a href="assess_list_detail_request?operateCode=${operateCode}" target="myFrameName">审核操作信息</a></li>
			      			<li class="list-group-item"><a href="record_list_detail_request?operateCode=${operateCode}" target="myFrameName">查看操作信息</a></li>
			      		</ul>
			  		</li>
			  		<li><a href="">常见问题</a></li>
			  		<li><a href="">个人信息</a></li>
			  		<li><a href="">联系我们</a></li>
			  		<li><a href="userLogin">退出登录</a></li>
			  		
				</ul>
				</div>
			</nav>
			<div class="row">
				<div class="panel panel-default col-md-3">
	  				<div class="panel-heading">通知公告</div>
	  				<div class="panel-body">
	    			 <ul class="list-group">
					    <li class="list-group-item">Cras justo odio</li>
					    <li class="list-group-item">Dapibus ac facilisis in</li>
					    <li class="list-group-item">Morbi leo risus</li>
					    <li class="list-group-item">Porta ac consectetur ac</li>
					    <li class="list-group-item">Vestibulum at eros</li>
					  </ul>
	  				</div>
	  				<div class="panel-heading">好书推荐</div>
	  				<div class="panel-body">
	    			 <ul class="list-group">
					    <li class="list-group-item">Cras justo odio</li>
					    <li class="list-group-item">Dapibus ac facilisis in</li>
					    <li class="list-group-item">Morbi leo risus</li>
					    <li class="list-group-item">Porta ac consectetur ac</li>
					    <li class="list-group-item">Vestibulum at eros</li>
					    <li class="list-group-item">Vestibulum at eros</li>
					  </ul>
	  				</div>
				</div>
				<div class="panel panel-default col-md-9">
					<!-- 16:9 aspect ratio -->
					<div class="embed-responsive embed-responsive-4by3">
  						<iframe name="myFrameName"  class="embed-responsive-item" src=""></iframe>
					</div>
	  				
				</div>
			</div>
			<footer>
				<div class="row">
					
				</div>
			</footer>
		</div>
    
  </body>
</html>
