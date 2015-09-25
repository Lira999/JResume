$(function() {
	function sendAjax() {
		var data = {
			comment: encodeURIComponent($("#comment").val()),
		};
		$.ajax({
			url: "addcomment",
			type: "POST",
			data: data,
			success: function (response) {
				debugger
			},
			error: function () {
				debugger
			}
		});
	}
	$("#addComment").click(function(){
		sendAjax();
	});
});