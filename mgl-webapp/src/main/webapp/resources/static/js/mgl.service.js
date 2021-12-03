'use strict';

angular.module('MglApp').factory('MglService', ['$http', function($http) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame : deleteGame,
			updateGame : updateGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI).then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function deleteGame(id) {
			return $http.delete(REST_SERVICE_URI + id).then(function(response) {
					return response.data;
				}
			);
		}
		
		function updateGame(id, game) {
			return $http.put(REST_SERVICE_URI + id, game).then(function(response) {
					return response.data;
				}
			);
		}

}]);
