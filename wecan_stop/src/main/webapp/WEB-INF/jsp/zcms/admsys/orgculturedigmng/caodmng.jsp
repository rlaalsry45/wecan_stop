<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />

	<c:set var="fntyp1" value="N"/>
	<c:forEach items="${perm}" var="p" varStatus="ini">
		<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
			<c:set var="fntyp1" value="Y"/>
			
            <div id="contents">
                <form:form modelAttribute="WConsultingActionOldDeclarationVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/index.html">진단관리</a> <strong>구 진단(신고) </strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
<!--                             <select style="height:27px;" name="cond1"> -->
<%--                                 <option value="reg_date" <c:if test="${input.cond1=='regDate'}"><c:out value='selected' /></c:if>>등록일</option> --%>
<!--                             </select> -->
<%-- 							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" /> --%>
<%-- 							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" /> --%>
<%-- 							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~ --%>
<%-- 							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;"> --%>
                            <select style="height:27px;" name="cond2">
                                <option value="consulting_action_no" <c:if test="${input.cond2=='consulting_action_no'}"><c:out value='selected' /></c:if>>사건번호</option>
                                <option value="org_name" <c:if test="${input.cond2=='org_name'}"><c:out value='selected' /></c:if>>기관명</option>
                                <option value="org_type" <c:if test="${input.cond2=='org_type'}"><c:out value='selected' /></c:if>>상담유형</option>
                                <option value="org_type_gov_detail" <c:if test="${input.cond2=='org_type_gov_detail'}"><c:out value='selected' /></c:if>>기관유형</option>
                            	<option value="manager" <c:if test="${input.cond2=='manager'}"><c:out value='selected' /></c:if>>종합지원센터 담당자</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="search();" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">구 진단(신고) 목록</h3></li>
                            <li>
                            <div class="top_bt">
                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
                            </div>

                                <div class="main_table" style="width:100%;overflow:auto;">
                                    <!--게시판 영역-->
                                    <table class="main_table1" summary="연번, 사건번호, 기관명, 상급기관, 상담유형 등등" style="white-space:nowrap;">
                                        <caption>관리목록</caption>
                                        <thead>
                                            <tr>
                                                <th>연번</th>
                                                <th>사건번호</th>
                                                <th>기관명</th>
                                                <th>상급기관</th>
                                                <th>상담유형</th>
                                                <th>공공</th>
                                                <th>민간</th>
                                                <th>기타</th>
                                                <th>기관유형</th>
                                                <th>국가기관</th>
                                                <th>지방자치단체</th>
                                                <th>공공기관</th>
                                                <th>각급학교</th>
                                                <th>민간</th>
                                                <th>기타</th>
                                                <th>컨설팅희망여부</th>
                                                <th>심의대기</th>
                                                <th>이관</th>
                                                <th>수사및<br>조사의뢰</th>
                                                <th>각하</th>
                                                <th>취하</th>
                                                <th>단순종결<br>(연락x)</th>
                                                <th>확인필요</th>
                                                <th>공문발송예정</th>
                                                <th>공문발송완료</th>
                                                <th>컨설팅예정</th>
                                                <th>컨설팅완료</th>
                                                <th>조치결과수신</th>
                                                <th>조치결과수신</th>
                                                <th>종합지원센터<br>담당자</th>
                                                <th>여성가족부</th>
                                                <th>1월</th>
                                                <th>2월</th>
                                                <th>3월</th>
                                                <th>4월</th>
                                                <th>5월</th>
                                                <th>6월</th>
                                                <th>7월</th>
                                                <th>8월</th>
                                                <th>9월</th>
                                                <th>10월</th>
                                                <th>11월</th>
                                                <th>12월</th>
                                                <th>사건접수</th>
                                                <th>공문발송</th>
                                                <th>컨설팅</th>
                                                <th>조치결과제출일</th>
                                                <th>종결</th>
                                                <th>1개월</th>
                                                <th>6개월</th>
                                                <th>상담의료법률(명)</th>
                                                <th>성폭력상담소</th>
                                                <th>해바라기센터/<br>1366</th>
                                                <th>법률지원등<br>연계</th>
                                                <th>여성노동자회</th>
                                                <th>노무법률자문</th>
                                                <th>정신과진료등<br>연계</th>
                                                <th>소속기관</th>
                                                <th>상급기관</th>
                                                <th>수사기관</th>
                                                <th>법원</th>
                                                <th>고용노동부</th>
                                                <th>지방중앙노동<br>위원회</th>
                                                <th>교육부</th>
                                                <th>국가인권위원회</th>
                                                <th>국민신문고/<br>청와대청원</th>
                                                <th>기타</th>
                                                <th>최초발생</th>
                                                <th>최근발생</th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th>언행</th>
                                                <th>언어적<br>물리적</th>
                                                <th>성추행<br>강간중강간</th>
                                                <th>문자영상</th>
                                                <th>폭언폭행</th>
                                                <th>협박소문유포<br>인사불이익</th>
                                                <th>0:분리x<br>1:분리o<br>미기재:알수없음</th>
                                                <th>고충상담</th>
                                                <th>공식신고절차</th>
                                                <th></th>
                                                <th>경찰검찰<br>고소고발진정</th>
                                                <th>민형사소송</th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th>행위자</th>
                                                <th>피해자</th>
                                                <th></th>
                                                <th>여</th>
                                                <th>남</th>
                                                <th>미상</th>
                                                <th></th>
                                                <th>본인</th>
                                                <th>대리인</th>
                                                <th>제3자</th>
                                                <th></th>
                                                <th>여</th>
                                                <th>남</th>
                                                <th>미상</th>
                                                <th></th>
                                                <th></th>
                                                <th>남</th>
                                                <th>여</th>
                                                <th>미상</th>
                                                <th>공공기관장건</th>
                                                <th></th>
                                                <th>휴대폰</th>
                                                <th>이메일</th>
                                                <th>휴대폰</th>
                                                <th>이메일</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="each" varStatus="loop">
                                                <tr>
                                                    <td>${each.NO}</td>
                                                    <td>${each.consulting_action_no}</td>
                                                    <td>${each.org_name}</td>
                                                    <td>${each.upper_org_name}</td>
                                                    <td>${each.org_type}</td>
                                                    <td>${each.org_type_gov}</td>
                                                    <td>${each.org_type_priv}</td>
                                                    <td>${each.org_type_etc}</td>
                                                    <td>${each.org_type_gov_detail}</td>
                                                    <td>${each.org_type_gov_detail_national}</td>
                                                    <td>${each.org_type_gov_detail_local}</td>
                                                    <td>${each.org_type_gov_detail_public}</td>
                                                    <td>${each.org_type_gov_detail_school}</td>
                                                    <td>${each.org_type_gov_detail_priv}</td>
                                                    <td>${each.org_type_gov_detail_etc}</td>
                                                    <td>${each.consulting_desired}</td>
                                                    <td>${each.action_type_cont_review_wait}</td>
                                                    <td>${each.action_type_cont_move}</td>
                                                    <td>${each.action_type_cont_con}</td>
                                                    <td>${each.action_type_cont_cancel}</td>
                                                    <td>${each.action_type_cont_giveup}</td>
                                                    <td>${each.action_type_cont_simple_end}</td>
                                                    <td>${each.action_type_cont_confirm_need}</td>
                                                    <td>${each.official_letter_expect}</td>
                                                    <td>${each.official_letter_complete}</td>
                                                    <td>${each.consulting_expect}</td>
                                                    <td>${each.consulting_complete}</td>
                                                    <td>${each.action_result_receive_1}</td>
                                                    <td>${each.action_result_receive_2}</td>
                                                    <td>${each.manager}</td>
                                                    <td>${each.org_women}</td>
                                                    <td>${each.month_1}</td>
                                                    <td>${each.month_2}</td>
                                                    <td>${each.month_3}</td>
                                                    <td>${each.month_4}</td>
                                                    <td>${each.month_5}</td>
                                                    <td>${each.month_6}</td>
                                                    <td>${each.month_7}</td>
                                                    <td>${each.month_8}</td>
                                                    <td>${each.month_9}</td>
                                                    <td>${each.month_10}</td>
                                                    <td>${each.month_11}</td>
                                                    <td>${each.month_12}</td>
                                                    <td>${each.accident_receive}</td>
                                                    <td>${each.official_letter_send}</td>
                                                    <td>${each.consulting}</td>
                                                    <td>${each.action_result_submission}</td>
                                                    <td>${each.end}</td>
                                                    <td>${each.month}</td>
                                                    <td>${each.sixmonth}</td>
                                                    <td>${each.consulting_medical_law}</td>
                                                    <td>${each.sexual_violence_consultation_center}</td>
                                                    <td>${each.sunflower_center_1366}</td>
                                                    <td>${each.legal_support_servie_rel}</td>
                                                    <td>${each.women_worker_association}</td>
                                                    <td>${each.labor_law_advice}</td>
                                                    <td>${each.psychiatric_care_servie_rel}</td>
                                                    <td>${each.org}</td>
                                                    <td>${each.org_upper}</td>
                                                    <td>${each.org_investigation}</td>
                                                    <td>${each.org_scourt}</td>
                                                    <td>${each.org_labor}</td>
                                                    <td>${each.org_nirc}</td>
                                                    <td>${each.org_education}</td>
                                                    <td>${each.org_human}</td>
                                                    <td>${each.org_epeople_cheongwadae_petition}</td>
                                                    <td>${each.org_etc}</td>
                                                    <td>${each.first_occurence}</td>
                                                    <td>${each.later_occurrence}</td>
                                                    <td>${each.empty_items1_1}</td>
                                                    <td>${each.empty_items1_2}</td>
                                                    <td>${each.empty_items1_3}</td>
                                                    <td>${each.empty_items1_4}</td>
                                                    <td>${each.sayings_and_doings}</td>
                                                    <td>${each.physical_linguistic}</td>
                                                    <td>${each.rape_sexual_harass}</td>
                                                    <td>${each.text_image}</td>
                                                    <td>${each.violent_verbal_abuse}</td>
                                                    <td>${each.threatened_rumors_private_disadvantages}</td>
                                                    <td>${each.isolation_status}</td>
                                                    <td>${each.complaint_consultation}</td>
                                                    <td>${each.official_reporting_procedure}</td>
                                                    <td>${each.empty_items2_1}</td>
                                                    <td>${each.police_prosecutor_accusation_charge}</td>
                                                    <td>${each.civil_and_criminal_proceedings}</td>
                                                    <td>${each.empty_items2_2}</td>
                                                    <td>${each.empty_items2_3}</td>
                                                    <td>${each.empty_items2_4}</td>
                                                    <td>${each.empty_items2_5}</td>
                                                    <td>${each.empty_items2_6}</td>
                                                    <td>${each.offender}</td>
                                                    <td>${each.victim}</td>
                                                    <td>${each.empty_items3_1}</td>
                                                    <td>${each.women_1}</td>
                                                    <td>${each.man_1}</td>
                                                    <td>${each.unknown_1}</td>
                                                    <td>${each.empty_items3_2}</td>
                                                    <td>${each.me}</td>
                                                    <td>${each.agent}</td>
                                                    <td>${each.third_party}</td>
                                                    <td>${each.empty_items4_1}</td>
                                                    <td>${each.women_2}</td>
                                                    <td>${each.man_2}</td>
                                                    <td>${each.unknown_2}</td>
                                                    <td>${each.empty_items4_2}</td>
                                                    <td>${each.empty_items5_1}</td>
                                                    <td>${each.man_3}</td>
                                                    <td>${each.women_3}</td>
                                                    <td>${each.unknown_3}</td>
                                                    <td>${each.state_run_organization}</td>
                                                    <td>${each.empty_items5_2}</td>
                                                    <td>${each.tel_no_1}</td>
                                                    <td>${each.email_1}</td>
                                                    <td>${each.tel_no_2}</td>
                                                    <td>${each.email_2}</td>
                                                    <td>${each.region}</td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="115" style="padding:20;">등록된 정보가 없습니다.</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                                    <!--/게시판 영역-->
									<!--설명-->
<!--									<p class="notification_right01">
										<img src="/cms/image/excla.gif" alt="!">
										1. [홈페이지 목록/등록] 메뉴에서 [홈페이지등록]을 클릭한 후 관련 정보를 입력 합니다. <br />
										<img src="/cms/image/excla.gif" alt="!">
										2. 생성된 홈페이지 목록 우측의  [환경설정]버튼을 클릭하여 홈페이지 제작에 필요한 가장 기본적인 정보를 셑팅합니다.<br />
										<img src="/cms/image/excla.gif" alt="!">
										3. [홈페이지 목록/등록] &gt; [홈페이지등록]메뉴에서 홈페이지를 등록하시면 [메뉴/콘텐츠 관리]에서 자동으로 카테고리를 관리할 수 있는 홈페이지 목록이 생성 됩니다.<br />
										<img src="/cms/image/excla.gif" alt="!">
										4. 원하시는 홈페이지를 셑팅하기 위해서는 미리 코딩해둔 메인페이지 Html 및 css파일, js파일을 각각 [메인페이지 관리], [CSS관리], [JS관리]에 미리 등록해 두어야 합니다.<br />
										<img src="/cms/image/excla.gif" alt="!">
										5. 따로 [메인페이지 관리]에서 메인페이지를 등록하시지 않아도 [메뉴/콘텐츠 관리]메뉴의  메인페이지 역할을 하는 페이지를 생성하여 메뉴리다이렉트 기능을 이용하셔도 무방합니다.
										</p>-->
									<!--/설명-->
								<div class="top_bt">
									<c:forEach items="${perm}" var="p" varStatus="ini">
										<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_4' and p.ALLOW_YN eq 'Y' }">
											<a class="btmore05" href="javascript:excelDownload();">엑셀다운로드</a>
										</c:if>
									</c:forEach>
                            	</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        <script type="text/javascript">
							
							function search(){
								$("#WConsultingActionOldDeclarationVo").attr("action","/admsys/orgculturedigmng/caodmng.html");
								$("#WConsultingActionOldDeclarationVo").submit();
							}
							
							function excelDownload(){
								var eForm = $("#WConsultingActionOldDeclarationVo").serialize();
								
								$.ajax({
									  type: 'POST',
									  url: "/admsys/orgculturedigmng/caodmng_excel.html",
									  data: eForm,
									  traditional:true,
									  success: function(result){
										  exportExcel(result.list);
									  },
									  error:function(e){
										  alert("엑셀 다운로드중 오류가 발생하였습니다."+e.responseText  );
									  }
								});
							}
							
							function s2ab(s) { 
	                     	    var buf = new ArrayBuffer(s.length); //convert s to arrayBuffer
	                     	    var view = new Uint8Array(buf);  //create uint8array as viewer
	                     	    for (var i=0; i<s.length; i++) view[i] = s.charCodeAt(i) & 0xFF; //convert to octet
	                     	    return buf;    
	                     	}
	                        
	                        function exportExcel(data){ 
	                     	    // step 1. workbook 생성
	                     	    var wb = XLSX.utils.book_new();

	                     	    // step 2. 시트 만들기 
	                     	    var newWorksheet = excelHandler.getWorksheet(data);
	                     	    
	                     	    // step 3. workbook에 새로만든 워크시트에 이름을 주고 붙인다.  
	                     	    XLSX.utils.book_append_sheet(wb, newWorksheet, excelHandler.getSheetName());

	                     	    // step 4. 엑셀 파일 만들기 
	                     	    var wbout = XLSX.write(wb, {bookType:'xlsx',  type: 'binary'});

	                     	    // step 5. 엑셀 파일 내보내기 
	                     	    saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), excelHandler.getExcelFileName());
	                     	}
	                        
	                        var excelHandler = {
	                     	        getExcelFileName : function(){
	                     	            return '구 진단(신고).xlsx';
	                     	        },
	                     	        getSheetName : function(){
	                     	            return '구 진단(신고)';
	                     	        },
	                     	        getExcelData : function(data){
	                     	        	var arr = new Array();
	                     	        	
	                                	for(var i=0; i< data.length; i++){
	                                		arr[i] = {
                                				'연번':data[i].no
                                                ,'사건번호':data[i].consulting_action_no
                                                ,'기관명':data[i].org_name
                                                ,'상급기관':data[i].upper_org_name
                                                ,'상담유형':data[i].org_type
                                                ,'공공':data[i].org_type_gov
                                                ,'민간':data[i].org_type_priv
                                                ,'기타':data[i].org_type_etc
                                                ,'기관유형':data[i].org_type_gov_detail
                                                ,'국가기관':data[i].org_type_gov_detail_national
                                                ,'지방자치단체':data[i].org_type_gov_detail_local
                                                ,'공공기관':data[i].org_type_gov_detail_public
                                                ,'각급학교':data[i].org_type_gov_detail_school
                                                ,'민간':data[i].org_type_gov_detail_priv
                                                ,'기타':data[i].org_type_gov_detail_etc
                                                ,'컨설팅희망여부':data[i].consulting_desired
                                                ,'심의대기':data[i].action_type_cont_review_wait
                                                ,'이관':data[i].action_type_cont_move
                                                ,'수사및\n조사의뢰':data[i].action_type_cont_con
                                                ,'각하':data[i].action_type_cont_cancel
                                                ,'취하':data[i].action_type_cont_giveup
                                                ,'단순종결\n(연락x)':data[i].action_type_cont_simple_end
                                                ,'확인필요':data[i].action_type_cont_confirm_need
                                                ,'공문발송예정':data[i].official_letter_expect
                                                ,'공문발송완료':data[i].official_letter_complete
                                                ,'컨설팅예정':data[i].consulting_expect
                                                ,'컨설팅완료':data[i].consulting_complete
                                                ,'조치결과수신':data[i].action_result_receive_1
                                                ,'조치결과수신':data[i].action_result_receive_2
                                                ,'종합지원센터\n담당자':data[i].manager
                                                ,'여성가족부':data[i].org_women
                                                ,'1월':data[i].month_1
                                                ,'2월':data[i].month_2
                                                ,'3월':data[i].month_3
                                                ,'4월':data[i].month_4
                                                ,'5월':data[i].month_5
                                                ,'6월':data[i].month_6
                                                ,'7월':data[i].month_7
                                                ,'8월':data[i].month_8
                                                ,'9월':data[i].month_9
                                                ,'10월':data[i].month_10
                                                ,'11월':data[i].month_11
                                                ,'12월':data[i].month_12
                                                ,'사건접수':data[i].accident_receive
                                                ,'공문발송':data[i].official_letter_send
                                                ,'컨설팅':data[i].consulting
                                                ,'조치결과제출일':data[i].action_result_submission
                                                ,'종결':data[i].end
                                                ,'1개월':data[i].month
                                                ,'6개월':data[i].sixmonth
                                                ,'상담의료법률(명)':data[i].consulting_medical_law
                                                ,'성폭력상담소':data[i].sexual_violence_consultation_center
                                                ,'해바라기센터/\n1366':data[i].sunflower_center_1366
                                                ,'법률지원등\n연계':data[i].legal_support_servie_rel
                                                ,'여성노동자회':data[i].women_worker_association
                                                ,'노무법률자문':data[i].labor_law_advice
                                                ,'정신과진료등\n연계':data[i].psychiatric_care_servie_rel
                                                ,'소속기관':data[i].org
                                                ,'상급기관':data[i].org_upper
                                                ,'수사기관':data[i].org_investigation
                                                ,'법원':data[i].org_scourt
                                                ,'고용노동부':data[i].org_labor
                                                ,'지방중앙노동\n위원회':data[i].org_nirc
                                                ,'교육부':data[i].org_education
                                                ,'국가인권위원회':data[i].org_human
                                                ,'국민신문고/\n청와대청원':data[i].org_epeople_cheongwadae_petition
                                                ,'기타':data[i].org_etc
                                                ,'최초발생':data[i].first_occurence
                                                ,'최근발생':data[i].later_occurrence
                                                ,'':data[i].empty_items1_1
                                                ,'':data[i].empty_items1_2
                                                ,'':data[i].empty_items1_3
                                                ,'':data[i].empty_items1_4
                                                ,'언행':data[i].sayings_and_doings
                                                ,'언어적\n물리적':data[i].physical_linguistic
                                                ,'성추행\n강간중강간':data[i].rape_sexual_harass
                                                ,'문자영상':data[i].text_image
                                                ,'폭언폭행':data[i].violent_verbal_abuse
                                                ,'협박소문유포\n인사불이익':data[i].threatened_rumors_private_disadvantages
                                                ,'0:분리x\n1:분리o\n미기재:알수없음':data[i].isolation_status
                                                ,'고충상담':data[i].complaint_consultation
                                                ,'공식신고절차':data[i].official_reporting_procedure
                                                ,'':data[i].empty_items2_1
                                                ,'경찰검찰\n고소고발진정':data[i].police_prosecutor_accusation_charge
                                                ,'민형사소송':data[i].civil_and_criminal_proceedings
                                                ,'':data[i].empty_items2_2
                                                ,'':data[i].empty_items2_3
                                                ,'':data[i].empty_items2_4
                                                ,'':data[i].empty_items2_5
                                                ,'':data[i].empty_items2_6
                                                ,'행위자':data[i].offender
                                                ,'피해자':data[i].victim
                                                ,'':data[i].empty_items3_1
                                                ,'여':data[i].women_1
                                                ,'남':data[i].man_1
                                                ,'미상':data[i].unknown_1
                                                ,'':data[i].empty_items3_2
                                                ,'본인':data[i].me
                                                ,'대리인':data[i].agent
                                                ,'제3자':data[i].third_party
                                                ,'':data[i].empty_items4_1
                                                ,'여':data[i].women_2
                                                ,'남':data[i].man_2
                                                ,'미상':data[i].unknown_2
                                                ,'':data[i].empty_items4_2
                                                ,'':data[i].empty_items5_1
                                                ,'남':data[i].man_3
                                                ,'여':data[i].women_3
                                                ,'미상':data[i].unknown_3
                                                ,'공공기관장건':data[i].state_run_organization
                                                ,'':data[i].empty_items5_2
                                                ,'휴대폰':data[i].tel_no_1
                                                ,'이메일':data[i].email_1
                                                ,'휴대폰':data[i].tel_no_2
                                                ,'이메일':data[i].email_2
                                                ,'':data[i].region
	                                		}                              
	                                	}
	                               		
	                     	           return arr;
	                     	        },
	                     	        getWorksheet : function(data){
	                     	            return XLSX.utils.json_to_sheet(this.getExcelData(data));
	                     	        }
	                     	}
							
						</script>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
            
        </c:if>
	</c:forEach>
	<c:if test="${fn:length(perm) > 0 && fntyp1 eq 'N'}">
      	<div id="contents">
           	<div id="content">
                <ul class="homepagebbs">
                    <li class="bg"><h3 class="sub">접근 권한이 없습니다.</h3></li>
                 </ul>
             </div>
         </div>
    </c:if>
	<c:if test="${fn:length(perm) == 0}">
		<div id="contents">
           	<div id="content">
                <ul class="homepagebbs">
                    <li class="bg"><h3 class="sub">접근 권한이 없습니다.</h3></li>
                 </ul>
             </div>
         </div>
	</c:if> 
            
<jsp:include page="../end.jsp" flush="false" />
