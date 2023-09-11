<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true">
<jsp:param value="Y" name="chgJquery" />
</jsp:include>
<jsp:include page="../../lnb.jsp" flush="true" />
<script type="text/javascript">
var j = jQuery.noConflict();
j(document).ready(function(){
    j("#redirectuse1").click(function(){
        j("#redirectmenunumber").removeAttr("readonly");
        alert("메뉴리다이렉트를 사용으로 선택하는 경우 리다이렉트메뉴번호를 입력해 주셔야 합니다.");
    });
    j("#redirectuse2").click(function(){
        j("#redirectmenunumber").attr("readonly","readonly");
        alert("메뉴리다이렉트를 미사용으로 선택하는 경우 리다이렉트메뉴번호를 수정 또는 입력할 수 없습니다.");
    });
});
</script>
<div id="contents">
    <div class="contents_top">
        <div class="location">
            <a href="/admsys/dashboard/index.html">HOME</a>
            <a href="/admsys/site/site/">홈페이지관리</a>
            <strong>사이트 수정</strong>
        </div>
    </div>
	<form:form modelAttribute="zsiteVo" name="frm" method="post" onsubmit="return checkForm()">
	<input name="act" type="hidden" value="update" />
	<input name="origindomain" id="origindomain" type="hidden" value="${detail.sitedomain}" />
	<input name="dupflag" id="dupflag" type="hidden" value="0" />
	<div id="content">
	    <ul class="homepagebbs">
	        <li class="bg"><h3 class="sub">홈페이지 수정</h3></li>
	        <li>
	            <div class="main_table">
	                <!-- 게시판 영역 -->
	                <table class="main_table1 bgneno" summary="사용 도메인, 홈페이지 명, 홈페이지 Title, 상태, 메뉴리다이렉트, 리다이렉트 메뉴번호, 공사중번호">
	                    <caption>홈페이지수정</caption>
	                    <colgroup>
	                        <col width="150px" />
	                        <col />
	                    </colgroup>
	                    <tr>
	                        <th class="Tleft">사용 도메인</th>
	                        <td class="Tbod Tbod Tleft">
	                            <input type="text" name="sitedomain" id="sitedomain" class="bor1ddd" size="50" value="${detail.sitedomain}" onblur="dupchk(1);"/>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th class="Tbornone Tleft">홈페이지 명</th>
	                        <td class="Tleft">
	                            <input type="text" name="sitetitle" class="bor1ddd" size="50" value="${detail.sitetitle}" />
	                        </td>
	                    </tr>
	                    <tr>
	                        <th class="Tbornone Tleft">홈페이지 Title</th>
	                        <td class="Tleft">
	                            <input type="text" name="sitewebtitle" class="bor1ddd" size="50" value="${detail.sitewebtitle}" />
	                        </td>
	                    </tr>
	                    <tr>
	                        <th class="Tbornone Tleft">상태</th>
	                        <td class="Tleft">
	                            <input class="sortby" type="radio" name="sitestatus" id = "sitestatus" value="1" <c:if test="${detail.sitestatus=='1'}"><c:out value='checked' /></c:if> /><label class="on" for="sitestatus">사용</label>
	                            <input class="sortby" type="radio" name="sitestatus" id = "sitestatus02" value="2" <c:if test="${detail.sitestatus=='2'}"><c:out value='checked' /></c:if> /><label class="on" for="sitestatus02">중지</label>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th class="Tbornone Tleft">메뉴리다이렉트</th>
	                        <td class="Tleft">
	                            <input class="sortby" type="radio" name="redirectuse" id = "redirectuse1" value="y" <c:if test="${detail.redirectuse=='y'}"><c:out value='checked' /></c:if> /><label class="on" for="redirectuse1">사용</label>
	                            <input class="sortby" type="radio" name="redirectuse" id = "redirectuse2" value="n" <c:if test="${detail.redirectuse=='n'}"><c:out value='checked' /></c:if> /><label class="on" for="redirectuse2">미사용</label>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th class="Tbornone Tleft">리다이렉트 메뉴번호</th>
	                        <td class="Tleft">
	                            <input type="text" name="redirectmenuno" id="redirectmenunumber" class="bor1ddd" size="50" value="${detail.redirectmenuno}" <c:if test="${detail.redirectuse=='n'}"><c:out value='readonly' /></c:if>/><br>
	                            <p class="notification_right"><img alt="!" src="/cms/image/excla.gif"> 별도로 메인페이지 관리에서 메인페이지를 지정하지 않는 경우 메뉴콘텐츠 관리의 특정 페이지를 메인 페이지로 지정할 경우 해당페이지의 페이지 넘버를 입력하면 도메인 클릭 시 해당페이지로 바로 접속됩니다. </p>
                            </td>
                        </tr>
                        <tr>
                            <th class="Tbornone Tleft">공사중번호</th>
                            <td class="Tleft">
                                <input type="text" name="underCNumber" class="bor1ddd" size="50" value="${detail.underCNumber}" /><br>
                                <p class="notification_right"><img alt="!" src="/cms/image/excla.gif"> (WEB-INF/jsp 경로 아래에 underC_1.jsp ~ underC_6.jsp의 파일이 있습니다. 1~6 번의 숫자를 써 주시면 됩니다.)</p>
                            </td>
                        </tr>
                    </table>
	                <!--/게시판 영역-->
	            </div>
	            <!--/main_table-->
	            <div class="btn-c">
	                <input class="chost_btn_s" type="submit" value="수정" />
	                <a class="btmore09" href="javascript:void(0);" onclick="if(window.confirm('수정한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/site/index.html'">취소</a>
	            </div>
	        </li>
	    </ul>
	</div><!--/content-->
	</form:form>
<<jsp:include page="../../end.jsp" flush="false" />