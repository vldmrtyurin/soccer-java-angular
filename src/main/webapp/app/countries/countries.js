'use strict'

angular.module('soccer.countries', [
  'ngRoute',
  'ngResource'
])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/countries', {
    templateUrl: 'countries/countries.html',
    controller: 'CountriesCtrl'
  });
  $routeProvider.when('/countries/:countryId', {
  templateUrl: 'countries/country.html',
  controller: 'CountryDetailsCtrl'
  });
}])

.controller('CountriesCtrl', ['$scope', '$resource', function($scope, $resource) {
  $scope.helloFromController = "Hello from country Ctrl";
  $scope.CountriesResource = $resource('http://localhost:8080/soccer/resources/countries/:countryId');
  $scope.countryList = $scope.CountriesResource.get(function() {
    $scope.countries = $scope.countryList.items;
  });
}]);