<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'youxiang.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function inityouxiang(){
			$.get("BookServlet","opr=zhuce",ifsuccess,"text");
			
		}
		function ifsuccess(result){
			var $div1 = $("#div1");
			$div1.html(result);
		}
	</script>
  </head>
  
  <body>
  	<table>
  		<tr>
  			<td>注册邮箱:</td>
  			<td><input type="text" name="zcyx" onblur="inityouxiang()"/></td>
  			<td><span style="color: B20DF7">*</span>
  			<div id="div1" style="display: none"></div></td>
  		</tr>
  		<tr>
  			<td>用户名:</td>
  			<td><input type="text" name="name"/></td>
  			<td><span style="color: B20DF7">*</span>
  			<div id="div2" style="display: none"></div></td>
  		</tr>
  		<tr>
  			<td>密码:</td>
  			<td><input type="text" name="pwd"/></td>
  			<td><span style="color: B20DF7">*</span>
  			<div id="div3" style="display: none"></div></td>
  		</tr>
  	</table>
  </body>
</html>
