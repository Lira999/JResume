$(document).ready(function() {
	sendAjax();
	$('select').change(function() {
		$("select option").each(sendAjax());
	});
});

function sendAjax() {
	$.ajax({
		url : 'templates/list?viewOnly=' + $('#view').val() + '&sortBy='
				+ $('#sortBy').val(),
		type : 'GET',
		contentType : 'application/json',
		success : function(data) {
			$("#row").empty();
			$.each(data, function(index, templates) {

				var address = new String('viewtemplate/' + templates.id);
				if (templates.price == null) {
					var priceButton = new String('<a href=' + address
							+ ' class="btn button btn-success">Free</a>');
				} else {
					var priceButton = new String('<a href=' + address
							+ ' class="btn button btn-danger">' + 'Price '
							+ templates.price + '$' + '</a>')
				}
				var image = new String('<img src="/Files/' + templates.name 
						+ '.png">');
				$(
						'<div>' + '<div class="thumbnail">'
								+ '<div class="caption">' + priceButton
								+ '</div>' + image
								+ '<p class="template-name">' + templates.name
								+ '</p>' + '</div>' + '</div>')
						.addClass('col-sm-12 col-xs-12 col-md-4 col-lg-4')
						.attr('id',	templates.id)
						.appendTo('div#row');
			});
		},
		error : function(data, status, er) {
			showErrorMessage('div#row');
		}
	});
}