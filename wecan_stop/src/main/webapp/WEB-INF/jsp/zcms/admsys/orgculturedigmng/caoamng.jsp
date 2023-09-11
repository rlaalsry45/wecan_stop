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
                <form:form modelAttribute="WConsultingActionOldApplicationVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/index.html">진단관리</a> <strong>구 진단(기관신청_타부처_선정등) </strong>
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
                                <option value="consulting_action_no" <c:if test="${input.cond2=='consulting_action_no'}"><c:out value='selected' /></c:if>>진단번호</option>
                                <option value="org_name" <c:if test="${input.cond2=='org_name'}"><c:out value='selected' /></c:if>>기관명</option>
                                <option value="manager" <c:if test="${input.cond2=='manager'}"><c:out value='selected' /></c:if>>종합지원센터 담당자</option>
                                <option value="consulting_type" <c:if test="${input.cond2=='consulting_type'}"><c:out value='selected' /></c:if>>컨설팅유형</option>
                                <option value="org_type_gov_detail" <c:if test="${input.cond2=='org_type_gov_detail'}"><c:out value='selected' /></c:if>>기관유형</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="search();" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">구 진단(기관신청_타부처_선정등) 목록</h3></li>
                            <li>
                            <div class="top_bt">
                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
                            </div>

                                <div class="main_table" style="width:100%;overflow:auto;">
                                    <!--게시판 영역-->
                                    <table class="main_table1" summary="연번, 진단번호, 기관명, 선정여부, 미선정또는대기, 신청일자, 신청취소일자 등등" style="white-space:nowrap;">
                                        <caption>관리목록</caption>
                                        <thead>
                                            <tr>
                                                <th>연번</th>
                                                <th>진단번호</th>
                                                <th>기관명</th>
                                                <th>선정<br>여부</th>
                                                <th>미선정<br>또는<br>대기</th>
                                                <th>신청일자<br>(공문수신일자)</th>
                                                <th>신청취소<br>(미선정)<br>일자</th>
                                                <th>컨설팅 일정<br>(기본)</th>
                                                <th>방문예정</th>
                                                <th>방문완료</th>
                                                <th>종합지원센터<br>담당자</th>
                                                <th>종합지원센터<br>담당자2</th>
                                                <th>컨택포인트<br>(신청자 정보)</th>
                                                <th>상급기관명</th>
                                                <th colspan="3">진단 자문위원</th>
                                                <th>18~21<br>컨설팅여부<br>(점검포함)</th>
                                                <th>1~4분기<br>파견원하<br>는 시기</th>
                                                <th>컨설팅 유형</th>
                                                <th>기관 유형</th>
                                                <th>국가기관</th>
                                                <th>지자체</th>
                                                <th>공공기관</th>
                                                <th>초중고교<br>(특수)</th>
                                                <th>대학</th>
                                                <th>민간</th>
                                                <th>기타</th>
                                                <th>(학교구분)<br>1.국립<br>2.공립<br>3.사립<br>4.특수</th>
                                                <th>(공공기관구분)<br>1.공기업<br>2.준정부<br>3.기타공공<br>4.지방공기업<br>5.공직유관</th>
                                                <th>신청기관 현원</th>
                                                <th>1.사건 있음<br>2.사건 없음<br>3.발생했으<br>나 비공식처리<br>4.미기재</th>
                                                <th>사건있음</th>
                                                <th>사건없음</th>
                                                <th>비공식처리</th>
                                                <th>미기재</th>
                                                <th>사건 최초<br>발생시기</th>
                                                <th>기관 신<br>고접수<br>시기</th>
                                                <th>언어적<br>성희롱</th>
                                                <th>신체적<br>성희롱</th>
                                                <th>시각적<br>성희롱</th>
                                                <th>2차 피해</th>
                                                <th>기타</th>
                                                <th>미기재</th>
                                                <th>인지<br>및<br>접수<br>(상담)</th>
                                                <th>조사</th>
                                                <th>심의위</th>
                                                <th>후속조치</th>
                                                <th>기타사항 주관식</th>
                                                <th>신청 사유<br>(주관식)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="each" varStatus="loop">       
                                                <tr>
                                                    <td>${each.NO}</td>
                                                    <td>${each.consulting_action_no}</td>
                                                    <td>${each.org_name}</td>
                                                    <td>${each.selection_status}</td>
                                                    <td>${each.unselected_standby}</td>
                                                    <td>${each.application_date}</td>
                                                    <td>${each.application_cancel}</td>
                                                    <td>${each.consulting_schedule}</td>
                                                    <td>${each.visit_schedule}</td>
                                                    <td>${each.visit_complete}</td>
                                                    <td>${each.manager}</td>
                                                    <td>${each.manager_2}</td>
                                                    <td>${each.contact_point}</td>
                                                    <td>${each.upper_org_name}</td>
                                                    <td>${each.consultant_1}</td>
                                                    <td>${each.consultant_2}</td>
                                                    <td>${each.consultant_3}</td>
                                                    <td>${each.consulting_status}</td>
                                                    <td>${each.time_of_dispatch}</td>
                                                    <td>${each.consulting_type}</td>
                                                    <td>${each.org_type_gov_detail}</td>
                                                    <td>${each.org_type_gov_detail_national}</td>
                                                    <td>${each.org_type_gov_detail_local}</td>
                                                    <td>${each.org_type_gov_detail_public}</td>
                                                    <td>${each.org_type_gov_detail_school}</td>
                                                    <td>${each.org_type_gov_detail_university}</td>
                                                    <td>${each.org_type_gov_detail_priv}</td>
                                                    <td>${each.org_type_gov_detail_etc}</td>
                                                    <td>${each.org_type_gov_detail_school_gubun}</td>
                                                    <td>${each.org_type_gov_detail_public_gubun}</td>
                                                    <td>${each.application_org_member}</td>
                                                    <td>${each.accident_status}</td>
                                                    <td>${each.accident}</td>
                                                    <td>${each.accident_not}</td>
                                                    <td>${each.accident_informal_processing}</td>
                                                    <td>${each.accident_not_listed}</td>
                                                    <td>${each.accident_date}</td>
                                                    <td>${each.receipt_date}</td>
                                                    <td>${each.harm_type_verbals}</td>
                                                    <td>${each.harm_type_body}</td>
                                                    <td>${each.harm_type_visual}</td>
                                                    <td>${each.harm_type_second}</td>
                                                    <td>${each.harm_type_etc}</td>
                                                    <td>${each.harm_type_not_listed}</td>
                                                    <td>${each.accident_step_1}</td>
                                                    <td>${each.accident_step_2}</td>
                                                    <td>${each.accident_step_3}</td>
                                                    <td>${each.accident_step_4}</td>
                                                    <td>${each.application_etc_txt}</td>
                                                    <td>${each.application_reason}</td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="51" style="padding:20;">등록된 정보가 없습니다.</td>
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
								$("#WConsultingActionOldApplicationVo").attr("action","/admsys/orgculturedigmng/caoamng.html");
								$("#WConsultingActionOldApplicationVo").submit();
							}
							
							function excelDownload(){
								var eForm = $("#WConsultingActionOldApplicationVo").serialize();
								
								$.ajax({
									  type: 'POST',
									  url: "/admsys/orgculturedigmng/caoamng_excel.html",
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
	                     	            return '구 진단(기관신청_타부처_선정등).xlsx';
	                     	        },
	                     	        getSheetName : function(){
	                     	            return '구 진단(기관신청_타부처_선정등)';
	                     	        },
	                     	        getExcelData : function(data){
	                     	        	var arr = new Array();
	                     	        	
	                                	for(var i=0; i< data.length; i++){
	                                		arr[i] = {
		                                		'연번':data[i].no
	                                            ,'진단번호':data[i].consulting_action_no
	                                            ,'기관명':data[i].org_name
	                                            ,'선정\n여부':data[i].selection_status
	                                            ,'미선정\n또는\n대기':data[i].unselected_standby
	                                            ,'신청일자\n(공문수신일자)':data[i].application_date
	                                            ,'신청취소\n(미선정)\n일자':data[i].application_cancel
	                                            ,'컨설팅 일정\n(기본)':data[i].consulting_schedule
	                                            ,'방문예정':data[i].visit_schedule
	                                            ,'방문완료':data[i].visit_complete
	                                            ,'종합지원센터\n담당자':data[i].manager
	                                            ,'종합지원센터\n담당자2':data[i].manager_2
	                                            ,'컨택포인트\n(신청자 정보)':data[i].contact_point
	                                            ,'상급기관명':data[i].upper_org_name
	                                            ,'진단 자문위원':data[i].consultant_1
	                                            ,'진단 자문위원':data[i].consultant_2
	                                            ,'진단 자문위원':data[i].consultant_3
	                                            ,'18~21\n컨설팅여부\n(점검포함)':data[i].consulting_status
	                                            ,'1~4분기\n파견원하\n는 시기':data[i].time_of_dispatch
	                                            ,'컨설팅 유형':data[i].consulting_type
	                                            ,'기관 유형':data[i].org_type_gov_detail
	                                            ,'국가기관':data[i].org_type_gov_detail_national
	                                            ,'지자체':data[i].org_type_gov_detail_local
	                                            ,'공공기관':data[i].org_type_gov_detail_public
	                                            ,'초중고교\n(특수)':data[i].org_type_gov_detail_school
	                                            ,'대학':data[i].org_type_gov_detail_university
	                                            ,'민간':data[i].org_type_gov_detail_priv
	                                            ,'기타':data[i].org_type_gov_detail_etc
	                                            ,'(학교구분)\n1.국립\n2.공립\n3.사립\n4.특수':data[i].org_type_gov_detail_school_gubun
	                                            ,'(공공기관구분)\n1.공기업\n2.준정부\n3.기타공공\n4.지방공기업\n5.공직유관':data[i].org_type_gov_detail_public_gubun
	                                            ,'신청기관 현원':data[i].application_org_member
	                                            ,'1.사건 있음\n2.사건 없음\n3.발생했으\n나 비공식처리\n4.미기재':data[i].accident_status
	                                            ,'사건있음':data[i].accident
	                                            ,'사건없음':data[i].accident_not
	                                            ,'비공식처리':data[i].accident_informal_processing
	                                            ,'미기재':data[i].accident_not_listed
	                                            ,'사건 최초\n발생시기':data[i].accident_date
	                                            ,'기관 신\n고접수\n시기':data[i].receipt_date
	                                            ,'언어적\n성희롱':data[i].harm_type_verbals
	                                            ,'신체적\n성희롱':data[i].harm_type_body
	                                            ,'시각적\n성희롱':data[i].harm_type_visual
	                                            ,'2차 피해':data[i].harm_type_second
	                                            ,'기타':data[i].harm_type_etc
	                                            ,'미기재':data[i].harm_type_not_listed
	                                            ,'인지\n및\n접수\n(상담)':data[i].accident_step_1
	                                            ,'조사':data[i].accident_step_2
	                                            ,'심의위':data[i].accident_step_3
	                                            ,'후속조치':data[i].accident_step_4
	                                            ,'기타사항 주관식':data[i].application_etc_txt
	                                            ,'신청 사유\n(주관식)':data[i].application_reason
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
