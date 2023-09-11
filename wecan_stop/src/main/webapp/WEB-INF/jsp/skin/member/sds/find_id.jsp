<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<script type="text/javascript">

    $(function () {


        document.getElementById('selectdomain').onchange = function () {
            document.getElementById('useremaildomain').value = document.getElementById('selectdomain').value;
        };


    });

    <c:if test="${success eq false}">
    alert("일치하는 회원정보가 없습니다.");
    </c:if>


    function checkJoin(type, no) {

        if ($("#j_licenseeno1").val().replace(/^\s+|\s+$/g, "") == "") {
            alert("사업자등록번호를 입력 해주세요.");
            $("#j_licenseeno1").focus();
            $("#j_licenseeno1").select();
            return false;
        }
        if ($("#j_licenseeno2").val().replace(/^\s+|\s+$/g, "") == "") {
            alert("사업자등록번호를 입력 해주세요.");
            $("#j_licenseeno2").focus();
            $("#j_licenseeno2").select();
            return false;
        }
        if ($("#j_licenseeno3").val().replace(/^\s+|\s+$/g, "") == "") {
            alert("사업자등록번호를 입력 해주세요.");
            $("#j_licenseeno3").focus();
            $("#j_licenseeno3").select();
            return false;
        }

        if ($("#useremailid").val().replace(/^\s+|\s+$/g, "") == "") {
            alert("이메일을 입력 해주세요.");
            $("#useremailid").focus();
            $("#useremailid").select();
            return false;
        }

        if ($("#useremaildomain").val().replace(/^\s+|\s+$/g, "") == "") {
            alert("이메일을 입력 해주세요.");
            $("#useremaildomain").focus();
            $("#useremaildomain").select();
            return false;
        }

        $("#licenseeno").val($("#j_licenseeno1").val() + "-" + $("#j_licenseeno2").val() + "-" + $("#j_licenseeno3").val());
        $("#useremail").val($("#useremailid").val() + "@" + $("#useremaildomain").val());


        if (confirm("사업자등록번호 : " + $("#licenseeno").val() + "\n이메일 : " + $("#useremail").val() + "\n\n입력하신 정보가 맞습니까?")) {

            $("#frm").submit();

        }
    }
</script>

<c:set var="tabtype" value="${param.tabtype }"/>
<c:if test="${tabtype eq null }">
    <c:set var="tabtype" value="1"/>
</c:if>

<c:if test="${success ne true}">
    <!--[s] contents -->
    <section id="contents-wrap">
        <div class="inner-wrap">
            <div class="contents">
                <h3 class="center tmg40">아이디 찾기</h3>

                <nav class="sub-text-tab">
                    <a href="/sds/?menuno=${param.menuno}&act=find_id&tabtype=1">일반회원</a>
                    <a href="#none" class="on">기업회원</a>
                </nav>

                <form name="frm" id="frm" method="post">
                    <input type="hidden" name="licenseeno" id="licenseeno"/>
                    <input type="hidden" name="useremail" id="useremail"/>
                    <div class="middle-wrap bmg50">
                        <div class="border-tb-box">
                            <section class="member-choice-box">
                                <ul class="form-inline-list tmg0 bmg0">
                                    <li><label for="lb-companyno">사업자등록번호</label>
                                        <div class="form-inline">
                                            <ul class="companyno">
                                                <li><input type="text" id="j_licenseeno1" maxlength="3"></li>
                                                <li><input type="text" id="j_licenseeno2" maxlength="2"></li>
                                                <li><input type="text" id="j_licenseeno3" maxlength="5"></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li><label for="lb-email">이메일</label>
                                        <div class="form-inline">
                                            <ul class="email">
                                                <li><input type="text" id="useremailid" name="useremailid"></li>
                                                <li><span>@</span><input type="text" id="useremaildomain" name="useremaildomain"></li>
                                                <li>
                                                    <div class="select-box">
                                                        <label for="lb-email-select">직접입력</label>
                                                        <select id="selectdomain">
                                                            <option value="" selected="selected">직접입력</option>
                                                            <option value="hotmail.com">hotmail.com</option>
                                                            <option value="hanmail.net">hanmail.net</option>
                                                            <option value="daum.net">daum.net</option>
                                                            <option value="naver.com">naver.com</option>
                                                            <option value="nate.com">nate.com</option>
                                                            <option value="gmail.com">gmail.com</option>
                                                        </select>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </section>
                        </div>
                </form>
                <ul class="list-billiard pos-bottom">
                    <li>가입 회원정보(사업자등록번호, 담당자 이메일)와 동일한 정보를 정확히 입력하십시오.</li>
                </ul>
                <div class="btns-box ar">
                    <a href="/sds/?menuno=${param.menuno}" class="btn-basic border">취소</a>
                    <a href="#none" onclick="checkJoin('2')" class="btn-basic" data-rel="pop">확인</a>
                </div>
            </div>
        </div>
        </div>
    </section>
    <!--[e] contents -->
</c:if>

<c:if test="${success eq true}">
    <!--[s] contents -->
    <section id="contents-wrap">
        <div class="inner-wrap">
            <div class="contents">
                <h3 class="center tmg40">아이디 찾기</h3>

                <div class="middle-wrap bmg50">
                    <div class="border-tb-box">
                        <section class="search-id-result">
                            <strong>아이디</strong>
                            <c:set var="idlength" value="${fn:length(user.userid) }"/>
                            <c:set var="userid" value="${fn:substring(user.userid, 0, (idlength-3)) }"/>
                            <span>${userid }***</span>
                        </section>
                    </div>
                    <ul class="list-dot pos-bottom">
                        <li>비밀번호를 찾으시려면 <a href="/sds/?menuno=${param.menuno}&act=find_pw" class="fb fBlk">[비밀번호 찾기]</a>를 이용하십시오.</li>
                        <li>개인정보보호를 위해 끝 3자리는 *로 표시하였습니다.</li>
                        <li>아이디 뒷자리까지 확인이 필요한 경우 KOCCA 고객센터(1544-1114)로 전화 주시기 바랍니다.</li>
                    </ul>
                    <div class="btns-box ar">
                        <a href="/sds/?menuno=${param.menuno}" class="btn-basic">확인</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--[e] contents -->
</c:if>