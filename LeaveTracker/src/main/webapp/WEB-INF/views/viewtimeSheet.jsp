<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet</title>
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

tbody tr:nth-child(odd) {
	font-weight: bold;
}

tbody tr:nth-child(even) {
	background: #eee;
	color: #000;
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

body {
	background: #f0f0f0;
}

.nav {
	left: 50%;
	margin-left: -150px;
	top: 50px;
	position: absolute;
}

.nav>li>a:hover, .nav>li>a:focus, .nav .open>a, .nav .open>a:hover, .nav .open>a:focus
	{
	background: #fff;
}

.dropdown {
	background: #fff;
	border: 1px solid #ccc;
	border-radius: 4px;
	width: 300px;
}

.dropdown-menu>li>a {
	color: #428bca;
}

.dropdown ul.dropdown-menu {
	border-radius: 4px;
	box-shadow: none;
	margin-top: 20px;
	width: 300px;
}

.dropdown ul.dropdown-menu:before {
	content: "";
	border-bottom: 10px solid #fff;
	border-right: 10px solid transparent;
	border-left: 10px solid transparent;
	position: absolute;
	top: -10px;
	right: 16px;
	z-index: 10;
}

.dropdown ul.dropdown-menu:after {
	content: "";
	border-bottom: 12px solid #ccc;
	border-right: 12px solid transparent;
	border-left: 12px solid transparent;
	position: absolute;
	top: -12px;
	right: 14px;
	z-index: 9;
}
</style>
<script src="/js/timesheet.js"></script>
<script src="/js/modernizr.custom.js"></script>
</head>
<body>
	<meta name="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" content="${_csrf.headerName}" />
	<div>
		<header> <span class="title"><span
			style="font-size: 21px;"
			class="glyphicon glyphicon glyphicon-screenshot"></span> Leave
			Tracker</span> <span class="userInfo"><span
			class="glyphicon glyphicon-tag" style="font-size: 16px;"
			aria-hidden="true"></span> ${adminUserID} &nbsp;&nbsp;<span
			style="font-size: 16px;" class="glyphicon glyphicon-user"
			aria-hidden="true"></span>${adminUserName}</span> </header>

		<div align="center" style="width: 100%; margin-top: 15px;" class="row">
			<div class="week-picker" style="display: inline-flex;"></div>
			<div class="col-lg-10" style="margin-left: 15px;">
				<table class="table table-striped" align="center">
					<col width="50">
					<col width="50">
					<col width="50">
					<col width="50">
					<col width="50">
					<col width="50">
					<col width="50">
					<thead>
						<tr>
							<td colspan="2"
								style="background: #fff; color: #aaa; vertical-align: middle;">
								<input type="hidden" value=${userName } id="userNameHid" /> <input
								type="hidden" value=${userID } id="userIdHid" /> <input
								type="hidden" value=${adminUserID } id="adminUserName" />
								Employee Name: <span class="empDetails" id="userName"></span>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Employee Id: <span
								class="empDetails" id="userID"></span>
							</td>
							<td align="right" colspan="3" style="background: #fff;">
								<div class="row" style="margin-right: 0px;">
									<input id="employeeId" placeholder="Emp Id"
										style="width: 85px; display: inline;"
										onkeypress="validateEmpId(this)" maxlength="6" />
									&nbsp;&nbsp;
									<button class="btn btn-success"
										onclick="getDetails($('#employeeId').val())"
										style="vertical-align: baseline;" title="To Submit leave Data"
										name="action" value="view" id="viewButton">
										<span style="font-size: 16px;" title="To Submit leave Data"
											class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
									</button>
								</div>
								<div class="row" style="margin-right: 0px;">
									&nbsp;&nbsp;
									<form:form action="/register/showForm" modelAttribute="findEmp">
										<form:hidden path="employeeId" id="employeeId" value="" />
										<button class="btn btn-primary" type="submit"
											style="vertical-align: baseline;" title="Add Employee"
											name="action" value="add">
											<span style="font-size: 16px;" title="Add Employee"
												class="glyphicon glyphicon-plus" aria-hidden="true"></span>
										</button>
										&nbsp;&nbsp;
										<button class="btn btn-default" type="submit"
											style="vertical-align: baseline;"
											title="Edit Employee Details" name="action" value="edit">
											<span style="font-size: 16px;" title="Edit Employee Details"
												class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										</button>
										&nbsp;&nbsp;
										<button class="btn btn-danger" type="submit"
											style="vertical-align: baseline;" title="Delete Employee"
											name="action" value="delete">
											<span style="font-size: 16px;"
												class="glyphicon glyphicon-trash" aria-hidden="true"
												title="Delete Employee"></span>
										</button>
									</form:form>
								</div>
							</td>

						</tr>
						<tr>
							<th><center>MONDAY</center></th>
							<th><center>TUESDAY</center></th>
							<th><center>WEDNESDAY</center></th>
							<th><center>THURSDAY</center></th>
							<th><center>FRIDAY</center></th>
						</tr>
					</thead>
					<form:form modelAttribute="leaveBean"
						action="/viewtimeSheet/submitLeaveDetails" name="submitLeaves"
						method="post">
						<form:hidden path="dateDay1" id="dateDay1" value="" />
						<form:hidden path="dateDay2" id="dateDay2" value="" />
						<form:hidden path="dateDay3" id="dateDay3" value="" />
						<form:hidden path="dateDay4" id="dateDay4" value="" />
						<form:hidden path="dateDay5" id="dateDay5" value="" />
						<form:hidden path="user" id="userSub" value="" />
						<form:hidden path="submitter" id="submitterSub" value="" />
						<tbody>
							<tr>
								<td>
									<div>

										<center>
											<span id="secondDate"> </span>
										</center>

									</div>
								</td>
								<td>
									<div>

										<center>
											<span id="thirdDate"> </span>
										</center>

									</div>
								</td>
								<td>
									<div>

										<center>
											<span id="fourthDate"> </span>
										</center>

									</div>
								</td>
								<td>
									<div>

										<center>
											<span id="fifthDate"> </span>
										</center>

									</div>
								</td>
								<td>
									<div>

										<center>
											<span id="sixthDate"> </span>
										</center>

									</div>
								</td>
							</tr>
							<tr>
								<td align="center">
									<div class="dropDownStyle">
										<div class="btn-group">
											<form:select path="leaveDay1"
												class="btn btn-default dropdown-toggle" id="selectForm1">
												<form:options items="${showLeaves}" />
											</form:select>
										</div>
									</div>
								</td>

								<td align="center">
									<div class="dropDownStyle">
										<div class="btn-group" id="button1">
											<form:select path="leaveDay2"
												class="btn btn-default dropdown-toggle" id="selectForm2">
												<form:options items="${showLeaves}" />
											</form:select>
										</div>
									</div>
								</td>

								<td align="center">
									<div class="dropDownStyle">
										<div class="btn-group" id="button1">
											<form:select path="leaveDay3"
												class="btn btn-default dropdown-toggle" id="selectForm3">
												<form:options items="${showLeaves}" />
											</form:select>
										</div>
									</div>
								</td>

								<td align="center">
									<div class="dropDownStyle">
										<div class="btn-group" id="button1">
											<form:select path="leaveDay4"
												class="btn btn-default dropdown-toggle" id="selectForm4">
												<form:options items="${showLeaves}" />
											</form:select>
										</div>
									</div>
								</td>


								<td align="center">
									<div class="dropDownStyle">
										<div class="btn-group" id="button1">
											<form:select path="leaveDay5"
												class="btn btn-default dropdown-toggle" id="selectForm5">
												<form:options items="${showLeaves}" />
											</form:select>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td align="center" colspan="5" style="background: #fff;"><button
										type="submit" class="btn btn-success btn-md">
										<span style="font-size: 16px;"
											class="glyphicon glyphicon-floppy-disk"></span> Save
									</button></td>
							</tr>
						</tbody>
					</form:form>
				</table>
			</div>
		</div>
	</div>

	<div class="container">

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog"
			data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<!-- 	<button type="button" class="close" data-dismiss="modal">&times;</button> -->
						<h4 class="modal-title">Information</h4>
					</div>
					<div class="modal-body">
						<p>You cannot select Future dates</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>