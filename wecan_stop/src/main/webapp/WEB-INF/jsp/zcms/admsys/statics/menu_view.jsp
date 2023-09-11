<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.nodes.Element" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %>
<c:import charEncoding="utf-8" url="../lnb.jsp" />
<script>

function downExcel(){
	
	$("#act").val("excel");
	$("#frm").submit();
	
}

</script>
 <div id="contents">
                <form:form name="frm" id="frm" method="post">
                <input type="hidden" name="siteno" value="${siteno}" />
                <input type="hidden" name="cond1" value="visitdate" />
                <input type="hidden" name="act" id="act"/>
                    <div class="contants_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>페이지별 방문통계</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                               <input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" style="width:128px;"/>
                                        ~
                                <input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" style="width:128px;"/>
                            <%-- <input class="bor1ddd" type="text" name="keyword" value="<c:out value='${input.keyword}' />" style="width:128px;"/> --%>
                            <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="setting">페이지별 방문통계 : <c:out value="${sitetitle}" escapeXml="false" /><!--현재 메뉴가 어떤 사이트의 메뉴관리인지 표--></h3>
                            <a class="btmore03" href="#none" onclick="downExcel()">엑셀다운</a>
                            </li>
                            <li>
                                <div class="main_table">
                                    <!--게시판 영역-->
                                <table class="main_table1" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
								<caption>메뉴전체보기</caption>
								<colgroup>
									<col width="" />
									<col width="20%" />
									<col width="20%" />
									
								</colgroup>
								<thead>
									<tr>
										<th>메뉴명</th>
										<th>URL</th>
										<th>접속수</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="data">
										<tr id="${data.menulevel}_${data.menuparentno}_${data.menutopno}">
											<td class='menu_d${data.menulevel}'>
												<c:url value="http://${sitedomain}" var="url">
													<c:param name="menuno" value="${data.menuno}" />
												</c:url>
												<c:if test='${data.cnt!="1"}'><img src="/cms/image/btn_closed.jpg" id="${data.menulevel+1}_${data.menuno}_${data.menutopno}" /></c:if>
												<a href="${url}" target="_blank" title="${data.menutitle}">${data.menutitle}<c:if test='${data.cnt!="1"}'>(${data.cnt-1})</c:if></a></span>
											</td>
											<td>
												<a href="javascript:void(0)" onclick="copytoclipboard('/?menuno=${data.menuno}');">
													${data.menuno }
												</a>
												
											</td>
											<td>${data.satis_cnt}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</div>
						</li>
					</ul>
				</div>
				</form:form>
						<!---/게시판 영역------------------------->
						<!-- <p class="goSiteList">
							<a href="/admsys/site/menu/index.html"><img src="/cms/image/btn_goList.jpg" alt="사이트목록으로 돌아가기"></a>
						</p> -->
					</div><!--/main_table-->
				</div><!--/content-->
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
</body>
</html>