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
        	var myprice = '';
        	var mydesc = '';
        	$('#name').append(response.name+" Template");
        	$('#description').append(response.description);
        	document.getElementById('price').setAttribute('value','buy '+response.price+" $");
        },
        error: function(data,status,er) {
        	alert(er);
        }  
    });
});