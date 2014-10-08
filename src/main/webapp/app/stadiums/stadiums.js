'use strict'

angular.module('soccer.stadiums', [
  'ngRoute',
  'ngResource'
])

  .config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/stadiums', {
      templateUrl: 'stadiums/stadiums.html',
      controller: 'CountriesCtrl'
    });
    $routeProvider.when('/countries/:countryId', {
      templateUrl: 'countries/country.html',
      controller: 'CountryDetailsCtrl'
    });
  }])

  .controller('StadiumsCtrl', ['$scope', '$resource', function($scope, $resource) {
    $scope.helloFromController = "Hello from country Ctrl";
    $scope.CountriesResource = $resource('resources/countries/:countryId');
    $scope.countryList = $scope.CountriesResource.get(function() {
      $scope.countries = $scope.countryList.items;
    });
    $scope.selectedCountry;
  }]);