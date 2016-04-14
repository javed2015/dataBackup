$('input').keypress(function(e) {
	
    var code = (e.keyCode ? e.keyCode : e.which);
    if(code == 13) {
 	   $('.btn-registration').trigger('click');
    }
 });
$('.btn-registration').click(function(){
	
	var projectcheck = $('.projectcheck:checked').length;
	var fname 	 = $.trim($('#fname').val());
	var lname 	 = $.trim($('#lname').val());
	var email 	 = $.trim($('#email').val());
	var password = $.trim($('#pass').val());
	var username   = $.trim($('#github-uname').val());
	var gitpassword   = $.trim($('#github-password').val());
	
	
	if(fname=="")
	{
		$('#errorMessage').text("First name can not be blank.").css('color','red');
		$('#fname').focus();
		return false;
		
	}
	else if(lname=="")
	{
		$('#errorMessage').text("Last name can not be blank.").css('color','red');
		$('#lname').focus();
		return false;
		
	}
	else if(email=="")
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
		$('#pass').focus();
		return false;
	}
	/*else if(projectcheck<1)
	{
		$('#errorMessage').text("Please select any one project.").css('color','red');
		$('#project1').focus();
		return false;
	}*/
	else if(username=="")
	{
		$('#errorMessage').text("Please Enter Github Username").css('color','red');
		$('#github-uname').focus();
		return false; 
	}
	else if(gitpassword=="")
	{
		$('#errorMessage').text("Please Enter Github Password").css('color','red');
		$('#github-password').focus();
		return false; 
	}
	else
	{
		$('#errorMessage').text("");
		$('#vinform').submit();
	}
});
