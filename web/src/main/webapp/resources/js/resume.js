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
	
	$('#pdf').click(function() {
		window.open(document.location.href + 'Pdf', '_blank');
	});
	
	$('#doc').click(function() {
		window.open(document.location.href + 'Doc', '_blank');
	});	
});