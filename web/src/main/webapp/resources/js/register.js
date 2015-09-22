
$(function () {

	jQuery.validator.addMethod( 'passwordMatch', function(value, element) {
		// The two password inputs
		var password = $("#password").val();
		var confirmPassword = $("#password_confirmation").val();

		// Check for equality with the password inputs
		if (password != confirmPassword ) {
			return false;
		} else {
			return true;
		}

	}, "Your passwords must match");

	$.validator.setDefaults({ 
		ignore: ":hidden:not(#t_and_c)"
	});
	// Setup form validation on the #register-form element
	$(".register-form").validate({

    // Specify the validation rules
    rules: {
    	first_name: "required",
    	last_name: "required",

    	email: {
    		required: true,
    		email: true
    	},
    	password: {
    		required: true,
    		minlength: 5,
    
    	},
    	password_confirmation: {
    		required: true,
    		minlength: 5,
            passwordMatch: true // set this on the field you're trying to match

        },
        t_and_c: {
        	required: true
        },
        submitHandler: function(form) {
        	form.submit();
        },
    },
    // Specify the validation error messages
    messages: {
    	firstname: "Please enter your first name.",
    	lastname: "Please enter your last name.",
    	t_and_c: "Please accept our T&C.",
    	password: {
    		required: "Please provide a password.",
    		minlength: "Please enter a password with at least five characters."
    	},
    	password_confirmation: {
    		required: "You must confirm your password.",
    		minlength: "Please enter a password with at least five characters.",
    	    passwordMatch: "Your passwords must match." // custom message for mismatched passwords
    	    },
    	    email: "Please enter a valid email address."
    	},

    	submitHandler: function(form) {
    		form.submit();
    	}
    }
    );


$('.button-checkbox').each(function () {

        // Settings for button
        var $widget = $(this),
        $button = $widget.find('button'),
        $checkbox = $widget.find('input:checkbox'),
        color = $button.data('color'),
        settings = {
        	on: {
        		icon: 'glyphicon glyphicon-check'
        	},
        	off: {
        		icon: 'glyphicon glyphicon-unchecked'
        	}
        };

        // Event Handlers
        $button.on('click', function () {
        	$checkbox.prop('checked', !$checkbox.is(':checked'));
        	$checkbox.triggerHandler('change');
        	updateDisplay();
        });
        $checkbox.on('change', function () {
        	updateDisplay();
        });

        // Actions
        function updateDisplay() {
        	var isChecked = $checkbox.is(':checked');

            // Set the button's state
            $button.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $button.find('.state-icon')
            .removeClass()
            .addClass('state-icon ' + settings[$button.data('state')].icon);

            // Update the button's color
            if (isChecked) {
            	$button
            	.removeClass('btn-default')
            	.addClass('btn-' + color + ' active');
            }
            else {
            	$button
            	.removeClass('btn-' + color + ' active')
            	.addClass('btn-default');
            }

        }


        // Initialization
        function init() {

        	updateDisplay();

            // Inject the icon if applicable
            if ($button.find('.state-icon').length == 0) {
            	$button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i>');
            }
        }
        init();
    });
});