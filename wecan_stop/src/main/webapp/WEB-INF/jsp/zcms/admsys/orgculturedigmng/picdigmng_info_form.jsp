<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/vendor/jquery.ui.widget.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.iframe-transport.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.fileupload.js"/>'></script>
<style>
	.main_table1{border-top:1px solid #ddd; border-collapse:inherit}
	.main_table1 td{text-align: left;border-top:none}
	.main_table1 td tr:last-child td{border-bottom:none;}
	.main_table1 td table{border-top:none;border-bottom:none}
	.main_table label{display : block;}
	
	#actionTable td:nth-child(1), td:nth-child(3){width: 8%;}
	#actionTable td:nth-child(2), td:nth-child(4){width: 42%}

</style>

<ul class="homepagebbs">
	<li class="bg">
		<h3 class="sub" id="txtOfdetail">담당관 진단 관리 등록 </h3>	
		<div style="text-align: right;padding-right: 10px;">
	       	<a id="action_registration_cancel" class="btmore01" href="javascript:return false;">취소</a>	       	
	       	<c:choose>
	       		
				<c:when test="${mode eq 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
							<a id="action_registration_data" class="btmore01" href="javascript:void(0);">등록</a>
						</c:if>
					</c:forEach>
				</c:when>
				
				<c:when test="${mode ne 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
							<a id="action_edit_data" class="btmore01" href="javascript:void(0);">수정</a>
						</c:if>
					</c:forEach>
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_2' and p.ALLOW_YN eq 'Y' }">
							<a id="action_delete_data" class="btmore01" href="javascript:void(0);">삭제</a>
						</c:if>
					</c:forEach>
				</c:when>
			</c:choose>
			
		</div>
	</li>
	<li id="main_li_content">
		<div id="workPage" class="main_table" style="overflow-y: scroll; min-height:400px; max-height: 800px;" tabindex="100">			
			<input type="hidden" id="actionNO" name="actionNO" value="${data.actionNO}" />
			<input type="hidden" id="consulting_action_no" name="consulting_action_no" value="${data.consulting_action_no}" />
			<input type="hidden" id="ORGANIZATION_ID" name="ORGANIZATION_ID" value="${data.ORGANIZATION_ID}" />

			<!--상담일지 등록 영역-->
			<table class="main_table1" id="actionTable" summary="담당관별 진단 관리 등록 항목을 보여줍니다.">
				<c:choose>
					<c:when test="${mode eq 'reg'}">
						<tr>
							<td>등록번호</td>
							<td>
								<table>
									<tr>
										<td style="width:100px;">접수년도</td>
										<td style="width:300px;">분류</td>
										<td style="width:300px;">숫자</td>
										<td style="width:60px;">검증</td>
									</tr>
									<tr>
										<td>
											<select id="atno_year" name="atno_year"></select>
										</td>
										<td>
											<select id="atno_type" name="atno_type">
												<option value="">구분 선택</option>
												<option value="A">여성가족부신고사건(A)</option>
												<option value="B">기관신청건(B)</option>
												<option value="C">여가부선정/타부처이관(C)</option>
												<option value="D">현장점검(D)</option>
											</select>
											<select id="atno_type_step" style="display: none;">
												<option value="">단계 선택</option>
												<option value="1">단계(1)</option>
												<option value="2">단계(2)</option>
												<option value="3">단계(3)</option>
											</select>
										</td>
										<td>
											<input type="number" id="numberText" name="regAcNo" oninput="handleOnInput(this, 3)" value=""/>
										</td>
										<td>
											<input type="button" id="validationButton" name="validationButton" value="검증" onclick = "validationF()"/>
										</td>
									</tr>
								</table>				
								<input type="hidden" id="acNO" name="acNO" value="${data.consulting_action_no}"/>
								<input type="hidden" id="regAcNo" name="regAcNo" value = ""/>
								
							</td>
							<td>진행상태</td>
							<td>심사대기</td>
						</tr>
					</c:when>
					<c:when test="${mode ne 'reg'}">
						<div class="divStatus <c:if test='${data.step_status eq "1"}'>divStatusSelect</c:if>">신청</div>
						<div class="divStatus <c:if test='${data.step_status eq "2"}'>divStatusSelect</c:if>">접수대기</div>
						<div class="divStatus <c:if test='${data.step_status eq "3"}'>divStatusSelect</c:if>">접수승인</div>
						<div class="divStatus <c:if test='${data.step_status eq "4"}'>divStatusSelect</c:if>">접수불가</div>
						<div class="divStatus <c:if test='${data.step_status eq "5"}'>divStatusSelect</c:if>">심사대기</div>
						<div class="divStatus <c:if test='${data.step_status eq "6"}'>divStatusSelect</c:if>">심사거절</div>
						<div class="divStatus <c:if test='${data.step_status eq "7"}'>divStatusSelect</c:if>">심사승인</div>
						<div class="divStatus <c:if test='${data.step_status eq "8"}'>divStatusSelect</c:if>">진단 완료</div>
						<tr>
							<td>등록번호</td>
							<td>${data.consulting_action_no}							
								<input type="hidden" id="acNO" name="acNO" value="${data.consulting_action_no}"/>
							</td>
							<td>진행상태 변경</td>
							<td>
								<select id="step_status" name="step_status">
									<option value="1" <c:if test='${data.step_status eq "1"}'>selected</c:if>>신청</option>
									<option value="2" <c:if test='${data.step_status eq "2"}'>selected</c:if>>접수대기</option>
									<option value="3" <c:if test='${data.step_status eq "3"}'>selected</c:if>>접수승인</option>
									<option value="4" <c:if test='${data.step_status eq "4"}'>selected</c:if>>접수불가</option>
									<option value="5" <c:if test='${data.step_status eq "5"}'>selected</c:if>>심사대기</option>
									<option value="6" <c:if test='${data.step_status eq "6"}'>selected</c:if>>심사거절</option>
									<option value="7" <c:if test='${data.step_status eq "7"}'>selected</c:if>>심사승인</option>
									<option value="8" <c:if test='${data.step_status eq "8"}'>selected</c:if>>진단 완료</option>
								</select>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
					
					</c:otherwise>
				</c:choose>
				<tr>
					<td>담당관</td>
					<td>
						<select id="managerListSel" onchange="javascript:addManager();">
							<option value="0">담당관을 선택해주세요</option>
							<c:forEach items="${ml}" var="m" varStatus="mi">
								<option value="${m.manager_id}">${m.manager_name}</option>
							</c:forEach>
						</select><br>						
						<ul id="managerListUL" style="column-count: 3;">
							<c:forEach items="${sml}" var="sm" varStatus="smi">
								<li data-no="${sm.manager_id}" data-type="old" id="mulli_${sm.manager_id}">${sm.manager_name}
									<a id="mm_${sm.manager_id}" class="btmore01" href="#" onclick="javascript:delManagerList('${sm.manager_id}');return false;">X</a>
								</li>
							</c:forEach>
						</ul>
						<input type="hidden" id="manager" name="manager" value="${data.manager}" />
					</td>				
					<td>상담분류</td>
					<td>
						<input type="radio" id="action_consulting_type_1" name="action_consulting_type" value="init" <c:if test="${data.action_consulting_type eq 'init'}">checked</c:if>>초기상담
						<input type="radio" id="action_consulting_type_2" name="action_consulting_type" value="continuing" <c:if test="${data.action_consulting_type eq 'continuing'}">checked</c:if>>지속상담
						<input type="radio" id="action_consulting_type_3" name="action_consulting_type" value="ending" <c:if test="${data.action_consulting_type eq 'ending'}">checked</c:if>>종결상담
						<input type="radio" id="action_consulting_type_4" name="action_consulting_type" value="monitoring1" <c:if test="${data.action_consulting_type eq 'monitoring1'}">checked</c:if>>모니터링(1차)
						<input type="radio" id="action_consulting_type_5" name="action_consulting_type" value="monitoring2" <c:if test="${data.action_consulting_type eq 'monitoring2'}">checked</c:if>>모니터링(2차)
					</td>
				</tr>
				<tr>
					<td>일시</td>
					<td>
						상담일<input type="date" id="registration_date" name="registration_date" value="${data.registration_date}" min="2019-01-01" max="2030-12-31" placeholder="년/월/일">
						상담시작<input type="time" id="registration_strtime" name="registration_strtime" value="${data.registration_strtime}">
						상담종료<input type="time" id="registration_endtime" name="registration_endtime" value="${data.registration_endtime}">
					</td>	
					<td>경로</td>
					<td>
						<input type="radio" id="action_received_type_1" name="action_received_type" value="tel" <c:if test="${data.action_received_type eq 'tel'}">checked</c:if>>전화
						<input type="radio" id="action_received_type_2" name="action_received_type" value="email" <c:if test="${data.action_received_type eq 'email'}">checked</c:if>>메일
						<input type="radio" id="action_received_type_3" name="action_received_type" value="sms" <c:if test="${data.action_received_type eq 'sms'}">checked</c:if>>문자
						<input type="radio" id="action_received_type_4" name="action_received_type" value="etc" <c:if test="${data.action_received_type eq 'etc'}">checked</c:if>>기타
					</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" id="contact_tel_no" name="contact_tel_no" value="${data.contact_tel_no}"></td>
					<td>이메일</td>
					<td><input type="text" id="contact_email" name="contact_email" value="${data.contact_email}"></td>
				</tr>
				<tr>
					<td>의뢰인</td>
					<td colspan="3">
						<table>
							<tr>
								<td>이름</td>
								<td><input type="text" id="client_name" name="client_name" value="${data.client_name}"></td>
								<td>성별</td>
								<td>
									<input type="radio" id="client_gender_1" name="client_gender" value="female" <c:if test="${data.client_gender eq 'female'}">checked</c:if>>여성
									<input type="radio" id="client_gender_2" name="client_gender" value="male" <c:if test="${data.client_gender eq 'male'}">checked</c:if>>남성
									<input type="radio" id="client_gender_3" name="client_gender" value="unknown" <c:if test="${data.client_gender eq 'unknown'}">checked</c:if>>미상
								</td>
								<td>소속</td>
								<td><input type="text" id="client_belong" name="client_belong" value="${data.client_belong}"></td>
							</tr>
							<tr>
								<td>피해자와의 관계</td>
								<td colspan="5">
									<input type="radio" id="client_victim_rel_type_1" name="client_victim_rel_type" value="me" <c:if test="${data.client_victim_rel_type eq 'me'}">checked</c:if>>본인
									<input type="radio" id="client_victim_rel_type_2" name="client_victim_rel_type" value="agent" <c:if test="${data.client_victim_rel_type eq 'agent'}">checked</c:if>>대리인/조력자
									<input type="radio" id="client_victim_rel_type_3" name="client_victim_rel_type" value="relmanager" <c:if test="${data.client_victim_rel_type eq 'relmanager'}">checked</c:if>>관련 담당자
									<input type="radio" id="client_victim_rel_type_3" name="client_victim_rel_type" value="etc" <c:if test="${data.client_victim_rel_type eq 'etc'}">checked</c:if>>기타
									<input type="text" id="client_victim_rel_type_etc" name="client_victim_rel_type_etc" value="${data.client_victim_rel_type_etc}">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>기관 내 진행 단계</td>
					<td>
						<table>
							<tr>
								<td>
									<input type="radio" id="org_accident_step_1" name="org_accident_step" value="before_declaration" <c:if test="${data.org_accident_step eq 'before_declaration'}">checked</c:if>>신고전
									<input type="radio" id="org_accident_step_2" name="org_accident_step" value="after_declaration" <c:if test="${data.org_accident_step eq 'after_declaration'}">checked</c:if>>신고 접수/상담
									<input type="radio" id="org_accident_step_3" name="org_accident_step" value="investigation" <c:if test="${data.org_accident_step eq 'investigation'}">checked</c:if>>조사
									<input type="radio" id="org_accident_step_4" name="org_accident_step" value="review" <c:if test="${data.org_accident_step eq 'review'}">checked</c:if>>심의
								</td>
							</tr>
							<tr>
								<td style="text-align: left;">
									<input type="radio" id="org_accident_step_5" name="org_accident_step" value="punishment" <c:if test="${data.org_accident_step eq 'punishment'}">checked</c:if>>징계
									<input type="radio" id="org_accident_step_6" name="org_accident_step" value="followup" <c:if test="${data.org_accident_step eq 'followup'}">checked</c:if>>후속조치
								</td>
							</tr>
							<tr>
								<td>
									<input type="radio" id="org_accident_step_7" name="org_accident_step" value="etc" <c:if test="${data.org_accident_step eq 'etc'}">checked</c:if>>기타
									<input type="text" id="org_accident_step_etc" name="org_accident_step_etc" value="${data.org_accident_step_etc}">
									<input type="radio" id="org_accident_step_8" name="org_accident_step" value="unknown" <c:if test="${data.org_accident_step eq 'unknown'}">checked</c:if>>미파악
								</td>
							</tr>
						</table>
					</td>
					<td>조치(복수선택)</td>
					<td>
						<table>
							<tr>
								<td>
									<input type="checkbox" id="action_type_monitoring" name="action_type_monitoring" value="Y" <c:if test="${data.action_type_monitoring eq 'Y'}">checked</c:if>>진행상황 모니터링
									<input type="checkbox" id="action_type_info" name="action_type_info" value="Y" <c:if test="${data.action_type_info eq 'Y'}">checked</c:if>>절차 안내 및 정보 제공
									<input type="checkbox" id="action_type_req_listening" name="action_type_req_listening" value="Y" <c:if test="${data.action_type_req_listening eq 'Y'}">checked</c:if>>추가정보 및 요구사항 청취
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" id="action_type_other_org_info" name="action_type_other_org_info" value="Y" <c:if test="${data.action_type_other_org_info eq 'Y'}">checked</c:if>>타 신고기관 안내
									(<input type="checkbox" id="action_type_other_org_min" name="action_type_other_org_min" value="Y" <c:if test="${data.action_type_other_org_min eq 'Y'}">checked</c:if>>고용노동부
									<input type="checkbox" id="action_type_other_org_civil_criminal" name="action_type_other_org_civil_criminal" value="Y" <c:if test="${data.action_type_other_org_civil_criminal eq 'Y'}">checked</c:if>>민/형사
									<input type="checkbox" id="action_type_other_org_rights" name="action_type_other_org_rights" value="Y" <c:if test="${data.action_type_other_org_rights eq 'Y'}">checked</c:if>>국가인권위원회
									<input type="checkbox" id="action_type_other_org_etc" name="action_type_other_org_etc" value="Y" <c:if test="${data.action_type_other_org_etc eq 'Y'}">checked</c:if>>그외
									<input type="text" id="action_type_other_org_etc_txt" name="action_type_other_org_etc_txt"
									<c:choose>
										<c:when test="${mode eq 'reg'}">
											disabled="disabled"
										</c:when>
										<c:otherwise>
										N/A
										</c:otherwise>
									</c:choose>
									 value="${data.action_type_other_org_etc_txt}" >)
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" id="action_type_servie_rel" name="action_type_servie_rel" value="Y" <c:if test="${data.action_type_servie_rel eq 'Y'}">checked</c:if>>서비스 연계/지원
									(<input type="checkbox" id="action_type_servie_rel_consulting" name="action_type_servie_rel_consulting" value="Y" <c:if test="${data.action_type_servie_rel_consulting eq 'Y'}">checked</c:if>>상담
									<input type="checkbox" id="action_type_servie_rel_law_min" name="action_type_servie_rel_law_min" value="Y" <c:if test="${data.action_type_servie_rel_law_min eq 'Y'}">checked</c:if>>법률/노무
									<input type="checkbox" id="action_type_servie_rel_medic" name="action_type_servie_rel_medic" value="Y" <c:if test="${data.action_type_servie_rel_medic eq 'Y'}">checked</c:if>>의료
									<input type="checkbox" id="action_type_servie_rel_etc" name="action_type_servie_rel_etc" value="Y" <c:if test="${data.action_type_servie_rel_etc eq 'Y'}">checked</c:if>>그외
									<input type="text" id="action_type_servie_rel_etc_txt" name="action_type_servie_rel_etc_txt" value="${data.action_type_servie_rel_etc_txt}">)
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" id="action_type_etc" name="action_type_etc" value="Y" <c:if test="${data.action_type_etc eq 'Y'}">checked</c:if>>기타
									<input type="text" id="action_type_etc_txt" name="action_type_etc_txt" value="${data.action_type_etc_txt}">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>조치내용</td>
					<td>
						<input type="radio" id="action_type_cont_1" name="action_type_cont" value="coun" <c:if test="${data.action_type_cont eq 'coun'}">checked</c:if>>초기상담
						<input type="radio" id="action_type_cont_2" name="action_type_cont" value="act" <c:if test="${data.action_type_cont eq 'act'}">checked</c:if>>기관조치
						<input type="text" id="action_type_cont_etc_txt" name="action_type_cont_etc_txt" value="${data.action_type_cont_etc_txt}">
						<input type="radio" id="action_type_cont_3" name="action_type_cont" value="con" <c:if test="${data.action_type_cont eq 'con'}">checked</c:if>>수사/조사의뢰
						<input type="radio" id="action_type_cont_4" name="action_type_cont" value="move" <c:if test="${data.action_type_cont eq 'move'}">checked</c:if>>이관
						<input type="radio" id="action_type_cont_5" name="action_type_cont" value="cancel" <c:if test="${data.action_type_cont eq 'cancel'}">checked</c:if>>각하
						<input type="radio" id="action_type_cont_6" name="action_type_cont" value="giveup" <c:if test="${data.action_type_cont eq 'giveup'}">checked</c:if>>취하
						<input type="radio" id="action_type_cont_7" name="action_type_cont" value="etc" <c:if test="${data.action_type_cont eq 'etc'}">checked</c:if>>기타
						<%-- <input type="checkbox" id="action_contents_etc" name="action_contents_etc" value="Y" <c:if test="${data.action_contents_etc eq 'Y'}">checked</c:if>>기타 --%>
						<textarea id="action_contents" name="action_contents" style="resize: none; width:100%; height:100px;">${data.action_contents}</textarea>
					</td>
					<td>향후 계획</td>
					<td><br><textarea id="after_plan" name="after_plan" style="resize: none; width:100%; height:100px;">${data.after_plan}</textarea></td>
				</tr>
				<tr>
					<td>비고</td>
					<td colspan="3"><textarea id="action_etc" name="action_etc" style="resize: none; width:100%; height:100px;">${data.action_etc}</textarea></td>
				</tr>
				<tr>
					<td>상담일지 등록하기</td>
					<td colspan="3"><input type="button" id="consult_reg_btn" onclick="return void(0);" value="상담일지 등록" /><br>
						<ul id="consultingUL" style="column-count: 3;">
							<c:forEach items="${conList}" var="a" varStatus="ai">
								<li data-no="${a.consulting_no}" id="culli_${a.consulting_no}">${a.consulting_history_no}
								<a id="dv_${a.consulting_no}" class="btmore01" href="#" onclick="javascript:conView('${a.consulting_no}');return false;">View</a>
								<a id="dd_${a.consulting_no}" class="btmore01" href="#" onclick="javascript:delConsultingList('${a.consulting_no}');return false;">X</a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td>일정 지정</td>
					<td colspan="3">
						<fmt:parseDate value="${data.action_consulting_date_from}" pattern="yyyy-MM-dd" var="sd1" />
						<fmt:parseDate value="${data.action_consulting_date_to}" pattern="yyyy-MM-dd" var="ed1" />
						시작일:<input type="date" id="action_consulting_date_from" name="action_consulting_date_from" value="<fmt:formatDate type="both" value="${sd1}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
						종료일:<input type="date" id="action_consulting_date_to" name="action_consulting_date_to" value="<fmt:formatDate type="both" value="${ed1}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
				</tr>
				<tr>
					<td>위원 지정</td>
					<td colspan="3"><input type="button" id="searchCommissionerListPop" value="위원 등록" /><br>
						<ul id="commUL" style="column-count: 3; width:100%">
							<c:forEach items="${cList}" var="c" varStatus="ci">
								<li data-no="${c.counselNum}" id="cmulli_${c.counselNum}">${c.counselName}
									<a id="cv_${c.counselNum}" class="btmore01" href="#" onclick="javascript:commView('${c.counselNum}');return false;">View</a>
									<a id="cm_${c.counselNum}" class="btmore01" href="#" onclick="javascript:delCommList('${c.counselNum}');return false;">X</a><br>
									<fmt:parseDate value="${c.ac_com_date_from}" pattern="yyyy-MM-dd HH:mm:ss" var="sd2" />
									<fmt:parseDate value="${c.ac_com_date_to}" pattern="yyyy-MM-dd HH:mm:ss" var="ed2" />
									<input type="date" id="cm_from${c.counselNum}" name="cm_from${c.counselNum}" value="<fmt:formatDate type="both" value="${sd2}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
									<input type="date" id="cm_to${c.counselNum}" name="cm_to${c.counselNum}" value="<fmt:formatDate type="both" value="${ed2}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
								</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td>첨부 파일</td>
					<td colspan="3">
						<a id="actionUploadBtn" class="btmore05" onclick="return attach();">+ 파일 등록</a>
						<input id="upload" type="file" name="file" 
								data-url="/admsys/commonFile/attach.html" 
								multiple style="opacity: 0; filter:alpha(opacity: 0);"><br/>
						<ul id="fileListUL" style="column-count: 2;">
						<c:forEach items="${fileList}" var="f" varStatus="fi">
							<li data-no="${f.NO}" data-type="old" id="ulliFile_${f.NO}">${f.file_name}
								<a id="bb_${f.NO}" class="btmore01" href="#" onclick="javascript:pickup('${f.NO}');return false;">받기</a>
								<a id="cc_${f.NO}" class="btmore01" href="#" onclick="javascript:detach('${f.NO}','${f.file_name}');return false;">삭제</a>
							</li>
						</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td>언론 모니터링 정보
					</td>
					<td colspan="3"><input type="button" id="searchPressSrchListPop" value="언론 모니터링 등록" />
						<table style="width:100%" summary="번호, 기사명, 등록자명, 등록일">
							<caption>언론 모니터링 정보 목록</caption>
							<colgroup>
								<col width="5%" />
								<col width="40%" />
								<col width="10%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
							</colgroup>
							<thead>
								<tr>
									<th>번호</th>
									<th>기사명</th>
									<th>등록자명</th>
									<th>등록일</th>
									<th>보기</th>
									<th>지정 취소</th>
								</tr>
							</thead>
							<tbody id="pressTrList">
							<c:forEach items="${acList}" var="a" varStatus="ai">
								<tr data-no="${a.NO}" id="tr_${a.NO}">
									<td style="width:5%; text-align: center;" id="nseq_${a.NO}">${ai.index+1}</td>
									<td style="width:40%">${a.article_title}</td>
									<td style="width:10%">${a.create_user}</td>	
									<td style="width:15%">${a.create_date}</td>
									<td style="width:15%; text-align: center;"><a id="av_${a.NO}" class="btmore01" href="#" onclick="javascript:pressViewPop(${a.NO});return false;">View</a></td>
									<td style="width:15%; text-align: center;"><a id="aa_${a.NO}" class="btmore01" href="#" onclick="javascript:delPressList(${a.NO});return false;">X</a></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</td>
				</tr>
			</table>
			<table id="applicationTAble" class="main_table1" style="">
				<!-- 신청서 시작 -->
				<tr>
					<td colspan="4" style="font-size: 20px; text-align: center;"><br><br><br>신청 접수 영역 시작</td>
				</tr>
				<tr>
					<td colspan="4" style="font-size: 16px;">기관 정보<td>
				</tr>
                <tr>
                    <td>유형</td>
                    <td>
                        <input type="radio" id="org_type_1" name="org_type" value="gov" <c:if test="${data.org_type eq 'gov'}">checked</c:if>>공공
                        <input type="radio" id="org_type_2" name="org_type" value="priv"<c:if test="${data.org_type eq 'priv'}">checked</c:if>>민간
                    </td>
					<td>기관명</td>
					<td>
						<input type="text" id="org_name" name="org_name" placeholder="" value="${data.org_name}">
						<input type="hidden" id="org_code" name="org_code" value="${data.org_code}" /><input type="button" onclick="openGovSrchPop('gov');" value="기관명 검색">
					</td>
				</tr>
				<tr>
					<td>상급기관</td>
					<td>
						<input type="text" id="upper_org_name" name="upper_org_name" placeholder="" value="${data.upper_org_name}">
						<input type="hidden" id="upper_org_code" name="upper_org_code" value="${data.upper_org_code}" /><input type="button" onclick="openGovSrchPop('upper');" value="상급기관 검색">
					</td>
					<td>현원</td>
					<td><input type="number" id="org_member_count" name="org_member_count" placeholder="" value="${data.org_member_count}">명</td>
				</tr>
				
				<c:choose>
					<c:when test="${data.org_type eq 'gov'}"><tr id="org_type_detail" style="display:tablerow;"></c:when>
					<c:otherwise><tr id="org_type_detail" style="display:none;"></c:otherwise>
				</c:choose>
					<td>기관분류</td>
					<td colspan="3">
					    <input type="radio" id="org_type_gov_detail_1" name="org_type_gov_detail" value="national" <c:if test="${data.org_type_gov_detail eq 'national'}">checked</c:if>>국가기관
                        <input type="radio" id="org_type_gov_detail_2" name="org_type_gov_detail" value="local"<c:if test="${data.org_type_gov_detail eq 'local'}">checked</c:if>>지방자치단체(지자체)
                        <input type="radio" id="org_type_gov_detail_3" name="org_type_gov_detail" value="public" <c:if test="${data.org_type_gov_detail eq 'public'}">checked</c:if>>공공기관
                        <input type="radio" id="org_type_gov_detail_4" name="org_type_gov_detail" value="school"<c:if test="${data.org_type_gov_detail eq 'school'}">checked</c:if>>각급학교
					</td>
				</tr>
				<tr>
					<td colspan="4" style="font-size: 16px;"><br>담당자 정보<td>
				</tr>
				<tr>
					<td>소속 및 직위</td>
					<td><input type="text" id="belong_job_title" name="belong_job_title" placeholder="" value="${data.belong_job_title}"></td>				
					<td>이름</td>
					<td><input type="text" id="org_client_name" name="org_client_name" placeholder="" value="${data.org_client_name}"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" id="org_client_tel_no" name="org_client_tel_no" placeholder="" value="${data.org_client_tel_no}"></td>				
					<td>이메일</td>
					<td><input type="text" id="org_client_email" name="org_client_email" placeholder="" value="${data.org_client_email}"></td>
				</tr>
				<tr>
					<td colspan="4" style="font-size: 16px;"><br>신고사건 현황</td>
				</tr>
				<tr>
					<td>사건처리이력</td>
					<td>
						<input type="radio" id="accident_response_hist_1" name="accident_response_hist" value="yes" <c:if test="${data.accident_response_hist eq 'yes'}">checked</c:if>>유
						<input type="radio" id="accident_response_hist_2" name="accident_response_hist" value="no" <c:if test="${data.accident_response_hist eq 'no'}">checked</c:if>>무
						<input type="radio" id="accident_response_hist_3" name="accident_response_hist" value="none" <c:if test="${data.accident_response_hist eq 'none'}">checked</c:if>>발생했으나 공식처리되지 않음
					</td>
					<td>시기(최근)</td>
					<td>	                     
						<fmt:parseDate value="${data.accident_date}" pattern="yyyy-MM-dd HH:mm:ss" var="acdt" />
						<fmt:parseDate value="${data.receipt_date}" pattern="yyyy-MM-dd HH:mm:ss" var="rcdt" />
						발생시기 <input type="date" id="accident_date" name="accident_date" value="<fmt:formatDate type="both" value="${acdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
						접수시기 <input type="date" id="receipt_date" name="receipt_date" value="<fmt:formatDate type="both" value="${rcdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
					</td>
				</tr>
				<tr>
					<td>피해유형<br><span>(중복체크가능)</span></td>
					<td>
						<input type="checkbox" id="harm_type_verbals" name="harm_type_verbals" value="Y" <c:if test="${data.harm_type_verbals eq 'Y'}">checked</c:if>>언어적 성희롱
						<input type="checkbox" id="harm_type_body" name="harm_type_body" value="Y" <c:if test="${data.harm_type_body eq 'Y'}">checked</c:if>>신체적 성희롱
						<input type="checkbox" id="harm_type_visual" name="harm_type_visual" value="Y" <c:if test="${data.harm_type_visual eq 'Y'}">checked</c:if>>시각적 성희롱
						<input type="checkbox" id="harm_type_second" name="harm_type_second" value="Y" <c:if test="${data.harm_type_second eq 'Y'}">checked</c:if>>2차 피해
						<input type="checkbox" id="harm_type_etc" name="harm_type_etc" value="Y" <c:if test="${data.harm_type_etc eq 'Y'}">checked</c:if>>기타 (직접입력)
						<input type="text" id="harm_etc_txt" name="harm_etc_txt" placeholder="기타유형을 입력해주세요." value="${data.harm_etc_txt}">
					</td>
					<td>사건 진행단계</td>
					<td>
						<input type="radio" id="accident_step_1" name="accident_step" value="step1" <c:if test="${data.accident_step eq 'step1'}">checked</c:if>>인지 및 접수 (삼당)
						<input type="radio" id="accident_step_2" name="accident_step" value="step2" <c:if test="${data.accident_step eq 'step2'}">checked</c:if>>조사
						<input type="radio" id="accident_step_3" name="accident_step" value="step3" <c:if test="${data.accident_step eq 'step3'}">checked</c:if>>고충심의위원회
						<input type="radio" id="accident_step_4" name="accident_step" value="step4" <c:if test="${data.accident_step eq 'step4'}">checked</c:if>>종결 (후속조치)
					</td>
				</tr>
				<tr>
					<td>기타(직접입력)<span>사건 관련 특이사항 등</span></td>
					<td colspan="3">
						<textarea id="application_etc_txt" name="application_etc_txt" rows="2" style="resize: none; width:100%; height:100px;" placeholder="기타 신고사건 현황을 입력해주세요.">${data.application_etc_txt}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4" style="font-size: 16px;"><br>희망분야 (중복체크 컨설팅 일정 및 내용은 선정 후 기관과 협의하여 확정합니다.)</td>
				</tr>
				<tr>
					<td><input type="radio" id="acc_1" name="acc" value="1">사건처리이력<br>없는 기관</td>
					<td colspan="3" id="acc1td">
						<input type="checkbox" id="first_org_type_all" class="num01" name="first_org_type_all" value="Y" <c:if test="${data.first_org_type_all eq 'Y'}">checked</c:if>>전수 설문조사 (조직문화 및 성희롱 성폭력 실태 파악)
						<input type="checkbox" id="first_org_type_inorg" class="num02" name="first_org_type_inorg" value="Y" <c:if test="${data.first_org_type_inorg eq 'Y'}">checked</c:if>>기관 내 성희롱ㆍ성폭력 사건처리 절차 및 제도* 자문<span>* 성희롱 방지조치, 폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span><br>
						<input type="checkbox" id="first_org_type_protect" class="num03" name="first_org_type_protect" value="Y" <c:if test="${data.first_org_type_protect eq 'Y'}">checked</c:if>>피해자 보호, 2차 피해 방지 방안 자문
						<input type="checkbox" id="first_org_type_etc" class="num05" name="first_org_type_etc" value="Y" <c:if test="${data.first_org_type_etc eq 'Y'}">checked</c:if>>기타(직접 작성)
						<textarea id="first_org_type_etc_txt" name="first_org_type_etc_txt" rows="2" style="resize: none; width:100%; height:100px;" placeholder="기타 의견을 입력해주세요.">${data.first_org_type_etc_txt}</textarea>
					</td>
				</tr>
				<tr>
					<td><input type="radio" id="acc_2" name="acc" value="2">사건처리이력<br>있는 기관</td>
					<td colspan="3" id="acc2td">
						<input type="checkbox" id="dup_org_type_check" class="num01" name="dup_org_type_check" value="Y" <c:if test="${data.dup_org_type_check eq 'Y'}">checked</c:if>>기관 내 성희롱ㆍ성폭력 사건처리절차 검토 및 자문
						<input type="checkbox" id="dup_org_type_protect" class="num02" name="dup_org_type_protect" value="Y" <c:if test="${data.dup_org_type_protect eq 'Y'}">checked</c:if>>피해자 보호, 2차 피해 방지 및 재발방지대책 수립 자문
						<input type="checkbox" id="dup_org_type_all" class="num03" name="dup_org_type_all" value="Y" <c:if test="${data.dup_org_type_all eq 'Y'}">checked</c:if>>전수 설문조사 (조직문화 및 성희롱ㆍ성폭력 실태 파악)
						<input type="checkbox" id="dup_org_type_inorg" class="num03" name="dup_org_type_inorg" value="Y" <c:if test="${data.dup_org_type_inorg eq 'Y'}">checked</c:if>>기관 내 성희롱ㆍ성폭력 사건처리 제도*자문 <span>*  폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span>
						<input type="checkbox" id="dup_org_type_etc" class="num05" name="dup_org_type_etc" value="Y" <c:if test="${data.dup_org_type_etc eq 'Y'}">checked</c:if>>기타(직접 작성)
						<textarea id="dup_org_type_etc_txt" name="dup_org_type_etc_txt" rows="2" style="resize: none; width:100%; height:100px;" placeholder="기타 의견을 입력해주세요.">${data.dup_org_type_etc_txt}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4" style="font-size: 16px;"><br>비고 가능한 시기 모두 체크해주세요
						<input type="hidden" id="wish_consulting_date_1" name="wish_consulting_date_1" value="">
						<input type="hidden" id="wish_consulting_date_2" name="wish_consulting_date_2" value="">
						<input type="hidden" id="wish_consulting_date_3" name="wish_consulting_date_3" value="">
						<input type="hidden" id="wish_consulting_date_4" name="wish_consulting_date_4" value="">
					</td>
				</tr>
				<tr>			
					<td colspan="4">
						<table style="width:100%">
							<tr>
								<td style="width:10%">컨설팅 가능 시기</td>					
                          		<td style="width:14%"><span id="w1ym">${fn:substring(data.wish_consulting_date_1,2,4)}년 ${fn:substring(data.wish_consulting_date_1,4,6)}분기</span>
									<input type="hidden" id="wish_consulting_date_1" name="wish_consulting_date_1" value="${data.wish_consulting_date_1}">
									<input type="checkbox" name="wish_consulting_date_1_yn" id="wish_consulting_date_1_yn" value="Y" <c:if test="${data.wish_consulting_date_1_yn eq 'Y'}">checked</c:if>>
								</td>
								<td style="width:14%"><span id="w2ym">${fn:substring(data.wish_consulting_date_2,2,4)}년 ${fn:substring(data.wish_consulting_date_2,4,6)}분기</span>
									<input type="hidden" id="wish_consulting_date_2" name="wish_consulting_date_2" value="${data.wish_consulting_date_2}">
									<input type="checkbox" name="wish_consulting_date_2_yn" id="wish_consulting_date_2_yn" value="Y" <c:if test="${data.wish_consulting_date_2_yn eq 'Y'}">checked</c:if>>
								</td>	                              
                            	<td style="width:14%"><span id="w3ym">${fn:substring(data.wish_consulting_date_3,2,4)}년 ${fn:substring(data.wish_consulting_date_3,4,6)}분기</span> 
                                   	<input type="hidden" id="wish_consulting_date_3" name="wish_consulting_date_3" value="${data.wish_consulting_date_3}">
                                	<input type="checkbox" name="wish_consulting_date_3_yn" id="wish_consulting_date_3_yn" value="Y" <c:if test="${data.wish_consulting_date_3_yn eq 'Y'}">checked</c:if>>
                                </td>
                            	<td style="width:14%"><span id="w4ym">${fn:substring(data.wish_consulting_date_4,2,4)}년 ${fn:substring(data.wish_consulting_date_4,4,6)}분기</span> 
                                   	<input type="hidden" id="wish_consulting_date_4" name="wish_consulting_date_4" value="${data.wish_consulting_date_4}">
                                	<input type="checkbox" name="wish_consulting_date_4_yn" id="wish_consulting_date_4_yn" value="Y" <c:if test="${data.wish_consulting_date_4_yn eq 'Y'}">checked</c:if>>
                                </td>
                                
                        	</tr>
                        	<tr>
                        		<td>기관 특성 등 사전에 참고해야 할 사항 등</td>
                        		<td colspan="4">
                        		<textarea id="reference_etc" name="reference_etc" rows="3" style="resize: none; width:100%; height:100px;" placeholder="기관 특성 등 사전에 참고해야 할 사항 등">${data.reference_etc}</textarea>
                        		</td>
                        	</tr>
						</table>
					</td>
				</tr>
			</table>
			
			<c:if test="${mode ne 'reg'}">
				<table class="main_table1" >							
					<tr id="editReason" style="display: none;">
						<td style="width:15%">수정 사유</td>
						<td colspan="3">
							<textarea id="edit_reason" name="edit_reason" rows="3" style="resize: none; width:100%; height:100px;"></textarea>
						</td>
					</tr>
					<tr id="editReasonHistoryList">
						<td style="width:8%">조치일자 수정 이력 및 사유</td>
						<td colspan="3">
							<table summary="번호, 수정일, 수정사유보기" style="width:100%;">
	                            <caption>조치일자 수정 이력 및 사유 목록</caption>
	                            <colgroup>
	                                <col width="15%" />
	                                <col width="15%" />
	                                <col width="70%" />
	                            </colgroup>
	                            <thead>
									<tr>
										<th>번호</th>
										<th>수정일</th>
										<th>수정사유보기</th>
									</tr>                            	
	                            </thead>					
								<tbody>
									<c:choose>
										<c:when test="${historyList.size() > 0}">
											<c:forEach items="${historyList}" var="each" varStatus="loop">
												<tr>
													<td style="text-align: center;">${each.edit_history_no}</td>
													<td>${each.create_date}</td>
													<td>${each.edit_contents}</td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr><td colspan="3">수정 이력이 없습니다.</td></tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</td>
					</tr>
				</table>
			</c:if>
			<!--/상담일지 등록 영역-->
		</div>
		<!--/main_table-->
	</li>
</ul>
<script>
	function handleOnInput(el, maxlength) {
		  if(el.value.length > maxlength)  {
		    el.value 
		      = el.value.substr(0, maxlength);
		  }
		}
	

	$(window).on('resize', function(){
		$("#workPage").css('max-height',window.innerHeight -210 );
	});

	var edit_save_flag="edit";
	$(function(){
		setSelectYear("atno_year", "2018", "Y");
		
		$("#workPage").css('max-height',window.innerHeight -210 );
		
		$("#contents").focusout(function(e){
			
			//if ( edit_save_flag == "save" ) {
			//	e.preventDefault();
			//	alert("수정사항이 있으시면 저장후 이동하여 주세요.");	
			//}
		});
		
		var mode = '${mode}';
		
		if ( mode == 'reg' ) {
			//all enable
			elementsDisabled(true);
// 			setInterval(clockStart,1000);
			$("#txtOfdetail").text("담당관 진단 관리 등록");
			//blank data
		} else if ( mode == 'view' ) {
			//all disable
			elementsDisabled(false);
			$("#action_registration_cancel").text("목록");
			$("#searchPressSrchListPop").hide();
			$("#managerListSel").hide();
			$("#searchCommissionerListPop").hide();
			$("#txtOfdetail").text("담당관 진단 관리 상세");
			//fill data
		} else if ( mode == 'edit' ) {
			//all enable
			//fill data
		} else {
			//???
		}
		
        $('#upload').fileupload({
            dataType: 'json',
            done    : function (e, data) {
            	appendFileInfo(data.result[0].name, data.result[0].no);
            }
        });
        
    	$("#searchPressSrchListPop").click(function(){
    		PopupCenter('/admsys/administration/index.html?mode=POP', 'popupSearchPressList','1000','730');
    	});
    	
    	$("#action_registration_cancel").click(function(){
			if ( mode == "view" && edit_save_flag == 'edit' ) {
				location.reload();
    			//location.href = "<c:url value='/admsys/orgculturedigmng/picdigmng.html' />";
    		} else {
    			if(confirm("취소하시겠습니까?")){
        			if ( mode == "reg" ) {
        				location.reload();
        				//location.href = "<c:url value='/admsys/consultingmng/index.html' />";
        			} else if ( mode == "view" ) {
        				$("#editReason").hide();
        				$("#editReasonHistoryList").show();
        				elementsDisabled(false);
        				$("#action_edit_data").text("수정");
        				$("#action_registration_cancel").text("목록");
        				$("#txtOfdetail").text("담당관 진단 관리 상세");
        				edit_save_flag = "edit";
        				$("#managerListSel").hide();
        			}
    			}	
    		}			
		});
    	
    	
		$("#action_edit_data").click(function(){
			if(edit_save_flag == 'save') {
				var managerArray = new Array();
				managerArray = getUlList("managerListUL");
				
				if ( managerArray.length <= 0 || managerArray.length === 0) {
					alert("담당관을 지정하여 주세요.");
					$("#managerListSel").focus();
					return;
				}
				
				var editVal = $("#edit_reason").val();
				
				if ( editVal == '' ) {
					alert("수정 사유를 입력해 주세요.");
					$("#edit_reason").focus();
					return;
				}
				if ( !validationCheck() ) {
					return;
				}

				if(confirm("수정 하시겠습니까?")){
					var strArr = $('#AppActionMergeVo').serializeArray();
					strArr.push({name: "managerList", value: managerArray});
					
					var fileULArray = new Array();
					fileULArray = getUL_li_no("fileListUL");
					strArr.push({name: "fileList", value: fileULArray});
					
					var pressArray = new Array();
					var ulLen = $("#pressTrList tr").length;
					for( var i = 0; i < ulLen; i++ ) {	
						var liNo = $("#pressTrList tr:eq("+i+")").data("no");
						pressArray.push(liNo);					
					}
					strArr.push({name: "pressList", value: pressArray});

					var commArray = new Array();
					commArray = getCommissionerInfo("commUL");
					strArr.push({name: "cmmList", value: commArray});
					
					var consultingArray = new Array();
					consultingArray = getUlList("consultingUL");
					strArr.push({name: "consultingNoList", value: consultingArray});
					
					var data = JSON.stringify(objectifyForm(strArr));
					
					$.ajax({
						  type: 'POST',
						  url: "/admsys/orgculturedigmng/picdigmng_update.html",
						  dataType: 'json',
				          contentType: 'application/json; charset=utf-8',	
						  data: data,
						  success: function(result){
							  if ( result.retStatus == "SUCCESS" ) {
								  $("#action_registration_cancel").text("목록");
								  edit_save_flag = "edit";
								  alert("수정 하였습니다.");
								  <c:if test="${mode ne 'reg'}">
								  viewDetailPageFromDetail('${data.actionNO}', '${data.consulting_action_no}','Y');
								  </c:if>
								  
								  
							  } else {
								  alert("수정에 실패 하였습니다.");
							  }
						  },
						  error:function(){
							  alert("수정중 오류가 발생하였습니다.");  
						  }
					})
				}

			}else if(edit_save_flag == 'edit') {
				
				if(confirm("수정 하시겠습니까?")){
					elementsDisabled(true);
					edit_save_flag="save";
					$("#editReason").show();
					$("#editReasonHistoryList").hide();
					$("#action_edit_data").text("저장");
					$("#action_registration_cancel").text("취소");
					$("#searchPressSrchListPop").show();
					$("#managerListSel").show();
					$("#searchCommissionerListPop").show();
					$("a[id^=cm_]").show();
					$("[id^=cm_]").show();
					$("#txtOfdetail").text("담당관 진단 관리 수정");
				}
			}
		});
    	
		$("#action_registration_data").click(function(){
			// 필수값 체크
			var managerArray = new Array();
			managerArray = getUlList("managerListUL");
			
			if ( managerArray.length <= 0 ) {
				alert("담당관을 지정하여 주세요.");
				$("#managerListSel").focus();
				return;
			}
			
			if ( !validationCheck() ) {
				return;
			}

			if(confirm("등록 하시겠습니까?")){
				var strArr = $('#AppActionMergeVo').serializeArray();
				strArr.push({name: "managerList", value: managerArray});
	
				var fileULArray = new Array();
				fileULArray = getUL_li_no("fileListUL");
				strArr.push({name: "fileList", value: fileULArray});
				
				var pressArray = new Array();
				var ulLen = $("#pressTrList tr").length;
				for( var i = 0; i < ulLen; i++ ) {	
					var liNo = $("#pressTrList tr:eq("+i+")").data("no");
					pressArray.push(liNo);					
				}
				strArr.push({name: "pressList", value: pressArray});
				
				var commArray = new Array();
				commArray = getCommissionerInfo("commUL");
				strArr.push({name: "cmmList", value: commArray});
				
				var consultingArray = new Array();
				consultingArray = getUlList("consultingUL");
				strArr.push({name: "consultingNoList", value: consultingArray});

				var data = JSON.stringify(objectifyForm(strArr));
		  		
				console.log(data);
				
				
				$.ajax({
					  type: 'POST',
					  url: "/admsys/orgculturedigmng/picdigmng_registration.html",
					  dataType: 'json',
			          contentType: 'application/json; charset=utf-8',						
					  data: data,
					  success: function(result){
						  if ( result.retStatus == "SUCCESS" ) {
							  alert("등록 하였습니다.");
							  var lastInsertNo = result.actionNO;
							  var consultingActionNo = result.consulting_action_no;
							  viewDetailPage(lastInsertNo, consultingActionNo);
						  } else {
							  alert("등록에 실패 하였습니다.");
						  }
					  },
					  error:function(){
						  alert("등록중 오류가 발생하였습니다.");  
					  }
				})
			}
		});
		
		$("#action_delete_data").click(function(){
			PopupCenter('/admsys/orgculturedigmng/orgculturedigmng_del_alram.html?mode=POP&consulting_action_no='+$("#acNO").val(),'deleteAction','600','250');
		});
		
		$("[id^=atno_]").change(function(){
			var m = "";//mergeNo
			var y = $("#atno_year").val();//접수년도
			var t = $("#atno_type").val();//분류
			var s = $("#atno_type_step").val();//단계
			
			
			var id = $(this).attr("id");
			var val = $(this).val();
			//alert("ID:"+id+"::"+$(this).val());
			
			if ( id == 'atno_type') {
				$("#atno_type_step").val("");
				if ( t == 'B' ) {
					//$("#atno_type_step").val("");
					$("#atno_type_step").show();
				} else {
					$("#atno_type_step").hide();
				}
			}
			var hypenM = "";
			if ( y !='' && t != '' ) {
				if ( t  == 'B' && s != '' ) {
					m = y+t+s;
					hypenM = y+"-"+t+"-"+s;
				} else {
					m = y+t+s;
					hypenM = y+"-"+t;
				}
			}
			
			$("#showMergeNo").text("");
			$("#showMergeNo").text(hypenM);
			$("#regAcNo").val(hypenM);
			
		});
		
   		$("#step_one").hide();
   		$("#gov_srch_pop").hide();
   		calcWishYearQ();
		
		$("#action_type_other_org_etc").change(function(){
			$("#action_type_other_org_etc_txt").val("");
			if ( $("#action_type_other_org_etc").is(":checked") ) {
				$("#action_type_other_org_etc_txt").attr("disabled", false);
			} else {
				$("#action_type_other_org_etc_txt").attr("disabled", true);
			}
		});
		
		$("#action_type_servie_rel_etc").change(function(){
			$("#action_type_servie_rel_etc_txt").val("");
			if ( $("#action_type_servie_rel_etc").is(":checked") ) {
				$("#action_type_servie_rel_etc_txt").attr("disabled", false);
			} else {
				$("#action_type_servie_rel_etc_txt").attr("disabled", true);
			}
		});
		
		$("#action_type_etc").change(function(){
			$("#action_type_etc_txt").val("");
			if ( $("#action_type_etc").is(":checked") ) {
				$("#action_type_etc_txt").attr("disabled", false);
			} else {
				$("#action_type_etc_txt").attr("disabled", true);
			}
		});

		$("input[name='client_victim_rel_type']:radio").change(function(){
			$("#client_victim_rel_type_etc").val("");
			if (  $('input[name=client_victim_rel_type]:checked').val() == 'etc'  ) {
				$("#client_victim_rel_type_etc").attr("disabled", false);
			} else {
				$("#client_victim_rel_type_etc").attr("disabled", true);
			}
		});
		
		$("input[name='org_accident_step']:radio").change(function(){
			$("#org_accident_step_etc").val("");
			if (  $('input[name=org_accident_step]:checked').val() == 'etc'  ) {
				$("#org_accident_step_etc").attr("disabled", false);
			} else {
				$("#org_accident_step_etc").attr("disabled", true);
			}
		});
		
		$("input[name='action_type_cont']:radio").change(function(){
			$("#action_contents").val("");
			if ( $('input[name=action_type_cont]:checked').val() == 'etc'  ) {
				$("#action_contents").attr("disabled", false);
				$("#action_type_cont_etc_txt").attr("disabled", true);
			} else if ( $('input[name=action_type_cont]:checked').val() == 'act'  ) {
				$("#action_contents").attr("disabled", true);
				$("#action_type_cont_etc_txt").attr("disabled", false);
			} else {
				$("#action_contents").attr("disabled", true);
				$("#action_type_cont_etc_txt").attr("disabled", true);
			}
		});
		

    	$("#acc_1").click(function(){
			acc1_2OnOff(1);
    	});
    	
    	$("#acc_2").click(function(){
    		acc1_2OnOff(2);
    	});
		
    	$("[id^=first_org_type_]").click(function(){
			acc1_2OnOff(1);
    	});
    	
    	$("[id^=dup_org_type_]").click(function(){
    		acc1_2OnOff(2);
    	});
    	
		$("input[name='org_type']").change(function(){
			if ( $("input[name='org_type']:checked").val()=='gov' ) {
				$("#org_type_detail").show();
			} else {
				$("#org_type_detail").hide();
				$("[id^=org_type_gov_detail_]").attr('checked', false);
			}
		});

	});

	function objectifyForm(formArray) {//serializeArray data function 
		var returnArray = {};
	
		for (var i = 0; i < formArray.length; i++) { 
			returnArray[formArray[i]['name']] = formArray[i]['value']; 
		} 
		return returnArray; 
	}

	function elementsDisabled(disabled) {
		if ( disabled == false ) {
			$('#contents input').attr('disabled', 'disabled');
			$('#contents select').attr('disabled', 'disabled');
			$('#contents textarea').attr('disabled', 'disabled');
			$("a[id^=aa_]").hide();
			$("a[id^=cc_]").hide();
			$("#actionUploadBtn").hide();
			$("#searchPressSrchListPop").hide();
			$("a[id^=mm_]").hide();
			$("#searchCommissionerListPop").hide();
			$("[id^=cm_]").hide();
			$("#consult_reg_btn").hide();
			$("[id^=dd_]").hide();
		} else if ( disabled == true ) {
			$('#contents input').removeAttr('disabled');
			$('#contents select').removeAttr('disabled');
			$('#contents textarea').removeAttr('disabled');
			$("a[id^=aa_]").show();
			$("a[id^=cc_]").show();
			$("#actionUploadBtn").show();
			$("a[id^=mm_]").show();
			$("#searchCommissionerListPop").show();
			$("a[id^=cm_]").show();
			$("[id^=cm_]").show();
			$("#consult_reg_btn").show();
			$("[id^=dd_]").show();
			//
			// 예외 항목
			$("#action_type_other_org_etc_txt").attr("disabled", true);
			$("#action_type_servie_rel_etc_txt").attr("disabled", true);
			$("#action_type_etc_txt").attr("disabled", true);
			
			$("#client_victim_rel_type_etc").attr("disabled", true);
			$("#org_accident_step_etc").attr("disabled", true);
			$("#action_contents").attr("disabled", true);
			
			$("#action_type_cont_etc_txt").attr("disabled", true);
		}
	}
	
    function deleteAction(reason){
		var str = $('#AppActionMergeVo').serialize();
		
		var delList = new Array();
		delList.push($("#actionNO").val());
		
		$.ajax({
			  type: 'POST',
			  url: "/admsys/orgculturedigmng/picdigmng_req_delete.html",
			  data: str + "&delList="+delList + "&delete_reason="+reason,
			  success: function(result){
				  if ( result.retStatus == "SUCCESS" ) {
					  alert("${consulting_action_no}\n조치일지 삭제가 완료 되었습니다.");
					  location.reload();
				  } else {
					  alert("삭제에 실패 하였습니다.");
				  }
			  },
			  error:function(){
				  alert("삭제중 오류가 발생하였습니다.");  
			  }
		})
    }
	
    function attach() {
        $("#upload").trigger('click');
        return false;
    }
    
    function pickup(no) {
        document.location = "/admsys/commonFile/download.html?no=" + encodeURIComponent(no);
        return false;
    }

    function detach(no, name) {
        alertify.confirm(name + ' 파일을 삭제 하시겠습니까?', function (e) {
            if (e) {
                $.get("/admsys/commonFile/detach.html?no=" + no, function (result) {
                    if (result) {
                    	$("#fileListUL #ulliFile_"+no).remove();
                    }
                });
            }
        });
        return false;
    }
    
    function appendFileInfo(name, no) {
    	$("#fileListUL").append('<li data-no="'+no+'" data-type="new" id="ulliFile_'+no+'">'+name+
				'<a id="bb_'+no+'" class="btmore01" href="#" onclick="javascript:pickup('+no+');return false;">받기</a>'+
				'<a id="cc_'+no+'" class="btmore01" href="#" onclick="javascript:detach('+no+',\''+name+'\');return false;">삭제</a>'+
				'</li>');
    }
    
    function getUL_li_no(ulId){
		var ulArray = new Array();
		var ulLen = $("#"+ulId+" li").length;
		for( var i = 0; i < ulLen; i++ ) {	
			var liNo = $("#"+ulId+" li:eq("+i+")").data("no");
			
			if ( ulId == 'fileListUL' ) {
				var liType = $("#"+ulId+" li:eq("+i+")").data("type");
				if ( liType == "new" ) {
					ulArray.push(liNo);
				}
			} else {
				ulArray.push(liNo);
			}
			
		}
		return ulArray;
    }
    
	var g_i = 1;
	function addPress(objList) {
		var ulLen = $("#pressTrList tr").length;

		if( ulLen == 0 ) {
			g_i  = 1;
			for( var i=0;i < objList.length; i++ ) {
				$("#pressTrList").append(
						'<tr data-no="'+objList[i].no+'" id="tr_'+objList[i].no+'">'
					+		'<td style="width:5%; text-align: center;" id="nseq_'+objList[i].no+'">'+g_i+'</td>'
					+		'<td style="width:40%">'+objList[i].an + '</td>'
					+		'<td style="width:10%">'+objList[i].u+'</td>'	
					+		'<td style="width:15%">'+objList[i].c+'</td>'
					+		'<td style="width:15%; text-align: center;"><a id="av_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:pressViewPop('+objList[i].no+');return false;">View</a></td>'
					+		'<td style="width:15%; text-align: center;"><a id="aa_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delPressList('+objList[i].no+');return false;">X</a></td>'
					+	'</tr>'
				);
				g_i++;	
			}
		} else {
			var tableArray = new Array();
			for( var i = 0; i < ulLen; i++ ) {	
				var liNo = $("#pressTrList tr:eq("+i+")").data("no");
				tableArray.push(liNo);
			}
			for( var i=0;i < objList.length; i++ ) {				
				var wNo = objList[i].no;
				var exists = true;
				for( var j=0; j < tableArray.length; j++){
					if ( wNo == tableArray[j] ) {
						exists = false;
						break;
					}
				}

				if ( exists ) {
					$("#pressTrList").append(
							'<tr data-no="'+objList[i].no+'" id="tr_'+objList[i].no+'">'
						+		'<td style="width:5%; text-align: center;" id="nseq_'+objList[i].no+'">'+g_i+'</td>'
						+		'<td style="width:40%">'+objList[i].an + '</td>'
						+		'<td style="width:10%">'+objList[i].u+'</td>'	
						+		'<td style="width:15%">'+objList[i].c+'</td>'
						+		'<td style="width:15%; text-align: center;"><a id="av_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:pressViewPop('+objList[i].no+');return false;">View</a></td>'
						+		'<td style="width:15%; text-align: center;"><a id="aa_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delPressList('+objList[i].no+');return false;">X</a></td>'
						+	'</tr>'
					);
				}
				reNumberSeq();
			}
		}
	}
	
	function delPressList(no) {
		$("#pressTrList #tr_"+no).remove();
		reNumberSeq();
	}
	
	function reNumberSeq(){
		var tL = $("#pressTrList tr").length;
		
		if ( tL > 0 ) {
			for ( var k = 0; k < tL; k++ ) {
				$("#pressTrList tr:eq("+k+") td:eq(0)").text(k+1);
			}
		}
	}

    function getTable_tr_no(tableId){
		var ulArray = new Array();
		var ulLen = $("#"+ulId+" li").length;
		for( var i = 0; i < ulLen; i++ ) {	
			var liNo = $("#"+ulId+" li:eq("+i+")").data("no");
			
			if ( ulId == 'fileListUL' ) {
				var liType = $("#"+ulId+" li:eq("+i+")").data("type");
				if ( liType == "new" ) {
					ulArray.push(liNo);
				}
			} else {
				ulArray.push(liNo);
			}
		}

		return ulArray;
    }
    
	// 등록일 시계
	function clockStart() {
		var today = new Date();
		var dayList = ['sunday', 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday'];
		var hh = addZero(today.getHours());
		var mm = addZero(today.getMinutes());
		var ss = addZero(today.getSeconds());
		var YY = today.getFullYear();
		var MM = addZero(today.getMonth()+1);
		var DD = addZero(today.getDate());
		
		document.getElementById('hours').innerText = hh;
		document.getElementById('min').innerText = mm;
		document.getElementById('sec').innerText = ss;
		document.getElementById('month').innerText = MM;
		document.getElementById('date').innerText = DD;
		document.getElementById('year').innerText = YY;

		function addZero(num) {
			return (num < 10 ? '0'+num : ''+num)
		}
	}

	
	function addManager() {
		var selVal = $("#managerListSel option:selected").val();//checked		
		var selTxt = $("#managerListSel option:selected").text();
		
		if(selVal == 0){
			return;
		}
		
		var ulLen = $("#managerListUL li").length;
		if( ulLen == 0 ) {			
			$("#managerListUL").append('<li data-no="'+selVal+'" data-type="new" id="mulli_'+selVal+'">'+selTxt
					+'<a id="mm_'+selVal+'" class="btmore01" href="#" onclick="javascript:delManagerList(\''+selVal+'\');return false;">X</a></li>');
			
		} else {
			var ulArray = new Array();
			for( var i = 0; i < ulLen; i++ ) {	
				var liNo = $("#managerListUL li:eq("+i+")").data("no");
				ulArray.push(liNo);
			}
							
			var wNo = selVal;
			var exists = true;
			for( var j=0; j < ulArray.length; j++){
				if ( wNo == ulArray[j] ) {
					exists = false;
					break;
				}
			}

			if ( exists ) {
				$("#managerListUL").append('<li data-no="'+selVal+'" data-type="new" id="mulli_'+selVal+'">'+selTxt
						+'<a id="mm_'+selVal+'" class="btmore01" href="#" onclick="javascript:delManagerList(\''+selVal+'\');return false;">X</a></li>');
			}
		}
	}
	
	function delManagerList(no) {
		no = no.replace(" ","");
		$("#managerListUL #mulli_"+no).remove();
	}
	
    function getUlList(ulid){
		var ulArray = new Array();
		var ulLen = $("#"+ulid+" li").length;
		for( var i = 0; i < ulLen; i++ ) {	
			var liNo = $("#"+ulid+" li:eq("+i+")").data("no");
			
			ulArray.push(liNo);
		}
		return ulArray;
    }
    
	$("#searchCommissionerListPop").click(function(){
		PopupCenter('/admsys/orgculturedigmng/commmngPop.html?mode=POP','deleteAction','1000','625');
	});

	function addComm(objList) {
		var ulLen = $("#commUL li").length;
		if( ulLen == 0 ) {
			for( var i=0;i < objList.length; i++ ) {
				$("#commUL").append('<li data-no="'+objList[i].no+'" id="cmulli_'+objList[i].no+'">'+objList[i].name
						+ '<a id="cv_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:commView('+objList[i].no+');return false;">View</a>'
						+ '<a id="cm_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delCommList('+objList[i].no+');return false;">X</a><br>'
						+ '<input type="date" id="cm_from'+objList[i].no+'" name="cm_from'+objList[i].no+'" value="" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">'
						+ '<input type="date" id="cm_to'+objList[i].no+'" name="cm_to'+objList[i].no+'" value="" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">'
						+ '</li>');
			}
		} else {
			var ulArray = new Array();
			for( var i = 0; i < ulLen; i++ ) {	
				var liNo = $("#commUL li:eq("+i+")").data("no");
				ulArray.push(liNo);
			}
			for( var i=0;i < objList.length; i++ ) {				
				var wNo = objList[i].no;
				var exists = true;
				for( var j=0; j < ulArray.length; j++){
					if ( wNo == ulArray[j] ) {
						exists = false;
						break;
					}
				}

				if ( exists ) {
					$("#commUL").append('<li data-no="'+objList[i].no+'" id="cmulli_'+objList[i].no+'">'+objList[i].name
							+ '<a id="cv_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:commView('+objList[i].no+');return false;">View</a>'
							+ '<a id="cm_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delCommList('+objList[i].no+');return false;">X</a><br>'
							+ '<input type="date" id="cm_from'+objList[i].no+'" name="cm_from'+objList[i].no+'" value="" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">'
							+ '<input type="date" id="cm_to'+objList[i].no+'" name="cm_to'+objList[i].no+'" value="" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">'

							//+ '<input style="width:100px;" id="cm_from'+objList[i].no+'" name="cm_from'+objList[i].no+'" class="Wdate" type="text" onFocus="WdatePicker()" value=""/>'
							//+ '<input style="width:100px;" id="cm_to'+objList[i].no+'"	name="cm_to'+objList[i].no+'"	class="Wdate" type="text" onFocus="WdatePicker()" value=""/>'
							+ '</li>');
				}					
			}
		}
	}
	
	function delCommList(no) {
		$("#commUL #cmulli_"+no).remove();
	}
	
    function getCommissionerInfo(ulid){
		var ulArray = new Array();
		var ulLen = $("#"+ulid+" li").length;
		for( var i = 0; i < ulLen; i++ ) {	
			var liNo = $("#"+ulid+" li:eq("+i+")").data("no");
			var cmFrom = $("#cm_from"+liNo).val();
			var cmTo =$("#cm_to"+liNo).val();
			//var liType = $("#"+ulid+" li:eq("+i+")").data("type");

			var consulting_action_no = $("#consulting_action_no").val();
			var obj = new Object();
			obj.consulting_action_no = consulting_action_no;
			obj.counselNum = liNo;
			obj.ac_com_date_from = cmFrom;
			obj.ac_com_date_to = cmTo;
			
			//dataList.push(obj);
			
			//if ( liType == "new" ) {
				ulArray.push(obj);
			//}			
		}
		return ulArray;
    }
    
	$("#consult_reg_btn").click(function(){
		PopupCenter('/admsys/consultingmng/consulting.html?mode=POP','popupSearchCAList','1000','700');	
	});
	
	function addConsulting(objList) {
		var ulLen = $("#consultingUL li").length;
		if( ulLen == 0 ) {
			for( var i=0;i < objList.length; i++ ) {
				$("#consultingUL").append('<li data-no="'+objList[i].no+'" id="culli_'+objList[i].no+'">'+objList[i].an
						+ '<a id="dv_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:conView('+objList[i].no+');return false;">View</a>'
						+ '<a id="dd_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delConsultingList('+objList[i].no+');return false;">X</a></li>');
			}
		} else {
			var ulArray = new Array();
			for( var i = 0; i < ulLen; i++ ) {	
				var liNo = $("#consultingUL li:eq("+i+")").data("no");
				ulArray.push(liNo);
			}
			for( var i=0;i < objList.length; i++ ) {				
				var wNo = objList[i].no;  
				var exists = true;
				for( var j=0; j < ulArray.length; j++){
					if ( wNo == ulArray[j] ) {
						exists = false;
						break;
					}
				}

				if ( exists ) {
					$("#consultingUL").append('<li data-no="'+objList[i].no+'" id="culli_'+objList[i].no+'">'+objList[i].an
							+ '<a id="dv_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:conView('+objList[i].no+');return false;">View</a> '
							+ '<a id="dd_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delConsultingList('+objList[i].no+');return false;">X</a></li>');
				}					
			}
		}
	}

	function delConsultingList(no) {
		$("#consultingUL #culli_"+no).remove();
	}
	
	function calcWishYearQ(){
		var date = new Date();
		
		date.setMonth(date.getMonth()+1);
		var one = ("0" + (1 + date.getMonth())).slice(-2);
		var tyear = date.getFullYear()+"";
		var ttext = tyear .substring(2)+"년 1분기";
		$("#w1ym").text(ttext);
		ttext = tyear .substring(2)+"년 2분기";
		$("#w2ym").text(ttext);
		ttext = tyear .substring(2)+"년 3분기";
		$("#w3ym").text(ttext);
		ttext = tyear .substring(2)+"년 4분기";
		$("#w4ym").text(ttext);

		$("#wish_consulting_date_1").val(tyear+"1");
		$("#wish_consulting_date_2").val(tyear+"2");
		$("#wish_consulting_date_3").val(tyear+"3");
		$("#wish_consulting_date_4").val(tyear+"4");

		
	}
	
	function calcWishYear(){
		var date = new Date();
		
		date.setMonth(date.getMonth()+1);
		var one = ("0" + (1 + date.getMonth())).slice(-2);
		var oney = date.getFullYear()+"";
		var onet = oney.substring(2)+"년 "+one+"월";
		$("#wish_consulting_date_1").val(oney+one);
		$("#w1ym").text(onet);
		
		date.setMonth(date.getMonth()+1);
		var two = ("0" + (1 + date.getMonth())).slice(-2);
		var twoy = date.getFullYear()+"";
		var twot = twoy.substring(2)+"년 "+two+"월";
		$("#wish_consulting_date_2").val(twoy+two);
		$("#w2ym").text(twot);
		
		date.setMonth(date.getMonth()+1);
		var three = ("0" + (1 + date.getMonth())).slice(-2);
		var threey = date.getFullYear()+"";
		var threet = threey.substring(2)+"년 "+three+"월";
		$("#wish_consulting_date_3").val(threey+three);
		$("#w3ym").text(threet);
		
		date.setMonth(date.getMonth()+1);
		var four = ("0" + (1 + date.getMonth())).slice(-2);
		var foury = date.getFullYear()+"";
		var fourt = foury.substring(2)+"년 "+four+"월";
		$("#wish_consulting_date_4").val(foury+four);
		$("#w4ym").text(fourt);
		
		date.setMonth(date.getMonth()+1);
		var five = ("0" + (1 + date.getMonth())).slice(-2);
		var fivey = date.getFullYear()+"";
		var fivet = fivey.substring(2)+"년 "+five+"월";
		$("#wish_consulting_date_5").val(fivey+five);
		$("#w5ym").text(fivet);
	}
	
	function openGovSrchPop(arg1){
		PopupCenter('/admsys/orgculturedigmng/govSearchPop.html?mode=POP&g_type='+arg1, 'popupSearchGovList','500','700');
	}
	
	function setGovInfo(code, name, g_type){
		if ( g_type == 'gov') {
			$("#org_name").val(name);
			$("#org_code").val(code);
		} else if ( g_type == 'upper') {
			$("#upper_org_name").val(name);
			$("#upper_org_code").val(code);
		} 
	}
	
	function validationData(){
		if ( $("#regAcNo").val() == '' ) {
			$("#regAcNo").focus();
			alert("사건번호를 생성하여 주세요.");			
		}
	}
	
	function acc1_2OnOff(arg1){
		
		if ( arg1 == '1' ) {
			$("[id^=first_org_type_][type=checkbox]").attr("disabled", false);
			$("#first_org_type_etc_txt").attr("disabled", false);
			
			$("[id^=dup_org_type_][type=checkbox]").prop("checked", false);
    		$("[id^=dup_org_type_][type=checkbox]").attr("disabled", true);
    		
    		$("#dup_org_type_etc_txt").val("");
    		$("#dup_org_type_etc_txt").attr("disabled", true);
    		
    		$("#acc1td").css("background-color", "");
    		$("#acc2td").css("background-color", "#DCDCDC");
    		
		} else if ( arg1 == '2' ) {
			$("[id^=dup_org_type_][type=checkbox]").attr("disabled", false);
			$("#dup_org_type_etc_txt").attr("disabled", false);
			
			$("[id^=first_org_type_][type=checkbox]").prop("checked", false);
    		$("[id^=first_org_type_][type=checkbox]").attr("disabled", true);
    		
    		$("#first_org_type_etc_txt").val("");
    		$("#first_org_type_etc_txt").attr("disabled", true);
    		
    		$("#acc1td").css("background-color", "#DCDCDC");
    		$("#acc2td").css("background-color", "");
		}
		
	}
	
	function conView(no) {
		PopupCenter('/admsys/consultingmng/consulting_view_pop.html?NO='+no, 'conView','1000','700');
	}
	
	function pressViewPop(no) {
		PopupCenter('/admsys/administration/press_view_pop.html?NO='+no, 'pressViewPop','500','400');
	}
	
	function commView(counselNum) {
		PopupCenter('/admsys/orgculturedigmng/commmngPop.html?mode=POP&cn='+counselNum,'commView','1000','425');
		//PopupCenter('/admsys/administration/press_view_pop.html?NO='+no, 'commView','500','400');	
	}
	
	function validationCheck(){
		if ( $('input[name=client_victim_rel_type]:checked').val() == 'etc' && $("#client_victim_rel_type_etc").val() == '' ) {
			alert("의뢰인 기타 항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#client_victim_rel_type_etc").focus();
			return false;
		}
		

		if ( $('input[name=org_accident_step]:checked').val() == 'etc' && $("#org_accident_step_etc").val() == '' ) {
			alert("기관 내 진행 단계의 기타 항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#org_accident_step_etc").focus();
			return false;
		}
		
		
		if ( $("#action_type_other_org_etc").is(':checked') && $("#action_type_other_org_etc_txt").val() == '' ) {
			alert("조치(복수선택)의 타 신고기관 안내의 그외항목이 선택되어 있을때는\n 그외내용을 입력해 주시기 바랍니다.");
			$("#action_type_other_org_etc_txt").focus();
			return false;
		}

		if ( $("#action_type_servie_rel_etc").is(':checked') && $("#action_type_servie_rel_etc_txt").val() == '' ) {
			alert("조치(복수선택)의 서비스 연계/지원의 그외항목이 선택되어 있을때는\n 그외내용을 입력해 주시기 바랍니다.");
			$("#action_type_servie_rel_etc_txt").focus();
			return false;
		}

		if ( $("#action_type_etc").is(':checked') && $("#action_type_etc_txt").val() == '' ) {
			alert("조치(복수선택)의 기타항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#action_type_etc_txt").focus();
			return false;
		}
		
		if ( $('input[name="action_type_cont"]:checked').val() == 'etc' && $("#action_contents").val() == '' ) {
			alert("조치내용 기타 항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#action_contents").focus();
			return false;
		}
		
		if ( $('input[name="action_type_cont"]:checked').val() == 'act' && $("#action_type_cont_etc_txt").val() == '' ) {
			alert("조치내용 기관조치 항목이 선택되어 있을때는\n 내용을 입력해 주시기 바랍니다.");
			$("#action_type_cont_etc_txt").focus();
			return false;
		}

		return true;
	}
	
	function viewDetailPageFromDetail(NO, consulting_action_no, fromDetailYN){
		$("#content").load("/admsys/orgculturedigmng/picdigmng_view.html", {'actionNO':NO,'consulting_action_no':consulting_action_no, 'fromDetailYN':fromDetailYN} );  
	}

	function setSelectYear(target, toYear, addAllYn){
		var yyyy = new Date().getFullYear();
		
		$('#'+target).children('option').remove();

		if ( addAllYn ) {
			var option = $("<option value=''>접수년도 선택</option>");
            $('#'+target).append(option);
		}

		for( var j=yyyy ; j>=toYear ; j-- ){
			var option = $("<option value='"+j+"'>"+j+"</option>");
            $('#'+target).append(option);
		}

		$('#'+target).val($('#'+target+" option:first").val());
		
	}
	
	function validationF(){
		
		var numberText = $("#numberText").val();
		var atno_type = $("#atno_type").val();
		var atno_year = $("#atno_year").val();
		
		/* 검증 스크립트 */
		if(true){}
		
		
		var validationData  = atno_year+"-"+atno_type+"-"+numberText;
		
		console.log(validationData);
		
		$("#regAcNo").val(validationData);
		//CHECK 
		console.log($("#regAcNo").val());
		
		$.ajax({ 
			 type: 'post' 
			, url: '/admsys/orgculturedigmng/validation.html' 
			, data: "validationData="+validationData
			, success: function(data) {	
				
				console.log(data.code);
				console.log(data);
				
				if(data.code == "success"){
					
					alert("중복된 데이터가 아니므로 등록하셔도 됩니다.");
					return;
					
				}else{
					
					alert("중복된 데이터입니다.");
					return;
					
				}
				
				
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'+err); 
			}
		});
		
		
		
	}
</script>