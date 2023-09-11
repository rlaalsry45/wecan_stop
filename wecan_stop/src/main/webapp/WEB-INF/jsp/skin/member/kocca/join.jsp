<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">

    <c:if test="${su eq 'true' }">
    alert("이미 가입되어 있습니다.\n로그인해 주시거나 아이디/비밀번호찾기를 이용해 주시기 바랍니다..");
    document.location.href = "/?menuno=${menuno}";
    </c:if>

    history.navigationMode = 'compatible'; // 오페라, 사파리 뒤로가기 막기
    function _no_Back() {
        window.history.forward(0);
    }
</script>
<!--[s] contents -->
<style>
    #paging a, #paging strong, #paging span {
        margin-left: 1px;
        width: 42px;
    }
</style>
<body onload="_no_Back();" onpageshow="if(event.persisted)_no_Back();">
</body>
<input type="hidden" id="type" value="${param.type }"/>
<input type="hidden" id="btn_id"/>
<c:if test="${param.type eq '1' }">
    <section id="contents-wrap">
        <div class="inner-wrap">
            <div class="contents">

                <h3 class="center">회원가입</h3>
                <nav class="join-step">
                    <ul>
                        <li>
                            <div><span>약관동의</span></div>
                        </li>
                        <li>
                            <div><span>본인인증</span></div>
                        </li>
                        <li class="on">
                            <div><span>정보입력</span></div>
                        </li>
                        <li>
                            <div><span>가입완료</span></div>
                        </li>
                    </ul>
                </nav>

                <form name="frm" id="frm" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="act" id="act" value="join"/>
                    <input type="hidden" name="menuno" id="menuno" value="${menuno }"/>
                    <input type="hidden" name="userbirth" id="userbirth"/>
                    <input type="hidden" name="work_grade" value="1"/>
                    <div class="necessary">
                        <p><span class="ico-necessary">체크</span>는 필수입력 사항입니다.</p>
                    </div>

                    <div class="tbl-box">
                        <fieldset>
                            <legend>일반회원 회원정보 입력</legend>
                            <table class="tbl-type01">
                                <caption>일반회원 가입폼</caption>
                                <colgroup>
                                    <col style="width:180px">
                                    <col style="width:*">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th><label for="lb-name"><span class="ico-necessary">체크</span>성명</label></th>
                                    <td><input type="text" id="username" name="username" class="w30p" value="<%=(String)session.getAttribute("niceName")%>"
                                               readonly="readonly"></td>
                                </tr>
                                <tr>


                                    <th><span class="ico-necessary">체크</span>생년월일</th>
                                    <td>
                                        <c:set var="birthYear" value="${fn:substring(sessionScope.sBirthDate, 0, 4)}"/>
                                        <c:set var="birthMonth" value="${fn:substring(sessionScope.sBirthDate, 4, 6)}"/>
                                        <c:set var="birthDay" value="${fn:substring(sessionScope.sBirthDate, 6, 8)}"/>
                                        <div class="select-box">
                                            <select id="userbirthyear">
                                                <option value="${birthYear }">${birthYear }</option>
                                            </select>
                                        </div>
                                        <div class="select-box">
                                            <select id="userbirthmonth">
                                                <option value="${birthMonth }">${birthMonth }</option>
                                            </select>
                                        </div>
                                        <div class="select-box">
                                            <select id="userbirthday">
                                                <option value="${birthDay }">${birthDay }</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-id"><span class="ico-necessary">체크</span>아이디</label></th>
                                    <td>
                                        <input type="text" id="userid" name="userid" class="w30p">
                                        <!-- <a href="" class="btn-tbl">중복확인</a> -->
                                        <p class="td-comment">* 6~30자리(특수문자 사용 불가)</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-pwd"><span class="ico-necessary">체크</span>비밀번호</label></th>
                                    <td>
                                        <input type="password" id="userpasswd" name="userpasswd" class="w30p">
                                        <p class="td-comment">* 영문 대소문자/숫자/특수문자 중 두가지 이상 조합으로 8~16자리</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-pwd-re"><span class="ico-necessary">체크</span>비밀번호 확인</label></th>
                                    <td>
                                        <input type="password" id="userpasswdchk" name="userpasswdchk" class="w30p">
                                    </td>
                                </tr>
                                <tr>
                                    <th><span class="ico-necessary">체크</span>전화번호</th>
                                    <td>
                                        <div class="select-box">
                                            <label for="lb-hp">선택</label>
                                            <select id="usertel1" name="usertel1">
                                                <option value="" selected="selected">선택</option>
                                                <option value="02">02</option>
                                                <option value="031">031</option>
                                                <option value="032">032</option>
                                                <option value="033">033</option>
                                                <option value="041">041</option>
                                                <option value="042">042</option>
                                                <option value="043">043</option>
                                                <option value="044">044</option>
                                                <option value="051">051</option>
                                                <option value="052">052</option>
                                                <option value="053">053</option>
                                                <option value="054">054</option>
                                                <option value="055">055</option>
                                                <option value="0505">0505</option>
                                                <option value="061">061</option>
                                                <option value="062">062</option>
                                                <option value="063">063</option>
                                                <option value="064">064</option>
                                                <option value="070">070</option>
                                            </select>
                                        </div>
                                        <span>-</span>
                                        <input type="text" id="usertel2" name="usertel2" maxlength="4" class="w10p"> <span>-</span>
                                        <input type="text" id="usertel3" name="usertel3" maxlength="4" class="w10p">
                                    </td>
                                </tr>
                                <tr>
                                    <th><span class="ico-necessary">체크</span>휴대폰 번호</th>
                                    <td>
                                        <div class="select-box">
                                            <label for="lb-cp">선택</label>
                                            <select id="usermobile1" name="usermobile1">
                                                <option value="" selected="selected">선택</option>
                                                <option value="010">010</option>
                                                <option value="011">011</option>
                                                <option value="016">016</option>
                                                <option value="017">017</option>
                                                <option value="018">018</option>
                                                <option value="019">019</option>
                                            </select>
                                        </div>
                                        <span>-</span>
                                        <input type="text" class="w10p" maxlength="4" id="usermobile2" name="usermobile2"> <span>-</span>
                                        <input type="text" class="w10p" maxlength="4" id="usermobile3" name="usermobile3">
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-email"><span class="ico-necessary">체크</span>이메일주소</label></th>
                                    <td>
                                        <input type="text" id="useremailid" name="useremailid" class="w10p"> <span>@</span>
                                        <input type="text" id="useremaildomain" name="useremaildomain" class="w20p">
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
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-zip"><span class="ico-necessary">체크</span>주소</label></th>
                                    <td>
                                        <input type="text" id="useraddrno1" name="useraddrno1" class="w10p" readonly="readonly">
                                        <a href="#pop-zipcode" id="useraddrno_btn" class="btn-tbl">우편번호 찾기</a>
                                        <hr class="space">
                                        <input type="text" id="useraddr" name="useraddr" class="w50p" readonly="readonly">
                                        <input type="text" id="useraddr2" name="useraddr2" class="w30p">
                                    </td>
                                </tr>
                                </tbody>
                            </table>

                        </fieldset>
                    </div>
                    <div class="btns-box ar">
                        <a href="" class="btn-basic border">취소</a>
                        <a id="submit_btn" href="#none" class="btn-basic">확인</a>
                    </div>
                </form>

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
                        <li>
                            <div><span>본인인증</span></div>
                        </li>
                        <li class="on">
                            <div><span>정보입력</span></div>
                        </li>
                        <li>
                            <div><span>가입완료</span></div>
                        </li>
                    </ul>
                </nav>

                <form name="frm2" id="frm2" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="act" id="act" value="join"/>
                    <input type="hidden" name="menuno" id="menuno" value="${menuno }"/>
                    <input type="hidden" name="userbirth" id="userbirth"/>
                    <input type="hidden" name="work_grade" value="2"/>
                    <h4>로그인 정보</h4>
                    <div class="necessary">
                        <p><span class="ico-necessary">체크</span>는 필수입력 사항입니다.</p>
                    </div>

                    <div class="tbl-box">
                        <fieldset>
                            <legend>기업회원 회원정보 입력</legend>
                            <table class="tbl-type01">
                                <caption>기업회원 로그인 정보 입력</caption>
                                <colgroup>
                                    <col style="width:180px">
                                    <col style="width:*">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th><label for="lb-id"><span class="ico-necessary">체크</span>아이디</label></th>
                                    <td>
                                        <input type="text" id="userid" name="userid" class="w30p">
                                        <!-- <a href="" class="btn-tbl">중복확인</a> -->
                                        <p class="td-comment">* 6~30자리(특수문자 사용 불가)</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-pwd"><span class="ico-necessary">체크</span>비밀번호</label></th>
                                    <td>
                                        <input type="password" id="userpasswd" name="userpasswd" class="w30p">
                                        <p class="td-comment">* 영문 대소문자/숫자/특수문자 중 두가지 이상 조합으로 8~16자리</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-pwd-re"><span class="ico-necessary">체크</span>비밀번호 확인</label></th>
                                    <td>
                                        <input type="password" id="userpasswdchk" name="userpasswdchk" class="w30p">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </fieldset>
                    </div>


                    <h4>기업체 정보</h4>
                    <div class="necessary">
                        <p><span class="ico-necessary">체크</span>는 필수입력 사항입니다.</p>
                    </div>

                    <div class="tbl-box">
                        <fieldset>
                            <legend>기업체 정보 입력</legend>
                            <table class="tbl-type01">
                                <caption>기업회원 기업체 정보 입력</caption>
                                <colgroup>
                                    <col style="width:180px">
                                    <col style="width:*">
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th><span class="ico-necessary">체크</span>기업명</th>
                                    <td><input type="text" id="comname" name="comname" value="${param.comname }" style="border: 0px" class="w30p"
                                               readonly="readonly"></td>
                                </tr>
                                <tr>
                                    <th><span class="ico-necessary">체크</span>사업자번호</th>
                                    <td><input type="text" id="licenseeno" name="licenseeno" value="${param.licenseeno }" style="border: 0px" class="w30p"
                                               readonly="readonly"></td>
                                </tr>
                                <tr>
                                    <th><span class="ico-necessary">체크</span>회사 전화번호</th>
                                    <td>
                                        <div class="select-box">
                                            <label for="lb-hp">선택</label>
                                            <select id="comtel1" name="comtel1">
                                                <option value="" selected="selected">선택</option>
                                                <option value="02">02</option>
                                                <option value="031">031</option>
                                                <option value="032">032</option>
                                                <option value="033">033</option>
                                                <option value="041">041</option>
                                                <option value="042">042</option>
                                                <option value="043">043</option>
                                                <option value="044">044</option>
                                                <option value="051">051</option>
                                                <option value="052">052</option>
                                                <option value="053">053</option>
                                                <option value="054">054</option>
                                                <option value="055">055</option>
                                                <option value="0505">0505</option>
                                                <option value="061">061</option>
                                                <option value="062">062</option>
                                                <option value="063">063</option>
                                                <option value="064">064</option>
                                                <option value="070">070</option>
                                            </select>
                                        </div>
                                        <span>-</span>
                                        <input type="text" id="comtel2" name="comtel2" maxlength="4" class="w10p"> <span>-</span>
                                        <input type="text" id="comtel3" name="comtel3" maxlength="4" class="w10p">
                                    </td>
                                </tr>
                                <tr>
                                    <th>팩스번호</th>
                                    <td>
                                        <div class="select-box">
                                            <label for="lb-fax">선택</label>
                                            <select id="userfax1" name="userfax1">
                                                <option value="" selected="selected">선택</option>
                                                <option value="02">02</option>
                                                <option value="031">031</option>
                                                <option value="032">032</option>
                                                <option value="033">033</option>
                                                <option value="041">041</option>
                                                <option value="042">042</option>
                                                <option value="043">043</option>
                                                <option value="044">044</option>
                                                <option value="051">051</option>
                                                <option value="052">052</option>
                                                <option value="053">053</option>
                                                <option value="054">054</option>
                                                <option value="055">055</option>
                                                <option value="0505">0505</option>
                                                <option value="061">061</option>
                                                <option value="062">062</option>
                                                <option value="063">063</option>
                                                <option value="064">064</option>
                                                <option value="070">070</option>
                                            </select>
                                        </div>
                                        <span>-</span>
                                        <input type="text" id="userfax2" name="userfax2" maxlength="4" class="w10p"> <span>-</span>
                                        <input type="text" id="userfax3" name="userfax3" maxlength="4" class="w10p">
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-zip"><span class="ico-necessary">체크</span>회사주소</label></th>
                                    <td>
                                        <input type="text" id="comaddrno" name="comaddrno" class="w10p" readonly="readonly"><a href="#pop-zipcode"
                                                                                                                               id="comaddrno_btn"
                                                                                                                               class="btn-tbl">우편번호 찾기</a>
                                        <hr class="space">
                                        <input type="text" id="comaddr" name="comaddr" class="w50p" readonly="readonly">
                                        <input type="text" id="comaddr2" name="comaddr2" class="w30p">
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-name"><span class="ico-necessary">체크</span>대표자명</label></th>
                                    <td><input type="text" id="username" name="username" class="w30p"></td>
                                </tr>
                                <tr>
                                    <th><span class="ico-necessary">체크</span>대표자 휴대폰 번호</th>
                                    <td>
                                        <div class="select-box">
                                            <label for="lb-cp">선택</label>
                                            <select id="usermobile1" name="usermobile1">
                                                <option value="" selected="selected">선택</option>
                                                <option value="010">010</option>
                                                <option value="011">011</option>
                                                <option value="016">016</option>
                                                <option value="017">017</option>
                                                <option value="018">018</option>
                                                <option value="019">019</option>
                                            </select>
                                        </div>
                                        <span>-</span>
                                        <input type="text" id="usermobile2" name="usermobile2" maxlength="4" class="w10p"> <span>-</span>
                                        <input type="text" id="usermobile3" name="usermobile3" maxlength="4" class="w10p">
                                    </td>
                                </tr>
                                <tr>
                                    <th><span class="ico-necessary">체크</span>대표자 생년월일</th>
                                    <td>
                                        <div class="select-box">
                                            <label for="lb-birth01">2016</label>
                                            <select id="userbirthyear">
                                            </select>
                                        </div>
                                        <div class="select-box">
                                            <label for="lb-birth02">04</label>
                                            <select id=userbirthmonth>
                                            </select>
                                        </div>
                                        <div class="select-box">
                                            <label for="lb-birth03">04</label>
                                            <select id="userbirthday">
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-zip2"><span class="ico-necessary">체크</span>대표자 주소</label></th>
                                    <td>
                                        <input type="text" id="useraddrno1" name="useraddrno1" class="w10p" readonly="readonly">
                                        <a href="#pop-zipcode" id="useraddrno_btn" class="btn-tbl">우편번호 찾기</a>
                                        <hr class="space">
                                        <input type="text" id="useraddr" name="useraddr" class="w50p" readonly="readonly">
                                        <input type="text" id="useraddr2" name="useraddr2" class="w30p">
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-name2"><span class="ico-necessary">체크</span>담당자명</label></th>
                                    <td><input type="text" id="chargername" name="chargername" class="w30p"></td>
                                </tr>
                                <tr>
                                    <th><span class="ico-necessary">체크</span>담당자 휴대폰 번호</th>
                                    <td>
                                        <div class="select-box">
                                            <label for="lb-cp2">선택</label>
                                            <select id="chargemobile1" name="chargemobile1">
                                                <option value="" selected="selected">선택</option>
                                                <option value="010">010</option>
                                                <option value="011">011</option>
                                                <option value="016">016</option>
                                                <option value="017">017</option>
                                                <option value="018">018</option>
                                                <option value="019">019</option>
                                            </select>
                                        </div>
                                        <span>-</span>
                                        <input type="text" id="chargemobile2" name="chargemobile2" maxlength="4" class="w10p"> <span>-</span>
                                        <input type="text" id="chargemobile3" name="chargemobile3" maxlength="4" class="w10p">
                                    </td>
                                </tr>
                                <tr>
                                    <th><label for="lb-email"><span class="ico-necessary">체크</span>담당자 이메일</label></th>
                                    <td>
                                        <input type="text" id="chargeremailid" name="chargeremailid" class="w10p"> <span>@</span>
                                        <input type="text" id="chargeremaildomain" name="chargeremaildomain" class="w20p">
                                        <div class="select-box">
                                            <label for="lb-email-select">직접입력</label>
                                            <select id="selectdomain2">
                                                <option value="" selected="selected">직접입력</option>
                                                <option value="hotmail.com">hotmail.com</option>
                                                <option value="hanmail.net">hanmail.net</option>
                                                <option value="daum.net">daum.net</option>
                                                <option value="naver.com">naver.com</option>
                                                <option value="nate.com">nate.com</option>
                                                <option value="gmail.com">gmail.com</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </fieldset>
                    </div>
                    <div class="btns-box ar">
                        <a href="" class="btn-basic border">취소</a>
                        <a id="submit_btn" href="#none" class="btn-basic">확인</a>
                    </div>
                </form>

            </div>
        </div>
    </section>
    <!--[e] contents -->
</c:if>

<div id="dimmed"></div>
<!-- [s] 우편번호 팝업 -->
<div id="pop-zipcode" class="pop-wrap">
    <div class="pop-wrap-inner zipcode">
        <header>
            <h2>우편번호 검색</h2>
        </header>
        <section class="pop-contents">
            <nav class="sub-text-tab tab">
                <a href="" class="on">주소검색(도로명, 지번)</a>
                <!-- <a href="">도로명주소</a> -->
            </nav>

            <!-- [s] addr -->
            <div class=.pop-cont tab-cont">
                <p>
                    <!-- <strong>검색방법 : 시·도 및 시·군·구 선택 → 읍, 면, 동으로 입력</strong><br> -->
                    예) <span class="fBlk">도화동, 도화</span>, 도화동 560, 도화동 현대아파트, 도움5로 19
                </p>
                </p>
                <div class="pop-search">
                    <dl>
                        <!-- <dt>시도</dt>
                        <dd>
                            <div class="select-box">
                                <label for="lb-sido">서울특별시</label>
                                <select id="lb-sido">
                                    <option selected="selected">서울특별시</option>
                                </select>
                            </div>
                        </dd>
                        <dt>시군구</dt>
                        <dd>
                            <div class="select-box">
                                <label for="lb-sido">종로구</label>
                                <select id="lb-sido">
                                    <option selected="selected">종로구</option>
                                </select>
                            </div>
                        </dd> -->
                        <dt><label for="lb-addr">주소</label></dt>
                        <dd>
                            <input type="text" class="w50p" id="dong" onKeyDown="if(event.keyCode == 13){pop_postcode()}">
                            <a href="#none" onclick="pop_postcode()" class="btn-tbl small">검색</a>
                        </dd>
                    </dl>
                </div>
            </div>
            <!-- [e] addr -->

            <!-- [s] addr -->
            <!-- <div class=.pop-cont tab-cont">
                <p>
                    <input type="radio" id="lb-zip01"><label for="lb-zip01">도로명+건물번호</label>
                    <input type="radio" id="lb-zip02"><label for="lb-zip02">동(읍/면/리)명+건물(아파트)명</label>
                    <input type="radio" id="lb-zip03"><label for="lb-zip03">동(읍/면/동)명+지번</label>
                </p>
                <div class="pop-search">
                    <dl>
                        <dt>시도</dt>
                        <dd>
                            <div class="select-box">
                                <label for="lb-sido">서울특별시</label>
                                <select id="lb-sido">
                                    <option selected="selected">서울특별시</option>
                                </select>
                            </div>
                        </dd>
                        <dt>시군구</dt>
                        <dd>
                            <div class="select-box">
                                <label for="lb-sido">종로구</label>
                                <select id="lb-sido">
                                    <option selected="selected">종로구</option>
                                </select>
                            </div>
                        </dd>
                        <dt><label for="lb-road">도로명</label></dt>
                        <dd>
                            <input type="text" class="w50p" id="lb-road">
                        </dd>
                        <dt><label for="lb-addr02">주소</label></dt>
                        <dd>
                            <input type="text" class="w30p" id="lb-addr02">
                            <input type="text" class="w30p"> <a href="" class="btn-tbl small">검색</a>
                        </dd>
                        <dt><label for="lb-building">건물명</label></dt>
                        <dd>
                            <input type="text" class="w50p" id="lb-building"> <a href="" class="btn-tbl small">검색</a>
                        </dd>
                    </dl>
                </div>
            </div> -->
            <!-- [e] addr -->
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
                        <!-- <tr>
                            <td>1</td>
                            <td>서울특별시 종로구 창신2동</td>
                            <td>110-542</td>
                            <td><a href="" class="btn-tbl small">선택</a></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>서울특별시 종로구 창신2동</td>
                            <td>110-542</td>
                            <td><a href="" class="btn-tbl small">선택</a></td>
                        </tr> -->
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="paging"></div>
        </section>
        <a href="#pop-confirm" class="pop-close heading">레이어 팝업닫기</a>
    </div>
</div>
<!-- [e] 우편번호 팝업 -->
