$(function() {

	$('#userID').html($('#userIdHid').val());
	$('#userName').html($('#userNameHid').val());

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var startDate;
	var endDate;

	var selectCurrentWeek = function() {
		window.setTimeout(function() {
			$('.week-picker').find('.ui-datepicker-current-day a').addClass(
					'ui-state-active')
		}, 3);
	}
	var $weekPicker = $('.week-picker');

	function updateWeekStartEnd() {
		var date = $weekPicker.datepicker('getDate') || new Date();
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
	}

	updateWeekStartEnd();

	function updateDateText(inst) {
		var dateFormat = inst != 'start' && inst.settings.dateFormat ? inst.settings.dateFormat
				: $.datepicker._defaults.dateFormat;
		removeDisabledForAll();
		var day1 = futureDatecheck(secondDate, dateFormat, inst, "#selectForm1");
		var day2 = futureDatecheck(thirdDate, dateFormat, inst, "#selectForm2");
		var day3 = futureDatecheck(fourthDate, dateFormat, inst, "#selectForm3");
		var day4 = futureDatecheck(fifthDate, dateFormat, inst, "#selectForm4");
		var day5 = futureDatecheck(sixthDate, dateFormat, inst, "#selectForm5");
		$('#secondDate').html(day1);
		$('#dateDay1').val(day1);
		$('#thirdDate').html(day2);
		$('#dateDay2').val(day2);
		$('#fourthDate').html(day3);
		$('#dateDay3').val(day3);
		$('#fifthDate').html(day4);
		$('#dateDay4').val(day4);
		$('#sixthDate').html(day5);
		$('#dateDay5').val(day5);
	}
	updateDateText('start');
	getDetails($('#employeeId').val());
	$weekPicker.datepicker({
		showOtherMonths : true,
		selectOtherMonths : true,
		maxDate : '0',
		onSelect : function(dateText, inst) {
			updateWeekStartEnd();
			updateDateText(inst);
			getDetails($('#employeeId').val());
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

	$('.week-picker .ui-datepicker-calendar tr').on('mousemove', function() {
		$(this).find('td a').addClass('ui-state-hover');
	});
	$('.week-picker .ui-datepicker-calendar tr').on('mouseleave', function() {
		$(this).find('td a').removeClass('ui-state-hover');
	});

});

var validateEmpId = function(obj) {
	if (!isNaN(obj.value)) {
		$('#employeeId').val(obj.value);
	} else {
		obj.value = "";
	}
}
function getDetails(name) {
	alert('value of EmployeeId tag' + $('#employeeId').val());
	alert('values length' + $('#employeeId').val().length);
	alert('value adminId' + $('#adminUserName').val());
	var adminEmp = $('#adminUserName').val();
	alert(adminEmp);
	alert(name);
	alert(name.length);
	var data = {}
	data["dates"] = $('#secondDate').text() + "," + $("#sixthDate").text();

	if (null != name && name != '' && name != adminEmp && name.length > 0) {
		alert('coming here-------------------------------------------->');
		data["user"] = name;
		getUserName(name);
	}
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/viewtimeSheet/getLeavesAjax",
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			alert(data);
			$.each(data, function(index, value) {
				indexInc = index + 1;
				$('#selectForm' + indexInc).val(data[index]);
			});
		},
		error : function(e) {
		},
		done : function(e) {
		}
	});
}

function getUserName(id) {
	var data = {}
	data["id"] = id;
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/viewtimeSheet/getUserNameAjax",
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			alert(data);
			alert(id);
			$('#userNamehid').val(data[0]);
			$('#userIdHid').val(id);
			$('#userID').html($('#userIdHid').val());
			$('#userName').html($('#userNameHid').val());
		},
		error : function(xhr, status, error) {
			alert(status);
			var err = eval("(" + xhr.responseText + ")");
			alert(err.Message);
		},
		done : function(e) {
			alert(e);
		}
	});
}

function futureDatecheck(date, dateFormat, inst, buttonId) {
	var currentDate = new Date();
	if (currentDate < date) {
		$(buttonId).attr('disabled', true);
		return "";
	} else {
		return $.datepicker.formatDate(dateFormat, date, inst.settings);
	}
}

function removeDisabledForAll() {
	$("#selectForm1").attr('disabled', false);
	$("#selectForm2").attr('disabled', false);
	$("#selectForm3").attr('disabled', false);
	$("#selectForm4").attr('disabled', false);
	$("#selectForm5").attr('disabled', false);
}

$(function() {
	/* Submit form using Ajax */
	$('button[type=submit]').click(function(e) {
		$('#userSub').val($('#userIdHid').val());
		$('#submitterSub').val($('#adminUserName').val());
		alert($('form[name=submitLeaves]').serialize());
		// Prevent default submission of form
		e.preventDefault();
		alert($('form[name=submitLeaves]').serialize());
		$.post({
			url : '/viewtimeSheet/submitLeaveDetails',
			data : $('form[name=submitLeaves]').serialize(),
			success : function(res) {

				alert(res);
				if (res.validated) {
					// Set response

				} else {
					// Set error messages
				}
			}
		})
	});
});
