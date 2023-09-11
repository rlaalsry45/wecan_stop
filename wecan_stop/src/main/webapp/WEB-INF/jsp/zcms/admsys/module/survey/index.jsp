<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />

            <div id="contents">
            	<form:form modelAttribute="zSurveyVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/index.html">조직문화진단관리</a> <strong>설문조사 관리</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="reg_date" <c:if test="${input.cond1=='reg_date'}"><c:out value='selected' /></c:if>>등록일</option>
                            </select>
                            	<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
								<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
								<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;" />
                                        ~
								<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;" />
                            <select style="height:27px;" name="cond2">
                            	<option value="survey_type" <c:if test="${input.cond2=='survey_type'}"><c:out value='selected' /></c:if>>설문타입</option>
                                <option value="org_id" <c:if test="${input.cond2=='org_id'}"><c:out value='selected' /></c:if>>기관ID</option>
                            	<option value="reg_id" <c:if test="${input.cond2=='reg_id'}"><c:out value='selected' /></c:if>>등록ID</option>
                            </select>
							<input type=text name="keyword" value="<c:out value='${input.keyword}' />" class="bor1ddd" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg">
                                <h3 class="sub">설문조사 관리 목록</h3>
                            </li>
                            <li>
                                <div class="top_bt">
                                    <a class="btmore07" href="javascript:checkAll(true,'surveyno');">전체선택</a>
                                    <a class="btmore07" href="javascript:checkAll(false,'surveyno');">전체해제</a>
                                    <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
                                </div>
                                <div class="main_table">
                                    <!---게시판 영역 -->
                                    <table class="main_table1" summary="번호, 제목, ID, 기관명, 상태, 대상, 시작일, 종료일, 관리">
                                        <caption>설문조사 폼리스트</caption>
                                        <colgroup>
                                            <col width="3px" />
                                            <col width="10%" />
                                            <col width="10%"/>
                                            <col width="20%" />
                                            <col width="20%" />
                                            <col  />
                                             <!--
                                            <col width="20%" />
                                            <col width="15%" />
                                            <col width="10%" />
                                            -->
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','surveyno')" />
                                                </th>
                                                <th>번호</th>
                                                <th>설문타입</th>
                                                <th>기관ID</th>
                                                <th>등록ID</th>
                                                <th>등록일</th
                                                <%--
                                                <th>관리</th>
                                                <th>미리보기</th>
                                                <th>사용현황</th>
                                                --%>
                                            </tr>
                                        </thead>
                                        <tbody>
<!--                                         	<tr> -->
<!-- 	                                        	<td colspan="8" class="Cnone lborder rborder"> -->
<!-- 	                                                <table class="Bnone_table" summary="치환문구복사"> -->
<!-- 	                                                    <tr> -->
<!-- 	                                                        <th class="Cnone" style="width:50px"> -->
<!-- 	                                                            <a href="javascript:void(0)" onclick="copytoclipboard('&#34;wecan.stop.or.kr&#47;S2021001&#34;');"> -->
<!-- 							                                        <img src="/cms/image/btn_replace_word.png" alt="치환문구복사" /> -->
<!-- 							                                    </a> -->
<!-- 	                                                        </th> -->
<!-- 	                                                        <td class="Cnone Tleft"> -->
<!-- 	                                                            URL : &#34;wecan.stop.or.kr&#47;S2022001&#47;survey.html&#34; -->
<!-- 	                                                        </td> -->
<!-- 	                                                    </tr> -->
<!-- 	                                                </table> -->
<!-- 	                                            </td> -->
<!-- 	                                        </tr> -->
                                            <c:forEach items="${list}" var="each" varStatus="loop">
                                                <tr ondblclick="view('${each.no}');" style="cursor:pointer;">
                                                    <%--td rowspan="2"--%>
                                                    <td>
                                                        <c:set value="${each.no}" var="k" />
                                                        <input class="bor_none" name="surveyno" value="${k}" type="checkbox" />
                                                    </td>
													<%--td rowspan="2"--%>
                                                    <%--
                                                    <td>
                                                        <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                                                    </td>
                                                    --%>
                                                    <td>
                                                        <c:out value='${each.no}' />
                                                    </td>
                                                    <td>
                                                        <c:out value='${each.surveyType}' />
                                                    </td>
                                                    <td>
                                                        <c:out value='${each.orgId}' />
                                                    </td>
                                                    <td>
                                                        <c:out value='${each.regId}' />
                                                    </td>
                                                    <td>
                                                        <c:out value='${each.regDate}' />
                                                    </td>
<!--                                                     <td> -->
<%--                                                         <c:choose> --%>
<%--                                                             <c:when test='${each.target=="1"}'><c:out value='정회원' /></c:when> --%>
<%--                                                             <c:when test='${each.target=="2"}'><c:out value='비회원' /></c:when> --%>
<%--                                                             <c:otherwise><c:out value='전체' /></c:otherwise> --%>
<%--                                                         </c:choose> --%>
<!--                                                     </td> -->
<!--                                                     <td> -->
<%--                                                         <c:out value='${each.sdate} ~ ${each.edate}' /> --%>
<!--                                                     </td> -->
                                                    <%--
                                                    <td>
                                                        <fmt:parseDate value="${each.datereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                        <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                                    </td>
                                                    <td>
                                                        <c:url value="result.html" var="url">
                                                            <c:param name="surveyno" value="${each.surveyno}" />
                                                        </c:url>
                                                        <a class="btmore04" href="${url}">결과보기</a>
                                                    </td> 
                                                    <td>
                                                        <c:url value="/PrvwEtc" var="url">
                                                            <c:param name="type" value="survey" />
                                                            <c:param name="no" value="${data.surveyno}" />
                                                            <c:param name="skin" value="${data.skin}" />
                                                        </c:url>
                                                        <a href="${url}" target="_blank"><img alt="미리보기" src="/cms/image/btn_bbs_preview.jpg" /></a>
                                                    </td>
													<td>
                                                        <c:out value='${fn:replace(data.sitetitle,",","<br>")}' escapeXml="false" />
                                                    </td>
                                                    --%>
                                                </tr>
                                                <%--
                                                <tr>
                                                    <td colspan="10" style="padding:0">
                                                        <table class="replacement_words" cellpadding=0 border=0 cellspacing=0 width=100%>
                                                            <tr>
                                                                <th width=50 style="">
                                                                    <a href="javascript:void(0)" onclick="copytoclipboard('&lt;call type=&#34;survey&#34; skin=&#34;${data.skin}&#34; no=&#34;${data.surveyno}&#34; &#47;&gt;');">
                                                                        <img src="/cms/image/btn_replace_word.png" alt="치환문구복사" />
                                                                    </a>
                                                                </th>
                                                                <td style="text-align:left;">
                                                                    &lt;call
                                                                    type=&#34;survey&#34;
                                                                    skin=&#34;${data.skin}&#34;
                                                                    no=&#34;${data.surveyno}&#34;
                                                                    &#47;&gt;
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </td>
                                                </tr>
                                                --%>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <!-- <td colspan="11" style="padding:20;">기록이 없습니다.</td> -->
                                                    <td colspan="10" style="padding:20;">기록이 없습니다.</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
<!-- 							<p class="notification_right01"> -->
<!-- 								<img alt="!" src="/cms/image/excla.gif"> 1. 상단의 등록을 통해 설문을 등록할 수 있습니다. -->
<!-- 								<br> -->
<!-- 								<img alt="!" src="/cms/image/excla.gif"> 2. 설문 기간 설정 및 대상을 선택합니다. 문항 관리를 통해 객관식, 주관신, 단일선택, 중복선택이 가능합니다. 여러 문항 추가도 가능합니다. -->
<!-- 								<br> -->
<!-- 								<img alt="!" src="/cms/image/excla.gif"> 3. 결과보기를 통해 설문 진행 현황을 확인할 수 있습니다. -->
<!-- 							</p> -->
                                    <!---/게시판 영역-->
                                <div class="top_bt">
	                               	<a class="btmore05" href="javascript:excelDownload();">엑셀 다운로드</a>
	                               	<a class="btmore05" href="javascript:window.print();">인쇄</a>
	                               	<!--<a class="btmore01" href="javascript:del('surveyno');">삭제</a>
	                               	<a class="btmore01" href="javascript:update('${url}');">수정</a>
	                               	<a class="btmore01" href="insert.html">등록</a>
	                               	-->
	                           	</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        <script type="text/javascript">
                        function update(){
                        	var surveynoChk = $(':checkbox[name=surveyno]:checked');
                        	
                        	if(surveynoChk.length == 0){
								alert("설문조사 관리 목록을 한개 체크하세요.");
								return;
							}
                        	if(surveynoChk.length > 1){
								alert("설문조사 관리 목록을 한개만 체크하세요.");
								return;
							}
                        	location.href = "update.html?surveyno="+surveynoChk.val();
			
                        }
                        
                        function excelDownload(){
							var eForm = $("#zSurveyVo").serialize();
							
							$.ajax({
								  type: 'POST',
								  url: "/admsys/module/survey/index_excel.html",
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
                     	            return '설문조사.xlsx';
                     	        },
                     	        getSheetName : function(){
                     	            return '설문조사';
                     	        },
                     	        getExcelData : function(data){
                     	        	var arr = new Array();
                     	        	
                                	for(var i=0; i< data.length; i++){
                                		arr[i] = {'번호':data[i].no
                                				,'설문타입':data[i].surveyType
                                				,'기관ID':data[i].orgId
                                				,'등록ID':data[i].regId
                                				,'등록일':data[i].regDate}
                                	}
                               		
                     	           return arr;
                     	        },
                     	        getWorksheet : function(data){
                     	            return XLSX.utils.json_to_sheet(this.getExcelData(data));
                     	        }
                     	}
                        
                        function view(surveyno){						
							$("#content").load("/admsys/module/survey/view.html", {'no': surveyno} ); 
                        }
                        </script>
                    </div><!--/content-->
                </form:form>
            </div><!--/contents-->
<jsp:include page="../../end.jsp" flush="false" />
