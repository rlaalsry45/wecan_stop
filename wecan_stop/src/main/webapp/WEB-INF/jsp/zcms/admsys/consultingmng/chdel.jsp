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
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/consultingmng/chdel.html">상담관리</a> <strong>상담일지 삭제함</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="sitedatereg" <c:if test="${input.cond1=='sitedatereg'}"><c:out value='selected' /></c:if>>등록일</option>
                                <option value="sitedatemod" <c:if test="${input.cond1=='sitedatemod'}"><c:out value='selected' /></c:if>>수정일</option>
                            </select>
                               <input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" style="width:128px;"/>
                                        ~
                                <input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" style="width:128px;"/>
                            <select style="height:27px;" name="cond2">
                                <option value="sitetitle" <c:if test="${input.cond2=='sitetitle'}"><c:out value='selected' /></c:if>>제목</option>
                                <option value="sitedomain" <c:if test="${input.cond2=='sitedomain'}"><c:out value='selected' /></c:if>>도메인</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <select style="height:27px;" name="sitestatus">
                                <option value="" <c:if test="${input.sitestatus==''}"><c:out value='selected' /></c:if>>상태</option>
                                <option value="1" <c:if test="${input.sitestatus=='1'}"><c:out value='selected' /></c:if>>사용</option>
                                <option value="2" <c:if test="${input.sitestatus=='2'}"><c:out value='selected' /></c:if>>중지</option>
                            </select>
                            <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">상담일지 삭제함 목록</h3><!-- <a class="btmore03" href="/admsys/consultingmng/chdel.html">+ 홈페이지등록</a> --></li>
                            <li>
                            <div class="top_bt">
                                <a class="btmore07" href="javascript:checkAll(true,'consultingChkBx');">전체선택</a>
                                <a class="btmore07" href="javascript:checkAll(false,'consultingChkBx');">전체해제</a>
                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
                                <!-- <a class="btmore05" href="javascript:del('siteno');">삭제</a> -->
                            </div>

                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1" summary="담당관별 상담관리 삭제 요청 목록을 보여줍니다.">
                                        <caption>관리목록</caption>
                                        <colgroup>
                                            <col width="5px" />
                                            <col width="15%" />
                                            <col />
                                            <col width="15%" />
                                            <col width="20%" />
                                            <col width="15%" />
                                            <col width="15%" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','consultingChkBx')" />
                                                </th>
                                                <th>상담번호</th>
                                                <th>의뢰인</th>
                                                <th>의뢰인소속</th>
                                                <th>내용</th>
                                                <th>생성일</th>
                                                <th>담당관</th>
                                            </tr>
                                        </thead>
                                        <tbody>
											<c:forEach items="${list}" var="each" varStatus="loop">
                                                <tr>
                                                    <td>
                                                    	<input class="bor_none" type="checkbox" name="consultingChkBx" value="${each.consulting_history_no}" />
                                                    </td>
                                                    <td><a href="javascript:viewDetailPage('${each.NO}','${each.consulting_history_no}');">${each.consulting_history_no}</a></td>
                                                    <td>${each.client_name}</td>
                                                    <td>${each.client_belong}</td>
                                                    <td>${each.consulting_req_type}</td>
                                                    <td>
                                                        <fmt:parseDate value="${each.registration_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
                                                        <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                                    </td>
                                                    <td>${each.manager}</td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="7" style="padding:20;">상담 기록이 없습니다.</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                                    <!--/게시판 영역-->
									<!--설명-->
<!-- 									<p class="notification_right01">
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
											<a class="btmore05" href="javascript:excelDownload();">엑셀 다운로드</a>
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
								if($(':checkbox[name=consultingChkBx]:checked').length == 0){
									alert("상담일지 목록을 한개이상 체크하세요.");
									return;
								}
								
								if(confirm("영구삭제 하시겠습니까?")){
									var dataList = new Array();
									var chk_val = $(':checkbox[name=consultingChkBx]:checked').map(function () {
										var obj = new Object();
										obj = $(this).val();
										dataList.push(obj);
									});
	
									$.ajax({
										  type: 'POST',
										  url: "/admsys/consultingmng/chdel_req_delPermanent.html",
										  data: {"delList":dataList},
										  traditional:true,
										  success: function(result){
											  if ( result.retStatus == "SUCCESS" ) {
												  alert("영구 삭제 하였습니다.");
												  location.reload();
												  //location.href = "<c:url value='/admsys/orgculturedigmng/allhisdel.html' />";
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
								if($(':checkbox[name=consultingChkBx]:checked').length == 0){
									alert("조치일지 목록을 한개이상 체크하세요.");
									return;
								}
								
								if(confirm("복원 하시겠습니까?")){
									var dataList = new Array();
									var chk_val = $(':checkbox[name=consultingChkBx]:checked').map(function () {
										var obj = new Object();
										obj = $(this).val();
										dataList.push(obj);
									});
	
									$.ajax({
										  type: 'POST',
										  url: "/admsys/consultingmng/chdel_req_updDelYn.html",
										  data: {"updList":dataList},
										  traditional:true,
										  success: function(result){
											  if ( result.retStatus == "SUCCESS" ) {
												  alert("복원 하였습니다.");
												  location.reload();
												  //location.href = "<c:url value='/admsys/orgculturedigmng/allhisdel.html' />";
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
								$("#WOrgCultureDigMngVo").attr("action","/admsys/consultingmng/chdel.html");
								$("#WOrgCultureDigMngVo").submit();
							}

							function excelDownload(){
								var eForm = $("#WConsultingMngVo").serialize();
								
								$.ajax({
									  type: 'POST',
									  url: "/admsys/consultingmng/chdel_excel.html",
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
						 	            return '상담일지 삭제함.xlsx';
						 	        },
						 	        getSheetName : function(){
						 	            return '상담일지 삭제함';
						 	        },
						 	        getExcelData : function(data){
						 	        	var arr = new Array();
						 	        	
						            	for(var i=0; i< data.length; i++){
						            		arr[i] = {'상담번호':data[i].consulting_history_no
						            				,'의뢰인':data[i].client_name
						            				,'의뢰인소속':data[i].client_belong
						            				,'내용':data[i].consulting_req_type
						            				,'생성일':data[i].registration_date
						            				,'담당관':data[i].manager}                              
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
