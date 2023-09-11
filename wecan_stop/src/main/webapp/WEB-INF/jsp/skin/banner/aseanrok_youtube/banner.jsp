<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:if test="${empty detail.conts}"></c:if>
<c:if test="${not empty detail.conts}">
	<c:forEach items="${fn:split(detail.conts,'Œ')}" var="banner" varStatus="loop">
	<c:set var="items" value="${fn:split(banner,'Æ')}" />
	<div class="left_wrap">
		<div class="viedo_wrap">
			<span>
				<img src="${uploadurl}${items[2]}" alt="${items[3]}">
			</span>
			<a href="${items[4]}" target="<c:if test="${items[9]=='1' || empty items[9]}">_blank</c:if><c:if test="${items[9]=='2'}">_self</c:if>"  title="유투브로 이동"/>
				<strong>${items[3]}</strong>
				${items[6]}
			</a>
			<a class="more" href="?menuno=86"><spring:message code="text.readmore"/></a>
		</div>
	</div>
	</c:forEach>
</c:if>