<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<link rel="stylesheet" href="//cdn.rawgit.com/xdan/datetimepicker/master/jquery.datetimepicker.css">
<script src="//cdn.rawgit.com/xdan/datetimepicker/master/jquery.datetimepicker.js"></script>
<!-- <link rel="stylesheet" href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css"> -->
<!-- <script src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script> -->
<script src='/usr/js/events/form_valid_check.js'></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".btn-add-row").bind("click", function () {
		var obj = $("#fee_zone");
		var src_obj = obj.find("li").last();
		var child = src_obj.clone();
		child.css('display', 'block');
		child.appendTo(obj);
	});
});

function addFee(){

 	var tblappend = $("li[name=feeLi]").length;
 	var feeno = tblappend+1;

 	$("#fee_zone").append('<li id="feeLi'+feeno+'" name="feeLi">\
 			\n<span>참가비 명칭</span> <input style="height:21px;" type="text" name="feeTitle" id="feeTitle'+feeno+'" class="evEntryFeeTitle text" />\
 			\n<select name="feeTarget" id="feeTarget'+feeno+'" class="feeTarget" style="height:27px;">\
 			\n<option value="0" selected>비회원</option>\
 			\n<option value="1">준회원</option>\
 			\n<option value="2">정회원</option>\
 			\n</select>\
 			\n<input type="text" value="" name="feeSum" id="feeSum'+feeno+'" maxlength="10" class="feeSum number  text" /><span class="pd"> 원</span>\
 			\n</li>');
 }
function delFee(){
 	var tblappend = $("li[name=feeLi]").length;
 	if(tblappend > 1)
 		$("#feeLi"+tblappend).remove();
 }

</script>
<style type="text/css">
table.mgtype20 {margin-top: 10px;}
input.text {height: 18px; font-size: 12px; padding-left: 3px;}
input.title {width: 600px;}
textarea {font-size: 12px; padding: 3px;}
a.btn-add-row {
	display:inline-block;
	background:#9d9d9d;
	color:#fff;
	padding:3px 3px;
	height:15px;
	line-height:15px;
	font-size:10px;
	font-family:NANUM;
	margin-left: 3px;
}
#fee_zone li {margin: 5px 0;}
</style>

<div id="container">
		<jsp:include page="../lnb.jsp" flush="true" />
	<div id="contents">
		<div class="contants_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/mail/">업무관리</a> <strong>행사 관리</strong>
				</div>
			</div>
		<form:form id="${mode}Events" name="events" action="./${mode}.html"  method="post" enctype="multipart/form-data" onSubmit="return write_submit(this);">
		<c:if test="${mode eq 'update'}">
			<input type="hidden" name="ev_idx" value="${eventsInfo.evIdx}">
		</c:if>
				<div id="content">
				<ul class="homepagebbs">
					<li class="bg">
						<h3 class="setting">행사 정보</h3>
					</li>
				<div class="main_table">
				<table class="main_table1 summary="행사 정보">
					<caption>행사 정보</caption>
					<colgroup>
						<col width="15%" />
						<col width="78%" />
					</colgroup>
					<tr>
						<th scope="row">제목 (*)</th>
						<td class="Tbod Tleft">
							<input type="text" id="evTitle" name="evTitle" class="text title" maxlength="100" value="${eventsInfo.evTitle}" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone" scope="row">행사분류 (*)</th>
						<td class="Tleft">
							<select name="evCategory" id="evCategory" style="height:27px;">
								<option>분류선택</option>
								<option value="정기총회" <c:if test="${eventsInfo.evCategory eq '정기총회'}">selected="selected"</c:if>>정기총회</option>
								<option value="세미나" <c:if test="${eventsInfo.evCategory eq '세미나'}">selected="selected"</c:if>>세미나</option>
								<%-- <option value="학술발표대회" <c:if test="${eventsInfo.evCategory eq '학술발표대회'}">selected="selected"</c:if>>학술발표대회</option> --%>
								<option value="관광" <c:if test="${eventsInfo.evCategory eq '관광'}">selected="selected"</c:if>>관광</option>
								<option value="진행위원모집" <c:if test="${eventsInfo.evCategory eq '진행위원모집'}">selected="selected"</c:if>>진행위원모집</option>
								<option value="기타" <c:if test="${eventsInfo.evCategory eq '기타'}">selected="selected"</c:if>>기타</option>
								<%-- <option value="초록접수" <c:if test="${eventsInfo.evCategory eq '초록접수'}">selected="selected"</c:if>>초록접수</option> --%>
								<option value="연구위원회" <c:if test="${eventsInfo.evCategory eq '연구위원회'}">selected="selected"</c:if>>연구위원회</option>
							</select>
						</td>
					</tr>
					<tr>
						<th class="Tbornone" scope="row">행사기간 (*)</th>
						<td class="Tleft"><span class="pd-first">시 작 일</span>
							<input type="text" id="evStartDate" value="${eventsInfo.evStartDate}" name="evStartDate" maxlength="10" class="date-pick text" /><span class="pd"> 부터</span>
							<span class="pd-first">종 료 일 </span>
							<input type="text" id="evEndDate" value="${eventsInfo.evEndDate}" name="evEndDate" maxlength="10" class="date-pick text" /><span class="pd"> 까지</span>
						</td>
					</tr>
					<tr>
						<th class="Tbornone" scope="row">사전등록기간 (*)</th>
						<td class="Tleft"><span class="pd-first">시작일시</span>
							<input type="text" id="evRegisStartTime" value="${eventsInfo.evRegisStartTime}" name="evRegisStartTime" maxlength="12" class="datetimepicker text" /><span class="pd"> 부터</span>
							<span class="pd-first">종료일시</span>
							<input type="text" id="evRegisEndTime" value="${eventsInfo.evRegisEndTime}" name="evRegisEndTime" maxlength="12" class="datetimepicker text" /><span class="pd"> 까지</span>
						</td>
					</tr>
					<tr>
						<th class="Tbornone" scope="row">개최장소 (*)</th>
						<td class="Tleft">
							<input type="text" id="evOpenSite" name="evOpenSite" class="text title" maxlength="100" value="${eventsInfo.evOpenSite}" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone" scope="row">게재일 (*)</th>
						<td class="Tleft">
							<input type="text" id="evOpenDate" value="${eventsInfo.evOpenDate}" name="evOpenDate" maxlength="10" class="date-pick text" />
						</td>
					</tr>
					<tr>
						<th class="Tbornone" scope="row">행사참가비 (*)</th>
						<td class="Tleft">
							<div class="btn-r03">
								<a class="blue" href="javascript:addFee();" >+ 참가비 추가</a>
								<a class="red" href="javascript:delFee();" >- 참가비 삭제</a>
							</div>
							<ul class="fee_zone" id="fee_zone">
							<c:forEach items="${feeList}" var="each" varStatus="loop">
								<li id="feeLi${loop.count }" name="feeLi">
									<span>참가비 명칭</span><input style="height:21px;" type="text" name="feeTitle" id="feeTitle${loop.count }" class="evEntryFeeTitle text" value="${each.efTitle}"/>
									<select name="feeTarget" id="feeTarget${loop.count }" class="feeTarget" style="height:27px;">
										<option value="0" <c:if test="${each.efTargetLevel eq '0'}">selected</c:if>>비회원</option>
										<option value="3" <c:if test="${each.efTargetLevel eq '3'}">selected</c:if>>준회원</option>
										<option value="1" <c:if test="${each.efTargetLevel eq '1'}">selected</c:if>>정회원</option>
									</select>
									<input style="height:21px;" type="text" value="${each.efChargeSum}" name="feeSum" id="feeSum${loop.count }" maxlength="10" class="feeSum number  text" /><span class="pd"> 원</span>
								</li>
							</c:forEach>
							<c:if test="${empty feeList}">
								<li id="feeLi1" name="feeLi">
									<span>참가비 명칭</span> <input style="height:21px;" type="text" name="feeTitle" id="feeTitle1" class="evEntryFeeTitle text" />
									<select name="feeTarget" id="feeTarget1" class="feeTarget" style="height:27px;">
										<option value="0" selected>비회원</option>
										<option value="3">준회원</option>
										<option value="1">정회원</option>
									</select>
									<input style="height:21px;" type="text" name="feeSum" id="feeSum1" maxlength="10" class="feeSum number  text" /><span class="pd"> 원</span>
								</li>
							</c:if>
							</ul>
						</td>
					</tr>
					<%--
					<c:if test="${eventsInfo.evIdx ne ''}">
					<tr>
						<th scope="row">팝업창</th>
						<td>
							<input type="checkbox"/> 1주일동안 팝업창을 띄웁니다.
						</td>
					</tr>
					</c:if> --%>

					<tr>
						<th class="Tbornone" scope="row">내용 (*)</th>
						<td class="Tleft">
							<textarea name="evContents" id="evContents" cols="150" rows="20">
								<c:if test="${not empty eventsInfo.evContents}">${fn:replace(eventsInfo.evContents, newLineChar, '<br/>')}</c:if>
							</textarea>
						</td>
					</tr>
					<tr>
						<th class="Tbornone" scope="row">첨부파일</th>
						<td class="Tleft">
							<input type="file" id="evAttFileName" name="evAttFileName" />
							<c:if test="${not empty eventsInfo.evAttFileName}"><br />${eventsInfo.evAttRealName}</c:if>
						</td>
					</tr>
				</table>
				<div class="btn-c">
					<input type="submit" value="등록" class="chost_btn_s" />
					<a href="./list.html" class="btmore09">취소</a>
				</div>
				<!--
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<div class="confirm">
								<p>
									<input type="image" src="/cms/image/upload.jpg" alt="등록" />
									<a href="./list.html"><img src="/cms/image/btn_cancel.jpg" alt="취소" />
								</p>
							</div>

						</td>
					</tr>
				</table>
				-->
			</div>
			</div>
			<!--/content-->
			</li>
		</ul>
		</form:form>
	</div>
	<!--/contents-->
</div>
<!--/container-->
</div>
<!--/wrap-->
</body>
</html>