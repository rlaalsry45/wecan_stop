<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
function checkJoin(no){
	$("#type").val(no);
	$("#frm").submit();
}
</script>

<form name="frm" id="frm" action="/?menuno=${param.menuno }" method="post">
	<input type="hidden" name="act" value="join_agree"/>
	<input type="hidden" name="type" id="type"/>
</form>

<!--[s] contents -->
<section id="contents-wrap">
	<div class="inner-wrap">
		<div class="contents">
			<h3 class="center tmg40">회원가입</h3>

			<div class="middle-wrap bmg50">
				<div class="border-tb-box half">
					<section class="member-choice-box">
						<h4>일반회원</h4>
						<p>본인 명의의 휴대폰 또는 I-PIN으로 본인인증이 가능한 내 외국인</p>
						<a href="#none" onclick="checkJoin('1')" class="btn-large">회원가입</a>
					</section>
					<section class="member-choice-box">
						<h4>기업회원</h4>
						<p>사업자번호가 있는 기업체(회사명, 사업자번호로 인증)</p>
						<a href="#none" onclick="checkJoin('2')" class="btn-large">회원가입</a>
					</section>
				</div>
			</div>
		</div>
	</div>
</section>
<!--[e] contents -->


				<!-- <div class="cont-right">
					<h3 class="ctit">회원가입</h3>
					<h4 class="stit">본인인증</h4>
					<div class="join-box-bottom">
						<div class="join-box-top">
							<div class="principal">
								<strong>안심본인인증서비스는 본인명의의 휴대폰과 주민등록번호 대신<br />식별ID를 인증기관으로 부터 발급받아 본인확인 서비스입니다.</strong>
								<p>개인정보(주민번호)수집금지(2014년 8월 7일 개정)법규정을<br />준수하며, 주민등록번호를 수집하지 않습니다.</p>
								<a href="javascript:fnNiceMain();"><img src="/usr/image/common/btn/btn_minoru.gif" alt="실명인증센터" /></a>
							</div>
						</div>
					</div>
					<div class="join" style="margin-top:20px;">
						<strong><em>(사)대한국토ㆍ도시계획학회 홈페이지 회원에 가입</em>하시면 더욱 더 다양한 서비스를 이용하실 수 있습니다.</strong>
						<ul class="clist02">
							<li>(사)대한국토ㆍ도시계획학회는 보다 많은 사용자들의 원활한 서비스 이용과 온라인 상에서의 익명 사용자로 인한 피해 등을 방지하기 위하여 회원 ID에 실명제를 행하고 있습니다.</li>
							<li>본인인증을 통해 본인확인을 해 주시기 바랍니다.</li>
							<li>중복가입을 방지하기 위해 가입여부를 확인합니다.</li>
						</ul>
						<strong class="type" style="margin-top:20px;">본인인증이 안되는 경우에는 실명인증기관에 고객님의 정보가 없는 경우이므로, 아래 실명인증기관을 통해 고객님의 실명정보를 등록 해 주셔야 합니다.</strong>
						<strong class="type" style="margin-top:20px;"><a href="#none" onclick='foreigner_join();'">Foreigner Registration</a></strong>
						<script type="text/javascript">
							function foreigner_join(){
								if(confirm("외국국적의 이용자만 가능합니다. 외국인이 아닐경우 가입을 하여도 인증처리되지 않습니다. 계속하시겠습니까?\n It's available only for foreigners. Continue?")){
									window.location.href="/?menuno=2083&act=join_chk&foreigner=1";
								}
							}
						
						</script>
						
					</div>
				</div>
			</div>
		</div> -->