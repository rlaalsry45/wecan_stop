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
                <form:form modelAttribute="WOrgCultureDigMngVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/index.html">진단관리</a> <strong>조치일지 삭제함</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="create_date" <c:if test="${input.cond1=='create_date'}"><c:out value='selected' /></c:if>>등록일</option>
                            </select>
							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">                            
                            <select style="height:27px;" name="cond2">
                                <option value="consulting_action_no" <c:if test="${input.cond2=='consulting_action_no'}"><c:out value='selected' /></c:if>>상담번호</option>
                                <option value="action_consulting_type" <c:if test="${input.cond2=='action_consulting_type'}"><c:out value='selected' /></c:if>>항목</option>
                            	<option value="manager" <c:if test="${input.cond2=='manager'}"><c:out value='selected' /></c:if>>담당관</option>
                            </select>                                               
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="search();" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">조치일지 삭제함 목록</h3></li>
                            <li>
                            <div class="top_bt">
                                <a class="btmore07" href="javascript:checkAll(true,'actionChkBx');">전체선택</a>
                                <a class="btmore07" href="javascript:checkAll(false,'actionChkBx');">전체해제</a>
                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
                            </div>

                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1" summary="상담번호, 항목, 담당관, 경로, 내용, 등록일">
                                        <caption>조치일지 목록</caption>
                                        <colgroup>
                                           <col width="5px" />
                                           <col width="15%" />
                                           <col width="15%" />
                                           <col />
                                           <col width="15%" />
                                           <col width="15%" />
                                           <col width="15%" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','actionChkBx')" />
                                                </th>
                                                <th>진단번호</th>
                                                <th>기관 분류</th>
                                                <th>기관명</th>
                                                <th>진행상태</th>
                                                <th>담당관</th>
                                                <th>등록일</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="each" varStatus="loop">
                                                <tr>
                                                    <td>
														<input class="bor_none" type="checkbox" name="actionChkBx" value="${each.consulting_action_no}">
                                                    </td>
                                                    <td>${each.consulting_action_no}</td>
                                                    <td>${each.org_type_gov_detail_txt}</td>
	                                                <td>${each.org_name}</td>
	                                                <td>${each.step_status_txt}</td>
                                                    <td>${each.manager_name}</td>
                                                    <td>${each.registration_date}</td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="9" style="padding:20;">기록이 없습니다.</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                                    <!--/게시판 영역-->
									<!--설명-->
									<!--<p class="notification_right01">
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
										</p> -->
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
									<c:forEach items="${perm}" var="p" varStatus="ini">
										<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_2' and p.ALLOW_YN eq 'Y' }">
											<a class="btmore01" href="javascript:delPermanent();">영구삭제</a>
										</c:if>
									</c:forEach>
									<c:forEach items="${perm}" var="p" varStatus="ini">
										<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_5' and p.ALLOW_YN eq 'Y' }">
											<a class="btmore01" href="javascript:updDelYn();">복원</a>
										</c:if>
									</c:forEach>
                            	</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        <script type="text/javascript">

							function delPermanent(){
								if($(':checkbox[name=actionChkBx]:checked').length == 0){
									alert("조치일지 목록을 한개이상 체크하세요.");
									return;
								}
								
								if(confirm("영구삭제 하시겠습니까?")){
									var dataList = new Array();
									var chk_val = $(':checkbox[name=actionChkBx]:checked').map(function () {
										var obj = new Object();
										obj = $(this).val();
										dataList.push(obj);
									});
	
									$.ajax({
										  type: 'POST',
										  url: "/admsys/orgculturedigmng/allhisdel_req_delPermanent.html",
										  data: {"delList":dataList},
										  traditional:true,
										  success: function(result){
											  if ( result.retStatus == "SUCCESS" ) {
												  alert("영구 삭제 하였습니다.");
												  location.href = "<c:url value='/admsys/orgculturedigmng/allhisdel.html' />";
											  } else {
												  alert("영구 삭제에 실패 하였습니다.");
											  }
										  },
										  error:function(e){
											  alert("영구 삭제중 오류가 발생하였습니다."+e.responseText  );
										  }
									});
								}
							}
							
							function updDelYn(){
								if($(':checkbox[name=actionChkBx]:checked').length == 0){
									alert("조치일지 목록을 한개이상 체크하세요.");
									return;
								}
								
								if(confirm("복원 하시겠습니까?")){
									var dataList = new Array();
									var chk_val = $(':checkbox[name=actionChkBx]:checked').map(function () {
										var obj = new Object();
										obj = $(this).val();
										dataList.push(obj);
									});
	
									$.ajax({
										  type: 'POST',
										  url: "/admsys/orgculturedigmng/allhisdel_req_updDelYn.html",
										  data: {"updList":dataList},
										  traditional:true,
										  success: function(result){
											  if ( result.retStatus == "SUCCESS" ) {
												  alert("복원 하였습니다.");
												  location.href = "<c:url value='/admsys/orgculturedigmng/allhisdel.html' />";
											  } else {
												  alert("복원에 실패 하였습니다.");
											  }
										  },
										  error:function(e){
											  alert("복원중 오류가 발생하였습니다."+e.responseText  );
										  }
									});
								}
							}
							
							function search(){
								$("#WOrgCultureDigMngVo").attr("action","/admsys/orgculturedigmng/allhisdel.html");
								$("#WOrgCultureDigMngVo").submit();
							}

							function excelDownload(){
								var eForm = $("#WOrgCultureDigMngVo").serialize();
								
								$.ajax({
									  type: 'POST',
									  url: "/admsys/orgculturedigmng/allhisdel_excel.html",
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
						 	            return '조치일지 삭제함.xlsx';
						 	        },
						 	        getSheetName : function(){
						 	            return '조치일지 삭제함';
						 	        },
						 	        getExcelData : function(data){
						 	        	var arr = new Array();
						 	        	
						            	for(var i=0; i< data.length; i++){
						            		arr[i] = {'진단번호':data[i].consulting_action_no
						            				,'기관 분류':data[i].org_type_gov_detail_txt
						            				,'기관명':data[i].org_name
						            				,'진행상태':data[i].step_status_txt
						            				,'담당관':data[i].manager_name
						            				,'등록일':data[i].registration_date}
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
