<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
    <c:if test="${su eq 'true' }">
    alert("이미 가입되어 있습니다.\n로그인해 주시거나 아이디/비밀번호찾기를 이용해 주시기 바랍니다..");
    document.location.href = "/survey/?menuno=${menuno}";
    </c:if>

    history.navigationMode = 'compatible'; // 오페라, 사파리 뒤로가기 막기
    function _no_Back() {
        window.history.forward(0);
    }
</script>
<!--[s] contents -->
<style>
    .paging a, .paging strong, .paging span { margin-left: 1px; width: 42px; }
</style>
<body onload="_no_Back();" onpageshow="if(event.persisted)_no_Back();">
</body>

<!--[s] contents -->
<section id="sub_contents-wrap">
    <div class="location">
        <p><a class="first" href="/sds/?menuno=67">홈</a><strong>회원가입</strong></p>
    </div>
    <h3>회원가입</h3>
    <section class="contents_box bnone tmg10">
        <div class="application-guide-step02">
            <ul>
                <li class="step1"><p>Ⅰ.기관선택</p></li>
                <li class="step2"><p>Ⅱ.개인정보 처리방침</p></li>
                <li class="step3"><p class="on">Ⅲ.정보입력</p></li>
                <li class="step4"><p>Ⅳ.가입완료</p></li>
            </ul>
        </div>
    </section>
    <h4>Ⅲ.정보입력</h4>
    <form name="frm" id="frm" method="post" enctype="multipart/form-data">
        <input type="hidden" name="act" id="act" value="join"/>
        <input type="hidden" name="subname" id="subname" value="${subname}"/>
        <input type="hidden" name="menuno" id="menuno" value="${param.menuno}"/>
        <input type="hidden" name="instndex" id="instndex" value="${param.ndex}"/>
        <input type="hidden" name="instname" id="instname" value="${param.name}"/>
        <table class="tbl-type02" summary="기관명, 기관유형, 주무부처, 아이디, 비밀번호, 비밀번호 확인, 보안질문, 답변, 성명, 부서, 직위, 주소, 전화번호, 팩스, E-Mail">
            <caption>정보입력 페이지</caption>
            <colgroup>
                <col style="width:10%">
                <col style="*">
            </colgroup>
            <tbody>
            <tr>
                <th class="first" scope="row">기관명</th>
                <c:set var="SQUOT">'</c:set>
                <td><c:out value="${fn:replace(param.name, SQUOT, '')}" /></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="userid">아이디</label></th>
                <td>
                    <input id="userid" name="userid" class="w20p" type="text" style="ime-mode:disabled;">
                    <p class="td-comment">* 아이디는 영문, 숫자를 조합한 6~12자리로 입력해주세요.</p>
                </td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="userpw">비밀번호</label></th>
                <td>
                    <input id="userpw" name="userpw" class="w20p" type="password" style="ime-mode:disabled;">
                    <p class="td-comment">* 비밀번호는 영문대소문자를 구분하며, 영문 대소문자, 숫자, 특수문자를 포함한 8~16자리 이상을 입력해주세요.</p>
                </td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="pairpw">비밀번호 확인</label></th>
                <td><input id="pairpw" class="w20p" type="password" style="ime-mode:disabled;"></td>
            </tr>
            <tr>
                <th class="first" scope="row">보안질문</th>
                <td>
                    <div class="select-box">
                        <legend for="question">보안질문</legend>
                        <select id="question" name="question">
                            <option selected="selected">보안질문을 선택하세요</option>
                            <option value="꿈의 직업은 무엇입니까?">꿈의 직업은 무엇입니까?</option>
                            <option value="가장 존경하는 위인은 누구 입니까?">가장 존경하는 위인은 누구 입니까?</option>
                            <option value="첫 직장상사의 이름은 무엇입니까?">첫 직장상사의 이름은 무엇입니까?</option>
                            <option value="학창시절 좋아하던 선생님의 이름은 무엇입니까?">학창시절 좋아하던 선생님의 이름은 무엇입니까?</option>
                            <option value="학창시절 별명은 무엇입니까?">학창시절 별명은 무엇입니까?</option>
                            <option value="학창시절 좋아하던 가수 또는 밴드의 이름은 무엇입니까?">학창시절 좋아하던 가수 또는 밴드의 이름은 무엇입니까?</option>
                            <option value="좋아하는 스포츠 팀의 이름은 무엇입니까?">좋아하는 스포츠 팀의 이름은 무엇입니까?</option>
                            <option value="첫 해외여행지는 어디 입니까?">첫 해외여행지는 어디 입니까?</option>
                            <option value="애완동물의 이름은 무엇입니까?">애완동물의 이름은 무엇입니까?</option>
                            <option value="부모님이 결혼하신 도시의 이름은 무엇 입니까?">부모님이 결혼하신 도시의 이름은 무엇 입니까?</option>
                            <option value="가장 친한 친구의 이름은 무엇입니까?">가장 친한 친구의 이름은 무엇입니까?</option>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="answer">답변</label></th>
                <td><input id="answer" name="answer" class="w100p" type="text"></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="name">성명</label></th>
                <td><input id="name" name="name" class="w20p" type="text"></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="sect">부서</label></th>
                <td><input id="sect" name="sect" class="w20p" type="text"></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="rank">직위</label></th>
                <td><input id="rank" name="rank" class="w20p" type="text"></td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="addr1">주소</label></th>
                <td>
                    <input type="text" id="post" name="post" class="w10p" value="" readonly="readonly">
                    <a href="#pop-zipcode" class="btn-tbl" data-rel="pop">우편번호 찾기</a>
                    <hr class="space">
                    <input type="text" id="addr1" name="addr1" class="w50p" value="" readonly="readonly">
                    <input type="text" id="addr2" name="addr2" class="w30p" value="">
                </td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="tel1">전화번호</label></th>
                <td>
                    <input id="tel1" name="tel1" class="w10p" type="text" value=""> -
                    <input id="tel2" name="tel2" class="w10p" type="text" value=""> -
                    <input id="tel3" name="tel3" class="w10p" type="text" value="">
                </td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="fax1">팩스</label></th>
                <td>
                    <input id="fax1" name="fax1" class="w10p" type="text" value=""> -
                    <input id="fax2" name="fax2" class="w10p" type="text" value=""> -
                    <input id="fax3" name="fax3" class="w10p" type="text" value="">
                </td>
            </tr>
            <tr>
                <th class="first" scope="row"><label for="email1">이메일</label></th>
                <td>
                    <input id="email1" name="email1" class="w10p" type="text" style="text-align:right; ime-mode:disabled;">
                    <span>@</span>
                    <input id="email2" name="email2" class="w20p" type="text" style="text-align:left; ime-mode:disabled;">
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
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    * 아이디/비밀번호 찾기, 자가진단지표 결과 발송에 쓰일 이메일 주소 입니다. 정확하게 입력해 주세요.

    <div class="tmg20 tac"><a class="bt01" id="submit_btn" href="#">확인</a></div>
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

