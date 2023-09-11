<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <div class="contents_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/site/tpl/index.html">템플릿관리</a> <strong>템플릿 등록</strong>
                    </div>
                </div>
                <form:form modelAttribute="zTpl" method="post" name="frm" onsubmit="return checkForm()">
                    <input name="act" type="hidden" value="insert" />
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg">
                                <h3 class="sub">템플릿 등록</h3>
                            </li>
                            <li>
                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1 bgneno" summary="템플릿명, 위치, 입력방법, 내용, 메모">
                                        <caption>사이트 추가</caption>
                                        <colgroup>
                                            <col width="150" />
                                            <col width="" />
                                        </colgroup>
                                        <tr>
                                            <th class="Tleft">템플릿명</th>
                                            <td class="Tbod Tbod Tleft"><input type="text" name="tpltitle" class="bor1ddd" value="" size="50" /></td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">위치</th>
                                            <td class="Tleft">
                                                <select name="tplposition" style="height:27px;">
                                                    <option value="1">Top</option>
                                                    <option value="2">Left</option>
                                                    <option value="3">Right</option>
                                                    <option value="4">Bottom</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">입력방법</th>
                                            <td class="Tleft">
                                                <input class="radio0" type="radio" name="tpltype" value="1" checked onclick="displayRow('01','tpl');" />
                                                내용직접입력
                                                <input class="radio1" type="radio" name="tpltype" value="2" onclick="displayRow('02','tpl');" />
                                                파일등록
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">내용</th>
                                            <td class="Tleft">
                                                <input type=radio class="radio0" name="tplcontstype" value="1" checked onclick="selArea(1)" />
                                                HTML
                                                <input type=radio class="radio1" name="tplcontstype" value="3" onclick="selArea(3)" />
                                                웹에디터
                                                <div id="txtarea">
                                                    <textarea class="bor1ddd" name="tplconts" id="tplconts" style="width:95%" rows="30"></textarea>
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
                                            <th class="Tbornone Tleft">메모</th>
                                            <td class="Tleft">
                                                <textarea class="bor1ddd" name="tplmemo" style="width:95%" rows="8"></textarea>
                                            </td>
                                        </tr>
                                    </table>
                                    <!--/게시판 영역-->
                                </div><!--/main_table-->
                                <!--/사이트 추가-->
                                <div class="btn-c">
                                    <input class="chost_btn_s" type="submit" value="등록" onclick="if(!window.confirm('저장하시겠습니까?')){return false;}"/>
                                    <a  class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='index.html'">취소</a>
                                </div>

                                <!--
                                <div class="confirm">
                                    <p>
                                        <input type="image" src="/cms/image/btn_confirm.jpg" alt="등록" onclick="if(window.confirm('저장하시겠습니까?')){saveContent('insert')}" />
                                        <a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='index.html'">
                                            <img src="/cms/image/btn_cancel.jpg" alt="취소" />
                                        </a>
                                    </p>
                                </div>
                                -->
                            </li>
                        </ul>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../../end.jsp" flush="false" />