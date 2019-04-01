angular.module('myApp').controller(
		'jcontroller',
		function($scope, $route, $rootScope, $location, $http) {
			var curr = this;
			curr.job = {
				job_Id : 0,
				job_Profile : '',
				job_description : '',
				qualification : '',
				status : '',
				vacancy : 0,
				salary : 0,
				published_Date : null
			};
			var rest_uri='http://localhost:8080/collaborationmiddleware/job';
			curr.submit = submit;
			curr.jobs=[];
			show();
			function submit() {
//				alert(curr.job.qualification);
//				alert(curr.job.job_description);
//				alert(curr.job.vacancy);
//				alert(curr.job.job_Profile);
//				alert(curr.job.salary);
				curr.job.status = 'true';
				$http.post(rest_uri,
						curr.job).then(function(response) {
					alert('Added Successfully');
				}, function(errResponse) {
					alert('It cant be added');

				})
			}
			function show() {
				alert('show job')
				$http.get('http://localhost:8080/collaborationmiddleware/job')
						.then(function(response) {
							curr.jobs = response.data;
						}, function(errResponse) {
							alert('No jobs to display');
						})
			}
		})
