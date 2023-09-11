<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />

            <div id="contents">
                <form:form modelAttribute="AccessLogVo" name="frm" method="post">
                    <div class="contents_top" style="height:70px;">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>수행업무기록 조회</strong>
                        </div>
                    </div>
                    <div id="content">
                    	<ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">수행업무기록 목록</h3></li>
                            <li>
		                    	<!-- 컨텐츠 영역 -->
								<div class="counsel_wrap">
									<div class="search_box">
										<table>
											<caption>접속기록조회</caption>
											<colgroup>
												<col style="width:150px;">
												<col style="width:345px;">
												<col style="width:150px;">
												<col style="width:auto;">
											</colgroup>
											<tbody>
												<tr>
													<th>일자</th>
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
													<th>사용자계정</th>
													<td>
														<div class="input_box full_width">
															<input type="text" id="regId" name="regId" value="${input.regId}">
														</div>
													</td>
													<th>수행업무</th>
													<td>
														<div class="input_box full_width">
															<select id="action" name="action">
																<option value="">선택</option>
																<option value="채팅상담 조회">채팅상담 조회</option>
																<option value="게시판상담 조회">게시판상담 조회</option>
																<option value="상담일지 조회">상담일지 조회</option>
																<option value="상담일지 등록">상담일지 등록</option>
																<option value="상담일지 수정">상담일지 수정</option>
																<option value="상담일지 삭제">상담일지 삭제</option>
																<option value="상담일지 삭제함 조회">상담일지 삭제함 조회</option>
																<option value="구)채팅상담 조회">구)채팅상담 조회</option>
																<option value="사용자 조회">사용자 조회</option>
																<option value="사용자 등록">사용자 등록</option>
																<option value="사용자 수정">사용자 수정</option>
																<option value="사용자 삭제">사용자 삭제</option>
															</select>
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
											<caption>접속기록조회 결과</caption>
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
													<th>번호</th>
													<th>사용자 계정</th>
													<th>IP 주소</th>
													<th>일자</th>
													<th>정보주체 정보</th>
													<th>수행업무</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="each" varStatus="loop">
												<tr>
													<td><c:out value='${each.no}'/></td>
													<td><c:out value='${each.regId}'/></td>
													<td><c:out value='${each.ip}'/></td>
													<td name="dateTd"><c:out value='${each.regDt}'/></td>
													<td><c:out value='${each.informationObject}'/></td>
													<td><c:out value='${each.action}'/></td>
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
	
	$(function(){
		var action = '${input.action}';
		$("#action").val(action).prop("selected", true);
	});

 	for(i=0;i<$("td[name=dateTd]").size();i++){
 		document.getElementsByName("dateTd")[i].innerText=$("td[name=dateTd]").get(i).textContent.replace('.0',"");
	}
 	
 	function excelDownload(){
		var eForm = $("#AccessLogVo").serialize();
		
		$.ajax({
			  type: 'POST',
			  url: "/admsys/ftp/accessLog_excel.html",
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
 	            return '접속기록조회.xlsx';
 	        },
 	        getSheetName : function(){
 	            return '접속기록조회';
 	        },
 	        getExcelData : function(data){
 	        	var arr = new Array();
 	        	
 	        	var i = 0, len = data.length; 
 	        	while (i < len) {
            		arr[i] = {'순번':data[i].no
            				,'사용자계정':data[i].regId
            				,'IP주소':data[i].ip
            				,'일자':data[i].regDt
            				,'정보주체 정보':data[i].informationObject
            				,'수행업무':data[i].action}
            		
            		i++;
 	        	}
           		
 	           return arr;
 	        },
 	        getWorksheet : function(data){
 	            return XLSX.utils.json_to_sheet(this.getExcelData(data));
 	        }
 	}
 	
</script>
