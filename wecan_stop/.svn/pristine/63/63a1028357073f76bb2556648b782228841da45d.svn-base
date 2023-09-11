<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/admsys/common.jsp" %>
<script type="text/javascript" src="/usr/js/common.js"></script>
<script type="text/javascript" src="/usr/js/admsys/user/common/joinUser.js"></script>
<div class="content">
    <div class="cont_wrap">
        <div class="cont">
            <p class="p_t t_center">담당관 회원가입</p>
            <form id="frm" name="frm" method="post" class="manager_join">
            	<input type="hidden" id="duplicationYn" name="duplicationYn" value="">
                <dl>
                    <dt>이름</dt>
                    <dd><div class="input_box"><input type="text" id="username" name="username" value="" placeholder="이름을 입력하세요." maxlength="50"></div></dd>
                </dl>
                <dl>
                    <dt>이메일</dt>
                    <dd><div class="input_box"><input type="text" id="email" name="email" value="" placeholder="이메일을 입력하세요." maxlength="50"></div><input type="button" id="duplicationConfirm" value="중복확인"></dd>
                </dl>
                <dl>
                    <dt>비밀번호</dt>
                    <dd><div class="input_box"><input type="password" id="passwd" name="passwd" value="" placeholder="비밀번호를 입력하세요." maxlength="20"></div><em id="passwd_txt" style="display:none;">비밀번호는 영문,숫자,특수문자 포함 8자리 이상으로 입력해주세요.</em></dd>
                </dl>
                <dl>
                    <dt>비밀번호 확인</dt>
                    <dd><div class="input_box"><input type="password" id="passwdConfirm" name="passwdConfirm" value="" placeholder="비밀번호 확인을 입력하세요." maxlength="20"></div></dd>
                </dl>
                <dl>
                    <dt>핸드폰번호</dt>
                    <dd><div class="input_box"><input type="text" id="mobile" name="mobile" value="" placeholder="핸드폰번호를 입력하세요." maxlength="13"></div><input type="button" value="인증하기"></dd>
                </dl>
                <dl>
                    <dt>인증번호 입력</dt>
                    <dd><div class="input_box"><input type="text" id="userCode" name="userCode" value="" placeholder="인증번호를 입력하세요." maxlength="6"></div><input type="button" value="확인"><em id="crtfc_txt" style="display:none;">인증이 완료되었습니다.</em></dd>
                </dl>
                <div class="btn_box">
                    <ul>
                        <li><a href="/login.html">취소</a></li>
                        <li><a href="javascript:joinUser();" class="b_feac25">완료</a></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>