<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<c:if test="${not empty detail.conts}">
<script>
$(document).ready(function(){
	$(".pop_wrap .pop_btn a").click(function(){
		$('.pop_wrap').css('margin-top','-140px');
		setCookie( "popupzone", "done" , 1);
	});	
	
	var blnCookie = getCookie( "popupzone");
	if(blnCookie != "") {  
       $(".pop_wrap").hide();
	}  
});


  
// 쿠키 가져오기  
function getCookie( name ) {  
   var nameOfCookie = name + "=";  
   var x = 0;  
   while ( x <= document.cookie.length )  
   {  
       var y = (x+nameOfCookie.length);  
       if ( document.cookie.substring( x, y ) == nameOfCookie ) {  
           if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )  
               endOfCookie = document.cookie.length;  
           return unescape( document.cookie.substring( y, endOfCookie ) );  
       }  
       x = document.cookie.indexOf( " ", x ) + 1;  
       if ( x == 0 )  
           break;  
   }  
   return "";  
}  
  
  
// 24시간 기준 쿠키 설정하기  
// expiredays 후의 클릭한 시간까지 쿠키 설정  
function setCookie( name, value, expiredays ) {   
   var todayDate = new Date();   
   todayDate.setDate( todayDate.getDate() + expiredays );   
   document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"   
}  

</script>


<div class="pop_wrap">
	<ul>
		<c:forEach items="${fn:split(detail.conts,'Œ')}" var="banner" varStatus="loop">
		<c:set var="items" value="${fn:split(banner,'Æ')}" />
		<li>
			<a href="${items[4]}" target="<c:if test="${items[9]=='1' || empty items[9]}">_blank</c:if><c:if test="${items[9]=='2'}">_self</c:if>" title="<c:if test="${items[9]=='1' || empty items[9]}">새창열림</c:if><c:if test="${items[9]=='2'}">현재창열림</c:if>"/>
				<img src="${uploadurl}${items[2]}" class="v_pc" alt="${items[3]}">
				<c:choose>
					<c:when test="${empty items[11] || items[11] eq 'null'}">
					<img src="${uploadurl}${items[2]}" class="v_mobile" alt="${items[3]}">
					</c:when>
					<c:otherwise><img src="${uploadurl}${items[11]}" class="v_mobile" alt="${items[3]}"></c:otherwise>
				</c:choose>
			</a>
		</li>
		</c:forEach>
		
	</ul>
	<div class="pop_btn"><a href="#none">오늘하루 그만보기</a></div>
</div>
</c:if>