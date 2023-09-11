<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<link rel="stylesheet" href="/usr/skin/member/default/css/login.css" type="text/css" />

<!--여기서 부터 사용하세요-->

<div id="idpw_wrap">
												
	<p class="idpw_tit"><img src="/usr/skin/member/default/images/sub_con_title01.gif" alt="아이디 찾기" /></p>
	
	<!--로그인폼 시작-->
	<fieldset>
	<form action="member_id_find_ok.jsp" name="frm" method="post">
	<input type="hidden" name="domainId" value="default" />
	<input type="hidden" name="returnURL" id="returnURL" value="/" />
	<input type="hidden" name="gubun" value="1" />
		<legend>로그인</legend>
			<div class="idpwform">
				<dl class="idpw_id">
					<dt><label for="username"><img src="/usr/skin/member/default/images/log_tit01.gif" alt="이름" /></label></dt>
					<dd><input type="text" name="username" id="username"  title="이름"  onfocus="fnClean('id');" class="intext01" /></dd>
				</dl>
				<dl class="idpw_pw">
					<dt><label for="email"><img src="/usr/skin/member/default/images/log_tit03.gif" alt="이메일주소" /></label></dt>
					<dd><input type="text" name="email1" id="email1" onfocus="fnClean('id');" title="이메일주소1"  class="intext01" />
						 @ <input type="text" name="email2" id="email2" onfocus="fnClean('id');" title="이메일주소2"  class="intext01" /></dd>
				</dl>
				<p class="idpw_btn">	
					   <input type="image" src="/usr/skin/member/default/images/btn_ok.gif" alt="확인" onclick="return sendit_id_fnd();" /></p>
				
				<ul class="idpwbtn_join">
					<li><a name="#aa"><a href="#aa" onclick="history.back();"><img src="/usr/skin/member/default/images/btn_cansle.gif" alt="취소" /></a></li>
				</ul>
				
				<p class="btn_txt"><img src="/usr/skin/member/default/images/idpw_tit1.gif" alt="회원님의 인증을 위한 아래 정보를 입력하시면 회원가입시 등록한 e-mail로 아이디가 발송됩니다." /></p>
			</div>
	</form>
	</fieldset>
	
	<br><br>
	
	
	<!--/로그인폼 시작-->
	<p class="idpw_tit01"><img src="/usr/skin/member/default/images/sub_con_title02.gif" alt="비밀번호 찾기" /></p>
	
	<!--로그인폼 시작-->
	<fieldset>
	<form action="member_id_find_ok.jsp" name="frmPass" method="post">
	<input type="hidden" name="domainId" value="default" />
	<input type="hidden" name="returnURL" id="returnURL" value="/" />
	<input type="hidden" name="gubun" value="2" />
		<legend>로그인</legend>
			<div class="idpwform01">
				<dl class="idpw_id">
					<dt><label for="userId"><img src="/usr/skin/member/default/images/log_tit04.gif" alt="아이디" /></label></dt>
					<dd><input type="text" name="userId" id="userId" onfocus="fnClean('pass');"  title="아이디"  class="intext01" /></dd>
				</dl>
				<dl class="idpw_id">
					<dt><label for="username01"><img src="/usr/skin/member/default/images/log_tit01.gif" alt="이름" /></label></dt>
					<dd><input type="text" name="username01" id="username01" onfocus="fnClean('pass');"  title="이름" class="intext01" /></dd>
				</dl>
				<dl class="idpw_pw">
					<dt><label for="email"><img src="/usr/skin/member/default/images/log_tit03.gif" alt="이메일주소" /></label></dt>
					<dd><input type="text" name="email01" id="email01" onfocus="fnClean('pass');"  title="이메일주소1" class="intext01" />
						 @ <input type="text" name="email02" id="email02" onfocus="fnClean('pass');"  title="이메일주소2" class="intext01" /></dd>
				</dl>
				<p class="idpw_btn"><input type="image" src="/usr/skin/member/default/images/btn_ok.gif" alt="확인" onclick="return senditPass();" /></p>
				
				<ul class="idpwbtn_join">
					<li><a href="#"><img src="/usr/skin/member/default/images/btn_cansle.gif" alt="취소" /></a></li>
				</ul>
				
				<p class="btn_txt"><img src="/usr/skin/member/default/images/idpw_tit2.gif" alt="본인확인을 위해 이름과 이메일 주소, 가입한 아이디명을 입력해주세요. 비밀번호를 조회할 수 있습니다." /></p>
			</div>
	</form>
	</fieldset>
	<!--/로그인폼 시작-->
	
</div>

<!--/여기까지 사용하세요-->