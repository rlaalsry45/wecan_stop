<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title> 팝업 </title>
		<meta name="Generator" content="eclipse">
		<meta name="Author" content="yjlzq">
		<meta name="Keywords" content="popup">
		<meta name="Description" content="팝업관리">
		<link rel="stylesheet" href="/usr/skin/popup/default/css/popup.css" type="text/css" />
		<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<!-- 		<script type="text/javascript" src="http://malsup.github.com/jquery.form.min.js"></script> -->
<!-- 		<script type="text/javascript" src="/usr/skin/popup/default/js/popup.js" defer></script> -->
<%-- 		<%@ page contentType="text/html;charset=utf-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<%@ taglib prefix="pt" uri="/WEB-INF/tld/pagingTag.tld" %>
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
		<script type="text/javascript">
			if ("true"=="${close}"){
				self.close();
			}
			
			//쿠키설정    
		    function setCookie( name, value, expiredays ) {
		    	var todayDate = new Date();
		    	todayDate.setDate( todayDate.getDate() + expiredays );
		    	document.cookie = name + '=' + escape( value ) + '; path=/; expires=' + todayDate.toGMTString() + ';'
		    }

		    //닫기 버튼 클릭시
		    function closeWin(key)
		    {
		        if($("#todaycloseyn").prop("checked"))
		        {
		            setCookie('wecanpopup'+key, 'Y' , 1 );
		        }
		        window.close();
		    }
		</script>
	</head>
<body>
<div id="skin">
<form name="popup_default" method="post" action="/skin/popup/default/popup_cookie.html">
	<input type="hidden" name="popupno" value="${popupVo.popupno}" />
	<c:if test="${popupVo.popupimg != null }" >
		<c:set var="popup_size" value="${fn:split(popupVo.popupsize, ':') }" />
	
		<div class="popup_img">
			<img src="/usr/upload/popup/${popupVo.popupimg}" width="${popup_size[0] }" border="0">
			<c:if test="${popupVo.popupno eq 4}">
			<a href="https://wecan.stop.or.kr/?menuno=249" target="_blank"><div style="position:absolute; top:412px; left:353px; width:33px; height:23px; cursor:pointer; border: 1px solid"></div></a>
			</c:if>
			<c:if test="${popupVo.popupno eq 8}">
			<a href="https://forms.office.com/r/uZMwUBbgKe" target="_blank"><div style="position:absolute; top:655px; left:310px; width:33px; height:23px; cursor:pointer; border: 1px solid"></div></a>
			</c:if>
		</div>
	</c:if>
	<div>
		${popupVo.conts}
	</div>
	<!--오늘 하루 이 창을 열지 않음 시작-->
	<div class="popup_footer">
		<!--오늘 하루 이 창을 열지 않음 시작-->
		<c:if test='${popupVo.today == "1"}'>
			<span class="popup_today"><input type="checkbox" id="todaycloseyn" name="todaycloseyn" style="vertical-align:middle"> 오늘 하루 이 창을 열지 않음</span>
		</c:if>
		<!--/오늘 하루 이 창을 열지 않음 끝-->
		<span style="margin-right:5px"><c:if test="${popupVo.popupno eq 4}"><a href="javascript:closeWin(2);"></c:if><img src="/usr/skin/popup/default/images/btn_popup_close.png" border="0" ></a></span>
	</div>
</form>
</div><!--/skin-->
</body>
</html>