<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<script src='/usr/js/admsys/conference/regform.js'></script>
<style type="text/css">
div.cont-right {margin-left: 10px; margin-top: 10px;}
</style>

<div id="container">
<jsp:include page="../lnb.jsp" flush="true" />
	 <div id="contents">
		<div class="contants_top">
			<div class="location">
				<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/mail/">업무관리</a> <a href="/admsys/events/list.html">행사 관리</a> <strong>참가자</strong>
			</div>
		</div>
		<div id="content">
			<ul class="homepagebbs">
				<li class="bg">
					<h3 class="setting">참가자 정보</h3>
				</li>
			<div class="main_table">
			<table class="main_table1 bgneno" summary="행사 참가자">
				<caption>본문관리(행사 참가자 정보)</caption>
				<colgroup>
					<col width="20%" />
					<col width="80%" />
				</colgroup>
				<tr>
					<th class="Tleft" scope="row">접수번호</th>
					<td class="Tbod Tbod Tleft">${entriesInfo.enSubmitNo}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">성명</th>
					<td class="Tleft">${entriesInfo.enUserName}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">생년월일</th>
					<td class="Tleft">${entriesInfo.enUserBirthDate}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">회사(학교)명</th>
					<td class="Tleft">${entriesInfo.enUserOrg}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row" >부서(학과)명</th>
					<td class="Tleft">${entriesInfo.enUserDept}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row" >직위(급)</th>
					<td class="Tleft">${entriesInfo.enUserJob}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row" >E-mail</th>
					<td class="Tleft">${entriesInfo.enUserEmail}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">전화번호</th>
					<td class="Tleft">${entriesInfo.enUserPhone}</td>

				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">휴대전화</th>
					<td class="Tleft">${entriesInfo.enUserMobile}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">주소</th>
					<td class="Tleft">&#40;${entriesInfo.enUserZipCode}&#41; ${entriesInfo.enUserAddr} ${entriesInfo.enUserAddrDetail}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">신청일</th>
					<td class="Tleft">${entriesInfo.enSubmitTime}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">제출문서</th>
					<td class="Tleft">

					<form name="chagneFileFrm" id="chagneFileFrm" method="post" enctype="multipart/form-data">
				    <input type="hidden" id="enIdx" name="enIdx" value="${entriesInfo.enIdx}"/>
				    <input type="hidden" id="enEvIdx" name="enEvIdx" value="${entriesInfo.enEvIdx}"/>
				    <c:if test="${empty papersList}">
				    	<c:if test="${eventsInfo.evCategory eq '관광'}">
							<input type="file" id="paperFile_0" name="paperFile_0" /><br>
							<input type="file" id="paperFile_1" name="paperFile_1" /><br>
				    	</c:if>
				    	<c:if test="${eventsInfo.evCategory ne '관광'}">
				    		<input type="file" id="paperFile_0" name="paperFile_0" /><br>
				    	</c:if>
				    </c:if>

				    <c:if test="${eventsInfo.evCategory eq '관광'}">

					<c:forEach items="${papersList}" var="papers" varStatus="loop">
							<input type="hidden" id="epIdx_${loop.index }" name="epIdx_${loop.index }" value="${papers.epIdx}"/>
							<input type="file" id="paperFile_${loop.index }" name="paperFile_${loop.index }" />
							<a href="./entryDownload.html?enIdx=${entriesInfo.enIdx}&epIdx=${papers.epIdx}">${papers.epAttRealName}</a><br>
					</c:forEach>

				    	<c:if test="${fn:length(papersList) eq '1'}">
				    		<input type="file" id="paperFile_1" name="paperFile_1" /><br>
				    	</c:if>
				    </c:if>

				    <c:if test="${eventsInfo.evCategory ne '관광'}">
				    	<c:forEach items="${papersList}" var="papers" varStatus="loop">
							<input type="hidden" id="epIdx_${loop.index }" name="epIdx_${loop.index }" value="${papers.epIdx}"/>
							<input type="file" id="paperFile_${loop.index }" name="paperFile_${loop.index }" />
							<a href="./entryDownload.html?enIdx=${entriesInfo.enIdx}&epIdx=${papers.epIdx}">${papers.epAttRealName}</a><br>
						</c:forEach>
				    </c:if>
						<div>
						<a href="javascript:chagePaper();" class="btmore04" style="margin-top:5px;">수정/등록</a>
						</div>
					</form>
					</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">상태</th>
					<td class="Tleft">${statMap[entriesInfo.enCondition]}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">결제방법</th>
					<td class="Tleft">${entriesInfo.enPaymentMethod}</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">결제금액</th>
					<td class="Tleft">${entriesInfo.enPaymentSum}원</td>
				</tr>
				<tr>
					<th class="Tbornone Tleft" scope="row">결제일</th>
					<td class="Tleft">${entriesInfo.enPaymentDate}</td>
				</tr>
			</table>
				<div class="btn-c">
					<c:if test="${entriesInfo.enCondition eq '2' }">
					<a href="./entrylist.html?evIdx=${entriesInfo.enEvIdx}&type=cancel" class="btmore04">참가자목록</a>
					</c:if>
					<c:if test="${entriesInfo.enCondition ne '2' }">
					<a href="./entrylist.html?evIdx=${entriesInfo.enEvIdx}&type=join" class="btmore04">참가자목록</a>
					</c:if>
					<c:if test="${entriesInfo.enCondition ne '2' }">
						<a href="./changeStatus.html?evIdx=${entriesInfo.enEvIdx}&sum=${entriesInfo.enPaymentSum }&enIdx=${entriesInfo.enIdx}&value=2&type=cancel" onclick="return checkCancel()" class="btmore09">등록취소</a>
					</c:if>
				</div>
			</div>
			</li>
		</ul>
		</div>
	</div>
</div>
<!--/container-->
</div>
<!--/wrap-->
<c:import url="../../../admsys/footer.jsp" />
</body>
</html>