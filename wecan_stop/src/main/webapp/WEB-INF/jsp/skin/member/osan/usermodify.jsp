<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
    window.onload = function () {
        if ("true" == "${param.sessionout}") {
            alert("세션시간이 끝났습니다. 다시 로그인해 주세요");
            window.location.href = "/survey/?menuno=" + "${param.menuno}";
        }
        if ("true" == "${param.modifysuccess}") {
            alert("회원정보가 수정되었습니다.");
            window.location.href = "/survey/?menuno=72&act=usermodify_chk";
        }
    }
</script>
<style>
    #paging a, #paging strong, #paging span {
        margin-left: 1px;
        width: 42px;
    }
</style>

<!--[s] contents -->
<section id="sub_contents-wrap">
    <div class="location">
        <p><a class="first" href="">홈</a><strong>회원정보변경</strong></p>
    </div>
    <h3>회원정보변경</h3>
    <form name="frm" id="frm" method="post">
        <input type="hidden" name="act" id="act"/>
        <input type="hidden" name="menuno" id="menuno" value="${param.menuno}"/>
        <input type="hidden" name="subname" id="subname" value="${subname}"/>
        <table class="tbl-type02" summary="기관명, 기관유형, 주무부처, 아이디, 비밀번호, 비밀번호 확인, 보안질문, 답변, 성명, 부서, 직위, 주소, 전화번호, 팩스, E-Mail">
            <caption>정보입력 페이지</caption>
            <colgroup>
                <col style="width:10%">
                <col style="*">
            </colgroup>
            <tbody>
            <tr>
                <th class="first" scope="row">기관명</th>
                <td><span class="w20p">${userdata.comname}</span>
            </tr>
            <tr>
                <th class="first" scope="row">기관유형</th>
                <td>${instdata.type}</td>
            </tr>
            <tr>
                <th class="first" scope="row">주무부처</th>
                <td>${instdata.arch}</td>
            </tr>
            <tr>
                <th class="first" scope="row">아이디</th>
                <td>${userdata.userid}</td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="userpw">비밀번호</label></th>
                <td>
                    <input id="userpw" name="userpw" class="w20p" type="password">
                    <p class="td-comment">* 비밀번호는 영문대소문자를 구분하며, 영문 대소문자, 숫자, 특수문자를 포함한 8~16자리 이상을 입력해주세요.</p>
                </td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="pairpw">비밀번호 확인</label></th>
                <td><input id="pairpw" class="w20p" type="password"></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="name">성명</label></th>
                <td><input id="name" name="name" class="w20p" type="text" value="${userdata.username}"></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="sect">부서</label></th>
                <td><input id="sect" name="sect" class="w20p" type="text" value="${userdata.work_title}"></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="rank">직위</label></th>
                <td><input id="rank" name="rank" class="w20p" type="text" value="${userdata.work_grade}"></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="addr1">주소</label></th>
                <td>
                    <input type="text" id="post" name="post" class="w10p" value="${userdata.useraddrno}" readonly="readonly">
                    <a href="#pop-zipcode" class="btn-tbl" data-rel="pop">우편번호 찾기</a>
                    <hr class="space">
                    <input type="text" id="addr1" name="addr1" class="w50p" value="${userdata.useraddr}" readonly="readonly">
                    <input type="text" id="addr2" name="addr2" class="w30p" value="${userdata.useraddr2}">
                </td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="tel1">전화번호</label></th>
                <td>
                    <c:set var="usertel" value="${fn:split(user.usertel,'-')}"/>
                    <input id="tel1" name="tel1" class="w10p" type="text" value="${usertel[0]}"> -
                    <input id="tel2" name="tel2" class="w10p" type="text" value="${usertel[1]}"> -
                    <input id="tel3" name="tel3" class="w10p" type="text" value="${usertel[2]}">
                </td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="fax1">팩스</label></th>
                <td>
                    <c:set var="userfax" value="${fn:split(user.userfax,'-')}"/>
                    <input id="fax1" name="fax1" class="w10p" type="text" value="${userfax[0]}"> -
                    <input id="fax2" name="fax2" class="w10p" type="text" value="${userfax[1]}"> -
                    <input id="fax3" name="fax3" class="w10p" type="text" value="${userfax[2]}"></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="email1">이메일</label></th>
                <td>
                    <c:set var="email" value="${fn:split(user.useremail,'@')}"/>
                    <input id="email1" name="email1" class="w10p" type="text" value="${email[0]}">
                    <span>@</span>
                    <input id="email2" name="email2" class="w20p" type="text" value="${email[1]}">
                    <div class="select-box">
                        <label for="email-domain">직접입력</label>
                        <select id="email-domain">
                            <option selected="selected">직접입력</option>
                            <option value="hotmail.com">hotmail.com</option>
                            <option value="hanmail.net">hanmail.net</option>
                            <option value="daum.net">daum.net</option>
                            <option value="naver.com">naver.com</option>
                            <option value="gmail.com">gmail.com</option>
                        </select>
                    </div>
                    <p class="tmg10">* 아이디/비밀번호 찾기, 자가진단지표 결과 발송에 쓰일 이메일 주소 입니다. 정확하게 입력해 주세요.</p>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="tmg20 tac">
            <a class="bt01 border" href="/sds/?menuno=72&act=usermodify_chk">취소</a>
            <a class="bt01" href="#none" id="submit_btn">확인</a>
        </div>
    </form>
</section>
<!--[e] contents -->

<!-- [s] 우편번호 팝업 -->
<div id="pop-zipcode" class="pop-wrap">
    <div class="pop-wrap-inner zipcode">
        <header>
            <h2>우편번호 검색</h2>
        </header>
        <section class="pop-contents">
            <nav class="sub-text-tab tab">
                <a href="" class="on">주소검색(도로명, 지번)</a>
            </nav>
            <div class=.pop-cont tab-cont">
                <p>예) <span class="fBlk">도화동, 도화</span>, 도화동 560, 도화동 현대아파트, 도움5로 19</p>
                <div class="pop-search">
                    <dl>
                        <dt>
                            <label for="addr-search">주소</label>
                        </dt>
                        <dd>
                            <input type="text" class="w50p" id="dong" onKeyDown="if(event.keyCode == 13){pop_postcode()}">
                            <a id="addr-search" href="#none" onclick="pop_postcode()" class="btn-tbl small">검색</a>
                        </dd>
                    </dl>
                </div>
            </div>
            <div class="pop-result">
                <p></p>
                <div class="pop-result-scroll">
                    <table>
                        <caption>우편번호 조회결과</caption>
                        <colgroup>
                            <col style="width:11%;">
                            <col style="width:18%">
                            <col style="width:*">
                            <col style="width:15%;">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>NO</th>
                            <th>우편번호</th>
                            <th>주소</th>
                            <th>선택</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td colspan="4">조회된 결과가 없습니다.</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="paging" class="paging"></div>
        </section>
        <a href="#pop-confirm" class="pop-close heading">레이어 팝업닫기</a>
    </div>
</div>
<!-- [e] 우편번호 팝업 -->
