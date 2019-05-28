angular.module('myApp').controller(
		'ucontroller',
		function($scope, $route, $rootScope, $location, $http, $cookieStore) {
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
			};

			curr.submit = submit;
			curr.login = login;

			function submit() {
				curr.user.status = 'true';
				curr.user.isOnline = 'false';
				$http.post(
						'http://localhost:8080/collaborationmiddleware/user',
						curr.user).then(function(response) {
					alert('Registered Successfully');
					reset();
				}, function(errResponse) {
					alert('Failed to register');
				})
			}

			function reset() {
				curr.user = null;
			}
			// function login() {
			//
			// curr.users = curr.user;
			// $http.post(
			// 'http://localhost:8080/collaborationmiddleware/login',
			// curr.user).then(function(response) {
			// curr.user = response.data;
			// console.log("i'm in login function");
			// console.log(curr.users);
			// alert('Login Successful');
			// }, function(errResponse) {
			// alert('Login Unsuccessful');
			// })
			// }

			function login() {
				console.log("I'm in login function");
				$http.post(
						'http://localhost:8080/collaborationmiddleware/login',
						curr.user).then(function(response) {
					curr.user = response.data;
					console.log(curr.user);
					email.id = curr.user.emailId;
					// console.log(email.id);
					$rootScope.currentUser = curr.user;
					console.log($rootScope.currentUser);
					$cookieStore.put('currentUser', $rootScope.currentUser);
					console.log($cookieStore.get('currentUser'));
					$rootScope.usersignedin = true;
					$cookieStore.put('usersignedin', $rootScope.usersignedin);
					console.log('hello');
					if (curr.user.role == "Student") {
						$location.path("/showblog")
					} else if (curr.user.role == "Employee") {
						$location.path("/showjob")
					} else if (curr.user.role = "Employer") {
						$location.path("/job")
					} else {
						$location.path("/")
					}
					alert('Login Successful');

				}, function(errResponse) {
					alert('Login UnSuccessful');
				})
			}

			function logout() {
				console.log('inside logout function');
				$http.post(
						'http://localhost:8080/collaborationmiddleware/logout').then(
						function(response) {
							$rootScope.currentUser = null;
							$cookieStore.remove('currentUser');
							$location.path('/');
							alert('logout successful');
						}, function(errResponse) {
							alert('logout unsuccessful');
						})

			}

		})