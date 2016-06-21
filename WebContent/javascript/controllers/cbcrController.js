/**
 * 
 */
app.controller('cbcrController', ['$scope','cbcrs', function($scope,cbcrs) {
				cbcrs.success(function(data) {
        $scope.cbcrs = data;
    });
}]);