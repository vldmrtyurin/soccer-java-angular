'use strict'
angular.module('soccer.clubs').controller('ClubDetailCtrl', ['$scope', '$routeParams', 'Club', function ($scope, $routeParams, Club) {
    Club.getById($routeParams.clubId).then(function(data) {
      $scope.club = data;
      Club.getPlayers($routeParams.clubId).then(function(data) {
        $scope.club.players = data;
      });
    });
}]);