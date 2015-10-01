"use strict";
/**
 * 
 */    
$(document).ready(function () {
    function sendAjax() { 
     var data = JSON.stringify({
         name:$( "#NameTeplate" ).val(),
         description:$( "#DescriptionTeplate" ).val(),
         price:$( "#showthis" ).val()
     });
     $.ajax({
      url: document.location.href,
      type: "POST",
      dataType: "json",
      contentType: "application/json",
      data: data,
      success: function(data) {
    	  alert("Data saved");
    	  top.location.href = "login";
      },
      error:function(data,status,er) {
       alert("error: "+data+" status: "+status+" er:"+er);
      }
     });
    };
    $("#uploadBtn").click(function(event){
    	  sendAjax();
    	  event.preventDefault();
    	 });
            
});