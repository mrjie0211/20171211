<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户添加界面</title>
    
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
	
	<script type="text/javascript">
		
		function Msg(){
			setTimeout("$('#add_result').remove()",3000);
			
		}
		Msg();
		
	</script>
	<script type="text/javascript" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/js/bootstrap.js"></c:url>'></script>

  </head>
  
  <body>
  <br>
   <div class="container ">
    <div class="row">
    	
        <div class="col-md-3 col-sm-3 ">
	    	<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
	    	<span class="h2  text-primary">添加用户</span>
	    </div>
	    <div class="col-md-3 col-sm-3 ">
	        <span class="text-success h2" id="add_result">
		        <c:if test="${result=='success'}">
		            		添加成功!
		        </c:if>
	        </span>         
	    </div>    
    </div>
    <br>
    <form id="form" action="admin_operate?type=add&operateCode=${operateCode}" method="post">
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">工号（Code）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" name="Code" class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">密码（Pwd）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="Pwd">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">姓名（Name）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="Name">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">年龄（age）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="age">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">部门（bldepartment）：</label>
                <div class="col-md-4 col-sm-4">
                    <select class="form-control" name="bldepartment">

                        <c:forEach items="${department_Lb}" var="department_Lb">
                        <option value="${department_Lb.dpCode}">${department_Lb.dpName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">角色（juese）：</label>
                <div class="col-md-4 col-sm-4">
                    <select class="form-control" name="juese">

                        <c:forEach items="${juese_Lb}" var="juese_Lb">
                        <option value="${juese_Lb.jsCode}">${juese_Lb.jsName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">学历（education）：</label>
                <div class="col-md-4 col-sm-4">
                    <select class="form-control" name="education">
                    	<option value="研究生" >研究生</option>
                        <option value="本科" >本科</option>
                        <option value="大专" >大专</option>
                        <option value="高中" >高中</option>
                        <option value="初中以及以下" >初中及以下</option>
                        <option value="其他" >其他</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">专业（profession）：</label>
                <div class="col-md-4 col-sm-4">
                    <select class="form-control" name="profession">
                    	<option value="计算机" >计算机</option>
                        <option value="金融" >金融</option>
                        <option value="英语" >英语</option>
                        <option value="管理" >管理</option>
                        <option value="其他" >其他</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">住址（adress）：</label>
                <div class="col-md-8 col-sm-8">
                	 <input type="text" class="form-control" name="adress">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">邮箱（email）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="email">
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
