<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="content">
    <div class="sub_top_wrap">
        <div class="w_1170">
            <div class="sub_top bg03">
                <p>성희롱 방지 조직문화 진단 신청</p>
                <div class="loca"><a href="">홈</a><span>성희롱 방지 조직문화 진단 신청</span></div>
            </div>
        </div>
    </div>
    <div class="cont_wrap">
        <div class="w_1170">
            <div class="left_cont">
                <p>성희롱 방지 조직문화 진단 신청</p>
            </div>
            <div class="right_cont">
                <p class="p_t">성희롱 방지 조직문화 진단 신청서</p>
                <form id="FrontApplicationVo" name="FrontApplicationVo" class="application">
                    <p class="tit">기관 정보</p>
                    <dl>
                        <dt>유형</dt>
                        <dd>
                            <input type="radio" id="org_type_1" name="org_type" value="gov"><label for="org_type_1"> 공공</label>
                            <input type="radio" id="org_type_2" name="org_type" value="priv"><label for="org_type_2"> 민간</label>
                        </dd>
                    </dl>
                    <dl>
                        <dt>기관명</dt>
                        <dd><div class="input_box"><input type="text" id="org_name" name="org_name" placeholder="" value="${org_name}" readonly>
<input type="hidden" id="org_code" name="org_code" value="${org_code}" /></div><input type="button" 
 onclick="openGovSrchPop();" value="기관명 검색"></dd>
                    </dl>
                    <dl>
                        <dt>상급기관</dt>
                        <dd><div class="input_box"><input type="text" id="upper_org_name" name="upper_org_name" placeholder="" readonly>
<input type="hidden" id="upper_org_code" name="upper_org_code" value="" /></div><input type="button" onclick="openUpperGovSrchPop();" value="상급기관 검색"></dd>
                    </dl>
                    <dl>
                        <dt>현원</dt>
                        <dd><div class="input_box w_110"><input type="text" id="org_member_count" name="org_member_count" placeholder=""></div> 명</dd>
                    </dl>

                    <p class="tit">담당자 정보</p>
                    <dl>
                        <dt>소속 및 직위</dt>
                        <dd><div class="input_box"><input type="text" id="belong_job_title" name="belong_job_title" placeholder=""></div></dd>
                    </dl>
                    <dl>
                        <dt>이름</dt>
                        <dd><div class="input_box"><input type="text" id="org_client_name" name="org_client_name" placeholder=""></div></dd>
                    </dl>
                    <dl>
                        <dt>연락처</dt>
                        <dd><div class="input_box"><input type="text" id="org_client_tel_no" name="org_client_tel_no" placeholder=""></div></dd>
                    </dl>
                    <dl>
                        <dt>이메일</dt>
                        <dd><div class="input_box"><input type="text" id="org_client_email" name="org_client_email" placeholder=""></div></dd>
                    </dl>

                    <p class="tit">신고사건 현황</p>
                    <dl>
                        <dt>사건처리이력</dt>
                        <dd>
                            <ul class="w_auto">
                                <li><input type="radio" id="accident_response_hist_1" name="accident_response_hist" value="yes"><label for="accident_response_hist_1"> 유</label></li>
                                <li><input type="radio" id="accident_response_hist_2" name="accident_response_hist" value="no"><label for="accident_response_hist_2"> 무</label></li>
                                <li><input type="radio" id="accident_response_hist_3" name="accident_response_hist" value="none"><label for="accident_response_hist_3"> 발생했으나 공식처리되지 않음</label></li>
                            </ul>
                        </dd>
                    </dl>
                    <dl>
                        <dt>시기(최근)</dt>
                        <dd>
                            <ul>
                                <li>발생시기 <input type="date" id="generation" name="accident_date" value="" min="2019-01-01" max="2122-12-31" placeholder="년/월/일" style="width:160px;"></li>
                                <li>접수시기 <input type="date" id="receipt" name="receipt_date" value="" min="2019-01-01" max="2122-12-31" placeholder="년/월/일" style="width:160px;"></li>
                            </ul>
                        </dd>
                    </dl>
                    <dl>
                        <dt>피해유형<span>중복체크가능</span></dt>
                        <dd>
                            <ul class="w_25">
                                <li><input type="checkbox" id="harm_type_verbals" name="harm_type_verbals" value="Y"><label for="harm_type_verbals"> 언어적 성희롱</label></li>
                                <li><input type="checkbox" id="harm_type_body" name="harm_type_body" value="Y"><label for="harm_type_body"> 신체적 성희롱</label></li>
                                <li><input type="checkbox" id="harm_type_visual" name="harm_type_visual" value="Y"><label for="harm_type_visual"> 시각적 성희롱</label></li>
                                <li><input type="checkbox" id="harm_type_second" name="harm_type_second" value="Y"><label for="harm_type_second"> 2차 피해</label></li>
                                <li class="w_100"><input type="checkbox" id="harm_type_etc" name="harm_type_etc" value="Y"><label for="harm_type_etc"> 기타 (직접입력)</label><div class="input_box w_220"><input type="text" id="harm_etc_txt" name="harm_etc_txt" placeholder="기타유형을 입력해주세요." disabled></div></li>
                            </ul>
                        </dd>
                    </dl>
                    <dl>
                        <dt>사건 진행단계</dt>
                        <dd>
                            <ul class="w_25">
                                <li><input type="radio" id="accident_step_1" name="accident_step" value="step1"><label for="accident_step_1"> 인지 및 접수 (상담)</label></li>
                                <li><input type="radio" id="accident_step_2" name="accident_step" value="step2"><label for="accident_step_2"> 조사</label></li>
                                <li><input type="radio" id="accident_step_3" name="accident_step" value="step3"><label for="accident_step_3"> 고충심의위원회</label></li>
                                <li><input type="radio" id="accident_step_4" name="accident_step" value="step4"><label for="accident_step_4"> 종결 (후속조치)</label></li>
                            </ul>
                        </dd>
                    </dl>
                    <dl>
                        <dt>기타(직접입력)<span>사건 관련 특이사항 등</span></dt>
                        <dd>
                            <div class="text_area">
                                <label class="textareaContainer"><textarea id="application_etc_txt" name="application_etc_txt" rows="2" style="resize: none;" placeholder="기타 신고사건 현황을 입력해주세요."></textarea></label>
                            </div>
                        </dd>
                    </dl>

                    <p class="tit">희망분야<span class="span01">중복체크</span><span class="span02">진단 일정 및 내용은 선정 후 <em></em>기관과 협의하여 확정합니다.</span></p>
                    <dl>
                        <dt><input type="radio" id="acc_1" name="acc_exists_yn" value="1">사건처리이력<br>없는 기관</dt>
                        <dd id="acc1td">
                            <ul class="w_100">
                                <li><div class="check_box"><input type="checkbox" id="first_org_type_all" class="num01" name="first_org_type_all" value="Y" checked onclick="return false;"><label for="first_org_type_all"> 전수 설문조사 (조직문화 및 성희롱 성폭력 실태 파악) ※ 진단 시 필수영역</label></div></li>
                                <li><div class="check_box"><input type="checkbox" id="first_org_type_inorg" class="num02" name="first_org_type_inorg" value="Y"><label for="first_org_type_inorg"> 기관 내 성희롱ㆍ성폭력 사건처리 절차 및 제도* 자문<span>* 성희롱 방지조치, 폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span></label></div></li>
                                <li><div class="check_box"><input type="checkbox" id="first_org_type_protect" class="num03" name="first_org_type_protect" value="Y"><label for="first_org_type_protect"> 피해자 보호, 2차 피해 방지 방안 자문</label></div></li>
                                <li>
                                    <div class="check_box"> <input type="checkbox" id="first_org_type_etc" class="num05" name="first_org_type_etc" value="Y"><label for="first_org_type_etc"> 기타(직접 작성)</label></div>
                                    <div class="text_area">
                                        <label class="textareaContainer"><textarea id="first_org_type_etc_txt" name="first_org_type_etc_txt" rows="2" style="resize: none;" disabled placeholder="기타 의견을 입력해주세요."></textarea></label>
                                    </div>
                                </li>
                            </ul>
                        </dd>
                    </dl>
                    <dl>
                        <dt><input type="radio" id="acc_2" name="acc_exists_yn" value="2">사건처리이력<br>있는 기관</dt>
                        <dd id="acc2td">
                            <ul class="w_100">
                                <li><div class="check_box"><input type="checkbox" id="dup_org_type_check" class="num01" name="dup_org_type_check" value="Y"><label for="dup_org_type_check"> 기관 내 성희롱ㆍ성폭력 사건처리절차 검토 및 자문</label></div></li>
                                <li><div class="check_box"><input type="checkbox" id="dup_org_type_protect" class="num02" name="dup_org_type_protect" value="Y"><label for="dup_org_type_protect"> 피해자 보호, 2차 피해 방지 및 재발방지대책 수립 자문</label></div></li>
                                <li><div class="check_box"><input type="checkbox" id="dup_org_type_all" class="num03" name="dup_org_type_all" value="Y" checked onclick="return false;"><label for="dup_org_type_all"> 전수 설문조사 (조직문화 및 성희롱ㆍ성폭력 실태 파악) ※ 진단 시 필수영역</label></div></li>
                                <li><div class="check_box"><input type="checkbox" id="dup_org_type_inorg" class="num03" name="dup_org_type_inorg" value="Y"><label for="dup_org_type_inorg"> 기관 내 성희롱ㆍ성폭력 사건처리 제도*자문 <span>*  폭력예방교육, 성희롱ㆍ성폭력 예방지침 등</span></label></div></li>
                                <li>
                                    <div class="check_box"> <input type="checkbox" id="dup_org_type_etc" class="num05" name="dup_org_type_etc" value="Y"><label for="dup_org_type_etc"> 기타(직접 작성)</label></div>
                                    <div class="text_area">
                                        <label class="textareaContainer"><textarea id="dup_org_type_etc_txt" name="dup_org_type_etc_txt" rows="2" style="resize: none;" disabled placeholder="기타 의견을 입력해주세요."></textarea></label>
                                    </div>
                                </li>
                            </ul>
                        </dd>
                    </dl>

                    <p class="tit">비고<span class="span01">가능한 시기 모두 체크해주세요</span></p>
						<input type="hidden" id="wish_consulting_date_1" name="wish_consulting_date_1" value="">
						<input type="hidden" id="wish_consulting_date_2" name="wish_consulting_date_2" value="">
						<input type="hidden" id="wish_consulting_date_3" name="wish_consulting_date_3" value="">
						<input type="hidden" id="wish_consulting_date_4" name="wish_consulting_date_4" value="">
						<input type="hidden" id="wish_consulting_date_5" name="wish_consulting_date_5" value="">
                    <dl>
                        <dt>진단<br>가능 시기</dt>
                        <dd>
                            <ul class="table">
                                <li>
                                    <dl>
                                        <dt id="w1ym"></dt>
                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_1_yn" id="wish_consulting_date_1_yn" value="Y"><label for="wish_consulting_date_1_yn"></label></div></dd>
                                    </dl>
                                </li>
                                <li>
                                    <dl>
                                        <dt id="w2ym"></dt>
                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_2_yn" id="wish_consulting_date_2_yn" value="Y"><label for="wish_consulting_date_2_yn"></label></div></dd>
                                    </dl>
                                </li>
                                <li>
                                    <dl>
                                        <dt id="w3ym"></dt>
                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_3_yn" id="wish_consulting_date_3_yn" value="Y"><label for="wish_consulting_date_3_yn"></label></div></dd>
                                    </dl>
                                </li>
                                <li>
                                    <dl>
                                        <dt id="w4ym"></dt>
                                        <dd><div class="check_box"><input type="checkbox" name="wish_consulting_date_4_yn" id="wish_consulting_date_4_yn" value="Y"><label for="wish_consulting_date_4_yn"></label></div></dd>
                                    </dl>
                                </li>
                            </ul>
                            <div class="text_area">
                                <label class="textareaContainer"><textarea id="reference_etc" name="reference_etc" rows="3" style="resize: none;" placeholder="기관 특성 등 사전에 참고해야 할 사항 등"></textarea></label>
                            </div>
                        </dd>
                    </dl>
                    <div class="btn_box">
                        <ul>
                            <li><a href="/?menuno=249">취소</a></li>
                            <li><a href="javascript:void(0);" id="registration_application" class="b_feac25">완료</a></li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

    <div class="popup_wrap" id="step_one">
        <div class="bg"></div>
        <div class="popup">
            <div class="popcon">
                <p class="pop_t">신청 완료</p>
                <div class="join_complete">
                    <p>성희롱 방지 조직문화 진단<br>신청이 완료되었습니다.<br>관련 문의는  02-735-7544로<br>부탁드립니다.</p>
                    <span class="btn_close" onclick="goAppList();">확인</span>
                </div>
            </div>
        </div>
    </div>

   <div class="popup_wrap" id="gov_srch_pop">
        <div class="bg"></div>
        <div class="popup w_720">
            <div class="agency_search_popcon">
                <p class="pop_t" id="govSrchTitle">기관 조회</p>
                <div class="agency_search">
                        <div class="search_box"><div class="input_box"><input type="text" id="srch_org_name" name="srch_org_name" placeholder="기관명을 입력해주세요." value=""></div><button type="button" onclick="srchList()">검색</button></div>
                        <div class="search_list">
                            <table id="resultTable">
								<tr>
                                    <th class=\"t_right\">번호</th>
                                    <th>기관명</th>
                               </tr>
                            </table>
                        </div>
                        <p>기관 조회가 안 되실 경우 시스템 관리자 02-735-7544로 문의 부탁드립니다.</p>
                        <div class="btn_box">
                            <ul>
                                <li><a href="javascript:$('#gov_srch_pop').hide();">취소</a></li>
                                <!--<li><a href="" class="b_feac25">완료</a></li>-->
                            </ul>
                        </div>
                </div>
            </div>
        </div>
    </div>


<script>
	$(function(){
    	$("#acc_1").click(function(){
			acc1_2OnOff(1);
    	});
    	
    	$("#acc_2").click(function(){
    		acc1_2OnOff(2);
    	});
		
    	$("[id^=first_org_type_]").click(function(){
			if ( !$(this).attr('id') == 'first_org_type_etc_txt'){
				acc1_2OnOff(1);
			}
    	});
    	
    	$("[id^=dup_org_type_]").click(function(){
			if ( !$(this).attr('id') == 'dup_org_type_etc_txt'){
				acc1_2OnOff(2);
			}
    	});

   		$("#step_one").hide();
   		$("#gov_srch_pop").hide();
		calcWishYearQ();
		
		$("#registration_application").click(function(){
			// 필수값 체크
			if ( $("#first_org_type_etc").is(':checked') && $("#first_org_type_etc_txt").val() == '' ) {
				alert("사건처리이력 없는 기관의 기타(직접 작성)항목이 선택되어 있을때는\n 기타의견을 입력해 주시기 바랍니다.");
				$("#first_org_type_etc_txt").focus();
				return;
			}

			if ( $("#dup_org_type_etc").is(':checked') && $("#dup_org_type_etc_txt").val() == '' ) {
				alert("사건처리이력 있는 기관의 기타(직접 작성)항목이 선택되어 있을때는\n 기타의견을 입력해 주시기 바랍니다.");
				$("#dup_org_type_etc_txt").focus();
				return;
			}

			if ( $("#harm_type_etc").is(':checked') && $("#harm_etc_txt").val() == '' ) {
				alert("신고사건 현황의 기타(직접입력)항목이 선택되어 있을때는\n 기타내용을 입력해 주시기 바랍니다.");
				$("#harm_etc_txt").focus();
				return;
			}

			if(confirm("등록 하시겠습니까?")){	
				var formValue = $("#FrontApplicationVo").serialize();

				$.ajax({
					  type: 'POST',
					  url: "/frontsys/application/registrationApplication.html",
					  data: formValue,
					  success: function(result){
						  if ( result.resultCode== "SUCCESS" ) {
							  		var lastInsertNo = result.NO;
								$("#step_one").show();
								$('html, body').animate({scrollTop : 100}, 400);
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

		$('#first_org_type_etc').change(function() {
        		if(this.checked) {
		           $("#first_org_type_etc_txt").attr("disabled", false);
		        } else {
		           $("#first_org_type_etc_txt").attr("disabled", true);
		           $("#first_org_type_etc_txt").val("");
				}
		});

		$('#dup_org_type_etc').change(function() {
        		if(this.checked) {
		           $("#dup_org_type_etc_txt").attr("disabled", false);
		        } else {
		           $("#dup_org_type_etc_txt").attr("disabled", true);
		           $("#dup_org_type_etc_txt").val("");
				}
		});

		$('#harm_type_etc').change(function() {
        		if(this.checked) {
		           $("#harm_etc_txt").attr("disabled", false);
		        } else {
		           $("#harm_etc_txt").attr("disabled", true);
		           $("#harm_etc_txt").val("");
				}
		});

		$("#srch_org_name").keypress(function(e) {
		    if (e.keyCode == 13){
        		srchList();
		    }
		});

	});

		function goAppList(){
				popup_close();
				location.href="/?menuno=260";
		}

		function openGovSrchPop(){
				$("#srch_org_name").val("");
				g_type = "gov";
				var resultObj ="<tr><th class=\"t_right\" style=\"width:67px\">번호</th><th style=\"width:534px\">기관명</th></tr>";
				$("#resultTable").html(resultObj);
				$("#govSrchTitle").text("기관 조회");
				$("#gov_srch_pop").show();
		}

		function openUpperGovSrchPop(){
				$("#srch_org_name").val("");
				g_type = "upper";
				var resultObj ="<tr><th class=\"t_right\" style=\"width:67px\">번호</th><th style=\"width:534px\">기관명</th></tr>";
				$("#resultTable").html(resultObj);
				$("#govSrchTitle").text("상급 기관 조회");
				$("#gov_srch_pop").show();
		}

		function srchList(){

				if ( $("#srch_org_name").val()==''){
						alert("검색어를 입력해 주세요.");
						$("#srch_org_name").focus();
						return;
				}
				$.ajax({
					  type: 'POST',
					  url: "/frontsys/application/srchGovList.html",
					  data: {org_name:$("#srch_org_name").val()},
					  success: function(result){
						  if ( result.resultCode== "SUCCESS" ) {
								$("#resultTable").html("");
								for( var i=0;  i < result.gList.length; i++ ) {
										var resultObj = "<tr style=\"cursor: pointer;\">"+
                                		    "<td>"+(i+1)+"</td>"+
                               		     "<td onclick=\"govlistClick('"+result.gList[i].org_code+"','"+result.gList[i].org_name+"')\">"+result.gList[i].org_name+"</td>"+
                                			"</tr>";
										$("#resultTable").append(resultObj );
								}

						  } else {
							  alert("기관 조회에 실패 하였습니다.");
						  }
					  },
					  error:function(){
						  alert("기관 조회중 오류가 발생하였습니다.");  
					  }
				})
		}
		var g_type = "gov";
		function govlistClick(code, name){
				if ( g_type == "gov" ) {
					$("#org_name").val(name);
					$("#org_code").val(code);
				} else if ( g_type == "upper" ) {
					$("#upper_org_name").val(name);
					$("#upper_org_code").val(code);
				} 

				$("#gov_srch_pop").hide();
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

	function acc1_2OnOff(arg1){
		
		if ( arg1 == '1' ) {
		    $("#acc_1").prop("checked", true); 
			$("[id^=first_org_type_][type=checkbox]").attr("disabled", false);
			$("#first_org_type_etc_txt").attr("disabled", true);
			
			$("[id^=dup_org_type_][type=checkbox]").prop("checked", false);
    		$("[id^=dup_org_type_][type=checkbox]").attr("disabled", true);
    		
    		$("#dup_org_type_etc_txt").val("");
    		$("#dup_org_type_etc_txt").attr("disabled", true);

    		$("#acc1td").css("background-color", "");
    		$("#acc2td").css("background-color", "#DCDCDC");    		
    		
		} else if ( arg1 == '2' ) {
		    $("#acc_2").prop("checked", true); 
			$("[id^=dup_org_type_][type=checkbox]").attr("disabled", false);
			$("#dup_org_type_etc_txt").attr("disabled", true);
			
			$("[id^=first_org_type_][type=checkbox]").prop("checked", false);
    		$("[id^=first_org_type_][type=checkbox]").attr("disabled", true);
    		
    		$("#first_org_type_etc_txt").val("");
    		$("#first_org_type_etc_txt").attr("disabled", true);
    		
    		$("#acc1td").css("background-color", "#DCDCDC");
    		$("#acc2td").css("background-color", "");
		}		
	}
</script>
