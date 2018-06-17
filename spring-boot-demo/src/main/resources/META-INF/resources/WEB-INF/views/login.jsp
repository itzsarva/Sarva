<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script src="/js/jquery.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/css/normalize.css">
<link href="https://fonts.googleapis.com/css?family=Maven+Pro"
	rel="stylesheet">

<!-- 
<link rel="stylesheet" type="text/css" href="/css/default.css" />
<link rel="stylesheet" type="text/css" href="/css/component.css" /> -->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<style>
*:not(span) {
	font-family: 'Maven Pro', sans-serif !important;
}

header {
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.4);
	background: #004d40;
	margin-top: 0;
	line-height: 60px;
	height: 60px;
}

.title {
	color: #fff;
	float: left;
	font-size: 25px;
	padding-left: 10px;
}

.userInfo {
	color: #fff;
	float: right;
	font-size: 20px;
	padding-right: 10px;
}

.dropDownStyle {
	width: 170px;
	margin: 8px 0px;
}

td {
	padding: 2px;
}

thead {
	background: #004d40;
	color: #fff;
	font-weight: bold;
}

tbody td {
	padding: 10px;
}

.empDetails {
	font-weight: bold;
	color: #004d40;
}

.shadow {
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}
</style>

<!-- Spring tag lib for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- JSTL Tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/js/modernizr.custom.js"></script>
</head>
<body>
	<div>

		<header> <span class="title"><span
			style="font-size: 21px;"
			class="glyphicon glyphicon glyphicon-screenshot"></span> Leave
			Tracker</span> </header>
		<div class="row" style="margin-top: 10%">
			<form:form action="/app-login" modelAttribute="loginBean"
				method="post">
				<div class="shadow col-lg-2  col-lg-offset-5">
					<h1 align="center">Log In</h1>
					<table align="center" cellspacing="10">
						<tr>
							<td><label for="txt_emp_id">Employee ID</label><span
								class="empDetails"></span></td>
							<td><form:input path="empId" id="txt_emp_id" /> <form:errors
									path="empId" cssClass="error" element="div" />
								<div id="empId.errors" class="error"></div></td>
						</tr>
						<tr>
							<td><label for="txt_emp_password">Password</label><span
								class="empDetails"></span></td>
							<td><form:input path="password" id="txt_emp_password" /> <form:errors
									path="password" cssClass="error" element="div" />
								<div id="password.errors" class="error"></div></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button class="btn btn-success btn-md">
									<span style="font-size: 16px;"
										class="glyphicon glyphicon-log-in"></span> &nbsp;Log In
								</button>
							</td>
						</tr>
					</table>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>