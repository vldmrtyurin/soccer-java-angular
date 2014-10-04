'use strict'
angular.module('soccer.country', [
  'ngRoute',
  'ngResource'
]).config(['$routeProvider', function ($routeProvider) {

}])
  .controller('CountryDetailsCtrl', ['$scope', '$resource', '$routeParams', function ($scope, $resource, $routeParams) {
    $scope.countryController = 'Country Details';
    $scope.CountriesResource = $resource('http://localhost:8080/soccer/resources/countries/:countryId');
    $scope.PlayersResource = $resource('http://localhost:8080/soccer/resources/countries/:countryId/players');
    $scope.country = $scope.CountriesResource.get({countryId: $routeParams.countryId}, function () {

    });
    $scope.playerList = $scope.PlayersResource.get({countryId: $routeParams.countryId}, function () {
      $scope.players = $scope.playerList.items;
    });
  }]);