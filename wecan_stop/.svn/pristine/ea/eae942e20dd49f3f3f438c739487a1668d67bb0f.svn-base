<%@ page contentType="text/html;charset=utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<script type="text/javascript">
function openbannerLink(link,typ){

	if(typ=='2'){
		window.open(link ,'_self','');
	}else{
		window.open(link ,'_blank','');
	}

}
$(function(){
	<c:if test="${input.cateno ne null}">
	$("#${input.cateno}").focus();
	</c:if>
	<c:if test="${input.cate eq 'all'}">
	$("#all").focus();
	</c:if>
});


</script>

<c:if test="${subname eq null}">
	<section class="main-contents main-goods">
		<div class="inner-wrap">
			<h2>우수문화상품</h2>
			<p>우수문화상품은 현재 ${input.total }개 지정되어 있습니다.</p>

			<ul class="main-goods-list">

				<c:forEach var="each" items="${list }" varStatus="loop">
					<c:set var="imagename" value="${each.place}" />
					<c:set var="explainTxt" value="${each.sponsor}" />
					<c:if test="${each.goal ne null}">
						<c:set var="explainTxt" value="${each.goal}" />
					</c:if>

					<c:choose>
						<c:when test="${loop.index eq '5' }">
							<c:set var="imagename" value="${each.etc2}" />
							<c:set var="explainTxt" value="${each.etc1}" />
							<c:if test="${each.etc3 ne null}">
								<c:set var="explainTxt" value="${each.etc3}" />
							</c:if>
						</c:when>
						<c:when test="${loop.index eq '4' }">
							<c:set var="imagename" value="${each.etc5}" />
							<c:set var="explainTxt" value="${each.etc4}" />
							<c:if test="${each.etc3 ne null}">
								<c:set var="explainTxt" value="${each.etc6}" />
							</c:if>
						</c:when>
					</c:choose>
					<c:set var="menuno"/>
					<c:set var="cateflag"/>
					<c:if test="${each.bbscatenos eq '656' }"><c:set var="menuno" value="12"/><c:set var="cateflag" value="A"/></c:if>
					<c:if test="${each.bbscatenos eq '657' }"><c:set var="menuno" value="13"/><c:set var="cateflag" value="B"/></c:if>
					<c:if test="${each.bbscatenos eq '658' }"><c:set var="menuno" value="14"/><c:set var="cateflag" value="C"/></c:if>
					<c:if test="${each.bbscatenos eq '659' }"><c:set var="menuno" value="15"/><c:set var="cateflag" value="D"/></c:if>
					<c:if test="${each.bbscatenos eq '660' }"><c:set var="menuno" value="16"/><c:set var="cateflag" value="E"/></c:if>

					<li<c:if test="${loop.index eq '4' }"> class="column_2"</c:if><c:if test="${loop.index eq '5' }"> class="row_2"</c:if>>
						<div><a href="?menuno=${menuno }&cateno=${each.bbscatenos }&bbsno=${each.bbsno}&boardno=${each.boardno}&siteno=${each.siteno}&act=view&cateflag=${cateflag}"><img src="/usr/upload/board_thumb/${tblname}/${imagename}" alt="${explainTxt}" /></a></div>
					</li>
				</c:forEach>

				<!-- <li><div><img src="/images/main/goods01.jpg" alt=""></div></li>
				<li><div><img src="/images/main/goods02.jpg" alt=""></div></li>
				<li><div><img src="/images/main/goods03.jpg" alt=""></div></li>
				<li><div><img src="/images/main/goods04.jpg" alt=""></div></li>
				<li class="column_2"><div><img src="/images/main/goods05.jpg" alt=""></div></li>
				<li class="row_2"><div><img src="/images/main/goods06.jpg" alt=""></div></li>
				<li><div><img src="/images/main/goods07.jpg" alt=""></div></li>
				<li><div><img src="/images/main/goods08.jpg" alt=""></div></li> -->
			</ul>

			<!--<div class="btns-introduction">
				<a href="/?menuno=12&cateno=656">우수문화상품 더보기</a>
				<a onclick="alert('링크를 알려주시기 바랍니다.');" href="#none">쇼핑몰 바로가기</a>
			</div>-->
		</div>
	</section>


</c:if>


<c:if test="${subname ne null}">
	<!-- section 03 -->
	<div class="inner-wrap main-section03">
		<h2>Excellent <br><strong>Cultural <br>Products </strong><br>IN KOREA</h2>
		<nav>
			<ul>

			<c:set var="cate1"/>
			<c:set var="cate2"/>
			<c:set var="cate3"/>
			<c:set var="cate4"/>
			<c:set var="cate5"/>

			<c:if test="${subname eq 'eng'}">
				<c:set var="cate1" value="675"/>
				<c:set var="cate2" value="676"/>
				<c:set var="cate3" value="677"/>
				<c:set var="cate4" value="678"/>
				<c:set var="cate5" value="679"/>
			</c:if>
			<c:if test="${subname eq 'chn'}">
				<c:set var="cate1" value="687"/>
				<c:set var="cate2" value="688"/>
				<c:set var="cate3" value="689"/>
				<c:set var="cate4" value="690"/>
				<c:set var="cate5" value="691"/>
			</c:if>
			<c:if test="${subname eq 'jpn'}">
				<c:set var="cate1" value="699"/>
				<c:set var="cate2" value="700"/>
				<c:set var="cate3" value="701"/>
				<c:set var="cate4" value="702"/>
				<c:set var="cate5" value="703"/>
			</c:if>

				<li<c:if test="${input.cateno eq null}"> class="on"</c:if>><a href="/${subname}/index.html?cate=all" id="all"><spring:message code="text.all"/></a></li>
				<li<c:if test="${input.cateno eq cate1 }"> class="on"</c:if>><a href="/${subname}/index.html?cateno=${cate1}" id="${cate1}"><spring:message code="text.food"/></a></li>
				<li<c:if test="${input.cateno eq cate2 }"> class="on"</c:if>><a href="/${subname}/index.html?cateno=${cate2}" id="${cate2}"><spring:message code="text.koreafood"/></a></li>
				<li<c:if test="${input.cateno eq cate3 }"> class="on"</c:if>><a href="/${subname}/index.html?cateno=${cate3}" id="${cate3}"><spring:message code="text.handicrafe"/></a></li>
				<li<c:if test="${input.cateno eq cate4 }"> class="on"</c:if>><a href="/${subname}/index.html?cateno=${cate4}" id="${cate4}"><spring:message code="text.hanbok"/></a></li>
				<li<c:if test="${input.cateno eq cate5 }"> class="on"</c:if>><a href="/${subname}/index.html?cateno=${cate5}" id="${cate5}"><spring:message code="text.cultral"/></a></li>
			</ul>
		</nav>

		<section class="main-goods-contents">

			<c:forEach var="data" items="${list }" varStatus="loop">
				<c:set var="imagename" value="${each.etc5}" />
				<c:if test="${imagename eq null}">
					<c:set var="imagename" value="${each.place}" />
				</c:if>

				<c:set var="explainTxt" value="${each.etc4}" />
				<c:if test="${each.goal ne null}">
					<c:set var="explainTxt" value="${each.goal}" />
				</c:if>

				<article class="main-goods-block">
					<div class="thumb">
					<img src="/usr/upload/board_thumb/${tblname}/${imagename}"  alt="${explainTxt}" /></div>

					<c:set var="menuno"/>
					<c:set var="menuname"/>
					<c:set var="menutype"/>
					<c:set var="cateflag"/>
					<c:if test="${each.bbscatenos eq '656' || each.bbscatenos eq '675' || each.bbscatenos eq '687' || each.bbscatenos eq '699' }">
						<c:set var="menuno" value="12"/>
						<c:set var="menuname" value="FOOD"/>
						<c:set var="menutype" value="type01"/>
						<c:set var="cateflag" value="A"/>
					</c:if>
					<c:if test="${each.bbscatenos eq '657' || each.bbscatenos eq '676' || each.bbscatenos eq '688' || each.bbscatenos eq '700' }">
						<c:set var="menuno" value="13"/>
						<c:set var="menuname" value="KOREA FOOD"/>
						<c:set var="menutype" value="type02"/>
						<c:set var="cateflag" value="B"/>
					</c:if>
					<c:if test="${each.bbscatenos eq '658' || each.bbscatenos eq '677' || each.bbscatenos eq '689' || each.bbscatenos eq '701' }">
						<c:set var="menuno" value="14"/>
						<c:set var="menuname" value="HANDICRAFT"/>
						<c:set var="menutype" value="type03"/>
						<c:set var="cateflag" value="C"/>
					</c:if>
					<c:if test="${each.bbscatenos eq '659' || each.bbscatenos eq '678' || each.bbscatenos eq '690' || each.bbscatenos eq '702' }">
						<c:set var="menuno" value="15"/>
						<c:set var="menuname" value="HANBOK"/>
						<c:set var="menutype" value="type04"/>
						<c:set var="cateflag" value="D"/>
					</c:if>
					<c:if test="${each.bbscatenos eq '660' || each.bbscatenos eq '679' || each.bbscatenos eq '691' || each.bbscatenos eq '703' }">
						<c:set var="menuno" value="16"/>
						<c:set var="menuname" value="CULTURAL CONTENT"/>
						<c:set var="menutype" value="type01"/>
						<c:set var="cateflag" value="E"/>
					</c:if>

					<div class="description ${menutype }">
						<dl>
							<dt><em>${menuname }</em><p>${each.bbstitle }</p></dt>
							<dd>${each.bbsconts }</dd>
						</dl>
						<a href="?menuno=${menuno }&cateno=${each.bbscatenos }&bbsno=${each.bbsno}&boardno=${each.boardno}&siteno=${each.siteno}&act=view&cateflag=${cateflag}">Detail</a>
					</div>
				</article>

			</c:forEach>
		</section>
		<!--a href="" class="btn-more"><span>MORE</span></a-->
	</div>
	<!--// section 03 -->


</c:if>



