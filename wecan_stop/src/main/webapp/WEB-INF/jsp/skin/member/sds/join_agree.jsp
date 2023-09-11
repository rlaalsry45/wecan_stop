<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<section id="sub_contents-wrap">
    <div class="location">
        <p><a class="first" href="">홈</a><strong>회원가입</strong></p>
    </div>
    <h3>회원가입</h3>
    <section class="contents_box bnone tmg10">
        <div class="application-guide-step02">
            <ul>
                <li class="step1"><p>Ⅰ.기관선택</p></li>
                <li class="step2"><p class="on">Ⅱ.개인정보 처리방침</p></li>
                <li class="step3"><p>Ⅲ.정보입력</p></li>
                <li class="step4"><p>Ⅳ.가입완료</p></li>
            </ul>
        </div>
    </section>
    <h4>Ⅱ.개인정보 처리방침</h4>
    <section class="join-form">
        <form name="">
            <fieldset>
                <legend>개인정보 수집 및 이용에 관한 동의</legend>
                <textarea readonly="readonly">
                    사회공헌정보센터에서는 사회공헌정보센터 신청서 접수, 심사, 지정 처리를 위하여 개인정보와 고유식별정보(이하 ‘개인정보’)를 수집합니다.
                    개인정보의 수집 및 이용에 동의하시고, 처리에 필요한 필수 정보(*표시)를 입력하시면 관련 신고를 하실 수 있습니다.

                    규정에 근거한 필수 수집 개인정보: 이름, 휴대전화번호, 이메일, 주소 등 수집된 개인정보는 신고처리 이외의 용도로는 이용되지 않으며,
                    수집목적 외 이용 및 제3자 제공 시에는 별도의 동의를 구합니다.
                    위의 규정에 따라 신고처리를 위하여 수집된 개인정보는 약 10년간 보존 후 폐기될 예정입니다.
                    이용자는 신고에서 수집하는 개인정보 제공에 대한 동의를 거부할 권리가 있습니다.
                    다만, 신고처리에 필요한 필수 항목의 제공에 대한 동의를 거부하시면 위의 서비스가 제한됩니다.

                    내용이 추가됩니다.
                </textarea>
                <div class="agree-radio">
                    <label for="agree">동의합니다</label><input id="agree" type="radio" value="1">
                    <label for="deny">동의하지 않습니다.</label><input id="deny" type="radio" value="0">
                </div>
            </fieldset>
        </form>
    </section>
    <div class="tmg20 tac">
        <a class="bt01" href="#none" onclick="agree()">확인</a>
    </div>
</section>

<form name="frm" id="frm" action="/sds/?menuno=${param.menuno}" method="post">
    <input type="hidden" name="act" value="join"/>
    <input type="hidden" name="ndex" value="${param.ndex}"/>
    <input type="hidden" name="name" value="${param.name}"/>
</form>

<script type="text/javascript">
    $(function () {
        $("#agree").bind("click", function () {
            $("#deny").prop('checked', false);
        });
        $("#deny").bind("click", function () {
            $("#agree").prop('checked', false);
        });
    });

    function agree() {
        var agree = $(':radio[id="agree"]:checked').val();
        if (agree != "1") {
            alert("개인정보 수집 및 이용에 동의하셔야 가입이 가능합니다.");
            $("#agree").focus();
            return;
        }
        $("#frm").submit();
    }
</script>
