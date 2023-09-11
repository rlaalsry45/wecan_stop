<!-- 전시,공연,강좌 리스트 jsp -->
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>

<%-- <div class="location">
	<c:set var="text" value="${fn:split(archvCatgryNameList,'>')}" />
	${fn:replace(archvCatgryNameList,text[fn:length(text)-1],'')}
	<strong>${text[fn:length(text)-1] }</strong>
</div> --%>

<ul class="progress">
	<c:forEach items="${list}" var="each" varStatus="loop">
	<li>
		<a href="/?menuno=${menuno}&type=view&archv_no=${each.archv_no}&pageIndex=${input.pageIndex}&path=${path}&tab=${tab}" class="img">
		<img width="161" height="122" src="${image_path_thbnail}/${each.thbnail}" onError="this.src='${image_path_thbnail}/noimg.gif'" alt="${each.title}" />
	</a>
		<div>
			<strong><a href="/?menuno=${menuno}&type=view&archv_no=${each.archv_no}&pageIndex=${input.pageIndex}&path=${path}&tab=${tab}">[문화센터/전시]${each.title}</a></strong>
			<p>한국-아일랜드 수교 30주년 기념 사진을 통해 바라본 양국이 공유한 이야기</p>
			<ul>
				<li>행사기간 : 04.03(수)~04.13(토)</li>
				<li>신청기간 : 04.03(수)~04.13(금)</li>
				<li>당첨발표 : 04.14(토)</li>
			</ul>
			<a href="javascript:cnjOpen('/popup/popup01.html','cnjopen',776,592)" class="btn" title="새창으로 열기"><img src="/usr/image/common/btn/btn_app02.gif" alt="신청하기" /></a>
		</div>
	</li>
	</c:forEach>
</ul>
<div class="paging">
	<a href="#" class="btn first"><img src="/usr/image/common/btn/paging_first.gif" alt="처음 페이지로" /></a>
	<a href="#" class="btn"><img src="/usr/image/common/btn/paging_prev.gif" alt="전 페이지로" /></a>
	<strong>1</strong>
	<a href="#">2</a>
	<a href="#">3</a>
	<a href="#">4</a>
	<a href="#">5</a>
	<a href="#">6</a>
	<a href="#">7</a>
	<a href="#">8</a>
	<a href="#">9</a>
	<a href="#">10</a>
	<a href="#" class="btn"><img src="/usr/image/common/btn/paging_next.gif" alt="다음 페이지로" /></a>
	<a href="#" class="btn"><img src="/usr/image/common/btn/paging_last.gif" alt="마지막 페이지로" /></a>
</div>
					<div class="c-sns">
	<a href="#"><img src="/usr/image/common/icon/icon_twitter03.gif" alt="트위터" /></a>
	<a href="#"><img src="/usr/image/common/icon/icon_facebook03.gif" alt="페이스북" /></a>
	<a href="#"><img src="/usr/image/common/icon/icon_wifi.gif" alt="RSS" /></a>
	<a href="#"><img src="/usr/image/common/icon/icon_print.gif" alt="프린트" /></a>
</div><!--소셜부분-->
					<div class="file">
	<h4 class="sctit first">관련 자료</h4>
	<ul class="file-list">
		<li class="first last"><a href="javascript:cnjOpen('/popup/popup02.html','cnjopen',776,592)" title="새창으로 열기">아카이브 계획 상세보기</a></li>
		<li class="last"><a href="/business/school_per.html">아카이브 실적 상세보기</a></li>
	</ul>
	<h4 class="sctit">관련 문서</h4>
	<ul class="file-list">
		<li class="first last"><a href="/business/school_plan.html">아카이브 문서 자료01</a></li>
		<li class="last"><a href="/business/school_per.html">아카이브 문서 자료02</a></li>
	</ul>
	<h4 class="sctit">관련 사진</h4>
	<ul class="file-list">
		<li class="first last"><a href="/business/school_plan.html">아카이브 사진 자료01</a></li>
		<li class="last"><a href="/business/school_per.html">아카이브 사진 자료02</a></li>
	</ul>
	<h4 class="sctit">관련 동영상</h4>
	<ul class="file-list">
		<li class="first last"><a href="/business/school_plan.html">아카이브 동영상 자료01</a></li>
		<li class="last"><a href="/business/school_per.html">아카이브 동영상 자료02</a></li>
	</ul>
</div>
<!--관련 자료-->
<table class="data" summary="담당자,전화,팩스">
	<caption>관련자료 정보</caption>
	<colgroup>
		<col style="width:10%;" />
		<col style="width:23%;" />
		<col style="width:10%;" />
		<col style="width:23%;" />
		<col style="width:10%;" />
		<col style="width:23%;" />
	</colgroup>
	<tbody>
		<tr>
			<th scope="row" class="first">담당자명</th>
			<td>홍길동</td>
			<th scope="row">전화</th>
			<td>+82-2-1234-5678</td>
			<th scope="row">팩스</th>
			<td>+82-2-1234-5678</td>
		</tr>
	</tbody>
</table><!--담당자 정보-->
<div class="select">
	<strong>이 페이지에서 제공하는 정보에 만족하셨습니까?</strong>
	<div>
		<label for="select">매우만족</label>
		<input type="radio" id="select" class="radio" name="select" />
		<label for="select2">만족</label>
		<input type="radio" id="select2" class="radio" name="select" />
		<label for="select3">보통</label>
		<input type="radio" id="select3" class="radio" name="select" />
		<label for="select4">불만</label>
		<input type="radio" id="select4" class="radio" name="select" />
		<label for="select5">매우불만</label>
		<input type="radio" id="select5" class="radio" name="select" />
		<a href="#"><img src="/usr/image/common/btn/btn_conf.gif" alt="확인" /></a>
	</div>
</div><!--만족도-->