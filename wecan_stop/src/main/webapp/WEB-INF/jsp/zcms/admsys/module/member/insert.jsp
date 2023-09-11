<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
	<div id="container">
		<c:import url="../../lnb.jsp" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/index.html" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/module/member/index.html" title="모듈관리로 이동">모듈관리</a>
						&gt;
						<a href="/admsys/module/member/index.html" title="회원/로그인폼목록으로 이동">회원/로그인폼목록</a>
						&gt;
						<span>회원/로그인폼등록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="page_title">
				<h2>
					<img src="/cms/image/tit_etc_member_insert.jpg" alt="회원/로그인폼등록" />
				</h2>
			</div>
			<form:form modelAttribute="zMemberVo" name="frm" method="post">
			<input name="act" type="hidden" v= "insert" />
			<div id="content">
				<div class="main_table">
				<!---게시판 영역------------------------->
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="회원/로그인폼등록">
					<caption>회원/로그인폼등록</caption>
					<colgroup>
						<col width="150" />
						<col width="" />
					</colgroup>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="title" id="title" class="bor1ddd" size="50" />
						</td>
					</tr>
					<tr>
						<th>스킨설정</th>
						<td>
							<select name="skin">
								<option selected value="">-스킨 선택-</option>
								<c:forEach items="${skinlist}" var="each">
								<option value='${each}'>${each}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>이용약관 내용</th>
						<td>
							<input type=radio class="radio0" name="contstype2" value="1" checked onclick="selArea2(1,2)" />
							HTML
							<input type=radio class="radio1" name="contstype2" value="3" onclick="selArea2(3,2)" />
							웹에디터
							<div id="txtarea2">
								<textarea class="bor1ddd" name="conts2" id="conts2" style="width:95%" rows="15"></textarea>
							</div>
							<div id="editorarea2" style="width:96%;display:none">
								<c:import url="/var/editor/index2.jsp" />
							</div>
						</td>
					</tr>
					<tr>
						<th>개인정보 보호정책 내용</th>
						<td>
							<input type=radio class="radio0" name="contstype3" value="1" checked onclick="selArea2(1,3)" />
							HTML
							<input type=radio class="radio1" name="contstype3" value="3" onclick="selArea2(3,3)" />
							웹에디터
							<div id="txtarea3">
								<textarea class="bor1ddd" name="conts3" id="conts3" style="width:95%" rows="15"></textarea>
							</div>
							<div id="editorarea3" style="width:96%;display:none">
								<c:import url="/var/editor/index3.jsp" />
							</div>
						</td>
					</tr>
					<tr>
						<th>회원가입 폼 내용</th>
						<td>
							<input type=radio class="radio0" name="contstype4" value="1" checked onclick="selArea2(1,4)" />
							HTML
							<input type=radio class="radio1" name="contstype4" value="3" onclick="selArea2(3,4)" />
							웹에디터
							<div id="txtarea4">
								<textarea class="bor1ddd" name="conts4" id="conts4" style="width:95%" rows="15"></textarea>
							</div>
							<div id="editorarea4" style="width:96%;display:none">
								<c:import url="/var/editor/index4.jsp" />
							</div>
						</td>
					</tr>
					<tr>
						<th>로그인 폼 내용</th>
						<td>
							<input type=radio class="radio0" name="contstype5" value="1" checked onclick="selArea2(1,5)" />
							HTML
							<input type=radio class="radio1" name="contstype5" value="3" onclick="selArea2(3,5)" />
							웹에디터
							<div id="txtarea5">
								<textarea class="bor1ddd" name="conts5" id="conts5" style="width:95%" rows="15"></textarea>
							</div>
							<div id="editorarea5" style="width:96%;display:none">
								<c:import url="/var/editor/index5.jsp" />
							</div>
						</td>
					</tr>
					<tr>
						<th>메모</th>
						<td>
							<textarea class="bor1ddd" name="memo" style="width:95%" rows="8"></textarea>
						</td>
					</tr>
				</table>
				<!---/게시판 영역------------------------->
				</div><!--/main_table-->
				<div class="confirm">
					<p>
						<input type="image" src="/cms/image/btn_confirm.jpg" alt="등록" onclick="if(!window.confirm('저장하시겠습니까?')){return false;}" />
						<a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/module/member/index.html'">
							<img src="/cms/image/btn_cancel.jpg" alt="취소" />
						</a>
					</p>
				</div><!--/confirm-->
			</div><!--/content-->
			</form:form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>