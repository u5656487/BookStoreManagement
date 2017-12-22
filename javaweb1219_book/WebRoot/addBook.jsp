<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table{
			margin:auto;
			text-align: "center";
			border: 2px;
			
		}
	</style>
  </head>
  
  <body>
  
    <h2 align="center">增加书籍</h2>
     <form action="book.do" method="get">
    	<input type="hidden" name = "action" value="bookAdd">
    	<table cellspacing="2" border="2" width="330px" style="table-layout:fixed;">
	  	<tr>
	  		<td>书籍名称：</td>
	  		<td><input type="text" name="bookname" value="${book.getBookname()}"></td>
	  	</tr>
	  	<tr>
	  		<td>书籍价格：</td>
	  		<td><input type="text" name="bookprice" value="${book.getBookprice()}"></td>
	  	</tr>
	  	<tr>
	  		<td>出版社：</td>
	  		<td><input type="text" name="bookpress" value="${book.getBookpress()}"></td>
	  	</tr>
	  	<tr>
	  		<td>作者：</td>
	  		<td><input type="text" name="bookauthor" value="${book.getBookauthor()}"></td>
	  	</tr>
	  	<tr>
	  		<td>出版时间：</td>
	  		<td><input type="text" name="bookdate" value="${book.getBookdate()}"></td>
	  	</tr>
	  	<tr align="center">
    			<td><input id = "submit" type = "submit" value = "增加书籍"/></td>
    			<td><input type="reset" /></td>
    		</tr>
	  	<tr align="center">
	  		<td colspan="2"><a href="index.jsp">返回主页面</a></td>
	  	</tr>
 	</table>
    </form>
  </body>
</html>
