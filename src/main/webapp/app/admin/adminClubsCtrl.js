'use strict'
angular.module('soccer.admin').controller('adminClubsCtrl', ['$scope', 'Club', function ($scope, Club) {
  Club.getAll().then(function (data) {
    $scope.clubs = data;
  });
}]);