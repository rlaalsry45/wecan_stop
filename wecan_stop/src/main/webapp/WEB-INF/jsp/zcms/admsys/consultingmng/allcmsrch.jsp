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
                <form:form modelAttribute="WConsultingMngVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/consultingmng/allcmsrch.html">상담관리</a> <strong>전체 상담 조회</strong>
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">전체 상담 조회 목록</h3></li>
                            <li>
								<jsp:include page="./consulting_search_part.jsp" flush="false" />
                        	</li>
	                        <li>
	                            <div class="top_bt">
	                                <a class="btmore07" href="javascript:checkAll(true,'consultingChkBx');">전체선택</a>
	                                <a class="btmore07" href="javascript:checkAll(false,'consultingChkBx');">전체해제</a>
	                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
	                                <!-- <a class="btmore05" href="javascript:del('siteno');">삭제</a> -->
	                            </div>
	
	                                <div class="main_table">
	                                    <!--게시판 영역-->
	                                    <table class="main_table1" summary="전체 상담 조회 목록을 보여줍니다.">
	                                        <caption>관리목록</caption>
	                                        <colgroup>
	                                            <col width="3px" />
	                                            <col />
	                                            <col width="10%" />
	                                            <col width="12%" />
	                                            <col width="10%" />
	                                            <col width="12%" />
	                                            <col width="15%" />
	                                            <col width="15%" />
	                                            <col width="12%" />
	                                        </colgroup>
	                                        <thead>
	                                            <tr>
	                                                <th>
	                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','consultingChkBx')" />
	                                                </th>
	                                                <th>상담번호</th>
	                                                <th>담당관</th>
	                                                <th>분류</th>
	                                                <th>상담시작일</th>
	                                                <th>연락처</th>
	                                                <th>의뢰인(피해자와의관계)</th>
	                                                <th>조치-서비스연계</th>
	                                                <th>생성일</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                            <c:forEach items="${list}" var="each" varStatus="loop">
	                                                <tr>
	                                                    <td>
	                                                    	<input class="bor_none" type="checkbox" name="consultingChkBx" value="${each.NO}" />
	                                                    </td>
	                                                    <td><a href="javascript:viewDetailPage('${each.NO}','${each.consulting_history_no}');">${each.consulting_history_no}</a></td>
	                                                    <td>${each.manager_name}</td>
	                                                    <td>${each.consulting_type_txt}</td>
	                                                    <td>
	                                                    	<fmt:parseDate value="${each.consulting_start_date}" pattern="yyyy-MM-dd HH:mm:ss" var="csdDate" />
	                                                        <fmt:formatDate type="both" value="${csdDate}" pattern="yyyy-MM-dd" />
	                                                    </td>
	                                                    <td>${each.contact_tel_no}</td>
	                                                    <td>${each.client_victim_rel_type_txt}</td>
	                                                    <td>${each.response_type_service_txt}</td>
	                                                    <td>
	                                                        <fmt:parseDate value="${each.registration_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
	                                                        <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
	                                                    </td>  
	                                                </tr>
	                                            </c:forEach>
	                                            <c:if test="${input.total==0}">
	                                                <tr>
	                                                    <td colspan="9" style="padding:20;">상담 기록이 없습니다.</td>
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
		                            	</div>
	                                </div>
	                                <!--/main_table-->
	                            </li>
                        	</ul>
                        <script>
	                        $("#consulting_registration").click(function(){
	                        	$("#content").load("/admsys/consultingmng/consulting_registration_form.html");
	                        });
	                        
	                        function deleteChecked(){
								var dataList = new Array();

								var chk_val = $(':checkbox[name=consultingChkBx]:checked').map(function () {
									var obj = new Object();
									obj = parseInt($(this).val());
									dataList.push(obj);
								});

								$.ajax({
									  type: 'POST',
									  url: "/admsys/consultingmng/consultingmng_req_delete.html",
									  data: {"delList":dataList,"delete_reason":"체크 삭제"},
									  traditional:true,
									  success: function(result){
										  if ( result.retStatus == "SUCCESS" ) {
											  alert("삭제 하였습니다.");
											  location.reload();
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
								var eForm = $("#WConsultingMngVo").serialize();
								
								$.ajax({
									  type: 'POST',
									  url: "/admsys/consultingmng/allcmsrch_excel.html",
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
	                     	            return '전체 상담 관리.xlsx';
	                     	        },
	                     	        getSheetName : function(){
	                     	            return '전체 상담 관리';
	                     	        },
	                     	        getExcelData : function(data){
	                     	        	var arr = new Array();
	                     	        	
	                                	for(var i=0; i< data.length; i++){
	                                		arr[i] = {'상담번호':data[i].consulting_history_no
	                                				,'담당관명':data[i].manager_name
	                                				,'분류':data[i].consulting_type_txt
	                                				,'작성일':data[i].registration_date
	                                				,'상담시작일시':data[i].consulting_start_date
	                                				,'상담종료일시':data[i].consulting_end_date
	                                				,'경로':data[i].received_type_txt
	                                				,'연락처':data[i].contact_tel_no
	                                				,'내용':data[i].consulting_req_type_txt
	                                				,'유입경로':data[i].contact_method_type_txt
	                                				,'의뢰인명':data[i].client_name
	                                				,'의뢰인성별':data[i].client_gender_txt
	                                				,'의뢰인소속':data[i].client_belong
	                                				,'의뢰인피해자와의관계':data[i].client_victim_rel_type_txt
	                                				,'피해자명':data[i].victim_name
	                                				,'피해자성별':data[i].victim_gender_type_txt
	                                				,'피해자소속':data[i].victim_belong
	                                				,'행위자명':data[i].offender_name
	                                				,'행위자성별':data[i].offender_gender_type_txt
	                                				,'행위자소속':data[i].offender_belong
	                                				,'행위자피해자와의관계':data[i].offender_victim_rel_type_txt
	                                				,'피해내용':data[i].harm_first_type_txt
	                                				,'조치':data[i].response_type_txt}                              
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
			function viewDetailPage(NO, consulting_history_no){
				$("#content").load("/admsys/consultingmng/consulting_view.html", {'NO':NO,'consulting_history_no':consulting_history_no} );  
			}
			</script>
<jsp:include page="../end.jsp" flush="false" />