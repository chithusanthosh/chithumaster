var myApp = angular.module('myApp', 
  ['ngRoute']);

/*myApp.run(['$rootScope', '$location', function($rootScope, $location) {
  $rootScope.$on('$routeChangeError', function(event, next, previous, error) {
    if (error == 'AUTH_REQUIRED') {
      $rootScope.message = 'Sorry, you must log in to access that page';
      $location.path('/login');
    }//Auth Required
  }); //$routeChangeError
}]); *///run

myApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/login', {
      templateUrl: 'views/sigin.html',
      controller: 'RegistrationController'
    }).
    when('/register', {
      templateUrl: 'views/signup.html',
      controller: 'RegistrationController'
    }).
    when('/success', {
      templateUrl: 'views/success.html',
      controller: 'SuccessController'
    }).
    when('/dashboard',{
    	templateUrl : 'views/dashboard.html',
    	controller : 'DashboardController'
    }).
    when('/creategroup',{
    	templateUrl: 'views/groupcreate.html',
    	controller : 'GroupCreationController'
    }).
    when('/viewtrans',{
    	templateUrl: 'views/viewtrans.html',
    	controller : 'viewTransController'
    }).
    when('/forwpas',{
    	templateUrl : 'views/forgot-password.html',
    	controller : 'RegistrationController'
    }).
    otherwise({
      redirectTo: '/login'
    });
}]);