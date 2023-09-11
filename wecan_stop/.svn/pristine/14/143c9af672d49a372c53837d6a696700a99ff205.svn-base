<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<div class="content">
    <div class="cont_wrap">
        <div class="cont">
            <p class="p_t t_center">담당자 아이디찾기</p>
            <form id="frm" name="frm" method="post" class="manager_join">
				<input type="hidden" id="crtfcNo" name="crtfcNo" value="">
				<input type="hidden" id="crtfcYn" name="crtfcYn" value="">
                <dl>
                    <dt>이름</dt>
                    <dd><div class="input_box"><input type="text" id="username" name="username" value="" placeholder="이름을 입력해주세요." maxlength="50"></div></dd>
                </dl>
                <dl>
                    <dt>이메일</dt>
                    <dd><div class="input_box"><input type="text" id="email" name="email" value="" placeholder="이메일을 입력해주세요." maxlength="50"></div><input type="button" id="emailCrtfc" value="인증하기"><em class="c_feac25">회원가입 당시 이메일을 모르실 경우 관리자에게 문의바랍니다.</em></dd>
                </dl>
                <dl>
                    <dt>인증번호 입력</dt>
                    <dd><div class="input_box"><input type="text" id="userCode" name="userCode" value="" placeholder="인증번호를 입력해주세요." maxlength="6"></div><input type="button" id="crtfc_btn" value="확인"><em id="timer"></em><em id="crtfc_txt" style="display:none;">인증이 완료되었습니다.</em></dd>
                </dl>
                <div class="btn_box">
                    <ul>
                        <li><a href="/?menuno=261">취소</a></li>
                        <li><a href="javascript:findUserid();" class="b_feac25">완료</a></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</div>
