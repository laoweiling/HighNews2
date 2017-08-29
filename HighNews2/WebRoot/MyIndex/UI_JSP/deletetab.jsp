<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除新闻页面</title>
</head>
<body >

<form action="<%= request.getContextPath() %>/NewsDeleteAction.action" method="post">   	

删除新闻<br/><br/>
<%-- 
新闻热图：<img style="width:50px;height:50px;" src="<%=request.getScheme()+"://" %>/${newsBean.newspic }" name="newpic" />--%>
<input type="hidden" name="newsidid" size="20" value = "${newsBean.newsid }"/><br/>
作者：<input type="text" name="author" size="20" value = "${newsBean.author }"/><br/>
题目：<input type="text" name="title" size="20" value="${newsBean.newstitle }"/><br/><br/>
<!--  <textarea rows="15" cols="40" name="content">${entry.value.content }</textarea><br/>-->
<textarea style="width:90%,height:50%" id="container" name="content" type="text/plain">
 ${newsBean.content }
</textarea><br/><br/>

    <!-- 配置文件 -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/utf8-jsp/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/utf8-jsp/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
       UE.getEditor('container');
    </script>
<input type="reset" name="rs" value="重写新闻" />
<input type="submit" name="sm"  value="删除新闻" />

</form>
	
</body>
</html>