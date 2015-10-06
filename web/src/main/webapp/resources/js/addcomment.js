$(function() {
	
	function sendAjax() {
		var data = JSON.stringify ({
			comment: $("#comment").val(),
			mark: $("#rating-input").val(),
		});
		$.ajax({
			url: "addcomment",
			type: "POST",
			contentType: "application/json",
			data: data,
			success: function (response) {
			    $.ajax({
			    	type: 'GET',
			        url: 'viewcommentsandmarks/result',
			        dataType: 'json',
			        contentType: "application/json",
			        success: function (response) {
			        		var newComment = response[response.length - 1];
			        		if(newComment.mark == 'EXCELLENT') var mark = new String('<span class="glyphicon glyphicon-star"></span>' +'<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>');
			        		else if(newComment.mark == 'GOOD') var mark = new String('<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>');        		
			        		else if(newComment.mark == 'AVERAGE') var mark = new String('<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>');        		
			        		else if(newComment.mark == 'FAIR') var mark = new String('<span class="glyphicon glyphicon-star"></span>' + '<span class="glyphicon glyphicon-star"></span>');        		
			        		else var mark = new String('<span class="glyphicon glyphicon-star"></span>'	);
			        		
			        		
			        		var unixDate = new Date(newComment.createDate);
			        		var date = unixDate.getDate() + '-' + (unixDate.getMonth()+1) + '-' + unixDate.getFullYear();
			        		
			        		$('#container').prepend(
			        			'<div class="row">' +
				        			'<hr />' +	
				        			'<div class="col-md-12">' +
			        					'<div class="row rating-desc">' +
				        					'<div class="col-md-4">' +
				        						'<div class="stars">' +
				        							mark + 
				        						'</div>' + 
				        						'&nbsp&nbsp&nbsp' + 'UserName' +
				        					'</div>' +
				        					'<div class="col-md-offset-11">' +
			        							'<h6>' + date + '</h6>' +
			        						'</div>' +
				        				'</div>' +
				        			'</div>' +
			        			'</div>' +
			        			'<div>' + 
			        				newComment.comment + 
			        			'</div>' 
			        				);
			        },
			        error: function(data,status,er) {
			        	debugger
			        }  
			    });
			    jQuery('textarea[name="comment"]').val('');
			    },
			error: function (er) {
				debugger
			}
		});
	}
	$("#addbutton").click(function(){
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