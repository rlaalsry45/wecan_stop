<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<jsp:include page="../../header.jsp" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
<%--
  Class Name : EgovDeptSchdulManageList.jsp
  Description : 부서일정관리 월별/주간별/일별 조회
  Modification Information

      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2008.03.09    장동한          최초 생성

    author   : 공통서비스 개발팀 장동한
    since    : 2009.03.09
--%>
            <%--
            <%@ page contentType="text/html; charset=utf-8"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
            <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
            <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
            --%>
            <c:set var="imgurl" value="/com/art/egovframework/com/cop/smt/sdm/" />
            <c:set var="cssurl" value="/com/css/egovframework/com/cop/smt/sdm/" />
            <style type="text/css">
                h1 {
                    font-size: 12px;
                }
                caption {
                    visibility: hidden;
                    font-size: 0;
                    height: 0;
                    margin: 0;
                    padding: 0;
                    line-height: 0;
                }
            </style>

            <meta http-equiv="content-type" content="text/html; charset=utf-8">
            <link type="text/css" rel="stylesheet" href="<c:url value='/com/css/egovframework/com/cmm/com.css'/>">
            <script type="text/javaScript" language="javascript">
                /* ********************************************************
                 * 등록 처리 함수
                 ******************************************************** */
                $(function() {
                    select_tab_menu(0);
                    //do_resize();
                });

                function select_tab_menu(oa) {
                    /*
                    document.getElementById("tabMenu0").bgColor = '#DDDDDD';
                    document.getElementById("tabMenu1").bgColor = '#DDDDDD';
                    document.getElementById("tabMenu2").bgColor = '#DDDDDD';

                    if (oa == 0) {
                        document.getElementById("schedule").src = "<c:url value='/admsys/module/schdule/SchdulManageMonthList.html' />";
                        document.getElementById("tabMenu0").bgColor = '#BBBBBB';
                    } else if (oa == 1) {
                        document.getElementById("schedule").src = "<c:url value='/admsys/module/schdule/SchdulManageWeekList.html' />";
                        document.getElementById("tabMenu1").bgColor = '#BBBBBB';
                    } else if (oa == 2) {
                        document.getElementById("schedule").src = "<c:url value='/admsys/module/schdule/SchdulManageDailyList.html' />";
                        document.getElementById("tabMenu2").bgColor = '#BBBBBB';
                    }
                    */
                    //do_resize();
                }

                /* ********************************************************
                 * IFRAME AUTO HEIGHT
                 ******************************************************** */
                function do_resize() {
                  //resize_frame("iframe_main",1);
                    resize_frame("schedule", 1);
                }

                function resize_frame(id, re) {
                    //가로길이는 유동적인 경우가 드물기 때문에 주석처리!
                    var ifr = document.getElementById(id);
                    var innerBody = ifr.contentWindow.document.body;
                    var innerHeight = innerBody.scrollHeight + (innerBody.offsetHeight - innerBody.clientHeight);
                  //var innerWidth = document.body.scrollWidth + (document.body.offsetWidth - document.body.clientWidth);

                    // console.log("+ resize frame : " + id);
                    // console.log("  - scroll height = " + innerBody.scrollHeight);
                    // console.log("  - offset height = " + innerBody.offsetHeight);
                    // console.log("  - client height = " + innerBody.clientHeight);
                    // console.log("  - inner  height = " + innerHeight);
                    // console.log("  - style  height = " + ifr.style.height);

                    //주석제거시 다음 구문으로 교체 ->
                    //if (ifr.style.height != innerHeight || ifr.style.width != innerWidth) {}
                    if (ifr.style.height != innerHeight) {
                        ifr.style.height = innerHeight;
                        //ifr.style.width = innerWidth;
                        //ifr.zattrs['height'] = innerHeight;
                        //ifr.setAttribute("height",innerHeight);
                    }

                    if (!re) {
                        try {
                            innerBody.attachEvent('onclick', parent.do_resize);
                            innerBody.attachEvent('onkeyup', parent.do_resize);
                            //글작성 상황에서 클릭없이 타이핑하면서 창이 늘어나는 상황이면 윗줄 주석제거
                        } catch (e) {
                            innerBody.addEventListener("click", parent.do_resize, false);
                            innerBody.addEventListener("keyup", parent.do_resize, false);
                            //글작성 상황에서 클릭없이 타이핑하면서 창이 늘어나는 상황이면 윗줄 주석제거
                        }
                    }
                }

                // iframe resize
                function auto_resize(obj) {
                    obj.height = obj.contentWindow.document.body.scrollHeight + 20;
                    //console.log("+ auto_resize - height : " + obj.height);
                }
            </script>

            <div id="contents">
                <div class="contants_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a>
                        <a href="/admsys/module/schdule/SchdulManageList.html">스케줄로 이동</a>
                        <strong>일정관리</strong>
                    </div>
                    <!--/location-->
                </div>
                <div id="content">
                    <ul class="homepagebbs">
                        <li class="bg"><h3 class="sub">행사캘린더</h3></li>
                        <li>
                            <!--
                            <table border="0" cellspacing="0" cellpadding="0"
                                summary="월별일정보기,주간별일정보기,일별일정보기 입니다.">
                                <tr>
                                    <td height="20px" width="100px" bgcolor="#DDDDDD"
                                        style="cursor: hand; cursor: pointer;" align="center"
                                        id="tabMenu0"><a
                                        href="<c:url value='/admsys/module/schdule/SchdulManageMonthList.html' />"
                                        target="schedule" onClick="select_tab_menu(0);"><b>월별일정보기</b></a></td>
                                    <td height="20px" width="1x" bgcolor="#FFFFFF"></td>
                                    <td height="20px" width="100px" bgcolor="#DDDDDD"
                                        style="cursor: hand; cursor: pointer;" align="center"
                                        id="tabMenu1"><a
                                        href="<c:url value='/admsys/module/schdule/SchdulManageWeekList.html' />"
                                        target="schedule" onClick="select_tab_menu(1);"><b>주간별일정보기</b></a></td>
                                    <td height="20px" width="1x" bgcolor="#FFFFFF"></td>
                                    <td height="20px" width="100px"
                                        style="cursor: hand; cursor: pointer;" bgcolor="#DDDDDD"
                                        align="center" id="tabMenu2"><a
                                        href="<c:url value='/admsys/module/schdule/SchdulManageDailyList.html' />"
                                        target="schedule" onClick="select_tab_menu(2);"><b>일별일정보기</b></a></td>
                                    <td height="20px" width="1x" bgcolor="#FFFFFF"></td>
                                </tr>
                            </table>
                            <table border="0" cellspacing="0" cellpadding="0" width="100%">
                                <tr>
                                    <td height="3" bgcolor="DDDDDD"></td>
                                </tr>
                            </table>
                            -->
                            <div class="calendar">
                                <iframe id="schedule" name="schedule"
                                    src="/admsys/module/schdule/SchdulManageMonthList.html?calendar_no=<%=(String)request.getParameter("calendar_no") %>" frameborder="0" scrolling="no" marginwidth="0" onload="auto_resize(this)"
                                    marginheight="0" title="부서일정" style="width:100% !important;">
                                </iframe>
                                <form name="deptSchdulManageVO" id="deptSchdulManageVO" action="?" method="post" style="width:100%;">
                                    <input type="hidden" name="schdulId" id="schdulId" value="" />
                                    <input type="hidden" name="schdulBgnde" id="schdulBgnde" value="" />
                                    <input type="hidden" name="schdulEndde" id="schdulEndde" value="" />
                                    <input type="hidden" name="calendar_no" id="calendar_no" value="<%=(String)request.getParameter("calendar_no") %>" />
                                    <div style="visibility: hidden; display: none;">
                                        <input name="iptSubmit" type="submit" value="전송" title="전송">
                                    </div>
                                </form>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
<jsp:include page="../../end.jsp" flush="false" />
