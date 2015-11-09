$(document).ready(function() {
	var PAGE_SIZE = 6;
	var PER_PAGE = 5;
	var DEFAULT_PAGE = 1;	
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
			var currentPage = DEFAULT_PAGE;
			showTemplate(DEFAULT_PAGE);
			showPaging(DEFAULT_PAGE);
			function showTemplate(page) {
				$('#row').empty();
				currentPage = page;
				var startPosition = (page - 1)*PAGE_SIZE;
				var endPosition = startPosition + PAGE_SIZE;
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
    		function showPaging(page) {
    			$('#paging').empty();
				var startPage, endPage;
				if(page <= Math.ceil(PER_PAGE/2)) {
				  startPage = 1;
				  endPage = Math.min(PER_PAGE, maxPage);
				} else if(maxPage-page < PER_PAGE/2) {
			             startPage = Math.max(1, (maxPage-PER_PAGE+1));
			             endPage = maxPage;
				       } else {
				         startPage = page - Math.ceil(PER_PAGE/2);
				         endPage = startPage + PER_PAGE-1;
				         }
				$('<input type="button" class="btn btn-default form-control space"'
						+ ' name="Prev" value="Prev">').appendTo('#paging');
				if(startPage != 1) {
					$('<input type="button" class="btn btn-default form-control"'
							+ ' name="1" value="1" id="btn1">').appendTo('#paging');
					$('<label class="space"> . . . </label>').appendTo('#paging');									
				} 
			    for(var i = startPage; i <= endPage; i++) {
			    	$('<input type="button" class="btn btn-default form-control"'
			    			+ ' name="' + i + '" value="' + i + '" id="btn' + i + '">')
							.appendTo('#paging');
			    }
			    if(endPage != maxPage) {
			    	$('<label class="space"> . . . </label>').appendTo('#paging');
			    	$('<input type="button" class="btn btn-default form-control"'
			    			+' name="' + maxPage + '" value="' + maxPage 
			    			+ '"id="btn' + maxPage + '">').appendTo('#paging');
				}
			    $('<input type="button" class="btn btn-default form-control space"'
			    		+' name="Next" value="Next">').appendTo('#paging');
			    $("#btn" + page).addClass("active");			    
			    $('#paging :button').click(function(){
			    	countPage(this.value);					
				});
			}	
    		function countPage(page) {
				if(page == 'Prev') {
					if(currentPage > 1){
						currentPage--;						
					} 
				} else if(page == 'Next'){
					if(currentPage < maxPage){
						currentPage++;						    
					}
				} else currentPage = page;
				showPaging(currentPage);
				showTemplate(currentPage);								
			}    		
		},
		error : function(templates, status, er) {
			showErrorMessage('div#row');
		}
	});
}
});