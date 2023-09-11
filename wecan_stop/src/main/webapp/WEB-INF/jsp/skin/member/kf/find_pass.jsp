<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script language="javascript">
	window.onload(document.title = "비밀번호 재설정 > "+document.title);
</script>
<!--여기서 부터 사용하세요-->
<h3 class="ctit">비밀번호 재설정</h3>
<fieldset class="password-setting">
	<legend>비밀번호 재설정</legend>
	<ul class="fieldset">
		<li class="first">
			<label for="id">비밀번호 입력</label>
			<input type="password" id="pass1" class="text" title="비밀번호 입력" style="width:243px;height:21px;" />
		</li>
		<li>
			<label for="pass">비밀번호 재입력</label>
			<input type="password" id="pass2" class="text" title="비밀번호 재입력" style="width:243px;height:21px;" />
		</li>
	</ul>
	<a href="javascript:void(0)"><img id="submit_b" class="btn" title="로그인" src="/usr/image/common/btn/btn_finish02.gif" alt="완료" /></a>
</fieldset>
<!--/여기까지 사용하세요-->