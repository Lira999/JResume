"use strict";
$(function() {

	jQuery.validator.addMethod('passwordMatch', function(value, element) {
		// The two password inputs
		var password = $("#password").val();
		var confirmPassword = $("#password_confirmation").val();
		// Check for equality with the password inputs
		if (password != confirmPassword) {
			return false;
		} else {
			return true;
		}
	}, "Your passwords must match");
	
	jQuery.validator.addMethod('regx', function(value, element, regexpr) {
		return regexpr.test(value);
	}, "Please enter a valid data.");

	jQuery.validator.setDefaults({
		ignore : ":hidden:not(#tAndC)"
	});
	
	// Setup form validation on the .register-form element
	$(".register-form").validate({
				// Specify the validation rules
				rules : {
					firstName : {
						required : true,
						regx : /^[a-zA-Z]+$/
					},
					lastName : {
						required : true,
						regx : /^[a-zA-Z]+$/
					},
					email : {
						required : true,
						regx : /^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/,
						maxlength : 60,
						remote: {
	                        url: "emailExist",
	                        type: "POST",
	                        value: true
	                    }
					},
					password : {
						required : true,
						minlength : 5,

					},
					password_confirmation : {
						required : true,
						minlength : 5,
						passwordMatch : true
			},
			tAndC : {
				required : true
			}
		},
				// Specify the validation error messages
				messages : {
					firstName : "Please enter your first name.",
					lastName : "Please enter your last name.",
					tAndC : "Please accept our T&C.",
					password : {
						required : "Please provide a password.",
						minlength : "Please enter a password with at least five characters."
					},
					passwordConfirmation : {
						required : "You must confirm your password.",
						minlength : "Please enter a password with at least five characters.",
					passwordMatch : "Your passwords must match."
				},
				email : "Email is invalid or already taken."
			},
			submitHandler : function(form) {
				sendAjax();
			},
			invalidHandler : function(form) {
			}

		});
	
	/**
	 * Send json to server.
	 */
	function sendAjax() {
		var data = JSON.stringify({
			firstName: $("#firstName").val(),
			lastName: $("#lastName").val(),
			email: $("#email").val(),
			password: $("#password").val()
		});
		$.ajax({
			url: "register",
			type: "POST",
			dataType: "json",
			contentType: "application/json",
			data: data,
			success: function(data, textStatus, xhr) {
				top.location.href = xhr.getResponseHeader('Location');
			},
			error: function(data,status,er) {
				if (!$("#err").length) {
					$("#bot_line").after("<label class='error' id='err'>" + data.responseText + "</label>");
				}
			}
		});
	}

	//For button "Agree".
	$('.button-checkbox')
	.each(function() {
		// Settings for button
		var $widget = $(this), $button = $widget.find('button'), $checkbox = $widget
		.find('input:checkbox'), color = $button
		.data('color'), settings = {
			on : {
				icon : 'glyphicon glyphicon-check'
			},
			off : {
				icon : 'glyphicon glyphicon-unchecked'
			}
		};

		// Event Handlers
		$button.on('click',
			function() {
				$checkbox.prop('checked', !$checkbox
					.is(':checked'));
				$checkbox.triggerHandler('change');
				updateDisplay();
			});
		$checkbox.on('change', function() {
			updateDisplay();
		});

		// Actions
		function updateDisplay() {
			var isChecked = $checkbox.is(':checked');

			// Set the button's state
			$button.data('state', (isChecked) ? "on" : "off");

			// Set the button's icon
			$button
			.find('.state-icon')
			.removeClass()
			.addClass(
				'state-icon '
				+ settings[$button
				.data('state')].icon);

			// Update the button's color
			if (isChecked) {
				$button.removeClass('btn-default').addClass(
					'btn-' + color + ' active');
			} else {
				$button.removeClass('btn-' + color + ' active')
				.addClass('btn-default');
			}

		}

		// Initialization
		function init() {

			updateDisplay();

			// Inject the icon if applicable
			if ($button.find('.state-icon').length == 0) {
				$button.prepend('<i class="state-icon '
					+ settings[$button.data('state')].icon
					+ '"></i>');
			}
		}
		init();
	});
});