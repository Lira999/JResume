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
	   
	console.log(object.name + "  " + object.price);
   });
  },
  error:function(data,status,er) {
	    }
 });
}