"use strict";
$(document).ready(function() {
 sendAjax();
}); 
function sendAjax() {
  $.ajax({
  url: "templates/list",
  type: "GET",
  contentType: "application/json",
  success: function(data) {
   $.each(data ,function(index, object) {
	   
	   if (object.price == null) {
	   $("<div>" +
	   		"<div class='thumbnail'>" +
	   		"<div class='caption'>" +
	   		"<a href='' class='btn button btn-success'>Use</a>" +
	   		"</div>" +
	   		"<img src='./resources/images/Template1.png'>" + 
	   		"<a href='' class='template_name'>" + object.name + "</a>" +
	   		"</div>" +
	   		"</div>")
		   .addClass("col-sm-12 col-xs-12 col-md-4 col-lg-4")
		   .attr('id', object.id)
		   .appendTo("div#row");
	   
	   } else {
		   $("<div>" +
			   	"<div class='thumbnail'>" +
			   	"<div class='caption'>" +
			   	"<a href='' class='btn button btn-danger'>" + "Price " + object.price + "$" +"</a>" +
			   	"</div>" +
			   	"<img src='./resources/images/Template1.png'>" + 
			   	"<a href='' class='template_name'>" + object.name + "</a>" +
			   	"</div>" +
			   	"</div>")
				.addClass("col-sm-12 col-xs-12 col-md-4 col-lg-4")
				.attr('id', object.id)
				.appendTo("div#row");
	   }
	   
   });   
     
  },
  error:function(data,status,er) {
	    }
 });
}