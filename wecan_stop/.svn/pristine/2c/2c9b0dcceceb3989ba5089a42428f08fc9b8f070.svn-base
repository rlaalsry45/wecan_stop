<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%@ page import = "java.util.Calendar" %>
<%@ page import = "java.util.Date" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/vnd.ms-excel");
	response.setCharacterEncoding("utf-8");
	response.setHeader("Content-Disposition", "attachment; filename=\"excel.xls\"");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	out.print("<meta http-equiv=\"Content-Type\" content=\"application/vnd.ms-excel; charset=utf-8\">");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40">
<head>
<style type="text/css">
	body {font-family:tahoma;font-size:12px}
	table {padding:2px;border-spacing:0px;font-family:tahoma;font-size:12px;border-collapse:collapse}
	td {text-align:center}
</style>

</head>
<body>
<c:if test="${act eq 'excel_chk' ||  act eq 'excel_all' }">
<table id="excel_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="회원리스트" style="display:none">
	<colgroup>
		<col width="7%" />
		<col width="8%" />
		<col width="8%" />
		<col />
		<col width="10%" />
		<col width="10%" />
		<col width="20%" />
	</colgroup>
	<thead>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>직장명</th>
			<th>직책</th>
			<th>연락처</th>
			<th>이메일주소</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchList}" var="each" varStatus="loop">
			<tr>
				<td><c:out value='${each.useridx}' /></td>
				<td><c:out value='${each.userid}' /></td>
				<td><c:out value='${each.username}' /></td>
				<td><c:out value='${each.usercompanyname}' /></td>
				<td><c:out value='${each.usercompanystatus}' /></td>
				<td><c:out value='${each.usermobile}' /></td>
				<td><c:out value='${each.useremail}' /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
<c:if test="${act eq 'paper_excel_chk' ||  act eq 'paper_excel_all' }">
<table id="excel_table" border="1" cellspacing="1" cellpadding="2" width="100%" style="display:none">
	<!-- <caption>학술대회 참가자 목록</caption> -->
	<colgroup>
		<col width="4%" />
		<col width="40%" />
		<col width="10%" />
		<col width="10%" />
		<col width="10%" />
		<col width="20%" />
		<col width="19%" />
		<col width="19%" />
		<col width="19%" />
		<col width="15%" />
		<col width="30%" />
		<col width="15%" />
		<col width="15%" />
		<col width="15%" />
	</colgroup>
	<thead>
		<tr>
			<th>접수번호</th>
			<th>논문정보</th>
			<th>성명</th>
			<th>생년월일</th>
			<th>회사(학교)명</th>
			<th>부서(학과)명</th>
			<th>직위(급)</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>휴대전화</th>
			<th>주소</th>
			<th>신청일</th>
			<th>진행단계</th>
			<th>승인여부</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchPaperList}" var="each" varStatus="loop">
			<tr>
				<td><c:out value='${each.decode}' /></td>
				<td>
					<table id="excel_table" border="1" cellspacing="1" cellpadding="2" width="100%" style="display:none">
						<colgroup>
							<col width="25%" />
							<col width="25%" />
							<col width="25%" />
							<col width="25%" />
						</colgroup>
						<thead>
							<tr>
								<th>논문제목</th>
								<th>세션</th>
								<th>트랙</th>
								<th>분야</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${each.infoList}" var="infoList" varStatus="loop">
								<tr>
									<td><c:out value='${infoList.cpititle}' /></td>
									<td><c:out value='${infoList.section}' /></td>
									<td><c:out value='${infoList.cpitrack}' /></td>
									<td><c:out value='${infoList.field}' /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
				<td><c:out value='${each.name}' /></td>
				<td><c:out value='${each.birthday}' /></td>
				<td><c:out value='${each.schoolname}' /></td>
				<td><c:out value='${each.schoollesson}' /></td>
				<td><c:out value='${each.schooldegree}' /></td>
				<td><c:out value='${each.email}' /></td>
				<td><c:out value='${each.phone}' /></td>
				<td><c:out value='${each.mobile}' /></td>
				<td><c:out value='${each.postcode}' /> <c:out value='${each.address}' /> <c:out value='${each.address2}' /></td>
				<td><c:out value='${each.createdate}' /></td>
				<td><c:if test="${each.papertype == 0}">초록</c:if>
					<c:if test="${each.papertype == 1}">최종본</c:if>
					<c:if test="${each.papertype == 2}">요약본</c:if>
				</td>
				<td>
				<c:if test="${each.paperstep == 1}">승인</c:if>
				<c:if test="${each.paperstep == 0}">미승인</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
<c:if test="${act eq 'participant_excel_chk' ||  act eq 'participant_excel_all' }">
<table id="excel_table" border="1" cellspacing="1" cellpadding="2" width="100%" style="display:none">
	<!-- <caption>학술대회 사전등록 목록</caption> -->
	<colgroup>
		<col width="4%" />
		<col width="10%" />
		<col width="10%" />
		<col width="10%" />
		<col width="20%" />
		<col width="19%" />
		<col width="19%" />
		<col width="19%" />
		<col width="15%" />
		<col width="30%" />
		<col width="15%" />
		<col width="15%" />
	</colgroup>
	<thead>
		<tr>
			<th>접수번호</th>
			<th>성명</th>
			<th>생년월일</th>
			<th>회사(학교)명</th>
			<th>부서(학과)명</th>
			<th>직위(급)</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>휴대전화</th>
			<th>주소</th>
			<th>신청일</th>
			<th>결제금액</th>
			<th>결제방법</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchParticipantList}" var="each" varStatus="loop">
			<tr>
				<td><c:out value='${each.decode}' /></td>
				<td><c:out value='${each.name}' /></td>
				<td><c:out value='${each.birthday}' /></td>
				<td><c:out value='${each.schoolname}' /></td>
				<td><c:out value='${each.schoollesson}' /></td>
				<td><c:out value='${each.schooldegree}' /></td>
				<td><c:out value='${each.email}' /></td>
				<td><c:out value='${each.phone}' /></td>
				<td><c:out value='${each.mobile}' /></td>
				<td><c:out value='${each.postcode}' /> <c:out value='${each.address}' /> <c:out value='${each.address2}' /></td>
				<td><c:out value='${each.createdate}' /></td>
				<td><c:out value='${each.enfee}' /></td>
				<td><c:out value='${each.enfeemethod}' /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
<c:if test="${act eq 'debate_excel_chk' ||  act eq 'debate_excel_all' }">
<table id="excel_table" border="1" cellspacing="1" cellpadding="2" width="100%" style="display:none">
	<!-- <caption>학술대회 좌장 및 토론신청 목록</caption> -->
	<colgroup>
		<col width="4%" />
		<col width="10%" />
		<col width="10%" />
		<col width="10%" />
		<col width="20%" />
		<col width="19%" />
		<col width="19%" />
		<col width="19%" />
		<col width="15%" />
		<col width="30%" />
		<col width="15%" />
		<col width="15%" />
		<col width="15%" />
		<col width="15%" />
	</colgroup>
	<thead>
		<tr>
			<th>접수번호</th>
			<th>성명</th>
			<th>생년월일</th>
			<th>회사(학교)명</th>
			<th>부서(학과)명</th>
			<th>직위(급)</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>휴대전화</th>
			<th>주소</th>
			<th>신청일</th>
			<th>분야</th>
			<th>세션</th>
			<th>전공선택</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchDebateList}" var="each" varStatus="loop">
			<tr>
				<td><c:out value='${each.decode}' /></td>
				<td><c:out value='${each.name}' /></td>
				<td><c:out value='${each.birthday}' /></td>
				<td><c:out value='${each.schoolname}' /></td>
				<td><c:out value='${each.schoollesson}' /></td>
				<td><c:out value='${each.schooldegree}' /></td>
				<td><c:out value='${each.email}' /></td>
				<td><c:out value='${each.phone}' /></td>
				<td><c:out value='${each.mobile}' /></td>
				<td><c:out value='${each.postcode}' /> <c:out value='${each.address}' /> <c:out value='${each.address2}' /></td>
				<td><c:out value='${each.createdate}' /></td>
				<td><c:out value='${each.field}' /></td>
				<td><c:out value='${each.section}' /></td>
				<td><c:out value='${each.receipt}' /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
<c:if test="${act eq 'org_excel_chk' ||  act eq 'org_excel_all'  ||  act eq 'donation_excell_chk'  ||  act eq 'donation_excell_all'}">
<table id="main_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="회원리스트">
<colgroup>
	<col width="5%" />
	<col width="8%" />
	<col width="8%" />
	<col width="8%" />
	<c:if test="${act eq 'org_excel_chk' ||  act eq 'org_excel_all'}">
	<col width="7%" />
	</c:if>
	<col width="12%" />
	<col width="12%" />
	<col width="15%" />
</colgroup>
<thead>
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>
			<c:if test="${act eq 'org_excel_chk' ||  act eq 'org_excel_all'}">기관명</c:if>
			<c:if test="${act eq 'donation_excell_chk' ||  act eq 'donation_excell_all'}">회사명</c:if>
		</th>
		<th>
			<c:if test="${act eq 'org_excel_chk' ||  act eq 'org_excel_all'}">대표자</c:if>
			<c:if test="${act eq 'donation_excell_chk' ||  act eq 'donation_excell_all'}">담당자</c:if>
		</th>
		<c:if test="${act eq 'org_excel_chk' ||  act eq 'org_excel_all'}">
		<th>담당자</th>
		</c:if>
		<th>부서</th>
		<th>이메일</th>
		<th>전화</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${orgSearchList}" var="each" varStatus="loop">
		<tr>
			<td><c:out value='${each.orgUserNo}' /></td>
			<td><c:out value='${each.userid}' /></td>
			<td><c:out value='${each.orgName}' /></td>
			<td>
				<c:if test="${act eq 'org_excel_chk' ||  act eq 'org_excel_all'}"><c:out value='${each.orgDelegate}' /></c:if>
				<c:if test="${act eq 'donation_excell_chk' ||  act eq 'donation_excell_all'}"><c:out value='${each.orgOfficer}' /></c:if>
			</td>
			<c:if test="${act eq 'org_excel_chk' ||  act eq 'org_excel_all'}">
				<td><c:out value='${each.adr1Officer}' /></td>
			</c:if>
			<td><c:out value='${each.adr1Dept}' /></td>
			<td><c:out value='${each.adr1Email}' /></td>
			<td><c:out value='${each.adr1Phone}' /></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>
<c:if test="${act eq 'event_excel_chk' ||  act eq 'event_excel_all'}">
<!-- 엑셀 다운로드 영역 -->
<table id="excel_table" border="1" cellspacing="1" cellpadding="2" width="100%" style="display:none">
	<colgroup>
		<col width="4%" />
		<col width="10%" />
		<col width="10%" />
		<col width="10%" />
		<col width="20%" />
		<col width="19%" />
		<col width="19%" />
		<col width="19%" />
		<col width="15%" />
		<col width="30%" />
		<col width="15%" />
		<col width="15%" />
		<col width="15%" />
		<col width="15%" />
		<col width="15%" />
		<col width="15%" />
	</colgroup>
	<thead>
		<tr>
			<th>접수번호</th>
			<th>성명</th>
			<th>생년월일</th>
			<th>소속단체</th>
			<th>소속부서</th>
			<th>직책/학위</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>휴대전화번호</th>
			<th>주소</th>
			<th>신청일</th>
			<th>결제금액</th>
			<th>결제방법</th>
			<!-- <th>발표자여부</th>
			<th>중식/석식</th>
			<th>비고</th>-->
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchEventList}" var="each" varStatus="loop">
			<tr>
				<td><c:out value='${each.enSubmitNo}' /></td>
				<td><c:out value='${each.enUserName}' /></td>
				<td><c:out value='${each.enUserBirthDate}' /></td>
				<td><c:out value='${each.enUserOrg}' /></td>
				<td><c:out value='${each.enUserDept}' /></td>
				<td><c:out value='${each.enUserJob}' /></td>
				<td><c:out value='${each.enUserEmail}' /></td>
				<td><c:out value='${each.enUserPhone}' /></td>
				<td><c:out value='${each.enUserMobile}' /></td>
				<td><c:out value='${each.enUserZipCode}' /> <c:out value='${each.enUserAddr}' /> <c:out value='${each.enUserAddrDetail}' /></td>
				<td><c:out value='${each.enSubmitTime}' /></td>
				<td><c:out value='${each.enPaymentSum}' /></td>
				<td><c:out value='${each.enPaymentMethod}' /></td>
				<%-- <td><c:out value='${panelMap[data.enUserIsPanel]}' /></td>
				<td>
					<c:if test="${data.enUserHaveLunch eq '1' }">중식 선택</c:if> /
					<c:if test="${data.enUserHaveDinner eq '1' }">만찬 선택</c:if>
				</td>
				<td><c:out value='${data.enUserNote}' /></td> --%>
				<td><c:out value='${statMap[each.enCondition]}' /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div><!--/main_table-->
</c:if>
<c:if test="${act eq 'search_excel_chk' ||  act eq 'search_excel_all'}">
<table id="main_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="회원리스트">
	<caption>회원리스트</caption>
	<colgroup>
	</colgroup>
	<thead>
		<tr>
			<th>회원번호</th>
			<c:if test='${fn:contains(column,"01")}'>
				<th>ID</th>
			</c:if>
			<c:if test='${fn:contains(column,"02")}'>
				<th>한글이름</th>
			</c:if>
			<c:if test='${fn:contains(column,"03")}'>
				<th>영문이름</th>
			</c:if>
			<c:if test='${fn:contains(column,"04")}'>
				<th>한문이름</th>
			</c:if>
			<c:if test='${fn:contains(column,"05")}'>
				<th>생년월일</th>
			</c:if>
			<c:if test='${fn:contains(column,"06")}'>
				<th>이메일</th>
			</c:if>
			<c:if test='${fn:contains(column,"07")}'>
				<th>우편물수령</th>
			</c:if>
			<c:if test='${fn:contains(column,"08")}'>
				<th>핸드폰</th>
			</c:if>
			<c:if test='${fn:contains(column,"10")}'>
				<th>지회</th>
			</c:if>
			<c:if test='${fn:contains(column,"11")}'>
				<th>입회날짜</th>
			</c:if>
			<c:if test='${fn:contains(column,"12")}'>
				<th>자택주소</th>
			</c:if>
			<c:if test='${fn:contains(column,"13")}'>
				<th>자택우편번호</th>
			</c:if>
			<c:if test='${fn:contains(column,"14")}'>
				<th>자택전화번호</th>
			</c:if>
			<c:if test='${fn:contains(column,"15")}'>
				<th>직장명</th>
			</c:if>
			<c:if test='${fn:contains(column,"16")}'>
				<th>부서</th>
			</c:if>
			<c:if test='${fn:contains(column,"17")}'>
				<th>직책</th>
			</c:if>
			<c:if test='${fn:contains(column,"18")}'>
				<th>회사주소</th>
			</c:if>
			<c:if test='${fn:contains(column,"19")}'>
				<th>회사우편번호</th>
			</c:if>
			<c:if test='${fn:contains(column,"20")}'>
				<th>회사전화번호</th>
			</c:if>
			<c:if test='${fn:contains(column,"21")}'>
				<th>회사FAX</th>
			</c:if>
			<c:if test='${fn:contains(column,"22")}'>
				<th>받을곳 우편번호</th>
			</c:if>
			<c:if test='${fn:contains(column,"23")}'>
				<th>받을곳 주소</th>
			</c:if>
			<c:if test='${fn:contains(column,"42")}'>
				<th>받을곳 상세주소</th>
			</c:if>
			<c:if test='${fn:contains(column,"24")}'>
				<th>회원종류</th>
			</c:if>
			<c:if test='${fn:contains(column,"25")}'>
				<th>임원</th>
			</c:if>
			<c:if test='${fn:contains(column,"26")}'>
				<th>위원회</th>
			</c:if>
			<c:if test='${fn:contains(column,"27")}'>
				<th>학사졸업연도</th>
			</c:if>
			<c:if test='${fn:contains(column,"28")}'>
				<th>학사학교</th>
			</c:if>
			<c:if test='${fn:contains(column,"29")}'>
				<th>학사학과</th>
			</c:if>
			<c:if test='${fn:contains(column,"30")}'>
				<th>석사졸업연도</th>
			</c:if>
			<c:if test='${fn:contains(column,"31")}'>
				<th>석사학교</th>
			</c:if>
			<c:if test='${fn:contains(column,"32")}'>
				<th>석사학과</th>
			</c:if>
			<c:if test='${fn:contains(column,"33")}'>
				<th>박사졸업연도</th>
			</c:if>
			<c:if test='${fn:contains(column,"34")}'>
				<th>박사박교</th>
			</c:if>
			<c:if test='${fn:contains(column,"35")}'>
				<th>박사학과</th>
			</c:if>
			<c:if test='${fn:contains(column,"36")}'>
				<th>최종학력</th>
			</c:if>
			<c:if test='${fn:contains(column,"37")}'>
				<th>직종</th>
			</c:if>
			<c:if test='${fn:contains(column,"38")}'>
				<th>추천인</th>
			</c:if>
			<c:if test='${fn:contains(column,"39")}'>
				<th>납부방법</th>
			</c:if>
			<c:if test='${fn:contains(column,"50")}'>
				<c:if test='${fn:contains(searchUser.dueyear,"d2000")}'>
					<th>연회비2000</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2001")}'>
					<th>연회비2001</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2002")}'>
					<th>연회비2002</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2003")}'>
					<th>연회비2003</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2004")}'>
					<th>연회비2004</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2005")}'>
					<th>연회비2005</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2006")}'>
					<th>연회비2006</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2007")}'>
					<th>연회비2007</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2008")}'>
					<th>연회비2008</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2009")}'>
					<th>연회비2009</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2010")}'>
					<th>연회비2010</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2011")}'>
					<th>연회비2011</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2012")}'>
					<th>연회비2012</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2013")}'>
					<th>연회비2013</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2014")}'>
					<th>연회비2014</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2015")}'>
					<th>연회비2015</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2016")}'>
					<th>연회비2016</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2017")}'>
					<th>연회비2017</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2018")}'>
					<th>연회비2018</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2019")}'>
					<th>연회비2019</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"d2020")}'>
					<th>연회비2020</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2000")}'>
					<th>임원2000</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2001")}'>
					<th>임원2001</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2002")}'>
					<th>임원2002</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2003")}'>
					<th>임원2003</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2004")}'>
					<th>임원2004</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2005")}'>
					<th>임원2005</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2006")}'>
					<th>임원2006</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2007")}'>
					<th>임원2007</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2008")}'>
					<th>임원2008</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2009")}'>
					<th>임원2009</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2010")}'>
					<th>임원2010</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2011")}'>
					<th>임원2011</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2012")}'>
					<th>임원2012</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2013")}'>
					<th>임원2013</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2014")}'>
					<th>임원2014</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2015")}'>
					<th>임원2015</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2016")}'>
					<th>임원2016</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2017")}'>
					<th>임원2017</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2018")}'>
					<th>임원2018</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2019")}'>
					<th>임원2019</th>
				</c:if>
				<c:if test='${fn:contains(searchUser.dueyear,"e2020")}'>
					<th>임원2020</th>
				</c:if>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchMultiList}" var="each" varStatus="loop">
			<tr>
				<td><c:out value='${each.useridx}' /></td>
				<c:if test='${fn:contains(column,"01")}'>
					<td>${each.userid}</td>
				</c:if>
				<c:if test='${fn:contains(column,"02")}'>
					<td>${each.username}</td>
				</c:if>
				<c:if test='${fn:contains(column,"03")}'>
					<td>${each.username2}</td>
				</c:if>
				<c:if test='${fn:contains(column,"04")}'>
					<td>${each.usercname}</td>
				</c:if>
				<c:if test='${fn:contains(column,"05")}'>
					<td>
						<c:if test="${fn:length(fn:trim(each.userbirth))  eq 8}">
							${fn:substring(each.userbirth,0,4) }년${fn:substring(each.userbirth,4,6) }월${fn:substring(each.userbirth,6,8) }일
						</c:if>
						<c:if test="${fn:length(fn:trim(each.userbirth))  eq 6}">
							19${fn:substring(each.userbirth,0,4) }년${fn:substring(each.userbirth,4,6) }월${fn:substring(each.userbirth,6,8) }일
						</c:if>
					</td>
				</c:if>
				<c:if test='${fn:contains(column,"06")}'>
					<td>${each.useremail}</td>
				</c:if>
				<c:if test='${fn:contains(column,"07")}'>
					<td>
						<c:if test="${each.postuserselect  eq '1'}">
							자택
						</c:if>
						<c:if test="${each.postuserselect  eq '2'}">
							소속
						</c:if>
					</td>
				</c:if>
				<c:if test='${fn:contains(column,"08")}'>
					<td>${each.usermobile}</td>
				</c:if>
				<c:if test='${fn:contains(column,"10")}'>
					<td>
						<c:if test="${each.branch eq '1'}">부산울산경남지회</c:if>
						<c:if test="${each.branch eq '2'}">대구경북지회</c:if>
						<c:if test="${each.branch eq '3'}">강원지회</c:if>
						<c:if test="${each.branch eq '4'}">광주전남지회</c:if>
						<c:if test="${each.branch eq '5'}">대전세종충청지회</c:if>
						<c:if test="${each.branch eq '6'}">전라북도지회</c:if>
						<c:if test="${each.branch eq '7'}">제주지회</c:if>
					</td>
				</c:if>
				<c:if test='${fn:contains(column,"11")}'>
					<c:if test="${fn:length(fn:trim(each.userdatereg))  eq 8}">
						<fmt:parseDate value="${fn:trim(each.userdatereg)}" pattern="yyyyMMdd" var="isoDate" />
					</c:if>
					<c:if test="${fn:length(fn:trim(each.userdatereg))  eq 14}">
						<fmt:parseDate value="${fn:trim(each.userdatereg)}" pattern="yyyyMMddHHmmss" var="isoDate" />
					</c:if>
					<td>
						<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy년MM월dd일" />
					</td>
				</c:if>
				<c:if test='${fn:contains(column,"12")}'>
					<td>${each.useraddr}</td>
				</c:if>
				<c:if test='${fn:contains(column,"13")}'>
					<td style="mso-number-format:\@">${each.useraddrno}</td>
				</c:if>
				<c:if test='${fn:contains(column,"14")}'>
					<td>${each.usertel}</td>
				</c:if>
				<c:if test='${fn:contains(column,"15")}'>
					<td>${each.dept_nm}</td>
				</c:if>
				<c:if test='${fn:contains(column,"16")}'>
					<td>${each.dept_full_nm}</td>
				</c:if>
				<c:if test='${fn:contains(column,"17")}'>
					<td>${each.usercompanystatus}</td>
				</c:if>
				<c:if test='${fn:contains(column,"18")}'>
					<td>${each.usercaddr}</td>
				</c:if>
				<c:if test='${fn:contains(column,"19")}'>
					<td style='mso-number-format:\@'>${each.usercaddrno}</td>
				</c:if>
				<c:if test='${fn:contains(column,"20")}'>
					<td>${each.tel_offc}</td>
				</c:if>
				<c:if test='${fn:contains(column,"21")}'>
					<td>${each.userfax}</td>
				</c:if>
				<c:if test='${fn:contains(column,"22")}'>
					<td style='mso-number-format:\@'>${each.postuseraddrno}</td>
				</c:if>
				<c:if test='${fn:contains(column,"23")}'>
					<td>${each.postuseraddr}</td>
				</c:if>
				<c:if test='${fn:contains(column,"42")}'>
					<td>
					<c:if test="${each.postuseraddr2 eq null}">
						<c:if test="${each.postuserselect  eq '2'}">
							<c:if test="${each.dept_nm ne null}">
								${each.dept_nm}
							</c:if>
							<c:if test="${each.dept_full_nm ne null}">
								  ${each.dept_full_nm}
							</c:if>
						</c:if>
					</c:if>
					<c:if test="${each.postuseraddr2 ne null}">
						${each.postuseraddr2}
					</c:if>
					</td>
				</c:if>
				<c:if test='${fn:contains(column,"24")}'>
					<td>
						<c:if test="${each.work_grade eq '1'}">정회원</c:if>
						<c:if test="${each.work_grade eq '2'}">종신회원</c:if>
						<c:if test="${each.work_grade eq '3'}">준회원</c:if>
						<c:if test="${each.work_grade eq '6'}">외부심사위원</c:if>
					</td>
				</c:if>
				<c:if test='${fn:contains(column,"25")}'>
					<td>${each.executivenm}</td>
				</c:if>
				<c:if test='${fn:contains(column,"26")}'>
					<td>${each.committeenm}</td>
				</c:if>
				<c:if test='${fn:contains(column,"27")}'>
					<td>${each.graduation0}</td>
				</c:if>
				<c:if test='${fn:contains(column,"28")}'>
					<td>${each.university0}</td>
				</c:if>
				<c:if test='${fn:contains(column,"29")}'>
					<td>${each.major0}</td>
				</c:if>
				<c:if test='${fn:contains(column,"30")}'>
					<td>${each.graduation1}</td>
				</c:if>
				<c:if test='${fn:contains(column,"31")}'>
					<td>${each.university1}</td>
				</c:if>
				<c:if test='${fn:contains(column,"32")}'>
					<td>${each.major1}</td>
				</c:if>
				<c:if test='${fn:contains(column,"33")}'>
					<td>${each.graduation2}</td>
				</c:if>
				<c:if test='${fn:contains(column,"34")}'>
					<td>${each.university2}</td>
				</c:if>
				<c:if test='${fn:contains(column,"35")}'>
					<td>${each.major2}</td>
				</c:if>
				<c:if test='${fn:contains(column,"36")}'>
					<td>
						<c:if test="${each.lasteducation eq '0'}">학부</c:if>
						<c:if test="${each.lasteducation eq '1'}">석사</c:if>
						<c:if test="${each.lasteducation eq '2'}">박사</c:if>
						<c:if test="${each.lasteducation eq '3'}">기타</c:if>
					</td>
				</c:if>
				<c:if test='${fn:contains(column,"37")}'>
					<td>
						<c:if test="${each.workplace eq '01'}">대학교수</c:if>
						<c:if test="${each.workplace eq '02'}">연구소</c:if>
						<c:if test="${each.workplace eq '03'}">대학원생</c:if>
						<c:if test="${each.workplace eq '04'}">건설회사</c:if>
						<c:if test="${each.workplace eq '05'}">건축사사무소</c:if>
						<c:if test="${each.workplace eq '06'}">공공기관</c:if>
						<c:if test="${each.workplace eq '07'}">구조사무</c:if>
						<c:if test="${each.workplace eq '08'}">기타회사</c:if>
						<c:if test="${each.workplace eq '09'}">중고교</c:if>
						<c:if test="${each.workplace eq '10'}">외국인</c:if>
						<c:if test="${each.workplace eq '11'}">기타</c:if>
						<c:if test="${each.workplace eq '12'}">대학생</c:if>
						<c:if test="${each.workplace eq '13'}">기술용역</c:if>
						<c:if test="${each.workplace eq '14'}">엔지니어링</c:if>
						<c:if test="${each.workplace eq '15'}">도시경관/도시계획</c:if>
					</td>
				</c:if>
				<c:if test='${fn:contains(column,"38")}'>
					<td>${each.nominator}</td>
				</c:if>
				<c:if test='${fn:contains(column,"39")}'>
					<td>
						<c:if test="${each.paytype eq '1'}">온라인</c:if>
						<c:if test="${each.paytype eq '2'}">지로</c:if>
					</td>
				</c:if>
				<c:if test='${fn:contains(column,"50")}'>
					<c:if test='${fn:contains(searchUser.dueyear,"d2000")}'>
						<td>${each.d2000}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2001")}'>
						<td>${each.d2001}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2002")}'>
						<td>${each.d2002}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2003")}'>
						<td>${each.d2003}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2004")}'>
						<td>${each.d2004}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2005")}'>
						<td>${each.d2005}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2006")}'>
						<td>${each.d2006}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2007")}'>
						<td>${each.d2007}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2008")}'>
						<td>${each.d2008}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2009")}'>
						<td>${each.d2009}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2010")}'>
						<td>${each.d2010}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2011")}'>
						<td>${each.d2011}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2012")}'>
						<td>${each.d2012}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2013")}'>
						<td>${each.d2013}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2014")}'>
						<td>${each.d2014}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2015")}'>
						<td>${each.d2015}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2016")}'>
						<td>${each.d2016}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2017")}'>
						<td>${each.d2017}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2018")}'>
						<td>${each.d2018}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2019")}'>
						<td>${each.d2019}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"d2020")}'>
						<td>${each.d2020}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2000")}'>
						<td>${each.e2000}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2001")}'>
						<td>${each.e2001}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2002")}'>
						<td>${each.e2002}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2003")}'>
						<td>${each.e2003}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2004")}'>
						<td>${each.e2004}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2005")}'>
						<td>${each.e2005}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2006")}'>
						<td>${each.e2006}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2007")}'>
						<td>${each.e2007}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2008")}'>
						<td>${each.e2008}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2009")}'>
						<td>${each.e2009}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2010")}'>
						<td>${each.e2010}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2011")}'>
						<td>${each.e2011}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2012")}'>
						<td>${each.e2012}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2013")}'>
						<td>${each.e2013}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2014")}'>
						<td>${each.e2014}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2015")}'>
						<td>${each.e2015}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2016")}'>
						<td>${each.e2016}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2017")}'>
						<td>${each.e2017}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2018")}'>
						<td>${each.e2018}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2019")}'>
						<td>${each.e2019}</td>
					</c:if>
					<c:if test='${fn:contains(searchUser.dueyear,"e2020")}'>
						<td>${each.e2020}</td>
					</c:if>
				</c:if>
			</tr>
		</c:forEach>
		<c:if test="${input.total==0}">
			<tr>
				<td colspan="14" style="padding:20;">등록된 정보가 없습니다.</td>
			</tr>
		</c:if>
		</tbody>
	</table>
</c:if>
<c:if test="${act eq 'paperSubmit_excel_all'}">
<p style="text-align:center;font-size:13px;font-family:NANUM;">총 검색편 수 (<span style="color:red;font-weight:bold !important;">${fn:length(paperSubmitList) }</span>편 )</p>
<table class="input_table mgtype20" border="1" cellspacing="0" cellpadding="2" width="100%" summary="">
	<colgroup>
		<col style="width:3%" />
		<col style="width:3%" />
		<col />
		<col style="width:8%" />
		<col style="width:8%" />
		<col style="width:12%" />
		<col style="width:10%" />
		<col style="width:15%" />
	</colgroup>
	<thead>
		<tr>
			<th scope="col" class="first">접수번호</th>
			<th scope="col">접수일자</th>
			<th scope="col">논문제목</th>
			<th scope="col">투고자</th>
			<th scope="col">분야</th>
			<th scope="col">현재상태</th>
			<th scope="col">심사자</th>
			<th scope="col">심사결과</th>
		</tr>
	</thead>
	<tbody class="type02">
	<input type="hidden" name="psNo" id="psNo" value=""/>
		<c:forEach items="${paperSubmitList }" var="each" varStatus="loop">
		<fmt:parseDate value="${each.REGDATE }" var="regDate" pattern="yyyy-MM-dd HH:mm:ss"/>
		<tr>
			<td class="first subject" rowspan="3"><c:out value="${each.PSJOINNO}" /></td>
			<td rowspan="3"><fmt:formatDate value="${regDate }" pattern="yyyy년 MM월 dd일"/></td>
			<td rowspan="3">
				<c:out value="${each.PSKOTITLE  }"/>
					<c:if test="${each.PSCANCEL_YN eq 'Y'}">
					<div style="color:red">취소</div>
					</c:if>
			</td>
			<td rowspan="3"><c:out value="${each.USERNAME }" /></td>
			<td rowspan="3">
				<c:forEach items="${attrbList }" var="data2" varStatus="status2">
					<c:if test="${data2.code == each.PSTYPE }">${data2.codeNm }</c:if>
				</c:forEach>
			</td>
			<td rowspan="3">
				<c:if test="${each.PSCANCEL_YN eq 'Y'}">
					논문취소
				</c:if>
				<c:if test="${each.PSCANCEL_YN eq 'N'}">
					<c:forEach items="${attrbList2 }" var="data3" varStatus="status3">
						<c:if test="${data3.code == each.PSSTATUS }">
							<c:if test="${each.PSSTATUS eq '2'}">
								심사본 접수
							</c:if>
							<c:if test="${each.PSSTATUS eq '3'}">
								<c:if test="${each.CHECKREQUESTFILE eq 'Y'}">
									추가본 요청
								</c:if>
								<c:if test="${each.CHECKREQUESTFILE eq 'N'}">
									심사대기중
								</c:if>
							</c:if>
							<c:if test="${each.PSSTATUS eq '4'}">
								게재불가
							</c:if>
							<c:if test="${each.PSSTATUS eq '5'}">
								<c:if test="${each.PSLASTFILENAME eq null }">
									최종본 요청
								</c:if>
								<c:if test="${each.PSLASTFILENAME ne null }">
									최종본 등록
								</c:if>
							</c:if>
							<c:if test="${each.PSSTATUS ne '2' && each.PSSTATUS ne '3' && each.PSSTATUS ne '4' && each.PSSTATUS ne '5'}">
								${data3.codeNm }
							</c:if>
						</c:if>
					</c:forEach>
				</c:if>
			</td>

			<c:if test="${fn:length(each.examList) ne 0}">
				<c:forEach items="${each.examList }" var="exam" varStatus="examStatus">
					<c:if test="${examStatus.count%3 == 0 || examStatus.count%3 == 2 }">
					<tr>
					</c:if>
						<td><c:out value="${exam.USERNAME }"/></td>
						<td>
							<c:if test="${exam.PEIRESULT eq null }">
								<c:choose>
									<c:when test="${exam.PEREJECT == 'Y'}">
										심사거부
									</c:when>
									<c:when test="${exam.PEEMAILYN == 'N'}">
										메일방송전
									</c:when>
									<c:when test="${exam.PEEMAILYN == 'Y'}">
										<c:choose>
											<c:when test="${exam.PEACCOUNT eq null }">
												<c:if test="${exam.PEEXAMDATE ne null }">
													<fmt:parseDate value="${exam.PEEXAMDATE }" var="examDate1" pattern="yyyy-MM-dd HH:mm:ss"/>
													<fmt:formatDate value="${examDate1}" var="examDate2" pattern="yyyy-MM-dd" />
													<%
													java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
													Date today = new Date ();
													Date beginDate = formatter.parse(pageContext.getAttribute("examDate2").toString());
												    Date endDate = formatter.parse(formatter.format(today));

												    long diff = endDate.getTime() - beginDate.getTime();
												    long diffDays = diff / (24 * 60 * 60 * 1000);
												    System.out.println ( "diffDays===>"+diffDays);
													%>
													심사전(
													<c:if test="<%=diffDays <= 0 %>"><c:out value="<%=-diffDays%>" />일 남음</c:if>
													<c:if test="<%=diffDays > 0 %>"><c:out value="<%=diffDays%>" />일 지남</c:if>
													)[${each.PSSTEP }차]
												</c:if>
											</c:when>
											<c:otherwise>
												심사전[${each.PSSTEP }차]
											</c:otherwise>
										</c:choose>
									</c:when>
								</c:choose>
							</c:if>
							<c:if test="${exam.PEIRESULT ne null }">
								<c:forEach items="${attrbList3 }" var="data3" varStatus="status3">
									<c:if test="${data3.code == exam.PEIRESULT }">${data3.codeNm }</c:if>
								</c:forEach>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<c:set var="size" value="${fn:length(each.examList) }"/>
				<c:if test="${size==2 }">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				</c:if>
				<c:if test="${size==1 }">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				</c:if>
			</c:if>
			<c:if test="${fn:length(each.examList) eq 0}">
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
		</c:forEach>
		<c:if test="${input.total==0}">
			<tr>
				<td colspan="8" style="padding:20;text-align:center">검색결과가 없습니다.</td>
			</tr>
		</c:if>
	</tbody>
</table>

</c:if>

<c:if test="${act eq 'paperSubmitDetail_excel_all'}">
<p style="text-align:center;font-size:13px;font-family:NANUM;">총 검색편 수 (<span style="color:red;font-weight:bold !important;">${fn:length(paperSubmitList) }</span>편 )</p>
<table class="input_table mgtype20" border="1" cellspacing="0" cellpadding="2" width="150%" summary="">
				<colgroup>
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:10%" />
					<col style="width:5%" />
					<col style="width:10%" />
					<col />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">투고자명</th>
						<th scope="col">주저자</th>
						<th scope="col">교신저자</th>
						<th scope="col">공동저자명</th>
						<th scope="col">게재예정일</th>
						<th scope="col">접수번호</th>
						<th scope="col">논문제목</th>
						<th scope="col">분야</th>
						<th scope="col">키워드</th>
						<th scope="col">영문초록</th>
					</tr>
				</thead>
				<tbody class="type02">
					<c:forEach items="${paperSubmitList }" var="data" varStatus="loop">
					<fmt:parseDate value="${each.PSDUEDATE }" var="dueDate" pattern="yyyy-MM"/>
					<fmt:formatDate value="${dueDate}" var="dueDate2" pattern="yyyy년 MM월" />
					<tr>
						<td><c:out value="${each.USERNAME }" /></td>
						<td><c:out value="${each.ANAME }" /></td>
						<td><c:out value="${each.CANAME }" /></td>
						<td>
							<c:forEach items="${each.auList }" var="auData" varStatus="loop">
								<c:out value="${auData.AINAME }" />,
							</c:forEach>
						</td>
						<td><c:out value="${dueDate2}" /></td>
						<td><c:out value="${each.PSJOINNO}" /></td>
						<td><c:out value="${each.PSKOTITLE }" />[<c:out value="${each.PSENTITLE }" />]</td>
						<td>
							<c:forEach items="${attrbList }" var="data2" varStatus="status2">
								<c:if test="${data2.code == each.PSTYPE }">${data2.codeNm }</c:if>
							</c:forEach>
						</td>
						<td><c:out value="${each.PSKEYWORD }" />,<c:out value="${each.PSENKEYWORD }" /></td>
						<td><c:out value="${each.PSENCONTENTS }" /></td>
					</c:forEach>
					<c:if test="${input.total==0}">
						<tr>
							<td colspan="10" style="padding:20;text-align:center">검색결과가 없습니다.</td>
						</tr>
					</c:if>
				</form>
				</tbody>
			</table>

</c:if>


</body>
</html>