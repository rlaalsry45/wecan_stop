<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
    <jsp:include page="../../lnb.jsp" flush="true"/>
    <div id="contents">
        <div class="contants_top">
            <div class="location">
                <a href="/admsys/dashboard/index.html">HOME</a>
                <a href="/admsys/user/common/inst_broker.html">기관관리</a>
                <strong>기관등록</strong>
            </div>
        </div>
        <div id="content">
            <ul class="homepagebbs">
                <li class="bg">
                    <h3 class="member">기관등록</h3>
                    <div class="user_btn">
                        <%--<a class="btmore01" id="batch-reg" href="/admsys/user/common/inst_xcelup.html">+ 기관 일괄 등록</a>--%>
                    </div>
                </li>
                <li>
                    <div class="main_table">
                        <form name="frm" id="frm" method="post" enctype="multipart/form-data">
                            <h4>신청기관 정보입력</h4>
                            <table class="main_table1 bgneno" summary="기관이름, 상위기관, 주무부처">
                                <caption>신청기관 정보입력</caption>
                                <colgroup>
                                    <col style="width:25%;"/>
                                    <col style="width:25%;"/>
                                    <col style="width:25%;"/>
                                    <col style="width:25%;"/>
                                </colgroup>
                                <tbody>
                                <tr>
                                    </td>
                                    <th scope="row">기관이름</th>
                                    <td class="Tbod Tleft">
                                        <input class="text" name="name" title="기관이름 입력" style="width:226px;height:23px;" type="text">
                                    </td>
                                </tr>
                                <tr>
                                    </td>
                                    <th scope="row">기관유형</th>
                                    <td class="Tbod Tleft">
                                        <input class="text" name="type" title="기관유형 입력" style="width:226px;height:23px;" type="text">
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row">상위기관</th>
                                    <td class="Tleft">
                                        <input class="text" name="boss" title="상위기관 입력" style="width:226px;height:23px;" type="text">
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row">주무부처</th>
                                    <td class="Tleft">
                                        <input class="text" name="arch" title="주무부처 입력" style="width:226px;height:23px;" type="text">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="btn-c-B">
                                <a class="btmore04" id="submit_btn" href="#none">확인</a>
                                <a class="btmore05" href="javascript:history.back();">취 소</a>
                            </div>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
        <!--/content-->
    </div>
    <!--/contents-->

<c:import url="../../footer.jsp"/>
