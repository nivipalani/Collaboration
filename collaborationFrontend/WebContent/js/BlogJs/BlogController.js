angular
		.module('myApp')
		.controller(
				'bcontroller',
				function($scope, $route, $rootScope, $location, $http, bid,
						blogedit) {
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

					curr.oblog = {
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

					curr.likedislike = {
						dummyid : 0,
						blog : null,
						likecount : 0,
						dislikecount : 0
					};

					curr.add = add;
					curr.reset = reset;
					// curr.addcomment = addcomment;
					curr.selectoneblog = selectoneblog;

					curr.blogs = [];
					// curr.blogcomments = [];

					show();
					// showcomment();
					viewoneblog();

					function add() {
						curr.blog.status = 'NA';
						curr.blog.likes = 0;
						$http
								.post(
										'http://localhost:8080/collaborationmiddleware/blog',
										curr.blog).then(function(response) {
									alert('Blog Added');
									reset();
								}, function(errResponse) {
									alert('Cant add this Blog');
								})

					}

					function reset() {
						curr.blog = null;
						curr.oblog = null;
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
					function selectoneblog(blogid) {
						bid.id = blogid;

						$location.path('/viewoneblog')
					}

					function viewoneblog() {
						alert(bid.id);
						$http.get(
								'http://localhost:8080/collaborationmiddleware/blog/'
										+ bid.id).then(function(response) {

							alert(bid.id);
							if (blogedit.edit == true) {
								curr.oblog = response.data;
								blogedit.edit = false;

							} else {
								// viewmylike();
								curr.blog = response.data;
							}
						}, function(errResponse) {
							alert('NO Blog found');
						})

					}

					curr.updatelike=function(blogid) {
						curr.likedislike.blog.blogId = bid.id;
						curr.likedislike.likecount = (curr.likedislike.likecount + 1);
						$http
								.post(
										'http://localhost:8080/collaborationmiddleware/likedislike',
										curr.likedislike).then(
										function(response) {
											alert('Blog added successfully');
										}, function(errResponse) {
											alert('Blog Not Added');
										})

					}

					// function addcomment() {
					// curr.blogcomment.blog = '';
					// curr.blogcomment.userdetail = '';
					// $http
					// .post(
					// 'http://localhost:8080/collaborationmiddleware/blogcomment',
					// curr.blogcomment).then(
					// function(response) {
					// alert('Comment added');
					//
					// }, function(errResponse) {
					// alert('not added');
					// })
					// }

					// function showcomment() {
					// $http
					// .get(
					// 'https://localhost:8080/collaborationmiddleware/blogcomment')
					// .then(function(response) {
					// curr.blogcomments = response.data;
					//
					// }, function(errResponse) {
					// alert('no comments to display');
					// })
					// }

				})