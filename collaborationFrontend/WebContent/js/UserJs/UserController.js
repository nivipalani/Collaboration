angular.module('myApp').controller(
		'ucontroller',
		function($scope, $route, $rootScope, $location, $http) {
			var curr = this;
			curr.user = {
				user_Id : 0,
				firstName : '',
				lastName : '',
				password : '',
				emailId : '',
				role : '',
				status : '',
				isOnline : '',
				userType : ''
			};

			curr.submit = submit;
			curr.login = login;

			function submit() {
				curr.user.role = 'student';
				curr.user.status = 'true';
				curr.user.isOnline = 'false';
				$http.post(
						'http://localhost:8080/collaborationmiddleware/user',
						curr.user).then(function(response) {
					alert('Registered Successfully');
				}, function(errResponse) {
					alert('Failed to register');
				})
			}

			function login() {
				$http.post(
						'http://localhost:8080/collaborationmiddleware/login',
						curr.user).then(function(response) {
					alert('Login Successful');
				}, function(errResponse) {
					alert('Login Unsuccessful');
				})
			}

		})