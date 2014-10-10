'use strict'
angular.module('soccer.country', [
  'ngRoute',
  'ngResource'
]).config(['$routeProvider', function ($routeProvider) {

}])
  .controller('CountryDetailsCtrl', ['$scope', '$resource', '$routeParams', 'Link', function ($scope, $resource, $routeParams, Link) {
    $scope.controllerName = 'CountryDetailsCtrl';
    $scope.CountriesResource = $resource('resources/countries/:countryId');
    $scope.PlayersResource = $resource('resources/countries/:countryId/players');
    $scope.CountriesResource.get({countryId: $routeParams.countryId}, function (data) {
      $scope.country = data;
      Link.create($scope.country.players.href).get(function(data) {
        $scope.country.players = data;
      });
    });
  }]);