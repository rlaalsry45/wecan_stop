<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
$(document).ready(function(){

	$(".cmenu>span>a").click(function(){
        var submenu = $(this).parent().next("ul");
        $("#eqindex").val($(".cmenu>span>a").index(this));//몇번째 menu가 열렸는지 값을 저장(파라미터로 넘겨주기 위함)
        if( submenu.is(":visible") ){
        	$(this).parent().parent("li").removeClass('cmenu on').addClass('cmenu');
        	$(".cmenu>span>a").children().attr('src','/usr/image/common/btn/on.gif');
			$(".cmenu>span>a").children().attr('alt','메뉴펼침');
            submenu.slideUp();
        }else{
        	$(".cmenu .hide").slideUp("fast");
        	$(".cmenu .hide").parent("li").removeClass('cmenu on').addClass('cmenu');
			$(".cmenu>span>a").children().attr('src','/usr/image/common/btn/on.gif');
			$(".cmenu>span>a").children().attr('alt','메뉴펼침');
        	$(this).parent().parent("li").removeClass('cmenu').addClass('cmenu on');
        	$(this).children().attr('src','/usr/image/common/btn/off.gif');
			$(this).children().attr('alt','메뉴닫음');
        	submenu.slideDown("fast");
        }
    });
	$(".cmenu:eq(${eqindex})>span>a").click();

});

function getEQandPath(url){
	//alert(url+"&eqindex="+$("#eqindex").val());
	window.location.href=url+"&eqindex="+$("#eqindex").val();

}
</script>
<style>
    .cmenu a{cursor:pointer;}
    .cmenu .hide{display:none;max-height:280px;padding-buttom:10px;overflow: auto;}

</style>
<input type="hidden" id="eqindex" value="" />
<div id="lnb">
	<c:set var="prelevel" value="0" />
	<c:forEach items="${list}" var="each" varStatus="loop">


<c:if test="${each.level ==1}">

		<h2>
		<em>Korea Planning Association</em>
		<strong>${each.name}</strong></h2>
		<ul class="lnb">
</c:if>




<c:if test="${each.level ==2 && loop.index==1}"><!-- 한국학 -->
		<li class="cmenu">
			<span ><a href="javascript:void(0);">${each.name }<img class="onoff" src="/usr/image/common/btn/on.gif" alt="메뉴펼침" /></a></span>
			<ul class="hide">
</c:if>
<c:if test="${each.level ==2 && loop.index!=1 && prelevel ==3}">
					</ul>
				</li>
			</ul>
		</li>
		<li class="cmenu">
			<span ><a href="javascript:void(0);">${each.name }<img class="onoff" src="/usr/image/common/btn/on.gif" alt="메뉴펼침" /></a></span>
			<ul class="hide">
</c:if>
<c:if test="${each.level ==2 && loop.index!=1 && prelevel ==4}">
					</ul>
				</li>
			</ul>
		</li>
		<li class="cmenu">
			<span ><a href="javascript:void(0);">${each.name }<img class="onoff" src="/usr/image/common/btn/on.gif" alt="메뉴펼침" /></a></span>
			<ul class="hide">
</c:if>
<c:if test="${each.level ==2 && loop.index!=1 && prelevel == 2}">
			</ul>
		</li>
		<li class="cmenu">
			<span ><a href="javascript:void(0);">${each.name }<img class="onoff" src="/usr/image/common/btn/on.gif" alt="메뉴펼침" /></a></span>
			<ul class="hide">
</c:if>





<c:if test="${each.level ==3 && loop.index==2}"><!-- 강좌운영 -->
				<li class="first">
					<strong><a href="javascript:void(0);" onclick="getEQandPath('/?menuno=${menuno}&path=${each.path}&lang=${lang}')">${each.name}</a></strong>
					<ul>
</c:if>
<c:if test="${each.level ==3 && loop.index!=2 && prelevel ==2}">
				<li>
					<strong><a href="javascript:void(0);" onclick="getEQandPath('/?menuno=${menuno}&path=${each.path}&lang=${lang}')">${each.name}</a></strong>
					<ul>
</c:if>
<c:if test="${each.level ==3 && loop.index!=2 &&prelevel !=2}">
					</ul>
				</li>
				<li>
					<strong><a href="javascript:void(0);" onclick="getEQandPath('/?menuno=${menuno}&path=${each.path}&lang=${lang}')">${each.name}</a></strong>
					<ul>
</c:if>





<c:if test="${each.level ==4}">
						<li <c:if test="${path eq each.path}">class="on"</c:if>><a href="javascript:void(0);" onclick="getEQandPath('/?menuno=${menuno}&path=${each.path}&lang=${lang}')">${each.name }</a></li>
</c:if>
	<c:set var="prelevel" value="${each.level }" />
	</c:forEach>
<c:if test="${prelevel ==4}">
					</ul>
				</li>
			</ul>
		</li>
	</ul>
</c:if>
<c:if test="${prelevel ==3}">
				</li>
			</ul>
		</li>
	</ul>
</c:if>
<c:if test="${prelevel ==2}">
			</ul>
		</li>
	</ul>
</c:if>
</div>
</div>
