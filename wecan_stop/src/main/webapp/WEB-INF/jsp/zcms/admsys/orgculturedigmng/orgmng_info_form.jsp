<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<ul class="homepagebbs">
	<li class="bg">
	<h3 class="sub">기관 관리 
	<c:choose>
	<c:when test="${mode eq 'reg'}">등록</c:when>
	<c:when test="${mode ne 'reg'}">수정</c:when>
	</c:choose>
	</h3>
	<li>
		<div class="main_table" style="min-height:300px;">
			<input type="hidden" name="organizationId" value="${data.organizationId}" />
			<!--기관 등록 영역-->
			<table class="main_table1" summary="기관 관리 등록 항목을 보여줍니다.">
				<c:if test="${mode ne 'reg'}">
				<tr>
					<td style="width:100px;text-align:right;">ID</td>
					<td style="text-align:left;">
						${data.organizationId}
					</td>
				</tr>
				</c:if>
				<tr>
					<td style="width:100px;text-align:right;">공공/민간</td>
					<td style="text-align:left;">
						<input type="radio" id="org_type_1" name="org_type" value="gov" <c:if test="${data.org_type eq 'gov'}">checked</c:if>>공공
                        <input type="radio" id="org_type_2" name="org_type" value="priv" <c:if test="${data.org_type eq 'priv'}">checked</c:if>>민간
					</td>
				</tr>
				<tr>
					<td style="width:100px;text-align:right;">기관명</td>
					<td style="text-align:left;">
						<input style="width:200px;" type="text" name="organizationName" id="organizationName" value="${data.organizationName}" maxlength="50"/>
						<input type="hidden" id="organizationCode" name="organizationCode" value="${data.organizationCode}"/>						
						<input type="button" id="srchBtnGov"onclick="openGovSrchPop('gov');" style="cursor: pointer;" value="기관명 검색" style="display:none;">
					</td>
				</tr>
				<c:if test="${mode ne 'reg'}">
				<tr>
					<td style="width:100px;text-align:right;">담당자명</td>
					<td style="text-align:left;">
						<input style="width:200px;" type="text" name="organizationChargename" value="${data.username}" maxlength="50"/>
					</td>
				</tr>
				<tr>
					<td style="width:100px;text-align:right;">이메일</td>
					<td style="text-align:left;">
						<input style="width:200px;" type="text" id="organizationEmail" name="organizationEmail" value="${data.useremail}" style="ime-mode:inactive" maxlength="100"/>
					</td>
				</tr>		
				<tr>
					<td style="width:100px;text-align:right;">연락처</td>
					<td style="text-align:left;">
						<c:set var="telnum" value="${data.usermobile}" />
                        <c:choose>
                        <c:when test="${fn:length(telnum) eq 11}"><c:set var="organizationTelnum" value="${fn:substring(telnum,0,3)}-${fn:substring(telnum,3,7)}-${fn:substring(telnum,7,11)}" /></c:when>
                        <c:when test="${fn:length(telnum) eq 10}"><c:set var="organizationTelnum" value="${fn:substring(telnum,0,3)}-${fn:substring(telnum,3,6)}-${fn:substring(telnum,6,10)}" /></c:when>
                        </c:choose>
						<input style="width:200px;" type="text" id="organizationTelnum" name="organizationTelnum" value="${organizationTelnum}" maxlength="13"/>
					</td>
				</tr>
				</c:if>
				
				<tr>
					<td style="text-align:right;">사용여부</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" name="useYn">
							<option value="Y" <c:if test="${data.useYn eq 'Y'}">selected="selected"</c:if>>사용</option>
							<option value="N" <c:if test="${data.useYn eq 'N'}">selected="selected"</c:if>>미사용</option>
						</select>
					</td>
				</tr>
			</table>
			<!--/기관 등록 영역-->
		</div>
		<!--/main_table-->
		<div class="top_bt">
	       	<a id="action_registration_cancel" class="btmore01" href="javascript:return false;">취소</a>
	       	
	       	<c:choose>
				<c:when test="${mode eq 'reg'}"><a id="action_registration_data" class="btmore01" href="javascript:void(0);">등록</a></c:when>
				<c:when test="${mode ne 'reg'}"><a id="action_edit_data" class="btmore01" href="javascript:void(0);">수정</a></c:when>						
			</c:choose>
		</div>	   
	</li>
</ul>
<script>
	var edit_save_flag="edit";
	$(function(){
		var mode = '${mode}';console.log(mode);
		var srcBtnShowYN = '${data.org_type}';
		
		if ( srcBtnShowYN== 'gov') {
			$("#organizationName").attr("readonly", true);
			$("#srchBtnGov").show();
		} else {
			$("#organizationName").attr("readonly", false);
			$("#srchBtnGov").hide();
		}
		
		if ( mode == 'reg' ) {
			elementsDisabled(true);
			$("#organizationName").attr("readonly", true);
			$("#srchBtnGov").show();
			$("#org_type_1").prop("checked", true);
		} else if ( mode == 'view' ) {
			elementsDisabled(true);
		}
		
		$("#organizationEmail").bind("keyup", function () {
			notKor($(this));
	    });
		
		$("#organizationTelnum").bind("keyup", function () {
			$(this).val($(this).val().replace(/[^0-9]/gi, ""));
			$(this).val(autoHypenPhone($(this).val()));
	    });
		
		$("#action_registration_cancel").click(function(){
			if(confirm("취소하시겠습니까?")){
				location.href = "<c:url value='/admsys/orgculturedigmng/orgmng.html' />";
			}
		});
		
		$("#action_edit_data").click(function(){	
			if(confirm("수정 하시겠습니까?")){
				var str = $('#WOrganizationVo').serialize();
				$.ajax({
					  type: 'POST',
					  url: "/admsys/orgculturedigmng/orgmng_update.html",
					  data: str,
					  success: function(result){
						  if ( result.retStatus == "SUCCESS" ) {
							  alert("수정 하였습니다.");
							  location.href = "<c:url value='/admsys/orgculturedigmng/orgmng.html' />";
						  } else {
							  alert("수정에 실패 하였습니다.");
						  }
					  },
					  error:function(){
						  alert("수정중 오류가 발생하였습니다.");  
					  }
				})
			}
		});
		
		$("#action_registration_data").click(function(){
			if(checkForm()){
				if(confirm("등록 하시겠습니까?")){
					var str = $('#WOrganizationVo').serialize();
					$.ajax({
						  type: 'POST',
						  url: "/admsys/orgculturedigmng/orgmng_registration.html",
						  data: str,
						  success: function(result){
							  if ( result.retStatus == "SUCCESS" ) {
								  alert("등록 하였습니다.");
								  location.href = "<c:url value='/admsys/orgculturedigmng/orgmng.html' />";
							  } else {
								  alert("등록에 실패 하였습니다.");
							  }
						  },
						  error:function(){
							  alert("등록중 오류가 발생하였습니다.");  
						  }
					})
				}
			}
		});
		
		$("input[name='org_type']:radio").change(function(){
			$("#organizationName").val("");
			
			if (  $('input[name=org_type]:checked').val() == 'gov'  ) {				
				$("#organizationName").attr("readonly", true);				
				$("#srchBtnGov").show();
			} else {
				$("#organizationName").attr("readonly", false);
				$("#srchBtnGov").hide();
			}
		});
	});

	
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
	
	function checkForm() {
		with (document.frm) {
			if (typeof(organizationName) != "undefined" && organizationName.value.trim() == "") {
	            alert("기관을 선택하세요.");
	            organizationChargename.focus();
	            return false;
	        }
			
/*	        if (typeof(organizationChargename) != "undefined" && organizationChargename.value.trim() == "") {
	            alert("담당자명을 입력하세요.");
	            organizationChargename.focus();
	            return false;
	        }
	        
	        if (typeof(organizationEmail) != "undefined" && organizationEmail.value.trim() == "") {
	            alert("이메일을 입력하세요.");
	            organizationEmail.focus();
	            return false;
	        }
	        
	        if(!isEmail(organizationEmail.value)){
				alert("이메일형식이 맞지 않습니다.");
				organizationEmail.focus();
	   			return false;
	   		}

	        if (typeof(organizationTelnum) != "undefined" && organizationTelnum.value.trim() == "") {
	            alert("연락처를 입력하세요.");
	            organizationTelnum.focus();
	            return false;
	        }
	        
	        if(!isPhone(organizationTelnum.value)){
				alert("연락처형식이 맞지 않습니다.");
				organizationTelnum.focus();
	   			return false;
	   		}
	        */
	        
	  	 }
		 return true;
	}
	
	function openGovSrchPop(arg1){
		PopupCenter('/admsys/orgculturedigmng/govSearchPop.html?mode=POP&g_type='+arg1, 'popupSearchGovList','500','700');
	}
	
	function setGovInfo(code, name, g_type){
		if ( g_type == 'gov') {
			$("#organizationName").val(name);
			$("#organizationCode").val(code);
		}
	}

</script>