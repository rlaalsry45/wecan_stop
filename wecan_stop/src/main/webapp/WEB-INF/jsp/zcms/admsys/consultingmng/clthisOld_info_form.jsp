<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<ul class="homepagebbs">
	<li class="bg"><h3 class="sub">구)신고서기록</h3>
	<li>
		<div class="main_table" id="workPage" style="min-height:400px;/* overflow-y:scroll; */">
	
			<!--구)신고서기록 등록 영역-->
			<% pageContext.setAttribute("newLineChar", "\n"); %>
			<div class="sta_headers">공공부문 직장내 성희롱·성폭력  신고센터</div>
			<div class="sta_header">신&nbsp;&nbsp;&nbsp;고&nbsp;&nbsp;&nbsp;서</div>
			<div class="sta_header_date">접수날짜 : ${fn:substring(data.wr_datetime,0,4) }년 &nbsp;${fn:substring(data.wr_datetime,5,7) }월 &nbsp;${fn:substring(data.wr_datetime,8,10) }일</div>
			<table class="main_table1" summary="구)신고서기록 항목을 보여줍니다.">
				<colgroup>
					<col width="10%" />
					<col width="10%" />
					<col width="20%" />
					<col width="10%" />
					<col width="20%" />
					<col width="10%" />
					<col width="20%" />
				</colgroup>
				<tr>
					<th rowspan="6">신고인</th>
					<th>이름</th>
					<td>${data.app_name}</td>
					<th>성별</th>
					<td>${data.app_sex}</td>
					<th>생년월일</th>
					<td>${data.app_bir}</td>
				</tr>
				<tr>
					<th>현재 소속 및 직급<span style="color:red;">*</span></th>
					<td colspan="2">${data.app_dep}</td>
					<th>사건발생 당시 소속 및 직급</th>
					<td colspan="2">${data.app_dep2}</td>
				</tr>				
				<tr>
					<th>상급기관(감독기관)</th>
					<td colspan="2">${data.app_rel}</td>
					<th>&nbsp;</th>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<th>관계</th>
					<td colspan="5">${data.app_rel2}</td>
				</tr>
				<tr>
					<th>직장주소</th>
					<td colspan="5">${data.app_dadd}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td colspan="2">☎ ${data.app_tel} 휴대폰 ${data.app_pho}</td>
					<th>e-mail</th>
					<td colspan="2">${data.app_eml}</td>
				</tr>
				<tr>
					<td colspan="6">* 대리 신고에 대한 당사자의 동의가 있었습니까? <c:choose><c:when test="${data.agree_1 eq '1'}">예</c:when><c:otherwise>아니오</c:otherwise></c:choose></td>
				</tr>
				<tr>
					<th rowspan="6">피신고인</th>
					<th>이름</th>
					<td>${data.dec_name}</td>
					<th>성별</th>
					<td>${data.dec_sex}</td>
					<th>연령대</th>
					<td>${data.dec_bir}</td>
				</tr>
				<tr>
					<th>현재 소속 및 직급<span style="color:red;">*</span></th>
					<td colspan="2">${data.dec_dep}</td>
					<th>사건발생 당시 소속 및 직급</th>
					<td colspan="2">${data.dec_dep2}</td>
				</tr>				
				<tr>
					<th>상급기관(감독기관)</th>
					<td colspan="2">${data.dec_rel}</td>
					<th>&nbsp;</th>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<th>직장주소</th>
					<td colspan="5">${data.dec_addr}</td>
				</tr>
			</table>

			<div class="sta_header_l">1. 피해사실</div>
			<table class="main_table1" summary="피해사실 항목을 보여줍니다.">
				<colgroup>
					<col width="3%" />
					<col width="17%" />
					<col width="80%" />
				</colgroup>
				<tr>
					<th rowspan="2">1</th>
					<th>최초 발생 시점</th>
					<td style="text-align:left;">${data.time_s}</td>
				</tr>
				<tr>
					<th>최근 발생 시점</th>
					<td style="text-align:left;">${data.time_r}</td>
				</tr>
				<tr>
					<th>2</th>
					<th>사건 발생 장소</th>
					<td style="text-align:left;">${data.time_p}</td>
				</tr>
				<tr>
					<th>3</th>
					<th>피해자와<br>피신고인간의<br>관계</th>
					<td style="text-align:left;">${fn:replace(data.vic_rel,newLineChar,'<br>')}</td>
				</tr>
				<tr>
					<th>4</th>
					<th>조력자 및<br>지원받고 있는<br>기관</th>
					<td style="text-align:left;">${fn:replace(data.hp_dec,newLineChar,'<br>')}</td>
				</tr>
				<tr>
					<th>5</th>
					<th>주요 피해 및<br>호소 내용</th>
					<td><textarea style="width:1080px;height:200px;overflow-y:scroll" name="content" id="content" disabled="disabled">${data.wr_content}</textarea></td>
				</tr>
				<tr>
					<th>6</th>
					<th>사건 처리경과</th>
					<td style="text-align:left;">${fn:replace(data.hp_text1,newLineChar,'<br>')}</td>
				</tr>
				<tr>
					<th>7</th>
					<th>사건 발생기관의 조치</th>
					<td style="text-align:left;">${fn:replace(data.hp_text2,newLineChar,'<br>')}</td>
				</tr>
			</table>
			
			<div class="sta_header_l">2. 피해자가 원하는 조치 (복수 선택) </div>
			<table class="main_table1" summary="피해자가 원하는 조치 항목을 보여줍니다.">
				<colgroup>
					<col width="3%" />
					<col width="97%" />
				</colgroup>
				<tr>
					<th>1</th>
					<td style="text-align:left;">재발 방지를 통한 조직문화 개선 요청 : <c:choose><c:when test="${data.act_5 eq '1'}">예</c:when><c:otherwise>아니오</c:otherwise></c:choose></td>
				</tr>
				<tr>
					<th>2</th>
					<td style="text-align:left;">소속기관의 조사 및 그에 따른 조치 요청 : <c:choose><c:when test="${data.act_10 eq '소속기관의 조사 및 그에 따른 조치 요청'}">예</c:when><c:otherwise>아니오</c:otherwise></c:choose></td>
				</tr>
				<tr>
					<th>3</th>
					<td style="text-align:left;">상급기관의 조사 및 그에 따른 조치 요청 : <c:choose><c:when test="${data.act_10 eq '상급기관의 조사 및 그에 따른 조치 요청'}">예</c:when><c:otherwise>아니오</c:otherwise></c:choose></td>
				</tr>
				<tr>
					<th>4</th>
					<td style="text-align:left;">감사원, 국가인권위원회의 조사 (사건 이첩) : <c:choose><c:when test="${data.act_10 eq '감사원, 국가인권위원회의 조사 (사건 이첩)'}">예</c:when><c:otherwise>아니오</c:otherwise></c:choose></td>
				</tr>
				<tr>
					<th>5</th>
					<td style="text-align:left;">소속기관의 합의 중재 및 조정 요청 : <c:choose><c:when test="${data.act_10 eq '소속기관의 합의 중재 및 조정 요청'}">예</c:when><c:otherwise>아니오</c:otherwise></c:choose></td>
				</tr>
				<tr>
					<th>6</th>
					<td style="text-align:left;">공간 분리 조치 : <c:choose><c:when test="${data.act_4 eq '1'}">예</c:when><c:otherwise>아니오</c:otherwise></c:choose></td>
				</tr>
				<tr>
					<th>7</th>
					<td style="text-align:left;">외부 상담 및 법적·의료 등 지원 연계 : <c:choose><c:when test="${data.act_8 eq '1'}">예</c:when><c:otherwise>아니오</c:otherwise></c:choose></td>
				</tr>
				<tr>
					<th>8</th>
					<td style="text-align:left;">기타 : <c:choose><c:when test="${data.act_6 eq '1'}">예(${data.act_6_etc})</c:when><c:otherwise>아니오</c:otherwise></c:choose></td>
				</tr>
				<tr>
					<th>9</th>
					<td style="text-align:left;"><span style="color:red;">*표시된 항목 관련)</span>사건발생기관에 전문가(변호사, 노무사, 성폭력 전문 상담가 등)로 구성된 컨설팅 위원단을 파견할 예정입니다. 민간사업장의 경우 사건발생기관에서 별도로 신청할 때에만 파견 가능합니다.<br>
					컨설팅을 원하지 않는 경우 다음 항목에 체크해 주시기 바랍니다.<br><br>
					(<span style="color:red;"><c:choose><c:when test="${data.act_7 eq '1'}">컨설팅 파견을 원함</c:when><c:otherwise>컨설팅 파견을 원하지 않음</c:otherwise></c:choose></span>)<br>
					<span style="color:red;">원하지 않는 이유</span> : ${data.act_9}</td>
				</tr>
			</table>
			
			<table class="main_table1" summary="구)신고서기록 답변항목을 보여줍니다.">
				<colgroup>
					<col width="10%" />
					<col width="15%" />
					<col width="10%" />
					<col width="15%" />
					<col width="10%" />
					<col width="15%" />
					<col width="10%" />
					<col width="15%" />
				</colgroup>
				<tr>
					<th>답변</th>
					<td colspan="8">
						<textarea style="width:1080px;height:200px;" name="answer" id="answer" disabled="disabled">
							 <c:forEach items="${answerList}" var="each" varStatus="status">
							 	${each.wr_answer}
							 </c:forEach>
						</textarea>
					</td>
				</tr>
			</table>
			<!--/구)신고서기록 등록 영역-->
		</div>
		<!--/main_table-->
		<div class="top_bt">
			<a href="/admsys/consultingmng/clthisOld.html" class="btmore01" >목록</a>
		</div>	   
	</li>
</ul>
<script>
	
 	for(i=0;i<$("td[name=dateTd]").size();i++){
 		document.getElementsByName("dateTd")[i].innerText=$("td[name=dateTd]").get(i).textContent.replace('.0',"");
	}

</script>