'use strict'
angular.module('soccer.admin').controller('adminClubsCtrl', ['$scope', 'Club', function ($scope, Club) {
  Club.getAll().then(function (data) {
    $scope.clubs = data;
  });
  $scope.selectedCountry = {};
  $scope.selectedStadium = {};
  $scope.newClub = {};
  $scope.delete = function(club) {
    console.log(club.id);
    Club.removeById(club.id.toString()).then(function() {
      $scope.clubs.items = _.without($scope.clubs.items, club);
    });
  }

  $scope.addClub = function() {
    $scope.newClub.stadium = $scope.selectedStadium;
    $scope.newClub.country = $scope.selectedCountry;
    Club.save($scope.newClub);
  }

}]);