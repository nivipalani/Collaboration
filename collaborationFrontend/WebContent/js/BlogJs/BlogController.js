angular
		.module('myApp')
		.controller(
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

					curr.blogcomment = {
						blogComment_Id : 0,
						blog : null,
						blog_Comment : '',
						blogComment_Date : null,
						userdetail : null
					};

					curr.add = add;
					curr.addcomment = addcomment;

					curr.blogs = [];
					curr.blogcomments = [];

					show();
					showcomment();

					function add() {
						curr.blog.status = 'NA';
						curr.blog.likes = 0;
						$http
								.post(
										'http://localhost:8080/collaborationmiddleware/blog',
										curr.blog).then(function(response) {
									alert('Blog Added');
								}, function(errResponse) {
									alert('Cant add this Blog');
								})

					}

					function show() {
						alert('show blog')
						$http
								.get(
										'http://localhost:8080/collaborationmiddleware/blog')
								.then(function(response) {
									curr.blogs = response.data;
								}, function(errResponse) {
									alert('No blogs to display');
								})
					}

					function addcomment() {
						$http
								.post(
										'http://localhost:8080/collaborationmiddleware/blogcomment',
										curr.blogcomment).then(
										function(response) {
											alert('Comment added');

										}, function(errResponse) {
											alert('not added');
										})
					}

					function showcomment() {
						$http
								.get(
										'https://localhost:8080/collaborationmiddleware/blogcomment')
								.then(function(response) {
									curr.blogcomments=response.data;

								},function(errResponse)
								{
									alert('no comments to display');
								})
					}

				})