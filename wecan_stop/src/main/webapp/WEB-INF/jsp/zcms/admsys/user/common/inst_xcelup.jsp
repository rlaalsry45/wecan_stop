<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<div id="container">
    <jsp:include page="../../lnb.jsp" flush="true"/>
    <div id="contents">
        <div class="contants_top">
            <div class="location">
                <a href="/admsys/dashboard/index.html">HOME</a>
                <a href="/admsys/user/common/index.html">회원관리</a>
                <a href="/admsys/user/common/inst_broker.html">기관관리</a>
                <strong>기관 일괄 등록</strong>
            </div>
        </div>
        <div id="content">
            <ul class="homepagebbs">
                <li class="bg">
                    <h3 class="member">기관 일괄 등록</h3>
                </li>
                <li>
                    <h4>엑셀 등록</h4>
                    <div class="main_table">
                        <form name="frm" id="frm" method="post" action="inst_xcelup.html" enctype="multipart/form-data">
                            <table class="main_table1 bgneno">
                                <tr>
                                    <td>
                                        <c:choose>
                                            <c:when test="${total eq null}">
                                                <input type="file" name="file">
                                            </c:when>
                                            <c:otherwise>
                                                총 ${total}개 기관중 ${store}개의 기관이 등록되었습니다.
                                                <c:if test="${exist gt 0}">
                                                    <br/>${exist}개의 기관은 이미 등록되어 있는 기관입니다.
                                                </c:if>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </table>
                            <div class="btn-c-B">
                                <c:choose>
                                    <c:when test="${total eq null}">
                                        <a href="javascript: document.frm.submit();" class="btmore04">등록</a>
                                        <a href="javascript: history.back();" class="btmore05">취소</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="/admsys/user/common/inst_xcelup.html" class="btmore04">재등록</a>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
        <!--/content-->
    </div>
    <!--/contents-->
</div>
<!--/container-->

<c:import url="../../footer.jsp"/>
