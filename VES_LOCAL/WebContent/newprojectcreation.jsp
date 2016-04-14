<input type="hidden" id="type" class="project-type"
	value="<%=request.getParameter("type")%>">
<%@ include file="Header.jsp"%>

<section class="wrapper">
	<div class="hd head_top">New Living App Project</div>
	<form name="newproject" method="get" action="FetchRepository"
		id="create_project">
		<input type="hidden" id="useridval"
			value="<%=session.getAttribute("userid")%>" /> <input type="hidden"
			id="userFname" value="<%=session.getAttribute("firstname")%>" /> <input
			type="hidden" id="githubUser"
			value="<%=session.getAttribute("githubuname")%>" /> <input
			type="hidden" id="githubPwd"
			value="<%=session.getAttribute("githubpword")%>" />

		<div class="row">
			<input type="text" name="new-proj-name" id="projname"
				class="form-control" placeholder="Project Name"> 
				<!-- <input type="text" name="rpath" class="form-control"
				placeholder="Repository Path" id="rpath"> -->
		</div>

		 <div class="row">
			<p>
				<span class="heading">PROJECT TYPE</span>
			</p>
			<div><%=request.getParameter("type")%> </div>
		</div>

		<div class="selection">
			<div class="row">
				<p>
					<span class="heading">PLATFORM</span>
				</p>
				<input type="radio" name="app" value="web" class="platform">Web
				<input type="radio" name="app" value="ios" class="platform">iOS
				<input type="radio" name="app" value="android" class="platform">Android

			</div>
			<div class="row">
				<p>
					<span class="heading">CLOUD</span>
				</p>
				<input type="radio" name="link" value="aws" class="cloud">AWS
				<input type="radio" name="link" value="softlayer" class="cloud">SoftLayer
				<input type="radio" name="link" value="ms-asure" class="cloud">MS
				Azure <input type="radio" name="link" value="rackspace"
					class="cloud">Rackspace <input type="radio" name="link"
					value="centurylink" class="cloud">CenturyLink

			</div>
			<div class="row">
				<p>
					<span class="heading">LANGUAGE</span>
				</p>
				<input type="radio" name="language" value="java" class="language">Java
				<input type="radio" name="language" value="php" class="language">PHP
				<input type="radio" name="language" value="node-js" class="language">Node.js

			</div>
		</div>
		<!-- <div class="selection1">
			<div class="row">
				<p>
					<span class="heading">WP Template</span>
				</p>
				<input type="checkbox" value="defender2015">Defender 2015 <input
					type="checkbox" value="defender2013">Defender 2013 <input
					type="checkbox" value="wp-origins">WP Origins <input
					type="checkbox" value="vig-template">VIG Template <input
					type="checkbox" value="oag-template">OAG Template
			</div>
			<div class="row">
				<p>
					<span class="heading">Plug-Ins</span>
				</p>
				<input type="checkbox" value="adv-custom-fields">Advanced
				Custom Fields <input type="checkbox" value="akismet">Akismet
				<input type="checkbox" value="huge-it-slider">Huge IT Slider
				<input type="checkbox" value="img-widget">Image Widget <input
					type="checkbox" value="sucuri-security">Sucuri Security <input
					type="checkbox" value="tiny-mce-adv">Tiny MCE Advanced <input
					type="checkbox" value="wp-polls">WP Polls <input
					type="checkbox" value="req-feature-img">Required Feature
				Image
			</div>
		</div> -->
		<div class="btn1">
			<input type="reset" name="Cancel" class="btn btn-lg btn-login"
				value="cancel"> <input type="button" name="Create"
				class="btn btn-lg btn-login" value="create" id="checkbtn">
		</div>
		<div id="errormessage-div"></div>
	</form>
</section>
<script src="scripts/newprojectcreate.js?t=2"></script>
<%@ include file="Footer.jsp"%>