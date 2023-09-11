<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<script type="text/javascript">

function checkJoin(){
	var agree01 = $(':radio[name="agree01"]:checked').val();
	var agree02 = $(':radio[name="agree02"]:checked').val();
	
	if(typeof(agree01) == "undefined" || agree01 == "0"){
		alert("개인정보 수집 및 이용에 동의하셔야 가입이 가능합니다.");
		$("#agree0101").focus();
		return;
	}
	
	if(typeof(agree02) == "undefined" || agree02 == "0"){
		alert("이용약관안내에 동의하셔야 가입이 가능합니다.");
		$("#agree0201").focus();
		return;
	}
	
	$("#frm").submit();
}

</script>
<form name="frm" id="frm" action="/?menuno=${param.menuno }" method="post">
	<input type="hidden" name="act" value="join_chk"/>
	<input type="hidden" name="type" id="type" value="${param.type}"/>
</form>

<!--[s] contents -->
<section id="contents-wrap">
	<div class="inner-wrap">
		<div class="contents">

			<h3 class="center">회원가입</h3>
			<nav class="join-step">
				<ul>
					<li class="on"><div><span>약관동의</span></div></li>
					<li><div><span>본인인증</span></div></li>
					<li><div><span>정보입력</span></div></li>
					<li><div><span>가입완료</span></div></li>
				</ul>
			</nav>
			<section class="join-form">
				<form name="">
					<fieldset>
						<legend>개인정보 수집 및 이용에 관한 동의</legend>
						<h4>개인정보 수집 및 이용에 관한 동의</h4>
						<textarea readonly="readonly">한국콘텐츠진흥원에서는 우수문화상품 신청서 접수, 심사, 지정 처리를 위하여 개인정보와 고유식별정보(이하 ‘개인정보’)를 수집합니다. 개인정보의 수집 및 이용에 동의하시고, 처리에 필요한 필수 정보(*표시)를 입력하시면 관련 신고를 하실 수 있습니다.

규정에 근거한 필수 수집 개인정보: 이름, 휴대전화번호, 이메일, 주소
수집된 개인정보는 신고처리 이외의 용도로는 이용되지 않으며, 수집목적 외 이용 및 제3자 제공 시에는 별도의 동의를 구합니다.
위의 규정에 따라 신고처리를 위하여 수집된 개인정보는 약 10년간 보존 후 폐기될 예정입니다.
이용자는 신고에서 수집하는 개인정보 제공에 대한 동의를 거부할 권리가 있습니다. 다만, 신고처리에 필요한 필수 항목의 제공에 대한 동의를 거부하시면 위의 서비스가 제한됩니다.</textarea>
						<div class="agree-radio">
							<input type="radio" id="agree0101" name="agree01" value="1"><label for="agree0101">동의합니다</label>
							<input type="radio" id="agree0102" name="agree01" value="0"><label for="agree0102">동의하지 않습니다.</label>
						</div>
					</fieldset>
					<fieldset>
						<legend>이용약관안내</legend>
						<h4>이용약관안내</h4>
						<textarea readonly="readonly">한국콘텐츠진흥원에서는 우수문화상품 신청서 접수, 심사, 지정 처리를 위하여 개인정보와 고유식별정보(이하 ‘개인정보’)를 수집합니다. 개인정보의 수집 및 이용에 동의하시고, 처리에 필요한 필수 정보(*표시)를 입력하시면 관련 신고를 하실 수 있습니다.

규정에 근거한 필수 수집 개인정보: 이름, 휴대전화번호, 이메일, 주소
수집된 개인정보는 신고처리 이외의 용도로는 이용되지 않으며, 수집목적 외 이용 및 제3자 제공 시에는 별도의 동의를 구합니다.
위의 규정에 따라 신고처리를 위하여 수집된 개인정보는 약 10년간 보존 후 폐기될 예정입니다.
이용자는 신고에서 수집하는 개인정보 제공에 대한 동의를 거부할 권리가 있습니다. 다만, 신고처리에 필요한 필수 항목의 제공에 대한 동의를 거부하시면 위의 서비스가 제한됩니다.</textarea>
						<div class="agree-radio">
							<input type="radio" id="agree0201" name="agree02" value="1"><label for="agree0201">동의합니다</label>
							<input type="radio" id="agree0202" name="agree02" value="0"><label for="agree0202">동의하지 않습니다.</label>
						</div>
					</fieldset>
					<div class="btns-box ar">
						<a href="/" class="btn-basic border">취소</a>
						<a href="#none" onclick="checkJoin()" class="btn-basic">확인</a>
					</div>
				</form>
			</section>

		</div>
	</div>
</section>
<!--[e] contents -->