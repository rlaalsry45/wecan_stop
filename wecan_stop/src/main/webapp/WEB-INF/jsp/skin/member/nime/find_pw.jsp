<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<c:set var="tabtype" value="${param.tabtype }" />
<c:if test="${tabtype eq null }">
	<c:set var="tabtype" value="1" />
</c:if>

<script type="text/javascript">

$(function(){
	<c:if test="${tabtype eq '2' }">
	document.getElementById('selectdomain').onchange=function(){
	document.getElementById('useremaildomain').value=document.getElementById('selectdomain').value;
	};
	</c:if>
});



<c:if test="${success eq false}">
	alert("일치하는 회원정보가 없습니다.");
</c:if>

var pw_type;
function checkJoin(type, no){
	
	if(type == "1"){
		
		pw_type = no;
		
		if(no == "1"){
			if ($("#userid").val().replace(/^\s+|\s+$/g,"")==""){
				alert("아이디를 입력 해주세요.");
				$("#userid").focus();
				$("#userid").select();
				return false;
			}
			
			fnNiceMain();	
		}else{
			if ($("#userid2").val().replace(/^\s+|\s+$/g,"")==""){
				alert("아이디를 입력 해주세요.");
				$("#userid2").focus();
				$("#userid2").select();
				return false;
			}
			fnIpinMain();
		}
	}else{
		
		if ($("#userid").val().replace(/^\s+|\s+$/g,"")==""){
			alert("아이디를 입력 해주세요.");
			$("#userid").focus();
			$("#userid").select();
			return false;
		}
		
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
		
		
		if(confirm("아이디:"+$("#userid").val()+"\n사업자등록번호 : "+$("#licenseeno").val()+"\n이메일 : "+$("#useremail").val()+"\n\n입력하신 정보가 맞습니까?")){
			
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
	$("#pw_type").val(pw_type);
	$("#frm").submit();
}


</script>


<c:if test="${success ne true}">

	<c:if test="${tabtype eq '1'}">
	<!--[s] contents -->
	<section id="contents-wrap">
		<div class="inner-wrap">
			<div class="contents">
				<h3 class="center tmg40">비밀번호 찾기</h3>
	
				<nav class="sub-text-tab">
					<a href="#none" class="on">일반회원</a>
					<a href="/?menuno=${param.menuno }&act=find_pw&tabtype=2">기업회원</a>
				</nav>
		
				<form name="frm" id="frm" method="post">
				<input type="hidden" name="pw_type" id="pw_type" />
				<div class="middle-wrap bmg50">
					<div class="border-tb-box half">
						<section class="member-choice-box">
							<h4>본인확인으로 비밀번호 찾기</h4>
							<p>본인확인으로 인증받기는 본인 명의의 휴대폰번호를<br class="m-hide">통하여 인증받는 방식입니다.</p>
							<div class="pwd-search">
								<label for="lb-id01">아이디</label> <input type="text" name="userid" id="userid" class="w40p">
							</div>
							<a href="#none" onclick="checkJoin('1', '1')" class="btn-large">본인확인 인증</a>
						</section>
						<section class="member-choice-box">
							<h4>I-PIN으로 비밀번호 찾기</h4>
							<p>IPIN을 이용하여 인증하시려면 아래 “아이핀으로 인증받기”<br class="m-hide">버튼을 클릭하여 작성을 진행해 주세요. </p>
							<div class="pwd-search">
								<label for="lb-id02">아이디</label> <input type="text" name="userid2" id="userid2" class="w40p">
							</div>
							<a href="#none" onclick="checkJoin('1', '2')" class="btn-large">아이핀 인증</a>
						</section>
					</div>
				</div>
				</form>
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
				<h3 class="center tmg40">비밀번호 찾기</h3>
	
				<nav class="sub-text-tab">
					<a href="/?menuno=${param.menuno }&act=find_pw&tabtype=1">일반회원</a>
					<a href="#none" class="on">기업회원</a>
				</nav>
				<form name="frm" id="frm" method="post">
				<input type="hidden" name="licenseeno" id="licenseeno" />
				<input type="hidden" name="useremail" id="useremail" />
				<div class="middle-wrap bmg50">
					<div class="border-tb-box">
						<section class="member-choice-box">
							<ul class="form-inline-list tmg0 bmg0">
								<li><label for="lb-id">아이디</label>
									<div class="form-inline">
										<input type="text" name="userid" id="userid" class="w60p">
									</div>
								</li>
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
					<ul class="list-billiard pos-bottom">
						<li>가입 회원정보(아이디, 사업자등록번호, 담당자 이메일)와 동일한 정보를 정확히 입력하십시오.</li>
					</ul>
					<div class="btns-box ar">
						<a href="/?menuno=${param.menuno }" class="btn-basic border">취소</a>
						<a href="#none" onclick="checkJoin('2')"  class="btn-basic" data-rel="pop">확인</a>
					</div>
				</div>
				</form>
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
			<h3 class="center tmg40">비밀번호 찾기</h3>

			<div class="middle-wrap bmg50">
				<div class="border-tb-box">
					<section class="search-pwd-result" style="width:100%">
						<span class="fBlk">${user.username }</span>님께서 가입시 등록하신 <span class="fBlk">
						<c:if test="${user.work_grade eq '1' }">이메일(${user.useremail })</c:if>
						<c:if test="${user.work_grade eq '2' }">담당자 이메일(${user.chargeremail })</c:if>
						</span>로 임시 비밀번호를 발송 하였습니다.<br>
						잠시 후 메시지 또는 메일을 확인해주세요.<br>
						로그인 후에는 반드시 회원정보에서 비밀번호를 수정하시기 바랍니다.
					</section>
				</div>
				<div class="btns-box ar">
					<a href="/?menuno=${param.menuno }" class="btn-basic">확인</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!--[e] contents -->
</c:if>