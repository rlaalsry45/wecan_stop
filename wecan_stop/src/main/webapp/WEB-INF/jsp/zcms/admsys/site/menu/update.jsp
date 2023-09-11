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

function delArchvRltd(obj,rltd_no){
	if(confirm('삭제하시겠습니까?')){
		//alert(obj+":"+rltd_no);
		$.ajax({
			type: 'post'
			, async: true
			, url: '/admsys/archv/data/delRltd.html'
			, data: "rltd_no="+rltd_no
			, success: function(data) {
				obj.parentNode.innerHTML ='';
			}
			, error: function(data, status, err) {
				alert('서버와의 통신이 실패했습니다.');
			}
		});
	}
}

function add_archv_no(archv_no){
	$.ajax({
		type: 'post'
		, async: true
		, url: '/admsys/archv/data/getArchvTitleAndPath.html'
		, data: "archv_no="+archv_no
		, dataType     : 'json'
		, success: function(data) {
			//console.log(data);
			$("#archv_no").val(archv_no);
			$("#archv_title").val(data.archv_title);
			$("#menuarchivenamepath").val(data.menuarchivenamepath);
			//self.close();
		}
		, error: function(data, status, err) {
			alert('서버와의 통신이 실패했습니다.');
		}
	});
}

function addArchvRltdList(archv_no_list){
	//alert(archv_no_list);
	//alert("archv_no_list="+archv_no_list+"&siteno="+$("#siteno").val()+"&menuno="+$("#menuno").val());
	$.ajax({
		type: 'post'
		, async: true
		, url: '/admsys/archv/data/addRltdInMenuno.html'
		, data: "archv_no_list="+archv_no_list+"&siteno="+$("#siteno").val()+"&menuno="+$("#menuno").val()
		, dataType     : 'json'
		, success: function(data) {
			//console.log(data.body);
			if(data.body == "nochange"){
				alert("이미 관련자료로 등록이 되어 있습니다.");
			}else{
				/* document.all("rltd_view").innerHTML="";
				document.all("rltd_view").innerHTML=data.body; */
				//alert($("#rltd_view").html());
				$("#rltd_view").html(data.body);
				alert("추가되었습니다.");
			}

		}
		, error: function(data, status, err) {
			alert('서버와의 통신이 실패했습니다.');
		}
	});

}


function get_menustaff_info(){
	var url		= '/admsys/menustaff/get_menustaff_info.html';
	var width	= 1024;
	var height	= 768;
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
		document.frm.action='/admsys/site/menu/menuPreview.html'; // 팝업창 윈도우 이름
		document.frm.submit();

		document.frm.target= '';
		document.frm.action='/admsys/site/menu/update.html';

	}


}

</script>

	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div id="contents">
				<div class="contents_top">
					<div class="location">
						<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/site/menu/index.html">메뉴/컨텐츠관리</a> <strong>${menulevel>0 ? "하" : "최상" }위 메뉴수정</strong>
					</div>
				</div>
			<form:form modelAttribute="zmenuVo" action="/admsys/site/menu/update.html" method="post" name="frm" id="frm" onsubmit="return checkForm()">
				<input type="hidden" name="act"  value="update" />
				<input type="hidden" name="siteno" id="siteno" value="${siteno}" />
				<input type="hidden" name="menuno" id="menuno" value="${menuno}" />
				<input name="menusubcss" type="hidden" value="" />
				<input name="menusubjs" type="hidden" value="" />
				<input name="menuttpl" type="hidden" value="" />
				<input name="menultpl" type="hidden" value="" />
				<input name="menurtpl" type="hidden" value="" />
				<input name="menubtpl" type="hidden" value="" />
				<input name="menusubno" type="hidden" value="${detail.menusubno}" />
				<input name="menuno_r" type="hidden" value="" />
				<input type="hidden" name="selectId"  value="${input.selectId }" />
				<input type="hidden" name="opens" value="${input.opens}" />
				<div id="content">
				<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">${menulevel>0 ? "하" : "최상" }위 메뉴수정 [ <c:out value="${sitetitle}" escapeXml="false" /> ]<!--현재 메뉴가 어떤 사이트의 메뉴관리인지 표--></h3></li>
						<li>
					<div class="main_table">
						<!---게시판 영역------------------------->
						<a name="menuupdate"></a>
						<h4>메뉴수정</h4>
						<table class="main_table1 bgneno" summary="메뉴수정">
						<caption>메뉴수정</caption>
							<colgroup>
								<col width="150" />
								<col width="" />
							</colgroup>
							<tr>
								<th class="Tleft">Depth</th>
								<td class="Tbod Tbod Tleft">
									<c:set var="added" value="&nbsp;&gt;&nbsp;" />
									<c:forEach items="${depth}" var="each" varStatus="loop">
										<c:if test="${loop.last==true}"><c:set var="added" value="" /></c:if>
										<c:out value="<img class='align' src='/cms/image/bul_menu_level_${loop.count}.jpg' alt='${loop.count}차 메뉴' />&nbsp; ${each.menutitle}${added}" escapeXml="false" />
									</c:forEach>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">링크주소</th>
								<td class="Tleft">
									<%-- superbolt <c:url value="http://${sitedomain}${port}/" var="url">--%>
									<c:url value="http://${sitedomain}/" var="url">
										<c:param name="menuno" value="${menuno}" />
									</c:url>
									<a href="${url}" target="_blank">
										<c:out value="${url}" escapeXml="false" />
									</a>

								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">메뉴명</th>
								<td class="Tleft">
									<input type="text" name="menutitle" class="bor1ddd" size="75" value="${detail.menutitle}" />
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">상태</th>
								<td class="Tleft">
									<input type="radio" class="radio0" name="menustatus" value="1" <c:if test="${detail.menustatus=='1'}">checked</c:if> />
									사용
									<input type="radio" class="radio1" name="menustatus" value="2" <c:if test="${detail.menustatus=='2'}">checked</c:if> />
									중지
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">화면참조
								<a class="imgSelect" title="콘텐츠 종류에 대한 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>화면참조</strong></br>
									페이지 등록 시 <em>이전에 등록한 페이지를 참조</em>하여 등록하실 수 있습니다. 참조화면을 선택하시면 이전에 등록된 페이지가 자동으로 등록됩니다.<br />
									</div>
								</th>
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
										reftree.openTo(${detail.menuno_r},true);
										</c:if>

										//-->
									</script>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">콘텐츠 종류
									<a class="imgSelect" title="콘텐츠 종류에 대한 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>직접작성</strong></br>
									코딩이 완료된 페이지를 직접 입력합니다.<br />
									<strong>하위메뉴지정</strong></br>
									하위메뉴를 지정하는 경우 해당 페이지 링크 시 지정된 하위 메뉴로 바로 이동합니다.<br />
									<strong>외부링크</strong></br>
									외부 페이지를 호출합니다.<br />
									<strong>내부링크</strong></br>
									내부 페이지를 호출합니다.<br />
									<strong>아카이브</strong></br>
									아카이브에 미리 등록된 자료 중 원하는 자료를 불러올 수 있습니다.
									</div></th>
								<td class="Tleft">
									<input type="radio" class="radio0" name="menutype" value="01" onclick="displayRow('01','site');" <c:if test="${detail.menutype=='01'||detail.menutype=='03'}">checked</c:if> />
									직접작성
									<input type="radio" class="radio0" name="menutype" value="02" onclick="displayRow('02','site');" <c:if test="${detail.menutype=='02'}">checked</c:if> />
									하위메뉴지정
									<input type="radio" class="radio1" name="menutype" value="04" onclick="displayRow('04','site');" <c:if test="${detail.menutype=='04'}">checked</c:if> />
									외부링크
									<input type="radio" class="radio1" name="menutype" value="05" onclick="displayRow('05','site');" <c:if test="${detail.menutype=='05'}">checked</c:if> />
									내부링크
									<input type="radio" class="radio1" name="menutype" value="06" onclick="displayRow('06','site');" <c:if test="${detail.menutype=='06'}">checked</c:if> />
									아카이브
								</td>
							</tr>
							<tr id="02" style="display:<c:if test="${detail.menutype!='02'}">none</c:if>;">
								<th class="Tbornone Tleft">하위메뉴지정</th>
								<td class="Tleft">
									<script type="text/javascript">
										<!--

										subtree = new dTree('subtree');

										subtree.config.inOrder = true;
										subtree.config.useCookies = false;
										subtree.config.useSelection = true;

										subtree.add(0,-1,'${sitetitle}');

										<c:forEach items="${list}" var="each">
										subtree.add(${each.menuno},${each.menuparentno},"${each.menutitle}","javascript:void(frm.menusubno.value='${each.menuno}');");
										</c:forEach>

										document.write(subtree);

										<c:if test='${detail.menusubno>0}'>
										subtree.openTo(${detail.menusubno},true);
										</c:if>

										//-->
									</script>

								</td>
							</tr>
							<tr id="04" style="display:<c:if test="${detail.menutype!='04'}">none</c:if>;">
								<th class="Tbornone Tleft">외부링크지정</th>
								<td class="Tleft">
									http://<input style="width:300px;" type="text" name="menulink" class="bor1ddd" value="${detail.menulink}" />
									<br />
									타겟
									<select name="menulinktarget">
										<option value="1" <c:if test="${detail.menulinktarget=='1'}">selected</c:if>>선택안함</option>
										<option value="2" <c:if test="${detail.menulinktarget=='2'}">selected</c:if>>SELF</option>
										<option value="3" <c:if test="${detail.menulinktarget=='3'}">selected</c:if>>NEW</option>
										<option value="4" <c:if test="${detail.menulinktarget=='4'}">selected</c:if>>PARENT</option>
										<option value="5" <c:if test="${detail.menulinktarget=='5'}">selected</c:if>>기타</option>
									</select>
									기타값
									<input type="text" name="menulinkother" class="bor1ddd" value="${detail.menulinkother}" />
								</td>
							</tr>
							<tr id="05" style="display:<c:if test="${detail.menutype!='05'}">none</c:if>;">
								<th class="Tbornone Tleft">내부링크지정</th>
								<td class="Tleft">
									서버이름 / <input type="text" name="menuintenallink" size="100" class="bor1ddd" value="${detail.menuintenallink}" />
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
									<input type="text" name="menuintenallinkother" class="bor1ddd" value="${detail.menuintenallinkother}" />
								</td>
							</tr>
							<tr id="06" style="display:<c:if test="${detail.menutype!='06'}">none</c:if>;">
								<th class="Tbornone Tleft">아카이브 지정</th>
								<td class="Tleft">
									<input type="hidden" id="archv_no" name="archv_no" value="${detail.archv_no}">
									<input type="text" id="archv_title" name="archv_title" value="${detail.archv_title}"class="bor1ddd" size="100" value="" readonly />
									<a class="btmore04" href="javascript:void(0)" onclick="call_archv_popup('add_archv_no','n',null)">
										아카이브 선택
									</a>
									<br />
									<input type="text" id="menuarchivenamepath" name="menuarchivenamepath" value="${detail.menuarchivenamepath}"class="bor1ddd" size="75" value="" readonly />
								</td>
							</tr>
						</table>


						<!-- 본문내용입력 단 -->
						<a name="bodyupdate"></a>
						<h4>내용 입력</h4>
						<p class="notification"><img src="/cms/image/excla.gif" alt="!"> 모든 이미지 및 플래시 등 요소의 경로는 root 디렉토리('/')로부터 절대경로로 지정해야합니다.</p>
						<table class="main_table1 bgneno" summary="내용입력">
							<caption>내용 입력</caption>
							<colgroup>
								<col width="150px" />
								<col />
							</colgroup>
							<tr>
								<th class="Tleft">상단내용
								<a class="imgSelect" title="상단내용에 대한 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>상단내용</strong></br>
									분문내용 상단에 적용할 수 있는 여분 필드입니다.(ex:배너, 타이틀, 네비게이션바 등 다양하게 들어갈 수 있습니다.)<br />
									본문영역과 동일한 영역으로 간주하셔도 됩니다.
									</div>
								</th>
								<td class="Tbod Tbod Tleft">
									<textarea class="bor1ddd" name="menutop" style="width:95%" rows="15" class="bor1ddd"><c:out value="${detail.menutop}" escapeXml="true" /></textarea>
								</td>
							</tr>
							<!-- 나모웹에디터를 사용할 경우 -->
							<%-- <tr id="123" style="display:<c:if test="${(detail.menutype=='01'||detail.menutype=='03')==false}">none</c:if>">
								<th class="Tbornone Tleft">본문내용</th>
								<td>
									<textarea id="menuconts" name="menuconts" Style="width:730px;height:450px;font-size:10pt"><c:out value="${detail.menuconts}" escapeXml="true" /></textarea>
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

							<!-- 다음웹에디터를 사용할 경우 -->
							<tr id="123" style="display:<c:if test="${(detail.menutype=='01'||detail.menutype=='03')==false}">none</c:if>">
								<th class="Tbornone Tleft">본문내용
								<a class="imgSelect" title="본문내용에 대한 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>본문내용</strong></br>
									대부분의 내용은 이곳에 적용합니다. 상단내용 및 하단내용은 비워두셔도 됩니다.
									</div>

								</th>
								<td class="Tleft">
									<input type=radio class="radio0" name="menucontstype" value="1" onclick="selArea(1)" <c:if test="${detail.menucontstype=='1'}">checked</c:if> />
									HTML
									<input type=radio class="radio1" name="menucontstype" value="3" onclick="selArea(3)" <c:if test="${detail.menucontstype=='3'}">checked</c:if> />
									웹에디터&nbsp;
									<a class="btmore04" href="javascript:openwin('ztag','')">치환문구</a>
									<a class="imgSelect" title="치환문구 대한 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>치환문구</strong></br>
									게시판, 이벤트, 설문, 배너 등 미리 생성된 치환문구를 불러옵니다.<br />
									새창에서 미리 생성해둔 치환문구에 "복사"를 클릭 후 Ctrl+C(복사)를 한 후 페이지 내에 적당한 위치에 삽입합니다.
									</div>

									<div id="txtarea" style="display:<c:if test='${detail.menucontstype==3}'>none</c:if>">
										<textarea class="bor1ddd" name="menuconts" id="menuconts" style="width:95%" rows="50"><c:out value="${detail.menuconts}" escapeXml="true" /></textarea>
									</div>

									<div id="editorarea" style="width:96%;display:<c:if test='${detail.menucontstype!=3}'>none</c:if>">
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
										<textarea class="bor1ddd" name="ckeditorConts" id="ckeditorConts" style="width:95%" rows="30"><c:out value="${detail.menuconts}" escapeXml="true" /></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">하단내용
								<a class="imgSelect" title="하단내용에 대한 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>하단내용</strong></br>
									분문내용 하단에 적용할 수 있는 여분 필드입니다.(ex:배너, 타이틀, 네비게이션바 등 다양하게 들어갈 수 있습니다.)<br />
									본문영역과 동일한 영역으로 간주하셔도 됩니다.
									</div>

								</th>
								<td class="Tleft">
									<textarea class="bor1ddd" name="menubtm" style="width:95%" rows="15"><c:out value="${detail.menubtm}" escapeXml="true" /></textarea>
								</td>
							</tr>
						</table>
						<!----버튼영역------------------------------->
									<div class="btn-c">

											<%-- <input type="image" src="/cms/image/btn_common_preview.jpg" alt="미리보기" onclick="previewContent('${sitedomain}')" /> --%>

											<!-- textarea사용시 -->
											<!-- <input type="image" src="/cms/image/btn_confirm.jpg" alt="확인" onclick="if(window.confirm('저장하시겠습니까?')){document.getElementById('menuconts').value=CrossEditor.GetBodyValue('XHTML');} else{return false;}" /> -->

											<!-- 다음웹에디터사용시 -->
											<!-- <img src="/cms/image/btn_confirm.jpg" alt="확인" onclick="if(window.confirm('저장하시겠습니까?')){$('#menuconts').val( Editor.getContent() );$('#frm').submit();} else{return false;}" /> -->

											<a class="btmore05" href="javascript:void(0);" onclick="call_preview();">미리보기</a>
											<input class="chost_btn_s" type="submit" value="확인" onclick="if(!window.confirm('저장하시겠습니까?')){return false;} " />
											<!-- 나모웹에디터사용시 -->
											<!-- <input type="image" src="/cms/image/btn_confirm.jpg" alt="확인" onclick="if(window.confirm('저장하시겠습니까?')){document.getElementById('menuconts').value=CrossEditor.GetBodyValue('XHTML');} else{return false;}" /> -->
											<a class="btmore05" href="/admsys/site/menu/list.html?siteno=${siteno}&selectId=${input.selectId }&opens=${input.opens}">목록</a>
											<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/menu/list.html?siteno=${siteno}'">취소</a>


									</div><!--/confirm-->


						<a name="cssjsupdate"></a>
						<h4>CSS/ JS 선택 </h4>
				 		<input type=checkbox class="checkbox1" name="apply1" value="1" onclick="if(this.checked) alert('현재 메뉴의 하위에 있는 모든 페이지에 지금 적용한 CSS 및 JS가 일괄적용됩니다.');" /> 하위메뉴 일괄적용<p class="notification_r"><img src="/cms/image/excla.gif" alt="!">'하위메뉴 일괄적용' 체크 시 현재 메뉴의 하위에 있는 모든 페이지에 지금 적용한 CSS 및 JS가 일괄적용됩니다.</p>
						<table class="main_table1 bgneno" summary="css/js">
							<caption>CSS/JS 설정</caption>
							<colgroup>
								<col width="150px" />
								<col />
							</colgroup>
							<tr>
								<th class="Tleft">서브페이지 CSS선택
								<a class="imgSelect" title="CSS/ JS 선택 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>CSS/ JS 선택</strong></br>
								해당 페이지 작업 시 사용한 CSS 와 JS 파일을 추가 및 제거할 수 있습니다. <em>CSS/ JS 등록은 CSS 관리 및 JS 관리</em>에서 등록하시면 자동으로 이곳에 노출됩니다.
								</div>
								</th>
								<td class="Tbod Tbod Tleft">
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
													<c:forEach items="${menusubcss}" var="each">
													<option value='${each.cssno}'>${each.csstitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">서브페이지 js선택
								<a class="imgSelect" title="CSS/ JS 선택 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>CSS/ JS 선택</strong></br>
								해당 페이지 작업 시 사용한 CSS 와 JS 파일을 추가 및 제거할 수 있습니다. <em>CSS/ JS 등록은 CSS 관리 및 JS 관리</em>에서 등록하시면 자동으로 이곳에 노출됩니다.
								</div>
								</th>
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
													<c:forEach items="${menusubjs}" var="each">
													<option value='${each.jsno}'>${each.jstitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
						</table>

						<a name="templateupdate"></a>
						<h4>서브페이지 템플릿 설정</h4>
				 		<input type=checkbox class="checkbox1" name="apply2" value="2" onclick="if(this.checked) alert('현재 메뉴의 하위에 있는 모든 페이지에 지금 적용한 템플릿이 일괄적용됩니다.');" /> 하위메뉴 일괄적용<p class="notification_r"><img src="/cms/image/excla.gif" alt="!">'하위메뉴 일괄적용' 체크 시 현재 메뉴의 하위에 있는 모든 페이지에 지금 적용한 템플릿이 일괄적용됩니다.</p>
						<table class="main_table1 bgneno" summary="템플릿 설정">
							<caption>템플릿 설정</caption>
							<colgroup>
								<col width="150px" />
								<col/>
							</colgroup>
							<tr>
								<th class="Tleft">상단 템플릿 설정
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
													<c:forEach items="${menuttpl}" var="each">
													<option value='${each.tplno}'>${each.tpltitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">좌측 템플릿 설정
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
											<a class="bt" href="javascript:void(0);" onclick="moveUp('tpl_l_dest')">순서 올리기</a><a class="next" href="javascript:void(0);" onclick="moveDown('tpl_l_dest')">순서 내리기</a>
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
													<c:forEach items="${menultpl}" var="each">
													<option value='${each.tplno}'>${each.tpltitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">우측 템플릿 설정
								<a class="imgSelect" title="우측 템플릿 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>우측 템플릿</strong></br>
								공통으로 사용되는 페이지를 호출합니다.(ex:우측 내비게이션,RNB 등)<br />
								※ 오른쪽 위치 이동을 통해 출력 순위를 정할 수 있습니다.
								</div>
								</th>
								<td class="Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
											<a class="bt" href="javascript:void(0);" onclick="moveUp('tpl_r_dest')">순서 올리기</a><a class="next" href="javascript:void(0);" onclick="moveDown('tpl_r_dest')">순서 내리기</a>
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
													<c:forEach items="${menurtpl}" var="each">
													<option value='${each.tplno}'>${each.tpltitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">하단 템플릿 설정
								<a class="imgSelect" title="하단 템플릿 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>하단 템플릿</strong></br>
								공통으로 사용되는 페이지를 호출합니다.(ex:하단 저작권 및 주소,footer 등)<br />
								※ 오른쪽 위치 이동을 통해 출력 순위를 정할 수 있습니다.
								</div>
								</th>
								<td class="Tleft">
									<div class="main_css_select">
										<p class="list_move_upDown">
											<a class="bt" href="javascript:void(0);" onclick="moveUp('tpl_b_dest')">순서 올리기</a><a class="next" href="javascript:void(0);" onclick="moveDown('tpl_b_dest')">순서 내리기</a>
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
													<c:forEach items="${menubtpl}" var="each">
													<option value='${each.tplno}'>${each.tpltitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
						</table>




						<!-- 아카이브 페이지 사용시에만 아래 내용을 사용 -->

						<%-- <h4>아카이브 관련링크</h4>
						<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="자료등록">
							<caption>메뉴수정</caption>
							<colgroup>
								<col width="10%" />
								<col />
								<col width="5%" />
							</colgroup>
							<tr>
								<th class="Tbornone Tleft">관련자료 사용 여부</th>
								<td >
									<input type="radio" class="radio0" name="rltd_shw_yn" value="1" <c:if test="${detail.rltd_shw_yn=='1'}">checked</c:if> />
									사용
									<input type="radio" class="radio1" name="rltd_shw_yn" value="0" <c:if test="${detail.rltd_shw_yn!='1'}">checked</c:if> />
									중지
								</td>
								<td class="menu_depth">
									<a href="javascript:void(0)" onclick="call_archv_popup('add_archv_no_list','y',null)"><img src="/cms/image/common_btn_additional.jpg"></a>
								</td>
							</tr>
						</table>

						<div id="rltd_view">
							<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="자료등록">
							<caption>아카이브수정</caption>
							<colgroup>
								<col width="10%" />
								<col />
								<col width="5%" />
							</colgroup>
								<tr>
									<th scope="row">관련자료</th>
									<td class="menu_depth" colspan="2">
										<c:forEach items="${rltdEvent}" var="data">
											<div>
												<strong>＊${data.title }</strong> <img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delArchvRltd(this,${data.rltd_no})" /><br />
												[${data.catgry_name_list }]<br />
											</div>
										</c:forEach>
									</td>
									<!-- <td class="menu_depth"><img src="/cms/image/common_btn_additional.jpg"></td> -->
								</tr>
								<tr>
									<th scope="row">관련문서</th>
									<td class="menu_depth" colspan="2">
										<c:forEach items="${rltdDocument}" var="data">
											<div>
												<strong>＊${data.title }</strong> <img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delArchvRltd(this,${data.rltd_no})" /><br />
												[${data.catgry_name_list }]<br />
											</div>
										</c:forEach>
									</td>
									<!-- <td class="menu_depth"><img src="/cms/image/common_btn_additional.jpg"></td> -->
								</tr>
								<tr>
									<th scope="row">관련사진</th>
									<td class="menu_depth" colspan="2">
										<c:forEach items="${rltdPhoto}" var="data">
											<div>
												<strong>＊${data.title }</strong> <img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delArchvRltd(this,${data.rltd_no})" /><br />
												[${data.catgry_name_list }]<br />
											</div>
										</c:forEach>
									</td>
									<!-- <td class="menu_depth"><img src="/cms/image/common_btn_additional.jpg"></td> -->
								</tr>
								<tr>
									<th scope="row">관련동영상</th>
									<td class="menu_depth" colspan="2">
										<c:forEach items="${rltdVod}" var="data">
											<div>
												<strong>＊${data.title }</strong> <img style="border:0px;width:10px" src='/cms/image/delet.gif' alt='삭제' onclick="delArchvRltd(this,${data.rltd_no})" /><br />
												[${data.catgry_name_list }]<br />
											</div>
										</c:forEach>
									</td>
									<!-- <td class="menu_depth"><img src="/cms/image/common_btn_additional.jpg"></td> -->
								</tr>
							</table>
						</div>--%>


						<h4>기타 메뉴 설정</h4>
						<table class="main_table1 bgneno" summary="기카기능설정">
							<caption>기타기능 설정</caption>
							<colgroup>
								<col width="150px" />
								<col width="" />
							</colgroup>
							<tr>
								<th class="Tleft" rowspan="2">담당자정보</th>
								<td class="Tbod Tleft">
									* 자동출력 : 아이디
									<input type="text" name="menustaffid" class="bor1ddd" value="${detail.menustaffid}" />
									사용<input type="checkbox" name="menustaff_use_yn"  style="vertical-align: middle;" value="1" <c:if test="${detail.menustaff_use_yn=='1'}">checked</c:if>/>
								</td>
							</tr>
							<tr>
								<td class="Tleft">
									* 수동출력 : 담당부서
									<input type="text" name="menustaffsect" class="bor1ddd" size="10" value="${detail.menustaffsect}" />
									이름
									<input type="text" id="menustaffname" name="menustaffname" class="bor1ddd" size="10" value="${detail.menustaffname}" />
									이메일
									<input type="text" name="menustaffemail" class="bor1ddd" value="${detail.menustaffemail}" />
									전화번호
									<input type="text" id="menustafftel" name="menustafftel" class="bor1ddd" size="20" value="${detail.menustafftel}" />
									팩스
									<input type="text" id="menustafffax" name="menustafffax" class="bor1ddd" size="20" value="${detail.menustafffax}" />
									<a class="btmore09" href="javascript:void(0)" onclick="get_menustaff_info();">+ 담당자 선택</a>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">만족도 사용</th>
								<td class="Tleft">
									<span>사용</span>
									<input class="checkbox2" type="checkbox" name="menuscore" value="1" <c:if test="${detail.menuscore=='1'}">checked</c:if> />
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">SNS링크걸기</th>
								<td class="Tleft">
									<span>사용</span>
									<input class="checkbox2"  type="checkbox" name="menusns_use_yn" value="1" <c:if test="${detail.menusns_use_yn=='1'}">checked</c:if> />
									<p class="notification_right"><img src="/cms/image/excla.gif" alt="!"> 일반페이지 전용입니다. 게시판, 행사, 아카이브는 사용하면 안됩니다.</p>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">Location적용</th>
								<td class="Tleft">
									<span>사용</span>
									<input class="checkbox2"  type="checkbox" name="location_use_yn" value="1" <c:if test="${detail.location_use_yn=='1'}">checked</c:if> />
									<p class="notification_right"><img src="/cms/image/excla.gif" alt="!"> 기본은 사용으로 되어 있습니다. 메인화면등 Location이 필요없을 경우 해제해주시기 바랍니다.</p>
								</td>
							</tr>
						</table>

						<!----버튼영역------------------------------->

								<div class="btn-c">

											<%-- <input type="image" src="/cms/image/btn_common_preview.jpg" alt="미리보기" onclick="previewContent('${sitedomain}')" /> --%>

											<!-- textarea사용시 -->
											<!-- <input type="image" src="/cms/image/btn_confirm.jpg" alt="확인" onclick="if(window.confirm('저장하시겠습니까?')){document.getElementById('menuconts').value=CrossEditor.GetBodyValue('XHTML');} else{return false;}" /> -->

											<!-- 다음웹에디터사용시 -->
											<!-- <img src="/cms/image/btn_confirm.jpg" alt="확인" onclick="if(window.confirm('저장하시겠습니까?')){$('#menuconts').val( Editor.getContent() );$('#frm').submit();} else{return false;}" /> -->
											<a class="btmore05" href="javascript:void(0);" onclick="call_preview();">미리보기</a>
											<input class="chost_btn_s" type="submit" value="확인" onclick="if(!window.confirm('저장하시겠습니까?')){return false;} " />

											<!-- 나모웹에디터사용시 -->
											<!-- <input type="image" src="/cms/image/btn_confirm.jpg" alt="확인" onclick="if(window.confirm('저장하시겠습니까?')){document.getElementById('menuconts').value=CrossEditor.GetBodyValue('XHTML');} else{return false;}" /> -->
											<a class="btmore05" href="/admsys/site/menu/list.html?siteno=${siteno}&selectId=${input.selectId }&opens=${input.opens}">목록</a>
											<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/menu/list.html?siteno=${siteno}'">취소</a>
									</div><!--/confirm-->


						<a name="historyupdate"></a>
						<h4>히스토리</h4>
						<div class="top_bt">
							<a class="btmore07" href="javascript:checkAll(true,'menuhisno');">전체선택</a>
							<a class="btmore07" href="javascript:checkAll(false,'menuhisno');">전체해제</a>
							<a class="btmore05" href="javascript:if(confirm('정말 삭제하시겠습니까?')){if (checkForm('menuhisno')){document.frm.action='deleteHis.html'; document.frm.submit();}}">삭제</a>
							<input class="checkbox1" type=checkbox name="menuhis" value="1" <c:if test="${detail.menuhis=='1'}">checked</c:if> />히스토리사용
							<a class="imgSelect" title="히스토리사용 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>히스토리사용</strong></br>
								히스토리 사용을 체크하시면 작성한 내용이 쌓이게 되며, 이전에 작성한 내용으로 복귀할 수 있습니다.
								</div>
						</div>
						<table class="main_table1 bgneno" summary="번호, 메뉴명, 아이디, 등록일, 곤텐츠 사용">
						<caption>기타기능 설정</caption>
						<colgroup>
							<col width="5px" />
							<col width="40px" />
							<col />
							<col width="150px" />
							<col width="150px" />
							<col width="180px" />
						</colgroup>
						<thead>
							<tr>
								<th>
                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','menuhisno')" />
                                </th>
								<th>번호</th>
								<th>메뉴명</th>
								<th>아이디</th>
								<th>등록일</th>
								<th>콘텐츠사용</th>
							</tr>
						</thead>
						<tbody class="td_center">
							<c:forEach items="${hislist}" var="each" varStatus="loop">
								<tr>
									<td>
                                       <input class="bor_none" name="menuhisno" value='${each.menuhisno}' type="checkbox" />
                                    </td>
									<td>
										<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
									</td>
									<td>
										<c:out value='${each.menuhistitle}' />
									</td>
									<td>
										<c:out value='${each.userid}' />
									</td>
									<td>
										<fmt:parseDate value="${each.menuhisdate}" pattern="yyyyMMddHHmmss" var="isoDate" />
										<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>
										<c:url value="" var="url">
											<c:param name="menuhisno" value="${each.menuhisno}" />
											<c:param name="menuno" value="${menuno}" />
											<c:param name="siteno" value="${each.siteno}" />
											<c:param name="selectId" value="${input.selectId}" />
											<c:param name="opens" value="${input.opens}" />
											<c:param name="mode" value="" />
										</c:url>
										<%-- <a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('정말 삭제하시겠습니까?')) this.href='${url}delete'">삭제</a> --%>
										<a class="btmore04" href="javascript:void(0);" onclick="if(window.confirm('현재 입력한 내용이 삭제되며 복구 불가합니다.\r\n그래도 진행 하시겠습니까?')) this.href='${url}restore'">콘텐츠사용</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form:form>
					<form:form modelAttribute="zmenuVo" method="post" name="frmHis" id="frmHis">
						<input type="hidden" name="siteno" value="${siteno}" />
						<input type="hidden" name="menuno" value="${menuno}" />
						<input type="hidden" name="selectId"  value="${input.selectId }" />
						<input type="hidden" name="opens" value="${input.opens}" />
						<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' formName="frmHis"/>
					</form:form>
					</div><!--/main_table-->
					</li>
				</ul>
				</div><!--/content-->

			</div><!--/contents-->
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->

<script type="text/javascript">
window.onload = function(){
	document.getElementsByName("sub_css_source")[0].size = document.getElementsByName("sub_css_dest")[0].size = document.getElementsByName("sub_css_source")[0].options.length;
	document.getElementsByName("sub_js_source")[0].size = document.getElementsByName("sub_js_dest")[0].size = document.getElementsByName("sub_js_source")[0].options.length;
	document.getElementsByName("tpl_t_source")[0].size = document.getElementsByName("tpl_t_dest")[0].size = document.getElementsByName("tpl_t_source")[0].options.length;
	document.getElementsByName("tpl_l_source")[0].size = document.getElementsByName("tpl_l_dest")[0].size = document.getElementsByName("tpl_l_source")[0].options.length;
	document.getElementsByName("tpl_r_source")[0].size = document.getElementsByName("tpl_r_dest")[0].size = document.getElementsByName("tpl_r_source")[0].options.length;
	document.getElementsByName("tpl_b_source")[0].size = document.getElementsByName("tpl_b_dest")[0].size = document.getElementsByName("tpl_b_source")[0].options.length;
	 if("true"=="${param.insertsuccess}"){
		alert("저장되었습니다.");
	 }
	 if("true"=="${param.updatesuccess}"){
		alert("수정되었습니다.");
	 }
	 if("true"=="${param.deletesuccess}"){
		alert("삭제되었습니다.");
		location.href="#historyupdate";
	 }
}

$(document).ready(function(){
    var currentPosition = parseInt($(".float").css("top"));
    $(window).scroll(function() {
        var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
        if(position>50){
       		$(".float").css({'padding':'10px','color':'#ffffff','position':'fixed', 'top':'20px','right':'20px','background-color':'#333333'});
        }else{
        	$('.float').attr('style','');
        }
    });
});
</script>
<div class="float">
	<a href="/admsys/site/menu/list.html?siteno=${siteno}&selectId=${input.selectId }&opens=${input.opens}" style="color: white">리스트로 이동</a><br />
	<a href="#menuupdate" style="color: white">메뉴수정 이동</a><br />
	<a href="#bodyupdate" style="color: white">본문수정 이동</a><br />
	<a href="#cssjsupdate" style="color: white">css/js 이동</a><br />
	<a href="#templateupdate" style="color: white">템플릿 이동</a><br />
	<a href="#historyupdate" style="color: white">히스토리 이동</a><br />
</div>
</body>
</html>
