(function() {
  'use strict';
  angular.module('app', ['ngRoute', 'ngAnimate', 'ui.bootstrap', 'easypiechart', 'mgo-angular-wizard', 'app.ui.ctrls', 'app.ui.services', 'app.controllers', 'app.directives', 'app.form.validation', 'app.ui.form.ctrls', 'app.ui.form.directives', 'app.tables', 'app.task', 'app.sse', 'app.entry', 'app.track', 'app.localization', 'app.chart.ctrls', 'app.chart.directives']).config([
    '$routeProvider', function($routeProvider) {
      return $routeProvider.when('/', {
        redirectTo: '/dashboard'
      }).when('/dashboard', {
        templateUrl: 'views/dashboard.html'
      }).when('/ui/typography', {
        templateUrl: 'views/ui/typography.html'
      }).when('/ui/buttons', {
        templateUrl: 'views/ui/buttons.html'
      }).when('/ui/icons', {
        templateUrl: 'views/ui/icons.html'
      }).when('/ui/grids', {
        templateUrl: 'views/ui/grids.html'
      }).when('/ui/widgets', {
        templateUrl: 'views/ui/widgets.html'
      }).when('/ui/components', {
        templateUrl: 'views/ui/components.html'
      }).when('/forms/elements', {
        templateUrl: 'views/forms/elements.html'
      }).when('/forms/layouts', {
        templateUrl: 'views/forms/layouts.html'
      }).when('/forms/validation', {
        templateUrl: 'views/forms/validation.html'
      }).when('/forms/wizard', {
        templateUrl: 'views/forms/wizard.html'
      }).when('/tables/static', {
        templateUrl: 'views/tables/static.html'
      }).when('/tables/responsive', {
        templateUrl: 'views/tables/responsive.html'
      }).when('/tables/dynamic', {
        templateUrl: 'views/tables/dynamic.html'
      }).when('/charts/others', {
        templateUrl: 'views/charts/charts.html'
      }).when('/charts/morris', {
        templateUrl: 'views/charts/morris.html'
      }).when('/charts/flot', {
        templateUrl: 'views/charts/flot.html'
      }).when('/pages/features', {
        templateUrl: 'views/pages/features.html'
      }).when('/pages/signin', {
        templateUrl: 'views/pages/signin.html'
      }).when('/pages/signup', {
        templateUrl: 'views/pages/signup.html'
      }).when('/pages/profile', {
        templateUrl: 'views/pages/profile.html'
      }).when('/trucks/status', {
        templateUrl: 'views/trucks/status.html'
      }).when('/trucks/history', {
        templateUrl: 'views/trucks/history.html'
      }).when('/404', {
        templateUrl: 'views/pages/404.html'
      }).when('/pages/500', {
        templateUrl: 'views/pages/500.html'
      }).when('/tasks', {
        templateUrl: 'views/tasks/tasks.html'
      }).when('/gf/tasks', {
        templateUrl: 'views/gf/tasks/tasks.html'
      }).when('/gf/trackItems', {
        templateUrl: 'views/gf/tasks/trackItems.html'
      }).when('/gf/simpleForm', {
        templateUrl: 'views/gf/tasks/simpleForm.html'
      }).when('/gf/entries', {
        templateUrl: 'views/gf/entries/entires.html'
      }).when('/gf/entryItems', {
        templateUrl: 'views/gf/entries/entryItems.html'
      }).when('/gf/entryEvents', {
        templateUrl: 'views/gf/entries/entryEvents.html'
      }).otherwise({
        redirectTo: '/404'
      });
    }
  ]);

}).call(this);
