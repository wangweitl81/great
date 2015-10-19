describe('mocking service http call', function() {
	var $httpBackend, RanAPCtrl, $rootScope, requestHandler;
	beforeEach(module('console'));


/*
.controller('RanAPCtrl', ['$scope', '$http', function($scope, $http){
      $http.get('/data/ap.json').success(function(data) {
          $scope.aplist = data.ap;
        });
    }])
*/

//  describe('with httpBackend', function() {
    beforeEach(inject(function($injector) {
      //$scope = $rootScope.$new();
      $httpBackend = $injector.get('$httpBackend');
      requestHandler = $httpBackend.when('GET', '/data/ap.json')
        .respond({ap: [{id: 1, name: "Cupertino-A001", status: "green", ip:"172.32.2.3", region:  "California", uptime: "10h20m" }]});

      $rootScope = $injector.get('$rootScope');
      var $controller = $injector.get('$controller');
      
      
      //RanAPCtrl = $controller('RanAPCtrl', { $scope: $scope });
      //$httpBackend.flush();
      
      createController = function() {
    	  return $controller('RanAPCtrl', {'$scope' : $rootScope});
      };
    }));
    
    it('should set data to a list of ap information', function() {
    	var controller = createController();
    	$httpBackend.flush();
    	
      expect($rootScope.aplist).toEqual(
       [{id: 1, name: "Cupertino-A001", status: "green", ip:"172.32.2.3", region:  "California", uptime: "10h20m" }]
      );
    });
//  });
});