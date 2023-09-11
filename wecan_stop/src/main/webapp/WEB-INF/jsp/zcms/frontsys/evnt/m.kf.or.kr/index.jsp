<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#searchevnt").change(function() {
		//alert($("#searchevnt option:selected").val());
		window.location.href = "/?menuno=" + $("#menuno").val() + "&searchevnt=" + $("#searchevnt option:selected").val();
	});
});

function newpostsearch(url){
	url = "/skin/newpost/road.html";
	window.open(url, "result1122", "resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=480, height=450");
};

</script>


<form modelAttribute="evntVO" name="frm" method="post" action="/?menuno=${menuno}">
	<input type="hidden" id="evnt_opt_cd" name="evnt_opt_cd" value="${evnt_opt_cd}" />
	<div id="container">
		<div class="location">
			<a href="/?menuno=${menuno}">KF문화센터</a> &gt;
			<c:if test="${menuno eq '378' }"><strong>전시</strong></c:if>
			<c:if test="${menuno eq '379' }"><strong>공연</strong></c:if>
			<c:if test="${menuno eq '380' }"><strong>강좌</strong></c:if>
			<c:if test="${menuno eq '384' }"><strong>재단주요활동</strong></c:if>


		</div>
		<div class="contents">
			<!--span class="tab"><a href="#" class="on">전체</a> | <a href="#">진행중</a> | <a href="#">종료</a> | <a href="#">당첨자</a></span-->

			<!-- 모바일메뉴번호에 따라 국문번호를 별도로 던져준다 -->
			<c:if test="${menuno eq '378' }"><c:set var="kfmenuno" value="35" /></c:if>
			<c:if test="${menuno eq '379' }"><c:set var="kfmenuno" value="36" /></c:if>
			<c:if test="${menuno eq '380' }"><c:set var="kfmenuno" value="37" /></c:if>
			<c:if test="${menuno eq '384' }"><c:set var="kfmenuno" value="79" /></c:if>


			<c:if test="${input.total !=0}">
			<ul class="progress sub">
				<c:forEach items="${list}" var="each" varStatus="loop">
					<li>

						<a href="http://kf.or.kr/?menuno=${kfmenuno}&type=view&evnt_no=${each.evnt_no}&pageIndex=${input.pageIndex}&searchevnt=${searchevnt}" class="img">
							<img width="107" height="86" src="${image_path_thbnail}/${each.thbnail}" onError="this.src='${image_path_thbnail}/noimg.gif'" alt="${each.evnt_title}" />
						</a>
						<div>
							<c:if test="${each.prwin_commit == 1}">
								<strong class="blue">[당첨자발표]</strong>
							</c:if>
							<fmt:parseDate value="${each.end_date}" pattern="yyyy-MM-dd" var="end_date_fmt" />
							<fmt:parseDate value="${each.currentdate}" pattern="yyyy-MM-dd" var="currentdate_fmt" />
							<c:if test="${end_date_fmt < currentdate_fmt && menuno != 384}">
								<strong class="red">[종료]</strong>
							</c:if>
							<strong><a href="http://kf.or.kr/?menuno=${kfmenuno}&type=view&evnt_no=${each.evnt_no}&pageIndex=${input.pageIndex}&searchevnt=${searchevnt}">${each.evnt_title}</a></strong>
							<p>${each.evnt_sumup }</p>
							<ul>
								<li>게시일 : ${each.post_date}</li>
								<c:if test="${each.start_date_mod !=null && each.end_date_mod !=null}">
									<li>행사기간 : ${each.start_date_mod}~${each.end_date_mod}</li>
								</c:if>
								<c:if test="${each.evnt_use_yn ==1}">
									<li>신청기간 : ${each.evnt_start_date_mod}~${each.evnt_end_date_mod}</li>
									<li>당첨발표 : ${each.prwin_date_mod}</li>
								</c:if>
							</ul>

							<c:if test="${each.evnt_use_yn ==1}">
								<c:if test="${each.evnt_end_date > each.currentdate && each.evnt_start_date <= each.currentdate}">
									<c:if test="${each.only_member_yn ==1 }" >
										<c:if test="${pageContext['request'].userPrincipal == null}">
											<a class="btn2" href="javascript:alert('회원만 신청가능합니다. 로그인 화면으로 이동합니다.');window.location.href='/?menuno=633';" title="새창으로 열기">신청하기</a>
										</c:if>
										<c:if test="${pageContext['request'].userPrincipal != null}">
											<a class="btn2" href="javascript:window.open('/evnt/evnt_popup.html?evnt_no=${each.evnt_no}&menuno=${menuno }', 'evnt_pop', 'resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no');">신청하기</a>
											<%-- <a href="javascript:cnjOpen('/evnt/evnt_popup.html?evnt_no=${data.evnt_no}&menuno=${menuno }','cnjopen',776,800)" class="btn2" title="새창으로 열기">신청하기</a> --%>
										</c:if>
									</c:if>
									<c:if test="${each.only_member_yn !=1 }" >
										<a class="btn2" href="javascript:window.open('/evnt/evnt_popup.html?evnt_no=${each.evnt_no}&menuno=${menuno }', 'evnt_pop', 'resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no');">신청하기</a>
										<%-- <a href="javascript:cnjOpen('/evnt/evnt_popup.html?evnt_no=${data.evnt_no}&menuno=${menuno }','cnjopen',776,800)" class="btn2" title="새창으로 열기">신청하기</a> --%>
									</c:if>
								</c:if>
							</c:if>
						</div>

					</li>
				</c:forEach>
			</ul>
			</c:if>
			<c:if test="${input.total==0}">
				<tr>
					<c:if test="${menuno == 42 || menuno == 43}">
						<div class="no-file"><img src="/usr/image/archive/img_nofile04.gif" alt="해당기록이 없습니다." /></div>
					</c:if>
					<c:if test="${!(menuno == 42 || menuno == 43)}">
						<div class="no-file"><img src="/usr/image/archive/img_nofile.gif" alt="해당기록이 없습니다." /></div>
					</c:if>
				</tr>
			</c:if>
			<ptkevm:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' menuno='${menuno}' searchevnt='${searchevnt}' />
			<a class="btn back" href="?menuno=369"><em>목록</em></a>
		</div>
	</div>
</form>