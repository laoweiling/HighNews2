<%@ page language="java"  import="java.util.*,entity.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户</title>
</head>
<body >

<!-- 修改action调用 -->
<form action="${pageContext.request.contextPath}/InsertUser.action" method="post"> 
增加用户<br/><br/>
用户名称：<input type="text" name="usersBean.username" size="20" /><br/>
用户密码：<input type="text" name="usersBean.userpwd" size="20" /><br/>
用户等级：<input type="text" name="usersBean.userleval" size="20" /><br/><br/>

<input type="reset" name="rs" value="重写" />
<input type="submit" name="sm" value="添加" />
</form>
	
</body>
</html>