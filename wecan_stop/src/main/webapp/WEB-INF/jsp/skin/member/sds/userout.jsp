<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<script type="text/javascript">
    <c:if test="${sessionScope.zUserVo eq null}">
    <%--location.href = "/survey/?menuno=${param.menuno}";--%>
    location.href = "/survey/?menuno=67";
    </c:if>

    $(document).ready(function() {
        $(document).on("click", "#secession", function () {
            if ($("#password").val() == "") {
                alert("비밀번호를 입력해 주십시요.");
                $("#password").focus();
                return false;
            }

            var password = $("#password").val();
            var causedby = "";
            if (confirm("정말로 탈퇴 하시겠습니까?")) {
                $.ajax({
                    type     : "POST"
                    , async  : true
                    , url    : "/front/user/memberoutchk.html"
                    , thpe   : "json"
                    , data   : "pass=" + password + "&cancelreason=" + causedby
                    , success: function (data) {
                        if (data == "success") {
                            alert("정상적으로 처리 되었습니다.");
                            document.location.href = "/survey/?menuno=67";
                            return true;
                        } else if (data == "nopass") {
                            alert("비밀번호가 다릅니다");
                        } else {
                            alert("비밀번호 확인에 실패했습니다.\n잠시 후 다시 시도해 주시기 바랍니다.");
                        }
                    }
                    , error  : function (data, status, err) {
                        alert('서버와의 통신이 실패했습니다.');
                    }
                });
            }

            $("#password").val('');
            $("#password").focus();
            return false;
        });
    });
</script>
<section id="sub_contents-wrap">
    <div class="location">
        <p>
            <a class="first" href="/sds/?menuno=67">홈</a>
            <a href="/sds/?menuno=98">마이페이지</a>
            <a href="/sds/?menuno=72&act=usermodify_chk">정보변경</a>
            <strong>회원탈퇴</strong>
        </p>
    </div>
    <h3>회원정보변경</h3>
    <div class="MgcTac w50p">
        <p>개인정보를 변경하시려면 비밀번호를 입력하셔야 합니다.</p>
        <span>회원님의 개인 정보 보호를 위한 본인확인 절차이오니, <br/> 로그인 시 사용하시는 비밀번호를 입력해주세요 </span>
    </div>
    <div class="pop-wrap-inner mc zipcode">
        <div>
            <section class="login-form Pa">
                <div class="login-form-in">
                    <form name="">
                        <fieldset>
                            <legend>회원탈퇴 폼</legend>
                            <input type="password" id="password" title="비밀번호 입력" placeholder="비밀번호를 입력해주세요">
                            <input type="submit" id="secession" value="확인">
                        </fieldset>
                    </form>
                </div>
            </section>
        </div>
    </div>

</section>
