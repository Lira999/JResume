"use strict";

$(document).ready(function () {
	
    $.ajax({
    	type: 'GET',
        url: document.location.href +'/res',
        dataType: 'json',
        contentType: "application/json",
        success: function (response) {
         	 $('#name').append(response.name+" Template");
         	 $('#description').append(response.description);
         	 var image = new String("<img src='./resources/templates/" + response.name + ".png'>");
         	 $('#img').append(image);
         	 if (response.price == null && typeof $(".btn") != "btn btn-success  btn-lg") {
         	 $("#control").addClass("btn btn-success  btn-lg").append("Use");
         	 } else {
         		$("#control").addClass("btn-danger btn-lg").append("Buy " + response.price + " $");
         	 }
        },
        error: function(data,status,er) {
        	$("<div>" +
        		    "<p><strong>Error:</strong>" + 
        				"JResume encountered some internal problems. " +
        	            "We working to resolve the issue as " +
        	            "soon as possible." + 
        	            " Please, try again later." + 
        			"</p>" +
        		  	"</div>")
        		  	    .addClass('error alert alert-danger fade in')	   
        		  	    .appendTo('div#row');  
        	$('#control').hide();
        		}
        
    });
});