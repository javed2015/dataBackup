<%@ include file="Header.jsp" %>
	<section class="wrapper prof">
		<div class="h1">My Account</div>
		<div class="prof-info">
		<div class="tab-pane col-md-6">Personal Information
				<div class="prof-box">
					<div class="prof-label">Name<span data-toggle="modal" href="#personalinfo" class="forgot-pass forgetpassword updatesettings">Edit</span></div>
					<div class="prof-content"><%=session.getAttribute("name")%></div>
					<div class="prof-label">Email Address</div>
					<div class="prof-content"><%=session.getAttribute("userid")%></div>
				</div>
			
				<div class="tab-pane">GIT HUB Credentials
				<div class="prof-box">
				  	<div class="prof-label">GitHub UserName<span data-toggle="modal" href="#github-edit" class="forgot-pass forgetpassword updatesettings">Edit</span></div>
					<div class="prof-content"><%=session.getAttribute("githubuname")%></div>
					<div class="prof-label">GitHub PassWord</div>
					<div class="prof-content"><% String gpassword = (String)session.getAttribute("githubpword");
							String gitoutput = "";
							for (int i = 0; i < gpassword.length(); i++) {
							    gitoutput += "*";
							}  %><%=gitoutput%> 
					</div>	
				</div>	
				</div>
			</div>
			<div class="tab-pane col-md-6">Login
			<div class="prof-box">
				<div class="prof-label">User Id</div>
				<div class="prof-content"><%=session.getAttribute("userid")%></div>
				<div class="prof-label">Password</div>
				<div class="prof-content"><% String password = (String)session.getAttribute("password");
						String output = "";
						for (int i = 0; i < password.length(); i++) {
						    output += "*";
						}  %><%=output%>
				</div>
				<!-- <div class="pass-bar">
				<span data-toggle="modal" href="#personalinfo" class="forgot-pass forgetpassword">Change Password</span>
            	</div> -->
			</div>
			</div>
		
          <!-- Modal -->
		  
          
		  <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="personalinfo" class="modal fade">
		  
              <div class="modal-dialog">
              <form name="profilesetting" id="profilesetting" action="" method="POST">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          <h4 class="modal-title">Edit Personal Information</h4>
                      </div>
                      <div class="modal-body">
                      <label for="email">First Name</label>
                      <input type="text" id="fname" name="fname" placeholder="FirstName" autocomplete="off" class="form-control placeholder-no-fix" value='<%=session.getAttribute("firstname")%>'>
                      <br> 
                      <label for="email">Last Name</label>
                      <input type="text" id="lname" name="lname" placeholder="LastName" autocomplete="off" class="form-control placeholder-no-fix" value='<%=session.getAttribute("lastname")%>'>
                       <br> 
                      <label for="email">E-Mail</label>    
                       <input type="email" id="email" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix" value='<%=session.getAttribute("userid")%>'>
                      </div>
                      <div class="modal-footer">
                          <div id="errorMessage" align="center">${message}</div><button data-dismiss="modal" class="btn btn-default btncancelsettings" type="button" id="accountcancel">Cancel</button>
                          
                          <button class="btn btn-success"  type="button" onclick='return personal()'>Save</button>
                      </div>
                  </div>
                  </form>
              </div>
          </div>
		    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="github-edit" class="modal fade">
		  
              <div class="modal-dialog">
              <form name="profilesetting" id="profilesetting" action="" method="POST">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          <h4 class="modal-title">GIT HUB Credentials </h4>
                      </div>
                      <div class="modal-body">
                      <label for="github-id">GIT HUB User-Id</label>
                      <input type="text" id="github-uname" name="github-uname" placeholder="GIT HUB-ID" autocomplete="off" class="form-control placeholder-no-fix" value='<%=session.getAttribute("githubuname")%>'>
                      <br> 
                      <label for="github-password">GIT HUB Password</label>
                      <input type="text" id="github-password" name="github-password" placeholder="GIT HUB-Password" autocomplete="off" class="form-control placeholder-no-fix" value='<%=session.getAttribute("githubpword")%>'>
                      <br> 
                      <div class="modal-footer">
                          <div id="errorMessage" align="center">${message}</div><button data-dismiss="modal" class="btn btn-default btncancelsettings" type="button" id="accountcancel">Cancel</button>
                          
                          <button class="btn btn-success"  type="button" onclick="return git()">Save</button>
                      </div>
                  </div>
                  </form>
              </div>
          </div>
          
          <!-- modal -->
       </div>  
	</section>
	

	
<script src="scripts/account-setting.js?t=5"></script>
<%@ include file="Footer.jsp" %>