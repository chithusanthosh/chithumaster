/**
 * 
 */
myApp.controller('GroupCreationController', 
  ['$scope', '$location','$http',
  function($scope,$location,$http) {
	 $scope.tempmobno = [];
	 $scope.storemobno = function(){
		 $scope.tempmobno.push($scope.subscriber.mobile);
		 console.log($scope.tempmobno);
		 $scope.mobilenolist = $scope.tempmobno;
	 } 
	 
	 $scope.addpeople = function(){
		 
		 var modalInstance = $uiModal.open({
			 templateUrl: "views/addpeople.html",
		      controller: "ModalContentCtrl",
		 })
	 }
	  
  }]);
