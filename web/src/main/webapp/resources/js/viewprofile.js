$(document).ready(function() {
	$.ajax({
		type : 'GET',
		url : 'viewprofile/result',
		dataType : 'json',
		contentType : 'application/json',
		success : function(response) {
			$('#firstName').append('<h5>' + response.firstName + '</h5>');
			$('#lastName').append('<h5>' + response.lastName + '</h5>');
			$('#email').append('<h5>' + response.email + '</h5><br>');
		},
		error : function(data, status, er) {
            showErrorMessage('#well');
		}
	});
});
