<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div id="popup">
	<c:if test="${not empty detail.conts}">
	<div class="play">	
		<ul class="btn_play">
			<li class="play"><a onclick="PreviousVisual(); return false;" href="#visual_stop"><img alt="이전팝업" src="/usr/images/new_main/pre.png"></a></li>
			<li class="play" id="ppause"><a onclick="StopVisual(); return false;" href="#visual_stop"><img alt="팝업멈춤" src="/usr/images/new_main/pause.png"></a></li>
			<li class="stop end" id="pplay" style="display:none;"><a onclick="StartVisual(); return false;" href="#visual_play"><img alt="팝업재생" src="/usr/images/new_main/play.png"></a></li>
			<li class="play"><a onclick="NextVisual(); return false;" href="#visual_stop"><img alt="다음팝업" src="/usr/images/new_main/next.png"></a></li>
		</ul>
	</div>
	<dl>
		<c:forEach items="${fn:split(detail.conts,'Œ')}" var="banner" varStatus="loop">
		<c:set var="items" value="${fn:split(banner,'Æ')}" />
		<dt class="visual_btn${loop.count} <c:if test="${loop.first==true}"> first</c:if><c:if test="${loop.last==true}"> end</c:if>">
			<a onfocus="forwardVisualDirect(${loop.count}); return false;" onblur="return false;" onclick="return false;" onmouseover="forwardVisualDirect(${loop.count}); return false;" onmouseout="StartVisual(); return false;" href="#none">
				<img alt="${loop.count} 번째 비주얼 보기" src="/usr/images/new_main/pop_on.png" id="vbtn${loop.count}">
			</a>
		</dt>
		<dd class="visual_con${loop.count} dipy_n" id="vnum${loop.count}">
			<a href="${items[4]}" target="<c:if test="${items[9]=='1' || empty items[9]}">_blank</c:if><c:if test="${items[9]=='2'}">_self</c:if>" title="<c:if test="${items[9]=='1' || empty items[9]}">새창열림</c:if><c:if test="${items[9]=='2'}">현재창열림</c:if>">
				<img src="${uploadurl}${items[2]}" alt="${items[3]}"/>
			</a>
		</dd>
		</c:forEach>
	</dl>
	</c:if>
</div>
<script>
window.onload = function(){
	vtotalSize = ${fn:length(fn:split(detail.conts,'Œ'))};
	if(vtotalSize > 1){
		StartVisual();
	}
}
</script>