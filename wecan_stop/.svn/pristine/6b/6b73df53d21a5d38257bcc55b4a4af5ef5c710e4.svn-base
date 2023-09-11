<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("HH");
	String hour = formatter.format(new java.util.Date());

	formatter = new java.text.SimpleDateFormat("mm");
	String min = formatter.format(new java.util.Date());
%>
<c:set var="hour" value="<%=hour %>" />
<c:set var="min" value="<%=min %>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>메일 발송</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/cms/js/valid.js"></script>
<script type="text/javascript" src="/var/ckeditor/ckeditor.js"></script>
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />
<script src='/com/js/jquery-1.10.3-ui.js'></script>
</head>
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
		/* var bodyCont = Editor.getContent();
		$("#conts").val(bodyCont); */
		/* var group = $('#firstGroup').val();

		if(group == ""){
			alert('수신자를 선택하세요.');
			$('#firstGroup').focus();
			return false;
		}

		var group = $('#countPerson').val();

		if(group == "0"){
			alert('수신자가 없습니다..');
			return false;
		} */


		var fromemail = $('#fromemail').val();

		if(fromemail == ""){
			alert('회신 이메일을 입력하십시오.');
			$('#fromemail').focus();
			return false;;
		}

		var title = $('#title').val().trim();
		if (typeof(title) == 'undefined' || title == '') {
			alert('제목을 입력하십시오.');
			$('#title').focus();
			return false;;
		}

		var conts = CKEDITOR.instances['conts'].getData()
		var conts = conts.replace(/<.*?>/g,'').trim();

		if (typeof(conts) == 'undefined' || conts == '' || conts == '&nbsp;') {
			alert('내용을 입력하십시오.');
			$('#conts').focus();
			return false;;
		}


		/* var sendType = $('#sendType:checked').val();

		if(sendType == "2"){
			var reservedate = $('#reservedate').val().trim();
			var reservetime = $('#reservetime').val().trim();
			var reservemin = $('#reservemin').val().trim();

			if (typeof(reservedate) == 'undefined' || reservedate == '') {
				alert('발송날짜를 선택하십시오.');
				$('#reservedate').focus();
				return;
			}
			if (typeof(reservetime) == 'undefined' || reservetime == '--' || reservetime == '') {
				alert('발송시간을 선택하십시오.');
				$('#reservetime').focus();
				return;
			}

			if (typeof(reservemin) == 'undefined' || reservemin == '--' || reservemin == '') {
				alert('발송 분을 선택하십시오.');
				$('#reservemin').focus();
				return;
			}
		} */

		/* var usernos = $("[name=user_dest]").find("option").map(function(){return $(this).val();}).get();
		$("#usernos").val(usernos); */


		if(confirm("메일을 발송하시겠습니까?")){
			//Editor.save();
			return true;
		}

		/* if(sendType == "2"){
			if(confirm("메일을 발송하시겠습니까?")){
				//Editor.save();
				document.frm.submit();
			}
		}else{
			if(confirm("즉시 발송의 경우 안정적인 발송을 위해 2분뒤 발송됩니다.\n 발송하시겠습니까?")){
				//Editor.save();
				document.frm.submit();
			}
		} */


	};

});

</script>
<body>

<div id="contents">
			<form name="frm" id="insert" action="sendMaill.html"  method="post" enctype="multipart/form-data" onsubmit="return insert_submit();">
			<input type="hidden" name="act" id="act" value="${act }"/>
			<input type="hidden" name="chk_no" id="chk_no" value="${chk_no }"/> <!-- 체크된 회원 -->
				<div id="content">
				<ul class="homepagebbs">
					<li class="bg"><h3 class="sub">메일내용 정보</h3></li>
					<li>
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="main_table1 bgneno" summary="CSS명, 입력방법, Import할 파일, 내용, 메모">
							<caption>사이트 추가</caption>
							<colgroup>
								<col width="150px" />
								<col />
							</colgroup>
							<tr>
								<th class="Tleft">받는사람</th>
								<td class="Tbod Tbod Tleft">
									<input type="text" name="csstitle" class="bor1ddd" size="100%" value="<c:forEach var="each" items="${list }" varStatus="loop">${each.companyname }<c:if test="${loop.count ne fn:length(list) }">,</c:if></c:forEach>" />
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">보내는사람</th>
								<td class="Tleft">
									<input type="text" id="fromemail" name="fromemail" class="bor1ddd" value="${mailaddr }" size="100%"/>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">제목</th>
								<td class="Tleft">
									<input type="text" id="title" name="title" class="bor1ddd" size="100%"/>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">내용</th>
								<td class="Tleft">
									<script type="text/javascript">

									window.onload=function() {

										CKEDITOR.replace("conts" ,{

											skin : 'office2013',
											//width : '620px',			// 입력창의 넓이, 넓이는 config.js 에서 % 로 제어
											height : '280px',				// 입력창의 높이

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
												{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak'] },
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

									<textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="6"><div class="mail-contents">
														<p>안녕하세요, 한국콘텐츠진흥원입니다. <br>
															신청하신 상품의 심사결과 2차 심사까지 모두 통과되어 <br>
															‘우수문화상품 지정 마크'를 획득하게 되었음을 알려드립니다.<br><br>

															지정 우수문화상품에 대한 유효기간은 심사결과 합격통보일로부터 3년간으로 하며,
															기간 종료 후 심사를 통해 2년 단위로 그 기간을 연장할 수 있습니다.
														</p>
														<p style="margin-top:35px">
															<img src="https://www.kribbon.kr/images/common/logo_top.png" alt="우수문화상품">
														</p>
													</div>

									</textarea>
								</td>
							</tr>

						</table>
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
					<!--/사이트 추가-->
					<div class="btn-c">
						<input class="chost_btn_s" type="submit" value="발송"/>
						<a class="btmore09" href="javascript:self.close()">취소</a>
					</div>
				</li>
				</ul>
				</div><!--/content-->
			</form>
		</div>

</body>
</html>

