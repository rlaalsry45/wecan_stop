<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<script type="text/javascript">

$(function(){
	

	document.getElementById('selectdomain').onchange=function(){
		document.getElementById('useremaildomain').value=document.getElementById('selectdomain').value;
	};
	
	
});

<c:if test="${success eq false}">
	alert("일치하는 회원정보가 없습니다.");
</c:if>


function checkJoin(type, no){
	
	if(type == "1"){
		if(no == "1"){
			fnNiceMain();	
		}else{
			fnIpinMain();
		}
	}else{
		
		if ($("#j_licenseeno1").val().replace(/^\s+|\s+$/g,"")==""){
			alert("사업자등록번호를 입력 해주세요.");
			$("#j_licenseeno1").focus();
			$("#j_licenseeno1").select();
			return false;
		}
		if ($("#j_licenseeno2").val().replace(/^\s+|\s+$/g,"")==""){
			alert("사업자등록번호를 입력 해주세요.");
			$("#j_licenseeno2").focus();
			$("#j_licenseeno2").select();
			return false;
		}
		if ($("#j_licenseeno3").val().replace(/^\s+|\s+$/g,"")==""){
			alert("사업자등록번호를 입력 해주세요.");
			$("#j_licenseeno3").focus();
			$("#j_licenseeno3").select();
			return false;
		}
		
		
		if ($("#useremailid").val().replace(/^\s+|\s+$/g,"")==""){
			alert("이메일을 입력 해주세요.");
			$("#useremailid").focus();
			$("#useremailid").select();
			return false;
		}
		
		if ($("#useremaildomain").val().replace(/^\s+|\s+$/g,"")==""){
			alert("이메일을 입력 해주세요.");
			$("#useremaildomain").focus();
			$("#useremaildomain").select();
			return false;
		}
		
		$("#licenseeno").val($("#j_licenseeno1").val()+"-"+$("#j_licenseeno2").val()+"-"+$("#j_licenseeno3").val());
		$("#useremail").val($("#useremailid").val()+"@"+$("#useremaildomain").val());
		
		
		if(confirm("사업자등록번호 : "+$("#licenseeno").val()+"\n이메일 : "+$("#useremail").val()+"\n\n입력하신 정보가 맞습니까?")){
			
			$("#frm").submit();
			
		}
	}
		
}


function fnNiceMain(){
	url = "/skin/nice_self/NiceID_main.html";
	window.open(url, "_blank", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=420");
}

function fnIpinMain(){
	url = "/skin/ipin/ipin_main.html";
	window.open(url, "_blank", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=420");
}

function findpw_submit(){
	location.reload();
}
</script>

<c:set var="tabtype" value="${param.tabtype }" />
<c:if test="${tabtype eq null }">
	<c:set var="tabtype" value="1" />
</c:if>

<c:if test="${success ne true}">

	<c:if test="${tabtype eq '1'}">
	<!--[s] contents -->
	<section id="contents-wrap">
		<div class="inner-wrap">
			<div class="contents">
				<h3 class="center tmg40">아이디 찾기</h3>
	
				<nav class="sub-text-tab">
					<a href="#none" class="on">일반회원</a>
					<a href="/?menuno=${param.menuno }&act=find_id&tabtype=2">기업회원</a>
				</nav>
	
				<div class="middle-wrap bmg50">
					<div class="border-tb-box half">
						<section class="member-choice-box">
							<h4>본인확인으로 아이디 찾기</h4>
							<p>본인확인으로 인증받기는 본인 명의의 휴대폰번호를<br class="m-hide">통하여 인증받는 방식입니다.</p>
							<a href="#none" onclick="checkJoin('1', '1')" class="btn-large">본인확인 인증</a>
						</section>
						<section class="member-choice-box">
							<h4>I-PIN으로 아이디 찾기</h4>
							<p>IPIN을 이용하여 인증하시려면 아래 “아이핀으로 인증받기”<br class="m-hide">버튼을 클릭하여 작성을 진행해 주세요. </p>
							<a href="#none" onclick="checkJoin('1', '2')" class="btn-large">아이핀 인증</a>
						</section>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--[e] contents -->	
	</c:if>
	
	<c:if test="${tabtype eq '2' }">
	<!--[s] contents -->
	<section id="contents-wrap">
		<div class="inner-wrap">
			<div class="contents">
				<h3 class="center tmg40">아이디 찾기</h3>
	
				<nav class="sub-text-tab">
					<a href="/?menuno=${param.menuno }&act=find_id&tabtype=1">일반회원</a>
					<a href="#none" class="on">기업회원</a>
				</nav>
				
				<form name="frm" id="frm" method="post">
				<input type="hidden" name="licenseeno" id="licenseeno" />
				<input type="hidden" name="useremail" id="useremail" />
				<div class="middle-wrap bmg50">
					<div class="border-tb-box">
						<section class="member-choice-box">
							<ul class="form-inline-list tmg0 bmg0">
								<li><label for="lb-companyno">사업자등록번호</label>
									<div class="form-inline">
										<ul class="companyno">
											<li><input type="text" id="j_licenseeno1" maxlength="3"></li>
											<li><input type="text" id="j_licenseeno2" maxlength="2"></li>
											<li><input type="text" id="j_licenseeno3" maxlength="5"></li>
										</ul>
									</div>
								</li>
								<li><label for="lb-email">이메일</label>
									<div class="form-inline">
										<ul class="email">
											<li><input type="text" id="useremailid" name="useremailid" ></li>
											<li><span>@</span><input type="text" id="useremaildomain" name="useremaildomain"></li>
											<li>
												<div class="select-box">
													<label for="lb-email-select">직접입력</label>
													<select id="selectdomain" >
														<option value="" selected="selected">직접입력</option>
														<option value="hotmail.com">hotmail.com</option>
														<option value="hanmail.net">hanmail.net</option>
														<option value="daum.net">daum.net</option>
														<option value="naver.com">naver.com</option>
														<option value="nate.com">nate.com</option>
														<option value="gmail.com">gmail.com</option>
													</select>
												</div>
											</li>
										</ul>
									</div>
								</li>
							</ul>
						</section>
					</div>
					</form>
					<ul class="list-billiard pos-bottom">
						<li>가입 회원정보(사업자등록번호, 담당자 이메일)와 동일한 정보를 정확히 입력하십시오.</li>
					</ul>
					<div class="btns-box ar">
						<a href="/?menuno=${param.menuno }" class="btn-basic border">취소</a>
						<a href="#none" onclick="checkJoin('2')"  class="btn-basic" data-rel="pop">확인</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--[e] contents -->
	</c:if>

</c:if>

<c:if test="${success eq true}">
	<!--[s] contents -->
	<section id="contents-wrap">
		<div class="inner-wrap">
			<div class="contents">
				<h3 class="center tmg40">아이디 찾기</h3>
	
				<div class="middle-wrap bmg50">
					<div class="border-tb-box">
						<section class="search-id-result">
								<strong>아이디</strong>
								<c:set var="idlength" value="${fn:length(user.userid) }" />
								<c:set var="userid" value="${fn:substring(user.userid, 0, (idlength-3)) }" />
								<span>${userid }***</span>
						</section>
					</div>
					<ul class="list-dot pos-bottom">
						<li>비밀번호를 찾으시려면 <a href="/?menuno=${param.menuno }&act=find_pw" class="fb fBlk">[비밀번호 찾기]</a>를 이용하십시오.</li>
						<li>개인정보보호를 위해 끝 3자리는 *로 표시하였습니다.</li>
						<li>아이디 뒷자리까지 확인이 필요한 경우 KOCCA 고객센터(1544-1114)로 전화 주시기 바랍니다.</li>
					</ul>
					<div class="btns-box ar">
						<a href="/?menuno=${param.menuno }" class="btn-basic">확인</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--[e] contents -->
</c:if>