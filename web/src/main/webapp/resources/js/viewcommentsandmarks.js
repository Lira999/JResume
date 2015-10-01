$(document).ready(function () {
	
    $.ajax({
    	type: 'GET',
        url: 'viewcommentsandmarks/res',
        dataType: 'json',
        contentType: "application/json",
        success: function (response) {
        	for(var i = 0, len=response.length; i<len; ++i){
        		
        		if(response[i].mark == 'EXCELLENT') var mark = new String("<span class='glyphicon glyphicon-star'></span>" +"<span class='glyphicon glyphicon-star'></span>" +"<span class='glyphicon glyphicon-star'></span>" +"<span class='glyphicon glyphicon-star'></span>" +"<span class='glyphicon glyphicon-star'></span>");
        		else if(response[i].mark == 'GOOD') var mark = new String("<span class='glyphicon glyphicon-star'></span>" + "<span class='glyphicon glyphicon-star'></span>" + "<span class='glyphicon glyphicon-star'></span>"+ "<span class='glyphicon glyphicon-star'></span>");        		
        		else if(response[i].mark == 'AVERAGE') var mark = new String("<span class='glyphicon glyphicon-star'></span>" + "<span class='glyphicon glyphicon-star'></span>" + "<span class='glyphicon glyphicon-star'></span");        		
        		else if(response[i].mark == 'FAIR') var mark = new String("<span class='glyphicon glyphicon-star'></span>" + "<span class='glyphicon glyphicon-star'></span>");        		
        		else var mark = new String("<span class='glyphicon glyphicon-star'></span>");
        		
        		
        	$('#container').append( "<hr />" +	
        			"<div class='row'>" +
        			"<div class='col-xs-1 col-md-1 text-center'>" + 
        			"<img src='resources/images/avatar.png' alt='photo' class='img-rounded img-responsive' />" +
        			"</div>" +
        			"<div class='col-xs-11 col-md-11 section-box'>" +
        			"<div class='col-md-12'>" +
        			"<div class='col-md-4'>" +
        			"<h4>" + "UserName" +"</h4>" +
        			"</div>" +
        			"<div class='col-md-offset-10'>" +
        			"<h6>" + "01-10-2015 00:01 AM" + "</h6>" +
        			"</div>" +
        			"</div>" +
        			"<hr />" +
        			"<hr />" +
        			"<div class='panel-body'>" + response[i].comment + "</div>" +
        			"<div class='row rating-desc'>" +
        			"<div class='col-md-offset-10'>" +
        			"<div class='stars'>" +
        			mark +
        			"</div>" +
        			"</div>" +
        			"</div>" +
        			"</div>" +
        			"</div>" 
        			);
        	}
        },
        error: function(data,status,er) {
        	debugger
        }  
    });
});