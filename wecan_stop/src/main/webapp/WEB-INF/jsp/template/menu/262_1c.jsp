<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="content">
    <div class="cont_wrap">
        <div class="cont">
            <p class="p_t t_center">담당자 회원가입</p>
            <form id="frm" name="frm" method="post" class="manager_join">
            	<input type="hidden" id="duplicationYn" name="duplicationYn" value="">
				<input type="hidden" id="crtfcNo" name="crtfcNo" value="">
				<input type="hidden" id="crtfcYn" name="crtfcYn" value="">
				<dl>
                    <dt>아이디</dt>
                    <dd><div class="input_box"><input type="text" id="userid" name="userid" value="" placeholder="아이디를 입력하세요." maxlength="20"></div></dd>
                </dl>
                <dl>
                    <dt>이름</dt>
                    <dd><div class="input_box"><input type="text" id="username" name="username" value="" placeholder="이름을 입력하세요." maxlength="50"></div></dd>
                </dl>
                <dl>
                    <dt>이메일</dt>
                    <dd><div class="input_box"><input type="text" id="email" name="email" value="" placeholder="이메일을 입력하세요." maxlength="50"></div><input type="button" id="emailCrtfc" value="인증하기"></dd>
                </dl>
                <dl>
                    <dt>인증번호 입력</dt>
                    <dd><div class="input_box"><input type="text" id="userCode" name="userCode" value="" placeholder="인증번호를 입력하세요." maxlength="6"></div><input type="button" id="crtfc_btn" value="확인"><em id="timer"></em><em id="crtfc_txt" style="display:none;">인증이 완료되었습니다.</em></dd>
                </dl>
                <dl>
                    <dt>비밀번호</dt>
                    <dd><div class="input_box"><input type="password" id="passwd" name="passwd" value="" placeholder="비밀번호를 입력하세요." maxlength="20"></div><em>비밀번호는 영문,숫자,특수문자 포함 8자리 이상으로 입력해주세요.</em></dd>
                </dl>
                <dl>
                    <dt>비밀번호 확인</dt>
                    <dd><div class="input_box"><input type="password" id="passwdConfirm" name="passwdConfirm" value="" placeholder="비밀번호 확인을 입력하세요." maxlength="20"></div></dd>
                </dl>
                <dl>
                    <dt>핸드폰번호</dt>
                    <dd><div class="input_box"><input type="text" id="mobile" name="mobile" value="" placeholder="핸드폰번호를 입력하세요." maxlength="13"></div></dd>
                </dl>
				<br><br>
				<p style="font-size:10pt;">한국여성인권진흥원은 개인정보 보호법에 따라 성희롱 방지 조직진단관리시스템의 회원가입을 통한 서비스 제공을 위하여 아래와 같이 개인정보를 수집·이용하고자 합니다. 내용을 자세히 읽으신 후 동의 여부를 결정하여 주십시오.</p>
				<p><span>□ 개인정보 수집·이용 내역 안내(필수사항)</span></p>
				<table class="main_table1" summary="개인정보 수집·이용 내역 안내" style="border:1px solid;">
	                 <colgroup>
	                     <col width="30%" />
	                     <col width="30%" />
	                     <col />
	                 </colgroup>
	                 <thead>
	                     <tr>
	                        <th style="border:1px solid;">수집목적</th>
	                        <th style="border:1px solid;">수집 항목</th>
	                        <th style="border:1px solid;">보유기간</th>
	                     </tr>
	                 </thead>
	                 <tbody>
	                     <tr>
	                         <td style="text-align:center;border:1px solid;">회원가입 및 관리,<br>성희롱 방지 조직문화 진단 신청 서비스</td>
	                         <td style="text-align:center;border:1px solid;">아이디, 비밀번호, 이름,<br> 이메일주소, 핸드폰번호</td>
	                         <td style="text-align:center;color:red;border:1px solid black;">회원탈퇴시 까지</td>
	                     </tr>  
	                 </tbody>
	            </table>
				<p style="font-size:10pt;">※ 위의 개인정보 수집‧이용에 대한 동의를 거부할 권리가 있습니다. 그러나 동의를 거부할 경우 회원가입 및 관리, 성희롱 방지 조직문화 진단 신청 서비스에 제한될 수 있습니다.</p>
                <div class="check_box">
                    위와 같이 개인정보를 수집·이용하는데 동의하십니까?  <input type="radio" id="agree_check1" name="agree_check" value="Y"><label for="agree_check1">동의</label> <input type="radio" id="agree_check2" name="agree_check" value="N" checked><label for="agree_check2">미동의</label>
                </div>
                <div class="btn_box">
                    <ul>
                        <li><a href="/?menuno=261">취소</a></li>
                        <li><a href="javascript:joinUser();" class="b_feac25">완료</a></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</div>
