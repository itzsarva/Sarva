<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/js/angulartest.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
</head>
<body>
<div ng-app="demoApp" ng-controller="demoController">
    <div mobiscroll-form style="display:none">
        <div class="mbsc-form-group">
            <div class="mbsc-form-group-title">Week selection</div>
            <label>
                Mon-Sun
                <input ng-model="mon" mobiscroll-calendar="demo" placeholder="Please Select..." />
            </label>
            <label>
                Sat-Fri
                <input ng-model="sat" mobiscroll-calendar="satSettings" placeholder="Please Select..." />
            </label>
            <label>
                Sat-Fri
                <input ng-model="multi" mobiscroll-calendar="multiSettings" placeholder="Please Select..." />
            </label>
        </div>
    </div>
</div>
</body>
</html>