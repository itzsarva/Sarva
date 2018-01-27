<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is a simple JSP page to test</title>
</head>
<body>
	<h1>
		Hi
		<c:out value="${who}"></c:out>
		,
	</h1>
	<h2>
		<i><br> you solely miss <c:out value="${miss}"></c:out></i>
	</h2>
</body>
</html>