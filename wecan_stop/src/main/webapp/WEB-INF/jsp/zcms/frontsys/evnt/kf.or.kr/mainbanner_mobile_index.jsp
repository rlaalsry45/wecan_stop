<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<c:forEach items="${list}" var="each" varStatus="loop">
	<c:if test="${loop.index==0 || loop.index==1}">
		<div class="activity">
			<a class="img" href="http://kf.or.kr/?menuno=79&type=view&evnt_no=${each.evnt_no}">
				<img width="107" height="86" src="${image_path_thbnail}/${each.thbnail}"
				onerror="this.src='${image_path_thbnail}/noimg.gif'" width="107" height="86" alt="${each.evnt_title}">
			</a>
			<div>
				<strong><a href="http://kf.or.kr/?menuno=79&type=view&evnt_no=${each.evnt_no}">${each.evnt_title}</a></strong>
				<p>${each.evnt_sumup}</p>
			</div>
		</div>
	</c:if>
</c:forEach>



