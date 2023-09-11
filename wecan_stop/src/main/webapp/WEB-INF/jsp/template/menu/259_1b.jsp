<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>
	$(function(){		
		$("#checkBtn").click(function(){
			login();	
		});

		$("#govno").keydown(function(e) {
        	if (e.keyCode == 13) {
		   		e.preventDefault();
		   		login();  
        	}
    	});
       		
	});

	function login(){
		var govno= $("#govno").val();

		$.ajax({
			type: 'POST',
			url: "/frontsys/check/checkFirstStep.html",
			data: {govNo:govno},
			success: function(result){
				if ( result.resultCode== "SUCCESS" ) {
					location.href="/?menuno=261";

				} else {
					alert("로그인에 실패 하였습니다.");
				}
			},
			error:function(){
				alert("로그인중 오류가 발생하였습니다.");  
			}
		});
	}

</script>
