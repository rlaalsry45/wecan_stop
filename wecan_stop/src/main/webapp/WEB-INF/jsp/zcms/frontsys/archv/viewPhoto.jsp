<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script language="javascript">
	function openSnsWin(opensns) {
		var winObj;
		winObj = window.open(opensns,"","width=560, height=520, scrollbars=yes, resizable=yes");
	}
	function _sns2(type){

		var snsTitle = encodeURI('<c:out value="${archv.title}" escapeXml="true" />');
		var snsUrl = encodeURIComponent (location.href);

		var snsCopy = encodeURI("한국국제교류재단");
		var opensns = "";

		if(type == "facebook"){
			opensns +="http://www.facebook.com/sharer.php?u="+snsUrl;
			opensns += "&&t="+snsTitle;
			openSnsWin(opensns);
			//window.open(opensns,'blank','width=400px,height=300px');
		}else if(type == "me2day"){
			opensns += "http://me2day.net/posts/new?new_post[body]=";
			opensns += "\""+snsTitle+"\":"+snsUrl;
			opensns += "&new_post[tags]="+snsCopy;
			openSnsWin(opensns);
			//window.open(opensns,'blank','width=400px,height=300px');
		}else if(type == "twitter"){
			opensns += "http://twitter.com/share?url="+snsUrl;
			opensns += "&text="+snsTitle;
			openSnsWin(opensns);
			//window.open(opensns,'blank','width=400px,height=300px');
			//openSnsWin(opensns);
			//BitlyClient.shorten('http://www.dailian.co.kr/news/news_view.htm?id=293718', 'BitlyCB.shortenResponse');
		}else if(type == "wifi"){
			opensns += "http://me2day.net/posts/new?new_post[body]=";
			opensns += "\""+snsTitle+"\":"+snsUrl;
			opensns += "&new_post[tags]="+snsCopy;
			openSnsWin(opensns);
			//window.open(opensns,'blank','width=400px,height=300px');
		}else if(type == "print"){
			document.body.innerHTML = $(".l-cont").html();
			window.print();
		}

	}



</script>
<div class="contents">

	<jsp:include page="/front/archv/lnb.html" flush="true" />
	<script src="/var/galleria/galleria-1.2.9.js"></script>
	 <script type="text/javascript">
		$(function(){
			 $("#photoDown").click(function(){
				window.location.href="/front/archv/downloadFile.html?filetype=P&filename="+$("#photoorg").val();
			 });
		});
	</script>
	<style>
		#galleria{height:600px;}
	</style>
	<script type="text/javascript">
	    // Load the classic theme
	    Galleria.loadTheme('/var/galleria/galleria.classic.min.js');
	    // Initialize Galleria
	    Galleria.run('#galleria');
	</script>
	<div class="cont-right">
	<h3 class="ctit">아카이브</h3>
		<c:if test="${lang==0}"><%@ include file="./include_search.jsp" %></c:if>
		<c:if test="${lang==1}"><%@ include file="./include_search_eng.jsp" %></c:if>
		<ul class="tab03">
				<li class="first">
					<a href="/?menuno=${menuno}&tab=1&path=${path}&eqindex=${eqindex}&lang=${lang}">
						<c:if test="${lang==0}">행사/활동/실적(${archvVO.eventCount })</c:if>
						<c:if test="${lang==1}">Web documents(${archvVO.eventCount })</c:if>
					</a>
				</li>
				<li>
					<a href="/?menuno=${menuno}&tab=2&path=${path}&eqindex=${eqindex}&lang=${lang}">
						<c:if test="${lang==0}">문서(${archvVO.documentCount })</c:if>
						<c:if test="${lang==1}">Documents(${archvVO.documentCount })</c:if>
					</a>
				</li>
				<li class="on">
					<a href="/?menuno=${menuno}&tab=3&path=${path}&eqindex=${eqindex}&lang=${lang}">
						<c:if test="${lang==0}">사진(${archvVO.photoCount})</c:if>
						<c:if test="${lang==1}">Photos(${archvVO.photoCount})</c:if>
					</a>
				</li>
				<li>
					<a href="/?menuno=${menuno}&tab=4&path=${path}&eqindex=${eqindex}&lang=${lang}">
						<c:if test="${lang==0}">동영상(${archvVO.vodCount})</c:if>
						<c:if test="${lang==1}">VOD(${archvVO.vodCount})</c:if>
					</a>
				</li>
			</ul>
		<h3 class="invisible">사진</h3>
		<div class="board-view">
				<div class="btn-c galleria_btn">
					<img id="photoDown" src="/usr/image/common/btn/btn_down.gif" alt="원본파일 다운로드" />
					<input type="hidden" id="photoorg" value="" />
				</div>
				<div id="galleria">
					<c:forEach items="${filelist}" var="filename" varStatus="loop">
						<a href="${image_path_detail}${filename.realname}"><img height="73" src="${image_path_thbnail}${filename.realname}" alt="" /></a>
					</c:forEach>
				</div>
			<h4 class="btit mgt">${archv.title}</h4>
			<table class="board-view" summary="분류, 작성일, 작성자, 조회수">
				<caption>${archv.title}</caption>
				<colgroup>
					<col style="width:9%;" />
					<col style="width:16%;" />
					<col style="width:9%;" />
					<col style="width:46%;" />
					<col style="width:10%;" />
					<col style="width:10%;" />
				</colgroup>
				<tbody>
					<%-- <tr>
						<th scope="row"><span>분류</span></th>
						<td colspan="5">${archv.catgry_name_list }</td>
					</tr> --%>
					<tr>
						<th scope="row">
							<span>
								<c:if test="${lang==0}">게시일</c:if>
								<c:if test="${lang==1}">Date</c:if>
							</span>
						</th>
						<td><fmt:parseDate value="${archv.start_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
							<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
						</td>
						<th scope="row">
							<span>
								<c:if test="${lang==0}">작성자</c:if>
								<c:if test="${lang==1}">Writer</c:if>
							</span>
						</th>
						<td>${archv.reg_nm }</td>
						<th scope="row">
							<span>
								<c:if test="${lang==0}">조회수</c:if>
								<c:if test="${lang==1}">Count</c:if>
							</span>
						</th>
						<td>${archv.archv_cnt}</td>
					</tr>
				</tbody>
			</table>
			<!-- <div class="b-contents"> -->
				${archv.conts }
			<!-- </div> -->
		</div>
		<div class="c-sns">
			<a href="javascript:_sns2('twitter');"><img src="/usr/image/common/icon/icon_twitter03.gif" alt="트위터" /></a>
			<a href="javascript:_sns2('facebook');"><img src="/usr/image/common/icon/icon_facebook03.gif" alt="페이스북" /></a>
			<!-- <a href="javascript:_sns2('wifi');"><img src="/usr/image/common/icon/icon_wifi.gif" alt="RSS" /></a> -->
			<a href="javascript:_sns2('print');"><img src="/usr/image/common/icon/icon_print.gif" alt="프린트" /></a>
		</div>
		<div class="path">
			<c:if test="${lang==0}"><strong class="title">관련 페이지 연결</strong></c:if>
			<c:if test="${lang==1}"><strong class="title">Linked page</strong></c:if>
			<c:forEach items="${archvMenunoPathList}" var="each" varStatus="loop">
				<c:set var="text" value="${fn:split(each.zmenu_title_path,'>')}" />
				<a href="http://${each.sitedomain}/?menuno=${each.menuno}"><div>${fn:replace(each.zmenu_title_path,text[fn:length(text)-1],'')}<strong>${text[fn:length(text)-1] }</strong></div></a>
			</c:forEach>
		</div>
		<ul class="prev-next prev-next2">
			<li class="first">
				<c:if test="${lang==0}"><strong>이전글</strong></c:if>
				<c:if test="${lang==1}"><strong>Prev</strong></c:if>
				<c:if test="${archv.pre_archv_no ==null}">${archv.pre_title }</c:if>
				<c:if test="${archv.pre_archv_no !=null}">
					<a href="/?menuno=${menuno}&type=view&archv_no=${archv.pre_archv_no}&pageIndex=${input.pageIndex}&path=${path}&tab=${tab}&eqindex=${eqindex}&lang=${lang}">
						<subs:substringOut str='${archv.pre_title}' length='100' />
					</a>
				</c:if>
			</li>
			<li>
				<c:if test="${lang==0}"><strong>다음글</strong></c:if>
				<c:if test="${lang==1}"><strong>Next</strong></c:if>
				<c:if test="${archv.next_archv_no ==null}">${archv.next_title }</c:if>
				<c:if test="${archv.next_archv_no !=null}">
					<a href="/?menuno=${menuno}&type=view&archv_no=${archv.next_archv_no}&pageIndex=${input.pageIndex}&path=${path}&tab=${tab}&eqindex=${eqindex}&lang=${lang}">
						<subs:substringOut str='${archv.next_title}' length='100' />
					</a>
				</c:if>
			</li>
		</ul>
		<div class="btn-c">
			<a href="/?menuno=${menuno}&pageIndex=${input.pageIndex}&path=${path}&tab=${tab}&eqindex=${eqindex}&lang=${lang}">
				<c:if test="${lang==0}"><img src="/usr/image/common/btn/btn_list.gif" alt="목록" /></c:if>
				<c:if test="${lang==1}"><img src="/usr/image/common/btn/btn_list.gif" alt="목록" /></c:if>

			</a>
		</div>
	</div>
</div>