$(function(){
	$('#coneventstartdate').datepicker({
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
	});
	//숫자만 입력
	 $(".number").bind("keyup", function () {
       $(this).val($(this).val().replace(/[^0-9]/gi, ""));
     });
	
	insert_submit = function(f) {
		var form = $(f);
		var productnm = $('#productnm').val().trim();
		if (typeof(productnm) == 'undefined' || productnm == '') {
			alert('상품명을 입력하십시오.');
			$('#productnm').focus();
			return false;
		}
		var amt1 = $('#amt1').val().trim();
		if (typeof(amt1) == 'undefined' || amt1 == '') {
			alert('가격을 입력하십시오.')
			$('#amt1').focus();
			return false;
		}
		var amt3 = $('#amt3').val().trim();
		if (typeof(amt3) == 'undefined' || amt3 == '') {
			alert('가격을 입력하십시오.')
			$('#amt3').focus();
			return false;
		}
		var amt0 = $('#amt0').val().trim();
		if (typeof(amt0) == 'undefined' || amt0 == '') {
			alert('가격을 입력하십시오.')
			$('#amt0').focus();
			return false;
		}

		var startdate = $('#startdate').val().trim();
		if(!$("#isendless1").is(":checked")){
			if (typeof(startdate) == 'undefined' || startdate == '') {
				alert('상품판매기간을 입력하십시오.');
				$('#startdate').focus()
				return false;
			}
		}
		var enddate = $('#enddate').val().trim();
		if(!$("#isendless1").is(":checked")){
			if (typeof(enddate) == 'undefined' || startdate == '') {
				alert('상품판매기간을 입력하십시오.');
				$('#enddate').focus()
				return false;
			}
		}
		if( $('#panner_userno_text').length  > 0){
			$('#panner_userno').val( $('#panner_userno_text').text());

		}
		//날짜 입력 확인
		var enddate = $('#enddate').val().trim();
		if (typeof(enddate) != 'undefined' && enddate != '') {
			if(enddate.replace(/-/gi,"")*1 < enddate.replace(/-/gi,"")*1){
				alert('종료일은 시작일보다 이후날짜여야합니다.')
				$('#enddate').focus();
				return false;
			}
		}
		$("#insert").submit();
		
		
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