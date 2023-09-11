<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<section id="content">
    <h3 class="tac">로그인</h3>
    <div class="small-wrap">
        <section class="login-form">
            <div class="login-form-in">
                <form action="/j_spring_security_check" method="post" id="signin" onsubmit="return ready(event);">
                    <input type="hidden" name="_from" value="${_from}"/>
                    <input type="hidden" name="_to" value="${_to}"/>
                    <fieldset>
                        <legend>로그인 폼</legend>
                        <input type="text" name="j_username" id="username" onkeypress="ready(event)" placeholder="아이디">
                        <span id="alert-id" style="display: none; color:red;">아이디 입력하여 주세요!</span>
                        <input type="password" name="j_password" id="password" title="비밀번호 입력" onkeypress="ready(event)" placeholder="비밀번호">
                        <span id="alert-pw" style="display: none; color:red;">비밀번호를 입력하여 주세요!</span>
                        <span id="alert-ng" style="display: none; color:red;">입력한 아이디와 비밀번호가 일치하지 않습니다. 아이디 또는 비밀번호를 다시 한번 입력해 주세요!</span>
                        <input type="submit" value="로그인">
                    </fieldset>
                </form>
            </div>
            <p class="tac mt20">유관기관 및 교원분들만 로그인이 가능합니다.<br/>회원가입을 원하시는 유관기관 및 교원분들은 <a href="mailto:dmh@nile.or.kr">dmh@nile.or.kr</a>로 문의해주세요</p>
        </section>
    </div>
</section>
