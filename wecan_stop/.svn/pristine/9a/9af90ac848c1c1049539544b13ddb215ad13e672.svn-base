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
		var bodyCont = Editor.getContent();
		$("#conts").val(bodyCont);
		var title = $('#title').val().trim();
		if (typeof(title) == 'undefined' || title == '') {
			alert('제목을 입력하십시오.');
			$('#title').focus();
			return false;
		}
		
		
		var reservedate = $('#reservedate').val().trim();
		var reservetime = $('#reservetime').val().trim();
		if(!$("#isendless1").is(":checked")){
			if (typeof(reservedate) == 'undefined' || reservedate == '') {
				alert('발송날자를 선택하십시오.');
				$('#reservedate').focus();
				return false;
			}
			if (typeof(reservetime) == 'undefined' || reservetime == '--' || reservetime == '') {
				alert('발송시간을 선택하십시오.');
				$('#reservetime').focus();
				return false;
			}
			
			
		}
		var conts = $('#conts').val().trim();
		if (typeof(conts) == 'undefined' || conts == '') {
			alert('내용을 입력하십시오.');
			$('#conts').focus();
			return false;
		}
		
		var usernos = $("[name=user_dest]").find("option").map(function(){return $(this).val();}).get();
		$("#usernos").val(usernos);
		
		Editor.save();
		
		
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
	
	
	$('#firstGroup').change(function(){
		
		
		
		if($(this).val() == "user"){
			
		}else if($(this).val() == "paper"){
			
		}else if($(this).val() == "conference"){
			
		}else if($(this).val() == "event"){
			
		}
		
		var params = "act=firstGroup&value" + $(this).val();
		
		$.ajax({
     		  type : "POST"
     		, data : params
     		, datatype:"json"
     		, cache : false
     		, url : "/journal/front/getIssueList.html"
     		, success : function(data) {
				//console.log(data);
 				//$("select[name='isu_id'] option").remove();
 				var apnd_val = "<option value=''>권호선택</option>";
 				for (var i = 0; i <data.issueList.length; i++) {
 					apnd_val += "<option value='"+data.issueList[i]['isu_ID']+"'>"+data.issueList[i]['isu_NAME_KR']+"</option>";
				}
 				$(".isu_year").each(function()  {
 					$(this).val(sel_year);
 				});
 				$(".isu_id").each(function()  {
 					$(this).empty();
 					$(this).append(apnd_val);
 				});
     		}
     		, error : function(data, status, err) {
     			alert("서버와의 통신이 실패했습니다.");
     			return;
     		}
     	});
		
		
		
	});
	
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
				innerHtml += "<option value='"+data[i].userno+"'>"+data[i].username+" : "+data[i].userid+ " [ " +data[i].work_grade+ " : "+data[i].useremail +data[i].newsletter1 +" ] "+ "</option>";
			}
			$("#searchUserOption").html(innerHtml);
		} 
		, error: function(data, status, err) { 
			alert('서버와의 통신이 실패했습니다.'); 
		}
	});
	
}

</script>
<style>
.search{border:0px;margin-top:20px;}
.search input.text{height:19px;padding:2px 0;border:1px solid #c7c7c7;}
.main_table1{border-top:2px solid #b6c5db;padding:5px 0;}
.main_table1 td{border:0px;padding:10px 0;}
</style>

<div id="container">
		<jsp:include page="../lnb.jsp" flush="true" />
	<div id="r_side">
		<div class="cont_top">
			<div class="location">
				<p>
						<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/mail/" title="자유결제관리로 이동">메일발송관리</a>
						&gt; <span>메일 생성</span>
				</p>
			</div>
			<!--/location-->
		</div>
		<!--/cont_top-->
		<form name="frm" id="insert" action="insert.html"  method="post" enctype="multipart/form-data" >
			<input type="hidden" id="usernos" name="usernos" value="" />
			<div class="page_title">
				<h3>
					메일 생성
				</h3>
			</div>
			<div class="cont-right">
				<h4 class="stit">수신인 설정</h4>
				<%-- <div class="search">
					<div class="srch_right">
						<ul>
							<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
							<li class="srch_right_left">
								<select name="cond1">
									<option value="productnm" <c:if test="${input.cond1=='productnm'}"><c:out value='selected' /></c:if>>상품명</option>
								</select>
								<input type=text name="keyword" value="<c:out value='${input.keyword}' class="text" style="height:19px;" />" />
							</li>
							<li class="srch_btn_go">
								<input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="this.form.action='?pageIndex=1'" />
							</li>
						</ul>
					</div><!--/srch_right-->
				</div><!--/search--> --%>
				<div class="search">
				<select id="cond2" name="cond2" style="height:24px;">
					<option value="username">이름</option>
					<option value="userid">ID</option>
					<option value="userno">유저번호</option>
					<option value="useremail">이메일</option>
				</select>
				<input type="text" id="keyword" value="" class="text" />
				&nbsp;&nbsp;유저등급
				<select name="work_grade" id="work_grade" style="height:24px;">
					<option value="">전체</option>
					<option value='1'>정회원</option>
					<option value='2'>종신회원</option>
					<option value='3'>준회원</option>
					<option value='4'>용역담당자</option>
					<option value='6'>외부심사위원</option>
				</select>
				&nbsp;검색인원&nbsp;<input type="text" id="pageSize" value="100" class="text" />&nbsp;명
				<a href="javascript:searchUser()" class=""><img src="/cms/image/srch_btn_go.jpg" alt="검색" /></a>
				</div>
				
				<div class="search">
				<select id="firstGroup" name=firstGroup style="height:24px;">
					<option value="">대분류</option>
					<option value="user">회원</option>
					<option value="paper">논문관리</option>
					<option value="conference">학술대회관리</option>
					<option value="event">행사관리</option>
				</select>
				<select id="secondGroup" name="secondGroup" style="height:24px;">
					<option value="">중분류</option>
					<!-- <option value="userid">ID</option>
					<option value="userno">유저번호</option>
					<option value="useremail">이메일</option> -->
				</select>
				<select id="thirdGroup" name="thirdGroup" style="height:24px;">
					<option value="">소분류</option>
					<!-- <option value="userid">ID</option>
					<option value="userno">유저번호</option>
					<option value="useremail">이메일</option> -->
				</select>
				</div>
				
				<table class="main_table1" border="0" cellspacing="1" cellpadding="2" width="90%" summary="유저설정">
					<caption>게시판 리스트</caption>
					<tbody>
					<tr>
						<td>
							<select name="user_source" id="searchUserOption" multiple size="20" style="width:550px">
								
								
								<%-- <c:forEach items="${dt.boardGroupInfo.zBoardGroupMemberVo}" var="data" varStatus="status">
									<option value="${data.boardno}">${data.boardtitle}</option>
								</c:forEach> --%>
							</select>
						</td>
						<td>
							<a href="javascript:void(0);" onclick="select_user('user_source')"><img src="/cms/image/css_add.jpg" alt="추가"></a><br>
							<a href="javascript:void(0);" onclick="deselect_user('user_dest')"><img src="/cms/image/css_del.jpg" alt="삭제"></a>
						</td>
						<td>
							<select name="user_dest" multiple size="20" style="width:550px">
							<%-- <c:forEach items="${dt.boardGroupInfo.zBoardGroupMemberVo}" var="data" varStatus="status">
								<c:if test="${data.groupno==param.groupno}">
									<option value="${data.boardno}">${data.boardtitle}</option>
								</c:if>
							</c:forEach> --%>
							</select>
						</td>
					</tr>
					</tbody>
				</table>
				<p style="padding-top:5px;">* 중복된 회원은 저장 시 자동으로 제거한 후 하나의 목록만 남깁니다.</p>
				<h4 class="stit">메일내용 정보</h4>
				<table class="input_table etc-board mgtype20" border="0" cellspacing="0" cellpadding="0" width="90%" summary="자유결제 상품 등록">
					<caption>메일내용 생성</caption>
					<colgroup>
						<col width="15%" />
						<col width="" />
						
					</colgroup>
					<tr>
						<th scope="row">제목</th>
						<td>
							<input type="text" id="title" value="" name="title" class="text" maxlength="100" style="width:400px;height:19px;" />
						</td>
					</tr>
					<tr id="123">
						<th scope="row">내용</th>
						<td>
							<div id="txtarea" style="display:none">
								<textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="30"></textarea>
							</div>
							<div id="editorarea" style="width:96%;">
								<script type="text/javascript">
										$(document).ready(function(){
											CKEDITOR.replace("ckeditorConts" ,{
												skin : 'office2013',
												//width : '620px',			// 입력창의 넓이, 넓이는 config.js 에서 % 로 제어
												height : '500px',				// 입력창의 높이
					
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
										});
										</script>
										<textarea class="bor1ddd" name="ckeditorConts" id="ckeditorConts" style="width:95%" rows="30"></textarea>
							</div>							
							<!-- <textarea rows="10" cols="80" id="conts" value="" name="conts" class="text" ></textarea> -->
						</td>
					</tr>
					<tr>
						<th scope="row">발송일시</th>
						<td>
							<!-- <input type="radio" value="0" name="isendless" id="isendless1" checked>임시저장 &nbsp;&nbsp;&nbsp;
							<input type="radio" value="1" name="isendless" id="isendless2">발송시간 설정<br /><br /> -->
							<span class="pd-first">발송일시</span>
							<input readonly type="text" id="reservedate" value="" name="reservedate" maxlength="10" class="date-pick number text" style="height:19px;" /><span class="pd"></span>
							<select name="reservetime" id="reservetime">
								<option value="--">--</option>
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
								<option value="04">04</option>
								<option value="05">05</option>
								<option value="06">06</option>
								<option value="07">07</option>
								<option value="08">08</option>
								<option value="09">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
							</select>
							시
						</td>
					</tr>
					<tr>
						<th scope="row">비고</th>
						<td>
							<textarea rows="3" cols="80" id="ref" value="" name="ref" class="text" ></textarea>
						</td>
					</tr>
					<tr>
						<th scope="row">사용유무</th>
						<td>
							<input type="radio" value="1" name="status" checked>사용 &nbsp;&nbsp;&nbsp;
							<input type="radio" value="0" name="status" >미사용
						</td>
					</tr>
				</table>
				
				<div class="btn-c05">
					<a href="javascript:insert_submit();" class="gray">등록</a>
					<a href="./index.html" class="gray">취소</a>
				</div>
				<!--
				<br />
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td>
							<div class="confirm">
								<p>
									<a href="javascript:insert_submit();"><img src="/cms/image/upload.jpg" alt="등록" /></a>
									<a href="./index.html"><img src="/cms/image/btn_cancel.jpg" alt="취소" /></a>
								</p>
							</div>
							
						</td>
					</tr>
				</table>
				-->
			</div>


			<!--/content-->
		</form>
	</div>
	<!--/r_side-->
</div>
<!--/container-->
</div>
<!--/wrap-->
<c:import url="../../../admsys/footer.jsp" />
</body>
</html>