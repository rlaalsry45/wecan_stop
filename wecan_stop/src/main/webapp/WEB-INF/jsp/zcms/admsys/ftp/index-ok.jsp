<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<jsp:include page="../lnb.jsp" flush="true"/>
<div id="contents">
    <div class="contents_top">
        <div class="location">
            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>업로드 관리</strong>
        </div>
    </div>
    <div id="content">
        <ul class="homepagebbs">
            <li class="bg"><h3 class="sub">업로드 관리</h3></li>
            <li>
                <form name="uploader" action="/admsys/ftp/upload.html" method="post" enctype="multipart/form-data" onsubmit="return checker();">
                    <div class="user_btn tmg10 bmg20">
                        <input type="file" class="main_table" id="file" name="file">
                        <button type="submit" class="bt01">업로드</button>
                    </div>
                </form>
            </li>
            <li>
                <!-- <div class="top_bt">
                    <a class="btmore07" href="javascript:checkAll(true,'no');">전체선택</a>
                    <a class="btmore07" href="javascript:checkAll(false,'no');">선택해제</a>
                    <a class="btmore05" href="javascript:del('no');">삭제</a>
                </div> -->
                <div class="main_table">
                    <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="파일 목록">
                        <caption>파일 목록</caption>
                        <colgroup>
                            <col width=""/>
                            <col width="20%"/>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>경로</th>
                            <th>관리</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="each" varStatus="loop">
                            <tr>
                                <td style="text-align: left">${repo}${each}</td>
                                <td>
                                    <a class="btmore06" onclick="return copytoclipboard('${repo}${each}');">경로복사</a>
                                    <a class="btmore05" href="${repo}${each}" target="_brank">다운</a>
                                    <a class="btmore04" href="<c:url value="/admsys/ftp/index.html?todo=delete&file=${each}"/>"
                                       onclick="if(!confirm('삭제하시겠습니까?')){return false}">삭제</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${fn:length(list) eq 0}">
                            <tr><td colspan="2" style="padding:20px;">파일이 없습니다.</td></tr>
                        </c:if>
                        </tbody>
                    </table>
                </div><!--/main_table-->
            </li>
        </ul>
    </div><!--/content-->
</div>
<script type="text/javascript">
    function checker() {
        if ($("#file").val() === "") {
            alert("파일을 선택하십시오.");
            $("#file").focus();
            return false;
        }

        document.uploader.submit();
        return true;
    }
</script>
<jsp:include page="../end.jsp"/>