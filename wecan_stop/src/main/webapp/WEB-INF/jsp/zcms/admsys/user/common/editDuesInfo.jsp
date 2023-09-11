<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<link rel="stylesheet" type="text/css" href="/com/css/jquery-1.10.3-ui.css" />
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

	function editDuesInfo(duesno, userno) {
		var oProductNM = $('#oProductNM'+duesno).val();
		var startYearMonth = $('#startYearMonth'+duesno).val();
		var limitYearMonth = $('#limitYearMonth'+duesno).val();
		var oAmt = $('#oAmt'+duesno).val();
		var etc = $('#etc'+duesno).val();
		var regyear = $('#regyear'+duesno).val();
		var regdate = $('#regdate'+duesno).val();
		var payconfirm = $('#payconfirm'+duesno).val();

		if (oProductNM == '') {
			alert("회비종류를 선택해 주십시오.");
			$('#oProductNM'+duesno).focus();
			return;
		}
		if (etc == '') {
			alert("납부방법을 선택해 주십시오.");
			$('#etc'+duesno).focus();
			return;
		}
		if (oAmt == '') {
			alert("금액을 입력해 주십시오.");
			$('#oAmt'+duesno).focus();
			return;
		}
		/* if (limitYearMonth.length != 8) {
			alert("회원기간을 정확히 입력해 주십시오.");
			limitYearMonth.focus();
			return;
		} */
		/* if (regdate == '') {
			alert("납입일을 정확히 입력해 주십시오.");
			$('#regdate'+duesno).focus();
			return;
		} */

		if (confirm('회비내역을 수정하시겠습니까??')) {
			$.ajax({
				type : 'post',
				async : true,
				url : '/admsys/dues/editDuesInfoDo.html',
				data : "userno=" + userno
						+ "&duesno=" + duesno
						+ "&oProductNM=" + oProductNM
						+ "&startYearMonth="+startYearMonth
						+ "&limitYearMonth="+ limitYearMonth
						+ "&oAmt="+oAmt
						+ "&etc="+etc
						+ "&regyear="+regyear
						+ "&regdate="+regdate
						+ "&payconfirm="+payconfirm
						,
				success : function(data) {
					if (data == '1') {
						alert("해당 회원의 납부 내역이 수정되었습니다.");
						window.location.reload();
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

	function delDuesInfo(duesno) {

		if (confirm('회비내역을 삭제하시겠습니까??')) {
			$.ajax({
				type : 'post',
				async : true,
				url : '/admsys/dues/delDuesInfoDo.html',
				data : "duesno=" + duesno,
				success : function(data) {
					if (data == '1') {
						window.location.reload();
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
			<h3 class="sub">회비납부수정</h3>
		</li>
		<li>
			<strong style="margin:10px 0 0 10px;display:block;">
			<c:if test="${act eq 'org' }">
				<font color="red">*단체회원 회비는 기존에 있는 납입년도를  절대로 입력하시면 안됩니다.</font>
			</c:if>
			<c:if test="${act eq null }">
				<font color="red">*연회비 및  임원회비는 기존에 있는 납입년도를  절대로 입력하시면 안됩니다.(연회비 선택시 기간을 꼭 입력하세요!)</font>
			</c:if>
			</strong>
		</li>
		<li>
			<table class="main_table1 bgneno" summary="No, 내용, 납부,신청일, 회원기간, 회원활동">
				<caption>회원정보수정</caption>
				<colgroup>
					<col style="width: 5%;" />
					<col style="width: 5%;" />
					<col style="width: 7%;" />
					<col style="width: 20%;" />
					<col style="width: 12%;" />
					<col style="width: 5%;" />
					<col style="width: 5%;" />
					<col style="width: 4%;" />
					<col style="width: 4%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">회비종류</th>
						<th scope="col">납부방법</th>
						<th scope="col">납부금액</th>
						<th scope="col">기간</th>
						<th scope="col">납입년도</th>
						<th scope="col">납입일</th>
						<th scope="col">납부여부</th>
						<th scope="col">수정</th>
						<th scope="col">삭제</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${dueslist}" var="each" varStatus="loop">
					<c:if test="${each.annualPause ne '9'}" >
					<tr>
						<td class="subject">
							<%-- <c:if test="${data.isAnnual eq 'P'}">
								<select name="oProductNM" id="oProductNM${data.duesno }">
									<!-- <option value=''>------</option> -->
									<option <c:if test="${data.oProductNM eq '입회비' }">selected="selected"</c:if>>입회비</option>
									<option <c:if test="${data.oProductNM eq '정회원 년회비' }">selected="selected"</c:if>>정회원 년회비</option>
									<option <c:if test="${data.oProductNM eq '종신회원 회비' }">selected="selected"</c:if>>종신회원 회비</option>
									<option <c:if test="${data.oProductNM eq '준회원 입회비' }">selected="selected"</c:if>>준회원 입회비</option>
									<option <c:if test="${data.oProductNM eq '준회원 년회비' }">selected="selected"</c:if>>준회원 년회비</option>
									<option <c:if test="${data.oProductNM eq '부회장 임원회비' }">selected="selected"</c:if>>부회장 임원회비</option>
									<option <c:if test="${data.oProductNM eq '회장 임원회비' }">selected="selected"</c:if>>회장 임원회비</option>
									<option <c:if test="${data.oProductNM eq '상임이사 임원회비' }">selected="selected"</c:if>>상임이사 임원회비</option>
									<option <c:if test="${data.oProductNM eq '이사 임원회비' }">selected="selected"</c:if>>이사 임원회비</option>
									<option <c:if test="${data.oProductNM eq '논문심사료' }">selected="selected"</c:if>>논문심사료</option>
									<option <c:if test="${data.oProductNM eq '단체회원회비' }">selected="selected"</c:if>>단체회원회비</option>
								</select>
							</c:if>
							<c:if test="${data.isAnnual ne 'P'}">
								<input name="oProductNM" id="oProductNM${data.duesno }" style="width: 150px;" type="text"	value="${data.oProductNM}"/>
							</c:if> --%>
							<input name="oProductNM" id="oProductNM${each.duesno }" style="width:150px;height:27px;" type="text" value="${each.oProductNM}"/>
						</td>
						<td>
						<select name="etc" id="etc${each.duesno }" style="width:120px;height:27px;">
							<option value="">------</option>
							<option <c:if test="${each.etc eq '신용카드' }">selected="selected"</c:if>>신용카드</option>
							<option <c:if test="${each.etc eq '계좌이체' }">selected="selected"</c:if>>계좌이체</option>
							<option <c:if test="${each.etc eq '무통장' }">selected="selected"</c:if>>무통장</option>
							<option <c:if test="${each.etc eq '지로' }">selected="selected"</c:if>>지로</option>
							<option <c:if test="${each.etc eq '관리자 입력' }">selected="selected"</c:if>>관리자 입력</option>
							<option <c:if test="${each.etc eq '기타' }">selected="selected"</c:if>>기타</option>
							<option <c:if test="${each.etc eq '학생기자단 면제' }">selected="selected"</c:if>>학생기자단 면제</option>
						  </select>
						</td>
						<td>
							<input class="number" name="oAmt" id="oAmt${each.duesno }" style="width:100px;height:27px;" type="text" value="${each.oAmt }"/>
						</td>
						<td>
							<input name="startYearMonth" id="startYearMonth${each.duesno }" class="number" maxlength="4" style="width: 100px;height:27px;" type="text" value="${each.startYearMonth }"/> ~
							<input name="regyear" id="regyear${each.duesno }" class="number" maxlength="4" style="width: 100px;height:27px;" type="text" value="${each.regyear }"/>
						</td>
						<td>
							<input name="limitYearMonth" id="limitYearMonth${each.duesno }" class="number" maxlength="4" style="width: 100px;height:27px;" type="text" value="${each.limitYearMonth }"/> 년
						</td>
						<td>
							<fmt:parseDate value="${each.regdate}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
							<input readonly class="date-pick" name="regdate" id="regdate${each.duesno }" style="width: 100px;height:27px;" type="text" value="<fmt:formatDate type="both" value="${isoDate}" pattern="yyyyMMdd" />"/>
						</td>
						<td>
							<%--<c:if test="${data.payconfirm eq '1' }">
								<input name="payconfirm" id="payconfirm${data.duesno }" type="hidden"	value="1"/>납부
							</c:if>
							<c:if test="${data.payconfirm ne '1' }"> --%>
								<select name="payconfirm" id="payconfirm${each.duesno }" style="width:120px;height:27px;">
									<option value="1" <c:if test="${each.payconfirm eq '1' }">selected="selected"</c:if>>납부</option>
									<option value="0" <c:if test="${each.payconfirm eq '0'  || each.payconfirm eq null}">selected="selected"</c:if>>미납</option>
							  </select>
							<%-- </c:if> --%>
						</td>
						<td>
							<%-- <c:if test="${data.isAnnual eq 'P'}"> --%>
								<a class="btmore05" href="javascript:editDuesInfo('${each.duesno }', '${each.userno }')">수정</a>
							<%-- </c:if> --%>
						</td>
						<td>
						<%-- <c:if test="${data.payconfirm eq '0' ||  data.payconfirm eq null}"> --%>
							<a  class="btmore06" href="javascript:delDuesInfo('${each.duesno }')">삭제</a>
						<%-- </c:if> --%>
						</td>
					</tr>
					</c:if>
				</c:forEach>
				</tbody>
			</table>
			<div class="btn-c-b">
				<a class="btmore04" href="javascript:window.opener.location.reload();self.close();" class="gray">완료</a>
				<!-- <a href="javascript:self.close();"><img	src="/usr/image/common/btn/btn_close05.gif" /></a> -->
			</div>
		</li>
	</ul>

</div>
</div>