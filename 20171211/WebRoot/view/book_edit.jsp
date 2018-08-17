<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


<!DOCTYPE HTML>
<html>
  <head>
    
    
    <title>My JSP 'book_edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		
		@import url("<c:url value= "/css/bootstrap.min.css"/>");
		
		
		
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
	    	<span class="h2  text-primary">编辑图书</span>
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
    <form id="form" action="book_save_edit.spring" method="post">
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">条码（BookCode）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" name="bookCode" class="form-control" value=${bookInfo.bookCode } readonly="readonly">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">图书名（BookName）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="bookName" value=${bookInfo.bookName }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">索书号（Booktpip）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="booktpip" value=${bookInfo.booktpip }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">作者（Author）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="author" value=${bookInfo.author }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">馆藏地（Position）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="position" value=${bookInfo.position }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">出版社（Cbs）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="cbs" value=${bookInfo.cbs }>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">内容简介（Content）：</label>
                <div class="col-md-8 col-sm-8">
                    <textarea class="form-control" name="content" cols="30" rows="6" >${bookInfo.content }</textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">类别（Lb）：</label>
                	<div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="lb" value=${bookInfo.lb }>
                	</div>
                	<!-- <div class="col-md-4 col-sm-4">
                    <select class="form-control" name="Lb">

                        <c:forEach items="${book_Lb}" var="book_Lb">
                        <option value="${book_Lb.code}">${book_Lb.className}</option>
                        </c:forEach>
                    </select>
                </div>
                 -->
            </div>
        </div>
        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">Isbn（Isbn）：</label>
                <div class="col-md-8 col-sm-8">
                    <input type="text" class="form-control" name="isbn" value=${bookInfo.isbn }>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="cont-wrapper row">
                <label class="col-md-3 col-sm-3">上传图片</label>
                <div class="col-md-8 col-sm-8">
                    <!-- <div id="preview">
                                    <img id="avatar-img"  onclick="$('#previewImg').click();" src="" width="90" height="90">
                                </div>
                                    <input type="file" onchange="previewImage(this)" style="display: none;" id="previewImg" name="product_img">  -->
                    <input type="file" name="product_img">
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
