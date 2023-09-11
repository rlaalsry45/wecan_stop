<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script language="javascript">
	window.onload(document.title = "Reset Your Password > "+document.title);
</script>
<!--여기서 부터 사용하세요-->
<h3 class="ctit">Reset Your Password</h3>
<fieldset class="password-setting">
	<legend>Reset Your Password</legend>
	<ul class="fieldset">
		<li class="first">
			<label for="id">Enter Password</label>
			<input type="password" id="pass1" class="text" title="Enter Password" style="width:243px;height:21px;" />
		</li>
		<li>
			<label for="pass">Re-enter Password</label>
			<input type="password" id="pass2" class="text" title="Re-enter Password" style="width:243px;height:21px;" />
		</li>
	</ul>
	<a href="javascript:void(0)"><img id="submit_b" class="btn" title="로그인" src="/usr/image/common/btn/btn_finish02.gif" alt="완료" /></a>
</fieldset>
<!--/여기까지 사용하세요-->