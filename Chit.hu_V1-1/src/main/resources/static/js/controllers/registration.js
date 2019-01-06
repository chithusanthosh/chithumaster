myApp.controller('RegistrationController', 
  ['$scope', '$location','$http',
  function($scope,$location,$http) {
	  $scope.noUser=true;
	  $scope.loggedUser = false;
  $scope.login = function() {
	  $http({
		  method: 'GET',
		  url: 'http://localhost:9090/chitF/usr/login/'+$scope.user.username+'/'+$scope.user.password
		}).then(function successCallback(response) {
			console.log(response.data);
			localStorage.setItem("currentUser",JSON.stringify(response.data));
			$location.url("/dashboard");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
    
  };//login

  $scope.logout = function() {
    
  };//logout

  $scope.register = function() {
	  $http({
		  method: 'POST',
		  headers : {
          	'Content-Type': 'application/json',
          	'Accept': 'text/plain'
          },
		  url: 'http://localhost:9090/chitF/usr/register',
		  data : $scope.user
		}).then(function successCallback(response) {
			console.log(response.data);
			localStorage.setItem("registermsg",response.data);
			$location.url("/success");
		  }, function errorCallback(response) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		  });
  }; //register

}]); //Controller