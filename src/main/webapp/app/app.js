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
      Country.getAll(function (data) {
        scope.countries = data;
      });
    }
  }
}).directive('stadiums', function(Stadium) {
  return {
    templateUrl: 'stadium-list.html',
    replace: true,
    scope: {
      selectedStadium: '='
    },
    link: function(scope, element, attributes) {
      Stadium.getAll().then(function(data) {
        scope.stadiums = data;
      });
    }
  }
}).directive('positions', function(Stadium) {
  return {
    templateUrl: 'positions-list.html',
    replace: true,
    scope: {
      selectedPosition: '='
    },
    link: function (scope, element, attributes) {
      scope.positions = {
        items: [
          {
            id: 1,
            name: 'Goalkeeper'
          },
          {
            id: 2,
            name: 'Defender'
          },
          {
            id: 3,
            name: 'Midfielder'
          },
          {
            id: 4,
            name: 'Attacker'
          }
        ]
      }
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
    getStadiums: function (id) {
      return clubs.one(id).one('stadiums').get();
    },
    save: function (club) {
      return clubs.post('', club);
    },
    removeById: function(id) {
      return clubs.one(id).remove();
    }
  }
}).factory('Stadium', function(Restangular) {
  var stadiums = Restangular.one('stadiums');
  return {
    getAll: function () {
      return stadiums.get();
    },
    save: function (stadium) {
      return stadiums.post('', stadium);
    },
    removeById: function(id) {
      return stadiums.one(id).remove();
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