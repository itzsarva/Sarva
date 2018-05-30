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

<script>
	var updateLeaveType = function(day, obj) {
		var selectedText = $(obj).text();
		if (day === 1) {
			$('#sel_emp_role').text(selectedText);

		}
		if (day === 2) {
			$('#sel_txt_team').text(selectedText);

		}
		if (day === 3) {
			$('#sel_txt_vm').text(selectedText);

		}
	}
</script>
<script src="/js/modernizr.custom.js"></script>
</head>
<body>
	<div>

		<header> <span class="title"><span
			style="font-size: 21px;"
			class="glyphicon glyphicon glyphicon-screenshot"></span> Leave
			Tracker</span> </header>
		<div class="row" style="margin:0 !important;margin-top: 10px !important">
			<div class="shadow col-lg-4  col-lg-offset-4">
				<h1 align="center">Register an Employee</h1>
				<table class="table table-striped">
					<tr>
						<td>ID <span class="empDetails"></td>
						<td></span> <input type="text" name="txt_emp_id"></td>
					</tr>
					<tr>
						<td>First Name <span class="empDetails"></td>
						<td></span> <input type="text" name="txt_emp_fname"></td>
					</tr>
					<tr>
						<td>Last Name <span class="empDetails"></td>
						<td></span> <input type="text" name="txt_emp_lname"></td>
					</tr>
					<tr>
						<td>Email ID </td>
						<td><input type="text" name="txt_emp_email"></td>
					</tr>



					<tr>
						<td>Reference Role 
						</td>
						<td >
							<div class="dropDownStyle" >
								<div class="btn-group">
									<button type="button" class="btn btn-default dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<span id="sel_emp_role">Manager </span> <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a onclick="updateLeaveType(1, this)">Manager </a></li>
										<li><a onclick="updateLeaveType(1, this)">Team Lead</a></li>
										<li><a onclick="updateLeaveType(1, this)">Senior
												Software Engineer </a></li>
										<li><a onclick="updateLeaveType(1, this)">Software
												Engineer </a></li>
									</ul>
								</div>
							</div>
						</td>
					</tr>


					<tr>
						<td>Reference Team
						</td>
						<td >
							<div class="dropDownStyle" >
								<div class="btn-group">
									<button type="button" class="btn btn-default dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<span id="sel_txt_team">Xanite - Dev </span> <span
											class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a onclick="updateLeaveType(2, this)">Xanite -
												Dev </a></li>

									</ul>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>VM
						</td>
						<td >
							<div class="dropDownStyle" >
								<div class="btn-group">
									<button type="button" class="btn btn-default dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<span id="sel_txt_vm">172.27.143.209</span> <span
											class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a onclick="updateLeaveType(3, this)">172.27.143.210
										</a></li>
										<li><a onclick="updateLeaveType(3, this)">172.27.143.211</a></li>
										<li><a onclick="updateLeaveType(3, this)">172.27.143.212
										</a></li>
										<li><a onclick="updateLeaveType(3, this)">172.27.143.213
										</a></li>
										<li><a onclick="updateLeaveType(3, this)">172.27.143.214</a></li>
										<li><a onclick="updateLeaveType(3, this)">172.27.143.215</a></li>
									</ul>
								</div>
							</div>
						</td>
					</tr>

					<tr>
						<td>Employee Proactive <span class="empDetails"></td>
						<td></span> <input type="checkbox" name="txt_emp_pactive"></td>
					</tr>
					<tr>
						<td>Employee Active <span class="empDetails"></td>
						<td> <input type="checkbox" name="txt_emp_active"></td>
					</tr>
					<tr>
						<td>Password </td>
						<td> <input type="password" name="txt_emp_password"></td>
					</tr>
					<tr>
						<td>Confirm Password </td>
						<td> <input type="password" name="txt_emp_cpassword"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<div>
								<button class="btn btn-default btn-md">
									<span style="font-size: 16px;"
										class="glyphicon glyphicon-refresh"></span> Reset
								</button> &nbsp;&nbsp;&nbsp;
								<button class="btn btn-success btn-md">
									<span style="font-size: 16px;"
										class="glyphicon glyphicon-floppy-disk"></span> Save
								</button>
							</div>
						</td>

					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>