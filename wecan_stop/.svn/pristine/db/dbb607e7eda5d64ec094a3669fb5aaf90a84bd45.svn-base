$(function(){
	
    $("#userCode").bind("keyup", function () {
    	$(this).val($(this).val().replace(/[^0-9]/gi, ""));
    });
    
    $("#userCode").keydown(function(e) {
        if (e.keyCode == 13) {
		   e.preventDefault();
		   crtfc();  
        }
    });

});

function checkForm(){
    with (document.frm) {
		if (typeof(userCode) != "undefined" && userCode.value.trim() == "") {
	        alert("OTP를 입력하세요.");
	        userCode.focus();
	        return false;
	    }
	 }
	 return true;
}

function crtfc(){
	if (checkForm()){
		$.ajax({
             type: "POST"
            ,url: "/admsys/setting/admin/login2ndResult.html"
            ,data: $("#frm").serialize()
            ,dataType: "json"
            ,success: function(data){
            	if (data.resultCode == "success"){
		       		$("#frm").attr("action","/admsys/dashboard/index.html");
		       		$("#frm").submit();
		       	}else{
					alert(data.resultMsg);
				}
            }
            ,error: function(x,e){
                alert('에러가 발생했습니다. 관리자에게 문의하세요.');
            }
        });    
	}
}

function reg(){
	$(".popup_wrap").show();
}
