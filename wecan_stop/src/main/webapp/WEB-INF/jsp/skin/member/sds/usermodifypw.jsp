<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
$(document).ready(function(){
	
});

</script>
<!--[s] contents -->
<section id="contents-wrap">
	<div class="inner-wrap">
		<div class="contents">
			<h3 class="center">비밀번호변경</h3>

			<form name="frm" id="frm" method="post">

					<div class="tbl-box">
					<fieldset>
						<legend>비밀번호변경 폼</legend>
						<table class="tbl-type01">
						<caption>비밀번호변경 정보 입력</caption>
						<colgroup><col style="width:180px"><col style="width:*"></colgroup>
						<tbody>
							<tr>
								<th><label for="lb-pwd">이전 비밀번호</label></th>
								<td>
									<input type="password" id="oldpasswd" name="oldpasswd" class="w30p">
								</td>
							</tr>
							<tr>
								<th><label for="lb-pwd2">신규 비밀번호</label></th>
								<td>
									<input type="password" id="userpasswd" name="userpasswd" class="w30p">
									<p class="td-comment">* 영문 대소문자/숫자/특수문자 중 두가지 이상 조합으로 8~16자리</p>
								</td>
							</tr>
							<tr>
								<th><label for="lb-pwd3">신규 비밀번호 확인</label></th>
								<td>
									<input type="password" id="userpasswdchk" name="userpasswdchk" class="w30p">
								</td>
							</tr>
						</tbody>
						</table>
					</fieldset>
					</div>

					<div class="btns-box ar">
						<a href="/?menuno=${param.menuno }&act=usermodify" class="btn-basic border">취소</a>
						<a href="#none" id="submit_b" class="btn-basic">확인</a>
					</div>
			</form>

		</div>
	</div>
</section>
<!--[e] contents -->