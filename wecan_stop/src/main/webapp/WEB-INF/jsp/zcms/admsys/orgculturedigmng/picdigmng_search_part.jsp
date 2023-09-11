<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>
	function showHideDetailSearch(tv){
		$("#detailSrchBtn").prop("value", tv.value == "상세검색조건 닫기" ? "상세검색조건 보기" : "상세검색조건 닫기");
		$("#detailSearchCondition").toggle();
	}
</script>
<style>
.table-search-condition td{padding: 5px 3px}
</style>
<!-- 기본 검색-->
<table style="width:100%" class="table-search-condition">
	<tr>
		<td>등록번호</td>
		<td><input type="text" id="consulting_action_no_search" name="consulting_action_no_search" value="${data.consulting_action_no_search}"></td>
		<td>진단분류(A/B/C/D)</td>
		<td>								
			<select id="action_no_type" name="action_no_type">
				<option value="">구분 선택</option>
				<option value="A" <c:if test="${data.action_no_type eq 'A'}">selected</c:if>>여성가족부신고사건(A)</option>
				<option value="B" <c:if test="${data.action_no_type eq 'B'}">selected</c:if>>기관신청건(B)</option>
				<option value="C" <c:if test="${data.action_no_type eq 'C'}">selected</c:if>>타부처이관건(C)</option>
				<option value="D" <c:if test="${data.action_no_type eq 'D'}">selected</c:if>>현장점검(D)</option>
			</select>
		</td>
		<td>진단기관명</td>
		<td><input type="text" id="org_name" name="org_name" value="${data.org_name}"></td>
		<td>위원명</td>
		<td><input type="text" id="counselName" name="counselName" value=""></td>
		<td>상담일</td>
		<td><input type="date" id="registration_date" name="registration_date" value="${data.registration_date}" min="2019-01-01" max="2030-12-31" placeholder="년/월/일"></td>
	</tr>
	<tr>
		<td>일정 지정</td>
		<td>
			시작일:<input type="date" id="action_consulting_date_from" name="action_consulting_date_from" value="${data.action_consulting_date_from}" min="2019-01-01" max="2030-12-31" placeholder="년/월/일">
			종료일:<input type="date" id="action_consulting_date_to" name="action_consulting_date_to" value="${data.action_consulting_date_to}" min="2019-01-01" max="2030-12-31" placeholder="년/월/일">
		</td>
		
		<!--등록일 조회창-->
	    <td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;등록일</td>
		<td>
			시작일:<input type="date" id="action_register_date_from" name="action_register_date_from" value="" min="2019-01-01" max="2030-12-31" placeholder="년/월/일">
			종료일:<input type="date" id="action_register_date_to" name="action_register_date_to" value="" min="2019-01-01" max="2030-12-31" placeholder="년/월/일">
		</td>
		
		<td>진단진행현황</td>
		<td>
			<select id="step_status" name="step_status">
				<option value="">선택</option>
				<option value="1" <c:if test='${data.step_status eq "1"}'>selected</c:if>>신청</option>
				<option value="2" <c:if test='${data.step_status eq "2"}'>selected</c:if>>접수대기</option>
				<option value="3" <c:if test='${data.step_status eq "3"}'>selected</c:if>>접수승인</option>
				<option value="4" <c:if test='${data.step_status eq "4"}'>selected</c:if>>접수불가</option>
				<option value="5" <c:if test='${data.step_status eq "5"}'>selected</c:if>>심사대기</option>
				<option value="6" <c:if test='${data.step_status eq "6"}'>selected</c:if>>심사거절</option>
				<option value="7" <c:if test='${data.step_status eq "7"}'>selected</c:if>>심사승인</option>
				<option value="8" <c:if test='${data.step_status eq "8"}'>selected</c:if>>컨설팅완료</option>
			</select>
		</td><!-- 4 -->
		<c:choose>
			<c:when test="${data.bbsType eq 'A'}">
				<td>담당관</td>
				<td colspan="4"><input type="text" id="manager_name" name="manager_name" value="${data.manager_name}"></td>
			</c:when>
			<c:otherwise>
				<td colspan="5"></td>			
			</c:otherwise>
		</c:choose>
		<td style="text-align: right;">
			<input class="bt01" type="button" value="상세검색조건 보기" id="detailSrchBtn" onclick="showHideDetailSearch(this)" />
			<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
		</td>
	</tr>
</table>
<!-- 상세 검색 -->
<table id="detailSearchCondition" class="table-search-condition" style="display:none;">
	<tr>
		<td>상담분류</td>
		<td>
			<select id="action_consulting_type" name="action_consulting_type">
				<option value="">선택</option>
				<option value="init" <c:if test="${data.action_consulting_type eq 'init'}">selected</c:if>>초기상담</option>
				<option value="continuing" <c:if test="${data.action_consulting_type eq 'continuing'}">selected</c:if>>지속상담</option>
				<option value="ending" <c:if test="${data.action_consulting_type eq 'ending'}">selected</c:if>>종결상담</option>
				<option value="monitoring1" <c:if test="${data.action_consulting_type eq 'monitoring1'}">selected</c:if>>모니터링(1차)</option>
				<option value="monitoring2" <c:if test="${data.action_consulting_type eq 'monitoring2'}">selected</c:if>>모니터링(2차)</option>
			</select>
		</td>
		<td>경로</td>
		<td>
			<select id="action_received_type" name="action_received_type">
				<option value="">선택</option>
				<option value="tel" <c:if test="${data.action_received_type eq 'tel'}">selected</c:if>>전화</option>
				<option value="email" <c:if test="${data.action_received_type eq 'email'}">selected</c:if>>메일</option>
				<option value="sms" <c:if test="${data.action_received_type eq 'sms'}">selected</c:if>>문자</option>
				<option value="etc" <c:if test="${data.action_received_type eq 'etc'}">selected</c:if>>기타</option>
            </select>
		</td>
		<td>연락처</td>
        <td><input type="text" id="contact_tel_no" name="contact_tel_no" value="${data.contact_tel_no}"></td>
		<td>이메일</td>
		<td><input type="text" id="contact_email" name="contact_email" value="${data.contact_email}"></td>
		<td>의뢰인 이름</td>
		<td><input type="text" id="client_name" name="client_name" value="${data.client_name}">
        </td>
   	</tr>
   	<tr>
        <td>의뢰인 성별</td>
        <td>
          	<select id="client_gender" name="client_gender">
               	<option value="">선택</option>
               	<option value="female" <c:if test="${data.client_gender eq 'female'}">selected</c:if>>여성</option>
				<option value="male" <c:if test="${data.client_gender eq 'male'}">selected</c:if>>남성</option>
				<option value="unknown" <c:if test="${data.client_gender eq 'unknown'}">selected</c:if>>미상</option>
			</select>
		</td>
		<td>의뢰인 소속</td>
		<td><input type="text" id="client_belong" name="client_belong" value="${data.client_belong}"></td>
		<td>의뢰인 피해자와의 관계</td>
		<td><select id="client_victim_rel_type" name="client_victim_rel_type">
				<option value="">선택</option>
				<option value="me" <c:if test="${data.client_victim_rel_type eq 'me'}">selected</c:if>>본인</option>
				<option value="agent" <c:if test="${data.client_victim_rel_type eq 'agent'}">selected</c:if>>대리인/조력자</option>
				<option value="relmanager" <c:if test="${data.client_victim_rel_type eq 'relmanager'}">selected</c:if>>관련 담당자</option>
				<option value="etc" <c:if test="${data.client_victim_rel_type eq 'etc'}">selected</c:if>>기타</option>
			</select>
			기타:<input type="text" id="client_victim_rel_type_etc" name="client_victim_rel_type_etc" value="${data.client_victim_rel_type_etc}">
        </td>
		<td>기관 내 진행 단계</td>
        <td colspan="2">
        	<select id="org_accident_step" name="org_accident_step">
				<option value="">선택</option>
                <option value="before_declaration" <c:if test="${data.org_accident_step eq 'before_declaration'}">selected</c:if>>신고전</option>
				<option value="after_declaration" <c:if test="${data.org_accident_step eq 'after_declaration'}">selected</c:if>>신고 접수/상담</option>
				<option value="investigation" <c:if test="${data.org_accident_step eq 'investigation'}">selected</c:if>>조사</option>
				<option value="review" <c:if test="${data.org_accident_step eq 'review'}">selected</c:if>>심의</option>
				<option value="punishment" <c:if test="${data.org_accident_step eq 'punishment'}">selected</c:if>>징계</option>
				<option value="followup" <c:if test="${data.org_accident_step eq 'followup'}">selected</c:if>>후속조치</option>
				<option value="etc" <c:if test="${data.org_accident_step eq 'etc'}">selected</c:if>>기타</option>
				<option value="unknown" <c:if test="${data.org_accident_step eq 'unknown'}">selected</c:if>>미파악</option>
			</select><br>
			미파악:<input type="text" id="org_accident_step_etc" name="org_accident_step_etc" value="${data.org_accident_step_etc}">
 		</td>
	</tr>
	<tr>
		<td>조치(복수선택)</td>
		<td colspan="9">
			<input type="checkbox" id="action_type_monitoring" name="action_type_monitoring" value="Y" <c:if test="${data.action_type_monitoring eq 'Y'}">checked</c:if>>진행상황 모니터링
			<input type="checkbox" id="action_type_info" name="action_type_info" value="Y" <c:if test="${data.action_type_info eq 'Y'}">checked</c:if>>절차 안내 및 정보 제공
			<input type="checkbox" id="action_type_req_listening" name="action_type_req_listening" value="Y" <c:if test="${data.action_type_req_listening eq 'Y'}">checked</c:if>>추가정보 및 요구사항 청취
			<input type="checkbox" id="action_type_other_org_info" name="action_type_other_org_info" value="Y" <c:if test="${data.action_type_other_org_info eq 'Y'}">checked</c:if>>타 신고기관 안내
			(<input type="checkbox" id="action_type_other_org_min" name="action_type_other_org_min" value="Y" <c:if test="${data.action_type_other_org_min eq 'Y'}">checked</c:if>>고용노동부
			<input type="checkbox" id="action_type_other_org_civil_criminal" name="action_type_other_org_civil_criminal" value="Y" <c:if test="${data.action_type_other_org_civil_criminal eq 'Y'}">checked</c:if>>민/형사
			<input type="checkbox" id="action_type_other_org_rights" name="action_type_other_org_rights" value="Y" <c:if test="${data.action_type_other_org_rights eq 'Y'}">checked</c:if>>국가인권위원회
			<input type="checkbox" id="action_type_other_org_etc" name="action_type_other_org_etc" value="Y" <c:if test="${data.action_type_other_org_etc eq 'Y'}">checked</c:if>>그외
			<input type="text" id="action_type_other_org_etc_txt" name="action_type_other_org_etc_txt" value="${data.action_type_other_org_etc_txt}">)
			<input type="checkbox" id="action_type_servie_rel" name="action_type_servie_rel" value="Y" <c:if test="${data.action_type_servie_rel eq 'Y'}">checked</c:if>>서비스 연계/지원
			(<input type="checkbox" id="action_type_servie_rel_consulting" name="action_type_servie_rel_consulting" value="Y" <c:if test="${data.action_type_servie_rel_consulting eq 'Y'}">checked</c:if>>상담
			<input type="checkbox" id="action_type_servie_rel_law_min" name="action_type_servie_rel_law_min" value="Y" <c:if test="${data.action_type_servie_rel_law_min eq 'Y'}">checked</c:if>>법률/노무
			<input type="checkbox" id="action_type_servie_rel_medic" name="action_type_servie_rel_medic" value="Y" <c:if test="${data.action_type_servie_rel_medic eq 'Y'}">checked</c:if>>의료
			<input type="checkbox" id="action_type_servie_rel_etc" name="action_type_servie_rel_etc" value="Y" <c:if test="${data.action_type_servie_rel_etc eq 'Y'}">checked</c:if>>그외
			<input type="text" id="action_type_servie_rel_etc_txt" name="action_type_servie_rel_etc_txt" value="${data.action_type_servie_rel_etc_txt}">)
			<input type="checkbox" id="action_type_etc" name="action_type_etc" value="Y" <c:if test="${data.action_type_etc eq 'Y'}">checked</c:if>>기타
			<input type="text" id="action_type_etc_txt" name="action_type_etc_txt" value="${data.action_type_etc_txt}">
		</td>
	</tr>
	<tr>
		<td>조치내용</td>
		<td colspan="2"><input type="text" id="action_contents" name="action_contents" value="${data.action_contents}"></td>								
		<td>향후 계획</td>
		<td colspan="2"><input type="text" id="after_plan" name="after_plan" value="${data.after_plan}"></td>
		<td>비고</td>
		<td colspan="3"><input type="text" id="action_etc" name="action_etc" value="${data.action_etc}"></td>
	</tr>
	<tr>
		<td>유형</td>
		<td>		
		    <select id="org_type" name="org_type">
				<option value="">선택</option>
                <option value="gov" <c:if test="${data.org_type eq 'gov'}">selected</c:if>>공공</option>
				<option value="priv" <c:if test="${data.org_type eq 'priv'}">selected</c:if>>민간</option>
			</select>
		</td>
<%-- 		<td>기관명</td>
		<td><input type="text" id="org_name" name="org_name" placeholder="" value="${data.org_name}"></td> --%>
		<td>상급기관</td>
		<td colspan="2">
			<input type="text" id="upper_org_name" name="upper_org_name" placeholder="" value="${data.upper_org_name}">
		</td>
		<td>현원</td>
		<td><input type="number" id="org_member_count" name="org_member_count" placeholder="" value="${data.org_member_count}">명</td>
		<td>기관분류</td>
		<td>		
		    <select id="org_type_gov_detail" name="org_type_gov_detail">
				<option value="">선택</option>				
				<option value="national" <c:if test="${data.org_type_gov_detail eq 'national'}">selected</c:if>>국가기관</option>
				<option value="local"<c:if test="${data.org_type_gov_detail eq 'local'}">selected</c:if>>지방자치단체(지자체)</option>
				<option value="public" <c:if test="${data.org_type_gov_detail eq 'public'}">selected</c:if>>공공기관</option>
				<option value="school"<c:if test="${data.org_type_gov_detail eq 'school'}">selected</c:if>>각급학교</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>소속 및 직위</td>
		<td><input type="text" id="belong_job_title" name="belong_job_title" placeholder="" value="${data.belong_job_title}"></td>				
		<td>이름</td>
		<td><input type="text" id="org_client_name" name="org_client_name" placeholder="" value="${data.org_client_name}"></td>
		<td>연락처</td>
		<td><input type="text" id="org_client_tel_no" name="org_client_tel_no" placeholder="" value="${data.org_client_tel_no}"></td>				
		<td>이메일</td>
		<td colspan="2"><input type="text" id="org_client_email" name="org_client_email" placeholder="" value="${data.org_client_email}"></td>
	</tr>
	
	<tr>
		<td>사건처리이력</td>
		<td><select id="accident_response_hist" name="accident_response_hist">
				<option value="">선택</option>
				<option value="yes" <c:if test="${data.accident_response_hist eq 'yes'}">selected</c:if>>유</option>
				<option value="no" <c:if test="${data.accident_response_hist eq 'no'}">selected</c:if>>무</option>
				<option value="none" <c:if test="${data.accident_response_hist eq 'none'}">selected</c:if>>발생했으나 공식처리되지 않음</option>
			</select>
		</td>
		<td>시기(최근)</td>
		<td>	                     
			<fmt:parseDate value="${data.accident_date}" pattern="yyyy-MM-dd HH:mm:ss" var="acdt" />
			<fmt:parseDate value="${data.receipt_date}" pattern="yyyy-MM-dd HH:mm:ss" var="rcdt" />
			발생시기 <input type="date" id="accident_date" name="accident_date" value="<fmt:formatDate type="both" value="${acdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
			접수시기 <input type="date" id="receipt_date" name="receipt_date" value="<fmt:formatDate type="both" value="${rcdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
		</td>
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
			<select id="accident_step" name="accident_step">
				<option value="">선택</option>
				<option value="step1" <c:if test="${data.accident_step eq 'step1'}">selected</c:if>>인지 및 접수 (삼당)</option>
				<option value="step2" <c:if test="${data.accident_step eq 'step2'}">selected</c:if>>조사</option>
				<option value="step3" <c:if test="${data.accident_step eq 'step3'}">selected</c:if>>고충심의위원회</option>
				<option value="step4" <c:if test="${data.accident_step eq 'step4'}">selected</c:if>>종결 (후속조치)</option>
			</select>
		</td>
		<td>기타(직접입력)<span>사건 관련 특이사항 등</span></td>
		<td>
			<input type="text" id="application_etc_txt" name="application_etc_txt" placeholder="" value="${data.application_etc_txt}">
		</td>
	</tr>
	<tr>	
		<td>사건처리이력<br>없는 기관</td>
		<td colspan="4" id="acc1td">
			<input type="checkbox" id="first_org_type_all" class="num01" name="first_org_type_all" value="Y" <c:if test="${data.first_org_type_all eq 'Y'}">checked</c:if>>전수 설문조사 (조직문화 및 성희롱 성폭력 실태 파악)
			<input type="checkbox" id="first_org_type_inorg" class="num02" name="first_org_type_inorg" value="Y" <c:if test="${data.first_org_type_inorg eq 'Y'}">checked</c:if>>기관 내 성희롱ㆍ성폭력 사건처리 절차 및 제도* 자문<span>* 성희롱 방지조치, 폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span><br>
			<input type="checkbox" id="first_org_type_protect" class="num03" name="first_org_type_protect" value="Y" <c:if test="${data.first_org_type_protect eq 'Y'}">checked</c:if>>피해자 보호, 2차 피해 방지 방안 자문
			<input type="checkbox" id="first_org_type_etc" class="num05" name="first_org_type_etc" value="Y" <c:if test="${data.first_org_type_etc eq 'Y'}">checked</c:if>>기타(직접 작성)
			<input type="text" id="first_org_type_etc_txt" name="first_org_type_etc_txt" value="${data.first_org_type_etc_txt}">
		</td>
		<td>사건처리이력<br>있는 기관</td>
		<td colspan="4" id="acc2td">
			<input type="checkbox" id="dup_org_type_check" class="num01" name="dup_org_type_check" value="Y" <c:if test="${data.dup_org_type_check eq 'Y'}">checked</c:if>>기관 내 성희롱ㆍ성폭력 사건처리절차 검토 및 자문
			<input type="checkbox" id="dup_org_type_protect" class="num02" name="dup_org_type_protect" value="Y" <c:if test="${data.dup_org_type_protect eq 'Y'}">checked</c:if>>피해자 보호, 2차 피해 방지 및 재발방지대책 수립 자문
			<input type="checkbox" id="dup_org_type_all" class="num03" name="dup_org_type_all" value="Y" <c:if test="${data.dup_org_type_all eq 'Y'}">checked</c:if>>전수 설문조사 (조직문화 및 성희롱ㆍ성폭력 실태 파악)
			<input type="checkbox" id="dup_org_type_inorg" class="num03" name="dup_org_type_inorg" value="Y" <c:if test="${data.dup_org_type_inorg eq 'Y'}">checked</c:if>>기관 내 성희롱ㆍ성폭력 사건처리 제도*자문 <span>*  폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span>
			<input type="checkbox" id="dup_org_type_etc" class="num05" name="dup_org_type_etc" value="Y" <c:if test="${data.dup_org_type_etc eq 'Y'}">checked</c:if>>기타(직접 작성)
			<input type="text" id="dup_org_type_etc_txt" name="dup_org_type_etc_txt" value="${data.dup_org_type_etc_txt}">
		</td>
	</tr>
<%-- 	<tr>
		<td colspan="4" style="font-size: 16px;">컨설팅 가능 시기</td>
        <td style="width:14%">
            			<span id="w1ym">${fn:substring(data.wish_consulting_date_1,2,4)}년 ${fn:substring(data.wish_consulting_date_1,4,6)}분기</span>
			<input type="hidden" id="wish_consulting_date_1" name="wish_consulting_date_1" value="${data.wish_consulting_date_1}">
			<input type="checkbox" name="wish_consulting_date_1_yn" id="wish_consulting_date_1_yn" value="Y" <c:if test="${data.wish_consulting_date_1_yn eq 'Y'}">checked</c:if>>
			<span id="w2ym">${fn:substring(data.wish_consulting_date_2,2,4)}년 ${fn:substring(data.wish_consulting_date_2,4,6)}분기</span>
			<input type="hidden" id="wish_consulting_date_2" name="wish_consulting_date_2" value="${data.wish_consulting_date_2}">
			<input type="checkbox" name="wish_consulting_date_2_yn" id="wish_consulting_date_2_yn" value="Y" <c:if test="${data.wish_consulting_date_2_yn eq 'Y'}">checked</c:if>>
			<span id="w3ym">${fn:substring(data.wish_consulting_date_3,2,4)}년 ${fn:substring(data.wish_consulting_date_3,4,6)}분기</span> 
                     <input type="hidden" id="wish_consulting_date_3" name="wish_consulting_date_3" value="${data.wish_consulting_date_3}">
                     <input type="checkbox" name="wish_consulting_date_3_yn" id="wish_consulting_date_3_yn" value="Y" <c:if test="${data.wish_consulting_date_3_yn eq 'Y'}">checked</c:if>>
                     <span id="w4ym">${fn:substring(data.wish_consulting_date_4,2,4)}년 ${fn:substring(data.wish_consulting_date_4,4,6)}분기</span> 
                     <input type="hidden" id="wish_consulting_date_4" name="wish_consulting_date_4" value="${data.wish_consulting_date_4}">
                     <input type="checkbox" name="wish_consulting_date_4_yn" id="wish_consulting_date_4_yn" value="Y" <c:if test="${data.wish_consulting_date_4_yn eq 'Y'}">checked</c:if>>
		</td>
		<td style="width:20%"><textarea id="reference_etc" name="reference_etc" rows="3" style="width:100%;resize: none;" placeholder="기관 특성 등 사전에 참고해야 할 사항 등">${data.reference_etc}</textarea></td>
	</tr> --%>
</table>