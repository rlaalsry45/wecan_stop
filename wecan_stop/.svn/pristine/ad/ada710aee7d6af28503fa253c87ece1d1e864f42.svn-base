<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script src="/usr/skin/survey/default/js/validate.js"></script>
<script type="text/javascript">
$(document).on("click", ".opt-type", function() {
    console.log($(this).val());
    var obj = $(this).val();
    var parent = $(this).parent("td");
    parent.find("span").find("input[type=radio]").prop("checked", false);
    parent.find("span").css('display', 'none');

    parent.find("." + obj).css('display', 'inline');
    parent.find("." + obj).find("input[type=radio]").eq(0).prop("checked", true);

    if(obj == "opt-2") {
        $(this).closest("table").find(".answer-item").remove();
    } else {
        reviveSubRow(this);
    }
});
</script>
<style type="text/css">
input.text {height: 15px; font-size: 12px; padding-left: 3px;}
input.bor1ddd {padding-left: 5px;}
.input_table td {padding: 5px 10px;}
span > input:nth-of-type(2) {margin-left: 5px;}
</style>
<div id="container">
    <c:import charEncoding="utf-8" url="../../lnb.jsp" />
    <div id="r_side">
    <div id="contents">
        <div class="contants_top">
            <div class="location">
                <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/index.html">성희롱방지 조직문화진단관리</a> <a href="index.html">만족도조사 관리</a> <strong>만족도조사 수정</strong>
            </div>
        </div>
        <form:form modelAttribute="zSatisfactionVo" name="frm" method="post" id="satisfaction_form">
        <input name="act" type="hidden" value="update" />
        <input name="question" type="hidden" value="${fn:length(fn:split(detail.added,'Æ'))}" />
        <!-- <input name="contstype" type="hidden" value="3" /> -->
        <div id="content">
            <ul class="homepagebbs">
            <li class="bg"><h3 class="sub">만족도조사 수정</h3></li>
            <li>
            <div class="main_table">
            <table class="main_table1 bgneno" summary="제목, ID, 기관명, 상태, 기간설정, 설명, 응답자수">
                <caption>만족도조사 수정</caption>
                <colgroup>
                    <col width="150px" />
                    <col/>
                </colgroup>
                <tr>
                    <th class="Tleft">제목</th>
                    <td class="Tbod Tbod Tleft">
                        <input type="text" name="title" id="title" class="bor1ddd" size="50" value="${detail.title}" />
                    </td>
                </tr>
                <tr>
                    <th class="Tbornone Tleft">ID</th>
                    <td class="Tleft">
                        ${detail.satisfactionid}
                    </td>
                </tr>
                 <tr>
                    <th class="Tbornone Tleft">기관명</th>
                    <td class="Tleft">
                        ${detail.orgname}
                    </td>
                </tr>
                <tr>
                    <th class="Tbornone Tleft">기간 설정</th>
                    <td class="Tleft">
                        시작 :
                        <input id="d4311" name="sdate" type="date" min="2019-01-01" max="2022-12-31" placeholder="년/월/일" value="<c:out value='${detail.sdate}' />" />
                        ~
                        종료 :
                        <input id="d4312" name="edate" type="date" min="2019-01-01" max="2022-12-31" placeholder="년/월/일" value="<c:out value='${detail.edate}' />" />
                    </td>
                </tr>
                <tr>
                    <th class="Tbornone Tleft">대상 선택</th>
                    <td class="Tleft">
                        <input class="radio0" type="radio" name="target" value="0" <c:if test="${detail.target=='0'}">checked</c:if> />
                        전체
                        <input class="radio1" type="radio" name="target" value="1" <c:if test="${detail.target=='1'}">checked</c:if> />
                        회원
                        <input class="radio1" type="radio" name="target" value="2" <c:if test="${detail.target=='2'}">checked</c:if> />
                        비회원
                    </td>
                </tr>
                <tr>
                    <th class="Tbornone Tleft">메인에 보기 표시</th>
                    <td class="Tleft">
                        <input type="radio" class="radio1" name="mainview" value="1" <c:if test="${detail.mainview=='1'}">checked</c:if> />
                        예
                        <input type="radio" class="radio1" name="mainview" value="0" <c:if test="${detail.mainview=='0'}">checked</c:if> />
                        아니오
                    </td>
                </tr>
                <tr>
                    <th class="Tbornone Tleft">설명</th>
                    <td class="Tleft">
                        <input type=radio class="radio0" name="contstype" value="1" onclick="selArea(1)" <c:if test="${detail.contstype=='1'}">checked</c:if> />
                        HTML
                        <input type=radio class="radio1" name="contstype" value="3" onclick="selArea(3)" <c:if test="${detail.contstype=='3'}">checked</c:if> />
                        웹에디터
                        <div id="txtarea" style="display:<c:if test='${detail.contstype==3}'>none</c:if>">
                            <textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="30"><c:out value="${detail.conts}" escapeXml="false" /></textarea>
                        </div>
                        <div id="editorarea" style="width:96%;display:<c:if test='${detail.contstype!=3}'>none</c:if>">
                            <script type="text/javascript">
                                $(document).ready(function(){
                                    CKEDITOR.replace("ckeditorConts" ,{
                                        skin : 'office2013',
                                        //width : '620px',           // 입력창의 넓이, 넓이는 config.js 에서 % 로 제어
                                        height : '200px',           // 입력창의 높이

                                        fullPage: true,             // 모든 html 허용
                                        allowedContent: true,       // 모든 html 허용

                                        toolbar : [
                                            { name: 'tools', items: [ 'Maximize'] },
                                            { name: 'document', groups: [ 'mode', 'document', 'doctools' ], items: [ 'Source', '-', 'Preview', 'Print', '-', 'Templates' ] },
                                            { name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
                                            { name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ], items: [ 'Find', 'Replace', '-', 'SelectAll', '-', 'Scayt' ] },
                                            '/',
                                            { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
                                            { name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl' ] },
                                            { name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
                                            '/',
                                            { name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak'] },
                                            { name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
                                            { name: 'colors', items: [ 'TextColor', 'BGColor' ] }
                                        ],

                                        filebrowserBrowseUrl: '/var/filemanager/index.jsp',
                                        enterMode: CKEDITOR.ENTER_BR,
                                        language : 'ko',

                                    });
                                });
                            </script>
                            <textarea class="bor1ddd" name="ckeditorConts" id="ckeditorConts" style="width:95%" rows="30"><c:out value="${detail.conts}" escapeXml="true" /></textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th class="Tbornone Tleft">문항 관리</th>
                    <td class="Tleft">
                        <!--<a href="javascript:addRow()" style="padding-left:45px"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /> 문항추가</a> <a href="javascript:delRow()" style="padding-left:10px"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /> 문항삭제</a>-->
                        <table class="allnone" id="question" summary="문항 관리">
                        <caption>문항 관리</caption>
                            <colgroup>
                                <col width="20" />
                                <col />
                            </colgroup>
                        <!--문항 시작-->
                        <input type="hidden" name="result_count" id="result_count" value="${fn:length(fn:split(detail.added,'Æ'))}"/>
                        <input type="hidden" name="new_result_count" id="new_result_count" value="${fn:length(fn:split(detail.added,'Æ'))}"/>
                        <c:forEach items="${fn:split(detail.added,'Æ')}" var="question" varStatus="loop">
                            <tr id="trRow_${loop.index+1}">
                                <input type="hidden" name="new_result_no_${loop.index+1}" id="new_result_no_${loop.index+1}" value="${loop.index+1}"/>
                                <!--<th class="checkbox_research"><input type="checkbox" /></th>-->
                                <td class="checkbox_research">
                                    <table class="main_table1 bgneno" summary="형식, 문항, 1, 2">
                                        <colgroup>
                                            <col width="50" />
                                            <col />
                                            <col width="100" />
                                        </colgroup>
                                    <c:forEach items="${fn:split(question,'Œ')}" var="opt" varStatus="idx">
                                        <c:if test="${idx.index==0}">
                                        <tr>
                                            <th class="Tleft lborder">형식</th>
                                            <td class="Tbod rborder Tleft">
                                            <c:if test="${opt==2||opt==1}">
                                                <input type="radio" value="opt-1" class="opt-type" id="opt-type_1_${loop.index+1}"
                                                       name="opt-type${loop.index+1}" checked>객관식
                                            </c:if>
                                            <c:if test="${opt==3||opt==4}">
                                                <input type="radio" value="opt-2" class="opt-type" id="opt-type_2_${loop.index+1}"
                                                       name="opt-type${loop.index+1}" style="margin-left:5px;" checked>주관식
                                            </c:if>
                                            <c:if test="${opt==2||opt==1}">
                                                <span class="opt-1" style="margin-left:20px;">
                                                <c:if test="${opt==2}">
                                                    <input type="radio" value="2" class="radio0" id="opttype_2_${loop.index+1}"
                                                           name="opttype${loop.index+1}" checked>단일선택
                                                </c:if>
                                                <c:if test="${opt==1}">
                                                    <input type="radio" value="1" class="radio0" id="opttype_1_${loop.index+1}"
                                                           name="opttype${loop.index+1}" checked>중복선택
                                                </c:if>
                                                </span>
                                            </c:if>
                                            <c:if test="${opt==3||opt==4}">
                                                <span class="opt-2" style="margin-left:20px;">
                                                <c:if test="${opt==3}">
                                                    <input type="radio" value="3" class="radio0" id="opttype_3_${loop.index+1}"
                                                           name="opttype${loop.index+1}" checked>단답형
                                                </c:if>
                                                <c:if test="${opt==4}">
                                                    <input type="radio" value="4" class="radio0" id="opttype_4_${loop.index+1}"
                                                           name="opttype${loop.index+1}" checked>서술형
                                                </c:if>
                                                </span>
                                            </c:if>
                                            </td>
                                            <c:set value="${fn:split(question,'Œ')}" var="rowC" />
                                            <c:set value="${fn:length(rowC)}" var="rowCount" />
                                            <td class="Tbod rborder Tleft" id="rowspan_${loop.index+1}" rowspan="${rowCount }"><a id="delRow_${loop.index+1}" href="javascript:delRow(${loop.index+1})"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /> 문항삭제</a></td>
                                        </tr>
                                        </c:if>
                                        <c:if test="${idx.index==1}">
                                        <tr>
                                            <th class="Tbornone Tleft lborder">문항</th>
                                            <td class="Tleft rborder">
                                                <input type="text" name="ask${loop.index+1}" class="bor1ddd" size="115" style="padding-left:10px" value="${opt}" onfocus="if(this.v=='질문하실 내용을 입력 하세요.') this.v=''" onblur="if(this.v=='') this.value='질문하실 내용을 입력 하세요.'" />
                                            </td>
                                        </tr>
                                        </c:if>
                                        <c:if test="${idx.index>1}">
                                        <tr>
                                            <th class="Tbornone Tleft lborder">${idx.index-1}</th>
                                            <td class="Tleft rborder">
                                                <input type="text" name="opt${loop.index+1}" class="bor1ddd" size="110" value="${opt=='null' ? '' : opt}" />
                                                <a href="javascript:void(0)" onclick="addSubRow(this,'${loop.index+1}')"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a>
                                                <a href="javascript:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a>
                                            </td>
                                        </tr>
                                        </c:if>
                                    </c:forEach>
                                    </table>
                                    <a id="addRow_${loop.index+1}" href="javascript:addRow(${loop.index+1})"><img src="/cms/image/btn_plus_small.jpg" alt="추가" /> 문항추가</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <!--/문항 끝-->
                        </table>
                    </td>
                </tr>
            </table>
            <!---/게시판 영역 -->
            </div><!--/main_table-->
            <!--/사이트 추가-->
            <div class="btn-c">
                <input class="chost_btn_s" type="submit" value="수정" onclick="return validate_survey('update')" />
                <a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('수정한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/satisfaction/index.html'">취소</a>
            </div><!--/confirm-->
        </li>
        </ul>
        </div><!--/content-->
        </form:form>
    </div>
    </div><!--/r_side-->
</div>
<!--/container-->
</div>
<!--/wrap-->
</body>
</html>