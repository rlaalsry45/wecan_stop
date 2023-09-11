<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<script type="text/javascript">
if("${user.userid}"==""){
	document.location.href="/?menuno=2083&act=login";
}

function memeberoutchk(){
	if($("#pass").val()==""){
		alert("비밀번호를 입력해 주십시요.");
		$("#pass").focus();
		return;
	}
	
	if($("#cancelreason").val()==""){
		alert("탈퇴사유를 입력해 주십시요.");
		$("#cancelreason").focus();
		return;
	}
	
	var inputpass = $("#pass").val();
	var cancelreason = $("#cancelreason").val();
	if(confirm("탈퇴하시겠습니까?")){
		
		$.ajax({
			type: "POST" 
			, async: true 
			, url: "/front/user/memberoutchk.html"
			, thpe:"json"
			, data: "pass="+inputpass+"&cancelreason="+cancelreason
			, success: function(data) {
				if(data=="success"){
					document.location.href="/?menuno=2554&memberout=true";
				}else if(data=="nopass"){
					alert("비밀번호가 일치하지 않습니다.\n다시한번 확인해 주시기 바랍니다.");
				}else{
					alert("비밀번호 확인에 실패했습니다.\n잠시 후 다시 시도해 주시기 바랍니다.");
				}
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
		
	}
}
</script>
				<div class="cont-right">
					<h3 class="ctit">회원탈퇴</h3>
					<div class="secession">
						<ul class="clist">
							<li>1. 회원탈퇴 후 같은 아이디로는 재가입이 불가능 합니다.</li>
							<li>2. 회원탈퇴 후 아이디를 제외한 개인정보는 30일 간 보관이 되고 30일 이후에 자동 삭제됩니다.</li>
							<li>3. 지금까지 (사)대한국토ㆍ도시계획학회을 이용해 주셔서 감사합니다.</li>
						</ul>
						<div class="join-box-bottom">
							<div class="join-box-top">
								<form name="frm" method="post">
									<div class="id-pass" style="text-align:left;">
										<ul>
											<li>
												<label>아이디</label>
												<span>${user.userid }</span>
											</li>
											<li>
												<label for="pass">비밀번호</label>
												<input type="password" class="text" id="pass" name="pass" title="비밀번호 입력" style="width:377px;height:30px;" />
											</li>
											<li>
												<label>탈퇴사유</label>
												<textarea id="cancelreason" name="cancelreason" rows="5" cols="50"></textarea>
											</li>
										</ul>
										<div class="btn-c"><a href="javascript:memeberoutchk();"><img src="/usr/image/common/btn/btn_secession.gif" alt="탈퇴하기" /></a></div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>