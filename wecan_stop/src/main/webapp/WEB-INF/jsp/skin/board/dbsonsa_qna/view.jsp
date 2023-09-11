<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:if test="${not empty subname}"><c:set var="subname" value="/${subname}" /></c:if>
<c:url value="${subname}/index.html" var="post_url" >
<c:if test="${menuno ne -9999}"><c:param name="menuno" value="${menuno}" /></c:if>
</c:url>
<style type="text/css">
.pop-layer .pop-container {
  padding: 20px 25px;
}

.pop-layer p.ctxt {
  color: #666;
  line-height: 25px;
}

.pop-layer .btn-r {
  width: 100%;
  margin: 10px 0 20px;
  padding-top: 10px;
  border-top: 1px solid #DDD;
  text-align: right;
}

.pop-layer {
  display: none;
  position: absolute;
  top: 50%;
  left: 50%;
  width: 447px;
  height: auto;
  background-color: #fff;
  border: 5px solid #7B8070;
  z-index: 10;
}

.dim-layer {
  display: none;
  position: fixed;
  _position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 100;
}

.dim-layer .dimBg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: #000;
  opacity: .5;
  filter: alpha(opacity=50);
}

.dim-layer .pop-layer {
  display: block;
}

a.btn-layerClose {
    display: inline-block;
    height: 33px;
    padding: 0 14px 0;
    border: 1px solid #3b5998;
    background-color: #3b5998;
    font-size: 13px;
    color: #fff;
    line-height: 30px;
}

a.btn-layerClose:hover {
  border: 1px solid #091940;
  /* background-color: #1f326a; */
  color: #fff;
}

a.btn-layerClose2 {
    display: inline-block;
    height: 33px;
    padding: 0 14px 0;
    border: 1px solid #999;
    background-color: #ffffff;
    font-size: 13px;
    color: #333;
    line-height: 30px;
}

a.btn-layerClose2:hover {
  border: 1px solid #091940;
  /* background-color: #1f326a; */
  color: #333;
}
</style>
<script type="text/javascript">
history.navigationMode = 'compatible'; // 오페라, 사파리 뒤로가기 막기
function _no_Back(){window.history.forward(0);}
</script>
<body onload="_no_Back();" onpageshow="if(event.persisted)_no_Back();">
</body>

<form:form modelAttribute="frontBoardVo" name="board" id="board" method="post" action="${post_url}" >

<div class="board-wrap">
	<article class="board-view">
		<p class="board-date fGray"><c:out value="${view.bbsdatereg}" /> <%-- <span class="bar">|</span> <spring:message code="text.views"/> : <fmt:formatNumber type="number" groupingUsed="true" value="${view.bbshit}" /> --%></p>
		<h4>
		<c:if test="${cateyn=='1'}">
			<c:if test="${not empty cateList}">
				[<c:out value="${fn:join(cateList, '&nbsp;&nbsp;&gt;&nbsp;&nbsp;')}" escapeXml="false" />]
			</c:if>
		</c:if>
		<c:out value="${view.bbstitle}" escapeXml="false" /></h4>
		
		<c:if test="${not empty filelist}">
		<div class="file-attach">
			<c:forEach items="${filelist}" var="data" varStatus="status">
			<c:set var="filetype" value="file"/>
			<c:choose>
				<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'BMP' || fn:toUpperCase(data.bbsfileicon) eq 'JPG' || fn:toUpperCase(data.bbsfileicon) eq 'GIF' || fn:toUpperCase(data.bbsfileicon) eq 'PNG'}">
					<c:set var="filetype" value="image"/>
				</c:when>
				<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'HWP'}">
					<c:set var="filetype" value="hwp"/>
				</c:when>
				<c:when test="${fn:toUpperCase(data.bbsfileicon) eq 'XLS' || fn:toUpperCase(data.bbsfileicon) eq 'XLSX'}">
					<c:set var="filetype" value="excel"/>
				</c:when>
			</c:choose>
				<a href="#none" onclick="return submitForm(this,'down',${data.fno},'')" class="file-name ${filetype }"><c:out value="${data.forg}" /></a>
			</c:forEach>
		</div>
		</c:if>
		<div class="board-contents"><c:out value="${view.bbsconts}" escapeXml="false" /></div>
	</article>
	
	<%-- <div class="comment">
		<c:if test="${not empty commentlist}" >
		<c:forEach items="${commentlist}" var="data" varStatus="status">
		<ul class="comments">
			<li>
				<div>
					<strong><c:if test="${empty data.bbsusername}" >-</c:if>${data.bbsusername}</strong>
					<fmt:parseDate value="${data.bbsdatereg}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
					<fmt:formatDate type="date" value="${isoDate}" pattern="yyyy-MM-dd HH:mm" />
					<a href="#none" onclick="return submitForm(this,'commentdel',${data.bbsno},${view.bbsno})"><img src="/skin/board/${skin}/image/btn_delete03.gif" alt="댓글 삭제" /></a>
				</div>
				<p><c:out value="${data.bbsconts}" escapeXml="false" /></p>
			</li>
		</ul>
		</c:forEach>
		</c:if>
		<c:if test="${sessionScope.frontAuthPassport.role_c ne '0'}">
		<p class="common">서로에 대한 배려있는 답글은 네티켓의 기본입니다.</p>
		<div class="common">
			<div>
				<textarea name="bbsconts" rows="2" cols="40"></textarea>
				<span><em>0</em>/300자</span>
			</div>
			<a href="#none" onclick="return submitForm(this,'comment',${view.bbsno})"><img src="/skin/board/${skin}/image/btn_enro.gif" alt="댓글 등록" /></a>
		</div>
		</c:if>
	</div> --%>
	
	
	<c:if test="${not empty commentlist}" >
	<c:forEach items="${commentlist}" var="data" varStatus="status">
	<article class="board-view reply">
		<strong class="title-header"><spring:message code="text.answer.ext"/></strong>
		<p class="board-date fGray">
		<fmt:parseDate value="${data.bbsdatereg}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
		<fmt:formatDate type="date" value="${isoDate}" pattern="yyyy-MM-dd HH:mm" />
		</p>
		<h4><spring:message code="text.pic"/> : <c:if test="${empty data.bbsusername}" >-</c:if>${data.bbsusername}</h4>
		<div class="board-contents"><c:out value="${data.bbsconts}" escapeXml="false" /></div>
	</article>
	<c:if test="${sessionScope.zUserVo.userid eq 'admin'}">
		<div class="btns-box ar">
			<a href="#none" class="btn-basic"  onclick="return submitForm(this,'commentdel',${data.bbsno},${view.bbsno})">답변삭제</a>
		</div>
	</c:if>
	</c:forEach>
	</c:if>
	<c:if test="${sessionScope.frontAuthPassport.role_c ne '0'}">
	<br />
	<div class="tbl-box">
		<fieldset>
			<legend>게시물 작성 폼</legend>
			<table class="tbl-type01">
			<caption>게시물 정보 입력</caption>
			<colgroup><col style="width:180px"><col style="width:*"></colgroup>
			<tbody>
				<tr>
					<th><label for="lb-manager"><spring:message code="text.pic"/></label></th>
					<td>
						<input type="text" id="lb-manager" name="commentusrnm" class="w30p">
					</td>
				</tr>
				<tr>
					<th><label for="lb-content"><spring:message code="text.answer"/></label></th>
					<td>
						<textarea name="bbsconts"></textarea>
					</td>
				</tr>
			</tbody>
			</table>
		</fieldset>
	</div>
	<div class="btns-box ar">
		<!-- <a href="qna.html" class="btn-basic border">취소</a> -->
		<a href="#none" class="btn-basic" onclick="return submitForm(this,'comment',${view.bbsno})">답변등록</a>
	</div>
	</c:if>
	<div class="btns-box ar">
		<c:if test="${sessionScope.frontAuthPassport.role_d ne '0'}">
			<a href="#none" onclick=
			<c:choose>
				<c:when test="${sessionScope.zUserVo.userid eq 'admin'}">
					"return submitForm(this,'delete', ${view.bbsno})"
				</c:when>
				<c:otherwise>
					"return confirmyn(this,'delete', ${view.bbsno})"
				</c:otherwise>
			</c:choose>
			class="btn-basic border"><spring:message code="button.delete"/></a>
		</c:if>
		<c:if test="${sessionScope.frontAuthPassport.role_m ne '0'}">
			<a href="#none" onclick=
			<c:choose>
				<c:when test="${sessionScope.zUserVo.userid eq 'admin'}">
					"return submitForm(this,'edit', ${view.bbsno})"
				</c:when>
				<c:otherwise>
					"return confirmyn(this,'edit', ${view.bbsno})"
				</c:otherwise>
			</c:choose>
			 class="btn-basic gray"><spring:message code="button.update"/></a>
		</c:if>
		<%-- <c:if test="${sessionScope.frontAuthPassport.role_r ne '0'}">
			<a href="#none" onclick="return submitForm(this,'reply',${view.bbsno})" class="btn-basic gray">답변</a>
		</c:if> --%>
		<c:if test="${1==2}">
			<a href="#none" onclick="return submitForm(this,'approval',${view.bbsno})" class="btn-basic">승인</a>
		</c:if>
			<a href="#none" onclick="return submitForm(this,'list',${view.bbsno})" class="btn-basic"><spring:message code="button.list"/></a>
		
	</div>
</div>
<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="cates" value="${cates}" />
<input type="hidden" name="key" value="${key}" />
<input type="hidden" name="keyword" value="${keyword}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="pageIndex" value="${pageIndex}" />
<input type="hidden" name="subname" id="subname" value="${subname}" />
<input type="hidden" name="boardno" id="boardno" value="${boardno }" />
<input type="hidden" name="no" id="no" value="${boardno }" />
</form:form>
<script language="javascript">
   document.title = "${view.bbstitle}:글읽기 > "+document.title;
</script>
<div class="dim-layer">
    <div class="dimBg"></div>
    <div id="layer2" class="pop-layer">
        <div class="pop-container">
            <div class="pop-conts">
                <!--content //-->
                <div>
					<label for="bbspasswd"><spring:message code="cop.password"/> : </label>
					<input name="bbspasswd" id="bbspasswd" type="password" style="width:160px; padding:2px;" maxlength="10" onkeypress="if(event.keyCode==13){$('#ChkPasswd').click()};" />
					<a href="#" name="ChkPasswd" id="ChkPasswd"  class="btn-layerClose"><spring:message code="button.confirm"/></a>&nbsp;<a href="#" name="RCancel" id="RCancel" class="btn-layerClose2"><spring:message code="button.cancel"/></a>
				</div>
                <!--// content-->
            </div>
        </div>
    </div>
</div>
