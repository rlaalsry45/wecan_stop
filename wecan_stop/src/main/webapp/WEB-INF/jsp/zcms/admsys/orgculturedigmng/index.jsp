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
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/index.html">진단관리</a> <strong>담당관지정 및 접수 관리 </strong>
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">담당관지정 및 접수 관리 목록</h3><!-- <a class="btmore03" href="/admsys/orgculturedigmng/index.html">+ 홈페이지등록</a> --></li>
                            <li>
                            <div class="top_bt">
                                <a class="btmore07" href="javascript:checkAll(true,'reqChkBx');">전체선택</a>
                                <a class="btmore07" href="javascript:checkAll(false,'reqChkBx');">전체해제</a>
                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
                            </div>

                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <input type="hidden" id="dashNO" name="dashNO" value="${dashNO}" >
                                    <table class="main_table1" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
                                        <caption>관리목록</caption>
                                        <colgroup>
                                            <col width="5px" />
                                            <col width="10%" />
                                            <col width="25px" />
                                            <col width="20%" />
                                            <col width="20%" />
                                            <col width="20%" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','reqChkBx')" />
                                                </th>
                                                <th>번호</th>
                                                <th>신청자</th>
                                                <th>신청일자</th>
                                                <th>담당관</th>
                                                <th>상태</th>
                                            </tr>
                                        </thead>
                                        <tbody>
											<c:forEach items="${list}" var="each" varStatus="loop">
					                            <tr>
						                            <td>
					                            		<input class="bor_none" type="checkbox" name="reqChkBx" value="${each.NO}">
													</td>
					                                <td>${each.NO}</td>
					                                <td class="t_left"><a href="javascript:viewDetailPage(${each.NO});">${each.org_client_name}(${each.org_name})</a>
					                                	<input type="hidden" id="cn_${each.NO}" name="cn_${each.NO}" value="${each.org_client_name}" />
					                                	<input type="hidden" id="on_${each.NO}" name="on_${each.NO}" value="${each.org_name}" />
					                                </td>
					                                <td id="dataReqDate_${each.NO}">                                
					                                	<fmt:parseDate value="${each.create_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
														<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
					                                </td>
					                                <td>${each.manager_name}</td>
					                                <td id="dataReqStatus_${each.NO}">
					                                	<c:choose>
					                                		<c:when test='${each.step_status eq "1"}'>신청</c:when>
					                                		<c:when test='${each.step_status eq "2"}'>접수대기</c:when>
					                                		<c:when test='${each.step_status eq "3"}'>접수승인</c:when>
					                                		<c:when test='${each.step_status eq "4"}'>접수불가</c:when>
					                                		<c:when test='${each.step_status eq "5"}'>심사대기</c:when>
					                                		<c:when test='${each.step_status eq "6"}'>심사거절</c:when>
					                                		<c:when test='${each.step_status eq "7"}'>심사승인</c:when>
					                                		<c:when test='${each.step_status eq "8"}'>진단완료</c:when>
					                                		<c:otherwise>UNKNOWN</c:otherwise>	
					                                	</c:choose>
					                                	<input type="hidden" id="dataResponseTxt_${each.NO}" name="dataResponseTxt_${each.NO}" vlaue= />                                	
					                                </td>
					                            </tr>
											</c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="7" style="padding:20;">접수 목록이 없습니다.</td>
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
	                            	</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                    </div>
                    <!--/content-->
                </form:form>
                <script>
                	function openManagerListPopup(){
                			
                	}
                	function setManager(){
						var dataList = new Array();

						var chk_val = $(':checkbox[name=reqChkBx]:checked').map(function () {
							var obj = new Object();
							obj = parseInt($(this).val());
							dataList.push(obj);
						});
						
						if ( dataList.length <= 0 ) {
							alert("접수목록을 선택하여 주세요.");
							return false;
						}
                	}
                	
                	function setManagerList(objList) {
                		var ulLen = $("#actionUL li").length;
                		if( ulLen == 0 ) {
                			for( var i=0;i < objList.length; i++ ) {
                				$("#actionUL").append('<li data-no="'+objList[i].no+'" id="aulli_'+objList[i].no+'">'+objList[i].an
                						+'<a id="aa_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delActionList('+objList[i].no+');return false;">X</a></li>');
                			}
                		} else {
                			var ulArray = new Array();
                			for( var i = 0; i < ulLen; i++ ) {	
                				var liNo = $("#actionUL li:eq("+i+")").data("no");
                				ulArray.push(liNo);
                			}
                			for( var i=0;i < objList.length; i++ ) {				
                				var wNo = objList[i].no;
                				var exists = true;
                				for( var j=0; j < ulArray.length; j++){
                					if ( wNo == ulArray[j] ) {
                						exists = false;
                						break;
                					}
                				}

                				if ( exists ) {
                					$("#actionUL").append('<li data-no="'+objList[i].no+'" id="aulli_'+objList[i].no+'">'+objList[i].an
                							+'<a id="aa_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delActionList('+objList[i].no+');return false;">X</a></li>');
                				}					
                			}
                		}
                	}
                	
					
					function excelDownload(){
						var eForm = $("#AppActionMergeVo").serialize();
						
						$.ajax({
							  type: 'POST',
							  url: "/admsys/orgculturedigmng/index_excel.html",
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
				 	            return '담당관지정 및 접수.xlsx';
				 	        },
				 	        getSheetName : function(){
				 	            return '담당관지정 및 접수';
				 	        },
				 	        getExcelData : function(data){
				 	        	var arr = new Array();

				            	for(var i=0; i< data.length; i++){
				            		arr[i] = {'번호':data[i].NO
				            				,'신청자':data[i].org_client_name
				            				,'신청일자':data[i].create_date
				            				,'담당관':data[i].manager_name
				            				,'상태':data[i].step_status_txt}                              
				            	}
				            	
				 	           return arr;
				 	        },
				 	        getWorksheet : function(data){
				 	            return XLSX.utils.json_to_sheet(this.getExcelData(data));
				 	        }
				 	}
                </script>
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

				if (typeof getDashNo != "undefined" && getDashNo != ""){
					viewDetailPage(getDashNo);
				}
			});
			
			function viewDetailPage(NO){
				$("#content").load("/admsys/orgculturedigmng/index_view.html", {'NO':NO} );  
			}			
			</script>
<jsp:include page="../end.jsp" flush="false" />
