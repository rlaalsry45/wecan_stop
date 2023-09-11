<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<ul class="new_gallery clear">
<c:forEach items="${list}" var="each" varStatus="loop">
	<li>
		<p class="nl_img new">
			<c:if test="${each.place ne null}"><c:set var="imgUrl" value="/usr/upload/board_thumb/${tblname}/${each.place}"/></c:if>
			<c:if test="${each.imgurl ne null}"><c:set var="imgUrl" value="${each.imgurl}"/></c:if>
			<img src="${imgUrl}" onError="this.src='/usr/upload/board/noimg.gif'" alt="${each.bbstitle} 관련 이미지" />
		</p>
		<a href="<c:if test="${!empty subname}">/${subname}</c:if>${each.url}">
			<p class="nl_tit"><subs:substringOut str="${each.bbstitle}" length="${maxlength}" endChar='...'/></p>
		</a>
		<span class="date"><fmt:parseDate value="${fn:substring(each.bbsdatereg, 0, 8)}" pattern="yyyyMMdd" var="bbsdatereg_fmt" /><fmt:formatDate value="${bbsdatereg_fmt}" type="date" pattern="${datetype}"/></span>
	</li>
</c:forEach>
</ul>
<span class="more02"><a href="${input.more_menuno}">더보기</a></span>