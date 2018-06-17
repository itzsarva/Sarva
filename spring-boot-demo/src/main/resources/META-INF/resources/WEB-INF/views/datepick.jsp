<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.asd{
    background-color: #ff6961 !important;    
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>
<script src="https://momentjs.com/downloads/moment.js"></script>
<script src="/js/app.js"></script>
<script src="/js/angular-datepicker-light.js"></script>
 <script>
angular
.module('mainApp', ['datepickerLightModule'])
.controller('InlineCtrl', InlineCtrl)
    
function InlineCtrl(){
    var vm = this;
    
    vm.date = new Date();
    vm.datepickerOptions = {
        inline: true
    };
}
</script> 
<script>
$(function () {
    var startDate;
    var endDate;
    var $weekPicker = $('.week-picker');
    
    var selectCurrentWeek = function () {
        window.setTimeout(function () {
            $weekPicker.find('.ui-datepicker-current-day a').addClass('ui-state-active')
        }, 1);
    }
   
    function updateWeekStartEnd() {
        var selectedDate = $weekPicker.datepicker('getDate') || new Date();
        startDate = new Date(selectedDate.getFullYear(), selectedDate.getMonth(), selectedDate.getDate() - selectedDate.getDay());
        endDate = new Date(selectedDate.getFullYear(), selectedDate.getMonth(), selectedDate.getDate() - selectedDate.getDay() + 6);
    }

    updateWeekStartEnd();
    selectCurrentWeek();

    $weekPicker.datepicker({
        showOtherMonths: true,
        selectOtherMonths: true,
        onSelect: function (dateText, instance) {
            updateWeekStartEnd();
            selectCurrentWeek();
        },
        beforeShowDay: function (date) {
            var cssClass = '';
            if (date >= startDate && date <= endDate) {
                cssClass = 'ui-datepicker-current-day asd';
            }
            return [true, cssClass];
        },
        onChangeMonthYear: function (year, month, inst) {
            selectCurrentWeek();
        }
    }); 

    $('.week-picker .ui-datepicker-calendar tr').on('mousemove', function () {
        $(this).find('td a').addClass('ui-state-hover');
    });
    $('.week-picker .ui-datepicker-calendar tr').on('mouseleave', function () {
        $(this).find('td a').removeClass('ui-state-hover');
    });

});
</script>
<!--CSS File-->
<!-- 
<script src="/assets/angular-datepicker-light.css" rel="stylesheet"
	type="text/css"></script> -->
<script src="/assets/app.css" rel="stylesheet" type="text/css"></script>

<!--Image File-->
<!-- <img src="/assets/images/calendar.png" />
<img src="/assets/images/chevron-left.png" />
<img src="/assets/images/chevron-right.png" /> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<!-- <h1>Testing Hi</h1> -->
<!-- <body ng-app="mainApp">
    <div class="week-picker" ng-controller="InlineCtrl as vm">
        <input type="text"
               ng-model="vm.date"   
               angular-datepicker-light="vm.datepickerOptions" />
    </div>
</body> -->

</html>