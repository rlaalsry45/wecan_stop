<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/vendor/jquery.ui.widget.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.iframe-transport.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.fileupload.js"/>'></script>
<style>
	.main_table1{border-top:1px solid #ddd; border-collapse:inherit}
	.main_table1 td{text-align: left;border-top:none;}
	.main_table1 td tr:last-child td{border-bottom:none;}
	.main_table1 td table{border-top:none;border-bottom:none}
</style>
<ul class="homepagebbs">
	<li class="bg"><h3 class="sub">담당자별 상담관리 등록</h3>
		<div style="text-align: right;padding-right: 10px;">
	       	<a id="consulting_registration_cancel" class="btmore01" href="javascript:return false;">취소</a>
	       	
	       	<c:choose>
				<c:when test="${mode eq 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
							<a id="consulting_registration_data" class="btmore01" href="javascript:void(0);">등록</a>
						</c:if>
					</c:forEach>
				</c:when>
				<c:when test="${mode ne 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
							<a id="consulting_edit_data" class="btmore01" href="javascript:void(0);">수정</a>
						</c:if>
					</c:forEach>
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_2' and p.ALLOW_YN eq 'Y' }">
							<a id="consulting_delete_data" class="btmore01" href="javascript:void(0);">삭제</a>
						</c:if>
					</c:forEach>
				</c:when>						
			</c:choose>
		</div>
	</li>
	<li>
		<div class="main_table"  style="overflow-y: scroll; min-height:400px; max-height: 800px;" tabindex="100">					
			<input type="hidden" id="NO" name="NO" value="${data.NO}" />
			<input type="hidden" id="pmode" name="pmode" value="${mode}" />
			<input type="hidden" id="consulting_history_no" name="consulting_history_no" value="${data.consulting_history_no}" />

			<!--상담일지 등록 영역-->
			<table class="main_table1" summary="담당관별 상담관리 등록 항목을 보여줍니다.">
				<c:choose>
					<c:when test="${mode ne 'reg'}">
						<tr>
							<td>상담번호</td>
							<td>${data.consulting_history_no}
								<input type="hidden" id="chNO" name="chNO" value="${data.consulting_history_no}"/>
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
				</tr>
				<tr>
					<td>분류</td>
					<td>
						<input type="radio" id="consulting_type_1" name="consulting_type" value="public" <c:if test="${data.consulting_type eq 'public'}">checked</c:if>>공공부문
						<input type="radio" id="consulting_type_2" name="consulting_type" value="civil" <c:if test="${data.consulting_type eq 'civil'}">checked</c:if>>민간부문
						<input type="radio" id="consulting_type_3" name="consulting_type" value="personal" <c:if test="${data.consulting_type eq 'personal'}">checked</c:if>>개인간
						<input type="radio" id="consulting_type_4" name="consulting_type" value="etc" <c:if test="${data.consulting_type eq 'etc'}">checked</c:if>>기타/미파악
					</td>
				</tr>
				<tr>
					<td>전화 구분</td>
					<td><input type="checkbox" id="tel_type" name="tel_type" value="Y" <c:if test="${data.tel_type eq 'Y'}">checked</c:if>>공공기관장 전화</td>
				</tr>
				<tr>
					<td>작성일</td>
					<c:choose>
						<c:when test="${mode eq 'reg'}">
							<td id="registration_date">
												&nbsp;
								<span id="year"></span>
								<span class="point">-</span>
								<span id="month"></span>
								<span class="point">-</span>
								<span id="date"></span>
								&nbsp;&nbsp;
								<span class="txt_lg" id="hours"></span>
								<span class="mark">:</span>
								<span class="txt_lg" id="min"></span>
								<span class="mark">:</span>								
								<span class="txt_sm" id="sec"></span>
							</td>
						</c:when>
						<c:when test="${mode ne 'reg'}">
							<td>
							<fmt:parseDate value="${data.registration_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
                            <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
						</c:when>
						<c:otherwise>
							<td>
							<fmt:parseDate value="${data.registration_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
                            <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<!-- 2022-03-02 Start -->
				<tr>
					<td>상담 시작</td>
					<td id="consulting_start_date_td">
						<fmt:parseDate value="${data.consulting_start_date}" pattern="yyyy-MM-dd HH:mm:ss" var="oriStdt" />
                        <fmt:formatDate type="both" value="${oriStdt}" pattern="yyyy-MM-dd'T'HH:mm" var="temStd" />
						<input type="datetime-local" id="consulting_start_date" name="consulting_start_date" value="${temStd}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
					</td>
				</tr>
				<tr>
					<td>상담 종료</td>
					<td id="consulting_end_date_td">
						<fmt:parseDate value="${data.consulting_end_date}" pattern="yyyy-MM-dd HH:mm:ss" var="oriEddt" />
                        <fmt:formatDate type="both" value="${oriEddt}" pattern="yyyy-MM-dd'T'HH:mm" var="temEdd" />
						<input type="datetime-local" id="consulting_end_date" name="consulting_end_date" value="${temEdd}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
					</td>
				</tr>
				<!-- 2022-03-02 end -->
				<tr>
					<td>경로</td>
					<td>
						<input type="radio" id="received_type_1" name="received_type" value="tel" <c:if test="${data.received_type eq 'tel'}">checked</c:if>>전화
						<input type="radio" id="received_type_2" name="received_type" value="mail" <c:if test="${data.received_type eq 'mail'}">checked</c:if>>우편
						<input type="radio" id="received_type_3" name="received_type" value="visit" <c:if test="${data.received_type eq 'visit'}">checked</c:if>>내방
						<input type="radio" id="received_type_4" name="received_type" value="move" <c:if test="${data.received_type eq 'move'}">checked</c:if>>이관
					</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<input type="text" id="contact_tel_no" name="contact_tel_no" value="${data.contact_tel_no}"/>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="radio" id="consulting_req_type_1" name="consulting_req_type" value="relaccident" <c:if test="${data.consulting_req_type eq 'relaccident'}">checked</c:if>>사건관련
						<input type="radio" id="consulting_req_type_2" name="consulting_req_type" value="simple" <c:if test="${data.consulting_req_type eq 'simple'}">checked</c:if>>단순문의
						<input type="radio" id="consulting_req_type_3" name="consulting_req_type" value="etc" <c:if test="${data.consulting_req_type eq 'etc'}">checked</c:if>>기타</td>
				</tr>
				<tr>
					<td>유입경로</td>
					<td>						
						<input type="radio" id="contact_method_type_1" name="contact_method_type" value="internet" <c:if test="${data.contact_method_type eq 'internet'}">checked</c:if>>인터넷 검색
						<input type="radio" id="contact_method_type_2" name="contact_method_type" value="support" <c:if test="${data.contact_method_type eq 'support'}">checked</c:if>>피해자 지원기관 등
						<input type="radio" id="contact_method_type_3" name="contact_method_type" value="gov" <c:if test="${data.contact_method_type eq 'gov'}">checked</c:if>>여성가족부
						<input type="radio" id="contact_method_type_4" name="contact_method_type" value="etc" <c:if test="${data.contact_method_type eq 'etc'}">checked</c:if>>기타
						<input type="text" id="contact_method_type_etc" name="contact_method_type_etc" value="${data.contact_method_type_etc}"/>
						<input type="radio" id="contact_method_type_5" name="contact_method_type" value="unknown" <c:if test="${data.contact_method_type eq 'unknown'}">checked</c:if>>미파악
					</td>
				</tr>
				<tr>
					<td>의뢰인</td>
					<td>
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
									<input type="radio" id="client_victim_rel_type_4" name="client_victim_rel_type" value="doer" <c:if test="${data.client_victim_rel_type eq 'doer'}">checked</c:if>>행위자등
									<input type="radio" id="client_victim_rel_type_5" name="client_victim_rel_type" value="etc" <c:if test="${data.client_victim_rel_type eq 'etc'}">checked</c:if>>기타
									<input type="text" id="client_victim_rel_type_etc" name="client_victim_rel_type_etc" value="${data.client_victim_rel_type_etc}">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>피해자</td>
					<td>
						<table>
							<tr>
								<td>이름</td>
								<td><input type="text" id="victim_name" name="victim_name" value="${data.victim_name}"></td>
								<td>성별</td>
								<td>
									<input type="radio" id="victim_gender_type_1" name="victim_gender_type" value="female" <c:if test="${data.victim_gender_type eq 'female'}">checked</c:if>>여성
									<input type="radio" id="victim_gender_type_2" name="victim_gender_type" value="male" <c:if test="${data.victim_gender_type eq 'male'}">checked</c:if>>남성
									<input type="radio" id="victim_gender_type_3" name="victim_gender_type" value="unknown" <c:if test="${data.victim_gender_type eq 'unknown'}">checked</c:if>>미상
									<input type="radio" id="victim_gender_type_4" name="victim_gender_type" value="none" <c:if test="${data.victim_gender_type eq 'none'}">checked</c:if>>해당사항없음
								</td>
								<td>소속</td>
								<td><input type="text" id="victim_belong" name="victim_belong" value="${data.victim_belong}"></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>행위자</td>
					<td>
						<table>
							<tr>
								<td>이름</td>
								<td><input type="text" id="offender_name" name="offender_name" value="${data.offender_name}"></td>
								<td>성별</td>
								<td>
									<input type="radio" id="offender_gender_type_1" name="offender_gender_type" value="female" <c:if test="${data.offender_gender_type eq 'female'}">checked</c:if>>여성
									<input type="radio" id="offender_gender_type_2" name="offender_gender_type" value="male" <c:if test="${data.offender_gender_type eq 'male'}">checked</c:if>>남성
									<input type="radio" id="offender_gender_type_3" name="offender_gender_type" value="unknown" <c:if test="${data.offender_gender_type eq 'unknown'}">checked</c:if>>미상
									<input type="radio" id="offender_gender_type_4" name="offender_gender_type" value="none" <c:if test="${data.offender_gender_type eq 'none'}">checked</c:if>>해당사항없음
								</td>
								<td>소속</td>
								<td><input type="text" id="offender_belong" name="offender_belong" value="${data.offender_belong}"></td>
							</tr>
							<tr>
								<td>피해자와의 관계</td>
								<td colspan="5">
									<input type="radio" id="offender_victim_rel_type_1" name="offender_victim_rel_type" value="boss" <c:if test="${data.offender_victim_rel_type eq 'boss'}">checked</c:if>>기관장/사업주
									<input type="radio" id="offender_victim_rel_type_2" name="offender_victim_rel_type" value="senior" <c:if test="${data.offender_victim_rel_type eq 'senior'}">checked</c:if>>상급자
									<input type="radio" id="offender_victim_rel_type_3" name="offender_victim_rel_type" value="partner" <c:if test="${data.offender_victim_rel_type eq 'partner'}">checked</c:if>>동료
									<input type="radio" id="offender_victim_rel_type_4" name="offender_victim_rel_type" value="otherrel" <c:if test="${data.offender_victim_rel_type eq 'otherrel'}">checked</c:if>>그 외 업무관계자
									<input type="radio" id="offender_victim_rel_type_5" name="offender_victim_rel_type" value="etc" <c:if test="${data.offender_victim_rel_type eq 'etc'}">checked</c:if>>기타
									<input type="text" id="offender_victim_rel_type_etc" name="offender_victim_rel_type_etc" value="${data.offender_victim_rel_type_etc}">
									<input type="radio" id="offender_victim_rel_type_6" name="offender_victim_rel_type" value="unknown" <c:if test="${data.offender_victim_rel_type eq 'unknown'}">checked</c:if>>미파악
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>피해내용(복수선택)</td>
					<td>
						<table>
							<tr>
								<td>
									<input type="checkbox" id="harm_first_type_rape" name="harm_first_type_rape" value="Y" <c:if test="${data.harm_first_type_rape eq 'Y'}">checked</c:if>>강간/유사강간
									<input type="checkbox" id="harm_first_type_harass" name="harm_first_type_harass" value="Y" <c:if test="${data.harm_first_type_harass eq 'Y'}">checked</c:if>>그 외 추행
									<input type="checkbox" id="harm_first_type_verbal" name="harm_first_type_verbal" value="Y" <c:if test="${data.harm_first_type_verbal eq 'Y'}">checked</c:if>>언어적
									<input type="checkbox" id="harm_first_type_visual" name="harm_first_type_visual" value="Y" <c:if test="${data.harm_first_type_visual eq 'Y'}">checked</c:if>>시각적
									<input type="checkbox" id="harm_first_type_etc" name="harm_first_type_etc" value="Y" <c:if test="${data.harm_first_type_etc eq 'Y'}">checked</c:if>>기타 성희롱
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" id="harm_sec_type" name="harm_sec_type" value="Y" <c:if test="${data.harm_sec_type eq 'Y'}">checked</c:if>>2차 피해
									(<input type="checkbox" id="harm_sec_type_security" name="harm_sec_type_security" value="Y" <c:if test="${data.harm_sec_type_security eq 'Y'}">checked</c:if>>비밀누설/소문유포
									<input type="checkbox" id="harm_sec_type_seprate" name="harm_sec_type_seprate" value="Y" <c:if test="${data.harm_sec_type_seprate eq 'Y'}">checked</c:if>>분리조치 미흡
									<input type="checkbox" id="harm_sec_type_intention" name="harm_sec_type_intention" value="Y" <c:if test="${data.harm_sec_type_intention eq 'Y'}">checked</c:if>>의사에 반한 사건처리
									<input type="checkbox" id="harm_sec_type_identity" name="harm_sec_type_identity" value="Y" <c:if test="${data.harm_sec_type_identity eq 'Y'}">checked</c:if>>신분상 불이익
									<input type="checkbox" id="harm_sec_etc" name="harm_sec_etc" value="Y" <c:if test="${data.harm_sec_etc eq 'Y'}">checked</c:if>>그외									
									<input type="text" id="harm_sec_etc_txt" name="harm_sec_etc_txt" value="${data.harm_sec_etc_txt}">)
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" id="harm_etc" name="harm_etc" value="Y" <c:if test="${data.harm_etc eq 'Y'}">checked</c:if>>기타
									<input type="text" id="harm_etc_txt" name="harm_etc_txt" value="${data.harm_etc_txt}">
									<input type="checkbox" id="harm_first_type_sexism" name="harm_first_type_sexism" value="Y" <c:if test="${data.harm_first_type_sexism eq 'Y'}">checked</c:if>>성차별
									<input type="checkbox" id="harm_first_type_unknown" name="harm_first_type_unknown" value="Y" <c:if test="${data.harm_first_type_unknown eq 'Y'}">checked</c:if>>미파악
									<input type="checkbox" id="harm_first_type_none" name="harm_first_type_none" value="Y" <c:if test="${data.harm_first_type_none eq 'Y'}">checked</c:if>>해당사항없음
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>조치(복수선택)</td>
					<td><table>
							<tr>
								<td>
									<input type="checkbox" id="response_type_info" name="response_type_info" value="Y" <c:if test="${data.response_type_info eq 'Y'}">checked</c:if>>절차 안내 및 정보 제공
									<input type="checkbox" id="response_type_advice" name="response_type_advice" value="Y" <c:if test="${data.response_type_advice eq 'Y'}">checked</c:if>>소속기관 상담/신고 권유
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" id="response_type_intro_org" name="response_type_intro_org" value="Y" <c:if test="${data.response_type_intro_org eq 'Y'}">checked</c:if>>타 신고기관 안내
									(<input type="checkbox" id="response_type_intro_org_women" name="response_type_intro_org_women" value="Y" <c:if test="${data.response_type_intro_org_women eq 'Y'}">checked</c:if>>여성가족부
									<input type="checkbox" id="response_type_intro_org_labor" name="response_type_intro_org_labor" value="Y" <c:if test="${data.response_type_intro_org_labor eq 'Y'}">checked</c:if>>고용노동부
									<input type="checkbox" id="response_type_intro_org_police" name="response_type_intro_org_police" value="Y" <c:if test="${data.response_type_intro_org_police eq 'Y'}">checked</c:if>>경찰
									<input type="checkbox" id="response_type_intro_org_education" name="response_type_intro_org_education" value="Y" <c:if test="${data.response_type_intro_org_education eq 'Y'}">checked</c:if>>교육부
									<input type="checkbox" id="response_type_intro_org_human" name="response_type_intro_org_human" value="Y" <c:if test="${data.response_type_intro_org_human eq 'Y'}">checked</c:if>>국가인권위원회
									<input type="checkbox" id="response_type_intro_org_etc" name="response_type_intro_org_etc" value="Y" <c:if test="${data.response_type_intro_org_etc eq 'Y'}">checked</c:if>>기타
									<input type="text" id="response_type_intro_org_etc_txt" name="response_type_intro_org_etc_txt" value="${data.response_type_intro_org_etc_txt}">)
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" id="response_type_service_rel" name="response_type_service_rel" value="Y" <c:if test="${data.response_type_service_rel eq 'Y'}">checked</c:if>>서비스 연계
									(<input type="checkbox" id="response_type_service_rel_con" name="response_type_service_rel_con" value="Y" <c:if test="${data.response_type_service_rel_con eq 'Y'}">checked</c:if>>상담
									<input type="checkbox" id="response_type_service_rel_law" name="response_type_service_rel_law" value="Y" <c:if test="${data.response_type_service_rel_law eq 'Y'}">checked</c:if>>법률/노무
									<input type="checkbox" id="response_type_service_rel_medical" name="response_type_service_rel_medical" value="Y" <c:if test="${data.response_type_service_rel_medical eq 'Y'}">checked</c:if>>의료
									<input type="checkbox" id="response_type_service_rel_etc" name="response_type_service_rel_etc" value="Y" <c:if test="${data.response_type_service_rel_etc eq 'Y'}">checked</c:if>>그외
									<input type="text" id="response_type_service_rel_etc_txt" name="response_type_service_rel_etc_txt" value="${data.response_type_service_rel_etc_txt}">)
								</td>
							</tr>
							<tr>
								<td>
									<input type="checkbox" id="response_type_etc" name="response_type_etc" value="Y" <c:if test="${data.response_type_etc eq 'Y'}">checked</c:if>>기타
									<input type="text" id="response_type_etc_txt" name="response_type_etc_txt" value="${data.response_type_etc_txt}">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>상담 내용</td>
					<td><textarea id="consulting_contents" name="consulting_contents" style="resize: none; width:100%; height:100px;">${data.consulting_contents}</textarea></td>
				</tr>
				<tr>
					<td>비고</td>
					<td><textarea id="consulting_contents_etc" name="consulting_contents_etc" style="resize: none; width:100%; height:100px;">${data.consulting_contents_etc}</textarea></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td>
						<a id="consultingUploadBtn" class="btmore05" onclick="return attach();">+ 파일 등록</a>
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
					<td><input type="button" id="searchPressSrchListPop" value="언론 모니터링 등록" />
					<table style="width:100%" summary="번호, 기사명, 등록자명, 등록일">
						<caption>언론 모니터링 정보 목록</caption>
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
						<c:forEach items="${conList}" var="a" varStatus="ai">
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
				<c:if test="${mode ne 'reg'}">
					<tr id="editReason" style="display: none;">
						<td>수정 사유</td>
						<td>
							<textarea id="edit_reason" style="resize: none; width:100%; height:100px;" name="edit_reason"></textarea>
						</td>
					</tr>					
					<tr id="editConsultingHistoryList">
						<td>상담일자 수정 이력 및 사유</td>
						<td>
							<table summary="번호, 수정일, 수정사유보기">
	                            <caption>상담일자 수정 이력 및 사유 목록</caption>
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
													<td>${each.edit_history_no}</td>
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
				</c:if>				
			</table>
			<!--/상담일지 등록 영역-->
		</div>
		<!--/main_table-->
<%-- 		<div class="top_bt">
	       	<a id="consulting_registration_cancel" class="btmore01" href="javascript:return false;">취소</a>
	       	
	       	<c:choose>
				<c:when test="${mode eq 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_17' and p.ALLOW_YN eq 'Y' }">
							<a id="consulting_registration_data" class="btmore01" href="javascript:void(0);">등록</a>
						</c:if>
					</c:forEach>
				</c:when>
				<c:when test="${mode ne 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_16' and p.ALLOW_YN eq 'Y' }">
							<a id="consulting_edit_data" class="btmore01" href="javascript:void(0);">수정</a>
						</c:if>
					</c:forEach>
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_15' and p.ALLOW_YN eq 'Y' }">
							<a id="consulting_delete_data" class="btmore01" href="javascript:void(0);">삭제</a>
						</c:if>
					</c:forEach>
				</c:when>						
			</c:choose>
		</div>	 --%>   
	</li>
</ul>
<script>
	var edit_save_flag="edit";

	var mode = '${mode}';
	
	$(function(){
		if ( mode == 'reg' ) {
			//all enable
			elementsDisabled(true);
			setInterval(clockStart,1000);
			//blank data
		} else if ( mode == 'view' ) {
			//all disable
			elementsDisabled(false);
			$("#consulting_registration_cancel").text("목록");
			$("#searchPressSrchListPop").hide();
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
    		window.open("/admsys/administration/index.html?mode=POP", "popupSearchPressList", "directories=no,toolbar=no,width=1000,height=700");
    	});
		
		$("#consulting_registration_cancel").click(function(){
			if ( mode == "view" && edit_save_flag == 'edit' ) {
				location.reload();
				//location.href = "<c:url value='/admsys/consultingmng/index.html' />";
    		} else {
    			if(confirm("취소하시겠습니까?")){
        			if ( mode == "reg" ) {
        				location.reload();
        				//location.href = "<c:url value='/admsys/consultingmng/index.html' />";
        			} else if ( mode == "view" ) {
        				if(edit_save_flag == 'save') {
            	  			$("#editReason").hide();
                			$("#editReasonHistoryList").show();
                			elementsDisabled(false);
                			$("#consulting_edit_data").text("수정");
                			$("#consulting_registration_cancel").text("목록");
                			edit_save_flag = "edit";
        				}
        			}
        		}	
    		}
		});
		
		
		$("#consulting_edit_data").click(function(){
			if(edit_save_flag == 'save') {
				// 필수값 체크
				var managerArray = new Array();
				managerArray = getUlList("managerListUL");
				
				if ( managerArray.length <= 0 ) {
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
				
				var fileULArray = new Array();
				fileULArray = getUL_li_no("fileListUL");

				var pressArray = new Array();
				var ulLen = $("#pressTrList tr").length;
				for( var i = 0; i < ulLen; i++ ) {	
					var liNo = $("#pressTrList tr:eq("+i+")").data("no");
					pressArray.push(liNo);					
				}

				if(confirm("수정 하시겠습니까?")){
					
					var str = $('#WConsultingMngVo').serialize();
	
					$.ajax({
						  type: 'POST',
						  url: "/admsys/consultingmng/consultingmng_update.html",
						  data: 	str 
						  		+	"&fileList="+fileULArray
						  		+	"&pressList="+pressArray
						  		+	"&managerList="+managerArray,
						  success: function(result){
							  if ( result.retStatus == "SUCCESS" ) {
								  alert("수정 하였습니다.");
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
					$("#consulting_edit_data").text("저장");
					$("#consulting_registration_cancel").text("취소");
					$("#searchPressSrchListPop").show();
				}
			}
		});
    	
		
		$("#consulting_registration_data").click(function(){
			// 필수값 체크
			var managerArray = new Array();
			managerArray = getUlList("managerListUL");
			
			if ( managerArray.length <= 0 ) {
				alert("담당관을 지정하여 주세요.");
				$("#managerListSel").focus();
				return;
			}
			
			if ( !validateData() ) {				
				return;
			}
			
			if(confirm("등록 하시겠습니까?")){
				var str = $('#WConsultingMngVo').serialize();
	
				var fileULArray = new Array();
				fileULArray = getUL_li_no("fileListUL");
				
				var pressArray = new Array();
				var ulLen = $("#pressTrList tr").length;
				for( var i = 0; i < ulLen; i++ ) {	
					var liNo = $("#pressTrList tr:eq("+i+")").data("no");
					pressArray.push(liNo);					
				}
				
				$.ajax({
					type: 'POST',
					url: "/admsys/consultingmng/consulting_registration.html",
					data: 	str
							+	"&fileList="+fileULArray
							+	"&pressList="+pressArray
							+	"&managerList="+managerArray,
					success: function(result){
						if ( result.retStatus == "SUCCESS" ) {
							alert("등록 하였습니다.");
							var lastInsertNo = result.no;
							var consultingNo = result.consulting_history_no;
							viewDetailPage(lastInsertNo, consultingNo);
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
		
		$("#consulting_delete_data").click(function(){
			PopupCenter('/admsys/consultingmng/consultingmng_del_alram.html?mode=POP&consulting_history_no='+$("#chNO").val(),'deleteConsulting','600','250');
		});

		
		//vali s
		$("input[name='contact_method_type']:radio").change(function(){
			$("#contact_method_type_etc").val("");
			if (  $('input[name=contact_method_type]:checked').val() == 'etc'  ) {
				$("#contact_method_type_etc").attr("disabled", false);
			} else {
				$("#contact_method_type_etc").attr("disabled", true);
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
		$("input[name='offender_victim_rel_type']:radio").change(function(){
			$("#offender_victim_rel_type_etc").val("");
			if (  $('input[name=offender_victim_rel_type]:checked').val() == 'etc'  ) {
				$("#offender_victim_rel_type_etc").attr("disabled", false);
			} else {
				$("#offender_victim_rel_type_etc").attr("disabled", true);
			}
		});
		$("#harm_sec_etc").change(function(){
			$("#harm_sec_etc_txt").val("");
			if ( $("#harm_sec_etc").is(":checked") ) {
				$("#harm_sec_etc_txt").attr("disabled", false);
			} else {
				$("#harm_sec_etc_txt").attr("disabled", true);
			}
		});
		$("#harm_etc").change(function(){
			$("#harm_etc_txt").val("");
			if ( $("#harm_etc").is(":checked") ) {
				$("#harm_etc_txt").attr("disabled", false);
			} else {
				$("#harm_etc_txt").attr("disabled", true);
			}
		});
		$("#response_type_intro_org_etc").change(function(){
			$("#response_type_intro_org_etc_txt").val("");
			if ( $("#response_type_intro_org_etc").is(":checked") ) {
				$("#response_type_intro_org_etc_txt").attr("disabled", false);
			} else {
				$("#response_type_intro_org_etc_txt").attr("disabled", true);
			}
		});
		$("#response_type_service_rel_etc").change(function(){
			$("#response_type_service_rel_etc_txt").val("");
			if ( $("#response_type_service_rel_etc").is(":checked") ) {
				$("#response_type_service_rel_etc_txt").attr("disabled", false);
			} else {
				$("#response_type_service_rel_etc_txt").attr("disabled", true);
			}
		});
		$("#response_type_etc").change(function(){
			$("#response_type_etc_txt").val("");
			if ( $("#response_type_etc").is(":checked") ) {
				$("#response_type_etc_txt").attr("disabled", false);
			} else {
				$("#response_type_etc_txt").attr("disabled", true);
			}
		}); 
		//vali e
		
		
		
	});
	
	function elementsDisabled(disabled) {
		if ( disabled == false ) {
			$('#contents input').attr('disabled', 'disabled');
			$('#contents select').attr('disabled', 'disabled');
			$('#contents textarea').attr('disabled', 'disabled');
			$("a[id^=aa_]").hide();
			$("a[id^=cc_]").hide();
			/*$('#searchConsultingSrchListPop').hide();
			$('#searchActionSrchListPop').hide();			*/
			$("#consultingUploadBtn").hide();
			$("#searchPressSrchListPop").hide();
			$("a[id^=mm_]").hide();
		} else if ( disabled == true ) {
			$('#contents input').removeAttr('disabled');
			$('#contents select').removeAttr('disabled');
			$('#contents textarea').removeAttr('disabled');
			$("a[id^=aa_]").show();
			$("a[id^=cc_]").show();
			/*$('#searchConsultingSrchListPop').show();
			$('#searchActionSrchListPop').show();
			*/
			$("#consultingUploadBtn").show();
			$("a[id^=mm_]").show();
		}
		

		// 예외 항목
		//$("#userId").attr("disabled", false);
		$("#contact_method_type_etc").attr("disabled", true);
		$("#client_victim_rel_type_etc").attr("disabled", true);
		$("#offender_victim_rel_type_etc").attr("disabled", true);
		$("#harm_sec_etc_txt").attr("disabled", true);
		$("#harm_etc_txt").attr("disabled", true);
		$("#response_type_intro_org_etc_txt").attr("disabled", true);
		$("#response_type_service_rel_etc_txt").attr("disabled", true);
		$("#response_type_etc_txt").attr("disabled", true);
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
					+		'<td id="nseq_'+objList[i].no+'">'+g_i+'</td>'
					+		'<td>'+objList[i].an + '</td>'
					+		'<td>'+objList[i].u+'</td>'	
					+		'<td>'+objList[i].c+'</td>'
					+		'<td><a id="aa_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delPressList('+objList[i].no+');return false;">X</a></td>'
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
						+		'<td id="nseq_'+objList[i].no+'">'+g_i+'</td>'
						+		'<td>'+objList[i].an + '</td>'
						+		'<td>'+objList[i].u+'</td>'	
						+		'<td>'+objList[i].c+'</td>'
						+		'<td><a id="aa_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delPressList('+objList[i].no+');return false;">X</a></td>'
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
	
    function deleteConsulting(reason){
		var str = $('#WConsultingMngVo').serialize();
		
		var delList = new Array();
		delList.push($("#NO").val());
		
		$.ajax({
			  type: 'POST',
			  url: "/admsys/consultingmng/consultingmng_req_delete.html",
			  data: str + "&delList="+delList + "&delete_reason="+reason,
			  success: function(result){
				  if ( result.retStatus == "SUCCESS" ) {
					  alert("${consulting_history_no}\n상담일지 삭제가 완료 되었습니다.");
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
    
	function pressViewPop(no) {
		PopupCenter('/admsys/administration/press_view_pop.html?NO='+no, 'pressViewPop','500','400');
	}
	
	function validateData(){
		if ( !$('input:radio[name=consulting_type]').is(':checked') ) {
			alert("분류 값을 선택하여 주세요.");
			$('input:radio[name=consulting_type]').focus();
			return false;
		}

		if ( !$('input:radio[name=received_type]').is(':checked') ) {
			alert("경로 값을 선택하여 주세요.");
			$('input:radio[name=received_type]').focus();
			return false;
		}
		
		if ( $("#contact_tel_no").val() == '' ) {
			alert("연락처를 입력하여주세요.");
			$("#contact_tel_no").focus();
			return false;
		}
		if ( !$('input:radio[name=consulting_req_type]').is(':checked') ) {
			alert("내용 값을 선택하여 주세요.");
			$('input:radio[name=consulting_req_type]').focus();
			return false;
		}
		if ( !$('input:radio[name=client_gender]').is(':checked') ) {
			alert("의뢰인의 성별 값을 선택하여 주세요.");
			$('input:radio[name=client_gender]').focus();
			return false;
		}
		if ( !$('input:radio[name=client_victim_rel_type]').is(':checked') ) {
			alert("의뢰인의 피해자와의 관계 값을 선택하여 주세요.");
			$('input:radio[name=client_victim_rel_type]').focus();
			return false;
		}
		
		if ( $('input[name=contact_method_type]:checked').val() == 'etc' && $("#contact_method_type_etc").val() == '' ) {
			alert("유입경로 기타 항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#contact_method_type_etc").focus();
			return false;
		}
		if ( $('input[name=client_victim_rel_type]:checked').val() == 'etc' && $("#client_victim_rel_type_etc").val() == '' ) {
			alert("의뢰인 피해자와의 관계 기타 항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#client_victim_rel_type_etc").focus();
			return false;
		}
		if ( $('input[name=offender_victim_rel_type]:checked').val() == 'etc' && $("#offender_victim_rel_type_etc").val() == '' ) {
			alert("행위자 피해자와의 관계 기타 항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#offender_victim_rel_type_etc").focus();
			return false;
		}
		
		if ( $("#harm_sec_etc").is(':checked') && $("#harm_sec_etc_txt").val() == '' ) {
			alert("피해내용(복수선택)의 그외항목이 선택되어 있을때는\n 그외내용을 입력해 주시기 바랍니다.");
			$("#harm_sec_etc_txt").focus();
			return false;
		}
		if ( $("#harm_etc").is(':checked') && $("#harm_etc_txt").val() == '' ) {
			alert("피해내용(복수선택)의 기타항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#harm_etc_txt").focus();
			return false;
		}
		if ( $("#response_type_intro_org_etc").is(':checked') && $("#response_type_intro_org_etc_txt").val() == '' ) {
			alert("조치(복수선택)의 타 신고기관 안내 기타항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#response_type_intro_org_etc_txt").focus();
			return false;
		}		
		if ( $("#response_type_service_rel_etc").is(':checked') && $("#response_type_service_rel_etc_txt").val() == '' ) {
			alert("조치(복수선택)의 그외항목이 선택되어 있을때는\n 그외내용을 입력해 주시기 바랍니다.");
			$("#response_type_service_rel_etc_txt").focus();
			return false;
		}	
		if ( $("#response_type_etc").is(':checked') && $("#response_type_etc_txt").val() == '' ) {
			alert("조치(복수선택)의 기타항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
			$("#response_type_etc_txt").focus();
			return false;
		}	

		return true;
	}
</script>