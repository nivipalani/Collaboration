var app = angular.module('myApp', [ 'ngRoute']);
app.value('bid', {
	id : 141
});
app.value('blogedit',{
	edit:false
});


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
	})
});