<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <form:form modelAttribute="satisfactionVo" name="frm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/consultingmng/allcmsrch.html">상담관리</a> <strong>만족도조사 관리</strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="datereg" <c:if test="${input.cond1=='datereg'}"><c:out value='selected' /></c:if>>등록일</option>
                            </select>
								<input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" style="width:128px;"/>
                                        ~
								<input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" style="width:128px;"/>
                            <select style="height:27px;" name="cond2">
                                <option value="title" <c:if test="${input.cond2=='title'}"><c:out value='selected' /></c:if>>제목</option>
                            </select>
							<input type=text name="keyword" value="<c:out value='${input.keyword}' />" class="bor1ddd" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="search();" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg">
                                <h3 class="sub">만족도조사 관리 목록</h3>
                            </li>
                            <li>
                                <div class="top_bt">
                                    <a class="btmore07" href="javascript:checkAll(true,'satisfactionno');">전체선택</a>
                                    <a class="btmore07" href="javascript:checkAll(false,'satisfactionno');">전체해제</a>
                                </div>
                                <div class="main_table">
                                    <!---게시판 영역 -->
                                    <table class="main_table1" summary="번호, 제목, 상태, 대상, 시작일, 종료일, 관리">
                                        <caption>만족도조사 폼리스트</caption>
                                        <colgroup>
                                            <col width="3px" />
                                            <col width="3%" />
                                            <col />
                                            <col width="5%" />
                                            <col width="20%" />
                                            <col width="15%" />
                                            <col width="10%" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','satisfactionno')" />
                                                </th>
                                                <th>번호</th>
                                                <th>제목</th>
                                                <th>상태</th>
                                                <th>진행일시</th>
                                                <th>등록일시</th>
                                                <th>관리</th>
                                                <!--
                                                <th>미리보기</th>
                                                <th>사용현황</th>
                                                -->
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<tr>
	                                             <td colspan="6" class="Cnone lborder rborder">
	                                                <table class="Bnone_table" summary="치환문구복사"> 
	                                                    <tr>
	                                                        <th class="Cnone" style="width:50px">
	                                                            <a href="javascript:void(0)" onclick="copytoclipboard('&lt;c:import charEncoding=&#34;utf-8&#34; url=&#34;&#47;frontsys&#47;satisfaction&#47;latest.html&#34;&gt;&lt;&#47;c:import&gt');">
							                                        <img src="/cms/image/btn_replace_word.png" alt="치환문구복사" />
							                                    </a>
	                                                        </th>
	                                                        <td class="Cnone Tleft">
	                                                            최근내역 : &lt;c:import charEncoding=&#34;utf-8&#34; url=&#34;&#47;frontsys&#47;satisfaction&#47;latest.html&#34;&gt;&lt;&#47;c:import&gt;
	                                                        </td>
	                                                    </tr>
	                                                </table>
	                                            </td>
	                                        </tr>
                                            <c:forEach items="${list}" var="each" varStatus="loop">
                                                <tr>
                                                    <td>
                                                        <c:set value="${each.satisfactionno}" var="k" />
                                                        <input class="bor_none" name="satisfactionno" value="${k}" type="checkbox" />
                                                    </td>
                                                    <td>
                                                        <c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
                                                    </td>
                                                    <td>
                                                        <c:out value='${each.title}' />
                                                    </td>
                                                    <td>
                                                        <c:out value='${each.useyn}' />
                                                    </td>
<!--                                                     <td> -->
<%--                                                         <c:choose> --%>
<%--                                                             <c:when test='${each.target=="1"}'><c:out value='정회원' /></c:when> --%>
<%--                                                             <c:when test='${each.target=="2"}'><c:out value='비회원' /></c:when> --%>
<%--                                                             <c:otherwise><c:out value='전체' /></c:otherwise> --%>
<%--                                                         </c:choose> --%>
<!--                                                     </td> -->
                                                    <td>
                                                        <c:out value='${each.sdate} ~ ${each.edate}' />
                                                    </td>
                                                    <td>
                                                        <fmt:parseDate value="${each.datereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                        <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                                    </td>
                                                    <td>
                                                        <c:url value="result.html" var="url">
                                                            <c:param name="satisfactionno" value="${each.satisfactionno}" />
                                                        </c:url>
                                                        <a class="btmore04" href="${url}">결과보기</a>
                                                    </td>
                                                    <%-- 
                                                    <td>
                                                        <c:url value="/PrvwEtc" var="url">
                                                            <c:param name="type" value="survey" />
                                                            <c:param name="no" value="${data.surveyno}" />
                                                            <c:param name="skin" value="${data.skin}" />
                                                        </c:url>
                                                        <a href="${url}" target="_blank"><img alt="미리보기" src="/cms/image/btn_bbs_preview.jpg" /></a>
                                                    </td>
													<td>
                                                        <c:out value='${fn:replace(data.sitetitle,",","<br>")}' escapeXml="false" />
                                                    </td>
                                                    --%>
                                                </tr>
                                                <%--
                                                <tr>
                                                    <td colspan="10" style="padding:0">
                                                        <table class="replacement_words" cellpadding=0 border=0 cellspacing=0 width=100%>
                                                            <tr>
                                                                <th width=50 style="">
                                                                    <a href="javascript:void(0)" onclick="copytoclipboard('&lt;call type=&#34;survey&#34; skin=&#34;${data.skin}&#34; no=&#34;${data.surveyno}&#34; &#47;&gt;');">
                                                                        <img src="/cms/image/btn_replace_word.png" alt="치환문구복사" />
                                                                    </a>
                                                                </th>
                                                                <td style="text-align:left;">
                                                                    &lt;call
                                                                    type=&#34;survey&#34;
                                                                    skin=&#34;${data.skin}&#34;
                                                                    no=&#34;${data.surveyno}&#34;
                                                                    &#47;&gt;
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </td>
                                                </tr>
                                                --%>
                                            </c:forEach>
                                            <c:if test="${input.total==0}">
                                                <tr>
                                                    <!-- <td colspan="11" style="padding:20;">기록이 없습니다.</td> -->
                                                    <td colspan="10" style="padding:20;">기록이 없습니다.</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
							<p class="notification_right01">
								<img alt="!" src="/cms/image/excla.gif"> 1. 상단의 등록을 통해 만족도를 등록할 수 있습니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 2. 만족도 기간 설정 및 대상을 선택합니다. 문항 관리를 통해 객관식, 주관신, 단일선택, 중복선택이 가능합니다. 여러 문항 추가도 가능합니다.
								<br>
								<img alt="!" src="/cms/image/excla.gif"> 3. 결과보기를 통해 만족도 진행 현황을 확인할 수 있습니다.
							</p>
                                    <!---/게시판 영역-->
                                <div class="top_bt">
	                               	<a class="btmore05" href="javascript:alert('엑셀 다운로드');">엑셀 다운로드</a>
	                               	<a class="btmore05" href="javascript:window.print();">인쇄</a>
	                               	<a class="btmore01" href="javascript:del('satisfactionno');">삭제</a>
	                               	<a class="btmore01" href="javascript:update('${url}');">수정</a>
	                               	<a class="btmore01" href="insert.html">등록</a>
	                           	</div>
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        <script type="text/javascript">
                        function update(){
                        	var satisfactionChk = $(':checkbox[name=satisfactionno]:checked');
                        	
                        	if(satisfactionChk.length == 0){
								alert("만족도조사 목록을 한개 체크하세요.");
								return;
							}
                        	if(satisfactionChk.length > 1){
								alert("만족도조사 목록을 한개만 체크하세요.");
								return;
							}
                        	location.href = "update.html?satisfactionno="+satisfactionChk.val();
			
                        }
                        function search(){
							$("#satisfactionVo").attr("action","/admsys/module/csatisfaction/index.html");
							$("#satisfactionVo").submit();
						}
                        </script>
                    </div><!--/content-->
                </form:form>
            </div><!--/contents-->
<jsp:include page="../../end.jsp" flush="false" />
