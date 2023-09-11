<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<div class="contents">
	<h2>통합검색</h2>
	<%-- <div class="board_search pl10 pr10">
		<fieldset>
			<div class="select_box">
				<select name="key" title="검색 옵션 선택">
				  <option value="센터공지">센터공지</option>				
				  <option value="채용정보">채용정보</option>
				  <option value="입찰공고">입찰공고</option>
				  <option value="보도자료">보도자료</option>
				  <option value="입찰공고">유관기관공지</option>
				  <option value="입찰공고">입찰공고</option>
				  <option value="활동이모저모">활동이모저모</option>
				</select>
			 </div>
			<label class="w60 btn_block">
			<input type="text" id="keyword" name="keyword" value="${input.keyword }" title="검색어를 입력해주세요." placeholder="검색어를 입력하세요.">
			<a href="#none" onclick="return submitForm(this,'list',1)">검색</a></label>
		</fieldset>
	</div> --%>
	<%-- <nav class="search-tab bbs"> 
		<a href="#none" class="on">통합검색</a>
		<c:forEach var="data" items="${zboardList}" varStatus="loop">
			<c:if test="${fn:length(data.boardlist) > 0}">
			<c:set var="boardtitle" value="${fn:split(data.boardtitle,'>') }"/>
			<a href="?menuno=${param.menuno }&">${boardtitle[fn:length(boardtitle)-1]}</a>
			</c:if>
		</c:forEach>
	</nav> --%>
	<c:set var="total" value="0"/>
	<c:forEach var="data" items="${zboardList}" varStatus="loop">
		<c:if test="${fn:length(data.boardlist) > 0}">
			<c:set var="total" value="${total +  fn:length(data.boardlist)}"/>
		</c:if>
	</c:forEach>
	<p class="text-box02 mt50">
		<em class="color_red">[${input.keyword }]</em>에 관한 검색 결과 <em class="color_red"> ${total }</em>건이 검색되었습니다.
	</p>
	<c:forEach var="zboardList" items="${zboardList}" varStatus="loop">
		<c:if test="${fn:length(zboardList.boardlist) > 0}">
		
			<c:set var="boardtitle" value="${fn:split(zboardList.boardtitle,'>') }"/>
			<c:set var="menuno"/>
			<strong class="search_title mt10">${boardtitle[fn:length(boardtitle)-1]} (${fn:length(zboardList.boardlist)}건)</strong>
			<ul class="board-list">
				<c:forEach var="each" items="${zboardList.boardlist}" varStatus="loop">
					<c:if test="${loop.count < 4 }">
					<li>
						<article class="all">
							<h4>
								<a href="?menuno=${each.menuno }&cateno=${each.bbscatenos}&bbsno=${each.bbsno}&boardno=${each.boardno}&siteno=${each.siteno}&act=view" target="_blank" title="새창에서 열림">${each.bbstitle}
								<em class="date">
								<fmt:parseDate value="${each.bbsdatereg}" pattern="yyyyMMddHHmmss" var="dDate"/>
		                        <fmt:formatDate var="regdate" value="${dDate}" pattern="yyyy.MM.dd"/>
								[${regdate}]</em></a>
								<span class="iconnone"></span>
								<ul class="location tmg10">
									<li>${zboardList.boardtitle }</li>
									<!-- <li>센터소식</li>
									<li><strong>센터공지</strong></li> -->
								</ul>
							</h4>
						</article>
					</li>
					<c:set var="menuno" value="${each.menuno}"/>
					</c:if>
				</c:forEach>
			</ul>
			<c:if test="${fn:length(zboardList.boardlist) > 3 }">
			<a class="mt20 btm_more" href="?menuno=${menuno }&key=community&keyword=${input.keyword}" target="_blank"><span>더 보기</span></a>	
			</c:if>
		</c:if>
	</c:forEach>
</div>