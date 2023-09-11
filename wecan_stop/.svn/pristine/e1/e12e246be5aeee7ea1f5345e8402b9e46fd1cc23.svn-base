<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">

<c:if test="${sessionScope.zUserVo ne null}">
alert("이미 로그인 되었습니다.");
location.href="/";
</c:if>


	window.onload=function(){
		 if("true"=="${param.fail}"){
			alert("아이디가 잘못되었습니다.")
		 }
		 if("true"=="${param.pwfail}"){
			alert("비밀번호가 잘못되었습니다")
		 }
	}
	function valchk(){
		if(document.getElementById('userid').value==""){
			alert("ID를 입력해 주십시요.");
			document.getElementById('userid').focus();
			return false;
		}else if(document.getElementById('userpasswd').value==""){
			alert("비밀번호를 입력해 주십시요.");
			document.getElementById('userpasswd').focus();
			return false;
		}else{
			document.getElementById('frm').submit();
		}
	}
</script>
<!--[s] contents -->
<section id="contents-wrap">
	<div class="inner-wrap">
		<div class="contents">
			<h3 class="center">로그인</h3>
			<div class="small-wrap">
				<section class="login-form">
					<div class="login-form-in">
						<form action="/j_spring_security_check" method="post" id="frm" onsubmit="return valchk();">
							<input type="hidden" name="_from" value="/?menuno=${param.menuno }"/>
							<fieldset>
								<legend>로그인 폼</legend>
								<input type="text" name="j_username" id="userid" title="아이디 입력" onkeydown="if(event.keyCode==13){valchk()}" placeholder="아이디를 입력해주세요">
								<input type="password" name="j_password" id="userpasswd" title="비밀번호 입력" onkeydown="if(event.keyCode==13){valchk()}" placeholder="비밀번호를 입력해주세요">
								<input type="submit" value="로그인">
							</fieldset>
						</form>

						<ul class="member-btns">
							<li><a href="/?menuno=${param.menuno }&act=join_type">회원가입</a></li>
							<li><a href="/?menuno=${param.menuno }&act=find_id">아이디찾기</a></li>
							<li><a href="/?menuno=${param.menuno }&act=find_pw">비밀번호찾기</a></li>
						</ul>
					</div>
				</section>
			</div>
		</div>
	</div>
</section>
<!--[e] contents -->