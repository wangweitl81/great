angular.module('myapp', ["ui.router"])
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
        })
        .state('personnel', {
            url: "/personnel",
            templateUrl: "personnel/personnel.html"
        })
        .state('personnel.list', {
          url: '/list',
          templateUrl: 'personnel/personnel.list.html',
          controller: 'PersonnelCtrl'
        })
        .state('personnel.list.person', {
          url: '/:id',
          templateUrl: 'personnel/personnel.list.person.html',
          controller: function($scope, $stateParams){
            $scope.id = $stateParams.id
          }
        });
    })
    .controller('PersonnelCtrl', ['$scope', function($scope){
      $scope.personnel = [{id:'1', name:"David"}, {id:'2', name:"Jon"}, {id:'3', name:"Tim"}, {id:'4', name:"Don"}];
    }])
    .controller('SubjectCtrl', ['$scope', function($scope){
      $scope.subjects = ['100101', '100201', '100301'];
    }])
    .controller('VisitCtrl', ['$scope', function($scope){
      $scope.visits = ["Enr", "Xab", "Conv"];
    }]);