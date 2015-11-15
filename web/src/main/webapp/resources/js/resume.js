$(function() {
	const CONFLICT = 409;
	$.ajax({
		url : document.location.href + 'Generate',
		type : 'POST',
		dataType : 'text',
		success : function(data) {
			$('#resume').append(data);
		},
		error : function(data) {
			if (data.status==CONFLICT) {
				top.location.href = 'userinformation';
			} else {
				showErrorMessage('#well');	
			}
		}
	});
	
	$('#pdf').click(function() {
		window.open(document.location.href + '/pdf', '_blank');
	});
	
	$('#doc').click(function() {
		window.open(document.location.href + '/doc', '_blank');
	});	
});