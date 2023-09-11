<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<script type="text/javascript">
function lang_name_change(catgry_cd){

	var name_1 = encodeURI($("#"+catgry_cd+"_name_1").val());
	name_1 = name_1.replace('&','Æ');
	$.ajax({
		type: 'post'
		, async: true
		, url: '/admsys/archv/data/lang_name_change.html'
		, data: "name_1="+name_1+"&catgry_cd="+catgry_cd
		, success: function(data) {
			alert('수정되었습니다.');
		}
		, error: function(data, status, err) {
			alert('서버와의 통신이 실패했습니다.');
		}
	});

}
</script>

<jsp:include page="../../lnb.jsp" flush="true" />
<div id="contents">
	<div class="contents_top">
              <div class="location">
                  <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/archv/catgry/">아카이브</a> <strong>분류관리</strong>
              </div>
          </div>

          <div id="content">
           <ul class="homepagebbs">
               <li class="bg"><h3 class="bbs">언어관리</h3></li>
               <li>
                   <div class="main_table">
                   <form:form modelAttribute="evntVO" name="frm" method="post">
					<input type="hidden" name="evnt_opt_cd" value="${evnt_opt_cd}" />
                    <table class="main_table1" summary="번호, 그룹, 소속게시판, 그룹관리자, 관리">
							<caption>목록</caption>
							<colgroup>
								<col width="5%" />
								<col />
								<col />
								<col width="189px" />
							</colgroup>
							<thead>
								<tr>
									<th scope="col">Level</th>
									<th scope="col">국문</th>
									<th scope="col">영문</th>
									<th scope="col">수정</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="each" varStatus="loop">
							<tr>
								<td>${each.level-1 } </td>
								<td style="padding-left:${each.level*20}px;" class="menu_btn_manage ">${each.name}</td>
								<td><input size="40" id="${each.catgry_cd}_name_1" value="${each.name_1}" style="height:24px;width:400px;" /></td>
								<td><a class="btmore04" href="javascript:lang_name_change('${each.catgry_cd}')">수정</a></td>
							</tr>
							</c:forEach>
						</tbody>
						</table>
<%-- 						<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' /> --%>
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
				 	</li>
             	 </ul>
				</div><!--/content-->
			</form:form>
		</div><!--/r_side-->
	<jsp:include page="../../end.jsp" flush="false" />