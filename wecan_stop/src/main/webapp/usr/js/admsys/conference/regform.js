$(function(){
	
	$('.datetimepicker').datetimepicker({
			lang:'ko',
			format:'YmdHi'
	});
	
	
	/*$('#coneventstartdate').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 > $('#coneventenddate').val().replace(/-/gi,"")*1&&  $('#coneventenddate').val() != ""){
				alert('시작일보다  종료일보다 이전이어야합니다.')
				$(this).val('');
				return false;
			}
		 }
	});
	$('#coneventenddate').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 < $('#coneventstartdate').val().replace(/-/gi,"")*1){
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				$(this).val('');
				return false;
			}
		 }
	});
	$('#conprestartdate').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 > $('#conprestartend').val().replace(/-/gi,"")*1 &&  $('#conprestartend').val() != ""){
				alert('시작일보다  종료일보다 이전이어야합니다.')
				$(this).val('');
				return false;
			}
		 }
	});
	$('#conprestartend').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 < $('#conprestartdate').val().replace(/-/gi,"")*1){
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				$(this).val('');
				return false;
			}
		 }
	});
	$('#constartdate').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 > $('#conenddate').val().replace(/-/gi,"")*1 &&  $('#conenddate').val() != ""){
				alert('시작일보다  종료일보다 이전이어야합니다.')
				$(this).val('');
				return false;
			}
		 }
	});
	$('#conenddate').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 < $('#constartdate').val().replace(/-/gi,"")*1){
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				$(this).val('');
				return false;
			}
		 }
	});
	$('#confinalstartdate').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 > $('#confinalenddate').val().replace(/-/gi,"")*1 &&  $('#confinalenddate').val() != ""){
				alert('시작일보다  종료일보다 이전이어야합니다.')
				$(this).val('');
				return false;
			}
		 }
	});
	$('#confinalenddate').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function (dateText, inst) {
			if(dateText.replace(/-/gi,"")*1 < $('#confinalstartdate').val().replace(/-/gi,"")*1){
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				$(this).val('');
				return false;
			}
		 }
	});
	$('.date-pick').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});
	$('.datetime-pick').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	});*/
	
	//숫자만 입력
	 $(".number").bind("keyup", function () {
       $(this).val($(this).val().replace(/[^0-9]/gi, ""));
     });
	
	insert_submit = function(f) {
		var form = $(f);
		
		var contitle = $('#contitle').val().trim();
		if (typeof(contitle) == 'undefined' || contitle == '') {
			$('#contitle').focus();
			alert('학술대회명을 입력하십시오.');
			return false;
		}
		var filetype = $('#filetype').val().trim();
		if (typeof(filetype) == 'undefined' || filetype == '') {
			$('#filetype').focus();
			alert('업로드확장자를 입력하십시오.');
			return false;
		}
		
		if($('#contype:checked').val() == "I"){

		}else{
			/*var conedefaultfee = $('#conedefaultfee').val().trim();
			if (typeof(conedefaultfee) == 'undefined' || conedefaultfee == '') {
				$('#conedefaultfee').focus();
				alert('비회원  참가비를 입력하십시오.')
				return false;
			}
			var conenomemberfee = $('#conenomemberfee').val().trim();
			if (typeof(conenomemberfee) == 'undefined' || conenomemberfee == '') {
				$('#conenomemberfee').focus();
				alert('준회원 참가비를 입력하십시오.')
				return false;
			}
			
			var conenmemberfee = $('#conenmemberfee').val().trim();
			if (typeof(conenmemberfee) == 'undefined' || conenmemberfee == '') {
				$('#conenmemberfee').focus();
				alert('정회원 참가비를 입력하십시오.')
				return false;
			}*/
		}

		var coneventstartdate = $('#coneventstartdate').val().trim();
		if (typeof(coneventstartdate) == 'undefined' || coneventstartdate == '') {
			$('#coneventstartdate').focus();
			alert('학술대회 일시를 입력하십시오.');
			return false;
		}
		if( $('#panner_userno_text').length  > 0){
			$('#panner_userno').val( $('#panner_userno_text').text());

		}
		//날짜 입력 확인
		var coneventenddate = $('#coneventenddate').val().trim();
		if (typeof(coneventenddate) != 'undefined' && coneventenddate != '') {
			if(coneventenddate.replace(/-/gi,"")*1 < coneventstartdate.replace(/-/gi,"")*1){
				$('#coneventenddate').focus();
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				return false;
			}
		}
		//날짜 입력 확인
		var constartdate = $('#constartdate').val().trim();		
		if (typeof(constartdate) != 'undefined' && constartdate != '') {
			var conenddate = $('#conenddate').val().trim();
			if(conenddate.replace(/-/gi,"")*1 < constartdate.replace(/-/gi,"")*1){
				$('#conenddate').focus();
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				return false;
			}
		}
		//날짜 입력 확인
		var conprestartdate = $('#conprestartdate').val().trim();		
		if (typeof(conprestartdate) != 'undefined' && conprestartdate != '') {
			var conprestartend = $('#conprestartend').val().trim();
			if(conprestartend.replace(/-/gi,"")*1 < conprestartdate.replace(/-/gi,"")*1){
				$('#conprestartend').focus();
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				return false;
			}
		}
		return true;
		
		//날짜 입력 확인
		var confinalstartdate = $('#confinalstartdate').val().trim();		
		if (typeof(confinalstartdate) != 'undefined' && confinalstartdate != '') {
			var confinalenddate = $('#confinalenddate').val().trim();
			if(confinalenddate.replace(/-/gi,"")*1 < confinalstartdate.replace(/-/gi,"")*1){
				$('#confinalenddate').focus();
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				return false;
			}
		}
		return true;
		
	};
	if( $('#panner_userno_text').length  > 0){
		var pannel_info = $('#panner_userno_text').text();
		//userno = {username,useremail} - json 형태
		var obj = new Array();
		if(pannel_info != ""){						
			obj = JSON.parse(pannel_info);
		}		
		display_user_info(obj);

	}
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
//패널 좌좡 토론 data set
function display_user_info(obj){
	var out = '';
	//등록된 사람인지 유저번호로 검색
	for (var i=0 ; i < obj.length ; i++)
	{
		var temp = '<a href="#" onclick="return remove_user('+obj[i]['userno']+')">'+obj[i]['username'] +'[삭제]</a>';
		out += temp +", ";
	    
	}	
	$('#panner_userno_text').text(JSON.stringify(obj));	
	$('#select_user_name').html(out);
}

function checkCancel(){
	if(confirm("등록을 취소하시겠습니까?")){
		return true;
	}else{
		return false;
	}
}

function chagePaper(){
	
	/*if($("#paperFile").val() == ""){
		alert("수정/등록할 파일을 선택해 주세요.");
	}else{
		if(confirm("파일을 수정/등록 하시겠습니까?")){
			var frm = document.chagneFileFrm;
			frm.action = "chageEntryFile.html";
			frm.submit(); 
		}
	}*/
	
	if(confirm("파일을 수정/등록 하시겠습니까?")){
		var frm = document.chagneFileFrm;
		frm.action = "chageEntryFile.html";
		frm.submit(); 
	}
	
	
}

function change_paper(cptno, type, count){
	
	if(type == 0){
		if($('#file1_'+count).val() == ''){
			alert("수정할 파일을 선택하십시오");
			$('#file1_'+count).focus();
			return;
		}
		
		$("#count").val("file1_"+count);
		
	}else if(type == 1){
		if($('#file2_'+count).val() == ''){
			alert("수정할 파일을 선택하십시오");
			$('#file2_'+count).focus();
			return;
		}
		
		$("#count").val("file2_"+count);
		
	}else if(type == 2){
		if($('#file3_'+count).val() == ''){
			alert("수정할 파일을 선택하십시오");
			$('#file3_'+count).focus();
			return;
		}
		
		$("#count").val("file3_"+count);
		
	}
	
	if(confirm("수정하시겠습니까?")){
		
		$("#cptno").val(cptno);
		
		
		var frm = document.chagePaperFrm;
		frm.action = "./change_paper.html";
		frm.submit();
	}
	
	
}

function delete_paper(cptno, type,  len){
	
	if(type == 0){
		if(len > 1){
			alert("초록을 삭제하시려면 최종본이나 요약본을 모두 삭제하셔야 합니다.");
			return;
		}
	}
	
	
	if(confirm("삭제하시겠습니까?")){
		
		$("#cptno").val(cptno);
		var frm = document.chagePaperFrm;
		frm.action = "./delete_paper.html";
		frm.submit();
	}
	
	
}
