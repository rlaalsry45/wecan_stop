$(function(){
	$('#enddate').datepicker({
		dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,changeMonth: true // True if month can be selected directly, false if only prev/next
		,changeYear: true // True if year can be selected directly, false if only prev/next
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,yearRange: "c-60:c+1",
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 < $('#startdate').val().replace(/-/gi,"")*1){
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				$(this).val('');
				return false;
			}
		 }
	});
	$('#startdate').datepicker({
		dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,changeMonth: true // True if month can be selected directly, false if only prev/next
		,changeYear: true // True if year can be selected directly, false if only prev/next
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,yearRange: "c-60:c+1",
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 > $('#enddate').val().replace(/-/gi,"")*1&&  $('#enddate').val() != ""){
				alert('시작일보다  종료일보다 이전이어야합니다.')
				$(this).val('');
				return false;
			}
		}
	});
	$('.date-pick').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,changeMonth: true // True if month can be selected directly, false if only prev/next
		,changeYear: true // True if year can be selected directly, false if only prev/next
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,yearRange: "c-60:c+1"
	});
	
	//숫자만 입력
	 $(".number").bind("keyup", function () {
       $(this).val($(this).val().replace(/[^0-9]/gi, ""));
     });
	//이메일 입력
	 $(".email").bind("keyup", function () {
		 var res = $(this).val().split("@"); 
        if(res.length > 1 ){
        	
        	alert('@domain.com을 제외한 아이디만 입력해주세요')
        	$(this).val(res[0]);
        	$(this).focus();
        }
     });
	 insert_submit = function(f) {
		var form = $(f);
		
		
		if ($("#userid",form).val().replace(/^\s+|\s+$/g,"")==""){
			alert("아이디를 입력 해주세요.");
			$("#userid",form).focus();
			$("#userid",form).select();
			return false;
		}
		else{
			if (form.data("dupchk")=="false"){
				alert("중복된 아이디가 존재 합니다.");
				$("#userid",form).focus();
				$("#userid",form).select();
				return false;
			}
		}
		
		if ($("#userpasswd",form).val().replace(/^\s+|\s+$/g,"")==""){
			alert("비밀번호를 입력 해주세요.");
			$("#userpasswd",form).focus();
			$("#userpasswd",form).select();
			return false;
		}
		else {
			if ($("#userpasswd",form).val().length<6){
				alert("비밀번호를 6자리 이상으로 입력 해주세요.");
				$("#userid",form).focus();
				$("#userid",form).select();
				return false;
			}else{
				 var chk_num = $("#userpasswd",form).val().search(/[0-9]/g); 
			     var chk_eng = $("#userpasswd",form).val().search(/[a-z]/ig);
			     if(chk_num < 0 || chk_eng < 0){ 
			    	 $("#userid",form).focus();
					 $("#userid",form).select();
			    	 alert("영문+숫자를 입력하셔야 합니다.");
			    	 return false;
			     }
			}
		}
		
		if ($("#userpasswdchk",form).val().replace(/^\s+|\s+$/g,"")==""){
			alert("비밀번호 확인을 입력 하세요.");
			$("#userpasswdchk",form).focus();
			$("#userpasswdchk",form).select();
			return false;
		}
		else{
			if ($("#userpasswd",form).val()!=$("#userpasswdchk",form).val()){
				alert("비밀번호가 다릅니다.");
				$("#userpasswdchk",form).focus();
				$("#userpasswdchk",form).select();
				return false;
			}
		}
		
		var subject =  $('#subject').val().trim();
		if (typeof(subject) == 'undefined' || subject == '') {
			$('#subject').focus();
			alert('과업명을하십시오.');
			return false;
		}
		
		var subject =  $('#senior_name').val().trim();
		if (typeof(subject) == 'undefined' || subject == '') {
			$('#senior_name').focus();
			alert('책임연구원을 선택하십시오.');
			return false;
		}
		var subject =  $('#senior_position').val().trim();
		if (typeof(subject) == 'undefined' || subject == '') {
			$('#senior_position').focus();
			alert('책임연구원을 선택하십시오.');
			return false;
		}
		
		/*var subject =  $('#subject').val().trim();
		if (typeof(subject) == 'undefined' || subject == '') {
			$('#subject').focus();
			alert('과업명을하십시오.');
			return false;
		}
		var startdate =  $('#startdate').val().trim();
		if (typeof(startdate) == 'undefined' || startdate == '') {
			$('#startdate').focus();
			alert('기간을 입력하십시오.');
			return false;
		}
		var enddate =  $('#enddate').val().trim();
		if (typeof(enddate) == 'undefined' || enddate == '') {
			$('#enddate').focus();
			alert('기간을 입력하십시오.');
			return false;
		}
		var ordered =  $('#ordered').val().trim();
		if (typeof(ordered) == 'undefined' || ordered == '') {
			$('#ordered').focus();
			alert('발주처를 입력하십시오.');
			return false;
		}
		var department =  $('#department').val().trim();
		if (typeof(department) == 'undefined' || department == '') {
			$('#department').focus();
			alert('담당부서를 입력하십시오.');
			return false;
		}
		
		var username =  $('#username').val().trim();
		if (typeof(username) == 'undefined' || username == '') {
			$('#username').focus();
			alert('담당자 이름을  입력하십시오.');
			return false;
		}
		var email1 =  $('#email1').val().trim();
		if (typeof(email1) == 'undefined' || email1== '') {
			$('#email1').focus();
			alert('담당자 이메일을 입력하십시오.');
			return false;
		}
		var email2 =  $('#email2').val().trim();
		if (typeof(email2) == 'undefined' || email2== '') {
			$('#email2').focus();
			alert('담당자 이메일을 입력하십시오.');
			return false;
		}
		var publications_title =  $('#publications_title').val().trim();
		if (typeof(publications_title) == 'undefined' || publications_title == '') {
			$('#publications_title').focus();
			alert('간행물 제목을하십시오.');
			return false;
		}*/
		
		return true;  
		
	};
	insert_history_submit = function(f) {
		var form = $(f);
		
		var title =  $('#title').val().trim();
		if (typeof(title) == 'undefined' || title == '') {
			$('#title').focus();
			alert('제목을하십시오.');
			return false;
		}
		return true;
		 
	};	
	
});

//컨퍼런스에서 패널 선택 팝업
function usersearch(){
	$('#user_insert').hide();
	
	var url = "/front/user/popupUserList.html";
	var windowName = "search_post";
	var windowWidth = 468;
	var windowHeight = 360;
	var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
	var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
	var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
	window.open(url, windowName, windowSize);
	return false;
}
//팝업에서 유저 선택시
function select_user(userno, userid, username,dept_nm,userphone,useremail){
	$('#userno').val(userno);
	$('#username').val(username);
	$('#useremail').val(useremail);
	$('#user_select_name').html(username);
}
function insert_user(){
	
	var insert_username =  $('#insert_username').val().trim();
	if (typeof(insert_username) == 'undefined' || insert_username == '') {
		$('#insert_username').focus();
		alert('이름을  입력하십시오.');
		return false;
	}
	var insert_email =  $('#insert_email').val().trim();
	if (typeof(insert_email) == 'undefined' || insert_email== '') {
		$('#insert_email').focus();
		alert('이메일을 입력하십시오.');
		return false;
	}
	$.ajax({
		type: "POST",
		url:"/admsys/project/insert_user.html",
		data: {userid:$('#insert_userid').val(),userpassword:$('#insert_pwd').val(),useremail:$('#insert_email').val(),username:$('#insert_username').val()},
		success: function(response){
			select_user(response.userno,response.userid,response.username,null,response.userphone,response.useremail);
			$('#user_insert').hide();
        }
	});
	return false;
}
function user_insert(){
	$('#user_insert').toggle();
	return false;
}

//첨부파일 확장자 체크
function check_thumb(e){
	
	var temp = $(e).val();
	var ext = temp.substring(temp.lastIndexOf(".") + 1).toLowerCase();
	var exts = ['png','jpg','jpeg','gif'];
	if (exts.indexOf(ext) < 0) {
		$(e).val('');
		alert('이미지파일(png,jpg,jpeg,gif)만 첨부가 가능합니다');
		return false;
	}
	
}
function check_pdf(e){
	
	var temp = $(e).val();
	var ext = temp.substring(temp.lastIndexOf(".") + 1).toLowerCase();
	var exts =  ['pdf'];
	if (exts.indexOf(ext) < 0) {
		$(e).val('');
		alert('pdf 파일만 첨부가 가능합니다');
		return false;
	}
	if(e.files[0].size/1024/1024 > 50){// 단위는 M
		$(e).val('');
		alert('파일 용량이 50M이하의 파일만 첨부가 가능합니다');
		return false;
		
	} 
	
}

//첨부파일 확장자 체크
function check_ext(e){
	
	var temp = $(e).val();
	var ext = temp.substring(temp.lastIndexOf(".") + 1).toLowerCase();
	var exts =  ['doc', 'docs', 'docx', 'txt', 'xlsx', 'xls', 'pdf', 'ppt', 'pptx', 'hwp'];
	if (exts.indexOf(ext) < 0) {
		$(e).val('');
		alert('문서 파일만 첨부가 가능합니다');
		return false;
	}
	
}

function changeEmail(obj){
	$('#email2').val($(obj).val().trim());
	if($(obj).val().trim() == "") $('#email2').show();
	else $('#email2').hide();
	return false;
}

var selectType = null;
var selectNo = null;

function userSelect(type, no){
	selectType = type;
	selectNo = no
	url = "/front/user/popupUserList.html";
	window.open(url, "userSelect", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=762, height=395"); 
}
function select_user(userno, userid, username,dept_nm,userphone,useremail){
	if(selectType == "1"){
		$("#senior").val(userno);
		$("#senior_name").val(username);
		$("#senior_position").val(dept_nm);
	}else if(selectType == "2"){
		
		$("#write_"+selectNo).attr("checked", false);
		write_pa(selectNo);
		
		$("#userno_"+selectNo).val(userno);
		$("#name_"+selectNo).val(username);
		$("#company_"+selectNo).val(dept_nm);
	}
}
