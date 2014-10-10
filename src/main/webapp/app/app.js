'use strict';

angular.module('soccer', [
  'ngRoute',
  'ngResource',
  'restangular',
  'soccer.countries',
  'soccer.country',
  'soccer.clubs',
  'soccer.admin'
]).config(['$routeProvider', function($routeProvider) {

}]).config(function(RestangularProvider) {
  RestangularProvider.setBaseUrl('resources');
}).factory('Link', ['$resource', function ($resource) {
  return {
    create: function(link) {
      return $resource(link);
    }
  }
}]).directive('countries', function(Country) {
  return {
    templateUrl: 'country-list.html',
    replace: true,
    scope: {
      selectedCountry: '='
    },
    link: function(scope, element, attributes) {
      scope.dirval = "BONUS!";
      Country.getAll(function (data) {
        scope.countries = data;
      });
    }
  }
}).directive('clubs', function(Club) {
  return {
    templateUrl: 'club-list.html',
    replace: true,
    scope: {
      selectedClub: '='
    },
    link: function(scope, element, attributes) {
      Club.getAll().then(function(data) {
        scope.clubs = data;
      });
    }
  }
}).factory('Club', function(Restangular) {
  var clubs = Restangular.one('clubs');
  return {
    getAll: function () {
      return clubs.get();
    },
    getById: function (id) {
      return clubs.one(id).get();
    },
    getPlayers: function (id) {
      return clubs.one(id).one('players').get();
    },
    save: function (player) {
      return clubs.one('players').post('', player);
    }
  }
}).factory('Player', function(Restangular) {
  var players = Restangular.one('players');
  return {
    getAll: function () {
      return players.get();
    },
    save: function (player) {
      return players.post('', player);
    },
    removeById: function(id) {
      return players.one(id).remove();
    }
  }
}).factory('Country', ['$resource', function($resource) {
  return $resource('resources/countries/:countryId', {}, {
    getAll: {method: 'GET', isArray: false},
    getById: {
      method: 'GET',
      params: {countryId: '@countryId'},
      isArray: false
    }
  });
}]);