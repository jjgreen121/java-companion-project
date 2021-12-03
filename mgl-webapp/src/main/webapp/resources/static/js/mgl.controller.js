'use strict';

angular.module('MglApp').controller('MglController',
		[ 'MglService', function(MglService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				MglService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return MglService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(game){
				console.log("delete attempt");
				return MglService.deleteGame(game.id).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.updateGame = function(game){
			return MglService.updateGame(game.id, self.game).then( function() {
			self.fetchAllGames();
				});
			}
			
			self.fetchAllGames();
			
		}] );
		
		
