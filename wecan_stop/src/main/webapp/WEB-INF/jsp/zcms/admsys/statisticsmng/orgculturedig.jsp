<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />
<div id="contents">
    <form:form modelAttribute="ZStatisticsMngVo" name="frm" method="post">
        <div class="contents_top">
            <div class="location">
                <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/statisticsmng/index.html">통계관리</a> <strong>진단통계</strong>
            </div>
        </div>
        <div id="content">
            <ul class="homepagebbs">
               <li>
					<div class="counsel_wrap">
						<div class="title_wrap">
							<h4 class="dot">진단통계</h4>
							<div class="btn_wrap">
								<a href="javascript:excelDownload();" class="btn">엑셀 다운로드</a>
							</div>
						</div>
						<div class="search_box">
							<table>
								<caption>진단통계 조회</caption>
								<colgroup>
									<col style="width:150px;">
									<col style="width:120px;">
									<col style="width:235px;">
									<col style="width:120px;">
									<col style="width:auto;">
								</colgroup>
								<tbody>
									<tr>
										<th>진단일정</th>
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
										<th>유형</th>
										<td colspan="4">
											<div class="input_box">
												<input type="checkbox" name="actionTypeCbx" id="chk_action_type01" value="A">
												<label for="chk_action_type01" class="on">여성가족부신고사건(A)</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeCbx" id="chk_action_type02" value="B">
												<label for="chk_action_type02" class="on">기관신청건(B)</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeCbx" id="chk_action_type03" value="C">
												<label for="chk_action_type03" class="on">여가부선정/타부처이관(C)</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeCbx" id="chk_action_type04" value="D">
												<label for="chk_action_type04" class="on">현장점검(D)</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>진행단계</th>
										<td colspan="4">
											<div class="input_box">
												<input type="checkbox" name="stepStatusCbx" id="chk_step_status01" value="1">
												<label for="chk_step_status01" class="on">신청</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="stepStatusCbx" id="chk_step_status02" value="2">
												<label for="chk_step_status02" class="on">접수대기</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="stepStatusCbx" id="chk_step_status03" value="3">
												<label for="chk_step_status03" class="on">접수승인</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="stepStatusCbx" id="chk_step_status04" value="4">
												<label for="chk_step_status04" class="on">접수불가</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="stepStatusCbx" id="chk_step_status05" value="5">
												<label for="chk_step_status05" class="on">심사대기</label>
											</div>
											<br>
											<div class="input_box">
												<input type="checkbox" name="stepStatusCbx" id="chk_step_status06" value="6">
												<label for="chk_step_status06" class="on">심사거절</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="stepStatusCbx" id="chk_step_status07" value="7">
												<label for="chk_step_status07" class="on">심사승인</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="stepStatusCbx" id="chk_step_status08" value="8">
												<label for="chk_step_status08" class="on">진단 완료</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>상담분류</th>
										<td colspan="4">
											<div class="input_box">
												<input type="checkbox" name="actionConsultingTypeCbx" id="chk_action_consulting_type01" value="init">
												<label for="chk_action_consulting_type01" class="on">초기상담</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionConsultingTypeCbx" id="chk_action_consulting_type02" value="continuing">
												<label for="chk_action_consulting_type02" class="on">지속상담</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionConsultingTypeCbx" id="chk_action_consulting_type03" value="ending">
												<label for="chk_action_consulting_type03" class="on">종결상담</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionConsultingTypeCbx" id="chk_action_consulting_type04" value="monitoring1">
												<label for="chk_action_consulting_type04" class="on">모니터링(1차)</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionConsultingTypeCbx" id="chk_action_consulting_type05" value="monitoring2">
												<label for="chk_action_consulting_type05" class="on">모니터링(2차)</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>경로</th>
										<td colspan="4">
											<div class="input_box">
												<input type="checkbox" name="actionReceivedTypeCbx" id="chk_action_received_type01" value="tel">
												<label for="chk_action_received_type01" class="on">전화</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionReceivedTypeCbx" id="chk_action_received_type02" value="email">
												<label for="chk_action_received_type02" class="on">메일</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionReceivedTypeCbx" id="chk_action_received_type03" value="sms">
												<label for="chk_action_received_type03" class="on">문자</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionReceivedTypeCbx" id="chk_action_received_type04" value="etc">
												<label for="chk_action_received_type04" class="on">기타</label>
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
												<input type="checkbox" name="clientVictimRelTypeCbx" id="chk_client_victim_rel_type04" value="etc">
												<label for="chk_client_victim_rel_type04" class="on">기타</label>
											</div>
										</td>
									</tr>
									<tr>
										<th colspan="2">기관 내 진행 단계</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="orgAccidentStepCbx" id="chk_org_accident_step01" value="before_declaration">
												<label for="chk_org_accident_step01" class="on">신고전</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="orgAccidentStepCbx" id="chk_org_accident_step02" value="after_declaration">
												<label for="chk_org_accident_step02" class="on">신고 접수/상담</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="orgAccidentStepCbx" id="chk_org_accident_step03" value="investigation">
												<label for="chk_org_accident_step03" class="on">조사</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="orgAccidentStepCbx" id="chk_org_accident_step04" value="review">
												<label for="chk_org_accident_step04" class="on">심의</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="orgAccidentStepCbx" id="chk_org_accident_step05" value="punishment">
												<label for="chk_org_accident_step05" class="on">징계</label>
											</div>
											<br>
											<div class="input_box">
												<input type="checkbox" name="orgAccidentStepCbx" id="chk_org_accident_step06" value="followup">
												<label for="chk_org_accident_step06" class="on">후속조치</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="orgAccidentStepCbx" id="chk_org_accident_step07" value="etc">
												<label for="chk_org_accident_step07" class="on">기타</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="orgAccidentStepCbx" id="chk_org_accident_step08" value="unknown">
												<label for="chk_org_accident_step08" class="on">미파악</label>
											</div>
										</td>
									</tr>
									<tr>
										<th rowspan="2">조치</th>
										<th>타 신고기관 안내</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="actionTypeOtherOrgCbx" id="chk_action_type_other_org01" value="min">
												<label for="chk_action_type_other_org01" class="on">고용노동부</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeOtherOrgCbx" id="chk_action_type_other_org02" value="civil_criminal">
												<label for="chk_action_type_other_org02" class="on">민/형사</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeOtherOrgCbx" id="chk_action_type_other_org03" value="rights">
												<label for="chk_action_type_other_org03" class="on">국가인권위원회</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeOtherOrgCbx" id="chk_action_type_other_org04" value="etc">
												<label for="chk_action_type_other_org04" class="on">그외</label>
											</div>
										</td>
									</tr>
									<tr>
										<th>서비스연계</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="actionTypeServiceRelCbx" id="chk_action_type_service_rel01" value="consulting">
												<label for="chk_action_type_service_rel01" class="on">상담</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeServiceRelCbx" id="chk_action_type_service_rel02" value="law_min">
												<label for="chk_action_type_service_rel02" class="on">법률/노무</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeServiceRelCbx" id="chk_action_type_service_rel03" value="medic">
												<label for="chk_action_type_service_rel03" class="on">의료</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeServiceRelCbx" id="chk_action_type_service_rel04" value="etc">
												<label for="chk_action_type_service_rel04" class="on">그외</label>
											</div>
										</td>
									</tr>
									<tr>
										<th colspan="2">조치내용</th>
										<td colspan="3">
											<div class="input_box">
												<input type="checkbox" name="actionTypeContCbx" id="chk_action_type_cont01" value="coun">
												<label for="chk_action_type_cont01" class="on">초기상담</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeContCbx" id="chk_action_type_cont02" value="act">
												<label for="chk_action_type_cont02" class="on">기관조치</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeContCbx" id="chk_action_type_cont03" value="con">
												<label for="chk_action_type_cont03" class="on">수사/조사의뢰</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeContCbx" id="chk_action_type_cont04" value="move">
												<label for="chk_action_type_cont04" class="on">이관</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeContCbx" id="chk_action_type_cont05" value="cancel">
												<label for="chk_action_type_cont05" class="on">각하</label>
											</div>
											<br>
											<div class="input_box">
												<input type="checkbox" name="actionTypeContCbx" id="chk_action_type_cont06" value="giveup">
												<label for="chk_action_type_cont06" class="on">취하</label>
											</div>
											<div class="input_box">
												<input type="checkbox" name="actionTypeContCbx" id="chk_action_type_cont07" value="etc">
												<label for="chk_action_type_cont07" class="on">기타</label>
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
							<caption>진단통계 결과</caption>
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
									<c:set var="sum1" value="0"/>
									<c:forEach items="${dailyList}" var="each" varStatus="loop">
										<c:set var="counselCnt1" value="0"/>
										<c:forEach items="${actionList}" var="each2" varStatus="loop">	
											<c:if test="${each.days eq each2.regDate}">
											<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
											</c:if>
										</c:forEach>
										<td>${counselCnt1}</td>
										<c:set var="sum1" value="${sum1 + counselCnt1}"/>
									</c:forEach>
									<c:forEach items="${monthlyList}" var="each" varStatus="loop">
										<c:set var="counselCnt1" value="0"/>
										<c:forEach items="${actionList}" var="each2" varStatus="loop">	
											<c:if test="${each.months eq each2.regDate}">
											<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
											</c:if>
										</c:forEach>
										<td>${counselCnt1}</td>
										<c:set var="sum1" value="${sum1 + counselCnt1}"/>
									</c:forEach>
									<td>${sum1}</td>
								</tr>
								
								<c:forEach items="${actionTypeCbx}" var="actionType" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(actionTypeCbx)}">유형</th>
									</c:if>
									<th>
									<c:if test="${actionType eq 'A'}">여성가족부신고사건(A)</c:if>
									<c:if test="${actionType eq 'B'}">기관신청건(B)</c:if>
									<c:if test="${actionType eq 'C'}">여가부선정/타부처이관(C)</c:if>
									<c:if test="${actionType eq 'D'}">현장점검(D)</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:set var="sum4" value="0"/>
									<c:if test="${actionType eq 'A'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${actionType eq 'B'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${actionType eq 'C'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${actionType eq 'D'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
								</tr>
								</c:forEach>
								
								<c:forEach items="${stepStatusCbx}" var="stepStatus" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(stepStatusCbx)}">진행단계</th>
									</c:if>
									<th>
									<c:if test="${stepStatus eq '1'}">신청</c:if>
									<c:if test="${stepStatus eq '2'}">접수대기</c:if>
									<c:if test="${stepStatus eq '3'}">접수승인</c:if>
									<c:if test="${stepStatus eq '4'}">접수불가</c:if>
									<c:if test="${stepStatus eq '5'}">심사대기</c:if>
									<c:if test="${stepStatus eq '6'}">심사거절</c:if>
									<c:if test="${stepStatus eq '7'}">심사승인</c:if>
									<c:if test="${stepStatus eq '8'}">진단 완료</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:set var="sum4" value="0"/>
									<c:set var="sum5" value="0"/>
									<c:set var="sum6" value="0"/>
									<c:set var="sum7" value="0"/>
									<c:set var="sum8" value="0"/>
									<c:if test="${stepStatus eq '1'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${stepStatus eq '2'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${stepStatus eq '3'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${stepStatus eq '4'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
									<c:if test="${stepStatus eq '5'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt5" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt5" value="${each2.counselCnt5}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt5}</td>
											<c:set var="sum5" value="${sum5 + counselCnt5}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt5" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt5" value="${each2.counselCnt5}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt5}</td>
											<c:set var="sum5" value="${sum5 + counselCnt5}"/>
										</c:forEach>
										<td>${sum5}</td>
									</c:if>
									<c:if test="${stepStatus eq '6'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt6" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt6" value="${each2.counselCnt6}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt6}</td>
											<c:set var="sum6" value="${sum6 + counselCnt6}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt6" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt6" value="${each2.counselCnt6}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt6}</td>
											<c:set var="sum4" value="${sum6 + counselCnt6}"/>
										</c:forEach>
										<td>${sum6}</td>
									</c:if>
									<c:if test="${stepStatus eq '7'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt7" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt7" value="${each2.counselCnt7}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt7}</td>
											<c:set var="sum7" value="${sum7 + counselCnt7}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt7" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt7" value="${each2.counselCnt7}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt7}</td>
											<c:set var="sum7" value="${sum7 + counselCnt7}"/>
										</c:forEach>
										<td>${sum7}</td>
									</c:if>
									<c:if test="${stepStatus eq '8'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt8" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt8" value="${each2.counselCnt8}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt8}</td>
											<c:set var="sum8" value="${sum8 + counselCnt8}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt8" value="0"/>
											<c:forEach items="${stepStatusList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt8" value="${each2.counselCnt8}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt8}</td>
											<c:set var="sum8" value="${sum8 + counselCnt8}"/>
										</c:forEach>
										<td>${sum8}</td>
									</c:if>
								</tr>
								</c:forEach>
								
								<c:forEach items="${actionConsultingTypeCbx}" var="actionConsultingType" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(actionConsultingTypeCbx)}">상담분류</th>
									</c:if>
									<th>
									<c:if test="${actionConsultingType eq 'init'}">초기상담</c:if>
									<c:if test="${actionConsultingType eq 'continuing'}">지속상담</c:if>
									<c:if test="${actionConsultingType eq 'ending'}">종결상담</c:if>
									<c:if test="${actionConsultingType eq 'monitoring1'}">모니터링(1차)</c:if>
									<c:if test="${actionConsultingType eq 'monitoring2'}">모니터링(2차)</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:set var="sum4" value="0"/>
									<c:set var="sum5" value="0"/>
									<c:if test="${actionConsultingType eq 'init'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${actionConsultingType eq 'continuing'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${actionConsultingType eq 'ending'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${actionConsultingType eq 'monitoring1'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
									<c:if test="${actionConsultingType eq 'monitoring2'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt5" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt5" value="${each2.counselCnt5}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt5}</td>
											<c:set var="sum5" value="${sum5 + counselCnt5}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt5" value="0"/>
											<c:forEach items="${actionConsultingTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt5" value="${each2.counselCnt5}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt5}</td>
											<c:set var="sum5" value="${sum5 + counselCnt5}"/>
										</c:forEach>
										<td>${sum5}</td>
									</c:if>
								</tr>
								</c:forEach>
								
								<c:forEach items="${actionReceivedTypeCbx}" var="actionReceivedType" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(actionReceivedTypeCbx)}">경로</th>
									</c:if>
									<th>
									<c:if test="${actionReceivedType eq 'tel'}">전화</c:if>
									<c:if test="${actionReceivedType eq 'email'}">메일</c:if>
									<c:if test="${actionReceivedType eq 'sms'}">문자</c:if>
									<c:if test="${actionReceivedType eq 'etc'}">기타</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:set var="sum4" value="0"/>
									<c:if test="${actionReceivedType eq 'tel'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionReceivedTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionReceivedTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${actionReceivedType eq 'email'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionReceivedTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionReceivedTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${actionReceivedType eq 'sms'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionReceivedTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionReceivedTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${actionReceivedType eq 'etc'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionReceivedTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionReceivedTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
								</tr>
								</c:forEach>

								<c:forEach items="${clientGenderCbx}" var="clientGender" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(clientGenderCbx)}">의뢰인 성별</th>
									</c:if>
									<th>
									<c:if test="${clientGender eq 'female'}">여성</c:if>
									<c:if test="${clientGender eq 'male'}">남성</c:if>
									<c:if test="${clientGender eq 'unknown'}">미상</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:if test="${clientGender eq 'female'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${clientGenderList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${clientGenderList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${clientGender eq 'male'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${clientGenderList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${clientGenderList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${clientGender eq 'unknown'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${clientGenderList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${clientGenderList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
								</tr>
								</c:forEach>
								
								<c:forEach items="${clientVictimRelTypeCbx}" var="clientVictimRelType" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(clientVictimRelTypeCbx)}">의뢰인 피해자와의 관계</th>
									</c:if>
									<th>
									<c:if test="${clientVictimRelType eq 'me'}">본인</c:if>
									<c:if test="${clientVictimRelType eq 'agent'}">대리인/조력자</c:if>
									<c:if test="${clientVictimRelType eq 'relmanager'}">관련 담당자</c:if>
									<c:if test="${clientVictimRelType eq 'etc'}">기타</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:set var="sum4" value="0"/>
									<c:if test="${clientVictimRelType eq 'me'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${clientVictimRelTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${clientVictimRelTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${clientVictimRelType eq 'agent'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${clientVictimRelTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${clientVictimRelTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${clientVictimRelType eq 'relmanager'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${clientVictimRelTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${clientVictimRelTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${clientVictimRelType eq 'etc'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${clientVictimRelTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${clientVictimRelTypeList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
									</tr>
								</c:forEach>
								
								<c:forEach items="${orgAccidentStepCbx}" var="orgAccidentStep" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(orgAccidentStepCbx)}">피해자 성별</th>
									</c:if>
									<th>
									<c:if test="${orgAccidentStep eq 'before_declaration'}">신고전</c:if>
									<c:if test="${orgAccidentStep eq 'after_declaration'}">신고 접수/상담</c:if>
									<c:if test="${orgAccidentStep eq 'investigation'}">조사</c:if>
									<c:if test="${orgAccidentStep eq 'review'}">심의</c:if>
									<c:if test="${orgAccidentStep eq 'punishment'}">징계</c:if>
									<c:if test="${orgAccidentStep eq 'followup'}">후속조치</c:if>
									<c:if test="${orgAccidentStep eq 'etc'}">기타</c:if>
									<c:if test="${orgAccidentStep eq 'unknown'}">미파악</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:set var="sum4" value="0"/>
									<c:set var="sum5" value="0"/>
									<c:set var="sum6" value="0"/>
									<c:set var="sum7" value="0"/>
									<c:set var="sum8" value="0"/>
									<c:if test="${orgAccidentStep eq 'before_declaration'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${orgAccidentStep eq 'after_declaration'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${orgAccidentStep eq 'investigation'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${orgAccidentStep eq 'review'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
									<c:if test="${orgAccidentStep eq 'punishment'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt5" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt5" value="${each2.counselCnt5}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt5}</td>
											<c:set var="sum5" value="${sum5 + counselCnt5}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt5" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt5" value="${each2.counselCnt5}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt5}</td>
											<c:set var="sum5" value="${sum5 + counselCnt5}"/>
										</c:forEach>
										<td>${sum5}</td>
									</c:if>
									<c:if test="${orgAccidentStep eq 'followup'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt6" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt6" value="${each2.counselCnt6}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt6}</td>
											<c:set var="sum6" value="${sum6 + counselCnt6}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt6" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt6" value="${each2.counselCnt6}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt6}</td>
											<c:set var="sum6" value="${sum6 + counselCnt6}"/>
										</c:forEach>
										<td>${sum6}</td>
									</c:if>
									<c:if test="${orgAccidentStep eq 'etc'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt7" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt7" value="${each2.counselCnt7}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt7}</td>
											<c:set var="sum7" value="${sum7 + counselCnt7}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt7" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt7" value="${each2.counselCnt7}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt7}</td>
											<c:set var="sum7" value="${sum7 + counselCnt7}"/>
										</c:forEach>
										<td>${sum7}</td>
									</c:if>
									<c:if test="${orgAccidentStep eq 'unknown'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt8" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt8" value="${each2.counselCnt8}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt8}</td>
											<c:set var="sum8" value="${sum8 + counselCnt8}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt8" value="0"/>
											<c:forEach items="${orgAccidentStepList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt8" value="${each2.counselCnt8}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt8}</td>
											<c:set var="sum8" value="${sum8 + counselCnt8}"/>
										</c:forEach>
										<td>${sum8}</td>
									</c:if>
								</tr>
								</c:forEach>
								
								<c:forEach items="${actionTypeOtherOrgCbx}" var="actionTypeOtherOrg" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(actionTypeOtherOrgCbx)}">타 신고기관 안내</th>
									</c:if>
									<th>
									<c:if test="${actionTypeOtherOrg eq 'min'}">고용노동부</c:if>
									<c:if test="${actionTypeOtherOrg eq 'civil_criminal'}">민/형사</c:if>
									<c:if test="${actionTypeOtherOrg eq 'rights'}">국가인권위원회</c:if>
									<c:if test="${actionTypeOtherOrg eq 'etc'}">그외</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:set var="sum4" value="0"/>
									<c:if test="${actionTypeOtherOrg eq 'min'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionTypeOtherOrgList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionTypeOtherOrgList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${actionTypeOtherOrg eq 'civil_criminal'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionTypeOtherOrgList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionTypeOtherOrgList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${actionTypeOtherOrg eq 'rights'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionTypeOtherOrgList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionTypeOtherOrgList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${actionTypeOtherOrg eq 'etc'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionTypeOtherOrgList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionTypeOtherOrgList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
								</tr>
								</c:forEach>
									
								<c:forEach items="${actionTypeServiceRelCbx}" var="actionTypeServiceRel" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(actionTypeServiceRelCbx)}">서비스연계</th>
									</c:if>
									<th>
									<c:if test="${actionTypeServiceRel eq 'consulting'}">상담</c:if>
									<c:if test="${actionTypeServiceRel eq 'law_min'}">법률/노무</c:if>
									<c:if test="${actionTypeServiceRel eq 'medic'}">의료</c:if>
									<c:if test="${actionTypeServiceRel eq 'etc'}">그외</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:set var="sum4" value="0"/>
									<c:if test="${actionTypeServiceRel eq 'consulting'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionTypeServiceRelList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionTypeServiceRelList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${actionTypeServiceRel eq 'law_min'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionTypeServiceRelList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionTypeServiceRelList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${actionTypeServiceRel eq 'medic'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionTypeServiceRelList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionTypeServiceRelList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${actionTypeServiceRel eq 'etc'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionTypeServiceRelList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionTypeServiceRelList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
								</tr>
								</c:forEach>
								
								<c:forEach items="${actionTypeContCbx}" var="actionTypeCont" varStatus="loop">	
								<tr>
									<c:if test="${loop.index eq 0}">
									<th rowspan="${fn:length(actionTypeContCbx)}">조치내용</th>
									</c:if>
									<th>
									<c:if test="${actionTypeCont eq 'coun'}">초기상담</c:if>
									<c:if test="${actionTypeCont eq 'act'}">기관조치</c:if>
									<c:if test="${actionTypeCont eq 'con'}">수사/조사의뢰</c:if>
									<c:if test="${actionTypeCont eq 'move'}">이관</c:if>
									<c:if test="${actionTypeCont eq 'cancel'}">각하</c:if>
									<c:if test="${actionTypeCont eq 'giveup'}">취하</c:if>
									<c:if test="${actionTypeCont eq 'etc'}">기타</c:if>
									</th>
									<c:set var="sum1" value="0"/>
									<c:set var="sum2" value="0"/>
									<c:set var="sum3" value="0"/>
									<c:set var="sum4" value="0"/>
									<c:set var="sum5" value="0"/>
									<c:set var="sum6" value="0"/>
									<c:set var="sum7" value="0"/>
									<c:if test="${actionTypeCont eq 'coun'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt1" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt1" value="${each2.counselCnt1}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt1}</td>
											<c:set var="sum1" value="${sum1 + counselCnt1}"/>
										</c:forEach>
										<td>${sum1}</td>
									</c:if>
									<c:if test="${actionTypeCont eq 'act'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt2" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt2" value="${each2.counselCnt2}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt2}</td>
											<c:set var="sum2" value="${sum2 + counselCnt2}"/>
										</c:forEach>
										<td>${sum2}</td>
									</c:if>
									<c:if test="${actionTypeCont eq 'con'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt3" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt3" value="${each2.counselCnt3}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt3}</td>
											<c:set var="sum3" value="${sum3 + counselCnt3}"/>
										</c:forEach>
										<td>${sum3}</td>
									</c:if>
									<c:if test="${actionTypeCont eq 'move'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt4" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt4" value="${each2.counselCnt4}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt4}</td>
											<c:set var="sum4" value="${sum4 + counselCnt4}"/>
										</c:forEach>
										<td>${sum4}</td>
									</c:if>
									<c:if test="${actionTypeCont eq 'cancel'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt5" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt5" value="${each2.counselCnt5}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt5}</td>
											<c:set var="sum5" value="${sum5 + counselCnt5}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt5" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt5" value="${each2.counselCnt5}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt5}</td>
											<c:set var="sum5" value="${sum5 + counselCnt5}"/>
										</c:forEach>
										<td>${sum5}</td>
									</c:if>
									<c:if test="${actionTypeCont eq 'giveup'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt6" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt6" value="${each2.counselCnt6}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt6}</td>
											<c:set var="sum6" value="${sum6 + counselCnt6}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt6" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt6" value="${each2.counselCnt6}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt6}</td>
											<c:set var="sum6" value="${sum6 + counselCnt6}"/>
										</c:forEach>
										<td>${sum6}</td>
									</c:if>
									<c:if test="${actionTypeCont eq 'etc'}">
										<c:forEach items="${dailyList}" var="each" varStatus="loop">
											<c:set var="counselCnt7" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.days eq each2.regDate}">
												<c:set var="counselCnt7" value="${each2.counselCnt7}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt7}</td>
											<c:set var="sum7" value="${sum7 + counselCnt7}"/>
										</c:forEach>
										<c:forEach items="${monthlyList}" var="each" varStatus="loop">
											<c:set var="counselCnt7" value="0"/>
											<c:forEach items="${actionTypeContList}" var="each2" varStatus="loop">	
												<c:if test="${each.months eq each2.regDate}">
												<c:set var="counselCnt7" value="${each2.counselCnt7}"/>
												</c:if>
											</c:forEach>
											<td>${counselCnt7}</td>
											<c:set var="sum7" value="${sum7 + counselCnt7}"/>
										</c:forEach>
										<td>${sum7}</td>
									</c:if>
								</tr>
								</c:forEach>

							</tbody>
<!-- 						<tfoot> 
 								<tr>
 									<th class="align_left" colspan="7">총 접수 건수</th>
 									<td>600</td> 
 								</tr>
 							</tfoot> -->
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
		
		var arrActionTypeCbx = '${actionTypeCbx}';
		arrActionTypeCbx = arrActionTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrActionTypeCbx.length;i++){
            $('input[name=actionTypeCbx][value="'+arrActionTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrStepStatusCbx = '${stepStatusCbx}';
		arrStepStatusCbx = arrStepStatusCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrStepStatusCbx.length;i++){
            $('input[name=stepStatusCbx][value="'+arrStepStatusCbx[i]+'"]').prop('checked',true);
		}
		
		var arrActionConsultingTypeCbx = '${actionConsultingTypeCbx}';
		arrActionConsultingTypeCbx = arrActionConsultingTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrActionConsultingTypeCbx.length;i++){
            $('input[name=actionConsultingTypeCbx][value="'+arrActionConsultingTypeCbx[i]+'"]').prop('checked',true);
		}
		
		var arrActionReceivedTypeCbx = '${actionReceivedTypeCbx}';
		arrActionReceivedTypeCbx = arrActionReceivedTypeCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrActionReceivedTypeCbx.length;i++){
            $('input[name=actionReceivedTypeCbx][value="'+arrActionReceivedTypeCbx[i]+'"]').prop('checked',true);
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
		
		var arrOrgAccidentStepCbx = '${orgAccidentStepCbx}';
		arrOrgAccidentStepCbx = arrOrgAccidentStepCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrOrgAccidentStepCbx.length;i++){
            $('input[name=orgAccidentStepCbx][value="'+arrOrgAccidentStepCbx[i]+'"]').prop('checked',true);
		}
		
		var arrActionTypeOtherOrgCbx = '${actionTypeOtherOrgCbx}';
		arrActionTypeOtherOrgCbx = arrActionTypeOtherOrgCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrActionTypeOtherOrgCbx.length;i++){
            $('input[name=actionTypeOtherOrgCbx][value="'+arrActionTypeOtherOrgCbx[i]+'"]').prop('checked',true);
		}
		
		var arrActionTypeServiceRelCbx = '${actionTypeServiceRelCbx}';
		arrActionTypeServiceRelCbx = arrActionTypeServiceRelCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrActionTypeServiceRelCbx.length;i++){
            $('input[name=actionTypeServiceRelCbx][value="'+arrActionTypeServiceRelCbx[i]+'"]').prop('checked',true);
		}
		
		var arrActionTypeContCbx = '${actionTypeContCbx}';
		arrActionTypeContCbx = arrActionTypeContCbx.replace('[','').replace(']','').split(', ');
		for(var i=0;i<arrActionTypeContCbx.length;i++){
            $('input[name=actionTypeContCbx][value="'+arrActionTypeContCbx[i]+'"]').prop('checked',true);
		}

	});
	 function inq(){
		if($('#sdate').val() == ''){
			alert('진단일정 시작일을 선택하세요.');
			return;
		}
		
		if($('#edate').val() == ''){
			alert('진단일정 종료일을 선택하세요.');
			return;
		}
		 
		$('#ZStatisticsMngVo').attr('action','/admsys/statisticsmng/orgculturedig.html');
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
		 
		 $('input[name=actionTypeCbx]').prop('checked',false);
		 $('input[name=stepStatusCbx]').prop('checked',false);
		 $('input[name=actionConsultingTypeCbx]').prop('checked',false);
		 $('input[name=actionReceivedTypeCbx]').prop('checked',false);
		 $('input[name=clientGenderCbx]').prop('checked',false);
		 $('input[name=clientVictimRelTypeCbx]').prop('checked',false);
		 $('input[name=orgAccidentStepCbx]').prop('checked',false);
		 $('input[name=actionTypeOtherOrgCbx]').prop('checked',false);
		 $('input[name=actionTypeServiceRelCbx]').prop('checked',false);
		 $('input[name=actionTypeContCbx]').prop('checked',false);
		 
		 $('input:radio[name="range"][value="d"]').prop('checked', true);
	 }
	 
	 function excelDownload(){ 
		 var wb = XLSX.utils.table_to_book(document.getElementById('statisticResult'), {sheet:"통계",raw:true});
		 XLSX.writeFile(wb, ('진단통계.xlsx'));
	 }
	</script>       
</div>
<!--/contents-->
<jsp:include page="../end.jsp" flush="false" />
