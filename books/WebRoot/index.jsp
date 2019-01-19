<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
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
	function initready(index) {
		var $sel = $("#sel").val();
		var $sele_gjz = $("#sele_gjz").val();
		$.getJSON("BookServlet","opr=login&sele_gjz="+$sele_gjz+"&sele_type="+$sel+"&pageindex=" + index,ifsuccess);
	}
	function ifsuccess(result) {
		$("#mytable tbody").empty();
		$("#myaa").empty();
		var $div = $("#mytable tbody");
		if(result==false){
			$div.append("<tr align=\"center\"><td colspan=\"7\"><h3>此查询无值,请核对数据库</h3></td></tr>");
		}else{
		var $myaa = $("#myaa");
		if (result.pageIndex > 1) {
				$myaa.append("<a href=\"javascript:initready(1);\">首页</a><a href=\"javascript:initready("
							+ (result.pageIndex - 1) + ");\">上一页</a>");
		}
		$myaa.append("<span>[" + result.pageIndex + "/" + result.pageCount
				+ "]</span>");
		if (result.pageIndex < result.pageCount) {
			$myaa.append("<a href=\"javascript:initready("
					+ (result.pageIndex + 1)
					+ ");\">下一页</a><a href=\"javascript:initready("
					+ result.pageCount + ");\">尾页</a>");
		}
		var $palist = result.pageList;
		$($palist).each(function() {
					$div.append("<tr align=\"center\"><td>" + this.id
							+ "</td><td>" + this.bookname + "</td><td>"
							+ this.bookAuthor + "</td>" + "<td>"
							+ this.publicsher + "</td><td>" + this.pagecount
							+ "</td><td>" + this.price
							+ "</td><td><a href=\"javascript:delBystuid("+ this.id +","+result.pageIndex+")\">删除</a><a href=\"Updata.jsp?id="
							+ this.id + "\">修改</a></td></tr>");
				});
		}
	}
	/*删除调用函数*/
	function delBystuid(stuid,pagecount) {
		$.ajax({
			"url" : "BookServlet",
			"type" : "GET",
			"data" : "opr=del&pagecount="+pagecount+"&stuid=" + stuid,
			"dataType" : "json",
			"success" : delsuccess
		});
	}
	/* 删除成功后调用函数*/
	function delsuccess(result) {
			if (result.opr == "true") {
				alert("删除成功！！");
				initready(result.pagecount);
			} else {
				alert("删除失败！！");
				initready(result.pagecount);
			}
	}
</script>
</head>

<body onload="initready(1);">
	<div id="mydiv">
		<table border="1" id="mytable" cellpadding="0" width="600"
			cellspacing="0">
			<thead>
				<tr align="center">
					<td colspan="7"><h1>图书查询</h1>
					</td>
				</tr>
				<tr align="center">
					<td colspan="7">
					<select name="sele_type" id="sel">
						<option value="bookName">书名</option>
						<option value="bookAuthor">作者</option>
						<option value="publicsher">出版社</option>
					</select>
					&nbsp;&nbsp;&nbsp;<input type="text" id="sele_gjz" name="sele_gjz"/>
					&nbsp;&nbsp;&nbsp;<input type="button" value="查询" id="mybut" onclick="initready(1)"/>
					</td>
				</tr>
				<tr>
					<th>序号</th>
					<th>书名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>页数</th>
					<th>价格</th>
					<th>操作</th>
				</tr>

			</thead>
			<tbody>
			</tbody>
		</table>

	</div>
	<p id="myaa"></p>
</body>
</html>
