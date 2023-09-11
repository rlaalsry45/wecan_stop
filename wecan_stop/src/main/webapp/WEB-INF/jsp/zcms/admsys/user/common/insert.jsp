<!DOCTYPE html PUBLIC"-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<script type="text/javascript" src="/var/sha/core.min.js"></script>
<script type="text/javascript" src="/var/sha/sha256.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../../../../../cms/css/democratic.css"/>
<jsp:include page="../../lnb.jsp" flush="true"/>
<div id="contents">
    <div class="contents_top">
        <div class="location">
            <a href="/admsys/dashboard/index.html">HOME</a>
            <a href="/admsys/user/organization/">회원관리</a>
            <strong>회원등록</strong>
        </div>
    </div>
    <div id="content">
        <ul class="homepagebbs">
            <li class="bg">
                <h3 class="member">회원등록</h3>
            </li>
            <li>
                <div class="main_table">
                    <form name="form" method="post" enctype="multipart/form-data">
                        <table class="main_table1 bgneno" summary="아이디, 비밀번호, 비밀번호 확인, 성명(한글), 성명(영문), E-mail, 우편물 수령">
                            <caption>회원등록</caption>
                            <colgroup>
                                <col style="width:10%;"/>
                                <col style="width:40%;"/>
                                <col style="width:12%;"/>
                                <col style="width:38%;"/>
                            </colgroup>
                            <tbody>
                            <tr>
                            	<th class="Tleft" scope="row">
                                    <label class="on" for="user">아이디</label>
                                </th>
                                <td class="Tbod Tbod Tleft">
                                    <input type="text" id="user" name="userid" title="아이디 입력" maxlength="16" style="width:226px;height:29px;"/>
                                </td>
                                <th class="Tleft" scope="row">
                                    <label class="on" for="usercate">등록카테고리</label>
                                </th>
                                <td class="Tbod Tbod Tleft">
                                	<input type="radio" name="usercate" value="1">대표단(DAO)
                                	<input type="radio" name="usercate" value="3">미디어
                                	<input type="radio" name="usercate" value="2">주최측인력
                                	<input type="radio" name="usercate" value="4">부대행사
                                	<input type="radio" name="usercate" value="5">차량등록
                                </td>
                               
                                
                            </tr>
                            <tr>
                                 <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="pass">비밀번호</label>
                                </th>
                                <td class="Tleft">
                                    <input type="password" class="text" id="pass" name="userpasswd" style="width:226px;height:29px;"/>
                                </td>
                                 <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="pair">비밀번호 확인</label>
                                </th>
                                <td class="Tleft" colspan="2">
                                    <input type="password" class="text" id="pair" style="width:226px;height:29px;"/>
                                </td>	
                            </tr>
                            <tr>
                                <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="user">국가</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" id="usernick" name="usernick" title="user category" maxlength="20" style="width:226px;height:29px;"/>
                                    <br/>*대표단 외 국적은 KOREA/FOREIGN으로만 표기
                                </td>
                                <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="username">등록 담당기관/단체명</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" class="text" id="username" name="username" style="width:226px;height:29px;"/>
                                </td>
                            </tr>
                            
                            <tr>
                                <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="user">담당자 성명</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" id="chargername" name="chargername" title="user category" style="width:226px;height:29px;"/>
                                </td>
                                <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="username">담당자 이메일</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" class="text" id="useremail" name="useremail" style="width:226px;height:29px;"/>
                                </td>
                            </tr>
                            <tr>
                                <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="user">담당자 핸드폰</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" id="usermobile" name="usermobile" title="user category" style="width:226px;height:29px;"/>
                                </td>
                                <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="username">담당자 전화</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" class="text" id="usertel" name="usertel" style="width:226px;height:29px;"/>
                                </td>
                            </tr>
                            <tr>
                                <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="user">담당자 소속</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" id="dept_nm" name="dept_nm" title="dept_nm" style="width:226px;height:29px;"/>
                                </td>
                                <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="username">담당자 직위</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" class="text" id="work_title" name="work_title" style="width:226px;height:29px;"/>
                                </td>
                            </tr>
                            <tr>
                                <th class="Tbornone Tleft" scope="row">
                                    <label class="on" for="user">지정 마감일</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" id="useripreg" name="useripreg" class="Wdate" title="user category" onFocus="WdatePicker()" style="width:137px;height:29px;"/>
                                </td>
                                 <th class="Tbornone Tleft" scope="row">
                                       <label class="on" for="memo">담당자 메모</label>
                                </th>
                                <td class="Tleft">
                                    <input type="text" class="text" id="memo" name="usermemo" style="width:226px;height:29px;"/>
                                </td>
                            </tr>
                           <!--  <tr>
                                <th class="Tbornone" scope="row">
                                    <label class="on" for="useraddr">교육청</label>
                                </th>
                                <td class="Tleft" colspan="2">
                                    <select name="useraddr" id="useraddr" title="member address" style="width:80px;height:24px;">
                                        <option value="서울">서울</option>
                                        <option value="경기">경기</option>
                                        <option value="인천">인천</option>
                                        <option value="강원">강원</option>
                                        <option value="대전">대전</option>
                                        <option value="세종">세종</option>
                                        <option value="충남">충남</option>
                                        <option value="충북">충북</option>
                                        <option value="부산">부산</option>
                                        <option value="울산">울산</option>
                                        <option value="경남">경남</option>
                                        <option value="경북">경북</option>
                                        <option value="대구">대구</option>
                                        <option value="광주">광주</option>
                                        <option value="전남">전남</option>
                                        <option value="전북">전북</option>
                                        <option value="제주">제주</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th class="Tbornone" scope="row">
                                    <label class="on" for="usernick">학교(기관)명</label>
                                </th>
                                <td class="Tleft" colspan="2">
                                    <input type="text" class="text" id="usernick" name="usernick" style="width:226px;height:29px;"/>
                                </td>
                            </tr> -->
                            <!-- <tr>
                                <th class="Tbornone" scope="row">
                                    <label class="on" for="indate">신청일</label>
                                </th>
                                <td class="Tleft" colspan="2">
                                    <input id="indate" name="chargemobile" class="Wdate" type="text"
                                           onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'indate\')}'})"/>
                                </td>
                            </tr>
                            <tr>
                                <th class="Tbornone" scope="row">
                                    <label class="on" for="ondate">승인일</label>
                                </th>
                                <td class="Tleft" colspan="2">
                                    <input id="ondate" name="chargeremail" class="Wdate" type="text"
                                           onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'ondate\')}'})"/>
                                </td>
                            </tr>
                            <tr>
                                <th class="Tbornone" scope="row">
                                    <label class="on" for="register">등록자</label>
                                </th>
                                <td class="Tleft" colspan="2">
                                    <input type="text" class="text" id="register" name="chargername" value="" style="width:226px;height:29px;"/>
                                </td>
                            </tr>
                            <tr>
                                <th class="Tbornone" scope="row">
                                    <label class="on" for="memo">기타</label>
                                </th>
                                <td class="Tleft" colspan="2">
                                    <input type="text" class="text" id="memo" name="usermemo" value="" style="width:80%;height:29px;"/>
                                </td>
                            </tr> -->
                            <%--<tr>--%>
                            <%--<th class="Tbornone" scope="row">--%>
                            <%--<label class="on" for="tel1">전화번호</label>--%>
                            <%--</th>--%>
                            <%--<td class="Tleft">--%>
                            <%--<input class="text" id="tel1" name="tel1" title="지역번호 입력" style="width:72px;height:24px;" maxlength="3" value=""/> ---%>
                            <%--<input class="text" id="tel2" name="tel2" title="중간 네자리번호 입력" style="width:71px;height:24px;" maxlength="4" value=""/> ---%>
                            <%--<input class="text" id="tel3" name="tel3" title="마지막 네자리번호 입력" style="width:71px;height:24px;" maxlength="4" value=""/>--%>
                            <%--</td>--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                            <%--<th class="Tbornone" scope="row">이메일</th>--%>
                            <%--<td class="Tleft">--%>
                            <%--<input class="text" id="email1" name="email1" title="이메일 주소 입력" style="width:104px;height:24px;" value=""/> @--%>
                            <%--<input class="text" id="email2" name="email2" title="이메일 주소 입력" style="width:103px;height:24px;" value=""/>--%>
                            <%--</td>--%>
                            <%--</tr>--%>
                            </tbody>
                        </table>
                        <div class="btn-c-B">
                            <a class="btmore04" id="submit_btn" href="#none">등록</a>
                            <a class="btmore05" href="javascript:history.back();">취소</a>
                        </div>
                    </form>
                </div>
            </li>
        </ul>
    </div><!--/content-->
</div><!--/contents-->
<script type="text/javascript" src="/usr/js/target/func.js"></script>
<script type="text/javascript">
    var PASSWORD_MIN = 8, PASSWORD_MAX = 16;
    $(function () {
        if ("true" === "${param.modifysuccess}") {
            alertify.success("회원정보가 수정되었습니다.");
        }

        var prompt = function (elem, color, message) {
            if ($("span", elem.parent()).length === 0) {
                $("<span>" + message + "</span>").insertAfter(elem);
            } else {
                $("span", elem.parent()).text(message);
            }
            $("span", elem.parent()).css({"color": color, "float": "right"});
            return color !== "red";
        };

        $(":input").bind("keyup blur", function () {
            var user = $("#user");
            var pass = $("#pass");
            var pair = $("#pair");
            switch ($(this).attr("id")) {
                case "user" :
                    user.val(user.val().replace(/[\W]/g, ""));
                    if (user.val().length >= 5) {
                        $.ajax({
                            type   : 'post',
                            async  : true,
                            url    : '/skin/member/default/dupchk.html',
                            data   : "userid=" + user.val(),
                            success: function (data) {
                                if (data === "false") {
                                    user.val('');
                                    return prompt(user, "red", "중복된 아이디가 존재합니다.");
                                } else {
                                    return prompt(user, "green", "사용 가능한 아이디입니다.");
                                }

                            },
                            error  : function (data, status, err) {
                                console.log("data:" + data + " status:" + status + " error:" + err);
                                alert('서버와의 통신이 실패했습니다.');
                            }
                        });
                    }
                    return prompt(user, "red", "5~12자리 아이디를 입력 해주세요.");
                case "pass":
                	
                	pass.val(pass.val().replace(/^\s+|\s+$/g, ""));
                    pair.val("");
                    
                    var regExp = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

                    if (pass.val().match(regExp) == null) {
                        return prompt(pass, "red", "영대/소문자,숫자,특수문자 중 3종류 이상 8~16자리 비밀번호를 입력하세요.");
                    } else {
                        return prompt(pass, "green", "사용 가능한 비밀번호입니다.");
                    }
                	
                    /* pass.val(shave(pass.val()));
                    pair.val("");

                    if (/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/.test(pass.val())) {
                        pass.val("");
                        return prompt(pass, "red", "한글 입니다. 영문 대소문자/숫자/특수문자를 조합해주세요!");
                    }
                    if (PASSWORD_MIN > pass.val().length || pass.val().length > PASSWORD_MAX) {
                        return prompt(pass, "red", PASSWORD_MIN + "~" + PASSWORD_MAX + "자리 비밀번호를 입력 해주세요.");
                    }
                    if (search(pass.val(), user.val())) {
                        pass.val("");
                        return prompt(pass, "red", "사용자 아이디가 비밀번호에 포함되어 있습니다!");
                    }
                    return prompt(pass, "green", "사용 가능한 비밀번호입니다."); */

                case 'pair':
                	pair.val(pair.val().replace(/^\s+|\s+$/g, ""));
                    if (pair.val().length >= PASSWORD_MIN && pair.val().length >= pass.val().length) {
                        if (pass.val() !== pair.val()) {
                            pair.val("");
                            return prompt(pair, "red", "비밀번호가 서로 다릅니다.");
                        } else {
                            /* if (!strength(pass.val())) {
                                pass.val("");
                                pair.val("");
                                pass.focus();
                                return prompt(pass, "red", "영문 대소문자/숫자/특수문자를 조합해주세요!");
                            } */
                            return prompt(pair, "green", "비밀번호가 확인되었습니다.");
                        }
                    }
                    break;
            }
        });
    });

    $(document).ready(function () {
        $(document).on("click", "#submit_btn", function (event) {
            event.preventDefault();

            var user = $("#user");
            if (!user.val()) {
                alertify.alert("아이디를 입력하여 주세요!", function () {
                    user.focus();
                });
                return false;
            }

            var pass = $("#pass");
            var pair = $("#pair");
            
            var regExp = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

            if (pass.val().match(regExp) == null) {
            	pass.val('');
                pair.val('');
            	alertify.alert("영대/소문자,숫자,특수문자 중 3종류 이상 8~16자리 비밀번호를 입력하세요.", function () {
                    pass.focus();
                });
            	return false;
            }
            
            /* if (pass.val().length < PASSWORD_MIN) {
                pass.val('');
                pair.val('');
                alertify.alert(PASSWORD_MIN + "자 이상의 비밀번호를 사용하여 주세요!", function () {
                    pass.focus();
                });
                return false;
            } */

            if (pass.val() !== pair.val()) {
                pair.val('');
                alertify.alert("비밀번호가 일치하지 않습니다!", function () {
                    pair.focus();
                });
                return false;
            }

            /* if (!strength(pass.val())) {
                pass.val('');
                pair.val('');
                alertify.alert("영문 대소문자/숫자/특수문자를 조합해주세요!", function () {
                    pass.focus();
                });
                return false;
            } */

            var item = $("#username");
            if (!item.val()) {
                alertify.alert("기관명을 입력하여 주세요!", function () {
                    item.focus();
                });
                return false;
            }

            item = $("#usernick");
            if (!item.val()) {
                alertify.alert("국적을 입력하여 주세요!", function () {
                    item.focus();
                });
                return false;
            }

            /* item = $("#indate");
            if (!item.val()) {
                alertify.alert("신청일을 입력하여 주세요!", function () {
                    item.focus();
                });
                return false;
            }

            item = $("#ondate");
            if (!item.val()) {
                alertify.alert("승인일을 입력하여 주세요!", function () {
                    item.focus();
                });
                return false;
            }

            item = $("#register");
            if (!item.val()) {
                alertify.alert("등록자를 입력하여 주세요!", function () {
                    item.focus();
                });
                return false;
            } */

            alertify.confirm("'" + user.val() + "'님의 정보를 입력 하시겠습니까?", function (e) {
                if (e) {
                	
                	var shaPw = CryptoJS.SHA256($("#pass").val()).toString(); 
                	$("#pass").val(shaPw);
                    document.form.action = "/admsys/user/common/insert.html";
                    document.form.submit();
                    return true;
                }
            });
            return false;
        });
    });
</script>
<jsp:include page="../../footer.jsp" flush="true"/>
