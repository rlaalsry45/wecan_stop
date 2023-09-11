<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="../../header.jsp" flush="true" />
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/user/common/" title="회원 목록으로 이동">회원 관리</a>
						&gt;
						<span>회원정보 수정</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="page_title">
				<h2>
					<img src="/cms/image/tit_user_modify.jpg" alt="회원정보 수정" />
				</h2>
			</div>
			<form name="frm" method="post" onsubmit="return checkForm()">
				<input name="act" type="hidden" value="update" />
				<div id="content">
					<div class="main_table">
						<!---게시판 영역------------------------->
						<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="게시판수정">
							<caption>회원수정</caption>
							<colgroup>
								<col width="150" />
								<col width="" />
							</colgroup>
							<tr>
								<th>아이디</th>
								<td>${result.userid}</td>
							</tr>
							<tr>
								<th>회원본명</th>
								<td>${result.username}</td>
							</tr>
							<tr>
								<th>별명</th>
								<td>${result.usernick}</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>${result.useremail}</td>
							</tr>
							<tr>
								<th>회원상태</th>
								<td>
									<input class="radio0" type="radio" name="mamber_radio1" checked />
									정회원
									<input class="radio1" type="radio" name="mamber_radio1" onclick="alert('해당 회원이 사이트에서 탈퇴 처리 되고 아이디가 영구삭제 됩니다. 계속 하시겠습니까?');" / />
									강제 탈퇴
								</td><!-- 강제탈퇴 선택시 확인 알림창 떠야함 -->
							</tr>
							<tr>
								<th>회원등급</th><!--회원 로그인시에는 비활성화/ 관리자로 로그인시 수정 가능-->
								<td>
									<select>
										<option>9</option>
										<option>8</option>
										<option>7</option>
										<option>6</option>
										<option>5</option>
										<option>4</option>
										<option>3</option>
										<option>2</option>
										<option>1</option>
									</select>
									(9: 모두공개 ~ 1:최고권한)
								</td>
							</tr>
							<tr>
								<th>주소</th>
								<td>
									<p>
										<input type="text" class="bor1ddd" value='<c:out value="${fn:substring(result.useraddrno,0,3)}" />' />
										-
										<input type="text" class="bor1ddd" value='<c:out value="${fn:substring(result.useraddrno,3,6)}" />' />
										<a href="#"><img src="/cms/image/btn_add.gif" alt="우편번호검색" /></a>
									</p>
									<p>
										<input type="text" class="bor1ddd" size="80" value="${result.useraddr}" />
									</p>
									<p>
										<input type="text" class="bor1ddd" size="80" value="${result.useraddr}" />
									</p>
								</td>
							<tr>
							<tr>
								<th>연락처</th>
								<td>
									<input type="text" class="bor1ddd" value="${result.usertel}" size="12" />
								</td>
							<tr>
							<tr>
								<th>모바일</th>
								<td>
									<input type="text" class="bor1ddd" value="${result.usermobile}" size="12" />
								</td>
							<tr>
							<tr>
								<th>성별</th>
								<td>
									<input class="radio0" type="radio" name="mamber_sex" <c:if test="${result.usersex=='1'}">checked</c:if> />
									남성
									<input class="radio1" type="radio" name="mamber_sex" <c:if test="${result.usersex=='2'}">checked</c:if>/>
									여성
								</td>
							<tr>
							<tr>
								<th>정보공개</th>
								<td>
									<input type="checkbox" class="checkbox1" />
									중요메일 수신(회원정보 변동 등)
									<input type="checkbox" class="checkbox1" />
									정보메일 수신
									<input type="checkbox" class="checkbox1" />
									문자 수신
								</td>
							</tr>
							<tr>
								<th>자기소개</th>
								<td>
									<textarea class="bor1ddd" style="width:100%" rows="5" /></textarea>
								</td>
							<tr>
							<tr>
								<th>메모</th>
								<td>
									<textarea class="bor1ddd" style="width:100%" rows="5" /></textarea>
								</td>
							<tr>
							<tr>
								<th>가입</th>
								<td>${result.userdatereg}</td>
							</tr>
							<tr>
								<th>탈퇴</th>
								<td></td>
							</tr>
						</table>
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
					<!--/사이트 추가-->
					<div class="confirm">
						<p>
							<input type="image" src="/cms/image/btn_confirm.jpg" alt="수정" />
							<a href="javascript:void(0);" onclick="if(window.confirm('수정한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='index.html'">
								<img src="/cms/image/btn_cancel.jpg" alt="취소" />
							</a>
						</p>
					</div><!--/confirm-->
				</div><!--/content-->
			</form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>