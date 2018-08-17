<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


<!DOCTYPE HTML >
<html>
  <head>
    <script type="text/javascript">
		
		function Msg(){
			setTimeout("$('#add_result').remove()",3000);
			
		}
		Msg();
		
	</script>
    
    <title>部门信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
<script type="text/javascript" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/js/bootstrap.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/js/dropdown.js"></c:url>'></script>

  </head>
  
  <body>
  <br>
  <div class="container ">
  		<span  id="add_result">
		        <c:if test="${result=='success'}">
		            		操作成功，等待审核！
		        </c:if>
	        </span> 
	<div class="row">
  			<a href="department_Lb?operateCode=${operateCode}">添加部门</a>
			<form class="form-inline" action="department_list_detail_request?operateCode=${operateCode}"  id=""  method="post" target="">
				<input type="hidden" name="startPage" value="1">
				<input type="hidden" name="pageSize" value="5">
				<div class="form-group form_select col-md-2 ">
				<select class="form-control "  name="title" id="title">
					<option value="0">查找方式</option>
					<option value="2">部门号</option>
					<option value="3">部门名</option>
					

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
						<td>部门号</td>
						<td>部门名</td>
						<td>联系电话</td>
						<td>状态</td>
						<td>其他</td>
						
					</tr>
					<c:forEach items="${department_list}" var="departmentInfo">
						<tr>
							<td>${departmentInfo.dpCode }</td>
							<td>${departmentInfo.dpName }</td>
							<td>${departmentInfo.dpPhone }</td>
							<c:if test="${departmentInfo.status =='0' }"><td>审查中</td>
							<td><a href="">当前无法操作</a></td></c:if>
							<c:if test="${departmentInfo.status =='1' }"><td>可操作</td>
							<td><a href="department_edit?Code=${departmentInfo.dpCode}&operateCode=${operateCode}">详细信息</a>
								<a href="department_operate?type=detele&Code=${departmentInfo.dpCode}&operateCode=${operateCode}">删除</a></td></c:if>
						</tr>
					</c:forEach>
			</table>
				
			</div>
			<div class="row text-center">
				<div class="col-md-2 col-md-offset-4">
					<a href="department_list_detail_request?operateCode=${operateCode}&title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage-1} "  class="btn btn-primary  active" role="button">上一页</a>
					<a href="department_list_detail_request?operateCode=${operateCode}&title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage+1}"  class="btn btn-primary  active" role="button">下一页</a>
				
				</div>
				
			</div>
		</div>
   	
  </body>

</html>
