var app=angular.module('myApp',['ngRoute']);
app.config(function($routeProvider){
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
	})
	.when("/showjob", {
		templateUrl : "viewalljob.html"
	})
});