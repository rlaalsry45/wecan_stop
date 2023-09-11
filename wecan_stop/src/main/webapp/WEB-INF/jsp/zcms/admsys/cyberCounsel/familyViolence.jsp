<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />
            <div id="contents">
                <form:form modelAttribute="WCounselorVo" name="Wcslfrm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/orgculturedigmng/">HOME</a> <a href="/admsys/cyberCounsel/chatCounsel.html">사이버상담</a> <strong>가정폭력감수성진단 </strong>
                        </div>
                        <div class="TopSearch">
                            <span>SEARCH AREA</span>
                            <select style="height:27px;" name="cond1">
                                <option value="sitedatereg" <c:if test="${input.cond1=='sitedatereg'}"><c:out value='selected' /></c:if>>등록일</option>
                            </select>
                               <input id="d4311" name="sdate" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" value="<c:out value='${input.sdate}' />" style="width:128px;"/>
                                        ~
                                <input id="d4312" name="edate" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" value="<c:out value='${input.edate}' />" style="width:128px;"/>
                            <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">가정폭력감수성진단</h3></li>
                            <li>
                                <div class="main_table">

	                            <div class="top_bt">
	                                <select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()" style="height:28px;">
	                                    <c:forTokens items="10,20,30,40,50" var="each" delims=",">
	                                        <option value="${each}" <c:if test="${input.pageSize==each}"><c:out value='selected'/></c:if>>${each}개 출력</option>
	                                    </c:forTokens>
	                                </select>
	                            </div>
                                
                                <!-- 전체현황 영역 -->
                                <table class="main_table1" style="font-size:7px;">
	                                <thead>
	                                	<th>구분</th>
	                                	<th>1번문항</th>
	                                	<th>2번문항</th>
	                                	<th>3번문항</th>
	                                	<th>4번문항</th>
	                                	<th>5번문항</th>
	                                	<th>6번문항</th>
	                                	<th>7번문항</th>
	                                	<th>8번문항</th>
	                                	<th>9번문항</th>
	                                	<th>10번문항</th>
	                                </thead>    
	                                <tbody>
                                    <c:forEach items="${listTotal}" var="each" varStatus="loop">
                                        <tr>
                                        	<td>그렇다</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_total_count}'/> <br> (${num1_1_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_total_count}'/> <br> (${num2_1_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_3_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_3_total_count}'/> <br> (${num3_1_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_4_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_4_total_count}'/> <br> (${num4_1_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_5_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_5_total_count}'/> <br> (${num5_1_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_6_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_6_total_count}'/> <br> (${num6_1_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_7_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_7_total_count}'/> <br> (${num7_1_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_8_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_8_total_count}'/> <br> (${num8_1_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_9_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_9_total_count}'/> <br> (${num9_1_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_10_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_10_total_count}'/> <br> (${num10_1_Percent} %)</td>
                                        </tr>                                                                                                                                                                                                          
                                        <tr>                                                                                                                                                                                                           
                                        	<td>아니다</td>                                                                                                                                                                                       
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_total_count}'/> <br> (${num1_2_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_total_count}'/> <br> (${num2_2_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_3_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_3_total_count}'/> <br> (${num3_2_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_4_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_4_total_count}'/> <br> (${num4_2_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_5_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_5_total_count}'/> <br> (${num5_2_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_6_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_6_total_count}'/> <br> (${num6_2_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_7_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_7_total_count}'/> <br> (${num7_2_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_8_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_8_total_count}'/> <br> (${num8_2_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_9_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_9_total_count}'/> <br> (${num9_2_Percent} %)</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_10_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_10_total_count}'/> <br> (${num10_2_Percent} %)</td>
                                        </tr>                                                                                                                                                                                                          
                                    </c:forEach>
	                                </tbody>                            
                                </table>
                                
                                
                                <!--게시판 영역-->
                                <table id="main_table" class="main_table1" summary="1번문항, 2번문항, 기타답변, 등록시간">
                                    <caption>사이버상담후기</caption>
                                    <colgroup>
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th onclick="event.cancelBubble=true">1번문항</th>
                                        <th onclick="event.cancelBubble=true">2번문항</th>
                                        <th onclick="event.cancelBubble=true">3번문항</th>
                                        <th onclick="event.cancelBubble=true">4번문항</th>
                                        <th onclick="event.cancelBubble=true">5번문항</th>
                                        <th onclick="event.cancelBubble=true">6번문항</th>
                                        <th onclick="event.cancelBubble=true">7번문항</th>
                                        <th onclick="event.cancelBubble=true">8번문항</th>
                                        <th onclick="event.cancelBubble=true">9번문항</th>
                                        <th onclick="event.cancelBubble=true">10번문항</th>
                                        <th onclick="event.cancelBubble=true">등록시간</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td><c:out value='${each.num_1}'/></td>                                            
                                            <td><c:out value='${each.num_2}'/></td>
                                            <td><c:out value='${each.num_3}'/></td>
                                            <td><c:out value='${each.num_4}'/></td>
                                            <td><c:out value='${each.num_5}'/></td>
                                            <td><c:out value='${each.num_6}'/></td>
                                            <td><c:out value='${each.num_7}'/></td>
                                            <td><c:out value='${each.num_8}'/></td>
                                            <td><c:out value='${each.num_9}'/></td>
                                            <td><c:out value='${each.num_10}'/></td>
                                            <td><c:out value='${each.datetime}'/></td>
                                        </tr>
                                    </c:forEach>
                                    
                                    <c:if test="${input.total==0}">
                                        <tr>
                                            <td colspan="14" style="padding: 20px;">등록된 정보가 없습니다.</td>
                                        </tr>
                                    </c:if>
                                    </tbody>
                                </table>
                                                                    
                                    <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                                    <!--/게시판 영역-->
                                    
				                    <div class="top_bt">
				                    	<a class="btmore05" href="javascript:alert('엑셀 다운로드');">엑셀 다운로드</a>
				                    	<a class="btmore05" href="javascript:alert('인쇄');">인쇄</a>
				                	</div> 
				                	                                   
                                </div>
                                <!--/main_table-->
                            </li>
                        </ul>
                        
                    </div>
                    <!--/content-->
                </form:form>
                            	                
            </div>
            <!--/contents-->
            
<jsp:include page="../end.jsp" flush="false" />