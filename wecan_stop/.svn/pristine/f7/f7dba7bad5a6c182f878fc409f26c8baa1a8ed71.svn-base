<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>
<form:form modelAttribute="frontBoardVo" name="board" method="post" action="${post_url}" >
		<div class="text-bbsbox">
			<strong class="bbstitle"><c:out value="${view.bbstitle}" escapeXml="false" /></strong>
			<dl>
				<dt>작성자</dt>
				<dd>${view.bbsusername }</dd>
				<dt>작성일</dt>
				<dd><c:out value="${view.bbsdatereg}" /></dd>
				<!-- 채용공고일경우만 나오도록 -->
				<c:if test="${param.menuno eq '70' }">
				<dt>공고기간</dt>
				<dd>${view.sdate} ~ ${view.edate}</dd>
				</c:if>
				<dt><spring:message code="text.views"/></dt>
				<dd><fmt:formatNumber type="number" groupingUsed="true" value="${view.bbshit}"/></dd>
			</dl>
			<c:if test="${not empty filelist}">
			<div class="file">
				<c:forEach items="${filelist}" var="each" varStatus="loop">
				<c:set var="filetype" value="zip"/>
				<c:choose>
					<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'BMP' || fn:toUpperCase(each.bbsfileicon) eq 'JPG' || fn:toUpperCase(each.bbsfileicon) eq 'GIF' || fn:toUpperCase(each.bbsfileicon) eq 'PNG'}">
						<c:set var="filetype" value=""/>
					</c:when>
					<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'HWP'}">
						<c:set var="filetype" value="hwp"/>
					</c:when>
					<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'DOC'}">
						<c:set var="filetype" value="doc"/>
					</c:when>
					<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'PDF'}">
						<c:set var="filetype" value="pdf"/>
					</c:when>
					<c:when test="${fn:toUpperCase(each.bbsfileicon) eq 'XLS' || fn:toUpperCase(each.bbsfileicon) eq 'XLSX'}">
						<c:set var="filetype" value="xlx"/>
					</c:when>
				</c:choose>
					<a href="#none" onclick="return submitForm(this,'down',${each.fno},'')" class="${filetype }"><c:out value="${each.forg}" /></a>
				</c:forEach>
			</div>
			</c:if>
			<div class="textview"><c:out value="${fn:replace(view.bbsconts, '<br>', '')}" escapeXml="false"/></div>
		</div>
		<dl class="bbs_pre_next">
			<dt><spring:message code="text.previous"/></dt>
			<dd>
			<c:if test="${view.prevno eq '0'}"><span>현재 페이지가 첫 페이지입니다.</span></c:if>
			<c:if test="${view.prevno ne '0'}"><a href="#none" onclick="return submitForm(this,'prev', ${view.prevno})"><c:out value="${view.prevtitle}" escapeXml="false" /></a></c:if>
			</dd>
			<dt><spring:message code="text.next"/></dt>
			<dd>
			<c:if test="${view.nextno eq '0'}"><span>현재 페이지가 마지막 페이지입니다.</span></c:if>
			<c:if test="${view.nextno ne '0'}"><a href="#none" onclick="return submitForm(this,'next', ${view.nextno})"><c:out value="${view.nexttitle}" escapeXml="false" /></a></c:if>
			</dd>
		</dl>
		<c:if test="${sessionScope.zUserVo.userid eq 'admin'}">
		<script type="text/javascript">
			function copytoclipboard(txt,ztag) {
				var ztag = encodeURIComponent(ztag);
				txt = location.protocol+"//"+location.host+txt +"&ztag="+ztag;
				
				var IE=(document.all)?true:false;
				if (IE) {
					if(window.clipboardData.setData("Text", txt)) alert("복사되었습니다.");
				}
				else{
					temp = prompt("이 메뉴의 링크주소 입니다.\r\n Ctrl+C를 눌러 클립보드로 복사하세요", txt);
				}
			}
		</script>
		<div style="text-align: center;font-weight: bold;">
		<a href="javascript:void(0)" onclick="copytoclipboard('/?menuno=${menuno}&bbsno=${view.bbsno}&boardno=${boardno}&siteno=${siteno}&act=view&','${ztag}');" >링크주소복사</a>
		</div>
		</c:if>
		<div class="tac">
			<c:if test="${sessionScope.frontAuthPassport.role_d ne '0'}">
			   <a href="#none" onclick="return submitForm(this,'delete', ${view.bbsno})" class="webtong-btn filled round basic big grey mt20">삭제</a>
			</c:if>
			<c:if test="${sessionScope.frontAuthPassport.role_m ne '0'}">
			   <a href="#none" onclick="return submitForm(this,'edit', ${view.bbsno})" class="webtong-btn filled round basic big mt20">수정</a>
			</c:if>        
			<c:if test="${sessionScope.frontAuthPassport.role_r ne '0'}">
			   <a href="#none" onclick="return submitForm(this,'reply', ${view.bbsno})" class="webtong-btn filled round basic big grey mt20">답글</a>
			</c:if>
			<c:if test="${1==2}">
			   <a href="#none" onclick="return submitForm(this,'approval', ${view.bbsno})" class="webtong-btn filled round basic big grey mt20">승인</a>
			</c:if>
			<a href="#none" onclick="return submitForm(this,'list', ${view.bbsno})" class="webtong-btn filled round basic big mt20"><spring:message code="button.list"/></a>
		</div>
<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="cates" value="${cates}" />
<input type="hidden" name="key" value="${key}" />
<input type="hidden" name="keyword" value="${keyword}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="pageIndex" value="${pageIndex}" />
<input type="hidden" name="subname" id="subname" value="${subname}" />
</form:form>

<script language="javascript">
    document.title = "${view.bbstitle}:글읽기 > "+document.title;
</script>
