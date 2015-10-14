"use strict";
$(document).ready(function() {
$(function() {
	jQuery.validator.addMethod('regx', function(value, element, regexpr) {
		return regexpr.test(value);
	}, "Please enter a valid data.");
	
	jQuery.validator.setDefaults({
		highlight: function(element) {
			$(element).closest('.input-group').removeClass('has-success');
			$(element).closest('.input-group').addClass('has-error');
			$(element).nextAll(".glyphicon").remove();
			$(element).after("<span class=\"glyphicon glyphicon-remove form-control-feedback\"></span>");
		},
		unhighlight: function(element) {
			$(element).closest('.input-group').removeClass('has-error');
			$(element).closest('.input-group').addClass('has-success');
			$(element).nextAll(".glyphicon").remove();
			$(element).after("<span class=\"glyphicon glyphicon-ok form-control-feedback\"></span>");
		}
	});
	$("#upload-form").validate({
			rules : {
				name : {
					required : true,
					},
				description : {
					required : true
				},
				file : {
					required : true
				},
				file2 : {
					required : true
				},
				price : {
					required : false,
					regx : /^[0-9]*([,.][0-9]{1,2})?$/,
				}
			},
			messages : {
				name : {
					required : "Please, enter template name",
				},
				description : {
					required : "Please, enter description about"
				},
				file : {
					required : "Please, select image file"
				},
				file2 : {
					required : "Please, select xslt file"
				},
				price : {
					regx : "Please, enter price corectly"
				}
			},
			errorPlacement: function (error, element) {
				var _popover;
				_popover = $(element).popover({
					trigger: "manual",
					placement: "right",
					content: $(error).text(),
					template: "<div class=\"popover\"><div class=\"arrow\"></div><div class=\"popover-inner\"><div class=\"popover-content\"><p></p></div></div></div>"
				});
				_popover.data("bs.popover").options.content = $(error).text();
				$(element).popover("show");
			},
			success: function (label, element) {
				$(element).popover("hide");
			},
			submitHandler : function(form) {
				sendAjax();
				sendAjax2();
			}
		});
});




	function sendAjax() {
		var formData = new FormData();
		formData.append('file', $('input[type=file]')[0].files[0]);
		formData.append('file', $('input[type=file]')[1].files[0]);
		formData.append('name', $( "#name" ).val());
		$.ajax({
			url : 'uploadtemplatefile',
			data : formData,
			type : 'POST',
			processData : false,
			contentType : false,
			success : function(result) {
				alert(result)
			},
			error : function(result) {
				
			}
		});
	};
	
	 function sendAjax2() { 
	     var data = JSON.stringify({
	         name:$( "#name" ).val(),
	         description:$( "#DescriptionTeplate" ).val(),
	         price:$( "#price" ).val()
	     });
	     $.ajax({
	      url: "uploadtemplate",
	      type: "POST",
	      dataType: "json",
	      contentType: "application/json",
	      data: data,
	      success: function(data) { 
	      },
	      error:function(data,status,er) {
	      }
	     });
	    };
	   
});
