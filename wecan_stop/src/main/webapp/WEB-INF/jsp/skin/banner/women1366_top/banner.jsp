<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="main_slide">
	<c:if test="${empty detail.conts}"></c:if>
	<c:if test="${not empty detail.conts}">
	<c:forEach items="${fn:split(detail.conts,'Œ')}" var="banner" varStatus="loop">
	<c:set var="items" value="${fn:split(banner,'Æ')}" />
	<div>
		<a href="${items[4]}" target="<c:if test="${items[9]=='1' || empty items[9]}">_blank</c:if><c:if test="${items[9]=='2'}">_self</c:if>" title="<c:if test="${items[9]=='1' || empty items[9]}">새창열림</c:if><c:if test="${items[9]=='2'}">현재창열림</c:if>"/>
        <img src="${uploadurl}${items[2]}" alt="${items[3]}">
        </a>
    </div>
	</c:forEach>
	</c:if>
</div>
