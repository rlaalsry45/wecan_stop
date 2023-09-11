<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
	$(function () {
		/* gnb */
		$("#gnb > li").eq(5).addClass("on");
	});
	var lnbnum=0;
	var lnbsubnum=0;

	 if("true"=="${param.fail}"){
		alert("아이디 혹은 비밀번호가 틀립니다.")
	 }
	 if("true"=="${param.foreigner}" && "true"=="${param.newbe}"){
		 /* alert("회원가입이 정상적으로 처리되었습니다.\n로그인 해 주시기 바랍니다."); */
		 document.location.href="/eng/?menuno=2619&foreigner=true&newbe=true";
	}else if("true"=="${param.newbe}"){
		 /* alert("회원가입이 정상적으로 처리되었습니다.\n로그인 해 주시기 바랍니다."); */
		 document.location.href="/?menuno=2554&newbe=true";
	}
	
	if("${userdata.username}"!=null&&"${userdata.username}"!=""){
		 alert("이미 로그인 되어 있습니다.");
		 document.location.href="/";
	}


function valchk(){
	if(document.getElementById('userid').value==""){
		alert("ID를 입력해 주십시요.");
		document.getElementById('userid').focus();
	}else if(document.getElementById('userpasswd').value==""){
		alert("비밀번호를 입력해 주십시요.");
		document.getElementById('userpasswd').focus();
	}else{
		document.getElementById('frm').submit();
	}
}
</script>
		<div class="cont-right">
			<h3 class="ctit">Login</h3>
			<div class="login02">
				<form action="/j_spring_security_check" method="post" id="frm" >
				<input id="status" type="hidden" name="status" value="eng" />
					<fieldset class="login">
						<legend>로그인</legend>
						<strong><em>Welcome to Korea Planning Association!</strong>
						<div>
							<ul>
								<li>
									<label for="id" style="width:80px;">ID</label>
									<input type="text" class="text" name="j_username" id="userid" title="아이디 입력" onkeydown="if(event.keyCode==13){valchk()}" style="width:265px;height:34px;" />
								</li>
								<li>
									<label for="id" style="width:80px;">PASSWORD</label>
									<input type="password" class="text" name="j_password" id="userpasswd" title="비밀번호 입력" onkeydown="if(event.keyCode==13){valchk()}" style="width:265px;height:34px;" />
								</li>
							</ul>
							<a href="javascript:void(0);" onclick="valchk();" class="login"><img src="/usr/image/common/btn/btn_login03.gif" alt="login" /></a>
						</div>
					</fieldset>
				</form>
				<!-- <ul class="login-desc">
					<li>
						신규회원의 경우 <strong>회원가입</strong>후 이용해 주시기 바랍니다.
						<div class="btn-c"><a href="/eng/?menuno=2612&act=join_foreigner_chk"><img src="/usr/image/common/btn/btn_join02.gif" alt="회원가입" /></a></div>
					</li>
					<li>
						<strong>아이디/비밀번호</strong>가 생각나지 않으세요?
						<div class="btn-c"><a href="/eng/?menuno=2612&act=find_id"><img src="/usr/image/common/btn/btn_idpass.gif" alt="아이디/비밀번호 찾기" /></a></div>
					</li>
				</ul> -->
			</div>
		</div>
	</div>
</div>