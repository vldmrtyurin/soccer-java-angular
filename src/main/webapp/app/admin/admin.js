'use strict'
angular.module('soccer.admin', [
  'ngRoute',
  'ngResource'
]).config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/admin', {
    templateUrl: 'admin/admin.html',
    controller: 'adminCtrl'
  });
  $routeProvider.when('/admin/clubs', {
    templateUrl: 'admin/adminClubs.html',
    controller: 'adminClubsCtrl'
  });
  $routeProvider.when('/admin/players', {
    templateUrl: 'admin/adminPlayers.html',
    controller: 'adminPlayersCtrl'
  });
}]);