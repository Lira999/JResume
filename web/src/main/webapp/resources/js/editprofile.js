$(function() {

	function sendAjax() {
		var data = JSON.stringify({
			firstName : $('#firstname').val(),
			lastName : $('#lastname').val(),
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
			url : 'editprofile',
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