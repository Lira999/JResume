$(function() {
	jQuery.validator.addMethod('regx', function(value, element, regexpr) {
		return regexpr.test(value);
	}, 'Please enter a valid data.');
	$.validator.addMethod('filesize', function(value, element, size) {
		return this.optional(element) || (element.files[0].size <= size);
	});
	jQuery.validator.setDefaults({
		highlight: function(element) {
			$(element).closest('.input-group').removeClass('has-success');
			$(element).closest('.input-group').addClass('has-error');
			$(element).nextAll('.glyphicon').remove();
			$(element).after('<span class="glyphicon glyphicon-remove '+
			'form-control-feedback"></span>');
		},
		unhighlight: function(element) {
			$(element).closest('.input-group').removeClass('has-error');
			$(element).closest('.input-group').addClass('has-success');
			$(element).nextAll('.glyphicon').remove();
			$(element).after('<span class="glyphicon glyphicon-ok form-control' +
			'-feedback"></span>');
		}
	});
	$('#upload-form').validate({
			rules : {
				name : {
					required : true,
					remote: {
						url: 'templateExists',
						type: 'POST',
						value: true
					}
				},
				description : {
					required : true
				},
				price : {
					required : false,
					regx : /^[0-9]*([,.][0-9]{1,2})?$/,
				},
				pic : {
					required : true,
					extension : 'png',
					filesize: 1000000
				},
				file : {
					required : true,
					extension: 'xsl',
					filesize: 1000000
				}
			},
			messages : {
				name : {
					required : 'Please, enter name of template',
					remote: 'This name is not available'
				},
				description : {
					required : 'Please, enter template description'
				},
				price : {
					regx : 'Please, enter price corectly'
				},
				pic : {
					required : 'Please, select a preview image',
					extension : 'Only png files allowed',
					filesize: 'File must be less, then 1 Mb'
				},
				file : {
					required : 'Please, select a template file',
					extension : 'Only xsl files allowed',
					filesize: 'File must be less, then 1 Mb'
				}
			},
			errorPlacement: function (error, element) {
				var popover;
				popover = $(element).parent().popover({
					trigger: 'manual',
					placement: 'right',
					content: $(error).text(),
					template: '<div class="popover"><div class="arrow">' +
					'</div><div class="popover-inner"><div class="popover-' +
					'content"><p></p></div></div></div>'
				});
				popover.data('bs.popover').options.content = $(error).text();
				$(element).parent().popover('show');
			},
			success: function (label, element) {
				$(element).parent().popover('hide');
			},
			submitHandler : function(form) {
				writeFiles();
			}
		});
});

function writeFiles() {
	var formData = new FormData();
	formData.append('file', $('input[type=file]')[0].files[0]);
	formData.append('file', $('input[type=file]')[1].files[0]);
	formData.append('name', $('#name').val());
	$.ajax({
		url : 'uploadfiles',
		data : formData,
		type : 'POST',
		processData : false,
		contentType : false,
		success : function(result) {
			if (result) {
				createDBEntry();
			} else {
				//shown in case of error during file upload
				var errorMessage = '<div class="alert error alert-danger fade' +
				' in">Upload failed. Your files seems to be not valid. Please,' +
				' check them and try again later.</div>';
				showErrorMessage('#error-div', errorMessage);
			}
		},
		error : function(result) {
			//shown in case of some problems on server side e.g. file size exceeded
			var errorMessage = '<div class="alert error alert-danger fade' +
			' in">Upload failed. We accept only files, less then 1 MB. Please,' +
			' check your files and try again later.</div>';
			showErrorMessage('#error-div', errorMessage);
		}
	});
}

function createDBEntry() { 
	var data = JSON.stringify({
		name:$('#name').val(),
		description:$('#description').val(),
		price:$('#price').val()
	});
	$.ajax({
		url: 'uploadtemplate',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json',
		data: data,
		success: function() {
		location.href = 'templates';
	},
		error:function() {
			//shown in case of some problems on server side
			showErrorMessage('#error-div');
		}
	});
}