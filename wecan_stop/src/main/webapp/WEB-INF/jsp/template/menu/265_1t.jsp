<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>
	
	function submit(){	
		if(checkForm()){
			$.ajax({
				type: "POST"
				,url: "/frontsys/survey/cSurveyResult.html"
		    	,data: $("#ZSurveyResultVo").serialize()
		    	,dataType: "json"
				,async: false
		    	,success: function(data){
		    		if(data.resultCode == "success"){
		    			alert("설문조사가 제출되었습니다.");
		    			location.href = "/?menuno=246";
		        	}else{
		        		alert("설문조사 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
		       		}
		    	},error: function(data){
		       		alert("설문조사 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
		    	} 
		 	});
		}
		
	}
	
	function checkForm() {
		if(!$('input:radio[name=askno0]').is(':checked')){
			alert("선문 1번 항목을 선택하세요.");
			$('input:radio[name=askno0]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno1_1]').is(':checked')){
			alert("설문조사 1_1번 항목을 선택하세요.");
			$('input:radio[name=askno1_1]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno1_2]').is(':checked')){
			alert("설문조사 1_2번 항목을 선택하세요.");
			$('input:radio[name=askno1_2]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno1_3]').is(':checked')){
			alert("설문조사 1_3번 항목을 선택하세요.");
			$('input:radio[name=askno1_3]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno1_4]').is(':checked')){
			alert("설문조사 1_4번 항목을 선택하세요.");
			$('input:radio[name=askno1_4]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno2_1]').is(':checked')){
			alert("설문조사 2_1번 항목을 선택하세요.");
			$('input:radio[name=askno2_1]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno2_2]').is(':checked')){
			alert("설문조사 2_2번 항목을 선택하세요.");
			$('input:radio[name=askno2_2]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno2_3]').is(':checked')){
			alert("설문조사 2_3번 항목을 선택하세요.");
			$('input:radio[name=askno2_3]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno2_4]').is(':checked')){
			alert("설문조사 2_4번 항목을 선택하세요.");
			$('input:radio[name=askno2_4]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno3_1]').is(':checked')){
			alert("설문조사 3_1번 항목을 선택하세요.");
			$('input:radio[name=askno3_1]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno3_2]').is(':checked')){
			alert("설문조사 3_2번 항목을 선택하세요.");
			$('input:radio[name=askno3_2]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno3_3]').is(':checked')){
			alert("설문조사 3_3번 항목을 선택하세요.");
			$('input:radio[name=askno3_3]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno3_4]').is(':checked')){
			alert("설문조사 3_4번 항목을 선택하세요.");
			$('input:radio[name=askno3_4]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno3_5]').is(':checked')){
			alert("설문조사 3_5번 항목을 선택하세요.");
			$('input:radio[name=askno3_5]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno4_1]').is(':checked')){
			alert("설문조사 4_1번 항목을 선택하세요.");
			$('input:radio[name=askno4_1]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno4_2]').is(':checked')){
			alert("설문조사 4_2번 항목을 선택하세요.");
			$('input:radio[name=askno4_2]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno4_3]').is(':checked')){
			alert("설문조사 4_3번 항목을 선택하세요.");
			$('input:radio[name=askno4_3]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno4_4]').is(':checked')){
			alert("설문조사 4_4번 항목을 선택하세요.");
			$('input:radio[name=askno4_4]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno5_1]').is(':checked')){
			alert("설문조사 5_1번 항목을 선택하세요.");
			$('input:radio[name=askno5_1]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno5_2]').is(':checked')){
			alert("설문조사 5_2번 항목을 선택하세요.");
			$('input:radio[name=askno5_2]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno5_3]').is(':checked')){
			alert("설문조사 5_3번 항목을 선택하세요.");
			$('input:radio[name=askno5_3]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno5_4]').is(':checked')){
			alert("설문조사 5_4번 항목을 선택하세요.");
			$('input:radio[name=askno5_4]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno5_5]').is(':checked')){
			alert("설문조사 5_5번 항목을 선택하세요.");
			$('input:radio[name=askno5_5]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno6_1]').is(':checked')){
			alert("설문조사 6_1번 항목을 선택하세요.");
			$('input:radio[name=askno6_1]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno6_2]').is(':checked')){
			alert("설문조사 6_2번 항목을 선택하세요.");
			$('input:radio[name=askno6_2]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno6_3]').is(':checked')){
			alert("설문조사 6_3번 항목을 선택하세요.");
			$('input:radio[name=askno6_3]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno6_4]').is(':checked')){
			alert("설문조사 6_4번 항목을 선택하세요.");
			$('input:radio[name=askno6_4]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno6_5]').is(':checked')){
			alert("설문조사 6_5번 항목을 선택하세요.");
			$('input:radio[name=askno6_5]:eq(0)').focus();
			return false;
		}
		
		if(!$("#num8_1_1").is(":checked")
			&&!$("#num8_1_2").is(":checked")
			&&!$("#num8_1_3").is(":checked")
			&&!$("#num8_1_4").is(":checked")
			&&!$("#num8_1_5").is(":checked")
			&&!$("#num8_1_6").is(":checked")
			&&!$("#num8_1_7").is(":checked")
			&&!$("#num8_1_8").is(":checked")){
			alert("설문조사 7번 항목을 선택하세요.");
			$("#num8_1_1").focus();
			return false;
		}
		
		if($("#num8_1_7").is(":checked")
				&& $("#askno7opinion").val() == ""){
			alert("설문조사 7번 항목 의견을 입력하세요.");
			$("#askno7opinion").focus();
			return false;
		}
		
		if(!$("#num8_1_8").is(":checked")){
		
			if(!$('input:radio[name=askno7_1_1]').is(':checked')){
				alert("설문조사 7_1번 항목을 선택하세요.");
				$('input:radio[name=askno7_1_1]:eq(0)').focus();
				return false;
			}
		
			if($("input[name=askno7_1_1]:checked").val() == "6"){
				if($("#askno7_1_1opinion").val() == ""){
					alert("설문조사 7_1번 항목 의견을 입력해주세요.");
					$("#askno7_1_1opinion").focus();
					return false;
				}
			}
		
			if(!$('input:radio[name=askno7_2_1]').is(':checked')){
				alert("설문조사 7_2번 항목을 선택하세요.");
				$('input:radio[name=askno7_2_1]:eq(0)').focus();
				return false;
			}
		
			if($("input[name=askno7_2_1]:checked").val() == "7"){
				if($("#askno7_2_1opinion").val() == ""){
					alert("설문조사 7_2번 항목 의견을 입력해주세요.");
					$("#askno7_2_1opinion").focus();
					return false;
				}
			}
		
			if(!$('input:radio[name=askno8]').is(':checked')){
				alert("설문조사 8번 항목을 선택하세요.");
				$('input:radio[name=askno8]:eq(0)').focus();
				return false;
			}
		}
		
		if(!$('input:radio[name=askno9]').is(':checked')){
			alert("설문조사 9번 항목을 선택하세요.");
			$('input:radio[name=askno9]:eq(0)').focus();
			return false;
		}
		
		if(!$("#num10_1").is(":checked")
			&&!$("#num10_2").is(":checked")
			&&!$("#num10_3").is(":checked")
			&&!$("#num10_4").is(":checked")
			&&!$("#num10_5").is(":checked")
			&&!$("#num10_6").is(":checked")
			&&!$("#num10_7").is(":checked")
			&&!$("#num10_8").is(":checked")){
			alert("설문조사 10번 항목을 선택하세요.");
			$("#num10_1").focus();
			return false;
		}
		
		if($("#num10_7").is(":checked")
				&& $("#askno10opinion").val() == ""){
			alert("설문조사 10번 항목 의견을 입력하세요.");
			$("#askno10opinion").focus();
			return false;
		}
		
		if(!$("#num11_1").is(":checked")
			&&!$("#num11_2").is(":checked")
			&&!$("#num11_3").is(":checked")
			&&!$("#num11_4").is(":checked")
			&&!$("#num11_5").is(":checked")
			&&!$("#num11_6").is(":checked")){
			alert("설문조사 11번 항목을 선택하세요.");
			$("#num11_1").focus();
			return false;
		}
		
		if($("#num11_6").is(":checked")
				&& $("#askno11opinion").val() == ""){
			alert("설문조사 11번 항목 의견을 입력하세요.");
			$("#askno11opinion").focus();
			return false;
		}
		
		if(!$("#num12_1").is(":checked")
			&&!$("#num12_2").is(":checked")
			&&!$("#num12_3").is(":checked")
			&&!$("#num12_4").is(":checked")
			&&!$("#num12_5").is(":checked")){
			alert("설문조사 12번 항목을 선택하세요.");
			$("#num12_1").focus();
			return false;
		}
		
		if($("#num12_5").is(":checked")
				&& $("#askno12opinion").val() == ""){
			alert("설문조사 12번 항목 의견을 입력하세요.");
			$("#askno12opinion").focus();
			return false;
		}
		
		if(!$('input:radio[name=askno14]').is(':checked')){
			alert("배문 1번 항목을 선택하세요.");
			$('input:radio[name=askno14]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno15]').is(':checked')){
			alert("배문 2번 항목을 선택하세요.");
			$('input:radio[name=askno15]:eq(0)').focus();
			return false;
		}
		
		if(!$('input:radio[name=askno16]').is(':checked')){
			alert("배문 3번 항목을 선택하세요.");
			$('input:radio[name=askno16]:eq(0)').focus();
			return false;
		}
		
		return true;
	}
	
	</script>
