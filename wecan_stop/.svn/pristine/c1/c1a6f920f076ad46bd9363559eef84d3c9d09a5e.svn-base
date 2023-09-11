<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
<c:if test="${sessionScope.zUserVo eq null}">
	location.href="/?menuno=${param.menuno }";
</c:if>

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
	if(confirm("정말로 탈퇴 하시겠습니까?")){
		
		$.ajax({
			type: "POST" 
			, async: true 
			, url: "/front/user/memberoutchk.html"
			, thpe:"json"
			, data: "pass="+inputpass+"&cancelreason="+cancelreason
			, success: function(data) {
				if(data=="success"){
					alert("정상적으로 처리 되었습니다.");
					document.location.href="/";
				}else if(data=="nopass"){
					alert("비밀번호가 다릅니다");
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
<!--[s] contents -->
<section id="contents-wrap">
	<div class="inner-wrap">
		<div class="contents">
			<h3 class="center">회원탈퇴</h3>

			<section class="bg-gray-box">
				<ul class="list-dot brown">
					<li>회원탈퇴를 신청하시면 해당 아이디는 사용이 중지되므로 해당 아이디로는 재가입이 불가능합니다.</li>
					<li>회원탈퇴한 회원정보는 삭제되며, 기존 가입한 ID와 신규 가입 ID간의 ID 중복방지와 게시글 관리를 위하여 성명과 ID는 남습니다.</li>
					<li>탈퇴 후 재가입은 가능하며, 탈퇴 전 데이터는 제공되지 않습니다.</li>
				</ul>
			</section>

			<form name="">

					<div class="tbl-box">
					<fieldset>
						<legend>회원탈퇴 폼</legend>
						<table class="tbl-type01">
						<caption>회원탈퇴 정보 입력</caption>
						<colgroup><col style="width:180px"><col style="width:*"></colgroup>
						<tbody>
							<tr>
								<th><label for="lb-pwd">비밀번호</label></th>
								<td>
									<input type="password" id="pass" name="pass"
									 class="w30p">
								</td>
							</tr>
							<tr>
								<th><label for="lb-reason">탈퇴사유</label></th>
								<td>
									<textarea id="cancelreason" name="cancelreason"></textarea>
								</td>
							</tr>
						</tbody>
						</table>
					</fieldset>
					</div>

					<div class="btns-box ar">
						<a href="/?menuno=${param.menuno }&act=usermodify" class="btn-basic border">취소</a>
						<a href="#pop-secede" onclick="memeberoutchk();" class="btn-basic" data-rel="pop">확인</a>
					</div>
			</form>

		</div>
	</div>
</section>
<!--[e] contents -->