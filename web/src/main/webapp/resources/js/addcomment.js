$(function() {
	function sendAjax() {
		var data = JSON.stringify ({
			comment: $("#comment").val(),
			mark: $("#rating-input").val(),
		});
		$.ajax({
			url: "addcomment",
			type: "POST",
			dataType: "json",
			contentType: "application/json",
			data: data,
			success: function (response) {
				debugger
			},
			error: function () {
				debugger
			}
		});
	}
	$("#addcomment").click(function(){
		sendAjax();
	});
});

jQuery(document).ready(function () {
    $('#rating-input').rating({
          min: 0,
          max: 5,
          step: 1,
          size: 'lg',
          showClear: false
       });
});
