$(function(){
	
	//숫자만 입력	
    $("#mobile").bind("keyup", function () {
    	$(this).val($(this).val().replace(/[^0-9]/gi, ""));
    	$(this).val(autoHypenPhone($(this).val())); 
    });

});

function checkForm() {
    with (document.frm) {
		if (typeof(username) != "undefined" && username.value.trim() == "") {
	        alert("이름을 입력하세요.");
	        username.focus();
	        return false;
	    }
	    
	    if (typeof(mobile) != "undefined" && mobile.value.trim() == "") {
	        alert("핸드폰번호를 입력하세요.");
	        mobile.focus();
	        return false;
	    }
	    
	    if(!isPhone(mobile.value)){
			alert("핸드폰번호형식이 맞지 않습니다.");
   			mobile.focus();
   			return false;
		}
	    
		if (typeof(userCode) != "undefined" && userCode.value.trim() == "") {
	        alert("인증번호를 입력하세요.");
	        userCode.focus();
	        return false;
	    }
	 }
	 return true;
}

function findUserid()
{
	if (checkForm()){
		$.ajax({
             type: "POST"
            ,url: "/admsys/user/common/findUseridResult.html"
            ,data: $("#frm").serialize()
            ,dataType: "json"
            ,success: function(data){
            	if (data.resultCode == "success"){
		       		alert("고객님의 아이디는 "+data.userid+" 입니다.");
		       		location.href="/login.html";
		       	}
            }
            ,error: function(x,e){
                alert('에러가 발생했습니다. 관리자에게 문의하세요.');
            }
        });    
	}
}
