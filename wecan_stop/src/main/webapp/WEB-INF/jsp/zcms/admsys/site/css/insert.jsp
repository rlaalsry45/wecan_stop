<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
		<div id="contents">
			<div class="contents_top">
				<div class="location">
					<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/site/css/index.html">CSS관리</a> <strong>CSS등록</strong>
				</div>
			</div>
			<form:form modelAttribute="zcssVo" method="post" name="frm" onsubmit="return checkForm()">
				<input name="act" type="hidden" value="insert" />
				<div id="content">
				<ul class="homepagebbs">
					<li class="bg"><h3 class="sub">CSS 등록</h3></li>
					<li>
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="main_table1 bgneno" summary="CSS명, 입력방법, Import할 파일, 내용, 메모">
							<caption>사이트 추가</caption>
							<colgroup>
								<col width="150px" />
								<col />
							</colgroup>
							<tr>
								<th class="Tleft">CSS명</th>
								<td class="Tbod Tbod Tleft">
									<input type="text" name="csstitle" class="bor1ddd" value="" size="50" />
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">입력방법</th>
								<td class="Tleft">
									<input class="radio0" type="radio" name="csstype" value="1" checked onclick="displayRow('01','css');" />
									내용직접입력
									<input class="radio1" type="radio" name="csstype" value="2" onclick="displayRow('02','css');" />
									파일등록
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">Import할 파일</th>
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
										<textarea class="bor1ddd" name="cssconts" id="cssconts" style="width:95%" rows="30"></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th class="Tbornone Tleft">메모</th>
								<td class="Tleft">
									<textarea class="bor1ddd" name="cssmemo" style="width:95%" rows="8"></textarea>
								</td>
							</tr>
						</table>
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
					<!--/사이트 추가-->
					<div class="btn-c">
						<input class="chost_btn_s" type="submit" value="등록"/>
						<a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='index.html'">취소</a>
					</div>

					<!--
					<div class="confirm">
						<p>
							<input type="image" src="/cms/image/btn_confirm.jpg" alt="등록" />
							<a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='index.html'">
								<img src="/cms/image/btn_cancel.jpg" alt="취소" />
							</a>
						</p>
					</div>--><!--/confirm-->
				</li>
				</ul>
				</div><!--/content-->
			</form:form>
<jsp:include page="../../end.jsp" flush="false" />
<script type="text/javascript">
window.onload = function(){
	document.getElementById("csslist").size = document.getElementById("csslist").options.length;
}
</script>
