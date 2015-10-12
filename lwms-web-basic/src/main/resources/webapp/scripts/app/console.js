function setupHotspots() {
    //Width and height
      var w = 100;
      var h = 100;

      var dataset = [ 45, 10, 5, 2];

      var outerRadius = w / 2;
      var innerRadius = w / 2.5;
      var arc = d3.svg.arc()
              .innerRadius(innerRadius)
              .outerRadius(outerRadius);
      
      var pie = d3.layout.pie();
      
      //Easy colors accessible via a 10-step ordinal scale
      //var color = d3.scale.category10();
      var color = d3.scale.ordinal().range(['green', 'yellow', 'red', 'grey']);

      //Create SVG element
      if($("#hot_zone_ca > svg").length == 0) {
        var svg = d3.select("#hot_zone_ca")
            .append("svg")
            .attr("width", w)
            .attr("height", h);
      
        //Set up groups
        var arcs = svg.selectAll("g.arc")
                .data(pie(dataset))
                .enter()
                .append("g")
                .attr("class", "arc")
                .attr("transform", "translate(" + outerRadius + "," + outerRadius + ")");
        
        //Draw arc paths
        arcs.append("path")
            .attr("fill", function(d, i) {
              return color(i);
            })
            .attr("d", arc);

        svg.append("circle")
           .attr("cx", 50)
           .attr("cy", 50)
           .attr("r", 40)
           .attr("fill", "green")
           .attr("class", "ccircle");

        svg.append("text")
          .attr("dy", "2.0em")
          .attr("x", 50)
          .attr("y", 18)
          .style("text-anchor", "middle")
          .attr("class", "inner-circle")
          .attr("fill", "#ffffff")
          .attr("font-size", "20px")
          .text(function(d) { return '45'; });
      }
  }

angular.module('console', ["ui.router"])
.factory('PathInterceptor', ['$location',function($location) {  
    var path = {
        request: function(config) {
        	var path = $location.absUrl(); 
            var pathArray = path.split('/');
            var appContext = pathArray[3];
        	
        	config.url = "/" + appContext + config.url;
  
            return config;
        },
        response: function(response) {
            return response;
        }
    };
    return path;
}])
.config(function($stateProvider, $urlRouterProvider, $httpProvider){
		//$locationProvider.baseHref = "/hello/";
	 $httpProvider.interceptors.push('PathInterceptor');
      // For any unmatched url, send to /populations
      $urlRouterProvider.otherwise('/ran/ran_map')
      
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
    })
    .controller('RanMapCtrl', ['$scope', function($scope){
    	setupHotspots();
    }])
    .controller('RanAPCtrl', ['$scope', '$http', function($scope, $http){
    	$http.get('/data/ap.json').success(function(data) {
    	    $scope.aplist = data.ap;
    	  });
    }])
    .controller('RanAlarmCtrl', ['$scope', '$http', function($scope, $http){
    	$http.get('/data/alarm.json').success(function(data) {
    	    $scope.alarmlist = data;
    	  });
    }]);