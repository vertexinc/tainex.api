/**
 * 
 */
'use strict';


var app = angular
  .module('tieappApp', ['ngRoute']);
app.config(function ($routeProvider) {
  $routeProvider
    .when('/main', {
      controller: 'main',
      templateUrl: 'views/main.jsp'
    })
    .when('/read', {
      controller: 'cbcrController',
      templateUrl: 'views/read.jsp'
    })
    .when('/read2', {
      controller: 'cbcrController',
      templateUrl: 'views/read2.jsp'
    })
    .when('/read2/:id', { 
      controller: 'tableController', 
      templateUrl: 'views/table.jsp' 
    })
    .when('/write', {
      controller: 'cbcrController',
      templateUrl: 'views/write.jsp'
    })
    .when('/success', {
      controller: 'main',
      templateUrl: 'views/success.jsp'
    })
    .otherwise({
      redirectTo: '/write'
    });
});

/*
angular
	.module('tieappApp', ['ui.router'])
	.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
		$urlRouterProvider.otherwise('/main');
		$stateProvider
			.state('read2',{
				url:'/read2',
				templateUrl: 'views/read2.jsp',
				controller: 'cbcrController',
				controller:'cbcrController as cbcrC'
			})
			.state('table',{
				url:'/table/:id',
				templateUrl: 'views/table.jsp',
				controller: 'cbcrController',
				controller:'cbcrController as cbcrC'
			})
	}]);*/