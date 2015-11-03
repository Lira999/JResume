var DEFAULT_PAGE = 1;
var PAGE_SIZE = 6;
	
$(document).ready(function() {
	sendAjax();
	$('#select').change(function() {
		$('#select option').each(sendAjax());
	});	
});

function sendAjax() {
	$.ajax({
		url : 'templates/list?viewOnly=' + $('#view').val() + '&sortBy='
				+ $('#sortBy').val(),
		type : 'GET',
		contentType : 'application/json',
		success : function(templates) {
			$('#paging').empty();
			var dataLength = templates.length;
			var numPage = 1;
			while(dataLength > 0) {
				$('<input type="button" class="btn btn-default" name="' 
						+ numPage + '" value="' + numPage + '">')
						.appendTo('#paging')
				dataLength -= PAGE_SIZE;
				numPage++;
			}		
			
			function showTemplate(page) {
				var currentPage = page;
				var startPosition = (currentPage - 1)*PAGE_SIZE;
				var endPosition = (currentPage - 1)*PAGE_SIZE + PAGE_SIZE;
				$('#row').empty();
				for(var i = startPosition; i < endPosition; i++ ) {
					var address = new String('viewtemplate/' + templates[i].id);
					if (templates[i].price == null) {
						var priceButton = new String('<a href=' + address
								+ ' class="btn button btn-success">Free</a>');
					} else {
						var priceButton = new String('<a href=' + address
								+ ' class="btn button btn-danger">' + 'Price '
								+ templates[i].price + '$' + '</a>')
					}
					var image = new String('<img src="/Files/' + templates[i].name 
							+ '.png">');
					$(
							'<div>' + '<div class="thumbnail">'
									+ '<div class="caption">' + priceButton
									+ '</div>' + image
									+ '<p class="template-name">' + templates[i].name
									+ '</p>' + '</div>' + '</div>')
							.addClass('col-sm-12 col-xs-12 col-md-4 col-lg-4')
							.attr('id',	templates[i].id)
							.appendTo('div#row');
				}
			}

			showTemplate(DEFAULT_PAGE);
			
			$('#paging :button').click(function(){
				showTemplate(this.value);
			});
			
		},
		error : function(templates, status, er) {
			showErrorMessage('div#row');
		}
	});
}