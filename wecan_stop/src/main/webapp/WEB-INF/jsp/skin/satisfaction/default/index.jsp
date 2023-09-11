<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <title>한국여성인권진흥원</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta name="description" id="description" content="" />
    <meta name="keywords" id="keywords" content=""><meta name="Resource-type" content="Document">
    <meta name="Resource-type" content="Document" />
    <meta property="og:type" content="website">
    <meta property="og:title" content="한국여성인권진흥원">
    <meta property="og:description" content="">
    <meta property="og:image" content="">
    <meta property="og:url" content="">

    <link href="/usr/css/base.css" rel="stylesheet" media="all">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="/usr/js/common.js"></script>
	
	<script>
	
	function submit(){	
		if(checkForm()){
			$.ajax({
				type: "POST"
				,url: "/frontsys/satisfaction/cSatisfactionResult.html"
		    	,data: $("#frm").serialize()
		    	,dataType: "json"
				,async: false
		    	,success: function(data){
		    		if(data.resultCode == "success"){
						alert("만족도 조사를 완료하였습니다.");
						location.href = "/?menuno=266"
		        	}else{
		        		alert("만족도조사 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
		       		}
		    	},error: function(data){
		       		alert("만족도조사 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
		    	} 
		 	});
		}
		
	}
	
	function checkForm() {
	    
		if(!$('input:radio[name=chk01]').is(':checked')){
			alert("만족도조사 1번항목을 선택하세요.");
			$('input:radio[name=chk01]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=chk01]:checked').val() == "6"){
			if($('#text01').val() == ""){
				alert("만족도조사 1번항목 기타 의견을 입력하세요.");
				$('#text01').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=chk02]').is(':checked')){
			alert("만족도조사 2번항목을 선택하세요.");
			$('input:radio[name=chk02]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=chk02]:checked').val() == "4"
			|| $('input:radio[name=chk02]:checked').val() == "5"){
			if($('#text02').val() == ""){
				alert("만족도조사 2번항목 의견을 입력하세요.");
				$('#text02').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=chk03]').is(':checked')){
			alert("만족도조사 3번항목을 선택하세요.");
			$('input:radio[name=chk03]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=chk03]:checked').val() == "4"
			|| $('input:radio[name=chk03]:checked').val() == "5"){
			if($('#text03').val() == ""){
				alert("만족도조사 3번항목 의견을 입력하세요.");
				$('#text03').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=chk04]').is(':checked')){
			alert("만족도조사 4번항목을 선택하세요.");
			$('input:radio[name=chk04]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=chk04]:checked').val() == "4"
			|| $('input:radio[name=chk04]:checked').val() == "5"){
			if($('#text04').val() == ""){
				alert("만족도조사 4번항목 의견을 입력하세요.");
				$('#text04').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=chk05]').is(':checked')){
			alert("만족도조사 5번항목을 선택하세요.");
			$('input:radio[name=chk05]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=chk05]:checked').val() == "4"
			|| $('input:radio[name=chk05]:checked').val() == "5"){
			if($('#text05').val() == ""){
				alert("만족도조사 5번항목 의견을 입력하세요.");
				$('#text05').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=chk06]').is(':checked')){
			alert("만족도조사 6번항목을 선택하세요.");
			$('input:radio[name=chk06]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=chk06]:checked').val() == "4"
			|| $('input:radio[name=chk06]:checked').val() == "5"){
			if($('#text06').val() == ""){
				alert("만족도조사 6번항목 의견을 입력하세요.");
				$('#text06').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=chk07]').is(':checked')){
			alert("만족도조사 7번항목을 선택하세요.");
			$('input:radio[name=chk07]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=chk07]:checked').val() == "4"
			|| $('input:radio[name=chk07]:checked').val() == "5"){
			if($('#text07').val() == ""){
				alert("만족도조사 7번항목 의견을 입력하세요.");
				$('#text07').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=chk08]').is(':checked')){
			alert("만족도조사 8번항목을 선택하세요.");
			$('input:radio[name=chk08]:eq(0)').focus();
			return false;
		}
		
		return true;
	}
	
	</script>
</head>
<body id = "body">
<div class="content">
    <div class="sub_top_wrap">
        <div class="w_1170">
            <div class="sub_top bg03">
                <p>조직문화 진단 신청</p>
                <div class="loca"><a href="/?menuno=246">홈</a><span>지원안내</span><span>센터지원 내용</span></div>
            </div>
        </div>
    </div>
    <div class="cont_wrap">
        <div class="w_1170">
            <div class="left_cont">
                <p>조직문화 진단 신청</p>
            </div>
            <div class="right_cont">
                <p class="p_t">성희롱 방지 조직문화 진단 만족도 조사</p>
                <p class="p_t_ment"></p>
                <div class="satisfaction">
                    <form id="frm" name="frm" method="post">
                        <p class="tit">Ⅰ. 기관 현황</p>
                        <dl>
                            <dt>1. 귀 기관의 유형은 무엇인가요?</dt>
                            <dd>
                                <ul>
                                    <li><input type="radio" id="num1_1" class="num01" name="chk01" value="1"><label for="num1_1"> 중앙행정기관</label></li>
                                    <li><input type="radio" id="num1_2" class="num02" name="chk01" value="2"><label for="num1_2"> 지방자치단체</label></li>
                                    <li><input type="radio" id="num1_3" class="num03" name="chk01" value="3"><label for="num1_3"> 공공기관</label></li>
                                    <li><input type="radio" id="num1_4" class="num04" name="chk01" value="4"><label for="num1_4"> 초·중·고교</label></li>
                                    <li><input type="radio" id="num1_5" class="num05" name="chk01" value="5"><label for="num1_5"> 대학교</label></li>
                                    <li class="li_text"><input type="radio" id="num1_6" class="num06" name="chk01" value="6"><label for="num1_6"> 기타(직접 작성)</label>
                                        <div class="text_area">
                                            <label class="textareaContainer"><textarea id="text01" name="text01" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
                                        </div>
                                    </li>
                                </ul>
                            </dd>
                        </dl>

                        <p class="tit">Ⅱ. 진행 만족도</p>
                        <dl>
                            <dt>2. 조직문화 진단 실시 전 계획과 내용에 대해 충분한 안내를 받으셨습니다?</dt>
                            <dd>
                                <ul>
                                    <li><input type="radio" id="num2_1" class="num01" name="chk02" value="1"><label for="num2_1"> 매우 그렇다</label></li>
                                    <li><input type="radio" id="num2_2" class="num02" name="chk02" value="2"><label for="num2_2"> 그렇다</label></li>
                                    <li><input type="radio" id="num2_3" class="num03" name="chk02" value="3"><label for="num2_3"> 보통이다</label></li>
                                    <li><input type="radio" id="num2_4" class="num04" name="chk02" value="4"><label for="num2_4"> 그렇지 않다</label></li>
                                    <li><input type="radio" id="num2_5" class="num05" name="chk02" value="5"><label for="num2_5"> 매우 그렇지 않다</label></li>
                                </ul>
                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
                                <div class="text_area">
                                    <label class="textareaContainer"><textarea id="text02" name="text02" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>3. 이번 조직문화 진단 진행방식에 만족하셨습니까?</dt>
                            <dd>
                                <ul>
                                    <li><input type="radio" id="num3_1" class="num01" name="chk03" value="1"><label for="num3_1"> 매우 그렇다</label></li>
                                    <li><input type="radio" id="num3_2" class="num02" name="chk03" value="2"><label for="num3_2"> 그렇다</label></li>
                                    <li><input type="radio" id="num3_3" class="num03" name="chk03" value="3"><label for="num3_3"> 보통이다</label></li>
                                    <li><input type="radio" id="num3_4" class="num04" name="chk03" value="4"><label for="num3_4"> 그렇지 않다</label></li>
                                    <li><input type="radio" id="num3_5" class="num05" name="chk03" value="5"><label for="num3_5"> 매우 그렇지 않다</label></li>
                                </ul>
                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
                                <div class="text_area">
                                    <label class="textareaContainer"><textarea id="text03" name="text03" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>4. 자문위원단의 전문성에 만족하셨습니까?</dt>
                            <dd>
                                <ul>
                                    <li><input type="radio" id="num4_1" class="num01" name="chk04" value="1"><label for="num4_1"> 매우 그렇다</label></li>
                                    <li><input type="radio" id="num4_2" class="num02" name="chk04" value="2"><label for="num4_2"> 그렇다</label></li>
                                    <li><input type="radio" id="num4_3" class="num03" name="chk04" value="3"><label for="num4_3"> 보통이다</label></li>
                                    <li><input type="radio" id="num4_4" class="num04" name="chk04" value="4"><label for="num4_4"> 그렇지 않다</label></li>
                                    <li><input type="radio" id="num4_5" class="num05" name="chk04" value="5"><label for="num4_5"> 매우 그렇지 않다</label></li>
                                </ul>
                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
                                <div class="text_area">
                                    <label class="textareaContainer"><textarea id="text04" name="text04" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>5. 자문위원단의 조직문화 진단을 위한 사전 준비가 충분했다고 느끼셨습니까?</dt>
                            <dd>
                                <ul>
                                    <li><input type="radio" id="num5_1" class="num01" name="chk05" value="1"><label for="num5_1"> 매우 그렇다</label></li>
                                    <li><input type="radio" id="num5_2" class="num02" name="chk05" value="2"><label for="num5_2"> 그렇다</label></li>
                                    <li><input type="radio" id="num5_3" class="num03" name="chk05" value="3"><label for="num5_3"> 보통이다</label></li>
                                    <li><input type="radio" id="num5_4" class="num04" name="chk05" value="4"><label for="num5_4"> 그렇지 않다</label></li>
                                    <li><input type="radio" id="num5_5" class="num05" name="chk05" value="5"><label for="num5_5"> 매우 그렇지 않다</label></li>
                                </ul>
                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
                                <div class="text_area">
                                    <label class="textareaContainer"><textarea id="text05" name="text05" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
                                </div>
                            </dd>
                        </dl>
                        <p class="tit">Ⅲ. 현업적용 의견</p>
                        <dl>
                            <dt>6. 이번 조직문화 진단을 통해 그간 궁금했던 사항들을 해결하는 데에 도움이 되었습니까?</dt>
                            <dd>
                                <ul>
                                    <li><input type="radio" id="num6_1" class="num01" name="chk06" value="1"><label for="num6_1"> 매우 그렇다</label></li>
                                    <li><input type="radio" id="num6_2" class="num02" name="chk06" value="2"><label for="num6_2"> 그렇다</label></li>
                                    <li><input type="radio" id="num6_3" class="num03" name="chk06" value="3"><label for="num6_3"> 보통이다</label></li>
                                    <li><input type="radio" id="num6_4" class="num04" name="chk06" value="4"><label for="num6_4"> 그렇지 않다</label></li>
                                    <li><input type="radio" id="num6_5" class="num05" name="chk06" value="5"><label for="num6_5"> 매우 그렇지 않다</label></li>
                                </ul>
                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
                                <div class="text_area">
                                    <label class="textareaContainer"><textarea id="text06" name="text06" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>7. 이번 조직문화 진단을 통해 습득한 내용을 관련 업무에 활용할 수 있다고 생각하십니까?</dt>
                            <dd>
                                <ul>
                                    <li><input type="radio" id="num7_1" class="num01" name="chk07" value="1"><label for="num7_1"> 매우 그렇다</label></li>
                                    <li><input type="radio" id="num7_2" class="num02" name="chk07" value="2"><label for="num7_2"> 그렇다</label></li>
                                    <li><input type="radio" id="num7_3" class="num03" name="chk07" value="3"><label for="num7_3"> 보통이다</label></li>
                                    <li><input type="radio" id="num7_4" class="num04" name="chk07" value="4"><label for="num7_4"> 그렇지 않다</label></li>
                                    <li><input type="radio" id="num7_5" class="num05" name="chk07" value="5"><label for="num7_5"> 매우 그렇지 않다</label></li>
                                </ul>
                                <p><span><img src="/usr/images/sub/btn-number_2.png"></span><span><img src="/usr/images/sub/btn-number_3.png"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
                                <div class="text_area">
                                    <label class="textareaContainer"><textarea id="text07" name="text07" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>8. 이번 조직문화 진단에서 특별히 도움이 되었던 분야는 무엇인가요?</dt>
                            <dd>
                                <ul class="w_auto">
                                    <li><input type="radio" id="num8_1" class="num01" name="chk08" value="1"><label for="num8_1"> 성 고충 사건처리 절차(상담·조사·심의 등)</label></li>
                                    <li><input type="radio" id="num8_2" class="num02" name="chk08" value="2"><label for="num8_2"> 피해자 보호조치 및 2차 피해 방지 </label></li>
                                    <li><input type="radio" id="num8_3" class="num03" name="chk08" value="3"><label for="num8_3"> 성희롱·성폭력 예방지침</label></li>
                                    <li><input type="radio" id="num8_4" class="num04" name="chk08" value="4"><label for="num8_4"> 고충상담창구 및 성고충심의위원회 운영  </label></li>
                                    <li><input type="radio" id="num8_5" class="num05" name="chk08" value="5"><label for="num8_5"> 예방교육 및 재발방지 대책</label></li>
                                </ul>
                                <p>위의 보기 외에 도움이 되었던 점을 말씀해 주세요.</p>
                                <div class="text_area">
                                    <label class="textareaContainer"><textarea id="text08" name="text08" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
                                </div>
                            </dd>
                        </dl>
                        <dl>
                            <dt>9. 이번 조직문화 진단에 개선할 사항이 있다면 자유롭게 말씀해 주세요.</dt>
                            <dd>
                                <div class="text_area">
                                    <label class="textareaContainer"><textarea id="text09" name="text09" rows="7" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
                                </div>
                            </dd>
                        </dl>
                    </form>
                    <div class="btn">
			            <a href="javascript:submit();">제출</a>
			        </div>
			        <div class="popup_wrap" style="display:none;">
				        <div class="bg"></div>
				        <div class="popup">
				            <div class="popcon">
				                <p class="pop_t">만족도 평가 완료</p>
				                <div class="join_complete">
				                    <p>만족도 평가가 완료되었습니다.<br>감사합니다.</p>
				                    <span class="btn_close" onclick="popup_close();">확인</span>
				                </div>
				            </div>
				        </div>
				    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>