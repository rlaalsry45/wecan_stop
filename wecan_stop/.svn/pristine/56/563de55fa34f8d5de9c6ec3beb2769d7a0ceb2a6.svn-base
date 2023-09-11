$(document).ready(function(){
	
	$('#keyword2').datepicker({
		 dateFormat : "yy-mm-dd"
		,showMonthAfterYear : true
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function (dateText, inst) {
		 }
	});
	
	if($('#cond2').val() == "userdatereg"){
		$('#keyword').attr("disabled",true);
		$('#keyword').hide();
		
		$('#keyword2').attr("disabled",false);
		$('#keyword2').show();
	}
	
	$('#cond2').change(function(){
		if($(this).val() == "userdatereg"){
			
			$('#keyword').attr("disabled",true);
			$('#keyword').hide();
			
			$('#keyword2').attr("disabled",false);
			$('#keyword2').show();
			
		}else{
			$('#keyword').attr("disabled",false);
			$('#keyword').show();
			
			$('#keyword2').attr("disabled",true);
			$('#keyword2').hide();
		}
	});
});

function userCommit(userid){
	if(confirm("해당 유저를 강제로 인증하시겠습니까?")){
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/admsys/user/common/usercommit.html' 
			, data: "userid="+userid
			, success: function(data) {
				alert("인증되었습니다.");
				window.location.reload();
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	}
}

function userCommitForStudent(userid,userno,username,useremail,re){
	//alert("userid="+userid+"&userno="+userno+"&username="+username+"&useremail="+useremail);
	if(re =="re") msg = "해당 유저의  준회원기간을 1년더 연장하시겠습니까?";
	else          msg = "해당 유저를 준회원으로 인증하시겠습니까?";
	if(confirm(msg)){
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/admsys/user/common/userCommitForStudent.html' 
			, data: "userid="+userid+"&userno="+userno+"&username="+username+"&useremail="+useremail
			, success: function(data) {
				alert("인증되었습니다.");
				window.location.reload();
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	}
}


function payedlist(userid,userno){
	var url = "/admin/dues/payedlist/index.html?userno="+userno+"&userid="+userid;
	var windowName = "payedlist";
	var windowWidth = 1000;
	var windowHeight = 600;
	var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
	var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
	var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
	window.open(url, windowName, windowSize);
}

function work_grade_change(userid,userno){
	var url = "/admsys/dues/work_grade_change.html?userno="+userno+"&userid="+userid;
	var windowName = "payedlist";
	var windowWidth = 1000;
	var windowHeight = 600;
	var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
	var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
	var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
	window.open(url, windowName, windowSize);
}

function userPassInit(userno){
	if(confirm("해당 유저의 비밀번호가 1234로 강제로 초기화 됩니다.\n실행하시겠습니까?")){
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/admsys/user/common/userPassInit.html' 
			, data: "userno="+userno
			, success: function(data) {
				alert("해당유저의 비밀번호가 초기화 되었습니다. .");
				window.location.reload();
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	}
}
/* function annualPauseStop(userno,duesno){
	if(confirm("회원중지상태를 활성화 상태로 변경하시겠습니까?")){
		$.ajax({ 
			type: 'post' 
			, async: true 
			, url: '/admsys/dues/annualPauseStop/index.html' 
			, data: "userno="+userno+"&duesno="+duesno
			, success: function(data) {
				if(data == '1'){
					alert("해당유저의 회원상태가 활성화 되었습니다.");
				}else{
					alert("관리자 권한이 아니거나 오류가 있습니다. 관리자에게 문의하세요");
				}
				window.location.reload();
			} 
			, error: function(data, status, err) { 
				alert('서버와의 통신이 실패했습니다.'); 
			}
		});
	}
} */

function sort(type, sort){
	
	$("#sortName").val(type); //정렬 타입
	$("#sort").val(sort); //정렬
	var form = document.frm;
	form.submit();
	
}

function sendAllMail(type){

	if(confirm("검색된 회원전체에게 메일을 발송하시겠습니까?")) {
		
		if(type == "1"){
			$("#act").val("org_all");
		}else if(type == "2"){
			$("#act").val("donation_all");	
		}
		window.open("", "sendAllMail", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=920, height=700"); 
		document.frm.action = "/admsys/mail/popupSendMail.html";
		document.frm.target = "sendAllMail";
		document.frm.submit();
		document.frm.target = "";
	}
	
	
}

function sendChkMail(type)
{
	
	if( $(":checkbox[name='userno']:checked").length==0 ){
		alert("메일 보낼 회원을 체크해주세요. ");
	}else{
		
		if(confirm("체크된 회원에게 메일을 발송하시겠습니까?")) {
			
			var userno = "";
			
			$("input:checkbox[name='userno']").each(function(){
				if($(this).is(":checked") == true){
					if($(this).val() != "undefined"){
						if(userno != "")
							userno += ","+$(this).val();
						else
							userno = $(this).val();
					}
				}
			});
			
			$("#chk_userno").val(userno);
			
			if(type == "1"){
				$("#act").val("org_chk");
			}else if(type == "2"){
				$("#act").val("donation_chk");	
			}
			
			window.open("", "updateExam", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=920, height=700"); 
			document.frm.action = "/admsys/mail/popupSendMail.html";
			document.frm.target = "updateExam";
			document.frm.submit();
			document.frm.target = "";
			
		}
	}
	
}


function excelAll(type){
	
	if(confirm("검색된 회원전체의 엑셀을 다운로드하시겠습니까?")) {
		
		if(type == "1"){
			$("#act").val("org_excel_all");
		}else if(type == "2"){
			$("#act").val("donation_excell_all");	
		}
		
		window.open("", "excelAll", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=10, height=10"); 
		document.frm.action = "/admsys/user/common/popupExcel.html";
		document.frm.target = "excelAll";
		document.frm.submit();
		document.frm.target = "";
	}
	
}

function excelChk(type)
{
	if( $(":checkbox[name='userno']:checked").length==0 ){
		alert("다운받을 엑셀의 회원을 체크해주세요. ");
	}else{
		
		if(confirm("체크된 회원의 엑셀을 다운로드하시겠습니까?")) {
			
			var userno = "";
			
			$("input:checkbox[name='userno']").each(function(){
				if($(this).is(":checked") == true){
					if($(this).val() != "undefined"){
						if(userno != "")
							userno += ","+$(this).val();
						else
							userno = $(this).val();
					}
				}
			});
			
			$("#chk_userno").val(userno);
			
			if(type == "1"){
				$("#act").val("org_excel_chk");
			}else if(type == "2"){
				$("#act").val("donation_excell_chk");	
			}
			
			window.open("", "excelAll", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=10, height=10"); 
			document.frm.action = "/admsys/user/common/popupExcel.html";
			document.frm.target = "excelAll";
			document.frm.submit();
			document.frm.target = "";
		}
	}
}
