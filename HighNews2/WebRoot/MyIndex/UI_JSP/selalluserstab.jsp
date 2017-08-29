<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="util.*" %>
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
<title>查询用户</title>
</head>
<body >

<!-- 删掉了原本嵌入的Java代码 -->

 查询用户
 <!-- 注释了迭代 -->
 <!--c:forEach var="s" items="${oneuser}"-->

						<!-- 修改了name value -->
<br /><br />用户编号：<input type="text" name="id" size="20" value="${oneuser.userid} " /><br/>
用户名称：<input type="text" name="usersBean.username" size="20" value="${oneuser.username}" /><br/>
用户密码：<input type="text" name="usersBean.userpwd" size="20" value="${oneuser.userpwd}" /><br/>
用户等级：<input type="text" name="usersBean.userleval" size="20" value="${oneuser.userleval}" /><br/>
											<!-- 修改了请求路径  lizhen -->
<a href="${pageContext.request.contextPath}/SelectUser.action?id=${oneuser.userid}&dothing=renew"><input type="button" name="rs" value="修改" /></a>
<a href="${pageContext.request.contextPath}/SelectUser.action?id=${oneuser.userid}&dothing=del"><input  type="button" name="sm" value="删除" /></a><br /><br />
 <!--/c:forEach--> 

	
</body>
</html>