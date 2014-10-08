'use strict'
angular.module('soccer.country', [
  'ngRoute',
  'ngResource'
]).config(['$routeProvider', function ($routeProvider) {

}])
  .controller('CountryDetailsCtrl', ['$scope', '$resource', '$routeParams', function ($scope, $resource, $routeParams) {
    $scope.controllerName = 'CountryDetailsCtrl';
    $scope.CountriesResource = $resource('resources/countries/:countryId');
    $scope.PlayersResource = $resource('resources/countries/:countryId/players');
    $scope.country = $scope.CountriesResource.get({countryId: $routeParams.countryId}, function () {

    });
    $scope.players;
    $scope.playerList = $scope.PlayersResource.get({countryId: $routeParams.countryId}, function () {
      $scope.players = $scope.playerList.items;
    });

  }]);