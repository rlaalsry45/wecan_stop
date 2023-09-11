<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <script type="text/javascript">
            $(function(){
                $(":button").click(function(){
                    var popup = null;
                    if ($(this).attr('id') == "groupbtn") {
                        /* group popup */
                        popup = window.open("boardGroupCreate.html", "popupCreateGroup", "directories=no,toolbar=no,width=380,height=200");
                    }
                    else if ($(this).attr('id') == "managebtn") {
                        /* manage popup */
                        popup = window.open("boardGroupSet.html?groupno="+$(this).closest("tr").find(":checkbox").val(), "popupManageGroup", "directories=no,toolbar=no,width=850,height=700,scrollbars=yes");
                    }
                    else {
                        alert("지원하지 않는 버튼입니다!");
                    }
                    popup.focus();
                });
                $('.main_table1 tr').click(function(event) {
                    if (event.target.type !== 'checkbox' && event.target.type !== 'button') {
                        $(':checkbox', this).trigger('click');
                    }
                });
            })
            </script>
            <div id="contents">
                <form:form modelAttribute="zBoardGroupVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/board/">게시판관리</a> <strong>그룹설정</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="groupnm" <c:if test="${input.cond1=='groupnm'}"><c:out value='selected' /></c:if>>그룹명</option>
                                <option value="boardtitle" <c:if test="${input.cond1=='boardtitle'}"><c:out value='selected' /></c:if>>소속게시판명</option>
                                <option value="username" <c:if test="${input.cond1=='username'}"><c:out value='selected' /></c:if>>그룹관리자명</option>
                            </select>
                            <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${keyword}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="this.form.action='?pageIndex=1'" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg">
                                <h3 class="bbs">그룹설정
								<a class="imgSelect" title="그룹설정 대한 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>그룹설정</strong></br>
									그룹설정을 통해 생성된 게시판 사용 권한을 설정할 수 있습니다.
									</div>

								</h3><input class="btmore03" type="button" id="groupbtn" value="+ 그룹등록" />
                            </li>
                            <li>
                                <div class="top_bt">
                                    <a class="btmore07" href="javascript:checkAll(true,'groupno');">전체선택</a>
                                    <a class="btmore07" href="javascript:checkAll(false,'groupno');">전체해제</a>
                                    <a class="btmore05" href="javascript:del('groupno');">삭제</a>
                                    <select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()" style="height:28px;">
                                            <c:forTokens items="10,20,30,40,50" var="each" delims=",">
                                            <option value="${each}" <c:if test="${param.pageSize==each}"><c:out value='selected' /></c:if>>${each}개 출력</option>
                                            </c:forTokens>
                                        </select>
                                </div>
                                <div class="main_table">
                                    <!-- 게시판 영역 -->
                                    <table class="main_table1" summary="관리목록">
                                        <caption>그룹목록</caption>
                                        <colgroup>
                                            <col width="7%" />
                                            <col width="7%" />
                                            <col width="25%" />
                                            <col />
                                            <col width="20%" />
                                            <col width="160" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','groupno')" />
                                                </th>
                                                <th>번호</th>
                                                <th>그룹</th>
                                                <th>소속게시판</th>
                                                <th>그룹관리자</th>
                                                <th>관리</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${dt.list}" var="each" varStatus="loop">
                                                <tr>
                                                    <td>
                                                        <input class="bor_none" name="groupno" value="${each.groupno}" type="checkbox" />
                                                    </td>
                                                    <td>
                                                        <c:out value='${dt.total-(param.pageIndex-1)*param.pageSize-loop.index}' />
                                                    </td>
                                                    <td>${each.groupnm}</td>
                                                    <td>
                                                        <c:forEach items="${each.zBoardGroupMemberVo}" var="board" varStatus="bstatus">
                                                            <c:out value="${board.boardtitle}" /><c:if test="${not bstatus.last}" ><br></c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td>
                                                    <c:forEach items="${each.zBoardGroupAdminVo}" var="emp" varStatus="estatus">
                                                        <c:out value="${emp.username}" /><c:if test="${not estatus.last}" ><br></c:if>
                                                    </c:forEach>
                                                    </td>
                                                    <td><input class="chost_btn_s3" type="button" id="managebtn" value="관리" /></td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${empty dt.list}">
                                                <tr>
                                                    <td colspan="6" style="padding:20;">기록이 없습니다.</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${dt.pageIndex}' pageMax='${dt.pageMax}' />
                                    <!--/게시판 영역-->
                                </div><!--/main_table-->
                            </li>
                        </ul>
                    </div><!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../../end.jsp" flush="false" />
