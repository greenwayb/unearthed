'use strict'

angular.module('app.track', [])

.factory('trackStorage', ->
    STORAGE_ID = 'tracks2'

    # gf.track.username (USERNAME), gf.track.equipmentId (TR019), MEASURECODE=TONNE, gf.track.mesaureValue (45.6), gf.track.source (ARG-N35 A106), gf.track.destination (ARG-AUG1)

    DEMO_TRACKS = '[
        {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.1", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"},
        {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.2", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"},
        {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.3", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"},
        {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.4", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"},
        {"username": "dave", "equipmentId": "TR019", "measureCode" : "TONNE", "measureValue" : "45.5", "source" : "ARG-N35 A106", "destination" : "ARG-AUG1"}
    ]'

    return {
        get: ->
            JSON.parse(localStorage.getItem(STORAGE_ID) || DEMO_TRACKS )

        put: (tracks)->
            localStorage.setItem(STORAGE_ID, JSON.stringify(tracks))
    }
)

.controller('trackCtrl', [
    '$scope', 'trackStorage', '$rootScope', 'logger', '$log'
    ($scope, trackStorage, $rootScope, logger, $log) ->

      tasks = $scope.tracks = trackStorage.get()

      $scope.taskData = {
        username: "Ben",
        equipmentId: "TR019",
        measureCode: "TONNE",
        measureValue: "34.8",
        source: "ARG-N35 A107",
        destination: "ARG-AUG1"
      }

#      task = {
#        username: "default",
#        equipmentId: "default",
#        measureCode: "default",
#        measureValue: "default",
#        source: "default",
#        destination: "default"
#      }

      $scope.pushed = ->
        logger.logSuccess('Pushed or was i?')

      $scope.save = (taskData) ->
        $log.info('taskData ='+JSON.stringify(taskData));
        $scope.newTaskData = taskData
        # task = $scope.taskData

       # newTask = $scope.newTask.trim()
        #newUsername = $scope.username
        #newMeasureValue = taskData.measureValue.trim()
# gf.track.username

        #if newTask.length is 0
        #  return

        tasks.push($scope.newTaskData)

#        tasks.push(
#          username: newUsername
#          equipmentId: ""
#          measureCode: "TONNE"
#          measureValue: measureValue
#          source : ""
#          destination : ""
#        )
       # logger.logSuccess('New task: "' + task.measureValue + '"tonnes added')
        logger.logSuccess('New task: "' + taskData.measureValue + '"tonnes added')
        trackStorage.put(tasks)
        tasks = $scope.tracks = trackStorage.get()


      $scope.username = ''
      $scope.mesaureValue = ''

      $scope.remainingCount++

])

###
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
###
