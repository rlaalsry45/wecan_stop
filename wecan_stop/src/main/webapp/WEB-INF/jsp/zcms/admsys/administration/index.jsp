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
                <form:form modelAttribute="PressVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a><strong>언론모니터링 </strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="sitedatereg" <c:if test="${input.cond1=='sitedatereg'}"><c:out value='selected' /></c:if>>등록일</option>
                            </select>
							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
                            <select style="height:27px;" name="cond2">
                                <option value="article_title" <c:if test="${input.cond2=='article_title'}"><c:out value='selected' /></c:if>>기사명</option>
                                <option value="create_userName" <c:if test="${input.cond2=='create_userName'}"><c:out value='selected' /></c:if>>등록자명</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="search();" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                        <li class="bg"><h3 class="sub">언론 모니터링</h3></li>
                            <li>
                            <div class="top_bt">
                                <a class="btmore07" href="javascript:checkAll(true,'pressChkBx');">전체선택</a>
                                <a class="btmore07" href="javascript:checkAll(false,'pressChkBx');">전체해제</a>
                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
                            </div>

                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
                                        <caption>관리목록</caption>
                                        <colgroup>
                                            <col width="5px" />
                                            <col width="10px" />
                                            <col width="40%" />
                                            <col width="20%" />
                                            <col width="20%" />
                                            <col width="7%" />
                                            <col width="7%" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','pressChkBx')" />
                                                </th>
                                                <th>번호</th>
                                                <th>기사명</th>
                                                <th>연관 상담 번호</th>
                                                <th>연관 조치 번호</th>
                                                <th>등록자명</th>
                                                <th>등록일</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="each" varStatus="loop">
                                                <tr>
                                                    <td>
                                                        <input class="bor_none" name="pressChkBx" value="${each.NO}" type="checkbox" />
                                                    </td>
                                                    <td>
                                                        <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                                                    </td>
                                                    <td>
                                                    	<a href="javascript:viewDetailPage('${each.NO}');">${each.article_title}</a><a class="btmore01" href="${each.rel_event_url}" target="_blank">View</a>
                                                    </td>
                                                    <td>
                                                       <c:forEach items="${each.conRelList}" var="c" varStatus="cl">
                                                      		${c.consulting_action_no}<c:if test="${!cl.last}">,&nbsp;</c:if>
                                                       </c:forEach>
                                                    </td>
                                                    <td>
                                                       <c:forEach items="${each.acRelList}" var="a" varStatus="al">
                                                       ${a.consulting_action_no}<c:if test="${!al.last}">,&nbsp;</c:if>
                                                       </c:forEach>
                                                    </td>
                                                    <td>
                                                        ${each.create_userName}
                                                    </td>
                                                    <td>
	                                                    <fmt:parseDate value="${each.create_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
														<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm" />
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="7" style="padding:20;">언론모니터링 정보가 없습니다.</td>
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
										<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_3' and p.ALLOW_YN eq 'Y' }">
											<a class="btmore01" href="javascript:deleteChecked();">삭제</a>
										</c:if>
									</c:forEach>
                                	<c:forEach items="${perm}" var="p" varStatus="ini">
										<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
											<a id="press_registration" class="btmore01" href="javascript:void(0);">등록</a>
                                		</c:if>
									</c:forEach>
                            	</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        <script>
						$("#press_registration").click(function(){
							$("#content").load("/admsys/administration/press_registration_form.html");
						});
						
						function deleteChecked(){
							var dataList = new Array();

							var chk_val = $(':checkbox[name=pressChkBx]:checked').map(function () {
								var obj = new Object();
								obj = parseInt($(this).val());
								dataList.push(obj);
							});

							$.ajax({
								  type: 'POST',
								  url: "/admsys/administration/press_req_delete.html",
								  data: {"delList":dataList},
								  traditional:true,
								  success: function(result){
									  if ( result.retStatus == "SUCCESS" ) {
										  alert("삭제 하였습니다.");
										  location.href = "<c:url value='/admsys/administration/index.html' />";
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
							var eForm = $("#PressVo").serialize();
							
							$.ajax({
								  type: 'POST',
								  url: "/admsys/administration/index_excel.html",
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
                     	            return '언론모니터링.xlsx';
                     	        },
                     	        getSheetName : function(){
                     	            return '언론모니터링';
                     	        },
                     	        getExcelData : function(data){
                     	        	var arr = new Array();
                     	        	
                                	for(var i=0; i< data.length; i++){
                                		
                                		var conRel_consulting_action_no = '';
                                		var acRel_consulting_action_no = '';
                                		for(var j=0; j< data[i].conRelList.length; j++){
                                			conRel_consulting_action_no = conRel_consulting_action_no + data[i].conRelList[j].consulting_action_no +',';
                                		}
                                		for(var k=0; k< data[i].acRelList.length; k++){
                                			acRel_consulting_action_no = acRel_consulting_action_no + data[i].acRelList[k].consulting_action_no +',';
                                		}
                                		
                                		arr[i] = {'연번':data[i].NO
                                				,'기사명':data[i].article_title
                                				,'기사링크':data[i].rel_event_url
                                				,'연관 상담번호':conRel_consulting_action_no
                                				,'연관 진단번호':acRel_consulting_action_no
                                				,'등록자명':data[i].create_user
                                				,'등록일':data[i].create_date}  
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
			function viewDetailPage(NO){
				$("#content").load("/admsys/administration/press_view.html", {'NO':NO} );  
			}			
			</script>
<jsp:include page="../end.jsp" flush="false" />
