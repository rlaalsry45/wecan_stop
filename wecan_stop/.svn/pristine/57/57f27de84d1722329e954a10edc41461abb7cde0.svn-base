<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>
<jsp:include page="../../lnb.jsp" flush="true"/>
<div id="contents">
    <div class="contents_top">
        <div class="location">
            <a href="<c:url value="/admsys/site/site/index.html"/>">HOME</a>
            <a href="<c:url value="/admsys/user/common/index.html"/>">회원관리</a>
            <strong>회원엑셀등록</strong>
        </div>
    </div>
    <div id="content">
        <form name="batch" id="batch" method="post" action="<c:url value="/admsys/user/common//batch.html"/>" enctype="multipart/form-data">
            <ul class="homepagebbs">
                <li class="bg"><h3 class="member">회원 엑셀 등록</h3></li>
                <li>
                    <table class="main_table1 bgneno" summary="아이디, 비밀번호">
                        <caption>회원등록</caption>
                        <colgroup>
                            <col style="width:20%;"/>
                            <col style="width:80%;"/>
                        </colgroup>
                        <tbody>
                        <c:if test="${empty args.action}">
                            <tr>
                                <th class="Tbornone" scope="row">회원정보 가져오기</th>
                                <td class="Tleft">
                                    <div class="file-box mt5">
                                        <input value="선택된 파일 없음" style="width: 320px;" type="text" readonly="readonly">
                                        <label class="btn-tbl">파일첨부<input type="file" id="file" name="file"></label>
                                    </div>
                                    <br>
                                    <ul style="color: darkred; width: 100%;">
                                        <li>&#9608; 회원정보가 포함되어 있는 엑셀파일을 첨부해주세요.</li>
                                        <li>&#9608; 등록 전에 중복된 회원ID(탈퇴회원 포함)가 없는지 반드시 확인해주세요.</li>
                                        <li>&#9608; 중복 된 회원ID는 제외하고 회원등록이 진행됩니다.</li>
                                        <li>&clubs; 회원정보 등록양식 : <a href="${args.sample}">샘플파일 다운로드</a></li>
                                    </ul>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${not empty args.action}">
                            <tr>
                                <th class="Tbornone" scope="row">회원정보 결과</th>
                                <td class="Tleft">
                                        ${args.success + args.failure} 명 회원등록 결과:
                                    <c:if test="${args.success gt 0}">
                                        <br><span style="color: darkblue;">&#9787; ${args.success} 명의 회원을 등록하였습니다.</span>
                                    </c:if>
                                    <c:if test="${args.failure gt 0}">
                                        <br><span style="color: darkred;">&#9608; ${args.failure} 명의 회원을 등록하지 못하였습니다.</span>
                                    </c:if>
                                </td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </li>
                <li>
                    <div class="btn-c-B">
                        <a class="btmore04" href="<c:url value="/admsys/user/common/index.html"/>">목록</a>
                        <c:if test="${empty args.action}">
                            <a class="btmore05" href="#" onclick="return sanity()">등록</a>
                        </c:if>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</div>
<!--/contents-->
<script type="text/javascript">
    function sanity() {
        // get the file name, possibly with path (depends on browser)
        var filename = $("#file").val();

        // Use a regular expression to trim everything before final dot
        var extension = filename.replace(/^.*\./, '');

        // Iff there is no dot anywhere in filename, we would have extension == filename,
        // so we account for this possibility now
        if (extension === filename) {
            extension = '';
        } else {
            // if there is an extension, we convert to lower case
            // (N.B. this conversion will not effect the value of the extension
            // on the file upload.)
            extension = extension.toLowerCase();
        }

        switch (extension) {
            case 'csv':
            case 'xls':
            case 'xlsx':
                document.batch.submit();
                return true;

            default:
                // Cancel the form submission
                alert("엑셀 파일만 지원합니다.");
        }
        return false;
    }

    $(document).ready(function () {
        $(document).on("change", "[type=file]", function () {
            var name = $(this).val();
            var ndex = name.lastIndexOf("/") + 1;
            if (ndex <= 0) {
                ndex = name.lastIndexOf("\\") + 1;
            }
            name = name.substr(ndex);
            $(this).parent().prev().val(name);
        });
    });
</script>
<jsp:include page="../../footer.jsp" flush="true"/>
