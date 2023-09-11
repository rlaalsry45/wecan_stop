<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<link rel="stylesheet" href="/usr/css/20140704_3090680450533111.css" type="text/css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/usr/js/20140704_3090836397829049.js"></script>
<script type="text/javascript" src="/usr/js/20150127_416502415196508.js"></script>
<c:if test="${sessionScope.zUserVo.work_grade eq '7' || sessionScope.zUserVo.work_grade eq '8' }">
<script type="text/javascript">
	alert('행사에 접근하실 수 없는 등급입니다. 관리자에게 문의하세요.');
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
<style type="text/css">
.normal_txt {height:35px;line-height:35px;}
h3.ctit {font-size:20px;line-height:20px;}
a.btn-small6 {
	display:inline-block;
	background:#495a74;
	color:#fff;
	padding:0 15px;
	height:23px;
	line-height:23px;
	font-size:12px;
	font-family:NANUM;
	/*margin-left: 5px;*/
}
</style>

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
	<h3 class="ctit">행사 정보</h3>
	<table class="board-write mgtype50" summary="행사참가신청, 접수" style="margin-bottom:30px;">
		<caption>참가 신청</caption>
		<colgroup>
			<col style="width:20%;" />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<th scope="row">행 사 명</th>
				<td class="normal_txt">${eventsInfo.evTitle}</td>
			</tr>
			<tr>
				<th scope="row">행사기간</th>
				<td class="normal_txt">${eventsInfo.evStartDate} ~ ${eventsInfo.evEndDate}</td>
			</tr>
			<tr>
				<th scope="row">사전 등록기간</th>
				<td class="normal_txt">${eventsInfo.evRegisStartTime} ~ ${eventsInfo.evRegisEndTime}</td>
			</tr>
			<tr>
				<th scope="row">개최장소</th>
				<td class="normal_txt">${eventsInfo.evOpenSite}</td>
			</tr>
			<c:if test="${not empty eventsInfo.evAttFileName}">
				<tr>
					<th scope="row">첨부파일</th>
					<td class="normal_txt"><a href="./entryMainDownload.html?evIdx=${eventsInfo.evIdx}">${eventsInfo.evAttRealName}</a></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<h3 class="ctit">참가 신청 내역</h3><br>
	※ 행사참가비 납부 바랍니다.<br>
	• 사전접수기간중에 참가비를 납부하지 않으면 자동으로 참가 등록 신청이 취소됩니다.<br>
	•영수증은 이메일로 송부됩니다.(단, 행사참가비납부시에 "결제내역통보이메일"에 받으실 이메일 주소를 반드시 기재해 주시기 바랍니다.)
	<table class="board-list" summary="접수번호, 성명, 생년월일, 회사(학교)명, 부서(학과)명, 직위(급), E-mail, 전화번호, 휴대전화, 주소" style="margin-top:10px;">
		<caption>참가 신청 내역</caption>
		<colgroup>
			<col style="width:10%;" />
			<col style="width:10%;" />
			<col style="width:20%" />
			<col style="width:15%" />
			<!-- <col style="width:15%;" /> -->
			<col style="width:15%" />
			<col style="width:18%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">접수번호</th>
				<th scope="col">성명</th>
				<th scope="col">접수일</th>
				<th scope="col">결제금액</th>
				<!-- <th scope="col">결제수단</th> -->
				<th scope="col">상태</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${entriesList}" var="each" varStatus="loop">
			<tr>
				<td>
					<a href="/events/myinfo.html?en_idx=${each.enIdx}&action=${action}">${each.enSubmitNo}</a>
				</td>
				<td>${each.enUserName}</td>
				<td>${each.enSubmitTime}</td>
				<td><%-- ${data.enPaymentSum} --%>
					<c:set var="feeIdx" value="${fn:split(each.enFeeIdx,  ',')}" />
					<c:forEach var="data2" items="${eventFeeInfo}" varStatus="loop">
						<c:forEach var="idx" items="${feeIdx}" >
							<c:if test="${data2.efIdx eq idx}">
								${data2.efTitle} : <fmt:formatNumber value='${data2.efChargeSum}'  pattern="#,###" type="currency" />원
								<c:if test="${loop.count ne  fn:length(eventFeeInfo)}"><br></c:if>
							</c:if>
						</c:forEach>
						<%-- <input name="eventFee" id="eventFee" type="radio" onchange="changeFee('${data.efChargeSum}', '${data.efTitle}')">${data.efTitle} : ${data.efChargeSum}원 --%>
					</c:forEach>

				</td>
				<!-- <td>${each.enPaymentMethod}</td> -->
				<td>${statMap[each.enCondition]}</td>
				<td>
					<a href="/events/myinfo.html?en_idx=${each.enIdx}&action=${action}" class="btn-small6">상세정보 확인 <c:if test="${each.enCondition eq '0'}"> 및 결제</c:if></a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty entriesList}">
			<tr><td colspan="6" style="text-align:center;width:100%;">참가신청 내역이 없습니다.</td></tr>
		</c:if>
		</tbody>
	</table>
	<div class="btn-c04">
		<a href="/events/info.html?ev_idx=${eventsInfo.evIdx}" class="btn_blue">돌아가기</a>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/template/tpl/7.jsp"%>
