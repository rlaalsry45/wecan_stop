<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>
	
	function submit(){	
		if(checkForm()){
			$.ajax({
				type: "POST"
				,url: "/frontsys/satisfaction/cSatisfactionResult.html"
		    	,data: $("#ZSatisfactionResultVo").serialize()
		    	,dataType: "json"
				,async: false
		    	,success: function(data){
		    		if(data.resultCode == "success"){
						alert("만족도 조사를 제출하였습니다.");
						location.href = "/?menuno=246"
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
	    
		if(!$('input:radio[name=askno1]').is(':checked')){
			alert("만족도조사 1번 항목을 선택하세요.");
			$('input:radio[name=askno1]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=askno1]:checked').val() == "6"){
			if($('#askno1opinion').val() == ""){
				alert("만족도조사 1번 항목 기타 의견을 입력하세요.");
				$('#askno1opinion').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=askno2]').is(':checked')){
			alert("만족도조사 2번 항목을 선택하세요.");
			$('input:radio[name=askno2]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=askno2]:checked').val() == "4"
			|| $('input:radio[name=askno2]:checked').val() == "5"){
			if($('#askno2opinion').val() == ""){
				alert("만족도조사 2번 항목 의견을 입력하세요.");
				$('#askno2opinion').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=askno3]').is(':checked')){
			alert("만족도조사 3번 항목을 선택하세요.");
			$('input:radio[name=askno3]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=askno3]:checked').val() == "4"
			|| $('input:radio[name=askno3]:checked').val() == "5"){
			if($('#askno3opinion').val() == ""){
				alert("만족도조사 3번 항목 의견을 입력하세요.");
				$('#askno3opinion').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=askno4]').is(':checked')){
			alert("만족도조사 4번 항목을 선택하세요.");
			$('input:radio[name=askno4]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=askno4]:checked').val() == "4"
			|| $('input:radio[name=askno4]:checked').val() == "5"){
			if($('#askno4opinion').val() == ""){
				alert("만족도조사 4번 항목 의견을 입력하세요.");
				$('#askno4opinion').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=askno5]').is(':checked')){
			alert("만족도조사 5번 항목을 선택하세요.");
			$('input:radio[name=askno5]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=askno5]:checked').val() == "4"
			|| $('input:radio[name=askno5]:checked').val() == "5"){
			if($('#askno5opinion').val() == ""){
				alert("만족도조사 5번항목 의견을 입력하세요.");
				$('#askno5opinion').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=askno6]').is(':checked')){
			alert("만족도조사 6번항목을 선택하세요.");
			$('input:radio[name=askno6]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=askno6]:checked').val() == "4"
			|| $('input:radio[name=askno6]:checked').val() == "5"){
			if($('#askno6opinion').val() == ""){
				alert("만족도조사 6번항목 의견을 입력하세요.");
				$('#askno6opinion').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=askno7]').is(':checked')){
			alert("만족도조사 7번항목을 선택하세요.");
			$('input:radio[name=askno7]:eq(0)').focus();
			return false;
		}
		
		if($('input:radio[name=askno7]:checked').val() == "4"
			|| $('input:radio[name=askno7]:checked').val() == "5"){
			if($('#askno7opinion').val() == ""){
				alert("만족도조사 7번항목 의견을 입력하세요.");
				$('#askno7opinion').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=askno8]').is(':checked')){
			alert("만족도조사 8번항목을 선택하세요.");
			$('input:radio[name=askno8]:eq(0)').focus();
			return false;
		}
		
		return true;
	}
	
	</script>
