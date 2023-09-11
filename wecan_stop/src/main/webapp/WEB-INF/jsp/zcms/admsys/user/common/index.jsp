<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<link rel='stylesheet' href='<c:url value="/com/css/jquery-1.10.3-ui.css"/>'/>
<script src='<c:url value="/com/js/jquery-1.10.3-ui.js"/>'></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#keyword2').datepicker({
            dateFormat          : "yy-mm-dd"
            , showMonthAfterYear: true
            , dayNamesMin       : ['월', '화', '수', '목', '금', '토', '일']
            , monthNames        : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            onSelect            : function (dateText, inst) {
            }
        });

        if ($('#cond2').val() == "userdatereg") {
            $('#keyword').attr("disabled", true);
            $('#keyword').hide();

            $('#keyword2').attr("disabled", false);
            $('#keyword2').show();
        } else if ($('#cond2').val() == "total") {
            $('#keyword').attr("disabled", false);
            $('#keyword').val('');
            $('#keyword').hide();

            $('#keyword2').attr("disabled", true);
            $('#keyword2').val('');
            $('#keyword2').hide();
        } else if ($('#cond2').val() == "foreigner") {
            $('#keyword').val('1');
            $('#keyword').hide();

            $('#keyword2').attr("disabled", true);
            $('#keyword2').val('');
            $('#keyword2').hide();
        }

        $('#cond2').change(function () {
            if ($(this).val() == "userdatereg") {
                $('#keyword').attr("disabled", true);
                $('#keyword').hide();

                $('#keyword2').attr("disabled", false);
                $('#keyword2').show();

            } else if ($(this).val() == "total") {
                $('#keyword').attr("disabled", false);
                $('#keyword').val('');
                $('#keyword').hide();

                $('#keyword2').attr("disabled", true);
                $('#keyword2').val('');
                $('#keyword2').hide();
            } else if ($(this).val() == "foreigner") {
                $('#keyword').val('1');
                $('#keyword').hide();

                $('#keyword2').attr("disabled", true);
                $('#keyword2').val('');
                $('#keyword2').hide();
            } else {
                $('#keyword').attr("disabled", false);
                $('#keyword').val('');
                $('#keyword').show();

                $('#keyword2').attr("disabled", true);
                $('#keyword2').val('');
                $('#keyword2').hide();
            }
        });
    });

    function userCommit(userno) {
        if (confirm("해당 유저를 승인하시겠습니까?")) {
            $.ajax({
                type     : 'post'
                , async  : true
                , url    : '/admsys/user/common/usercommit.html'
                , data   : "userno=" + userno
                , success: function (data) {
                    alert("승인되었습니다.");
                    window.location.reload();
                }
                , error  : function (data, status, err) {
                    alert('서버와의 통신이 실패했습니다.');
                }
            });
        }
    }

    /* function userCommitForStudent(userid,userno,username,useremail,re){
     //alert("userid="+userid+"&userno="+userno+"&username="+username+"&useremail="+useremail);
     if(re =="re") msg = "해당 유저의  준회원기간을 1년더 연장하시겠습니까?";
     else          msg = "해당 유저를 준회원으로 인증하시겠습니까?";
     if(confirm(msg)){
     $.ajax({
     type: 'post'
     , async: true
     , url: '/admsys/user/common/userCommitForStudent.html'
     , data: "userid="+userid+"&userno="+userno+"&username="+username+"&useremail="+useremail
     , success: function(data) {
     alert("인증되었습니다.");
     window.location.reload();
     }
     , error: function(data, status, err) {
     alert('서버와의 통신이 실패했습니다.');
     }
     });
     }
     } */


    function payedlist(userid, userno) {
        var url = "/admin/dues/payedlist/index.html?userno=" + userno + "&userid=" + userid;
        var windowName = "payedlist";
        var windowWidth = 1000;
        var windowHeight = 600;
        var windowLeft = parseInt((screen.availWidth / 2) - (windowWidth / 2));
        var windowTop = parseInt((screen.availHeight / 2) - (windowHeight / 2));
        var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
        window.open(url, windowName, windowSize);
    }

    function work_grade_change(userid, userno) {
        var url = "/admsys/dues/work_grade_change.html?userno=" + userno + "&userid=" + userid;
        var windowName = "payedlist";
        var windowWidth = 1000;
        var windowHeight = 600;
        var windowLeft = parseInt((screen.availWidth / 2) - (windowWidth / 2));
        var windowTop = parseInt((screen.availHeight / 2) - (windowHeight / 2));
        var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
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

    function sort(type, sort) {

        $("#sortName").val(type); //정렬 타입
        $("#sort").val(sort); //정렬
        var form = document.frm;
        form.submit();

    }

    function sendAllMail() {
        if (confirm("검색된 회원전체에게 메일을 발송하시겠습니까?")) {
            $("#act").val("user_all");
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
                $("#act").val("user_chk");

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

            $("#act").val("excel_all");

            window.open("", "excelAll", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=10, height=10");
            document.frm.action = "/admsys/user/common/popupExcel.html";
            document.frm.target = "excelAll";
            document.frm.submit();
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
                $("#act").val("excel_chk");

                window.open("", "excelAll", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=10, height=10");
                document.frm.action = "/admsys/user/common/popupExcel.html";
                document.frm.target = "excelAll";
                document.frm.submit();
                document.frm.target = "";

            }
        }
    }

    function changeStatus(userno) {
        if (confirm("승인하시겠습니까?")) {
            $.ajax({
                type   : 'post',
                async  : true,
                url    : '/admsys/user/common/changeUserStatus.html',
                data   : "userno=" + userno,
                success: function (data) {

                    if (data == "1") {
                        alert("승인되었습니다.");
                        window.location.reload();
                    } else {
                        alert("오류가 발생하였습니다. 다시 시도해 주세요.");
                    }
                },
                error  : function (data, status, err) {
                    alert('서버와의 통신이 실패했습니다.');
                }
            });
        }
    }

    function annualPauseStop(userno) {
        if (confirm("회원중지상태를 활성화 상태로 변경하시겠습니까?")) {
            $.ajax({
                type     : 'post'
                , async  : true
                , url    : '/admsys/dues/annualPauseStop/index.html'
                , data   : "userno=" + userno
                , success: function (data) {
                    if (data == '1') {
                        alert("해당유저의 회원상태가 활성화 되었습니다.");
                    } else {
                        alert("관리자 권한이 아니거나 오류가 있습니다. 관리자에게 문의하세요");
                    }
                    window.location.reload();
                    window.opener.location.reload();
                }
                , error  : function (data, status, err) {
                    alert('서버와의 통신이 실패했습니다.');
                }
            });
        }
    }
</script>
<div id="container">
    <jsp:include page="../../lnb.jsp" flush="true"/>
    <div id="r_side">
        <div id="contents">
            <form:form name="frm" method="post">
                <input type="hidden" name="work_grade" value="${data.work_grade }"/>
                <div class="contants_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a>
                        <a href="/admsys/user/common/index.html">회원관리</a>
                        <strong>회원목록</strong>
                    </div>
                    <div class="TopSearch">
                        <span>SEARCH AREA</span>
                        <select style="height:27px;" name="cond3">
                        	<option value="">카테고리 선택</option>
                            <option value="1" <c:if test="${data.cond3=='1'}"><c:out value='selected'/></c:if>>대표단</option>
                            <option value="2" <c:if test="${data.cond3=='2'}"><c:out value='selected'/></c:if>>주최측인력</option>
                            <option value="3" <c:if test="${data.cond3=='3'}"><c:out value='selected'/></c:if>>미디어</option>
                            <option value="4" <c:if test="${data.cond3=='4'}"><c:out value='selected'/></c:if>>부대행사</option>
                            <option value="5" <c:if test="${data.cond3=='5'}"><c:out value='selected'/></c:if>>차량등록</option>
                        </select>
                        <select style="height:27px;" name="cond2">
                            <option value="userid" <c:if test="${data.cond2=='userid'}"><c:out value='selected'/></c:if>>접속ID</option>
                            <option value="usernick" <c:if test="${data.cond2=='usernick'}"><c:out value='selected'/></c:if>>국가</option>
                            <option value="username" <c:if test="${data.cond2=='username'}"><c:out value='selected'/></c:if>>단체명</option>
                        </select>
                        <input type=text name="keyword" value="<c:out value='${data.keyword}' />" class="bor1ddd" style="width:128px;"/>
                        <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'"/>
                    </div>
                </div>

                <div id="content">
                    <ul class="homepagebbs">
                        <li class="bg">
                            <h3 class="sub">회원정보&nbsp;&nbsp; 총 회원: ${data.total}명
                            </h3>
                                <%--<a class="btmore03" href="/admsys/user/common/index.html?work_grade=3">지정업체</a>--%>
                                <%--<a class="btmore03" href="/admsys/user/common/index.html?work_grade=2">기업회원</a>--%>
                                <%--<a class="btmore03" href="/admsys/user/common/index.html?work_grade=1">개인회원</a>--%>
                                <%--<a class="btmore03" href="/admsys/user/common/index.html?work_grade=all">전체</a>--%>
                                <%--<div class="user_btn">--%>
                                <%--<a class="btmore01" href="javascript:sendAllMail()">검색된회원 전체메일발송</a>--%>
                                <%--<a class="btmore01" href="javascript:sendChkMail()">체크된회원 메일발송</a>--%>
                                <%--<a class="btmore01" href="javascript:excelAll()">검색된회원 전체엑셀다운로드</a>--%>
                                <%--<a class="btmore01" href="javascript:excelChk()">체크된회원 엑셀다운로드</a>--%>
                                <%--</div>--%>
                        </li>
                        <li>
                            <div class="user_btn">
                                <a class="btmore01" href="/admsys/user/common/insert.html">회원등록</a>
                               <!--  <a class="btmore01" href="/admsys/user/common/excel.html">엑셀다운</a>
                                <a class="btmore01" href="/admsys/user/common/batch.html">엑셀등록</a> -->
                            </div>
                        </li>
                        <li>
                            <div class="top_bt">
                                <a class="btmore07" href="javascript:checkAll(true,'userno');">전체선택</a>
                                <a class="btmore07" href="javascript:checkAll(false,'userno');">전체해제</a>
                                <a class="btmore05" href="javascript:del('userno');">삭제</a>
                                <!-- <a class="btmore05" href="javascript:resign('userno');">탈퇴</a> -->
                                <select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()" style="height:28px;">
                                    <c:forTokens items="10,20,30,40,50" var="each" delims=",">
                                        <option value="${each}" <c:if test="${data.pageSize==each}"><c:out value='selected'/></c:if>>${each}개 출력</option>
                                    </c:forTokens>
                                </select>
                            </div>
                            <div class="main_table">
                                <!---게시판 영역------------------------->
                                <table id="main_table" class="main_table1" summary="체크박스, 회원번호, 아이디, 이름, 소속기관, 직위, 연락처, 이메일, 수정">
                                    <caption>회원리스트</caption>
                                    <colgroup>
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th><input class="bor_none" id="batch" value="3" type="checkbox" onclick="javascript:checkAll('','userno')"/></th>
                                        <th>번호</th>
                                        <th>접속 ID</th>
                                        <th>등록카테고리</th>
                                        <th>국가</th>
                                        <th>등록담당기관/단체명</th>
                                        <th>담당자 성명</th>
                                        <th>담당자 이메일</th>
                                        <th>담당자 핸드폰</th>
                                        <th>담당자 전화</th>
                                        <th>담당자 소속</th>
                                        <th>담당자 직위</th>
                                        <th>지정 마감일</th>
                                        <th>수정</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td><input class="bor_none" name="userno" value="${each.userno}" type="checkbox"/></td>
                                            <td><c:out value='${data.total-(data.pageIndex-1)*data.pageSize-loop.index}'/></td>
                                            <td>
                                                <c:out value='${each.userid}'/>
                                                <c:if test="${each.enabled eq '0'}">(<span style="color: orangered; ">탈퇴</span>)</c:if>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${each.usercate eq '1'}">대표단</c:when>
                                                    <c:when test="${each.usercate eq '2'}">주최측인력</c:when>
                                                    <c:when test="${each.usercate eq '3'}">미디어</c:when>
                                                    <c:when test="${each.usercate eq '4'}">부대행사</c:when>
                                                </c:choose>
                                            </td>
                                            <td>${each.usernick }</td>
                                            <td><c:out value='${each.username}'/></td>
                                            <td><c:out value='${each.chargername}'/></td>
                                            <td><c:out value='${each.useremail}'/></td>
                                            <td><c:out value='${each.usermobile}'/></td>
                                            <td><c:out value='${each.usertel}'/></td>
                                            <td><c:out value='${each.dept_nm}'/></td>
                                            <td><c:out value='${each.work_title}'/></td>
                                            <td><c:out value='${each.useripreg}'/></td>
                                            <td>
                                                    <%-- <a href="javascript:userCommitForStudent('${item.userid}')">강제인증</a>&nbsp&nbsp&nbsp --%>
                                                    <%-- <a href="javascript:userPassInit('${item.userno}')">비밀번호 초기화</a> --%>
                                                    <%-- <a href="javascript:window.open('/admsys/user/common/update.html?userno=${item.userno}','회원정보','width=800,height=900,left=300,top=20,resizable=no,scrollbars=yes');" class="btn-small5">수정</a> --%>
                                                <a href="/admsys/user/common/update.html?userno=${each.userno}" class="btmore05">수정</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${data.total==0}">
                                        <tr>
                                            <td colspan="14" style="padding: 20px;">등록된 정보가 없습니다.</td>
                                        </tr>
                                    </c:if>
                                    </tbody>
                                </table>
                                <pt:pageOut pageIndex='${data.pageIndex}' pageMax='${data.pageMax}'/>
                                <!---/게시판 영역------------------------->
                            </div><!--/main_table-->
                            <c:if test="${data.userType eq 'outside' }">
                                <ul class="site_register">
                                    <li class="btn-r" style="margin-top:40px;"><a href="insert.html">+ 회원 등록</a></li>
                                </ul>
                            </c:if>
                        </li>
                    </ul>
                </div>
                <!--/content-->
            </form:form>
        </div>
    </div>
    <!--/r_side-->
</div>
<!--/container-->
<%-- </div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html> --%>
