<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<html>
<head>
	<title>Archive Popup</title>
	<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
</head>
<body>
<body style="background:none;">
<div id="content">
					<ul class="homepagebbs">
						<li class="bg"><h3 class="sub">아카이브 연결</h3>
						<archv id="path" value="${input.path }" />
						 <%-- <c:import url="/WEB-INF/jsp/zcms/admsys/archv/catgry/select.jsp"></c:import> --%>
						</li>
						<li>
                        <div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="CSS리스트">
		<colgroup>
			<col style="width:5%;" />
			<col style="width:5%;" />
			<col style="width:15%" />
			<col style="width:5%;" />
			<col />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">선택</th>
				<th scope="col">번호</th>
				<th scope="col">옵션</th>
				<th scope="col">언어</th>
				<th scope="col">제목</th>
			</tr>
		</thead>
		<tbody class="type">
		<c:forEach items="${list}" var="each">
			<tr>
				<td>
					<c:choose>
						<c:when test="${input.mlt == 'y' }">
							<input type="checkbox" name="archv_no[]" value="${each.archv_no }">
						</c:when>
						<c:otherwise>
							<input type="radio" name="archv_no"  value="${each.archv_no }">
						</c:otherwise>
					</c:choose>
				</td>
				<td>${each.archv_no }</td>
				<td>${each.opt_name }</td>
				<td>
					<c:choose>
						<c:when test="${each.lang == '0' }">국문</c:when>
						<c:when test="${each.lang == '1' }">영문</c:when>
					</c:choose>
				</td>
				<%-- <td><subs:substringOut str='${data.title }' length='40' /></td> <!--임시로 제목이 모두보이게 처리-->--%>
				<td class="subject">
					<span class="img_area ">
						<%-- <a href="/admsys/evnt/update.html?evnt_no=${data.evnt_no}&evnt_opt_cd=${data.evnt_opt_cd}"> --%>
						<a href="javascript:void(0);">
							<img width="80" height="60" src="${image_path_thbnail}/${each.thbnail}" onError="this.src='${image_path_thbnail}/noimg.gif'" />
						</a>
					</span>
					${each.title }
				</td>
			</tr>
		</c:forEach>
		<c:if test="${input.total==0}">
			<tr>
				<td colspan="5" style="padding:20;">기록이 없습니다.</td>
			</tr>
		</c:if>
		</tbody>
	</table>
	<form name="frm" method="post">
		<input type="hidden" name="type" id="type" value="1">
		<input type="hidden" name="mlt" id="mlt" value="${input.mlt }">
		<input type="hidden" name="ftn" id="ftn" value="${input.ftn }">
		<input type="hidden" name="opt_no" id="opt_no" value="${input.opt_no }">
		<input type="hidden" name="catgry_cd" id="catgry_cd" value="${input.catgry_cd }">
		<input type="hidden" name="keyword" value="${input.keyword}">
	</form>
<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
</div>

<div class="btn-c">
      <input class="chost_btn_s" type="submit" value="확인" onclick="javascript:${input.ftn}(_get_value()); return false;"/>
      <a class="btmore09" href="javascript:self.close();">닫기</a>
  </div>
</body>
${js_url }
</html>