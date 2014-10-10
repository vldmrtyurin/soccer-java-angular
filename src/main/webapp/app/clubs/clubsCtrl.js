'use strict'
angular.module('soccer.clubs').controller('ClubsCtrl', ['$scope', '$routeParams', 'Club', 'Link', function ($scope, $routeParams, Club, Link) {
  Club.getAll().then(function (data) {
    $scope.clubs = data;
  });
}]);