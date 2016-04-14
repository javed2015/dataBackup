function DropDown(el) {
				this.dd = el;
				this.placeholder = this.dd.children('span');
				this.opts = this.dd.find('ul.dropdown > li');
				this.val = '';
				this.index = -1;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					/*obj.dd.on('click', function(event){
						if($(this).hasClass('active'))
						{
							$('.wrapper-dropdown-3').removeClass('active');
							console.log(1);
							
						}
						else{
							$('.wrapper-dropdown-3').removeClass('active');
							$(this).addClass('active');
							console.log(2);
						}
						return false;
					});*/

					obj.opts.on('click',function(){
						var opt = $(this);
						obj.val = opt.text();
						obj.index = opt.index();
						//obj.placeholder.text(obj.val);
					});
				},
				getValue : function() {
					return this.val;
				},
				getIndex : function() {
					return this.index;
				}
			}

			$(function() {

				var dd = new DropDown( $('.dd') );
				$(document).click(function(event) {
				    if ( !$(event.target).closest( "#notification" ).length ) {
				    	$('.wrapper-dropdown-3').removeClass('active');
				    }
				});
				

			});