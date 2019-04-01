angular.module('myApp').controller(
		'fcontroller',
		function($scope, $route, $rootScope, $location, $http) {
			var curr = this;
			curr.forum = {
				forum_Id : 0,
				forum_Name : '',
				forum_Content : '',
				userdetail : null,
				comment_Date : null,
				forum_status : ''
			}

			curr.add = add;
			curr.forum = [];
			show();

			function add() {
				curr.forum.forum_status = 'NA';
				$http.post(
						'http://localhost:8080/collaborationmiddleware/forum',
						curr.forum).then(function(response) {
					alert('Forum Added');
				}, function(errResponse) {
					alert('Cant add this Forum');
				})

			}
			function show() {
				alert('show forum')
				$http.get('http://localhost:8080/collaborationmiddleware/forum')
						.then(function(response) {
							curr.forum = response.data;
						}, function(errResponse) {
							alert('No forum to display');
						})
			}

		})