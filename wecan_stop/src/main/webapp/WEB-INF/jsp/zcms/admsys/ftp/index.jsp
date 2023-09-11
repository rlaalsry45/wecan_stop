<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type='text/javascript' src='<c:url value="/com/js/fileupload/vendor/jquery.ui.widget.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.iframe-transport.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.fileupload.js"/>'></script>
<jsp:include page="../lnb.jsp" flush="true"/>
<div id="contents">
    <div class="contents_top">
        <div class="location">
            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>업로드 관리</strong>
        </div>
    </div>
    <div id="content">
        <ul class="homepagebbs">
            <li class="bg">
                <h3 class="sub">업로드 관리</h3>
                <a class="btmore03" onclick="return attach();">+ 파일 등록</a>
                <input id="upload" type="file" name="file" data-url="/admsys/ftp/attach.html" multiple style="opacity: 0; filter:alpha(opacity: 0);"><br/>
            </li>
            <li>
                <div class="main_table">
                    <input type="hidden" id="repo" value="${repo}">
                    <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="파일 목록">
                        <caption>파일 목록</caption>
                        <colgroup>
                            <col width=""/>
                            <col width="20%"/>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>파일</th>
                            <th>관리</th>
                        </tr>
                        </thead>
                        <tbody id="table">
                        <c:set var="search" value="'"/>
						<c:set var="replace" value="\\'" />
                        <c:forEach items="${list}" var="each" varStatus="loop">
                            <tr>
                                <td style="text-align: left">${each}</td>
                                <td>
                                    <a class="btmore06" onclick="return carbon('${fn:replace(each, search, replace)}');">경로복사</a>
                                    <a class="btmore05" onclick="return pickup('${fn:replace(each, search, replace)}');">다운로드</a>
                                    <a class="btmore04" onclick="return detach('${fn:replace(each, search, replace)}');">파일삭제</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${fn:length(list) eq 0}">
                            <tr>
                                <td colspan="2" style="padding:20px;">파일이 없습니다.</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div><!--/main_table-->
            </li>
        </ul>
    </div><!--/content-->
</div>
<script type="text/javascript">
    $(function () {
        $('#upload').fileupload({
            dataType: 'json',
            done    : function (e, data) {
                record();
                // $.each(data.result, function (index, file) {
                //     $('#table').append(formatHtml(index, file.name));
                // });
            }
        });
    });

    function attach() {
        $("#upload").trigger('click');
        return false;
    }

    function pickup(file) {
        document.location = "/admsys/ftp/download.html?file=" + encodeURIComponent(file);
        return false;
    }

    function detach(file) {
        alertify.confirm(file + ' 파일을 삭제 하시겠습니까?', function (e) {
            if (e) {
                $.get("/admsys/ftp/detach.html?file=" + file, function (result) {
                    if (result) {
                        record();
                    }
                });
            }
        });
        return false;
    }

    function record() {
        $.get("/admsys/ftp/record.html", function (list) {
            $("#table").empty();
            $.each(list, function (index, file) {
                $('#table').append(formatHtml(file));
            })
        });
        return false;
    }

    function formatHtml(file) {
        var html = '';
        html += '<tr>\n';
        html += '  <td style="text-align: left">' + file + '</td>\n';
        html += '  <td>\n';
        html += '    <a class="btmore06" onclick="return carbon(\'' + file.replace(/\'/gi,"\\'") + '\');">경로복사</a>\n';
        html += '    <a class="btmore05" onclick="return pickup(\'' + file.replace(/\'/gi,"\\'") + '\');">다운로드</a>\n';
        html += '    <a class="btmore04" onclick="return detach(\'' + file.replace(/\'/gi,"\\'") + '\');">파일삭제</a>\n';
        html += '  </td>\n';
        html += '</tr>\n';
        return html;
    }

    function carbon(file) {
        var text = $('#repo').val() + file;
        var area = document.createElement("textarea");

        area.value = text;
        document.body.appendChild(area);
        area.select();
        document.execCommand("Copy");
        area.remove();

        alertify.success('복사 되었습니다.(' + text + ')');
        return false;
    }
</script>
<jsp:include page="../end.jsp"/>