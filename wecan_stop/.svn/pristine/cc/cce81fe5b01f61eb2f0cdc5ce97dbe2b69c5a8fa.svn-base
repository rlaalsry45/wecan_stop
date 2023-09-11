<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="homepagebbs">
	<li class="bg"><h3 class="sub">게시판상담 등록</h3>
	<li>
		<div class="main_table" style="min-height:400px;">
			
			<input type="hidden" name="boardNo" value="${data.boardNo}"/>
			
			<!--상담일지 등록 영역-->
			<table class="main_table1" summary="상담일지 등록 항목을 보여줍니다.">
			
				<tr>
					<td style="text-align:right;">제목</td>
					<td style="text-align:left;">
						<span>${data.boardTitle}</span>
					</td>
				</tr>			
				<tr>
					<td style="text-align:right;">작성자</td>
					<td style="text-align:left;">
						<span>${data.boardUsername}</span>
					</td>
				</tr>			
				<tr>
					<td style="text-align:right;">등록일시</td>
					<td style="text-align:left;">
						<span>${data.regDate}</span>
					</td>
				</tr>			
				<tr>
					<td style="text-align:right;">내용</td>
					<td style="text-align:left;">
						<textarea style="width:1180px;height:200px;" name="boardConts" id="boardConts"/>
					</td>
				</tr>
				<tr id="answerTrId" name="answerTr" style="display:none;">
					<td style="text-align:right;">답변</td>
					<td style="text-align:left;">
						<textarea style="width:1150px;height:200px;" name="boardAnswer" id="boardAnswer"/>
					</td>
				</tr>
				<tr name="answerTr" style="display:none;">
					<td style="text-align:right;">상담원</td>
					<td style="text-align:left;">
						<span>${data.boardAnswerId}</span>
					</td>
				</tr>					
			</table>
			<!--/상담일지 등록 영역-->
		</div>
		<!--/main_table-->
		<div class="top_bt">
	       	<a id="action_registration_cancel" class="btmore01" href="javascript:return false;">취소</a>
			<a style="display:none;" id="action_registration_data" class="btmore01" href="javascript:void(0);">등록</a>
			<a id="boardCounsel_action_registration" class="btmore01" href="javascript:void(0);">답변등록</a>
		</div>	   
	</li>
</ul>
<script>

	$(document).ready(function() {
		
	});
	
	if('${data.boardAnswer}'.length != 0){
		$("tr[name=answerTr]").show();
	}
	
	$("#boardCounsel_action_registration").click(function(){
		$('#answerTrId').show();
		$('#answerTrId textarea').removeAttr('disabled');
		$('#boardCounsel_action_registration').hide();
		$('#action_registration_data').show();
		
	});
	
	var edit_save_flag="edit";
	var mode = '${mode}';console.log(mode);
	$(function(){
		if ( mode == 'reg' ) {
			//all enable
			//elementsDisabled(true);
			//blank data
		} else if ( mode == 'view' ) {
			//all disable			
			//elementsDisabled(false);		
			$("#boardConts").attr('disabled','disabled');
			$("#boardAnswer").attr('disabled','disabled');
			$("#boardConts").val('${data.boardConts}');
			$("#boardAnswer").val('${data.boardAnswer}');
		} else if ( mode == 'edit' ) {
			//all enable
			//fill data			
		}
			
	});

	$("#action_registration_cancel").click(function(){
		if(confirm("취소하시겠습니까?")){
			if(mode == 'reg'){
				location.href = "<c:url value='/admsys/cyberCounsel/boardCounsel.html' />";
			}else if(mode == 'view'){
				location.href = "<c:url value='/admsys/cyberCounsel/boardCounsel.html' />";
/* 				elementsDisabled(false);
				$("#action_edit_data").text("수정");
				edit_save_flag = "edit"; */
			}
		}
	})
	
	$("#action_edit_data").click(function(){
		var txtVal = $("#action_edit_data").text();
		
		if(edit_save_flag == 'save') {
			if(confirm("저장 하시겠습니까?")){
				var str = $('#WCounselLogVO').serialize();
				console.log(str);
				$.ajax({
					  type: 'POST',
					  url: "/admsys/cyberCounsel/boardCounsel_registration.html",
					  data: str,
					  success: function(result){
						  if ( result.retStatus == "SUCCESS" ) {
							  alert("수정 하였습니다.");
						  } else {
							  alert("수정에 실패 하였습니다.");
						  }
					  },
					  error:function(){
						  alert("수정중 오류가 발생하였습니다.");  
					  }
				})
			}
		}else if(edit_save_flag == 'edit') {
			if(confirm("수정 하시겠습니까?")){				
				elementsDisabled(true);				
				edit_save_flag="save";
				$("#action_edit_data").text("저장");
			}
		}
	})
	
	
	$("#action_registration_data").click(function(){
		if(confirm("등록 하시겠습니까?")){
			var str = $('#WBoardCounselVo').serialize();
			console.log("reg:"+str);
			$.ajax({
				  type: 'POST',
				  url: "/admsys/cyberCounsel/boardCounsel_registration.html",
				  data: str,
				  success: function(result){
					  if ( result.retStatus == "SUCCESS" ) {
						  alert("등록 하였습니다.");console.log("AAA:"+result.no);
/* 						  var lastInsertNo = result.no;
						  viewDetailPage(lastInsertNo); */
						  location.href = "<c:url value='/admsys/cyberCounsel/boardCounsel.html' />";						  
					  } else {
						  alert("등록에 실패 하였습니다.");
					  }
				  },
				  error:function(){
					  alert("등록중 오류가 발생하였습니다.");  
				  }
			})
		}
	})
	
	function elementsDisabled(disabled) {
		if ( disabled == false ) {
			$('#contents input').attr('disabled', 'disabled');
			$('#contents select').attr('disabled', 'disabled');
			$('#contents textarea').attr('disabled', 'disabled');
		} else if ( disabled == true ) {
			$('#contents input').removeAttr('disabled');
			$('#contents select').removeAttr('disabled');
			$('#contents textarea').removeAttr('disabled');
		}
		
	}


</script>