angular.module("getMatchUsers.services", ["ngResource"]).
    factory('MatchUser', function ($resource) {
        var MatchUser = $resource('/api/v1/users/:userId', {userId: '@id'});
        MatchUser.prototype.isNew = function(){
            return (typeof(this.id) === 'undefined');
        }
        return MatchUser;
    });


angular.module("getmatchusers", ["getMatchUsers.services"]).
    config(function ($routeProvider) {
        $routeProvider
            .when('/', {templateUrl: '/assets/views/main/info.html', controller: MainController})
            .when('/hs/sitter/faq', {templateUrl: '/assets/views/housesitting/housesitters/faq.html', controller: MainController})
            .when('/hs/owner/faq', {templateUrl: '/assets/views/housesitting/homeowners/faq.html', controller: MainController})
            .when('/list', {templateUrl: '/assets/views/users/list.html', controller: UserListController})
            .when('/users/new', {templateUrl: '/assets/views/users/create.html', controller: UserCreateController})
            .when('/users/:userId', {templateUrl: '/assets/views/users/detail.html', controller: UserDetailController});
    });

function MainController($scope, MatchUser) {
 // Controller for Main Page - dont need to do anything yet
}

function UserListController($scope, MatchUser) {
    $scope.matchusers = MatchUser.query();

}

function UserCreateController($scope, $routeParams, $location, MatchUser) {
    $scope.matchuser = new MatchUser();

    $scope.save = function () {
        $scope.matchuser.$save(function (matchuser, headers) {
            toastr.success("Submitted New MatchUser");
            $location.path('/');
        });
    };
}


function UserDetailController($scope, $routeParams, $location, MatchUser) {
    // http://docs.angularjs.org/api/ngRoute/service/$routeParams
    // http://localhost:9000/#//users/{{user.id}}
    var userId = $routeParams.userId;
    //alert("UID:"+{userId: userId});
    //$scope.matchuser = MatchUser.get({userId: userId});
    $scope.matchuser = MatchUser.get({userId: userId});

}





/** Below was the original from day30 framework of angular integration */

/*angular.module("getbookmarks.services", ["ngResource"]).
    factory('Story', function ($resource) {
        var Story = $resource('/api/v1/stories/:storyId', {storyId: '@id'});
        Story.prototype.isNew = function(){
            return (typeof(this.id) === 'undefined');
        }
        return Story;
    });

angular.module("getbookmarks", ["getbookmarks.services"]).
    config(function ($routeProvider) {
        $routeProvider
            .when('/', {templateUrl: '/assets/views/stories/list.html', controller: StoryListController})
            .when('/stories/new', {templateUrl: '/assets/views/stories/create.html', controller: StoryCreateController})
            .when('/stories/:storyId', {templateUrl: '/assets/views/stories/detail.html', controller: StoryDetailController});
    });

function StoryListController($scope, Story) {
    $scope.stories = Story.query();
    
}

function StoryCreateController($scope, $routeParams, $location, Story) {

    $scope.story = new Story();

    $scope.save = function () {
    	$scope.story.$save(function (story, headers) {
    		toastr.success("Submitted New Story");
            $location.path('/');
        });
    };
}


function StoryDetailController($scope, $routeParams, $location, Story) {
    var storyId = $routeParams.storyId;
    
    $scope.story = Story.get({storyId: storyId});

}*/
