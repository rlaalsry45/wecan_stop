function delPaticipant(obj) {
	if(confirm("정말 삭제하시겠습니까?")) {
		if (checkForm(obj)){
			document.frm.action ="entry_delete.html";
			if (obj=="urlno"){
				var urlnos = $(":checkbox[name=urlno]:checked").map(function(){return $(this).val();}).get();
				var opens = $("[src$='btn_opened.jpg']").map(function(){return $(this).attr('id');}).get();
				document.frm.action += "&urlnos="+urlnos+"&opens="+opens;
			}
			else if (obj=="cno"){
				document.frm.action += "&"+window.location.search.replace("?","");
			}
			document.frm.submit();
		}
	}
}

function sendAllMail(){

	if(confirm("검색된 회원전체에게 메일을 발송하시겠습니까?")) {
		
		$("#act").val("event_all");
		
		window.open("", "sendAllMail", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=920, height=700"); 
		document.frm.action = "/admsys/mail/popupSendMail.html";
		document.frm.target = "sendAllMail";
		document.frm.submit();
		document.frm.target = "";
	}
	
	
}

function sendChkMail()
{
	
	if( $(":checkbox[name='enIdx']:checked").length==0 ){
		alert("메일 보낼 회원을 체크해주세요. ");
	}else{
		
		if(confirm("체크된 회원에게 메일을 발송하시겠습니까?")) {
			
			var userno = "";
			
			$("input:checkbox[name='enIdx']").each(function(){
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
			$("#act").val("event_chk");
			
			window.open("", "updateExam", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=920, height=700"); 
			document.frm.action = "/admsys/mail/popupSendMail.html";
			document.frm.target = "updateExam";
			document.frm.submit();
			document.frm.target = "";
			
		}
	}
	
}


function excelAll(){
	
	if(confirm("검색된 회원전체의 엑셀을 다운로드하시겠습니까?")) {
		
		$("#act").val("event_excel_all");
		
		window.open("", "excelAll", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=10, height=10"); 
		document.frm.action = "/admsys/user/common/popupExcel.html";
		document.frm.target = "excelAll";
		document.frm.submit();
		document.frm.target = "";
	}
	
}

function excelChk(obj)
{
	if( $(":checkbox[name='enIdx']:checked").length==0 ){
		alert("다운받을 엑셀의 회원을 체크해주세요. ");
	}else{
		
		if(confirm("체크된 회원의 엑셀을 다운로드하시겠습니까?")) {
			
			var userno = "";
			
			$("input:checkbox[name='enIdx']").each(function(){
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
			$("#act").val("event_excel_chk");
			
			window.open("", "excelAll", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=10, height=10"); 
			document.frm.action = "/admsys/user/common/popupExcel.html";
			document.frm.target = "excelAll";
			document.frm.submit();
			document.frm.target = "";
		}
	}
}