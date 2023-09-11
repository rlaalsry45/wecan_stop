<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>


<section id="contents_main" class="clearfix">
	<div class="event_wrap_in">
		<div class="center slider">
			
			<c:if test="${empty detail.conts}"></c:if>
			<c:if test="${not empty detail.conts}">
			<c:forEach items="${fn:split(detail.conts,'Œ')}" var="banner" varStatus="loop">
			<c:set var="items" value="${fn:split(banner,'Æ')}" />
		
			<div class="g_box">
				<div class="g_box_in">
					
					<a href="${items[4]}" target="<c:if test="${items[9]=='1' || empty items[9]}">_blank</c:if><c:if test="${items[9]=='2'}">_self</c:if>" title="<c:if test="${items[9]=='1' || empty items[9]}">새창열림</c:if><c:if test="${items[9]=='2'}">현재창열림</c:if>"/>
						<img src="${uploadurl}${items[2]}" class="pc" alt="${items[3]}">
						
						<c:choose>
							<c:when test="${empty items[11] || items[11] eq 'null'}">
							<img src="${uploadurl}${items[2]}" class="mobile" alt="${items[3]}">
							</c:when>
							<c:otherwise><img src="${uploadurl}${items[11]}" class="mobile" alt="${items[3]}"></c:otherwise>
						</c:choose>
						
					</a>
				</div>
			</div>
			</c:forEach>
				</c:if>
		</div>
		<div class="controller">
			<span class="pagingInfo"></span>
			<button class="Pause">control</button>
		</div>
	</div>
</section>


