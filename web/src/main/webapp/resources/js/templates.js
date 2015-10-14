$(document).ready(function() {
    sendAjax();
}); 

function sendAjax() {
    $.ajax({
    url: "templates/list",
    type: "GET",
    contentType: "application/json",
    success: function(data) {
    $.each(data ,function(index, templates) {
	   
	    var address = new String("viewtempl" + templates.id);
	    if (templates.price == null) { var priceButton = new String("<a href=" + address + " class='btn button btn-success'>Free</a>"); }
	   	    else { var priceButton = new String("<a href=" + address + " class='btn button btn-danger'>" + "Price " + templates.price + "$" +"</a>") }
	    var image = new String("<img src='./resources/templates/" + templates.name + ".png'>");
	   
	    $("<div>" +
	   	    "<div class='thumbnail'>" +
	   		"<div class='caption'>" +
	   		    priceButton +
	   		"</div>" +
	   		    image + 
	   		"<p class='template-name'>" + templates.name + "</p>" +
	   		"</div>" +
	   		"</div>")
		        .addClass('col-sm-12 col-xs-12 col-md-4 col-lg-4')
		        .attr('id', templates.id)
		        .appendTo('div#row');
    });        
    },
    error:function(data,status,er) {
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
	}
    });
}