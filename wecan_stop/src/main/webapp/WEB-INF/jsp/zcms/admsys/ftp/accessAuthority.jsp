<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../lnb.jsp" flush="true" />

            <div id="contents">
                <form:form modelAttribute="AccessAuthorityVo" name="frm" method="post">
                    <div class="contents_top" style="height:70px;">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>접근권한 등록</strong>
                        </div>
                    </div>
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="sub">접근권한관리 목록</h3></li>
                            <li>
                            	<!-- 컨텐츠 영역 -->
								<div class="counsel_wrap">
									<div class="search_box">
										<table>
											<caption>접근권한관리조회</caption>
											<colgroup>
												<col style="width:150px;">
												<col style="width:345px;">
												<col style="width:150px;">
												<col style="width:auto;">
											</colgroup>
											<tbody>
												<tr>
													<th>기간</th>
													<td colspan="3">
														<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
														<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
														<div class="input_box">
															<input type="date" class="date" id="sdate" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="2020-01-01" max="2040-12-31" placeholder="년-월-일" style="width: 160px;">
														</div>
														&nbsp;&nbsp;~&nbsp;&nbsp;
														<div class="input_box">
															<input type="date" class="date" id="edate" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="2020-01-01" max="2040-12-31" placeholder="년-월-일" style="width: 160px;">
														</div>
													</td>
												</tr>
												<tr>
													<th>신청사유</th>
													<td colspan="3">
														<div class="input_box full_width">
															<input type="text" id="reason" name="reason" value="${input.reason}">
														</div>
													</td>
												</tr>
												<tr>
													<th>신청자명</th>
													<td>
														<div class="input_box full_width">
															<input type="text" id="regName" name="regName" value="${input.regName}">
														</div>
													</td>
												</tr>
											</tbody>
										</table>
										<div class="btn_wrap align_right">
											<input class="btn" type="submit" value="조회" onclick="document.forms[0].action='?pageIndex=1'" />
										</div>
									</div>
									<div class="result_list">
										<div class="result_top_info">
											<span class="result_cnt">결과 : <c:out value='${input.total}'/>건</span>
											<select name="pageSize" onChange="this.form.action='?pageIndex=1';this.form.submit()">
			                                    <c:forTokens items="10,15,20,30,40,50" var="each" delims=",">
			                                        <option value="${each}" <c:if test="${input.pageSize==each}"><c:out value='selected'/></c:if>>${each}개 출력</option>
			                                    </c:forTokens>
			                                </select>
										</div>
										<table class="align_center">
											<caption>접근권한관리조회 결과</caption>
											<colgroup>
												<col style="width:75px;">
												<col style="width:75px;">
												<col style="width:auto;">
												<col style="width:80px;">
												<col style="width:100px;">
												<col style="width:200px;">
												<col style="width:100px;">
												<col style="width:80px;">
											</colgroup>
											<thead>
												<tr>
													<th>번호</th>
													<th>구분</th>
													<th>권한</th>
													<th>신청자명</th>
													<th>신청자ID</th>
													<th>신청사유</th>
													<th>승인일시</th>
													<th>승인자ID</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="each" varStatus="loop">
												<tr>
													<td><c:out value='${each.NO}'/></td>
													<td><c:out value='${each.permission_typeName}'/></td>
													<td><c:out value='${each.permission_info}'/></td>
													<td><c:out value='${each.userName}'/></td>
													<td><c:out value='${each.userId}'/></td>
													<td><c:out value='${each.reason}'/></td>
													<td name="dateTd"><c:out value='${each.approval_date}'/></td>
													<td><c:out value='${each.approval_user}'/></td>
												</tr>
												</c:forEach>
											</tbody>
										</table>
										<div class="btn_wrap align_right">
											<a href="javascript:excelDownload()" id="download_excel" class="btn">엑셀 다운로드</a>
											<a href="javascript:void(0);" id="action_registration" class="btn">등록</a>
										</div>	
										<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
									</div>
								</div>
								<!-- //컨텐츠 영역 -->
                            </li>
                        </ul>
                    </div>
                    <!--/content-->
                </form:form>                	                
            </div>
            <!--/contents-->
            
<jsp:include page="../end.jsp" flush="false" />

<script>
	function excelDownload(){
		
		var eForm = document.frm;
		
		eForm.method = "post";
		eForm.action = "/admsys/ftp/accessAuthority_excel.html";
		eForm.submit();
		
	
	}

	
	$("#action_registration").click(function(){
		$("#content").load("/admsys/ftp/accessAuthority_registration_form.html");
	});

 	for(i=0;i<$("td[name=dateTd]").size();i++){
 		document.getElementsByName("dateTd")[i].innerText=$("td[name=dateTd]").get(i).textContent.replace('.0',"");
	}
 	
 	
</script>
