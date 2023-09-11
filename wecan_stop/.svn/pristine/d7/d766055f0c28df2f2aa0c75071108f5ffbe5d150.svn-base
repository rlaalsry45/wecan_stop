<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>국민참여 | 한국국제교류재단</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="/usr/css/tmp/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script src='/com/js/jquery.form.min.js'></script>
<script src='/com/js/purl.js'></script>
<script type="text/javascript" src="/usr/js/popupclose.js"></script>
<script type="text/javascript">
function submit_c(isNotMember){
	$("#btn_img").hide();
	if($("#username").val() ==""){
		alert("본인 인증을 해주세요");
		$("#username").focus();
		$("#btn_img").show();
		return;
	}
	if(isNotMember == 'yes'){
		if ($("#chka").is(":checked")!=true){
			alert("서비스 이용약관에 동의하셔야 합니다.");
			$("#chka").focus();
			$("#btn_img").show();
			return;
		}
		if ($("#chkb").is(":checked")!=true){
			alert("개인정보 보호정책에 동의하셔야 합니다.");
			$("#chkb").focus();
			$("#btn_img").show();
			return;
		}
	}
	if($("#phone1").val() ==""){
		alert("연락처를 입력해 주세요");
		$("#phone1").focus();
		$("#btn_img").show();
		return;
	}
	if($("#phone2").val() ==""){
		alert("연락처를 입력해 주세요");
		$("#phone2").focus();
		$("#btn_img").show();
		return;
	}
	if($("#phone3").val() ==""){
		alert("연락처를 입력해 주세요");
		$("#phone3").focus();
		$("#btn_img").show();
		return;
	}
	if(confirm("신청 후 수정은 불가능합니다. 신청을 완료하시겠습니까?")){
		$(".btn-c").html("브라우저에 따라 처리 시간이 걸릴수 있습니다. 완료메시지가 나올때 까지 잠시 기다려 주세요~");
		$("#insert").submit();
	}else{
		$("#btn_img").show();
	}
};

function newpostsearch(){
	url = "/skin/newpost/road.html";
	window.open(url, "result1122", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=450");
};

function fnNiceMain(){
	url = "/skin/nice_self/NiceID_main.html?parentmove=no";
	window.open(url, "result1122", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=420");
}
function fnOpenTerms(url){
	window.open(url, "result1122", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=420");
}
$(function(){

	/*
	 * form submit*/
	var option_update = {
			success : showResponse
			, url : "/evnt/evnt_popup.dex"
			, type : 'post'
			, dataType : "json"
			, resetForm : false
	};

	insert_submit = function(f) {
		var form = $(f);
		form.ajaxSubmit(option_update);
		return false;
	};

	function showResponse(responseText, statusText, xhr, $form) {
		if (statusText == 'success') {
			$(".btn-c").html("");
			alert(responseText.result);
			self.close();
		}
		else {
			alert('고맙습니다.');
		}
	}

});
</script>
</head>
<body>
	<form:form id="insert" name="insert" method="post" enctype="multipart/form-data" onSubmit="return insert_submit(this);">
		<input type="hidden" name="userid" value="${userid}" />
		<input type="hidden" name="evnt_no" value="${evnt_no}" />
		<div id="pop-wrap">
			<div id="skipNavi">
				<h1>컨텐츠 바로기기</h1>
				<ul>
					<li><a href="#p-container">본문으로 바로가기</a></li>
					<li><a href="#close">닫기 버튼 바로가기</a></li>
				</ul>
			</div>
			<div class="p-location">
				<c:set var="text" value="${fn:split(input.menu_catgry_name_list,'>')}" />
				${fn:replace(input.menu_catgry_name_list,text[fn:length(text)-1],'')}
				<strong>${text[fn:length(text)-1] }</strong>
			</div>
			<div id="p-container">
				<h1>${input.evnt_title }</h1>
				<p class="ptext">행사에 참여 가능한 날짜 및 시간을 선택해 주세요.</p>
				<div class="pbox">
					<ul>
						<c:forEach items="${notlist}" var="each" varStatus="loop">
							<li <c:if test="${loop.index==0}"> class="first" </c:if>  >
								<input type="radio" id="select1" class="radio" name="not_cfg_no" value="${each.not_cfg_no }" <c:if test="${loop.index==0}"> checked </c:if> />
								<label for="select1">${each.not_date }</label>
							</li>
						</c:forEach>
					</ul>
				</div>
				<p class="ptext">행사참여시 필요한 추가정보를 입력해주세요.</p>
				<table class="board-write board-write2" summary="행사후기 등록페이지입니다.">
					<caption>행사후기 등록</caption>
					<colgroup>
						<col style="width:20%;" />
						<col />
					</colgroup>
					<tbody class="type">

						<tr>
							<th scope="row"><label for="phone">이름</label></th>
							<td>
								<input type="text" class="text" id="username" name="username" value="${username}" readonly style="width:150px;height:16px;" />
								<c:if test="${pageContext['request'].userPrincipal == null}">
									<a href="javascript:fnNiceMain();" ><img src="/cms/image/btn_niceid.gif" alt="본인인증" /></a>
								</c:if>
							</td>
						</tr>
						<c:if test="${pageContext['request'].userPrincipal == null}">
							<th scope="row"><label for="phone">이용동의</label></th>
							<td>
								<input type="checkbox" id="chka" class="check" />
								<label for="chka">서비스 이용약관에 동의 합니다.</label>
								<a href="javascript:fnOpenTerms('/?menuno=674');"><strong>상세보기</strong></a>
								<br/>
								<input type="checkbox" id="chkb" class="check" />
								<label for="chkb">개인정보 보호정책에 동의 합니다.</label>
								<a href="javascript:fnOpenTerms('/?menuno=675');"><strong>상세보기</strong></a>
							</td>
						</c:if>
						<c:if test="${input.contact_yn =='1' }">
							<tr>
								<th scope="row"><label for="phone">연락처</label></th>
								<td>
								<input type="text" id="phone1" name="contact1" title="전화번호 앞 세자리 입력하세요" class="text"  maxlength="3" style="width:57px;height:16px;" />
								-
								<input type="text" id="phone2" name="contact2" title="전화번호 중간 네자리 입력하세요" class="text" maxlength="4" style="width:57px;height:16px;" />
								-
								<input type="text" id="phone3" name="contact3" title="전화번호 마지막 네자리 입력하세요" class="text" maxlength="4" style="width:57px;height:16px;" />
								※휴대폰 번호를 입력해 주세요.
								</td>
							</tr>
						</c:if>
						<c:if test="${input.addr_yn =='1' }">
							<tr>
								<th scope="row"><label for="mail">주소</label></th>
								<td>
								<input type="text" name="useraddrno1" id="useraddrno1" maxlength="3" readonly title="우편번호 앞자리" class="text" style="width:57px;height:16px;" />
								-
								<input type="text" name="useraddrno2" id="useraddrno2"  maxlength="3" readonly title="우편번호 뒷자리" class="text" style="width:57px;height:16px;" />
								<a href="javascript:newpostsearch();" ><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호검색" /></a><br />
								<input type="text" name="useraddr" id="useraddr" readonly title="주소를 입력하세요" class="text" style="width:90%;height:16px;margin:2px 0; " /><br />
								<input type="text" name="useraddr2" id="useraddr2" title="나머지 주소를 입력하세요" class="text" style="width:90%;height:16px;margin:2px 0;" />
								</td>
							</tr>
						</c:if>
						<c:if test="${input.extra_yn =='1' }">
							<tr>
								<th scope="row"><label for="date">내용</label></th>
								<td><input type="text" name="extra_conts" id="extra_conts" class="text" title="추가정보를 입력하게요" style="width:90%;height:18px;" /><br />
									※ 100자 이내로 작성하여 주십시오
								</td>
							</tr>
						</c:if>
						<c:if test="${input.additional_yn =='1' }">
							<tr>
								<th scope="row"><label for="text">내용</label></th>
								<td><textarea rows="89" cols="5" name="additional_conts" id="extra_conts" style="width:90%;height:60px;">${input.additional_conts}</textarea></td>
							</tr>
						</c:if>
						<c:if test="${input.attach_yn =='1' }">
							<tr>
								<th scope="row"><label for="file">파일첨부</label></th>
								<td><input type="file" name="evntfile" style="width:60%;height:18px;" /></td>
							</tr>
						</c:if>

					</tbody>
				</table>

				<div class="pbox">
					<label for="phone" class="phone">안내사항</label>
					<ul>
						<li>- ${input.caution}</li>
					</ul>
				</div>

				<%-- <ul class="plist">
					<li>※ 안내사항
						<ul>
							<li>- ${input.caution}</li>
						</ul>
					</li>
				</ul> --%>
				<c:if test="${pageContext['request'].userPrincipal != null}">
					<div class="btn-c">
						<a href="javascript:submit_c('no');"><img id="btn_img" src="/usr/image/common/btn/btn_app03.gif" alt="신청하기" /></a>
					</div>
				</c:if>
				<c:if test="${pageContext['request'].userPrincipal == null}">
					<div class="btn-c">
						<a href="javascript:submit_c('yes');"><img id="btn_img" src="/usr/image/common/btn/btn_app03.gif" alt="신청하기" /></a>
					</div>
				</c:if>
			</div>
			<a href="#" onclick="window.opener.closePopup(); window.close();" id="close"><img src="/usr/image/popup/btn_close.gif" alt="닫기" /></a>
		</div>
	</form:form>

</body>
</html>