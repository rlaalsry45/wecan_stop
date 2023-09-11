<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<div class="tag">
	<strong><img src="/usr/image/common/icon/icon_tag.png" alt="TAG" /></strong>
	<c:forEach items="${frontStatisList }" var="each" varStatus="loop">
		<c:if test="${loop.count < 6 }">
		<c:set value="${each.STATIS }" var="statis"></c:set>
		<%
			String keyword = URLEncoder.encode(pageContext.getAttribute("statis").toString(), "UTF-8");
		%>

		<a href="/?menuno=2092&keyword=<%=keyword%>&sort=d"><c:out value="${each.STATIS }" /></a>
		<%-- <c:if test="${status.count ne  fn:length(frontStatisList)}"> / </c:if> --%>
		<c:if test="${loop.count < 5}"> / </c:if>
		</c:if>
	</c:forEach>
</div>