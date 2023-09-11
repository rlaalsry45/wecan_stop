<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
<script type="text/javascript">
$(function(){
    $(":button").click(function(){
        if ($(this).parent().get(0).tagName=="DIV"){
            if ($(this).index()==0){
                window.open("createGroup.html", "popupCreateGroup", "directories=no,toolbar=no,width=460,height=180");
            }
            else {
                <c:if test="${empty list}">
                    alert("그룹 등록 후 사용자 추가 해주세요.");
                    return;
                </c:if>
                <c:if test="${not empty list}">
                    if ($(":checkbox[name=groupno]:checked").length==0){
                        alert("사용자를 추가 할 그룹을 선택 해주세요.");
                        return;
                    }
                    else {
                        var groupnos = $(":checkbox[name=groupno]:checked").map(function(){return $(this).val();}).get();
                        window.open("../gauth/searchEmp.html?groupnos="+groupnos, "popupFindEmp", "directories=no,toolbar=no,width=950,height=700");
                    }
                </c:if>
            }
        }
        else {
            if (confirm("선택하신 사용자를 그룹에서 삭제하시겠습니까?")){
                var keynos = $(this).closest("tr").attr("nos");
                var arr = keynos.split("^");
                document.frm.action = "authDelete.html?groupno="+arr[0]+"&auth_no="+arr[1];
                document.frm.submit();
            }
        }
    });
})
</script>
            <div id="contents">
					<form:form modelAttribute="gAuthVo" name="frm" method="post">
					<div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/setting/admin/">환경설정</a> <strong>그룹설정</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="groupnm" <c:if test="${input.cond1=='groupnm'}"><c:out value='selected' /></c:if>>그룹명</option>
                                <option value="emp_nm" <c:if test="${input.cond1=='emp_nm'}"><c:out value='selected' /></c:if>>사용자명</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="this.form.action='?pageIndex=1'" />
                        </div>
                    </div>


                    <div id="content">
					<ul class="homepagebbs">
						<li class="bg"><h3 class="setting">그룹관리</h3>
							<div class="user_btn"><input class="chost_btn_s4" type="button" value="그룹등록" /> <input class="chost_btn_s4" type="button" value="사용자등록" /></div>
						</li>
						<li>
						<div class="top_bt">
                                <a class="btmore07" href="javascript:checkAll(true,'groupno');">전체선택</a>
                                <a class="btmore07" href="javascript:checkAll(false,'groupno');">전체해제</a>
                                <a class="btmore05" href="javascript:del('groupno');">삭제</a>
						</div>
                        <div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="그룹목록">
                                <caption>그룹목록</caption>
                                <colgroup>
                                    <col width="5%" />
                                    <col width="25%" />
                                    <col width="30%" />
                                    <col />
                                    <col width="100" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','groupno')" />
                                        </th>
                                        <th>그룹명</th>
                                        <th>사용자명</th>
                                        <th>ID</th>
                                        <th>관리</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <c:choose>
                                        <c:when test="${empty each.authemp}" >
                                        <tr>
                                            <td>
                                                <input class="bor_none" name="groupno" value="${each.groupno}" type="checkbox" />
                                            </td>
                                            <td>${each.groupnm}</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </c:when>
                                        <c:otherwise>
                                        <c:forEach items="${each.authemp}" var="emp" varStatus="loop">
                                        <tr nos="${each.groupno}^${emp.emp_no}">
                                        <c:if test="${loop.first}" >
                                            <td rowspan="${fn:length(each.authemp)}">
                                                <input class="bor_none" name="groupno" value="${each.groupno}" type="checkbox" />
                                            </td>
                                            <td rowspan="${fn:length(each.authemp)}">${each.groupnm}(${fn:length(each.authemp)}명)</td>
                                        </c:if>
                                            <td>${emp.emp_nm}</td>
                                            <td>${emp.emp_id}</td>
                                            <td class="menu_btn_manage" style="text-align:center"><input type="button" value="그룹 해제" style="width:70px;height:20px"/></td>
                                        </tr>
                                        </c:forEach>
                                        </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:if test="${empty list}">
                                        <tr>
                                            <td colspan="7" style="padding:20;">기록이 없습니다.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                            <!---/게시판 영역------------------------->
                        </div><!--/main_table-->
						</li>
					</ul>
                    </div><!--/content-->
                </form:form>
            </div><!--/contents-->
        </div><!--/container-->
    </div><!--/wrap-->
</body>
</html>
