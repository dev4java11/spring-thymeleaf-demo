/**
 * 
 */

function printMessage(messageIcon, messageHeader, messageBody, messageSeverity){
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
	
	$('.datetimepicker').datetimepicker({
		locale: localeDatetimePicker,
		format: formatDatetimePicker
	});
}
