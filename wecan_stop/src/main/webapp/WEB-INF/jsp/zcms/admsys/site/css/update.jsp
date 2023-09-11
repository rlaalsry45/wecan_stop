<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
if("true"=="${param.updatesuccess}"){
	alert("정상적으로 수정되었습니다.");
	//location.href='/admsys/site/css/index.html';
}
</script>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
		<div id="contents">
			<div class="contents_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/site/css/index.html">CSS관리</a> <strong>CSS수정</strong>
				</div>
			</div>
			<form method="post" name="frm" onsubmit="return checkForm()">
				<input name="act" type="hidden" value="update" />
				<input name="cssfilesave" type="hidden" value="${detail.cssfilesave}" />
				<div id="content">
				<ul class="homepagebbs">
					<li class="bg"><h3 class="sub">CSS 수정</h3></li>
					<li>
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="main_table1 bgneno" summary="CSS명, 입력방법, Import할 파일, 내용, 메모">
							<caption>CSS수정</caption>
							<colgroup>
								<col width="150px" />
								<col/>
							</colgroup>
							<tr>
								<th class="Tleft">CSS명</th>
								<td class="Tbod Tbod Tleft">
									<input type="text" name="csstitle" class="bor1ddd" size="50" value="${detail.csstitle}" />
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">입력방법</th>
								<td class="Tleft">
									<input class="radio0" type="radio" name="csstype" value="1" onclick="displayRow('01','css');" <c:if test="${detail.csstype=='1'}">checked</c:if> />
									내용직접입력
									<input class="radio1" type="radio" name="csstype" value="2" onclick="displayRow('02','css');" <c:if test="${detail.csstype=='2'}">checked</c:if> />
									파일등록
								</td>
							</tr>
							<tr id="03">
								<th class="Tbornone Tleft">Import할 파일
									<a class="imgSelect" title="Import 설명">설명</a>
									<div class="popupLayer">
									<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
									<strong>Import할 파일</strong></br>
									여러 css 파일을 하나의 css파일로 묶을 경우 사용
									</div>
								</th>
								<td class="Tleft">
									<div class="main_css_select">
										<ul>
											<li>
												<select id="csslist" multiple onclick="setconts('csslist')">
													<c:forEach items="${list}" var="each" varStatus="loop">
														<c:set value="${each.cssno}^${each.cssfilesave}" var="key" />
														<option value='${key}'>${each.csstitle}</option>
													</c:forEach>
												</select>
											</li>
										</ul>
									</div><!--/main_css_select-->
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">내용</th>
								<td class="Tleft">
									<div id="txtarea">
										<textarea class="bor1ddd" name="cssconts" id="cssconts" style="width:95%" rows="30"><c:out value="${detail.cssconts}" escapeXml="false" /></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">메모</th>
								<td class="Tleft">
									<textarea class="bor1ddd" name="cssmemo" style="width:95%" rows="8"><c:out value="${detail.cssmemo}" escapeXml="false" /></textarea>
								</td>
							</tr>
						</table>
						<!--/사이트 추가-->
						<div class="btn-c">
							<input class="chost_btn_s" type="submit" value="수정"/>
							<a class="btmore05" href="index.html">목록</a>
							<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('수정한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='index.html'">취소</a>
						</div>
						<h4>히스토리</h4>
						<input class="checkbox1" type="checkbox" name="csshis" value="1" <c:if test="${detail.csshis=='1'}">checked</c:if> />히스토리사용
							<a class="imgSelect" title="히스토리사용 설명">설명</a>
								<div class="popupLayer">
								<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
								<strong>히스토리사용</strong></br>
								히스토리 사용을 체크하시면 작성한 내용이 쌓이게 되며, 이전에 작성한 내용으로 복귀할 수 있습니다.
								</div>
						<table class="main_table1 bgneno" summary="번호, 메뉴명, 아이디, 등록일, 곤텐츠 사용">
						<colgroup>
							<col width="40px" />
							<col />
							<col width="150px" />
							<col width="150px" />
							<col width="180px" />
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>CSS명</th>
								<th>아이디</th>
								<th>등록일</th>
								<th>콘텐츠사용</th>
							</tr>
						</thead>
						<tbody class="td_center">
							<c:forEach items="${hislist}" var="data" varStatus="loop">
								<tr>
									<td>
										<c:out value='${loop.index+1}' />
									</td>
									<td>
										<c:out value='${data.csshistitle}' />
									</td>
									<td>
										<c:out value='${data.csshisuserid}' />
									</td>
									<td>
										<fmt:parseDate value="${data.csshisdate}" pattern="yyyyMMddHHmmss" var="isoDate" />
										<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>
										<c:url value="update.html" var="url">
											<c:param name="csshisno" value="${data.csshisno}" />
											<c:param name="cssno" value="${cssno}" />
											<c:param name="mode" value="" />
										</c:url>
										<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('정말 삭제하시겠습니까?')) this.href='${url}delete'">삭제</a>
										<a class="btmore04" href="javascript:void(0);" onclick="if(window.confirm('현재 입력한 내용이 삭제되며 복구 불가합니다.\r\n그래도 진행 하시겠습니까?')) this.href='${url}restore'">콘텐츠사용</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->

					</li>
				</ul>
				</div><!--/content-->
			</form>
<jsp:include page="../../end.jsp" flush="false" />
<script type="text/javascript">
window.onload = function(){
	document.getElementById("csslist").size = document.getElementById("csslist").options.length;
}
</script>
