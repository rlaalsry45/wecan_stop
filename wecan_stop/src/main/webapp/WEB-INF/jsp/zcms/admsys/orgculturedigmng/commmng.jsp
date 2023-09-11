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
                <form:form modelAttribute="WCounselorVo" name="Wcslfrm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/index.html">진단관리</a> <strong>위원 관리 </strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="sitedatereg" <c:if test="${input.cond1=='sitedatereg'}"><c:out value='selected' /></c:if>>등록일</option>
                                <option value="sitedatemod" <c:if test="${input.cond1=='sitedatemod'}"><c:out value='selected' /></c:if>>수정일</option>
                            </select>
							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
                            <select style="height:27px;" name="cond2">
                                <option value="counselName" <c:if test="${input.cond2=='counselName'}"><c:out value='selected' /></c:if>>위원성명</option>
                                <option value="org" <c:if test="${input.cond2=='org'}"><c:out value='selected' /></c:if>>소속기관</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">위원 관리 목록</h3></li>
                            <li>
                                <div class="main_table">

	                            <div class="top_bt">
	                                <a class="btmore07" href="javascript:checkAll(true,'actionChkBx');">전체선택</a>
	                                <a class="btmore07" href="javascript:checkAll(false,'actionChkBx');">전체해제</a>
	                                <span id="totalCountText">검색결과 총 ${input.total}건이 조회(검색)되었습니다.</span>
	                            </div>
                                
                                <!--게시판 영역-->
                                <table id="main_table" class="main_table1" summary="번호, 위원성명, 소속기관, 활동지역, 최초활동일, 활동여부, 연락처, 등록(수정)자, 등록(수정)일">
                                    <caption>위원리스트</caption>
                                    <colgroup>
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th onclick="event.cancelBubble=true"><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','actionChkBx')"/></th>
                                        <th onclick="event.cancelBubble=true">번호</th>
                                        <th onclick="event.cancelBubble=true">위원 성명</th>
                                        <th onclick="event.cancelBubble=true">소속기관</th>
                                        <th onclick="event.cancelBubble=true">활동지역</th>
                                        <th onclick="event.cancelBubble=true">최초활동일</th>
                                        <th onclick="event.cancelBubble=true">활동여부</th>
                                        <th onclick="event.cancelBubble=true">연락처</th>
                                        <th onclick="event.cancelBubble=true">등록(수정)자</th>
                                        <th onclick="event.cancelBubble=true">등록(수정)일</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr style="cursor:pointer;">
                                            <td><input class="bor_none" name="actionChkBx" value="${each.counselNum}" type="checkbox" onclick="event.cancelBubble=true"/></td>
                                            <td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
                                            <td><c:out value='${each.counselName}'/></td>                                            
                                            <td><c:out value='${each.org}'/></td>
                                            <td><c:out value='${each.region}'/></td>
                                            <td><c:out value='${each.startDt}'/></td>
                                            <td><c:out value='${each.actYn}'/></td>
                                            <td><c:out value='${each.phoneNum}'/></td>
                                            <td><c:out value='${each.regUser}'/></td>
                                            <td><c:out value='${each.regDt}'/></td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${input.total==0}">
                                        <tr>
                                            <td colspan="14" style="padding: 20px;">등록된 정보가 없습니다.</td>
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
												<a id="commmng_action_registration" class="btmore01" href="javascript:void(0);">등록</a>
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

	$("#commmng_action_registration").click(function(){
		$("#content").load("/admsys/orgculturedigmng/commmng_registration_form.html");
	});
	 
    $("#main_table tr").click(function(){     
    	
        var str = ""
        var tdArr = new Array();
        var tr = $(this);
        var td = tr.children();
        var val = $(this).find("input").val();
        td.each(function(i){
            tdArr.push(td.eq(i).text());
        });
        $("#content").load("/admsys/orgculturedigmng/commmng_view.html", {'counselNum': val} );        
    });
	
	function deleteChecked(){
		var dataList = new Array();
	
		var chk_val = $(':checkbox[name=actionChkBx]:checked').map(function () {
			var obj = new Object();
			obj = parseInt($(this).val());
			dataList.push(obj);
		});
	
		$.ajax({
			  type: 'POST',
			  url: "/admsys/orgculturedigmng/commmng_req_delete.html",
			  data: {"delList":dataList},
			  traditional:true,
			  success: function(result){
				  if ( result.retStatus == "SUCCESS" ) {
					  alert("삭제 하였습니다.");
					  location.href = "<c:url value='/admsys/orgculturedigmng/commmng.html' />";
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
		var eForm = $("#WCounselorVo").serialize();
		
		$.ajax({
			  type: 'POST',
			  url: "/admsys/orgculturedigmng/commmng_excel.html",
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
 	            return '위원 관리.xlsx';
 	        },
 	        getSheetName : function(){
 	            return '위원 관리';
 	        },
 	        getExcelData : function(data){
 	        	var arr = new Array();
 	        	var no = data.length;
 	        	
            	for(var i=0; i< data.length; i++){
            		arr[i] = {'연번': no
            				,'위원명':data[i].counselName
            				,'소속기관':data[i].org
            				,'활동지역':data[i].region
            				,'최초활동일':data[i].startDt
            				,'활동여부':data[i].actYn
            				,'연락처':data[i].phoneNum
            				,'등록자':data[i].regUser
            				,'등록일':data[i].regDt} 
            		
            		no--;
            	}
            	
 	           return arr;
 	        },
 	        getWorksheet : function(data){
 	            return XLSX.utils.json_to_sheet(this.getExcelData(data));
 	        }
 	}
</script>
