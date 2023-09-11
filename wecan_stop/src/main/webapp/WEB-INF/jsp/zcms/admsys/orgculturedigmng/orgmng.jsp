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
                <form:form modelAttribute="WOrganizationVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/index.html">진단관리</a> <strong>기관 관리 </strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="reg_date" <c:if test="${input.cond1=='regDate'}"><c:out value='selected' /></c:if>>등록일</option>
                            </select>
							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
                            <select style="height:27px;" name="cond2">
                                <option value="organization_id" <c:if test="${input.cond2=='organization_id'}"><c:out value='selected' /></c:if>>기관ID</option>
                                <option value="organization_name" <c:if test="${input.cond2=='organization_name'}"><c:out value='selected' /></c:if>>기관명</option>
                                <option value="organization_chargename" <c:if test="${input.cond2=='organization_chargename'}"><c:out value='selected' /></c:if>>담당자명</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="search();" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">기관 관리 목록</h3></li>
                            <li>
                            <div class="top_bt">
                                <a class="btmore07" href="javascript:checkAll(true,'actionChkBx');">전체선택</a>
                                <a class="btmore07" href="javascript:checkAll(false,'actionChkBx');">전체해제</a>
                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
                            </div>

                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1" summary="번호, ID, 기관명, 담당자명, 이메일, 휴대폰번호, 사용여부, 등록일">
                                        <caption>관리목록</caption>
                                        <colgroup>
                                            <col width="5px" />
                                            <col width="5%" />
                                            <col />
                                            <col width="11%" />
                                            <col width="13%" />
                                            <col width="13%" />
                                            <col width="11%" />
                                            <col width="7%" />
                                            <col width="15%" />
                                            <col width="15%" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','actionChkBx')" />
                                                </th>
                                                <th>번호</th>
                                                <th>ID</th>
                                                <th>기관명</th>
                                                <th>담당자명</th>
                                                <th>이메일</th>
                                                <th>휴대폰번호</th>
                                                <th>사용여부</th>
                                                <th>등록일</th>
                                                <th>수정일</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="each" varStatus="loop">
                                            	<c:set var="no" value="${input.total-(input.pageIndex-1)*input.pageSize-loop.index}" />
                                                <tr>
                                                    <td>
                                                        <input type="checkbox" name="actionChkBx" class="bor_none" value="${each.organizationId}/${each.useYn}" />
                                                    </td>
                                                    <td>${no}</td>
                                                    <td><a href="javascript:viewDetailPage('${each.organizationId}','${each.userid}');">${each.organizationId}</a></td>
                                                    <td>${each.organizationName}</td>
                                                    <td>${each.username}</td>
                                                    <td>${each.useremail}</td>
                                                    <td><c:set var="telnum" value="${each.usermobile}" />
                                                    <c:choose>
                                                    <c:when test="${fn:length(telnum) eq 11}">${fn:substring(telnum,0,3)}-${fn:substring(telnum,3,7)}-${fn:substring(telnum,7,11)}</c:when>
                                                    <c:when test="${fn:length(telnum) eq 10}">${fn:substring(telnum,0,3)}-${fn:substring(telnum,3,6)}-${fn:substring(telnum,6,10)}</c:when>
                                                    </c:choose>
                                                    </td>
                                                    <td>${each.useYn}</td>
                                                    <td>${each.regDate}</td>
                                                    <td>${each.updDate}</td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <td colspan="10" style="padding:20;">등록된 정보가 없습니다.</td>
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
									<c:forEach items="${perm}" var="p" varStatus="ini">
										<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_3' and p.ALLOW_YN eq 'Y' }">
											<a class="btmore05" href="javascript:window.print();">인쇄</a>
										</c:if>
									</c:forEach>
									<c:forEach items="${perm}" var="p" varStatus="ini">
										<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
											<a class="btmore01" href="javascript:updUse();">사용/미사용처리</a>
										</c:if>
									</c:forEach>
									<c:forEach items="${perm}" var="p" varStatus="ini">
										<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
											<a id="organization_action_registration" class="btmore01" href="javascript:void(0);">등록</a>
										</c:if>
									</c:forEach>
                            	</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        <script type="text/javascript">
							$("#organization_action_registration").click(function(){
								$("#content").load("/admsys/orgculturedigmng/orgmng_registration_form.html");
							});
							
							function search(){
								$("#WOrganizationVo").attr("action","/admsys/orgculturedigmng/orgmng.html");
								$("#WOrganizationVo").submit();
							}
				
							function updUse(){
								if($(':checkbox[name=actionChkBx]:checked').length == 0){
									alert("기관관리 목록을 한개이상 체크하세요.");
									return;
								}
				
								var dataList = new Array();
								var chk_val = $(':checkbox[name=actionChkBx]:checked').map(function () {
									var obj = new Object();
									obj = $(this).val();
									dataList.push(obj);
								});
				
								$.ajax({
									  type: 'POST',
									  url: "/admsys/orgculturedigmng/orgmng_req_updUse.html",
									  data: {"updList":dataList},
									  traditional:true,
									  success: function(result){
										  if ( result.retStatus == "SUCCESS" ) {
											  alert("사용/미사용 처리 하였습니다.");
											  location.href = "<c:url value='/admsys/orgculturedigmng/orgmng.html' />";
										  } else {
											  alert("사용/미사용 처리에 실패 하였습니다.");
										  }
									  },
									  error:function(e){
										  alert("사용/미사용 처리중 오류가 발생하였습니다."+e.responseText  );
									  }
								});
							}
							
							function excelDownload(){
								var eForm = $("#WOrganizationVo").serialize();
								
								$.ajax({
									  type: 'POST',
									  url: "/admsys/orgculturedigmng/orgmng_excel.html",
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
	                     	            return '기관 관리.xlsx';
	                     	        },
	                     	        getSheetName : function(){
	                     	            return '기관 관리';
	                     	        },
	                     	        getExcelData : function(data){
	                     	        	var arr = new Array();
	                     	        	
	                                	for(var i=0; i< data.length; i++){
	                                		arr[i] = {'기관유형':data[i].organizationId
	                                				,'기관명':data[i].organizationName
	                                				,'기관담당자':data[i].username
	                                				,'이메일':data[i].useremail
	                                				,'연락처':data[i].usermobile
	                                				,'사용여부':data[i].useYn
	                                				,'등록일':data[i].regDate
	                                				,'수정일':data[i].updDate}                              
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
            
            <script type="text/javascript">
			function viewDetailPage(organizationId, userid){
				$("#content").load("/admsys/orgculturedigmng/orgmng_view.html", {'organizationId':organizationId,'userid':userid} );  
			}			
			</script>
<jsp:include page="../end.jsp" flush="false" />
