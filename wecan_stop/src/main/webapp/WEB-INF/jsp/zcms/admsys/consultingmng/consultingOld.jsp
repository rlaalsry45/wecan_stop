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
                <form:form modelAttribute="WConsultingOldMngVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/consultingmng/chdel.html">상담관리</a> <strong>구 상담일지</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="sitedatereg" <c:if test="${input.cond1=='sitedatereg'}"><c:out value='selected' /></c:if>>접수일</option>
                            </select>
							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
                            <select style="height:27px;" name="cond2">
                                <option value="manager" <c:if test="${input.cond2=='manager'}"><c:out value='selected' /></c:if>>접수자(종합지원센터 담당자)</option>
                                <option value="contact_tel_no" <c:if test="${input.cond2=='contact_tel_no'}"><c:out value='selected' /></c:if>>연락처</option>
                                <option value="consulting_type" <c:if test="${input.cond2=='consulting_type'}"><c:out value='selected' /></c:if>>상담유형</option>
                                <option value="consulting_req_type" <c:if test="${input.cond2=='consulting_req_type'}"><c:out value='selected' /></c:if>>문의유형</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="search();" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">구 상담일지 목록</h3></li>
                            <li>
                            <div class="top_bt">
                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
                            </div>

                                <div class="main_table" style="width:100%;overflow:auto;">
                                    <!--게시판 영역-->
                                    <table class="main_table1" summary="월, 상담일자, 상담시작, 상담종료, 연번, 종합지원센터 담당자 등등" style="white-space:nowrap;">
                                        <caption>관리목록</caption>
                                        <thead>
                                            <tr>
                                                <th>월</th>
                                                <th>상담일자</th>
                                                <th>상담시작</th>
                                                <th>상담종료</th>
                                                <th>연번</th>
                                                <th>종합지원센터<br>담당자</th>
                                                <th>전화</th>
                                                <th>우편</th>
                                                <th>내방</th>
                                                <th>이관</th>
                                                <th>상담유형</th>
                                                <th>공공</th>
                                                <th>민간(기업)</th>
                                                <th>민간(개인)</th>
                                                <th>기타/미파악</th>
                                                <th>공공기관장<br>전화</th>
                                                <th>연락처</th>
                                                <th>문의 유형</th>
                                                <th>사건관련</th>
                                                <th>단순문의</th>
                                                <th>기타</th>
                                                <th>발신자이름</th>
                                                <th>발신자여성</th>
                                                <th>발신자남성</th>
                                                <th>발신자미상</th>
                                                <th>발신자소속</th>
                                                <th>본인</th>
                                                <th>대리인/<br>조력자</th>
                                                <th>관련담당자</th>
                                                <th>행위자등</th>
                                                <th>기타</th>
                                                <th>기타(내용)</th>
                                                <th>피해자이름</th>
                                                <th>피해자여성</th>
                                                <th>피해자남성</th>
                                                <th>피해자미상</th>
                                                <th>해당사항없음</th>
                                                <th>피해자소속</th>
                                                <th>행위자이름</th>
                                                <th>행위자여성</th>
                                                <th>행위자남성</th>
                                                <th>행위자미상</th>
                                                <th>해당사항없음</th>
                                                <th>소속</th>
                                                <th>기관장/<br>사업주</th>
                                                <th>상급자</th>
                                                <th>동료</th>
                                                <th>그외업무관계자</th>
                                                <th>기타</th>
                                                <th>기타(내용)</th>
                                                <th>미파악</th>
                                                <th>강간/유사강간/<br>준강간</th>
                                                <th>그외추행</th>
                                                <th>언어적</th>
                                                <th>시각적</th>
                                                <th>기타 성희롱</th>
                                                <th>2차피해</th>
                                                <th>비밀누설/<br>소문유포</th>
                                                <th>분리조치미흡</th>
                                                <th>의사에반한<br>사건처리</th>
                                                <th>신분상불이익</th>
                                                <th>그외2차피해</th>
                                                <th>그외2차피해<br>(내용)</th>
                                                <th>기타</th>
                                                <th>기타(내용)</th>
                                                <th>성차별/<br>외모비하</th>
                                                <th>미파악</th>
                                                <th>해당사항 없음</th>
                                                <th>절차안내</th>
                                                <th>소속기관<br>상담신고권유</th>
                                                <th>타신고기관안내</th>
                                                <th>여성가족부</th>
                                                <th>고용노동부</th>
                                                <th>경찰</th>
                                                <th>교육부</th>
                                                <th>국가인권위원회</th>
                                                <th>기타</th>
                                                <th>기타(내용)</th>
                                                <th colspan="5">피해자 지원기관<br>연계</th>
                                                <th>기타</th>
                                                <th>기타(내용)</th>
                                                <th>상담내용</th>
                                                <th>비고</th>
                                                <th>인터넷검색</th>
                                                <th>피해자<br>지원기관</th>
                                                <th>여성가족부</th>
                                                <th>기타</th>
                                                <th>기타(내용)</th>
                                                <th>미파악</th>
                                                <th>지속상담건</th>
                                                <th colspan="2">추가통화</th>
                                            	<th>소요시간</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="each" varStatus="loop">
                                                <tr>
                                                    <td>${each.counsel_month}</td>
                                                    <td>${each.counsel_date}</td>
                                                    <td>${each.counsel_starttime}</td>
                                                    <td>${each.counsel_endtime}</td>
                                                    <td>${each.NO}</td>
                                                    <td>${each.manager}</td>
                                                    <td>${each.received_type_tel}</td>
                                                    <td>${each.received_type_mail}</td>
                                                    <td>${each.received_type_visit}</td>
                                                    <td>${each.received_type_move}</td>
                                                    <td>${each.consulting_type}</td>
                                                    <td>${each.consulting_type_public}</td>
                                                    <td>${each.consulting_type_civil}</td>
                                                    <td>${each.consulting_type_personal}</td>
                                                    <td>${each.consulting_type_etc}</td>
                                                    <td>${each.tel_type}</td>
                                                    <td>${each.contact_tel_no}</td>
                                                    <td>${each.consulting_req_type}</td>
                                                    <td>${each.consulting_req_type_relaccident}</td>
                                                    <td>${each.consulting_req_type_simple}</td>
                                                    <td>${each.consulting_req_type_etc}</td>
                                                    <td>${each.client_name}</td>
                                                    <td>${each.client_gender_female}</td>
                                                    <td>${each.client_gender_male}</td>
                                                    <td>${each.client_gender_unknown}</td>
                                                    <td>${each.client_belong}</td>
                                                    <td>${each.client_victim_rel_type_me}</td>
                                                    <td>${each.client_victim_rel_type_agent}</td>
                                                    <td>${each.client_victim_rel_type_relmanager}</td>
                                                    <td>${each.client_victim_rel_type_doer}</td>
                                                    <td>${each.client_victim_rel_type_etc}</td>
                                                    <td>${each.client_victim_rel_type_etc_txt}</td>
                                                    <td>${each.victim_name}</td>
                                                    <td>${each.victim_gender_type_female}</td>
                                                    <td>${each.victim_gender_type_male}</td>
                                                    <td>${each.victim_gender_type_unknown}</td>
                                                    <td>${each.victim_gender_type_none}</td>
                                                    <td>${each.victim_belong}</td>
                                                    <td>${each.offender_name}</td>
                                                    <td>${each.offender_gender_type_female}</td>
                                                    <td>${each.offender_gender_type_male}</td>
                                                    <td>${each.offender_gender_type_unknown}</td>
                                                    <td>${each.offender_gender_type_none}</td>
                                                    <td>${each.offender_belong}</td>
                                                    <td>${each.offender_victim_rel_type_boss}</td>
                                                    <td>${each.offender_victim_rel_type_senior}</td>
                                                    <td>${each.offender_victim_rel_type_partner}</td>
                                                    <td>${each.offender_victim_rel_type_otherrel}</td>
                                                    <td>${each.offender_victim_rel_type_etc}</td>
                                                    <td>${each.offender_victim_rel_type_etc_txt}</td>
                                                    <td>${each.offender_victim_rel_type_unknown}</td>
                                                    <td>${each.harm_first_type_rape}</td>
                                                    <td>${each.harm_first_type_harass}</td>
                                                    <td>${each.harm_first_type_verbal}</td>
                                                    <td>${each.harm_first_type_visual}</td>
                                                    <td>${each.harm_first_type_etc}</td>
                                                    <td>${each.harm_sec_type}</td>
                                                    <td>${each.harm_sec_type_security}</td>
                                                    <td>${each.harm_sec_type_seprate}</td>
                                                    <td>${each.harm_sec_type_intention}</td>
                                                    <td>${each.harm_sec_type_identity}</td>
                                                    <td>${each.harm_sec_etc}</td>
                                                    <td>${each.harm_sec_etc_txt}</td>
                                                    <td>${each.harm_etc}</td>
                                                    <td>${each.harm_etc_txt}</td>
                                                    <td>${each.harm_first_type_sexism}</td>
                                                    <td>${each.harm_first_type_unknown}</td>
                                                    <td>${each.harm_first_type_none}</td>
                                                    <td>${each.response_type_info}</td>
                                                    <td>${each.response_type_advice}</td>
                                                    <td>${each.response_type_intro_org}</td>
                                                    <td>${each.response_type_intro_org_women}</td>
                                                    <td>${each.response_type_intro_org_labor}</td>
                                                    <td>${each.response_type_intro_org_police}</td>
                                                    <td>${each.response_type_intro_org_education}</td>
                                                    <td>${each.response_type_intro_org_human}</td>
                                                    <td>${each.response_type_intro_org_etc}</td>
                                                    <td>${each.response_type_intro_org_etc_txt}</td>
                                                    <td>${each.response_type_service_rel_1}</td>
                                                    <td>${each.response_type_service_rel_2}</td>
                                                    <td>${each.response_type_service_rel_3}</td>
                                                    <td>${each.response_type_service_rel_4}</td>
                                                    <td>${each.response_type_service_rel_5}</td>
                                                    <td>${each.response_type_etc}</td>
                                                    <td>${each.response_type_etc_txt}</td>
                                                    <td>${each.consulting_contents}</td>
                                                    <td>${each.consulting_contents_etc}</td>
                                                    <td>${each.contact_method_type_internet}</td>
                                                    <td>${each.contact_method_type_support}</td>
                                                    <td>${each.contact_method_type_gov}</td>
                                                    <td>${each.contact_method_type_etc}</td>
                                                    <td>${each.contact_method_type_etc_txt}</td>
                                                    <td>${each.contact_method_type_unknown}</td>
                                                    <td>${each.continue_consulting}</td>
                                                    <td>${each.add_call_time_1}</td>
                                                    <td>${each.add_call_time_2}</td>
                                                    <td>${each.time}</td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="98" style="padding:20;">등록된 정보가 없습니다.</td>
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
								$("#WConsultingOldMngVo").attr("action","/admsys/consultingmng/consultingOld.html");
								$("#WConsultingOldMngVo").submit();
							}
							
							function excelDownload(){
								var eForm = $("#WConsultingOldMngVo").serialize();
								
								$.ajax({
									  type: 'POST',
									  url: "/admsys/consultingmng/consultingOld_excel.html",
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
	                     	            return '구 상담일지.xlsx';
	                     	        },
	                     	        getSheetName : function(){
	                     	            return '구 상담일지';
	                     	        },
	                     	        getExcelData : function(data){
	                     	        	var arr = new Array();
	                     	        	
	                                	for(var i=0; i< data.length; i++){
	                                		arr[i] = {
                                				'월':data[i].counsel_month
                                                ,'상담일자':data[i].counsel_date
                                                ,'상담시작':data[i].counsel_starttime
                                                ,'상담종료':data[i].counsel_endtime
                                                ,'연번':data[i].no
                                                ,'종합지원센터\n담당자':data[i].manager
                                                ,'전화':data[i].received_type_tel
                                                ,'우편':data[i].received_type_mail
                                                ,'내방':data[i].received_type_visit
                                                ,'이관':data[i].received_type_move
                                                ,'상담유형':data[i].consulting_type
                                                ,'공공':data[i].consulting_type_public
                                                ,'민간(기업)':data[i].consulting_type_civil
                                                ,'민간(개인)':data[i].consulting_type_personal
                                                ,'기타/미파악':data[i].consulting_type_etc
                                                ,'공공기관장\n전화':data[i].tel_type
                                                ,'연락처':data[i].contact_tel_no
                                                ,'문의 유형':data[i].consulting_req_type
                                                ,'사건관련':data[i].consulting_req_type_relaccident
                                                ,'단순문의':data[i].consulting_req_type_simple
                                                ,'기타':data[i].consulting_req_type_etc
                                                ,'발신자이름':data[i].client_name
                                                ,'발신자여성':data[i].client_gender_female
                                                ,'발신자남성':data[i].client_gender_male
                                                ,'발신자미상':data[i].client_gender_unknown
                                                ,'발신자소속':data[i].client_belong
                                                ,'본인':data[i].client_victim_rel_type_me
                                                ,'대리인/\n조력자':data[i].client_victim_rel_type_agent
                                                ,'관련담당자':data[i].client_victim_rel_type_relmanager
                                                ,'행위자등':data[i].client_victim_rel_type_doer
                                                ,'기타':data[i].client_victim_rel_type_etc
                                                ,'기타(내용)':data[i].client_victim_rel_type_etc_txt
                                                ,'피해자이름':data[i].victim_name
                                                ,'피해자여성':data[i].victim_gender_type_female
                                                ,'피해자남성':data[i].victim_gender_type_male
                                                ,'피해자미상':data[i].victim_gender_type_unknown
                                                ,'해당사항없음':data[i].victim_gender_type_none
                                                ,'피해자소속':data[i].victim_belong
                                                ,'행위자이름':data[i].offender_name
                                                ,'행위자여성':data[i].offender_gender_type_female
                                                ,'행위자남성':data[i].offender_gender_type_male
                                                ,'행위자미상':data[i].offender_gender_type_unknown
                                                ,'해당사항없음':data[i].offender_gender_type_none
                                                ,'소속':data[i].offender_belong
                                                ,'기관장/\n사업주':data[i].offender_victim_rel_type_boss
                                                ,'상급자':data[i].offender_victim_rel_type_senior
                                                ,'동료':data[i].offender_victim_rel_type_partner
                                                ,'그외업무관계자':data[i].offender_victim_rel_type_otherrel
                                                ,'기타':data[i].offender_victim_rel_type_etc
                                                ,'기타(내용)':data[i].offender_victim_rel_type_etc_txt
                                                ,'미파악':data[i].offender_victim_rel_type_unknown
                                                ,'강간/유사강간/\n준강간':data[i].harm_first_type_rape
                                                ,'그외추행':data[i].harm_first_type_harass
                                                ,'언어적':data[i].harm_first_type_verbal
                                                ,'시각적':data[i].harm_first_type_visual
                                                ,'기타 성희롱':data[i].harm_first_type_etc
                                                ,'2차피해':data[i].harm_sec_type
                                                ,'비밀누설/\n소문유포':data[i].harm_sec_type_security
                                                ,'분리조치미흡':data[i].harm_sec_type_seprate
                                                ,'의사에반한\n사건처리':data[i].harm_sec_type_intention
                                                ,'신분상불이익':data[i].harm_sec_type_identity
                                                ,'그외2차피해':data[i].harm_sec_etc
                                                ,'그외2차피해\n(내용)':data[i].harm_sec_etc_txt
                                                ,'기타':data[i].harm_etc
                                                ,'기타(내용)':data[i].harm_etc_txt
                                                ,'성차별/\n외모비하':data[i].harm_first_type_sexism
                                                ,'미파악':data[i].harm_first_type_unknown
                                                ,'해당사항 없음':data[i].harm_first_type_none
                                                ,'절차안내':data[i].response_type_info
                                                ,'소속기관\n상담신고권유':data[i].response_type_advice
                                                ,'타신고기관안내':data[i].response_type_intro_org
                                                ,'여성가족부':data[i].response_type_intro_org_women
                                                ,'고용노동부':data[i].response_type_intro_org_labor
                                                ,'경찰':data[i].response_type_intro_org_police
                                                ,'교육부':data[i].response_type_intro_org_education
                                                ,'국가인권위원회':data[i].response_type_intro_org_human
                                                ,'기타':data[i].response_type_intro_org_etc
                                                ,'기타(내용)':data[i].response_type_intro_org_etc_txt
                                                ,'피해자 지원기관\n연계':data[i].response_type_service_rel_1
                                                ,'피해자 지원기관\n연계':data[i].response_type_service_rel_2
                                                ,'피해자 지원기관\n연계':data[i].response_type_service_rel_3
                                                ,'피해자 지원기관\n연계':data[i].response_type_service_rel_4
                                                ,'피해자 지원기관\n연계':data[i].response_type_service_rel_5
                                                ,'기타':data[i].response_type_etc
                                                ,'기타(내용)':data[i].response_type_etc_txt
                                                ,'상담내용':data[i].consulting_contents
                                                ,'비고':data[i].consulting_contents_etc
                                                ,'인터넷검색':data[i].contact_method_type_internet
                                                ,'피해자\n지원기관':data[i].contact_method_type_support
                                                ,'여성가족부':data[i].contact_method_type_gov
                                                ,'기타':data[i].contact_method_type_etc
                                                ,'기타(내용)':data[i].contact_method_type_etc_txt
                                                ,'미파악':data[i].contact_method_type_unknown
                                                ,'지속상담건':data[i].continue_consulting
                                                ,'추가통화':data[i].add_call_time_1
                                                ,'추가통화':data[i].add_call_time_2
                                            	,'소요시간':data[i].time
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
