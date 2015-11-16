$(function() {
	function sendAjax() {
		var startPosition = document.location.href.indexOf('viewtemplate/')
				+ 'viewtemplate/'.length;
		var id = document.location.href.substring(startPosition,
				document.location.href.length);
		var data = JSON.stringify({
			comment : $('#comment').val(),
			mark : $('#rating-input').val(),
			templateId: id,
		});
		$.ajax({
			url : 'addcomment',
			type : 'POST',
			contentType : 'application/json',
			data : data,
			success : function(response) {
				$.ajax({
					type : 'GET',
					url : 'viewcomments' + id + '/result',
					dataType : 'json',
					contentType : "application/json",
					success : function(response) {
						var newComment = response[response.length - 1];
						if (newComment.mark === 'EXCELLENT')
							var mark = new String('<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>');
						else if (newComment.mark === 'GOOD')
							var mark = new String('<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>');
						else if (newComment.mark === 'AVERAGE')
							var mark = new String('<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>');							
						else if (newComment.mark === 'FAIR')
							var mark = new String('<span class="glyphicon glyphicon-star"></span>'
									+ '<span class="glyphicon glyphicon-star"></span>');
						else if (newComment.mark === 'POOR')
							var mark = new String('<span class="glyphicon glyphicon-star"></span>');
						else 				
							var mark = '';
						$('#list').prepend('<li class= "item"><div class="row">'
								+ '<hr />'
								+ '<div class="col-md-12">'
								+ '<div class="row rating-desc">'
								+ '<div class="col-md-4">'
								+ '<div class="stars">'
								+ mark
								+ '</div>'
								+ '&nbsp&nbsp&nbsp'
								+ newComment.createdBy
								+ '</div>'
								+ '<div class="col-md-offset-11">'
								+ '<h6>'
								+ moment(newComment.createDate).format('DD-MMM-YYYY ')
								+ '</h6>'
								+ '</div>'
								+ '</div>'
								+ '</div>'
								+ '</div>'
								+ '<div>'
								+ newComment.comment
								+ '</div></li>');
						$("#list").find("li:hidden:lt(1)").show();
						currentPosition--;
						},
						error : function(data, status, er) {
						}
						});
				jQuery('textarea[name="comment"]').val('');
				},
				error : function(er) {
				}
				});
		}
	$('#addbutton').click(function() {
		if($('#comment').val()){
			sendAjax();
		}
	});
});
jQuery(document).ready(function() {
	$('#rating-input').rating({
		min : 0,
		max : 5,
		step : 1,
		size : 'lg',
		showClear : false
	});
});