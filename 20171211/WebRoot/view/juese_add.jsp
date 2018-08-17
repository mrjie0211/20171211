<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>角色添加界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		
		@import url("<c:url value= "/css/bootstrap.min.css"/>");
	
		
		
		
	</style>
	
	<script type="text/javascript" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/js/bootstrap.js"></c:url>'></script>

  </head>
  
  <body>
    <div class="container ">
    <div class="row">
    	
        <div class="col-md-3 col-sm-3 ">
	    	<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
	    	<span class="h2  text-primary">添加角色</span>
	    </div>
   
    </div>
    <br>
    <form id="form" action="juese_operate?type=add&operateCode=${operateCode}" method="post">
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">角色号（JsCode）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" name="JsCode" class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">角色名（JsName）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="JsName">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">权限（JsPower）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="JsPower">
                </div>
            </div>
        </div>
        <div class="row">
           
                <button type="submit" class="btn-submit btn-primary btn-lg">确定</button>
            	
        </div>
    </form>
</div>
  </body>
</html>