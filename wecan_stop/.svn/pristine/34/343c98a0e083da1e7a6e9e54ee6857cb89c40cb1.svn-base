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
		<td>상담번호</td>
		<td><input type="text" id="consulting_history_no" name="consulting_history_no" value="${data.consulting_history_no}">	
		</td>
		<td>작성일</td>
		<%-- <td><input type="date" id="registration_date" name="registration_date" value="${data.registration_date}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일"></td> --%>
		<td>
			시작일:<input type="date" id="registration_date_from" name="registration_date_from" value="${data.registration_date_from}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
			종료일:<input type="date" id="registration_date_to" name="registration_date_to" value="${data.registration_date_to}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
		</td>
				

		<td>상담 시작</td>
		<td>
			시작일:<input type="date" id="registration_date_from" name="registration_date_from" value="${data.consulting_start_date_from}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
			종료일:<input type="date" id="registration_date_to" name="registration_date_to" value="${data.consulting_start_date_to}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
		</td>
		<td>상담 종료</td>
		<td>
			시작일:<input type="date" id="registration_date_from" name="registration_date_from" value="${data.consulting_end_date_from}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
			종료일:<input type="date" id="registration_date_to" name="registration_date_to" value="${data.consulting_end_date_to}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
		</td>
		<td>분류</td>
		<td><select id="consulting_type" name="consulting_type">
				<option value="">선택</option>
				<option value="public" <c:if test="${data.consulting_type eq 'public'}">selected</c:if>>공공부문</option>
				<option value="civil" <c:if test="${data.consulting_type eq 'civil'}">selected</c:if>>민간부문</option>
				<option value="personal" <c:if test="${data.consulting_type eq 'personal'}">selected</c:if>>개인간</option>
				<option value="etc" <c:if test="${data.consulting_type eq 'etc'}">selected</c:if>>기타/미파악</option>
			</select>
		</td>
<%-- 		<td>경로</td>
		<td>
			<select id="received_type" name="received_type">
				<option value="">선택</option>
				<option value="tel" <c:if test="${data.received_type eq 'tel'}">selected</c:if>>전화</option>
				<option value="mail" <c:if test="${data.received_type eq 'mail'}">selected</c:if>>우편</option>
				<option value="visit" <c:if test="${data.received_type eq 'visit'}">selected</c:if>>내방</option>
				<option value="move" <c:if test="${data.received_type eq 'move'}">selected</c:if>>이관</option>
			</select>
		</td>
		<td>의뢰인 이름</td>
		<td><input type="text" id="client_name" name="client_name" value="${data.client_name}"></td> --%>
	</tr>
	<tr>
		<td>경로</td>
		<td>
			<select id="received_type" name="received_type">
				<option value="">선택</option>
				<option value="tel" <c:if test="${data.received_type eq 'tel'}">selected</c:if>>전화</option>
				<option value="mail" <c:if test="${data.received_type eq 'mail'}">selected</c:if>>우편</option>
				<option value="visit" <c:if test="${data.received_type eq 'visit'}">selected</c:if>>내방</option>
				<option value="move" <c:if test="${data.received_type eq 'move'}">selected</c:if>>이관</option>
			</select>
		</td>
		<td>의뢰인 이름</td>
		<td><input type="text" id="client_name" name="client_name" value="${data.client_name}"></td>	
		<td>피해자 이름</td>
		<td><input type="text" id="victim_name" name="victim_name" value="${data.victim_name}"></td>
		<td>피해자 소속</td>
		<td><input type="text" id="victim_belong" name="victim_belong" value="${data.victim_belong}"></td>
		<td>연락처</td>
		<td <c:if test="${data.bbsType eq 'P'}">colspan="2"</c:if>><input type="text" id="contact_tel_no" name="contact_tel_no" value="${data.contact_tel_no}"/></td>
		<c:if test="${data.bbsType ne 'P'}">
			<td>담당관</td>
			<td><input type="text" id="manager_name" name="manager_name" value="${data.manager_name}"></td>
		</c:if>
		<td colspan="6" style="text-align: right;">
			<input class="bt01" type="button" value="상세검색조건 보기" id="detailSrchBtn" onclick="showHideDetailSearch(this)" />
			<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
		</td>
	</tr>
</table>

<!-- 상세 검색 -->
<table id="detailSearchCondition" style="display:none;" class="table-search-condition">
	<tr>
		<td>전화 구분</td>
		<td><input type="checkbox" id="tel_type" name="tel_type" value="Y" <c:if test="${data.tel_type eq 'Y'}">checked</c:if>>공공기관장 전화</td>
		<td>내용</td>
		<td>
			<select id="consulting_req_type" name="consulting_req_type">
				<option value="">선택</option>										
				<option value="relaccident" <c:if test="${data.consulting_req_type eq 'relaccident'}">selected</c:if>>사건관련</option>
				<option value="simple" <c:if test="${data.consulting_req_type eq 'simple'}">selected</c:if>>단순문의</option>
				<option value="etc" <c:if test="${data.consulting_req_type eq 'etc'}">selected</c:if>>기타</option>
			</select>
		</td>
		<td>유입경로</td>
		<td>
			<select id="contact_method_type" name="contact_method_type">
				<option value="">선택</option>
				<option value="internet" <c:if test="${data.contact_method_type eq 'internet'}">selected</c:if>>인터넷 검색</option>
				<option value="support" <c:if test="${data.contact_method_type eq 'support'}">selected</c:if>>피해자 지원기관 등</option>
				<option value="gov" <c:if test="${data.contact_method_type eq 'gov'}">selected</c:if>>여성가족부</option>
				<option value="etc" <c:if test="${data.contact_method_type eq 'etc'}">selected</c:if>>기타</option>
				<option value="unknown" <c:if test="${data.contact_method_type eq 'unknown'}">selected</c:if>>미파악</option>
			</select>
			<input type="text" id="contact_method_type_etc" name="contact_method_type_etc" value="${data.contact_method_type_etc}"/>
		</td>
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
	</tr>
	<tr>
		<td>의뢰인 피해자와의 관계</td>
		<td>
			<select id="client_victim_rel_type" name="client_victim_rel_type">
				<option value="">선택</option>
				<option value="me" <c:if test="${data.client_gender eq 'unknown'}">selected</c:if>>본인</option>
				<option value="agent" <c:if test="${data.client_gender eq 'unknown'}">selected</c:if>>대리인/조력자</option>
				<option value="relmanager" <c:if test="${data.client_gender eq 'unknown'}">selected</c:if>>관련 담당자</option>
				<option value="doer" <c:if test="${data.client_gender eq 'unknown'}">selected</c:if>>행위자등</option>
				<option value="etc" <c:if test="${data.client_gender eq 'unknown'}">selected</c:if>>기타</option>
			</select>									
			<input type="text" id="client_victim_rel_type_etc" name="client_victim_rel_type_etc" value="${data.client_victim_rel_type_etc}">
		</td>
		<td>피해자 성별</td>
		<td>
			<select id="victim_gender_type" name="victim_gender_type">
					<option value="">선택</option>
					<option value="female" <c:if test="${data.victim_gender_type eq 'female'}">selected</c:if>>여성</option>
					<option value="male" <c:if test="${data.victim_gender_type eq 'male'}">selected</c:if>>남성</option>
					<option value="unknown" <c:if test="${data.victim_gender_type eq 'unknown'}">selected</c:if>>미상</option>
					<option value="none" <c:if test="${data.victim_gender_type eq 'none'}">selected</c:if>>해당사항없음</option>
			</select>
		</td>
		<td>행위자 이름</td>
		<td><input type="text" id="offender_name" name="offender_name" value="${data.offender_name}"></td>
		<td>행위자 성별</td>
		<td>
			<select id="offender_gender_type" name="offender_gender_type">
				<option value="">선택</option>
				<option value="female" <c:if test="${data.offender_gender_type eq 'female'}">selected</c:if>>여성</option>
				<option value="male" <c:if test="${data.offender_gender_type eq 'male'}">selected</c:if>>남성</option>
				<option value="unknown" <c:if test="${data.offender_gender_type eq 'unknown'}">selected</c:if>>미상</option>
				<option value="none" <c:if test="${data.offender_gender_type eq 'none'}">selected</c:if>>해당사항없음</option>								
			</select>
		</td>
		<td>행위자 소속</td>
		<td><input type="text" id="offender_belong" name="offender_belong" value="${data.offender_belong}"></td>
	</tr>
	<tr>
		<td>행위자 피해자와의 관계</td>
		<td colspan="9">
			<select id="offender_victim_rel_type" name="offender_victim_rel_type">
				<option value="">선택</option>
				<option value="boss" <c:if test="${data.offender_victim_rel_type eq 'boss'}">selected</c:if>>기관장/사업주</option>
				<option value="senior" <c:if test="${data.offender_victim_rel_type eq 'senior'}">selected</c:if>>상급자</option>
				<option value="partner" <c:if test="${data.offender_victim_rel_type eq 'partner'}">selected</c:if>>동료</option>
				<option value="otherrel" <c:if test="${data.offender_victim_rel_type eq 'otherrel'}">selected</c:if>>그 외 업무관계자</option>
				<option value="etc" <c:if test="${data.offender_victim_rel_type eq 'etc'}">selected</c:if>>기타</option>
				<option value="unknown" <c:if test="${data.offender_victim_rel_type eq 'unknown'}">selected</c:if>>미파악</option>
			</select>
			<input type="text" id="offender_victim_rel_type_etc" name="offender_victim_rel_type_etc" value="${data.offender_victim_rel_type_etc}">
		</td>
	</tr>
	<tr>
		<td>피해내용</td>
		<td colspan="9">
			<input type="checkbox" id="harm_first_type_rape" name="harm_first_type_rape" value="Y" <c:if test="${data.harm_first_type_rape eq 'Y'}">checked</c:if>>강간/유사강간
			<input type="checkbox" id="harm_first_type_harass" name="harm_first_type_harass" value="Y" <c:if test="${data.harm_first_type_harass eq 'Y'}">checked</c:if>>그 외 추행
			<input type="checkbox" id="harm_first_type_verbal" name="harm_first_type_verbal" value="Y" <c:if test="${data.harm_first_type_verbal eq 'Y'}">checked</c:if>>언어적
			<input type="checkbox" id="harm_first_type_visual" name="harm_first_type_visual" value="Y" <c:if test="${data.harm_first_type_visual eq 'Y'}">checked</c:if>>시각적
			<input type="checkbox" id="harm_first_type_etc" name="harm_first_type_etc" value="Y" <c:if test="${data.harm_first_type_etc eq 'Y'}">checked</c:if>>기타 성희롱
			<input type="checkbox" id="harm_sec_type" name="harm_sec_type" value="Y" <c:if test="${data.harm_sec_type eq 'Y'}">checked</c:if>>2차 피해
			(<input type="checkbox" id="harm_sec_type_security" name="harm_sec_type_security" value="Y" <c:if test="${data.harm_sec_type_security eq 'Y'}">checked</c:if>>비밀누설/소문유포
			<input type="checkbox" id="harm_sec_type_seprate" name="harm_sec_type_seprate" value="Y" <c:if test="${data.harm_sec_type_seprate eq 'Y'}">checked</c:if>>분리조치 미흡
			<input type="checkbox" id="harm_sec_type_intention" name="harm_sec_type_intention" value="Y" <c:if test="${data.harm_sec_type_intention eq 'Y'}">checked</c:if>>의사에 반한 사건처리
			<input type="checkbox" id="harm_sec_type_identity" name="harm_sec_type_identity" value="Y" <c:if test="${data.harm_sec_type_identity eq 'Y'}">checked</c:if>>신분상 불이익
			<input type="checkbox" id="harm_sec_etc" name="harm_sec_etc" value="Y" <c:if test="${data.harm_sec_etc eq 'Y'}">checked</c:if>>그외									
			<input type="text" id="harm_sec_etc_txt" name="harm_sec_etc_txt" value="${data.harm_sec_etc_txt}">)
			<input type="checkbox" id="harm_etc" name="harm_etc" value="Y" <c:if test="${data.harm_etc eq 'Y'}">checked</c:if>>기타
			<input type="text" id="harm_etc_txt" name="harm_etc_txt" value="${data.harm_etc_txt}">
			<input type="checkbox" id="harm_first_type_sexism" name="harm_first_type_sexism" value="Y" <c:if test="${data.harm_first_type_sexism eq 'Y'}">checked</c:if>>성차별
			<input type="checkbox" id="harm_first_type_unknown" name="harm_first_type_unknown" value="Y" <c:if test="${data.harm_first_type_unknown eq 'Y'}">checked</c:if>>미파악
			<input type="checkbox" id="harm_first_type_none" name="harm_first_type_none" value="Y" <c:if test="${data.harm_first_type_none eq 'Y'}">checked</c:if>>해당사항없음
		</td>
	</tr>
	<tr>
		<td>조치</td>
		<td colspan="9">
			<input type="checkbox" id="response_type_info" name="response_type_info" value="Y" <c:if test="${data.response_type_info eq 'Y'}">checked</c:if>>절차 안내 및 정보 제공
			<input type="checkbox" id="response_type_advice" name="response_type_advice" value="Y" <c:if test="${data.response_type_advice eq 'Y'}">checked</c:if>>소속기관 상담/신고 권유
			<input type="checkbox" id="response_type_intro_org" name="response_type_intro_org" value="Y" <c:if test="${data.response_type_intro_org eq 'Y'}">checked</c:if>>타 신고기관 안내
			(<input type="checkbox" id="response_type_intro_org_women" name="response_type_intro_org_women" value="Y" <c:if test="${data.response_type_intro_org_women eq 'Y'}">checked</c:if>>여성가족부
			<input type="checkbox" id="response_type_intro_org_labor" name="response_type_intro_org_labor" value="Y" <c:if test="${data.response_type_intro_org_labor eq 'Y'}">checked</c:if>>고용노동부
			<input type="checkbox" id="response_type_intro_org_police" name="response_type_intro_org_police" value="Y" <c:if test="${data.response_type_intro_org_police eq 'Y'}">checked</c:if>>경찰
			<input type="checkbox" id="response_type_intro_org_education" name="response_type_intro_org_education" value="Y" <c:if test="${data.response_type_intro_org_education eq 'Y'}">checked</c:if>>교육부
			<input type="checkbox" id="response_type_intro_org_human" name="response_type_intro_org_human" value="Y" <c:if test="${data.response_type_intro_org_human eq 'Y'}">checked</c:if>>국가인권위원회
			<input type="checkbox" id="response_type_intro_org_etc" name="response_type_intro_org_etc" value="Y" <c:if test="${data.response_type_intro_org_etc eq 'Y'}">checked</c:if>>기타
			<input type="text" id="response_type_intro_org_etc_txt" name="response_type_intro_org_etc_txt" value="${data.response_type_intro_org_etc_txt}">)<br>
			<input type="checkbox" id="response_type_service_rel" name="response_type_service_rel" value="Y" <c:if test="${data.response_type_service_rel eq 'Y'}">checked</c:if>>서비스 연계
			(<input type="checkbox" id="response_type_service_rel_con" name="response_type_service_rel_con" value="${data.response_type_service_rel_con}">상담
			<input type="checkbox" id="response_type_service_rel_law" name="response_type_service_rel_law" value="Y" <c:if test="${data.response_type_service_rel_law eq 'Y'}">checked</c:if>>법률/노무
			<input type="checkbox" id="response_type_service_rel_medical" name="response_type_service_rel_medical" value="Y" <c:if test="${data.response_type_service_rel_medical eq 'Y'}">checked</c:if>>의료
			<input type="checkbox" id="response_type_service_rel_etc" name="response_type_service_rel_etc" value="Y" <c:if test="${data.response_type_service_rel_etc eq 'Y'}">checked</c:if>>그외
			<input type="text" id="response_type_service_rel_etc_txt" name="response_type_service_rel_etc_txt" value="${data.response_type_service_rel_etc_txt}">)
			<input type="checkbox" id="response_type_etc" name="response_type_etc" value="Y" <c:if test="${data.response_type_etc eq 'Y'}">checked</c:if>>기타
			<input type="text" id="response_type_etc_txt" name="response_type_etc_txt" value="${data.response_type_etc_txt}">									
		</td>
	</tr>
	<tr>
		<td>상담 내용</td>
		<td colspan="4"><input type="text" id="consulting_contents" name="consulting_contents" value="${data.consulting_contents}"/></td>
		<td>비고</td>
		<td colspan="4"><input type="text" id="consulting_contents_etc" name="consulting_contents_etc" value="${data.consulting_contents_etc}"/></td>
	</tr>
</table>