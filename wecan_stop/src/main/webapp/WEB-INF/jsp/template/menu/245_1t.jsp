<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>

$(document).ready(function(){
  
});

function goNext(){
	if (checkForm()){
		$.ajax({
			type: "POST"
			,url: "/frontsys/satisfaction/cSatisfactionResult.html"
	    	,data: $("#frm").serialize()
	    	,dataType: "json"
			,async: false
	    	,success: function(data){
	    		if(data.resultCode == "success"){
					alert("작성해주신 소중한 의견은 참고하여 상담시 반영하도록 노력하겠습니다. 감사합니다.");
					location.href = "/?menuno=222";
	        	}else{
	        		alert("만족도조사 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	       		}
	    	},error: function(data){
	       		alert("만족도조사 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	    	}        
	 	});
	}
}

function checkForm() {

	if(Number($("#question").val()) == 0){
		alert("진행중인 만족도조사가 없습니다.");
        return false;
	}

	let idx = 1;
	while(idx <= Number($("#question").val())){ 

		if (!$("input:radio[name=askno"+idx+"]").is(":checked")) {
        	alert("만족도조사 "+idx+"번 질문을 선택하세요.");
        	$("input:radio[name=askno"+idx+"]:eq(0)").focus();
        	return false;
    	}

		if ($("input:radio[name=askno"+idx+"]:checked").val() == "4"
			|| $("input:radio[name=askno"+idx+"]:checked").val() == "5"){
			if($("#answer"+idx).val() == "") {
        		alert("만족도조사 "+idx+"번 질문의 의견을 입력하세요.");
        		$("#answer"+idx).focus();
        		return false;
			}
    	}

		idx++; 
	}
    
	return true;
}

</script>
