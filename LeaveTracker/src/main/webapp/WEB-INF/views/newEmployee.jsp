<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Tracker :: Register an Employee</title>
<script src="/js/jquery.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/css/normalize.css">
<link href="https://fonts.googleapis.com/css?family=Maven+Pro"
	rel="stylesheet">

<!-- Spring tag lib for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- JSTL Tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

select #referenceRole #refernceTeam #vm {
	border: none;
}

td {
	padding: 2px;
	vertical-align: middle !important;
}

thead {
	background: #004d40;
	color: #fff;
	font-weight: bold;
}

.empDetails {
	font-weight: bold;
	color: #004d40;
}

.ui-state-active {
	background: #1DE9B6 !important;
}

.ui-state-highlight {
	background: #004D40 !important;
	border: none !important;
	color: #fff !important;
	font-weight: bold !important;
}

.shadow {
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}
</style>
<script src="/js/modernizr.custom.js"></script>
</head>
<body>
	<div>
		<header> <span class="title"><span
			style="font-size: 21px;"
			class="glyphicon glyphicon glyphicon-screenshot"></span> Leave
			Tracker</span> </header>
		<div class="row"
			style="margin: 0 !important; margin-top: 10px !important">
			<div class="shadow col-lg-4  col-lg-offset-4">
				<h1 align="center">Register an Employee</h1>
				<form:form modelAttribute="registerBean"
					action="/register/saveEmployee">
					<table class="table table-striped">
						<tr>
							<td><label for="txt_emp_id">ID</label></td>
							<td><form:input path="Employeeid" id="txt_emp_id" /> <form:errors
									path="Employeeid" cssClass="error" element="div" />
								<div id="Employeeid.errors" class="error"></div></td>
						</tr>
						<tr>
							<td><label for="txt_emp_fname">First Name</label></td>
							<td><form:input path="firstName" id="txt_emp_fname" /> <form:errors
									path="firstName" cssClass="error" element="div" />
								<div id="firstName.errors" class="error"></div></td>
						</tr>
						<tr>
							<td><label for="txt_emp_lname">Last Name</label></td>
							<td><form:input path="lastName" id="txt_emp_lname" /> <form:errors
									path="lastName" cssClass="error" element="div" />
								<div id="lastName.errors" class="error"></div></td>
						</tr>
						<tr>
							<td><label for="txt_emp_email">Email ID</label></td>
							<td><form:input path="emailId" id="txt_emp_email" /> <form:errors
									path="emailId" cssClass="error" element="div" />
								<div id="emailId.errors" class="error"></div></td>
						</tr>
						<tr>
							<td><label for="reference_Role">Reference Role</label></td>
							<td>
								<div class="dropDownStyle">
									<div class="btn-group">
										<form:select path="referenceRole"
											class="btn btn-default dropdown-toggle" id="reference_Role">
											<form:options items="${getRoles}" />
										</form:select>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td><label for="refernce_Team">Reference Team</label></td>
							<td>
								<div class="dropDownStyle">
									<div class="btn-group">
										<form:select path="refernceTeam"
											class="btn btn-default dropdown-toggle" id="refernce_Team">
											<form:options items="${referenceTeam}" />
										</form:select>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td><label for="v_m">VM</label></td>
							<td>
								<div class="dropDownStyle">
									<div class="btn-group">
										<form:select path="vm" class="btn btn-default dropdown-toggle"
											id="v_m">
											<form:options items="${getVm}" />
										</form:select>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td><label for="txt_emp_pactive">Employee Pro-Active</label></td>
							<td><form:checkbox path="employeeProactive"
									name="txt_emp_pactive" value="true" /> <form:errors
									path="employeeProactive" cssClass="error" element="div" />
								<div id="employeeProactive.errors" class="error"></div></td>
						</tr>
						<tr>
							<td><label for="txt_emp_pactive">Employee Active</label></td>
							<td><form:checkbox path="employeeActive" value="true"
									name="txt_emp_active" /> <form:errors path="employeeActive"
									cssClass="error" element="div" />
								<div id="employeeActive.errors" class="error"></div></td>
						</tr>
						<tr>
							<td><label for="txt_emp_password">Password</label></td>
							<td><form:input path="password" id="txt_emp_password" /> <form:errors
									path="password" cssClass="error" element="div" />
								<div id="password.errors" class="error"></div></td>
						</tr>
						<tr>
							<td><label for="txt_emp_cpassword">Confirm Password</label></td>
							<td><form:input path="confirmPassword"
									id="txt_emp_cpassword" /> <form:errors path="confirmPassword"
									cssClass="error" element="div" />
								<div id="confirmPassword.errors" class="error"></div></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<div>
									<button class="btn btn-default btn-md" type="reset">
										<span style="font-size: 16px;"
											class="glyphicon glyphicon-refresh"></span> Reset
									</button>
									&nbsp;&nbsp;&nbsp;
									<button type="submit" class="btn btn-success btn-md">
										Submit</button>
								</div>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>