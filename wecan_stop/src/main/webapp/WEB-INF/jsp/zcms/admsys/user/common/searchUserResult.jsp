<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.z5.zcms.admsys.user.domain.ZUserVo" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css'/>
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<script type="text/javascript">

    function userCommit(userid) {
        if (confirm("해당 유저를 강제로 인증하시겠습니까?")) {
            $.ajax({
                type     : 'post'
                , async  : true
                , url    : '/admsys/user/common/usercommit.html'
                , data   : "userid=" + userid
                , success: function (data) {
                    alert("인증되었습니다.");
                    window.location.reload();
                }
                , error  : function (data, status, err) {
                    alert('서버와의 통신이 실패했습니다.');
                }
            });
        }
    }

    function userCommitForStudent(userid, userno, username, useremail, re) {
        //alert("userid="+userid+"&userno="+userno+"&username="+username+"&useremail="+useremail);
        if (re == "re") msg = "해당 유저의  준회원기간을 1년더 연장하시겠습니까?";
        else          msg = "해당 유저를 준회원으로 인증하시겠습니까?";
        if (confirm(msg)) {
            $.ajax({
                type     : 'post'
                , async  : true
                , url    : '/admsys/user/common/userCommitForStudent.html'
                , data   : "userid=" + userid + "&userno=" + userno + "&username=" + username + "&useremail=" + useremail
                , success: function (data) {
                    alert("인증되었습니다.");
                    window.location.reload();
                }
                , error  : function (data, status, err) {
                    alert('서버와의 통신이 실패했습니다.');
                }
            });
        }
    }


    function payedlist(userid, userno) {
        var url          = "/admin/dues/payedlist/index.html?userno=" + userno + "&userid=" + userid;
        var windowName   = "payedlist";
        var windowWidth  = 1000;
        var windowHeight = 600;
        var windowLeft   = parseInt((screen.availWidth / 2) - (windowWidth / 2));
        var windowTop    = parseInt((screen.availHeight / 2) - (windowHeight / 2));
        var windowSize   = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
        window.open(url, windowName, windowSize);
    }

    function work_grade_change(userid, userno) {
        var url          = "/admsys/dues/work_grade_change.html?userno=" + userno + "&userid=" + userid;
        var windowName   = "payedlist";
        var windowWidth  = 1000;
        var windowHeight = 600;
        var windowLeft   = parseInt((screen.availWidth / 2) - (windowWidth / 2));
        var windowTop    = parseInt((screen.availHeight / 2) - (windowHeight / 2));
        var windowSize   = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
        window.open(url, windowName, windowSize);
    }

    function userPassInit(userno) {
        if (confirm("해당 유저의 비밀번호가 1234로 강제로 초기화 됩니다.\n실행하시겠습니까?")) {
            $.ajax({
                type     : 'post'
                , async  : true
                , url    : '/admsys/user/common/userPassInit.html'
                , data   : "userno=" + userno
                , success: function (data) {
                    alert("해당유저의 비밀번호가 초기화 되었습니다. .");
                    window.location.reload();
                }
                , error  : function (data, status, err) {
                    alert('서버와의 통신이 실패했습니다.');
                }
            });
        }
    }
    /* function annualPauseStop(userno,duesno){
     if(confirm("회원중지상태를 활성화 상태로 변경하시겠습니까?")){
     $.ajax({
     type: 'post'
     , async: true
     , url: '/admsys/dues/annualPauseStop/index.html'
     , data: "userno="+userno+"&duesno="+duesno
     , success: function(data) {
     if(data == '1'){
     alert("해당유저의 회원상태가 활성화 되었습니다.");
     }else{
     alert("관리자 권한이 아니거나 오류가 있습니다. 관리자에게 문의하세요");
     }
     window.location.reload();
     }
     , error: function(data, status, err) {
     alert('서버와의 통신이 실패했습니다.');
     }
     });
     }
     } */

    function sort(type, sort) {

        $("#sortName").val(type); //정렬 타입
        $("#sort").val(sort); //정렬
        var form = document.frm;
        form.submit();

    }

    function sendAllMail() {

        if (confirm("검색된 회원전체에게 메일을 발송하시겠습니까?")) {

            $("#act").val("search_all");

            window.open("", "sendAllMail", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=920, height=700");
            document.frm.action = "/admsys/mail/popupSendMail.html";
            document.frm.target = "sendAllMail";
            document.frm.submit();
            document.frm.target = "";
        }


    }

    function sendChkMail() {

        if ($(":checkbox[name='userno']:checked").length == 0) {
            alert("메일 보낼 회원을 체크해주세요. ");
        } else {

            if (confirm("체크된 회원에게 메일을 발송하시겠습니까?")) {

                var userno = "";

                $("input:checkbox[name='userno']").each(function () {
                    if ($(this).is(":checked") == true) {
                        if ($(this).val() != "undefined") {
                            if (userno != "")
                                userno += "," + $(this).val();
                            else
                                userno = $(this).val();
                        }
                    }
                });

                $("#chk_userno").val(userno);
                $("#act").val("search_chk");

                window.open("", "updateExam", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=920, height=700");
                document.frm.action = "/admsys/mail/popupSendMail.html";
                document.frm.target = "updateExam";
                document.frm.submit();
                document.frm.target = "";

            }
        }

    }


    function excelAll() {

        if (confirm("검색된 회원전체의 엑셀을 다운로드하시겠습니까?")) {

            $("#act").val("search_excel_all");

            window.open("", "excelAll", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=10, height=10");
            document.frm.action = "/admsys/user/common/popupExcel.html";
            document.frm.target = "excelAll";
            document.frm.submit();
            document.frm.target = "";
            document.frm.target = "";
        }

    }

    function excelChk(obj) {
        if ($(":checkbox[name='userno']:checked").length == 0) {
            alert("다운받을 엑셀의 회원을 체크해주세요. ");
        } else {

            if (confirm("체크된 회원의 엑셀을 다운로드하시겠습니까?")) {

                var userno = "";

                $("input:checkbox[name='userno']").each(function () {
                    if ($(this).is(":checked") == true) {
                        if ($(this).val() != "undefined") {
                            if (userno != "")
                                userno += "," + $(this).val();
                            else
                                userno = $(this).val();
                        }
                    }
                });

                $("#chk_userno").val(userno);
                $("#act").val("search_excel_chk");

                window.open("", "excelAll", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=10, height=10");
                document.frm.action = "/admsys/user/common/popupExcel.html";
                document.frm.target = "excelAll";
                document.frm.submit();
                document.frm.target = "";
                document.frm.target = "";
            }
        }
    }

</script>

<div id="container">
    <jsp:include page="../../lnb.jsp" flush="true"/>
    <div id="r_side">
        <div class="cont_top">
            <div class="location">
                <p>
                    <a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
                    &gt;
                    <a href="/admsys/user/common/" title="회원관리로 이동">회원다중검색</a>
                    &gt;
                    <span>회원목록</span>
                </p>
            </div><!--/location-->
        </div><!--/cont_top-->
        <!--내용-->

        <form:form name="frm" method="post" modelAttribute="searchUser">
            <input type="hidden" name="act" id="act"/>
            <input type="hidden" name="chk_userno" id="chk_userno"/>
            <input type="hidden" name="totalCnt" id="totalCnt" value="${input.total }"/>
            <%-- <input type="hidden" name="all_userno" value="<c:forEach items="${list}" var="data" varStatus="status">${data.userno }<c:if test="${status.count ne fn:length(list) }">,</c:if></c:forEach>"/> --%>
            <input type="hidden" name="excel_val"/>

            <input type="hidden" name="column" value="${column}">
            <input type="hidden" name="userno" value="${searchUser.userno}">
            <input type="hidden" name="useridx" value="${searchUser.useridx}">
            <input type="hidden" name="userid" value="${searchUser.userid}">
            <input type="hidden" name="username" value="${searchUser.username}">
            <input type="hidden" name="username2" value="${searchUser.username2}">
            <input type="hidden" name="work_grade" value="${searchUser.work_grade}">
            <input type="hidden" name="usersex" value="${searchUser.usersex}">
            <input type="hidden" name="useroutrequest" value="${searchUser.useroutrequest}">
            <input type="hidden" name="dept_nm" value="${searchUser.dept_nm}">
            <input type="hidden" name="dept_full_nm" value="${searchUser.dept_full_nm}">
            <input type="hidden" name="userdatereg" value="${searchUser.userdatereg}">
            <input type="hidden" name="userbirth" value="${searchUser.userbirth}">
            <input type="hidden" name="useraddrno" value="${searchUser.useraddrno}">
            <input type="hidden" name="useremail" value="${searchUser.useremail}">
            <input type="hidden" name="usermobile" value="${searchUser.usermobile}">
            <input type="hidden" name="useraddr" value="${searchUser.useraddr}">
            <input type="hidden" name="branch" value="${searchUser.branch}">
            <input type="hidden" name="usercname" value="${searchUser.usercname}">
            <input type="hidden" name="postuserselect" value="${searchUser.postuserselect}">
            <input type="hidden" name="usercompanystatus" value="${searchUser.usercompanystatus}">
            <input type="hidden" name="usercaddrno" value="${searchUser.usercaddrno}">
            <input type="hidden" name="usercaddr" value="${searchUser.usercaddr}">
            <input type="hidden" name="nominator" value="${searchUser.nominator}">
            <input type="hidden" name="lasteducation" value="${searchUser.lasteducation}">
            <input type="hidden" name="annualpause" value="${searchUser.annualpause}">
            <input type="hidden" name="semimemberconfirm" value="${searchUser.semimemberconfirm}">
            <input type="hidden" name="graduation0" value="${searchUser.graduation0}">
            <input type="hidden" name="university0" value="${searchUser.university0}">
            <input type="hidden" name="major0" value="${searchUser.major0}">
            <input type="hidden" name="graduation1" value="${searchUser.graduation1}">
            <input type="hidden" name="university1" value="${searchUser.university1}">
            <input type="hidden" name="graduation2" value="${searchUser.graduation2}">
            <input type="hidden" name="university2" value="${searchUser.university2}">
            <input type="hidden" name="major2" value="${searchUser.major2}">
            <input type="hidden" name="cond4" value="${searchUser.cond4}">
            <input type="hidden" name="cond5" value="${searchUser.cond5}">
            <input type="hidden" name="searchtype" value="${searchUser.searchtype}">
            <input type="hidden" name="keyword" value="${searchUser.keyword}">
            <input type="hidden" name="usernostart" value="${searchUser.usernostart}">
            <input type="hidden" name="usernoend" value="${searchUser.usernoend}">
            <input type="hidden" name="sdatetype" value="${searchUser.sdatetype}">
            <input type="hidden" name="sdateys" value="${searchUser.sdateys}">
            <input type="hidden" name="sdatems" value="${searchUser.sdatems}">
            <input type="hidden" name="sdateds" value="${searchUser.sdateds}">
            <input type="hidden" name="sdateye" value="${searchUser.sdateye}">
            <input type="hidden" name="sdateme" value="${searchUser.sdateme}">
            <input type="hidden" name="sdatede" value="${searchUser.sdatede}">
            <input type="hidden" name="st_sec1" value="${searchUser.st_sec1}">
            <input type="hidden" name="st_sec2" value="${searchUser.st_sec2}">
            <input type="hidden" name="st_sec3" value="${searchUser.st_sec3}">
            <input type="hidden" name="st_sec4" value="${searchUser.st_sec4}">
            <input type="hidden" name="st_sec5" value="${searchUser.st_sec5}">
            <input type="hidden" name="st_sec6" value="${searchUser.st_sec6}">
            <input type="hidden" name="sc_sec1_val" value="${searchUser.sc_sec1_val}">
            <input type="hidden" name="sd_sec1" value="${searchUser.sd_sec1}">
            <input type="hidden" name="sc_sec2_val" value="${searchUser.sc_sec2_val}">
            <input type="hidden" name="sd_sec2" value="${searchUser.sd_sec2}">
            <input type="hidden" name="workplace" value="${searchUser.workplace}">
            <input type="hidden" name="sc_sec4_val" value="${searchUser.sc_sec4_val}">
            <input type="hidden" name="sd_sec4" value="${searchUser.sd_sec4}">
            <input type="hidden" name="executive" value="${searchUser.executive}">
            <input type="hidden" name="sc_sec5_val" value="${searchUser.sc_sec5_val}">
            <input type="hidden" name="sd_sec5" value="${searchUser.sd_sec5}">
            <input type="hidden" name="committee" value="${searchUser.committee}">
            <input type="hidden" name="sc_sec11_val" value="${searchUser.sc_sec11_val}">
            <input type="hidden" name="sd_sec11" value="${searchUser.sd_sec11}">
            <input type="hidden" name="sc_sec12_val" value="${searchUser.sc_sec12_val}">
            <input type="hidden" name="sd_sec12" value="${searchUser.sd_sec12}">
            <input type="hidden" name="groupuser" value="${searchUser.groupuser}">
            <input type="hidden" name="paytype" value="${searchUser.paytype}">
            <input type="hidden" name="postal" value="${searchUser.postal}">
            <input type="hidden" name="university" value="${searchUser.university}">
            <input type="hidden" name="duetype" value="${searchUser.duetype}">
            <input type="hidden" name="duestart" value="${searchUser.duestart}">
            <input type="hidden" name="dueend" value="${searchUser.dueend}">
            <input type="hidden" name="duepaytype" value="${searchUser.duepaytype}">


            <%-- <div class="search">
                <div class="srch_right">
                    <ul>
                        <li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
                        <li class="srch_right_left">
                            <select name="cond1">
                                <option value="userdatereg" <c:if test="${input.cond1=='userdatereg'}"><c:out value='selected' /></c:if>>등록일</option>
                                <option value="userdatemod" <c:if test="${input.cond1=='userdatemod'}"><c:out value='selected' /></c:if>>수정일</option>
                            </select>
                            <input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" />
                            ~
                            <input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" />
                            <select name="cond2" id="cond2">
                                <option value="usertype" <c:if test="${input.cond2=='usertype'}"><c:out value='selected' /></c:if>>분류</option>
                                <option value="userid" <c:if test="${input.cond2=='userid'}"><c:out value='selected' /></c:if>>아이디</option>
                                <option value="username" <c:if test="${input.cond2=='username'}"><c:out value='selected' /></c:if>>이름</option>
                                <option value="userno" <c:if test="${input.cond2=='userno'}"><c:out value='selected' /></c:if>>회원번호</option>
                                <option value="userdatereg" <c:if test="${input.cond2=='userdatereg'}"><c:out value='selected' /></c:if>>입회일</option>
                                <option value="total" <c:if test="${input.cond2=='total'}"><c:out value='selected' /></c:if>>전체</option>
                                <option value="userno" <c:if test="${input.cond2=='userno'}"><c:out value='selected' /></c:if>>지회</option>
                                <option value="usersite" <c:if test="${input.cond2=='usersite'}"><c:out value='selected' /></c:if>>관리사이트</option>
                            </select>
                            <input type=text name="keyword" id="keyword" value="<c:out value='${input.keyword}' />" />
                            <input type=text name="keyword" id="keyword2" value="<c:out value='${input.keyword}' />" disabled="disabled" style="display:none"/>
                            <select name="work_grade">
                                <option value="" <c:if test="${input.work_grade==''}"><c:out value='selected' /></c:if>>회원구분</option>
                                <option value="1" <c:if test="${input.work_grade=='1'}"><c:out value='selected' /></c:if>>정회원</option>
                                <option value="2" <c:if test="${input.work_grade=='2'}"><c:out value='selected' /></c:if>>종신회원</option>
                                <option value="3" <c:if test="${input.work_grade=='3'}"><c:out value='selected' /></c:if>>준회원</option>
                                <option value="6" <c:if test="${input.work_grade=='6'}"><c:out value='selected' /></c:if>>외부심사위원</option>
                            </select>
                            목록<input type="text" style="width:20px;"name="pageSize" value="<c:out value='${input.pageSize}' />" />
                        </li>
                        <li class="srch_btn_go">
                            <input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
                        </li>
                    </ul>
                </div><!--/srch_right-->
            </div><!--/search--> --%>
            <div class="page_title" style="padding:10px 0px 0px 10px;">
                <h3>
                    다중검색<img src="/cms/image/tit_user_list.jpg" alt="회원목록"/>&nbsp;Total : ${input.total}(${pageIndex} / ${input.pageMax})&nbsp;
                </h3>
            </div>
            <div id="content">
                <div class="main_btn">
                    <ul>
                        <li>
                            <a href="javascript:checkAll(true,'userno');"><img alt="전체선택" src="/cms/image/common_btn_selall.jpg"/></a>
                        </li>
                        <li>
                            <a href="javascript:checkAll(false,'userno');"><img alt="선택해제" src="/cms/image/common_btn_release.jpg"/></a>
                        </li>
                        <li>
                            <a href="javascript:del('userno');"><img alt="삭제" src="/cms/image/common_btn_del.jpg"/></a>
                        </li>
                    </ul>
                    <ul class="site_register">
                        <li>
                            <div class="btn-c05" style="margin-top:0;">
                                <a href="javascript:sendAllMail()" class="gray" style="padding:7px 15px; font-size:12px;">검색된회원 전체메일발송</a>
                            </div>
                        </li>
                        <li>
                            <div class="btn-c05" style="margin-top:0;">
                                <a href="javascript:sendChkMail()" class="gray" style="padding:7px 15px; font-size:12px;">체크된회원 메일발송</a>
                            </div>
                        </li>
                        <li>
                            <div class="btn-c05" style="margin-top:0;">
                                <a href="javascript:excelAll()" class="gray" style="padding:7px 15px; font-size:12px;">검색된회원 전체엑셀다운로드</a>
                            </div>
                        </li>
                        <li>
                            <div class="btn-c05" style="margin-top:0;">
                                <a href="javascript:excelChk()" class="gray" style="padding:7px 15px; font-size:12px;">체크된회원 엑셀다운로드</a>
                            </div>
                        </li>
                        <!-- <li>
                            <a href="javascript:excel()"><img alt="엑셀로 저장" src="/cms/image/btn_save_xls.jpg" /></a>
                        </li> -->
                    </ul>
                </div><!--/main_btn-->
                <div class="main_table" style="width:100%;height:100%;overflow:auto">
                    <!---게시판 영역------------------------->
                    <table id="main_table" class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="회원리스트">
                        <caption>회원리스트</caption>
                        <colgroup>
                            <!-- <col width="2%" />
                            <col width="7%" />
                            <col width="13%" />
                            <col width="8%" />
                            <col width="" />
                            <col width="7%" />
                            <col width="7%" />
                            <col width="7%" />
                            <col width="6%" />
                            <col width="7%" />
                            <col width="7%" />
                            <col width="6%" />
                            <col width="7%" /> -->

                        </colgroup>
                        <thead>
                        <tr>
                            <th><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','userno')"/></th>
                            <th>회원번호</th>
                            <c:if test='${fn:contains(column,"01")}'>
                                <th>ID</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"02")}'>
                                <th>한글이름</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"03")}'>
                                <th>영문이름</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"04")}'>
                                <th>한문이름</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"05")}'>
                                <th>생년월일</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"06")}'>
                                <th>이메일</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"07")}'>
                                <th>우편물수령</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"08")}'>
                                <th>핸드폰</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"10")}'>
                                <th>지회</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"11")}'>
                                <th>입회날짜</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"12")}'>
                                <th>자택주소</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"13")}'>
                                <th>자택우편번호</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"14")}'>
                                <th>자택전화번호</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"15")}'>
                                <th>직장명</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"16")}'>
                                <th>부서</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"17")}'>
                                <th>직책</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"18")}'>
                                <th>회사주소</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"19")}'>
                                <th>회사우편번호</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"20")}'>
                                <th>회사전화번호</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"21")}'>
                                <th>회사FAX</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"22")}'>
                                <th>받을곳 우편번호</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"23")}'>
                                <th>받을곳 주소</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"42")}'>
                                <th>받을곳 상세주소</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"24")}'>
                                <th>회원종류</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"25")}'>
                                <th>임원</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"26")}'>
                                <th>위원회</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"27")}'>
                                <th>학사졸업연도</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"28")}'>
                                <th>학사학교</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"29")}'>
                                <th>학사학과</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"30")}'>
                                <th>석사졸업연도</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"31")}'>
                                <th>석사학교</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"32")}'>
                                <th>석사학과</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"33")}'>
                                <th>박사졸업연도</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"34")}'>
                                <th>박사박교</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"35")}'>
                                <th>박사학과</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"36")}'>
                                <th>최종학력</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"37")}'>
                                <th>직종</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"38")}'>
                                <th>추천인</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"39")}'>
                                <th>납부방법</th>
                            </c:if>
                            <c:if test='${fn:contains(column,"50")}'>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2000")}'>
                                    <th>연회비2000</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2001")}'>
                                    <th>연회비2001</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2002")}'>
                                    <th>연회비2002</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2003")}'>
                                    <th>연회비2003</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2004")}'>
                                    <th>연회비2004</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2005")}'>
                                    <th>연회비2005</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2006")}'>
                                    <th>연회비2006</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2007")}'>
                                    <th>연회비2007</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2008")}'>
                                    <th>연회비2008</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2009")}'>
                                    <th>연회비2009</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2010")}'>
                                    <th>연회비2010</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2011")}'>
                                    <th>연회비2011</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2012")}'>
                                    <th>연회비2012</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2013")}'>
                                    <th>연회비2013</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2014")}'>
                                    <th>연회비2014</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2015")}'>
                                    <th>연회비2015</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2016")}'>
                                    <th>연회비2016</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2017")}'>
                                    <th>연회비2017</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2018")}'>
                                    <th>연회비2018</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2019")}'>
                                    <th>연회비2019</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"d2020")}'>
                                    <th>연회비2020</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2000")}'>
                                    <th>임원2000</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2001")}'>
                                    <th>임원2001</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2002")}'>
                                    <th>임원2002</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2003")}'>
                                    <th>임원2003</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2004")}'>
                                    <th>임원2004</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2005")}'>
                                    <th>임원2005</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2006")}'>
                                    <th>임원2006</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2007")}'>
                                    <th>임원2007</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2008")}'>
                                    <th>임원2008</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2009")}'>
                                    <th>임원2009</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2010")}'>
                                    <th>임원2010</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2011")}'>
                                    <th>임원2011</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2012")}'>
                                    <th>임원2012</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2013")}'>
                                    <th>임원2013</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2014")}'>
                                    <th>임원2014</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2015")}'>
                                    <th>임원2015</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2016")}'>
                                    <th>임원2016</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2017")}'>
                                    <th>임원2017</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2018")}'>
                                    <th>임원2018</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2019")}'>
                                    <th>임원2019</th>
                                </c:if>
                                <c:if test='${fn:contains(searchUser.dueyear,"e2020")}'>
                                    <th>임원2020</th>
                                </c:if>
                            </c:if>


                                <%-- <th><a href="javascript:sort('userno','${userSort }')">회원번호<c:if test="${userSort eq 'asc'}">↓</c:if><c:if test="${userSort eq 'desc'}">↑</c:if></a></th>
                                <th><a href="javascript:sort('userid','${idSort }')">아이디<c:if test="${idSort eq 'asc'}">↓</c:if><c:if test="${idSort eq 'desc'}">↑</c:if></a></th>
                                <th><a href="javascript:sort('username','${nameSort }')">이름<c:if test="${nameSort eq 'asc'}">↓</c:if><c:if test="${nameSort eq 'desc'}">↑</c:if></a></th>
                                <th>직장명</th>
                                <th>회원구분(변경)</th>
                                <th>회원기간<br />(납부내역)</th>
                                <th>인증여부</th>
                                <th>중지상태</th>
                                <th>입회일</th>
                                <th>탈퇴신청</th>
                                <th>메일수신</th> --%>
                            <th>유저관리</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="each" varStatus="loop">
                            <tr>
                                <td><input class="bor_none" name="userno" value="${each.userno}" type="checkbox"/></td>
                                    <%-- <td><c:out value='${data.userno}' /></td> --%>
                                <!-- 표현하는 번호를 userno -> useridx로 변경 -->
                                <td><c:out value='${each.useridx}'/></td>
                                <c:if test='${fn:contains(column,"01")}'>
                                    <td>${each.userid}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"02")}'>
                                    <td>${each.username}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"03")}'>
                                    <td>${each.username2}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"04")}'>
                                    <td>${each.usercname}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"05")}'>
                                    <td>
                                        <c:if test="${fn:length(fn:trim(each.userbirth))  eq 8}">
                                            ${fn:substring(each.userbirth,0,4) }년${fn:substring(each.userbirth,4,6) }월${fn:substring(each.userbirth,6,8) }일
                                        </c:if>
                                        <c:if test="${fn:length(fn:trim(each.userbirth))  eq 6}">
                                            19${fn:substring(each.userbirth,0,4) }년${fn:substring(each.userbirth,4,6) }월${fn:substring(each.userbirth,6,8) }일
                                        </c:if>
                                    </td>
                                </c:if>
                                <c:if test='${fn:contains(column,"06")}'>
                                    <td>${each.useremail}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"07")}'>
                                    <td>
                                        <c:if test="${each.postuserselect  eq '1'}">
                                            자택
                                        </c:if>
                                        <c:if test="${each.postuserselect  eq '2'}">
                                            소속
                                        </c:if>
                                    </td>
                                </c:if>
                                <c:if test='${fn:contains(column,"08")}'>
                                    <td>${each.usermobile}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"10")}'>
                                    <td>
                                        <c:if test="${each.branch eq '1'}">부산울산경남지회</c:if>
                                        <c:if test="${each.branch eq '2'}">대구경북지회</c:if>
                                        <c:if test="${each.branch eq '3'}">강원지회</c:if>
                                        <c:if test="${each.branch eq '4'}">광주전남지회</c:if>
                                        <c:if test="${each.branch eq '5'}">대전세종충청지회</c:if>
                                        <c:if test="${each.branch eq '6'}">전라북도지회</c:if>
                                        <c:if test="${each.branch eq '7'}">제주지회</c:if>
                                    </td>
                                </c:if>
                                <c:if test='${fn:contains(column,"11")}'>
                                    <c:if test="${fn:length(fn:trim(each.userdatereg))  eq 8}">
                                        <fmt:parseDate value="${fn:trim(each.userdatereg)}" pattern="yyyyMMdd" var="isoDate"/>
                                    </c:if>
                                    <c:if test="${fn:length(fn:trim(each.userdatereg))  eq 14}">
                                        <fmt:parseDate value="${fn:trim(each.userdatereg)}" pattern="yyyyMMddHHmmss" var="isoDate"/>
                                    </c:if>
                                    <td>
                                        <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy년MM월dd일"/>
                                    </td>
                                </c:if>
                                <c:if test='${fn:contains(column,"12")}'>
                                    <td>${each.useraddr}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"13")}'>
                                    <td>${each.useraddrno}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"14")}'>
                                    <td>${each.usertel}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"15")}'>
                                    <td>${each.dept_nm}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"16")}'>
                                    <td>${each.dept_full_nm}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"17")}'>
                                    <td>${each.usercompanystatus}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"18")}'>
                                    <td>${each.usercaddr}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"19")}'>
                                    <td>${each.usercaddrno}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"20")}'>
                                    <td>${each.tel_offc}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"21")}'>
                                    <td>${each.userfax}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"22")}'>
                                    <td>${each.postuseraddrno}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"23")}'>
                                    <td>${each.postuseraddr}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"42")}'>
                                    <td>
                                        <c:if test="${each.postuseraddr2 eq null}">
                                            <c:if test="${each.postuserselect  eq '2'}">
                                                <c:if test="${each.dept_nm ne null}">
                                                    ${each.dept_nm}
                                                </c:if>
                                                <c:if test="${each.dept_full_nm ne null}">
                                                    ${each.dept_full_nm}
                                                </c:if>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${each.postuseraddr2 ne null}">
                                            ${each.postuseraddr2}
                                        </c:if>
                                    </td>
                                </c:if>
                                <c:if test='${fn:contains(column,"24")}'>
                                    <td>
                                        <c:if test="${each.work_grade eq '1'}">정회원</c:if>
                                        <c:if test="${each.work_grade eq '2'}">종신회원</c:if>
                                        <c:if test="${each.work_grade eq '3'}">준회원</c:if>
                                        <c:if test="${each.work_grade eq '6'}">외부심사위원</c:if>
                                    </td>
                                </c:if>
                                <c:if test='${fn:contains(column,"25")}'>
                                    <td>${each.executivenm}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"26")}'>
                                    <td>${each.committeenm}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"27")}'>
                                    <td>${each.graduation0}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"28")}'>
                                    <td>${each.university0}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"29")}'>
                                    <td>${each.major0}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"30")}'>
                                    <td>${each.graduation1}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"31")}'>
                                    <td>${each.university1}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"32")}'>
                                    <td>${each.major1}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"33")}'>
                                    <td>${each.graduation2}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"34")}'>
                                    <td>${each.university2}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"35")}'>
                                    <td>${each.major2}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"36")}'>
                                    <td>
                                        <c:if test="${each.lasteducation eq '0'}">학부</c:if>
                                        <c:if test="${each.lasteducation eq '1'}">석사</c:if>
                                        <c:if test="${each.lasteducation eq '2'}">박사</c:if>
                                        <c:if test="${each.lasteducation eq '3'}">기타</c:if>
                                    </td>
                                </c:if>
                                <c:if test='${fn:contains(column,"37")}'>
                                    <td>
                                        <c:if test="${each.workplace eq '01'}">대학교수</c:if>
                                        <c:if test="${each.workplace eq '02'}">연구소</c:if>
                                        <c:if test="${each.workplace eq '03'}">대학원생</c:if>
                                        <c:if test="${each.workplace eq '04'}">건설회사</c:if>
                                        <c:if test="${each.workplace eq '05'}">건축사사무소</c:if>
                                        <c:if test="${each.workplace eq '06'}">공공기관</c:if>
                                        <c:if test="${each.workplace eq '07'}">구조사무</c:if>
                                        <c:if test="${each.workplace eq '08'}">기타회사</c:if>
                                        <c:if test="${each.workplace eq '09'}">중고교</c:if>
                                        <c:if test="${each.workplace eq '10'}">외국인</c:if>
                                        <c:if test="${each.workplace eq '11'}">기타</c:if>
                                        <c:if test="${each.workplace eq '12'}">대학생</c:if>
                                        <c:if test="${each.workplace eq '13'}">기술용역</c:if>
                                        <c:if test="${each.workplace eq '14'}">엔지니어링</c:if>
                                        <c:if test="${each.workplace eq '15'}">도시경관/도시계획</c:if>
                                    </td>
                                </c:if>
                                <c:if test='${fn:contains(column,"38")}'>
                                    <td>${each.nominator}</td>
                                </c:if>
                                <c:if test='${fn:contains(column,"39")}'>
                                    <td>
                                        <c:if test="${each.paytype eq '1'}">온라인</c:if>
                                        <c:if test="${each.paytype eq '2'}">지로</c:if>
                                    </td>
                                </c:if>
                                <c:if test='${fn:contains(column,"50")}'>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2000")}'>
                                        <td>${each.d2000}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2001")}'>
                                        <td>${each.d2001}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2002")}'>
                                        <td>${each.d2002}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2003")}'>
                                        <td>${each.d2003}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2004")}'>
                                        <td>${each.d2004}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2005")}'>
                                        <td>${each.d2005}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2006")}'>
                                        <td>${each.d2006}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2007")}'>
                                        <td>${each.d2007}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2008")}'>
                                        <td>${each.d2008}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2009")}'>
                                        <td>${each.d2009}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2010")}'>
                                        <td>${each.d2010}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2011")}'>
                                        <td>${each.d2011}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2012")}'>
                                        <td>${each.d2012}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2013")}'>
                                        <td>${each.d2013}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2014")}'>
                                        <td>${each.d2014}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2015")}'>
                                        <td>${each.d2015}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2016")}'>
                                        <td>${each.d2016}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2017")}'>
                                        <td>${each.d2017}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2018")}'>
                                        <td>${each.d2018}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2019")}'>
                                        <td>${each.d2019}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"d2020")}'>
                                        <td>${each.d2020}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2000")}'>
                                        <td>${each.e2000}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2001")}'>
                                        <td>${each.e2001}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2002")}'>
                                        <td>${each.e2002}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2003")}'>
                                        <td>${each.e2003}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2004")}'>
                                        <td>${each.e2004}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2005")}'>
                                        <td>${each.e2005}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2006")}'>
                                        <td>${each.e2006}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2007")}'>
                                        <td>${each.e2007}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2008")}'>
                                        <td>${each.e2008}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2009")}'>
                                        <td>${each.e2009}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2010")}'>
                                        <td>${each.e2010}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2011")}'>
                                        <td>${each.e2011}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2012")}'>
                                        <td>${each.e2012}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2013")}'>
                                        <td>${each.e2013}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2014")}'>
                                        <td>${each.e2014}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2015")}'>
                                        <td>${each.e2015}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2016")}'>
                                        <td>${each.e2016}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2017")}'>
                                        <td>${each.e2017}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2018")}'>
                                        <td>${each.e2018}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2019")}'>
                                        <td>${each.e2019}</td>
                                    </c:if>
                                    <c:if test='${fn:contains(searchUser.dueyear,"e2020")}'>
                                        <td>${each.e2020}</td>
                                    </c:if>
                                </c:if>


                                <td>
                                        <%-- <a href="javascript:userCommitForStudent('${data.userid}')">강제인증</a>&nbsp&nbsp&nbsp --%>
                                        <%-- <a href="javascript:userPassInit('${data.userno}')">비밀번호 초기화</a> --%>
                                        <%-- <a href="javascript:window.open('/admsys/user/common/update.html?userno=${data.userno}','회원정보','width=800,height=900,left=300,top=20,resizable=no,scrollbars=yes');" class="btn-small5">수정</a> --%>
                                    <a href="/admsys/user/common/update.html?userno=${each.userno}" class="btn-small5">수정</a>
                                </td>


                                    <%-- <td><c:out value='${data.userno}' /></td>
                                    <td><c:out value='${data.userid}' /></td>
                                    <td><c:out value='${data.username}' /></td>
                                    <td><c:out value='${data.dept_nm}' /></td>
                                    <td>
                                        <c:if test='${fn:contains(data.work_grade,"1")}'>
                                            <a href="javascript:work_grade_change('${data.userid }','${data.userno }');">정회원</a>
                                        </c:if>
                                        <c:if test='${fn:contains(data.work_grade,"2")}'>
                                            <a href="javascript:work_grade_change('${data.userid }','${data.userno }');">종신회원</a>
                                        </c:if>
                                        <c:if test='${fn:contains(data.work_grade,"3")}'>
                                            <a href="javascript:work_grade_change('${data.userid }','${data.userno }');">준회원</a>
                                        </c:if>
                                        <c:if test='${fn:contains(data.work_grade,"4")}'>연구용역</c:if>
                                        <c:if test='${fn:contains(data.work_grade,"6")}'>외부심사위원</c:if>
                                    </td>
                                    <td>
                                        <c:if test="${data.work_grade eq '1' || data.work_grade eq '2' ||data.work_grade eq '3'}">
                                            <c:if test="${data.limitYearMonth eq null || data.limitYearMonth eq '' }">
                                                <a href="javascript:payedlist('${data.userid}','${data.userno}');">미결제(중지)</a>
                                            </c:if>
                                            <c:if test="${!(data.limitYearMonth eq null || data.limitYearMonth eq '' )}">
                                                <a href="javascript:payedlist('${data.userid}','${data.userno}');"><c:out value="${data.limitYearMonth}" /></a>
                                            </c:if>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${data.work_grade eq '3' && (data.semimemberconfirm eq null ||data.semimemberconfirm eq '0')}">
                                        <!-- 준회원이 아닌 일반회원도 인증이 필요한 관계로 로직을 수정한다. -->
                                        <c:if test="${(data.semimemberconfirm eq null ||data.semimemberconfirm eq '0')}">
                                            <c:if test="${!(data.limitYearMonth eq null || data.limitYearMonth eq '' )}">
                                                <font color="red">인증필요</font>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${data.userconfirm=='1'}">인증</c:if>
                                        <c:if test="${data.userconfirm=='0'}"><font color="red">미인증</font></c:if>
                                        <c:if test="${data.userconfirm=='0'}">
                                            <a href="javascript:userCommitForStudent('${data.userid}','${data.userno }','${data.username }','${data.useremail }','first')"><font color="red">준회원인증</font></a>
                                        </c:if>
                                        <c:if test="${data.work_grade=='3' && data.userconfirm== '1'}">
                                            <fmt:parseDate value="${data.userconfirmdate}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                            <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" /><br />
                                            <a href="javascript:userCommitForStudent('${data.userid}','${data.userno }','${data.username }','${data.useremail }','re')"><font color="red">준회원1년연장</font></a>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${data.annualPause eq '1'}">
                                            중지상태
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${data.userdatereg ne '000000' && data.userdatereg ne null}">
                                            <fmt:parseDate value="${data.userdatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                            <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${data.useroutrequest eq '0' && data.enabled eq '1'}">
                                            <a href="javascript:if(confirm('탈퇴를 승인하시겠습니까?')){ document.location.href='/admsys/user/common/EnabledToZero.html?userno=${data.userno}'}">탈퇴승인</a>
                                        </c:if>
                                        <c:if test="${data.useroutrequest eq '0' && data.enabled eq '0'}">
                                            탈퇴 완료
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${data.newsletter1 eq '1'}">
                                            수신
                                        </c:if>
                                        <c:if test="${data.newsletter1 ne '1'}">
                                            거부
                                        </c:if>
                                    </td> --%>
                                    <%-- <td>
                                        <a href="javascript:userCommitForStudent('${data.userid}')">강제인증</a>&nbsp&nbsp&nbsp
                                        <a href="javascript:userPassInit('${data.userno}')">비밀번호 초기화</a>
                                        <a href="javascript:window.open('/admsys/user/common/update.html?userno=${data.userno}','회원정보','width=800,height=900,left=300,top=20,resizable=no,scrollbars=yes');" class="btn-small5">수정</a>
                                        <a href="/admsys/user/common/update.html?userno=${data.userno}" class="btn-small5">수정</a>
                                    </td> --%>
                            </tr>
                        </c:forEach>
                        <c:if test="${input.total==0}">
                            <tr>
                                <td colspan="14" style="padding:20;">등록된 정보가 없습니다.</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
                    <!---/게시판 영역------------------------->
                </div><!--/main_table-->
            </div>
            <!--/content-->
        </form:form>
    </div><!--/r_side-->
</div>
<!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp"/>
</body>
</html>


</script>
</head>


<%--


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/user/common/" title="회원관리로 이동">회원관리</a>
						&gt;
						<span>회원목록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
				<table width="835" border="0" cellspacing="0" cellpadding="0"
					height="100%">
					<tr>
						<td width="15" height="41" bgcolor="#CCCCCC"
							style="border-left: 1px solid #D4D3CF; border-right: 1px solid #D4D3CF; border-bottom: 1 solid #D4D3CF"><font
							color="#CCCCCC"></td>
						<td width="795" height="41" background="/cms/image/table_title.jpg"
							style="border-right: 1px solid #D4D3CF; border-bottom: 1 solid #D4D3CF"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font
								class="t8"><b>개인회원</b></font></strong></td>
						<td width="16" bgcolor="dddddd">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td width="15"
							style="border-right: 1 solid #D4D3CF; border-left: 1 solid #D4D3CF; border-bottom: 1px solid #d4d3cf">&nbsp;</td>
						<td align="left" valign="top"
							style="border-right: 1px solid #D4D3CF; border-bottom: 1px solid #D4D3CF; padding-top: 10px; padding-left: 40px; padding-right: 40px; padding-bottom: 20px">
							<!--  내용들어가는 부분 시작  -->

							<table border="0" width="700">
								<tr>
									<td width="100%">
										<form name="frm1" method="post" modelAttribute="searchUser">

											<table width="100%">
												<tr height="2">
													<td width="50%"><strong>
													<img src="/cms/image/ad_m_icon.gif" width="12" height="9">&nbsp;회원리스트
													</strong></td>
													<td width="50%" align="right" class="chost_table_body"><span
														class="chost_table_header"><b>&nbsp;Total : ${input.total}
																(${pageIndex} / ${input.pageMax})&nbsp;</b></span></td>
												</tr>
											</table>
											<table cellpadding="3" cellspacing="1" border="0"
												class="chost_table" width="100%">
												<tr height="22">
													<th>회원번호</td>
													<c:if test='${fn:contains(column,"01")}'>
														<th>ID</td>
													</c:if>
													<c:if test='${fn:contains(column,"02")}'>
														<th>한글이름</td>
													</c:if>
													<c:if test='${fn:contains(column,"03")}'>
														<th>영문이름</td>
													</c:if>
													<c:if test='${fn:contains(column,"04")}'>
														<th>한문이름</td>
													</c:if>
													<c:if test='${fn:contains(column,"05")}'>
														<th>생년월일</td>
													</c:if>
													<c:if test='${fn:contains(column,"06")}'>
														<th>이메일</td>
													</c:if>
													<c:if test='${fn:contains(column,"07")}'>
														<th>우편물수령</td>
													</c:if>
													<c:if test='${fn:contains(column,"08")}'>
														<th>핸드폰</td>
													</c:if>
													<c:if test='${fn:contains(column,"10")}'>
														<th>지회</td>
													</c:if>
													<c:if test='${fn:contains(column,"11")}'>
														<th>입회날자</td>
													</c:if>
													<c:if test='${fn:contains(column,"12")}'>
														<th>자택주소</td>
													</c:if>
													<c:if test='${fn:contains(column,"13")}'>
														<th>자택우편번호</td>
													</c:if>
													<c:if test='${fn:contains(column,"14")}'>
														<th>자택전화번호</td>
													</c:if>
													<c:if test='${fn:contains(column,"15")}'>
														<th>직장명</td>
													</c:if>
													<c:if test='${fn:contains(column,"16")}'>
														<th>부서</td>
													</c:if>
													<c:if test='${fn:contains(column,"17")}'>
														<th>직책</td>
													</c:if>
													<c:if test='${fn:contains(column,"18")}'>
														<th>회사주소</td>
													</c:if>
													<c:if test='${fn:contains(column,"19")}'>
														<th>회사우편번호</td>
													</c:if>
													<c:if test='${fn:contains(column,"20")}'>
														<th>회사전화번호</td>
													</c:if>
													<c:if test='${fn:contains(column,"21")}'>
														<th>회사FAX</td>
													</c:if>
													<c:if test='${fn:contains(column,"22")}'>
														<th>받을곳 우편번호</td>
													</c:if>
													<c:if test='${fn:contains(column,"23")}'>
														<th>받을곳 주소</td>
													</c:if>
													<c:if test='${fn:contains(column,"24")}'>
														<th>회원종류</td>
													</c:if>
													<c:if test='${fn:contains(column,"25")}'>
														<th>임원</td>
													</c:if>
													<c:if test='${fn:contains(column,"26")}'>
														<th>위원회</td>
													</c:if>
													<c:if test='${fn:contains(column,"27")}'>
														<th>학사졸업연도</td>
													</c:if>
													<c:if test='${fn:contains(column,"28")}'>
														<th>학사학교</td>
													</c:if>
													<c:if test='${fn:contains(column,"29")}'>
														<th>학사학과</td>
													</c:if>
													<c:if test='${fn:contains(column,"30")}'>
														<th>석사졸업연도</td>
													</c:if>
													<c:if test='${fn:contains(column,"31")}'>
														<th>석사학교</td>
													</c:if>
													<c:if test='${fn:contains(column,"32")}'>
														<th>석사학과</td>
													</c:if>
													<c:if test='${fn:contains(column,"33")}'>
														<th>박사졸업연도</td>
													</c:if>
													<c:if test='${fn:contains(column,"34")}'>
														<th>박사박교</td>
													</c:if>
													<c:if test='${fn:contains(column,"35")}'>
														<th>박사학과</td>
													</c:if>
													<c:if test='${fn:contains(column,"36")}'>
														<th>최종학력</td>
													</c:if>
													<c:if test='${fn:contains(column,"37")}'>
														<th>직종</td>
													</c:if>
													<c:if test='${fn:contains(column,"38")}'>
														<th>추천인</td>
													</c:if>
													<c:if test='${fn:contains(column,"39")}'>
														<th>납부방법</td>
													</c:if>

													<th>
														<a href="javascript:AllCheck(document.frm1)"><font face="WebDings" size="4">a</font></a>
													</td>
												</tr>
												<c:forEach items="${list}" var="data" varStatus="status">
													<tr height="22" class="chost_table_body">

														<td align="center">
															<a href="/admsys/user/common/update.html?userno=${data.userno}" class="btn-small5">${data.userno }</a>
														</td>
														<c:if test='${fn:contains(column,"01")}'>
															<td align="center">${data.userid}</td>
														</c:if>
														<c:if test='${fn:contains(column,"02")}'>
															<td align="center">${data.username}</td>
														</c:if>
														<c:if test='${fn:contains(column,"03")}'>
															<td align="center">${data.username2}</td>
														</c:if>
														<c:if test='${fn:contains(column,"04")}'>
															<td align="center">${data.usercname}</td>
														</c:if>
														<c:if test='${fn:contains(column,"05")}'>
															<td align="center">${data.userbirth}</td>
														</c:if>
														<c:if test='${fn:contains(column,"06")}'>
															<td align="center">${data.useremail}</td>
														</c:if>
														<c:if test='${fn:contains(column,"07")}'>
															<td align="center">${data.postuserselect}</td>
														</c:if>
														<c:if test='${fn:contains(column,"08")}'>
															<td align="center">${data.usermobile}</td>
														</c:if>
														<c:if test='${fn:contains(column,"10")}'>
															<td align="center">
																<c:if test="${data.branch eq '1'}">부산울산경남지회</c:if>
																<c:if test="${data.branch eq '2'}">대구경북지회</c:if>
																<c:if test="${data.branch eq '3'}">강원지회</c:if>
																<c:if test="${data.branch eq '4'}">광주전남지회</c:if>
																<c:if test="${data.branch eq '5'}">대전세종충청지회</c:if>
																<c:if test="${data.branch eq '6'}">전라북도지회</c:if>
																<c:if test="${data.branch eq '7'}">제주지회</c:if>
															</td>
														</c:if>
														<c:if test='${fn:contains(column,"11")}'>
															<td align="center">${data.userdatereg}</td>
														</c:if>
														<c:if test='${fn:contains(column,"12")}'>
															<td align="center">${data.useraddr}</td>
														</c:if>
														<c:if test='${fn:contains(column,"13")}'>
															<td align="center">${data.useraddrno}</td>
														</c:if>
														<c:if test='${fn:contains(column,"14")}'>
															<td align="center">${data.usertel}</td>
														</c:if>
														<c:if test='${fn:contains(column,"15")}'>
															<td align="center">${data.dept_nm}</td>
														</c:if>
														<c:if test='${fn:contains(column,"16")}'>
															<td align="center">${data.dept_full_nm}</td>
														</c:if>
														<c:if test='${fn:contains(column,"17")}'>
															<td align="center">${data.usercompanystatus}</td>
														</c:if>
														<c:if test='${fn:contains(column,"18")}'>
															<td align="center">${data.usercaddr}</td>
														</c:if>
														<c:if test='${fn:contains(column,"19")}'>
															<td align="center">${data.usercaddrno}</td>
														</c:if>
														<c:if test='${fn:contains(column,"20")}'>
															<td align="center">${data.tel_offc}</td>
														</c:if>
														<c:if test='${fn:contains(column,"21")}'>
															<td align="center">${data.postuserselect}</td>
														</c:if>
														<c:if test='${fn:contains(column,"22")}'>
															<td align="center">${data.postuserselect}</td>
														</c:if>
														<c:if test='${fn:contains(column,"23")}'>
															<td align="center">${data.postuserselect}</td>
														</c:if>
														<c:if test='${fn:contains(column,"24")}'>
															<td align="center">
																<c:if test="${data.work_grade eq '1'}">정회원</c:if>
																<c:if test="${data.work_grade eq '2'}">종신회원</c:if>
																<c:if test="${data.work_grade eq '3'}">준회원</c:if>
																<c:if test="${data.work_grade eq '6'}">외부심사위원</c:if>
															</td>
														</c:if>
														<c:if test='${fn:contains(column,"25")}'>
															<td align="center">${data.executivenm}</td>
														</c:if>
														<c:if test='${fn:contains(column,"26")}'>
															<td align="center">${data.committeenm}</td>
														</c:if>
														<c:if test='${fn:contains(column,"27")}'>
															<td align="center">${data.graduation0}</td>
														</c:if>
														<c:if test='${fn:contains(column,"28")}'>
															<td align="center">${data.university0}</td>
														</c:if>
														<c:if test='${fn:contains(column,"29")}'>
															<td align="center">${data.major0}</td>
														</c:if>
														<c:if test='${fn:contains(column,"30")}'>
															<td align="center">${data.graduation1}</td>
														</c:if>
														<c:if test='${fn:contains(column,"31")}'>
															<td align="center">${data.university1}</td>
														</c:if>
														<c:if test='${fn:contains(column,"32")}'>
															<td align="center">${data.major1}</td>
														</c:if>
														<c:if test='${fn:contains(column,"33")}'>
															<td align="center">${data.graduation2}</td>
														</c:if>
														<c:if test='${fn:contains(column,"34")}'>
															<td align="center">${data.university2}</td>
														</c:if>
														<c:if test='${fn:contains(column,"35")}'>
															<td align="center">${data.major2}</td>
														</c:if>
														<c:if test='${fn:contains(column,"36")}'>
															<td align="center">
																<c:if test="${data.lasteducation eq '0'}">학부</c:if>
																<c:if test="${data.lasteducation eq '1'}">석사</c:if>
																<c:if test="${data.lasteducation eq '2'}">박사</c:if>
																<c:if test="${data.lasteducation eq '3'}">기타</c:if>

															</td>
														</c:if>
														<c:if test='${fn:contains(column,"37")}'>
															<td align="center">
																<c:if test="${data.workplace eq '01'}">대학교수</c:if>
																<c:if test="${data.workplace eq '02'}">연구소</c:if>
																<c:if test="${data.workplace eq '03'}">대학원생</c:if>
																<c:if test="${data.workplace eq '04'}">건설회사</c:if>
																<c:if test="${data.workplace eq '05'}">건축사사무소</c:if>
																<c:if test="${data.workplace eq '06'}">공공기관</c:if>
																<c:if test="${data.workplace eq '07'}">구조사무</c:if>
																<c:if test="${data.workplace eq '08'}">기타회사</c:if>
																<c:if test="${data.workplace eq '09'}">중고교</c:if>
																<c:if test="${data.workplace eq '10'}">외국인</c:if>
																<c:if test="${data.workplace eq '11'}">기타</c:if>
																<c:if test="${data.workplace eq '12'}">대학생</c:if>
																<c:if test="${data.workplace eq '13'}">기술용역</c:if>
																<c:if test="${data.workplace eq '14'}">엔지니어링</c:if>
																<c:if test="${data.workplace eq '15'}">도시경관/도시계획</c:if>
															</td>
														</c:if>
														<c:if test='${fn:contains(column,"38")}'>
															<td align="center">${data.nominator}</td>
														</c:if>
														<c:if test='${fn:contains(column,"39")}'>
															<td align="center">${data.postuserselect}</td>
														</c:if>
														<td align="center">
															<input type="checkbox" name="checkval" value="${data.userno}" class="chost_table_body">
														</td>

													</tr>
												</c:forEach>
												<c:if test="${input.total==0}">
												<tr>
													<td colspan="14" style="padding:20;">등록된 정보가 없습니다.</td>
												</tr>
											</c:if>
											</table>
											<input type="hidden" name="column" value="${column}">
											<input type="hidden" name="userno" value="${searchUser.userno}">
											<input type="hidden" name="userid" value="${searchUser.userid}">
											<input type="hidden" name="username" value="${searchUser.username}">
											<input type="hidden" name="username2" value="${searchUser.username2}">
											<input type="hidden" name="work_grade" value="${searchUser.work_grade}">
											<input type="hidden" name="usersex" value="${searchUser.usersex}">
											<input type="hidden" name="useroutrequest" value="${searchUser.useroutrequest}">
											<input type="hidden" name="dept_nm" value="${searchUser.dept_nm}">
											<input type="hidden" name="dept_full_nm" value="${searchUser.dept_full_nm}">
											<input type="hidden" name="userdatereg" value="${searchUser.userdatereg}">
											<input type="hidden" name="userbirth" value="${searchUser.userbirth}">
											<input type="hidden" name="useraddrno" value="${searchUser.useraddrno}">
											<input type="hidden" name="useremail" value="${searchUser.useremail}">
											<input type="hidden" name="usermobile" value="${searchUser.usermobile}">
											<input type="hidden" name="useraddr" value="${searchUser.useraddr}">
											<input type="hidden" name="branch" value="${searchUser.branch}">
											<input type="hidden" name="usercname" value="${searchUser.usercname}">
											<input type="hidden" name="postuserselect" value="${searchUser.postuserselect}">
											<input type="hidden" name="usercompanystatus" value="${searchUser.usercompanystatus}">
											<input type="hidden" name="usercaddrno" value="${searchUser.usercaddrno}">
											<input type="hidden" name="usercaddr" value="${searchUser.usercaddr}">
											<input type="hidden" name="nominator" value="${searchUser.nominator}">
											<input type="hidden" name="lasteducation" value="${searchUser.lasteducation}">
											<input type="hidden" name="annualpause" value="${searchUser.annualpause}">
											<input type="hidden" name="semimemberconfirm" value="${searchUser.semimemberconfirm}">
											<input type="hidden" name="graduation0" value="${searchUser.graduation0}">
											<input type="hidden" name="university0" value="${searchUser.university0}">
											<input type="hidden" name="major0" value="${searchUser.major0}">
											<input type="hidden" name="graduation1" value="${searchUser.graduation1}">
											<input type="hidden" name="university1" value="${searchUser.university1}">
											<input type="hidden" name="graduation2" value="${searchUser.graduation2}">
											<input type="hidden" name="university2" value="${searchUser.university2}">
											<input type="hidden" name="major2" value="${searchUser.major2}">
											<input type="hidden" name="cond4" value="${searchUser.cond4}">
											<input type="hidden" name="cond5" value="${searchUser.cond5}">
											<input type="hidden" name="searchtype" value="${searchUser.searchtype}">
											<input type="hidden" name="keyword" value="${searchUser.keyword}">
											<input type="hidden" name="usernostart" value="${searchUser.usernostart}">
											<input type="hidden" name="usernoend" value="${searchUser.usernoend}">
											<input type="hidden" name="sdatetype" value="${searchUser.sdatetype}">
											<input type="hidden" name="sdateys" value="${searchUser.sdateys}">
											<input type="hidden" name="sdatems" value="${searchUser.sdatems}">
											<input type="hidden" name="sdateds" value="${searchUser.sdateds}">
											<input type="hidden" name="sdateye" value="${searchUser.sdateye}">
											<input type="hidden" name="sdateme" value="${searchUser.sdateme}">
											<input type="hidden" name="sdatede" value="${searchUser.sdatede}">
											<input type="hidden" name="st_sec1" value="${searchUser.st_sec1}">
											<input type="hidden" name="st_sec2" value="${searchUser.st_sec2}">
											<input type="hidden" name="st_sec3" value="${searchUser.st_sec3}">
											<input type="hidden" name="st_sec4" value="${searchUser.st_sec4}">
											<input type="hidden" name="st_sec5" value="${searchUser.st_sec5}">
											<input type="hidden" name="st_sec6" value="${searchUser.st_sec6}">
											<input type="hidden" name="sc_sec1_val" value="${searchUser.sc_sec1_val}">
											<input type="hidden" name="sd_sec1" value="${searchUser.sd_sec1}">
											<input type="hidden" name="sc_sec2_val" value="${searchUser.sc_sec2_val}">
											<input type="hidden" name="workplace" value="${searchUser.workplace}">
											<input type="hidden" name="sc_sec4_val" value="${searchUser.sc_sec4_val}">
											<input type="hidden" name="sd_sec4" value="${searchUser.sd_sec4}">
											<input type="hidden" name="executive" value="${searchUser.executive}">
											<input type="hidden" name="sc_sec5_val" value="${searchUser.sc_sec5_val}">
											<input type="hidden" name="sd_sec5" value="${searchUser.sd_sec5}">
											<input type="hidden" name="committee" value="${searchUser.committee}">
											<input type="hidden" name="sc_sec11_val" value="${searchUser.sc_sec11_val}">
											<input type="hidden" name="sd_sec11" value="${searchUser.sd_sec11}">
											<input type="hidden" name="groupuser" value="${searchUser.groupuser}">
											<input type="hidden" name="paytype" value="${searchUser.paytype}">
											<input type="hidden" name="postal" value="${searchUser.postal}">
											<input type="hidden" name="university" value="${searchUser.university}">
											<input type="hidden" name="degrees" value="${searchUser.degrees}">
										</form>
									</td>
								</tr>
								<tr>
									<td width="100%"></td>
								</tr>
								<tr>
									<td width="100%" align="center">
										<table width="100%">
											<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
												<td width="15%" align="right"><select name="pskip" id="pskip"
													onchange="goPageSkip()">
														<script type="text/javascript">
															var pageMax = '${input.pageMax}';
															for(var i=1;Number(pageMax) >= i;i++){
																document.write("<option value="+i+">"+i+"</option>");
															}
														</script>
												</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
											</tr>
											<script type="text/javascript">
												function goPageSkip(){
													document.forms[0].action="?pageIndex="+$("#pskip").val();
													document.forms[0].submit();
												}
											</script>
										</table>
									</td>
								</tr>
								<tr>
									<td width="100%"></td>
								</tr>
								<tr>
									<td width="100%"></td>
								</tr>

								<tr>
									<td width="100%">
										<div class="btn-c05" style="margin-top:0;">
											<a href="javascript:sendAllMail()" class="gray" style="padding:7px 15px; font-size:12px;">검색된회원 전체메일발송</a>
											<a href="javascript:sendChkMail()" class="gray" style="padding:7px 15px; font-size:12px;">체크된회원 메일발송</a>
											<a href="javascript:excelAll()" class="gray" style="padding:7px 15px; font-size:12px;">검색된회원 전체엑셀다운로드</a>
											<a href="javascript:excelChk()" class="gray" style="padding:7px 15px; font-size:12px;">체크된회원 엑셀다운로드</a>
										</div>
									</td>
								</tr>



								<!-- <tr>
									<td width="100%">
										<table cellpadding="0" cellspacing="0" border="0"
											class="chost_table" width="100%">
											<tr>
												<td align="center" class="chost_table_body" width="100%"
													height="3"></td>
											</tr>
											<tr>
												<td align="center" class="chost_table_body" width="100%">
												<a href="index.html"><input type="button" class="chost_btn" value="검색화면" ></a>&nbsp;&nbsp;&nbsp;
												<input
													type="button" class="chost_btn" value="Excel 저장"
													onClick="DownExcel()">&nbsp;&nbsp;&nbsp;<input
													type="button" class="chost_btn" value="검색된 회원에게 메일 보내기"
													onClick="SendMail()">&nbsp;&nbsp;&nbsp;<input
													type="button" class="chost_btn" value="체크된 회원에게 메일 보내기"
													onClick="SendMailCheck()"></td>
											</tr>
										</table>
									</td>
								</tr> -->
							</table> <!--  내용들어가는 부분 끝  -->
						</td>
						<td bgcolor="DDDDDD">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<!--  subpage bottom 시작  -->
					<!--  subpage bottom 끝  -->
				</table>
				</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>
 --%>
