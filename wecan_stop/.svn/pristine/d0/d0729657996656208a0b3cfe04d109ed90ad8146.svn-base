<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="egovframework.rte.psl.dataaccess.util.EgovMap" %>
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
%>

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

<c:if test="${use_yn eq 'Y'}">


<div class="schadule_wrap">
	<h3><strong>DBCAS</strong>일정관리</h3>
	<a href="?menuno=221" class="more"><span>더보기</span></a>
	<div class="schadule_data">
		<p class="date"><%=year%><strong>년</strong><br><%=month + 1%><strong>월</strong></p>
			<%
            List listResult = (List) request.getAttribute("resultList");
            EgovMap egovMap = new EgovMap();

            out.print("<ul>");
            if (listResult.size() > 0) {
                for (int i = 0; i < 6; i++) {
                    egovMap = (EgovMap) listResult.get(i);

//                    int    iBeginDate      = Integer.parseInt(((String) egovMap.get("schdulBgnde")).substring(0, 8));
//                    int    iBeginEnd       = Integer.parseInt(((String) egovMap.get("schdulEndde")).substring(0, 8));
                    String schdulUrl       = (String) egovMap.get("schdulurl");
                    String schdulUrlTarget = (String) egovMap.get("schdulurltarget");
                    String ctitle          = (String) egovMap.get("ctitle");
                    Object boardurl        = egovMap.get("url");

                    /* 날자별로 일정이 박혀야 할경우 아래 조건절 사용
                       if(iUseDate >= iBeginDate && iUseDate <= iBeginEnd) */
                    //해당날자만 나와야 할경우 아래선택


                    out.print("<li><span class=\"period\">");
                    if (!(egovMap.get("schdulBgnde").equals(egovMap.get("schdulEndde")))) {
                    	 out.print(
                                          //+ ((String) egovMap.get("schdulBgnde")).substring(0, 4)
                                          ((String) egovMap.get("schdulBgnde")).substring(4, 6)
                                          + "." + ((String) egovMap.get("schdulBgnde")).substring(6, 8)
                                          + " ~ "
                                          //+ ((String) egovMap.get("schdulEndde")).substring(0, 4)
                                          + ((String) egovMap.get("schdulEndde")).substring(4, 6)
                                          + "." + ((String) egovMap.get("schdulEndde")).substring(6, 8));
                    } else {
                    	 out.print(
                                          //+ ((String) egovMap.get("schdulBgnde")).substring(0, 4)
                                          ((String) egovMap.get("schdulBgnde")).substring(4, 6)
                                          + "." + ((String) egovMap.get("schdulBgnde")).substring(6, 8));
                    }
                    out.print("</span>");

                    if (!(ctitle == null || ctitle.equals("null"))) {
                        out.print("<span class=\"sbj\">" + ctitle + "</span>");
                    } else {
                        out.print("<span class=\"sbj\">" + egovMap.get("schdulNm") + "</span>");
                    }

                    //out.print("<p>" + ((String) egovMap.get("schdulCn")).replace("\r\n", "<br />") + "</p>");

                    if (schdulUrl != null) {
                        //out.print("<div><a href='##' onclick=\"javascript:openbannerLink('" + schdulUrl + "','" + schdulUrlTarget);
                        //out.print("')\"><img src='/usr/images/common/btn_go.gif' alt='View' /></a></div></td>");

                    }
                    out.print("</li>");

                    if(i == 2) out.print("</ul><ul>");

                }
            } else {
                out.print("<li><span class=\"period\">&nbsp;</span><span class=\"sbj\">일정이 없습니다.</span></li>");
                out.print("<li><span class=\"period\">&nbsp;</span><span class=\"sbj\">&nbsp;</span></li>");
                out.print("<li><span class=\"period\">&nbsp;</span><span class=\"sbj\">&nbsp;</span></li>");
            }

            out.print("</ul>");
            %>
			<!-- <li>
				<span class="period">07.17 ~ 08.11</span>
				<span class="sbj">하계 계절학기 개설</span>
			</li>
			<li>
				<span class="period">08.01 ~ 08.15</span>
				<span class="sbj">2학기 복학 신청</span>
			</li>
			<li>
				<span class="period">08.07 ~ 08.11</span>
				<span class="sbj">2학기 전과, 재입학 신청</span>
			</li>
		</ul>
		<ul>
			 <li>
				<span class="period">08. 09 ~ 08.11</span>
				<span class="sbj">2학기 학기포기 신청</span>
			</li>
			<li>
				<span class="period">08.16 ~ 08.17</span>
				<span class="sbj">2학기 장애학생 수강신청</span>
			</li>
			<li>
				<span class="period">08.21 ~ 08.25</span>
				<span class="sbj">2학기 등록</span>
			</li>
		</ul>-->
	</div>
</div>
</c:if>

