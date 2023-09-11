<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="egovframework.rte.psl.dataaccess.util.EgovMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%
    java.util.Calendar cal = java.util.Calendar.getInstance();
    String sImgUrl = "/com/art/egovframework/com/cop/smt/sdm/";
    String sCssUrl = "/com/css/egovframework/com/cop/smt/sdm/";

    String strYear = request.getParameter("year");
    String strMonth = request.getParameter("month");

    int year = cal.get(java.util.Calendar.YEAR);
    int month = cal.get(java.util.Calendar.MONTH);
    int date = cal.get(java.util.Calendar.DATE);


    if (strYear == null || strYear.equals("null")) {
        strYear = Integer.toString(year);
    }
    if (strMonth == null || strMonth.equals("null")) {
        strMonth = Integer.toString(month);
    }

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


    String url = "/?menuno=381";

%>

<c:if test="${use_yn eq 'Y'}">

    <style>

        /* 캘린더 */
        div.years-month {
            width: 300px;
            margin: 38px auto 0 auto;
            color: #000000;
            font-size: 25px;
            line-height: 30px;
            font-family: NANUM;
            text-align: center;
            position: relative;
        }

        div.years-month a.prev {
            position: absolute;
            top: 0;
            left: 0;
        }

        div.years-month a.next {
            position: absolute;
            top: 0;
            right: 0;
        }

        table.calender {
            width: 100%;
            margin-top: 30px;
            border-top: 2px solid #495a74;
            border-left: 1px solid #e5e5e5;
            font-size: 14px;
            line-height: 18px;
            font-family: NANUM;
        }

        table.calender th {
            padding: 5px 0;
            border-right: 1px solid #e5e5e5;
            border-bottom: 1px solid #e5e5e5;
            background: #eef1f9;
            color: #000000;
        }

        table.calender td {
            height: 110px;
            padding: 10px;
            border-right: 1px solid #e5e5e5;
            border-bottom: 1px solid #e5e5e5;
            color: #3a3a3a;
            vertical-align: top;
        }

        table.calender td p {
            margin-top: 10px;
            color: #587e86;
            font-size: 12px;
            line-height: 18px;
            font-family: NANUM;
        }

        table.calender .sun {
            color: #ff0000;
        }

        table.calender .sat {
            color: #0018ff;
        }

        table.calender .last {
            color: #8f8f8f;
        }

        table.calender td span {
            display: block;
            width: 28px;
            height: 23px;
            padding-top: 5px;
            background: #97d0ff;
            text-align: center;
        }
    </style>
    <form name="deptSchdulManageVO" id="deptSchdulManageVO" action="" method="post">
        <div class="calendar big">
            <script type="text/javaScript" language="javascript">

                var gOpener = parent.document.all ? parent.document.deptSchdulManageVO : parent.document.getElementById("deptSchdulManageVO");

                /* ********************************************************
                 * 주관 부서 팝업창열기
                 ******************************************************** */


                /* ********************************************************
                 * 주관 부서 팝업창열기
                 ******************************************************** */


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

            <c:if test="${calendar_lang eq 'KR'}">
                <a href="?menuno=${param.menuno}&calendar_no=${calendar_no}&year=<%=year1%>&amp;month=<%=month1%>" class="first ti">이전달</a>
            </c:if>
            <c:if test="${calendar_lang eq 'EN'}">
                <a href="?menuno=${param.menuno}&calendar_no=${calendar_no}&year=<%=year1%>&amp;month=<%=month1%>" class="first ti">Previous Month</a>
            </c:if>
            <strong>
                <%=year%>
                <c:if test="${calendar_lang eq 'KR'}">
                    년 <%=month + 1%>월
                </c:if>
                <c:if test="${calendar_lang eq 'EN'}">
                    . <%=month + 1%>
                </c:if>
            </strong>
            <c:if test="${calendar_lang eq 'KR'}">
                <a href="?menuno=${param.menuno}&calendar_no=${calendar_no}&year=<%=year2%>&amp;month=<%=month2%>" class="end ti">다음달</a>
            </c:if>
            <c:if test="${calendar_lang eq 'EN'}">
                <a href="?menuno=${param.menuno}&calendar_no=${calendar_no}&year=<%=year2%>&amp;month=<%=month2%>" class="end ti">Next Month</a>
            </c:if>
        </div>
        <table class="calendar_in big" summary="Calender">
            <caption>calendar</caption>
            <colgroup>
                <col style="width:14.285%">
                <col style="width:14.285%">
                <col style="width:14.285%">
                <col style="width:14.285%">
                <col style="width:14.285%">
                <col style="width:14.285%">
                <col style="width:14.285%">
            </colgroup>
            <thead>
            <c:if test="${calendar_lang eq 'KR'}">
                <tr>
                    <th scope="col" class="sun">일</th>
                    <th scope="col">월</th>
                    <th scope="col">화</th>
                    <th scope="col">수</th>
                    <th scope="col">목</th>
                    <th scope="col">금</th>
                    <th scope="col" class="sat">토</th>
                </tr>
            </c:if>
            <c:if test="${calendar_lang eq 'EN'}">
                <tr>
                    <th scope="col" class="sun">S</th>
                    <th scope="col">M</th>
                    <th scope="col">T</th>
                    <th scope="col">W</th>
                    <th scope="col">T</th>
                    <th scope="col">F</th>
                    <th scope="col">S</th>
                </tr>
            </c:if>
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

//                        out.println("<TD valign='top' align='left' height='92px' width ='100px' bgcolor='" + bgcolor + "' break-word;>");
                        out.println("<TD valign='top' align='left' height='92px' width ='100px' break-word;>");

                        out.println("<font color='" + color + "'>" + index + "</font>");
                        out.println("<BR>");
	/*
	out.println(iUseDate);
	out.println("<BR>");
	*/

                        if (listResult != null) {

                            for (int i = 0; i < listResult.size(); i++) {
                                egovMap = (EgovMap) listResult.get(i);

                                int    iBeginDate      = Integer.parseInt(((String) egovMap.get("schdulBgnde")).substring(0, 8));
                                int    iBeginEnd       = Integer.parseInt(((String) egovMap.get("schdulEndde")).substring(0, 8));
                                String schdulUrl       = (String) egovMap.get("schdulurl");
                                String schdulUrlTarget = (String) egovMap.get("schdulurltarget");
                                String schdulNm        = (String) egovMap.get("schdulNm");
                                String ctitle          = (String) egovMap.get("ctitle");
                                Object boardurl        = egovMap.get("url");

                                //날자별로 일정이 박혀야 할경우 아래 조건절 사용
                                //if(iUseDate >= iBeginDate && iUseDate <= iBeginEnd){
                                //해당날자만 나와야 할경우 아래선택
                                if (iUseDate == iBeginDate) {
                                    //out.print("<table><tr><td nowrap><div class='divDotText' style='width:97px;border:solid 0px;'><a href=\"JavaScript:fn_egov_detail_DeptSchdulManage('" +  egovMap.get("schdulId") + "')\">");
                                    //if(egovMap.get("exposuretype").equals("C")){

                                    //out.print("<a href=\"JavaScript:fn_egov_update_DeptSchdulManage('" +  egovMap.get("schdulId") + "')\">");
                                    if (!(schdulUrl == null || schdulUrl.equals("null"))) {
                %>
                <a href='#' onclick="javascript:openbannerLink('<%=schdulUrl%>','<%=schdulUrlTarget%>')">
                    <font color='green'>
                        <subs:substringOut str='<%=schdulNm%>' length='40'/>
                    </font>
                </a>
                <%
                } else if (!(boardurl == null || boardurl.equals("null"))) {
                %>
                <a href='<%=boardurl%>'>
                    <font color='green'>
                        <%if (!(ctitle == null || ctitle.equals("null"))) {%>
                        <subs:substringOut str='<%=ctitle%>' length='40'/>
                        <%} else {%>
                        <subs:substringOut str='<%=schdulNm%>' length='40'/>
                        <%}%>
                    </font>
                </a>
                <%
                } else {
                %>
                <font color='green'>
                    <%if (!(ctitle == null || ctitle.equals("null"))) {%>
                    <subs:substringOut str='<%=ctitle%>' length='40'/>
                    <%} else {%>
                    <subs:substringOut str='<%=schdulNm%>' length='40'/>
                    <%}%>
                </font>
                <%
                    }
                    //out.print("</a>");
                    out.print("<br>" + (String) egovMap.get("schdulCn") + "<br>");
                    if (iBeginDate != iBeginEnd) {
                        out.print("<font color='red'>Start</font>");
                    }
				/* 	if(iBeginDate !=iBeginEnd){
						out.print("<br/>["+((String)egovMap.get("schdulBgnde")).substring(4, 6)
									+"."+((String)egovMap.get("schdulBgnde")).substring(6, 8)
									+" ~ "
									+((String)egovMap.get("schdulEndde")).substring(4, 6)
									+"."+((String)egovMap.get("schdulEndde")).substring(6, 8)
									+"]<br/>");
					} */

                    out.print("<br/>");
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
                } else if (iUseDate == iBeginEnd) {
                    //out.print("<table><tr><td nowrap><div class='divDotText' style='width:97px;border:solid 0px;'><a href=\"JavaScript:fn_egov_detail_DeptSchdulManage('" +  egovMap.get("schdulId") + "')\">");
                    //if(egovMap.get("exposuretype").equals("C")){

                    //out.print("<a href=\"JavaScript:fn_egov_update_DeptSchdulManage('" +  egovMap.get("schdulId") + "')\">");
                    if (!(schdulUrl == null || schdulUrl.equals("null"))) {
                %>
                <a href='#' onclick="javascript:openbannerLink('<%=schdulUrl%>','<%=schdulUrlTarget%>')">
                    <font color='green'>
                        <subs:substringOut str='<%=schdulNm%>' length='40'/>
                    </font>
                </a>
                <%
                } else if (!(boardurl == null || boardurl.equals("null"))) {
                %>
                <a href='<%=boardurl%>'>
                    <font color='green'>
                        <%if (!(ctitle == null || ctitle.equals("null"))) {%>
                        <subs:substringOut str='<%=ctitle%>' length='40'/>
                        <%} else {%>
                        <subs:substringOut str='<%=schdulNm%>' length='40'/>
                        <%}%>
                    </font>
                </a>
                <%
                } else {
                %>
                <font color='green'>
                    <%if (!(ctitle == null || ctitle.equals("null"))) {%>
                    <subs:substringOut str='<%=ctitle%>' length='40'/>
                    <%} else {%>
                    <subs:substringOut str='<%=schdulNm%>' length='40'/>
                    <%}%>
                </font>
                <%
                                    }
                                    //out.print("</a>");
                                    out.print("<br>" + (String) egovMap.get("schdulCn") + "<br>");
                                    if (iBeginDate != iBeginEnd) {
                                        out.print("<font color='red'>End</font>");
                                    }
				/* 	if(iBeginDate !=iBeginEnd){
						out.print("<br/>["+((String)egovMap.get("schdulBgnde")).substring(4, 6)
									+"."+((String)egovMap.get("schdulBgnde")).substring(6, 8)
									+" ~ "
									+((String)egovMap.get("schdulEndde")).substring(4, 6)
									+"."+((String)egovMap.get("schdulEndde")).substring(6, 8)
									+"]<br/>");
					} */

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
        <div class="board-wrap">

            <div class="tbl-box tmg20">
                <fieldset>
                    <legend>calendar</legend>
                    <ul class="calendar_tit">
                        <li>Date</li>
                        <li>Schedule</li>
                    </ul>

                    <table class="tbl-type01 bnone">
                        <caption>Calendar Lists</caption>
                        <colgroup>
                            <col style="width:180px">
                            <col style="width:*">
                        </colgroup>
                        <tbody>
                        <%
                            if (listResult.size() > 0) {
                                for (int i = 0; i < listResult.size(); i++) {
                                    egovMap = (EgovMap) listResult.get(i);

//                                    int    iBeginDate      = Integer.parseInt(((String) egovMap.get("schdulBgnde")).substring(0, 8));
//                                    int    iBeginEnd       = Integer.parseInt(((String) egovMap.get("schdulEndde")).substring(0, 8));
                                    String schdulUrl       = (String) egovMap.get("schdulurl");
                                    String schdulUrlTarget = (String) egovMap.get("schdulurltarget");
                                    String ctitle          = (String) egovMap.get("ctitle");
                                    Object boardurl        = egovMap.get("url");

                                    /* 날자별로 일정이 박혀야 할경우 아래 조건절 사용
                                       if(iUseDate >= iBeginDate && iUseDate <= iBeginEnd) */
                                    //해당날자만 나와야 할경우 아래선택
                                    out.print("<tr>");
                                    if (!(egovMap.get("schdulBgnde").equals(egovMap.get("schdulEndde")))) {
                                        out.print("<td class='bln'>"
                                                          + ((String) egovMap.get("schdulBgnde")).substring(0, 4)
                                                          + "-" + ((String) egovMap.get("schdulBgnde")).substring(4, 6)
                                                          + "-" + ((String) egovMap.get("schdulBgnde")).substring(6, 8)
                                                          + " start "
                                                          + ((String) egovMap.get("schdulEndde")).substring(0, 4)
                                                          + "-" + ((String) egovMap.get("schdulEndde")).substring(4, 6)
                                                          + "-" + ((String) egovMap.get("schdulEndde")).substring(6, 8)
                                                          + " deadline</td>");
                                    } else {
                                        out.print("<td class='bln'>"
                                                          + ((String) egovMap.get("schdulBgnde")).substring(0, 4)
                                                          + "-" + ((String) egovMap.get("schdulBgnde")).substring(4, 6)
                                                          + "-" + ((String) egovMap.get("schdulBgnde")).substring(6, 8)
                                                          + "</td>");
                                    }

                                    if (!(ctitle == null || ctitle.equals("null"))) {
                                        out.print("<td class=\"subject\"><a href=\"" + boardurl + "\"><strong>" + ctitle + "</strong></a>");
                                    } else {
                                        out.print("<td class=\"subject\"><a href=\"" + boardurl + "\"><strong>" + egovMap.get("schdulNm") + "</strong></a>");
                                    }

                                    out.print("<p>" + ((String) egovMap.get("schdulCn")).replace("\r\n", "<br />") + "</p>");

                                    if (schdulUrl != null) {
                                        out.print("<div><a href='##' onclick=\"javascript:openbannerLink('" + schdulUrl + "','" + schdulUrlTarget);
                                        out.print("')\"><img src='/usr/images/common/btn_go.gif' alt='View' /></a></div></td>");
                                    }
                                    out.print("</tr>");
                                }
                            } else {
                                out.print("<tr>");
                                out.print("<td  class='first' colspan=\"2\">No post schedule!</td>");
                                out.print("</tr>");
                            }
                        %>
                        </tbody>
                    </table>
                </fieldset>
            </div>
        </div>
        <%
            }
        %>
        <!-- 여기까지 ------------------------------------------------->
    </form>
</c:if>
<c:if test="${use_yn eq 'N'}">캘린더의 사용이 중지되었습니다. 관리자에게 문의하십시오. </c:if>
