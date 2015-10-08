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
.config(function($stateProvider, $urlRouterProvider){
      
      // For any unmatched url, send to /populations
      $urlRouterProvider.otherwise('/ran_map')
      
      $stateProvider
        .state('ran', {
            url: "/ran",
            templateUrl: "ran/ran.html"
        })
        .state('ran.map', {
            url: "/ranmap",
            templateUrl: "ran/ran.map.html",
            controller: 'RanMapCtrl'
        })
        .state('ran.aplist', {
            url: "/ranaplist",
            templateUrl: "ran/ran.aplist.html",
            controller: 'RanAPCtrl'
        })
        .state('ran.alarmlist', {
            url: "/ranalarmlist",
            templateUrl: "ran/ran.alarmlist.html",
            controller: 'RanAlarmCtrl'
        });
//        .state('personnel.list.person', {
//          url: '/:id',
//          templateUrl: 'personnel/personnel.list.person.html',
//          controller: function($scope, $stateParams){
//            $scope.id = $stateParams.id
//          }
//        });
    })
    .controller('RanMapCtrl', ['$scope', function($scope){
     // $scope.personnel = [{id:'1', name:"David"}, {id:'2', name:"Jon"}, {id:'3', name:"Tim"}, {id:'4', name:"Don"}];
    	setupHotspots();
    }])
    .controller('RanAPCtrl', ['$scope', '$http', function($scope, $http){
      //$scope.subjects = ['100101', '100201', '100301'];
    	$http.get('/data/ap.json').success(function(data) {
    	    $scope.aplist = data.ap;
    	  });
    }])
    .controller('RanAlarmCtrl', ['$scope', '$http', function($scope, $http){
      //$scope.visits = ["Enr", "Xab", "Conv"];
    	$http.get('/data/alarm.json').success(function(data) {
    	    $scope.alarmlist = data;
    	  });
    }]);