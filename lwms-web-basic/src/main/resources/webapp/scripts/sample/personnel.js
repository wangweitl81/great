angular.module('myapp_personnel', ["ui.router"])
.config(function($stateProvider, $urlRouterProvider){
      
      // For any unmatched url, send to /populations
      $urlRouterProvider.otherwise('/personnel')
      
      $stateProvider
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
    }]);