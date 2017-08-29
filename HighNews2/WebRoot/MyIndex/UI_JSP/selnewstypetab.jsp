<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
    <%@ page import="java.util.*" %>
<%@ page import="control.*" %>
 <%@ page import="Businesses.*" %>
  <%@ page import="entity.*" %>
  <%@ page import="util.*" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询新闻类型</title>
</head>
<body >
	<!-- 海源改 -->
  <form action="${pageContext.request.contextPath}/SelectNewsType.action" method="post">
 	<button type="submit">查询新闻类别</button>
 </form>
 <!-- 海源改 -->
 <c:forEach var="s" items="${NewsType}">

<form action="${pageContext.request.contextPath}/UpdateType.action" method="post">
<br /><br />类别编号：<input type="text" name="newsTypeBean.typeid" size="20" value="${s.typeid} " /><br/>
类别名称：<input type="text" name="newsTypeBean.typename" size="20" value="${s.typename}" /><br/>
<button type="submit" name="rs">修改</button>
 </form>
<form action="${pageContext.request.contextPath}/DeleteTypeById.action" method="post">
<input type="hidden" name="newsTypeBean.typeid" value="${s.typeid}" />
<button  type="submit" name="sm">删除</button><br /><br />
</form>
 </c:forEach> 


</body>
</html>