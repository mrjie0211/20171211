<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
		<title>登录</title>
	<style type="text/css">
	@import url("<c:url value= "css/bootstrap.min.css"/>");
	[class^='row main-title']{
    		background: -webkit-linear-gradient(left top, #2d2d86, #df9fbf), url(<c:url value="/img/title.png"></c:url>) center ;
    		
    		border: 1px solid #ccc;
    		color:white;
    	}
    	.main-title{
    		height:100px;
    	}
    	.denglu{
    		color:black;
    		font-size:20px;
    		font-family:"方正正纤黑简体";
    		
    	}
	</style>
	<script type="text/javascript" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/js/bootstrap.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/js/dropdown.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/js/carousel.js"></c:url>'></script>
  </head>
  
  <body>
   <div class="container">
			<div class="row main-title"><h1>图书后台管理系统</h1></div>
			<br>
			<div class="row">
				<div class="col-md-8">
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					  <!-- Indicators -->
					  <ol class="carousel-indicators">
					    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
					  </ol>
					
					  <!-- Wrapper for slides -->
					  <div class="carousel-inner" role="listbox">
					    <div class="item active">
					      <img src="<c:url value="img/1.jpg" ></c:url>" alt="1">
					      <div class="carousel-caption">
					        ...
					      </div>
					    </div>
					    <div class="item">
					      <img src="<c:url value="img/2.jpg" ></c:url>"  alt="2">
					      <div class="carousel-caption">
					      	
					      </div>
					    </div>
					     <div class="item">
					      <img src="<c:url value="img/3.jpg" ></c:url>" alt="3">
					      <div class="carousel-caption">
					      
					      </div>
					    </div>
					    
					  </div>
					
					  <!-- Controls -->
					  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel panel-default">
					  <div class="panel-heading text-center "><h4 class="denglu">登录界面</h4></div>
					  <div class="panel-body">
					    <form  action="CheckUser"  Method="post" >
					    	<div class="form-group">
						    <label for="exampleInputuserName">用户名</label>
						    <input type="text" class="form-control"  name="userCode" placeholder="userName">
						  	</div>
						  	<div class="form-group">
						    <label for="exampleInputPassword1">密码</label>
						    <input type="password" class="form-control"  name="pwd" placeholder="Password">
						  	</div>
						  	<div class="checkbox">
						    <label>
						      <input type="checkbox" name="state"> 下次自动登录						    </label>
						 	 </div>
						 	 <div class="form-group">
						    
						    <input type="submit" class="form-control btn btn-default" value="登录" >
						  	</div>
						  	<div class="row text-center">
						  		
						  		<a href="">忘记密码？</a>
						  		<a href="">注册</a>
						  		
						  	</div>
					    		
					    </form> 	
					  </div>
					</div>
					
				</div>
			</div>
		</div>
  </body>
</html>
