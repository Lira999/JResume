$(document).ready(function () {
	
	var startPosition = document.location.href.indexOf('viewtempl')+'viewtempl'.length;
    var id = document.location.href.substring(startPosition, document.location.href.length)
	
    $.ajax({
    	type: 'GET',
        url: 'viewcomments' + id + '/result',
        dataType: 'json',
        contentType: "application/json",
        success: function (response) {
        	
        	for(var i = response.length - 1; i>=0; i--){
        		
        		if(response[i].mark == 'EXCELLENT') var mark = new String('<span class="glyphicon glyphicon-star"></span>' +'<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>');
        		else if(response[i].mark == 'GOOD') var mark = new String('<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>');        		
        		else if(response[i].mark == 'AVERAGE') var mark = new String('<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>');        		
        		else if(response[i].mark == 'FAIR') var mark = new String('<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>');        		
        		else var mark = new String('<span class="glyphicon glyphicon-star"></span>'	);   		
        		
             		$('#container').append(
        			'<div class="row">' +
	        			'<hr />' +	
	        			'<div class="col-md-12">' +
        					'<div class="row rating-desc">' +
	        					'<div class="col-md-4">' +
	        						'<div class="stars">' +
	        							mark + 
	        						'</div>' + 
	        						'&nbsp&nbsp&nbsp' + response[i].createdBy +
	        					'</div>' +
	        					'<div class="col-md-offset-11">' +
        							'<h6>' + moment(response[i].createDate).format('DD-MM-YY ') + '</h6>' +
        						'</div>' +
	        				'</div>' +
	        			'</div>' +
        			'</div>' +
        			'<div>' + 
        				response[i].comment + 
        			'</div>' 
        				);
        	}
        },
        error: function(data,status,er) {
        }  
    });
});