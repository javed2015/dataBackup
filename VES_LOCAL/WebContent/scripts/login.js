$('#form-signin #email,#form-signin #password').keypress(function(e) { 
    if (e.keyCode == 13) {
    	 $('.btn-login').trigger('click');
     }
 });
/*$('#form-signin #email').blur(function(){
	
	var email 	 = $.trim($('#email').val());
	if(email=="")
	{
		$('#errorMessage').text("Email can not be blank.").css('color','red');
		$('#email').focus();	
	}
	else if(!isEmail(email))
	{
		$('#errorMessage').text("Please enter valid email.").css('color','red');
		$('#email').focus();
	}
	else
	{
		$('#errorMessage').text("");
	}
});
$('#form-signin #password').blur(function(){
	
	var password = $.trim($('#password').val());
	if(password=="")
	{
		$('#errorMessage').text("Password can not be blank.").css('color','red');
		$('#password').focus();
	}
	else
	{
		$('#errorMessage').text("");
	}
});*/
$('.btn-login').click(function(){
	var email 	 = $.trim($('#email').val());
	var password = $.trim($('#password').val());
	if(email=="")
	{
		$('#errorMessage').text("Email can not be blank.").css('color','red');
		$('#email').focus();
		return false;
		
	}
	else if(!isEmail(email))
	{
		$('#errorMessage').text("Please enter valid email.").css('color','red');
		$('#email').focus();
		return false;
	}
	else if(password=="")
	{
		$('#errorMessage').text("Password can not be blank.").css('color','red');
		$('#password').focus();
		return false;
	}
	else
	{
		$('#errorMessage').text("");
		$('#form-signin').submit();
	}
});
