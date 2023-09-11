<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/admsys/common.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<script type="text/javascript" src="/var/sha/core.min.js"></script>
<script type="text/javascript" src="/var/sha/sha256.min.js"></script
<script type="text/javascript" src="/usr/js/common.js"></script>
<script type="text/javascript" src="/var/alertify/alertify.js"></script>
<script type="text/javascript">

        $(document).on("click", "#submit_btn", function (event) {
            event.preventDefault();

            var pass = $("#newpass");
            var pair = $("#repass");
            if (pass.val().length > 0) {
            	var regExp = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

                if (pass.val().match(regExp) == null) {
                	alert("영대/소문자,숫자,특수문자 중 3종류 이상 8~16자리 비밀번호를 입력하세요.", function () {
                        pass.focus();
                    });
                	return false;
                }

                if (pass.val() !== pair.val()) {
                    pair.val('');
                    alert("비밀번호가 일치하지 않습니다!", function () {
                        pair.focus();
                    });
                    return false;
          		}
            }
   
   			if(confirm("정보를 수정하시겠습니까 ?")){
   			
   				if($("#newpass").val() != ""){
                
                	var shaPw = CryptoJS.SHA256($("#newpass").val()).toString();		 
                	$("#newpass").val(shaPw);
          		        			
          			$.ajax({ 
						type: 'post' 
						, url: '/admsys/user/common/updatepassword.html' 
						, data: "newpass="+$("#newpass").val()
						, success: function(data) {
							
							if(data.code == 'success'){
							
								alert(data.message);
								window.close();
									
							}else{
							
								alert(data.message);
							}
							
						} 
						, error: function(data, status, err) { 
							alert('서버와의 통신이 실패했습니다.'+err); 
						}
					});
                			
            	}
            	
   			}else{
   				return;
   			}
        });

</script>

 <body>   
      <div class="content">
	    <div class="cont_wrap">
	        <div class="cont">
	            <p class="p_t t_center" style = "font-size:15px;">비밀번호 변경일로 부터 ${chkVal}일 경과 하였습니다.</p>
	            <p class="p_t t_center" style = "font-size:15px;">동일한 비밀번호를 사용 시 도용 위험성이 있으니 비밀번호를 변경해주시기 바랍니다.</p>
	            <form id="updateForm" name="updateForm" method="post" class="otp_login">
	            	<dl>
	                    <dt>새비밀번호</dt>
	                    <dd><input type="password" id="newpass" name="newpass" value=""  maxlength="20" autofocus="autofocus"></dd>
	                </dl>
	                <dl>
	                    <dt>새비밀번호 확인</dt>
	                    <dd><input type="password" id="repass" name="repass" value="" maxlength="20"></dd>
	                </dl>
	                <div class="btn_box">
	                    <a href="" class="btn b_feac25" id = "submit_btn">확인</a>
	                </div>
	                <div class="btn_box">
	                    <a href="" class="btn b_feac25" onclick ="window.close();">다음에 변경하기</a>
	                </div>
	                
	            </form>
	            <p class="t_right mr_50">시스템 관련 문의 02-6363-8335~8336</p>
	        </div>
	    </div>
	</div>

</body>
</html>