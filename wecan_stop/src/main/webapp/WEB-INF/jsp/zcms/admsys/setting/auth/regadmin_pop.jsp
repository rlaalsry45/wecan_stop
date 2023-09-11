<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="ajax" uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<c:choose>
		<c:when test="${input.popType eq 'header'}">
			<title>마이페이지 팝업</title>	
		</c:when>
		<c:otherwise>
			<title>관리자::사용자 등록</title>
		</c:otherwise>
	</c:choose>
    
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <meta name="Keywords" content="z5 cms"/>
    <meta name="decription" content="z5 cms"/>
    <meta name="author" content="z5 cms"/>
    <meta name="classification" content="z5 cms"/>
    <link rel="stylesheet" type="text/css" href="/cms/css/democratic.css"/>
    <script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="/cms/js/func.js"></script>
    <script type="text/javascript" src="/cms/js/valid.js"></script>
    <script type="text/javascript" src="/var/sha/core.min.js"></script>
	<script type="text/javascript" src="/var/sha/sha256.min.js"></script>
    <script type="text/javascript">
        if ("true" == "${flag}") {
            window.opener.location.reload();
            self.close();
        }

        $(function () {
        	var popType = "${input.popType}";
        	
            var frm = $("form[name='frm']");

            var chk = function (obj, color, message) {
                if ($("font", obj.parent()).length == 0) {
                    $("<font>" + message + "</font>").insertAfter(obj);
                } else {
                    $("font", obj.parent()).text(message);
                }
                $("font", obj.parent()).attr("color", color);
                $("font", obj.parent()).css("float", "right");
                return color == "red" ? false : true;
            };

            frm.data("dupchk", "false");

            <c:if test="${vo.username ne null}">
            frm.data("dupchk", "true");
            </c:if>

            $(":input", frm).bind("keyup blur", function () {
                var obj = $(this);
                var regExp = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
                switch (obj.attr("id")) {

                    <c:if test="${vo.username eq null}">
                    case "userid" :
                        obj.val(obj.val().replace(/[\W]/g, ""));
                        if (obj.val().length > 5) {
                            $.ajax({
                                type     : 'post'
                                , async  : true
                                , url    : '/skin/member/default/dupchk.html'
                                , data   : "userid=" + obj.val()
                                , success: function (data) {
                                    frm.data("dupchk", data);
                                    if (data == "false") {
                                        return chk(obj, "red", "중복된 아이디가 존재합니다.");
                                    } else {
                                        return chk(obj, "green", "사용 가능한 아이디입니다.");
                                    }

                                }
                                , error  : function (data, status, err) {
                                    alert('서버와의 통신이 실패했습니다.');
                                }

                            });

                        } else {
                            return chk(obj, "red", "6~30자리 아이디를 입력 해주세요.");
                        }
                        break;
                    </c:if>
                    case "userpasswd" :
                        obj.val(obj.val().replace(/^\s+|\s+$/g, ""));
                        $("#userpasswdchk").val("");

                        if (obj.val().match(regExp) == null) {
                            return chk(obj, "red", "영대/소문자,숫자,특수문자 중 3종류 이상 8~16자리 비밀번호를 입력하세요.");
                        } else {
                            return chk(obj, "green", "사용 가능한 비밀번호입니다.");
                        }
                        
                        /* if (obj.val().length < 8 || obj.val().length > 16) {
                            return chk(obj, "red", "8~16자리 비밀번호를 입력 해주세요.");
                        } else {
                            if ($("#userpasswdchk").val() != "" && $("#userpasswdchk").val() != $("#userpasswd").val()) {
                                return chk(obj, "red", "비밀번호가 서로 다릅니다.");
                            } else {

                                var num = obj.val().search(/[0-9]/g);
                                var eng = obj.val().search(/[a-z]/ig);
                                var spe = obj.val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

                                if ((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0)) {
                                    return chk(obj, "red", "영문 대소문자/숫자/특수문자 중 두가지 이상 조합해주세요.");
                                } else {
                                    return chk(obj, "green", "사용 가능한 비밀번호입니다.");
                                }

                            }
                        } */
                        break;
                    case "userpasswdchk" :
                        obj.val(obj.val().replace(/^\s+|\s+$/g, ""));

                        if (obj.val().match(regExp) == null) {
                            return chk(obj, "red", "영대/소문자,숫자,특수문자 중 3종류 이상 8~16자리 비밀번호를 입력하세요.");
                        } else {
                            if ($("#userpasswdchk").val() != $("#userpasswd").val()) {
                                return chk(obj, "red", "비밀번호가 서로 다릅니다.");
                            } else {
                                $("#userhint").focus();
                                return chk(obj, "green", "비밀번호가 확인되었습니다.");
                            }
                        }
                        
                        /* if (obj.val().length < 8 || obj.val().length > 16) {
                            return chk(obj, "red", "8~16자리 비밀번호를 입력 해주세요.");
                        } else {
                            if ($("#userpasswdchk").val() != $("#userpasswd").val()) {
                                return chk(obj, "red", "비밀번호가 서로 다릅니다.");
                            } else {
                                $("#userhint").focus();
                                return chk(obj, "green", "비밀번호가 확인되었습니다.");
                            }
                        } */
                        break;
                    default :
                        break;
                }
            });
        });

        function checkadmin(userid) {
            var frm = $("form[name='frm']");

            if ($("#username", frm).val().replace(/^\s+|\s+$/g, "") == "") {
                alert("운영자명을 입력 해주세요.");
                $("#username", frm).focus();
                $("#username", frm).select();
                return false;
            }

            if ($("#userid", frm).val().replace(/^\s+|\s+$/g, "") == "") {
                alert("아이디를 입력 해주세요.");
                $("#userid", frm).focus();
                $("#userid", frm).select();
                return false;
            } else {
                if (frm.data("dupchk") == "false") {
                    alert("중복된 아이디가 존재 합니다.");
                    $("#userid", frm).focus();
                    $("#userid", frm).select();
                    return false;
                }
            }

            if (userid != "") {
            	if($("#userpasswd").val().trim() != ""){
 		            var shaPw = CryptoJS.SHA256($("#userpasswd").val()).toString(); 
 		        	$("#userpasswd").val(shaPw);
 	            }
            	 
                if (!confirm("수정 하시겠습니까?")) {
                    return false;
                }

                $("#act").val("update");

            } else {
            	
            	if ($("#userpasswd", frm).val().replace(/^\s+|\s+$/g, "") == "") {
	                alert("비밀번호를 입력 해주세요.");
	                $("#userpasswd", frm).focus();
	                $("#userpasswd", frm).select();
	                return false;
	            } else {
	            	var regExp = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	            	if ($("#userpasswd", frm).val().match(regExp) == null) {
	            		alert("영대/소문자,숫자,특수문자 중 3종류 이상 8~16자리 비밀번호를 입력하세요.");
	            		$("#userpasswd", frm).focus();
	                    $("#userpasswd", frm).select();
	                    return false;
	                }
	
	                /* if ($("#userpasswd", frm).val().length < 8 || $("#userpasswd", frm).val().length > 16) {
	                    alert("비밀번호를 8~16자리로 입력 해주세요.");
	                    $("#userpasswd", frm).focus();
	                    $("#userpasswd", frm).select();
	                    return false;
	                } else {
	
	                    var num = $("#userpasswd", frm).val().search(/[0-9]/g);
	                    var eng = $("#userpasswd", frm).val().search(/[a-z]/ig);
	                    var spe = $("#userpasswd", frm).val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	                    if ((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0)) {
	                        alert("비밀번호를 영문 대소문자/숫자/특수문자 중 두가지 이상 조합해주세요.");
	                        $("#userpasswd", frm).focus();
	                        $("#userpasswd", frm).select();
	                    }
	                } */
	            }
	
	            if ($("#userpasswdchk", frm).val().replace(/^\s+|\s+$/g, "") == "") {
	                alert("비밀번호를 확인 해주세요.");
	                $("#userpasswdchk", frm).focus();
	                $("#userpasswdchk", frm).select();
	                return false;
	            } else {
	                if ($("#userpasswd", frm).val() != $("#userpasswdchk", frm).val()) {
	                    alert("비밀번호가 다릅니다.");
	                    $("#userpasswdchk", frm).focus();
	                    $("#userpasswdchk", frm).select();
	                    return false;
	                }
	            }
            
	            if ($("#useremail", frm).val().replace(/^\s+|\s+$/g, "") == "") {
	                alert("이메일을 입력 해주세요.");
	                $("#useremail", frm).focus();
	                $("#useremail", frm).select();
	                return false;
	            }
	            
		        var shaPw = CryptoJS.SHA256($("#userpasswd").val()).toString(); 
		        $("#userpasswd").val(shaPw);

                if (!confirm("등록 하시겠습니까?")) {
                    return false;
                }
            }

        }

    </script>
</head>
<body style="background:none;">
<div id="content">
    <ul class="homepagebbs">
        <li class="bg">
		<c:if test="${not empty vo.userid && vo.userauth == '5'}">
			<h3 class="sub">담당자 수정</h3>
		</c:if>
		<c:if test="${not empty vo.userid && vo.userauth != '5'}">
			<h3 class="sub">사용자 수정</h3>
		</c:if>
		<c:if test="${empty vo.userid}">
			<h3 class="sub">사용자 등록</h3>
		</c:if>	
        </li>
        <li>
            <div class="main_table">

                <form:form modelAttribute="zsiteVo" name="frm" action="/admsys/setting/auth/regadmin_pop.html" method="post"
                           onsubmit="return checkadmin('${vo.userid }')">
                <input type="hidden" name="act" id="act"/>
                <input type="hidden" name="userno" value="${vo.userno }"/>
                <!---게시판 영역------------------------->
                <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="CSS리스트">
                    <caption>사이트 설정</caption>
                    <colgroup>
                        <col width="150px"/>
                        <col width=""/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th class="Tleft">사용자명</th>
                        <td class="Tbod Tbod Tleft">
                            <input type="text" class="bor1ddd" name="username" id="username" size=30 value="${vo.username }" <c:if test="${vo.username ne null}">readonly="readonly"</c:if>/>
                        </td>
                    </tr>
                    <tr>
                        <th class="Tbornone Tleft">아이디</th>
                        <td class="Tleft">
                            <input type="text" class="bor1ddd" name="userid" id="userid" size=30 value="${vo.userid }" <c:if test="${vo.userid ne null}">readonly="readonly"</c:if>/>
                        </td>
                    </tr>
                    <tr>
                        <th class="Tbornone Tleft">비밀번호</th>
                        <td class="Tleft"><input type="password" style="height:26px" class="bor1ddd" name="userpasswd" id="userpasswd" size=30/></td>
                    </tr>
                    <tr>
                        <th class="Tbornone Tleft">비밀번호 확인</th>
                        <td class="Tleft"><input type="password" style="height:26px" class="bor1ddd" id="userpasswdchk" size=30/></td>
                    </tr>
                    <tr>
                    	<th class="Tbornone Tleft">이메일</th>
                    	<td class="Tleft"><input type="text" id="useremail" name="useremail" value="${vo.useremail}" size=30/></td>                    	
                    </tr>
                    <tr>
                        <th class="Tbornone Tleft" scope="row">
                            <label class="on" for="at-date">사용여부</label>
                        </th>
                        <td class="Tleft" colspan="3">
                        	<select id="useyn" name="useyn" style="width:70px;">
                        		<option value="Y" <c:if test="${vo.useyn eq 'Y'}">selected</c:if>>사용</option>
                        		<option value="N" <c:if test="${vo.useyn eq 'N'}">selected</c:if>>미사용</option>
                        	</select>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <!---/게시판 영역------------------------->
            </div><!--/main_table-->
            <div class="btn-c">
                <input class="chost_btn_s" type="submit" id="btn_submit" value="확인"/>
                <a class="btmore09" href="javascript:self.close();">닫기</a>
            </div>

            </form:form>
</div><!--/bbs_category_popup-->
</body>
</html>