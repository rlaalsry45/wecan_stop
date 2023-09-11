<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<link rel="stylesheet" href="/usr/skin/member/default/css/login.css" type="text/css" />
<!--여기서부터 사용하세요-->
<script type="text/javascript">
	window.onload=function(){
		 if("true"=="${param.fail}"){
			alert("Your login attempt was not successful, try again.\n\nReason:아이디 혹은 비밀번호가 틀립니다.")
		 }
	}
</script>

<div id="skin">
<form name="frm" method="post" action="/?menuno=${menuno}">

	<div id="log_wrap">
		<p class="log_tit">
		${reuslt.conts5}
		<!--상단 이미지
		<img src="/usr/skin/member/default/images/log_tit3.gif" alt="LOGIN" />
			<span><img src="/usr/skin/member/default/images/log_tit4.gif" alt="서울친환경유통센터 홈페이지에 오신것을 환영합니다." /></span>
		-->
			</p>
		<fieldset>
			<input type="hidden" name="domainId" value="default" />
			<input type="hidden" name="returnURL" id="returnURL" value="/" />
			<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
			<input type="hidden" name="act" id="act" value="${act}" />
			<input type="hidden" name="_to" value="${_to}" />
			<input type="hidden" name="_from" value="${_from}" />

			<legend>로그인</legend>
				<div class="loginform">
					<p class="txtfield">
						<dl class="log_id">
							<dt><label for="userid"><img src="/usr/skin/member/default/images/log_tit5.gif" alt="아이디" /></label></dt>
							<dd><input type="text" name="j_username" id="userid" value="${userid}" class="intext" /></dd>
						</dl>
						<dl class="log_pw">
							<dt><label for=userpasswd><img src="/usr/skin/member/default/images/log_tit6.gif" alt="비밀번호" /></label></dt>
							<dd><input type="password" name="j_password" id="userpasswd" class="intext" /></dd>
						</dl>
					</p>
					<p class="log_btn"><img id ="submit_b" src="/usr/skin/member/default/images/btn_login.gif" alt="로그인버튼" /></p>

					<ul class="btn_join">
						<li><a href="#"><img id = "find_b" src="/usr/skin/member/default/images/btn_idpwsh.gif" alt="아이디/비밀번호 찾기" /></a></li>
						<li><a href="#"><img id = "join_b" src="/usr/skin/member/default/images/btn_join.gif" alt="회원가입" /></a></li>
					</ul>
					<p class="btn_txt"><img src="/usr/skin/member/default/images/log_tit7.gif" alt="회원계정이 없으신 분은 회원가입을 해주시기 바랍니다." /></p>
				</div>
		</fieldset>
		<!--하단 텍스트
			<ul class="log_textbox">
				<li class="bold_r">웹서비스 이용시 주의사항</li>
				<li>웹서비스 이용시 개인정보에 관한 사항은 절대로 게재하지 마십시오. 타인에게 노출되어 개인정보가 침해 받을 수 있습니다.</li>
				<li class="bold_r">개인정보란?</li>
				<li>생존하는 개인에 관한 정보로서 당해 정보에 포함되어 있는 성명·주민등록번호 및 화상 등의 사항에 의하여 당해 개인을 식별할 수 있는 정보</li>
				<li>(예. 주민등록번호, 계좌번호, 카드번호, 화상 등)</li>
			</ul>
		-->
	</div>
</form>
</div><!--/skin-->
<!--/여기까지 사용하세요-->