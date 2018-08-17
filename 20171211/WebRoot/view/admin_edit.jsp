<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'admin_edit.jsp' starting page</title>
    
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
	    	<span class="h1  text-primary">编辑员工信息</span>
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
    <form id="form" action="admin_operate?type=update&operateCode=${operateCode}" method="post">
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">工号（Code）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" name="Code" class="form-control" value=${admininfo.code } readonly="readonly">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">密码（Pwd）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="Pwd" value=${admininfo.pwd }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">姓名（Name）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="Name" value=${admininfo.name }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">部门（bldepartment）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="bldepartment" value=${admininfo.bldepartment }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">学历（education）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="education" value=${admininfo.education }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">专业（profession）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="profession" value=${admininfo.profession }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">年龄（age）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="age" value=${admininfo.age }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">住址（adress）：</label>
                	<div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="adress" value=${admininfo.adress }>
                	</div>
                </div>
                
            </div>
        </div>
        <div class="row" id="juese">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">角色（juese）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="juese" value=${admininfo.juese }>
                </div>
            </div>
        </div>
        <div class="row" id="email">
              <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">邮箱（email）：</label>
              <div class="col-md-8 col-sm-8">
                   <input type="text" class="form-control" name="email" value=${admininfo.email }>
                </div>
            </div>
        </div>
        <div class="row" id="sbutton">
           
                <button type="submit" class="btn-submit btn-primary btn-lg">确定</button>
            	
        </div>
    </form>
</div>
  </body>
</html>
