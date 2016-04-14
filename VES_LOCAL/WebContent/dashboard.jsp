<%@ page import="com.votsh.access.*"%>
<%@ page import="com.votsh.servlets.*"%>
<%@ page import="com.votsh.dashboard.*"%>
<%
javax.servlet.http.HttpServletRequest _request = (javax.servlet.http.HttpServletRequest) request;
javax.servlet.http.HttpServletResponse _response = (javax.servlet.http.HttpServletResponse) response;
String _path = _request.getContextPath();
String gridValues=null; 
DashBoardProjects dbp = new DashBoardProjects(); 
gridValues=dbp.projects((String)session.getAttribute("userid"));  
%>
<div id="dynamicData" style="display: none">
	<%= gridValues %>
</div>
<%-- <div id="dynamicData" > <%= gridValues %> </div --%>
<%@ include file="Header.jsp"%>

<section class="wrapper">
	<div class="row">
		<div class="col-lg-8">
			<section class="panel">
				<header class="panel-heading dash-header">
					Projects

					<!-- <a class="header-button" href="newprojectcreation.jsp"><i class="fa fa-plus"></i> New Project</a> -->
				</header>
				<table id="projectList" class="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Type</th>
							<th>Creator</th>
							<th>Access</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</section>
		</div>
		<input type="hidden" id="useridval"
			value="<%=session.getAttribute("userid")%>" />
		<div class="col-lg-4">
			<section class="panel">
				<header class="panel-heading dash-header"> Living Apps </header>
				<form action="project.jsp" method="post" name=""
					class="project-access" style="display: none">
					<input name="projectName" id="name"> <input
						name="projectType" id="type">
						<input
						name="projectCreator" id="creator">
				</form>
				<form action="projectaccess.jsp" method="post" name=""
					id="dashboard">
					<input type="hidden" name="project" id="selProject">
					<table id="applist" class="table">
						<thead>
							<tr>
								<th>Type</th>
							</tr>
						</thead>
						<tbody> </tbody>
					</table>
				</form>
			</section>
		</div>

	</div>
	
	<div class="wrapper new-app-popup">
		<div class="hd">New Living App</div>
		<form action="">
			<div class="heading row">Living App Name
			<input type="text" name="name_of_the_type" class="form-control app-bx" id="name_of_the_type">
			</div>
			<div class="heading row">GIT HUB URL
			<input type="text" name="gurl" class="form-control app-bx" id="gurl">
			</div>
			<div class="heading row">Machine Name
			<input type="text" name="mname" class="form-control app-bx" id="mname">
			</div>
			<div class="btn1 row">
			<input type="reset" name="Create" class="header-button" value="create" id="createapp">
			<input type="reset" name="Cancel" class="header-button" id="btn-cancel" value="cancel"> 
			</div>
			<div id="errormessage-div"></div>
		</form>
	</div>
	
	<%-- <div style="color: red">${accessmsg}</div>		 --%>

</section>

<!--main content end-->



<!-- Right Slidebar start -->


<!-- OPENING BUTTON -->
<a class="master-menu-open-btn sb-toggle-right"><i
	class="fa fa-caret-square-o-left"></i></a>


<div class="sb-slidebar sb-right sb-style-overlay">
	<div class="side-menu-top">
		Master Tasks <a class="master-menu-close-btn sb-toggle-right"><i
			class="fa fa-close"></i></a>
	</div>
	<h5 class="side-title">Task Group</h5>
	<ul class="sidebar-task-list">
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		</ul>


			<h5 class="side-title">Task Group</h5>
			<ul class="sidebar-task-list">
				<li><a class="sidebar-task-btn" href="#">Task</a></li>
				<li><a class="sidebar-task-btn" href="#">Task</a></li>
				<li><a class="sidebar-task-btn" href="#">Task</a></li>
				<li><a class="sidebar-task-btn" href="#">Task</a></li>
				<li><a class="sidebar-task-btn" href="#">Task</a></li>
				<li><a class="sidebar-task-btn" href="#">Task</a></li>
				</ul>

					<h5 class="side-title">Task Group</h5>
					<ul class="sidebar-task-list">
						<li><a class="sidebar-task-btn" href="#">Task</a></li>
						<li><a class="sidebar-task-btn" href="#">Task</a></li>
						<li><a class="sidebar-task-btn" href="#">Task</a></li>
						<li><a class="sidebar-task-btn" href="#">Task</a></li>
						<li><a class="sidebar-task-btn" href="#">Task</a></li>
						<li><a class="sidebar-task-btn" href="#">Task</a></li>
						</ul>
</div>
<!-- Right Slidebar end -->

<%@ include file="Footer.jsp"%>

<script>

var v = $('#dynamicData').text();
var d = JSON.parse(v)
var html = '';
var accessrequest ='';
//var requestaccessval=null;

var rowId = 1;
d.forEach(function(obj) {
	var requestaccess='';
	
	if((obj.data[3])=="Access Allowed")
	{
		 requestaccess ='<span class="access-btn selected-project green"  project-type="'+obj.data[4]+'" project-name ="'+ obj.data[2]+'" project-creator ="'+ obj.data[1] +'">View</span>';
	}
	else if((obj.data[3])=="Request Pending")
	{
		 requestaccess ='<div class="pending-btn yellow">Requested</div>';
	}
	else if((obj.data[3])=="Request To Access")
	{
		 requestaccess ='<input type="button" requestVal = "null" class="send-data red" name="'+ rowId +'" value="Request Access"/> ';
	}
	 html += '<tr> <td> <a class=" name-'+ rowId +'" project-type="'+obj.data[4]+'">  '+ obj.data[2] +' </a></td> <td class="left type-'+ rowId +'">'+ obj.data[4]+'</td> <td class="left creator-'+ rowId +'">'+ obj.data[1]+'</td> <td class="left request-data"> '+ requestaccess +'</td></tr>';
   rowId++;
 });
$('#projectList tbody').append(html);/* joining the code  */
$('.selected-project').click(function(){
		 var data = $(this).attr('project-type') == 'InstantWinApp' ? 1 : 2;
		 $('.project-access #name').val($(this).attr('project-name'));
		 $('.project-access #type').val($(this).attr('project-type'));
		 $('.project-access #creator').val($(this).attr('project-creator'));
		 $('.project-access').submit();
	});

$('.send-data').click(function() {
	var n = $(this).attr('name');
	
	dataString= {
			userId:$('#useridval').val(),
		  projName: $('.name-'+n).html().trim(),
		  projType: $('.type-'+n).html().trim(),
		  projCreator: $('.creator-'+n).html().trim(),
		  access: null
	  }
	console.log(dataString)
	
	
	$.ajax({
			method : "POST",
			url : 'DashBoard',
			 dataType: "json", 
			data : dataString,
			success : function(resp) {
				s = resp;
				console.log(resp[0].message);
				resp[0].message == '0' ? $('[name= '+ n +']').parent().html('<div class=".pending-btn yellow">Requested</div>') : '';
				
			},
			failure: function() {
				alert("failure");
			}
		});
		
	});
</script>



<script>
$(document).ready(function(){
$('.new-app-popup').css('display','none');
$('#btn-cancel').click(function(){
	$('.new-app-popup').css('display','none');
});
});
$('#name_of_the_type').blur(function(){
	
	var livinguser = $.trim($('#name_of_the_type').val());
	
	if(name_of_the_type=="")
	{
		$('#errormessage-div').text("Please Enter Living App Name").css('color','red');
		$('#name_of_the_type').focus();
	}
	else if(name_of_the_type!="")
	{
		$('#errormessage-div').text("");
	}
});
$('#gurl').blur(function(){
	
	var gurl = $.trim($('#gurl').val());
	
	if(gurl=="")
	{
		$('#errormessage-div').text("Please Enter GIT HUB URL").css('color','red');
		$('#gurl').focus();
	}
	else if(gurl!="")
	{
		$('#errormessage-div').text("");
	}
});
$('#mname').blur(function(){
	
	var mname = $.trim($('#mname').val());
	
	if(mname=="")
	{
		$('#errormessage-div').text("Please Enter Machine Name").css('color','red');
		$('#mname').focus();
	}
	else if(mname!="")
	{
		$('#errormessage-div').text("");
	}
});
$("#name_of_the_type,#gurl,#mname").keypress(function(e) {
	   if (e.keyCode == 13) {
	      $('#createapp').trigger('click');
	   }
});
$('#createapp').click(function(){
	var name_of_the_type 		= $.trim($('#name_of_the_type').val());
	var gurl   	= $.trim($('#gurl').val());
	var mname   	= $.trim($('#mname').val());
	

	if(name_of_the_type=="")
	{
		$('#errormessage-div').text("Please Enter Living User Registration").css('color','red');
		$('#name_of_the_type').focus();
		return false; 
	}
	else if(gurl=="")
	{
		$('#errormessage-div').text("Please Enter GIT HUB URL").css('color','red');
		$('#gurl').focus();
		return false; 
	}
	else if(mname=="")
	{
		$('#errormessage-div').text("Please Enter Machine Name").css('color','red');
		$('#mname').focus();
		return false; 
	}
	else 
	{
		$('#errormessage-div').text("");
		$("body").css("overflow", "hidden");
		var appString = 'name_of_the_type='+ encodeURIComponent(name_of_the_type) + '&gurl='+ encodeURIComponent(gurl)+ '&mname='+ encodeURIComponent(mname)+ '&uName='+"<%=session.getAttribute("userid")%>";
		console.log(appString);
		  $.ajax({
		  method: "POST",
		   url: 'NewApp', 
		  dataType: "html",
		  data: appString,
		  success:function(resp){
			  loadTypes();
		   $('.new-app-popup').css('display','none'); 
		  },
		}); 
	}
});
</script>

<script>
	var loadTypes = function() {
		$('#applist tbody').html('');
		var html = '';
		$.ajax({
			method : "POST",
			url : 'NewLivingType',
			dataType: "json", 
			success : function(resp) {
				s = resp;
				resp.forEach(function(obj) {
					html +=  '<tr> <td class="selectedProject" name="'+ obj.nameOfType +'"> <a href="javascript:;" data="2" class="selectedProject">'+ obj.nameOfType +'</a>' 
					+'<a class="header-button new-project" id="'+ obj.nameOfType +'" href="newprojectcreation.jsp?type='+ obj.nameOfType +'" style="display: none;"><i class="fa fa-plus"></i> New Project</a>'
					+'</td> </tr>';
			  // rowId++;
			 });
				html += '<tr> <td><a class="header-button"  id="create-app"><i class="fa fa-plus"></i>New Living App</a></td> </tr>';
				$('#applist tbody').append(html);
				$('.selectedProject').mouseover(function() {
					$('#'+$(this).attr('name')).show();
				});
				$('.selectedProject').mouseout(function() {
					$('#'+$(this).attr('name')).hide();
				});
				$('#create-app').click(function(){
					$('.new-app-popup').css('display','inline-block');
				});
			},
		});
	}
	loadTypes();
</script>


