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
</style>


<script>
	$(function() {
		var startDate;
		var endDate;

		var selectCurrentWeek = function() {
			window.setTimeout(function() {
				$('.week-picker').find('.ui-datepicker-current-day a')
						.addClass('ui-state-active')
			}, 3);
		}
		var $weekPicker = $('.week-picker');

		function updateWeekStartEnd() {
			var date = $weekPicker.datepicker('getDate') || new Date();
			startDate = new Date(date.getFullYear(), date.getMonth(), date
					.getDate()
					- date.getDay());
			var CurrentDate = new Date();
			var SelectedDate = date;

			secondDate = new Date(date.getFullYear(), date.getMonth(), date
					.getDate()
					- date.getDay() + 1);
			thirdDate = new Date(date.getFullYear(), date.getMonth(), date
					.getDate()
					- date.getDay() + 2);
			fourthDate = new Date(date.getFullYear(), date.getMonth(), date
					.getDate()
					- date.getDay() + 3);
			fifthDate = new Date(date.getFullYear(), date.getMonth(), date
					.getDate()
					- date.getDay() + 4);
			sixthDate = new Date(date.getFullYear(), date.getMonth(), date
					.getDate()
					- date.getDay() + 5);
			endDate = new Date(date.getFullYear(), date.getMonth(), date
					.getDate()
					- date.getDay() + 6);
		}

		updateWeekStartEnd();

		function updateDateText(inst) {
			var dateFormat = inst != 'start' && inst.settings.dateFormat ? inst.settings.dateFormat
					: $.datepicker._defaults.dateFormat;

			$('#startDate').html(
					$.datepicker.formatDate(dateFormat, startDate,
							inst.settings));
			$('#secondDate').html(
					$.datepicker.formatDate(dateFormat, secondDate,
							inst.settings));
			$('#thirdDate').html(
					$.datepicker.formatDate(dateFormat, thirdDate,
							inst.settings));
			$('#fourthDate').html(
					$.datepicker.formatDate(dateFormat, fourthDate,
							inst.settings));
			$('#fifthDate').html(
					$.datepicker.formatDate(dateFormat, fifthDate,
							inst.settings));
			$('#sixthDate').html(
					$.datepicker.formatDate(dateFormat, sixthDate,
							inst.settings));
			$('#endDate')
					.html(
							$.datepicker.formatDate(dateFormat, endDate,
									inst.settings));
		}

		updateDateText('start');

		$weekPicker.datepicker({
			showOtherMonths : true,
			selectOtherMonths : true,
			maxDate : '0',
			onSelect : function(dateText, inst) {
				updateWeekStartEnd();
				updateDateText(inst);
				selectCurrentWeek();
			},
			beforeShowDay : function(date) {
				var cssClass = '';
				if (date >= startDate && date <= endDate)
					cssClass = 'ui-datepicker-current-day';
				return [ true, cssClass ];
			},
			onChangeMonthYear : function(year, month, inst) {
				selectCurrentWeek();
			}
		});

		selectCurrentWeek();

		$('.week-picker .ui-datepicker-calendar tr').on('mousemove',
				function() {
					$(this).find('td a').addClass('ui-state-hover');
				});
		$('.week-picker .ui-datepicker-calendar tr').on('mouseleave',
				function() {
					$(this).find('td a').removeClass('ui-state-hover');
				});

	});

	var updateLeaveType = function(day, obj) {
		var selectedText = $(obj).text();
		if (day === 1) {
			$('#startDateLeave').text(selectedText);

		}
		if (day === 2) {
			$('#secondDateLeave').text(selectedText);

		}
		if (day === 3) {
			$('#ThiredDateLeave').text(selectedText);

		}
		if (day === 4) {
			$('#FourthDateLeave').text(selectedText);

		}
		if (day === 5) {
			$('#FifhtDateLeave').text(selectedText);

		}
		if (day === 6) {
			$('#SixthDateLeave').text(selectedText);

		}
		if (day === 7) {
			$('#SeventhDateLeave').text(selectedText);

		}
	}

	var validateEmpId = function(obj) {
		if (!isNaN(obj.value)) {

		} else {
			obj.value = "";
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
			Tracker</span> <span class="userInfo"><span
			class="glyphicon glyphicon-tag" style="font-size: 16px;"
			aria-hidden="true"></span> 1989 &nbsp;&nbsp;<span
			style="font-size: 16px;" class="glyphicon glyphicon-user"
			aria-hidden="true"></span> Yusuf</span> </header>

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
								Employee Name: <span class="empDetails">Raj Kumar</span>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Employee Id: <span
								class="empDetails">1977</span>

							</td>
							<form:form action="/register/showForm">
								<td align="right" colspan="5" style="background: #fff;">
									<div class="row" style="margin-right: 0px;">
										<input type="text" class="form-control" placeholder="Emp Id"
											style="width: 85px; display: inline;"
											onkeypress="validateEmpId(this)"> &nbsp;&nbsp;

										<button class="btn btn-success" type="submit"
											style="vertical-align: baseline;"
											title="To Submit leave Data" name="action" value="view">
											<span style="font-size: 16px;" title="To Submit leave Data"
												class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
										</button>
										&nbsp;&nbsp;
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
									</div>
								</td>
							</form:form>
						</tr>
						<tr>
							<th><center>SUNDAY</center></th>
							<th><center>MONDAY</center></th>
							<th><center>TUESDAY</center></th>
							<th><center>WEDNESDAY</center></th>
							<th><center>THURSDAY</center></th>
							<th><center>FRIDAY</center></th>
							<th><center>SATURDAY</center></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<div>
									<center>
										<span id="startDate"> </span>
									</center>
								</div>
							</td>

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
							<td>
								<div>

									<center>
										<span id="endDate"> </span>
									</center>
								</div>
							</td>
						</tr>
						<tr>
							<td align="center">
								<div class="dropDownStyle" align="center">
									<div class="btn-group">
										<button type="button"
											class="btn btn-default dropdown-toggle disabled"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<span id="startDateLeave">Planned Leave </span> <span
												class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a onclick="updateLeaveType(1, this)">Planned
													Leave</a></li>
											<li><a onclick="updateLeaveType(1, this)">Sick Leave</a></li>
											<li><a onclick="updateLeaveType(1, this)">Casual
													Leave</a></li>
											<li><a onclick="updateLeaveType(1, this)">Optional
													Holiday</a></li>
											<li><a onclick="updateLeaveType(1, this)">UK Holiday</a></li>
											<li><a onclick="updateLeaveType(1, this)">Comp-off</a></li>
										</ul>
									</div>
								</div>
							</td>

							<td align="center">
								<div class="dropDownStyle" align="center">
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<span id="secondDateLeave">Planned Leave </span> <span
												class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a onclick="updateLeaveType(2, this)">Planned
													Leave</a></li>
											<li><a onclick="updateLeaveType(2, this)">Sick Leave</a></li>
											<li><a onclick="updateLeaveType(2, this)">Casual
													Leave</a></li>
											<li><a onclick="updateLeaveType(2, this)">Optional
													Holiday</a></li>
											<li><a onclick="updateLeaveType(2, this)">UK Holiday</a></li>
											<li><a onclick="updateLeaveType(2, this)">Comp-off</a></li>
										</ul>
									</div>
								</div>
							</td>

							<td align="center">
								<div class="dropDownStyle" align="center">
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<span id="ThiredDateLeave">Planned Leave </span> <span
												class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a onclick="updateLeaveType(3, this)">Planned
													Leave</a></li>
											<li><a onclick="updateLeaveType(3, this)">Sick Leave</a></li>
											<li><a onclick="updateLeaveType(3, this)">Casual
													Leave</a></li>
											<li><a onclick="updateLeaveType(3, this)">Optional
													Holiday</a></li>
											<li><a onclick="updateLeaveType(3, this)">UK Holiday</a></li>
											<li><a onclick="updateLeaveType(3, this)">Comp-off</a></li>
										</ul>
									</div>
								</div>
							</td>

							<td align="center">
								<div class="dropDownStyle" align="center">
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<span id="FourthDateLeave">Planned Leave </span> <span
												class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a onclick="updateLeaveType(4, this)">Planned
													Leave</a></li>
											<li><a onclick="updateLeaveType(4, this)">Sick Leave</a></li>
											<li><a onclick="updateLeaveType(4, this)">Casual
													Leave</a></li>
											<li><a onclick="updateLeaveType(4, this)">Optional
													Holiday</a></li>
											<li><a onclick="updateLeaveType(4, this)">UK Holiday</a></li>
											<li><a onclick="updateLeaveType(4, this)">Comp-off</a></li>
										</ul>
									</div>
								</div>
							</td>


							<td align="center">
								<div class="dropDownStyle" align="center">
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<span id="FifhtDateLeave">Planned Leave </span> <span
												class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a onclick="updateLeaveType(5, this)">Planned
													Leave</a></li>
											<li><a onclick="updateLeaveType(5, this)">Sick Leave</a></li>
											<li><a onclick="updateLeaveType(5, this)">Casual
													Leave</a></li>
											<li><a onclick="updateLeaveType(5, this)">Optional
													Holiday</a></li>
											<li><a onclick="updateLeaveType(5, this)">UK Holiday</a></li>
											<li><a onclick="updateLeaveType(5, this)">Comp-off</a></li>
										</ul>
									</div>
								</div>
							</td>

							<td align="center">
								<div class="dropDownStyle" align="center">
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<span id="SixthDateLeave">Planned Leave </span> <span
												class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a onclick="updateLeaveType(6, this)">Planned
													Leave</a></li>
											<li><a onclick="updateLeaveType(6, this)">Sick Leave</a></li>
											<li><a onclick="updateLeaveType(6, this)">Casual
													Leave</a></li>
											<li><a onclick="updateLeaveType(6, this)">Optional
													Holiday</a></li>
											<li><a onclick="updateLeaveType(6, this)">UK Holiday</a></li>
											<li><a onclick="updateLeaveType(6, this)">Comp-off</a></li>
										</ul>
									</div>
								</div>
							</td>

							<td align="center">
								<div class="dropDownStyle" align="center">
									<div class="btn-group">
										<button type="button"
											class="btn btn-default dropdown-toggle disabled"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<span id="SeventhDateLeave">Planned Leave </span> <span
												class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a onclick="updateLeaveType(7, this)">Planned
													Leave</a></li>
											<li><a onclick="updateLeaveType(7, this)">Sick Leave</a></li>
											<li><a onclick="updateLeaveType(7, this)">Casual
													Leave</a></li>
											<li><a onclick="updateLeaveType(7, this)">Optional
													Holiday</a></li>
											<li><a onclick="updateLeaveType(7, this)">UK Holiday</a></li>
											<li><a onclick="updateLeaveType(7, this)">Comp-off</a></li>
										</ul>
									</div>
								</div>
							</td>

						</tr>
						<tr>
							<td align="center" colspan="7" style="background: #fff;"><button
									class="btn btn-success btn-md">
									<span style="font-size: 16px;"
										class="glyphicon glyphicon-floppy-disk"></span> Save
								</button></td>
						</tr>
					</tbody>
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