var app = angular.module('myApp', [ 'ngRoute', 'ngCookies' ]);
app.value('bid', {
	id : 141
});
app.value('blogedit', {
	edit : false
});
app.value('forumid', {
	id : 110
})

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "home.html"
	}).when("/login", {
		templateUrl : "login.html"
	}).when("/register", {
		templateUrl : "register.html"
	}).when("/blog", {
		templateUrl : "blog.html"
	}).when("/forum", {
		templateUrl : "forum.html"
	}).when("/job", {
		templateUrl : "job.html"
	}).when("/showblog", {
		templateUrl : "viewallblogs.html"
	}).when("/showforum", {
		templateUrl : "viewallforum.html"
	}).when("/showjob", {
		templateUrl : "viewalljobs.html"
	}).when("/comment", {
		templateUrl : "comment.html"
	}).when("/viewoneblog", {
		templateUrl : "viewoneblog.html"
	}).when("/viewoneforum", {
		templateUrl : "viewoneforum.html"
	})
});

app
		.run(function($rootScope, $location, $http, $cookieStore) {

			console.log('am in run function');
			if($rootScope.currentUser==undefined)
				{
				console.log($cookieStore.get('currentUser'));
				$rootScope.currentUser=$cookieStore.get('currentUser');
				}
			//$rootScope.currentUser = $cookieStore.get('currentUser') || null;
			if ($rootScope.currentUser) {
				$http.defaults.headers.common['Authorization'] = 'Basic'
						+ $rootScope.currentUser;
			}

			$rootScope
					.$on(
							'$locationChangeStart',
							function(event, next, current) {
								var isLoggedIn = $cookieStore
										.get('usersignedin');
								var erole = $rootScope.currentUser.role;
								console.log(erole);
								var email = $rootScope.currentUser.emailId;
								console.log(email);
								var studentPages = [ '/blog', '/showblog',
										'/viewoneblog', '/showforum' ]
								var employeePages = [ '/showjob' ]
								var companyPages = [ '/job' ]
								var adminPages = [ '/forum' ]
								var currentPage = $location.path()
								var isStudentPage = $.inArray(currentPage,
										studentPages) >= 0;
								var isAdminPage = $.inArray(currentPage,
										adminPages) >= 0;
								var isEmployeePage = $.inArray(currentPage,
										employeePages) >= 0;
								var isCompanyPage = $.inArray(currentPage,
										companyPages) >= 0;

								if (!isLoggedIn) {
									if (isStudentPage || isAdminPage
											|| isEmployeePage || isCompanyPage) {
										alert('You have to log in to view this page');
										$location.path('/login');
									}
								} else {
									if (erole == 'Admin') {
										if (isEmployeePage || isCompanyPage) {
											alert('You are not able to do this operation as you are logged as : '
													+ erole);
											$location.path('/');
										}
									} else if (erole == 'Employee') {
										if (isCompanyPage || isAdminPage) {
											alert("You are not able to do this operation as you are logged as : "
													+ erole);
											$location.path('/');
										}
									} else if (erole == 'Employer') {
										if (isAdminPage) {
											alert("You are not able to do this operation as you are logged as : "
													+ erole);
											$location.path('/');
										}
									} else {
										if (isAdminPage || isEmployeePage
												|| isCompanyPage) {
											alert("You are not able to do this operation as you are logged as : "
													+ erole);
											$location.path('/');
										}
									}
								}
							})
		});