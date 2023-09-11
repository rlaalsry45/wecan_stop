<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ page import="com.z5.zcms.admsys.user.domain.ZUserVo"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
                <div class="contents_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/user/common/">회원관리</a> <strong>회원통계</strong>
                    </div>
                </div>
				<div id="content">
					<ul class="homepagebbs">
					<li class="bg"><h3 class="member">회원통계</h3></li>
					<li>
						<table class="main_table1 bgneno" summary="전체, 종신회원, 정회원, 준회원">
						<caption>회원통계</caption>
						<colgroup>
							<col width="33.3%" />
							<col width="33.3%" />
							<col width="33.3%" />
						</colgroup>
						<tr>
							<th width="100%" colspan="3"><b>전체 : ${totalCount } 명</b></th>
							<!-- <td align="right" class=chost_table_body2>[ 2015-05-11]&nbsp;&nbsp;</td> -->
						</tr>
						<tr>
							<!--td width="19%" class=chost_table_body2>명예회원 : 1370 명</td-->
							<td class="rborder">종신회원 : ${lfeCount } 명</td>
							<td class="rborder">정회원 : ${regularCount } 명</td>
							<td>준회원 : ${associateCount }명</td>
							<!--td width="19%" class=chost_table_body2>논문회원 :　0 명</td-->
						</tr>
						</table>
						<table class="main_table_none" summary="각지회">
						<c:forEach items="${branchCountList}" var="branch" varStatus="loop">
							<c:if test="${loop.count % 3 == 1 }">
						<tr>
							</c:if>
							<td width="33.3%">
								<table class="main_table1 bgneno" summary="각지회">
								<colgroup>
									<col width="33.3%" />
									<col width="33.3%" />
									<col width="33.3%" />
								</colgroup>
								<thead>
									<tr>
										<th class="rborder" colspan="3">${branch.cond1 } : <b>${branch.cond2} 명</b></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="rborder">종신회원 : <b>${branch.cond3} 명</b></td>
										<td class="rborder">정회원 : <b>${branch.cond4} 명</b></td>
										<td>준회원 : <b>${branch.cond5} 명</b></td>
									</tr>
								</tbody>
								</table>
							</td>
							<c:if test="${loop.count % 3 == 0 }">
						</tr>
							</c:if>
						</c:forEach>
						</table>
					</li>
				</ul>
				</div>
            </div> <!--/contents-->
        </div> <!--/container-->
    </div> <!--/wrap-->
</body>
</html>