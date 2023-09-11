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

<form name="deptSchdulManageVO" id="deptSchdulManageVO" action="" method="post">
<div class="content_wrap">
	<div class="m">
		<h3 class="tit_1">학사일정</h3>
		<p class="tit_1_txt">오산대학교의 학사일정 입니다</p>
	</div>
	<div class="calendar_ctrl">
		<div class="ctrl">
			<a href="?menuno=${param.menuno}&calendar_no=${calendar_no}&year=<%=year-1%>&amp;month=0" class="prev"><span><%=year-1%></span></a>
			<span class="now_year"><%=year%></span>
			<a href="?menuno=${param.menuno}&calendar_no=${calendar_no}&year=<%=year+1%>&amp;month=0" class="next"><span><%=year+1%></span></a>
		</div>
		<ol>
			<%
			for(int i = 0; i < 12; i++){
			%>
			<li <%if(month == i){%>class="on"<%}%>><a href="?menuno=${param.menuno}&calendar_no=${calendar_no}&year=<%=year%>&month=<%=i%>"><%=(i+1)%><span>월</span></a></li>
			<%
			}
			%>
		</ol>
	</div>

	<div class="major_schadule">
		<div class="calendar_wrap">
			<p class="calendar_head"><%=year%>. <%=month+1%></p>
			<table>
				<caption><%=year%>년 <%=month+1%>월 달력</caption>
				<colgroup>
					<col><col><col><col><col><col><col>
				</colgroup>
				<thead>
					<tr>
						<th scope="col">일</th>
						<th scope="col">월</th>
						<th scope="col">화</th>
						<th scope="col">수</th>
						<th scope="col">목</th>
						<th scope="col">금</th>
						<th scope="col">토</th>
					</tr>
				</thead>
				<tbody>
					<tr class="space">
						<td colspan="7"></td>
					</tr>
					<tr>
						 <%
		                    String bgcolor = "white";

		                    List listResult = (List) request.getAttribute("resultList");
		                    EgovMap egovMap = new EgovMap();
		//처음 빈공란 표시
		                    for (int index = 1; index < start; index++) {
		                        out.println("<td><span class='empty'></span></td>");
		                        newLine++;
		                    }

		                    for (int index = 1; index <= endDay; index++) {
		                        String color = "";

		                        if (newLine == 0) {
		                            color = "sun";
		                        } else if (newLine == 6) {
		                            color = "sat";
		                        } else {
		                            //color = "BLACK";
		                        }
		                        ;

		                        String sUseDate = Integer.toString(year);

		                        sUseDate += Integer.toString(month + 1).length() == 1 ? "0" + Integer.toString(month + 1) : Integer.toString(month + 1);
		                        sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index) : Integer.toString(index);

		                        int iUseDate = Integer.parseInt(sUseDate);

		//                        out.println("<TD valign='top' align='left' height='92px' width ='100px' bgcolor='" + bgcolor + "' break-word;>");
		                        out.println("<TD class='" + color + "'><a href='#none'>" + index + "</a>");

		                        //out.println("<font color='" + color + "'>" + index + "</font>");
		                        //out.println("<BR>");
			/*
			out.println(iUseDate);
			out.println("<BR>");
			*/

			//#############################################
		    //중간에 삭제 되었음 back 원본파일과 비교하기 바람.
			//#############################################



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
		                        out.println("<TD><span class='empty'></span></TD>");
		                        newLine++;
		                    }
		                %>



					</tr>

					<tr class="space">
						<td colspan="7"></td>
					</tr>


				</tbody>
			</table>
		</div>


		<%if (listResult != null) { %>
		<div class="schadule_wrap">
			<table>
				<caption>2017년 2월 주요일정</caption>
				<colgroup>
					<col class="col30 mcol45">
					<col>
				</colgroup>
				<body>

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
                                        out.print("<th scope='row'>"
                                                          //+ ((String) egovMap.get("schdulBgnde")).substring(0, 4)
                                                          + ((String) egovMap.get("schdulBgnde")).substring(4, 6)
                                                          + "." + ((String) egovMap.get("schdulBgnde")).substring(6, 8)
                                                          + " ~ "
                                                          //+ ((String) egovMap.get("schdulEndde")).substring(0, 4)
                                                          + ((String) egovMap.get("schdulEndde")).substring(4, 6)
                                                          + "." + ((String) egovMap.get("schdulEndde")).substring(6, 8)
                                                          + "</th>");
                                    } else {
                                        out.print("<th scope='row'>"
                                                          //+ ((String) egovMap.get("schdulBgnde")).substring(0, 4)
                                                          + ((String) egovMap.get("schdulBgnde")).substring(4, 6)
                                                          + "." + ((String) egovMap.get("schdulBgnde")).substring(6, 8)
                                                          + "</th>");
                                    }

                                    if (!(ctitle == null || ctitle.equals("null"))) {
                                        out.print("<td><a href=\"#none\" onclick=\"javascript:openbannerLink('" + schdulUrl + "','" + schdulUrlTarget+"')\"><strong>" + ctitle + "</strong></a>");
                                    } else {
                                        out.print("<td><a href=\"#none\" onclick=\"javascript:openbannerLink('" + schdulUrl + "','" + schdulUrlTarget+"')\"><strong>" + egovMap.get("schdulNm") + "</strong></a>");
                                    }

                                    out.print("<p>" + ((String) egovMap.get("schdulCn")).replace("\r\n", "<br />") + "</p>");

                                    if (schdulUrl != null) {
                                        //out.print("<div><a href='##' onclick=\"javascript:openbannerLink('" + schdulUrl + "','" + schdulUrlTarget);
                                        //out.print("')\"><img src='/usr/images/common/btn_go.gif' alt='View' /></a></div></td>");

                                    }
                                    out.print("</td></tr>");
                                }
                            } else {
                                out.print("<tr>");
                                out.print("<td colspan=\"2\" style='text-align: center;'>일정이 없습니다.</td>");
                                out.print("</tr>");
                            }
                        %>
			</tbody>
		</table>
	</div>
	<%} %>


</div>

    </form>
</c:if>
<c:if test="${use_yn eq 'N'}">캘린더의 사용이 중지되었습니다. 관리자에게 문의하십시오. </c:if>
