$(function() {

	function sendAjax() {
		var data = JSON.stringify({
			firstName : $('#firstname').val(),
			lastName : $('#lastname').val(),
			// password : $('#password').val(),
			// email : $('#email').val(),
			position : $('#position').val(),
			summary : $('#summary').val(),
			birthDate: 1000*moment($('#birthdate').val()).unix(),
			
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
			url : 'editprofile',
			type : 'POST',
			dataType : 'text',
			contentType : 'application/json',
			data : data,
			success : function(response) {
				$('#hardware').val(moment($('#birthdate').val()).unix());
				debugger
			},
			error : function(er) {
				debugger
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

	$('#eventForm').formValidation({
		framework : 'bootstrap',
		icon : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			date : {
				validators : {
					notEmpty : {
						message : 'The date is required'
					},
					date : {
						format : 'MM-DD-YYYY',
						message : 'The date is not a valid'
					}
				}
			}
		}
	});
});