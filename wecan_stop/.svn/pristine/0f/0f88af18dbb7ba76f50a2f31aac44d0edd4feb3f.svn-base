<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file = "/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자::상품선택</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
<meta name="Keywords" content="z5 cms"/>
<meta name="decription" content="z5 cms"/>
<meta name="author" content="z5 cms"/>
<meta name="classification" content="z5 cms"/>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">

function sel(seq,name){

	var pseq = $("#pseq").val();

	window.opener.select_product(pseq,seq, name);
	//window.opener.location.reload();
	self.close();
}

</script>
</head>
<body style="background:none;">
    <div id="content" style="margin:10px 10px 0 10px;">
        <ul class="homepagebbs">
            <li class="bg">
                <h3 class="bbs">상품선택</h3>
            </li>
            <li>
                <form:form modelAttribute="zBoardVo" method="post">
                	<input type="hidden" name="pseq" id="pseq" value="${input.pseq }"/>
                	<div class="contents_top">
						<div class="TopSearch">
							<span>SEARCH AREA</span>
							<select style="height:27px;" name="cond2">
								<option value="bbstitle" <c:if test="${input.cond2=='bbstitle'}"><c:out value='selected' /></c:if>>상품명</option>
							</select>
							<input type=text name="keyword" class="bor1ddd" value="<c:out value='${input.keyword}' />"  style="width:128px;" />
							<input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'" />
						</div>
					</div>
                    <div class="main_table">
                         <table class="main_table1" summary="번호, 제목, 사용현황, 등록일, 관리">
                                <caption>배너리스트</caption>
                                <colgroup>
                                    <col width="5%" />
                                    <col width="10%" />
                                    <col width="" />
									<col width="160" />
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th>NO</th>
                                        <th>분류</th>
                                        <th>상품명</th>
                                        <th>선택</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${list}" var="each" varStatus="loop">
                                        <tr>
                                            <td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' /></td>
                                            <td>
                                            <c:if test="${each.bbscatenos eq '656'}">식품</c:if>
                                            <c:if test="${each.bbscatenos eq '657'}">한식</c:if>
                                            <c:if test="${each.bbscatenos eq '658'}">공예품</c:if>
                                            <c:if test="${each.bbscatenos eq '659'}">한복</c:if>
                                            <c:if test="${each.bbscatenos eq '660'}">문화콘텐츠</c:if>
                                            </td>
                                           	<td>
                                                <c:out value='${each.bbstitle}' />
                                            </td>
                                            <td>
                                                <a class="btmore09" href="#" onclick="sel('${each.bbsno}','${each.bbstitle}')">선택</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${input.total==0}">
                                        <tr>
											<td colspan="6" style="padding:20;">기록이 없습니다.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                    </div>
                    <!--/main_table-->
                    <div class="btn-c-B">
                            <a class="btmore09" href="javascript:self.close();">닫기</a>
                    </div>
                    <!--/confirm-->
                </form:form>
            </li>
        </ul>
    </div>
</body>
</html>