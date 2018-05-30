<html lang="en" ng-app="demo.app">

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Angular Material style sheet -->
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.css">    
  <script src="/assets/md-date-range-picker.css" rel="stylesheet" type="text/css"></script>
 </head>

<body ng-cloak layout="row" ng-controller="ctrl">
  <div style="width: 270px" layout="column">
    <md-list>
      <md-subheader>Demo</md-subheader>
      <md-list-item ng-click="page = 'calendar'">
        <p>Calendar</p>
        <span ng-if="page == 'calendar'">></span>
      </md-list-item>
      <md-list-item ng-click="page = 'picker'">
        <p>Picker</p>
        <span ng-if="page == 'picker'">></span>
      </md-list-item>
      <md-list-item ng-click="page = 'service'">
        <p>Service</p>
        <span ng-if="page == 'service'">></span>
      </md-list-item>
      <md-list-item ng-click="page = 'disabled-dates'">
        <p>Disabled Dates</p>
        <span ng-if="page == 'disabled-dates'">></span>
      </md-list-item>
      <md-list-item ng-click="page = 'selected-dates'">
        <p>Selected Dates</p>
        <span ng-if="page == 'selected-dates'">></span>
      </md-list-item>
      <md-list-item ng-click="page = 'advanced'">
        <p>Advanced</p>
        <span ng-if="page == 'advanced'">></span>
      </md-list-item>
    </md-list>
    <md-button class="md-primary md-raised" ng-click="clearAll()">Clear All</md-button>
  </div>
  <div flex layout="column">
    <md-content class="md-padding" layout flex>
      <div ng-include="page+'.html'" flex></div>
    </md-content>
  </div>
  <!-- Angular Material requires Angular.js Libraries -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>

  <!-- Angular Material Library -->
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.js"></script>


  <!-- Angular Material Date Range Picker Library -->
  <script src="/js/md-date-range-picker.js"></script>
 

  <!-- Your application bootstrap  -->
  <script type="text/javascript">
    /**
     * You must include the dependency on 'ngMaterial' 
     */
    angular.module('demo.app', ['ngMaterial', 'ngMaterialDateRangePicker']).controller('ctrl', function ($scope, $mdDateRangePicker) {
      $scope.page = 'calendar';

      var lessThan3Day = new Date();
      lessThan3Day.setDate(lessThan3Day.getDate() - 2);
      $scope.customTemplates = [
        {
          name: 'Last 3 Days',
          dateStart: lessThan3Day,
          dateEnd: new Date(),
        }
      ];

      $scope.calendarModel = { selectedTemplate: 'Last 3 Days' };
      $scope.pickerModel = { selectedTemplate: 'Last 3 Days' };
      $scope.advancedModel = { selectedTemplate: 'Last 3 Days' };
      $scope.serviceModel = { selectedTemplate: 'Last 3 Days' };
      $scope.selectedDate = {};
      $scope.selectedDates = [];

      $scope.selectDateRange = function () {
        $mdDateRangePicker.show({
          model: $scope.serviceModel,
          customTemplates: $scope.customTemplates,
        }).then(function (result) {
          $scope.serviceModel = result;
        }).catch(function () {
          console.log('Cancelled');
        });
      }

      $scope.selectDateRange = function () {
        $mdDateRangePicker.show({
          model: $scope.serviceModel,
          autoConfirm: true,
          mdOnSelect: console.log,
          customTemplates: $scope.customTemplates,
        }).then(function (result) {
          $scope.serviceModel = result;
        }).catch(function () {
          console.log('Cancelled');
        });
      }

      $scope.format = function (dateStart, dateEnd, template, templateName) {
        return template ? 'Range of ' + (templateName || template) : (dateStart && dateEnd && (dateStart.toLocaleDateString() + ' to ' + dateEnd.toLocaleDateString()));
      }
      $scope.isDisabledDate = function (d) {
        return d.getDay() === 0 || d.getDay() === 6;
      }

      $scope.showAdvanced = function () {
        $mdDateRangePicker.show({
          model: $scope.advancedModel,
          autoConfirm: true,
          mdOnSelect: console.log,
          showTemplate: true,
          customTemplates: $scope.customTemplates,
          onePanel: true,
          format: $scope.format,
          isDisabledDate: $scope.isDisabledDate,
        }).then(function (result) {
          $scope.serviceModel = result;
        }).catch(function () {
          console.log('Cancelled');
        });
      }


      $scope.clearAll = function () {
        $scope.calendarModel = { dateStart: null };
        $scope.pickerModel = { dateStart: null };
        $scope.serviceModel = { dateStart: null };
      }
    });
  </script>

</body>

</html>