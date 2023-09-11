<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <script src="/usr/skin/survey/default/js/validate.js"></script>
            <script type="text/javascript">
                $(document).ready(function() {
                    $(document).on("click", ".opt-type", function() {
                        // console.log($(this).val());
                        var obj = $(this).val();
                        var parent = $(this).parent("td");
                        parent.find("span").find("input[type=radio]").prop("checked", false);
                        parent.find("span").css('display', 'none');

                        parent.find("." + obj).css('display', 'inline');
                        parent.find("." + obj).find("input[type=radio]").eq(0).prop("checked", true);

                        if (obj == "opt-2") {
                            $(this).closest("table").find(".answer-item").remove();
                        } else {
                            reviveSubRow(this);
                        }
                    });
                });
            </script>
            <style type="text/css">
                input.text {height: 15px; font-size: 12px; padding-left: 3px;}
                input.bor1ddd {padding-left: 5px;}
                .input_table td {padding: 5px 10px;}
                span > input:nth-of-type(2) {margin-left: 5px;}
            </style>
            <div id="contents">
               <div class="contants_top">
                    <div class="location">
                    	<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/orgculturedigmng/index.html">성희롱방지 조직문화진단관리</a> <a href="index.html">만족도조사 관리</a> <strong>만족도조사 등록</strong>
                    </div>
                </div>
                <form:form modelAttribute="zSatisfactionVo" name="frm" method="post">
                    <input name="act" type="hidden" value="insert" />
                    <input name="question" type="hidden" value="1" />
                    <!-- <input name="contstype" type="hidden" value="3" /> -->
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">만족도조사 등록</h3></li>
                            <li>
                                <div class="main_table">
                                    <!-- 게시판 영역 -->
                                    <table class="main_table1 bgneno" summary="제목, 기관명, 기간 설정, 대상 선택, 메인에 보기 표시, 설명, 문항 관리">
                                        <caption>만족도조사 등록</caption>
                                        <colgroup>
                                            <col width="150" />
                                            <col width="" />
                                        </colgroup>
                                        <tr>
                                            <th class="Tleft">제목</th>
                                            <td class="Tbod Tbod Tleft">
                                                <input type="text" name="title" id="title" class="bor1ddd" size="100" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">기관명</th>
                                            <td class="Tleft">
                                                <input type="text" name="orgname" id="orgname" class="bor1ddd" size="30" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">기간 설정</th>
                                            <td class="Tleft">
                                                시작 :
												<input id="d4311" name="sdate" type="date" min="2019-01-01" max="2022-12-31" placeholder="년/월/일" />
												~
												종료 :
												<input id="d4312" name="edate" type="date" min="2019-01-01" max="2022-12-31" placeholder="년/월/일" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">대상 선택</th>
                                            <td class="Tleft">
                                                <input type="radio" class="radio0" name="target" value="0" checked />
                                                전체
                                                <input type="radio" class="radio1" name="target" value="1" />
                                                회원
                                                <input type="radio" class="radio1" name="target" value="2" />
                                                비회원
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">메인에 보기 표시</th>
                                            <td class="Tleft">
                                                <input type="radio" class="radio1" name="mainview" value="1" checked="checked" />
                                                예
                                                <input type="radio" class="radio1" name="mainview" value="0" />
                                                아니오
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">설명</th>
                                            <td class="Tleft">
                                            	<input type=radio class="radio0" name="contstype" value="1" checked onclick="selArea(1)" />
												HTML
												<input type=radio class="radio1" name="contstype" value="3" onclick="selArea(3)" />
												웹에디터
                                                <div id="txtarea">
                                                    <textarea class="bor1ddd" name="conts" id="conts" style="width:95%" rows="30"></textarea>
                                                </div>
                                                <div id="editorarea" style="width:96%;display:none">
                                                    <script type="text/javascript">
													$(document).ready(function(){
														CKEDITOR.replace("ckeditorConts" ,{
															skin : 'office2013',
															//width : '620px',			// 입력창의 넓이, 넓이는 config.js 에서 % 로 제어
															height : '500px',				// 입력창의 높이

															fullPage: true,				// 모든 html 허용
															allowedContent: true,		// 모든 html 허용

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
										<textarea class="bor1ddd" name="ckeditorConts" id="ckeditorConts" style="width:95%" rows="30"></textarea>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">문항 관리</th>
                                            <td class="Tleft">
                                                <!--<a href="javascript:addRow()" style="padding-left:20px"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /> 문항추가</a> <a href="javascript:delRow()" style="padding-left:10px"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /> 문항삭제</a>-->
                                                <table class="allnone" id="question" summary="문항 관리">
                                                    <caption>문항 관리</caption>
                                                    <colgroup>
                                                        <col width="20px" />
                                                        <col />
                                                    </colgroup>
                                                    <!--문항 시작-->
                                                    <tr id="trRow_1">
                                                        <!--<th class="checkbox_research"><input type="checkbox" /></th>-->
                                                        <td class="checkbox_research">
                                                            <table class="main_table1 bgneno" summary="형식, 문항, 1, 2">
                                                                <colgroup>
                                                                    <col width="50px" />
                                                                    <col />
                                                                    <col width="100" />
                                                                </colgroup>
                                                                <tr>
                                                                    <th class="Tleft lborder">형식</th>
                                                                    <td class="Tbod rborder Tleft">
                                                                        <input type="radio" value="opt-1" class="radio0" id="opt-type_1_1" name="opt-type1" checked="checked">객관식
                                                                        <input type="radio" value="opt-2" class="radio0" id="opt-type_2_1" name="opt-type1" style="margin-left:5px;">주관식
                                                                        <span class="opt-1" style="margin-left:50px;">
                                                                            <input class="radio0" type="radio" value="2" id="opttype_2_1" name="opttype1" checked="checked">단일선택
                                                                            <input class="radio0" type="radio" value="1" id="opttype_1_1" name="opttype1">중복선택
                                                                        </span>
                                                                        <span class="opt-2" style="display:none;margin-left:50px;">
                                                                            <input class="radio0" type="radio" value="3" id="opttype_3_1" name="opttype1">단답형
                                                                            <input class="radio0" type="radio" value="4" id="opttype_4_1" name="opttype1">서술형
                                                                        </span>
                                                                    </td>
                                                                    <td class="Tbod rborder Tleft" id="rowspan_1" rowspan="4"><a id="delRow_1" href="javascript:delRow(1)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /> 문항삭제</a></td>
                                                                </tr>
                                                                <tr>
                                                                    <th class="Tbornone Tleft lborder">문항</th>
                                                                    <td class="Tleft rborder">
                                                                        <input type="text" name="ask1" class="bor1ddd" size="115" value="질문하실 내용을 입력 하세요." onfocus="if(this.v=='질문하실 내용을 입력 하세요.') this.v=''" onblur="if(this.v=='') this.value='질문하실 내용을 입력 하세요.'" />
                                                                    </td>
                                                                </tr>
                                                                <tr class="answer-item">
                                                                    <th class="Tbornone Tleft lborder">1</th>
                                                                    <td class="Tleft rborder">
                                                                        <input type="text" name="opt1" class="bor1ddd" size="110" value="" />
                                                                        <a href="javascript:void(0)" onclick="addSubRow(this,1)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a>
                                                                        <a href="javascript:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a>
                                                                    </td>
                                                                </tr>
                                                                <tr class="answer-item">
                                                                    <th class="Tbornone Tleft lborder">2</th>
                                                                    <td class="Tleft rborder">
                                                                        <input type="text" name="opt1" class="bor1ddd" size="110" value="" />
                                                                        <a href="javascript:void(0)" onclick="addSubRow(this,1)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a>
                                                                        <a href="javascript:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <a id="addRow_1" href="javascript:addRow(1)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /> 문항추가</a>
                                                        </td>
                                                    </tr>
                                                <!--/문항 끝-->
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <!---/게시판 영역 -->
                                </div><!--/main_table-->
                                <div class="btn-c">
                                    <p>
                                        <input class="chost_btn_s" type="submit" value="등록" onclick="return validate_survey('insert')" />
                                        <a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/satisfaction/index.html'">취소</a>
                                    </p>
                                </div><!--/confirm-->
                            </li>
                        </ul>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../../end.jsp" flush="false" />