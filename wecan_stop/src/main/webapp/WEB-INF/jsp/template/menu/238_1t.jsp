<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script src="/var/sha/core.min.js"></script>
<script src="/var/sha/sha256.min.js"></script>

<script>

function goNext(){
	if (checkForm()){
		$("#passwd").val(CryptoJS.SHA256($("#passwd").val()).toString());
		$.ajax({
			type: "POST"
			,url: "/frontsys/board/getBoard.html"
	    	,data: $("#frm").serialize()
	    	,dataType: "json"
			,async: false
	    	,success: function(data){
	    		if(data.resultCode == "success"){
					$("#cDiv").show();
		        	$("#cUsername").text(data.username);
					$("#cTitle").text(data.title);
					$("#cConts").text(data.conts);
					if(data.fileOriginal != null){
						$("#cFile").text(data.fileOriginal);
						$("#cFile_a").attr("href","/frontsys/board/fileDown.html?downFile="+data.fileSave+"&orginFile="+data.fileOriginal); 
					}else{
						$("#cFiledd").hide();
					}
					if(data.add_file1 != null){
						$("#cAnswerFile").text(data.add_file1);
						$("#cAnswerFile_a").attr("href","/frontsys/board/fileDown.html?downFile="+data.add_file1+"&orginFile="+data.add_file1);
					}else{
						$('#cAnswerFiledd').hide();
					}
					if(data.answer != null){
						$("#cAnswer").text(data.answer);
						$(".btn_box").show();
						if(data.satisfactionResultYn == "Y"){
							$("#satisfaction").attr("href","javascript:alert('"+data.resultMsg+"');");
						}else{
							$("#satisfaction").attr("href","/?menuno=245");
						}
					}else{
						$("#cAnswer").text("답변대기중입니다.");
					}
	        	}else{
	        		alert(data.resultMsg+" 담당자에게 문의바랍니다.");
	       		}
	    	},error: function(data){
	       		alert("내글 조회중 오류가 발생했습니다. 담당자에게 문의바랍니다.");
	    	}        
	 	});
	}
}

function checkForm() {
  
	if ($("#username").val() == "") {
        alert("이름을 입력하세요.");
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
    
	return true;
}

</script>

