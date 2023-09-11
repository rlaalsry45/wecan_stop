<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/usr/js/20140704_3090836397829049.js"></script>
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<c:if test="${userno eq null }">
	<script type="text/javascript">
		alert("정상적인 접근이 아닙니다.");
		self.close();
	</script>
</c:if>
<script type="text/javascript">
	$(function() {
		//숫자만 입력
		$(".number").bind("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/gi, ""));
		});

		$('.date-pick').datepicker(
				{
					dateFormat : "yymmdd",
					showMonthAfterYear : true,
					dayNamesMin : [ '월', '화', '수', '목', '금', '토', '일' ],
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					changeMonth : true,
					changeYear : true
				});
	});
	
	
	function addwillpaylistForAdmin(work_grade,userno,username,useremail){
		
		var oProductNM = $('#oProductNM2').val();
		var oAmt = $('#oAmt2').val();
		var limitYearMonth = $('#limitYearMonth2').val();
		var isAnnual = "";
		
		if(oProductNM == "정회원 회비" || oProductNM == "종신회원 회비" || oProductNM == "준회원 회비"){
			isAnnual = "1";
			
		}else if(oProductNM == "부회장 임원회비" || oProductNM == "회장 임원회비" | oProductNM == "상임이사 임원회비" || oProductNM == "이사 임원회비"){
			isAnnual = "P";
		}
		
		//if(confirm("연회비 납부를 위한 주문이 리스트에 추가 됩니다. \n추가된후에 결제를 진행해주시면 됩니다. \n연회비 추가를 위한것으로 결제를 하실 경우에는 결제하기를 바로 눌러주시기 바랍니다.\n추가하시겠습니까?")){
		if (confirm('회비내역을 추가하시겠습니까??')) {
			$.ajax({ 
				type: 'post' 
				, async: true 
				, data: "work_grade="+work_grade
				+"&userno="+userno
				+"&username="+username
				+"&useremail="+useremail
				+ "&oProductNM=" + oProductNM
				+ "&limitYearMonth="+ limitYearMonth
				+ "&oAmt="+oAmt
				+ "&isAnnual="+isAnnual
				
				, url: '/admsys/dues/addwillpaylistForAdmin/index.html' 
				, success: function(data) {
					if(data =='1'){
						//window.location.reload();
						
						window.opener.location.reload();
						alert("해당 회원의 미납 회비가 추가되었습니다.");
						self.close();
						
					}else{
						alert("주문에 실패하였습니다. 지속적으로 문제가 발생시 관리자에게 문의하시기 바랍니다.");
					}
				} 
				, error: function(data, status, err) { 
					alert('서버와의 통신이 실패했습니다.'); 
				}
			});
		}
	}
	
	
	
	

	function addDuesInfo(userno, type) {
		
		var oProductNM = $('#oProductNM').val();
		var startYearMonth = $('#startYearMonth').val();
		var regyear = $('#regyear').val();
		var limitYearMonth = $('#limitYearMonth').val();
		var oAmt = $('#oAmt').val();
		var etc = $('#etc').val();
		var regdate = $('#regdate').val();
		var isAnnual = "";
		
		if (oProductNM == '') {
			alert("회비종류를 선택해 주십시오.");
			 $('#oProductNM').focus();
			return;
		}
		
		/* if (etc == '') {
			alert("납부방법을 주십시오.");
			return;
		} */
		if (oAmt == '') {
			alert("금액을 입력해 주십시오.");
			return;
		}
		
		if(oProductNM == "입회비" || oProductNM == "정회원 년회비" || oProductNM == "종신회원 회비" || oProductNM == "준회원 년회비"){
			isAnnual = "1";
			
			if (startYearMonth == "") {
				alert("회원기간 입력해 주십시오.");
				return;
			}
			
			if (regyear == "") {
				alert("회원기간 입력해 주십시오.");
				return;
			}
			
		}else if(oProductNM == "부회장 임원회비" || oProductNM == "회장 임원회비" | oProductNM == "상임이사 임원회비" || oProductNM == "이사 임원회비"  || oProductNM == "단체회원회비"){
			isAnnual = "P";
		}
		
		if (limitYearMonth == "") {
			alert("납입년도 입력해 주십시오.");
			return;
		}
		
		/* if (regdate == "") {
			alert("납입일을 입력해 주십시오.");
			return;
		} */

		if (confirm('회비내역을 추가하시겠습니까??')) {
			$.ajax({
				type : 'post',
				async : true,
				url : '/admsys/dues/addDuesInfoDo.html',
				data : "userno=" + userno
						+ "&oProductNM=" + oProductNM
						+ "&startYearMonth="+startYearMonth
						+ "&regyear="+ regyear
						+ "&limitYearMonth="+ limitYearMonth
						+ "&oAmt="+oAmt
						+ "&etc="+etc
						+ "&regdate="+regdate
						+ "&isAnnual="+isAnnual
						,
				success : function(data) {
					if (data == '1') {
						window.opener.location.reload();
						alert("해당 회원의 납부 내역이 추가되었습니다.");
						self.close()
						
					} else {
						alert("서버와의 통신이 실패하였습니다. 개발담당자에게 문의하시기 바랍니다.");
					}

				},
				error : function(data, status, err) {
					alert('서버와의 통신이 실패했습니다.');
				}
			});
		}
	}
</script>
<body style="background:#dfe8ea;">
<div id="content" style="margin:10px 10px 0 10px;">
	<ul class="homepagebbs">
            <li class="bg">
                <h3 class="sub">회비 납부내역 입력</h3>
            </li>
            <li>
				<strong style="margin:10px 0 0 10px;display:block;">
				<c:if test="${act eq 'org' }">
				<font color="red">*단체회원 회비는 기존에 있는 납입년도를  절대로 입력하시면 안됩니다.</font>
				</c:if>
				<c:if test="${act eq null }">
					<font color="red">*연회비 및  임원회비는 기존에 있는 납입년도를 절대로 입력하시면 안됩니다.(연회비 선택시 기간을 꼭 입력하세요!)</font>
				</c:if>
				</strong>
			</li>
			<li>
				<table class="main_table1 bgneno" summary="No, 내용, 납부,신청일, 회원기간, 회원활동">
					<caption>회원정보수정</caption>
					<colgroup>
						<col style="width: 5%;" />
						<col style="width: 5%;" />
						<col style="width: 11%;" />
						<col style="width: 20%;" />
						<col style="width: 8%;" />
						<col style="width: 5%;" />
						<c:if test="${act eq 'org' }">
							<col style="width: 5%;" />
						</c:if>
					</colgroup>
					<thead>
						<tr>
							<th scope="col">회비종류</th>
							<th scope="col">납부방법</th>
							<th scope="col">납부금액</th>
							<th scope="col">기간</th>
							<th scope="col">납입년도</th>
							<th scope="col">납입일</th>
							<c:if test="${act eq 'org' }">
								<th scope="col">납부여부</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="subject">
								<!-- <input name="oProductNM" id="oProductNM" style="width: 290px;" type="text"	/> -->
								<select name="oProductNM" id="oProductNM" style="height:27px;">
									<!-- 이름 바꾸지 말것 이름으로 체크하기때문에 -->
									<c:if test="${act eq 'org' }">
										<option>단체회원회비</option>
									</c:if>
									<c:if test="${act eq null }">
										<option value=''>------</option>
										<option>입회비</option>
										<option>정회원 년회비</option>
										<option>종신회원 회비</option>
										<!-- <option>준회원 입회비</option> -->
										<option>준회원 년회비</option>
										<option>부회장 임원회비</option>
										<option>회장 임원회비</option>
										<option>상임이사 임원회비</option>
										<option>이사 임원회비</option>
										<%--<option>논문심사료</option>
										<option <c:if test="${act eq 'org' }">selected="selected"</c:if>>단체회원회비</option> --%>
									</c:if>
								</select>
							</td>
							<td>
							<select name="etc" id="etc" style="width:120px;height:27px;">
								<option value="">------</option>
								<option >신용카드</option>
								<option >계좌이체</option>
								<option >무통장</option>
								<option >지로</option>
								<option >관리자 입력</option>
								<option >기타</option>
								<option >학생기자단 면제</option>
							  </select>
							</td>
							<td>
								<input class="number" name="oAmt" id="oAmt" style="width:100px;height:27px;" type="text"	/>
							</td>
							<td>
								<input name="startYearMonth" id="startYearMonth" class="number" maxlength="4" style="width:100px;height:27px;" type="text"	/> ~
								<input name="regyear" id="regyear" class="number" maxlength="4" style="width: 100px;height:27px;" type="text"	/>
							</td>
							<td>
								<input name="limitYearMonth" id="limitYearMonth"  class="number" maxlength="4" style="width: 100px;height:27px;" type="text" /> 년
							</td>	
							<td>
								<input readonly class="date-pick" name="regdate" id="regdate" style="width: 80px;height:27px;" type="text" />
							</td>
							<c:if test="${act eq 'org' }">
								<td>
									<select name="payconfirm" id="payconfirm" style="width:120px:height:27px;">
										<option value="0">미납</option>
										<option value="1">납부</option>
									</select>
								</td>
							</c:if>
							<c:if test="${act eq null }">
								<inpu type="hidden" name="payconfirm" value="1"/>
							</c:if>
						</tr>
					</tbody>
				</table>
				<div class="btn-c-B">
					<a class="btmore04" href="javascript:addDuesInfo('${userVO.userno}');">회비납부추가</a>
					<a class="btmore05" href="javascript:self.close();">창닫기</a>
				</div>

<c:if test="${act eq null }">
				<h4 class="stit">미납회비 입력</h4>
				<strong style="margin:10px 0 0 10px;display:block;">
				<font color="red">* 연회비 및  임원회비는 기존에 있는 납입년도를  절대로 입력하시면 안됩니다.</font>
				</strong>
				<table class="main_table1 bgneno" summary="No, 내용, 납부,신청일, 회원기간, 회원활동">
					<caption>회원정보수정</caption>
					<colgroup>
						<col style="width: 11%;" />
						<col style="width: 20%;" />
						<col style="width: 5%;" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">회비종류</th>
							<!-- <th scope="col">납부방법</th> -->
							<th scope="col">납부금액</th>
							<!-- <th scope="col">기간</th> -->
							<th scope="col">납입년도</th>
						<!-- 	<th scope="col">납입일</th>
							<th scope="col">납부여부</th> -->
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="subject">
								<!-- <input name="oProductNM" id="oProductNM" style="width: 290px;" type="text"	/> -->
								<select  id="oProductNM2" style="height:27px;">
									<c:if test="${userVO.work_grade eq '1'}">
										<option>정회원 회비</option>
									</c:if>
									<c:if test="${userVO.work_grade eq '2'}">
										<option>종신회원 회비</option>
									</c:if>
									<c:if test="${userVO.work_grade eq '3'}">
										<option>준회원 회비</option>
									</c:if>
									<option>부회장 임원회비</option>
									<option>회장 임원회비</option>
									<option>상임이사 임원회비</option>
									<option>이사 임원회비</option>
								</select>
							</td>
							<td>
								<input class="number" id="oAmt2" style="width:100px;height:27px;" type="text"	/>
							</td>
							<td>
								<input id="limitYearMonth2"  class="number" maxlength="4" style="width: 100px;height:27px;" type="text"	/> 년
							</td>	
						</tr>
					</tbody>
				</table>
				<div class="btn-c-B">
					<a class="btmore04" href="javascript:addwillpaylistForAdmin('${userVO.work_grade}','${userVO.userno}','${userVO.username}','${userVO.useremail}');">미납회비 입력</a>
					<a class="btmore05" href="javascript:self.close();">창닫기</a>
				</div>
			</li>
		</ul>
	
</div>
</c:if>
</body>
</html>