<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


<!DOCTYPE HTML>
<html>
  <head>
    
    
    <title>图书界面</title>
	
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
  <div class="container " >
  			<div class="row">
  			<a href="book_Lb">添加图书</a>
			<form class="form-inline" action="book_list_detail_request"  id=""  method="post" target="">
				<input type="hidden" name="startPage" value="1">
				<input type="hidden" name="pageSize" value="10">
				<img src="<c:url value="img/findbook.png" ></c:url>" width="30px" height="30px">
				<div class="form-group form_select col-md-2 ">
				<select class="form-control "  name="title" id="title">
					<option value="0">查找方式</option>
					<option value="2">书名</option>
					<option value="3">作者</option>
					<option value="4">出版社</option>

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
						<td>图书名称</td>
						<td>作者</td>
						<td>出版社</td>
						<td>状态</td>
						<td>索书号</td>
						<td>其他</td>
					</tr>
					<c:forEach items="${book_list}" var="bookInfo">
						<tr>
							<td>${bookInfo.bookCode }</td>
							<td>${bookInfo.bookName }</td>
							<td>${bookInfo.author }</td>
							<td>${bookInfo.cbs }</td>
							<td>${bookInfo.bookStatus }</td>
							<td>${bookInfo.booktpip }</td>
							<td><a href="book_edit?BookCode=${bookInfo.bookCode}">详细信息</a></td>
						</tr>
					</c:forEach>
			</table>
				
			</div>
			<div class="row text-center">
				<div class="col-md-2 col-md-offset-4">
					<a href="book_list_detail_request?title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage-1} "  class="btn btn-primary  active" role="button">上一页</a>
					<a href="book_list_detail_request?title=${title}&keyword=${keyword}&pageSize=${pageSize}&startPage=${startPage+1}"  class="btn btn-primary  active" role="button">下一页</a>
				
				</div>
				
			</div>
		</div> 
  </body>
  
</html>
