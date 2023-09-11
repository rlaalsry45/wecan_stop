$(function(){
	$('.date-pick').datepicker({
		 dateFormat : "yymmdd"
		,showMonthAfterYear : true
		,changeMonth: true // True if month can be selected directly, false if only prev/next
		,changeYear: true // True if year can be selected directly, false if only prev/next
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,yearRange: "c-100:c+1"
		,defaultDate: new Date()
	});
	//숫자만 입력
	$(".number").bind("keyup", function () {
		$(this).val($(this).val().replace(/[^0-9]/gi, ""));
	});
	
	write_submit = function(f) {
		
		var form = $(f);
		var enUserName = $.trim($('#enUserName').val());
		if (typeof(enUserName) == 'undefined' || enUserName == '') {
			alert('성명을 입력해 주세요.');
			$('#enUserName').focus();
			return false;
		}

		if ( $("#enUserPasswd").length > 0 ){
			var enUserPasswd = $('#enUserPasswd').val();
			if (enUserPasswd == '') {
				alert('비밀번호를 입력해주세요.');
				$('#enUserPasswd').focus();
				return false;
			}
			
			if(enUserPasswd.length < 4){
				alert('비밀번호를 4자리 이상 입력해주세요.');
				$('#enUserPasswd').focus();
				return false;
			}
		}
		
		var enUserBirthDate =  $.trim($('#enUserBirthDate').val());
		if (typeof(enUserBirthDate) == 'undefined' || enUserBirthDate == '') {
			alert('생년월일을 입력해 주세요.');
			$('#enUserBirthDate').focus();
			return false;
		} else {
			$('#enUserBirthDate').val(enUserBirthDate);
		}
		var enUserOrg =  $.trim($('#enUserOrg').val());
		if (typeof(enUserOrg) == 'undefined' || enUserOrg == '') {
			alert('회사(학교)명을 입력해 주세요.');
			$('#enUserOrg').focus();
			return false;
		}
		var enUserDept =  $.trim($('#enUserDept').val());
		if (typeof(enUserDept) == 'undefined' || enUserDept == '') {
			alert('부서(학과)명을 입력해 주세요.');
			$('#enUserDept').focus();
			return false;
		}
		var enUserJob =  $.trim($('#enUserJob').val());
		if (typeof(enUserJob) == 'undefined' || enUserJob == '') {
			alert('직위(급)를 입력해 주세요.');
			$('#enUserJob').focus();
			return false;
		}

		var email1 =  $.trim($('#email1').val());
		var email_valid = 0;
		if (typeof(email1) == 'undefined' || email1 == '') {
			alert('이메일 주소를 입력해 주세요.');
			$('#email1').focus();
			return false;
		} else {
			email_valid += 1;
		}
		var email2 =  $.trim($('#email2').val());
		if (typeof(email2) == 'undefined' || email2 == '') {
			alert('이메일 주소를 형식에 맞게 입력해 주세요.');
			$('#email2').focus();
			return false;
		} else {
			email_valid += 1;
		}
		if(email_valid == 2) {
			$('#enUserEmail').val(email1 + '@' + email2);
		}

		var phone1 =  $.trim($('#phone1').val());
		var phone_valid = 0;
		if (typeof(phone1) == 'undefined' || phone1 == '') {
			alert('전화번호를 입력해 주세요.');
			$('#phone1').focus();
			return false;
		} else {
			phone_valid += 1;
		}
		var phone2 =  $.trim($('#phone2').val());
		if (typeof(phone2) == 'undefined' || phone2 == '') {
			alert('전화번호를 입력해 주세요.');
			$('#phone2').focus();
			return false;
		} else {
			phone_valid += 1;
		}
		var phone3 =  $.trim($('#phone3').val());
		if (typeof(phone3) == 'undefined' || phone3 == '') {
			alert('전화번호를 입력해 주세요.');
			$('#phone3').focus();
			return false;
		} else {
			phone_valid += 1;
		}
		if(phone_valid == 3) {
			$('#enUserPhone').val(phone1 + '-' + phone2 + '-' + phone3);
		}

		var mobile1 =  $.trim($('#mobile1').val());
		var mobile_valid = 0;
		if (typeof(mobile1) == 'undefined' || mobile1 == '') {
			alert('휴대전화번호를 입력해 주세요.');
			$('#mobile1').focus();
			return false;
		} else {
			mobile_valid += 1;
		}
		var mobile2 =  $.trim($('#mobile2').val());
		if (typeof(mobile2) == 'undefined' || mobile2 == '') {
			alert('휴대전화번호를 입력해 주세요.');
			$('#mobile2').focus();
			return false;
		} else {
			mobile_valid += 1;
		}
		var mobile3 =  $.trim($('#mobile3').val());
		if (typeof(mobile3) == 'undefined' || mobile3 == '') {
			alert('휴대전화번호를 입력해 주세요.');
			$('#mobile3').focus();
			return false;
		} else {
			mobile_valid += 1;
		}
		if(mobile_valid == 3) {
			$('#enUserMobile').val(mobile1 + '-' + mobile2 + '-' + mobile3);
		}

		/*var pa_useraddrno1 =  $.trim($('#pa_useraddrno1').val());
		var pa_useraddrno2 =  $('#pa_useraddrno2'))trim();
		if (!(typeof(pa_useraddrno1) == 'undefined' || pa_useraddrno1 == '') && 
			!(typeof(pa_useraddrno2) == 'undefined' || pa_useraddrno2 == '')) {
			$('#enUserZipCode').val(pa_useraddrno1 + pa_useraddrno2);
		}*/
		
		var pa_useraddrno1 =  $.trim($('#pa_useraddrno1').val());
		if (!(typeof(pa_useraddrno1) == 'undefined' || pa_useraddrno1 == '')) {
			$('#enUserZipCode').val(pa_useraddrno1);
		}

		var enUserAddr =  $.trim($('#pa_useraddr').val());
		if (typeof(enUserAddr) == 'undefined' || enUserAddr == '') {
			alert('주소를 입력해 주세요.');
			$('#pa_useraddr').focus();
			return false;
		}
		var enUserAddrDetail =  $.trim($('#pa_useraddr2').val());
		if (typeof(enUserAddrDetail) == 'undefined' || enUserAddrDetail == '') {
			alert('상세주소를 입력해 주세요.');
			$('#pa_useraddr2').focus();
			return false;
		}
		// if($("input:checkbox[name='enUserIsPanel']").is(":checked") == false) {
//		if($('input:radio[name="enUserIsPanel"]:checked').val() == '') {
//			alert('발표자 여부를 선택해 주세요.');
//			$('#isPanel').focus();
//			return false;
//		}
		var enFeeIdx =  $('#enFeeIdx:checked').val();
		if (typeof(enFeeIdx) == 'undefined' || enFeeIdx == '') {
			alert('참가비를 선택하세요.');
			$('#enFeeIdx').focus();
			return false;
		}
		
		if($("#epAttFileName").length > 0){
			
			var epAttFileName =  $('#epAttFileName').val();
			if (typeof(epAttFileName) == 'undefined' || epAttFileName == '') {
				alert('첨부파일을 선택하세요.');
				$('#epAttFileName').focus();
				return false;
			}
		}
		
		if($("#epAttFileName2").length > 0){
			
			var epAttFileName =  $('#epAttFileName2').val();
			if (typeof(epAttFileName) == 'undefined' || epAttFileName == '') {
				alert('첨부파일을 선택하세요.');
				$('#epAttFileName2').focus();
				return false;
			}
		}

		if(confirm("등록하시겠습니까?")){
			return true;
		}else{
			return false;
		}
		
	};

});

function postsearch(initial){
    if(typeof initial === "undefined"){
          initial ='';
    }
	var url = "/skin/post/post.html?initial="+initial;
	var windowName = "search_post";
	var windowWidth = 475;
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
	/*if (exts.indexOf(ext) < 0) {
		alert('문서 파일만 첨부가 가능합니다');
		$(e).val('');
		return false;
	}*/
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
	$.trim($('#email2').val($(obj).val()));
	if($.trim($(obj).val()) == "") $('#email2').show();
	else $('#email2').hide();
	return false;
}
