<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<script type="text/javascript">

    $(function () {

        $("#j_licenseeno1").bind("keyup blur", function () {
            var obj = $(this);
            obj.val(obj.val().replace(/[^\d]/g, ""));
            if (event.type == "keyup") {
                var regu1 = /^\d{3}$/g;
                if (new RegExp(regu1).test(obj.val())) {
                    $("#j_licenseeno2").focus();
                }
            }
        });
        $("#j_licenseeno2").bind("keyup blur", function () {
            var obj = $(this);
            obj.val(obj.val().replace(/[^\d]/g, ""));
            if (event.type == "keyup") {
                var regu1 = /^\d{2}$/g;
                if (new RegExp(regu1).test(obj.val())) {
                    $("#j_licenseeno3").focus();
                }
            }
        });
        $("#j_licenseeno3").bind("keyup blur", function () {
            var obj = $(this);
            obj.val(obj.val().replace(/[^\d]/g, ""));
        });

    });

    function checkJoin(type, no) {

        if (type == "1") {

            if (no == "1") {
                fnNiceMain();
            } else {
                fnIpinMain();
            }

        } else {

            if ($("#j_comname").val().replace(/^\s+|\s+$/g, "") == "") {
                alert("회사명을 입력해주세요.");
                $("#j_comname").focus();
                $("#j_comname").select();
                return false;
            }

            $("#comname").val($("#j_comname").val());

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

            $("#licenseeno").val($("#j_licenseeno1").val() + "-" + $("#j_licenseeno2").val() + "-" + $("#j_licenseeno3").val())

            $("#frm").submit();
        }


    }


    function fnNiceMain() {
        url = "/skin/nice_self/NiceID_main.html";
        window.open(url, "_blank", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=420");
    }

    function fnIpinMain() {
        url = "/skin/ipin/ipin_main.html";
        window.open(url, "_blank", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=420");
    }

    function findpw_submit() {
        location.reload();
    }


</script>

<form name="frm" id="frm" action="/?menuno=${param.menuno }" method="post">
    <input type="hidden" name="act" value="join"/>
    <input type="hidden" name="type" id="type" value="${param.type }"/>
    <input type="hidden" name="comname" id="comname"/>
    <input type="hidden" name="licenseeno" id="licenseeno"/>
</form>

<c:if test="${param.type eq '1'}">
    <!--[s] contents -->
    <section id="contents-wrap">
        <div class="inner-wrap">
            <div class="contents">

                <h3 class="center">회원가입</h3>
                <nav class="join-step">
                    <ul>
                        <li>
                            <div><span>약관동의</span></div>
                        </li>
                        <li class="on">
                            <div><span>본인인증</span></div>
                        </li>
                        <li>
                            <div><span>정보입력</span></div>
                        </li>
                        <li>
                            <div><span>가입완료</span></div>
                        </li>
                    </ul>
                </nav>

                <div class="middle-wrap">
                    <div class="border-tb-box type02 half">
                        <section class="member-choice-box">
                            <h4>본인확인으로 인증</h4>
                            <p>본인확인으로 인증받기는 본인 명의의 휴대폰번호를<br class="m-hide">통하여 인증받는 방식입니다.</p>
                            <a href="#none" onclick="checkJoin('1', '1')" class="btn-large">본인확인 인증</a>
                        </section>
                        <section class="member-choice-box">
                            <h4>I-PIN으로 인증</h4>
                            <p>IPIN을 이용하여 인증하시려면 아래 “아이핀으로 인증받기”<br class="m-hide">버튼을 클릭하여 작성을 진행해 주세요. </p>
                            <a href="#none" onclick="checkJoin('1', '2')" class="btn-large">아이핀 인증</a>
                        </section>
                    </div>
                    <ul class="list-dot pos-bottom">
                        <li>인증받기를 클릭하며 인증창이 팝업으로 생성되오니, 반드시 팝업 허용을 해주시기 바랍니다.</li>
                        <li>입력하신 정보는 회원가입을 위한 본인 확인 용도로만 사용되며, 개인식별코드만 저장을 합니다.</li>
                        <li>타인의 정보 및 주민등록번호를 부정하게 사용하는 경우 3년 이하의 징역 또는 1천만원 이하의 벌금에 처해지게 됩니다. (※관련법률 : 주민등록법 제 37조(벌칙))</li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <!--[e] contents -->

</c:if>

<c:if test="${param.type eq '2'}">
    <!--[s] contents -->
    <section id="contents-wrap">
        <div class="inner-wrap">
            <div class="contents">

                <h3 class="center">회원가입</h3>
                <nav class="join-step">
                    <ul>
                        <li>
                            <div><span>약관동의</span></div>
                        </li>
                        <li class="on">
                            <div><span>본인인증</span></div>
                        </li>
                        <li>
                            <div><span>정보입력</span></div>
                        </li>
                        <li>
                            <div><span>가입완료</span></div>
                        </li>
                    </ul>
                </nav>

                <div class="middle-wrap">
                    <div class="border-tb-box type02">
                        <section class="member-choice-box">
                            <h4>회사명 및 사업자등록번호 인증</h4>
                            <ul class="form-inline-list">
                                <li><label for="lb-company">회사명</label>
                                    <div class="form-inline">
                                        <input type="text" id="j_comname" class="w135">
                                    </div>
                                </li>
                                <li><label for="lb-companyno">사업자등록번호</label>
                                    <div class="form-inline">
                                        <ul class="companyno">
                                            <li><input type="text" id="j_licenseeno1" maxlength="3"></li>
                                            <li><input type="text" id="j_licenseeno2" maxlength="2"></li>
                                            <li><input type="text" id="j_licenseeno3" maxlength="5"></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                            <div class="btns-box">
                                <a href="#none" onclick="checkJoin('2')" class="btn-basic">인증</a>
                            </div>
                        </section>
                    </div>
                    <ul class="list-dot pos-bottom">
                        <li>회원님의 원활한 서비스 제공을 위해 기업의 사업자등록번호 인증을 실시하고 있습니다.</li>
                    </ul>
                </div>
            </div>

        </div>
    </section>
    <!--[e] contents -->
</c:if>

