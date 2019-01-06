myApp.controller('SuccessController', ['$scope', function($scope) {

	$scope.currentUser = JSON.parse(localStorage.getItem('currentUser'));
	$scope.registermsg = localStorage.getItem('registermsg');
	
	if(!($scope.registermsg === "null")){
		if($scope.registermsg == 10){
			$scope.message = "Mobile no already registered";
			localStorage.setItem("registermsg",null);
			/*$scope.registermsg = null;*/
		}else if($scope.registermsg == 00){
			$scope.message = "Registered successful, You will get username to your mobile for login";
			localStorage.setItem("registermsg",null);
			/*$scope.registermsg = null;*/
		}else if($scope.registermsg == 50){
			$scope.message = "Unexpected error please contact support";
			localStorage.setItem("registermsg",null);
			/*$scope.registermsg = null;*/
		}else if($scope.registermsg == 20){
			$scope.message = "Unexpected error please contact support";
			localStorage.setItem("registermsg",null);
			/*$scope.registermsg = null;*/
		}
		
	}else{
		$scope.message = $scope.currentUser.firstname+" "+$scope.currentUser.lastname;
	}
}]);