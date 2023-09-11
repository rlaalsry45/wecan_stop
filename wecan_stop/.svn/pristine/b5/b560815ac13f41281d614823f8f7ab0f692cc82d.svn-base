<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<div class="board-view">
	<h4 class="btit">${evnt.evnt_title }</h4>
	<table class="board-view" summary="분류, 등록일">
		<caption>보기</caption>
		<colgroup>
			<col style="width:8%;" />
			<col style="width:22%;" />
			<col style="width:15%;" />
			<col style="width:35%;" />
			<col style="width:8%;" />
			<col style="width:12%;" />
		</colgroup>
		<tbody>
			<tr>
				<th scope="row"><span>Date</span></th>
				<td>${evnt.post_date}</td>
				<th scope="row"><span>Event period</span></th>
				<td>${evnt.start_date} ~ ${evnt.end_date}</td>
				<th scope="row"><span>Read </span></th>
				<td>${evnt.evnt_cnt}</td>
			</tr>
		</tbody>
	</table>
	${evnt.conts}
	<c:if test="${evnt.evnt_end_date_mod > evnt.currentdate }">
		<c:if test="${pageContext['request'].userPrincipal != null}">
			<div class="btn-c"><a href="javascript:cnjOpen('/evnt/evnt_popup.html?evnt_no=${evnt.evnt_no}&menuno=${menuno }','cnjopen',776,592)"><img src="/usr/image/common/btn/btn_app09.gif" alt="신청" /></a></div>
		</c:if>
		<c:if test="${pageContext['request'].userPrincipal == null}">
			<div class="btn-c"><a href="javascript:alert('For members. Log in please.');"><img src="/usr/image/common/btn/btn_app09.gif" alt="신청" /></a></div>
		</c:if>
	</c:if>
	<c:if test="${evnt.caution != null}">
		<p class="text"><strong>※ Attention</strong><br />${evnt.caution}</p>
	</c:if>
	<p class="text">
	<c:if test="${fn:length(filelist) != 0}"><strong>[File Download]</strong><br /></c:if>
	<c:forEach items="${filelist}" var="filename" varStatus="loop">
		<a href="/front/archv/downloadFile.html?filetype=D&filename=${filename.realname}">	- ${filename.name }</a><br />
	</c:forEach>
	</p>
</div>

<div class="c-sns">
	<a href="#"><img src="/usr/image/common/icon/icon_twitter03.gif" alt="트위터" /></a>
	<a href="#"><img src="/usr/image/common/icon/icon_facebook03.gif" alt="페이스북" /></a>
	<a href="#"><img src="/usr/image/common/icon/icon_wifi.gif" alt="RSS" /></a>
	<a href="#"><img src="/usr/image/common/icon/icon_print.gif" alt="프린트" /></a>
</div>
<div class="btn-c"><a href="/?menuno=${menuno}&pageIndex=${pageIndex}&searchevnt=${searchevnt}"><img src="/usr/image/common/btn/btn_list.gif" alt="목록" /></a></div>