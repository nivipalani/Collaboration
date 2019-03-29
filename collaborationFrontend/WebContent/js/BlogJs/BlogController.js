angular.module('myApp').controller(
		'bcontroller',
		function($scope, $route, $rootScope, $location, $http) {
			var curr = this;
			curr.blog = {
				blogId : 0,
				blogName : '',
				blogContent : '',
				userdetail : null,
				createDate : null,
				status : '',
				likes : 0
			};

			curr.add = add;

			function add() {
				curr.blog.status = 'NA';
				curr.blog.likes = 0;
				$http.post(
						'http://localhost:8080/collaborationmiddleware/blog',
						curr.blog).then(function(response) {
					alert('Blog Added');
				}, function(errResponse) {
					alert('Cant add this Blog');
				})

			}

		})