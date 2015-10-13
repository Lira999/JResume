$(document).ready(function() {
    getCurrentUserFullName();
}); 

function getCurrentUserFullName() {
    $.ajax({
    url: 'getCurrentUserFullName',
    type: 'GET',
    contentType: 'text',
    success: function(currentUserFullName) {
        if (currentUserFullName) {
            var output = '<li class="dropdown"><a class="dropdown-toggle" ' + 
                'data-toggle="dropdown" href="#">' + 
                currentUserFullName + '<span class="caret">' + 
                '</span></a><ul class="dropdown-menu"><li><a href="#">' + 
                'View Profile</a></li><li><a href="#">Edit Profile</a>' + 
                '</li></ul></li><li><a href="logout"><span class="glyphicon' +
                ' glyphicon-log-out"></span> Log Out</a></li>';
            $('#toggles').prepend(output);
        } else {
            var output = '<li><a href="register"><span class="glyphicon ' + 
            'glyphicon-user"></span> Sign Up</a></li><li><a href="login">' +
            '<span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>';
            $('#toggles').prepend(output);
        }
    },
    error:function() {
        console.log('Something went wrong');
    }
    });
}