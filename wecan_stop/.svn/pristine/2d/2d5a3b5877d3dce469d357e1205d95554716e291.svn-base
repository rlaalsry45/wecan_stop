<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
    function checkJoin(act) {
        $("#act").val(act);
        $("#frm").submit();
    }
</script>

<form name="frm" id="frm" action="/sds/?menuno=${param.menuno}" method="post">
    <input type="hidden" name="act" id="act"/>
</form>

<section id="sub_contents-wrap">
    <div class="location">
        <p>
            <a class="first" href="/sds/?menuno=67">홈</a>
            <a href="/sds/?menuno=98">마이페이지</a>
            <strong>정보변경</strong>
        </p>
    </div>
    <h3>정보변경</h3>
    <ul class="mygate tmg30">
        <li>
            <div class="box g04">
                <p>
                    <a href="">
                        <strong>회원탈퇴</strong><br/>
                        <span>
                            회원탈퇴 시 동일한 ID로 재가입 할 수 없으며<br/>
                            회원님의 개인정보는 삭제 됩니다.<br/>
                            단, 회원님께서 진행하신 자가진단 지표의 결과는<br/>
                            통계에 반영 됩니다.
                        </span>
                    </a>
                    <a class="bt01 tmg20" href="#none" onclick="checkJoin('userout')">회원탈퇴</a>
                </p>
            </div>
        </li>
        <li>
            <div class="box g05">
                <p>
                    <a href="">
                        <strong>회원정보변경</strong><br/>
                        <span>회원님의 정보변경이 필요하신 경우 신청해 주세요.<br/><br/><br/><br/></span>
                    </a>
                    <a class="bt01 tmg20" href="#none" onclick="checkJoin('usermodify')">정보변경</a>
                </p>
            </div>
        </li>
    </ul>
</section>
