<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/vendor/jquery.ui.widget.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.iframe-transport.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.fileupload.js"/>'></script>
<style>
.main_table1 {
	border-top: 1px solid #ddd;
	border-collapse: inherit
}

.main_table1 td {
	text-align: left;
	border-top: none;
}

.main_table1 td tr:last-child td {
	border-bottom: none;
}

.main_table1 td table {
	border-top: none;
	border-bottom: none
}
.main_table{padding:5px;}
#content ul{border:none}
#content ul li{margin-bottom:3px;}
#content ul label{display:inline-block}
.application dt, .application dd{display:inline-block}
</style>

<ul class="homepagebbs">
	<li class="bg"><h3 class="sub">접수 상세</h3>
	<div style="text-align: right;padding-right: 10px;">
	
		       	<a id="action_registration_cancel" class="btmore01" href="javascript:void(0);">목록</a>
			<c:forEach items="${perm}" var="p" varStatus="ini">
				<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_31' and p.ALLOW_YN eq 'Y' }">
					<a class="btmore01" id="setManagerBtn" href="javascript:void(0);">담당관 지정</a>
				</c:if>
			</c:forEach>
	       	<c:choose>
				<c:when test="${mode eq 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_17' and p.ALLOW_YN eq 'Y' }">
							<a id="action_registration_data" class="btmore01" href="javascript:void(0);">등록</a>
						</c:if>
					</c:forEach>
				</c:when>
				<c:when test="${mode ne 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_16' and p.ALLOW_YN eq 'Y' }">
							<a id="action_edit_data" class="btmore01" href="javascript:void(0);">수정</a>
						</c:if>
					</c:forEach>
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_15' and p.ALLOW_YN eq 'Y' }">
							<a id="action_delete_data" class="btmore01" href="javascript:void(0);">삭제</a>
						</c:if>
					</c:forEach>
				</c:when>						
			</c:choose>
	</div>
	<li>
		<div id="workPage" class="main_table" style="overflow-y: scroll; min-height:400px;">			
			<input type="hidden" id="NO" name="NO" value="${data.NO}" />
			
			<!--상담일지 등록 영역-->
                <form id="FrontApplicationVo" name="FrontApplicationVo" class="application">
                	<table>
                		<tr>
                			<td>접수,사건 번호</td>
                			<td>${data.consulting_application_no}
                			<input type="hidden" id="consulting_application_no" name="consulting_application_no" value="${data.consulting_application_no}" /></td>
                		</tr>
                		<tr>
                			<td colspan="2" style="font-size: 16px;">기관 정보</td>
                		</tr>
                		<tr>
                			<td>유형</td>
                			<td>
                			<input type="radio" id="org_type_1" name="org_type" value="gov"<c:if test="${data.org_type eq 'gov'}">checked</c:if>><label for="org_type_1"> 공공</label>
                            <input type="radio" id="org_type_2" name="org_type" value="priv"<c:if test="${data.org_type eq 'priv'}">checked</c:if>><label for="org_type_2"> 민간</label>
                			</td>
                		</tr>
                		<tr>
                			<td>기관명
                			</td>
                			<td><input type="text" id="org_name" name="org_name" placeholder="" value="${data.org_name}">
                			</td>
                		</tr>
                		<tr>
                			<td>상급기관
                			</td>
                			<td><input type="text" id="upper_org_name" name="upper_org_name" placeholder="" value="${data.upper_org_name}">
                			</td>
                		</tr>
                		<tr>
                			<td>현원
                			</td>
                			<td><input type="text" id="org_member_count" name="org_member_count" placeholder="" value="${data.org_member_count}">명
                			</td>
                		</tr>
                		<tr>
                			<td colspan="2">&nbsp;</td>
                		</tr>
                		<tr>
                			<td colspan="2" style="font-size: 16px;">담당자 정보 </td>
                		</tr>                		
                		<tr>
                			<td>소속 및 직위
                			</td>
                			<td><input type="text" id="belong_job_title" name="belong_job_title" placeholder="" value="${data.belong_job_title}">
                			</td>
                		</tr>
                		<tr>
                			<td>이름
                			</td>
                			<td><input type="text" id="org_client_name" name="org_client_name" placeholder="" value="${data.org_client_name}">
                			</td>
                		</tr>
                		<tr>
                			<td>연락처
                			</td>
                			<td><input type="text" id="org_client_tel_no" name="org_client_tel_no" placeholder="" value="${data.org_client_tel_no}">
                			</td>
                		</tr>
                		<tr>
                			<td>이메일
                			</td>
                			<td><input type="text" id="org_client_email" name="org_client_email" placeholder="" value="${data.org_client_email}">
                			</td>
                		</tr>
                		<tr>
                			<td colspan="2">&nbsp;</td>
                		</tr>
                		<tr>
                			<td colspan="2" style="font-size: 16px;">신고사건 현황 </td>
                		</tr>
                		<tr>
                			<td>사건처리이력
                			</td> 
                			<td>                            
	                			<ul>
	                                <li><input type="radio" id="accident_response_hist_1" name="accident_response_hist" value="yes"<c:if test="${data.accident_response_hist eq 'yes'}">checked</c:if>><label for="accident_response_hist_1"> 유</label></li>
	                                <li><input type="radio" id="accident_response_hist_2" name="accident_response_hist" value="no"<c:if test="${data.accident_response_hist eq 'no'}">checked</c:if>><label for="accident_response_hist_2"> 무</label></li>
	                                <li><input type="radio" id="accident_response_hist_3" name="accident_response_hist" value="none"<c:if test="${data.accident_response_hist eq 'none'}">checked</c:if>><label for="accident_response_hist_3"> 발생했으나 공식처리되지 않음</label></li>
	                            </ul>
                			</td>
                		</tr>
                		<tr>
                			<td>시기(최근)
                			</td>
                			<td> 
								<ul>
	                                <li>발생시기 <input type="date" id="generation" name="accident_date"  value="${data.accident_date}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일"></li>
	                                <li>접수시기 <input type="date" id="receipt" name="receipt_date"  value="${data.receipt_date}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일"></li>
	                            </ul>
                			</td>
                		</tr>
                		<tr>
                			<td>피해유형<span>중복체크가능</span>
                			</td>
                			<td>                            
                				<ul>
	                                <li><input type="checkbox" id="harm_type_verbals" name="harm_type_verbals" value="Y"<c:if test="${data.harm_type_verbals eq 'Y'}">checked</c:if>><label for="harm_type_verbals"> 언어적 성희롱</label></li>
	                                <li><input type="checkbox" id="harm_type_body" name="harm_type_body" value="Y"<c:if test="${data.harm_type_body eq 'Y'}">checked</c:if>><label for="harm_type_body"> 신체적 성희롱</label></li>
	                                <li><input type="checkbox" id="harm_type_visual" name="harm_type_visual" value="Y"<c:if test="${data.harm_type_visual eq 'Y'}">checked</c:if>><label for="harm_type_visual"> 시각적 성희롱</label></li>
	                                <li><input type="checkbox" id="harm_type_second" name="harm_type_second" value="Y"<c:if test="${data.harm_type_second eq 'Y'}">checked</c:if>><label for="harm_type_second"> 2차 피해</label></li>
	                                <li class="w_100"><input type="checkbox" id="harm_type_etc" name="harm_type_etc" value="Y"<c:if test="${data.harm_type_etc eq 'Y'}">checked</c:if>><label for="harm_type_etc"> 기타 (직접입력)</label>
	                                <div class="input_box w_220"><input type="text" id="harm_etc_txt" name="harm_etc_txt" placeholder="기타유형을 입력해주세요." value="${data.harm_etc_txt}"></div></li>
	                            </ul>
                			</td>
                		</tr>
                		<tr>
                			<td>사건 진행단계
                			</td>
                			<td>
								<ul>
	                                <li><input type="radio" id="accident_step_1" name="accident_step" value="step1"><label for="accident_step_1" <c:if test="${data.accident_step eq 'step1'}">checked</c:if>> 인지 및 접수 (삼당)</label></li>
	                                <li><input type="radio" id="accident_step_2" name="accident_step" value="step2"><label for="accident_step_2" <c:if test="${data.accident_step eq 'step2'}">checked</c:if>> 조사</label></li>
	                                <li><input type="radio" id="accident_step_3" name="accident_step" value="step3"><label for="accident_step_3" <c:if test="${data.accident_step eq 'step3'}">checked</c:if>> 고충심의위원회</label></li>
	                                <li><input type="radio" id="accident_step_4" name="accident_step" value="step4"><label for="accident_step_4" <c:if test="${data.accident_step eq 'step4'}">checked</c:if>> 종결 (후속조치)</label></li>
	                            </ul>
                			</td>
                		</tr>
                		<tr>
                			<td>기타(직접입력)<br><span>사건 관련 특이사항 등</span>사건처리이력<br>없는 기관
                			</td>
                			<td><textarea id="application_etc_txt" name="application_etc_txt" rows="2" style="resize: none; width:100%; height:100px;" placeholder="기타 신고사건 현황을 입력해주세요.">${data.application_etc_txt}</textarea>
                			</td>
                		</tr>
                		<tr>
                			<td colspan="2">&nbsp;</td>
                		</tr>
                		<tr>
                			<td colspan="2" style="font-size: 16px;">희망분야</td>
                		</tr>                		
                		<tr>
                			<td><span class="span01">중복체크</span><br><span class="span02">컨설팅 일정 및 내용은 선정 후 <em><br></em>기관과 협의하여 확정합니다.</span>
                			</td>
                			<td>
                                <div class="check_box"><input type="checkbox" id="first_org_type_all" class="num01" name="first_org_type_all" value="Y"<c:if test="${data.first_org_type_all eq 'Y'}">checked</c:if>><label for="first_org_type_all"> 전수 설문조사 (조직문화 및 성희롱 성폭력 실태 파악)</label></div>
                                <div class="check_box"><input type="checkbox" id="first_org_type_inorg" class="num02" name="first_org_type_inorg" value="Y"<c:if test="${data.first_org_type_inorg eq 'Y'}">checked</c:if>><label for="first_org_type_inorg"> 기관 내 성희롱ㆍ성폭력 사건처리 절차 및 제도* 자문<span>* 성희롱 방지조치, 폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span></label></div>
                                <div class="check_box"><input type="checkbox" id="first_org_type_protect" class="num03" name="first_org_type_protect" value="Y"<c:if test="${data.first_org_type_protect eq 'Y'}">checked</c:if>><label for="first_org_type_protect"> 피해자 보호, 2차 피해 방지 방안 자문</label></div>
                                <div class="check_box"> <input type="checkbox" id="first_org_type_etc" class="num05" name="first_org_type_etc" value="Y"<c:if test="${data.first_org_type_etc eq 'Y'}">checked</c:if>><label for="first_org_type_etc"> 기타(직접 작성)</label></div>
                                <textarea id="first_org_type_etc_txt" name="first_org_type_etc_txt" rows="2" style="resize: none; width:100%; height:100px;" placeholder="기타 의견을 입력해주세요.">${data.first_org_type_etc_txt}</textarea>
                			</td>
                		</tr>
                		<tr>
                			<td>사건처리이력 있는 기관
                			</td>
                			<td>
	                                <div class="check_box"><input type="checkbox" id="dup_org_type_check" class="num01" name="dup_org_type_check" value="Y"<c:if test="${data.dup_org_type_check eq 'Y'}">checked</c:if>><label for="dup_org_type_check"> 기관 내 성희롱ㆍ성폭력 사건처리절차 검토 및 자문</label></div>
	                                <div class="check_box"><input type="checkbox" id="dup_org_type_protect" class="num02" name="dup_org_type_protect" value="Y"<c:if test="${data.dup_org_type_protect eq 'Y'}">checked</c:if>><label for="dup_org_type_protect"> 피해자 보호, 2차 피해 방지 및 재발방지대책 수립 자문</label></div>
	                                <div class="check_box"><input type="checkbox" id="dup_org_type_all" class="num03" name="dup_org_type_all" value="Y"<c:if test="${data.dup_org_type_all eq 'Y'}">checked</c:if>><label for="dup_org_type_all"> 전수 설문조사 (조직문화 및 성희롱ㆍ성폭력 실태 파악)</label></div>
	                                <div class="check_box"><input type="checkbox" id="dup_org_type_inorg" class="num03" name="dup_org_type_inorg" value="Y"<c:if test="${data.dup_org_type_inorg eq 'Y'}">checked</c:if>><label for="dup_org_type_inorg"> 기관 내 성희롱ㆍ성폭력 사건처리 제도*자문 <span>*  폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span></label></div>
	                                
	                                    <div class="check_box"> <input type="checkbox" id="dup_org_type_etc" class="num05" name="dup_org_type_etc" value="Y"<c:if test="${data.dup_org_type_etc eq 'Y'}">checked</c:if>><label for="dup_org_type_etc"> 기타(직접 작성)</label></div>
	                                    <textarea id="dup_org_type_etc_txt" name="dup_org_type_etc_txt" rows="2" style="resize: none; width:100%; height:100px;" placeholder="기타 의견을 입력해주세요.">${data.dup_org_type_etc_txt}</textarea>
                			</td>
                		</tr>
                		<tr>
                			<td colspan="2">&nbsp;</td>
                		</tr>
                		<tr>
                			<td colspan="2" style="font-size: 16px;">비고</td>
                		</tr>
                		<tr>
                			<td>컨설팅 가능 시기
                			</td>
                			<td> 
	                			
	                                    <dl>
	                                        <dt>${fn:substring(data.wish_consulting_date_1,2,4)}년 ${fn:substring(data.wish_consulting_date_1,4,6)}분기</dt>
	                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_1_yn" id="wish_consulting_date_1_yn" value="Y" <c:if test="${data.wish_consulting_date_1_yn eq 'Y'}">checked</c:if>><label for="wish_consulting_date_1_yn"></label></div></dd>
	                                    </dl>
	                                
	                                    <dl>
	                                        <dt>${fn:substring(data.wish_consulting_date_2,2,4)}년 ${fn:substring(data.wish_consulting_date_2,4,6)}분기</dt>
	                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_2_yn" id="wish_consulting_date_2_yn" value="Y" <c:if test="${data.wish_consulting_date_2_yn eq 'Y'}">checked</c:if>><label for="wish_consulting_date_2_yn"></label></div></dd>
	                                    </dl>
	                                
	                                    <dl>
	                                        <dt>${fn:substring(data.wish_consulting_date_3,2,4)}년 ${fn:substring(data.wish_consulting_date_3,4,6)}분기</dt>
	                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_3_yn" id="wish_consulting_date_3_yn" value="Y" <c:if test="${data.wish_consulting_date_3_yn eq 'Y'}">checked</c:if>><label for="wish_consulting_date_3_yn"></label></div></dd>
	                                    </dl>
	                                
	                                    <dl>
	                                        <dt>${fn:substring(data.wish_consulting_date_4,2,4)}년 ${fn:substring(data.wish_consulting_date_4,4,6)}분기</dt>
	                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_4_yn" id="wish_consulting_date_4_yn" value="Y" <c:if test="${data.wish_consulting_date_4_yn eq 'Y'}">checked</c:if>><label for="wish_consulting_date_4_yn"></label></div></dd>
	                                    </dl>
	                                
                			</td>
                		</tr>
                		<tr>
                			<td>기관 특성 등 사전에 참고해야 할 사항 등
                			</td>
                			<td><textarea id="reference_etc" name="reference_etc" rows="3" style="resize: none; width:100%; height:100px;" placeholder="기관 특성 등 사전에 참고해야 할 사항 등">${data.reference_etc}</textarea>
                			</td>
                		</tr>
                	</table>
<!--                     <div class="btn_box">
                        <ul>
                            <li><a href="">취소</a></li>
                            <li><a href="javascript:void(0);" id="registration_application" class="b_feac25">완료</a></li>
                        </ul>
                    </div> -->
                </form>
			<!--/상담일지 등록 영역-->
		</div>
		<!--/main_table-->
		<!-- 
		<div class="top_bt">
	       	<a id="action_registration_cancel" class="btmore01" href="javascript:void(0);">목록</a>
			<c:forEach items="${perm}" var="p" varStatus="ini">
				<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_31' and p.ALLOW_YN eq 'Y' }">
					<a class="btmore01" id="setManagerBtn" href="javascript:void(0);">담당관 지정 목록</a>
				</c:if>
			</c:forEach>
	       	<c:choose>
				<c:when test="${mode eq 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_17' and p.ALLOW_YN eq 'Y' }">
							<a id="action_registration_data" class="btmore01" href="javascript:void(0);">등록</a>
						</c:if>
					</c:forEach>
				</c:when>
				<c:when test="${mode ne 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_16' and p.ALLOW_YN eq 'Y' }">
							<a id="action_edit_data" class="btmore01" href="javascript:void(0);">수정</a>
						</c:if>
					</c:forEach>
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_15' and p.ALLOW_YN eq 'Y' }">
							<a id="action_delete_data" class="btmore01" href="javascript:void(0);">삭제</a>
						</c:if>
					</c:forEach>
				</c:when>						
			</c:choose>
		</div>	    -->
	</li>
</ul>
<script>
		$(window).on('resize', function(){
			$("#workPage").css('max-height',window.innerHeight -210 );
		});

	var edit_save_flag="edit";
	$(function(){
		$("#workPage").css('max-height',window.innerHeight -210 );
		
		var mode = '${mode}';console.log(mode);
		
		if ( mode == 'reg' ) {
			//all enable
			elementsDisabled(true);
			//blank data
		} else if ( mode == 'view' ) {
			//all disable
			elementsDisabled(false);
			//fill data
		} else if ( mode == 'edit' ) {
			//all enable
			//fill data
		} else {
			//???
			elementsDisabled(false);
		}
		
		$(".main_table label").show();
		
    	$("#setManagerBtn").click(function(){
    		PopupCenter('/admsys/orgculturedigmng/managerListPopup.html?mode=POP','popupSearchCAList','500','300');		
    	});
    	
    	$("#action_registration_cancel").click(function(){			
			location.href="/admsys/orgculturedigmng/index.html";	
		});
	});

	
	function elementsDisabled(disabled) {
		if ( disabled == false ) {
			$('#contents input').attr('disabled', 'disabled');
			$('#contents select').attr('disabled', 'disabled');
			$('#contents textarea').attr('disabled', 'disabled');
		} else if ( disabled == true ) {
			$('#contents input').removeAttr('disabled');
			$('#contents select').removeAttr('disabled');
			$('#contents textarea').removeAttr('disabled');
		}
		

		// 예외 항목
		$("#action_registration_cancel").attr("disabled", false);
		$("#setManagerBtn").attr("disabled", "");
	}
</script>