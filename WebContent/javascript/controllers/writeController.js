/**
 * 
 */
app.controller('writeController', [ '$scope', function($scope) {
	// $scope.$apply(function() {
	// $scope.myData = DocArray;
	$scope.getData = function() {
		// setTimeout(function() {
		// $scope.$apply(function() {
		// $scope.message = "Timeout called!";
		$scope.myData = DocArray;

		// });
		// }, 1000);
	};

	// fail test
	/*
	 * $scope.getData = function() { // setTimeout(function() { //
	 * $scope.$apply(function() { // $scope.message = "Timeout called!"; //
	 * $scope.myData = DocArray;// DocArray; // $scope.TestCode = TestCode; //
	 * console.log("Fetching data"); // }); // }, 1000); $scope.myData = {
	 * columnDefs : [ { name : 'COOD', field : 'code' }, { name : '1stFriend',
	 * field : 'name' }, { name : 'TITLE', field : 'description' }], data :
	 * DocArray }; console.log("DocArray"+DocArray[0].code); };
	 */
	// });
} ]);