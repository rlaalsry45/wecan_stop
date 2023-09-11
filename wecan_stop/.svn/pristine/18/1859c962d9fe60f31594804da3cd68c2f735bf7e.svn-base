<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<% pageContext.setAttribute("newLineChar", "\r\n"); %>
<link rel="stylesheet" href="/usr/css/20140704_3090680450533111.css" type="text/css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/usr/js/20140704_3090836397829049.js"></script>
<script type="text/javascript" src="/usr/js/20150127_416502415196508.js"></script>
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<script src='/usr/js/events/submit_valid_check.js'></script>

<c:if test="${sessionScope.zUserVo.work_grade eq '7' || sessionScope.zUserVo.work_grade eq '8' }">
<script type="text/javascript">
	alert('행사에 접근하실 수 없는 등급입니다. 관리자에게 문의하세요.');
	history.go(-1);
</script>
</c:if>
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

history.navigationMode = 'compatible'; // 오페라, 사파리 뒤로가기 막기
function _no_Back(){window.history.forward(0);}
</script>
<style type="text/css">
.normal_txt {height:35px;line-height:35px;}
h3.ctit {font-size:20px;line-height:20px;}
</style>
<body onload="_no_Back();" onpageshow="if(event.persisted)_no_Back();">
</body>
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
				<tr>
					<td colspan="2" style="word-break:break-all;border-left:none;">
						<p style="line-height:22px;">
						${fn:replace(eventsInfo.evContents, newLineChar, '<br/>')}
						</p>
					</td>
				</tr>
			</tbody>
		</table>

	<h3 class="ctit">참가 신청</h3>
		<form:form id="write" name="events" action="/events/submit.html"  method="post" enctype="multipart/form-data" onSubmit="return write_submit(this);">
		<input type="hidden" id="enEvIdx" name="enEvIdx" value="${entryInfo.enEvIdx}">
		<input type="hidden" id="enSubmitNo" name="enSubmitNo" value="${entryInfo.enSubmitNo}">
		<input type="hidden" id="action" name="action" value="${action}">
		<input type="hidden" id="enUserEmail" name="enUserEmail" value="${entryInfo.enUserEmail}">
		<input type="hidden" id="enUserPhone" name="enUserPhone" value="${entryInfo.enUserPhone}">
		<input type="hidden" id="enUserMobile" name="enUserMobile" value="${entryInfo.enUserMobile}">
		<input type="hidden" id="enUserZipCode" name="enUserZipCode" value="${entryInfo.enUserZipCode}">

		<table class="board-write mgtype50" summary="접수번호, 성명, 생년월일, 회사(학교)명, 부서(학과)명, 직위(급), E-mail, 전화번호, 휴대전화, 주소">
			<caption>참가 신청</caption>
			<colgroup>
				<col style="width:20%;" />
				<col />
			</colgroup>
			<tbody>
				<%-- <tr>
					<th scope="row">접수번호</th>
					<td class="normal_txt">${entryInfo.enSubmitNo}</td>
				</tr> --%>
				<tr>
					<th scope="row"><label for="enUserName">성명</label></th>
					<td>
						<input type="text" class="text" id="enUserName" name="enUserName" style="width:150px;" maxlength="20" value="${entryInfo.enUserName}" <c:if test="${entryInfo.enUserName ne null}">readonly="readonly"</c:if> />
						<c:if test="${action eq 'guest'}">
						<div style="color:red">*비회원의 경우 이름으로 신청확인이 가능하므로 정확하게 입력하십시오.</div>
						</c:if>
					</td>
				</tr>
			<c:if test="${action eq 'guest'}">
				<tr>
					<th scope="row"><label for="enUserPasswd">비밀번호</label></th>
					<td>
						<input type="text" class="text" id="enUserPasswd" name="enUserPasswd" style="width:150px;" maxlength="20" value="${entryInfo.enUserPasswd}" />
						*4자리이상
						<div style="color:red">*비회원의 경우 비밀번호로 신청확인이 가능하므로 정확하게 입력하십시오.</div>
					</td>
				</tr>
			</c:if>
				<tr>
					<th scope="row"><label for="enUserBirthDate">생년월일</label></th>
					<td><input type="text" class="text date-pick" id="enUserBirthDate" name="enUserBirthDate" style="width:100px;"  maxlength="10" value="${entryInfo.enUserBirthDate}"/></td>
				</tr>
				<tr>
					<th scope="row"><label for="enUserOrg">회사(학교)명</label></th>
					<td><input type="text" class="text" id="enUserOrg" name="enUserOrg" style="width:300px;"  maxlength="50" value="${entryInfo.enUserOrg}" /></td>
				</tr>
				<tr>
					<th scope="row"><label for="enUserDept">부서(학과)명</label></th>
					<td><input type="text" class="text" id="enUserDept" name="enUserDept" style="width:300px;"  maxlength="50" value="${entryInfo.enUserDept}" /></td>
				</tr>
				<tr>
					<th scope="row"><label for="enUserJob">직위(급)</label></th>
					<td><input type="text" class="text" id="enUserJob" name="enUserJob" style="width:150px;" maxlength="50" value="${entryInfo.enUserJob}" /></td>
				</tr>
				<tr>
					<th scope="row"><label for="email1">E-mail</label></th>
					<td>
					<input type="text" class="text"  id="email1" name="email1" style="width:150px;"  maxlength="25" value="${email1}" onkeyup="return check_email(this);" /> @
					<input type="text" class="text"  id="email2" name="email2" title="이메일 주소 입력" style="width:103px;" value="${email2}" />
					<select style="height:24px;" onchange="changeEmail(this);" name="email2">
						<option value="">직접입력</option>
						<c:forEach items="${emailList}" var="email">
							<option value="${email.code}" <c:if test="${email.code eq email2}">selected</c:if>>${email.code}</option>
						</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="phone1">전화번호</label></th>
					<td>
						<input type="text" class="text" id="phone1" title="지역번호 입력" style="width:64px;" name="phone1" class="number" maxlength="3" value="${phone1}"  />
						-
						<input type="text" class="text" id="phone2" title="중간 네자리번호 입력" style="width:64px;" name="phone2" class="number" maxlength="4" value="${phone2}"  />
						-
						<input type="text" class="text" id="phone3" title="마지막 네자리번호 입력" style="width:64px;" name="phone3" class="number" maxlength="4" value="${phone3}"  />
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="mobile1">휴대전화</label></th>
					<td>
						<input type="text" class="text" id="mobile1" title="지역번호 입력" style="width:64px;"  name="mobile1" class="number" maxlength="3" value="${mobile1}"  />
						-
						<input type="text" class="text" id="mobile2" title="중간 네자리번호 입력" style="width:64px;"  name="mobile2" class="number" maxlength="4" value="${mobile2}"  />
						-
						<input type="text" class="text" id="mobile3" title="마지막 네자리번호 입력" style="width:64px;"  name="mobile3" class="number" maxlength="4" value="${mobile3}"  />
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="postcode1">주소</label></th>
					<td>
						<input type="text" class="text"  name="postcode1" id="pa_useraddrno1" style="width:64px;" value="${entryInfo.enUserZipCode}"  /><%--  -
						<input type="text" class="text" name="postcode2" id="pa_useraddrno2" style="width:64px;" maxlength="3" value="${postcode2}"  />	 --%>
						<a href="javascript:postsearch('pa_');" id="postsearch"><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호찾기" /></a>
						<input type="text" class="text block" name="enUserAddr" id="pa_useraddr" style="width:400px;" maxlength="100" value="${entryInfo.enUserAddr}"  />
						<input type="text" class="text block" name="enUserAddrDetail" id="pa_useraddr2"  style="width:400px;" maxlength="100" value="${entryInfo.enUserAddrDetail}"   />
					</td>
				</tr>
				<!-- <tr>
					<th scope="row"><label for="isGeneral">발표자 여부</label></th>
					<td>
						<input type="radio" id="isGeneral" name="enUserIsPanel" value="1" /><label for="isGeneral">일반참가자</label>
						<input type="radio" id="isPanel" name="enUserIsPanel" value="2" /><label for="isPanel">발표자</label>
					</td>
				</tr>
				<tr>
					<th scope="row" class="bgnone"><label for="haveLunch">중식/만찬</label></th>
					<td>
						<input type="checkbox" id="haveLunch" name="enUserHaveLunch" value="1" /><label for="haveLunch">중식</label>
						<input type="checkbox" id="haveDinner" name="enUserHaveDinner" value="1" /><label for="haveDinner">만찬</label>
					</td>
				</tr> -->
				<tr>
					<th scope="row"><label for="haveLunch">참가비선택</label></th>
					<td>
						<c:forEach var="each" items="${eventFeeInfo}">
							<input name="enFeeIdx" id="enFeeIdx" type="checkbox" value="${each.efIdx }">${each.efTitle} : <fmt:formatNumber value='${each.efChargeSum}' pattern="#,###" type="currency" />원 &nbsp;&nbsp;
						</c:forEach>
						<c:if test="${entryInfo.enEvIdx eq '341'}">
							<font color="red">(입금처 : 한국씨티은행 186-01168-240-01 대한국토·도시계획학회)</font><br>
							<font color="blue">*예약금 납부 7/30(월)까지 (30만 원)<br>*경비 완납 8/10(월)까지 (79만 원)</font>
						</c:if>
						<!-- <font color="red">외환은행 630-008349-241 (예금주 : (주)제이티씨)</font> -->
					</td>
				</tr>
				<c:if test="${eventsInfo.evCategory eq '기타'}">
				<tr>
					<th scope="row"><label for="haveLunch">첨부파일</label></th>
					<td>
						<input type="file" id="epAttFileName" name="epAttFileName" onchange="return check_ext(this);"  /><!--  (여권사본 50MB이하) --><br>
						<c:if test="${entryInfo.enEvIdx eq '341'}">
						<font color="red">** 신청 시 여권 사본을 첨부하여 주시기 바랍니다<br>
						** 여권유효기간은 출발일 기준 6개월 이상 남아있어야 합니다 (2016.2.28 이후 까지)</font>
						</c:if>
						<c:if test="${entryInfo.enEvIdx eq '381'}">
							<font color="red">장애인, 차상위계층, 기초생활수급자, 한부모가정, 다문화가정 등은 무료(증빙자료를 참가신청시 스캔파일 첨부)</font>
						</c:if>
					</td>
				</tr>
				</c:if>
				<c:if test="${eventsInfo.evCategory eq '관광'}">
				<tr>
					<th scope="row"><label for="haveLunch">첨부파일</label></th>
					<td>
						<input type="file" id="epAttFileName" name="epAttFileName" onchange="return check_ext(this);"  /><font color="red">(신청서 50MB이하)</font><br>
						<input type="file" id="epAttFileName2" name="epAttFileName2" onchange="return check_ext(this);"  /><font color="red">(여권사본 50MB이하)</font><br>
					</td>
				</tr>
				</c:if>
			</tbody>
		</table>
		<div class="btn-c04">
			<input type="image" src="/usr/image/common/btn/btn_add.gif" alt="등록" class="btn_blue" />
			<a href="/events/info.html?ev_idx=${eventsInfo.evIdx}" class="btn_blue" style="vertical-align:top;">취소</a>
		</div>
	</form:form>
</div>

<%@ include file="/WEB-INF/jsp/template/tpl/7.jsp"%>
