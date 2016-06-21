/**
 * 
 */
app.controller('tableController', ['$scope','cbcrs', '$routeParams', function($scope,cbcrs ,$routeParams) {
  // Your code here
  books.success(function(data) {
    $scope.table = data[$routeParams.Id];  

  });

  // Using this property to create the URL in line 9 of views/book.html
  $scope.currentCbcrIndex = parseInt($routeParams.Id);


}]);