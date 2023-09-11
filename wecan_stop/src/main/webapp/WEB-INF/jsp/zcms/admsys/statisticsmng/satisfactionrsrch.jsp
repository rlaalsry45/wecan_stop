<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />

            <div id="contents">
                <form:form modelAttribute="ZStatisticsMngVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/statisticsmng/">HOME</a> <a href="/admsys/statisticsmng/index.html">통계관리</a> <strong>만족도조사</strong>
                        </div>
                        <%--<div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="term" <c:if test="${input.cond1=='term'}"><c:out value='selected' /></c:if>>기간</option>
                            </select>
                              <input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" style="width:128px;"/>
                                        ~
                              <input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="/admsys/statisticsmng/index.html" />
                        </div> --%>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">만족도조사</h3></li> 
                            <li>
                            	<div id="wrap">
									<div class="search_box">
										<table>
											<caption>검색</caption>
											<colgroup>
												<col style="width:250px;">
												<col style="width:auto;">
											</colgroup>
											<tbody>
												<tr>
													<th>기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;간</th>
													<td>
														<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
														<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
														<div class="input_box">
															<input type="date" id="sdate" name="sdate" class="date" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
														</div>
														~
														<div class="input_box">
															<input type="date" id="edate" name="edate" class="date" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
														</div>
													</td>
												</tr>
												<tr>
													<th>기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관</th>
													<td>
														<!--<div class="input_box">
															<input type="checkbox" name="org1" id="chk_public" value="gov" <c:if test="${input.org1 eq 'gov'}">checked</c:if>>
															<label for="chk_public" class="on">공공</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="org2" id="chk_private" value="priv" <c:if test="${input.org2 eq 'priv'}">checked</c:if>>
															<label for="chk_private" class="on">민간</label>
														</div>-->
														<div class="input_box">
															<input type="checkbox" name="satisfaction1" id="chk_sat1" value="1" <c:if test="${input.satisfaction1 eq '1'}">checked</c:if>>
															<label for="chk_sat1" class="on">중앙부처/국가기관</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="satisfaction1" id="chk_sat2" value="2" <c:if test="${input.satisfaction1 eq '2'}">checked</c:if>>
															<label for="chk_sat2" class="on">지방자치단체</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="satisfaction1" id="chk_sat3" value="3" <c:if test="${input.satisfaction1 eq '3'}">checked</c:if>>
															<label for="chk_sat3" class="on">공공기관</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="satisfaction1" id="chk_sat4" value="4" <c:if test="${input.satisfaction1 eq '4'}">checked</c:if>>
															<label for="chk_sat4" class="on">초·중·고교</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="satisfaction1" id="chk_sat5" value="5" <c:if test="${input.satisfaction1 eq '5'}">checked</c:if>>
															<label for="chk_sat5" class="on">대학교</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="satisfaction1" id="chk_sat6" value="6" <c:if test="${input.prequery1 eq '6'}">checked</c:if>>
															<label for="chk_sat6" class="on">민간/기타</label>
														</div>
													</td>
												</tr>
												<tr>
													<th>유&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;형</th>
													<td>
														<div class="input_box">
															<input type="checkbox" name="type1" id="chk_type1" value="A" <c:if test="${input.type1 eq 'A'}">checked</c:if>>
															<label for="chk_type1" class="on">여성가족부신고사건(A)</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="type2" id="chk_type2" value="B" <c:if test="${input.type2 eq 'B'}">checked</c:if>>
															<label for="chk_type2" class="on">기관신청건(B)</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="type3" id="chk_type3" value="C" <c:if test="${input.type3 eq 'C'}">checked</c:if>>
															<label for="chk_type3" class="on">여가부선정/타부처이관(C)</label>
														</div>
														<div class="input_box">
															<input type="checkbox" name="type4" id="chk_type4" value="D" <c:if test="${input.type4 eq 'D'}">checked</c:if>>
															<label for="chk_type4" class="on">현장점검(D)</label>
														</div>
													</td>
												</tr>
												<tr>
													<th>기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;관&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;코&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;드</th>
													<td>
														<div class="input_box basic">
															<input type="text" name="orgId" id="orgId" value="${input.orgId}">
														</div>
														<div class="input_box basic">
															<input type="text" name="orgName" id="orgName" value="${input.orgName}" readonly style="background-color: #e2e2e2;">
														</div>
													</td>
												</tr>
												<tr>
													<th>진단일지번호(사건번호)</th>
													<td>
														<div class="input_box basic">
															<input type="text" name="consulting_application_no" id="consulting_application_no" value="${input.consulting_application_no}">
														</div>
													</td>
												</tr>
											</tbody>
										</table>
										<div class="btn_wrap">
											<a href="javascript:search();" class="search"><span>조 회</span></a>
											<a href="javascript:excelDownload();" class="excel_download"><span>엑셀 다운로드</span></a>
										</div>
									</div>
									<br>
									<div class="research_list">
										<table id="research_table">
											<caption>만족도조사</caption>
											<colgroup>
												<col style="width:780px;">
												<col style="width:275px;">
												<col style="width:auto;">
											</colgroup>
											<thead>
												<tr>
													<th>질&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문</th>
													<th>답</th>
													<th>선&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;택</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td rowspan="6" class="td_first"><span class="point_color">1.</span>귀 기관의 유형은 무엇인가요?</td>
													<td>1.중앙행정기관</td>
													<td>${getSatisfaction.satisfactionCnt01_1}</td>
												</tr>
												<tr>
													<td>2.지방자체단체</td>
													<td>${getSatisfaction.satisfactionCnt01_2}</td>
												</tr>
												<tr>
													<td>3.공공기관</td>
													<td>${getSatisfaction.satisfactionCnt01_3}</td>
												</tr>
												<tr>
													<td>4.초·중·고교</td>
													<td>${getSatisfaction.satisfactionCnt01_4}</td>
												</tr>
												<tr>
													<td>5.대학교</td>
													<td>${getSatisfaction.satisfactionCnt01_5}</td>
												</tr>
												<tr>
													<td>6.기타</td>
													<td>${getSatisfaction.satisfactionCnt01_6}</td>
												</tr>
												<c:forEach var="each" items="${getSatisfaction1OpinionList}">
				                                <tr>
				                                    <td colspan="3" class="td_first">${each.askno1opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td rowspan="5" class="td_first"><span class="point_color">2.</span>조직문화 진단 실시 전 계획과 내용에 대해 충분한 안내를 받으셨습니까?</td>
													<td>1.매우 그렇다</td>
													<td>${getSatisfaction.satisfactionCnt02_1}</td>
												</tr>
												<tr>
													<td>2.그렇다</td>
													<td>${getSatisfaction.satisfactionCnt02_2}</td>
												</tr>
												<tr>
													<td>3.보통이다</td>
													<td>${getSatisfaction.satisfactionCnt02_3}</td>
												</tr>
												<tr>
													<td>4.그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt02_4}</td>
												</tr>
												<tr>
													<td>5.매우 그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt02_5}</td>
												</tr>
												<c:forEach var="each" items="${getSatisfaction2OpinionList}">
				                                <tr>
				                                    <td colspan="3" class="td_first">${each.askno2opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td rowspan="5" class="td_first"><span class="point_color">3.</span>이번 조직문화 진단 진행방식에 만족하셨습니까?</td>
													<td>1.매우 그렇다</td>
													<td>${getSatisfaction.satisfactionCnt03_1}</td>
												</tr>
												<tr>
													<td>2.그렇다</td>
													<td>${getSatisfaction.satisfactionCnt03_2}</td>
												</tr>
												<tr>
													<td>3.보통이다</td>
													<td>${getSatisfaction.satisfactionCnt03_3}</td>
												</tr>
												<tr>
													<td>4.그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt03_4}</td>
												</tr>
												<tr>
													<td>5.매우 그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt03_5}</td>
												</tr>
												<c:forEach var="each" items="${getSatisfaction3OpinionList}">
				                                <tr>
				                                    <td colspan="3" class="td_first">${each.askno3opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td rowspan="5" class="td_first"><span class="point_color">4.</span>자문위원단의 전문성에 만족하셨습니까?</td>
													<td>1.매우 그렇다</td>
													<td>${getSatisfaction.satisfactionCnt04_1}</td>
												</tr>
												<tr>
													<td>2.그렇다</td>
													<td>${getSatisfaction.satisfactionCnt04_2}</td>
												</tr>
												<tr>
													<td>3.보통이다</td>
													<td>${getSatisfaction.satisfactionCnt04_3}</td>
												</tr>
												<tr>
													<td>4.그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt04_4}</td>
												</tr>
												<tr>
													<td>5.매우 그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt04_5}</td>
												</tr>
												<c:forEach var="each" items="${getSatisfaction4OpinionList}">
				                                <tr>
				                                    <td colspan="3" class="td_first">${each.askno4opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td rowspan="5" class="td_first"><span class="point_color">5.</span>자문위원단의 조직문화 진단을 위한 사전 준비가 충분했다고 느끼셨습니까?</td>
													<td>1.매우 그렇다</td>
													<td>${getSatisfaction.satisfactionCnt05_1}</td>
												</tr>
												<tr>
													<td>2.그렇다</td>
													<td>${getSatisfaction.satisfactionCnt05_2}</td>
												</tr>
												<tr>
													<td>3.보통이다</td>
													<td>${getSatisfaction.satisfactionCnt05_3}</td>
												</tr>
												<tr>
													<td>4.그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt05_4}</td>
												</tr>
												<tr>
													<td>5.매우 그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt05_5}</td>
												</tr>
												<c:forEach var="each" items="${getSatisfaction5OpinionList}">
				                                <tr>
				                                    <td colspan="3" class="td_first">${each.askno5opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td rowspan="5" class="td_first"><span class="point_color">6.</span>이번 조직문화 진단을 통해 그간 궁금했던 사항들을 해결하는 데에 도움이 되었습니까?</td>
													<td>1.매우 그렇다</td>
													<td>${getSatisfaction.satisfactionCnt06_1}</td>
												</tr>
												<tr>
													<td>2.그렇다</td>
													<td>${getSatisfaction.satisfactionCnt06_2}</td>
												</tr>
												<tr>
													<td>3.보통이다</td>
													<td>${getSatisfaction.satisfactionCnt06_3}</td>
												</tr>
												<tr>
													<td>4.그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt06_4}</td>
												</tr>
												<tr>
													<td>5.매우 그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt06_5}</td>
												</tr>
												<c:forEach var="each" items="${getSatisfaction6OpinionList}">
				                                <tr>
				                                    <td colspan="3" class="td_first">${each.askno6opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td rowspan="5" class="td_first"><span class="point_color">7.</span>이번 조직문화 진단을 통해 습득한 내용을 관련 업무에 활용할 수 있다고 생각하십니까?</td>
													<td>1.매우 그렇다</td>
													<td>${getSatisfaction.satisfactionCnt07_1}</td>
												</tr>
												<tr>
													<td>2.그렇다</td>
													<td>${getSatisfaction.satisfactionCnt07_2}</td>
												</tr>
												<tr>
													<td>3.보통이다</td>
													<td>${getSatisfaction.satisfactionCnt07_3}</td>
												</tr>
												<tr>
													<td>4.그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt07_4}</td>
												</tr>
												<tr>
													<td>5.매우 그렇지 않다</td>
													<td>${getSatisfaction.satisfactionCnt07_5}</td>
												</tr>
												<c:forEach var="each" items="${getSatisfaction7OpinionList}">
				                                <tr>
				                                    <td colspan="3" class="td_first">${each.askno7opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td rowspan="5" class="td_first"><span class="point_color">8.</span>이번 조직문화 진단에서 특별히 도움이 되었던 분야는 무엇인가요?</td>
													<td>1.성 고충 사건처리 절차(상담·조사·심의 등)</td>
													<td>${getSatisfaction.satisfactionCnt08_1}</td>
												</tr>
												<tr>
													<td>2.피해자 보호조치 및 2차 피해 방지</td>
													<td>${getSatisfaction.satisfactionCnt08_2}</td>
												</tr>
												<tr>
													<td>3.성희롱·성폭력 예방지침</td>
													<td>${getSatisfaction.satisfactionCnt08_3}</td>
												</tr>
												<tr>
													<td>4.고충상담창구 및 성고충심의위원회 운영</td>
													<td>${getSatisfaction.satisfactionCnt08_4}</td>
												</tr>
												<tr>
													<td>5.예방교육 및 재발방지 대책</td>
													<td>${getSatisfaction.satisfactionCnt08_5}</td>
												</tr>
												<c:forEach var="each" items="${getSatisfaction8OpinionList}">
				                                <tr>
				                                    <td colspan="3" class="td_first">${each.askno8opinion}</td>
				                                </tr> 
				                                </c:forEach>
												<tr>
													<td class="td_first"><span class="point_color">9.</span>이번 조직문화 진단에 개선할 사항이 있다면 자유롭게 말씀해 주세요.</td>
													<td></td>
													<td></td>
												</tr>
												<c:forEach var="each" items="${getSatisfaction9List}">
				                                <tr>
				                                    <td colspan="3" class="td_first">${each.askno9}</td>
				                                </tr> 
				                                </c:forEach>
											</tbody>
										</table>
									</div>
								</div>
                            </li>
                        </ul>
                        <script type="text/javascript">
                        $(document).on('click', "input[name='satisfaction1']", function(){
                            if(this.checked) {
                                const checkboxes = $("input[name='satisfaction1']");
                                for(let ind = 0; ind < checkboxes.length; ind++){
                                    checkboxes[ind].checked = false;
                                }
                                this.checked = true;
                            } else {
                                this.checked = false;
                            }
                        });
                        $("#orgId").autocomplete({
                            source : function(request, response) {
                                $.ajax({
                                      url : "/admsys/orgculturedigmng/get_org_code_list.html"
                                    , type : "GET"
                                    , data : {keyword : $("#orgId").val()} // 검색 키워드
                                    , success : function(data){ // 성공
                                        response(
                                            $.map(data.list, function(item) {
                                                return {
                                                      label : item.organizationFullName    //목록에 표시되는 값
                                                    , value : item.organizationId    //선택 시 input창에 표시되는 값
                                                    , name : item.organizationName
                                                };
                                            })
                                        );    //response
                                    }
                                    ,
                                    error : function(){ //실패
                                        alert("통신에 실패했습니다.");
                                    }
                                });
                            }
                            , minLength : 2    
                            , autoFocus : false    
                            , select : function(evt, ui) {
                                $('#orgName').val(ui.item.name);
                            }
                            , focus : function(evt, ui) {
                                return false;
                            }
                            , close : function(evt) {
                            }
                        });
	                        
	                        function search(){
								$("#ZStatisticsMngVo").attr("action","/admsys/statisticsmng/satisfactionrsrch.html");
								$("#ZStatisticsMngVo").submit();
							}
	                        
	                        function excelDownload(){ 
                        	  // step 1. workbook 생성
                        	  var wb = XLSX.utils.book_new();
                        	  
                        	  var org = '';
                        	  if('${input.org1}' == 'gov'){
                        		  org = '공공';
                        	  }else if('${input.org2}' == 'priv'){
                        		  org = '민간';
                        	  }
                        	  
                        	  var type = '';
                        	  if('${input.type1}' == 'A'){
                        		  type = '여성가족부신고사건(A)'
                        	  }else if('${input.type2}' == 'B'){
                        		  type = '기관신청건(B)';
                        	  }else if('${input.type3}' == 'C'){
                        		  type = '여가부선정/타부처이관(C)';
                        	  }else if('${input.type4}' == 'D'){
                        		  type = '현장점검(D)';
                        	  }
 							  var wsData = [['검색'],
 								  			['기간:'+'<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />'+'~'+'<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />'],
 								  			['기관:'+org],
 								  			['유형:'+type],
 								  			['기관코드:'+'${input.orgId}'],
 								  			['진단일지번호(사건번호):'+'${input.consulting_application_no}']];
                        	  
                        	  const ws = XLSX.utils.aoa_to_sheet(wsData);
                        	  
                        	  XLSX.utils.book_append_sheet(wb, ws, "검색조건");

                        	  // step 2. 시트 만들기 
                        	  var newWorksheet = excelHandler.getWorksheet();

                        	  // step 3. workbook에 새로만든 워크시트에 이름을 주고 붙인다.  
                        	  XLSX.utils.book_append_sheet(wb, newWorksheet, excelHandler.getSheetName());

                        	  // step 4. 엑셀 파일 만들기 
                        	  var wbout = XLSX.write(wb, {bookType:'xlsx',  type: 'binary'});

                        	  // step 5. 엑셀 파일 내보내기 
                        	  saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), excelHandler.getExcelFileName());
                        	}

                        	var excelHandler = {
                        	    getExcelFileName : function(){
                        	        return '만족도조사_통계.xlsx';	//파일명
                        	    },
                        	    getSheetName : function(){
                        	        return '만족도조사';	//시트명
                        	    },
                        	    getExcelData : function(){
                        	        return document.getElementById('research_table'); 	//TABLE id
                        	    },
                        	    getWorksheet : function(){
                        	        return XLSX.utils.table_to_sheet(this.getExcelData());
                        	    }
                        	}

                        	function s2ab(s) { 
                        	  var buf = new ArrayBuffer(s.length); //convert s to arrayBuffer
                        	  var view = new Uint8Array(buf);  //create uint8array as viewer
                        	  for (var i=0; i<s.length; i++) view[i] = s.charCodeAt(i) & 0xFF; //convert to octet
                        	  return buf;    
                        	}
	                        	
						</script>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../end.jsp" flush="false" />
