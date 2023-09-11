$(function(){
	var now = new Date();
	$('.date-pick').datepicker({
		 dateFormat : "yymmdd"
		,showMonthAfterYear : true
		,changeMonth: true // True if month can be selected directly, false if only prev/next
		,changeYear: true // True if year can be selected directly, false if only prev/next
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,yearRange: "c-60:c+1"
		,defaultDate: new Date(now.getFullYear(), now.getMonth(), now.getDate())
	});
	$('.datetimepicker').datetimepicker({
	// $('.datetimepicker').appendDtpicker({
		lang:'ko',
		format:'YmdHi'
	});

	//숫자만 입력
	 $(".number").bind("keyup", function () {
       $(this).val($(this).val().replace(/[^0-9]/gi, ""));
     });
	
	write_submit = function(f) {
		var form = $(f);
		var evTitle = $('#evTitle').val().trim();
		if (typeof(evTitle) == 'undefined' || evTitle == '') {
			alert('제목을 입력해 주세요.');
			$('#evTitle').focus();
			return false;
		}
/*		
		var evStartDate =  $('#evStartDate').val().trim();
		if (typeof(evStartDate) == 'undefined' || evStartDate == '') {
			alert('행사기간 시작일을 선택해 주세요.');
			$('#evStartDate').focus();
			return false;
		}
		var evEndDate =  $('#evEndDate').val().trim();
		if (typeof(evEndDate) == 'undefined' || evEndDate == '') {
			alert('행사기간 종료일을 선택해 주세요.');
			$('#evEndDate').focus();
			return false;
		}
		if(parseInt(evStartDate) > parseInt(evEndDate)) {
			alert('행사기간 종료일이 시작일보다 빠릅니다. 확인해 주세요.');
			$('#evEndDate').focus();
			return false;
		}
		var evRegisStartTime =  $('#evRegisStartTime').val().trim();
		if (typeof(evRegisStartTime) == 'undefined' || evRegisStartTime == '') {
			alert('사전등록기간 시작일시를 선택해 주세요.');
			$('#evRegisStartTime').focus();
			return false;
		}
		var evRegisEndTime =  $('#evRegisEndTime').val().trim();
		if (typeof(evRegisEndTime) == 'undefined' || evRegisEndTime == '') {
			$('#evRegisEndTime').focus();
			alert('사전등록기간 종료일시를 선택해 주세요.');
			return false;
		}
		if(parseInt(evRegisStartTime) > parseInt(evRegisEndTime)) {
			alert('사전등록기간 종료일시가 시작일시보다 빠릅니다. 확인해 주세요.');
			$('#evRegisEndTime').focus();
			return false;
		}
		var evOpenSite =  $('#evOpenSite').val().trim();
		if (typeof(evOpenSite) == 'undefined' || evOpenSite == '') {
			alert('개최장소를 입력해 주세요.');
			$('#evOpenSite').focus();
			return false;
		}
		var evOpenDate =  $('#evOpenDate').val().trim();
		if (typeof(evOpenDate) == 'undefined' || evOpenDate == '') {
			alert('게재일을 선택해 주세요.');
			$('#evOpenDate').focus();
			return false;
		}
		var evContents =  $('#evContents').val().trim();
		if (typeof(evContents) == 'undefined' || evContents == '') {
			alert('내용을 입력해 주세요.');
			$('#evContents').focus();
			return false;
		}
*/		
		return true;
	};

});

function postsearch(initial){
    if(typeof initial === "undefined"){
          initial ='';
    }
	var url = "/skin/post/post.html?initial="+initial;
	var windowName = "search_post";
	var windowWidth = 468;
	var windowHeight = 400;
	var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
	var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
	var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
	window.open(url, windowName, windowSize);
}
//결제창 호출
function popup_payment(order){
    if(typeof initial === "undefined"){
          initial ='';
    }
    $('#encode').val(order);
	var url = "/Allat/approval.html?sOrderNo="+order;
	var windowName = "search_post";
	var windowWidth = 468;
	var windowHeight = 360;
	var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
	var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
	var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
	window.open(url, windowName, windowSize);
	return false;
}
//결제 완료 후 호출
function orderResult(ret,no){
	if(ret=="Y"){
		//주문코드 등록
		$('#insert').attr('action',"/conference/pre_registration_update.html")
		$('#insert').attr('onsubmit',"")
		$('#insert').submit();
	}else{
		alert('결제를 실패하였습니다.')
	}
}
//첨부파일 확장자 체크
function check_ext(e){
	
	var temp = $(e).val();
	var ext = temp.substring(temp.lastIndexOf(".") + 1).toLowerCase();
	var exts = ['pdf','hwp','doc','docx','xls','xlsx','ppt','pptx'];
	if (exts.indexOf(ext) < 0) {
		alert('문서 파일만 첨부가 가능합니다');
		$(e).val('');
		return false;
	}
	if(e.files[0].size/1024/1024 > 50){// 단위는 M
		$(e).val('');
		alert('파일 용량이 50M이하의 파일만 첨부가 가능합니다');
		return false;
		
	} 	
}
function check_email(e){
	//이메일 입력
	var res = $(e).val().split("@");
   if(res.length > 1 ){
   	alert('@domain.com을 제외한 아이디만 입력해주세요')
   	$(e).val(res[0]);
   	return false;
   }
}

function changeEmail(obj){
	$('#email2').val($(obj).val().trim());
	if($(obj).val().trim() == "") $('#email2').show();
	else $('#email2').hide();
	return false;
}