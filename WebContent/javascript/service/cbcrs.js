/**
 * 
 */
app.factory('cbcrs', ['$http', function($http) { 
  return $http.get('http://localhost:5050/tieDoc/') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);