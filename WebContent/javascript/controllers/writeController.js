/**
 * 
 */
app.controller('writeController', [ '$scope', function($scope) {
	// $scope.$apply(function() {
	//$scope.myData = DocArray;
	$scope.getData = function() {
		//setTimeout(function() {
			//$scope.$apply(function() {
				// $scope.message = "Timeout called!";
				$scope.myData = DocArray;
				
				$scope.TestCode = TestCode;
				console.log("Fetching data");
			//});
		//}, 1000);

	};
	// });
} ]);