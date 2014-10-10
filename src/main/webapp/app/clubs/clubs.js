'use strict'
angular.module('soccer.clubs', [
  'ngRoute',
  'ngResource'
]).config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/clubs', {
    templateUrl: 'clubs/clubs.html',
    controller: 'ClubsCtrl'
  });
  $routeProvider.when('/clubs/:clubId', {
    templateUrl: 'clubs/clubDetail.html',
    controller: 'ClubDetailCtrl'
  });
}]);