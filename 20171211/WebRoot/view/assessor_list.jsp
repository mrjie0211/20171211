<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>审核表</title>
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
			<form class="form-inline" action="assess_list_detail_request?operateCode=${operateCode}"  id=""  method="post" target="">
				<input type="hidden" name="startPage" value="1">
				<input type="hidden" name="pageSize" value="10">
				<div class="form-group form_select col-md-2 ">
				<select class="form-control "  name="title" id="title">
					<option value="0">查找方式</option>
					<option value="2">操作员</option>
					<option value="3">操作的表格</option>
					<option value="4">操作类型</option>
					<option value="5">操作时间</option>

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
				<div class="col-md-12">需要审核的信息</div>	
			</div>
			<div class="row text-center">
				<table class="table table-striped table-bordered table-hover">
					<tr class="warning">
						<td>序号</td>
						<td>操作者</td>
						<td>操作的表格</td>
						<td>操作类型</td>
						<td>操作内容</td>
						<td>操作时间</td>
						<td>审核</td>
					</tr>
					<c:forEach items="${assessor_list}" var="assessorInfo">
						<tr>
							<td>${assessorInfo.id }</td>
							<td>${assessorInfo.coperator }</td>
							<td>${assessorInfo.ctable }</td>
							<td>${assessorInfo.ctype }</td>
							<td>${assessorInfo.ccontent }</td>
							<td>${assessorInfo.ctimeshow }</td>
							<td><c:if test="${assessorInfo.ctype=='删除' }">
							<a href="assessor_operate?type=detelesure&id=${assessorInfo.id }&ctable=${assessorInfo.ctable }&
							ctable_key=${assessorInfo.ctable_key }&ctable_key_value=${assessorInfo.ctable_key_value }&operateCode=${operateCode}">√</a>
							<a href="assessor_operate?type=deteleno&id=${assessorInfo.id }&ctable=${assessorInfo.ctable }&
							ctable_key=${assessorInfo.ctable_key }&ctable_key_value=${assessorInfo.ctable_key_value }&operateCode=${operateCode}">×</a>
							</c:if>
							<c:if test="${assessorInfo.ctype=='修改' }">
							<a href="assessor_operate?type=updatesure&id=${assessorInfo.id }&ctable=${assessorInfo.ctable }&
							ctable_key=${assessorInfo.ctable_key }&ctable_key_value=${assessorInfo.ctable_key_value }&operateCode=${operateCode}">√</a>
							<a href="assessor_operate?type=updateno&id=${assessorInfo.id }&ctable=${assessorInfo.ctable }&
							ctable_key=${assessorInfo.ctable_key }&ctable_key_value=${assessorInfo.ctable_key_value }&operateCode=${operateCode}">×</a>
							</c:if>
							<c:if test="${assessorInfo.ctype=='添加' }">
							<a href="assessor_operate?type=addsure&id=${assessorInfo.id }&ctable=${assessorInfo.ctable }&
							ctable_key=${assessorInfo.ctable_key }&ctable_key_value=${assessorInfo.ctable_key_value }&operateCode=${operateCode}">√</a>
							<a href="assessor_operate?type=addno&id=${assessorInfo.id }&ctable=${assessorInfo.ctable }&
							ctable_key=${assessorInfo.ctable_key }&ctable_key_value=${assessorInfo.ctable_key_value }&operateCode=${operateCode}">×</a>
							</c:if></td>
						</tr>
					</c:forEach>
			</table>
				
			</div>
			<div class="row text-center">
				<div class="col-md-2 col-md-offset-4">
					<a href="assess_list_detail_request?title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage-1}&operateCode=${operateCode} "  class="btn btn-primary  active" role="button">上一页</a>
					<a href="assess_list_detail_request?title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage+1}&operateCode=${operateCode}"  class="btn btn-primary  active" role="button">下一页</a>
				
				</div>
				
			</div>
		</div> 
   
  </body>
</html>
