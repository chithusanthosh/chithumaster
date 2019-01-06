/**
 * 
 */
myApp.controller('DashboardController', 
  ['$scope', '$location','$http',
  function($scope,$location,$http) {
	  $scope.user = JSON.parse(localStorage.getItem('currentUser'));
	  $scope.userfullname = $scope.user.firstname +" "+ $scope.user.lastname;
	  $scope.noUser=true;
	  $scope.loggedUser = false;
}]); //Controller