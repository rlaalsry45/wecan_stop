<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<ul class="bxslider_main">
	<c:if test="${empty detail.conts}"></c:if>
	<c:if test="${not empty detail.conts}">
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
	</c:if>
</ul>

