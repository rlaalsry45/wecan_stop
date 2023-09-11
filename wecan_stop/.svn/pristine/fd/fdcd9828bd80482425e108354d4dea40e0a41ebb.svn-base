<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<% pageContext.setAttribute("newLineChar", "\r\n"); %>
<link rel="stylesheet" href="/usr/css/20140704_3090680450533111.css" type="text/css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/usr/js/20140704_3090836397829049.js"></script>
<script type="text/javascript" src="/usr/js/20150127_416502415196508.js"></script>
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<script src='/usr/js/conference/regform.js'></script>
<c:if test="${ising eq 'false' }">
<script type="text/javascript">
	alert("접수기간이 지났습니다.");
	history.go(-1);
</script>
</c:if>		
<c:if test="${isapply eq 'false' }">
<script type="text/javascript">
	alert("이미 신청하였습니다.");
	history.go(-1);
</script>
</c:if>		
<script type="text/javascript">
	$(function () {
		/* gnb */
		$("#gnb > li").eq(3).addClass("on");
	});
	var lnbnum=5;
	var lnbsubnum=1;
</script>
<%@ include file="/WEB-INF/jsp/template/tpl/8.jsp"%>
<div class='location'><img src='/usr/image/common/icon/icon_home.gif' alt='HOME' /> > 주요행사 > 학술행사 > ${eventsInfo.evTitle}</div>
<div class='sub-login'>
<c:if test="${username != '' &&  username != null}">
	<span class='member'><strong>${username}</strong> 님</span>
	<c:if test="${userid!= '' &&  userid != null && userid ne  'guest' }">
		<span class='info'><a href='/?menuno=2431'>My Page</a></span>
		<a href='/j_spring_security_logout' class='btn'><img src='/usr/image/common/btn/btn_logout02.gif' alt='로그아웃' /></a>
	</c:if>
</c:if>
</div>	
<%@ include file="/WEB-INF/jsp/template/tpl/8.jsp"%>

<div class="cont-right">
	<h3 class="ctit">${eventsInfo.evTitle}</h3>
		<form:form id="insert" name="conference" action="/conference/registration_insert.html"  method="post" enctype="multipart/form-data" onSubmit="return insert_submit(this);">
		<input type="hidden" id="fkconidx" name="fkconidx" value="${conferencePaper.fkconidx}">
		<input type="hidden" id="decode" name="decode" value="${conferencePaper.decode}">
		
		<table class="board-write mgtype50" summary="행사안내, 행사정보">
			<caption>행사 안내</caption>
			<colgroup>
				<col style="width:20%;" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">행사분류</th>
					<td>${eventsInfo.evCategory}</td>
				</tr>
				<tr>
					<th scope="row">게재일</th>
					<td>${eventsInfo.evOpenDate}</td>
				</tr>
				<tr>
					<th scope="row">행사기간</th>
					<td>${eventsInfo.evStartDate} ~ ${eventsInfo.evEndDate}</td>
				</tr>
				<tr>
					<th scope="row">사전 등록기간</th>
					<td>${eventsInfo.evRegisStartTime} ~ ${eventsInfo.evRegisEndTime}</td>
				</tr>
				<tr>
					<th scope="row">개최장소</th>
					<td>${eventsInfo.evOpenSite}</td>
				</tr>
				<c:if test="${not empty eventsInfo.evAttFileName}">
					<tr>
						<th scope="row">첨부파일</th>
						<td class="normal_txt"><a href="./entryMainDownload.html?evIdx=${eventsInfo.evIdx}">${eventsInfo.evAttRealName}</a></td>
					</tr>
				</c:if>
				<tr>
					<td colspan="2" style="word-break:break-all;border-left:none;">
						<p style="line-height:22px;">
						${fn:replace(eventsInfo.evContents, newLineChar, '<br/>')}
						</p>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="btn-c04">
			<a href="/events/submit.html?ev_idx=${eventsInfo.evIdx}" class="btn_blue">참가신청하기</a>
			<a href="/events/participants.html?ev_idx=${eventsInfo.evIdx}" class="btn_gray">신청 확인</a>
		</div>
	</form:form>
</div>
<%@ include file="/WEB-INF/jsp/template/tpl/7.jsp"%>