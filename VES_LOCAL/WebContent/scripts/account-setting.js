$('#profilesetting #fname,#profilesetting #lname,#profilesetting #email').keypress(function(e) { 
    if (e.keyCode == 13) {
    	navigate();
     }
 });
$('#profilesetting #fname').blur(function(){
	
	var fname = $.trim($('#fname').val());
	if(fname=="")
	{
		$('#errorMessage').text("First name can not be blank.").css('color','red');
		$('#password').focus();
	}
	else
	{
		$('#errorMessage').text("");
	}
});
$('#profilesetting #lname').blur(function(){
	
	var lname = $.trim($('#lname').val());
	if(lname=="")
	{
		$('#errorMessage').text("Last name can not be blank.").css('color','red');
		$('#lname').focus();
	}
	else
	{
		$('#errorMessage').text("");
	}
});
$('#profilesetting #email').blur(function(){
	
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

function navigate()
{
	
	var fname = $.trim($("#fname").val());
	var lname = $.trim($("#lname").val());
	var email = $.trim($("#email").val());
	if(fname=="")
	{
		$('#errorMessage').text("First Name can not be blank.").css('color','red');
		$('#fname').focus();
		return false;	
	}
	else if(lname=="")
	{
		$('#errorMessage').text("Last Name can not be blank.").css('color','red');
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
	else
	{
		$('#errorMessage').text("");
		//window.top.location.href="personalinformation.jsp?fname="+fname+"&lname="+lname+"&email="+email;
		var queryString = 'fname='+ encodeURIComponent(fname) + '&lname='+ encodeURIComponent(lname) + '&email='+ encodeURIComponent(email);
			
			$.ajax({
			  method: "POST",
			  url: 'personalinformation.jsp', 
			  dataType: "html",
			  data: queryString,
			  success:function(resp){
				  $('#errorMessage').text("Settings Updated Successfully").css('color','green');
				/*$('#errorMessage').text("");
				window.top.location.href="profile.jsp";*/
			//	alert(resp);
			  },
			});
	}
	
}
$('.btncancelsettings').click(function(){
	//window.top.location.href="profile.jsp";
});

function git()
{
	var guname = document.getElementById("github-uname").value;
	var gpword = document.getElementById("github-password").value; 
	window.top.location.href="personalgithubinformation.jsp?github-uname="+guname+"&github-password="+gpword+"" ;
			}
			
function personal()
{   
	var ufname = document.getElementById("fname").value;
	var ulname = document.getElementById("lname").value; 
	var uemail = document.getElementById("email").value; 
	window.top.location.href="personalinformation.jsp?fname="+ufname+"&lname="+ulname+"&email="+uemail+"" ;
			}