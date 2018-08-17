<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'record.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		
		function Msg(){
			setTimeout("$('#add_result').remove()",3000);
			
		}
		Msg();
		
	</script>
	<script type="text/javascript" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
	<style type="text/css">
		@import url("<c:url value= "/css/book_list.css"/>");
		@import url("<c:url value= "/css/bootstrap.min.css"/>");
		
		.result{
			background:#eeeeee;
		}
		.form_select{
			margin-left:-220px;
			
		}
		
	</style>
	

  </head>
  
  <body>
  <br>
  <div class="container ">
	            
  			<div class="row">
  			<a href="">刷新</a>    
			<form class="form-inline" action="record_list_detail_request?operateCode=${operateCode}"  id=""  method="post" target="">
				<input type="hidden" name="startPage" value="1">
				<input type="hidden" name="pageSize" value="10">
				<div class="form-group form_select col-md-2 ">
				<select class="form-control "  name="title" id="title">
					<option value="0">查找方式</option>
					<option value="2">序号</option>
					<option value="3">操作者</option>
					<option value="4">时间</option>
				</select>
				</div>
				<div class="form-group col-md-2">
					<input type="text" name="keyword" class="form-control" value="" placeholder="输入关键字"/>

				</div>
				<div class="form-group col-md-2">
					<input type="submit" value="确定" class="form-control btn-primary">
				</div>
			</form>
			</div>
			<div class="row result">
				<div class="col-md-12">查询结果</div>	
			</div>
			<div class="row text-center">
				<table class="table table-striped table-bordered table-hover">
					<tr class="warning">
						<td>序号</td>
						<td>操作者</td>
						<td>操作时间</td>
						<td>操作内容</td>
					</tr>
					<c:forEach items="${record_list}" var="recordInfo">
						<tr>
							<td>${recordInfo.id }</td>
							<td>${recordInfo.coperator }</td>
							<td>${recordInfo.ctimeshow }</td>
							<td>${recordInfo.ccontent}</td>
							
						</tr>
					</c:forEach>
			</table>
				
			</div>
			<div class="row text-center">
				<div class="col-md-2 col-md-offset-4">
					<a href="record_list_detail_request?operateCode=${operateCode}&title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage-1} "  class="btn btn-primary  active" role="button">上一页</a>
					<a href="record_list_detail_request?operateCode=${operateCode}&title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage+1}"  class="btn btn-primary  active" role="button">下一页</a>
				
				</div>
				
			</div>
		</div> 
  </body>
  </body>
</html>
