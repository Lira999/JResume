$(document).ready(function() {
	var DEFAULT_PAGE = 1;
	var PAGE_SIZE = 6;
	sendAjax();
	$('#select').change(function() {
		$('#select option').each(sendAjax());
	});	
function sendAjax() {
	$.ajax({
		url : 'templates/list?viewOnly=' + $('#view').val() + '&sortBy='
				+ $('#sortBy').val(),
		type : 'GET',
		contentType : 'application/json',
		success : function(templates) {
			var maxPage = Math.ceil(templates.length/PAGE_SIZE);
			showTemplate(DEFAULT_PAGE);
			$('#paging').empty();
			for(var i = 1; i <= maxPage; i++) {
				$('<input type="button" class="btn btn-default" name="' 
						+ i + '" value="' + i + '">')
						.appendTo('#paging');
			}			
			function showTemplate(page) {
				$('#row').empty();
				for(var i = (page - 1)*PAGE_SIZE; 
				        i < (page - 1)*PAGE_SIZE + PAGE_SIZE; i++ ) {
					var address = new String('viewtemplate/' + templates[i].id);
					if (templates[i].price == null) {
						var priceButton = new String('<a href=' + address
								+ ' class="btn button btn-success">Free</a>');
					} else {
						var priceButton = new String('<a href=' + address
								+ ' class="btn button btn-danger">' + 'Price '
								+ templates[i].price + '$' + '</a>')
					}
					var image = new String('<img src="/Files/' 
							+ templates[i].name + '.png">');
					$('<div>' + '<div class="thumbnail">'
						      + '<div class="caption">' + priceButton
							  + '</div>' + image
							  + '<p class="template-name">' + templates[i].name
							  + '</p>' + '</div>' + '</div>')
							  .addClass('col-sm-12 col-xs-12 col-md-4 col-lg-4')
							  .attr('id',	templates[i].id)
							  .appendTo('div#row');
				}
			}
    		$('#paging :button').click(function(){
				showTemplate(this.value);
			});			
		},
		error : function(templates, status, er) {
			showErrorMessage('div#row');
		}
	});
}
});