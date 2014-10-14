'use strict'
angular.module('soccer.admin').controller('adminStadiumsCtrl', ['$scope', 'Stadium', function($scope, Stadium) {
  Stadium.getAll().then(function(data) {
    $scope.stadiums = data;
  });
  $scope.delete = function(stadium) {
    var index = $scope.stadiums.items.indexOf(stadium);
    console.log(stadium.id);
    Stadium.removeById(stadium.id.toString()).then(function() {
      $scope.stadiums.items = _.without($scope.stadiums.items, stadium);
    });
  }
  $scope.selectedCountry = {};
  $scope.newStadium = {};
  $scope.addStadium = function() {
    $scope.newStadium.country = $scope.selectedCountry;
    Stadium.save($scope.newStadium);
  }
}]);