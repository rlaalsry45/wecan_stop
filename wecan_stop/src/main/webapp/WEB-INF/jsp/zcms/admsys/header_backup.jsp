<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<c:if test="${empty input.location }">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${projectName}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="X-UA-Compatible" content="IE=10"/>
    <link rel="stylesheet" type="text/css" href="/cms/css/democratic.css"/>
    <link rel="stylesheet" type="text/css" href="/cms/css/target.css"/>
    <link rel="stylesheet" type="text/css" href="/com/css/dtree.css"/>
    <link rel="stylesheet" type="text/css" href="/com/css/tarea.css"/>
    <link rel="stylesheet" type="text/css" href="/var/alertify/alertify.css"/>
    <link rel="stylesheet" type="text/css" href="/usr/css/toastr.min.css"/>
    <link href="/usr/css/admin_system.css" rel="stylesheet" media="all">
    <script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="/com/js/jquery-ui.js"></script><!--레이어팝업드레그-->
    <script type="text/javascript" src="/cms/js/func.js"></script>
    <script type="text/javascript" src="/com/js/spin.js"></script>
    <script type="text/javascript" src="/com/js/purl.js"></script>
    <script type="text/javascript" src="/cms/js/valid.js"></script>
    <script type="text/javascript" src="/com/js/dtree.js"></script>
    <script type="text/javascript" src="/com/js/tarea.js"></script>
    <script type="text/javascript" src="/com/js/popup.js"></script>
    <script type="text/javascript" src="/com/js/var.js"></script> <!--여러 효과-->
    <script type="text/javascript" src="/var/alertify/alertify.js"></script>
    <script type="text/javascript" src="/cms/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" charset="utf-8" src="/var/ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="/usr/js/common.js"></script>
    <script type="text/javascript" src="/usr/js/toastr.min.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        <c:choose>
        <c:when test="${chgJquery eq 'Y' }">
        var J = jQuery.noConflict();

        /* 하단top 링크 */
        J(document).ready(function () {
            J(window).scroll(function () {
                if (J(this).scrollTop() !== 0) {
                    J('#top').fadeIn();
                } else {
                    J('#top').fadeOut();
                }
            });

            J('#top').click(function () {
                J('body,html').animate({scrollTop: 0}, 800);
            });

            /* Left Navigation Bar Slide */
            /*---------------------------------------------------------------*/
            /* Only first menu slide-up */
            J(".subtitle:not(:first)").attr('class', 'subtitle sub_on');
            J(".sub1:first").css("display", "block");
            J(".sub1:not(:first)").css("display", "none");
            /*---------------------------------------------------------------*/

            /*---------------------------------------------------------------*/
            /* Full menu slide-down */
            // J(".subtitle").attr('class','subtitle sub_on');
            // J(".sub1").css('display','none');
            /*---------------------------------------------------------------*/

            J(".subtitle").click(function () { // When clicked div(subtitle)
                if (J(this).next(".sub1").css("display") === "none") {
                    J(this).attr('class', 'subtitle');
                } else {
                    J(this).attr('class', 'subtitle sub_on');
                }
                J(this).next(".sub1").slideToggle('fast');
            });

            /* Top Menu Hi-Light */
            var cast = false;
            var menu = null;
            for (var index = 0; index < J(".menu li").length; ++index) {
                menu = J(".menu li a").eq(index).attr("href");
                J(".lnb ul li a").each(function () {
                    if (menu === J(this).attr("href")) {
                        J(".menu li a").eq(index).addClass('on');
                        cast = true;
                        return false;
                    }
                });
                if (cast) return;
            }
            if (cast === false) {
                for (var index = 0; index < J(".menu li").length; ++index) {
                    menu = J(".menu li a").eq(index).attr("href").replace(/[\\\/][^\\\/]*$/, '');
                    J(".lnb ul li a").each(function () {
                        if (menu === J(this).attr("href").replace(/[\\\/][^\\\/]*$/, '')) {
                            J(".menu li a").eq(index).addClass('on');
                            cast = true;
                            return false;
                        }
                    });
                    if (cast) return;
                }
            }

            /* Left Navigation Bar Hi-Light */
            var flop = true;
            var href = window.location.pathname + window.location.search;
            J(".lnb ul li a").each(function () {
                if (href === J(this).attr("href")) {
                    J(this).addClass('on');
                    flop = false;
                    return false;
                }
            });
            if (flop) {
                href = window.location.pathname.replace(/[\\\/][^\\\/]*$/, '');
                J(".lnb ul li a").each(function () {
                    var addr = J(this).attr("href").replace(/[\\\/][^\\\/]*$/, '');
                    if (addr.indexOf(href) > -1 || href.indexOf(addr) > -1) {
                        J(this).addClass('on');
                        return false;
                    }
                });
            }
        });
        </c:when>
        <c:otherwise>
        /* 하단top 링크 */
        $(document).ready(function () {
            $(window).scroll(function () {
                if ($(this).scrollTop() != 0) {
                    $('#top').fadeIn();
                } else {
                    $('#top').fadeOut();
                }
            });

            $('#top').click(function () {
                $('body,html').animate({scrollTop: 0}, 800);
            });

            /* Left Navigation Bar Slide */
            /*---------------------------------------------------------------*/
            /* Only first menu slide-up */
            $(".subtitle:not(:first)").attr('class', 'subtitle sub_on');
            $(".sub1:first").css("display", "block");
            $(".sub1:not(:first)").css("display", "none");
            /*---------------------------------------------------------------*/

            /*---------------------------------------------------------------*/
            /* Full menu slide-down */
            // $(".subtitle").attr('class','subtitle sub_on');
            // $(".sub1").css('display','none');
            /*---------------------------------------------------------------*/

            $(".subtitle").click(function () { // When clicked div(subtitle)
                if ($(this).next(".sub1").css("display") === "none") {
                    $(this).attr('class', 'subtitle');
                } else {
                    $(this).attr('class', 'subtitle sub_on');
                }
                $(this).next(".sub1").slideToggle('fast');
            });

            /* Top Menu Hi-Light */
            var cast = false;
            var menu = null;
            for (var index = 0; index < $(".menu li").length; ++index) {
                menu = $(".menu li a").eq(index).attr("href");
                $(".lnb ul li a").each(function () {
                    if (menu === $(this).attr("href")) {
                        $(".menu li a").eq(index).addClass('on');
                        cast = true;
                        return false;
                    }
                });
                if (cast) return;
            }
            if (cast === false) {
                for (var index = 0; index < $(".menu li").length; ++index) {
                    menu = $(".menu li a").eq(index).attr("href").replace(/[\\\/][^\\\/]*$/, '');
                    $(".lnb ul li a").each(function () {
                        if (menu === $(this).attr("href").replace(/[\\\/][^\\\/]*$/, '')) {
                            $(".menu li a").eq(index).addClass('on');
                            cast = true;
                            return false;
                        }
                    });
                    if (cast) return;
                }
            }

            /* Left Navigation Bar Hi-Light */
            var flop = true;
            var href = window.location.pathname + window.location.search;
            $(".lnb ul li a").each(function () {
                if (href === $(this).attr("href")) {
                    $(this).addClass('on');
                    flop = false;
                    return false;
                }
            });
            if (flop) {
                href = window.location.pathname.replace(/[\\\/][^\\\/]*$/, '');
                $(".lnb ul li a").each(function () {
                    var addr = $(this).attr("href").replace(/[\\\/][^\\\/]*$/, '');
                    if (addr.indexOf(href) > -1 || href.indexOf(addr) > -1) {
                        $(this).addClass('on');
                        return false;
                    }
                });
            }
        });
        </c:otherwise>
        </c:choose>

        var _spinner = undefined;
        function spinner(id) {
            if (_spinner) {
                _spinner.stop();
            } else {
                if (id) {
                    _spinner = new Spinner().spin(document.getElementById(id));
                } else {
                    _spinner = new Spinner().spin();
                }
            }
        }

        var SetTime = 3600;
        
        $(document).ready(function () {
        	$("#reset_time").click(function()
    		{
    			SetTime = 3600;
    		});
        	
        	//setInterval("msg_time()",1000);
        	setInterval("notify()",10000);
        });

       	/*function msg_time() {

           	var msg = Math.floor(SetTime / 60) + "분 " + (SetTime % 60) + "초";
           	$("#time").html(msg);

           	SetTime--;
           	
           	if (SetTime < 0) {
           		alert("장시간 미사용하여 로그아웃되었습니다.");
           		document.location.href = "/login.html";	
           	}
        }*/

		function notify() {
       		
       		var business = "Z00302";
       		$.ajax({
       			type: "POST"
       			,url: "/admsys/notify/getNotifyList.html"
       			,data: "business="+business
       		   	,dataType: "json"
       			,async: false				
       		    ,success: function(data){
       		    	if(data.resultCode == "success"){
       		    		var notice = Number($("#notice").text()) + Number(data.notifyCnt);
       		    		$("#notice").text(notice);
       		    		
       		    		data.notifyList.forEach(function(notify){
       		    			toastr.options = {
            		        	"closeButton": false,
            		      		"debug": false,
            		      		"newestOnTop": false,
            		      		"progressBar": false,
            		      		"positionClass": "toast-bottom-right",
            		      		"preventDuplicates": false,
            		      		"onclick": null,
            		      		"onCloseClick": null,
            		      		"showDuration": "5000",
            		      		"hideDuration": "3000",
            		      		"timeOut": "20000",
            		      		"extendedTimeOut": "0",
            		      		"showEasing": "swing",
            		      		"hideEasing": "linear",
            		      		"closeEasing": "linear",
            		      		"showMethod": "slideDown",
            		      		"hideMethod": "slideUp",
            		      		"closeMethod": "slideUp"
            		       	};

       		       			toastr.info(notify.notifyContent);
       		    		});
       		        }
       		    },error: function(data){
       		        //alert("알림처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
       		    }
       		});
       		
       	}
       	
       	function updateNotify(notifyNo){
       		var business = "Z00302";
       		$.ajax({
       			type: "POST"
       			,url: "/admsys/notify/updateNotify.html"
       			,data: "business="+business+"&notifyNo="+notifyNo
       		   	,dataType: "json"
       			,async: false				
       		    ,success: function(data){
       		    	if(data.resultCode == "success"){
       		    	}
       		 	},error: function(data){
    		        //alert("알림처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
    		    }
       		});
       	}
       	
       	function notice(){
       		$("#notice").text("0");
       		location.href = "/admsys/consultingmng/allcmsrch.html";
       	}
       	
        
        function add_admin(userid) {
            url = "/admsys/setting/auth/regadmin_pop.html?userid="+userid+"&popType=header";
            //window.open(url, "result1122", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=450, height=400");
            PopupCenter(url, "result1122", "450", "400");
        }
    </script>
</head>
<body id="main">
<div id="top"><img src="/cms/image/common/top.png" alt="top"/></div>
<div class="skip_navi">
    <a href="#header">메뉴바로가기</a><br/>
    <a href="#container">서브메뉴 바로가기</a><br/>
    <a href="#contents">본문 바로가기</a>
</div>
<div id="wrap">
    <div id="header">
        <menu:menuOut opt="gnb" authMenu="${authMenu}" projectName="${projectName}"/>
        <ul class="topmenu">
<!--             <li class="first"> -->
<!--                 <label for="ex_select">홈페이지 바로가기</label> -->
<!--                 <select style="height:27px;" id="ex_select" title="홈페이지 바로가기"> -->
<%--                     <c:forEach items="${sitelist}" var="site"> --%>
<%--                         <option value="<c:out value='${site.sitedomain}' />"><c:out value='${site.sitetitle}'/></option> --%>
<%--                     </c:forEach> --%>
<!--                 </select> -->
<!--                 <div class="select"> -->
<!--                     <a href="#" title="새창으로 링크 열기" onclick="window.open('http://'+$('#ex_select').val());"> -->
<!--                         <img src="/cms/image/main/go.png" alt="go"/></a> -->
<!--                 </diviss="first">자동 로그아웃까지 <font id="time" color='red'>60분 0초</font> 남았습니다. <a href="#" id="reset_time">[연장]</a></li> -->
            <li class="first">
            	<a href="javascript:notice();" class="alert_btn"><img src="/cms/image/main/KakaoTalk_20211215_233710316_02.png"><span id="notice" style="color:white;">0</span></a>
            </li>
            <li class="admin">
                <!-- <a href="/admsys/user/common/searchIndex.html"><c:out value='${login_user}'/></a> -->
                <a href="#none" onclick="add_admin('${emp_id}');"><c:out value='${login_user}'/></a>
                
            </li>
            <li class="end">
                <a href="/j_spring_security_logout?type=manage">로그아웃</a>
            </li>
        </ul>
    </div><!-- header -->
</c:if>
<c:if test="${input.location eq 'Y' }">
	<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}"/>
	<div class="location">
		<a href="/admsys/dashboard/index.html">HOME</a>
		<c:forEach var="data" items="${input.authMenu }" varStatus="status">
		
			
		
			<c:if test="${data.urllevel eq '0' }">
				<c:forEach var="data2" items="${input.authMenu }" varStatus="status2">
					
					
					
				</c:forEach>
			
			
				<a href="/admsys/site/site/">${data.urltitle }</a>
			</c:if>
		</c:forEach>
	
	
		  <strong>CSS ss관리</strong>
	</div>
</c:if>
