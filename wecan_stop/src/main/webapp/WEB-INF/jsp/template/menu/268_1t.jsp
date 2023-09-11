<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>

function submit(){

	if(checkForm()){
		$.ajax({
			type: "POST"
			,url: "/frontsys/prequery/prequeryResult.html"
		    ,data: $("#PrequeryVO").serialize()
		    ,dataType: "json"
			,async: false
		    ,success: function(data){
		    	if(data.resultCode == "success"){
					alert("사전질의가 제출되었습니다.");
					location.href="/?menuno=246";
		        }else{
		        	alert("사전질의 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
		       	}
		    },error: function(data){
		       	alert("사전질의 처리중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
		    } 
		});
	}
}

function checkForm(){
	if(!$("input:radio[name=prequery1]").is(":checked")){
		alert("사전질의 1번 항목을 선택하세요.");
		$("input:radio[name=prequery1]:eq(0)").focus();
		return false;
	}
	if(!$("#num2_1").is(":checked")
		&&!$("#num2_2").is(":checked")
		&&!$("#num2_3").is(":checked")
		&&!$("#num2_4").is(":checked")
		&&!$("#num2_5").is(":checked")
		&&!$("#num2_6").is(":checked")
		&&!$("#num2_7").is(":checked")
		&&!$("#num2_8").is(":checked")){
		alert("사전질의 2번 항목을 선택하세요.");
		$("#num2_1").focus();
		return false;
	}
	if($("#num2_8").is(":checked")){
		if($("#prequery2_8_opinion").val() == ""){
			alert("사전질의 2번 항목 내용을 입력하세요.");
			$("#prequery2_8_opinion").focus();
			return false;
		}
	}
	if(!$("input:radio[name=prequery3]").is(":checked")){
		alert("사전질의 3번 항목을 선택하세요.");
		$("input:radio[name=prequery3]:eq(0)").focus();
		return false;
	}
	if($("input[name=prequery3]:checked").val() == "1"){
	if($("#prequery4_1").val() == ""){
		alert("사전질의 4번 항목을 입력하세요.");
		$("#prequery4_1").focus();
		return false;
	}
	if($("#prequery4_2").val() == ""){
		alert("사전질의 4번 항목을 입력하세요.");
		$("#prequery4_2").focus();
		return false;
	}
	if(!$("input:radio[name=prequery5]").is(":checked")){
		alert("사전질의 5번 항목을 선택하세요.");
		$("input:radio[name=prequery5]:eq(0)").focus();
		return false;
	}
	if($("input[name=prequery5]:checked").val() == "8"){
		if($("#prequery5_8_opinion").val() == ""){
			alert("사전질의 5번 항목 내용을 입력해주세요.");
			$("#prequery5_8_opinion").focus();
			return false;
		}
	}
	if(!$("#num6_1_1").is(":checked")
		&&!$("#num6_1_2").is(":checked")
		&&!$("#num6_1_3").is(":checked")
		&&!$("#num6_1_4").is(":checked")
		&&!$("#num6_1_5").is(":checked")
		&&!$("#num6_1_6").is(":checked")
		&&!$("#num6_1_7").is(":checked")
		&&!$("#num6_1_8").is(":checked")){
		alert("사전질의 6번 항목을 선택하세요.");
		$("#num6_1_1").focus();
		return false;
	}
	if($("#num6_1_3").is(":checked")){
		if(!$("input:radio[name=num6_1_3_1]").is(":checked")){
			alert("유급 또는 무급을 선택하세요.");
			$("input:radio[name=num6_1_3_1]:eq(0)").focus();
			return false;
		}
	}
	if($("#num6_1_7").is(":checked")){
		if($("#prequery6_1_7_opinion").val() == ""){
			alert("사전질의 6번 항목 내용을 입력하세요.");
			$("#prequery6_1_7_opinion").focus();
			return false;
		}
	}
	if(!$("#num6_2_1").is(":checked")
		&&!$("#num6_2_2").is(":checked")
		&&!$("#num6_2_3").is(":checked")
		&&!$("#num6_2_4").is(":checked")
		&&!$("#num6_2_5").is(":checked")
		&&!$("#num6_2_6").is(":checked")
		&&!$("#num6_2_7").is(":checked")){
		alert("사전질의 6-2번 항목을 선택하세요.");
		$("#num6_2_1").focus();
		return false;
	}
	if($("#num6_2_6").is(":checked")){
		if($("#prequery6_2_6_opinion").val() == ""){
			alert("사전질의 6-2번 항목 내용을 입력하세요.");
			$("#prequery6_2_6_opinion").focus();
			return false;
		}
	}
	if($("#num6_2_1").is(":checked")
		&&!$("#num6_2_1_1").is(":checked")
		&&!$("#num6_2_1_2").is(":checked")
		&&!$("#num6_2_1_3").is(":checked")
		&&!$("#num6_2_1_4").is(":checked")
		&&!$("#num6_2_1_5").is(":checked")
		&&!$("#num6_2_1_6").is(":checked")){
		alert("사전질의 6-2-1번 항목을 선택하세요.");
		$("#num6_2_1_1").focus();
		return false;
	}
	if($("#num6_2_1_6").is(":checked")){
		if($("#prequery6_2_1_6_opinion").val() == ""){
			alert("사전질의 6-2-1번 항목 내용을 입력하세요.");
			$("#prequery6_2_1_6_opinion").focus();
			return false;
		}
	}
	if(!$("#num6_3_1").is(":checked")
		&&!$("#num6_3_2").is(":checked")
		&&!$("#num6_3_3").is(":checked")
		&&!$("#num6_3_4").is(":checked")){
		alert("사전질의 6-3번 항목을 선택하세요.");
		$("#num6_3_1").focus();
		return false;
	}
	if($("#num6_3_1").is(":checked")){
		if(!$("input:radio[name=num6_3_1_1]").is(":checked")){
			alert("전수조사 또는 사건 관련 부서 / 인원 대상을 선택하세요.");
			$("input:radio[name=num6_3_1_1]:eq(0)").focus();
			return false;
		}
	}
	if($("#num6_3_3").is(":checked")){
		if($("#prequery6_3_3_opinion").val() == ""){
			alert("사전질의 6-3번 항목 내용을 입력하세요.");
			$("#prequery6_3_3_opinion").focus();
			return false;
		}
	}
	if(!$("input:radio[name=prequery7]").is(":checked")){
		alert("사전질의 7번 항목을 선택하세요.");
		$("input:radio[name=prequery7]:eq(0)").focus();
		return false;
	}
	if($("input[name=prequery7]:checked").val() == "4"){
		if($("#prequery7_4_opinion").val() == ""){
			alert("사전질의 7번 항목 내용을 입력해주세요.");
			$("#prequery7_4_opinion").focus();
			return false;
		}
	}
	}
	if(!$("input:radio[name=prequery8]").is(":checked")){
		alert("사전질의 8번 항목을 선택하세요.");
		$("input:radio[name=prequery8]:eq(0)").focus();
		return false;
	}
	if($("#text09_1_1").val() == ""
		|| $("#text09_1_2").val() == ""
		|| $("#text09_1_3").val() == ""
		|| $("#text09_1_4").val() == ""){
		alert("사전질의 9번 항목 성고충 상담원을 입력하세요.");
		$("#text09_1_1").focus();
		return false;
	}
	if($("#text09_2_1").val() == ""
		|| $("#text09_2_2").val() == ""
		|| $("#text09_2_3").val() == ""){
		alert("사전질의 9번 항목 성희롱고충심의위원회를 입력하세요.");
		$("#text09_2_1").focus();
		return false;
	}
	if($("#text10_1_1").val() == ""
		|| $("#text10_1_2").val() == ""
		|| $("#text10_1_3").val() == ""
		|| $("#text10_1_4").val() == ""){
		alert("사전질의 10번 항목 남성을 입력하세요.");
		$("#text10_1_1").focus();
		return false;
	}
	if($("#text10_2_1").val() == ""
		|| $("#text10_2_2").val() == ""
		|| $("#text10_2_3").val() == ""
		|| $("#text10_2_4").val() == ""){
		alert("사전질의 10번 항목 여성을 입력하세요.");
		$("#text10_2_1").focus();
		return false;
	}
	if($("#text10_3_1").val() == ""
		|| $("#text10_3_2").val() == ""
		|| $("#text10_3_3").val() == ""
		|| $("#text10_3_4").val() == ""){
		alert("사전질의 10번 항목 합계를 입력하세요.");
		$("#text10_3_1").focus();
		return false;
	}
	if($("#text10_4_1").val() == ""
		|| $("#text10_4_2").val() == ""
		|| $("#text10_4_3").val() == ""
		|| $("#text10_4_4").val() == ""){
		alert("사전질의 10번 항목 성비를 입력하세요.");
		$("#text10_4_1").focus();
		return false;
	}
	if($("#prequery11").val() == ""){
		alert("사전질의 11번 항목을 입력하세요.");
		$("#prequery11").focus();
		return false;
	}
	if(!$("input:radio[name=chk12_1]").is(":checked")){
		alert("사전질의 12번 항목을 선택하세요.");
		$("input:radio[name=chk12_1]:eq(0)").focus();
		return false;
	}
	if(!$("input:radio[name=chk12]").is(":checked")){
		alert("사전질의 12번 항목을 선택하세요.");
		$("input:radio[name=chk12]:eq(0)").focus();
		return false;
	}
	return true;
}

</script>
