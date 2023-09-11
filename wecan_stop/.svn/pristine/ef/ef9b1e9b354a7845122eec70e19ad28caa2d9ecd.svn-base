<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="subs" uri="/WEB-INF/tld/substringTag.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<p>공지사항<a href="/?menuno=257">더보기</a></p>
<c:forEach items="${list}" var="each">
	<dl>
		<dt><a href="/?menuno=257&noticeNo=${each.archv_no}"><subs:substringOut str='${each.title}' length='80' /></a></dt>
		<dd>
			<fmt:parseDate value="${each.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
			<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
		</dd>
	</dl>
</c:forEach>