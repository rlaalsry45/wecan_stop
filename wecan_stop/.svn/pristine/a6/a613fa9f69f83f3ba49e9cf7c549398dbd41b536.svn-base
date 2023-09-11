<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<ul id="bannerList">
<c:if test="${not empty detail.conts}">
<c:forEach items="${fn:split(detail.conts,'Œ')}" var="banner" varStatus="loop">
<c:set var="items" value="${fn:split(banner,'Æ')}" />
	<li>
	<a href="${items[4]}" target="<c:if test="${items[9]=='1' || empty items[9]}">_blank</c:if><c:if test="${items[9]=='2'}">_self</c:if>" title="<c:if test="${items[9]=='1' || empty items[9]}">새창열림</c:if><c:if test="${items[9]=='2'}">현재창열림</c:if>">
		<img src="${uploadurl}${items[2]}" alt="${items[3]}"/>
	</a>
	</li>
</c:forEach>
</c:if>
</ul>
<span class="fb_left"><a href="#" class="prev" onclick="bn.direction=4; return false;">이전</a></span>
<span class="fb_stop"><a href="#" class="stop" onclick="bn_pause(); return false;">정지</a></span>
<span class="fb_start" style="display:none;"><a href="#" class="start" onclick="bn_start(); return false">시작</a></span>
<span class="fb_right"><a href="#" class="next" onclick="bn.direction=2; return false">다음</a></span>