<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>국민참여 | 한국국제교류재단</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0" name="viewport" />
<link rel="stylesheet" type="text/css" href="/usr/css/tmp/m_democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script src='/com/js/jquery.form.min.js'></script>
<script src='/com/js/purl.js'></script>
<script type="text/javascript" src="/usr/js/popupclose.js"></script>
<script type="text/javascript">
function submit_c(){
	$("#btn_img").hide();
	if($("#username").val() ==""){
		alert("본인 인증을 해주세요");
		$("#username").focus();
		$("#btn_img").show();
		return false;
	}
	if($("#phone1").val() ==""){
		alert("연락처를 입력해 주세요");
		$("#phone1").focus();
		$("#btn_img").show();
		return false;
	}
	if($("#phone2").val() ==""){
		alert("연락처를 입력해 주세요");
		$("#phone2").focus();
		$("#btn_img").show();
		return false;
	}
	if($("#phone3").val() ==""){
		alert("연락처를 입력해 주세요");
		$("#phone3").focus();
		$("#btn_img").show();
		return false;
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
	url = "/skin/nice_namecheck/NiceID_main.html?parentmove=no";
	window.open(url, "result1122", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=420");
}
$(function(){





	/*
	 * form submit*/
	/* var option_update = {
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
	} */

});
</script>
</head>
<body>
	<%-- <form:form id="insert" name="insert" method="post" enctype="multipart/form-data" onSubmit="return insert_submit(this);"> --%>
	<form:form id="insert" name="insert" method="post" action="/evnt/evnt_popup_mobile.html" enctype="multipart/form-data" >
		<input type="hidden" name="userid" value="${userid}" />
		<input type="hidden" name="evnt_no" value="${evnt_no}" />

		<div id="wrap">
			<div id="skipNavi">
				<h1>컨텐츠 바로기기</h1>
				<ul>
					<li><a href="#p-container">본문으로 바로가기</a></li>
					<li><a href="#close">닫기 버튼 바로가기</a></li>
				</ul>
			</div>

			<div id="container">

				<div class="location">
					국제교류재단 모바일
					<c:set var="text" value="${fn:split(input.menu_catgry_name_list,'>')}" />
					${fn:replace(input.menu_catgry_name_list,text[fn:length(text)-1],'')}
					<strong> ${text[fn:length(text)-1] }</strong>
				</div>

				<h4 class="btit">${input.evnt_title }</h4>
				<!--<p class="ptext">행사에 참여 가능한 날짜 및 시간을 선택해 주세요.</p>-->

				<div class="box">
					<ul>
						<c:forEach items="${notlist}" var="each" varStatus="loop">
							<li <c:if test="${loop.index==0}"> class="first" </c:if>  >
								<input type="radio" id="select1" class="radio" name="not_cfg_no" value="${each.not_cfg_no }" <c:if test="${loop.index==0}"> checked </c:if> />
								<label for="select1">${each.not_date }</label>
							</li>
						</c:forEach>
					</ul>
				</div>
				<p class="text">행사참여시 필요한 추가정보를 입력해주세요.</p>
				<table class="board-write" summary="정보입력.">
					<caption>정보입력</caption>
					<colgroup>
						<col style="width:25%;" />
						<col style="width:75%;" />
					</colgroup>
					<tbody>

						<tr>
							<th scope="row"><label for="phone">이름</label></th>
							<td>
								<input type="text" class="text" id="username" name="username" value="${username}" readonly style="width:120px;height:18px;text-align:center;" />
								<c:if test="${pageContext['request'].userPrincipal == null}">
									<a href="javascript:fnNiceMain();" ><img src="/cms/image/btn_niceid.gif" alt="본인인증" /></a>
								</c:if>
							</td>
						</tr>
						<c:if test="${input.contact_yn =='1' }">
							<tr>
								<th scope="row"><label for="phone">연락처</label></th>
								<td>
									<input type="text" id="phone1" name="contact1" title="전화번호 앞 세자리 입력하세요" class="text"  maxlength="3" style="width:50px;height:18px;text-align:center;" />
									-
									<input type="text" id="phone2" name="contact2" title="전화번호 중간 네자리 입력하세요" class="text" maxlength="4" style="width:50px;height:18px;text-align:center;" />
									-
									<input type="text" id="phone3" name="contact3" title="전화번호 마지막 네자리 입력하세요" class="text" maxlength="4" style="width:50px;height:18px;text-align:center;" />
									<br />
									※휴대폰 번호를 입력해 주세요.
								</td>
							</tr>
						</c:if>
						<%-- <c:if test="${input.addr_yn =='1' }">
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
						</c:if> --%>
						<c:if test="${input.extra_yn =='1' }">
							<tr>
								<th scope="row"><label for="date">내용</label></th>
								<td>
									<input type="text" name="extra_conts" id="extra_conts" class="text" title="내용을 입력하세요" style="width:90%;height:18px;">
									<br />
									※100자 이내로 입력해 주세요.
								</td>
							</tr>
						</c:if>
						<c:if test="${input.additional_yn =='1' }">
							<tr>
								<th scope="row"><label for="text">내용</label></th>
								<td><textarea rows="89" cols="5" name="additional_conts" id="extra_conts" style="width:90%;height:60px;">${input.additional_conts}</textarea></td>
							</tr>
						</c:if>
						<%-- <c:if test="${input.attach_yn =='1' }">
							<tr>
								<th scope="row"><label for="file">파일첨부</label></th>
								<td><input type="file" name="evntfile" style="width:60%;height:18px;" /></td>
							</tr>
						</c:if> --%>

					</tbody>
				</table>

				<ul class="list2">
					<li> ※ 안내사항
						<ul>
							<li>- ${input.caution}</li>
						</ul>
					</li>
				</ul>

				<%-- <ul class="plist">
					<li>※ 안내사항
						<ul>
							<li>- ${input.caution}</li>
						</ul>
					</li>
				</ul> --%>

				<div class="btn-c">
					<!--<a href="javascript:submit_c();"><img id="btn_img" src="/usr/image/common/btn/btn_app03.gif" alt="신청하기" /></a>-->
					<a class="btn" href="javascript:submit_c();">신청하기</a>
					<a class="btn cencle" href="#" onclick="self.close();" >취소</a>
				</div>
			</div>

			<p class="text">※ 신청하신 상세한 내용과 당첨자정보는 PC버전에서 확인하실 수 있습니다.</p>
		</div>
	</form:form>
</body>
</html>