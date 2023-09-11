<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<ul class="homepagebbs">
	<li class="bg"><h3 class="sub">위원 관리 등록</h3>
	<li>
		<div class="main_table" style="min-height:400px;">
			
			<input type="hidden" name="counselNum" value="${data.counselNum}" />
			
			<!--위원 등록 영역-->
			<table class="main_table1" summary="위원 관리 등록 항목을 보여줍니다.">
				<tr>
					<td style="width:100px;text-align:right;">위원성명</td>
					<td style="text-align:left;">
						<input style="width:200px;" type="text" name="counselName" value="${data.counselName}"/>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">소속기관</td>
					<td style="text-align:left;"><input style="width:200px;" type="text" name="org" value="${data.org}"/></td>
				</tr>
				<tr>
					<td style="text-align:right;">활동지역</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" name="region" id="region">
							<option value="0">선택해주세요</option>
							<option value="서울특별시">서울특별시</option>
							<option value="부산광역시">부산광역시</option>
							<option value="대구광역시">대구광역시</option>
							<option value="대구광역시">대구광역시</option>
							<option value="광주광역시">광주광역시</option>
							<option value="대전광역시">대전광역시</option>
							<option value="울산광역시">울산광역시</option>
							<option value="세종특별자치시">세종특별자치시</option>
							<option value="제주특별자치도">제주특별자치도</option>
							<option value="강원도">강원도</option>
							<option value="경기도">경기도</option>
							<option value="경상남도">경상남도</option>
							<option value="경상북도">경상북도</option>
							<option value="전라북도">전라북도</option>
							<option value="전라남도">전라남도</option>
							<option value="충청남도">충청남도</option>
							<option value="충청북도">충청북도</option>
						</select>
					</td>
				</tr>		
				<tr>
					<td style="text-align:right;">최초활동일</td>
					<td style="text-align:left;">
						<fmt:parseDate value="${data.startDt}" pattern="yyyy-MM-dd" var="icd" />
						<input type="date" id="startDt" name="startDt" value="<fmt:formatDate type="both" value="${icd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
					</td>
				</tr>		
				<tr>
					<td style="text-align:right;">활동여부</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" name="actYn" id="actYn">
							<option value="">선택해주세요</option>
							<option value="Y">활동</option>
							<option value="N">비활동</option>
						</select>
					</td>
				</tr>	
				<tr>
					<td style="width:100px;text-align:right;">연락처</td>
					<td style="text-align:left;">
						<input style="width:200px;" type="text" name="phoneNum" value="${data.phoneNum}"/>
					</td>
				</tr>
				<tr>
					<td style="width:100px;text-align:right;">등록일</td>
					<td style="text-align:left;" id="regDt">
						&nbsp;
						<span id="year"></span>
						<span class="point">-</span>								
<!-- 								<span id="day"></span> -->
						<span id="month"></span>
						<span class="point">-</span>
						<span id="date"></span>
						&nbsp;&nbsp;
						<span class="txt_lg" id="hours"></span>
						<span class="mark">:</span>
						<span class="txt_lg" id="min"></span>
						<span class="mark">:</span>								
						<span class="txt_sm" id="sec"></span>
					</td>
				</tr>							
			
			</table>
			<!--/위원 등록 영역-->
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
	var mode = '${mode}';console.log(mode);
	$(function(){
		
		if ( mode == 'reg' ) {
			//all enable
			elementsDisabled(true);
			setInterval(clockStart,1000);
			//blank data
		} else if ( mode == 'view' ) {
			var regDt = '${data.regDt}';
			regDt = regDt.replace('.0','');
			$('#regDt').text(regDt);
			//all disable
			elementsDisabled(false);
			//fill data
		} else if ( mode == 'edit' ) {
			//all enable
			//fill data
		} else {
			//???
		}
		
		var actYn = '${data.actYn}';
		if(actYn == 'Y'){
			$("#actYn").val("Y").prop("selected", true);
		}else if(actYn == 'N'){
			$("#actYn").val("N").prop("selected", true);
		}
		
		var region = '${data.region}';
			$("#region").val(region).prop("selected", true);
			
	});

	$("#action_registration_cancel").click(function(){
		if(confirm("취소하시겠습니까?")){
			if(mode == 'reg'){
				location.href = "<c:url value='/admsys/orgculturedigmng/commmng.html' />";
			}else if(mode == 'view'){
				location.href = "<c:url value='/admsys/orgculturedigmng/commmng.html' />";
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
				var str = $('#WCounselorVo').serialize();
				console.log(str);
				$.ajax({
					  type: 'POST',
					  url: "/admsys/orgculturedigmng/commmng_update.html",
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
			var str = $('#WCounselorVo').serialize();
			console.log("reg:"+str);
			$.ajax({
				  type: 'POST',
				  url: "/admsys/orgculturedigmng/commmng_registration.html",
				  data: str,
				  success: function(result){
					  if ( result.retStatus == "SUCCESS" ) {
						  alert("등록 하였습니다.");console.log("AAA:"+result.no);
						  var lastInsertNo = result.no;
						  viewDetailPage(lastInsertNo);
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
	
	// 등록일 시계
		function clockStart() {
		var today = new Date()
		var dayList = ['sunday', 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday']
		var hh = addZero(today.getHours())
		var mm = addZero(today.getMinutes())
		var ss = addZero(today.getSeconds())
		var YY = today.getFullYear()
		var MM = today.getMonth()+1
		var DD = today.getDate()
		//var dd = dayList[today.getDay()].toUpperCase()
		document.getElementById('hours').innerText = hh
		document.getElementById('min').innerText = mm
		document.getElementById('sec').innerText = ss
		document.getElementById('month').innerText = MM
		document.getElementById('date').innerText = DD
		document.getElementById('year').innerText = YY
		//document.getElementById('day').innerText = dd
		
		function addZero(num) {
			return (num < 10 ? '0'+num : ''+num)
		}
		
	}



</script>