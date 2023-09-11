<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>

$(document).on("change", "input[name='origin']:radio", function(){
	var $target = $("#county");
	$target.children('option:not(:first)').remove();
	var origin = $("input[name='origin']:checked").val();	
	$.ajax({
		type: "POST"
		,url: "/getCountyList.html"
	    ,data: "origin="+origin
	    ,dataType: "json"
		,async: false
	    ,success: function(data){
			var countyList = data.countyList;
	    	if(countyList != null && countyList.length > 0){
				$(countyList).each(function(i){
					if(countyList.length == 1){
						$target.append('<option value="'+countyList[i].code+'" selected="selected">'+countyList[i].codeNm+'</option>');
					}else{
						$target.append('<option value="'+countyList[i].code+'">'+countyList[i].codeNm+'</option>');
					}
				});
	        }else{
	        	alert("지역시군구 조회중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	        }
	     },error: function(data){
	        alert("지역시군구 조회중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	     }        
	 });
});

function goNext(){
 	if (checkForm()){
		$("#region").val($("#county").val());
		$.ajax({
			type: "POST"
			,url: "/frontsys/counsel/insertCounsel.html"
	    	,data: $("#frm").serialize()
	    	,dataType: "json"
			,async: false
	    	,success: function(data){
	    		if(data.resultCode == "success"){
		        	 $.ajax({
						type: "POST"
						,url: "/frontsys/chat/insertChat.html"
						,data: $("#frm").serialize()
	    				,dataType: "json"
	    				,success: function(data){
	    					if(data.resultCode == "success"){
		        				location.href =	"/?menuno=239";
	        				}else{
	        					alert("상담 등록중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	       					}
	    				},error: function(data){
	       					alert("상담 등록중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	    				}        
	 				});		
	        	}else{
	        		alert("상담전 입력사항 등록중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	       		}
	    	},error: function(data){
	       		alert("상담전 입력사항 등록중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	    	}        
	 	});
	}

}

function checkForm() {
	if (!$("input:radio[name=gender]").is(":checked")) {
        alert("성별을 입력하세요.");
        $("input:radio[name=gender]:eq(0)").focus();
        return false;
    }
    
    if (!$("input:radio[name=nation]").is(":checked")) {
        alert("국적을 선택하세요.");
        $("input:radio[name=nation]:eq(0)").focus();
        return false;
    }
    
    if (!$("input:radio[name=relation]").is(":checked")) {
        alert("피해자와의 관계를 선택하세요.");
        $("input:radio[name=relation]:eq(0)").focus();
        return false;
    }
    
    if (!$("input:radio[name=age]").is(":checked")) {
        alert("피해자 연령을 선택하세요.");
        $("input:radio[name=age]:eq(0)").focus();
        return false;
    }
    
    if ($("input:radio[name=origin]").is(":checked") && $("#county option:selected").val() == "") {
   	 	alert("지역 시군구를 선택하세요.");
        $("#county").focus();
        return false;
    }
    
    if (!$("input:radio[name=type]").is(":checked")) {
        alert("상담 유형을 선택하세요.");
        $("input:radio[name=type]:eq(0)").focus();
        return false;
    }

	if (!$("#agree_check").is(":checked")) {
        alert("상담 유의사항을 확인후 동의해 주세요.");
        $("#agree_check").focus();
        return false;
    }
    
	return true;
}

</script>

