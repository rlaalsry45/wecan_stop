<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
function call_archv_popup(ftn,mlt,archv_no_list){
		var url		= '/admsys/archv/data/list.html?type=1&ftn='+ftn+'&mlt='+mlt+'&archv_no_list='+archv_no_list;
		var width	= 800;
		var height	= 600;
		var conf	= 'scrollbars=1, resizable, status=0, toolbar=0, width=' + width + ', height=' + height;
		var a		= window.open(url, "ztreer", conf);
		a.focus();

		var i = (window.screen.width - width) / 2;
		var j = (window.screen.height - height) / 2;
		a.moveTo(i, j);
}

function call_preview(){


	if (checkForm()){

		var width	= 1200;
		var height	= 700;
		var conf	= 'scrollbars=1, resizable, status=0, toolbar=0, width=' + width + ', height=' + height;
		var a		= window.open("", "menuPreview", conf);
		a.focus();

		var i = (window.screen.width - width) / 2;
		var j = (window.screen.height - height) / 2;
		a.moveTo(i, j);

		document.frm.target='menuPreview';
		document.frm.action='/admsys/site/menu/menuPreview.html?menuno=9999&siteno=${siteno}'; // 팝업창 윈도우 이름
		document.frm.submit();

		document.frm.target= '';
		document.frm.action='';

	}

}

</script>
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
		<div id="contents">
				<div class="contents_top">
					<div class="location">
						<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/site/menu/index.html">메뉴/컨텐츠관리</a> <strong>${menuno>0 ? "하" : "최상" }위 메뉴등록</strong>
					</div>
				</div>
			<form:form modelAttribute="zmenuVo" method="post" name="frm" onsubmit="return checkForm()">
				<input name="act" type="hidden" value="insert" />
				<%-- <input name="siteno" id="siteno" type="hidden" value="${siteno}" /> //나모이용시에는 주석처리할것--%>
				<%-- <input name="menuno" id="menuno" type="hidden" value="${menuno}" /> --%>
				<input name="menusubcss" type="hidden" value="" />
				<input name="menusubjs" type="hidden" value="" />
				<input name="menuttpl" type="hidden" value="" />
				<input name="menultpl" type="hidden" value="" />
				<input name="menurtpl" type="hidden" value="" />
				<input name="menubtpl" type="hidden" value="" />
				<input name="menusubno" type="hidden" value="" />
				<input name="menuno_r" type="hidden" value="" />
				<div id="content">
				<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">${menuno>0 ? "하" : "최상" }위 메뉴등록 [ <c:out value="${sitetitle}" escapeXml="false" /> ]<!--현재 메뉴가 어떤 사이트의 메뉴관리인지 표--></h3></li>
						<li>
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="main_table1 bgneno" summary="Depth, 메뉴명, 상태, 화면참조, 콘텐츠 종류">
							<caption>메뉴등록</caption>
							<colgroup>
								<col width="150px" />
								<col />
							</colgroup>
							<tr>
								<th class="Tleft">Depth</th>
								<td class="Tbod Tbod Tleft">
									<c:forEach items="${depth}" var="each" varStatus="loop">
										<c:out value="<img class='align' src='/cms/image/bul_menu_level_${loop.count}.jpg' alt='${loop.count}차 메뉴' />&nbsp;${each.menutitle}&nbsp;&gt;&nbsp;" escapeXml="false" />
									</c:forEach>
									<c:out value="<img  class='align' src='/cms/image/bul_menu_level_${fn:length(depth)+1}.jpg' alt='${fn:length(depth)+1}차 메뉴' />" escapeXml="false" />
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">메뉴명</th>
								<td class="Tleft">
									<input type="text" name="menutitle" class="bor1ddd" size="75" value="<c:if test="${act=='refer'}"><c:out value="${siteCfg.menutitle}" escapeXml="true" /></c:if>" />
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">상태</th>
								<td class="Tleft">
									<input type="radio" class="radio0" name="menustatus" value="1" <c:choose><c:when test="${act=='refer'}"><c:if test="${siteCfg.menustatus=='1'}">checked</c:if></c:when><c:otherwise>checked</c:otherwise></c:choose> />
									사용
									<input type="radio" class="radio1" name="menustatus" value="2" <c:if test="${siteCfg.menustatus=='2'}">checked</c:if> />
									중지
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">화면참조</th>
								<td class="Tleft">
									<script type="text/javascript">
										<!--

										reftree = new dTree('reftree');

										reftree.config.inOrder = true;
										reftree.config.useCookies = false;
										reftree.config.useSelection = true;

										reftree.add(0,-1,'${sitetitle}');

										<c:forEach items="${list}" var="each">
											reftree.add(${each.menuno},${each.menuparentno},"${each.menutitle}","javascript:refer(${each.menuno});");
										</c:forEach>

										document.write(reftree);

										<c:if test='${act=="refer"}'>
										reftree.openTo(${siteCfg.menuno},true);
										</c:if>

										//-->
									</script>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">콘텐츠 종류</th>
								<td class="Tleft">
									<input type="radio" class="radio0" name="menutype" value="01" onclick="displayRow('01','site');" checked<%-- <c:if test="${siteCfg.menutype=='01'}">checked</c:if> --%> />
									직접작성
									<input type="radio" class="radio0" name="menutype" value="02" onclick="displayRow('02','site');" <%-- <c:if test="${siteCfg.menutype=='02'}">checked</c:if> --%> />
									하위메뉴지정
									<input type="radio" class="radio1" name="menutype" value="04" onclick="displayRow('04','site');" <%-- <c:if test="${siteCfg.menutype=='04'}">checked</c:if> --%> />
									외부링크
									<input type="radio" class="radio1" name="menutype" value="05" onclick="displayRow('05','site');" <%-- <c:if test="${siteCfg.menutype=='05'}">checked</c:if> --%> />
									내부링크
									<input type="radio" class="radio1" name="menutype" value="06" onclick="displayRow('06','site');" <%-- <c:if test="${siteCfg.menutype=='06'}">checked</c:if> --%> />
									아카이브
								</td>
							</tr>
							<tr id="02" style="display:<c:choose><c:when test="${act=='refer'}"><c:if test="${siteCfg.menutype!='02'}">none</c:if></c:when><c:otherwise>none</c:otherwise></c:choose>;">
								<th class="Tbornone Tleft">하위메뉴지정</th>
								<td class="Tleft">
									<script type="text/javascript">
										<!--

										subtree = new dTree('subtree');

										subtree.config.inOrder = true;
										subtree.config.useCookies =
										false;
										subtree.config.useSelection =
										true;

										subtree.add(0,-1,'${sitetitle}');

										<c:forEach items="${list}"
										var="each">
										subtree.add(${each.menuno},${each.menuparentno},"${each.menutitle}","javascript:void(frm.menusubno.value='${each.menuno}');");
										</c:forEach>

										document.write(subtree);

										<c:if test='${act=="refer"&&siteCfg.menusubno>0}'>
										subtree.openTo(${siteCfg.menusubno},true);
										</c:if>

										//-->
									</script>
								</td>
							</tr>
							<tr id="04" style="display:<c:choose><c:when test="${act=='refer'}"><c:if test="${siteCfg.menutype!='04'}">none</c:if></c:when><c:otherwise>none</c:otherwise></c:choose>;">
								<th class="Tbornone Tleft">외부링크지정</th>
								<td class="Tleft">
									http://<input type="text" name="menulink" class="bor1ddd" />
									<br />
									타겟
									<select name="menulinktarget">
										<option value="1" <c:if test="${siteCfg.menulinktarget=='1'}">selected</c:if>>선택안함</option>
										<option value="2" <c:if test="${siteCfg.menulinktarget=='2'}">selected</c:if>>SELF</option>
										<option value="3" <c:if test="${siteCfg.menulinktarget=='3'}">selected</c:if>>NEW</option>
										<option value="4" <c:if test="${siteCfg.menulinktarget=='4'}">selected</c:if>>PARENT</option>
										<option value="5" <c:if test="${siteCfg.menulinktarget=='5'}">selected</c:if>>기타</option>
									</select>
									기타값
									<input type="text" name="menulinkother" class="bor1ddd" value="${siteCfg.menulinkother}" />
								</td>
							</tr>
							<tr id="05" style="display:<c:choose><c:when test="${act=='refer'}"><c:if test="${siteCfg.menutype!='05'}">none</c:if></c:when><c:otherwise>none</c:otherwise></c:choose>;">
								<th class="Tbornone Tleft">내부링크지정</th>
								<td class="Tleft">
									서버이름/<input type="text" name="menuintenallink" size="100" class="bor1ddd" />
									<br />
									포함범위
									<select name="menuintenallinktarget">
										<option value="1" <c:if test="${siteCfg.menuintenallinktarget=='1'}">selected</c:if>>본문링크(템플릿사용)</option>
										<option value="2" <c:if test="${siteCfg.menuintenallinktarget=='2'}">selected</c:if>>전체링크(템플릿미사용)</option>
										<%-- <option value="3" <c:if test="${siteCfg.menulinktarget=='3'}">selected</c:if>>NEW</option>
										<option value="4" <c:if test="${siteCfg.menulinktarget=='4'}">selected</c:if>>PARENT</option>
										<option value="5" <c:if test="${siteCfg.menulinktarget=='5'}">selected</c:if>>기타</option> --%>
									</select>
									기타값
									<input type="text" name="menuintenallinkother" class="bor1ddd" value="${siteCfg.menuintenallinkother}" />
								</td>
							</tr>
							<tr class="Tbornone Tleft" id="06" style="display:<c:choose><c:when test="${act=='refer'}"><c:if test="${siteCfg.menutype!='06'}">none</c:if></c:when><c:otherwise>none</c:otherwise></c:choose>;">
								<th class="Tbornone Tleft">아카이브 지정</th>
								<td class="Tleft">
									<!-- <input type="hidden" id="archv_no" name="archv_no" value="">
									<input type="text" id="archv_title"  value="" class="bor1ddd" size="100" value="" readonly />
									<a href="javascript:void(0)" onclick="call_archv_popup('add_archv_no','n',null)">
										<img src="/cms/image/common_btn_archv.jpg">
									</a>
									<br />
									<input type="text" id="menuarchivenamepath" value="" class="bor1ddd" size="75" value="" readonly /> -->
									<p class="notification"><img src="/cms/image/excla.gif" alt="!">아카이브는 메뉴를 생성한 후 수정화면에서 등록가능합니다.</p>
								</td>
							</tr>
						</table>
						<h4>CSS/ JS 선택</h4>
						<table class="main_table1 bgneno" summary="서브페이지 CSS선택, 서브페이지 js선택">
							<caption>CSS/JS 설정</caption>
							<colgroup>
								<col width="150px" />
								<col/>
							</colgroup>
							<tr>
								<th class="Tleft Tleft">서브페이지 CSS선택</th>
								<td class="Tbod Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
											<a class="bt" href="javascript:void(0);" onclick="moveUp('sub_css_dest')">순서 올리기</a><a class="next" href="javascript:void(0);" onclick="moveDown('sub_css_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="sub_css_source" multiple>
													<c:forEach items="${cssList}" var="each">
													<option value='${each.cssno}'>${each.csstitle}</option>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0);" onclick="select('sub_css_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												<br />
												<a href="javascript:void(0);" onclick="deselect('sub_css_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="sub_css_dest" multiple>
													<c:forEach items="${subCss}" var="each">
													<option value='${each.cssno}'>${each.csstitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">서브페이지 js선택</th>
								<td class="Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
											<a class="bt" href="javascript:void(0);" onclick="moveUp('sub_js_dest')">순서 올리기</a><a class="next" href="javascript:void(0);" onclick="moveDown('sub_js_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="sub_js_source" multiple>
													<c:forEach items="${jsList}" var="each">
													<option value='${each.jsno}'>${each.jstitle}</option>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0);" onclick="select('sub_js_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												<br />
												<a href="javascript:void(0);" onclick="deselect('sub_js_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="sub_js_dest" multiple>
													<c:forEach items="${subJs}" var="each">
													<option value='${each.jsno}'>${each.jstitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
						</table>
						<h4>서브페이지 템플릿 설정</h4>
						<table class="main_table1 bgneno" summary="상단 템플릿 설정, 좌측 템플릿 설정, 우측 템플릿 설정, 하단 템플릿 설정">
							<caption>템플릿 설정</caption>
							<colgroup>
								<col width="150px" />
								<col/>
							</colgroup>
							<tr>
								<th class="Tleft">상단 템플릿 설정</th>
								<td class="Tbod Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
											<a class="bt" href="javascript:void(0);" onclick="moveUp('tpl_t_dest')">순서 올리기</a><a class="next" href="javascript:void(0);" onclick="moveDown('tpl_t_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="tpl_t_source" multiple>
													<c:forEach items="${tList}" var="each">
													<c:if test="${each.tplposition=='1'}"><option value='${each.tplno}'>${each.tpltitle}</option></c:if>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0);" onclick="select('tpl_t_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												<br />
												<a href="javascript:void(0);" onclick="deselect('tpl_t_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="tpl_t_dest" multiple>
													<c:forEach items="${topTpl}" var="each">
													<option value='${each.tplno}'>${each.tpltitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">좌측 템플릿 설정</th>
								<td class="Tleft">
									<div class="main_css_select">
									<p class="list_move_upDown">
											<a class="bt" href="javascript:void(0);" onclick="moveUp('tpl_t_dest')">순서 올리기</a><a class="next" href="javascript:void(0);" onclick="moveDown('tpl_t_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="tpl_l_source" multiple>
													<c:forEach items="${tList}" var="each">
													<c:if test="${each.tplposition=='2'}"><option value='${each.tplno}'>${each.tpltitle}</option></c:if>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0);" onclick="select('tpl_l_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												<br />
												<a href="javascript:void(0);" onclick="deselect('tpl_l_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="tpl_l_dest" multiple>
													<c:forEach items="${leftTpl}" var="each">
													<option value='${each.tplno}'>${each.tpltitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">우측 템플릿 설정</th>
								<td class="Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
											<a class="bt" href="javascript:void(0);" onclick="moveUp('tpl_t_dest')">순서 올리기</a><a class="next" href="javascript:void(0);" onclick="moveDown('tpl_t_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="tpl_r_source" multiple>
													<c:forEach items="${tList}" var="each">
													<c:if test="${each.tplposition=='3'}"><option value='${each.tplno}'>${each.tpltitle}</option></c:if>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0);" onclick="select('tpl_r_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												<br />
												<a href="javascript:void(0);" onclick="deselect('tpl_r_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="tpl_r_dest" multiple>
													<c:forEach items="${rightTpl}" var="each">
													<option value='${each.tplno}'>${each.tpltitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">하단 템플릿 설정</th>
								<td class="Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
											<a class="bt" href="javascript:void(0);" onclick="moveUp('tpl_t_dest')">순서 올리기</a><a class="next" href="javascript:void(0);" onclick="moveDown('tpl_t_dest')">순서 내리기</a>
										</p>
										<ul>
											<li>
												<select name="tpl_b_source" multiple>
													<c:forEach items="${tList}" var="each">
													<c:if test="${each.tplposition=='4'}"><option value='${each.tplno}'>${each.tpltitle}</option></c:if>
													</c:forEach>
												</select>
											</li>
											<li class="css_add_del">
												<a href="javascript:void(0);" onclick="select('tpl_b_source')"><img src="/cms/image/css_add.jpg" alt="추가" /></a>
												<br />
												<a href="javascript:void(0);" onclick="deselect('tpl_b_dest')"><img src="/cms/image/css_del.jpg" alt="삭제" /></a>
											</li>
											<li>
												<select name="tpl_b_dest" multiple>
													<c:forEach items="${bottomTpl}" var="each">
													<option value='${each.tplno}'>${each.tpltitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
						</table>
						<h4>내용 입력</h4>
						<table class="main_table1 bgneno" summary="상단내용, 본문내용, 하단내용">
							<caption>내용 입력</caption>
							<colgroup>
								<col width="150" />
								<col width="" />
							</colgroup>
							<tr>
								<th class="Tleft">상단내용</th>
								<td class="Tbod Tbod Tleft">
									<textarea class="bor1ddd" name="menutop" style="width:95%" rows="15" class="bor1ddd"><c:out value="${siteCfg.menutop}" escapeXml="true" /></textarea>
								</td>
							</tr>
							<!-- 나모웹에디터를 사용할 경우 -->
							<%-- <tr id="123" style="display:<c:if test="${act=='refer'}"><c:if test="${!siteCfg.menutype=='01'}">none</c:if></c:if>;">
								<th>본문내용</th>
								<td>


									<script type="text/javascript">
										var CrossEditor = new NamoSE('menuconts');
										CrossEditor.params.Width = "100%";
										CrossEditor.params.UserLang = "auto";
										CrossEditor.params.FullScreen = false;
										CrossEditor.EditorStart();
										function OnInitCompleted(e){
											e.editorTarget.SetBodyValue(document.getElementById("menuconts").value);
										}
									</script>
								</td>
							</tr> --%>
							<!-- 다음을 이용할 경우 -->
							<tr id="123" style="display:<c:if test="${act=='refer'}"><c:if test="${!siteCfg.menutype=='01'}">none</c:if></c:if>;">
								<th class="Tbornone Tleft">본문내용</th>
								<td class="Tleft">
									<input type=radio class="radio0" name="menucontstype" value="1" onclick="selArea(1)" <c:choose><c:when test="${act=='refer'}"><c:if test="${siteCfg.menucontstype=='1'}">checked</c:if></c:when><c:otherwise>checked</c:otherwise></c:choose> />
									HTML
									<input type=radio class="radio1" name="menucontstype" value="3" onclick="selArea(3)" <c:if test="${act=='refer' && siteCfg.menucontstype=='3'}">checked</c:if> />
									웹에디터&nbsp;
									<a class="btmore04" href="javascript:openwin('ztag','')"> 치환문구 </a>
									<div id="txtarea" style="display:<c:if test="${act=='refer'}"><c:if test='${siteCfg.menucontstype==3}'>none</c:if></c:if>">
										<textarea class="bor1ddd" name="menuconts" id="menuconts" style="width:95%" rows="30"><c:if test="${act=='refer'}"><c:out value="${siteCfg.menuconts}" escapeXml="true" /></c:if></textarea>
									</div>
									<div id="editorarea" style="width:96%;display:<c:choose><c:when test="${act=='refer'}"><c:if test='${siteCfg.menucontstype!=3}'>none</c:if></c:when><c:otherwise>none</c:otherwise></c:choose>">
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
										<textarea class="bor1ddd" name="ckeditorConts" id="ckeditorConts" style="width:95%" rows="30"><c:if test="${act=='refer'}"><c:out value="${siteCfg.menuconts}" escapeXml="true" /></c:if></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">하단내용</th>
								<td class="Tleft">
									<textarea class="bor1ddd" name="menubtm" style="width:95%" rows="15"><c:out value="${siteCfg.menubtm}" escapeXml="true" /></textarea>
								</td>
							</tr>
						</table>


						<!-- 현재는 아래메뉴 사용안함 사용시 주석 풀것 -->
						<p class="notification"><img src="/cms/image/excla.gif" alt="!">관련자료는 메뉴를 생성한 후 수정화면에서 등록가능합니다.</p>
						<h4>기타 메뉴 설정</h4>
						<table class="main_table1 bgneno" summary="기타기능 설정">
							<caption>기타기능 설정</caption>
							<colgroup>
								<col width="150px" />
								<col width="" />
							</colgroup>
							<tr>
								<th class="Tleft">담당자정보</th>
								<td class="Tbod Tbod Tleft">
									페이지 등록 후 수정화면에서 관리가 가능합니다.
									<%-- * 자동출력 : 아이디
									<input type="text" name="menustaffid" class="bor1ddd" value="${siteCfg.menustaffid}" />
									<br />
									* 수동출력 : 담당부서
									<input type="text" name="menustaffsect" class="bor1ddd" size="10" value="${siteCfg.menustaffsect}" />
									이름
									<input type="text" name="menustaffname" class="bor1ddd" size="10" value="${siteCfg.menustaffname}" />
									이메일
									<input type="text" name="menustaffemail" class="bor1ddd" value="${siteCfg.menustaffemail}" />
									전화번호
									<input type="text" name="menustafftel" class="bor1ddd" size="15" value="${siteCfg.menustafftel}" />
									팩스
									<input type="text" name="menustafffax" class="bor1ddd" size="15" value="${siteCfg.menustafffax}" /> --%>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">평가</th>
								<td class="Tleft">
									페이지 등록 후 수정화면에서 관리가 가능합니다.<input type=checkbox style="vertical-align: middle;" disabled />
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">Location적용</th>
								<td class="Tleft">
									페이지 등록 후 수정화면에서 관리가 가능합니다. Default는 적용입니다.<input type=checkbox style="vertical-align: middle;" disabled />
								</td>
							</tr>
						</table>
							<div class="btn-c">

									<%-- <input type="image" src="/cms/image/btn_common_preview.jpg" alt="미리보기" onclick="previewContent('${sitedomain}')" /> --%>

									<!-- 다음에디터 사용시 -->
									<a class="btmore05" href="javascript:void(0);" onclick="call_preview();">미리보기</a>
									<input class="chost_btn_s" type="submit" value="확인" onclick="if(!window.confirm('저장하시겠습니까?')){return false;}" />
									<!-- 나모에디터사용시 -->
									<!-- <input type="image" src="/cms/image/btn_confirm.jpg" alt="확인" onclick="document.getElementById('menuconts').value=CrossEditor.GetBodyValue('XHTML')"/> -->
									<a class="btmore05" href="/admsys/site/menu/list.html?siteno=${siteno}">목록</a>
									<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/menu/list.html?siteno=${siteno}&opens=${input.opens}'">취소</a>
							</div><!--/confirm-->
					</div><!--/main_table-->
					</li>
					</ul>
				</div><!--/content-->
			</form:form>
<jsp:include page="../../end.jsp" flush="false" />

<script type="text/javascript">
window.onload = function(){
	document.getElementsByName("sub_css_source")[0].size = document.getElementsByName("sub_css_dest")[0].size = document.getElementsByName("sub_css_source")[0].options.length;
	document.getElementsByName("sub_js_source")[0].size = document.getElementsByName("sub_js_dest")[0].size = document.getElementsByName("sub_js_source")[0].options.length;
	document.getElementsByName("tpl_t_source")[0].size = document.getElementsByName("tpl_t_dest")[0].size = document.getElementsByName("tpl_t_source")[0].options.length;
	document.getElementsByName("tpl_l_source")[0].size = document.getElementsByName("tpl_l_dest")[0].size = document.getElementsByName("tpl_l_source")[0].options.length;
	document.getElementsByName("tpl_r_source")[0].size = document.getElementsByName("tpl_r_dest")[0].size = document.getElementsByName("tpl_r_source")[0].options.length;
	document.getElementsByName("tpl_b_source")[0].size = document.getElementsByName("tpl_b_dest")[0].size = document.getElementsByName("tpl_b_source")[0].options.length;
}
$(document).ready(function(){
    var currentPosition = parseInt($(".float").css("top"));
    $(window).scroll(function() {
        var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
        if(position>100){
       		$(".float").css({'position':'fixed', 'top':'20px','right':'20px','background-color':'#333333'});
        }else{
        	$('.float').attr('style','');
        }
    });
});
</script>
<div class="float"><a href="/admsys/site/menu/list.html?siteno=${siteno}&opens=${input.opens}" style="color: white">리스트로 이동</a></div>
