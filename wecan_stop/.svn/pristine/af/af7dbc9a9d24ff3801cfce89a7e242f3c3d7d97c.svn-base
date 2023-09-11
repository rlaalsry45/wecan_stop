<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file = "/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자::게시글 관리</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
<meta name="Keywords" content="z5 cms"/>
<meta name="decription" content="z5 cms"/>
<meta name="author" content="z5 cms"/>
<meta name="classification" content="z5 cms"/>
<link rel="stylesheet" href="/cms/css/common.css" type="text/css" />
<link rel="stylesheet" href="/cms/css/import.css" type="text/css" />
</head>
<body style="background:none;">
<div id="wrap">
<form:form modelAttribute="postsVo" name="frm" method="post">
<input type="hidden" id="boardno" name="boardno" value="${boardno}" />
<input type="hidden" name="type" value="${type}" />
<input type="hidden" name="tblname" value="${tblname}" />
<c:set var="gubun" value="${type eq '0' ? 'notice' : 'posts'}"/>
    <div class="search">
        <div class="srch_right">
            <ul>
                <li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
                <li class="srch_right_left">
                    <select name="cond1">
                        <option value="datereg" <c:if test="${input.cond1=='datereg'}"><c:out value='selected' /></c:if>>등록일</option>
                        <option value="datemod" <c:if test="${input.cond1=='datemod'}"><c:out value='selected' /></c:if>>수정일</option>
                    </select>
                    <input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" />
                    ~
                    <input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" />
                    <select name="cond2">
                        <option value="bbstitle" <c:if test="${input.cond2=='bbstitle'}"><c:out value='selected' /></c:if>>제목</option>
                        <option value="bbsconts" <c:if test="${input.cond2=='bbsconts'}"><c:out value='selected' /></c:if>>내용</option>
                    </select>
                    <input type=text name="keyword" value="<c:out value='${input.keyword}' />" />
                </li>
                <li class="srch_btn_go">
                    <input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
                </li>
            </ul>
        </div><!--/srch_right-->
    </div><!--/search-->
    <div id="content">
    <c:if test="${gubun=='notice'}">
    <div class="main_btn">
        <ul>
            <li>
                <a href="javascript:checkAll(true,'bbsno');"><img alt="전체선택" src="/cms/image/common_btn_selall.jpg" /></a>
            </li>
            <li>
                <a href="javascript:checkAll(false,'bbsno');"><img alt="선택해제" src="/cms/image/common_btn_release.jpg" /></a>
            </li>
            <li>
                <a href="javascript:del('bbsno');"><img alt="삭제" src="/cms/image/common_btn_del.jpg" /></a>
            </li>
        </ul>
        <ul class="site_register">
            <li>
                <a href="
                <c:url value="write.html">
                    <c:param name="boardno" value="${boardno}"/>
                    <c:param name="tblname" value="${tblname}"/>
                </c:url>
                "><img alt="등록" src="/cms/image/btn_common_reg.jpg" /></a>
            </li>
        </ul>
    </div><!--/main_btn-->
    </c:if>
    <div class="main_table">
            <!--게시판 영역-->
            <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="게시글리스트">
                <caption>게시글리스트</caption>
                <colgroup>
                    <c:if test="${gubun=='notice'}">
                    <col width="5%" />
                    </c:if>
                    <col width="10%" />
                    <col />
                    <col width="15%" />
                    <col width="10%" />
                    <col width="15%" />
                </colgroup>
                <thead>
                    <tr>
                        <c:if test="${gubun=='notice'}">
                        <th>
                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','bbsno')" />
                        </th>
                        </c:if>
                        <th>번호</th>
                        <th>제목</th>
                        <c:if test="${gubun=='posts'}"><th>답변여부</th></c:if>
                        <th>글쓴이</th>
                        <c:if test="${gubun=='notice'}"><th>첨부</th></c:if>
                        <th>게시일자</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="each" varStatus="loop">
                        <tr>
                            <c:if test="${gubun=='notice'}">
                            <td>
                                <input class="bor_none" name="bbsno" value="${each.bbsno}" type="checkbox" />
                            </td>
                            </c:if>
                            <td>
                                <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                            </td>
                            <td style="padding-left:50px;text-align:left">
                                <c:if test="${each.bbsnotice=='1'}"><img src="/cms/image/icon/icon_notice.gif" alt="공지글입니다." style="border:0px;" /></c:if>
                                <c:set var="page" value="${type eq '0' ? 'write.html' : 'view.html'}"/>
                                <a href="
                                <c:url value="${page}">
                                    <c:param name="boardno" value="${boardno}"/>
                                    <c:param name="bbsno" value="${each.bbsno}"/>
                                    <c:param name="tblname" value="${tblname}"/>
                                </c:url>
                                "><c:out value='${each.bbstitle}' /></a>
                            </td>
                            <c:if test="${gubun=='posts'}">
                            <td>
                                <c:if test="${each.bbslevel==0}"><c:if test="${each.cnt==1}"><img src="/cms/image/icon/icon_answer.gif" border="0" alt="답변중"></c:if><c:if test="${each.cnt>1}"><img src="/cms/image/icon/icon_answer02.gif" border="0" alt="답변완료" /></c:if></c:if>
                            </td>
                            </c:if>
                            <td>
                                <c:out value='${each.bbsusername}' />
                            </td>
                            <c:if test="${gubun=='notice'}">
                            <td>
                                <c:if test="${each.bbsfilenos>0}" ><img src='/cms/image/icon/icon_down.gif' border="0" alt="첨부파일" /></c:if><c:if test="${each.bbsfilenos==0}" >-</c:if>
                            </td>
                            </c:if>
                            <td>
                                <fmt:parseDate value="${each.bbsdatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${input.total==0}">
                        <tr>
                            <td colspan="<c:if test="${type==1}">6</c:if><c:if test="${type!=1}">5</c:if>" style="padding:20;">기록이 없습니다.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
            <!--/게시판 영역-->
        </div>
        <!--/main_table-->
    </div>
    <!--/content-->
</form:form>
</div><!--/wrap-->
</body>
</html>
