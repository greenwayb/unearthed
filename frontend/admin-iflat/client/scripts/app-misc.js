angular.module('app').factory('pollingService', ['$http', '$log', function($http,$log){
    var defaultPollingTime = 10000;
    var polls = {};
    var pollCount = 0;

    return {
        poll: function(name,message,pollingTime) {
            if (!polls[name]) {
                var poller = function() {
                    $log.log("polling "+pollCount++);
                }
                poller();
                polls[name] = setInterval(poller, pollingTime || defaultPollingTime);
            }
        },

        startPolling: function(name, url, pollingTime, callback) {
            // Check to make sure poller doesn't already exist
            if (!polls[name]) {
                var poller = function() {
                    $log.log("polling");
//                    $http.get(url).then(callback);
                }
                poller();
                polls[name] = setInterval(poller, pollingTime || defaultPollingTime);
            }
        },

        stopPolling: function(name) {
            clearInterval(polls[name]);
            delete polls[name];
        }
    }
}]);