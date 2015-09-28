"use strict";
/**
 * 
 */

$(document).ready(function () {
    //block possibility to write smth in form if radiobutton isn't choose 
    $(function () {
        $('input[name="showthis"]').hide();

        //show it when the checkbox is clicked
        $('input[name="checkbox"]').on('click', function () {
            if ($(this).prop('checked')) {
                $('input[name="showthis"]').fadeIn();
            } else {
                $('input[name="showthis"]').hide();
            }
        });
    });
    
    function sendAjax() { 
     var data = JSON.stringify({
         name:$( "#NameTeplate" ).val(),
         description:$( "#DescriptionTeplate" ).val(),
         price:$( "#showthis" ).val(),
         image:$( "#fileUpload1" ).val()
     });
     $.ajax({
      url: document.location.href,
      type: "POST",
      dataType: "json",
      contentType: "application/json",
      data: data,
      success: function(data) {
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