<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
	function downFile(order){
		<c:set var="atchFilePath" value="${detail.name_first}_${detail.name_last}_${detail.year_birth}${detail.mon_birth}${detail.day_birth}"/>
		var params = "?atchFilePath=${atchFilePath}&order="+order;
		window.open("down.html" + params, "_new", "");
	}
</script>
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/site/salzburg/index.html" title="salzburg로 이동">salzburg list</a>
						<span>salzburg info</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="page_title">
				<h2>salzburg info</h2>
			</div>
			<div id="content">
				<form:form modelAttribute="salzburgVO" name="frm" method="post">
				<input type="hidden" name="cond2" value="${input.cond2}" />
				<input type="hidden" name="keyword" value="${input.keyword}" />
				<input type="hidden" name="pageIndex" value="${input.pageIndex}" />
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="salzburg info">
					<caption>salzburg info</caption>
					<colgroup>
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
					</colgroup>
					<tr>
						<th>TITLE</th>
						<td colspan="7">${detail.title}</td>
					</tr>
					<tr>
						<th>FAMILY (LAST) NAME</th>
						<td>${detail.name_last}</td>
						<th>GIVEN (FIRST) NAME</th>
						<td>${detail.name_first}</td>
						<th>MIDDLE NAME</th>
						<td>${detail.name_middle}</td>
						<th>GENDER</th>
						<td>${detail.gender}</td>
					</tr>
					<tr>
						<th>REGISTERING FOR SESSION</th>
						<td colspan="7">
							<c:set var="se_regs" value=",1 Russian Civil Society Summit
														,2 Conflict Transformation through Culture
														,3 New Dynamics in Global Trade Architecture
														,4 Mind the Gap!
														,5 Holocaust and Genocide Education
														,6 Patient Voices in Mental Health Care
														,7 Students at the Margins and the Institutions
														,8 Young Cultural Innovators
														,9 Africaâs Growth Engine
														,10 The Economics of Aging Societies
														,11 Realizing the Right to Health" />
							<c:set var="delim" value=","/> 
							<c:set var="array" value="${fn:split(se_regs, delim)}"/> 
							<c:out value="${array[detail.se_reg1]}"/></br>
							<c:out value="${array[detail.se_reg2]}"/></br>
							<c:out value="${array[detail.se_reg3]}"/>
						</td>
					</tr>
					<tr>
						<th>BIRTHDATE</th>
						<td>${detail.year_birth}-${detail.mon_birth}-${detail.day_birth}</td>
						<th>CITIZENSHIP</th>
						<td colspan="5">${detail.citienship}</td>
					</tr>
					<tr>
						<th>BUSINESS ADDRESS</th>
						<td colspan="7">
							<table class="input_table" border="0" cellspacing="0" cellpadding="2" width="100%" summary="BUSINESS ADDRESS">
								<caption>BUSINESS ADDRESS</caption>
								<colgroup>
									<col width="15%" />
									<col />
								</colgroup>
								<tr>
									<th>POSITION</th>
									<td>${detail.pos_bus}</td>
								</tr>
								<tr>
									<th>ORGANIZATION</th>
									<td>${detail.organ_bus}</td>
								</tr>
								<tr>
									<th>STREET ADDRESS</th>
									<td>${detail.addr_bus}</td>
								</tr>
								<tr>
									<th>POSTAL CODE</th>
									<td>${detail.pcode_bus}</td>
								</tr>
								<tr>
									<th>CITY</th>
									<td>${detail.city_bus}</td>
								</tr>
								<tr>
									<th>COUNTRY</th>
									<td>${detail.country_bus}</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<th>BUSINESS TELEPHONE</th>
						<td colspan="7">
							<table class="input_table" border="0" cellspacing="0" cellpadding="2" width="100%" summary="BUSINESS TELEPHONE">
								<caption>BUSINESS TELEPHONE</caption>
								<colgroup>
									<col width="15%" />
									<col />
								</colgroup>
								<tr>
									<th>COUNTRY CODE</th>
									<td>${detail.ccode_bustel}</td>
								</tr>
								<tr>
									<th>CITY/AREA CODE</th>
									<td>${detail.cacode_bustel}</td>
								</tr>
								<tr>
									<th>TELEPHONE NO.</th>
									<td>${detail.tel_bustel}</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<th>BUSINESS FAX</th>
						<td colspan="7">
							<table class="input_table" border="0" cellspacing="0" cellpadding="2" width="100%" summary="BUSINESS FAX">
								<caption>BUSINESS FAX</caption>
								<colgroup>
									<col width="15%" />
									<col />
								</colgroup>
								<tr>
									<th>COUNTRY CODE</th>
									<td>${detail.ccode_busfax}</td>
								</tr>
								<tr>
									<th>CITY/AREA CODE</th>
									<td>${detail.cacode_busfax}</td>
								</tr>
								<tr>
									<th>FAX NO.</th>
									<td>${detail.fax_busfax}</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<th>E-MAIL ADDRESS</th>
						<td colspan="7">${detail.email}</td>
					</tr>
					<tr>
						<th>MOBILE NO.</th>
						<td colspan="7">${detail.mobile}</td>
					</tr>
					<tr>
						<th>Attach File</th>
						<td colspan="7">
							<a href="#" onclick="downFile('1')">1. A curriculum vitae</a><br/>
							<a href="#" onclick="downFile('2')">2. One passport-size photograph for the Fellow directory</a><br/>
							<a href="#" onclick="downFile('3')">3. A personal statement explaining reasons for choosing this session</a>
						</td>
					</tr>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<!--/사이트 추가-->
				<div class="confirm">
					<p>
						<input type="button" value="prev" style="width:70px;height:20px" onclick="if (${detail.prevno}>0) {document.forms[0].action='?logno=${detail.prevno}';document.forms[0].submit();} else {alert('first record.')}"/>
						<a href="javascript:void(0)" onclick="document.forms[0].action='index.html';document.forms[0].submit();"><img src="/cms/image/btn_confirm.jpg" alt="OK" /></a>
						<input type="button" value="next" style="width:70px;height:20px" onclick="if (${detail.nextno}>0) {document.forms[0].action='?logno=${detail.nextno}';document.forms[0].submit();} else {alert('last record.')}"/>
					</p>
				</div><!--/confirm-->
				</form:form>
			</div><!--/content-->
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>