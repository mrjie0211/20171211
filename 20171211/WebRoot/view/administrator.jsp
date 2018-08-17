<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户界面</title>
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
	        <span  id="add_result">
		        <c:if test="${result=='success'}">
		            		操作成功，等待审核！
		        </c:if>
	        </span>         
  			<div class="row">
  			<a href="admin_Lb?operateCode=${operateCode}">添加用户</a>    
			<form class="form-inline" action="admin_list_detail_request"  id=""  method="post" target="">
				<input type="hidden" name="startPage" value="1">
				<input type="hidden" name="pageSize" value="10">
				<div class="form-group form_select col-md-2 ">
				<select class="form-control "  name="title" id="title">
					<option value="0">查找方式</option>
					<option value="2">工号</option>
					<option value="3">姓名</option>
					<option value="4">所属部门</option>
					<option value="5">角色</option>

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
						<td>工号</td>
						<td>姓名</td>
						<td>年龄</td>
						<td>密码</td>
						<td>部门</td>
						<td>角色</td>
						<td>状态</td>
						<td>其他</td>
					</tr>
					<c:forEach items="${admin_list}" var="admininfo">
						<tr>
							<td>${admininfo.code }</td>
							<td>${admininfo.name }</td>
							<td>${admininfo.age }</td>
							<td>${admininfo.pwd }</td>
							<td>${admininfo.bldepartment }</td>
							<td>${admininfo.juese }</td>
							<c:if test="${admininfo.status =='0' }"><td>审查中</td>
							<td><a href="">当前无法操作</a></td></c:if>
							<c:if test="${admininfo.status =='1' }"><td>可修改</td>
							<td><a href="admin_edit?Code=${admininfo.code}&operateCode=${operateCode}">详细信息</a>
								<a href="admin_operate?type=detele&Code=${admininfo.code}&operateCode=${operateCode}">删除</a></td></c:if>
							
						</tr>
					</c:forEach>
			</table>
				
			</div>
			<div class="row text-center">
				<div class="col-md-2 col-md-offset-4">
					<a href="admin_list_detail_request?operateCode=${operateCode}&title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage-1} "  class="btn btn-primary  active" role="button">上一页</a>
					<a href="admin_list_detail_request?operateCode=${operateCode}&title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage+1}"  class="btn btn-primary  active" role="button">下一页</a>
				
				</div>
				
			</div>
		</div> 
  </body>
</html>
