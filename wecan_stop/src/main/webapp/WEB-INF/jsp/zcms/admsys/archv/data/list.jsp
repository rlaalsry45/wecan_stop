<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
<div id="contents">
	<div class="contents_top">
         <div class="location">
             <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/archv/catgry/">게시판</a> <strong>
               <c:choose>
					<c:when test="${catgry_cd eq '400' }">내부 공지 게시판</c:when>
					<c:when test="${catgry_cd eq '401' }">(대민)참고자료 게시판</c:when>
					<c:when test="${catgry_cd eq '403' }">Wecan 공지 게시판</c:when>
					<c:when test="${catgry_cd eq '404' }">개인정보처리방침 게시판</c:when>
					<c:otherwise>자료관리</c:otherwise>
				</c:choose>
             </strong>
         </div>
         <c:import url="/WEB-INF/jsp/zcms/admsys/archv/catgry/select.jsp"></c:import>
     </div>
           <div id="content">
            <ul class="homepagebbs">
                <li class="bg"><h3 class="bbs">
             	<c:choose>
					<c:when test="${catgry_cd eq '400' }">내부 공지 게시판</c:when>
					<c:when test="${catgry_cd eq '401' }">(대민)참고자료 게시판</c:when>
					<c:when test="${catgry_cd eq '403' }">Wecan 공지 게시판</c:when>
					<c:when test="${catgry_cd eq '404' }">개인정보처리방침 게시판</c:when>
					<c:otherwise>자료관리</c:otherwise>
				</c:choose>
                
                </h3>
	                <c:choose>
						<c:when test="${catgry_cd eq '400' }"><a class="btmore03" href="noticeInsert.html">+ 공지 등록</a></c:when>
						<c:when test="${catgry_cd eq '401' }"><a class="btmore03" href="orgInfoInsert.html">+ 안내문 등록</a></c:when>
						<c:when test="${catgry_cd eq '403' }">
							<a class="btmore03" href="wecanNoticeInsert.html">+ Wecan 공지 등록</a>			
						</c:when>
						<c:when test="${catgry_cd eq '404' }"><a class="btmore03" href="privacyInsert.html">+ 개인정보처리방침 등록</a></c:when>
						<c:otherwise><a class="btmore03" href="insert.html">+ 자료 등록</a></c:otherwise>
					</c:choose>
                </li>
                <li>
                    <div class="main_table">
                    	<input type="hidden" id="dashNO" name="dashNO" value="${dashNO}" >
                        <!--게시판 영역-->
                        <table class="main_table1" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
							<caption>자료목록</caption>
							<colgroup>
								<col style="width:5%;" />
								<c:choose>
									<c:when test="${catgry_cd eq '400' }"></c:when>
									<c:when test="${catgry_cd eq '401' }"></c:when>
									<c:when test="${catgry_cd eq '403' }"></c:when>
									<c:when test="${catgry_cd eq '404' }"></c:when>
									<c:otherwise>
										<col style="width:8%" />
										<col style="width:5%" />
									</c:otherwise>
								</c:choose>
								
								<col />
								<c:choose>
									<c:when test="${catgry_cd eq '400' }"></c:when>
									<c:when test="${catgry_cd eq '401' }"></c:when>
									<c:when test="${catgry_cd eq '403' }"></c:when>
									<c:when test="${catgry_cd eq '404' }"></c:when>
									<c:otherwise>
										<col style="width:5%;" />
									</c:otherwise>
								</c:choose>
								<col style="width:8%;" />
								<col style="width:8%;" />
								<c:choose>
									<c:when test="${catgry_cd eq '400' }"></c:when>
									<c:when test="${catgry_cd eq '401' }"></c:when>
									<c:when test="${catgry_cd eq '403' }"></c:when>
									<c:when test="${catgry_cd eq '404' }"></c:when>
									<c:otherwise>
										<col style="width:5%;" />
									</c:otherwise>
								</c:choose>
								
							</colgroup>
							<thead>
								<tr>
									<th scope="col">번호</th>
									<c:choose>
										<c:when test="${catgry_cd eq '400' }"></c:when>
										<c:when test="${catgry_cd eq '401' }"></c:when>
										<c:when test="${catgry_cd eq '403' }"></c:when>
										<c:when test="${catgry_cd eq '404' }"></c:when>
										<c:otherwise>
											<th scope="col">옵션</th>
											<th scope="col">언어</th>
										</c:otherwise>
									</c:choose>
									<th scope="col">제목</th>
									<th scope="col">게시자</th>
									<c:choose>
										<c:when test="${catgry_cd eq '400' }"></c:when>
										<c:when test="${catgry_cd eq '401' }">
<!-- 											<th scope="col">안내 분류</th> -->
										</c:when>
										<c:when test="${catgry_cd eq '403' }"></c:when>
										<c:when test="${catgry_cd eq '404' }"></c:when>
										<c:otherwise>
											<th scope="col">게시일</th>		
										</c:otherwise>
									</c:choose>
									<th scope="col">등록일</th>
									<c:choose>
										<c:when test="${catgry_cd eq '400' }"></c:when>
										<c:when test="${catgry_cd eq '401' }"></c:when>
										<c:when test="${catgry_cd eq '403' }"></c:when>
										<c:when test="${catgry_cd eq '404' }"></c:when>
										<c:otherwise>
											<th scope="col">관리</th>
										</c:otherwise>
									</c:choose>
								</tr>
							</thead>
							<tbody>
					<c:forEach items="${list}" var="each">
						<c:choose>
							<c:when test="${catgry_cd eq '400' }">
								<tr onclick="viewDetail('${each.archv_no}','${catgry_cd}')" style="cursor: pointer;">
									<td>${each.rownum_}</td>
							</c:when>
							<c:when test="${catgry_cd eq '401' }">
								<tr onclick="viewDetail('${each.archv_no}','${catgry_cd}')" style="cursor: pointer;">
									<td>${each.rownum_}</td>
							</c:when>
							<c:when test="${catgry_cd eq '403' }">
								<tr onclick="viewDetail('${each.archv_no}','${catgry_cd}')" style="cursor: pointer;">
									<td>${each.rownum_}</td>
							</c:when>
							<c:when test="${catgry_cd eq '404' }">
								<tr onclick="viewDetail('${each.archv_no}','${catgry_cd}')" style="cursor: pointer;">
									<td>${each.rownum_}</td>
							</c:when>
							<c:otherwise>
								<tr>
									<td>${each.archv_no }</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${catgry_cd eq '400' }"></c:when>
							<c:when test="${catgry_cd eq '401' }"></c:when>
							<c:when test="${catgry_cd eq '403' }"></c:when>
							<c:when test="${catgry_cd eq '404' }"></c:when>
							<c:otherwise>
								<td>${each.opt_name }</td>
								<td>
									<c:choose>
										<c:when test="${each.lang == '0' }">국문</c:when>
										<c:when test="${each.lang == '1' }">영문</c:when>
									</c:choose></td>
							</c:otherwise>
						</c:choose>
						<td class="Tleft">
							<c:choose>
								<c:when test="${catgry_cd eq '400' }">
									<strong class="zarchv"><subs:substringOut str='${each.title }' length='80' />
								</c:when>
								<c:when test="${catgry_cd eq '401' }">
									<strong class="zarchv"><subs:substringOut str='${each.title }' length='80' />
								</c:when>
								<c:when test="${catgry_cd eq '403' }">
									<strong class="zarchv"><subs:substringOut str='${each.title }' length='80' />
								</c:when>
								<c:when test="${catgry_cd eq '404' }">
									<strong class="zarchv"><subs:substringOut str='${each.title }' length='80' />
								</c:when>
								<c:otherwise>
									<img width="80" height="60" src="${image_path_thbnail}${each.thbnail}" onError="this.src='${image_path_thbnail}noimg.gif'" />
										<strong class="zarchv"><subs:substringOut str='${each.title }' length='80' /></strong><br/>
										<c:if test="${each.evnt_period_start_date !=null && each.evnt_period_end_date !=null}">
											행사기간 : ${each.evnt_period_start_date}~${each.evnt_period_end_date}<br/>
										</c:if>
										아카이브 경로 : ${each.catgry_name_list}<br/>
										<c:if test="${each.path !=null}">
											관련페이지 : ${each.path }
										</c:if>
								</c:otherwise>
							</c:choose>
						</td>
						<td>${each.reg_nm }</td>
						<c:choose>
							<c:when test="${catgry_cd eq '400' }"></c:when>
							<c:when test="${catgry_cd eq '401' }">
<!-- 								<td> -->
<%-- 									<c:choose> --%>
<%-- 										<c:when test="${each.orginfo_catgry_cd eq 1}">성폭력</c:when> --%>
<%-- 										<c:when test="${each.orginfo_catgry_cd eq 2}">가정폭력</c:when> --%>
<%-- 										<c:otherwise>미선택</c:otherwise> --%>
<%-- 									</c:choose> --%>
<!-- 								</td> -->
							</c:when>
							<c:when test="${catgry_cd eq '403' }"></c:when>
							<c:when test="${catgry_cd eq '404' }"></c:when>
							<c:otherwise>
								<td>
									<fmt:parseDate value="${each.start_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
									<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</c:otherwise>
						</c:choose>
						<td>
							<fmt:parseDate value="${each.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
							<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<c:choose>
							<c:when test="${catgry_cd eq '400' }"></c:when>
							<c:when test="${catgry_cd eq '401' }"></c:when>
							<c:when test="${catgry_cd eq '403' }"></c:when>
							<c:when test="${catgry_cd eq '404' }"></c:when>
							<c:otherwise>
								<td><a class="btmore09" href="update.html?archv_no=${each.archv_no }&pageIndex=${input.pageIndex }&opt_no=${input.opt_no }&catgry_cd=${input.catgry_cd }">관리</a></td>
							</c:otherwise>
						</c:choose>
						
					</tr>
				</c:forEach>
				<c:if test="${input.total==0}">
					<tr>
						<td colspan="8" style="padding:20;">기록이 없습니다.</td>
					</tr>
				</c:if>
				</tbody>
			</table>
		<form name="frm" method="post">
			<input type="hidden" id="catgry_cd" name="catgry_cd" value="${input.catgry_cd }">
			<input type="hidden" id="keyword" name="keyword" value="${input.keyword }">
		</form>
		<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
		</div>
		 </li>
		</ul>
	</div><!--/r_side-->
</div><!--/container-->
<script>
	$(document).ready(function () {
		var getDashNo = $("#dashNO").val();
		
		if ( getDashNo != ''){
			location.href = "noticeUpdate.html?archv_no="+getDashNo
					+"&pageIndex=1&opt_no=5&catgry_cd=400";
		}
	});
	
	function viewDetail(archv_no, catgry_cd){
		var controllerName = "";
		if ( catgry_cd == '400' ) {
			controllerName = "noticeView.html";
		} else if ( catgry_cd == '401' ) {
			controllerName = "orgInfoView.html";
		} else if ( catgry_cd == '403' ) {
			controllerName = "wecanNoticeView.html";
		} else if ( catgry_cd == '404' ) {
			controllerName = "privacyView.html";
		}
		
		location.href = "/admsys/archv/data/"+controllerName+"?archv_no="+archv_no
		+"&pageIndex=1&opt_no=5&catgry_cd="+catgry_cd;
	}
</script>
<jsp:include page="../../end.jsp" flush="false" />