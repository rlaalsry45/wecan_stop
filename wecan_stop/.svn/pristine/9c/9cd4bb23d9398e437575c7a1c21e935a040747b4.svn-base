$(function(){
	
	 insert_submit = function(f) {
		var form = $(f);
		
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
			alert('담당자를 입력하십시오.');
			return false;
		}
		
		var filecnt = $('input[type="text"][id^="name_"]').length;
		
		for (var int = 1; int <= filecnt; int++) {
			
			var username =  $('#name_'+int).val().trim();
			var company =  $('#company_'+int).val().trim();
			if (typeof(username) == 'undefined' || username == '') {
				$('#name_'+int).focus();
				alert('과업참여자 성명을 입력하십시오.');
				return false;
			}
			if (typeof(company) == 'undefined' || company == '') {
				$('#company_'+int).focus();
				alert('과업참여자 소속을 입력하십시오.');
				return false;
			}
			
		}
		
		var publications_title =  $('#publications_title').val().trim();
		if (typeof(publications_title) == 'undefined' || publications_title == '') {
			$('#publications_title').focus();
			alert('간행물 제목을 입력하십시오.');
			return false;
		}
		
		if (!$("input:radio[id=publications_cycle]").is(":checked")) {
			$('#publications_cycle').focus();
			alert('발간주기를 선택하십시오.');
			return false;
		}
		
		var publications_purpose =  $('#publications_purpose').val().trim();
		if (typeof(publications_purpose) == 'undefined' || publications_purpose == '') {
			$('#publications_purpose').focus();
			alert('발간용도를 입력하십시오.');
			return false;
		}
		
		var publications_media =  $('#publications_media').val().trim();
		if (typeof(publications_media) == 'undefined' || publications_media == '') {
			$('#publications_media').focus();
			alert('발간매체를 입력하십시오.');
			return false;
		}
		
		var form =  $('#form').val().trim();
		if (typeof(form) == 'undefined' || form == '') {
			$('#form').focus();
			alert('형태(사이즈)를 입력하십시오.');
			return false;
		}
		
		var project_keyword =  $('#project_keyword').val().trim();
		if (typeof(project_keyword) == 'undefined' || project_keyword == '') {
			$('#project_keyword').focus();
			alert('키워드를 입력하십시오.');
			return false;
		}
		
		var main_content =  $('#main_content').val().trim();
		if (typeof(main_content) == 'undefined' || main_content == '') {
			$('#main_content').focus();
			alert('주요내용을 입력하십시오.');
			return false;
		}
		
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

function write_pa(no){
	
	if($("#write_"+no).is(":checked")){
		$("#name_"+no).attr("readonly", false);
		$("#company_"+no).attr("readonly", false);
		
		$("#userno_"+no).val('');
		$("#name_"+no).val('');
		$("#company_"+no).val('');
		
		$("#name_"+no).focus();
		
	}else{
		
		$("#name_"+no).attr("readonly", true);
		$("#company_"+no).attr("readonly", true);
		$("#userno_"+no).val('');
		$("#name_"+no).val('');
		$("#company_"+no).val('');
	}
	
}

//첨부파일 공개,비공개
function changeReason(seq){
	
	var isopen = $("#isopen_"+seq+":checked").val();
	if(isopen == 'Y'){
		$("#reason_"+seq).attr("disabled", true);
		$("#reason_"+seq).val('');
	}else{
		$("#reason_"+seq).attr("disabled", false);
		$("#reason_"+seq).focus();
	}
}

//첨부파일 공개,비공개
function changeOpen(seq){
	
	var isopen = $("#isopen_"+seq+":checked").val();
	var reason = $("#reason_"+seq).val();
	
	if(isopen == 'N'){
		if($.trim(reason) == ''){
			alert("비공개 사유를 입력하십시오.");
			$("#reason_"+seq).focus();
			return;
		}
	}
	
	$.ajax({
		type: "POST",
		url:"./changeOpen.html",
		data: "seq="+seq+"&isopen="+isopen+"&reason="+reason,
		success: function(data) { 
			if (data=="true"){
				if(isopen == 'Y'){
					alert("공개로 변경하였습니다.");
				}else{
					alert("비공개로 변경하였습니다.");
				}
			}
			location.href="/project/detail.html";
		} ,
		error: function(data, status, err) { 
			alert('서버와의 통신이 실패했습니다.'); 
		}
	});
	
}

//첨부파일 확장자 체크
function check_ext(id){
	
	var temp = $("#"+id).val();
	var ext = temp.substring(temp.lastIndexOf(".") + 1).toLowerCase();
	var exts =  ['doc', 'docs', 'docx', 'txt', 'xlsx', 'xls', 'pdf', 'ppt', 'pptx', 'hwp'];
	if (exts.indexOf(ext) < 0) {
		$("#"+id).val('');
		alert('문서 파일만 첨부가 가능합니다');
		return false;
	}
	
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
