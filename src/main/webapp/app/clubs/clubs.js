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
    controller: 'ClubsCtrl'
  });
}]).factory('Club', ['$resource', function($resource) {
    return $resource('resources/clubs/:clubId/:players', {}, {
      getAll: {method: 'GET', isArray: false},
      getById: {method: 'GET', params: {clubId: '@clubId'}, isArray: false},
      getPlayers: {method: 'GET', params: {clubId: '@clubId', players: 'players'}, isArray: false}
    });
}]).factory('Link', ['$resource', function($resource) {
  return {
    create: function(link) {
      return $resource(link);
    }
  }
}]);