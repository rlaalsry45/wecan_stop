<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>
	$(function(){

	});

	function application(){
		
		var sessionData = "258"; 
		sessionStorage.setItem("wecan_np", sessionData );

		$.ajax({
			type: 'POST',
			url: "/frontsys/application/sessionCheckForGOV.html",
			data : {"whatStepFST":"F"},
			success: function(result){
				if( result.resultCode == 'SUCCESS' ) {
					location.href= "/?menuno=258";
				}else{
					location.href= "/?menuno=259";
				}
			},
			error:function(e){
				alert("로그인 확인중 오류가 발생하였습니다."+e.responseText  );
			}
		});
	}

	function inquiry(){
		
		var sessionData = "260"; 
		sessionStorage.setItem("wecan_np", sessionData );

		$.ajax({
			type: 'POST',
			url: "/frontsys/application/sessionCheckForGOV.html",
			data : {"whatStepFST":"F"},
			success: function(result){
				if( result.resultCode == 'SUCCESS' ) {
					location.href= "/?menuno=260";
				}else{
					location.href= "/?menuno=259";
				}
			},
			error:function(e){
				alert("로그인 확인중 오류가 발생하였습니다."+e.responseText  );
			}
		});
	}

	function msg(){
		alert("온라인 신청은 준비중입니다.\n신청 절차는 02-735-7544로 문의해 주세요.");
	}
</script>
