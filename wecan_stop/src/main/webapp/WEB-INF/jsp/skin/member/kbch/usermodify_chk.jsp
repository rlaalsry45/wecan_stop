<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
function checkJoin(act){
	$("#act").val(act);
	$("#frm").submit();
}
</script>

<form name="frm" id="frm" action="/?menuno=${param.menuno }" method="post">
	<input type="hidden" name="act" id="act"/>
</form>


<!--[s] contents -->
<section id="contents-wrap">
	<div class="inner-wrap">
		<div class="contents">
			<h3 class="center tmg40">마이페이지</h3>

			<div class="middle-wrap bmg50">
				<div class="border-tb-box half">
					<section class="member-choice-box">
						<h4>비밀번호 변경</h4>
						<p></p>
						<a href="#none" onclick="checkJoin('usermodify')" class="btn-large">비밀번호 변경</a>
					</section>
					<section class="member-choice-box">
						<h4>회원탈퇴</h4>
						<p></p>
						<a href="#none" onclick="checkJoin('userout')" class="btn-large">회원탈퇴</a>
					</section>
				</div>
			</div>
		</div>
	</div>
</section>
<!--[e] contents -->