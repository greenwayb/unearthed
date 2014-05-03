'use strict'

# app level module which depends on services and controllers
angular.module('app.sse', [])

.factory('rooms', ->
  SAMPLE_ROOMS = '[
          {"name": "Room 1", "value": "room1"},
          {"name": "Room 2", "value": "room2"}
      ]'
  return {
   get: ->
      JSON.parse(SAMPLE_ROOMS);
  }
)

.controller('ChatCtrl', [
    '$scope', '$http', '$log', 'rooms'
    ($scope, $http, $log, rooms) ->

      $log.log("hi0")
      $scope.rooms = rooms.get()

      $log.log("hi1")
      $scope.msgs = []
      $scope.inputText = ""
      $log.log("hi2")
#      $scope.user = "Jane Doe #" + Math.floor((Math.random() * 100) + 1)
#      $scope.currentRoom = $scope.rooms[0]

    # change current room, restart EventSource connection
      $scope.setCurrentRoom = (room)->
        $scope.editedTask = task
        $scope.chatFeed.close();
        $scope.msgs = [];
        $scope.listen();

      $scope.addMsg = (msg) ->
        $scope.$apply = () ->
          $scope.msgs.push(JSON.parse(msg.data))

    # http://localhost:8080/webapi/events
      $scope.listen = ->
#          $scope.chatFeed = new EventSource("http://localhost:8080/webapi/events");
          $scope.chatFeed = new EventSource("/webapi/events");
          $scope.chatFeed.addEventListener("message", $scope.addMsg, false);

      $log.log("adding listener")
      $scope.listen()


])
