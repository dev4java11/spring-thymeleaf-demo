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