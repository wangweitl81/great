angular.module('console') 
.controller("globalCtrl", function GlobalCtrl($scope){
	$scope.showNav = false;
	$scope.enterNav = function() {
		console.log("in leaveNav");
		$scope.showNav = true;
	};
	
	$scope.leaveNav = function() {
		console.log("in showNav");
		$scope.showNav = false;
	};
	
	$scope.$on('$viewContentLoaded', function() {
		$scope.onDocReady();
	});
	
	$scope.onDocReady = function() {
		 //handle the navigator
	    $("#text_navigator .text_navigator_item_text").bind("mouseover", function(){
	        $(this).css("color", "#0000aa");
	    }).bind("mouseout", function() {
	        $(this).css("color", "white");
	    });

	    $("#search_icon").bind("click", function() {
	      $("#search_bar").addClass("highlight");
	    });

	    //handle the tab switcher
	    $("body").delegate(".tab_item a", "click", function(){
	      var parentNode = $(this).parent().parent();
	      var tab_item_id = parentNode.attr("id").substr(4);

	      //set the select status
	      $(".tab_item").removeClass("selected");
	      parentNode.addClass("selected");
	    });

	    $(".ap_list_selector_icon p").bind("click", function(){
	        var parentNode = $(this).parent();
	        var color = parentNode.attr("class").substr(22);
	        console.log(color);

	        $("#ap_list .table_record").css("display", "none");
	        $("#ap_list .table_record").filter(function(index){
	            var classname = $(this).children().eq(0).attr("class");
	            console.log(classname + " " + color );
	            console.log(classname.indexOf(color));
	            return classname.indexOf(color) > 0;
	        }).css("display", "block");
	    });
	};
});