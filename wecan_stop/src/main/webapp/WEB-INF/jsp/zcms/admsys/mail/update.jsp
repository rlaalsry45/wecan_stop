<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<script type="text/javascript">
$(function(){
	$('.date-pick').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,minDate : 0
	});

	//숫자만 입력
	 $(".number").bind("keyup", function () {
       $(this).val($(this).val().replace(/[^0-9]/gi, ""));
     });

	insert_submit = function(f) {
		var form = $(f);
		//var bodyCont = Editor.getContent();
		//$("#conts").val(bodyCont);

		var fromemail = $('#fromemail').val();
		if(fromemail == ""){
			alert('회신 이메일을 입력하십시오.');
			$('#fromemail').focus();
			return false;
		}

		var title = $('#title').val().trim();
		if (typeof(title) == 'undefined' || title == '') {
			alert('제목을 입력하십시오.');
			$('#title').focus();
			return false;
		}

		var conts = CKEDITOR.instances['conts'].getData()
		var conts = conts.replace(/<.*?>/g,'').trim();

		if (typeof(conts) == 'undefined' || conts == '' || conts == '&nbsp;') {
			alert('내용을 입력하십시오.');
			$('#conts').focus();
			return false;
		}

		var reservedate = $('#reservedate').val().trim();
		var reservetime = $('#reservetime').val().trim();
		var reservemin = $('#reservemin').val().trim();
		if (typeof(reservedate) == 'undefined' || reservedate == '') {
			alert('발송시간을 입력하십시오.');
			$('#reservedate').focus();
			return false;
		}
		if (typeof(reservetime) == 'undefined' || reservetime == '--' || reservetime == '') {
			alert('발송시간을 선택하십시오.');
			$('#reservetime').focus();
			return false;
		}
		if (typeof(reservemin) == 'undefined' || reservemin == '--' || reservemin == '') {
			alert('발송 분을 선택하십시오.');
			$('#reservemin').focus();
			return false;
		}

		var usernos = $("[name=user_dest]").find("option").map(function(){return $(this).val();}).get();
		$("#usernos").val(usernos);


		if(confirm("수정하시면 이미 발송된 회원에게도 예약된 시간에 다시 메일이 발송됩니다. 그래도 수정하시겠습니까?")){
			//Editor.save();
			document.frm.submit();

		}

	};
	/* if( $('#panner_userno_text').length  > 0){
		var pannel_info = $('#panner_userno_text').text();
		//userno = {username,useremail} - json 형태
		var obj = new Array();
		if(pannel_info != ""){
			obj = JSON.parse(pannel_info);
		}
		display_user_info(obj);

	} */
});

//컨퍼런스에서 패널 선택 팝업
function usersearch(){

	var url = "/front/user/popupUserList.html";
	var windowName = "search_post";
	var windowWidth = 468;
	var windowHeight = 360;
	var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
	var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
	var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop + ",scrollbars=1";
	window.open(url, windowName, windowSize);
	return false;
}
//팝업에서 유저 선택시
function select_user(userno, userid, username,dept_nm,userphone,useremail){
	var pannel_info = $('#panner_userno_text').text();//{username,useremail} - json 형태
	var obj = new Array();
	if(pannel_info != ""){
		obj = JSON.parse(pannel_info);
	}

	//등록된 사람인지 유저번호로 검색
	for (var i=0 ; i < obj.length ; i++)
	{
	    if (obj[i]['userno'] == userno) {
	        alert('이미 선택된 사용자입니다.');
	        return false;
	    }
	}
	obj.push({
        "userno" : userno,
        "username"  : username,
        "useremail" : useremail
    });
	display_user_info(obj);
}
//팝업에서 유저 선택시
function remove_user(userno){
	var pannel_info = $('#panner_userno_text').text();
	//userno = {username,useremail} - json 형태
	var obj = new Array();
	if(pannel_info != ""){
		obj = JSON.parse(pannel_info);
	}
	var data = $.grep(obj, function(e){
	     return e.userno != userno;
	});

	display_user_info(data);

	return false;
}

function select_user(arg)
{
	with(document.frm) {
		var source = arg;
		var dest = arg.replace("source","dest");
		var flag = false;
		for (var i=0;i<eval(source).length;i++){
			flag = false;
			if (eval(source).options[i].selected){
				var oOption = document.createElement("OPTION");
				oOption.text = eval(source).options[i].text;
				oOption.value = eval(source).options[i].value;
				for (var j=0;j<eval(dest).length;j++){
					if(eval(dest).options[j].value==eval(source).options[i].value){
						flag = true;
						break;
					}
				}
				if (!flag){
					eval(dest).add(oOption);
				}
				eval(source).options[i].selected = false;
			}
		}
	}
}

function deselect_user(arg)
{
	with(document.frm) {
		for (var i=eval(arg).length-1;i>=0;i--){
			if (eval(arg).options[i].selected){
				eval(arg).options.remove(i);
			}
		}
	}
}

function searchUser(){
	var cond2 = $("#cond2").val();
	var keyword = $("#keyword").val();
	var work_grade = $("#work_grade").val();
	var pageSize = $("#pageSize").val();
	var data= "keyword="+keyword+"&work_grade="+work_grade+"&cond2="+cond2+"&pageSize="+pageSize;
	//return;
	$.ajax({
		type: 'post'
		, async: true
		, data:data
		, url: '/admsys/mail/searchUser.html'
		, success: function(data) {
			var innerHtml ='';
			for (var i=0 ; i < data.length ; i++){
				if(data[i].newsletter1 !='1'){
					data[i].newsletter1 = ' - 수신거부';
				}else{
					data[i].newsletter1 = '';
				}
				innerHtml += "<option value='"+data[i].userno+"'>"+data[i].username+" : "+data[i].userid+ " [ " +data[i].work_grade+ " : "+data[i].useremail +":"+data[i].newsletter1 +" ] "+"</option>";
			}
			$("#searchUserOption").html(innerHtml);
		}
		, error: function(data, status, err) {
			alert('서버와의 통신이 실패했습니다.');
		}
	});

}
function quickSendMail(idx){
	var data= "idx="+idx;

	if(confirm("대용량 메일의 경우 시스템에 부하를 줄수 있는 관계로 직접 발송 보다는 예약을 걸어두는 편이 안정적입니다.\n그래도 즉시 발송 하시겠습니까?")){
		$.ajax({
			type: 'post'
			, async: true
			, data:data
			, url: '/admsys/mail/mailSendQuick.html'
			, success: function(data) {
				if(data == '1'){
					alert('정상적으로 메일이 발송 되었습니다.');
					window.location.reload();
				}else{
					alert('메일 발송도중 에러가 발생하였습니다. 시스템 관리자에게 문의하시기 바랍니다.');
				}

			}
			, error: function(data, status, err) {
				alert('서버와의 통신이 실패했습니다.');
			}
		});
	}

}

</script>
<div id="container">
	<jsp:include page="../lnb.jsp" flush="true" />
	<div id="contents">
			<div class="contants_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/mail/" title="자유결제관리로 이동">메일발송관리</a> <strong>메일 생성</strong>
				</div>
			</div>
			<form id="insert" name="frm" action="update.html"  method="post" enctype="multipart/form-data" >
			<input type="hidden" id="idx" name="idx" value="${mail.idx}">
			<input type="hidden" id="usernos" name="usernos" value="" />
			<input name="act" type="hidden" value="update" />
				<div id="content">
					<ul class="homepagebbs">
						<li class="bg">	<h3 class="setting">메일 생성 [메일내용 정보]</h3></li>
						<li>
							<div class="main_table">
								<table class="main_table1 bgneno" width="90%" summary="메일내용">
									<caption>메일내용 생성</caption>
									<colgroup>
										<col width="10%" />
										<col width="" />
									</colgroup>
									<tr>
										<th  class="Tleft" scope="row">회신 이메일</th>
										<td class="Tbod Tbod Tleft">
											<input type="text" value="${mail.fromemail }" id="fromemail" value="" name="fromemail" class="text" maxlength="100" style="width:400px;height:19px;" />
										</td>
									</tr>
									<tr>
										<th class="Tbornone Tleft" scope="row">제목</th>
										<td class="Tleft">
											<input type="text" value="${mail.title }" id="title" value="" name="title" class="text" maxlength="100" style="width:400px;height:19px;" />
										</td>
									</tr>

									<tr id ="123">
										<th class="Tbornone Tleft" scope="row">내용</th>
										<td class="Tleft">
											<%-- ckeditor --%>
											<script type="text/javascript" src="/var/ckeditor/ckeditor.js"></script>
											<script type="text/javascript">CKEDITOR.dtd.$removeEmpty['span'] = false;</script>
											<script type="text/javascript">

											window.onload=function() {

												CKEDITOR.replace("conts" ,{

													skin : 'office2013',

													extraPlugins:'lineutils,widget,autosave',		// fontawesome-이메일발송시 css 안되는 문제로 뺌.
													//contentsCss : '/var/ckeditor/plugins/fontawesome/font-awesome/css/font-awesome.min.css',

													//width : '620px',			// 입력창의 넓이, 넓이는 config.js 에서 % 로 제어
													height : '500px',			// 입력창의 높이

													fullPage: true,				// 모든 html 허용
													allowedContent: true,		// 모든 html 허용

													toolbar : [
														{ name: 'tools', items: [ 'Maximize'] },
														{ name: 'document', groups: [ 'mode', 'document', 'doctools' ], items: [ 'Source', '-', 'Preview', 'Print', '-', 'Templates' ] },
														{ name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
														{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ], items: [ 'Find', 'Replace', '-', 'SelectAll', '-', 'Scayt' ] },
														'/',
														{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
														{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl' ] },
														{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
														'/',
														{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'SpecialChar', 'PageBreak'] },
														{ name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
														{ name: 'colors', items: [ 'TextColor', 'BGColor' ] }
													],

													filebrowserBrowseUrl: '/var/filemanager/index.jsp',
													enterMode: CKEDITOR.ENTER_BR,
													language : 'ko',

												});
											}

											</script>
											<%-- ckeditor --%>

											<textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="30">${mail.conts }</textarea>

											<%--
											<div id="txtarea" style="display:none">
												<textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="30">${mail.conts }</textarea>
											</div>
											<div id="editorarea" style="width:96%;">
												<c:import url="/var/editor/index.jsp" />
											</div>
											--%>

											<%--
											<textarea rows="10" cols="80" id="conts" value="" name="conts" class="text" >${mail.conts }</textarea>
											--%>
										</td>
									</tr>
									<%-- <tr>
										<th class="Tbornone Tleft" scope="row">발송일시</th>
										<td class="Tleft">
											
											<input type="radio" value="0" name="isendless" id="isendless1" <c:if test="${mail.isendless eq '0' }">checked</c:if>>임시저장 &nbsp;&nbsp;&nbsp;
											<input type="radio" value="1" name="isendless" id="isendless2" <c:if test="${mail.isendless eq '1' }">checked</c:if>>발송시간 설정<br /><br />
											
											<span class="pd-first">발송일시</span>
											<input readonly value="${fn:substring(mail.reservedate,0,10) }" type="text" id="reservedate" value="" name="reservedate" maxlength="10" class="date-pick number text" style="height:19px;" /><span class="pd"></span>
											
											${mail.reservedate}
											${fn:substring(mail.reservedate,10,12)}
											
											<select name="reservetime" id="reservetime" style="height:27px;">
												<option value="00" <c:if test="${fn:substring(mail.reservedate,10,12) eq '00'}" >selected</c:if> >00</option>
												<option value="01" <c:if test="${fn:substring(mail.reservedate,10,12) eq '01'}" >selected</c:if> >01</option>
												<option value="02" <c:if test="${fn:substring(mail.reservedate,10,12) eq '02'}" >selected</c:if> >02</option>
												<option value="03" <c:if test="${fn:substring(mail.reservedate,10,12) eq '03'}" >selected</c:if> >03</option>
												<option value="04" <c:if test="${fn:substring(mail.reservedate,10,12) eq '04'}" >selected</c:if> >04</option>
												<option value="05" <c:if test="${fn:substring(mail.reservedate,10,12) eq '05'}" >selected</c:if> >05</option>
												<option value="06" <c:if test="${fn:substring(mail.reservedate,10,12) eq '06'}" >selected</c:if> >06</option>
												<option value="07" <c:if test="${fn:substring(mail.reservedate,10,12) eq '07'}" >selected</c:if> >07</option>
												<option value="08" <c:if test="${fn:substring(mail.reservedate,10,12) eq '08'}" >selected</c:if> >08</option>
												<option value="09" <c:if test="${fn:substring(mail.reservedate,10,12) eq '09'}" >selected</c:if> >09</option>
												<option value="10" <c:if test="${fn:substring(mail.reservedate,10,12) eq '10'}" >selected</c:if> >10</option>
												<option value="11" <c:if test="${fn:substring(mail.reservedate,10,12) eq '11'}" >selected</c:if> >11</option>
												<option value="12" <c:if test="${fn:substring(mail.reservedate,10,12) eq '12'}" >selected</c:if> >12</option>
												<option value="13" <c:if test="${fn:substring(mail.reservedate,10,12) eq '13'}" >selected</c:if> >13</option>
												<option value="14" <c:if test="${fn:substring(mail.reservedate,10,12) eq '14'}" >selected</c:if> >14</option>
												<option value="15" <c:if test="${fn:substring(mail.reservedate,10,12) eq '15'}" >selected</c:if> >15</option>
												<option value="16" <c:if test="${fn:substring(mail.reservedate,10,12) eq '16'}" >selected</c:if> >16</option>
												<option value="17" <c:if test="${fn:substring(mail.reservedate,10,12) eq '17'}" >selected</c:if> >17</option>
												<option value="18" <c:if test="${fn:substring(mail.reservedate,10,12) eq '18'}" >selected</c:if> >18</option>
												<option value="19" <c:if test="${fn:substring(mail.reservedate,10,12) eq '19'}" >selected</c:if> >19</option>
												<option value="20" <c:if test="${fn:substring(mail.reservedate,10,12) eq '20'}" >selected</c:if> >20</option>
												<option value="21" <c:if test="${fn:substring(mail.reservedate,10,12) eq '21'}" >selected</c:if> >21</option>
												<option value="22" <c:if test="${fn:substring(mail.reservedate,10,12) eq '22'}" >selected</c:if> >22</option>
												<option value="23" <c:if test="${fn:substring(mail.reservedate,10,12) eq '23'}" >selected</c:if> >23</option>
											</select>
											시
											<select name="reservemin" id="reservemin" style="height:27px;">
												<option value="00" <c:if test="${fn:substring(mail.reservedate,12,14) eq '00'}" >selected</c:if>>00</option>
												<option value="10" <c:if test="${fn:substring(mail.reservedate,12,14) eq '10'}" >selected</c:if>>10</option>
												<option value="20" <c:if test="${fn:substring(mail.reservedate,12,14) eq '20'}" >selected</c:if>>20</option>
												<option value="30" <c:if test="${fn:substring(mail.reservedate,12,14) eq '30'}" >selected</c:if>>30</option>
												<option value="40" <c:if test="${fn:substring(mail.reservedate,12,14) eq '40'}" >selected</c:if>>40</option>
												<option value="50" <c:if test="${fn:substring(mail.reservedate,12,14) eq '50'}" >selected</c:if>>50</option>
											</select>
											분
										</td>
									</tr>
									<tr>
										<th class="Tbornone Tleft" scope="row">비고</th>
										<td class="Tleft">
											<textarea rows="3" cols="80" id="ref" value="" name="ref" class="text" >${mail.ref }</textarea>
										</td>
									</tr>
									<tr>
										<th class="Tbornone Tleft" scope="row">사용유무</th>
										<td class="Tleft">
											<input type="radio" value="1" name="status" <c:if test="${mail.status eq '1' }">checked</c:if>>사용 &nbsp;&nbsp;&nbsp;
											<input type="radio" value="0" name="status" <c:if test="${mail.status eq '0' }">checked</c:if>>미사용
										</td>
									</tr>
								</table>
								<div class="btn-c">
									<a class="btmore04" href="javascript:insert_submit(this);">수정</a>
									<a href="./index.html" class="btmore09">취소</a>
									<c:if test="${mail.sended ne '1' }" >
										<a href="javascript:quickSendMail('${mail.idx}');" class="btmore09">즉시발송</a>
									</c:if>
								</div> --%>
							</div>
						</li>
					</ul>
				</div><!--/content-->
		</form>
	</div><!--contents-->
</div><!--/container-->
</div><!--/wrap-->
<jsp:include page="../end.jsp" flush="false" />
</body>
</html>