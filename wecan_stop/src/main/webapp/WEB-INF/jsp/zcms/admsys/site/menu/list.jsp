<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.nodes.Element" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@ page import="java.util.*, java.text.*"%>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
<script type="text/javascript">
$(function(){
    $('.main_table1 tbody img').bind("click",function(){
        var attr = $(this).attr("id");
        if (typeof attr !== 'undefined' && attr !== false){
            if ($(this).attr("src").indexOf("closed")!=-1){
                $(this).attr("src","/cms/image/btn_opened.jpg");
                $(this).attr("alt","열림");
                $(this).closest("tr").siblings("#"+$(this).attr("id")).show();
            }
            else{
                $(this).attr("src","/cms/image/btn_closed.jpg");
                $(this).attr("alt","닫힘");
                if ($(this).attr("id").match(/^\d+/)=="1"){
                    var id = $(this).attr("id").match(/\d+$/);
                    $(this).closest("tr").siblings("tr[id$='"+id+"']").hide();
                    $(this).closest("tr").siblings("tr[id$='"+id+"']").find("img[id$='"+id+"']").attr("src","/cms/image/btn_closed.jpg");
                }
                else{
                    $(this).closest("tr").siblings("#"+$(this).attr("id")).hide();
                }
            }
        }
    });
    $('.main_table1 thead img').bind("click",function(){
        if ($(this).attr("src").indexOf("open")!=-1){
            $(".main_table1 tbody img[id]").attr("src","/cms/image/btn_opened.jpg");
            $('.main_table1 tbody tr').show();
        }
        else{
            $(".main_table1 tbody img[id]").attr("src","/cms/image/btn_closed.jpg");
            $(".main_table1 tbody tr:not([id^='0'])").hide();
        }
    });

    var opens = $.url().param('opens');
    if (opens) {
    	 $.each(opens.split(","), function(index, value) {
    		 $('#' + value).trigger('click');
         });
    }
    var selectId = $.url().param('selectId');
    if (selectId) {
    	$("."+selectId+"_tr").attr("bgcolor","#f5f5f5");
    	location.href="#"+selectId+"_selectId";
    }

})

function order(arg){

	var opens = $("[src$='btn_opened.jpg']").map(function(){return $(this).attr('id');}).get();
	alert(arg + "&opens=" + opens)
	window.location.href = arg + "&opens=" + opens;

}

function actionMenu(act,siteno, menuno){

	var url = "";

	if(act == "insert"){
		url = "insert.html?siteno="+siteno;
	}else if(act == "insert_d"){
		url = "insert.html?siteno="+siteno+"&menuno="+menuno;
	}else if(act == "update"){
		url = "update.html?siteno="+siteno+"&menuno="+menuno+"&selectId="+menuno;
	}else if(act == "up" || act == "down"){
		url = siteno;
	}
      var opens = $("[src$='btn_opened.jpg']").map(function(){return $(this).attr('id');}).get();
      location.href= url+"&opens="+opens;
}
</script>
            <div id="contents">
                <div class="contents_top">
					<div class="location">
						<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>메뉴전체보기</strong>
					</div>
				</div>
                <div id="content">
				<ul class="homepagebbs">
					<li class="bg"><h3 class="sub">메뉴전체보기 [ <c:out value="${sitetitle}" escapeXml="false" /> ]</h3>
					<a class="btmore03" href="#none" onclick="actionMenu('insert','${siteno}');">+ 최상위메뉴등록</a></li>
					<li>
					<div class="top_bt">
						<a class="btmore07" href="javascript:checkAll(true,'menuno');">전체선택</a>
						<a class="btmore07" href="javascript:checkAll(false,'menuno');">전체해제</a>
						<a class="btmore05" href="javascript:del('menuno');">삭제</a>
					</div>
                    <div class="main_table">
                        <!---게시판 영역------------------------->
                        <form:form name="frm" method="post">
                            <input type="hidden" name="siteno" value="${siteno}" />
                            <table class="main_table1" summary="메뉴명, URL, 종류, 상태, SNS링크, 등록일, 수정일, 메뉴관리">
                                <caption>메뉴전체보기</caption>
                                <colgroup>
                                    <col width="5px" />
                                    <col/>
                                    <col width="80px" />
                                    <col width="5%" />
                                    <col width="10%" />
                                    <col width="55px" />
                                    <col width="55px" />
                                    <col width="10%" />
                                    <col width="10%" />
                                    <col width="250px" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','menuno')" />
                                        </th>
                                        <th><span style="float:left">
										<img src="/cms/image/btn_lnb_open.gif" alt="전체열림" title="전체열림"> <img src="/cms/image/btn_lnb_close.gif" alt="전체닫힘" title="전체닫힘">
										<a class="imgSelect"  title="설명">설명</a>
										<div class="popupLayer">
											<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"  title="닫기"></a></div>
											<strong>메뉴 펼침, 접음</strong></br>
											전체 분류를 펼치거나 접을 경우 사용합니다.
										</div>
									</div>
										</span>메뉴명</th>
                                        <th>순서조정 <a class="imgSelect" title="설명">설명</a>
											<div class="popupLayer">
												<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
												<strong>분류 순서조정</strong></br>
											분류의 위치 이동을 할 수 있습니다. 상위 분류나 하위 분류로 이동할 수 있습니다.
											</div>
										</div></th>
                                        <th>URL</th>
                                        <th>종류
											<a class="imgSelect" title="종류 설명">설명</a>
											<div class="popupLayer">
												<div><a onClick="closeLayer(this)"><img id="close" src="/cms/image/common/c.gif" alt="닫기"></a></div>
												<strong>콘텐츠 종류에 체크한 부분이 표기</strong></br>
												<strong>직접작성 시 표기되는 약어설명</strong></br>
												게:게시판 / 회:회원폼 / 로:로그인폼  / 팝 : 팝업<br />
												이 : 이벤트 / 배 : 배너 / 폼 : 폼메일 / 설 : 설문조사 / 평 : 평가
											</div></th>
                                        <th>상태</th>
                                        <th>SNS링크</th>
                                        <th>등록일</th>
                                        <th>수정일</th>
                                        <th>메뉴관리</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each">
                                        <tr style="display:<c:if test='${each.menulevel!="0"}'>none</c:if>" id="${each.menulevel}_${each.menuparentno}_${each.menutopno}" class="${each.menuno }_tr">
                                            <td>
                                            	<a name="${each.menuno }_selectId" /><!-- 위치 찾기 위한  -->
                                                <%-- <input class="bor_none" name="menuno" value='${data.menuno}^${siteno}' type="checkbox" /> --%>
                                                <input class="bor_none" name="menuno" value='${each.menuno}' type="checkbox" />
                                            </td>
                                            <td class='menu_d${each.menulevel}'>
                                                <!-- 로드벨런실 관계로 포트를 주석처리 -->
                                                <%-- <c:url value="http://${sitedomain}${port }" var="url">
                                                    <c:param name="menuno" value="${data.menuno}" />
                                                </c:url> --%>
                                                <c:url value="http://${sitedomain}/" var="url">
                                                    <c:param name="menuno" value="${each.menuno}" />
                                                </c:url>
                                                <c:if test='${each.cnt!="1"}'><img src="/cms/image/btn_closed.jpg" id="${each.menulevel+1}_${each.menuno}_${each.menutopno}" /></c:if>
                                                <a href="${url}" target="_blank" title="${each.menutitle}">${each.menutitle}<c:if test='${each.cnt!="1"}'>(${each.cnt-1})</c:if></a></span>
                                            </td>
                                            <%--
											<td>
                                                <c:url value="list.html" var="url">
                                                    <c:param name="mode" value="order" />
                                                    <c:param name="menuno" value="${data.menuno}" />
                                                    <c:param name="act" value="" />
                                                </c:url>
                                                <a class="bt" href="${url}up" title="분류상위 이동">분류상위 이동</a>
                                                <a class="next" href="${url}down" title="분류하위 이동">분류하위 이동</a>
                                            </td> --%>
											<td>
												<c:url value="list.html" var="url">
													<c:param name="mode" value="order" />
													<c:param name="menuno" value="${each.menuno}" />
													<c:param name="siteno" value="${siteno}" />
													<c:param name="act" value="" />
												</c:url>
												<a class="bt" href="#none" onclick="actionMenu('up','${url}u')" title="분류상위 이동">분류상위 이동</a><a class="next" href="#none" onclick="actionMenu('down','${url}d')" title="분류하위 이동">분류하위 이동</a>
											</td>

                                            <td>
                                                <a href="javascript:void(0)" onclick="copytoclipboard('/?menuno=${each.menuno}');">
                                                    ${each.menuno }
                                                </a>

                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test='${each.menutype=="01"}'><c:out value="<font color=029CFD>직접작성</font>" escapeXml="false" />
                                                        <c:forTokens items="${each.menutags}" delims="," var="type">
                                                            <c:if test='${fn:startsWith(type,"board")}'><c:out value='${fn:replace(type,"board"," - 게")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"terms")}'><c:out value='${fn:replace(type,"terms"," - 약")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"member")}'><c:out value='${fn:replace(type,"member"," - 회")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"login")}'><c:out value='${fn:replace(type,"login"," - 로")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"popup")}'><c:out value='${fn:replace(type,"popup"," - 팝")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"event")}'><c:out value='${fn:replace(type,"event"," - 이")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"banner")}'><c:out value='${fn:replace(type,"banner"," - 배")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"formmail")}'><c:out value='${fn:replace(type,"formmail"," - 폼")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"survey")}'><c:out value='${fn:replace(type,"survey"," - 설")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"eval")}'><c:out value='${fn:replace(type,"eval"," - 평")}' /></c:if>
                                                            <c:if test='${fn:startsWith(type,"manager")}'><c:out value='${fn:replace(type,"manager"," - 컨")}' /></c:if>
                                                        </c:forTokens>
                                                    </c:when>
                                                    <c:when test='${each.menutype=="02"}'><c:out value="하위메뉴지정" /></c:when>
                                                    <c:when test='${each.menutype=="03"}'><c:out value="<font color=31B00A>게시판</font>" escapeXml="false" /></c:when>
                                                    <c:when test='${each.menutype=="04"}'><c:out value="<font color=BF39BA>외부</font>" escapeXml="false" /></c:when>
                                                    <c:when test='${each.menutype=="05"}'><c:out value="<font color=BF39BA>내부</font>" escapeXml="false" /></c:when>
                                                    <c:when test='${each.menutype=="06"}'><c:out value="<font color=31B00A>아카이브</font>" escapeXml="false" /></c:when>
                                                    <c:otherwise><c:out value="<font color=029CFD>직접작성</font>" escapeXml="false" /></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test='${each.menustatus=="1"}'><span class="textbt">사용</span></c:when>
                                                    <c:otherwise><span class="textbt01">중지</span></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test='${each.menusns_use_yn==1}'><span class="textbt">사용</span></c:when>
                                                    <c:otherwise><span class="textbt01">중지</span></c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.menudatereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
                                            </td>
                                            <td>
                                                <fmt:parseDate value="${each.menudatemod}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                                <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
                                            </td>
                                            <td class="Tleft">
                                                <a class="btmore05" href="#none" onclick="actionMenu('update','${siteno}','${each.menuno}');">수정</a>
                                                <a class="btmore06" href="#none" onclick="actionMenu('insert_d','${siteno}','${each.menuno}');">하위메뉴등록</a>
                                                <c:if test='${each.menutype!="02"}'>
                                                    <c:url value="/" var="url">
                                                        <c:param name="menuno" value="${each.menuno}" />
                                                    </c:url>
                                                    <a class="btmore06" href="javascript:void(0);" onclick="copytoclipboard('${url}')" title="${url}">링크복사</a>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </form:form>
                        <!---/게시판 영역------------------------->
                        <sssc:securitysessionOut auth="ROLE_SUPER">
                            <div class="btn-c">
								<a class="btmore09" href="/admsys/site/menu/index.html">사이트목록</a>
							</div>
                        </sssc:securitysessionOut>
                    </div><!--/main_table-->
                </div>
				</li>
				</ul><!--/content-->
            </div><!--/contents-->
       <jsp:include page="../../end.jsp" flush="false" />
