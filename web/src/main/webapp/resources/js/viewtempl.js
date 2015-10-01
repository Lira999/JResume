"use strict";
/**
 * 
 */
$(document).ready(function () {
	
    $.ajax({
    	type: 'GET',
        url: 'viewtempl/res',
        dataType: 'json',
        contentType: "application/json",
        success: function (response) {
        	 var myname = '';
         	 var mydesc = '';
         	 $('#name').append(response.name+" Template");
         	 $('#description').append(response.description);
         	if (response.price == null && typeof $(".btn") != "btn btn-success  btn-lg") {
         	 $("#control").addClass("btn btn-success  btn-lg").append("Use");
         	} else {
         		$("#control").addClass("btn-danger btn-lg").append("Price " + response.price + " $");
        	}
        },
        error: function(data,status,er) {
        	alert(er);
        }  
    });
});