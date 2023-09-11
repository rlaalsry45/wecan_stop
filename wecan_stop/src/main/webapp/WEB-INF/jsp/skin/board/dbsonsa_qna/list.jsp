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
<form:form modelAttribute="frontBoardVo" name="board" id="board" method="post" action="${post_url}" >

<div class="board-wrap">
	<c:if test="${not empty map }">
	<nav class="search-tab qna"> 
		<a href="?menuno=${param.menuno }" <c:if test="${param.cates eq null || param.cates eq ''}">class="on"</c:if>>전체</a>
		<c:forEach var="catelist" items="${map}" varStatus="status">
			<c:set var="cno" value="${cates[status.index]}" />
			<c:forEach items="${catelist.value}" var="data">
				<a href="?menuno=${param.menuno }&cates=${data.cno}" <c:if test="${param.cates eq data.cno }">class="on"</c:if>>${data.cname}</a>
			</c:forEach>
		</c:forEach>
	</nav>
	</c:if>
	<c:if test="${input.total+nCount!=0}"><p class="total">현재 ${input.pageIndex}/${input.pageMax}페이지 <span class="bar">|</span> 총${input.total }건</p></c:if>
	<ul class="board-list qna">
	<c:forEach items="${list}" var="data" varStatus="status">
		<li<c:if test="${data.bbsnotice=='1'}"> class="notice"</c:if>>
			<span class="no"><c:if test="${data.bbsnotice=='0'}"><c:out value="${input.total+nCount-(input.pageIndex-1)*input.pageSize-status.index}" /></c:if></span>
			<article>
				<p class="board-date fGray"><c:out value="${data.bbsreg}" /> <%-- <span class="bar">|</span> <spring:message code="text.views"/> : <fmt:formatNumber type="number" groupingUsed="true" value="${data.bbshit}" /> --%>
				<c:if test="${data.fnos>0}" ><a href="" class="file-name icon file">첨부파일</a></c:if>
				</p>
				<h4>
					<c:if test="${cateyn=='1'}">
						<c:if test="${not empty data.catenames}">
							<strong>[<c:out value="${fn:join(data.catenames, '&nbsp;&nbsp;&gt;&nbsp;&nbsp;')}" escapeXml="false" />]</strong>
						</c:if>
					</c:if>
					<c:if test="${data.bbsopen==0}">
						<c:choose>
							<%-- <c:when test="${sessionScope.zUserVo.userid eq 'admin'}"> --%>
							<c:when test="${sessionScope.frontAuthPassport.role_c ne '0'}">
							
								<a href="#none" onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}">
							</c:when>
							<c:otherwise>
								<a href="#none" onclick="return confirmyn(this,'view',${data.bbsno});" title="${data.bbstitle}">
							</c:otherwise>
						</c:choose>
						<c:if test="${data.bbsnotice=='1'}"><strong class="fPointC">[공지]</strong></c:if> 
						<subs:substringOut str='${data.bbstitle}' length='${titlelen}' endChar='...'/>		
						</a>
					</c:if>
					<c:if test="${data.bbsopen==1}">
					<a href="#none" onclick="return submitForm(this,'view',${data.bbsno});" title="${data.bbstitle}">
						<c:if test="${data.bbsnotice=='1'}"><strong class="fPointC">[공지]</strong></c:if> 
						<subs:substringOut str='${data.bbstitle}' length='${titlelen}' endChar='...'/>
					</a>
					</c:if>
					<c:if test="${data.bbsnew=='1'}"><img src='/usr/skin/board/${skin}/image/icon_new.gif' border=0 alt="새글입니다." /></c:if>
					<c:if test="${data.bbsopen==0}"><span class="ico secret">비밀글</span></c:if>
				</h4>
				<c:if test="${data.bbslevel==0}"><c:if test="${data.commentYN eq 'N'}"><span class="btn-status">답변대기</span></c:if><c:if test="${data.commentYN eq 'Y'}"><span class="btn-status end">답변완료</span></c:if></c:if>
			</article>
		</li>
	</c:forEach>
	<c:if test="${input.total+nCount==0}">
		<li>기록이 없습니다.</li>
	</c:if>
	</ul>
	<ptBBS:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
	<c:if test="${sessionScope.frontAuthPassport.role_w ne '0'}">
		<div class="btns-box ar">
			<a href="#none" onclick="return submitForm(this,'write',0)" class="btn-basic">등록</a>
		</div>
	</c:if>
	<div class="board-search-box border-box">
		<div class="select-box">
			<label for="lb-search">제목 + 내용</label>
			<select name="key" id="lb-search" title="제목,작성자, 내용 중 항목선택">
				<option value='bbstitle' <c:if test="${input.key=='bbstitle'}">selected</c:if>>제목</option>
				<option value='bbsusername' <c:if test="${input.key=='bbsusername'}">selected</c:if>>작성자</option>
				<option value='bbsconts' <c:if test="${input.key=='bbsconts'}">selected</c:if>>내용</option>
				<!-- <option selected="selected">제목 + 내용</option> -->
			</select>
		</div>
		<input type="text" class="w40p" name="keyword" value="${input.keyword}" placeholder="검색어를 입력해 주세요" title="검색어를 입력해 주세요">
		<input type="submit" value="검색" class="btn-search" onclick="return submitForm(this,'list',1)"/>
	</div>
</div>
<input type="hidden" name="ztag" value="${ztag}" />
<input type="hidden" name="siteno" value="${siteno}" />
<input type="hidden" name="page" value="${input.pageIndex}" />
<input type="hidden" name="no" id="no" value="${boardno }" />
<input type="hidden" name="boardno" id="boardno" value="${boardno }" />
<input type="hidden" name="cates" value="${input.cates }" />
</form:form>

<div class="dim-layer">
    <div class="dimBg"></div>
    <div id="layer2" class="pop-layer">
        <div class="pop-container">
            <div class="pop-conts">
                <!--content //-->
                <div>
					<label for="bbspasswd">패스워드 : </label>
					<input name="bbspasswd" id="bbspasswd" type="password" style="width:160px; padding:2px;" maxlength="10" onkeypress="if(event.keyCode==13){$('#ChkPasswd').click()};" />
					<a href="#" name="ChkPasswd" id="ChkPasswd"  class="btn-layerClose">확인</a>&nbsp;<a href="#" name="RCancel" id="RCancel" class="btn-layerClose2">취소</a>
				</div>
                <!--// content-->
            </div>
        </div>
    </div>
</div>