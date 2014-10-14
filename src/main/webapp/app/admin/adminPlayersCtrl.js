'use strict'
angular.module('soccer.admin').controller('adminPlayersCtrl', ['$scope', 'Player', function($scope, Player) {
  Player.getAll().then(function(data) {
    $scope.players = data;
  });
  $scope.delete = function(player) {
    var index = $scope.players.items.indexOf(player);
    console.log(player.id);
    Player.removeById(player.id.toString()).then(function() {
      $scope.players.items = _.without($scope.players.items, player);
    });
  }
  $scope.selectedPosition = {};
  $scope.selectedCountry = {};
  $scope.selectedClub = {};
  $scope.newPlayer = {};
  $scope.addPlayer = function() {
    $scope.newPlayer.position = $scope.selectedPosition;
    $scope.newPlayer.country = $scope.selectedCountry;
    $scope.newPlayer.club = $scope.selectedClub;
    Player.save($scope.newPlayer);

  }
}]);