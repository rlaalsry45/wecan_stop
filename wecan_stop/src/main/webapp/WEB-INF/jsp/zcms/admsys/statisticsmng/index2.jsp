<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />
<div id="contents">
    <form:form modelAttribute="ZStatisticsMngVo" name="frm" method="post">
        <div class="contents_top">
            <div class="location">
                <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/statisticsmng/index.html">통계관리</a> <strong>상담통계</strong>
            </div>
        </div>
        <div id="content">
        	<ul class="homepagebbs">
	            <li>
					<div class="counsel_wrap">
						<div class="title_wrap">
							<h4 class="dot">상담통계</h4>
							<div class="btn_wrap">
								<a href="javascript:excelDownload();" class="btn">엑셀 다운로드</a>
							</div>
						</div>
						<div class="search_box">
							<table>
								<caption>상담통계 조회</caption>
								<colgroup>
									<col style="width:150px;">
									<col style="width:120px;">
									<col style="width:235px;">
									<col style="width:120px;">
									<col style="width:auto;">
								</colgroup>
								<tbody>
									<tr>
										<th>상담기간</th>
										<td colspan="4">
											<div class="input_box">
												<span class="input_radio">
													<input type="radio" name="range" id="daily" value="d">
													<label for="daily" class="on">일별</label>
												</span>
												<span class="input_radio">
													<input type="radio" name="range" id="monthly" value="m">
													<label for="monthly" class="on">월별</label>
												</span>
											</div>
											<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
											<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
											<div class="input_box">
												<input type="date" id="sdate" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" class="date" placeholder="년-월-일">
											</div>
											&nbsp;&nbsp;~&nbsp;&nbsp;
											<div class="input_box">
												<input type="date" id="edate" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" class="date" placeholder="년-월-일">
											</div>
										</td>
									</tr>
									<!-- <tr>
										<th>조회항목</th>
										<td colspan="4">
											<div class="input_box">
												<input type="checkbox" name="item" id="chk_item01" checked="checked">
												<label for="chk_item01" class="on">상담구분</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="item" id="chk_item02" checked="checked">
												<label for="chk_item02" class="on">의뢰유형</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="item" id="chk_item03" checked="checked">
												<label for="chk_item03" class="on">지속상담구분</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="item" id="chk_item04" checked="checked">
												<label for="chk_item04" class="on">조치결과</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="item" id="chk_item05" checked="checked">
												<label for="chk_item05" class="on">지역</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="item" id="chk_item06">
												<label for="chk_item06" class="on">의뢰인</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="item" id="chk_item07">
												<label for="chk_item07" class="on">피해자</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="item" id="chk_item08">
												<label for="chk_item08" class="on">가해자</label>
											</div>
										</td>
									</tr> -->
									<tr>
										<th>분류</th>
										<td colspan="4">
											<div class="input_box">
												<input type="checkbox" name="consultingTypeCbx" id="chk_counsel_type01" value="public">
												<label for="chk_counsel_type01" class="on">공공부문</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="consultingTypeCbx" id="chk_counsel_type02" value="civil">
												<label for="chk_counsel_type02" class="on">민간부문</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="consultingTypeCbx" id="chk_counsel_type03" value="personal">
												<label for="chk_counsel_type03" class="on">개인간</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="consultingTypeCbx" id="chk_counsel_type04" value="etc">
												<label for="chk_counsel_type04" class="on">기타/미파악</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>경로</th>
										<td colspan="4">
											<div class="input_box">
												<input type="checkbox" name="receivedTypeCbx" id="chk_received_type01" value="tel">
												<label for="chk_received_type01" class="on">전화</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="receivedTypeCbx" id="chk_received_type02" value="mail">
												<label for="chk_received_type02" class="on">우편</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="receivedTypeCbx" id="chk_received_type03" value="visit">
												<label for="chk_received_type03" class="on">내방</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="receivedTypeCbx" id="chk_received_type04" value="move">
												<label for="chk_received_type04" class="on">이관</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>내용</th>
										<td colspan="4">
											<div class="input_box">
												<input type="checkbox" name="consultingReqTypeCbx" id="chk_consulting_req_type01" value="relaccident">
												<label for="chk_consulting_req_type01" class="on">사건관련</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="consultingReqTypeCbx" id="chk_consulting_req_type02" value="simple">
												<label for="chk_consulting_req_type02" class="on">단순문의</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="consultingReqTypeCbx" id="chk_consulting_req_type03" value="etc">
												<label for="chk_consulting_req_type03" class="on">기타</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>유입경로</th>
										<td colspan="4">
											<div class="input_box">
												<input type="checkbox" name="contactMethodTypeCbx" id="chk_contact_method_type01" value="internet">
												<label for="chk_contact_method_type01" class="on">인터넷 검색</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="contactMethodTypeCbx" id="chk_contact_method_type02" value="support">
												<label for="chk_contact_method_type02" class="on">피해자 지원기관 등</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="contactMethodTypeCbx" id="chk_contact_method_type03" value="gov">
												<label for="chk_contact_method_type03" class="on">여성가족부</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="contactMethodTypeCbx" id="chk_contact_method_type04" value="etc">
												<label for="chk_contact_method_type04" class="on">기타</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="contactMethodTypeCbx" id="chk_contact_method_type05" value="unknown">
												<label for="chk_contact_method_type05" class="on">미파악</label>
											</div>
										</td>
									</tr>
									<tr>
										<th rowspan="2">의뢰인</th>
										<th>성별</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="clientGenderCbx" id="chk_client_gender01" value="female">
												<label for="chk_client_gender01" class="on">여성</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="clientGenderCbx" id="chk_client_gender02" value="male">
												<label for="chk_client_gender02" class="on">남성</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="clientGenderCbx" id="chk_client_gender03" value="unknown">
												<label for="chk_client_gender03" class="on">미상</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>피해자와의 관계</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="clientVictimRelTypeCbx" id="chk_client_victim_rel_type01" value="me">
												<label for="chk_client_victim_rel_type01" class="on">본인</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="clientVictimRelTypeCbx" id="chk_client_victim_rel_type02" value="agent">
												<label for="chk_client_victim_rel_type02" class="on">대리인/조력자</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="clientVictimRelTypeCbx" id="chk_client_victim_rel_type03" value="relmanager">
												<label for="chk_client_victim_rel_type03" class="on">관련 담당자</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="clientVictimRelTypeCbx" id="chk_client_victim_rel_type04" value="doer">
												<label for="chk_client_victim_rel_type04" class="on">행위자등</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="clientVictimRelTypeCbx" id="chk_client_victim_rel_type05" value="etc">
												<label for="chk_client_victim_rel_type05" class="on">기타</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>피해자</th>
										<th>성별</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="victimGenderTypeCbx" id="chk_victim_gender01" value="female">
												<label for="chk_victim_gender01" class="on">여성</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="victimGenderTypeCbx" id="chk_victim_gender02" value="male">
												<label for="chk_victim_gender02" class="on">남성</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="victimGenderTypeCbx" id="chk_victim_gender03" value="unknown">
												<label for="chk_victim_gender03" class="on">미상</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="victimGenderTypeCbx" id="chk_victim_gender04" value="none">
												<label for="chk_victim_gender04" class="on">해당사항없음</label>
											</div>
										</td>
									</tr>
									<tr>
										<th rowspan="2">행위자</th>
										<th>성별</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="offenderGenderTypeCbx" id="chk_offender_gender01" value="female">
												<label for="chk_offender_gender01" class="on">여성</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="offenderGenderTypeCbx" id="chk_offender_gender02" value="male">
												<label for="chk_offender_gender02" class="on">남성</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="offenderGenderTypeCbx" id="chk_offender_gender03" value="unknown">
												<label for="chk_offender_gender03" class="on">미상</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="offenderGenderTypeCbx" id="chk_offender_gender04" value="none">
												<label for="chk_offender_gender04" class="on">해당사항없음</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>피해자와의 관계</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="offenderVictimRelTypeCbx" id="chk_offender_victim_rel_type01" value="boss">
												<label for="chk_offender_victim_rel_type01" class="on">기관장/사업주</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="offenderVictimRelTypeCbx" id="chk_offender_victim_rel_type02" value="senior">
												<label for="chk_offender_victim_rel_type02" class="on">상급자</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="offenderVictimRelTypeCbx" id="chk_offender_victim_rel_type03" value="partner">
												<label for="chk_offender_victim_rel_type03" class="on">동료</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="offenderVictimRelTypeCbx" id="chk_offender_victim_rel_type04" value="otherrel">
												<label for="chk_offender_victim_rel_type04" class="on">그 외 업무관계자</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="offenderVictimRelTypeCbx" id="chk_offender_victim_rel_type05" value="etc">
												<label for="chk_offender_victim_rel_type05" class="on">기타</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="offenderVictimRelTypeCbx" id="chk_offender_victim_rel_type06" value="unknown">
												<label for="chk_offender_victim_rel_type06" class="on">미파악</label>
											</div>
										</td>
									</tr>
									<tr>
										<th rowspan="2">피해내용</th>
										<th>피해</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="harmFirstTypeCbx" id="chk_harm_first_type01" value="rape">
												<label for="chk_harm_first_type01" class="on">강간/유사강간</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="harmFirstTypeCbx" id="chk_harm_first_type02" value="harass">
												<label for="chk_harm_first_type02" class="on">그외 추행</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="harmFirstTypeCbx" id="chk_harm_first_type03" value="verbal">
												<label for="chk_harm_first_type03" class="on">언어적</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="harmFirstTypeCbx" id="chk_harm_first_type04" value="visual">
												<label for="chk_harm_first_type04" class="on">시각적</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="harmFirstTypeCbx" id="chk_harm_first_type05" value="etc">
												<label for="chk_harm_first_type05" class="on">기타 성희롱</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>2차피해</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="harmSecTypeCbx" id="chk_harm_sec_type01" value="security">
												<label for="chk_harm_sec_type01" class="on">비밀누설/소문유포</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="harmSecTypeCbx" id="chk_harm_sec_type02" value="seprate">
												<label for="chk_harm_sec_type02" class="on">분리조치 미흡</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="harmSecTypeCbx" id="chk_harm_sec_type03" value="intention">
												<label for="chk_harm_sec_type03" class="on">의사에 반한 사건처리</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="harmSecTypeCbx" id="chk_harm_sec_type04" value="identity">
												<label for="chk_harm_sec_type04" class="on">신분상 불이익</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="harmSecTypeCbx" id="chk_harm_sec_type05" value="etc">
												<label for="chk_harm_sec_type05" class="on">그외</label>
											</div>
										</td>
									</tr>
									<tr>
										<th rowspan="2">조치</th>
										<th>타 신고기관 안내</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="responseTypeIntroOrgCbx" id="chk_response_type_intro_org01" value="women">
												<label for="chk_response_type_intro_org01" class="on">여성가족부</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="responseTypeIntroOrgCbx" id="chk_response_type_intro_org02" value="labor">
												<label for="chk_response_type_intro_org02" class="on">고용노동부</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="responseTypeIntroOrgCbx" id="chk_response_type_intro_org03" value="police">
												<label for="chk_response_type_intro_org03" class="on">경찰</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="responseTypeIntroOrgCbx" id="chk_response_type_intro_org04" value="education">
												<label for="chk_response_type_intro_org04" class="on">교육부</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="responseTypeIntroOrgCbx" id="chk_response_type_intro_org05" value="human">
												<label for="chk_response_type_intro_org05" class="on">국가인권위원회</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="responseTypeIntroOrgCbx" id="chk_response_type_intro_org06" value="etc">
												<label for="chk_response_type_intro_org06" class="on">기타</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>서비스연계</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="responseTypeServiceRelCbx" id="chk_response_type_service_rel01" value="con">
												<label for="chk_response_type_service_rel01" class="on">상담</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="responseTypeServiceRelCbx" id="chk_response_type_service_rel02" value="law">
												<label for="chk_response_type_service_rel02" class="on">법률/노무</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="responseTypeServiceRelCbx" id="chk_response_type_service_rel03" value="medical">
												<label for="chk_response_type_service_rel03" class="on">의료</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="responseTypeServiceRelCbx" id="chk_response_type_service_rel04" value="etc">
												<label for="chk_response_type_service_rel04" class="on">그외</label>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							<div class="btn_wrap align_right">
								<a href="javascript:init();" class="btn">초기화</a>
								<a href="javascript:inq();" class="btn bg_btn">조회</a>
							</div>
						</div>
						<div style="width:100%;overflow:auto;margin-top:20px;">
						<table id="statisticResult" class="align_center">
							<caption>상담통계 결과</caption>
							<colgroup>
								<col style="width:60px;">
								<col style="width:60px;">
								<c:forEach items="${dailyList}" var="each" varStatus="loop">
									<col style="width:120px;">
								</c:forEach>
								<c:forEach items="${monthlyList}" var="each" varStatus="loop">
									<col style="width:120px;">
								</c:forEach>
								<col style="width:120px;">
							</colgroup>
							<thead>
								<tr>
									<th colspan="2">구분</th>
									<c:forEach items="${dailyList}" var="each" varStatus="loop">
									<th>${each.days}</th>
									</c:forEach>
									<c:forEach items="${monthlyList}" var="each" varStatus="loop">
									<th>${each.months}</th>
									</c:forEach>
									<th>합계</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th colspan="2">상담건수</th>
									<c:forEach items="${consultingListTotalCnt}" var="listCnt">
									<c:set var="sum1" value="${listCnt.counselCnt eq null? 0:listCnt.counselCnt}"/>
									</c:forEach>
									<c:forEach items="${dailyList}" var="each" varStatus="loop">
										<c:set var="counselCnt" value="0"/>
										<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
											<c:if test="${each.days eq each2.regDate}">
											<c:set var="counselCnt" value="${each2.counselCnt}"/>
											</c:if>
										</c:forEach>
										<td>${counselCnt}</td>
									</c:forEach>
									<c:forEach items="${monthlyList}" var="each" varStatus="loop">
										<c:set var="counselCnt" value="0"/>
										<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
											<c:if test="${each.months eq each2.regDate}">
											<c:set var="counselCnt" value="${each2.counselCnt}"/>
											</c:if>
										</c:forEach>
										<td>${counselCnt}</td>
									</c:forEach>
									<td>${sum1}</td>
								</tr>
								<c:forEach items="${consultingTypeCbx}" var="consultingType" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(consultingTypeCbx)}">분류</th>
									</c:if>
									<th>
									<c:if test="${consultingType eq 'public'}">공공부문</c:if>
									<c:if test="${consultingType eq 'civil'}">민간부문</c:if>
									<c:if test="${consultingType eq 'personal'}">개인간</c:if>
									<c:if test="${consultingType eq 'etc'}">기타/미파악</c:if>
									</th>
									<c:forEach items="${consultingListTotalCnt}" var="listCnt">
									<c:set var="sum1" value="${listCnt.consultingTypePublicCnt eq null? 0:listCnt.consultingTypePublicCnt}"/>
									<c:set var="sum2" value="${listCnt.consultingTypeCivilCnt eq null? 0:listCnt.consultingTypeCivilCnt}"/>
									<c:set var="sum3" value="${listCnt.consultingTypePersonalCnt eq null? 0:listCnt.consultingTypePersonalCnt}"/>
									<c:set var="sum4" value="${listCnt.consultingTypeEtcCnt eq null? 0:listCnt.consultingTypeEtcCnt}"/>
									</c:forEach>
									<c:if test="${consultingType eq 'public'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.consultingTypePublicCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.consultingTypePublicCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${consultingType eq 'civil'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.consultingTypeCivilCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.consultingTypeCivilCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${consultingType eq 'personal'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.consultingTypePersonalCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.consultingTypePersonalCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${consultingType eq 'etc'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.consultingTypeEtcCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.consultingTypeEtcCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
								</tr>
								</c:forEach>
								<c:forEach items="${receivedTypeCbx}" var="receivedType" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(consultingTypeCbx)}">분류</th>
									</c:if>
									<th>
									<c:if test="${receivedType eq 'tel'}">전화</c:if>
									<c:if test="${receivedType eq 'mail'}">우편</c:if>
									<c:if test="${receivedType eq 'visit'}">내방</c:if>
									<c:if test="${receivedType eq 'move'}">이관</c:if>
									</th>
									<c:forEach items="${consultingListTotalCnt}" var="listCnt">
									<c:set var="sum1" value="${listCnt.receivedTypeTelCnt eq null? 0:listCnt.receivedTypeTelCnt}"/>
									<c:set var="sum2" value="${listCnt.receivedTypeMailCnt eq null? 0:listCnt.receivedTypeMailCnt}"/>
									<c:set var="sum3" value="${listCnt.receivedTypeVisitCnt eq null? 0:listCnt.receivedTypeVisitCnt}"/>
									<c:set var="sum4" value="${listCnt.receivedTypeMoveCnt eq null? 0:listCnt.receivedTypeMoveCnt}"/>
									</c:forEach>
									<c:if test="${receivedType eq 'tel'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.receivedTypeTelCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.receivedTypeTelCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${receivedType eq 'mail'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.receivedTypeMailCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.receivedTypeMailCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${receivedType eq 'visit'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.receivedTypeVisitCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.receivedTypeVisitCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${receivedType eq 'move'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.receivedTypeMoveCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${consultingList2}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.receivedTypeMoveCnt}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
								</tr>
								</c:forEach>
								
							</tbody>
						</table>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form:form>
	
	<script>
	$(function(){
		var sdate = '${input.sdate}';
		if(sdate == ''){
			var today = new Date();
			var year = today.getFullYear();
			var month = ('0' + (today.getMonth() + 1)).slice(-2);
			var day = ('0' + today.getDate()).slice(-2);
			var dateString = year + '-' + month  + '-' + day;

			$('#sdate').val(dateString);
			$('#edate').val(dateString);
		}
		
		var range = '${range}';
		$('input:radio[name="range"][value="'+range+'"]').prop('checked', true);
		
		var arrConsultingTypeCbx = '${consultingTypeCbx}';
		arrConsultingTypeCbx = arrConsultingTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrConsultingTypeCbx.length;i++){
            $('input[name=consultingTypeCbx][value="'+arrConsultingTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrReceivedTypeCbx = '${receivedTypeCbx}';
		arrReceivedTypeCbx = arrReceivedTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrReceivedTypeCbx.length;i++){
            $('input[name=receivedTypeCbx][value="'+arrReceivedTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrConsultingReqTypeCbx = '${consultingReqTypeCbx}';
		arrConsultingReqTypeCbx = arrConsultingReqTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrConsultingReqTypeCbx.length;i++){
            $('input[name=consultingReqTypeCbx][value="'+arrConsultingReqTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrContactMethodTypeCbx = '${contactMethodTypeCbx}';
		arrContactMethodTypeCbx = arrContactMethodTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrContactMethodTypeCbx.length;i++){
            $('input[name=contactMethodTypeCbx][value="'+arrContactMethodTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrClientGenderCbx = '${clientGenderCbx}';
		arrClientGenderCbx = arrClientGenderCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrClientGenderCbx.length;i++){
            $('input[name=clientGenderCbx][value="'+arrClientGenderCbx[i]+'"]').prop('checked',true);
		}
		
		var arrClientVictimRelTypeCbx = '${clientVictimRelTypeCbx}';
		arrClientVictimRelTypeCbx = arrClientVictimRelTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrClientVictimRelTypeCbx.length;i++){
            $('input[name=clientVictimRelTypeCbx][value="'+arrClientVictimRelTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrVictimGenderTypeCbx = '${victimGenderTypeCbx}';
		arrVictimGenderTypeCbx = arrVictimGenderTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrVictimGenderTypeCbx.length;i++){
            $('input[name=victimGenderTypeCbx][value="'+arrVictimGenderTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrOffenderGenderTypeCbx = '${offenderGenderTypeCbx}';
		arrOffenderGenderTypeCbx = arrOffenderGenderTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrOffenderGenderTypeCbx.length;i++){
            $('input[name=offenderGenderTypeCbx][value="'+arrOffenderGenderTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrOffenderVictimRelTypeCbx = '${offenderVictimRelTypeCbx}';
		arrOffenderVictimRelTypeCbx = arrOffenderVictimRelTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrOffenderVictimRelTypeCbx.length;i++){
            $('input[name=offenderVictimRelTypeCbx][value="'+arrOffenderVictimRelTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrHarmFirstTypeCbx = '${harmFirstTypeCbx}';
		arrHarmFirstTypeCbx = arrHarmFirstTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrHarmFirstTypeCbx.length;i++){
            $('input[name=harmFirstTypeCbx][value="'+arrHarmFirstTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrHarmSecTypeCbx = '${harmSecTypeCbx}';
		arrHarmSecTypeCbx = arrHarmSecTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrHarmSecTypeCbx.length;i++){
            $('input[name=harmSecTypeCbx][value="'+arrHarmSecTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrResponseTypeIntroOrgCbx = '${responseTypeIntroOrgCbx}';
		arrResponseTypeIntroOrgCbx = arrResponseTypeIntroOrgCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrResponseTypeIntroOrgCbx.length;i++){
            $('input[name=responseTypeIntroOrgCbx][value="'+arrResponseTypeIntroOrgCbx[i]+'"]').prop('checked',true);
		}
		
		var arrResponseTypeServiceRelCbx = '${responseTypeServiceRelCbx}';
		arrResponseTypeServiceRelCbx = arrResponseTypeServiceRelCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrResponseTypeServiceRelCbx.length;i++){
            $('input[name=responseTypeServiceRelCbx][value="'+arrResponseTypeServiceRelCbx[i]+'"]').prop('checked',true);
		}


	});
	 function inq(){
		if($('#sdate').val() == ''){
			alert('상담기간 시작일을 선택하세요.');
			return;
		}
		
		if($('#edate').val() == ''){
			alert('상담기간 종료일을 선택하세요.');
			return;
		}
		 
		$('#ZStatisticsMngVo').attr('action','/admsys/statisticsmng/index2.html');
		$('#ZStatisticsMngVo').submit();
	 }
	 
	 function init(){
		 var today = new Date();
		 var year = today.getFullYear();
		 var month = ('0' + (today.getMonth() + 1)).slice(-2);
		 var day = ('0' + today.getDate()).slice(-2);
		 var dateString = year + '-' + month  + '-' + day;
		 $('#sdate').val(dateString);
		 $('#edate').val(dateString);
		 
		 $('input[name=consultingTypeCbx]').prop('checked',false);
		 $('input[name=receivedTypeCbx]').prop('checked',false);
		 $('input[name=consultingReqTypeCbx]').prop('checked',false);
		 $('input[name=contactMethodTypeCbx]').prop('checked',false);
		 $('input[name=clientGenderCbx]').prop('checked',false);
		 $('input[name=clientVictimRelTypeCbx]').prop('checked',false);
		 $('input[name=victimGenderTypeCbx]').prop('checked',false);
		 $('input[name=offenderGenderTypeCbx]').prop('checked',false);
		 $('input[name=offenderVictimRelTypeCbx]').prop('checked',false);
		 $('input[name=harmFirstTypeCbx]').prop('checked',false);
		 $('input[name=harmSecTypeCbx]').prop('checked',false);
		 $('input[name=responseTypeIntroOrgCbx]').prop('checked',false);
		 $('input[name=responseTypeServiceRelCbx]').prop('checked',false);
		 
		 $('input:radio[name="range"][value="d"]').prop('checked', true);
	 }
	 
	 function excelDownload(){ 
		 var wb = XLSX.utils.table_to_book(document.getElementById('statisticResult'), {sheet:"통계",raw:true});
		 XLSX.writeFile(wb, ('상담통계.xlsx'));
	 }
	</script>       
</div>
<!--/contents-->
<jsp:include page="../end.jsp" flush="false" />
