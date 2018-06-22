angular
    .module('demoApp', ['mobiscroll-calendar', 'mobiscroll-form'])
    .controller('demoController', ['$scope', function ($scope) {

        var fromMonday = [],
            fromSaturday = [],
            twoWeeks = [],
            i = 0,
            j = 0;

        for (i; i < 7; i++) {
            fromMonday.push(new Date(2018, 0, 8 + i));
            fromSaturday.push(new Date(2018, 0, 6 + i));
        }

        for (j; j < 14; j++) {
            twoWeeks.push(new Date(2018, 0, 8 + j));
        }

        $scope.mon = fromMonday;
        $scope.sat = fromSaturday;
        $scope.multi = twoWeeks;

        $scope.demo = {
            theme: 'ios',
            lang: 'en-UK',
            display: 'bottom',
            selectType: 'week',
            firstSelectDay: 1,
            firstDay: 1
        };

        $scope.satSettings = {
            theme: 'ios',
            lang: 'en-UK',
            display: 'bottom',
            selectType: 'week',
            firstSelectDay: 6,
            firstDay: 1
        };

        $scope.multiSettings = {
            theme: 'ios',
            lang: 'en-UK',
            display: 'bottom',
            selectType: 'week',
            firstSelectDay: 1,
            firstDay: 1,
            select: 'multiple'
        };

    }]);