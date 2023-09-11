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
function submit_c(){
	$("#btn_img").hide();
	if($("#username").val() ==""){
		alert("Please Authentication");
		$("#username").focus();
		$("#btn_img").show();
		return false;
	}
	if($("#phone1").val() ==""){
		alert("Please enter a mobile phone number");
		$("#phone1").focus();
		$("#btn_img").show();
		return false;
	}
	if($("#phone2").val() ==""){
		alert("Please enter a mobile phone number");
		$("#phone2").focus();
		$("#btn_img").show();
		return false;
	}
	if($("#phone3").val() ==""){
		alert("Please enter a mobile phone number");
		$("#phone3").focus();
		$("#btn_img").show();
		return false;
	}
	if(confirm("Can not be modified after the application. Do you want to complete an application?")){
		$(".btn-c").html("This process may take hours, depending on the browser. Please wait until the complete message comes out");
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
			alert('thank you.');
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
				<p class="ptext">Please choose the date of event.</p>
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
				<p class="ptext">Please enter the details of event..</p>
				<table class="board-write board-write2" summary="행사후기 등록페이지입니다.">
					<caption>행사후기 등록</caption>
					<colgroup>
						<col style="width:20%;" />
						<col />
					</colgroup>
					<tbody class="type">

						<tr>
							<th scope="row"><label for="phone">Name</label></th>
							<td>
								<input type="text" class="text" id="username" name="username" value="${username}" readonly style="width:150px;height:16px;" />
								<c:if test="${pageContext['request'].userPrincipal == null}">
									<a href="javascript:fnNiceMain();" ><img src="/cms/image/btn_niceid.gif" alt="본인인증" /></a>
								</c:if>
							</td>
						</tr>
						<c:if test="${input.contact_yn =='1' }">
							<tr>
								<th scope="row"><label for="phone">Tel</label></th>
								<td>
								<input type="text" name="contact1" title="Please enter the phone number of the previous three-digit." class="text" id="phone1" maxlength="3" style="width:57px;height:16px;" />
								-
								<input type="text" name="contact2" title="Please enter the digits of the phone number." class="text" id="phone2" maxlength="4" style="width:57px;height:16px;" />
								-
								<input type="text" name="contact3" title="Please enter the last digits of the phone number." class="text" id="phone3" maxlength="4" style="width:57px;height:16px;" />
								</td>
							</tr>
						</c:if>
						<c:if test="${input.addr_yn =='1' }">
							<tr>
								<th scope="row"><label for="mail">Address </label></th>
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
								<th scope="row"><label for="date">Additional contents</label></th>
								<td><input type="text" name="extra_conts" id="extra_conts" class="text" title="추가정보를 입력하게요" style="width:90%;height:18px;" /><br />
									※ Write 100 characters or less
								</td>
							</tr>
						</c:if>
						<c:if test="${input.additional_yn =='1' }">
							<tr>
								<th scope="row"><label for="text">Please enter your message.</label></th>
								<td><textarea rows="89" cols="5" name="additional_conts" id="extra_conts" style="width:90%;height:60px;">${input.additional_conts}</textarea></td>
							</tr>
						</c:if>
						<c:if test="${input.attach_yn =='1' }">
							<tr>
								<th scope="row"><label for="file">Attachment</label></th>
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

				<div class="btn-c">
					<a href="javascript:submit_c();"><img id="btn_img" src="/usr/image/common/btn/btn_app03.gif" alt="신청하기" /></a>
				</div>
			</div>
			<a href="#" onclick="window.opener.closePopup(); window.close();" id="close"><img src="/usr/image/popup/btn_close.gif" alt="닫기" /></a>
		</div>
	</form:form>
</body>
</html>