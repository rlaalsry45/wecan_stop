<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <div class="contents_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/user/common/">회원관리</a> <strong>회원검색</strong>
                    </div>
                </div>
                <div id="content">
                <c:if test="${userType ne 'outside' }">
                    <ul class="homepagebbs">
					<li class="bg"><h3 class="member">회원검색 [회비납부 승인대기:${semiUserCount}명, 탈퇴대기:${outUserCount}명]</h3></li>
					<li>
                        <!--  내용들어가는 부분 시작  -->
                    <form name="frm" method="post" action="index.html">
                        <table class="main_table1 bgneno" summary="검색조건, 정렬조건">
                        <colgroup>
                            <col style="width:10%" />
                            <col style="width:10%" />
                            <col style="width:15%" />
                            <col />
                        </colgroup>
                            <tr>
                                <th rowspan="2" class="Tleft">검색조건</th>
                                <td class="rborder Tbod">검색어</td>
                                <td class="rborder Tbod Tleft">
                                <select name="cond6" id="cond6" style="height:27px;">
                                    <option value="username">이름</option>
                                    <option value="useridx">회원번호</option>
                                    <option value="userid">ID</option>
                                </select></td>
                                <td colspan="2" class="Tbod Tbod Tleft">
                                <input type="text" class="bor1ddd" name="keyword" style="height:23px;width:140px;"><!-- *like 검색시 검색어 앞에 %를 입력해주세요. --></td>
                            </tr>
                            <tr>
                                <td align="center" class="rborder">승인여부</td>
                                <td class="Tleft" colspan="2">
                                <select name="cond7" id="cond7" style="height:27px;">
                                        <option value="1">승인</option>
                                        <option value="0">승인대기(미납)</option>
                                        <option value="4">승인대기(완납)</option>
                                        <option value="9">탈퇴</option>
                                        <option value="3">탈퇴대기</option>
                                </select>
                                <!-- <input type="checkbox" name="st_sec3" style="vertical-align:middle">결제회원 -->
                                </td>
                            </tr>
                            <tr>
                                <th colspan="2" class="Tbornone Tleft">정렬조건</th>
                                <td  class="Tleft" colspan="2">
                                <select name="st_sec1" style="height:27px;">
                                        <option value="useridx">회원번호</option>
                                        <option value="username">이름</option>
                                        <option value="userid">ID</option>
                                </select>
                                <select name="st_sec2" style="height:27px;">
                                        <option value="1">오름차순</option>
                                        <option value="2">내림차순</option>
                                </select>
                                </td>
                            </tr>
                        </table>
                        <div class="btn-c">
                            <input type="submit" class="chost_btn_s" value="검 색">
                        </div>
                        </form>
                    </li>
                </ul>
                </c:if>
                <c:if test="${userType eq 'outside' }">
                    <ul class="homepagebbs">
					<li class="bg"><h3 class="member">외부심사위원 검색</h3></li>
					<li>
                    <form name="frm" method="post" action="index.html">
                        <input type="hidden" name="userType" value="${userType }"/>
                        <table class="main_table1 bgneno" summary="검색조건">
                            <colgroup>
                                <col style="width:10%" />
                                <col style="width:10%" />
                                <col style="" />
                            </colgroup>
                                <tr>
                                    <th class="Tleft">검색조건</th>
                                    <td class="rborder Tbod">검색어</td>
                                    <td class="rborder Tbod Tleft">
                                    <select name="cond6" id="cond6" style="height:27px;">
                                        <option value="username">이름</option>
                                        <option value="useridx">회원번호</option>
                                        <option value="userid">ID</option>
                                    </select> <input type="text" class="bor1ddd" name="keyword" style="height:23px;width:140px;"><!-- *like 검색시 검색어 앞에 %를 입력해주세요. --></td>
                                </tr>
                            </table> <br>
                            <div class="btn-c">
                                <input type="submit" class="chost_btn_s" value="검 색">
                            </div>
                    </form>
                    </li>
                </ul>
                </c:if>
            </div>
            </div><!--/contents-->
        </div><!--/container-->
    </div><!--/wrap-->
</body>
</html>