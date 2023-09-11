<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<ul class="new_list clear">
<c:forEach items="${list}" var="each" varStatus="loop">
	<li>
		<a href="<c:if test="${!empty subname}">/${subname}</c:if>${each.url}">
			<span class="tit"><subs:substringOut str="${each.bbstitle}" length="${maxlength}" endChar='...'/></span>
			<c:if test="${0==loop.index}">
			<span class="txt"><subs:substringOut str="${each.bbsconts}" length="160" endChar='...'/></span>
			</c:if>
		</a>
		<span class="date"><fmt:parseDate value="${fn:substring(each.bbsdatereg, 0, 8)}" pattern="yyyyMMdd" var="bbsdatereg_fmt" /><fmt:formatDate value="${bbsdatereg_fmt}" type="date" pattern="${datetype}"/></span>	
	</li>
</c:forEach>
</ul>
<span class="more02"><a href="${input.more_menuno }">더보기</a></span> 
