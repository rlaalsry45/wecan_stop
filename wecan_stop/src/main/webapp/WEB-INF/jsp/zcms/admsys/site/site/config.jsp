<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div id="contents">
				<div class="contents_top">
					<div class="location">
						<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/">홈페이지관리</a> <strong>홈페이지 환경설정</strong>
					</div>
				</div>
			<form:form modelAttribute="zsitecfgVo" method="post" name="frm" onsubmit="return checkForm()">
				<input name="act" type="hidden" value="update" />
				<input name="sitecfgmaincss" type="hidden" value="" />
				<input name="sitecfgsubcss" type="hidden" value="" />
				<input name="sitecfgmainjs" type="hidden" value="" />
				<input name="sitecfgsubjs" type="hidden" value="" />
				<input name="sitecfgtoptpl" type="hidden" value="" />
				<input name="sitecfglefttpl" type="hidden" value="" />
				<input name="sitecfgrighttpl" type="hidden" value="" />
				<input name="sitecfgbottomtpl" type="hidden" value="" />
				<div id="content">
				<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">환경설정</h3></li>
						<li>
					<div class="main_table">
						<!---게시판 영역------------------------->
						<h4>메인페이지 선택</h4>
						<table class="main_table1 bgneno" summary="메인페이지 선택">
							<caption>메인페이지 선택</caption>
							<colgroup>
								<col width="150px" />
								<col />
							</colgroup>
							<tr>
								<th class="Tleft">메인페이지 선택</th>
								<td class="Tbod Tbod Tleft">
									<select name="sitecfgmain" style="height:27px;">
										<option value="-99">메인페이지 사용시 선택하십시오</option>
										<c:forEach items="${mainList}" var="each">
										<option value="<c:out value='${each.mainno}' />" <c:if test="${each.mainno==siteCfg.sitecfgmain}"><c:out value='selected' /></c:if>><c:out value='${each.maintitle}' /></option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">DTD 선언</th>
								<td class="Tbornone Tleft">
									<input type="text" name="sitecfgdtd" class="bor1ddd" size="117" value='<c:out value="${siteCfg.sitecfgdtd}" default="&lt;&#33;DOCTYPE html PUBLIC &#34;&#45;&#47;&#47;W3C&#47;&#47;DTD XHTML 1.0 Transitional&#47;&#47;EN&#34; &#34;http:&#47;&#47;www.w3.org&#47;TR&#47;xhtml1&#47;DTD&#47;xhtml1&#45;transitional.dtd&#34;&gt;" escapeXml="false" />' />
									<a class="btmore06" href="javascript:restore(1)">초기화</a>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">XHTML 네임스페이스</th>
								<td class="Tbornone Tleft">
									<input type="text" name="sitecfghtm" class="bor1ddd" size="117" value='<c:out value="${siteCfg.sitecfghtm}" default="&lt;html xmlns&#61;&#34;http:&#47;&#47;www.w3.org&#47;1999&#47;xhtml&#34; xml&#58;lang&#61;&#34;ko&#34; lang&#61;&#34;ko&#34;&gt;" escapeXml="false" />' />
									<a class="btmore06" href="javascript:restore(2)">초기화</a>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">META 태그설정</th>
								<td class="Tbornone Tleft">
									<textarea class="bor1ddd" name="sitecfgmeta" id="sitemenuconts" style="width:90%" rows="10"><c:out value="${siteCfg.sitecfgmeta}" /></textarea>
								</td>
							</tr>
						</table>
						<h4>CSS/ JS 선택</h4>
						<p class="notification_r"><img alt="!" src="/cms/image/excla.gif">이곳에서 CSS/JS 를 설정하게 되면 메뉴/콘텐츠 관리에서 새롭게 생성된 페이지에  기본으로 설정됩니다.</p>
						<table class="main_table1 bgneno" summary="CSS 설정">
							<caption>CSS 설정</caption>
							<colgroup>
								<col width="150" />
								<col width="" />
							</colgroup>
							<tr>
								<th>메인페이지 CSS선택
								<a class="imgSelect" title="메인페이지 CSS선택 설명">메인페이지 CSS선택 설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>메인페이지 CSS선택</strong></br>
								해당 페이지 작업 시 사용한 CSS 와 JS 파일을 추가 및 제거할 수 있습니다. <em>CSS/ JS 등록은 CSS 관리 및 JS 관리</em>에서 등록하시면 자동으로 이곳에 노출됩니다.
								</div>
								</th>
								<td class="Tbod Tbod Tleft">
									<div class="main_css_select">
										<ul>
											<li>
												<select name="main_css_source" multiple>
													<c:forEach items="${cssList}" var="each">
													<option value="<c:out value='${each.cssno}' />"><c:out value='${each.csstitle}' /></option>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0)" onclick="select('main_css_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												</br>
												<a href="javascript:void(0)" onclick="deselect('main_css_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="main_css_dest" multiple>
													<c:forEach items="${mainCss}" var="each">
													<option value="<c:out value='${each.cssno}' />"><c:out value='${each.csstitle}' /></option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th>서브페이지 CSS선택
								<a class="imgSelect" title="서브페이지 CSS선택 설명">서브페이지 CSS선택 설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>서브페이지 CSS선택</strong></br>
								해당 페이지 작업 시 사용한 CSS 와 JS 파일을 추가 및 제거할 수 있습니다. <em>CSS/ JS 등록은 CSS 관리 및 JS 관리</em>에서 등록하시면 자동으로 이곳에 노출됩니다.
								</div>
								</th>
								<td class="Tbod Tbod Tleft">
									<div class="main_css_select">
										<ul>
											<li>
												<select name="sub_css_source" multiple>
													<c:forEach items="${cssList}" var="each">
													<option value="<c:out value='${each.cssno}' />"><c:out value='${each.csstitle}' /></option>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0)" onclick="select('sub_css_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												</br>
												<a href="javascript:void(0)" onclick="deselect('sub_css_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="sub_css_dest" multiple>
													<c:forEach items="${subCss}" var="each">
													<option value="<c:out value='${each.cssno}' />"><c:out value='${each.csstitle}' /></option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th>메인페이지 js선택
								<a class="imgSelect" title="메인페이지 js선택 설명">메인페이지 js선택 설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>메인페이지 js선택</strong></br>
								해당 페이지 작업 시 사용한 CSS 와 JS 파일을 추가 및 제거할 수 있습니다. <em>CSS/ JS 등록은 CSS 관리 및 JS 관리</em>에서 등록하시면 자동으로 이곳에 노출됩니다.
								</div>
								</th>
								<td class="Tbod Tbod Tleft">
									<div class="main_css_select">
										<ul>
											<li>
												<select name="main_js_source" multiple>
													<c:forEach items="${jsList}" var="each">
													<option value="<c:out value='${each.jsno}' />"><c:out value='${each.jstitle}' /></option>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0)" onclick="select('main_js_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												</br>
												<a href="javascript:void(0)" onclick="deselect('main_js_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="main_js_dest" multiple>
													<c:forEach items="${mainJs}" var="each">
													<option value="<c:out value='${each.jsno}' />"><c:out value='${each.jstitle}' /></option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th>서브페이지 js선택
								<a class="imgSelect" title="서브페이지 js선택 설명">서브페이지 js선택 설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>서브페이지 js선택</strong></br>
								해당 페이지 작업 시 사용한 CSS 와 JS 파일을 추가 및 제거할 수 있습니다. <em>CSS/ JS 등록은 CSS 관리 및 JS 관리</em>에서 등록하시면 자동으로 이곳에 노출됩니다.
								</div>
								</th>
								<td class="Tbod Tbod Tleft">
									<div class="main_css_select">
										<ul>
											<li>
												<select name="sub_js_source" multiple>
													<c:forEach items="${jsList}" var="each">
													<option value="<c:out value='${each.jsno}' />"><c:out value='${each.jstitle}' /></option>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0)" onclick="select('sub_js_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												</br>
												<a href="javascript:void(0)" onclick="deselect('sub_js_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="sub_js_dest" multiple>
													<c:forEach items="${subJs}" var="each">
													<option value="<c:out value='${each.jsno}' />"><c:out value='${each.jstitle}' /></option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
						</table>
						<h4>서브페이지 템플릿 설정</h4>
						<p class="notification_r"><img alt="!" src="/cms/image/excla.gif">이곳에서 서브페이지 템플릿 설정하게 되면 메뉴/콘텐츠 관리에서 새롭게 생성된 페이지에  기본으로 설정됩니다.</p>
						<table class="main_table1 bgneno" summary="템플릿 설정">
							<caption>템플릿 설정</caption>
							<colgroup>
								<col width="150" />
								<col width="" />
							</colgroup>
							<tr>
								<th>상단 템플릿 설정
								<a class="imgSelect" title="상단 템플릿 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>상단 템플릿</strong></br>
								공통으로 사용되는 페이지를 호출합니다.(ex:상단 내비게이션,GNB 등)<br />
								※ 오른쪽 위치 이동을 통해 출력 순위를 정할 수 있습니다.
								</div>
								</th>
								<td class="Tbod Tbod Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
										<a class="bt" href="javascript:void(0)" onclick="moveUp('tpl_t_dest')">순서 올리기</a><a class="next" href="javascript:void(0)" onclick="moveDown('tpl_t_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="tpl_t_source" multiple>
													<c:forEach items="${tList}" var="each">
													<c:if test="${each.tplposition=='1'}"><option value="<c:out value='${each.tplno}' />"><c:out value='${each.tpltitle}' /></option></c:if>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0)" onclick="select('tpl_t_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												</br>
												<a href="javascript:void(0)" onclick="deselect('tpl_t_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="tpl_t_dest" multiple>
													<c:forEach items="${topTpl}" var="each">
													<option value="<c:out value='${each.tplno}' />"><c:out value='${each.tpltitle}' /></option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th>좌측 템플릿 설정
								<a class="imgSelect" title="좌측 템플릿 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>좌측 템플릿</strong></br>
								공통으로 사용되는 페이지를 호출합니다.(ex:좌측 내비게이션,LNB 등)<br />
								※ 오른쪽 위치 이동을 통해 출력 순위를 정할 수 있습니다.
								</div>
								</th>
								<td class="Tbod Tbod Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
										<a class="bt" href="javascript:void(0)" onclick="moveUp('tpl_l_dest')">순서 올리기</a><a class="next" href="javascript:void(0)" onclick="moveDown('tpl_l_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="tpl_l_source" multiple>
													<c:forEach items="${tList}" var="each">
													<c:if test="${each.tplposition=='2'}"><option value="<c:out value='${each.tplno}' />"><c:out value='${each.tpltitle}' /></option></c:if>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0)" onclick="select('tpl_l_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												</br>
												<a href="javascript:void(0)" onclick="deselect('tpl_l_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="tpl_l_dest" multiple>
													<c:forEach items="${leftTpl}" var="each">
													<option value="<c:out value='${each.tplno}' />"><c:out value='${each.tpltitle}' /></option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th>우측 템플릿 설정
								<a class="imgSelect" title="우측 템플릿 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>우측 템플릿</strong></br>
								공통으로 사용되는 페이지를 호출합니다.(ex:우측 내비게이션,RNB 등)<br />
								※ 오른쪽 위치 이동을 통해 출력 순위를 정할 수 있습니다.
								</div>
								</th>
								<td class="Tbod Tbod Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
										<a class="bt" href="javascript:void(0)" onclick="moveUp('tpl_r_dest')">순서 올리기</a><a class="next" href="javascript:void(0)" onclick="moveDown('tpl_r_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="tpl_r_source" multiple>
													<c:forEach items="${tList}" var="each">
													<c:if test="${each.tplposition=='3'}"><option value="<c:out value='${each.tplno}' />"><c:out value='${each.tpltitle}' /></option></c:if>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0)" onclick="select('tpl_r_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												</br>
												<a href="javascript:void(0)" onclick="deselect('tpl_r_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="tpl_r_dest" multiple>
													<c:forEach items="${rightTpl}" var="each">
													<option value="<c:out value='${each.tplno}' />"><c:out value='${each.tpltitle}' /></option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th>하단 템플릿 설정
								<a class="imgSelect" title="하단 템플릿 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>하단 템플릿</strong></br>
								공통으로 사용되는 페이지를 호출합니다.(ex:하단 저작권 및 주소,footer 등)<br />
								※ 오른쪽 위치 이동을 통해 출력 순위를 정할 수 있습니다.
								</div>
								</th>
								<td class="Tbod Tbod Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
										<a class="bt" href="javascript:void(0)" onclick="moveUp('tpl_b_dest')">순서 올리기</a><a class="next" href="javascript:void(0)" onclick="moveDown('tpl_b_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="tpl_b_source" multiple>
													<c:forEach items="${tList}" var="each">
														<c:if test="${each.tplposition=='4'}">
														<option value="<c:out value='${each.tplno}' />"><c:out value='${each.tpltitle}' /></option>
														</c:if>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0)" onclick="select('tpl_b_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												</br>
												<a href="javascript:void(0)" onclick="deselect('tpl_b_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="tpl_b_dest" multiple>
													<c:forEach items="${bottomTpl}" var="each">
													<option value="<c:out value='${each.tplno}' />"><c:out value='${each.tpltitle}' /></option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
						</table>
						<h4>기타기능 설정</h4>
						<table class="main_table1 bgneno" summary="기타기능 설정">
							<caption>기타기능 설정</caption>
							<colgroup>
								<col width="150" />
								<col />
							</colgroup>
							<tr>
								<th>기타기능 설정</th>
								<td class="Tbod Tbod Tleft">
									<input class="checkbox1" type="checkbox" id="sitecfgzoom" name="sitecfgzoom" value="1" <c:if test="${siteCfg.sitecfgzoom=='1'}"><c:out value="checked" /></c:if> disabled>
									<label class="on" for="sitecfgzoom">확대/축소</label>
									<input class="checkbox1" type="checkbox" id="sitecfgprint" name="sitecfgprint" value="1" <c:if test="${siteCfg.sitecfgprint=='1'}"><c:out value="checked" /></c:if>  disabled>
									<label class="on" for="sitecfgprint">프린트</label>
									<input class="checkbox1" type="checkbox" id="sitecfgemail" name="sitecfgemail" value="1" <c:if test="${siteCfg.sitecfgemail=='1'}"><c:out value="checked" /></c:if> disabled>
									<label class="on" for="sitecfgemail">이메일</label>
									<input class="checkbox1" type="checkbox" id="sitecfgval" name="sitecfgval" value="1" <c:if test="${siteCfg.sitecfgval=='1'}"><c:out value="checked" /></c:if> disabled>
									<label class="on" for="sitecfgval">평가기능</label>
									<input class="checkbox1" type="checkbox" id="sitecfgopinion" name="sitecfgopinion" value="1" <c:if test="${siteCfg.sitecfgopinion=='1'}"><c:out value="checked" /></c:if> disabled>
									<label class="on" for="sitecfgopinion">의견기능</label>
									<input class="checkbox1" type="checkbox" id="sitecfgscrap" name="sitecfgscrap" value="1" <c:if test="${siteCfg.sitecfgscrap=='1'}"><c:out value="checked" /></c:if> disabled>
									<label class="on" for="sitecfgscrap">스크랩기능</label>
								</td>
							</tr>
						</table>
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
					<div class="btn-c">
						<input class="chost_btn_s" type="submit" value="확인" />
						<a  class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/site/index.html'">취소</a>
					</div>

				</div>
					</li>
				</ul><!--/content-->
			</form:form>
			</div>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<script type="text/javascript">
window.onload = function(){
	document.getElementsByName("main_css_source")[0].size = document.getElementsByName("main_css_dest")[0].size = document.getElementsByName("main_css_source")[0].options.length;
	document.getElementsByName("sub_css_source")[0].size = document.getElementsByName("sub_css_dest")[0].size = document.getElementsByName("sub_css_source")[0].options.length;
	document.getElementsByName("main_js_source")[0].size = document.getElementsByName("main_js_dest")[0].size = document.getElementsByName("main_js_source")[0].options.length;
	document.getElementsByName("sub_js_source")[0].size = document.getElementsByName("sub_js_dest")[0].size = document.getElementsByName("sub_js_source")[0].options.length;
	document.getElementsByName("tpl_t_source")[0].size = document.getElementsByName("tpl_t_dest")[0].size = document.getElementsByName("tpl_t_source")[0].options.length;
	document.getElementsByName("tpl_l_source")[0].size = document.getElementsByName("tpl_l_dest")[0].size = document.getElementsByName("tpl_l_source")[0].options.length;
	document.getElementsByName("tpl_r_source")[0].size = document.getElementsByName("tpl_r_dest")[0].size = document.getElementsByName("tpl_r_source")[0].options.length;
	document.getElementsByName("tpl_b_source")[0].size = document.getElementsByName("tpl_b_dest")[0].size = document.getElementsByName("tpl_b_source")[0].options.length;
}
</script>
</body>
</html>