<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="egovframework.rte.psl.dataaccess.util.EgovMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    java.util.Calendar cal = java.util.Calendar.getInstance();
    String sImgUrl = "/com/art/egovframework/com/cop/smt/sdm/";
    String sCssUrl = "/com/css/egovframework/com/cop/smt/sdm/";

    String strYear = request.getParameter("year");
    String strMonth = request.getParameter("month");

    int year = cal.get(java.util.Calendar.YEAR);
    int month = cal.get(java.util.Calendar.MONTH);
    int date = cal.get(java.util.Calendar.DATE);

    if (strYear != null) {
        year = Integer.parseInt(strYear);
        month = Integer.parseInt(strMonth);
    } else {

    }
//년도/월 셋팅
    cal.set(year, month, 1);

    int startDay = cal.getMinimum(java.util.Calendar.DATE);
    int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
    int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
    int newLine = 0;

    String url = "/admsys/module/schdule/SchdulManageMonthList.html";
    String regurl = "/admsys/module/schdule/SchdulManageRegist.html";
    String detailurl = "/admsys/module/schdule/SchdulManageDetail.html";
    String updateurl = "/admsys/module/schdule/SchdulManageModify.html";
%>
<html lang="ko">
<HEAD>
    <TITLE>월간 부서일정관리</TITLE>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/cms/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="/cms/css/base.css" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/cms/css/democratic.css"/>
    <script type="text/javaScript" language="javascript">

        var gOpener = parent.document.all ? parent.document.deptSchdulManageVO : parent.document.getElementById("deptSchdulManageVO");

        /* ********************************************************
         * 주관 부서 팝업창열기
         ******************************************************** */
        function fn_egov_regist_DeptSchdulManage(sDate) {

            gOpener.schdulBgnde.v = sDate;
            gOpener.schdulEndde.v = sDate;
            gOpener.action            = "<%=regurl%>";
            window.open('', 'listPop1', 'width=746,height=350,left=300,top=100,resizable=no');
            gOpener.target = 'listPop1';
            gOpener.submit();
        }


        /* ********************************************************
         * 주관 부서 팝업창열기
         ******************************************************** */
        function fn_egov_detail_DeptSchdulManage(schdulId) {
            window.open('', 'listPop2', 'width=746,height=350,left=300,top=100,resizable=no');
            gOpener.schdulId.v = schdulId;
            gOpener.action         = "<%=detailurl%>";
            gOpener.target         = 'listPop2';
            gOpener.submit();
        }
        function fn_egov_update_DeptSchdulManage(schdulId) {
            window.open('', 'listPop2', 'width=746,height=350,left=300,top=100,resizable=no');
            gOpener.schdulId.v = schdulId;
            gOpener.action         = "<%=updateurl%>";
            gOpener.target         = 'listPop2';
            gOpener.submit();
        }


        var ifr = parent.document.all ? parent.document.all.SchdulView : parent.document.getElementById("SchdulView");

        function do_resize() {
            resizeFrame(1);
        }

        //가로길이는 유동적인 경우가 드물기 때문에 주석처리!
        function resizeFrame(re) {

            if (ifr) {

                var innerHeight = document.body.scrollHeight + (document.body.offsetHeight - document.body.clientHeight);

                if (ifr.style.height != innerHeight) //주석제거시 다음 구문으로 교체 -> if (ifr.style.height != innerHeight || ifr.style.width != innerWidth)
                {
                    ifr.style.height = innerHeight;
                }

                /*
                 if(!re) {
                 try{ document.body.attachEvent('onclick',do_resize);
                 }catch(e){document.body.addEventListener("click", do_resize, false);}
                 }
                 */
            }
        }
        function fnEgovSchdulSe(setValue) {

            location.href = "<%=url%>?year=<%=year%>&month=<%=month%>&searchCondition=SCHDUL_SE&searchKeyword=" + setValue;

        }
        window.onload = function () {
            do_resize();
        }
    </script>

</HEAD>
<BODY style="background:none;">
<script type="text/javascript">
    function openbannerLink(link, typ, w, h) {
        if (!(link == null || link == 'null')) {
            if (typ == '2') {
                window.open(link, '_blank', '');
            } else if (typ == '3') {
                window.open(link, '_blank', 'width=' + w + ',height=' + h);
            } else {
                window.open(link, '_self', '');
            }
        }


    }
</script>
<form name="deptSchdulManageVO" id="deptSchdulManageVO" action="" method="post">
    <%
        int month1 = month - 1;
        int year1 = year;
        int month2 = month + 1;
        int year2 = year;
        if (month2 >= 12) {
            year2++;
            month2 = 0;
        }
        if (month1 < 0) {
            year1--;
            month1 = 11;
        }
    %>

    <div class='l-cont'>
        <h3 class="invisible">월별일정보기</h3>
        <div class="calender">
            <div class="first"><span><%=year%>년</span>
                <!--a href="#" class="prev"><img src="/usr/image/common/btn/btn_prev04.gif" alt="전 날짜로" /></a>							<a href="#" class="next"><img src="/usr/image/common/btn/btn_next04.gif" alt="다음 날짜로" /></a-->
            </div>
            <div>
                <span><%=month + 1%>월</span>
                <a href="<%=url %>?calendar_no=${calendar_no}&year=<%=year1%>&amp;month=<%=month1%>" class="prev">
                    <img src="/usr/images/common/btn_prev04.gif" alt="전 날짜로"/>
                </a>
                <a href="<%=url %>?calendar_no=${calendar_no}&year=<%=year2%>&amp;month=<%=month2%>" class="next">
                    <img src="/usr/images/common/btn_next04.gif" alt="다음 날짜로"/>
                </a>
            </div>
        </div>
        <table class="calender" summary="일, 월, 화, 수, 목, 금, 토">
            <caption> 월별일정보기</caption>
            <colgroup>
                <col style="width: 14.2%;"/>
                <col/>
                <col style="width: 14.2%;"/>
                <col style="width: 14.2%;"/>
                <col style="width: 14.2%;"/>
                <col style="width: 14.2%;"/>
                <col style="width: 14.2%;"/>
            </colgroup>
            <thead>
            <tr>
                <th scope="col" class="first sun">일</th>
                <th scope="col">월</th>
                <th scope="col">화</th>
                <th scope="col">수</th>
                <th scope="col">목</th>
                <th scope="col">금</th>
                <th scope="col" class="sat">토</th>
            </tr>
            </thead>
            <TBODY>
            <TR>
                <%
                    String bgcolor = "white";

                    List listResult = (List) request.getAttribute("resultList");
                    EgovMap egovMap = new EgovMap();
//처음 빈공란 표시
                    for (int index = 1; index < start; index++) {
                        out.println("<TD >&nbsp;</TD>");
                        newLine++;
                    }

                    for (int index = 1; index <= endDay; index++) {
                        String color = "";

                        if (newLine == 0) {
                            color = "RED";
                        } else if (newLine == 6) {
                            color = "#529dbc";
                        } else {
                            color = "BLACK";
                        }
                        ;

                        String sUseDate = Integer.toString(year);

                        sUseDate += Integer.toString(month + 1).length() == 1 ? "0" + Integer.toString(month + 1) : Integer.toString(month + 1);
                        sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index) : Integer.toString(index);

                        int iUseDate = Integer.parseInt(sUseDate);

                        out.println("<TD valign='top' align='left' height='92px' width='100px' break-word;>");
//	out.println("<TD valign='top' align='left' height='92px' width='100px' bgcolor='"+ bgcolor+"' break-word;>");

                        out.println("<font color='" + color + "'><a href=\"JavaScript:fn_egov_regist_DeptSchdulManage('" + iUseDate + "');\">" + index + "</a></font>");
                        out.println("<BR>");
	/*
	out.println(iUseDate);
	out.println("<BR>");
	*/

                        if (listResult != null) {

                            for (int i = 0; i < listResult.size(); i++) {
                                egovMap = (EgovMap) listResult.get(i);

                                int iBeginDate = Integer.parseInt(((String) egovMap.get("schdulBgnde")).substring(0, 8));
                                int iBeginEnd  = Integer.parseInt(((String) egovMap.get("schdulEndde")).substring(0, 8));

                                //날자별로 일정이 박혀야 할경우 아래 조건절 사용
                                //if(iUseDate >= iBeginDate && iUseDate <= iBeginEnd){
                                //해당날자만 나와야 할경우 아래선택
                                if (iUseDate == iBeginDate) {
                                    //out.print("<table><tr><td nowrap><div class='divDotText' style='width:97px;border:solid 0px;'><a href=\"JavaScript:fn_egov_detail_DeptSchdulManage('" +  egovMap.get("schdulId") + "')\">");
                                    //if(egovMap.get("exposuretype").equals("C")){

                                    out.print("<a href=\"JavaScript:fn_egov_update_DeptSchdulManage('" + egovMap.get("schdulId") + "')\">");
                                    out.print("<font color='green'>" + (String) egovMap.get("schdulNm") + "</font>");
                                    out.print("</a>");
					/* out.print("<br/>"+(String)egovMap.get("schdulCn")+"<br/>"); */
                                    if (iBeginDate != iBeginEnd) {
                                        out.print("<br/>[" + ((String) egovMap.get("schdulBgnde")).substring(4, 6)
                                                          + "." + ((String) egovMap.get("schdulBgnde")).substring(6, 8)
                                                          + " ~ "
                                                          + ((String) egovMap.get("schdulEndde")).substring(4, 6)
                                                          + "." + ((String) egovMap.get("schdulEndde")).substring(6, 8)
                                                          + "]<br/>");
                                    }
                                    out.print("<br/><br/>");

                                    //}else if(egovMap.get("exposuretype").equals("P")){
                                    //	out.print("<font color='red'>"+(String)egovMap.get("schdulNm")+"</font>");
                                    //}else{
                                    //	out.print((String)egovMap.get("schdulNm"));
                                    //}

                                    //out.println("</a></div></td></tr></table>");
				/*
				out.println(iBeginDate);
				out.println("<BR>");
				out.println(iBeginEnd);
				*/
                                }


                            }
                        }

                        out.println("</TD>");
                        newLine++;

                        if (newLine == 7) {
                            out.println("</TR>");
                            if (index <= endDay) {
                                out.println("<TR>");
                            }
                            newLine = 0;
                        }
                    }
//마지막 공란 LOOP
                    while (newLine > 0 && newLine < 7) {
                        out.println("<TD>&nbsp;</TD>");
                        newLine++;
                    }
                %>
            </TR>

            </TBODY>
        </TABLE>

        <!-- 여기부터 ------------------------------------------------->

        <%if (listResult != null) { %>

        <table class="detailed-sch" summary="날짜, 행사일정">
            <caption>행사일정</caption>
            <colgroup>
                <col style="width: 20%;"/>
                <col style="width: 80%;"/>
            </colgroup>
            <thead>
            <tr>
                <th scope="col" class="first">날짜</th>
                <th scope="col">행사일정</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < listResult.size(); i++) {
                    egovMap = (EgovMap) listResult.get(i);

                    int    iBeginDate      = Integer.parseInt(((String) egovMap.get("schdulBgnde")).substring(0, 8));
                    int    iBeginEnd       = Integer.parseInt(((String) egovMap.get("schdulEndde")).substring(0, 8));
                    String schdulUrl       = (String) egovMap.get("schdulurl");
                    String schdulUrlTarget = (String) egovMap.get("schdulurltarget");

		/* 날자별로 일정이 박혀야 할경우 아래 조건절 사용
		if(iUseDate >= iBeginDate && iUseDate <= iBeginEnd) */
                    //해당날자만 나와야 할경우 아래선택

                    out.print("<tr>");
                    if (!(egovMap.get("schdulBgnde").equals(egovMap.get("schdulEndde")))) {
                        out.print("<td>"
                                          + ((String) egovMap.get("schdulBgnde")).substring(0, 4)
                                          + "." + ((String) egovMap.get("schdulBgnde")).substring(4, 6)
                                          + "." + ((String) egovMap.get("schdulBgnde")).substring(6, 8)
                                          + " ~ "
                                          + ((String) egovMap.get("schdulEndde")).substring(0, 4)
                                          + "." + ((String) egovMap.get("schdulEndde")).substring(4, 6)
                                          + "." + ((String) egovMap.get("schdulEndde")).substring(6, 8)
                                          + "</td>");
                    } else {
                        out.print("<td>"
                                          + ((String) egovMap.get("schdulBgnde")).substring(0, 4)
                                          + "." + ((String) egovMap.get("schdulBgnde")).substring(4, 6)
                                          + "." + ((String) egovMap.get("schdulBgnde")).substring(6, 8)
                                          + "</td>");
                    }
                    out.print("<td class=\"subject\"><strong>" + (String) egovMap.get("schdulNm") + "</strong>");
                    out.print("<p>" + (String) egovMap.get("schdulCn") + "</p>");
                    if (schdulUrl != null) {
                        out.print("<div><a href='##' class='btmore04' onclick=\"javascript:openbannerLink('" + schdulUrl + "','2')\">링크주소</a></div></td>");
                    }
                    out.print("</tr>");

                }
            %>
            </tbody>
        </table>
        <br/><br/>
        <%
            }
        %>
        <!-- 여기까지 ------------------------------------------------->
    </div>

</form>
</BODY>
</HTML>
