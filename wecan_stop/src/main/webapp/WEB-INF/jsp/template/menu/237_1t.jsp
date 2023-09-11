<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script src="/var/sha/core.min.js"></script>
<script src="/var/sha/sha256.min.js"></script>

<script>

$(document).ready(function(){
	getCaptchaNKey();
});

$(document).on("click", "#captcha_reload", function(){
	getCaptchaNKey(); 
});

function getCaptchaNKey() {
	$.ajax({
		type: "POST"
		,url: "/frontsys/captcha/captchaNkey.html"
	   	,dataType: "json"
		,async: false				
	    ,success: function(data){
	    	if(data.resultCode == "success"){
				getCaptchaImage();	        	
	        }else{
				alert("네이버 캡차Nkey가 발급되지 않았습니다. 담당자에게 문의바랍니다.");
			}
	    },error: function(data){
	        alert("네이버 캡차Nkey가 발급되지 않았습니다. 담당자에게 문의바랍니다.");
	    }        
	});
}

function getCaptchaImage() {
	$.ajax({
		type: "POST"
		,url: "/frontsys/captcha/captchaImage.html"
	   	,dataType: "json"
		,async: false				
	    ,success: function(data){
	    	if(data.resultCode == "success"){
	        	$("#captcha_img").attr("src", "/usr/upload/captcha/image/"+data.captchaImg);
	        }else{
				alert("네이버 캡차 이미지 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
			}
	    },error: function(data){
	        alert("네이버 캡차 이미지 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	    }        
	});
}

function getCaptchaSKey() {
	$.ajax({
		type: "POST"
		,url: "/frontsys/captcha/captchaSkey.html"
	   	,dataType: "json"
		,async: false				
	    ,success: function(data){
	    	if(data.resultCode == "success"){
				getCaptchaSound();	        	
	        }else{
				alert("네이버 캡차Skey가 발급되지 않았습니다. 담당자에게 문의바랍니다.");
			}
	    },error: function(data){
	        alert("네이버 캡차Skey가 발급되지 않았습니다. 담당자에게 문의바랍니다.");
	    }        
	});
}

function getCaptchaSound() {
	$.ajax({
		type: "POST"
		,url: "/frontsys/captcha/captchaSound.html"
	   	,dataType: "json"
		,async: false				
	    ,success: function(data){
	    	if(data.resultCode == "success"){
	        	$("#captcha_sound").html('<audio controls="controls"><source src="/usr/upload/captcha/sound/'+data.captchaSound+'" type="audio/wav"></audio>');	    									
	        }else{
				alert("네이버 캡차 사운드 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
			}
	    },error: function(data){
	        alert("네이버 캡차 사운드 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	    }        
	});
}

function goNext(){
	if(checkForm()) {
		var captchaChk = true;
		if ($("#captcha_key").val() == "") {
        	alert("자동등록방지 문자를 입력하세요.");
        	$("#captcha_key").focus();
        	return;
    	}else{
			$.ajax({
				type: "POST"
				,url: "/frontsys/captcha/captchaNkeyResult.html"
	    		,data: "captchaKey="+$("#captcha_key").val()
	   			,dataType: "json"
				,async: false
	    		,success: function(data){
	    			if(data.resultCode != "success"){
						alert("자동등록방지 문자가 일치하지 않습니다.");
						$("#captcha_key").focus();
        				captchaChk = false;
						getCaptchaNKey();
						$("#captcha_key").val("");
					}
	    		},error: function(data){
	       			alert("자동등록방지 문자 확인중 오류가 발생했습니다.");
					captchaChk = false;
	   			}        
			});
		}

		if(captchaChk){
			$("#passwd").val(CryptoJS.SHA256($("#passwd").val()).toString());
			$.ajax({
				type: "POST"
				,url: "/frontsys/board/insertBoard.html"
	    		,data: $("#frm").serialize()
	   			,dataType: "json"
				,async: false
	    		,success: function(data){
	    			if(data.resultCode == "success"){
/*						if($("#add_file1").val() != ""){
							var formData = new FormData(); 
							formData.append("file1", $("#add_file1")[0].files[0]);

 							if($("#add_file2").val() != ""){
								formData.append("file2", $("#add_file2")[0].files[0]);
							} 

							$.ajax({
								type: "POST"
								,url: "/frontsys/board/insertBoardFile.html"
	    						,data: formData
	   							,dataType: "json"
								,processData: false
								,contentType: false
								,async: false
	    						,success: function(data){
	    							if(data.resultCode == "success"){
		        						alert("작성완료되었습니다.");

										let content = $("#username").val() + "님이 " + getToday() + "(" + getDate() + ")에 게시판상담을 요청하였습니다.";
    									$.ajax({
        									type: "post"
        									,url: "/front/notify/insertNotify.html"
        									,dataType: "text"
        									,data: "business="+$("#business").val()+"&counselclassification="+$("#counselclassification").val()+"&content="+content
											,async: false
        									,success: function(){
												location.href="/?menuno=230";
        									}
    									});

	        						}else{
	        							alert(data.resultMsg+" 담당자에게 문의바랍니다.");
										getCaptchaNKey();
										$("#captcha_key").val("");
	       							}
	    						},error: function(data){
	       							alert("파일등록중 오류가 발생했습니다.");
									getCaptchaNKey();
									$("#captcha_key").val("");
	    						}        
							});
						}else{ */
							alert("작성완료되었습니다.");

							let content = $("#username").val() + "님이 " + getToday() + "(" + getDate() + ")에 게시판상담을 요청하였습니다.";
		   					$.ajax({
        						type: "post"
        						,url: "/front/notify/insertNotify.html"
        						,dataType: "text"
        						,data: "business="+$("#business").val()+"&counselclassification="+$("#counselclassification").val()+"&content="+content
								,async: false
        						,success: function(){
            						location.href="/?menuno=230";
        						}
    						});
					/*	} */
	        		}else{
	        			alert(data.resultMsg);
						getCaptchaNKey();
						$("#captcha_key").val("");
	       			}
	    		},error: function(data){
	       			alert("글등록중 오류가 발생했습니다.");
					getCaptchaNKey();
					$("#captcha_key").val("");
	    		}        
			});
		}
	}
}

function checkForm() {
  
	if ($("#username").val() == "") {
        alert("이름를 입력하세요.");
        $("#username").focus();
        return false;
    }

	if ($("#passwd").val() == "") {
        alert("비밀번호를 입력하세요.");
        $("#passwd").focus();
        return false;
    }

	if (!isPwd($("#passwd").val())) {
        $("#passwd").focus();
        return false;
    }

	if ($("#title").val() == "") {
        alert("제목을 입력하세요.");
        $("#title").focus();
        return false;
    }

	if ($("#conts").val() == "") {
        alert("내용을 입력하세요.");
        $("#conts").focus();
        return false;
    }

	if (!$("#agree_check").is(":checked")) {
        alert("상담 유의사항을 확인후 동의해 주세요.");
        $("#agree_check").focus();
        return false;
    }

	return true;
}


function checkSize(input) {
    if (input.files && input.files[0].size > (10 * 1024 * 1024)) {
        alert("파일 사이즈가 10mb 를 넘습니다.");
        input.value = "";
    }
}


</script>

