<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>

$(document).ready(function(){

    $("#telnum").bind("keyup", function () {
    	$(this).val($(this).val().replace(/[^0-9]/gi, ""));
		$(this).val(autoHypenPhone($(this).val()));
    });
});
		
function goNext(){
	
	if (checkForm()){
		var counselNum = "";
		$.ajax({
		  	type: "POST"
		  	,url: "/frontsys/counsel/counselLog_getCounselNum.html"
	    	,dataType: "json"
			,async: false
	    	,success: function(data){
				if(data.resultCode == "success"){
					counselNum = data.counselNum;
				}
		  	}
		    ,error:function(data){
			  alert("상담번호 처리중 오류가 발생하였습니다. 관리자에게 문의하시기 바랍니다.");  
		  	}
		});	

		var sendData = {};
		sendData.userid = $("#username").val();
		sendData.nickname = $("#username").val();
		sendData.usertype = 0;

		var reurl = "";
		if(window.location.port == "8080"){
			reurl = window.location.protocol+"//"+window.location.hostname+":"+window.location.port+"/?menuno=244";
		}else{
			reurl = window.location.protocol+"//"+window.location.hostname+"/?menuno=244";
		}
		sendData.reurl = reurl;

		sendData.roomid = counselNum;
		sendData.roomname = counselNum;


		$.ajax({
			type: "POST"
			,url: "/frontsys/chat/updateChat.html"
	    	,data: "telnum="+$("#telnum").val()+"&username="+$("#username").val()
	    	,dataType: "json"
			,async: false
	    	,success: function(data){
	    		if(data.resultCode == "success"){
					var username =  $("#username").val().trim();
					if(username == ""){	username = "고객";}
					let content = username + "님이 " + getToday() + "(" + getDate() + ")에 채팅상담을 요청하였습니다.";
		   			$.ajax({
        				type: "post"
        				,url: "/front/notify/insertNotify.html"
        				,dataType: "text"
        				,data: "business="+$("#business").val()+"&counselclassification="+$("#counselclassification").val()+"&content="+content
						,async: false
        				,success: function(){
        				}
    				});

    				//채팅방 입장
    				$.ajax({
    				    contentType: "application/json; charset=utf-8",
    				    type:"post",
    				    dataType:"json",
    				    data: JSON.stringify(sendData),
    				    url: "https://chat.women1366.kr/api/token",
						async: false,
    				    success: function (resp) {
    				    	PopupCenter(resp.url, "chatWin", "500", "600");
    			     	}
    				 });
    				
	        	}else{
	        		alert("개인정보 수집 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	       		}
	    	},error: function(data){
	       		alert("개인정보 수집 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	    	}        
	 	});
	}
    
}

function checkForm() {
  
	if (!$("#agree_check").is(":checked")) {
        alert("개인정보 수집·이용 동의(필수)를 확인후 동의해 주세요.");
        $("#agree_check").focus();
        return false;
    }

	if($("#username").val() == ""){
		alert("이름을 입력하세요.");
   		$("#username").focus();
   		return false;
	}

	if($("#telnum").val() == ""){
		alert("핸드폰번호를 입력해주세요.");
   		$("#telnum").focus();
   		return false;
	}

	if($("#telnum").val() != "" && !isPhone($("#telnum").val())){
		alert("핸드폰번호형식이 맞지 않습니다.");
   		$("#telnum").focus();
   		return false;
	}
    
	return true;
}

function PopupCenter(url, title, w, h) {  
	// Fixes dual-screen position                         Most browsers      Firefox  
	var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;  
	var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;  
	              
	width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;  
	height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;  
	              
	var left = ((width / 2) - (w / 2)) + dualScreenLeft;  
	var top = ((height / 2) - (h / 2)) + dualScreenTop;  
	var newWindow = window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);  
	
	// Puts focus on the newWindow  
	if (window.focus) {  
		//newWindow.focus();  
    }

}

</script>
