<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <%@taglib uri="http://www.able.com" prefix="tm" %> --%>
<%-- <%@ taglib prefix="tm" uri="/WEB-INF/tlds/online.tld" %> --%>
<%@taglib prefix="tm" uri="/WEB-INF/tag.tld" %>
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
  </head>
  <body>
	   <%-- 你的ip是:<tm:ip/><br/>
	   循环输出Tag中的内容:<tm:tag>N</tm:tag><br/>
	   修改Tag为小写:<tm:taglab3>NNN</tm:taglab3><br/> --%>
	   <!-- 空标签 -->
	   <tm:helloWorld/>
	   <!-- 更能url中是否传入name属性控制是否显示标签体类容 -->
	   <tm:SkipBodyOrEvalBodyIncludeTag>
	   		<h2>自己学习</h2>
	   </tm:SkipBodyOrEvalBodyIncludeTag> 
	   <!-- 防盗链 -->
	   
	   <tm:SkipPageOrEvalPageTag/>
	   <br/>
    <br>
  </body>
</html>
