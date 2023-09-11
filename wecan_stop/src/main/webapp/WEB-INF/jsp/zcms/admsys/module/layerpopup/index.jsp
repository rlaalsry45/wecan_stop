<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <form:form modelAttribute="zLayerPopupVo" name="frm" method="post">
                    <div class="contents_top">
						<div class="location">
							<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>레이어팝업 관리</strong>
						</div>
						<div class="TopSearch">
							<span>SEARCH AREA</span>
							<select style="height:27px;" name="cond1">
								<option value="datereg" <c:if test="${input.cond1=='datereg'}"><c:out value='selected' /></c:if>>등록일</option>
								<option value="datemod" <c:if test="${input.cond1=='datemod'}"><c:out value='selected' /></c:if>>수정일</option>
							</select>
							<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
							<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
							<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
							<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">
							<select style="height:27px;" name="cond2">
								<option value="title" <c:if test="${input.cond2=='title'}"><c:out value='selected' /></c:if>>캘린더 이름</option>
							</select>
							<input type=text name="keyword" class="bor1ddd" style="width:128px;"/>
							<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
						</div>
					</div>
                    <div id="content">
					<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">레이어팝업 관리</h3><a class="btmore03" href="insert.html">+ 등록</a></li>
						<li>
						<div class="top_bt">
							<a class="btmore07" href="javascript:checkAll(true,'popupno');">전체선택</a>
							<a class="btmore07" href="javascript:checkAll(false,'popupno');">전체해제</a>
							<a class="btmore05" href="javascript:del('popupno');">삭제</a>
						</div>
                        <div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="번호, 시작일, 종료일, 사용현황, 사용유무, 등록일, 관리">
                                <caption>팝업폼리스트</caption>
                                <colgroup>
                                    <col width="5px" />
                                    <col width="5%" />
                                    <col />
                                    <col width="140px" />
                                    <col width="140px" />
                                    <col width="15%" />
                                    <col width="80px" />
                                    <col width="140px" />
                                    <col width="160px" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','popupno')" />
                                        </th>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>시작일</th>
                                        <th>종료일</th>
                                        <th>사용현황</th>
                                        <th>사용유무</th>
                                        <th>등록일</th>
                                        <!-- <th>미리보기</th> -->
                                        <th>관리</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td rowspan="2">
                                                <c:set value="${each.layerpopupno}^${each.popupimg}" var="k" />
                                                <input class="bor_none" name="popupno" value="${k}" type="checkbox" />
                                            </td>
                                            <td rowspan="2">
                                                <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                                            </td>
                                            <td class="lborder">
                                                <c:out value='${each.title}' />
                                            </td>
                                            <td>
                                                <c:out value='${each.sdate}' />
                                            </td>
                                            <td>
                                                <c:out value='${each.edate}' />
                                            </td>
                                            <td>
                                                <c:out value='${fn:replace(each.sitetitle,",","<br>")}' escapeXml="false" />
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test='${each.popupstatus=="1"}'><span class="textbt">사용</span></c:when>
                                                    <c:otherwise><span class="textbt01">중지</span></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.datereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </td>
                                            <%-- <td>
                                                <c:url value="/admsys/PrvwEtc.html" var="url">
                                                    <c:param name="type" value="popup" />
                                                    <c:param name="no" value="${data.layerpopupno}" />
                                                    <c:param name="skin" value="${data.skin}" />
                                                </c:url>
                                                <a href="${url}" target="_blank"><img alt="미리보기" src="/cms/image/btn_bbs_preview.jpg" /></a>
                                            </td> --%>
                                            <td>
                                                <c:url value="update.html" var="url">
                                                    <c:param name="layerpopupno" value="${each.layerpopupno}" />
                                                </c:url>
												<a class="btmore09" href="${url}">수정</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="9" class="Cnone lborder rborder">
                                                <table class="Bnone_table" summary="치환문구복사">
                                                    <tr>
                                                        <th class="Cnone" style="width:50px">
                                                            <a href="javascript:void(0)" onclick="copytoclipboard('&lt;call type=&#34;layerpopup&#34; skin=&#34;${each.skin}&#34; no=&#34;${each.layerpopupno}&#34; &#47;&gt;');">
                                                                <img src="/cms/image/btn_replace_word.png" alt="치환문구복사" />
                                                            </a>
                                                        </th>
                                                        <td class="Cnone Tleft">
                                                            &lt;call
                                                            type=&#34;layerpopup&#34;
                                                            skin=&#34;${each.skin}&#34;
                                                            no=&#34;${each.layerpopupno}&#34;
                                                            &#47;&gt;
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${input.total==0}">
                                        <tr>
                                            <!-- <td colspan="10" style="padding:20;">기록이 없습니다.</td> -->
                                            <td colspan="9" style="padding:20;">기록이 없습니다.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                            <!---/게시판 영역------------------------->
							<p class="notification_right01">
								<img alt="!" src="/cms/image/excla.gif"> 1. 상단의 등록 버튼을 클릭하면 새로운 레이어팝업을 추가할 수 있습니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 2. 제목, 상태, 스킨설정, 기간설정, 크기, 위치, 오늘 하루 보지않기, 파일 업로드(이미지 첨부), 간략한 내용을 넣을 수 있습니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 3. 내용을 입력 후  됩니다. 등록 버튼을 클릭하면 목록 페이지에 추가된 레이어팝업을 확인할 수 있습니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 4. 추가된 레이어팝업 적용은 치환문구를 복사하여 해당 페이지에 삽입하면 해당 페이지에서 레이어 팝업이 생성됩니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 5. div 특정상 레이어 팝업은 메인 페이지에서 사용할 것을 권장합니다.
							</p>
                        </div><!--/main_table-->

						</li>
					</u>
                    </div><!--/content-->
                </form:form>
            </div><!--/contents-->
        </div><!--/container-->
    </div><!--/wrap-->
</body>
</html>
