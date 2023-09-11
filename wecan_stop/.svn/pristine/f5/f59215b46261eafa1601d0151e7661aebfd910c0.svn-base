<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />
            <div id="contents">
                <form:form modelAttribute="WBoardCounselVo" name="Wcsllfrm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/cyberCounsel/">HOME</a> <a href="/admsys/cyberCounsel/chatCounsel.html">사이버상담</a> <strong>게시판상담 관리 </strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="sitedatereg" <c:if test="${input.cond1=='sitedatereg'}"><c:out value='selected' /></c:if>>등록일</option>
                            </select>
                               <input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" style="width:128px;"/>
                                        ~
                                <input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" style="width:128px;"/>
                            <select style="height:27px;" name="cond2">
                                <option value="boardTitle" <c:if test="${input.cond2=='boardTitle'}"><c:out value='selected' /></c:if>>제목</option>
                                <option value="boardConts" <c:if test="${input.cond2=='boardConts'}"><c:out value='selected' /></c:if>>내용</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">게시판상담 목록</h3></li>
                            <li>
                                <div class="main_table">

	                            <div class="top_bt">
	                                <a class="btmore07" href="javascript:checkAll(true,'actionChkBx');">전체선택</a>
	                                <a class="btmore07" href="javascript:checkAll(false,'actionChkBx');">전체해제</a>
	                                <select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()" style="height:28px;">
	                                    <c:forTokens items="10,20,30,40,50" var="each" delims=",">
	                                        <option value="${each}" <c:if test="${input.pageSize==each}"><c:out value='selected'/></c:if>>${each}개 출력</option>
	                                    </c:forTokens>
	                                </select>
	                            </div>
                                
                                <!--게시판 영역-->
                                <table id="main_table" class="main_table1" summary="순번, 이름, 제목, 내용, 아이피, 조회수, 답변, 답변ID, 등록일시, 등록ID, 수정일시, 수정ID">
                                    <caption>게시판상담목록</caption>
                                    <colgroup>
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th onclick="event.cancelBubble=true"><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','actionChkBx')"/></th>
                                        <th onclick="event.cancelBubble=true">순번</th>
                                        <th onclick="event.cancelBubble=true">제목</th>
                                        <th onclick="event.cancelBubble=true">조회수</th>
                                        <th onclick="event.cancelBubble=true">등록일시</th>
                                        <th onclick="event.cancelBubble=true">등록ID</th>
                                        <th onclick="event.cancelBubble=true">변경일시</th>
                                        <th onclick="event.cancelBubble=true">변경ID</th>
                                        <th onclick="event.cancelBubble=true">답변여부</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td><input class="bor_none" name="actionChkBx" value="${each.boardNo}" type="checkbox" onclick="event.cancelBubble=true"/></td>
                                            <td><c:out value='${each.boardNo}'/></td>
                                            <td><c:out value='${each.boardTitle}'/></td>                                            
                                            <td><c:out value='${each.boardHit}'/></td>
                                            <td><c:out value='${each.regDate}'/></td>
                                            <td><c:out value='${each.regId}'/></td>
                                            <td><c:out value='${each.updDate}'/></td>
                                            <td><c:out value='${each.updId}'/></td>                                            
										       	<c:choose>
													<c:when test="${each.boardAnswer != null}"><td>답변완료</td></c:when>
													<c:when test="${each.boardAnswer == null}"><td>답변대기</td></c:when>						
												</c:choose>                                            
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
				                    	<a class="btmore05" href="javascript:alert('엑셀 다운로드');">엑셀 다운로드</a>
				                    	<a class="btmore05" href="javascript:alert('인쇄');">인쇄</a>
				                    	<a class="btmore01" href="javascript:deleteChecked();">삭제</a>				                    	
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
            
<jsp:include page="../end.jsp" flush="false" />

<script>
	 
    $("#main_table tr").click(function(){     
    	
        var str = ""
        var tdArr = new Array();
        var tr = $(this);
        var td = tr.children();
        
        td.each(function(i){
            tdArr.push(td.eq(i).text());
        });
        console.log("boardNo : "+tdArr[1]);
        $("#content").load("/admsys/cyberCounsel/boardCounsel_view.html", {'boardNo': tdArr[1]} );
        
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
			  url: "/admsys/cyberCounsel/boardCounsel_req_delete.html",
			  data: {"delList":dataList},
			  traditional:true,
			  success: function(result){
				  if ( result.retStatus == "SUCCESS" ) {
					  alert("삭제 하였습니다.");
					  location.href = "<c:url value='/admsys/cyberCounsel/boardCounsel.html' />";
				  } else {
					  alert("삭제에 실패 하였습니다.");
				  }
			  },
			  error:function(e){
				  alert("삭제중 오류가 발생하였습니다."+e.responseText  );
			  }
		});
	}

</script>
