$(function() {
	$.ajax({
		url : document.location.href + 'Generate',
		type : 'POST',
		dataType : 'text',
		success : function(data) {
			$('#resume').append(data);
		},
		error : function(data, textStatus) {
			showErrorMessage('#well');
		}
	});
});