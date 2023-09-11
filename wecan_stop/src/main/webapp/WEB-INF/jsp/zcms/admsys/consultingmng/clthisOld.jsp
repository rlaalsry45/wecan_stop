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
                <form:form modelAttribute="WClthisOldVo" name="frm" method="post">
                    <div class="contents_top" style="height:70px;">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/consultingmng/allcmsrch.html">상담관리</a> <strong>구)신고서기록</strong>
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
                                <option value="wr_subject" <c:if test="${input.cond2=='wr_subject'}"><c:out value='selected' /></c:if>>제목</option>
                                <option value="wr_name" <c:if test="${input.cond2=='wr_name'}"><c:out value='selected' /></c:if>>작성자</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>                        
                            <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
                        </div>
                    </div>
                    <div id="content" style="height:700px;overflow:auto;">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">구)신고서기록 목록</h3></li>
                            <li>
                                <div class="main_table">

		                            <div class="top_bt">
		                                <a class="btmore07" href="javascript:checkAll(true,'actionChkBx');">전체선택</a>
		                                <a class="btmore07" href="javascript:checkAll(false,'actionChkBx');">전체해제</a>
		                                <select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()" style="height:28px;">
		                                    <c:forTokens items="10,15,20,30,40,50" var="each" delims=",">
		                                        <option value="${each}" <c:if test="${input.pageSize==each}"><c:out value='selected'/></c:if>>${each}개 출력</option>
		                                    </c:forTokens>
		                                </select>
		                            </div>
	                                
	                                <!--게시판 영역-->
	                                <table id="main_table" class="main_table1" summary="순번, 상담구분, 상담구분번호, 성별, 국적, 관계, 나이, 지역, 유형, 상담내용, 등록일시, 등록ID, 변경일시, 변경ID">
	                                    <caption>구)신고서기록 목록</caption>
	                                    <colgroup>
	                                    </colgroup>
	                                    <thead>
	                                    <tr>
	                                        <th onclick="event.cancelBubble=true"><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','actionChkBx')"/></th>
	                                        <th onclick="event.cancelBubble=true">순번</th>
	                                        <th onclick="event.cancelBubble=true">제목</th>
	                                        <th onclick="event.cancelBubble=true">작성자</th>                                        
	                                        <th onclick="event.cancelBubble=true">등록일</th>
	                                        <th onclick="event.cancelBubble=true">수정일</th>
	                                    </tr>
	                                    </thead>
	                                    <tbody>
	                                    <c:forEach items="${list}" var="each" varStatus="loop">
	                                        <tr onclick="detail('${each.wr_id}');">
	                                            <td><input class="bor_none" name="actionChkBx" value="${each.wr_id}" type="checkbox" onclick="event.cancelBubble=true"/></td>
	                                            <td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
	                                            <td><c:out value='${each.wr_subject}'/></td>                                             
	                                            <td><c:out value='${each.wr_name}'/></td>
	                                            <td name="dateTd"><c:out value='${each.wr_datetime}'/></td>
	                                            <td name="dateTd"><c:out value='${each.wr_last}'/></td>                                       
	                                        </tr>
	                                    </c:forEach>
	                                    <c:if test="${input.total==0}">
	                                        <tr>
	                                            <td colspan="6" style="padding: 20px;">등록된 정보가 없습니다.</td>
	                                        </tr>
	                                    </c:if>
	                                    </tbody>
	                                </table>
                                
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                                    <!--/게시판 영역-->
                                    
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
				                	</div>                                    
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul> 
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

<script>
	
	$(document).ready(function() {
		
	});

 	for(i=0;i<$("td[name=dateTd]").size();i++){
 		document.getElementsByName("dateTd")[i].innerText=$("td[name=dateTd]").get(i).textContent.replace('.0',"");
	}
 	
 	function detail(wr_id){
 	   $("#content").load("/admsys/consultingmng/clthisOld_view.html", {'wr_id': wr_id} );
 	}
 	
 	function excelDownload(){
		var eForm = $("#WClthisOldVo").serialize();
		
		$.ajax({
			  type: 'POST',
			  url: "/admsys/consultingmng/clthisOld_excel.html",
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
 	            return '구)신고서기록.xlsx';
 	        },
 	        getSheetName : function(){
 	            return '구)신고서기록';
 	        },
 	        getExcelData : function(data){
 	        	var arr = new Array();
 	        	
 	        	var i = 0, len = data.length; 
 	        	while (i < len) {
 	        		var no = len;
            		arr[i] = {'순번':no
            				,'제목':data[i].wr_subject
            				,'작성자':data[i].wr_name
            				,'등록일':data[i].wr_datetime
            				,'수정일':data[i].wr_last}
            		no--;
            		i++;
 	        	}
           		
 	           return arr;
 	        },
 	        getWorksheet : function(data){
 	            return XLSX.utils.json_to_sheet(this.getExcelData(data));
 	        }
 	}
 	
</script>
