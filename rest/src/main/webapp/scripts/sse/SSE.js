(function() {
  'use strict';
  angular.module('app.sse', []).factory('rooms', function() {
    var SAMPLE_ROOMS;
    SAMPLE_ROOMS = '[ {"name": "Room 1", "value": "room1"}, {"name": "Room 2", "value": "room2"} ]';
    return {
      get: function() {
        return JSON.parse(SAMPLE_ROOMS);
      }
    };
  }).controller('ChatCtrl', [
    '$scope', '$http', '$log', 'rooms', function($scope, $http, $log, rooms) {
      $log.log("hi0");
      $scope.rooms = rooms.get();
      $log.log("hi1");
      $scope.msgs = [];
      $scope.inputText = "";
      $log.log("hi2");
      $scope.setCurrentRoom = function(room) {
        $scope.editedTask = task;
        $scope.chatFeed.close();
        $scope.msgs = [];
        return $scope.listen();
      };
      $scope.addMsg = function(msg) {
        return $scope.$apply = function() {
          return $scope.msgs.push(JSON.parse(msg.data));
        };
      };
      $scope.listen = function() {
        $scope.chatFeed = new EventSource("/webapi/events");
        return $scope.chatFeed.addEventListener("message", $scope.addMsg, false);
      };
      $log.log("adding listener");
      return $scope.listen();
    }
  ]);

}).call(this);
