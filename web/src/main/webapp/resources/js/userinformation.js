var educationCount = 0;
var projectCount = 0;
var certificationCount = 0;
$(function() {
	function sendAjax() {
		var data = JSON.stringify({
			position : $('#position').val(),
			summary : $('#summary').val(),
			birthDate : 1000 * moment($('#birthdate').val()).unix(),
			programmingLanguages : $('#programminglanguages').val(),
			technologies : $('#technologies').val(),
			rdbms : $('#rdbms').val(),
			methodologies : $('#methodologies').val(),
			frameworks : $('#frameworks').val(),
			webServers : $('#webservers').val(),
			tools : $('#tools').val(),
			testingTools : $('#testingtools').val(),
			operatingSystems : $('#operatingsystems').val(),
			hardware : $('#hardware').val(),
		});
		$.ajax({
			url : 'userinformation',
			type : 'POST',
			dataType : 'text',
			contentType : 'application/json',
			data : data,
			success : function(response) {

			},
			error : function(er) {
				showErrorMessage('#well');
			}
		});
		var educationArr = new Array();
		for (var i = 0; i <= educationCount; i++) {
			var data = {
				schoolName : $('#schoolName-' + i).val(),
				university : $('#university-' + i).val(),
				degreeReceived : $('#degreeReceived-' + i).val(),
				department : $('#department-' + i).val(),
				graduationYear : $('#graduationYear-' + i).val(),
			}
			educationArr.push(data);
		}
		$.ajax({
			url : 'userinformation/education',
			type : 'POST',
			dataType : 'text',
			contentType : 'application/json',
			data : JSON.stringify(educationArr),
			success : function(response) {

			},
			error : function(er) {
				showErrorMessage('#well');
			}
		});
		var projectArr = new Array();
		for (var i = 0; i <= projectCount; i++) {
			var data = {
				description : $('#description-' + i).val(),
				customer : $('#customer-' + i).val(),
				role : $('#role-' + i).val(),
				teamSize : $('#teamSize-' + i).val(),
				involvementDuration : $('#involvementDuration-' + i).val(),
				tools : $('#tools-' + i).val(),
			}
			console.log(i + "test");
			debugger
			projectArr.push(data);
		}
		$.ajax({
			url : 'userinformation/project',
			type : 'POST',
			dataType : 'text',
			contentType : 'application/json',
			data : JSON.stringify(projectArr),
			success : function(response) {

			},
			error : function(er) {
				showErrorMessage('#well');
			}
		});
		var certificationArr = new Array();
		for (var i = 0; i <= certificationCount; i++) {
			var data = {
				name : $('#name-' + i).val(),
				yearReceived : $('#yearReceived-' + i).val(),
			}
			certificationArr.push(data);
		}
		$.ajax({
			url : 'userinformation/certification',
			type : 'POST',
			dataType : 'text',
			contentType : 'application/json',
			data : JSON.stringify(certificationArr),
			success : function(response) {
				top.location.href = 'templates';
			},
			error : function(er) {
				showErrorMessage('#well');
			}
		});

	}
	$('#savebutton').click(function() {
		sendAjax();
	});
});

$(document).ready(function() {
	$('#datePicker').datepicker({
		format : 'mm-dd-yyyy'
	}).on('changeDate', function(e) {
		$('#eventForm').formValidation('revalidateField', 'date');
	});
});

$(function() {
	$('#next').click(
			$(document).ready(function() {
				$.ajax({
					type : 'GET',
					url : 'userinformation/result',
					dataType : 'json',
					contentType : 'application/json',
					success : function(response) {
						$('#nextfields').prepend(
								'<div class="form-group col-lg-12">'
									+ '<input name="programminglanguages" class="form-control"'
									+ '	id="programminglanguages" placeholder="Programming Languages">'
									+ '</div>'
									+ '<div class="form-group col-lg-12">'
									+ '<input name="technologies" class="form-control" id="technologies"'
									+ 'placeholder="Technologies">'
									+ '</div>'
									+ '<div class="form-group col-lg-12">'
									+ '<input name="rdbms" class="form-control" id="rdbms"'
									+ 'placeholder="RDBMS">'
									+ '</div>'
									+ '<div class="form-group col-lg-12">'
									+ '<input name="methodologies" class="form-control" id="methodologies"'
									+ 'placeholder="Methodologies">'
									+ '</div>'
									+ '<div class="form-group col-lg-12">'
									+ '<input name="frameworks" class="form-control" id="frameworks"'
									+ 'placeholder="Frameworks">'
									+ '</div>'
									+ '<div class="form-group col-lg-12">'
									+ '<input name="webservers" class="form-control" id="webservers"'
									+ 'placeholder="Web Servers">'
									+ '</div>'
									+ '<div class="form-group col-lg-12">'
									+ '<input name="tools" class="form-control" id="tools"'
									+ 'placeholder="Tools">'
									+ '</div>'
									+ '<div class="form-group col-lg-12">'
									+ '<input name="testingtools" class="form-control" id="testingtools"'
									+ 'placeholder="Testing Tools">'
									+ '</div>'
									+ '<div class="form-group col-lg-12">'
									+ '<input name="operatingsystems" class="form-control"'
									+ 'id="operatingsystems" placeholder="Operating Systems">'
									+ '</div>'
									+ '<div class="form-group col-lg-12">'
									+ '<input name="hardware" class="form-control" id="hardware" '
									+ 'placeholder="Hardware">'
									+ '</div>'
						);
						$('#next').hide();
						$('#programminglanguages').val(response.programmingLanguages);
						$('#technologies').val(response.technologies);
						$('#rdbms').val(response.rdbms);
						$('#methodologies').val(response.methodologies)
						$('#frameworks').val(response.frameworks);
						$('#webservers').val(response.webServers);
						$('#tools').val(response.tools);
						$('#testingtools').val(response.testingTools);
						$('#operatingsystems').val(response.operatingSystems);
						$('#hardware').val(response.hardware);
						},
						error : function(error) {
						}
						});
				}));});

$(function() {
	$('#addeducation').click(
			function() {
				educationCount++;
				$('#education').append(
						'<div class="form-group col-lg-6">'
							+ '<input type="text" class="form-control" id="schoolName-'
							+ educationCount
							+ '"name="schoolName" placeholder="School Name">'
							+ '</div>'
							+ '<div class="form-group col-lg-6">'
							+ '<input type="text" class="form-control" id="university-'
							+ educationCount
							+ '"name="university" placeholder="University">'
							+ '</div>'
							+ '<div class="form-group col-lg-4">'
							+ '<input type="text" class="form-control" id="degreeReceived-'
							+ educationCount
							+ '"name="degreeReceived" placeholder="Degree Received">'
							+ '</div>'
							+ '<div class="form-group col-lg-4">'
							+ '<input type="text" class="form-control" id="department-'
							+ educationCount
							+ '"name="department" placeholder="Department">'
							+ '</div>'
							+ '<div class="form-group col-lg-4">'
							+ '<input type="number" class="form-control" id="graduationYear-'
							+ educationCount
							+ '"name="graduationYear" placeholder="Graduation Year">'
							+ '<br></div>'
				);
			}
		);
	}
);


$(function() {
	$('#addproject').click(
			function() {
				projectCount++;
				$('#project').append(
						'<div class="form-group col-lg-8">'
							+ '<input type="text" class="form-control" id="description-'
							+ projectCount
							+ '"name="description" placeholder="Description">'
							+ '</div>'
							+ '<div class="form-group col-lg-4">'
							+ '<input type="text" class="form-control" id="customer-'
							+ projectCount
							+ '"name="customer" placeholder="Customer">'
							+ '</div>'
							+ '<div class="form-group col-lg-4">'
							+ '<input type="number" class="form-control" id="teamSize-'
							+ projectCount
							+ '"name="teamSize" placeholder="Team Size">'
							+ '</div>'
							+ '	<div class="form-group col-lg-4">'
							+ '<input type="text" class="form-control" id="involvementDuration-'
							+ projectCount
							+ '"name="involvementDuration" placeholder="Involvement Duration">'
							+ '</div>'
							+ '<div class="form-group col-lg-4">'
							+ '<input type="text" class="form-control" id="tools-'
							+ projectCount
							+ '"name="tools"'
							+ 'placeholder="Tools">'
							+ '<br></div>'
				);
			}
		);
	}
);
$(function() {
	$('#addcertification').click(
			function() {
				certificationCount++;
				$('#certification').append(
						'<div class="form-group col-lg-8">'
							+ '<input type="text" class="form-control" id="name-'
							+ certificationCount
							+ '"name="name" placeholder="Name">'
							+ '</div>'
							+ '<div class="form-group col-lg-4">'
							+ '<input type="number" class="form-control" id="yearReceived-'
							+ certificationCount
							+ '"name="yearReceived" placeholder="Year Received" required>'
							+ '<br></div>'
				);
			}
		);
	}
);
$(document).ready(
		function() {
			$.ajax({
				type : 'GET',
				url : 'userinformation/result',
				dataType : 'json',
				contentType : 'application/json',
				success : function(response) {
					$('#position').val(response.position);
					$('#summary').val(response.summary);
					if (response.birthDate != null) {
						$('#birthdate').val(moment(response.birthDate).format('MM-DD-YYYY'));
					}
				},
				error : function(error) {
				}
			}
		)
	}
);

$.ajax({
	type : 'GET',
	url : 'userinformation/education/current',
	dataType : 'json',
	contentType : 'application/json',
	success : function(response) {
		for (; educationCount < response.length; educationCount++) {
			$('#education').append(
					'<div class="form-group col-lg-6">'
						+ '<input type="text" class="form-control" id="schoolName-'
						+ educationCount
						+ '"name="schoolName" placeholder="School Name">'
						+ '</div>'
						+ '<div class="form-group col-lg-6">'
						+ '<input type="text" class="form-control" id="university-'
						+ educationCount
						+ '"name="university" placeholder="University">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="degreeReceived-'
						+ educationCount
						+ '"name="degreeReceived" placeholder="Degree Received">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="department-'
						+ educationCount
						+ '"name="department" placeholder="Department">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="number" class="form-control" id="graduationYear-'
						+ educationCount
						+ '"name="graduationYear" placeholder="Graduation Year">'
						+ '<br></div>'
			);
			$('#schoolName-' + educationCount).val(response[educationCount].schoolName);
			$('#university-' + educationCount).val(response[educationCount].university);
			$('#degreeReceived-'+ educationCount).val(response[educationCount].degreeReceived);
			$('#department-' + educationCount).val(response[educationCount].department);
			$('#graduationYear-'+ educationCount).val(response[educationCount].graduationYear);
		}
		if (educationCount === 0) {
			$('#education').append(
					'<div class="form-group col-lg-6">'
						+ '<input type="text" class="form-control" id="schoolName-'
						+ educationCount
						+ '"name="schoolName" placeholder="School Name">'
						+ '</div>'
						+ '<div class="form-group col-lg-6">'
						+ '<input type="text" class="form-control" id="university-'
						+ educationCount
						+ '"name="university" placeholder="University">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="degreeReceived-'
						+ educationCount
						+ '"name="degreeReceived" placeholder="Degree Received">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="department-'
						+ educationCount
						+ '"name="department" placeholder="Department">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="number" class="form-control" id="graduationYear-'
						+ educationCount
						+ '"name="graduationYear" placeholder="Graduation Year">'
						+ '<br></div>'
			);
			}
		},
		error : function(err) {
		}
	}
);
$.ajax({
	type : 'GET',
	url : 'userinformation/project/current',
	dataType : 'json',
	contentType : 'application/json',
	success : function(response) {
		for (; projectCount < response.length; projectCount++) {
			$('#project').append(
					'<div class="form-group col-lg-8">'
						+ '<input type="text" class="form-control" id="description-'
						+ projectCount
						+ '"name="description" placeholder="Description">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="customer-'
						+ projectCount
						+ '"name="customer" placeholder="Customer">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="number" class="form-control" id="teamSize-'
						+ projectCount
						+ '"name="teamSize" placeholder="Team Size">'
						+ '</div>'
						+ '	<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="involvementDuration-'
						+ projectCount
						+ '"name="involvementDuration" placeholder="Involvement Duration">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="tools-'
						+ projectCount
						+ '"name="tools"'
						+ 'placeholder="Tools">'
						+ '<br></div>'
			);
			$('#description-' + projectCount).val(response[projectCount].description);
			$('#customer-' + projectCount).val(response[projectCount].customer);
			$('#teamSize-' + projectCount).val(response[projectCount].teamSize);
			$('#involvementDuration-'+ projectCount).val(response[projectCount].involvementDuration);
			$('#tools-' + projectCount).val(response[projectCount].tools);
			}
		if (projectCount === 0) {
			$('#project')
			.append('<div class="form-group col-lg-8">'
						+ '<input type="text" class="form-control" id="description-'
						+ projectCount
						+ '"name="description" placeholder="Description">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="customer-'
						+ projectCount
						+ '"name="customer" placeholder="Customer">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="number" class="form-control" id="teamSize-'
						+ projectCount
						+ '"name="teamSize" placeholder="Team Size">'
						+ '</div>'
						+ '	<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="involvementDuration-'
						+ projectCount
						+ '"name="involvementDuration" placeholder="Involvement Duration">'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="text" class="form-control" id="tools-'
						+ projectCount
						+ '"name="tools"'
						+ 'placeholder="Tools">'
						+ '<br></div>'
			);
		}
	},
	error : function(err) {
	}
});
$.ajax({
	type : 'GET',
	url : 'userinformation/certification/current',
	dataType : 'json',
	contentType : 'application/json',
	success : function(response) {
		for (; certificationCount < response.length; certificationCount++) {
			$('#certification').append(
					'<div class="form-group col-lg-8">'
						+ '<input type="text" class="form-control" id="name-'
						+ certificationCount
						+ '"name="name" placeholder="Name" required>'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="number" class="form-control" id="yearReceived-'
						+ certificationCount
						+ '"name="yearReceived" placeholder="Year Received" required>'
						+ '<br></div>'
			);
			$('#name-' + certificationCount).val(response[certificationCount].name);
			$('#yearReceived-'+ certificationCount).val(response[certificationCount].yearReceived);
		}
		if (certificationCount === 0) {
			$('#certification').append(
					'<div class="form-group col-lg-8">'
						+ '<input type="text" class="form-control" id="name-'
						+ certificationCount
						+ '"name="name" placeholder="Name" required>'
						+ '</div>'
						+ '<div class="form-group col-lg-4">'
						+ '<input type="number" class="form-control" id="yearReceived-'
						+ certificationCount
						+ '"name="yearReceived" placeholder="Year Received" required>'
						+ '<br></div>');
			}
		},
		error : function(err) {
		}
	}
);
	