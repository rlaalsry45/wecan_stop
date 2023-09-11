function check_payment(e){
	// console.log(e);
	
	var eventFee = $("#eventFee").val();
	var feeTitle = $("#feeTitle").val(); 
	
	if(eventFee == "0"){
		alert("참가비가 없습니다. 결제하실 필요가 없습니다.");
		return false;
	}else{
		$("#oAmt").val(eventFee);
		$("#oProductNM").val(feeTitle+" 참가비");
		$("#enPaymentSum").val(eventFee);
	}
	$.ajax({
		type: "POST",
		url: e.action,
		data: $(e).serialize(),
		success: function(response){
			if(response == 'false'){
				alert('신청 정보가 올바르지 않습니다.');
			}else{
				// console.log(response);
				popup_payment(response);
			}
            	
        }
	});
	return false;
}
//결제창 호출
function popup_payment(order){
    if(typeof initial === "undefined"){
          initial ='';
    }
    $('#enOrderNo').val(order);
	var url = "/Allat/approval.html?sOrderNo="+order;
	var windowName = "search_post";
	var windowWidth = 468;
	var windowHeight = 450;
	var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
	var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
	var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
	window.open(url, windowName, windowSize);
	return false;
}
//결제 완료 후 호출
function orderResult(ret,no,type){
	var evTitle = $('#evTitle').text();
	var frm = $('#payinfoUpdate');
	if(ret=="Y"){
		alert(evTitle + ' 참가비 결제가 완료되었습니다.\r\n감사합니다.');
		$('#enUserOrderNo').val(no);
		$("#enPaymentMethod").val(type);
		frm.submit();
	} else {
		alert('결제를 완료하지 못하였습니다.\r\n담당자에게 문의해주세요.');
	}
}
function chagePaper(){
	
	if($("#paperFile").val() == ""){
		alert("수정/등록할 파일을 선택해 주세요.");
	}else{
		if(confirm("파일을 수정/등록 하시겠습니까?")){
			var frm = document.chagneFileFrm;
			frm.action = "chageEntryFile.html";
			frm.submit(); 
		}
	}
}