 // twitter
!function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ? 'http'
			: 'https';
	if (!d.getElementById(id)) {
		js = d.createElement(s);
		js.id = id;
		js.src = p + '://platform.twitter.com/widgets.js';
		fjs.parentNode.insertBefore(js, fjs);
	}
}(document, 'script', 'twitter-wjs');

$(document).ready(function() {
		/*lydata height*/
		$("#lydata").find("header").addClass("lynked-hcnt-down");
		$('.lynked-menu1').click(function() {
		    $(".lynked-url").toggleClass("ly-url-show");
		    $(this).toggleClass("lynked-menu1-rotate");
		    $("#lydata").find("header").hasClass("lynked-hcnt-down") ? $("header").removeClass("lynked-hcnt-down") : $("header").addClass("lynked-hcnt-down");
		    $("#lydata").hasClass("lynked-cnt-down") ? $("#lydata").removeClass("lynked-cnt-down") : $("#lydata").addClass("lynked-cnt-down");
	  	});
		function lynked_widthChk(){
			var lynked_cnt_left = 63;
			var lynked_cnt_width = $(window).width()- lynked_cnt_left;
			$('#lydata').css('width',lynked_cnt_width);
			$('#lydata').css('left',lynked_cnt_left);
		}
		lynked_widthChk();
		/* lynked-tools menu */
			$(".lynked-menu").click(function() {
				$(".lynked-tools-menu").toggleClass("lynked-tools-menu-show");
				$(this).toggleClass("lynked-menu-rotate");
				/*change width of content*/
				if ($(".lynked-tools-menu").hasClass("lynked-tools-menu-show")){
					lynked_widthChk();
				}
				else {
					$('#lydata').css('width','100%');
					$('#lydata').css('left','0');
				}
			});
			$(".lynked-tools-menu li").click(function(){
				if (lj.menuCheck()){
					$(this).children(".lynked-tool-hover").hide();
					$(this).children(".lynked-tool-hover").css('transform','translateX(-250px)');
					$(this).children(".lynked-notifi").show().fadeOut(2500);
				}
			});
			/* tools hover */
			$('.lynked-tools li').mouseover(function(){
				if (lj.menuCheck()){
					if(!($('.lynked-colorPl').is(':visible'))){
						$(this).children(".lynked-tool-hover").show();
						$(this).children(".lynked-tool-hover").css('transform','translateX(0px)');
					}
				}
			});
			$('.lynked-tools li').mouseout(function(){
				if (lj.menuCheck())
				$(this).children(".lynked-tool-hover").css('transform','translateX(-250px)');
			});
			/* tools cursor */
			$('.lynked-tools-menu-show .lynked-tools .lynked-text').click(function() {
				if (lj.menuCheck()){
					$('#lydata').css('cursor', 'text');
				}
			});
			$('.lynked-tools-menu-show .lynked-tools .lynked-crosshair').click(function() {
				if (lj.menuCheck()){
					$('#lydata').css('cursor', 'crosshair');
					$('#lydata').unbind('mouseup');
				}
			});
			$('.lynked-tools-menu-show .lynked-tools .lynked-default').click(function() {
				if (lj.menuCheck()){
						$('#lydata').css('cursor', 'default');
						$('#lydata').unbind('mouseup');
				}
			});
		});
var lj = {
	menuCheck : function() {
		return $('.lynked-tools-menu').hasClass("lynked-tools-menu-show");
	}
};

/* url msg */
function details() {
	return true;
}
/* url validation */

var tomatch = /^(http[s]?:\/\/){0,1}(com\.){0,1}[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}[\.]{0,1}/
function check_it() {
	$(".tx1").click(function() {
		$(this).parent().find('p1').removeClass('warning-msg').css("display", "none");
		$(".tx1").removeClass('warning');
	});
	if ($(".tx1").val() == "") {
		$(".tx1").parent().find('p1').html($(".tx1").attr('message')).addClass(
				'warning-msg');
		$(".tx1").addClass('warning');
		return false;
	} else if (!tomatch.test($(".tx1").val())) {
		$(".tx1").parent().find('p1').html('Please enter the valid URL')
				.addClass('warning-msg');
		return false;
	}
	return true;
}

/* popup */
$(document).ready(function() {
	$('.parent').click(function() {
		$('.child').hide();
		$('.parent').removeClass('active')
		$(this).addClass('active')
		$('#' + $(this).attr('name')).show();
	});
});
var sts = {
	lynkedLog : function() {
		if (lynkedStatus != "0") {
			$(".lynked-signout").show();
			$(".lynked-signin-open").hide();
			$('#lynked-popup1').hide();
			$('#lynked-url').show();
			$(".signin-close").hide();
		} else {
			$(".lynked-signout").hide();
			$(".lynked-signin-open").show();
		}
	}
};
window.onload = sts.lynkedLog();
var lynkedStatus = "0";
$(document).ready(function() {
	sts.lynkedLog();
	$('.lynked-signin-open').click(function() {
		$('#lynked-popup1').show();
		$('#lynked-url').hide();
		$(".signin-close").show();
		$(".lynked-signin-open").hide();
	});
	$('.signin-close').click(function() {
		$('#lynked-popup1').hide();
		$('#lynked-url').show();
		$(".signin-close").hide();
		sts.lynkedLog();
	});
});

/* Generate lynk */
$(document).ready(function() {
	$('.lynked-svg-close-popup').click(function() {
		$('body').css('overflow', 'auto');
		$('.md-overlay').hide();
		$('.md-content').hide();
	});
	$('.lynked-gen').click(function() {
		$('.md-content').show();
		$('body').css('overflow', 'hidden');
		$('.md-overlay').show();
	});
	$('.md-overlay').click(function() {
		$('.md-overlay').hide();
	});
	
	/* None Selected */
	$('.lynked-gen').click(function() {
		if(globalSelection.length == 0)
			alert("There is no Selection");
	});
	/*reset gen-form*/
	$('.md-close').click(function(){
		$('.lynked-tx1').empty();
		$('.lynked-tx2').empty();
		$('.lynked-cnt').empty();
		$('.lynked-cnt1').empty();
		$('.lynked-warng').empty();
	});
});
$("#cont").click(function() {
	submitSelection();
	generate();
});
function generate() {
	$(".lynked-tx1").click(function() {
		$('.lynked-warng').removeClass('warning-msg');
		$("lynked-tx1").focus();
		$('.lynked-warng').empty();
	});
	if ($(".lynked-tx1").text().length == 0) {
		$('.lynked-warng').html($(".lynked-tx1").attr('message')).addClass('warning-msg');
		$(".lynked-tx1").focus();
		return false;
	}
	$(".lynked-tx2").click(function() {
		$('.lynked-warng').removeClass('warning-msg');
		$(".lynked-tx2").focus();
		$('.lynked-warng').empty();
	});
	if ($(".lynked-tx2").text().length == 0) {
		$('.lynked-warng').html($(".lynked-tx2").attr('message')).addClass('warning-msg');
		$(".lynked-tx2").focus();
		return false;
	}
	if ($('input[name=radio-button]:checked').length <= 0) {
		$('.lynked-warng').html($('input[name=radio-button]').attr('message')).addClass('warning-msg');
		return false;
	}
	document.getElementById('lynked-gen-form').submit();
	return true;
}
function details() {
	return true;
}

// for list selection
$('ul.lynked-tools .lynked-tool').click(
		function(e) {
			if (lj.menuCheck()) {
				e.preventDefault(); // prevent the default action
				e.stopPropagation; // stop the click from bubbling
				$(this).closest('ul').find('.lynked-selected').removeClass(
						'lynked-selected');
				$(this).addClass('lynked-selected');
			}
		});
$('ul.lynked-tools .lynked-ntool').click(
		function(e){
			if (lj.menuCheck()) {
				e.preventDefault(); // prevent the default action
				e.stopPropagation; // stop the click from bubbling
				var  lynked_rSel = $(this).addClass('lynked-selected1');
				setTimeout(function() {
					    lynked_rSel.removeClass('lynked-selected1');
					}, 500);
			}
		}
)

$(document).ready(function() {
	$('#lynk-copy-btn').click(function() {
		$('.lynk-copy').show().fadeOut(2000);
		$('.lynk-copy-arrow').show().fadeOut(2000);

	});
});
//for signin and signup form reset
$(document).ready(function() {
 $("#signin-box-link").click(function(){
    $('#lynkedSignup').bootstrapValidator("resetForm",true); 
    $('#signup .form-group input[type="checkbox"]').prop("checked",false);
    $('.forgeterrorMessage').empty();
 });
 $("#signup-box-link").click(function(){
	 var lynked_erMsg = $('.forgeterrorMessage').text();
	 $('#lynkedSignin').bootstrapValidator("resetForm",true); 
	 if($.trim(lynked_erMsg) != "User Already Exists")
     $('.forgeterrorMessage').empty();   
 });
 $(".signin-close").click(function(){
    $('#lynkedSignin').bootstrapValidator("resetForm",true);
    $('#lynkedSignup').bootstrapValidator("resetForm",true); 
    $('#signup .form-group input[type="checkbox"]').prop("checked",false);
    $('.forgeterrorMessage').empty();
 });
 });

/*text typed*/
$('.lynked-tx1').keyup(updateCount);
$('.lynked-tx1').keydown(updateCount);
$('.lynked-tx2').keyup(updateCount1);
$('.lynked-tx2').keydown(updateCount1);
function updateCount() {
	var lynked_txt_count = 50 - $(this).text().length;
	$('.lynked-cnt').text(lynked_txt_count);
}
function updateCount1() {
	var lynked_txt_count1 = 140 - $(this).text().length;
	$('.lynked-cnt1').text(lynked_txt_count1);
}
/*color selection*/
$(document).ready(function() {
	$('.lynked-colorPl .row div').css('background-color',function(lynkedColor){
		var lynkedColor = $(this).attr("lynkedColor"); 
		return lynkedColor;
	});
	$('.lynked-colorPl .row div').click(function(){
		var lynkedColor = $(this).css('background-color');
		var lynkedChkColor = $('.lynked-selColor').siblings('.lynked-dispColor').css('background-color');
		if(lynkedColor === lynkedChkColor){
			alert("Both the Text Colour and Hilighter Colour are same");
		}
		else{
			$('.lynked-selColor').css('background-color',lynkedColor);
			$('.lynked-colorPl').hide();
		}
	}); 
	$(document).click(function(event) {
		if($('.lynked-colorPl').is(':visible')){
			((!$(event.target).closest('.lynked-colorPl').length) && (!$(event.target).closest('#Lynked-colorSelector').length)) ? 	$('.lynked-colorPl').hide() : '';
			$('.lynked-colorPl').siblings('.lynked-tool-hover').hide();
			$(this).removeClass('lynked-selected1');
		}
	});
	$('#Lynked-colorSelector').on('click', function(e) {
		if (lj.menuCheck()){
			if (e.target == this){
				$('.lynked-colorPl').toggle();
				$(this).toggleClass('lynked-selected1');
			}
		}	
	});
	$('.lynked-dispColor').on('click', function() {
		if (lj.menuCheck()){
				$('.lynked-colorPl').show();
				$('.lynked-dispColor').removeClass("lynked-selColor");
				$(this).addClass("lynked-selColor");
				$('#Lynked-colorSelector').addClass('lynked-selected1');
		}
	});
});