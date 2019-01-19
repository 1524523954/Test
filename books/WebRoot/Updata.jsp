<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Updata.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
	<style type="text/css">
		tr{
			text-align:center;
		}
		td{
			text-valign:middle;
		}
	</style>
	<script type="text/javascript">
		function initBook(bookid){
			$.ajax({
				"url"  : "BookServlet" ,
				"type"  : "GET" ,
				"data"  : "opr=selone&id="+bookid ,
				"dataType"  : "json" ,
				"success"  : ifsuccess
			});
		}
		function ifsuccess(result){
			if(result.opr==0){
				alert("您的账号已被删除");
	 			open("index.jsp","_self");
			}else{
				$("#bookid").val(result.id);
				$("#bookname").val(result.bookname);
				$("#bookAuthor").val(result.bookAuthor);
				$("#publicsher").val(result.publicsher);
				$("#pagecount").val(result.pagecount);
				$("#price").val(result.price);
			}
		}
	</script>
	
  </head>
  <body onload="initBook(<%=request.getParameter("id")%>)">
  	<form action="BookServlet?opr=doupdata" method="post">
  	<table border="1" align="center" id="mytable" cellpadding="0" width="600" cellspacing="0">
  			<thead>
  				<tr align="center">
  					<td colspan="2"><h1>修改book</h1></td>
  				</tr>
  				<tr>
  					<td>编号</td>
  					<td><input type="text" readonly="readonly"  id="bookid" name="bookid"/></td>
  				</tr>
  				<tr>
  					<td>书名</td>
  					<td><input type="text" id="bookname" name="bookname"/></td>
  				</tr>
  				<tr>
  					<td>作者</td>
  					<td><input type="text" id="bookAuthor" name="bookAuthor"/></td>
  				</tr>
  				<tr>
  					<td>出版社</td>
  					<td><input type="text" id="publicsher" name="publicsher"/></td>
  				</tr>
  				<tr>
  					<td>页数</td>
  					<td><input type="text" id="pagecount" name="pagecount"/></td>
  				</tr>
  				<tr>
  					<td>价格</td>
  					<td><input type="text" id="price" name="price"/></td>
  				</tr>
  				<tr>
  					<td>操作</td>
  					<td><input type="submit" value="提交"/></td>
  				</tr>
  			</thead>
  	</table>
  	</form>
  </body>
</html>
