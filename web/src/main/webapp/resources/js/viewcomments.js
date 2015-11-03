var currentPosition = 0;
var COMMENTS_PER_LOAD = 5;
$(document).ready(function () {
	var itemsLength;
	var startPosition = document.location.href.indexOf('viewtemplate/')+'viewtemplate/'.length;
	var id = document.location.href.substring(startPosition, document.location.href.length);
	$.ajax({
		type: 'GET',
		url: 'viewcomments' + id + '/result',
		dataType: 'json',
		contentType: 'application/json',
		success: function (response) {
			itemsLength = response.length - COMMENTS_PER_LOAD;
			if (itemsLength <= 0) {
				$('#load-btn').css('display', 'none');
			} 
			for(var i = response.length - 1; i >= 0; i--) {
				
				if (response[i].mark === 'EXCELLENT')
					var mark = new String('<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>');
				else if (response[i].mark === 'GOOD')
					var mark = new String('<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>');
				else if (response[i].mark === 'AVERAGE')
					var mark = new String('<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>');	
				else if (response[i].mark === 'FAIR')
					var mark = new String('<span class="glyphicon glyphicon-star"></span>'
							+ '<span class="glyphicon glyphicon-star"></span>');
				else if (response[i].mark === 'POOR')
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
						+ response[i].createdBy
						+ '</div>'
						+ '<div class="col-md-offset-11">'
						+ '<h6>'
						+ moment(response[i].createDate).format('DD-MMM-YYYY ')
						+ '</h6>'
						+ '</div>'
						+ '</div>'
						+ '</div>'
						+ '</div>'
						+ '<div>'
						+ response[i].comment
						+ '</div></li>');

			}
			$('#list').find('li:hidden:lt('+ COMMENTS_PER_LOAD + ')').show();
		},
		error: function(data,status,er) {
		}
	});
	$('#load-btn').on('click', function () {
		$('#list').find('li:hidden:lt('+ COMMENTS_PER_LOAD + ')').show();
		currentPosition += COMMENTS_PER_LOAD;
		if (currentPosition >= itemsLength) {
			$('#load-btn').css('display', 'none');
		}
	});
});
