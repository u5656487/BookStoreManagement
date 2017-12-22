<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

pageContext.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'userDetail.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		a{
			text-decoration: none;
			color: black;
		}
		
		#submit:hover{
			cursor: pointer;
		}
		tr{
			align="center";
		}
		
		table{
			margin:auto;
			text-align: "center";
			border: 2px;
			
		}
	
	</style>
  </head>
  
  <body>  

	<h2 align="center">书籍详细信息</h2>
  	<table cellspacing="2" border="2" width="230px">
	  	<tr>
	  		<td>书籍名称：</td>
	  		<td>${book.getBookname()}</td>
	  	</tr>
	  	<tr>
	  		<td>书籍价格：</td>
	  		<td>${book.getBookprice()}</td>
	  	</tr>
	  	<tr>
	  		<td>出版社：</td>
	  		<td>${book.getBookpress()}</td>
	  	</tr>
	  	<tr>
	  		<td>作者：</td>
	  		<td>${book.getBookauthor()}</td>
	  	</tr>
	  	<tr>
	  		<td>出版时间：</td>
	  		<td>${book.getBookdate()}</td>
	  	</tr>
	  	<tr align="center">
	  		<td colspan="2"><a href="index.jsp">返回主页面</a></td>
	  	</tr>
 	</table>
  </body>
</html>
