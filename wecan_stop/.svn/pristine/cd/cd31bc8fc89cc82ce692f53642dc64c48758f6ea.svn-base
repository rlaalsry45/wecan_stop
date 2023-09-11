<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<c:set var="duesMap" value="${duesCheckMap}" />
<c:set value="${keyword }" var="keyword" />
<c:set value="${author }" var="author" />
<c:set value="${csq }" var="csq" />

<c:set value="${dSubject }" var="dSubject" />
<c:set value="${dAuthor }" var="dAuthor" />
<c:set value="${dKeyword }" var="dKeyword" />
<script type="text/javascript">
$(document).ready(function(){
	<c:if test="${searchType eq  'detailView'}">
		$(".details-search").show();
	</c:if>


	$("#selectSize").change(function(){
		$("#showSize").val($(this).val());

		document.searchPage.submit();

	});

});

function showText(no, type){

	if(type == "allAbstract"){

		 $("p[id^='atcl_abstract_']").each(function() {

			 if($(this).css("display") == "none"){
				 $(this).show();
			 }else{
				 $(this).hide();
			 }

		});

	}else if(type == "allContent"){

		 $("p[id^='atcl_content_']").each(function() {

			 if($(this).css("display") == "none"){
				 $(this).show();
			 }else{
				 $(this).hide();
			 }

		});

	}else if(type == "allChk"){

		$("input:checkbox[name=chkExcel]").each(function() {


			if((this).checked == false){
				$(this).prop("checked", true);
			}else{
				$(this).prop("checked", false);
			}

		});


	}else if(type == "abstract"){
		if($("#atcl_abstract_"+no).css("display") == "none"){
		    $("#atcl_abstract_"+no).show();
		} else {
		    $("#atcl_abstract_"+no).hide();
		}
	}else if(type == "content"){
		if($("#atcl_content_"+no).css("display") == "none"){
		    $("#atcl_content_"+no).show();
		} else {
		    $("#atcl_content_"+no).hide();
		}
	}


}

function showLeft(type){

	if($("#"+type).css("display") == "none"){
	    $("#"+type).show();
	    $("#"+type+"2").hide();
	} else {
	    $("#"+type).hide();
	    $("#"+type+"2").show();
	}
}


function excel(){
	var contents = "";

	var size = $('input:checkbox[id="chkExcel"]:checked').length;

	if(size > 0){

		contents += $("#excel_table").clone().wrapAll("<table />").parent().html();

		$('input:checkbox[id="chkExcel"]').each(function(){

			if(this.checked == true){
				contents += $("#excel_table_"+$(this).val()).clone().wrapAll("<table />").parent().html();
			}

		});

		document.frm.action = "/search/front/excel.html";
		document.frm.excel_val.value = contents;
		document.frm.submit();

	}else{
		alert("게시물을  한개이상 체크하시고 저장해주세요.");
		return false;
	}


}

function viewJournal(jnl_id, art_id){

	var dnfrm = document.frmJournalList;
	dnfrm.jnl_id.value = jnl_id;
	dnfrm.art_id.value = art_id;

	var viewMenuNo;

	if(jnl_id == "924"){
		viewMenuNo = "2569";
	}else if(jnl_id == "925"){
		viewMenuNo = "2566";
	}else if(jnl_id == "1001"){
		viewMenuNo = "2571";
	}else if(jnl_id == "1002"){
		viewMenuNo = "2568";
	}else if(jnl_id == "1003"){
		viewMenuNo = "2573";
	}

	dnfrm.action = "/?menuno="+viewMenuNo;
	dnfrm.submit();

}

function downloadJournal(no){
	var dnfrm = document.frmJournalList;
	dnfrm.art_id.value = no;

	dnfrm.action = "/journal/front/journalDownload.html";
	dnfrm.target = "_blank";
	dnfrm.submit();
}

function popupOpen(no) {
	var frm = document.frmJournalList;
	frm.art_id.value = no;

	var url    ="/journal/front/articlePreview.html";
	var title  = "PDFPreview";
	var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=880,height=660,top=0,left=0";
	window.open("", title,status);

	frm.target = title;
	frm.action = url;
	frm.method = "post";
	frm.submit();
}

</script>
<style>
div.details-search{z-index:999999;width:416px !important;}
div.details-search .search-box{margin-bottom:0px !important;}
div.details-search .search-box .search-cont{padding:15px !important;float:left !important;}
div.details-search .search-box .search-cont ul{float:left;}
div.details-search .search-box .search-cont ul li{font-size:13px !important;display:block;width:100%;float:left;}
div.details-search .search-box .search-cont ul li label{width:53px !important;float:left;}
div.details-search .search-box .search-cont .select{float:left;}
div.details-search .search-box .search-cont .select label{margin-right:5px !important;font-size:12px !important;}
div.btn-c02{float:left;width:100%;}
div.btn-c02 a{float:none !important;}
div.details-search .search-box a.close{right:0px !important;}
#lnb ul.lnb li a.on, #lnb ul.lnb li a:hover, #lnb02 ul.lnb li a.on, #lnb02 ul.lnb li a:hover { background-position:0 -20px; color:#767676; }
#lnb ul.lnb li ul li a.on, #lnb ul li ul li a:hover, #lnb02 ul.lnb li ul li a.on, #lnb02 ul li ul li a:hover { color:#6e6e6e; }
</style>
<form name="frm" method="post">
<input type="hidden" name="excel_val" />
<input type="hidden" name="keyword" value="${keyword }"/>
</form>
<div id="lnb02">
	<h2>
		<em>Korea Planners Association</em>
		<strong>통합검색</strong>
	</h2>
	<ul class="lnb">
		<li>
			<a href="#">문헌DB+<c:if test="${pubCnt > 0 }">(${pubCnt })</c:if></a>
			<ul>
				<c:forEach items="${pubList }" var="each" varStatus="loop">
					<c:if test="${loop.count > 10 }">
						<c:if test="${loop.count == 11 }">
							<li  id="pubDisplay2"><a href="javascript:showLeft('pubDisplay')">- 더보기</a></li>
							<div id="pubDisplay" style="display:none">
						</c:if>
					</c:if>
					<li><a href="/?menuno=2092&searchType=left&keyword=<%=URLEncoder.encode(pageContext.getAttribute("keyword").toString(), "UTF-8") %>&pub_id=${each.PUB_ID }&csq=<%=URLEncoder.encode(pageContext.getAttribute("csq").toString(), "UTF-8") %>&pub_temp=${pub_temp }&ym_temp=${ym_temp }&showSize=${showSize}&dSubject=<%=URLEncoder.encode(pageContext.getAttribute("dSubject").toString(), "UTF-8") %>&dAuthor=<%=URLEncoder.encode(pageContext.getAttribute("dAuthor").toString(), "UTF-8") %>&dKeyword=<%=URLEncoder.encode(pageContext.getAttribute("dKeyword").toString(), "UTF-8") %>">- ${each.PUB_NAME } (${each.COUNT })</a></li>
					<c:if test="${loop.count > 10 }">
						<c:if test="${loop.count eq fn:length(pubList)}">
							</div>
						</c:if>
					</c:if>
				</c:forEach>
			</ul>
		</li>
		<li>
			<a href="javascript:;">발간년도<c:if test="${isuCnt > 0 }">(${isuCnt })</c:if></a>
			<ul>
				<c:forEach items="${isuList }" var="each" varStatus="loop">
					<c:if test="${loop.count > 10 }">
						<c:if test="${loop.count == 11 }">
							<li  id="yearDisplay2"><a href="javascript:showLeft('yearDisplay')">- 더보기</a></li>
							<div id="yearDisplay" style="display:none">
						</c:if>
					</c:if>
					<li><a href="/?menuno=2092&searchType=left&keyword=<%=URLEncoder.encode(pageContext.getAttribute("keyword").toString(), "UTF-8") %>&yearMonth=${each.ISU_YEAR }&csq=<%=URLEncoder.encode(pageContext.getAttribute("csq").toString(), "UTF-8") %>&pub_temp=${pub_temp }&ym_temp=${ym_temp }&showSize=${showSize}&dSubject=<%=URLEncoder.encode(pageContext.getAttribute("dSubject").toString(), "UTF-8") %>&dAuthor=<%=URLEncoder.encode(pageContext.getAttribute("dAuthor").toString(), "UTF-8") %>&dKeyword=<%=URLEncoder.encode(pageContext.getAttribute("dKeyword").toString(), "UTF-8") %>">- ${each.ISU_YEAR} (${each.COUNT})</a></li>
					<c:if test="${loop.count > 10 }">
						<c:if test="${loop.count eq fn:length(isuList)}">
							</div>
						</c:if>
					</c:if>
				</c:forEach>
			</ul>
		</li>
		<li>
			<a href="#">저자<c:if test="${authorCnt > 0 }">(${authorCnt })</c:if></a>
			<ul>
				<c:forEach items="${authorList }" var="each" varStatus="loop">
					<c:if test="${loop.count > 10 }">
						<c:if test="${loop.count == 11 }">
							<li  id="authorDisplay2"><a href="javascript:showLeft('authorDisplay')">- 더보기</a></li>
							<div id="authorDisplay" style="display:none">
						</c:if>
					</c:if>
					<c:set value="${each.ATCL_AUTHOR }" var="leftAuthor" />
					<li><a href="/?menuno=2092&searchType=left&keyword=<%=URLEncoder.encode(pageContext.getAttribute("keyword").toString(), "UTF-8") %>&author=<%=URLEncoder.encode(pageContext.getAttribute("leftAuthor").toString(), "UTF-8") %>&csq=<%=URLEncoder.encode(pageContext.getAttribute("csq").toString(), "UTF-8") %>&pub_temp=${pub_temp }&ym_temp=${ym_temp }&showSize=${showSize}&dSubject=<%=URLEncoder.encode(pageContext.getAttribute("dSubject").toString(), "UTF-8") %>&dAuthor=<%=URLEncoder.encode(pageContext.getAttribute("dAuthor").toString(), "UTF-8") %>&dKeyword=<%=URLEncoder.encode(pageContext.getAttribute("dKeyword").toString(), "UTF-8") %>">- ${each.ATCL_AUTHOR} (${each.COUNT})</a></li>
					<c:if test="${loop.count > 10 }">
						<c:if test="${loop.count eq fn:length(authorList)}">
							</div>
						</c:if>
					</c:if>
				</c:forEach>
			</ul>
		</li>
	</ul>
</div>
<div class="cont-right">

	<%-- <fieldset class="search">
		<div class="search-box">
			<form:form action="/" name="searchForm1" method="get" commandName="frontSearchVO">
				<input type="hidden" name="menuno" value="${param.menuno }"/>
				<input type="hidden" name="searchType" id="searchType" value=""/>
				<label for="search"><img src="/usr/image/search/text_search.gif" alt="통합검색" /></label>
				<span>
					<input type="text" class="text" name="keyword" id="keyword1" title="검색어 입력" style="width:453px;height:20px;padding-left:5px;" value="<c:if test="${keyword ne '*' }">${keyword }</c:if>"/>
					<a href="javascript:chkForm('base');"><img src="/usr/image/common/btn/btn_search_new04.gif" alt="HOME" /></a>
				</span>
				<a href="javascript:void(0);" class="search02"><img src="/usr/image/common/btn/btn_search_new03.gif" alt="상세검색" /></a>

				<!-- 상세검색 -->
				<!-- <div class="details-search">작업완료되시면 style 부분 삭제하세요.
					<div class="search-box">
						<h3>상세검색</h3>
						<div class="search-cont">
							<ul>
								<li>
									<label for="title">제 목</label>
									<input type="text" class="text" name="dSubject" id="dSubject" value="" title="제목 입력" style="width:240px;height:22px;" />
								</li>
								<li>
									<label for="author">저 자</label>
									<input type="text" class="text" name="dAuthor" id="dAuthor" value="" title="저자 입력" style="width:240px;height:22px;" />
								</li>
								<li>
									<label for="proce">학술지</label>
									<select name="dJournal" id="dJournal" class="text" style="width:240px;height:26px;font-size:12px;line-height:20px;">
										<option value="">-------------선택------------</option>
										<option value="925">국토계획</option>
										<option value="924">도시정보</option>
										<option value="1001">학술발표논문집</option>
										<option value="1002">APPR</option>
										<option value="1003">세미나자료집</option>
									</select>
								</li>
								<li>
									<label for="keywords">키워드</label>
									<input type="text" class="text" name="dKeyword" id="dKeyword" value="" title="키워드 입력" style="width:240px;height:22px;" />
								</li>
							</ul>

							<div class="btn-c02"><a href="javascript:chkForm('detail');"><img src="/usr/image/common/btn/btn_search04.gif" alt="검색" /></a></div>
						</div>
						<a href="javascript:;" class="close"><img src="/usr/image/common/btn/btn_close.gif" alt="닫기" /></a>
					</div>
				</div> -->
				<!-- //상세검색 -->

				<div class="details-search">
					<div class="search-box">
						<h3>상세검색</h3>
						<div class="search-cont">
							<ul>
								<li>
									<label for="title">제 목</label>
									<input type="text" class="text" name="dSubject" id="dSubject" title="제목 입력" style="width:240px;height:22px;" />
								</li>
								<li>
									<label for="author">저 자</label>
									<input type="text" class="text" name="dAuthor" id="dAuthor" title="저자 입력" style="width:240px;height:22px;" />
								</li>
								<li>
									<label for="proce">자료구분</label>
									<select name="dJournal" id="dJournal" class="text" style="width:240px;height:26px;font-size:12px;line-height:20px;">
										<option value="">-------------선택------------</option>
										<option value="925">국토계획</option>
										<option value="924">도시정보</option>
										<option value="1001">학술발표논문집</option>
										<option value="1002">APPR</option>
										<option value="1003">세미나자료집</option>
									</select>
								</li>
								<li>
									<label for="keywords">키워드</label>
									<input type="text" class="text" name="dKeyword" id="dKeyword" value="${dKeyword }" title="키워드 입력" style="width:240px;height:22px;" />
								</li>
							</ul>
							<div class="select">
								<label for="period">기간설정</label>
								<select name="sYear"id="sYear" style="width:52px;">
									<option value="">년도</option>
									<c:forEach var="data" begin="1966" end="2015">
										<option value="${data }">${data }</option>
									</c:forEach>
								</select>
								<select name="sMonth"id="sMonth">
									<option value="">월</option>
									<c:forEach var="data" begin="1" end="12">
										<option value="${data }">${data }</option>
									</c:forEach>
								</select>
								부터
								<select name="eYear"id="eYear" style="width:52px;">
									<option value="">년도</option>
									<c:forEach var="data" begin="1966" end="2015">
										<option value="${data }">${data }</option>
									</c:forEach>
								</select>
								<select name="eMonth"id="eMonth">
									<option value="">월</option>
									<c:forEach var="data" begin="1" end="12">
										<option value="${data }">${data }</option>
									</c:forEach>
								</select>
								까지
							</div>
							<div class="btn-c02"><a href="javascript:chkForm('detail');"><img src="/usr/image/common/btn/btn_search04.gif" alt="검색" /></a></div>
						</div>
						<a href="javascript:window.close();" class="close"><img src="/usr/image/common/btn/btn_close.gif" alt="닫기" /></a>
					</div>
				</div>
			</form:form>
		</div>
		<div class="tag">
			<strong><img src="/usr/image/common/icon/icon_tag.png" alt="TAG" /></strong>
			<c:forEach items="${statisList }" var="data" varStatus="status">
				<c:if test="${status.count < 6 }">
				<c:set value="${data.STATIS }" var="statis"></c:set>
				<%
					String keyword = URLEncoder.encode(pageContext.getAttribute("statis").toString(), "UTF-8");
				%>
				<a href="/?menuno=2092&keyword=<%=keyword%>"><c:out value="${data.STATIS }" /></a>
				<c:if test="${status.count ne  fn:length(statisList)}"> / </c:if>
				<c:if test="${status.count < 5}"> / </c:if>
				</c:if>
			</c:forEach>
		</div>
	</fieldset> --%>

	<!-- <ul class="tab05">
		<li class="on total"><a href="/?menuno=2092">전체</a></li>
		<li class="two"><a href="/?menuno=2092&pub_id=925">국토도시계획학회지</a></li>
		<li><a href="/?menuno=2092&pub_id=1002">APPR</a></li>
		<li><a href="/?menuno=2092&pub_id=924">도시정보지</a></li>
		<li><a href="/?menuno=2092&pub_id=1001">학술발표논문집</a></li>
		<li><a href="/?menuno=2092&pub_id=1003">세미나자료집</a></li>
	</ul> -->
<style>
.ranking ul.float-l{float:left !important;margin-bottom:20px;}
.ranking ul.float- li{padding-left:5px !important;}
.ranking ul li.no_bg{background:none;margin-left:0px;}
.ranking ul li a.btn_small{display:inline-block;background:#495a74;color:#fff;line-height:28px;padding:0 10px;}
.ranking ul li a.btn_small:hover{display:inline-block;background:#495a74;color:#fff;line-height:28px;padding:0 10px;font-weight:normal;}
.ranking ul li.on a, .ranking ul li a:hover{font-weight:800;}
.ranking p.btn-l{float:left;}
.ranking p.btn-l a.btn_small{display:inline-block;background:#000;color:#fff;line-height:28px;padding:0 10px;}
.ranking p.btn-l a.btn_small:hover{display:inline-block;background:#000;color:#fff;line-height:28px;padding:0 10px;font-weight:normal;}

ul.search-results li{padding:5px 0;}
ul.search-results li p{margin-top:0px;}
ul.search-results li ul{margin-top:0px;}
ul.search-results li ul li a img{padding-left:10px;}
ul.search-results li a.btn-small{display:inline-block;margin-left:20px;font-size:12px;line-height:20px;padding:0px 10px;background:#dedede;font-weight:normal;border:1px solid #b0b0b0;}
#contents .cont-right {min-height:500px;}

div.ranking ul li.on2 {background:url('/usr/image/common/icon/bl_ranking2.gif') no-repeat 0 7px;font-size:12px;background-position:0 -8px;}
div.ranking ul li.on2 a, div.ranking ul li a:hover {font-weight:800;color:#444444;}
.text-tit{width:100%;border-bottom:1px solid #495a74;font-family:NANUM;font-weight:600;font-size:13px;margin-top:23px;line-height:23px;padding-bottom:10px;}
.text-tit span{color:#3d639f;}
</style>

	<div class="text-tit">
		<span>
		<c:if test="${keyword ne '*' }"> '${keyword }'</c:if>

		<c:if test="${dSubject ne '' }"> '${dSubject }'</c:if>
		<c:if test="${dAuthor ne '' }"> '${dAuthor }'</c:if>

		<c:if test="${pub_temp ne '' }">
			<c:if test="${pub_temp eq '925' }"> '국토계획'</c:if>
			<c:if test="${pub_temp eq '924' }"> '도시정보'</c:if>
			<c:if test="${pub_temp eq '1001' }"> '학술발표논문집'</c:if>
			<c:if test="${pub_temp eq '1002' }"> 'APPR'</c:if>
			<c:if test="${pub_temp eq '1003' }"> '세미나자료집'</c:if>
		</c:if>

		<c:if test="${dKeyword ne '' }"> '${dKeyword }'</c:if>
		<c:if test="${ym_temp ne '' }"> '${ym_temp }'</c:if>

		</span>에 관한 검색 결과입니다.
	</div>
	<div class="ranking">
		<p class="btn-l"><a href="javascript:void(0)" onclick="showText('','allChk')" class="btn_small">전체선택</a></p>
		<ul class="float-l">
			<li class="no_bg"><a href="javascript:void(0)" onclick="showText('','allContent')" class="btn_small">모든 내용보기</a></li>
			<li class="no_bg"><a href="javascript:void(0)" onclick="showText('','allAbstract')" class="btn_small">모든 초록보기</a></li>
			<li class="no_bg"><a href="javascript:void(0)" onclick="excel()" class="btn_small">엑셀로 저장</a></li>
			<li class="no_bg">
				<select name="selectSize" id="selectSize" style="height:28px;">
					<option value="8" <c:if test="${showSize eq '8' }">selected="selected"</c:if>>8개씩</option>
					<option value="10" <c:if test="${showSize eq '10' }">selected="selected"</c:if>>10개씩</option>
					<option value="20" <c:if test="${showSize eq '20' }">selected="selected"</c:if>>20개씩</option>
					<option value="30" <c:if test="${showSize eq '30' }">selected="selected"</c:if>>30개씩</option>
					<option value="40" <c:if test="${showSize eq '40' }">selected="selected"</c:if>>40개씩</option>
					<option value="50" <c:if test="${showSize eq '50' }">selected="selected"</c:if>>50개씩</option>
					<option value="100" <c:if test="${showSize eq '100' }">selected="selected"</c:if>>100개씩</option>
				</select>
			</li>
		</ul>
	</div>
	<div class="ranking" style="width:250px;float:right;margin-top:-45px;">
		<ul>
			<c:set var="msort_status" value=""/>
			<c:if test="${fn:indexOf(msort, 'm:1:1') ne -1}">
				<c:set var="msort_status" value="class='on'"/>
			</c:if>
			<c:if test="${fn:indexOf(msort, 'm:1:0') ne -1}">
				<c:set var="msort_status" value="class='on2'"/>
			</c:if>

			<c:set var="dsort_status" value=""/>
			<c:if test="${fn:indexOf(msort, 'd:1:1') ne -1}">
				<c:set var="dsort_status" value="class='on'"/>
			</c:if>
			<c:if test="${fn:indexOf(msort, 'd:1:0') ne -1}">
				<c:set var="dsort_status" value="class='on2'"/>
			</c:if>

			<c:set var="ssort_status" value=""/>
			<c:if test="${fn:indexOf(msort, 's:3:1') ne -1}">
				<c:set var="ssort_status" value="class='on2'"/>
			</c:if>
			<c:if test="${fn:indexOf(msort, 's:3:0') ne -1}">
				<c:set var="ssort_status" value="class='on''"/>
			</c:if>

			<li ${msort_status } style="width:50px;"><a href="/?menuno=2092&keyword=<%=URLEncoder.encode(pageContext.getAttribute("keyword").toString(), "UTF-8") %>&pub_id=${pub_id }&yearMonth=${yearMonth }&author=<%=URLEncoder.encode(pageContext.getAttribute("author").toString(), "UTF-8") %>&searchType=${searchType }&csq=<%=URLEncoder.encode(pageContext.getAttribute("csq").toString(), "UTF-8") %>&pub_temp=${pub_temp }&ym_temp=${ym_temp }&showSize=${showSize}&pageIndex=${input.pageIndex}&sort=m&msort=${msort}&dSubject=<%=URLEncoder.encode(pageContext.getAttribute("dSubject").toString(), "UTF-8") %>&dAuthor=<%=URLEncoder.encode(pageContext.getAttribute("dAuthor").toString(), "UTF-8") %>&dKeyword=<%=URLEncoder.encode(pageContext.getAttribute("dKeyword").toString(), "UTF-8") %>">정확도순</a></li>
			<li ${dsort_status } style="width:40px;"><a href="/?menuno=2092&keyword=<%=URLEncoder.encode(pageContext.getAttribute("keyword").toString(), "UTF-8") %>&pub_id=${pub_id }&yearMonth=${yearMonth}&author=<%=URLEncoder.encode(pageContext.getAttribute("author").toString(), "UTF-8") %>&searchType=${searchType }&csq=<%=URLEncoder.encode(pageContext.getAttribute("csq").toString(), "UTF-8") %>&pub_temp=${pub_temp }&ym_temp=${ym_temp }&showSize=${showSize}&pageIndex=${input.pageIndex}&sort=d&msort=${msort}&dSubject=<%=URLEncoder.encode(pageContext.getAttribute("dSubject").toString(), "UTF-8") %>&dAuthor=<%=URLEncoder.encode(pageContext.getAttribute("dAuthor").toString(), "UTF-8") %>&dKeyword=<%=URLEncoder.encode(pageContext.getAttribute("dKeyword").toString(), "UTF-8") %>">최신순</a></li>
			<li ${ssort_status } style="width:85px;"><a href="/?menuno=2092&keyword=<%=URLEncoder.encode(pageContext.getAttribute("keyword").toString(), "UTF-8") %>&pub_id=${pub_id }&yearMonth=${yearMonth }&author=<%=URLEncoder.encode(pageContext.getAttribute("author").toString(), "UTF-8") %>&searchType=${searchType }&csq=<%=URLEncoder.encode(pageContext.getAttribute("csq").toString(), "UTF-8") %>&pub_temp=${pub_temp }&ym_temp=${ym_temp }&showSize=${showSize}&pageIndex=${input.pageIndex}&sort=s&msort=${msort}&dSubject=<%=URLEncoder.encode(pageContext.getAttribute("dSubject").toString(), "UTF-8") %>&dAuthor=<%=URLEncoder.encode(pageContext.getAttribute("dAuthor").toString(), "UTF-8") %>&dKeyword=<%=URLEncoder.encode(pageContext.getAttribute("dKeyword").toString(), "UTF-8") %>">저자(가나다순)</a></li>
		</ul>
	</div>
	<ul class="search-results">
		<form name="frmJournalList" method="post">
		<input type="hidden" name="jnl_id" id="jnl_id" value=""/>
		<input type="hidden" name="art_id" id="art_id" value=""/>
		<c:forEach items="${totalSearchList}" var="data" varStatus="loop">
		<li>
			<strong><em><%-- [${fn:substring(data.ISU_NAME,0,4) }] --%></em>
			<input type="checkbox" name="chkExcel" id="chkExcel" value="${each.ATCL_ID }"/><a href="javascript:viewJournal('${each.PUB_ID }', '${each.ATCL_ID}')" style="color:#4e7ab9;font-size:14px;line-height:18px;font-family:NANUM;">${each.ATCL_NAME }</a>
			<span>${each.ISU_YEAR }년 ${each.ISU_MONTH }월</span>
			<c:if test="${fn:trim(each.ATCL_CONTENT) ne ''}">
			<a href="javascript:showText('${each.ATCL_ID }','content')" class="btn-small">내용보기</a>
			</c:if>
			<c:if test="${fn:trim(each.ATCL_ABSTRACT) ne ''}">
			<a href="javascript:showText('${each.ATCL_ID }','abstract')" class="btn-small">초록보기</a>
			</c:if>
			</strong>
			<p><c:if test="${each.ATCL_AUTHOR ne '' }">저자 : ${each.ATCL_AUTHOR }</c:if><c:if test="${each.ATCL_AUTHOR eq '' }">저자 : ${each.ATCL_AUTHOR_1ST }</c:if></p>
			<p id="atcl_content_${each.ATCL_ID }" style="display:none">${fn:trim(each.ATCL_CONTENT)}</p>
			<P id="atcl_abstract_${each.ATCL_ID }" style="display:none">${fn:trim(each.ATCL_ABSTRACT)}</P>
			<ul>
				<!-- <li>도시</li> -->
				<%-- <li>${data.ATCL_AUTHOR }</li> --%>
				<li>대한국토·도시계획학회</li>
				<li>${each.PUB_NAME}</li>
				<li>
					<c:choose>
						<c:when test="${duesMap.status eq '00'}">
							미리보기<a href="#" onclick="popupOpen('${each.ATCL_ID}')"><img src="/usr/image/common/icon/icon_view01.gif" alt="미리보기" title="미리보기"  style="vertical-align: middle;"/></a>
						</c:when>
						<c:otherwise>
							미리보기
							<c:choose>
								<c:when test="${sessionScope.zUserVo.work_grade eq '7'}">
									<a href="#" onclick="popupOpen('${each.ATCL_ID}')"><img src="/usr/image/common/icon/icon_view01.gif" alt="미리보기" title="미리보기" style="vertical-align: middle;"/></a>
								</c:when>
								<c:otherwise>
									<a href="javascript:alert('원문 미리보기 권한이 없습니다. 로그인 후에도 미리보기가 활성화 되지 않으면 회비납부여부를 확인하시기 바랍니다.');">
									<img src="/usr/image/common/icon/icon_view01.gif" alt="미리보기" title="미리보기"  style="vertical-align: middle;"/></a>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<c:choose>
						<c:when test="${duesMap.status eq '00'}">
							원문다운<a href="#" onclick="downloadJournal('${each.ATCL_ID }')">
								<img src="/usr/image/common/icon/icon_file.gif" alt="원문다운" title="원문다운" style="vertical-align: middle;"/>
							</a>
						</c:when>
						<c:otherwise>
							원문다운
							<c:choose>
								<c:when test="${sessionScope.zUserVo.work_grade eq '7'}">
									<a href="#" onclick="downloadJournal('${each.ATCL_ID }')">
										<img src="/usr/image/common/icon/icon_file.gif" alt="원문다운" title="원문다운" style="vertical-align: middle;"/>
									</a>
								</c:when>
								<c:otherwise>
									<a href="javascript:alert('다운로드 권한이 없습니다. 로그인 후에도 다운로드가 되지 않으면 회비납부여부를 확인하시기 바랍니다.');">
										<img src="/usr/image/common/icon/icon_file.gif" alt="원문다운" title="원문다운" style="vertical-align: middle;"/>
									</a>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</li>
				<c:if test="${not empty fn:trim(each.ATCL_LINK)}">
				<li>
					XML<a href="${each.ATCL_LINK}" target="_blank">
						<img src="/usr/image/common/icon/icon_xml.gif" alt="xml링크" title="xml링크"  style="vertical-align: middle;"/>
					</a>
				</li>
				</c:if>
			</ul>
		</li>
		<li style="display:none"><!-- 엑셀 다운 테이블 -->
			<c:if test="${loop.count == 1 }">
			<table id="excel_table" border="1" cellspacing="1" cellpadding="2" width="100%" summary="검색 결과">
				<thead>
					<tr>
						<th>출간년월</th>
						<th>논문제목</th>
						<th>본문</th>
						<th>논문초록</th>
						<th>논문저자</th>
						<th>저널종류</th>
					</tr>
				</thead>
			</table>
			</c:if>
			<table id="excel_table_${each.ATCL_ID }" border="1" cellspacing="1" cellpadding="2" width="100%" summary="검색 결과">
				<tbody>
					<tr>
						<td>${each.ISU_YEAR }년 ${each.ISU_MONTH }월</td>
						<td>${fn:replace(each.ATCL_NAME, '<b>', ' ') }</td>
						<td>${fn:replace(each.ATCL_CONTENT, '<b>', ' ') } </td>
						<td>${fn:replace(each.ATCL_ABSTRACT, '<b>', '') }</td>
						<td>${each.ATCL_AUTHOR }</td>
						<td>${each.PUB_NAME}</td>
					</tr>
				</tbody>
			</table>
		</li>
		</c:forEach>
		</form>
		<c:if test="${fn:length(totalSearchList) == 0}">
			<c:if test="${searchType ne 'detailView'}">
				<li style="text-align:center">검색 결과가 없습니다.</li>
			</c:if>
		</c:if>
	</ul>
	<form:form action="/?menuno=${param.menuno }" name="searchPage" method="post">
	<ptkev:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' menuno='${param.menuno }' formName='searchPage'/>
	<input type="hidden" name="keyword" value="${keyword }"/>
	<input type="hidden" name="pub_id" value="${pub_id }"/>
	<input type="hidden" name="yearMonth" value="${yearMonth }"/>
	<input type="hidden" name="author" value="${author }"/>
	<%-- <input type="hidden" name="sort" value="${sort }"/> --%>
	<input type="hidden" name="msort" value="${msort }"/>
	<input type="hidden" name="searchType" value="<c:if test="${searchType ne 'detailView'}">${searchType }</c:if>"/>
	<input type="hidden" name="csq" value="${csq }"/>
	<input type="hidden" name="pub_temp" value="${pub_temp }"/>
	<input type="hidden" name="ym_temp" value="${ym_temp }"/>
	<input type="hidden" name="showSize" id="showSize" value="${showSize }"/>
	<input type="hidden" name="dSubject" value="${dSubject }"/>
	<input type="hidden" name="dAuthor" value="${dAuthor }"/>
	<input type="hidden" name="dKeyword" value="${dKeyword }"/>

	</form:form>

	<!-- <div class="paging"> -->

		<!-- <a href="#" class="btn first"><img src="/usr/image/common/btn/paging_first.gif" alt="첫 페이지로" /></a>
		<a href="#" class="btn"><img src="/usr/image/common/btn/paging_prev.gif" alt="이전 페이지로" /></a>
		<a href="#">1</a>
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
		<a href="#" class="btn"><img src="/usr/image/common/btn/paging_last.gif" alt="마지막 페이지로" /></a> -->
	<!-- </div> -->
</div>
