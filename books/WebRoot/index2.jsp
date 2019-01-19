<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
	<script type="text/javascript">
		function initbook(){
			$.get("BookServlet","opr=boolist",ifsuccess,"html");
		}
		
		function ifsuccess(result){
			/* var $myul = $("#myul");
			$(result).each(function (){
				$myul.append("<li>"+this.id+" --  "+this.bookname+"  -- "+this.bookAuthor+"  -- "+this.publicsher+
				"  -- "+this.pagecount+"  -- "+this.price+"  -- "+"</li>");
			
			}); */
			$("#myul").append(result);
		} 
	
	</script>
  </head>
  <body onload="initbook()">
  		<ul id="myul">
  		</ul>
  		<!-- <script type="text/javascript">
  			$("#myul").load(url,data);
  		</script> -->
  </body>
</html>
