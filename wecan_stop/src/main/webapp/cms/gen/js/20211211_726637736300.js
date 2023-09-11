function menu_btn_click() {
    $("body").addClass('menu-open');
    return false;
}
function navi_close() {
    $("body").removeClass('menu-open');
    $('.gnb_dep2 > a').removeClass("on");
    $('.dep02').slideUp("fast");
    return false;
}



(function ($) {
    $.fn.dropdown = function () {
        return this.each(function () {
            var $gnb = $(this);
            var $menu = $gnb.find(".menu");
            var $depth1 = $gnb.find(".depth1");
            var $depth2 = $gnb.find(".depth2");

            $gnb
                .mouseenter(function () {
                    gnbOn();
                })
                .mouseleave(function () {
                    gnbOff();
                });

            $gnb
                .find("a")
                .focusin(function () {
                    gnbOn();
                })
                .focusout(function () {
                    gnbOff();
                });

            function gnbOn() {
                $gnb.find($depth2).stop().animate({ height: "200" });
                $('.gnb_bg').stop().animate({ height: "200" });
            }

            function gnbOff() {
                $gnb.find($depth2).stop().animate({ height: "0" });
                $('.gnb_bg').stop().animate({ height: "0" });
            }

            $menu.mouseenter(function() {
                $(this).addClass('on');
            });
            $menu.mouseleave(function() {
                $(this).removeClass('on');
            });
        });
    };
})(jQuery);

$(function () {
    $(".dropdown").dropdown();
});

/* popup닫기 */
function popup_close() {
    $(".popup_wrap").hide();
    return false;
}

$(document).ready(function() {

    $('.dep02').hide();
    $('.nav_wrap .navi .gnb_ul > li p').click(function() {
        $(this).parent('li').siblings('li').children('.dep02').slideUp(100);
        $(this).parent('li').siblings('li').children('.dep02').children('ul').children('li').children('.dep03').slideUp(100);
        $(this).parent('li').children('.dep02').slideToggle(100);
        $(this).parent('li').toggleClass('on');
        $(this).parent('li').siblings().removeClass('on');
        $(this).parent('li').children('.dep02').children('ul').children('li').siblings().removeClass('on');
    });

    //gnb


    $('.main_slide').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        dots: true,
        infinite: true,
        cssEase: 'linear',
        arrows: true,
        prevArrow: '<div class="slick-prev"></div>',
        nextArrow: '<div class="slick-next"></div>',
        variableWidth: false,
        draggable: false,
        autoplay: false,
        autoplaySpeed: 1500
    });

    $('.banner_slide').slick({
        slidesToShow: 2,
        slidesToScroll: 1,
        dots: true,
        infinite: false,
        cssEase: 'linear',
        arrows: true,
        prevArrow: '<div class="slick-prev"></div>',
        nextArrow: '<div class="slick-next"></div>',
        variableWidth: false,
        draggable: false,
        autoplay: true,
        autoplaySpeed: 1000,
        responsive: [ // 반응형 웹 구현 옵션
            {
                breakpoint: 1200, //화면 사이즈 960px
                settings: {
                    slidesToShow:1,
                }
            }
        ]
    });
    $('.stop').click(function(){
        $('.banner_slide').slick('slickPause');
    });

});

function isEmail(email) {
	var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email);
}

function isPhone(phone) {
	var regex = /^010-?([0-9]{3,4})-?([0-9]{4})$/;
	return regex.test(phone);
}

function autoHypenPhone(str){
      str = str.replace(/[^0-9]/g, '');
      var tmp = '';
      if( str.length < 4){
          return str;
      }else if(str.length < 7){
          tmp += str.substr(0, 3);
          tmp += '-';
          tmp += str.substr(3);
          return tmp;
      }else if(str.length < 11){
          tmp += str.substr(0, 3);
          tmp += '-';
          tmp += str.substr(3, 3);
          tmp += '-';
          tmp += str.substr(6);
          return tmp;
      }else{              
          tmp += str.substr(0, 3);
          tmp += '-';
          tmp += str.substr(3, 4);
          tmp += '-';
          tmp += str.substr(7);
          return tmp;
      }
  
      return str;
}

function isPwd(pwd){
	var num = pwd.search(/[0-9]/g);
 	var eng = pwd.search(/[a-z]/ig);
 	var spe = pwd.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

 	if(pwd.length < 8 || pwd.length > 20){
		alert("비밀번호는 8자리 ~ 20자리 이내로 입력해주세요.");
  		return false;
 	}else if(pwd.search(/\s/) != -1){
  		alert("비밀번호는 공백 없이 입력해주세요.");
  		return false;
 	}else if(num < 0 || eng < 0 || spe < 0 ){
  		alert("비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
  		return false;
 	}else {
    	return true;
 	}
}

function getTimeString(second) {
	var minute = '' + (Math.floor(second / 60));
	var dividedSec = second % 60;
	if (dividedSec < 10) {
		dividedSec = '0' + dividedSec;
	}
	return minute + ":" + dividedSec;
}

function getToday(){
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var date = now.getDate();

    month = month >=10 ? month : "0" + month;
    date  = date  >= 10 ? date : "0" + date;

    return today = ""+year + month + date;
}

function getDate(){
	var now = new Date();
	var week = ["일", "월", "화", "수", "목", "금", "토"]; 
	var dayOfWeek = week[now.getDay()]; 
	return dayOfWeek;
}

