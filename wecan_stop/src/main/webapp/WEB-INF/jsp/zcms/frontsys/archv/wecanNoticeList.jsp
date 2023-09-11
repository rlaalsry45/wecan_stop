<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<%
String strId = StringUtils.defaultIfBlank(request.getParameter("noticeNo"),"");
strId = StringUtils.deleteWhitespace(strId);
strId = StringUtils.replace(strId, "null", "");

if (StringUtils.isNotBlank(strId)) {%>
		<script>
	$.ajax({
		  type: 'POST',
		  url: "/front/archv/wecanNoticeView.html",
		  data:{archv_no:<%=strId%>, pageIndex:${input.pageIndex}, catgry_cd:${catgry_cd}},
		  success: function(result){
			  $("#changeArea").css("padding-top","0");
			  $("#changeArea").html(result);
		  },
		  error:function(e){
			  alert("조회중 오류가 발생하였습니다."+e.responseText  );
		  }
	});
	</script>
	    <div class="sub_top_wrap">
        <div class="w_1170">
            <div class="sub_top bg04">
                <p>정보</p>
                <div class="loca"><a href="">홈</a><span>정보</span><span>공지사항</span></div>
            </div>
        </div>
    </div>
    <div class="cont_wrap">
        <div class="w_1170">
            <div class="left_cont">
                <p>정보</p>
                <ul>
                    <li class="on"><a href="/?menuno=257">공지사항</a></li>
                    <li><a href="/?menuno=256">참고자료</a></li>
                </ul>
            </div>
            <div class="right_cont">
                <p class="p_t">공지사항</p>
                <form class="board_wrap" id="changeArea"> <!-- 211124 클래스명 추가 -->
                </form>
                <p class="notice_ment">궁금한 사항은 02-735-7544로 문의 부탁드립니다. 감사합니다.</p>
            </div>
        </div>
    </div>
<%} else {%>
    <div class="sub_top_wrap">
        <div class="w_1170">
            <div class="sub_top bg04">
                <p>정보</p>
                <div class="loca"><a href="">홈</a><span>정보</span><span>공지사항</span></div>
            </div>
        </div>
    </div>
    <div class="cont_wrap">
        <div class="w_1170">
            <div class="left_cont">
                <p>정보</p>
                <ul>
                    <li class="on"><a href="/?menuno=257">공지사항</a></li>
                    <li><a href="/?menuno=256">참고자료</a></li>
                </ul>
            </div>
            <div class="right_cont">
                <p class="p_t">공지사항</p>
                <form class="board_wrap" id="changeArea"> <!-- 211124 클래스명 추가 -->
                    <table class="board">
                        <colgroup>
                            <col width="7%">
                            <col width="*">
                            <col width="10%">
                            <col width="10%">
                            <col width="15%">
                        </colgroup>
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
								<th>첨부</th>
                                <th>작성자</th>
                                <th>작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="each">
                            <tr onclick="viewDetail('${each.archv_no}','${catgry_cd}')" style="cursor: pointer;">
                                <td>${each.rownum_}</td>
                                <td class="subject t_left"><div class="text-ellipsis"><p><subs:substringOut str='${each.title }' length='80' /></p></div></td>
                                <td><c:if test="${each.file_exists_yn eq 'Y'}"><img src="/cms/image/common/btn-file.png"></c:if></td>
                                <td>관리자</td>
                                <td><fmt:parseDate value="${each.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" var="isoDate" />
									<fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" /></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <pt:pageOut3 pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
                </form>
                <div class="board_search">
	                <select id="condition" name="condition">
						<option value="" <c:if test="${input.condition eq ''}">selected</c:if>>선택</option>
						<option value="title" <c:if test="${input.condition eq 'title'}">selected</c:if>>제목</option>
						<option value="content" <c:if test="${input.condition eq 'content'}">selected</c:if>>내용</option>
						<option value="sc_all" <c:if test="${input.condition eq 'sc_all'}">selected</c:if>>제목+내용</option>
					</select>
					<input type="text" id="keyword" name="keyword" value="${input.keyword }" title="검색어 입력" />
					<a href="javascript:boardSearch();" class="search_btn">검색</a>
				</div>
				<div class="board_ment">
                	<p class="notice_ment">궁금한 사항은 02-735-7544로 문의 부탁드립니다. 감사합니다.</p>
            	</div>
            </div>
        </div>
    </div>
		<form name="frm" method="post">
			<input type="hidden" id="catgry_cd" name="catgry_cd" value="${input.catgry_cd }">
			<input type="hidden" id="keyword" name="keyword" value="${input.keyword }">
		</form>
			<script>
			function viewDetail(archv_no){
				$.ajax({
					  type: 'POST',
					  url: "/front/archv/wecanNoticeView.html",
					  data:{archv_no:archv_no, pageIndex:${input.pageIndex}, catgry_cd:${catgry_cd}},
					  success: function(result){
						  $("#changeArea").css("padding-top","0");
						  $("#changeArea").html(result);
					  },
					  error:function(e){
						  alert("조회중 오류가 발생하였습니다."+e.responseText  );
					  }
				});
				
				
				//location.href = "/admsys/archv/data/orgInfoView.html?archv_no="+archv_no
				//+"&pageIndex=1&opt_no=5&catgry_cd=401";
			}

			function goPaging(arg){
				$.ajax({
					  type: 'POST',
					  url: "/front/archv/wecanNoticeList.html",
					  data:{pageIndex:arg, catgry_cd:${catgry_cd}},					  
					  success: function(result){
						  $("#wecanNoticeList").html(result);
					  },
					  error:function(e){
						  alert("조회중 오류가 발생하였습니다."+e.responseText  );
					  }
				});
			}

			function boardSearch(){
				$.ajax({
					type: 'POST',
					url: "/front/archv/wecanNoticeList.html",
					data:{pageIndex:1, catgry_cd:${catgry_cd}, keyword:$('#keyword').val(), condition:$('#condition').val()},
					success: function(result){
						$("#wecanNoticeList").html(result);
					},
					error:function(e){
						alert("조회중 오류가 발생하였습니다."+e.responseText  );
					}
				});
			}
			
			</script>
			<%}%>