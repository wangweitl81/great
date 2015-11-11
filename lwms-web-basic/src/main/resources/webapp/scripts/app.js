/*global angular */

/**
 * The main app module
 *
 * @type {angular.Module}
 */
angular.module('console', ["ui.router"])
.config(function($stateProvider, $urlRouterProvider, $locationProvider){
		//$locationProvider.baseHref = "/hello/";
	// $httpProvider.interceptors.push('PathInterceptor');
      // For any unmatched url, send to /populations
      $urlRouterProvider.otherwise('/ran/ran_map');
      
      $stateProvider
        .state('ran', {
        	url: '/ran',
            templateUrl: "/console/ran/ran.htm"
        })
        .state('ran.map', {
        	url: '/ran_map',
            templateUrl: "/console/ran/ran.map.html",
            controller: 'RanMapCtrl'
        })
        .state('ran.aplist', {
        	url: '/ran_aplist',
            templateUrl: "/console/ran/ran.aplist.htm",
            controller: 'RanAPCtrl'
        })
        .state('ran.alarmlist', {
        	url: '/ran_alarmlist',
            templateUrl: "/console/ran/ran.alarmlist.htm",
            controller: 'RanAlarmCtrl'
        });
      
     // $locationProvider.html5Mode(true);
    });
