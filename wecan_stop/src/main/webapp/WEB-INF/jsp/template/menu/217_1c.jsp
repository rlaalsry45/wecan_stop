<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
	<div class="contents">
		<h2>설문조사</h2>
		<div class="greetings_wrap">
			
<c:set var="page" value="index"/>
<c:if test="${not empty param.page}"><c:set var="page" value="${param.page}"/></c:if>
<c:import charEncoding="utf-8" url="/survey/front/${page}.html"></c:import>

		</div>
	</div>
