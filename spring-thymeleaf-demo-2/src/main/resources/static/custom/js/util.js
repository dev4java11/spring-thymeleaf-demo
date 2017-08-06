/**
 * 
 */

function printMessage(messageSeverity, messageIcon, messageHeader, messageBody){
	if(!messageSeverity){
		messageSeverity = 'info';
	}
	if(!messageIcon){
		messageIcon = 'fa fa-info';
	}
	
	var growl = $.notify({
		icon: messageIcon,
		title: '<strong>'+messageHeader+': </strong>',
		message: messageBody
	},{
		type: messageSeverity
	});
	return growl;
}

function printInfoMessage(messageHeader, messageBody){
	printMessage('info', 'fa fa-info', messageHeader, messageBody);
}

function printWarningMessage(messageHeader, messageBody){
	printMessage('warning', 'fa fa-warning', messageHeader, messageBody);
}

function printErrorMessage(messageHeader, messageBody){
	printMessage('danger', 'fa fa-remove', messageHeader, messageBody);
}


function inicializarComponentSelect(){
	$('.selectpicker').selectpicker();
}

function inicializarComponentDatetimePicker(localeDatetimePicker, formatDatetimePicker){
	if(!localeDatetimePicker){
		localeDatetimePicker = 'es';
	}
	if(!formatDatetimePicker){
		console.log('estableciendo valor por defecto');
		formatDatetimePicker = 'DD/MM/YYYY HH:mm:ss'
	}
	
	var $datetimepicker = $('.datetimepicker').datetimepicker({
		locale: localeDatetimePicker,
		format: formatDatetimePicker
	});
	return $datetimepicker;
}

function setDataDateTimePicker($datetimepicker, date){
	$datetimepicker.data("DateTimePicker").date(date);
}


function submitPostForm(event, $form, preventDefault, onDone, onFail, onComplete){
	if(preventDefault){
		event.preventDefault();
	}
	var data = $form.serialize();
	var url = $form.attr("action");
	
	var post = $.post(url, data);
	if(onDone){
		post.done(onDone);
	}
	if(onFail){
		post.fail(onFail);
	}
	if(onComplete){
		
	}
}

function refresh($response, componentId){
	if(componentId){
		$result = $(response).find(componentId);
		$(componentId).html($result.html());
	}else{
		$(document).html($response.html());
	}
}
