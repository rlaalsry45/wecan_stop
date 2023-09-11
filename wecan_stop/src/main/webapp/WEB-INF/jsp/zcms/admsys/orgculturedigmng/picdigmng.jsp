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
                <form:form modelAttribute="AppActionMergeVo" name="OrgCDMFrm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/picdigmng.html">진단관리</a> <strong>담당관 진단 관리 </strong>
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">담당관 진단 관리 목록</h3><!-- <a class="btmore03" href="/admsys/orgculturedigmng/picdigmng.html">+ 홈페이지등록</a> --></li>
                            <li>
                            	<jsp:include page="./picdigmng_search_part.jsp" flush="false" />
                            </li>
                            <li>
								<div class="top_bt">
	                                <a class="btmore07" href="javascript:checkAll(true,'actionChkBx');">전체선택</a>
	                                <a class="btmore07" href="javascript:checkAll(false,'actionChkBx');">전체해제</a>
	                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
	                                <!-- <a class="btmore05" href="javascript:del('actionChkBx');">삭제</a> -->
	                            </div>
                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <input type="hidden" id="dashNO" name="dashNO" value="${dashNO}" >
                                    <input type="hidden" id="actionNO" name="actionNO" value="${data.actionNO}" >
                                    <input type="hidden" id="consulting_action_no" name="consulting_action_no" value="${data.consulting_action_no}" >
                                    <input type="hidden" id="fromDetailYN" name="fromDetailYN" value="${data.fromDetailYN}" >
                                    
                                    <table class="main_table1" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
                                        <caption>관리목록</caption>
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
														<input class="bor_none" type="checkbox" name="actionChkBx" value="${each.actionNO}">
                                                    </td>
                                                    <td><a href="javascript:viewDetailPage('${each.actionNO}','${each.consulting_action_no}');">${each.consulting_action_no}</a></td>
                                                    <td>${each.org_type_gov_detail_txt}</td>
	                                                <td>${each.org_name}</td>
	                                                <td>${each.step_status_txt}</td>
                                                    <td>${each.manager_name}</td>
                                                    <td>${each.registration_date}</td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="9" style="padding:20;">조치 기록이 없습니다.</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                                    <!--/게시판 영역-->
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
												<a class="btmore01" href="javascript:deleteChecked();">삭제</a>
											</c:if>
										</c:forEach>
	                       				<c:forEach items="${perm}" var="p" varStatus="ini">
											<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
												<a id="consulting_action_registration" class="btmore01" href="javascript:void(0);">등록</a>
											</c:if>
										</c:forEach>
	                            	</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        <script>
							$("#consulting_action_registration").click(function(){
								$("#content").load("/admsys/orgculturedigmng/picdigmng_registration_form.html");
							});

							/*$("#content tbody > tr > td:eq(1)").click(function(){
								console.log($(this).text());
								$("#content").load("/admsys/orgculturedigmng/picdigmng_registration_form.html");
							});*/

							function deleteChecked(){
								var dataList = new Array();

								var chk_val = $(':checkbox[name=actionChkBx]:checked').map(function () {
									var obj = new Object();
									obj = parseInt($(this).val());
									dataList.push(obj);
								});

								$.ajax({
									  type: 'POST',
									  url: "/admsys/orgculturedigmng/picdigmng_req_delete.html",
									  data: {"delList":dataList},
									  traditional:true,
									  success: function(result){
										  if ( result.retStatus == "SUCCESS" ) {
											  alert("삭제 하였습니다.");
											  location.href = "<c:url value='/admsys/orgculturedigmng/picdigmng.html' />";
										  } else {
											  alert("삭제에 실패 하였습니다.");
										  }
									  },
									  error:function(e){
										  alert("삭제중 오류가 발생하였습니다."+e.responseText  );
									  }
								});
							}

							function excelDownload(){
								var eForm = $("#AppActionMergeVo").serialize();
								
								$.ajax({
									  type: 'POST',
									  url: "/admsys/orgculturedigmng/picdigmng_excel.html",
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
						 	            return '담당관 진단 관리.xlsx';
						 	        },
						 	        getSheetName : function(){
						 	            return '담당관 진단 관리';
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
	
			<script>
			$(document).ready(function () {
				var getDashNo = $("#dashNO").val();
				var getActionNO = $("#actionNO").val();
				var getConsulting_action_no = $("#consulting_action_no").val();
				var getFromDetailYN = $("#fromDetailYN").val();
				
				if (typeof getDashNo !="undefined" && getDashNo != ""){
					viewDetailPageT(getDashNo);
				} else if (typeof getActionNO != "undefined" && getActionNO != "0" && getActionNO != "" && typeof getConsulting_action_no != "undefined" && getConsulting_action_no != "" && typeof getFromDetailYN != "undefined" && getFromDetailYN != "Y" ) {
					viewDetailPage(getActionNO, getConsulting_action_no);
				}
			});
			
			function viewDetailPageT(NO){
				$("#content").load("/admsys/orgculturedigmng/picdigmng_view.html", {'NO':NO} );  
			}
			
			function viewDetailPage(NO, consulting_action_no){
				$("#content").load("/admsys/orgculturedigmng/picdigmng_view.html", {'actionNO':NO,'consulting_action_no':consulting_action_no} );  
			}
			</script>
<jsp:include page="../end.jsp" flush="false" />
