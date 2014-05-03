'use strict'

angular.module('app.entry', [])

.factory('entryStorage', ->
  STORAGE_ID = 'entries'
  DEMO_ENTRIES = '[
          {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"},
          {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"},
          {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"},
          {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"},
          {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}
      ]'

  return {
  get: ->
    JSON.parse(localStorage.getItem(STORAGE_ID) || DEMO_ENTRIES )

  put: (entries)->
    localStorage.setItem(STORAGE_ID, JSON.stringify(entries))
  }
)

.controller('entryCtrl', [
    '$scope', 'entryStorage', 'filterFilter', '$rootScope', 'logger'
    ($scope, entryStorage, filterFilter, $rootScope, logger) ->

      entries = $scope.entries = entryStorage.get()
      $scope.newEntry = ''

  ])