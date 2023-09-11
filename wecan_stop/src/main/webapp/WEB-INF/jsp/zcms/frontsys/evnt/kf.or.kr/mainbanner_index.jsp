<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<div class="report">
	<h3>
		<img alt="KF 사업 활동 보고" src="/usr/image/common/title/mtit_report.gif" />
	</h3>
	<c:forEach items="${list}" var="each" varStatus="loop">
		<c:if test="${loop.index==0}"><div class="box on"></c:if>
		<c:if test="${loop.index!=0}"><div class="box"></c:if>
			<span class="img"><img width="114" height="87"
                                   src="${image_path_thbnail}/${each.thbnail}" onError="this.src='${image_path_thbnail}/noimg.gif'" alt="${each.evnt_title}" /></span>
			<a href="http://www.kf.or.kr/?menuno=79&type=view&evnt_no=${each.evnt_no}">
				<strong>${each.evnt_title}</strong>
				<span>${each.evnt_sumup}</span>
			</a>
		</div>
	</c:forEach>

	<ul>
		<c:forEach items="${list}" var="each" varStatus="loop">
			<c:if test="${loop.index==0}"><li><a href="#"><img alt="${each.evnt_title}" src="/usr/image/common/icon/icon_rolling_on.gif" /></a></li></c:if>
			<c:if test="${loop.index!=0}"><li><a href="#"><img alt="${each.evnt_title}" src="/usr/image/common/icon/icon_rolling_off.gif" /></a></li></c:if>
		</c:forEach>

	</ul>
	<span class="prev-next"><a href="#"><img alt="전페이지로"
			src="/usr/image/common/btn/btn_prev.gif" /></a><a href="#"><img alt="정지"
			src="/usr/image/common/btn/btn_stop.gif" /></a><a href="#"><img
			alt="다음페이지로" src="/usr/image/common/btn/btn_next.gif" /></a></span>
</div>
