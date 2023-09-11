<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file = "/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자::게시판 복사</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
<meta name="Keywords" content="z5 cms"/>
<meta name="decription" content="z5 cms"/>
<meta name="author" content="z5 cms"/>
<meta name="classification" content="z5 cms"/>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript">
window.onload = function() {
    if ("${flag}"==1) {
        window.opener.location.reload();
        self.close();
    } else {
        document.getElementsByName("boardtitle")[0].focus();
    }
}
</script>
</head>
<body style="background:none;">
    <div id="content" style="margin:10px 10px 0 10px;">
        <ul class="homepagebbs">
            <li class="bg">
                <h3 class="bbs">게시판 설정 복사 [게시물이 아닌 현재 게시판의 설정을 복사하여 새로운 게시판을 생성합니다.]</h3>
            </li>
            <li>
                <form:form modelAttribute="zBoardVo" method="post">
                    <div class="main_table">
                        <table class="main_table1" border="1" summary="게시판 설정">
                            <caption>게시판 설정</caption>
                                <colgroup>
                                    <col width="200" />
                                    <col width="" />
                                </colgroup>
                            <tbody>
                                <tr>
                                    <th>생성할 게시판 제목<br><form:errors path="boardtitle" cssClass="error" /></th>
                                    <td class="align_l"><form:input path="boardtitle" cssClass="bor1ddd" cssErrorClass="errorSt" size="75" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!--/main_table-->
                    <div class="btn-c-B">
                            <input class="chost_btn_s" type="submit" value="확인" />
                            <a class="btmore09" href="javascript:self.close();">취소</a>
                    </div>
                    <!--/confirm-->
                </form:form>
            </li>
        </ul>
    </div>
</body>
</html>