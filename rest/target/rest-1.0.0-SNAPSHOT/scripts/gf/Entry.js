(function() {
  'use strict';
  angular.module('app.entry', []).factory('entryStorage', function() {
    var DEMO_ENTRIES, STORAGE_ID;
    STORAGE_ID = 'entries';
    DEMO_ENTRIES = '[ {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}, {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}, {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}, {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}, {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"} ]';
    return {
      get: function() {
        return JSON.parse(localStorage.getItem(STORAGE_ID) || DEMO_ENTRIES);
      },
      put: function(entries) {
        return localStorage.setItem(STORAGE_ID, JSON.stringify(entries));
      }
    };
  }).controller('entryCtrl', [
    '$scope', 'entryStorage', 'filterFilter', '$rootScope', 'logger', function($scope, entryStorage, filterFilter, $rootScope, logger) {
      var entries;
      entries = $scope.entries = entryStorage.get();
      return $scope.newEntry = '';
    }
  ]);

}).call(this);
