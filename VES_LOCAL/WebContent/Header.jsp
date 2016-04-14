<%@ page import="com.votsh.access.*"%>
<%@ page import="com.votsh.servlets.*"%>
<%@ page import="com.votsh.dashboard.*"%>
<%
String notifications=null; 
 NotificationList nl = new NotificationList(); 
 notifications=nl.projectRequest((String)session.getAttribute("userid"));  
%>
<div id="notificationList" style="display: none">
	<%= notifications %>
</div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword"
	content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="img/favicon.png">

<title>VOTSH VSERVER</title>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="styles/bootstrap.min.css" rel="stylesheet">
<link href="styles/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!--right slidebar-->
<link href="styles/slidebars.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="styles/style.css?t=2" rel="stylesheet">
<link href="styles/style-responsive.css" rel="stylesheet" />
<!-- js placed at the end of the document so the pages load faster -->
<script src="scripts/jquery.js"></script>
<script src="scripts/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
	src="scripts/jquery.dcjqaccordion.2.7.js"></script>
<script src="scripts/jquery.scrollTo.min.js"></script>
<script src="scripts/slidebars.min.js"></script>
<script src="scripts/jquery.nicescroll.js" type="text/javascript"></script>
<script src="scripts/respond.min.js"></script>
<!-- notification dropdown -->
<script src="scripts/notification.js"></script>
<!--common script for all pages-->
<script src="scripts/common-scripts.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="boxed-page">
	<!-- <div id="overlay">
		<img src="images/loading.gif" id="loadingimg" />
	</div>
	<div id="overlay1">
		<img src="images/testing.gif" id="testingimg" />
	</div> -->
	 <div id="overlay">
	 
		 <img src="images/loading.gif" id="loadingimg"/>
		 <div class="ajaxresponsemsg" align="center"></div>
	 </div>
	 
  <div id="overlay1"><img src="images/testing.gif" id="testingimg"/><div class="ajaxresponsemsg" align="center"></div></div>
	<div class="container">

		<section id="container" class="">
			<!--header start-->

			<!--header end-->
			<!--main content start-->
			<section id="main-content">
				<section class="inner-header">
					<div class="upper-nav">
						<a href="dashboard.jsp" class="nav-link-left">Dashboard</a>
						<!--<a href="#" class="nav-link-left">Projects</a>-->

						<a href="logout.jsp" class="nav-link-right">Log Out<i
							class="fa fa-chevron-right ico-right"></i></a> 
						<a href="profile.jsp" class="nav-link-right"><i
							class="fa fa-user ico-left"></i>My Account</a>
							<a href="#"
							class="nav-link-right"><i class="fa fa-group ico-left"></i><%=session.getAttribute("name")%></a>
						
						<span class="nav-link-right dd wrapper-dropdown-3">
							<div class="notification-panel">

								<img src="images/icon/plus1.png"> <img
									src="images/icon/plus1.png" style="display: none">
							</div> <span class="not-count"> </span>
							<ul id="notification" class="dropdown">
							</ul>
						</span> <input type="hidden" id="useridval"
							value="<%=session.getAttribute("userid")%>" />
					</div>
				</section>

				<script>
				
				var rows = $('#notificationList').text();
				
					var t = '';
					var listitem = 1;
					var object = JSON.parse(rows)
					object.length != 0 ? $('.not-count').text(object.length) : $('.wrapper-dropdown-3').removeClass('active');
					object.forEach(function(obj) {
					var s = obj[' data'][0]+' requested access to '+obj[' data'][1];
					t += '<li style="position: relative" class="list-'+ listitem +'"><a href="#" class="access-notifi"><i class="icon"> '+ s  +'</i></a>  <i class="check-notification allow" listvalue="'+ listitem +'"uname="'+obj[' data'][0] +'" project="'+ obj[' data'][1] +'">Allow</i> <i class="check-notification deny" listvalue="'+ listitem +'"uname="'+obj[' data'][0] +'" project="'+ obj[' data'][1] +'">Deny</i></li>';
						listitem++;
					});
					$('#notification').html(t);
					
					$('.check-notification').click(function() {
						dataString= {
								userId:$('#useridval').val(),
						  reqUser: $(this).attr('uname'),
						  project: $(this).attr('project'),
						  validNo: $(this).hasClass('allow')? 1 :0
						}
						console.log(dataString);
						var listvalue = $(this).attr('listvalue');
						$.ajax({
							method : "POST",
							url : 'DashBoard',
							data : dataString,
							dataType : "json",
							success : function(resp) {
							console.log(resp);
								$('.list-'+listvalue).remove();
								
								var length = $('#notification li').length;
								if(length != 0){
							         $('.not-count').text(length)}
							        else{
							         $('.not-count').text('');
							         $('.wrapper-dropdown-3').removeClass('active');
							        }
							},
							failure: function() {
								alert("failure");
							}
						});
					});					
					$('.notification-panel').click(function(event){
						if($('.wrapper-dropdown-3').hasClass('active'))
						{
							$('.wrapper-dropdown-3').removeClass('active');
							
						}
						else{
							$('.wrapper-dropdown-3').removeClass('active');
							$(this).parent().addClass('active');
						}
						return false;
					});
					
				</script>

