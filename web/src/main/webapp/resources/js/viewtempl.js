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
             var image = '<img src="/Files/' + template.name + '.png">';
             $('#img').append(image);
             if (template.price === null) {
             $("#control").addClass("btn-success").append("Use!");
             } else {
                 $("#control").addClass("btn-danger").append("Buy " + template.price + " $");
             }
        },
        error: function() {
            showErrorMessage('#well');
        }
    });
});