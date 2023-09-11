<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
    <c:if test="${sessionScope.zUserVo ne null}">
    alert("Already login.");
    location.href = "/";
    </c:if>

    window.onload = function () {
        if ("true" == "${param.fail}") {
            alert("Invalid username!")
        } else if ("true" == "${param.pwfail}") {
            alert("Invalid password!")
        } else {
            document.getElementById('username').focus();
        }
    }

    function ready(event) {
        if (event.type == 'submit' || (event.type == 'keydown' && event.keyCode == 13)) {
            if (document.getElementById('username').value == "") {
                alert("Please input ID!");
                document.getElementById('username').focus();
                return false;
            } else if (document.getElementById('password').value == "") {
                alert("Please input password!");
                document.getElementById('password').focus();
                return false;
            }
            document.getElementById('signin').submit();
        }
    }
</script>
<section class="contents" id="top">
    <h4>Please Signin</h4>
    <a class="print" href="#">print</a>
    <section class="login-form">
        <div class="login-form-in">
            <form action="/j_spring_security_check" method="post" id="signin" onsubmit="return ready(event);">
                <input type="hidden" name="_from" value="/?menuno=${param.menuno }"/>
                <fieldset>
                    <legend>Please Sign In</legend>
                    <input type="text" name="j_username" id="username" title="ID" placeholder="Enter the ID" onkeypress="ready(event)"/>
                    <input type="password" name="j_password" id="password" title="PASSWORD" placeholder="Enter the password" onkeypress="ready(event)"/>
                    <input type="submit" value="Signin" onclick="window.location='/?menuno=110';"/>
                </fieldset>
            </form>
        </div>
        <h5 class="tac none">Asia BCH Family members</h5>
        <ul>
            <li>
                Asia BCH Family members, the administrator to specify the ID / Password,
                and then transferred via the e-mail to the countries of the person in charge.
            </li>
            <li>
                Please contact via e-mail(<a class="mail" href="mailto:whkim7@kribb.re.kr">whkim7@kribb.re.kr</a>)
                to the administrator at the time of Password loss.
            </li>
        </ul>
    </section>
</section>
