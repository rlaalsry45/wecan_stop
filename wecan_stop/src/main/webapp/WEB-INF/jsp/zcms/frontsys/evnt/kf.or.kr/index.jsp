<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	$("#searchevnt").change(function(){
		//alert($("#searchevnt option:selected").val());
		window.location.href="/?menuno="+$("#menuno").val()+"&searchevnt="+$("#searchevnt option:selected").val();
	});
});
</script>


<form modelAttribute="evntVO" name="frm" method="post" action="/?menuno=${menuno}">
	<!--<c:if test="${evnt_opt_cd == 1 ||evnt_opt_cd == 2||evnt_opt_cd == 3 }">
		<div class="select2">
			<label class="invisible" for="searchevnt">진행현황</label>
			<select name= "searchevnt" id="searchevnt">
				<option value=""   <c:if test="${searchevnt == null}">selected</c:if> >전체</option>
				<option value="1"  <c:if test="${searchevnt == 1}">selected</c:if> >진행중</option>
				<option value="2"  <c:if test="${searchevnt == 2}">selected</c:if> >종료</option>
				<option value="3"  <c:if test="${searchevnt == 3}">selected</c:if> >당첨자 발표</option>
			</select>
		</div>
	</c:if>-->
	<input type="hidden" id="evnt_opt_cd" name="evnt_opt_cd" value="${evnt_opt_cd}" />
	<!--<input type="hidden" id="menuno" name="menuno" value="${menuno}" />-->

	<c:if test="${input.total !=0}">
	<ul class="progress type">
		<c:forEach items="${list}" var="each" varStatus="loop">
		<li>
			<a href="/?menuno=${menuno}&type=view&evnt_no=${each.evnt_no}&pageIndex=${input.pageIndex}&searchevnt=${searchevnt}" class="img">
				<img width="161" height="122" src="${image_path_thbnail}/${each.thbnail}" onError="this.src='${image_path_thbnail}/noimg.gif'" alt="${each.evnt_title}" />
			</a>
			<div>
				<c:if test="${each.prwin_commit == 1}">
					<strong class="blue">[당첨자발표]</strong>
				</c:if>
				<fmt:parseDate value="${each.end_date}" pattern="yyyy-MM-dd " var="end_date_fmt" />
				<fmt:parseDate value="${each.currentdate}" pattern="yyyy-MM-dd" var="currentdate_fmt" />
				<c:if test="${end_date_fmt < currentdate_fmt && menuno != 79}">
					<strong class="red">[종료]</strong>
				</c:if>
				<strong><a href="/?menuno=${menuno}&type=view&evnt_no=${each.evnt_no}&pageIndex=${input.pageIndex}&searchevnt=${searchevnt}">${each.evnt_title}</a></strong>
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
						<c:if test="${each.only_member_yn ==1 }">
							<c:if test="${pageContext['request'].userPrincipal == null}">
								<a class="btn2"	href="javascript:alert('회원만 신청가능합니다. 로그인 화면으로 이동합니다.');window.location.href='/?menuno=477';"	title="새창으로 열기"><img src="/usr/image/common/btn/btn_app02.gif" alt="신청하기" /></a>
							</c:if>
							<c:if test="${pageContext['request'].userPrincipal != null}">
								<a href="javascript:cnjOpen('/evnt/evnt_popup.html?evnt_no=${each.evnt_no}&menuno=${menuno }','cnjopen',776,800)" class="btn" title="새창으로 열기"><img src="/usr/image/common/btn/btn_app02.gif" alt="신청하기" /></a>
							</c:if>
						</c:if>
						<c:if test="${each.only_member_yn !=1 }">
							<a href="javascript:cnjOpen('/evnt/evnt_popup.html?evnt_no=${each.evnt_no}&menuno=${menuno }','cnjopen',776,800)" class="btn" title="새창으로 열기"><img src="/usr/image/common/btn/btn_app02.gif" alt="신청하기" /></a>
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
	<ptkev:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' menuno='${menuno}' searchevnt='${searchevnt}' />
</form>