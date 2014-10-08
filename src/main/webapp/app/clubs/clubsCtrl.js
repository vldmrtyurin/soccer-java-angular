'use strict'
angular.module('soccer.clubs').controller('ClubsCtrl', ['$scope', '$routeParams' , 'Club', 'Link', function($scope, $routeParams, Club, Link) {
  Club.getAll(function(data) {
    $scope.clubs = data;
  });
  if ($routeParams !== undefined) {
    Club.getById({clubId: $routeParams.clubId}, function(data) {
      $scope.club = data;
      Link.create($scope.club.country.href).get(function(data) {
        $scope.club.country = data;
      });
      Club.getPlayers({clubId: $routeParams.clubId}, function(data) {
        $scope.club.players = data;
      });
    });
  }


}]);