<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<c:if test="${tabno == 1}">
	<li>
		<h3 id="tab1">
			<a href="#tab-cont1"><img src="/usr/image/main/tab01.gif" alt="정책결정" /></a>
		</h3>
		<ul id="tab-cont1">
			<c:forEach items="${list}" var="each" varStatus="loop">
				<li <c:if test="${loop.index ==0}"><c:out value='class="first"' /></c:if> >
					<a href="${each.url}"><c:out value="${each.bbstitle}" /></a>
					<c:set var="bbsdatereg_set" value="${each.bbsdatereg}"/>
					<fmt:parseDate value="${fn:substring(bbsdatereg_set, 0, 8)}" pattern="yyyyMMdd" var="bbsdatereg_fmt" />
					<span><fmt:formatDate value="${bbsdatereg_fmt}" type="date" pattern="yyyy-MM-dd"/></span>
				</li>
			</c:forEach>
		</ul> <!--<a href="#" class="more"><img src="/usr/image/common/btn/btn_more02.gif" alt="더보기" /></a>-->
	</li>
</c:if>
<c:if test="${tabno == 2}">
	<li>
		<h3 id="tab2">
			<a href="#tab-cont2"><img src="/usr/image/main/tab02.gif" alt="보도자료" /></a>
		</h3>
		<ul id="tab-cont2">
			<c:forEach items="${list}" var="data" varStatus="loop">
				<li <c:if test="${loop.index ==0}"><c:out value='class="first"' /></c:if> >
					<a href="${each.url}"><c:out value="${each.bbstitle}" /></a>
					<c:set var="bbsdatereg_set" value="${each.bbsdatereg}"/>
					<fmt:parseDate value="${fn:substring(bbsdatereg_set, 0, 8)}" pattern="yyyyMMdd" var="bbsdatereg_fmt" />
					<span><fmt:formatDate value="${bbsdatereg_fmt}" type="date" pattern="yyyy-MM-dd"/></span>
				</li>
			</c:forEach>
		</ul> <!--<a href="#" class="more"><img src="/usr/image/common/btn/btn_more02.gif" alt="더보기" /></a>-->
	</li>
</c:if>