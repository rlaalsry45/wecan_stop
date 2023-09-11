$(function(){
	$('.date-pick').datepicker({
		 dateFormat : "yymmdd"
		,showMonthAfterYear : true
		,changeMonth: true // True if month can be selected directly, false if only prev/next
		,changeYear: true // True if year can be selected directly, false if only prev/next
		,dayNamesMin : ['월', '화', '수', '목', '금', '토', '일']
		,monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,yearRange: "c-60:c+1"
		,defaultDate: new Date(1980, 0, 1)
	});
	//숫자만 입력
	 $(".number").bind("keyup", function () {
       $(this).val($(this).val().replace(/[^0-9]/gi, ""));
     });

	 /*insert_submit = function(f) {
		var form = $(f);
		var session = $('#session').val().trim();
		if (typeof(session) == 'undefined' || session == '') {
			$('#session').focus();
			alert('세션을 선택하십시오.');
			return false;
		}
		var field =  $('#field').val().trim();
		if (typeof(field) == 'undefined' || field == '') {
			$('#field').focus();
			alert('분야를 선택하십시오.');
			return false;
		}
		var receipt =  $('#receipt').val().trim();
		if (typeof(receipt) == 'undefined' || receipt == '') {
			$('#receipt').focus();
			alert('접수논문을 선택하십시오.');
			return false;
		}
		var paper_title =  $('#paper_title').val().trim();
		if (typeof(paper_title) == 'undefined' || paper_title == '') {
			$('#paper_title').focus();
			alert('논문제목을하십시오.');
			return false;
		}
		var summation =  $('#summation').val().trim();
		if (typeof(summation) == 'undefined' || summation == '') {
			$('#summation').focus();
			alert('요약을 입력하십시오.');
			return false;
		}
		var file =  $('#file').val().trim();
		if (typeof(file) == 'undefined' || file == '') {
			$('#file').focus();
			alert('첨부파일을 입력하십시오.');
			return false;
		}
		var name =  $('#name').val().trim();
		if (typeof(name) == 'undefined' || name == '') {
			$('#name').focus();
			alert('이름을 입력하십시오.');
			return false;
		}
		var phone1 =  $('#phone1').val().trim();
		if (typeof(phone1) == 'undefined' || phone1 == '') {
			$('#phone1').focus();
			alert('전화번호를 입력하십시오.');
			return false;
		}
		var phone2 =  $('#phone2').val().trim();
		if (typeof(phone2) == 'undefined' || phone2 == '') {
			$('#phone2').focus();
			alert('전화번호를 입력하십시오.');
			return false;
		}
		var phone3 =  $('#phone3').val().trim();
		if (typeof(phone3) == 'undefined' || phone3 == '') {
			$('#phone3').focus();
			alert('전화번호를 입력하십시오.');
			return false;
		}
		var email1 =  $('#email1').val().trim();
		if (typeof(email1) == 'undefined' || email1 == '') {
			$('#email1').focus();
			alert('이메일을 입력하십시오.');
			return false;
		}
		var email2 =  $('#email2').val().trim();
		if (typeof(email2) == 'undefined' || email2 == '') {
			$('#email2').focus();
			alert('이메일을 입력하십시오.');
			return false;
		}
		return true;

	};*/
	/*insert_pa_submit = function(f) {
		var form = $(f);
		var fee = $('#fee').val().trim();
		if (typeof(fee) == 'undefined' || fee == '') {
			$('#fee').focus();
			alert('결제비를 선택하십시오.');
			return false;
		}
		var payments =  $('#payments').val().trim();
		if (typeof(payments) == 'undefined' || payments == '') {
			$('#payments').focus();
			alert('결제방법을 선택하십시오.');
			return false;
		}
		var name =  $('#name').val().trim();
		if (typeof(name) == 'undefined' || name == '') {
			$('#name').focus();
			alert('이름을 입력하십시오.');
			return false;
		}
		var phone1 =  $('#phone1').val().trim();
		if (typeof(phone1) == 'undefined' || phone1 == '') {
			$('#phone1').focus();
			alert('전화번호를 입력하십시오.');
			return false;
		}
		var phone2 =  $('#phone2').val().trim();
		if (typeof(phone2) == 'undefined' || phone2 == '') {
			$('#phone2').focus();
			alert('전화번호를 입력하십시오.');
			return false;
		}
		var phone3 =  $('#phone3').val().trim();
		if (typeof(phone3) == 'undefined' || phone3 == '') {
			$('#phone3').focus();
			alert('전화번호를 입력하십시오.');
			return false;
		}
		var email1 =  $('#email1').val().trim();
		if (typeof(email1) == 'undefined' || email1 == '') {
			$('#email1').focus();
			alert('이메일을 입력하십시오.');
			return false;
		}
		var email2 =  $('#email2').val().trim();
		if (typeof(email2) == 'undefined' || email2 == '') {
			$('#email2').focus();
			alert('이메일을 입력하십시오.');
			return false;
		}
		return true;

	};*/


	/*insert_ap_submit = function(f) {
		var form = $(f);

		var paper_title =  $('#paper_title').val().trim();
		if (typeof(paper_title) == 'undefined' || paper_title == '') {
			$('#paper_title').focus();
			alert('논문제목을하십시오.');
			return false;
		}
		var file =  $('#file').val().trim();
		if (typeof(file) == 'undefined' || file == '') {
			$('#file').focus();
			alert('첨부파일을 입력하십시오.');
			return false;
		}
		return true;

	};	*/


});
/*function insert_mo_submit (f) {
	var form = $(f);
	var recipies ='';
	var checked_i = 0;
	for(var i =1; i<=13; i++){
		if($('input[name=receipt'+i+']').is(":checked") == true){
			checked_i++;
			var lab = $('input[name=receipt'+i+']').attr('id');
			var title = $('label[for='+lab+']').text();
			recipies += title +',';
		}
	}
	if(checked_i != 3){
		alert('전공선택은 3개를 선택하셔야합니다.')
		return false;
	}
	var session = $('#session').val().trim();
	if (typeof(session) == 'undefined' || session == '') {
		$('#session').focus();
		alert('세션을 선택하십시오.');
		return false;
	}
	var field =  $('#field').val().trim();
	if (typeof(field) == 'undefined' || field == '') {
		$('#field').focus();
		alert('분야를 선택하십시오.');
		return false;
	}
	var name =  $('#name').val().trim();
	if (typeof(name) == 'undefined' || name == '') {
		$('#name').focus();
		alert('이름을 입력하십시오.');
		return false;
	}
	var phone1 =  $('#phone1').val().trim();
	if (typeof(phone1) == 'undefined' || phone1 == '') {
		$('#phone1').focus();
		alert('전화번호를 입력하십시오.');
		return false;
	}
	var phone2 =  $('#phone2').val().trim();
	if (typeof(phone2) == 'undefined' || phone2 == '') {
		$('#phone2').focus();
		alert('전화번호를 입력하십시오.');
		return false;
	}
	var phone3 =  $('#phone3').val().trim();
	if (typeof(phone3) == 'undefined' || phone3 == '') {
		$('#phone3').focus();
		alert('전화번호를 입력하십시오.');
		return false;
	}
	var email1 =  $('#email1').val().trim();
	if (typeof(email1) == 'undefined' || email1 == '') {
		$('#email1').focus();
		alert('이메일을 입력하십시오.');
		return false;
	}
	var email2 =  $('#email2').val().trim();
	if (typeof(email2) == 'undefined' || email2 == '') {
		$('#email2').focus();
		alert('이메일을 입력하십시오.');
		return false;
	}

	$('#receipt').val(recipies);
	return true;

}*/
//사전 참가자 insert- 후 결제로 넘김
function insert_pa_submit_ajax(form){
	var username =  $('#username').val().trim();
	if (typeof(username) == 'undefined' || username == '') {
		$('#username').focus();
		alert('이름을 입력하십시오.');
		return false;
	}
	/*var phone1 =  $('#phone1').val().trim();
	if (typeof(phone1) == 'undefined' || phone1 == '') {
		$('#phone1').focus();
		alert('핸드폰을 입력하십시오.');
		return false;
	}
	var phone2 =  $('#phone2').val().trim();
	if (typeof(phone2) == 'undefined' || phone2 == '') {
		$('#phone2').focus();
		alert('핸드폰을 입력하십시오.');
		return false;
	}
	var phone3 =  $('#phone3').val().trim();
	if (typeof(phone3) == 'undefined' || phone3 == '') {
		$('#phone3').focus();
		alert('핸드폰을 입력하십시오.');
		return false;
	}*/
	var email1 =  $('#email1').val().trim();
	if (typeof(email1) == 'undefined' || email1 == '') {
		$('#email1').focus();
		alert('이메일을 입력하십시오.');
		return false;
	}
	var email2 =  $('#email2').val().trim();
	if (typeof(email2) == 'undefined' || email2 == '') {
		$('#email2').focus();
		alert('이메일을 입력하십시오.');
		return false;
	}
	var mobile1 =  $('#mobile1').val().trim();
	if (typeof(mobile1) == 'undefined' || mobile1 == '') {
		$('#mobile1').focus();
		alert('휴대전화번호를 입력하십시오.');
		return false;
	}
	var mobile2 =  $('#mobile2').val().trim();
	if (typeof(email2) == 'undefined' || mobile2 == '') {
		$('#mobile2').focus();
		alert('휴대전화번호를 입력하십시오.');
		return false;
	}
	var mobile3 =  $('#mobile3').val().trim();
	if (typeof(mobile3) == 'undefined' || mobile3 == '') {
		$('#mobile3').focus();
		alert('휴대전화번호를 입력하십시오.');
		return false;
	}

	var data = "idx="+$("#idx").val() +"&amt="+$("#amt").val()+"&userno="+$("#userno").val()+"&username="+$("#username").val()+"&birthday="+$("#birthday").val()+"&email="+$("#email1").val()+"@"+$("#email2").val()+"&mobile="+$("#mobile1").val()+"-"+$("#mobile2").val()+"-"+$("#mobile3").val();
	//alert(data);
	//먼저 해당 결제에 대한 내용을 자유결제 테이블에 넣는다.freeorderparticipant
	$.ajax({
		type: "POST",
		url: "/freeorder/order_write/index.html",
		data: data,
		success: function(response){
			if(response.status !='00'){
				//alert(response.msg);
			}else{
				//alert(response.msg);
				var url = "/Allat/approval.html?sOrderNo="+response.msg;
				var windowName = "allat_approval";
				var windowWidth = 468;
				var windowHeight = 360;
				var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
				var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
				var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
				window.open(url, windowName, windowSize);
			}
        }
		, error : function(data, status, err){
			alert("서버와의 통신이 실패했습니다.");
			return;
		}
	});
	/*$.ajax({
		type: "POST",
		url: form.action,
		data: $(form).serialize(),
		success: function(response){

            //결제 정보 넘기기
			$('#paidx').val(response.paidx);
			$('#oAmt').val(response.enfee);
			$('#oProductCD').val(response.paidx);
			$('#oMemberID').val(response.userno);
			$('#oMemberNm').val(response.name);
			$('#oRecpNM').val(response.name);
			$('#oRecpAddr').val(response.address +" "+response.address2);
			$('#oMemberEmail').val(response.email);
			$('#payment_form').submit();

			if(response.userno==0)
				$('#oMemberID').val("guest");
        }
	});*/
	return false;

}

function orderResult(orderResult, sOrderNo){
	//Y,주문번호가 들어오면 정상결제
	//N,ERROR가 들어오면 비정상 결제

	//alert("결재결과:"+orderResult+": 주문번호"+sOrderNo);//
	if(orderResult == 'Y'){
		window.location.reload();
	}else{
		alert("결재가 비정상적으로 종료되었습니다");
	}
}

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

//첨부파일 확장자 체크
function check_ext(e){

	var temp = $(e).val();
	var ext = temp.substring(temp.lastIndexOf(".") + 1).toLowerCase();
	var exts = ['pdf'];
	if (exts.indexOf(ext) < 0) {
		alert('pdf 파일만 첨부가 가능합니다');
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