<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/admsys/common.jsp" %>
<script type="text/javascript" src="/usr/js/common.js"></script>
<script type="text/javascript" src="/usr/js/admsys/setting/admin/login2ndCrtfc.js"></script>
<div class="content">
    <div class="cont_wrap">
        <div class="cont">
            <p class="p_t t_center">한국여성인권진흥원 ${projectName} 관리자<br>(구글 OTP 인증하기)</p>
            <form id="frm" name="frm" method="post" class="otp_login">
                <input type="hidden" name="encodedKey" value="${encodedKey}">
                <dl>
                    <dt>OTP</dt>
                    <dd><input type="text" id="userCode" name="userCode" value="" placeholder="OTP를 입력해주세요." autocomplete="off" maxlength="6"></dd>
                </dl>
                <div class="btn_box">
                    <a href="javascript:crtfc();" class="btn b_feac25">로그인</a>
                    <a href="javascript:reg();" class="btn b_cfcfcf">OTP 등록</a>
                </div>
            </form>
        </div>
    </div>
    <div class="popup_wrap" style="display:none;">
        <div class="bg"></div>
        <div class="popup">
            <div class="pop_close" onclick="popup_close();"><img src="/usr/images/sub/icon-close.png"></div>
            <div class="popcon">
                <p class="pop_t">OTP 등록</p>
                <div class="otp_qr">
                    <p>OTP 앱을 실행 후 아래의 바코드 또는 인증 코드를 입력하세요.</p>
                    <div class="qr_code">
                        <img src="${qrcodeUrl}" alt="qrcode">
                    </div>
                    <p>인증코드 ${encodedKey}</p>
                    <p class="link">앱 다운로드<a href="https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2&hl=ko&gl=US" target="_blank" title="구글 OTP 다운로드 Android 새창열림">Android</a> <a href="https://apps.apple.com/kr/app/google-authenticator/id388497605" target="_blank" title="구글 OTP 다운로드 iPhone 및 iPad 새창열림">iPhone 및 iPad</a></p>
                    <span class="btn_close" onclick="popup_close();">닫기</span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>