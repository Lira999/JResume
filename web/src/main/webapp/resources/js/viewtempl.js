$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: document.location.href +'/res',
        dataType: 'json',
        contentType: "application/json",
        success: function (template) {
             document.title = template.name + ' - JResume';
             $('#name').append(template.name);
             $('#description').append(template.description);
             var image = '<img src="./resources/templates/' + template.name + '.png">';
             $('#img').append(image);
             if (template.price === null) {
             $("#control").addClass("btn-success").append("Use!");
             } else {
                 $("#control").addClass("btn-danger").append("Buy " + template.price + " $");
             }
        },
        error: function() {
            $('#page-content').hide();
            var errormessage = '<div class="center error alert alert-danger ' +
            'fade in"><strong>Error: </strong>JResume encountered some ' +
            'internal problems. We working to resolve the issue as soon ' + 
            'as possible.  Please, try again later.</div>'
            $('#well').append(errormessage);
        }
    });
});