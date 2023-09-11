<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />
            <div id="contents">
                <form:form modelAttribute="WCounselorVo" name="Wcslfrm" method="post">
                    <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/orgculturedigmng/">HOME</a> <a href="/admsys/cyberCounsel/chatCounsel.html">사이버상담</a> <strong>사이버상담후기 </strong>
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
                            <li class="bg"><h3 class="sub">사이버상담후기</h3></li>
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
                                <table class="main_table1" >
	                                <thead>
	                                	<th colspan="2">1번문항</th>
	                                	<th colspan="2">2번문항</th>
	                                </thead>    
	                                <tbody>
                                    <c:forEach items="${listTotal}" var="each" varStatus="loop">
                                        <tr>
                                        	<td>전혀 그렇지 않다</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_total_count}'/> (${num1_1_Percent} %)</td>
                                            <td>상담 내용</td>  
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_1_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_total_count}'/> (${num2_1_Percent} %)</td>                                       
                                        </tr>                                                                                                                                                                                                          
                                        <tr>                                                                                                                                                                                                           
                                        	<td>그렇지 않다</td>                                                                                                                                                                                       
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_total_count}'/> (${num1_2_Percent} %)</td>
                                            <td>상담사의 태도</td>                                                                                                                                                                                     
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_2_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_total_count}'/> (${num2_2_Percent} %)</td>
                                        </tr>                                                                                                                                                                                                          
                                        <tr>                                                                                                                                                                                                           
                                        	<td>보통이다</td>                                                                                                                                                                                          
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_3_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_total_count}'/> (${num1_3_Percent} %)</td>
                                            <td>상담 시스템</td>                                                                                                                                                                                       
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_3_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_total_count}'/> (${num2_3_Percent} %)</td>
                                        </tr>                                                                                                                                                                                                          
                                        <tr>                                                                                                                                                                                                           
                                        	<td>그렇다</td>                                                                                                                                                                                            
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_4_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_total_count}'/> (${num1_4_Percent} %)</td>
                                            <td>기타</td>                                                                                                                                                                                              
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_4_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_2_total_count}'/> (${num2_4_Percent} %)</td>
                                        </tr>                                                                                                                                                                                                          
                                        <tr>                                                                                                                                                                                                           
                                        	<td>매우 그렇다</td>                                                                                                                                                                                       
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_5_count}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_total_count}'/> (${num1_5_Percent} %)</td>
											<td>5점만점 기준</td>                                                                                                                                                                                              
                                            <td><fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_sum}'/> / <fmt:formatNumber type="number" maxFractionDigits="0"  value='${each.num_1_count}'/> (${fivePoint})</td>                                            
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
                                        <th onclick="event.cancelBubble=true">기타답변</th>
                                        <th onclick="event.cancelBubble=true">등록시간</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td><c:out value='${each.num_1}'/></td>                                            
                                            <td><c:out value='${each.num_2}'/></td>
                                            <td><c:out value='${each.num_3}'/></td>
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