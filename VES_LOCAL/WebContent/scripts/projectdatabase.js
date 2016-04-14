/*project database page scripts starts here*/
$(document).ready(function(){
$('.database-pop').css('display','none');
$('#btn-database').click(function(){
	$("body").css("overflow", "hidden");
	$('#overlay').show();	
   $('.database-pop').css('display','inline-block');
   
});
$('#btn-cancel').click(function(){
	$('#overlay').hide();
	$("body").css("overflow", "auto");
	$('.database-pop').css('display','none');
});
});
$('#living-user').blur(function(){
	
	var livinguser = $.trim($('#living-user').val());
	
	if(livinguser=="")
	{
		$('#errormessage-div').text("Please Enter Living User Registration").css('color','red');
		$('#living-user').focus();
	}
	else if(livinguser!="")
	{
		$('#errormessage-div').text("");
	}
});
$('#mysql-path').blur(function(){
	
	var mysqlpath = $.trim($('#mysql-path').val());
	
	if(mysqlpath=="")
	{
		$('#errormessage-div').text("Please Enter Mysql Path").css('color','red');
		$('#mysql-path').focus();
	}
	else if(mysqlpath!="")
	{
		$('#errormessage-div').text("");
	}
});
$("#living-user,#mysql-path").keypress(function(e) {
	   if (e.keyCode == 13) {
	      $('#createdatabase').trigger('click');
	   }
});
$('#createdatabase').click(function(){
	var livinguser 		= $.trim($('#living-user').val());
	var mysqlpath   	= $.trim($('#mysql-path').val());
	var provider 		= $('.provider:checked').length;
	var database_type 	= $('.database_type:checked').length;
	var interfaceval 	= $('.interface:checked').length;
	var options 		= $('.options:checked').length;
	var sessionuser_id  = $('#sessionuser_id').val();
	if(livinguser=="")
	{
		$('#errormessage-div').text("Please Enter Living User Registration").css('color','red');
		$('#living-user').focus();
		return false; 
	}
	else if(mysqlpath=="")
	{
		$('#errormessage-div').text("Please Enter Mysql Path").css('color','red');
		$('#mysql-path').focus();
		return false; 
	}
	else if(provider<1)
	{
		
		$('#errormessage-div').text("Please select any one provider.").css('color','red');
		return false;
	}
	else if(database_type<1)
	{
		$('#errormessage-div').text("Please select any one database type.").css('color','red');
		return false;
	}
	else if(interfaceval<1)
	{
		$('#errormessage-div').text("Please select any one interface.").css('color','red');
		return false;
	}
	else if(options<1)
	{
		$('#errorMessage').text("Please select any one option.").css('color','red');
		return false;
	}
	else 
	{
		$('#errormessage-div').text("");
		var providerval 		= $('.provider:checked').val();
		var databasetypeval 	= $('.database_type:checked').val();
		var interfacevalue 		= $('.interface:checked').val();
		var optionsval 			= $('.options:checked').val();
		$("body").css("overflow", "hidden");
		$('#overlay').show().css('z-index','100000');		
		var queryString = 'sessionuser_id='+ encodeURIComponent(sessionuser_id) + '&livinguser='+ encodeURIComponent(livinguser) + 
		'&mysqlpath='+ encodeURIComponent(mysqlpath)+ '&providerval='+ encodeURIComponent(providerval)+ '&databasetypeval='
		+ encodeURIComponent(databasetypeval)+ '&interfacevalue='+ encodeURIComponent(interfacevalue)+ '&optionsval='+ 
		encodeURIComponent(optionsval);
		$.ajax({
		  method: "POST",
		   url: 'UserDbServlet', 
		  dataType: "html",
		  data: queryString,
		  success:function(resp){
		
			$('#errormessage-div').text("User Data Updated").css('color','green');
			$('#overlay').hide();
			$("body").css("overflow", "auto");
		//	alert(resp);
		  },
		});
	}
});
/*project database page scripts ends here*/