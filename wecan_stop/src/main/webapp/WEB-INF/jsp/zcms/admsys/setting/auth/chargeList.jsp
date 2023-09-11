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
                <form:form modelAttribute="ZUserVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/setting/auth/list.html">사용자 관리</a> <strong>(대민) 기관 담당자 관리</strong>
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg">
                                <h3 class="setting">담당자 목록</h3>
                                <div class="user_btn">
<!--                                     <a href="#none" onclick="add_admin('')"> -->
<!--                                         <input class="chost_btn_s4" type="button" value="사용자등록" /> -->
<!--                                     </a> -->
                                </div>
                            </li>
                            <li style="padding-left: 10px; padding-top: 2px;">
	                            <table style="width:100%">
									<tr>
										<td>사용자명</td>
										<td><input type="text" id="username" name="username" value="${input.username}"></td>
										<td>아이디</td>
										<td><input type="text" id="userid" name="userid" value="${input.userid}"></td>
										<td>생성일</td>
										<td>				
											<fmt:parseDate value="${input.userdateregfrom}" pattern="yyyy-MM-dd" var="acdt" />
											<fmt:parseDate value="${input.userdateregto}" pattern="yyyy-MM-dd" var="rcdt" />
											시작일 <input type="date" id="userdateregfrom" name="userdateregfrom" value="<fmt:formatDate type="both" value="${acdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
											종료일 <input type="date" id="userdateregto" name="userdateregto" value="<fmt:formatDate type="both" value="${rcdt}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
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
                                        	<col width="20%" />
                                            <col width="20%" />
                                            <col width="15%" />
                                            <col width="10%" />
                                            <col width="20%" />
                                        </colgroup>
                                        <thead>
                                            <tr>                                            	
                                                <th>사용자명</th>
                                                <th>아이디</th>
                                                <th>권한그룹</th>
                                                <th>생성일</th>
                                                <th>관리</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="each">
                                                <tr>
                                                    <td>${each.username}</td>
                                                    <td>${each.userid}</td>
                                                    <td>담당자</td>
                                                    <td>${each.userdatereg}</td>
                                                    <td>
                                                    	<c:if test="${each.userid ne 'admin' && each.userid ne 'aseanrok'}">
                                                    	<a class="btmore04" href="#none" onclick="loginUnblock('${each.userid}')">차단해제</a>
                                                        <a class="btmore04" href="#none" onclick="add_admin('${each.userid}')">수정/상세</a>
                                                       	<a class="btmore05" href="/admsys/setting/auth/delete.html?userno=${each.userno }" onclick="javascript:if(!confirm('삭제하시겠습니까?')){return false;}">삭제</a>
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
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../../end.jsp" flush="true" />
