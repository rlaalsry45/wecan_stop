<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />

            <div id="contents">
                <form:form modelAttribute="DownloadLogVo" name="frm" method="post">
                    <div class="contents_top" style="height:70px;">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>다운로드기록조회</strong>
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">다운로드기록조회 목록</h3></li>
                            <li>
                            	<!-- 컨텐츠 영역 -->
								<div class="counsel_wrap">
									<div class="search_box">
										<table>
											<caption>다운로드이력로그 조회</caption>
											<colgroup>
												<col style="width:150px;">
												<col style="width:345px;">
												<col style="width:150px;">
												<col style="width:auto;">
											</colgroup>
											<tbody>
												<tr>
													<th>기간</th>
													<td colspan="3">
														<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
														<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
														<div class="input_box">
															<input type="date" class="date" id="sdate" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="2020-01-01" max="2040-12-31" placeholder="년-월-일" style="width: 160px;">
														</div>
														&nbsp;&nbsp;~&nbsp;&nbsp;
														<div class="input_box">
															<input type="date" class="date" id="edate" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="2020-01-01" max="2040-12-31" placeholder="년-월-일" style="width: 160px;">
														</div>
													</td>
												</tr>
												<tr>
													<th>자료명</th>
													<td>
														<div class="input_box full_width">
															<input type="text" id="dataName" name="dataName" value="${input.dataName}">
														</div>
													</td>
													<th>사용자명</th>
													<td>
														<div class="input_box full_width">
															<input type="text" id="regName" name="regName" value="${input.regName}">
														</div>
													</td>
												</tr>
											</tbody>
										</table>
										<div class="btn_wrap align_right">
											<input class="btn" type="submit" value="조회" onclick="document.forms[0].action='?pageIndex=1'" />
										</div>
									</div>
									<div class="result_list">
										<div class="result_top_info">
											<span class="result_cnt">결과 : <c:out value='${input.total}'/>건</span>
											<select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()">
			                                    <c:forTokens items="10,15,20,30,40,50" var="each" delims=",">
			                                        <option value="${each}" <c:if test="${input.pageSize==each}"><c:out value='selected'/></c:if>>${each}개 출력</option>
			                                    </c:forTokens>
			                                </select>
										</div>
										<table class="align_center">
											<caption>다운로드이력로그조회 결과</caption>
											<colgroup>
												<col style="width:75px;">
												<col style="width:182px;">
												<col style="width:182px;">
												<col style="width:198px;">
												<col style="width:165px;">
												<col style="width:auto;">
											</colgroup>
											<thead>
												<tr>
													<th>연번</th>
													<th>일시</th>
													<th>자료명</th>
													<th>사유</th>
													<th>사용자명</th>
													<th>소속</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="each" varStatus="loop">
												<tr>
													<td><c:out value='${each.no}'/></td>
													<td name="dateTd"><c:out value='${each.regDt}'/></td>
													<td><c:out value='${each.dataName}'/></td> 
													<td><c:out value='${each.reason}'/></td>
													<td><c:out value='${each.regName}'/></td>
													<td>한국여성인권진흥원</td>
												</tr>
												</c:forEach>
												<c:if test="${input.total==0}">
		                                        <tr>
		                                            <td colspan="6">등록된 정보가 없습니다.</td>
		                                        </tr>
		                                    	</c:if>
											</tbody>
										</table>
										<div class="result_bottom_info">
											<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
											<div class="btn_wrap">
												<a href="javascript:excelDownload();" class="btn">엑셀 다운로드</a>
											</div>
										</div>
									</div>
								</div>
								<!-- //컨텐츠 영역 -->
                            </li>
                        </ul>         
                    </div>
                    <!--/content-->
                </form:form>              	                
            </div>
            <!--/contents-->
            
<jsp:include page="../end.jsp" flush="false" />

<script>
	
 	for(i=0;i<$("td[name=dateTd]").size();i++){
 		document.getElementsByName("dateTd")[i].innerText=$("td[name=dateTd]").get(i).textContent.replace('.0',"");
	}
 	
 	function excelDownload(){
		var eForm = $("#DownloadLogVo").serialize();
		
		$.ajax({
			  type: 'POST',
			  url: "/admsys/ftp/downloadLog_excel.html",
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
 	            return '다운로드이력로그조회.xlsx';
 	        },
 	        getSheetName : function(){
 	            return '다운로드이력로그조회';
 	        },
 	        getExcelData : function(data){
 	        	var arr = new Array();
 	        	
 	        	var i = 0, len = data.length; 
 	        	while (i < len) {
            		arr[i] = {'순번':data[i].no
            				,'일시':data[i].regDt
            				,'자료명':data[i].dataName
            				,'사유':data[i].reason
            				,'사용자명':data[i].regName
            				,'소속':'한국여성인권진흥원'}
            		
            		i++;
 	        	}
           		
 	           return arr;
 	        },
 	        getWorksheet : function(data){
 	            return XLSX.utils.json_to_sheet(this.getExcelData(data));
 	        }
 	}
 	
</script>
