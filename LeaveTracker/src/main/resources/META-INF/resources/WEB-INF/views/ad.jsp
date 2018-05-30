<!DOCTYPE html>
<html ng-app="app">

  <head>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
    <script src="http://code.angularjs.org/1.2.16/angular.js"></script>
    <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
    <!-- <script src="/angularjs/example.js"></script> -->
 <% String foo = request.getParameter("foo");%>
       <script>
    angular.module('app', ['ui.bootstrap'])

    .controller("BodyCtrl", function($scope) {

      $scope.formData = {};
      $scope.data = {};
      $scope.angDate='Mnai';
       $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 0,
        showWeeks:'false'
      };
    </script>
     
    
  </head>

  <body ng-controller="BodyCtrl">
    <br><br>
   {{angDate}}
<div ng-bind="angDate"></div>
    
  </body>
</html>

