$(function(){
	
	$("#userpw").keypress(function(e) { 
    	if (e.keyCode == 13){
        	login();
    	}    
	});
});

function login(){
	if(checkForm()){
		$("#frm").attr("action","/j_spring_security_check");
		$("#userpw").val(CryptoJS.SHA256($("#userpw").val()).toString());
    	$("#frm").submit();
	}
}

function checkForm() {
	with (document.frm) {
        if (typeof(userid) != "undefined" && userid.value.trim() == "") {
            alert("아이디를 입력하세요.");
            userid.focus();
            return false;
        }

        if (typeof(userpw) != "undefined" && userpw.value.trim() == "") {
            alert("비밀번호를 입력하세요.");
            userpw.focus();
            return false;
        }
        
  	 }
	 return true;
}
