//by kms 20140530
// 아래는 서로간의 종속관계에 있으므로 순서를 바꾸면 안됩니다. 
$(function() {
	var isPc = $(window).width() > 783;
//	alert(isPc);
	//GNB START HIDE
	$("#gnb li div").hide();

	//GNB MOUSE LEAVE HIDE
	$("#gnb div").mouseleave(function(){
		$("#gnb div").hide();
	});
	$(".gnb").mouseleave(function(){
		$("#gnb div").hide();
	});
	//gnb 메뉴 on
	if(!(typeof gnbnum === 'undefined')){
		$("#gnb > li").eq(gnbnum).addClass("on");
	}

	

	//기타유관사이트
	$("#other-site > ul").hide();
	$("#other-site > span >a").click(function(){
		var other_site_menu = $(this).parent().next("ul");
		if( other_site_menu.is(":visible") ){
			other_site_menu.slideUp("fast");
		}else{
			other_site_menu.slideDown("fast");
		}
	}); 

	

	//메뉴를 클릭했을 때 - 테블릿
	$("#lnb > div > strong > a").click(function(){
		if ($(window).width() <= 783) {
			$("#lnb > div > ul").show();
		}
	});
	//메뉴를 벗어났을때 - 테블릿
	$("#lnb > div").mouseleave(function(){
		if ($(window).width() <= 783) {
			$("#lnb > div > ul").hide();
		}
	});
	
	//key focus 테블릿
	$("#lnb > div > strong > a").focus(function(){
		if ($(window).width() <= 783) {
			$("#lnb > div > ul").show();
		}
	});
	//strong에 마우스가 왔을 때 - 테블릿
	$("#lnb div ul li a").click(function(){
		if ( $(window).width() <= 783) {
			$(this).parent("li").siblings().children("ul").hide();
			$(this).next("ul").show();
		}
	});
	//strong 클릭시 - PC
	$("#lnb div ul strong a").click(function(){
		if ($(window).width() > 783) {
			//나머지 ul 숨김
			$("#lnb div ul li ul").hide();
			//해당 ul만 보임
			$(this).parent("strong").next("ul").show();
			$("#lnb div ul  li").removeClass("on");
			$(this).parent().parent("li").addClass("on");
			$("#lnb > div > ul > li").eq(lnbnum).children("ul").children("li").eq(lnbsubnum).addClass("on");
		}
	});
	


	/*lnb 메뉴 부분*/
	$("#lnb div ul li ul").hide();

	if(!(typeof lnbnum === 'undefined')){
		if($(window).width() > 783){
			$("#lnb > div > ul > li").eq(lnbnum).addClass("on");
			$("#lnb > div > ul > li").eq(lnbnum).children("ul").show();
			if(!(typeof lnbsubnum === 'undefined')){
				$("#lnb > div > ul > li").eq(lnbnum).children("ul").children("li").eq(lnbsubnum).addClass("on");
			}
		}
	}

	/*var lnb_pc =	$(".lnb-pc").eq(0).detach();
	var lnb_tablet =$(".lnb").eq(0).detach();*/


	//layout.js를 통합시킨다. =================================================
	$(window).resize(function(){
		var width = parseInt($(this).width());
		if (width <= 783) {
			$("#lnb > div > ul").hide();
		} else{
			$("#lnb > div > ul").show();
		}
	}).resize();

	
	//각 페이지 마다 print를 삽이해야하기에 location을 기준으로 print div를 삽입 시킴
	if($(".location") != null){
		$( '<div class="printing"><a href="#none" onclick=pop_print($("head").html(),$(".cont-right").html());><img src="/usr/skin/board/notice/image/icon_print.gif" alt="프린트" /></a></div>').insertAfter( ".location");
	}
	/*if(div_location != null && div_location.length != 0){
		var inputTag = '<div class="printing"><a href="#none" onclick=window.print($(".cont-right").val());><img src="/usr/skin/board/notice/image/icon_print.gif" alt="프린트" /></a></div>';
		var divTag = document.createElement("div");
		//div_location.nextElementSibling.outerHTML=inputTag;
		divTag.outerHTML = inputTag
		div_location.parentNode.insertBefore(divTag, div_location.nextSibling);
		
		
	}*/

	
});//jquery document ready END.

function showsubgnb(number){
	$("#gnb li div").hide();
	$("#gnb >li").eq(number).children("div").show("fast");
}

function refreshGnbScript(){
	var gnb_script = $("#gnb_script").html();
	$("#gnb_script").html("");
	$("#gnb_script").html(gnb_script);

}


//CENTER DIV
jQuery.fn.center = function () {
	this.css("position","absolute");
	this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
	this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
	return this;
};


function pop_print(head,cont){
    w=window.open("", 'Print_Page', 'scrollbars=yes');        
    w.document.write( '<!DOCTYPE html><html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">' );
    w.document.write( "<html>" );
    w.document.write( "<head>" );
    w.document.write(head);
    w.document.write( "</head>" );
    w.document.write( "<body><div class='cont-right'>" );
    w.document.write(cont);
    w.document.write( "</div>" );
    w.document.write( "</body>" );
    w.document.write( "</html>" );
    w.document.close();
    w.print();
}