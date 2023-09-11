<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
    history.navigationMode = 'compatible'; // 오페라, 사파리 뒤로가기 막기
    function _no_Back() {
        window.history.forward(0);
    }
</script>

<body onload="_no_Back();" onpageshow="if(event.persisted)_no_Back();">
</body>

<section id="sub_contents-wrap">
    <div class="location">
        <p><a class="first" href="">홈</a><strong>회원가입</strong></p>
    </div>
    <h3>회원가입</h3>
    <section class="contents_box bnone tmg10">
        <div class="application-guide-step02">
            <ul>
                <li class="step1">
                    <p>Ⅰ.기관선택</p>
                </li>
                <li class="step2">
                    <p>Ⅱ.개인정보 처리방침</p>
                </li>
                <li class="step3">
                    <p>Ⅲ.정보입력</p>
                </li>
                <li class="step4">
                    <p class="on">Ⅳ.가입완료</p>
                </li>
            </ul>
        </div>
    </section>
    <p class="tac font01 tmg30">회원가입을 감사 드립니다!</p>
    <hr class="line02 tmg30">
    <ul class="loginfoot W04">
        <li><a href="/sds/?menuno=68">이용안내</a></li>
        <li><a href="/sds/?menuno=69">온라인 자가진단</a></li>
        <li><a href="/sds/?menuno=70">커뮤니티</a></li>
        <%--<li><a href="/survey/?menuno=97">마이페이지</a></li>--%>
        <li><a href="/sds/?menuno=90">Q &amp; A</a></li>
    </ul>
    <hr class="line01 tmg30">
    <ul class="list-dot tmg30">
        <li>기관당 다수의 ID 가입이 가능하며, 기관관리 ID를 지정하실 수 있습니다.
            <br />(기관관리 ID는 해당기관에 처음 가입한 회원이며, 마이 페이지에서 변경/권한인계를 하실 수 있습니다.)</li>
        <li>회원자격의 유효기간은 3년이며, 유효기간 전 로그인을 통하여 자격을 연장하실 수 있습니다.
            <br />(유효기간 만료 3개월 전부터 로그인 시 유효기간 만료 알림 알럿이 보여집니다.)</li>
        <li>기관등록을 하신 후 회원가입을 완료하신 경우 시스템 운영자의 승인완료 후 자가진단평가를 이용하실 수 있습니다.</li>
    </ul>
</section>













