angular.module('myapp_population', ["ui.router"])
.config(function($stateProvider, $urlRouterProvider){
      
      // For any unmatched url, send to /populations
      $urlRouterProvider.otherwise('/populations')
      
      $stateProvider
        .state('admin', {
          url: '/admin',
          templateUrl: 'admin.html'
        })
        .state('populations', {
            url: "/populations",
            templateUrl: "populations/populations.html"
        })
        .state('populations.visits', {
            url: "/visits",
            templateUrl: "populations/populations.visits.html",
            controller: 'VisitCtrl'
        })
        .state('populations.subjects', {
            url: "/subjects",
            templateUrl: "populations/populations.subjects.html",
            controller: 'SubjectCtrl'
        });
    })
    .controller('SubjectCtrl', ['$scope', function($scope){
      $scope.subjects = ['100101', '100201', '100301'];
    }])
    .controller('VisitCtrl', ['$scope', function($scope){
      $scope.visits = ["Enr", "Xab", "Conv"];
    }]);