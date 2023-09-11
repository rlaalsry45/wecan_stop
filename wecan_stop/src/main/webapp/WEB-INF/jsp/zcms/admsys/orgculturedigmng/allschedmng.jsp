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
                <form:form modelAttribute="zsiteVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/orgculturedigmng/">HOME</a> <a href="/admsys/orgculturedigmng/allschedmng.html">진단관리</a> <strong>전체 일정 관리 </strong>
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">일정 관리 목록</h3></li>
                            <li>
                            	<table style="width:100%">
                            		<tr>
                            			<td>접수 날짜</td>
                            			<td>
                            				<input type="date" id="registration_date_from" name="registration_date_from" value="${data.registration_date_from}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
											<input type="date" id="registration_date_to" name="registration_date_to" value="${data.registration_date_to}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
                            			</td>
                            			<td>담당관</td>
                            			<td><input type="text" id="manager_name" name="manager_name" value="${data.manager_name}"></td>
                            			<td>기관명</td>
                            			<td><input type="text" id="org_name" name="org_name" value="${data.org_name}"></td>
                            			<td>진단 기간</td>
                            			<td>
                            				<input type="date" id="action_consulting_date_from" name="action_consulting_date_from" value="${data.action_consulting_date_from}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
											<input type="date" id="action_consulting_date_to" name="action_consulting_date_to" value="${data.action_consulting_date_to}" min="2019-01-01" max="2022-12-31" placeholder="년/월/일">
                            			</td>
                            			<td>진행 상태</td>
                            			<td>
											<select id="step_status" name="step_status">
												<option value="" <c:if test='${data.step_status eq ""}'>selected</c:if>>선택</option>
												<option value="1" <c:if test='${data.step_status eq "1"}'>selected</c:if>>신청</option>
												<option value="2" <c:if test='${data.step_status eq "2"}'>selected</c:if>>접수대기</option>
												<option value="3" <c:if test='${data.step_status eq "3"}'>selected</c:if>>접수승인</option>
												<option value="4" <c:if test='${data.step_status eq "4"}'>selected</c:if>>접수불가</option>
												<option value="5" <c:if test='${data.step_status eq "5"}'>selected</c:if>>심사대기</option>
												<option value="6" <c:if test='${data.step_status eq "6"}'>selected</c:if>>심사거절</option>
												<option value="7" <c:if test='${data.step_status eq "7"}'>selected</c:if>>심사승인</option>
												<option value="8" <c:if test='${data.step_status eq "8"}'>selected</c:if>>컨설팅완료</option>
											</select>
                            			</td>
                            		</tr>
                            		<tr>
                            			<td colspan="10">
											<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
											<span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
										</td>
									</tr>
                            	</table>
                            </li>
                            <li>
                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1" summary="번호, 등록번호, 접수일자, 담당관, 기관명, 컨설팅 기간, 진행상태">
                                        <caption>관리목록</caption>
                                        <colgroup>
                                            <col width="5%" />
                                            <col width="20%" />
                                            <col width="15%" />
                                            <col width="10%" />
                                            <col width="15%" />
                                            <col width="15%" />
                                            <col width="20%" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>번호</th>
                                                <th>등록번호</th>
                                                <th>접수일자</th>
                                                <th>담당관</th>
                                                <th>기관명</th>
                                                <th>진단 기간</th>
                                                <th>진행상태</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="each" varStatus="loop">
                                                <tr>
                                                    <td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
                                                    <td>${each.consulting_action_no}</td>
                                                    <td>${each.registration_date}</td>
                                                    <td>${each.manager_name}</td>
                                                    <td>${each.org_name}</td>
                                                    <td>${each.action_consulting_date_from} ~ ${each.action_consulting_date_to}</td>
                                                    <td>${each.step_status_name}</td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="9" style="padding:20;">일정이 없습니다.</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                                    <!--/게시판 영역-->
									<!--설명-->

									<!--/설명-->
									<div class="top_bt">
										<c:forEach items="${perm}" var="p" varStatus="ini">
											<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_4' and p.ALLOW_YN eq 'Y' }">
												<a class="btmore05" href="javascript:excelDownload();">엑셀다운로드</a>
											</c:if>
										</c:forEach>
										<c:forEach items="${perm}" var="p" varStatus="ini">
											<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_3' and p.ALLOW_YN eq 'Y' }">
												<a class="btmore05" href="javascript:window.print();">인쇄</a>
											</c:if>
										</c:forEach>
                            		</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        <script type="text/javascript">
                        
                        function excelDownload(){
							var eForm = $("#zsiteVo").serialize();
							
							$.ajax({
								  type: 'POST',
								  url: "/admsys/orgculturedigmng/allschedmng_excel.html",
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
                     	            return '일정 관리.xlsx';
                     	        },
                     	        getSheetName : function(){
                     	            return '일정 관리';
                     	        },
                     	        getExcelData : function(data){
                     	        	var arr = new Array();
                     	        	
                                	for(var i=0; i< data.length; i++){
                                		arr[i] = {'등록번호':data[i].consulting_action_no
                                				,'접수일자':data[i].registration_date
                                				,'담당관':data[i].manager_name
                                				,'기관명':data[i].org_name
                                				,'진단기간':data[i].action_consulting_date_from+'~'+data[i].action_consulting_date_to
                                				,'진행상태':data[i].step_status_name}  
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
