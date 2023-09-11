<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>

<ul>
<c:forEach items="${list}" var="each" varStatus="loop">
<li><a href="<c:if test="${!empty subname}">/${subname}</c:if>${each.url}">
<strong>${each.bbstitle}</strong>

<c:choose>
	<c:when test="${tblname eq 'zboardcommon108' }">
	
		<c:if test="${each.bbsclose eq '1' }"><em>종료</em></c:if>
		<c:if test="${each.bbsclose eq '0' }">
			<c:choose>
				<c:when test="${each.appYN eq '-1' }"><em>종료</em></c:when>
				<c:otherwise><em class="on">진행중</em></c:otherwise>
			</c:choose>
		</c:if>
		
	</c:when>
	<c:otherwise>
		<span>
		<fmt:parseDate value="${fn:substring(each.bbsdatereg, 0, 8)}" pattern="yyyyMMdd" var="bbsdatereg_fmt" />
		<fmt:formatDate value="${bbsdatereg_fmt}" type="date" pattern="${datetype}"/>
		</span>	
	</c:otherwise>
</c:choose>




</a>
</li>


</c:forEach>

<c:if test="${empty list }"><li><a href="#none">등록된 게시물이 없습니다.</a></li>
</c:if>
</ul>
<a class="notice_more" href="${input.more_menuno }">바로가기</a>