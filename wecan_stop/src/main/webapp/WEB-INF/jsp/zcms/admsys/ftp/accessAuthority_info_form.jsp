<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<ul class="homepagebbs">
	<li class="bg"><h3 class="sub">접근권한 등록</h3>
	<li>
		<!-- 컨텐츠 영역 -->
		<div class="counsel_wrap">
			<div>
				<div class="title_wrap">
					<h4 class="dot">사용자 정보</h4>
				</div>
				<table>
					<caption>사용자 정보</caption>
					<colgroup>
						<col style="width:150px;">
						<col style="width:345px;">
						<col style="width:150px;">
						<col style="width:auto;">
					</colgroup>
					<tbody>
						<tr>
							<th>아이디</th>
							<td colspan="3">
								<div class="input_box">
									<input type="text" id="userId" name="userId" value="" style="width:270px;">
									<input type="hidden" id="userName" name="userName" value="">	
								</div>
								<span class="btn_wrap">
									<a href="javascript:openUserPop();" class="btn">검색</a>
								</span>
							</td>
						</tr>
						<tr>
							<th>이름</th>
							<td id="userName_td1"></td>
						</tr>
						<tr>
							<th>권한유형</th>
							<td colspan="3">
								<select id="permission_type" name="permission_type">
									<option value="">선택해주세요</option>
									<option value="P1">권한부여</option>
<%-- 									<option value="P2">권한변경</option> --%>
									<option value="P3">권한말소</option>						
								</select>
							</td>
						</tr>
						<tr>
							<th>신청사유</th>
							<td colspan="3">
								<input type="text" id="reason" name="reason" value="" style="width:500px;">
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<caption>권한</caption>
					<colgroup>
						<col style="width:150px;">
						<col style="width:345px;">
						<col style="width:150px;">
						<col style="width:auto;">
					</colgroup>
					<tbody>
						<tr>
							<th rowspan="2">권한</th>
							<td colspan="3">
								<div class="input_box">
									<span class="input_radio">
										<input type="radio" name="approve" id="approve" checked="checked">
										<label for="approve" class="on">승인</label>
									</span>
								</div>
								<div class="input_box">
									<span class="txt">- 권한 그룹</span>
									<select id="URLINFO" name="URLINFO" style="min-width:120px">
										<option value="">선택하세요</option>
										<c:forEach items="${list}" var="each" varStatus="loop">
											<option value="${each.URLNO}/${each.URLTITLE}">${each.URLTITLE}</option>
										</c:forEach>	
									</select>
								</div>
							</td>
						</tr>
						<!--<tr>
							<td colspan="3">
								<div class="input_box">
									<span class="input_radio">
										<input type="radio" name="approve" id="reject">
										<label for="reject">반려</label>
									</span>
								</div>
								<div class="input_box">
									<span class="txt">- 사유</span>
							  		<input type="text" style="width:645px">
								</div>
							</td>
						</tr>-->
						<tr>
							<th>승인자ID</th>
							<td><c:out value="${userId}" /></td>
							<th>승인일시</th>
							<td>
								<jsp:useBean id="now" class="java.util.Date" />
								<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="today" />
								<c:out value="${today}" />
							</td>
						</tr>
					</tbody>
				</table>
				<div class="set_permissions">
					<div class="title_wrap">
						<h4 class="dot">권한 설정</h4>
					</div>
					<table>
						<caption>권한 설정</caption>
						<colgroup>
							<col style="width:200px;">
							<col style="width:auto;">
						</colgroup>
						<tbody>
							<tr>
								<th>개인정보처리시스템</th>
								<td>
 									<div class="input_box">
 										<input type="checkbox" name="permissions01" id="chk_permissions01" value="FNTYP_1">
										<label for="chk_permissions01" class="on">조회/등록/수정</label>
 									</div>
									<div class="input_box" id="inputBoxPermissions02">	
										<input type="checkbox" name="permissions02" id="chk_permissions02" value="FNTYP_2">
										<label for="chk_permissions02" class="on">삭제</label>
									</div>
									<div class="input_box" id="inputBoxPermissions05">
										<input type="checkbox" name="permissions05" id="chk_permissions05" value="FNTYP_5">
										<label for="chk_permissions05" class="on">복원</label>
									</div>
									<div class="input_box">
										<input type="checkbox" name="permissions03" id="chk_permissions03" value="FNTYP_3">
										<label for="chk_permissions03" class="on">인쇄</label>
									</div>
									<div class="input_box">
										<input type="checkbox" name="permissions04" id="chk_permissions04" value="FNTYP_4">
										<label for="chk_permissions04" class="on">다운로드</label>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn_wrap align_center">
					<a href="javascript:void(0);" id="action_list" class="btn">목록</a>
					<a href="javascript:void(0);" id="action_registration_data" class="btn">등록</a>
				</div>
			</div>
		</div>
		<!-- //컨텐츠 영역 -->
	</li>
</ul>
<script>

	$(function(){
		$("#inputBoxPermissions02").hide();
		$("#inputBoxPermissions05").hide();
	});
	
	var edit_save_flag="edit";
	var mode = '${mode}';
	$(function(){
		if ( mode == 'reg' ) {
			//all enable
			elementsDisabled(true);
			//blank data
		} else if ( mode == 'view' ) {
			//all disable
			elementsDisabled(false);
			$('#authority input').removeAttr('disabled');
			$('#authority select').removeAttr('disabled');
			//fill data
		} else if ( mode == 'edit' ) {
			//all enable
			//fill data			
		}
			
	});

	$("#action_registration_cancel").click(function(){
		if(confirm("취소하시겠습니까?")){
			location.href = "<c:url value='/admsys/ftp/accessAuthority.html' />";
		}
	})

	$("#action_registration_data").click(function(){
		if(reg_validation()){
			if(confirm("등록 하시겠습니까?")){			
				var str = $('#AccessAuthorityVo').serialize();
				console.log("reg:"+str);
				$.ajax({
					  type: 'POST',
					  url: "/admsys/ftp/accessAuthority_registration.html",
					  data: str,
					  success: function(result){
						  if ( result.retStatus == "SUCCESS" ) {
							  alert("등록 하였습니다.");
						  } else {
							  alert("등록에 실패 하였습니다. "+result.retMessage);
						  }
					  },
					  error:function(){
						  alert("등록중 오류가 발생하였습니다.");  
					  }
				})
			}
		}
	})
	
	$("#action_list").click(function(){
		if(confirm("목록으로 이동하시겠습니까?")){
			location.href = "<c:url value='/admsys/ftp/accessAuthority.html' />";
		}
	})
	
	$("#URLINFO").on("change", function(){
		$("#chk_permissions01").prop("checked",false);
		$("#chk_permissions02").prop("checked",false);
		$("#chk_permissions03").prop("checked",false);
		$("#chk_permissions04").prop("checked",false);
		$("#chk_permissions05").prop("checked",false);
		  
		var urlInfoArr = $(this).val().split("/");
	    if(urlInfoArr[0] == 44
	    	|| urlInfoArr[0] == 45
	    	|| urlInfoArr[0] == 46
	    	|| urlInfoArr[0] == 49
	    	|| urlInfoArr[0] == 50
	    	|| urlInfoArr[0] == 52
	    	|| urlInfoArr[0] == 54
	    	|| urlInfoArr[0] == 55
	    	|| urlInfoArr[0] == 94){
	    	$("#inputBoxPermissions02").show();
	    }else{
	    	$("#inputBoxPermissions02").hide();
	    }
	    
	    if(urlInfoArr[0] == 46
	    	|| urlInfoArr[0] == 52){
	    	$("#inputBoxPermissions05").show();
	    }else{
	    	$("#inputBoxPermissions05").hide();
	    }
	});

  function openUserPop(){
		PopupCenter('/admsys/consultingmng/userPop.html?mode=POP', 'popupSearchUserList','500','700');
  }
  
  function setUserInfo(userid, userName, counselorName){
	  	$("#userId").val(userid);
		$("#userName").val(userName);
		$("#userName_td1").text(userName);
  }
  
  function elementsDisabled(disabled) {
		if ( disabled == false ) {
			$('#contents input').attr('disabled', 'disabled');
			$('#contents select').attr('disabled', 'disabled');
		} else if ( disabled == true ) {
			$('#contents input').removeAttr('disabled');
			$('#contents select').removeAttr('disabled');
		}
		
	}
  
  function reg_validation(){
	  if($("#userId").val().trim() == ""){
		  alert("아이디를 조회해주세요.");
		  return false;
	  }
	  if($("#permission_type").val() == ""){
		  alert("권한유형을 선택해주세요.");
		  return false;
	  }
	  if($("#reason").val().trim() == ""){
		  alert("사유를 입력해주세요.");
		  return false;
	  }
	  if($("#URLINFO").val() == ""){
		  alert("권한그룹을 선택해주세요.");
		  return false;
	  }
	  var urlInfoArr = $("#URLINFO").val().split("/");
	  if(urlInfoArr[0] == 44
		    || urlInfoArr[0] == 45
		    || urlInfoArr[0] == 49
		    || urlInfoArr[0] == 50
		    || urlInfoArr[0] == 54
		    || urlInfoArr[0] == 55){
		  if($("#chk_permissions01").is(':checked') == false
				&& $("#chk_permissions02").is(':checked') == false
				&& $("#chk_permissions03").is(':checked') == false
				&& $("#chk_permissions04").is(':checked') == false){
			  alert("권한설정을 선택해주세요.");
			  return false;
		  }
	  }else if(urlInfoArr[0] == 46
		    	|| urlInfoArr[0] == 52){
		  if($("#chk_permissions01").is(':checked') == false
				&& $("#chk_permissions02").is(':checked') == false
				&& $("#chk_permissions05").is(':checked') == false
				&& $("#chk_permissions03").is(':checked') == false
				&& $("#chk_permissions04").is(':checked') == false){
			  alert("권한설정을 선택해주세요.");
			  return false;
		  }
	  }else{
		  if($("#chk_permissions01").is(':checked') == false
				&& $("#chk_permissions03").is(':checked') == false
				&& $("#chk_permissions04").is(':checked') == false){
			  alert("권한설정을 선택해주세요.");
			  return false;
		  }
	  }
	  return true;
  }

</script>