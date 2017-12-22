
<%@page import="com.service.impl.BookServiceImpl"%>
<%@page import="com.service.BookService"%>
<%@page import="com.dao.impl.BookDaoImpl"%>
<%@page import="com.dao.BookDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.entity.Book"%>

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
    <title>My JSP 'index.jsp' starting page</title>
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
			text-align: center;
			border: 2px;
			border-color: red;
			table-layout:fixed;
		}
		
	</style>
  </head>
  
  <body>
  <c:set var="nowPage" value="${basePath}book.do?action=queryBook" scope="page"></c:set>
  
  <c:if test="${list==null}">
  	<c:redirect url="${basePath}book.do">
  		<c:param name="action" value="queryBook"></c:param>
  		<c:param name="pageIndex" value="${param.pageIndex}"></c:param>
  	</c:redirect>
  </c:if>

	<c:if test="${sessionScope.message==11}">
		<script type="text/javascript">alert("添加成功！");</script>
	</c:if>
	<c:if test="${sessionScope.message==12}">
		<script type="text/javascript">alert("添加失败！");</script>
	</c:if>
	
	<c:if test="${sessionScope.message==21}">
		<script type="text/javascript">alert("修改成功！");</script>
	</c:if>
	<c:if test="${sessionScope.message==22}">
		<script type="text/javascript">alert("修改失败！");</script>
	</c:if>
	
	<c:if test="${sessionScope.message==31}">
		<script type="text/javascript">alert("删除成功！");</script>
	</c:if>
	<c:if test="${sessionScope.message==32}">
		<script type="text/javascript">alert("删除失败！");</script>
	</c:if>

	<c:remove var="message" scope="session" />
	
	<h1 align="center">图书管理系统</h1>
    <div style="text-align: center;">
    	<a href="addBook.jsp">增加书籍</a>
    </div>
    <br/>
	<table border="2" width="750px"  style="table-layout:fixed">
		<tr>
			<td>图书名称</td>
			<td>图书价格</td>
			<td>图书作者</td>
			<td>图书出版社</td>
			<td>出版日期</td>
			<td colspan = "3">操作</td>
		</tr>
	
		<c:forEach var="s" items="${list}">
		<tr>	
			<td>${s.getBookname()}</td>
			<td>${s.getBookprice()}</td>
			<td>${s.getBookauthor()}</td>
			<td>${s.getBookpress()}</td>
			<td>${s.getBookdate()}</td>
			<td><a href="book.do?action=bookDetail&bookid=${s.getBookid()}&toPage=update.jsp">修改</a></td>
			<td><a href="book.do?action=bookDetail&bookid=${s.getBookid()}&toPage=BookDetail.jsp">查看</a></td>
			<td><a href="book.do?action=deleteBookById&bookid=${s.getBookid()}">删除</a></td>
		</tr>
		</c:forEach>
    </table>
    
    <%@ include file="pages.jsp" %>
    
  </body>
</html>
