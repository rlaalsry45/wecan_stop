<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
window.onload = function(){
	document.title = "회원가입 단계4:회원정보입력 > "+document.title;
	 if("true"=="${sessionout}"){
		alert("비정상적인 접근입니다.");
		window.location.href="/";
	 }
}
</script>


<form name="frm" id="frm" method="post">
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="usertype" id="usertype" value="${usertype}" />
	<input type="hidden" name="menuno" id="menuno" value="${menuno}" />
	<input type="hidden" name="siteno" id="siteno" value="${siteno}" />
	<input type="hidden" id="dupchk" value="false" />
	<input type="hidden" name="subname" id="subname" value="${subname}" />
	
	
	
	
	<h3 class="ctit">회원가입</h3>
	<p class="text">※ 로그인 관련문의는 02-2151-6547 또는 02-2046-8558로 연락 주시기 바랍니다.</p>
	<ul class="member-kind">
		<li class="first kind"><span>회원<br />종류선택</span></li>
		<li class="name"><span>실명<br />확인</span></li>
		<li class="term"><span>약관<br />동의</span></li>
		<li class="info on"><span>회원<br />정보입력</span></li>
		<li class="email"><span>이메일<br />인증</span></li>
		<li class="finish"><span>가입<br />완료</span></li>
	</ul>
	<h4 class="sctit">회원 정보 입력</h4>
	<p class="text">KF지원사업신청포털 사이트(https://apply.kf.or.kr)에 회원가입을 하여 이메일 아이디를 가지고 계신 경우 같은 아이디로 홈페이지를 이용할 수 있습니다.</p>
	<div class="email"><strong>KF지원사업신청포털(https://apply.kf.or.kr) 사이트에 이메일 아이디가 있는 회원</strong>

		<div class="btn-l"><a href="javascript:cnjOpen('/usr/skin/member/kf/epmsUserCheck.html','cnjopen',776,400)"><img src="/usr/image/common/btn/btn_id.gif" alt="아이디 찾기" /></a></div>
	</div>
	<p class="text">필수 입력 항목은 온라인 회원 가입 시 반드시 필요한 항목이므로 빠짐없이 모두 입력해주세요.</p>

	<table class="board-write" summary="이메일, 비밀번호, 비밀번호 재입력, 이름 (모국어), 이름 (영어), 메일수신여부">
		<caption>필수 회원 정보 입력</caption>
		<colgroup>
			<col style="width:30%;" />
			<col style="width:70%;" />
		</colgroup>
		<tbody>
			<tr>
				<th scope="row"><label for="emaill">이메일(아이디)</label></th>
				<td><input type="text" name="userid" id="userid"  class="text" title="이메일 주소 입력" style="width:196px;height:18px;" /> * 이메일(아이디)은 인증용을 사용됩니다.</td>
			</tr>
			<tr>
				<th scope="row"><label for="password">비밀번호</label></th>
				<td><input type="password" name="userpasswd" id="userpasswd" class="text" title="비밀번호 입력" style="width:150px;height:18px;" /> * 문자, 숫자, 특수문자의 조합으로 8자리 이상 입력해주세요</td>
			</tr>
			<tr>
				<th scope="row"><label for="rpassword">비밀번호 재입력</label></th>
				<td><input type="password" name="userpasswdchk" id="userpasswdchk" class="text" title="비밀번호 재입력" style="width:150px;height:18px;" /> * 문자, 숫자, 특수문자의 조합으로 8자리 이상 입력해주세요</td>
			</tr>
			<tr>
				<th scope="row"><label for="name">이름 (모국어)</label></th>
				<td><input type="text" name="username" id="username"  <c:if test="${usertype eq 'a' }"> value="${username}" readonly</c:if>   class="text" title="모국어로 이름 입력" style="width:196px;height:18px;" /></td>
				<!-- <td><input type="text" name="username" id="username"  class="text" title="모국어로 이름 입력" style="width:196px;height:18px;" /></td> -->
			</tr>
			<tr>
				<th scope="row"><label for="name2">이름 (영어)</label></th>
				<td><input type="text" name="username2" id="username2" class="text" title="영어로 이름 입력" style="width:196px;height:18px;" /></td>
			</tr>
			<c:if test="${usertype eq 'b' }">
			<tr>
				<th scope="row"><label for="name">이름 (보호자)</label></th>
				<td><input type="text" name="parentname" id="parentname"  value="${username}" readonly  class="text" title="모국어로 이름 입력" style="width:196px;height:18px;" /></td>
				<!-- <td><input type="text" name="parentname" id="parentname"   class="text" title="모국어로 이름 입력" style="width:196px;height:18px;" /></td> -->
			</tr>
			</c:if>
		</tbody>
	</table>
	<p class="text">선택 입력 항목</p>
	<table class="board-write" summary="메일수신여부">
		<caption>선택 회원 정보 입력</caption>
		<colgroup>
			<col style="width:30%;" />
			<col style="width:70%;" />
		</colgroup>
		<tbody>
			<tr>
				<th scope="row">메일수신여부</th>
				<td class="type">
					<input type="checkbox" name="newsletter1" id="new" class="check" value="1" />
					<label for="new">What’s New(새소식)</label>
					<input type="checkbox" name="newsletter2" id="newsletter" class="check"  value="2" />
					<label for="newsletter">KF Newsletter(한국국제교류재단 소식)</label>
					<input type="checkbox" name="newsletter3"id="focus" class="check"  value="3" />
					<label for="focus">Korea Focus</label>
					<input type="checkbox" name="newsletter4" id="kf" class="check"  value="4" />
					<label for="kf">Koreana</label>
				</td>
			</tr>
		</tbody>
	</table>
	<div class="btn-c">
		<a href="javascript:void(0)" onclick="submit_b();"><img src="/usr/image/common/btn/btn_join02.gif" alt="회원가입" /></a>
		<a href="/"><img src="/usr/image/common/btn/btn_cancle.gif" alt="취소" /></a>
	</div>
</form>