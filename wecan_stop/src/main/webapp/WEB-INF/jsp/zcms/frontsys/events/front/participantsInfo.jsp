<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<% pageContext.setAttribute("newLineChar", "\r\n"); %>
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
<script type="text/javascript" src="/usr/js/events/payment.js"></script>
<style type="text/css">
.normal_txt {height:35px;line-height:35px;}
h3.ctit {font-size:20px;line-height:20px;}
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

<form:form id="payinfoUpdate" name="entries" method="post" action="/events/payinfoUpdate.html">
	<input type="hidden" id="en_idx" name="en_idx" value="${entriesInfo.enIdx}">
	<input type="hidden" id="enEvIdx" name="enEvIdx" value="${entriesInfo.enEvIdx}">
	<input type="hidden" id="enUserOrderNo" name="enUserOrderNo">
	<input type="hidden" id="enPaymentSum" name="enPaymentSum" value="">
	<input type="hidden" id="enPaymentMethod" name="enPaymentMethod" value="">
	<input type="hidden" id="enCondition" name="enCondition" value="1">
</form:form>
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
				<td class="normal_txt">
					${eventsInfo.evTitle}
					<span style="display:none;" id="evTitle">${eventsInfo.evTitle}</span>
				</td>
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
			<tr>
				<td colspan="2" style="word-break:break-all;border-left:none;">
					<p style="line-height:22px;">
					${fn:replace(eventsInfo.evContents, newLineChar, '<br/>')}
					</p>
				</td>
			</tr>
		</tbody>
	</table>
	<h3 class="ctit">참가 신청 내역</h3>
	<table class="board-write mgtype50" summary="접수번호, 성명, 생년월일, 회사(학교)명, 부서(학과)명, 직위(급), E-mail, 전화번호, 휴대전화, 주소">
		<caption>참가 신청</caption>
		<colgroup>
			<col style="width:20%;" />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<th scope="row">접수번호</th>
				<td class="normal_txt">${entriesInfo.enSubmitNo}</td>
			</tr>
			<tr>
				<th scope="row" class="bgnone"><label for="enUserName">성명</label></th>
				<td>${entriesInfo.enUserName}</td>
			</tr>
			<tr>
				<th scope="row" class="bgnone"><label for="enUserBirthDate">생년월일</label></th>
				<td>${entriesInfo.enUserBirthDate}</td>
			</tr>
			<tr>
				<th scope="row" class="bgnone"><label for="enUserOrg">회사(학교)명</label></th>
				<td>${entriesInfo.enUserOrg}</td>
			</tr>
			<tr>
				<th scope="row" class="bgnone"><label for="enUserDept">부서(학과)명</label></th>
				<td>${entriesInfo.enUserDept}</td>
			</tr>
			<tr>
				<th scope="row" class="bgnone"><label for="enUserJob">직위(급)</label></th>
				<td>${entriesInfo.enUserJob}</td>
			</tr>
			<tr>
				<th scope="row" class="bgnone"><label for="email1">E-mail</label></th>
				<td>${entriesInfo.enUserEmail}</td>
			</tr>
			<tr>
				<th scope="row" class="bgnone"><label for="phone1">전화번호</label></th>
				<td>${entriesInfo.enUserPhone}</td>
			</tr>
			<tr>
				<th scope="row" class="bgnone"><label for="mobile1">휴대전화</label></th>
				<td>${entriesInfo.enUserMobile}</td>
			</tr>
			<tr>
				<th scope="row" class="bgnone"><label for="postcode1">주소</label></th>
				<td>(${entriesInfo.enUserZipCode}) ${entriesInfo.enUserAddr} ${entriesInfo.enUserAddrDetail}</td>
			</tr>
			<%-- <tr>
				<th scope="row" class="bgnone"><label for="isGeneral">발표자 여부</label></th>
				<td>${panelMap[entriesInfo.enUserIsPanel]}</td>
			</tr> --%>
			<tr>
				<th scope="row" class="bgnone"><label for="isGeneral">참가비</label></th>
				<td style="color:red">
					<c:set var="feeIdx" value="${fn:split(entriesInfo.enFeeIdx,  ',')}" />
					<c:forEach var="each" items="${eventFeeInfo}" varStatus="loop">
						<c:forEach var="idx" items="${feeIdx}" >
							<c:if test="${each.efIdx eq idx}">
								*${each.efTitle} : <fmt:formatNumber value='${each.efChargeSum}' pattern="#,###" type="currency" />원
								<input type="hidden" name="eFee" id="eFee${loop.count}" value="${each.efChargeSum}"/>
								<input type="hidden" name="eTitle " id="eTitle${loop.count}" value="${each.efTitle}"/>
								<c:if test="${loop.count ne  fn:length(eventFeeInfo)}"><br></c:if>
							</c:if>
						</c:forEach>
						<%-- <input name="eventFee" id="eventFee" type="radio" onchange="changeFee('${data.efChargeSum}', '${data.efTitle}')">${data.efTitle} : ${data.efChargeSum}원 --%>
					</c:forEach>
					<!-- (입금처 : 한국씨티은행 186-01168-240-01 대한국토·도시계획학회)<br>
					<font color="blue">*예약금 납부 7/30(월)까지 (30만 원)<br>*경비 완납 8/10(월)까지 (79만 원)</font> -->
					<!-- <font color="red">외환은행 630-008349-241 (예금주 : (주)제이티씨)</font> -->
					<input type="hidden" name="eventFee" id="eventFee"/>
					<input type="hidden" name="feeTitle" id="feeTitle"/>
					<script type="text/javascript">
					 	var cnt = $("input[name=eFee]").length

					 	var start = "1";
					 	var end = cnt;

					 	if(cnt == 1){
					 		if(!$("#eFee1").length){
					 			start = 2;
					 			end =2;
					 		}
					 	}

					 	var fee = 0;
					 	var search = "";

					 	for (var i = start; i <= end; i++) {
					 		fee +=  Number($("#eFee"+i).val());
					 		search +=  $("#eTitle"+i).val();
					 		if(i != end) search += ",";

						}
					 	$("#eventFee").val(fee);
					 	$("#feeTitle").val(search);
					</script>
				</td>
			</tr>
			<%-- <tr>
				<th scope="row" class="bgnone"><label for="haveLunch">중식/만찬</label></th>
				<td>
					<c:if test="${entriesInfo.enUserHaveLunch eq '1' }">중식 선택</c:if> /
					<c:if test="${entriesInfo.enUserHaveDinner eq '1' }">만찬 선택</c:if>
				</td>
			</tr> --%>
			<c:if test="${eventsInfo.evCategory eq '기타'}">
				<tr>
					<th scope="row" class="bgnone">첨부파일</th>
					<td>

					<form name="chagneFileFrm" id="chagneFileFrm" method="post" enctype="multipart/form-data">

					<c:forEach items="${papersList}" var="each" varStatus="loop">
						${each.epAttRealName} <br>
						<c:set var="epIdx" value="${each.epIdx }"/>
					</c:forEach>
					<input type="hidden" id="epIdx" name="epIdx"  value="${epIdx }"/>
					<input type="hidden" id="enIdx" name="enIdx" value="${entriesInfo.enIdx}"/>
					<input type="file" id="paperFile" name="paperFile" />
					<a href="javascript:chagePaper();" class="gray">수정/등록</a>
					</form>

					<c:if test="${fn:length(papersList) eq 0}">첨부파일이 없습니다</c:if></br>
					<!-- <font color="red">** 신청 시 여권 사본을 첨부하여 주시기 바랍니다<br>
						** 여권유효기간은 출발일 기준 6개월 이상 남아있어야 합니다 (2016.2.28 이후 까지)</font>
					</td> -->
					<c:if test="${entriesInfo.enEvIdx eq '381'}">
						<font color="red">장애인, 차상위계층, 기초생활수급자, 한부모가정, 다문화가정 등은 무료(증빙자료를 참가신청시 스캔파일 첨부)</font>
					</c:if>
				</tr>
			</c:if>
			<c:if test="${eventsInfo.evCategory eq '관광'}">
				<tr>
					<th scope="row" class="bgnone">첨부파일</th>
					<td>

					<form name="chagneFileFrm" id="chagneFileFrm" method="post" enctype="multipart/form-data">

					<c:forEach items="${papersList}" var="data" varStatus="loop">
						${each.epAttRealName} <br>
						<c:set var="epIdx" value="${each.epIdx }"/>
					</c:forEach>
					<%-- <input type="hidden" id="epIdx" name="epIdx"  value="${epIdx }"/>
					<input type="hidden" id="enIdx" name="enIdx" value="${entriesInfo.enIdx}"/>
					<input type="file" id="paperFile" name="paperFile" />
					<a href="javascript:chagePaper();" class="gray">수정/등록</a> --%>
					</form>
				</tr>
			</c:if>
			<c:if test="${entriesInfo.enCondition ne '0'}">
				<tr>
					<th scope="row" class="bgnone"><label for="haveLunch">상태</label></th>
					<td>${statMap[entriesInfo.enCondition]}</td>
				</tr>
				<tr>
					<th scope="row" class="bgnone"><label for="haveLunch">결제방법</label></th>
					<td>${entriesInfo.enPaymentMethod}</td>
				</tr>
				<tr>
					<th scope="row" class="bgnone"><label for="haveLunch">결제금액</label></th>
					<td>${entriesInfo.enPaymentSum}</td>
				</tr>
				<tr>
					<th scope="row" class="bgnone"><label for="haveLunch">결제일</label></th>
					<td>${entriesInfo.enPaymentDate}</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<div class="btn-c04">
<c:if test="${entriesInfo.enCondition eq '0'}">
	<!-- <form method="post" name="payment_form" action="/Allat/orderInsert.html" onsubmit="return check_payment(this);" id="payment_form"> -->
	<form method="post" name="payment_form" action="/Allat/orderInsert.html" onsubmit="return check_payment(this);" id="payment_form">
		<input type="hidden" id="oType" name="oType" value="EVN" />
		<input type="hidden" id="oAmt" name="oAmt" value="" /> <!-- 주문 금액 -->
		<input type="hidden" id="oProductCD" name="oProductCD" value="${entriesInfo.enSubmitNo}" /><!-- 상품코드 (각 테이블의 PK값) -->
		<input type="hidden" id="oProductNM" name="oProductNM" value="" /><!--  상품명(ex:2월정기회비,논문심사비,무슨학회 참가비) -->
		<input type="hidden" id="oMemberID" name="oMemberID" value="${entriesInfo.enUserNo}" /><!-- 회원id 없을시에는 guest -->
		<input type="hidden" id="oMemberNm" name="oMemberNm" value="${entriesInfo.enUserName}" /> <!-- 회원이름 -->
		<input type="hidden" id="oRecpNM" name="oRecpNM" value="${entriesInfo.enUserName}" /><!-- 수취자 성명(없을시 결제자와 동일하게 -->
		<input type="hidden" id="oRecpAddr" name="oRecpAddr" value="${entriesInfo.enUserAddr} ${entriesInfo.enUserAddrDetail}" /><!-- 수취자 주소(없을시 [-]) -->
		<input type="hidden" id="oMemberEmail" name="oMemberEmail" value="${entriesInfo.enUserEmail}" /><!-- 회원 email -->
		<input type="hidden" id="oResultSendYN" name="oResultSendYN" value="" /><!-- 결제 결과 발송 유무 Y:발송, N or Null:발송안함(차후 구현예정, 주문번호를 메일로 발송할 예정입니다) -->
</c:if>
		<a href="javascript:history.back();" class="btn_blue" style="vertical-align:top;">돌아가기</a>
<c:if test="${entriesInfo.enCondition eq '0'}">
		<!-- <input type="image" src="/usr/image/common/btn/btn_add.gif" alt="등록" /> -->


		<a href="#" class="btn_gray" onClick="check_payment(document.forms.payment_form);">결제하기</a>
	</form>
</c:if>
	</div>
</div>
<%@ include file="/WEB-INF/jsp/template/tpl/7.jsp"%>
