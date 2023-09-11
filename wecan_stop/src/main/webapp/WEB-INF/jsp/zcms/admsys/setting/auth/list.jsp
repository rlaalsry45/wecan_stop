<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <script type="text/javascript">
            $(function(){
                $('.main_table1 tbody img').bind("click",function(){
                    var attr = $(this).attr("id");
                    if (typeof attr !== 'undefined' && attr !== false){
                        if ($(this).attr("src").indexOf("closed")!=-1){
                            $(this).attr("src","/cms/image/btn_opened.jpg");
                            $(this).attr("alt","열림");
                            $(this).closest("tr").siblings("#"+$(this).attr("id")).show();
                        }
                        else{
                            $(this).attr("src","/cms/image/btn_closed.jpg");
                            $(this).attr("alt","닫힘");
                            if ($(this).attr("id").match(/^\d+/)=="1"){
                                var id = $(this).attr("id").match(/\d+$/);
                                $(this).closest("tr").siblings("tr[id$='_"+id+"']").hide();
                                $(this).closest("tr").siblings("tr[id$='_"+id+"']").find("img[id$='"+id+"']").attr("src","/cms/image/btn_closed.jpg");
                            }
                            else{
                                $(this).closest("tr").siblings("#"+$(this).attr("id")).hide();
                            }
                        }
                    }
                });
                $('.main_table1 thead img').bind("click",function(){
                    if ($(this).attr("src").indexOf("open")!=-1){
                        $(".main_table1 tbody img[id]").attr("src","/cms/image/btn_opened.jpg");
                        $('.main_table1 tbody tr').show();
                    }
                    else{
                        $(".main_table1 tbody img[id]").attr("src","/cms/image/btn_closed.jpg");
                        $(".main_table1 tbody tr:not([id^='0'])").hide();
                    }
                });
            });

            function getDept(){
                if ($("#hq_cd").val==""){
                    alert("부서를 선택해 주십시오.");
                    return;
                }
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "/admsys/setting/auth/getDept.html",
                    data: {hq_cd:$("#hq_cd").val()},
                    beforeSend: function() {
                        $("#dept_cd").empty();
                        $("#dept_cd").append("<option v=''>선택</option>");
                    },
                    success: function(item) {
                        for (var idx = 0; idx < item.deptlist.length; idx++) {
                            var dept_cd = item.deptlist[idx]['dept_cd'];
                            var dept_nm = item.deptlist[idx]['dept_nm'];
                            $("#dept_cd").append("<option value='" + dept_cd + "'>"+ dept_nm + "</option>");
                        }
                    },
                    error:function(xhr, ajaxOpts, thrownErr) {
                        alert(_errorMsg+" [" + xhr.status + " " + thrownErr + "]");
                    }
                });
            }

            function add_admin(userid) {
                url = "/admsys/setting/auth/regadmin_pop.html?userid="+userid;
                //window.open(url, "result1122", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=450, height=400");
                PopupCenter(url, "result1122", "450", "400");
            }
            
            function loginUnblock(userid) {
            	
            	$.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "/admsys/setting/auth/loginUnblock.html",
                    data: {userid:userid},
                    success: function(data) {
                    	if(data.result == "success"){
                    		alert("차단해제되었습니다.");
                    	}
                    },
                    error:function(xhr, ajaxOpts, thrownErr) {
                        alert(_errorMsg+" [" + xhr.status + " " + thrownErr + "]");
                    }
                });
            }
            </script>
            <div id="contents">
                <form:form modelAttribute="gAuthEmp" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/setting/auth/list.html">사용자 관리</a> <strong>(업무) 사용자 관리</strong>
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg">
                                <h3 class="setting">사용자 목록</h3>
                                <div class="user_btn">
                                    <a href="#none" onclick="add_admin('')">
                                        <input class="chost_btn_s4" type="button" value="사용자등록" />
                                    </a>
                                </div>
                            </li>
                            <li style="padding-left: 10px; padding-top: 2px;">
	                            <table style="width:100%">
									<tr>
										<td>사용자명</td>
										<td><input type="text" id="emp_nm" name="emp_nm" value="${data.emp_nm}"></td>
										<td>아이디</td>
										<td><input type="text" id="emp_id" name="emp_id" value="${data.emp_id}"></td>
										<td>권한그룹</td>
										<td>
											<select id="GROUPNO" name="GROUPNO">
												<option value="">선택</option>
												<option value="1" <c:if test="${data.GROUPNO eq 1}">selected</c:if>>관리자</option>
												<option value="2" <c:if test="${data.GROUPNO eq 2}">selected</c:if>>담당관</option>
												<option value="3" <c:if test="${data.GROUPNO eq 3}">selected</c:if>>팀장</option>
												<option value="4" <c:if test="${data.GROUPNO eq 4}">selected</c:if>>본부장</option>
											</select>
										</td>
										<td>생성일</td>
										<td>				
											<fmt:parseDate value="${data.USERDATEREGFrom}" pattern="yyyy-MM-dd" var="acdt" />
											<fmt:parseDate value="${data.USERDATEREGTo}" pattern="yyyy-MM-dd" var="rcdt" />
											시작일 <input type="date" id="USERDATEREGFrom" name="USERDATEREGFrom" value="<fmt:formatDate type="both" value="${acdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
											종료일 <input type="date" id="USERDATEREGTo" name="USERDATEREGTo" value="<fmt:formatDate type="both" value="${rcdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
										</td>
	
									</tr>
									<tr>
									<td colspan="10" style="text-align: right; padding-right: 10px;">
									<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'"/>
									</td>
									</tr>
								</table>
                            </li>
                            <li>
                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1" border="1" cellspacing="0" cellpadding="0" width="100%" summary="메뉴전체보기">
                                        <caption>메뉴전체보기</caption>
                                        <colgroup>
                                        	<col width="15%" />
                                            <col width="15%" />
                                            <col width="10%" />
                                            <col width="10%" />
                                            <col width="15%" />
                                            <col width="15%" />
                                            <col width="20%" />
                                        </colgroup>
                                        <thead>
                                            <tr>                                            	
                                                <th>사용자명</th>
                                                <th>아이디</th>
                                                <th>권한그룹</th>
                                                <th>사용여부</th>
                                        		<th>계정 생성일</th>
                                        		<th>최종접속일</th>
                                                <th>관리</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="each">
                                                <tr>
                                                    <td>${each.emp_nm}</td>
                                                    <td>${each.emp_id}</td>
                                                    <td>${each.GROUPNM}</td>
                                                    <td>
                                                    	<c:if test="${each.useyn eq 'Y'}">사용</c:if>
														<c:if test="${each.useyn eq 'N'}">미사용</c:if>
													</td>
                                                    <td name="dateTd">${each.userdatereg}</td>
                                                    <td name="dateTd">${each.latestconnectiondate}</td>
                                                    <td>
                                                    	<c:if test="${each.emp_id ne 'admin' && each.emp_id ne 'adminTest' && each.emp_id ne 'aseanrok'}">
                                                    	<a class="btmore04" href="#none" onclick="loginUnblock('${each.emp_id}')">차단해제</a>
                                                        <a class="btmore04" href="#none" onclick="add_admin('${each.emp_id}')">수정/상세</a>
                                                       	<a class="btmore05" href="/admsys/setting/auth/delete.html?userno=${each.emp_no }" onclick="javascript:if(!confirm('삭제하시겠습니까?')){return false;}">삭제</a>
                                                        </c:if>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${empty list}">
                                                <tr><td colspan="6" style="padding:20">기록이 없습니다.</td></tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                                    <!---/게시판 영역-->
                                    <div class="top_bt">
                                    	<a class="btmore05" href="javascript:excelDownload();">엑셀다운로드</a>
                                		<a class="btmore05" href="javascript:window.print();">인쇄</a>
                                	</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        <script>
                        function excelDownload(){
							var eForm = $("#gAuthEmp").serialize();
							
							$.ajax({
								  type: 'POST',
								  url: "/admsys/setting/auth/list_excel.html",
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
                     	            return '사용자 목록.xlsx';
                     	        },
                     	        getSheetName : function(){
                     	            return '사용자 목록';
                     	        },
                     	        getExcelData : function(data){
                     	        	var arr = new Array();
                     	        	
                                	for(var i=0; i< data.length; i++){   
                                		arr[i] = {'사용자명':data[i].emp_nm
                                				,'아이디':data[i].emp_id
                                				,'권한그룹':data[i].groupnm
                                				,'사용여부':data[i].useyn
                                				,'계정 생성일':data[i].userdatereg
                                				,'최종접속일':data[i].latestconnectiondate}  
                                	}
                               		
                     	           return arr;
                     	        },
                     	        getWorksheet : function(data){
                     	            return XLSX.utils.json_to_sheet(this.getExcelData(data));
                     	        }
                     	}
                        
                        for(i=0;i<$("td[name=dateTd]").size();i++){
                     		document.getElementsByName("dateTd")[i].innerText=$("td[name=dateTd]").get(i).textContent.replace('.0',"");
                    	}
                        </script>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../../end.jsp" flush="true" />
