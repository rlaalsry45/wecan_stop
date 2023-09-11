<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <div class="content"> -->
			<!-- application start -->
			<!-- <div id="showDetailApplication" style="display: none;"> -->


				<p class="p_t">성희롱 방지 조직문화 진단 신청 내역</p>
				<c:if test="${data.step_status > 1}">
					<br>
					<p class="p_title">접수처리되어 수정할 수 없습니다. 수정관련 문의는  02-735-7544로 연락해주시기 바랍니다.</p>
				</c:if>
				<form:form modelAttribute="FrontApplicationVo" id="editAppFrm" name="editAppFrm" class="application" method="post">
					<input type="hidden" id="consulting_application_no" name="consulting_application_no" value="${data.consulting_application_no}" />
					<input type="hidden" id="ORGANIZATION_ID" name="ORGANIZATION_ID" value="${data.ORGANIZATION_ID}" />
					<input type="hidden" id="NO" name="NO" value="${data.NO}" />
					<input type="hidden" id="step_status" name="step_status" value="${data.step_status}" />
					<p class="tit">기관 정보</p>
					<dl>
						<dt>유형</dt>
						<dd>
							<input type="radio" id="org_type_1" name="org_type" value="gov" <c:if test="${data.org_type eq 'gov'}">checked</c:if>><label for="org_type_1"> 공공</label> 
							<input type="radio" id="org_type_2" name="org_type" value="priv"<c:if test="${data.org_type eq 'priv'}">checked</c:if>><label for="org_type_2">민간</label>
						</dd>
					</dl>
					<dl>
						<dt>기관명</dt>
						<dd>
							<div class="input_box">
								<input type="text" id="org_name" name="org_name" placeholder="" value="${data.org_name}">
								<input type="hidden" id="org_code" name="org_code" value="${data.org_code}" />
							</div>
							<c:if test="${data.step_status eq 1}"><input type="button" onclick="openGovSrchPop();" value="기관명 검색"></c:if>
						</dd>
					</dl>
					<dl>
						<dt>상급기관</dt>
						<dd>
							<div class="input_box">
								<input type="text" id="upper_org_name" name="upper_org_name" placeholder="" value="${data.upper_org_name}">
								<input type="hidden" id="upper_org_code" name="upper_org_code" value="${data.upper_org_code}" />
							</div>
							<c:if test="${data.step_status eq 1}"><input type="button" onclick="openUpperGovSrchPop();" value="상급기관 검색"></c:if>
						</dd>
					</dl>
					<dl>
						<dt>현원</dt>
						<dd>
							<div class="input_box w_110">
								<input type="text" id="org_member_count" name="org_member_count" placeholder="" value="${data.org_member_count}">
							</div>
							명
						</dd>
					</dl>

					<p class="tit">담당자 정보</p>
					<dl>
						<dt>소속 및 직위</dt>
						<dd>
							<div class="input_box">
								<input type="text" id="belong_job_title" name="belong_job_title" placeholder="" value="${data.belong_job_title}">
							</div>
						</dd>
					</dl>
					<dl>
						<dt>이름</dt>
						<dd>
							<div class="input_box">
								<input type="text" id="org_client_name" name="org_client_name" placeholder="" value="${data.org_client_name}">
							</div>
						</dd>
					</dl>
					<dl>
						<dt>연락처</dt>
						<dd>
							<div class="input_box">
								<input type="text" id="org_client_tel_no" name="org_client_tel_no" placeholder="" value="${data.org_client_tel_no}">
							</div>
						</dd>
					</dl>
					<dl>
						<dt>이메일</dt>
						<dd>
							<div class="input_box">
								<input type="text" id="org_client_email" name="org_client_email" placeholder="" value="${data.org_client_email}">
							</div>
						</dd>
					</dl>

					<p class="tit">신고사건 현황</p>
					<dl>
						<dt>사건처리이력</dt>
						<dd>
							<ul class="w_auto">
								<li><input type="radio" id="accident_response_hist_1" name="accident_response_hist" value="yes" <c:if test="${data.accident_response_hist eq 'yes'}">checked</c:if>><label for="accident_response_hist_1"> 유</label></li>
								<li><input type="radio" id="accident_response_hist_2" name="accident_response_hist" value="no" <c:if test="${data.accident_response_hist eq 'no'}">checked</c:if>><label for="accident_response_hist_2"> 무</label></li>
								<li><input type="radio" id="accident_response_hist_3" name="accident_response_hist" value="none" <c:if test="${data.accident_response_hist eq 'none'}">checked</c:if>><label for="accident_response_hist_3"> 발생했으나 공식처리되지 않음</label></li>
							</ul>
						</dd>
					</dl>
					<dl>
						<dt>시기(최근)</dt>
						<dd>
							<ul><fmt:parseDate value="${data.accident_date}" pattern="yyyy-MM-dd HH:mm:ss" var="acdt" />
								<fmt:parseDate value="${data.receipt_date}" pattern="yyyy-MM-dd HH:mm:ss" var="rcdt" />
								<li>발생시기 <input type="date" id="accident_date" name="accident_date" value="<fmt:formatDate type="both" value="${acdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;"></li>
								<li>접수시기 <input type="date" id="receipt_date" name="receipt_date" value="<fmt:formatDate type="both" value="${rcdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;"></li>
							</ul>
						</dd>
					</dl>
					<dl>
						<dt>
							피해유형<span>중복체크가능</span>
						</dt>
						<dd>
							<ul class="w_25">
								<li><input type="checkbox" id="harm_type_verbals" name="harm_type_verbals" value="Y" <c:if test="${data.harm_type_verbals eq 'Y'}">checked</c:if>><label for="harm_type_verbals"> 언어적 성희롱</label></li>
								<li><input type="checkbox" id="harm_type_body" name="harm_type_body" value="Y" <c:if test="${data.harm_type_body eq 'Y'}">checked</c:if>><label for="harm_type_body"> 신체적 성희롱</label></li>
								<li><input type="checkbox" id="harm_type_visual" name="harm_type_visual" value="Y" <c:if test="${data.harm_type_visual eq 'Y'}">checked</c:if>><label for="harm_type_visual"> 시각적 성희롱</label></li>
								<li><input type="checkbox" id="harm_type_second" name="harm_type_second" value="Y" <c:if test="${data.harm_type_second eq 'Y'}">checked</c:if>><label for="harm_type_second"> 2차 피해</label></li>
								<li class="w_100"><input type="checkbox" id="harm_type_etc" name="harm_type_etc" value="Y" <c:if test="${data.harm_type_etc eq 'Y'}">checked</c:if>><label for="harm_type_etc"> 기타 (직접입력)</label>
								<div class="input_box w_220"> <input type="text" id="harm_etc_txt" name="harm_etc_txt" placeholder="기타유형을 입력해주세요." value="${data.harm_etc_txt}"></div></li>
							</ul>
						</dd>
					</dl>
					<dl>
						<dt>사건 진행단계</dt>
						<dd>
							<ul class="w_25">
								<li><input type="radio" id="accident_step_1" name="accident_step" value="step1" <c:if test="${data.accident_step eq 'step1'}">checked</c:if>><label for="accident_step_1"> 인지 및 접수 (삼당)</label></li>
								<li><input type="radio" id="accident_step_2" name="accident_step" value="step2" <c:if test="${data.accident_step eq 'step2'}">checked</c:if>><label for="accident_step_2"> 조사</label></li>
								<li><input type="radio" id="accident_step_3" name="accident_step" value="step3" <c:if test="${data.accident_step eq 'step3'}">checked</c:if>><label for="accident_step_3"> 고충심의위원회</label></li>
								<li><input type="radio" id="accident_step_4" name="accident_step" value="step4" <c:if test="${data.accident_step eq 'step4'}">checked</c:if>><label for="accident_step_4"> 종결 (후속조치)</label></li>
							</ul>
						</dd>
					</dl>
					<dl>
						<dt>
							기타(직접입력)<span>사건 관련 특이사항 등</span>
						</dt>
						<dd>
							<div class="text_area" style="width:94%">
								<label class="textareaContainer"><textarea id="application_etc_txt" name="application_etc_txt" rows="2" style="resize: none;" placeholder="기타 신고사건 현황을 입력해주세요.">${data.application_etc_txt}</textarea></label>
							</div>
						</dd>
					</dl>

					<p class="tit">희망분야<span class="span01">중복체크</span><span class="span02">진단 일정 및 내용은 선정 후 <em></em>기관과 협의하여 확정합니다.</span>
					</p>
					<dl>
						<dt><input type="radio" id="acc_1" name="acc_exists_yn" value="1" <c:if test="${data.acc_exists_yn eq '1'}">checked</c:if>>사건처리이력<br>없는 기관</dt>
						<dd id="acc1td">
							<ul class="w_100">
								<li><div class="check_box">
										<input type="checkbox" id="first_org_type_all" class="num01" name="first_org_type_all" value="Y" <c:if test="${data.first_org_type_all eq 'Y'}">checked</c:if>>
											<label for="first_org_type_all"> 전수 설문조사 (조직문화 및 성희롱 성폭력 실태 파악) ※ 진단 시 필수영역</label>
									</div></li>
								<li><div class="check_box">
										<input type="checkbox" id="first_org_type_inorg" class="num02" name="first_org_type_inorg" value="Y" <c:if test="${data.first_org_type_inorg eq 'Y'}">checked</c:if>>
											<label for="first_org_type_inorg"> 기관 내 성희롱ㆍ성폭력 사건처리 절차 및 제도* 자문<span>* 성희롱 방지조치, 폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span>
										</label>
									</div></li>
								<li><div class="check_box">
										<input type="checkbox" id="first_org_type_protect" class="num03" name="first_org_type_protect" value="Y" <c:if test="${data.first_org_type_protect eq 'Y'}">checked</c:if>>
											<label for="first_org_type_protect"> 피해자 보호, 2차 피해 방지 방안 자문</label>
									</div></li>
								<li>
									<div class="check_box">
										<input type="checkbox" id="first_org_type_etc" class="num05" name="first_org_type_etc" value="Y" <c:if test="${data.first_org_type_etc eq 'Y'}">checked</c:if>>
											<label for="first_org_type_etc"> 기타(직접 작성)</label>
									</div>
									<div class="text_area">
										<label class="textareaContainer">
											<textarea id="first_org_type_etc_txt" name="first_org_type_etc_txt" rows="2" style="resize: none;" placeholder="기타 의견을 입력해주세요.">${data.first_org_type_etc_txt}</textarea></label>
									</div>
								</li>
							</ul>
						</dd>
					</dl>
					<dl>
						<dt><input type="radio" id="acc_2" name="acc_exists_yn" value="2" <c:if test="${data.acc_exists_yn eq '2'}">checked</c:if>>사건처리이력<br>있는 기관</dt>
						<dd id="acc2td">
							<ul class="w_100">
								<li><div class="check_box">
										<input type="checkbox" id="dup_org_type_check" class="num01" name="dup_org_type_check" value="Y" <c:if test="${data.dup_org_type_check eq 'Y'}">checked</c:if>>
											<label for="dup_org_type_check"> 기관 내 성희롱ㆍ성폭력 사건처리절차 검토 및 자문</label>
									</div></li>
								<li><div class="check_box">
										<input type="checkbox" id="dup_org_type_protect" class="num02" name="dup_org_type_protect" value="Y" <c:if test="${data.dup_org_type_protect eq 'Y'}">checked</c:if>>
											<label for="dup_org_type_protect"> 피해자 보호, 2차 피해 방지 및 재발방지대책 수립 자문</label>
									</div></li>
								<li><div class="check_box">
										<input type="checkbox" id="dup_org_type_all" class="num03" name="dup_org_type_all" value="Y" <c:if test="${data.dup_org_type_all eq 'Y'}">checked</c:if>>
											<label for="dup_org_type_all"> 전수 설문조사 (조직문화 및 성희롱 성폭력 실태 파악) ※ 진단 시 필수영역</label>
									</div></li>
								<li><div class="check_box">
										<input type="checkbox" id="dup_org_type_inorg" class="num03" name="dup_org_type_inorg" value="Y" <c:if test="${data.dup_org_type_inorg eq 'Y'}">checked</c:if>>
											<label for="dup_org_type_inorg"> 기관 내 성희롱ㆍ성폭력 사건처리 제도*자문 <span>* 폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span></label>
									</div></li>
								<li>
									<div class="check_box">
										<input type="checkbox" id="dup_org_type_etc" class="num05" name="dup_org_type_etc" value="Y" <c:if test="${data.dup_org_type_etc eq 'Y'}">checked</c:if>>
											<label for="dup_org_type_etc"> 기타(직접 작성)</label>
									</div>
									<div class="text_area">
										<label class="textareaContainer">
											<textarea id="dup_org_type_etc_txt" name="dup_org_type_etc_txt" rows="2" style="resize: none;" placeholder="기타 의견을 입력해주세요.">${data.dup_org_type_etc_txt}</textarea></label>
									</div>
								</li>
							</ul>
						</dd>
					</dl>

					<p class="tit">
						비고<span class="span01">가능한 시기 모두 체크해주세요</span>
					</p>
					<dl>
						<dt>
							진단<br>가능 시기
						</dt>
						<dd>
								<ul class="table">
	                                <li>
	                                    <dl>
	                                        <dt>${fn:substring(data.wish_consulting_date_1,2,4)}년 ${fn:substring(data.wish_consulting_date_1,4,6)}분기 
	                                        	<input type="hidden" id="wish_consulting_date_1" name="wish_consulting_date_1" value="${data.wish_consulting_date_1}">
	                                        </dt>
	                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_1_yn" id="wish_consulting_date_1_yn" value="Y" <c:if test="${data.wish_consulting_date_1_yn eq 'Y'}">checked</c:if>><label for="wish_consulting_date_1_yn"></label></div></dd>
	                                    </dl>
	                                </li>
	                                <li>
	                                    <dl>
	                                        <dt>${fn:substring(data.wish_consulting_date_2,2,4)}년 ${fn:substring(data.wish_consulting_date_2,4,6)}분기 
	                                        	<input type="hidden" id="wish_consulting_date_2" name="wish_consulting_date_2" value="${data.wish_consulting_date_2}">
	                                        </dt>
	                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_2_yn" id="wish_consulting_date_2_yn" value="Y" <c:if test="${data.wish_consulting_date_2_yn eq 'Y'}">checked</c:if>><label for="wish_consulting_date_2_yn"></label></div></dd>
	                                    </dl>
	                                </li>
	                                <li>
	                                    <dl>
	                                        <dt>${fn:substring(data.wish_consulting_date_3,2,4)}년 ${fn:substring(data.wish_consulting_date_3,4,6)}분기
	                                        	<input type="hidden" id="wish_consulting_date_3" name="wish_consulting_date_3" value="${data.wish_consulting_date_3}">
	                                       	</dt>
	                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_3_yn" id="wish_consulting_date_3_yn" value="Y" <c:if test="${data.wish_consulting_date_3_yn eq 'Y'}">checked</c:if>><label for="wish_consulting_date_3_yn"></label></div></dd>
	                                    </dl>
	                                </li>
	                                <li>
	                                    <dl>
	                                        <dt>${fn:substring(data.wish_consulting_date_4,2,4)}년 ${fn:substring(data.wish_consulting_date_4,4,6)}분기
	                                        	<input type="hidden" id="wish_consulting_date_4" name="wish_consulting_date_4" value="${data.wish_consulting_date_4}">
	                                        </dt>
	                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_4_yn" id="wish_consulting_date_4_yn" value="Y" <c:if test="${data.wish_consulting_date_4_yn eq 'Y'}">checked</c:if>><label for="wish_consulting_date_4_yn"></label></div></dd>
	                                    </dl>
	                                </li>
	                            </ul>
							<div class="text_area">
								<label class="textareaContainer"><textarea
										id="reference_etc" name="reference_etc" rows="3"
										style="resize: none;" placeholder="기관 특성 등 사전에 참고해야 할 사항 등">${data.reference_etc}</textarea></label>
							</div>
						</dd>
					</dl>
					<div class="btn_box">
						<ul>
							<!-- <li><a href="">취소</a></li> -->
							<c:if test="${data.step_status eq 1}">
							<li><a href="javascript:editApplicationInfo();void(0);"
								id="registration_application" class="b_feac25">수정</a></li>
							</c:if>
						</ul>
					</div>
				</form:form>
			<!-- </div> -->
			<!-- appliation stop -->
<!-- </div> -->
<script>
	var g_step_status = '${data.step_status}';
	var g_acc_exists_yn = '${data.acc_exists_yn}';
	
	$(function(){
		if ( g_step_status != 1) {
			$('#showDetailApplication input').attr('disabled', 'disabled');
			$('#showDetailApplication select').attr('disabled', 'disabled');
			$('#showDetailApplication textarea').attr('disabled', 'disabled');
		}
		
		if ( g_acc_exists_yn != '') {
			if ( g_acc_exists_yn == '1') {
				acc1_2OnOff(1);
			} else if ( g_acc_exists_yn == '2') {
				acc1_2OnOff(2);
			}	
		}
		
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
	});
	
	function editApplicationInfo(no){

			// 필수값 체크	
			if (confirm("수정 하시겠습니까?")) {
				var formValue = $("#editAppFrm").serialize();

				$.ajax({
					type : 'POST',
					url : "/frontsys/application/editApplicationInfo.html",
					data : formValue,
					success : function(result) {
						if (result.resultCode == "SUCCESS") {
							var lastInsertNo = result.NO;
							$("#step_one").show();
					        //var offset = $("#step_one").offset();console.log("adasdf",offset);
					        $('html, body').animate({scrollTop : 100}, 400);

						} else {
							alert("수정에 실패 하였습니다.");
						}
					},
					error : function() {
						alert("수정중 오류가 발생하였습니다.");
					}
				})
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
</script>
