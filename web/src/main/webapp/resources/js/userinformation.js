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

		var data = JSON.stringify({
			schoolName : $('#schoolName').val(),
			university : $('#university').val(),
			degreeReceived : $('#degreeReceived').val(),
			department : $('#department').val(),
			graduationYear : $('#graduationYear').val(),
		});
		$.ajax({
			url : 'userinformation/education',
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

		var data = JSON.stringify({
			description : $('#description').val(),
			customer : $('#customer').val(),
			role : $('#role').val(),
			teamSize : $('#teamSize').val(),
			involvementDuration : $('#involvementDuration').val(),
			tools : $('#tools').val(),
		});
		$.ajax({
			url : 'userinformation/project',
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

		var data = JSON.stringify({
			name : $('#name').val(),
			yearReceived : $('#yearReceived').val(),
		});
		$.ajax({
			url : 'userinformation/certification',
			type : 'POST',
			dataType : 'text',
			contentType : 'application/json',
			data : data,
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
	$('#next')
			.click(
					function() {
						debugger
						$('#nextfields')
								.prepend(
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
												+ '</div>')
						$('#next').hide();

					});

});