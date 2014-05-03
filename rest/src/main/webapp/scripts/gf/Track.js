(function() {
  'use strict';
  angular.module('app.track', []).factory('trackStorage', function() {
    var DEMO_TRACKS, STORAGE_ID;
    STORAGE_ID = 'tracks';
    DEMO_TRACKS = '[ {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}, {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}, {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}, {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}, {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.6", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"} ]';
    return {
      get: function() {
        return JSON.parse(localStorage.getItem(STORAGE_ID) || DEMO_TRACKS);
      },
      put: function(tracks) {
        return localStorage.setItem(STORAGE_ID, JSON.stringify(tracks));
      }
    };
  }).controller('trackCtrl', [
    '$scope', 'trackStorage', '$rootScope', 'logger', '$log', function($scope, trackStorage, $rootScope, logger, $log) {
      var tasks;
      tasks = $scope.tracks = trackStorage.get();
      $scope.pushed = function() {
        return logger.logSuccess('Pushed or was i?');
      };
      return $scope.save = function(taskData) {
        $log.info('taskData =' + taskData);
        $scope.newTaskData = taskData;
        tasks.push($scope.newTaskData);
        logger.logSuccess('New task: "' + taskData + '"tonnes added');
        trackStorage.put(tasks);
        $scope.username = '';
        $scope.mesaureValue = '';
        return $scope.remainingCount++;
      };
    }
  ]);


  /*
  .directive('taskFocus', [
      '$timeout'
      ($timeout) ->
          return {
              link: (scope, ele, attrs) ->
                  scope.$watch(attrs.taskFocus, (newVal) ->
                      if newVal
                          $timeout( ->
                              ele[0].focus()
                          , 0, false)
                  )
          }
  ])
  
  .controller('trackCtrl', [
      '$scope', 'taskStorage', 'filterFilter', '$rootScope', 'logger'
      ($scope, taskStorage, filterFilter, $rootScope, logger) ->
  
          tasks = $scope.tasks = taskStorage.get()
  
          $scope.newTask = ''
          $scope.remainingCount = filterFilter(tasks, {completed: false}).length
          $scope.editedTask = null
          $scope.statusFilter = {completed: false}
  
          $scope.filter = (filter) ->
              switch filter
                  when 'all' then $scope.statusFilter = ''
                  when 'active' then $scope.statusFilter = {completed: false}
                  when 'completed' then $scope.statusFilter = {completed: true}
  
          $scope.add = ->
              newTask = $scope.newTask.trim()
  
              if newTask.length is 0
                  return
  
              tasks.push(
                  title: newTask
                  completed: false
              )
              logger.logSuccess('New task: "' + newTask + '" added')
  
              taskStorage.put(tasks)
  
              $scope.newTask = ''
              $scope.remainingCount++
  
          $scope.edit = (task)->
              $scope.editedTask = task
  
          $scope.doneEditing = (task) ->
              $scope.editedTask = null
              task.title = task.title.trim()
  
              if !task.title
                  $scope.remove(task)
              else
                  logger.log('Task updated')
              taskStorage.put(tasks)
  
          $scope.remove = (task) ->
              $scope.remainingCount -= if task.completed then 0 else 1
              index = $scope.tasks.indexOf(task)
              $scope.tasks.splice(index, 1)
              taskStorage.put(tasks)
              logger.logError('Task removed')
  
          $scope.completed = (task) ->
              $scope.remainingCount += if task.completed then -1 else 1
              taskStorage.put(tasks)
              if task.completed
                  if $scope.remainingCount > 0
                      if $scope.remainingCount is 1
                          logger.log('Almost there! Only ' + $scope.remainingCount + ' task left')
                      else
                          logger.log('Good job! Only ' + $scope.remainingCount + ' tasks left')
                  else
                      logger.logSuccess('Congrats! All done :)')
  
          $scope.clearCompleted = ->
              $scope.tasks = tasks = tasks.filter( (val) ->
                  return !val.completed
              )
              taskStorage.put(tasks)
  
          $scope.markAll = (completed)->
              tasks.forEach( (task) ->
                  task.completed = completed
              )
              $scope.remainingCount = if completed then 0 else tasks.length
              taskStorage.put(tasks)
              if completed
                  logger.logSuccess('Congrats! All done :)')
  
          $scope.$watch('remainingCount == 0', (val) ->
              $scope.allChecked = val
          )
  
          $scope.$watch('remainingCount', (newVal, oldVal) ->
              $rootScope.$broadcast('taskRemaining:changed', newVal) 
          )
  ])\
   */

}).call(this);
