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

::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
	color: #aaa;
	opacity: 1; /* Firefox */
}

header {
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.4);
	background: #fff;
	margin-top: 0;
	line-height: 60px;
	height: 60px;
}

.title {
	color: #004d40;
	float: left;
	font-size: 25px;
	padding-left: 10px;
}

.btn-danger {
	background-image: -webkit-linear-gradient(top, #D32F2F 0, #c12e2a 100%);
	background-image: -o-linear-gradient(top, #D32F2F 0, #c12e2a 100%);
	background-image: -webkit-gradient(linear, left top, left bottom, from(#D32F2F),
		to(#c12e2a));
	background-image: linear-gradient(to bottom, #D32F2F 0, #c12e2a 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffD32F2F',
		endColorstr='#ffc12e2a', GradientType=0);
	filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
	background-repeat: repeat-x;
	border-color: #D32F2F;
}

.userInfo {
	color: #004d40;
	font-size: 20px;
	margin-left: 1437px;
}

.userInfoLogout {
	color: #004d40;
	float: right;
	font-size: 20px;
	padding-right: 10px;
	margin-top: 13px
}

.pageColor {
	color: #004d40;
}

.dropDownStyle {
	width: 170px;
	margin: 8px 0px;
}

td {
	padding: 2px;
}

thead {
	background: #D32F2F;
	color: #fff;
	font-weight: bold;
}

.modalHeader {
	background: #D32F2F;
	color: #fff;
	font-weight: bold;
}

tbody tr:nth-child(odd) {
	font-weight: bold;
	background: #fff !important;
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
	background: #D32F2F !important;
	border: none !important;
	color: #fff !important;
	font-weight: bold !important;
}

.ui-widget-header {
	background: #fff;
	color: #222222 /*{fcHeader}*/;
	font-weight: bold;
	border-radius: 0;
}

.ui-corner-all {
	border-radius: 0px !important;
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
	<input type="hidden" id="trackEndDate" value="" />
	<div>
		<header> <span class="title"> <img
			src="/css/images/Equiniti_Logo.jpg"
			style="height: 35px; margin-top: 13px;">
		</span> <span class="userInfo" style="cursor: pointer;">
			&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size: 16px;"
			class="glyphicon glyphicon-user" aria-hidden="true"
			onclick="window.location.reload()"></span>&nbsp;${adminUserName}
			&nbsp;&nbsp;&nbsp;&nbsp;
		</span> <span class="userInfoLogout" style="cursor: pointer;">
			<button class="btn btn-danger btn-sm" type="button"
				data-toggle="modal" data-target="#logoutConfirmation">
				<span class="glyphicon glyphicon-log-out"></span> Logout
			</button>
		</span> </header>
		&nbsp;&nbsp;<span id="SubmitSuccess" style="color: green"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
			id="adminWarning" style="color: red"></span>
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
								<div class="" style="margin-right: 0px;">
									<input id="employeeId" placeholder="Emp Id..."
										style="width: 85px; display: inline; color: #004d40; padding: 2px; border: 1px solid #ddd;"
										onkeypress="validateEmpId(this)" maxlength="6"
										autocomplete="off" /> &nbsp;&nbsp;
									<button class="btn btn-default"
										onclick="getDetails($('#employeeId').val())"
										style="vertical-align: baseline;" title="View Employee"
										name="action" value="view" id="viewButton">
										<span style="font-size: 16px;" title="View Employee"
											class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
									</button>
									&nbsp;&nbsp;
									<form:form action="/register/showForm" modelAttribute="findEmp"
										style="float:right">
										<form:hidden path="employeeId" id="employee" value="" />
										<button class="btn btn-default" type="submit"
											style="vertical-align: baseline;" title="Add Employee"
											name="action" value="add">
											<span style="font-size: 16px;" title="Add Employee"
												class="glyphicon glyphicon-plus" aria-hidden="true"></span>
										</button>
										&nbsp;&nbsp;
										<button class="btn btn-default" type="submit"
											style="vertical-align: baseline;"
											title="Edit Employee Details" name="action" value="edit">
											<span style="font-size: 16px;" title="Edit Employee"
												class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										</button>
										&nbsp;&nbsp;
										<button class="btn btn-default" type="submit"
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
								<td align="center" colspan="5" style="background: #f0f0f0;"><button
										type="submit" class="btn btn-success btn-md"
										name="submitLeaves">
										<span style="font-size: 16px;"
											class="glyphicon glyphicon-floppy-disk"></span> Save
									</button></td>
								<td align="center" colspan="5" style="background: #f0f0f0;"><button
										type="button" class="btn btn-success btn-md"
										onclick="window.location.reload()">
										<span style="font-size: 16px;"
											class="glyphicon glyphicon-floppy-disk"></span> Reset
									</button></td>
							</tr>
						</tbody>
					</form:form>
				</table>
			</div>
		</div>
	</div>

	<!-- Log out Modal -->
	<div class="modal fade" id="logoutConfirmation" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header modalHeader">
					<button type="button" class="close" data-dismiss="modal" style="">&times;</button>
					<h4 class="modal-title">Log Out</h4>
				</div>
				<div class="modal-body">
					<p>Do you want to logout and end your current session?</p>
				</div>
				<div class="modal-footer">
					<form:form action="/logout" method="get" name="logout">
						<button type="submit" class="btn btn-success">Yes, Sign
							Out</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>