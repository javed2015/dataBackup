<%
String context = application.getAttribute("lynk_context").toString();

%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<div id="lynked-editor" class="container-fluid">
	<div class="url-container">
	<div class="lynked-url ly-url-show">
	<form name="myForm" id="fn-reUrl" method="post" onsubmit="return check_it()"
					action="f">		
		<div  id="lynked-dUrl" class="tx1 lynked-url-box lynked-box1" contenteditable="true" name="URL" ></div> 
		<input type="hidden" id="lynked-dUrl1" class="tx1 lynked-url-box lynked-box1" name="URL" /> 
		<div class="lynked-open" onClick="FN_Reopen();">Open</div>
	</form>
			<div class="lynked-menu1 lynked-arrow">
				<i class="flaticon-chevron19"></i>
			</div>
		</div>

	
		
	<div class="lynked-tools-menu lynked-tools-menu-show">
		<ul class="lynked-tools">
			<div class="lynked-menu">
				<i class="flaticon-chevron19"></i>
			</div>
			<li id="Lynked-textMarker" class="lynked-tool lynked-text" title="Text-Marker"><i class="flaticon-marker1"></i><div class="lynked-notifi">Text-Marker Selected</div><!-- <div class="lynked-tool-hover">Text Marker</div> --></li>
			<li id="Lynked-shapes" class="lynked-tool lynked-crosshair" title="Shapes"><i class="flaticon-rectangular47"></i><div class="lynked-notifi">Under-Construction</div><!--<div class="lynked-tool-hover">Shapes</div>--></li>
			<li id="Lynked-brushMarker" class="lynked-tool lynked-text" title="Brush-Marker"><i class="flaticon-paintbrush4"></i><div class="lynked-notifi">Brush-Marker Selected</div><!-- <div class="lynked-tool-hover">Brush Marker</div> --></li>
		<!-- <li id="Lynked-pointerMarker" class="lynked-tool lynked-default" title="Pointer-Marker" ><i class="flaticon-square318"></i><div class="lynked-notifi">Under-Construction</div><div class="lynked-tool-hover">Pointer Marker</div></li> -->
			<li id="Lynked-elementMarker" class="lynked-tool lynked-default" title="Element-Marker" ><i class="flaticon-paint86"></i><div class="lynked-notifi">Element Marker Selected</div><!-- <div class="lynked-tool-hover">Element Marker</div> --></li>
			<li id="Lynked-pageMarker" class="lynked-tool lynked-default"  title="Page-Marker" ><i class="flaticon-file10"></i><div class="lynked-notifi">Under-Construction</div><!-- <div class="lynked-tool-hover">Page Marker</div> --></li>
		    <li id="Lynked-colorSelector" title="Select Colors">
		    	<div class="lynked-dispColor lynked-textColor lynked-selColor"></div>
				<div class="lynked-dispColor lynked-highlighterColor"></div>	
		    	<div class="lynked-colorPl">
		    		<div class="row">
		    			<div class="lynked-c-red" lynkedColor="#FFFFFF"></div>
		    			<div class="lynked-c-red" lynkedColor="#FF0000"></div>
		    			<div class="lynked-c-red" lynkedColor="#FF8000"></div>
		    			<div class="lynked-c-red" lynkedColor="#FFFF00"></div>
		    			<div class="lynked-c-red" lynkedColor="#00FF00"></div>
		    			<div class="lynked-c-red" lynkedColor="#00FFFF"></div>
		    		</div>
		    		<div class="row">
		    			<div class="lynked-c-red" lynkedColor="#000000"></div>
		    			<div class="lynked-c-red" lynkedColor="#736F6E"></div>
		    			<div class="lynked-c-red" lynkedColor="#FF00FF"></div>
		    			<div class="lynked-c-red" lynkedColor="#8000FF"></div>
		    			<div class="lynked-c-red" lynkedColor="#0000FF"></div>
		    			<div class="lynked-c-red" lynkedColor="#0080FF"></div>
		    		</div>
		    	 </div>
		    	 <!-- <div class="lynked-tool-hover">Select Color</div> -->
		    </li> 
			<!-- <li id="Lynked-eraser" class="lynked-tool lynked-default" ><i class="flaticon-eraser8"></i><div class="lynked-notifi">Under-Construction</div><div class="lynked-tool-hover">Eraser</div></li> -->
			<li id="lynked-undo" class="lynked-ntool" title="Undo"><i class="flaticon-undo19"></i>
			<li id="lynked-redo" class="lynked-ntool" title="Redo"><i class="flaticon-redo10"></i>
		</ul>
	</div>
	<div>
		<a class="lynked-gen md-trigger" data-modal="lynked-modal-1">Generate Note</a>
	</div>

	<div class="lynked-modal md-effect-popup" id="lynked-modal-1">
			<div class="lynked-info md-content">
				<div class="lynked-svg-close-popup md-close">
					<svg version="1.1" x="0px" y="0px" width="15px" height="15px"
						viewBox="0 0 348.333 348.334"
						style="enable-background: new 0 0 348.333 348.334;"
						xml:space="preserve">
						<g>
							<path
							d="M336.559,68.611L231.016,174.165l105.543,105.549c15.699,15.705,15.699,41.145,0,56.85
								c-7.844,7.844-18.128,11.769-28.407,11.769c-10.296,0-20.581-3.919-28.419-11.769L174.167,231.003L68.609,336.563
								c-7.843,7.844-18.128,11.769-28.416,11.769c-10.285,0-20.563-3.919-28.413-11.769c-15.699-15.698-15.699-41.139,0-56.85
								l105.54-105.549L11.774,68.611c-15.699-15.699-15.699-41.145,0-56.844c15.696-15.687,41.127-15.687,56.829,0l105.563,105.554
								L279.721,11.767c15.705-15.687,41.139-15.687,56.832,0C352.258,27.466,352.258,52.912,336.559,68.611z"
							style="fill: #e5e5e5;" />
						</g>
					</svg>
				</div>
				<form id="lynked-gen-form" onsubmit=" return generate()" action="lynk.jsp">
					<div contenteditable="true" class="lynked-tx1" id="lynk_name" data-text="Name" max="50" message="Enter the Name"></div>
					<div class="lynked-cnt"></div>
					<div contenteditable="true" class="lynked-tx2" id="lynk_desc" data-text="Description" max="140" message="Enter the Description"></div>	
					<div class="lynked-cnt1"></div>				
					<input type="hidden" id="lynk_token1" name="lynk_token1"
						value="token" />
					<div class="lynked-checkbox">
						<input type="radio" id="lynk_flag1" name="radio-button" message="Select the Note type" value="privacy">Private 
						<input type="radio"	id="lynk_flag2" name="radio-button" message="Select the Note type" value="public" checked="true">Public
					</div>
					<div autofocus class="lynked-warng"></div>
					<div class="lynked-submit-btn">
						 <div class="lynked-edit" id="cont" style="float:right;">Continue</div>
						<!--  <div class="lynked-edit" id="gen-pdf" style="float:left;">Run Code</div> -->
						
					</div>
				</form>
			</div>
	</div>
	<div class="md-overlay md-close"></div>
</div>


<script>
	var entrUrl = document.getElementById("lynk_url").value	
	document.getElementById("lynked-dUrl").innerHTML = entrUrl;
</script>
<script>
			/*for reUrl open*/
function FN_Reopen() {
	var reOpenUrl1 = document.getElementById("lynked-dUrl").innerHTML;
	document.getElementById("lynked-dUrl1").value = reOpenUrl1;
	document.getElementById("fn-reUrl").submit();
}

$(document).ready(function() {
	/*new tab*/
	$('#lydata a').prop('target','_blank');	
	$('.lynked-tools li').click(function(){
		if($(this).is("#Lynked-elementMarker")){
			$('#lydata a').attr("onclick", "return false");
		}
		else {
			$('#lydata a').removeAttr("onclick"); 
		}
	});	
	/* window.onbeforeunload = confirmExit;
  function confirmExit()
  {
    return "You have attempted to leave this page." + "\n\n" + "The changes you made will be lost if you navigate away from this page.";
  }  */
	/* content editable div */
	$("#lynked-editor div [contenteditable='true']").keypress(function(e){ return e.which != 13; });
	/* text limit */
	var textfields = document.getElementsByClassName("lynked-tx1"); 
	for(i=0; i<textfields.length; i++){
	    textfields[i].addEventListener("keypress", function(e) {
	        if($(this).text().length >= this.getAttribute("max")){
	            e.preventDefault();
	            return false;
	        }
	    }, false);
	}
});
</script>
 <!-- <script type="text/javascript" src="js/jspdf.js"></script>
 <script type="text/javascript" src="js/from_html.js"></script>
 <script type="text/javascript" src="js/split_text_to_size.js"></script>
 <script type="text/javascript" src="js/standard_fonts_metrics.js"></script>
 <script type="text/javascript" src="js/FileSaver.js"></script> 
 <script type="text/javascript" src="js/cell.js"></script> 
 <script>
 $("#gen-pdf").click(function() {
	alert("test-pdf");
	factualPdf();
});
 
    function factualPdf() {
    var doc = new jsPDF('p', 'in', 'letter');
    var source = document.getElementById('lydata');
    var specialElementHandlers = {
        '#bypassme': function (element, renderer) {
            return true;
        }
    };
	 pdf.addHTML($('#lydata')[0], function () {
     pdf.save('Test.pdf');
 });
}
</script> -->