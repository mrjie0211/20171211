<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>角色修改界面</title>
    
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
		#email,#juese,#sbutton{
		margin-top:0px;
		margin-left:50px;
		}
		
		
	</style>
	<script type="text/javascript" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/js/bootstrap.js"></c:url>'></script>
	<script type="text/javascript">
		
		function Msg(){
			/*var value =  $("#add_result").text();
			if( value != null){
			
				alert("编辑失败");
			}*/
			setTimeout("$('#add_result').remove()",3000);
			
		}
		Msg();
		
	</script>

  </head>
  
  <body>
  <br>
  <div class="container ">
    <div class="row">
    	
        <div class="col-md-3 col-sm-3 ">
	    	<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
	    	<span class="h1  text-primary">编辑角色信息</span>
	    </div>
	    <div class="col-md-3 col-sm-3 ">
	        <span class="text-success h2" id="add_result">
		        <c:if test="${result=='fail'}">
		            		编辑失败!
		        </c:if>
		        <c:if test="${result=='success'}">
		            		编辑成功!
		        </c:if>
	        </span>         
	    </div>    
    </div>
    <br>
    <form id="form" action="juese_operate?type=update&operateCode=${operateCode}" method="post">
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">角色号（JsCode）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" name="JsCode" class="form-control" value=${jueseinfo.jsCode } readonly="readonly">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">角色名（JsName）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="JsName" value=${jueseinfo.jsName }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">权限（JsPower）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="JsPower" value=${jueseinfo.jsPower }>
                </div>
            </div>
        </div>
       
        <div class="row" >
           
                <button type="submit" class="btn-submit btn-primary btn-lg">确定</button>
            	
        </div>
    </form>
</div>
  </body>
</html>