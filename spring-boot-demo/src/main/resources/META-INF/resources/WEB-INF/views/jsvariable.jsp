<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
    var name = "Script value testing
    ";
</script>
<body>
<form>
<h2>Script test</h2>
<%
    String str = "<script>document.writeln(name)</script>";
    out.println("value: " + str);
%>
</form>
</body>
</html>




