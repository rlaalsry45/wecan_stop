<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript">
history.navigationMode = 'compatible'; // 오페라, 사파리 뒤로가기 막기
function _no_Back(){window.history.forward(0);}

window.onload=function(){
}

function addeducation(){
	var tblappend = $("tbody[name=academicbody]").length;
	var academicno = tblappend+1;
	$("#academic").append('<tbody id="academicbody'+academicno+'" name="academicbody">\
			\n<tr class="first">\
			\n<th scope="row"><label for="education">학력</label></th>\
			\n<td>\
			\n<select id="education'+academicno+'" name="education" >\
			\n<option value="">----학력선택----</option>\
			\n<c:forEach var="each" items="${education}" varStatus="loop">\
			\n<option value="${each.code}">${each.codeNm}</option>\
			\n</c:forEach>\
			\n</select>\
			\n* 학력별로 한개씩만 입력할 수 있습니다.\
			\n</td>\
			\n</tr>\
			\n<tr>\
			\n<th scope="row"><label for="graduation">졸업년도</label></th>\
			\n<td>\
			\n<select id="graduation'+academicno+'" name="graduation" style="width:150px;">\
			\n<option value="">졸업년도 선택</option>\
			\n</select>\
			\n</td>\
			\n</tr>\
			\n<tr>\
			\n<th scope="row"><label for="degrees">학 위</label></th>\
			\n<td>\
			\n<select id="degrees'+academicno+'" name="degrees" style="width:150px;">\
			\n<option value="">----학위 선택----</option>\
			\n<c:forEach var="each" items="${degrees}" varStatus="status2">\
			\n<option value="${each.code}">${each.codeNm}</option>\
			\n</c:forEach>\
			\n</select>\
			\n</td>\
			\n</tr>\
			\n<tr>\
			\n<th scope="row"><label for="school">학 교</label></th>\
			\n<td>\
			\n<input type="text" class="text" id="writeschool'+academicno+'" name="university2" title="학교이름 입력" style="width:226px;height:17px;" />\
			\n<p class="text">* 대학 및 기타 학교는 직접 기입해주세요!<br />외국대학의 경우 학교명뒤에 국적을 입력하세요. (반드시 한글로 입력) <br />예) 미시간대(미) </p>\
			\n</td>\
			\n</tr>\
			\n<tr>\
			\n<th scope="row"><label for="lesson">학 과</label></th>\
			\n<td><input type="text" class="text" id="lesson'+academicno+'" name="major" title="학과이름 입력" style="width:315px;height:17px;" /></td>\
			\n</tr>\
			\n</body>');
	makeyearselect(academicno);
}
</script>
<body onload="_no_Back();" onpageshow="if(event.persisted)_no_Back();">
</body>
				<div class="cont-right">
					<h3 class="ctit">회원정보수정</h3>
					<h4 class="stit">회원정보</h4>
					<p class="text03">개인회원(정회원,준회원)을 회원정보를 수정하는 곳입니다. 단체회원(기업,기관,단체회원)은 학회사무국으로 연락 주십시오.</p>
					<h5 class="sstit">신상정보 </h5>
					<p class="text"><img src="/usr/image/common/icon/icon_star.png" alt="별표" /> 는 필수 입력 항목 입니다.</p>
					<form name="frm" id="frm" method="post"  enctype="multipart/form-data">

						<input type="hidden" name="no" value="${no}" />
						<input type="hidden" name="type" value="${type}" />
						<input type="hidden" name="skin" value="${skin}" />
						<input type="hidden" name="siteno" value="${siteno}" />

						<input type="hidden" name="act" id="act" value="join" />
						<input type="hidden" name="menuno" id="menuno" value="${menuno }" />
						<input type="hidden" id="work_grade" value="${userdata.work_grade }" />
						<table class="board-write" summary="아이디, 비밀번호, 비밀번호 확인, 성명(한글), 성명(한자), 성명(영문), 생년월일, E-mail, 우편물 수령">
							<caption>회원등록</caption>
							<colgroup>
								<col style="width:20%;" />
								<col style="width:80%;" />
							</colgroup>
							<tbody>
								<tr>
									<th scope="row"><label for="no">회원번호</label></th>
									<td><input type="text" class="text" title="회원번호" style="width:226px;height:17px;" value="${userdata.useridx}" readonly/>
								</tr>
								<tr>
									<th scope="row"><label for="id">아이디</label></th>
									<td>
										<input type="text" class="text" id="userid" name="userid" title="아이디 입력" maxlength="8" style="width:226px;height:17px;" value="${userdata.userid}" readonly />
										<!-- <a href="javascript:"><img src="/usr/image/common/btn/btn_reduplic.gif" alt="중복확인" /></a> -->
										4~8 이내 영문, 숫자(특수문자 제외)
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="pass">비밀번호</label></th>
									<td><input type="password" class="text" id="userpasswd" name="userpasswd" title="비밀번호 입력" style="width:226px;height:17px;" /> 6자 이상의 영문+숫자</td>
								</tr>
								<tr>
									<th scope="row"><label for="pass02">비밀번호 확인</label></th>
									<td><input type="password" class="text" id="userpasswdchk" name="userpasswdchk" title="비밀번호 재확인 입력" style="width:226px;height:17px;" /></td>
								</tr>
								<tr>
									<th scope="row"><label for="kname">성명 (한글)</label></th>
									<td><input type="text" class="text" id="username" name="username" title="한글이름 입력" style="width:226px;height:17px;" value="${userdata.username}" readonly /> (예: 홍길동)</td>
								</tr>

								<c:if test="${userdata.work_grade ne '7'}"><!-- 단체회원이 아닐경우 -->
									<tr>
										<th scope="row"><label for="cname" style="background:none;">성명 (한자)</label></th>
										<td><input type="text" class="text" id="usercname" name="usercname" title="한자이름 입력" style="width:226px;height:17px;" value="${userdata2.usercname}" /></td>
									</tr>
									<tr>
										<th scope="row"><label for="ename" style="background:none;">성명 (영문)</label></th>
										<td><input type="text" class="text" id="userename" name="Username2" title="영문이름 입력" style="width:226px;height:17px;" value="${userdata.username2}" /> (예: Hong,Kil-Dong)</td>
									</tr>
									<tr>
										<th scope="row"><label for="years">생년월일</label></th>
										<td class="select">
											<input type="text" class="text" name="userbirth"  id="years" title="생년월일" style="width:144px;height:17px;" value="${userdata.userbirth}" readonly/>
											<input type="radio" readonly <c:if test="${userdata.usersex eq '1'}">checked</c:if><c:if test="${userdata.usersex eq '0'}"> disabled</c:if> class="radio" id="guy" name="usersex" value="1" />
											<label for="guy">남</label>
											<input type="radio" readonly <c:if test="${userdata.usersex eq '0'}">checked</c:if><c:if test="${userdata.usersex eq '1'}"> disabled</c:if>  class="radio" id="girl" name="usersex" value="0" />
											<label for="girl">여</label>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="email">이메일</label></th>
										<td>
											<c:set var="useremail" value="${fn:split(userdata.useremail,'@')}" />
											<input type="text" class="text" id="useremailid" name="useremailid" title="이메일 주소 입력" style="width:104px;height:17px;" value="${useremail[0]}" />
											@
											<input type="text" class="text" id="useremaildomain" name="useremaildomain" title="이메일 주소 입력" style="width:103px;height:17px;" value="${useremail[1]}" />
											<select id="selectdomain" style="width:101px;height:21px;">
												<option value="">직접입력</option>
												<c:forEach var="domain" items="${emaildomain}" varStatus="loop">
													<option value="${domain.code}">${domain.code}</option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="newsletter1">이메일수신</label></th>
										<td>
											동의함<input type="radio" value="1" <c:if test="${userdata.newsletter1 eq '1'}">checked</c:if> class="text" id="newsletter1" name="newsletter1" title="이메일 수신" style="border:0px;" />
											동의안함<input type="radio" value="0" <c:if test="${userdata.newsletter1 ne '1'}">checked</c:if> class="text" id="newsletter1" name="newsletter1" title="이메일 수신" style="border:0px;" />
											<!-- 이 메일 수신을 원하지 않을 경우에는 체크를 해제 해 주시기 바랍니다. -->
										</td>
									</tr>
								</c:if>


							</tbody>
						</table>

						<c:if test="${userdata.work_grade ne '7'}"> <!-- 단체회원이 아닐경우 -->
							<table class="board-write mgtype20" summary="프로필 사진, 회원종류, 지회선택, 자택, 직장/대학원, 추천인, 추천서">
								<caption>회원등록</caption>
								<colgroup>
									<col style="width:20%;" />
									<col style="width:80%;" />
								</colgroup>
								<tbody>
									<%-- <tr>
										<th scope="row">프로필 사진</th>
										<td>
											<div class="profile">
												<span><img id="photo" name="photo" style="width:90px;height:120px;" src="/usr/upload/board_thumb/${userdata2.photosave}" onError="this.src='/usr/image/member/no_images.gif'" alt="프로필 사진" /></span>

												<input type="hidden" name="photoorg" value="${userdata2.photoorg}" />
												<input type="hidden" name="photosave" value="${userdata2.photosave}" />

												<input type="file" name="imgfile" id="photofile" />

												<p>3*4 사이즈에 맞게 올려주세요</p>
											</div>
										</td>
									</tr> --%>
									<tr>
										<%-- <th scope="row"><label for="category">회원종류</label></th>
										<td>
											<select id="category" name="work_grade">
												<option value="">회원분류</option>
												<option value="1" <c:if test="${userdata.work_grade eq '1'}">selected</c:if> >정회원</option>
												<option value="2" <c:if test="${userdata.work_grade eq '2'}">selected</c:if> >종신회원</option>
												<option value="3" <c:if test="${userdata.work_grade eq '3'}">selected</c:if> >준회원(학부생)</option>
											</select>
											※ 회원종류 안내 : 준회원 가입은 자격여부을 위해 학회에 문의
										</td> --%>
										<script type="text/javascript">
											$(function() {
											    $("#category").change(function(){
											    	if($("#category").val() == '3'){
											    		alert("준회원(학부생)의 경우 관리자에게 서류제출 후 승인을 받아야 합니다. 재학증명서(3개월이내)를 첨부해주시기 바랍니다.");
											    	}
											    });
											});

											function showsemimemberdocu(path){
												var url = "/skin/member/showsemimemberdocu.html?path="+path;
												var windowName = "showsemimemberdocu";
												var windowWidth = 800;
												var windowHeight = 800;
												var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
												var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
												var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
												window.open(url, windowName, windowSize);
											}
										</script>
									</tr>
									<c:if test="${userdata.work_grade eq '3' }">
										<tr>
											<th scope="row">재학증명서 첨부</th>
											<td>
												<input type="hidden" name="semimemberdocuorg" value="${userdata2.semimemberdocuorg}" />
												<input type="hidden" name="semimemberdocusave" value="${userdata2.semimemberdocusave}" />
												<input type="file" name="semimemberdocu" id="semimemberdocu" />
												<c:if test="${userdata2.semimemberdocuorg ne null}">
													<a href="javascript:showsemimemberdocu('${userdata2.semimemberdocusave}');">첨부증명서 보기(${userdata2.semimemberdocuorg})</a>
												</c:if>
											</td>
										</tr>
									</c:if>
									<tr>
										<th scope="row"><label for="branch">지회선택</label></th>
										<td>
											<select id="branch" name="branch">
												<option value="">------------</option>
												<c:forEach var="each" items="${branch}" varStatus="loop">
													<option value="${each.code}" <c:if test="${userdata2.branch eq each.code}">selected</c:if>>${each.codeNm}</option>
												</c:forEach>
											</select><!-- 제주 부산울산경남, 대전세종충청 -->
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="category">자택</label></th>
										<td>
											<input type="text" class="text" id="useraddrno1" name="useraddrno1" title="우편번호 입력" style="width:104px;height:17px;" maxlength="10" value="${userdata.useraddrno}" readonly />
											<%-- -
											<input type="text" class="text" id="useraddrno2" name="useraddrno2" title="우편번호 입력" style="width:104px;height:17px;" value="${fn:substring(userdata.useraddrno,3,6)}" readonly /> --%>
											<a href="javascript:postsearch();" id="postsearch"><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호찾기" /></a>
											<input type="checkbox" id="dwritechk" style="vertical-align: middle;">직접입력
											<input type="text" class="text block" id="useraddr" name="useraddr" title="주소 입력" style="width:415px;height:17px;" value="${userdata.useraddr}" readonly />
											<input type="text" class="text block" id="useraddr2" name="useraddr2" title="상세주소 입력" style="width:415px;height:17px;" value="${userdata.useraddr2}" />
											<ul class="type02">
												<li>
													<label for="hand">휴대전화</label>
													<c:set var="mobile" value="${fn:split(userdata.usermobile,'-')}" />
													<input type="text" class="text" id="usermobile1" name="usermobile1" title="지역번호 입력" style="width:72px;height:17px;" maxlength="3" value="${mobile[0]}" />
													-
													<input type="text" class="text" id="usermobile2" name="usermobile2" title="중간 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" value="${mobile[1]}" />
													-
													<input type="text" class="text" id="usermobile3" name="usermobile3" title="마지막 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" value="${mobile[2]}" />
												</li>
												<li>
													<label for="phone">자택전화</label>
													<input type="text" class="text"name="usertelco" title="국가코드" style="width:72px;height:17px;" maxlength="4" value="${userdata.usertelco }"/>(국가코드, 국내는 생략가능)<br>
													<c:set var="tel" value="${fn:split(userdata.usertel,'-')}" />
													<input type="text" class="text" id="usertel1" name="usertel1" title="지역번호 입력" style="width:72px;height:17px;margin-left:  53px;margin-top: 5px" maxlength="3"  value="${tel[0]}" />
													-
													<input type="text" class="text" id="usertel2" name="usertel2" title="중간 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" value="${tel[1]}" />
													-
													<input type="text" class="text" id="usertel3" name="usertel3" title="마지막 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" value="${tel[2]}" />
												</li>
											</ul>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="category">소속</label></th>
										<td>
											<input type="text" class="text" id="cuseraddrno1" name="cuseraddrno1" title="우편번호 입력" style="width:104px;height:17px;" maxlength="10" value="${userdata2.usercaddrno}" readonly/>
											<%-- -
											<input type="text" class="text" id="cuseraddrno2" name="cuseraddrno2" title="우편번호 입력" style="width:104px;height:17px;" value="${fn:substring(userdata2.usercaddrno,3,6)}" readonly/> --%>
											<a href="javascript:postsearch('c')"><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호찾기" /></a>
											<input type="checkbox" id="dwritechk2" style="vertical-align: middle;">직접입력
											<input type="text" class="text block" id="cuseraddr" name="usercaddr" title="주소 입력" style="width:415px;height:17px;" value="${userdata2.usercaddr}" readonly/>
											<input type="text" class="text block" id="cuseraddr2" name="usercaddr2" title="상세주소 입력" style="width:415px;height:17px;" value="${userdata2.usercaddr2}" />
											<ul class="type02">
												<li>
													<label for="rectal">직장명</label>
													<input type="text" class="text" id="rectal" name="usercompanyname" title="직장명 입력" style="width:260px;height:17px;" value="${userdata2.usercompanyname}" />
												</li>
												<li>
													<label for="department">부 서</label>
													<input type="text" class="text" id="department" name="dept_full_nm" title="부서명 입력" style="width:260px;height:17px;" value="${userdata2.dept_full_nm}" />
												</li>
												<li>
													<label for="title">직 책</label>
													<input type="text" class="text" id="title" name="usercompanystatus" title="직책 입력" style="width:260px;height:17px;" value="${userdata2.usercompanystatus}" />
												</li>
												<li>
													<label for="phone02">전 화</label>
													<input type="text" class="text"name="tel_offcco" title="국가코드" style="width:72px;height:17px;" maxlength="4" value="${userdata2.tel_offcco }"/>(국가코드, 국내는 생략가능)<br>
													<c:set var="teloffc" value="${fn:split(userdata2.tel_offc,'-')}" />
													<input type="text" class="text" id="cusertel1" name="cusertel1" title="지역번호 입력" style="width:72px;height:17px;margin-left:  53px;margin-top: 5px" maxlength="3" value="${teloffc[0]}" />
													-
													<input type="text" class="text" id="cusertel2" name="cusertel2" title="중간 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" value="${teloffc[1]}" />
													-
													<input type="text" class="text" id="cusertel3" name="cusertel3" title="마지막 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" value="${teloffc[2]}" />
												</li>
												<li>
													<label for="FAX">FAX</label>
													<input type="text" class="text"name="userfaxco" title="국가코드" style="width:72px;height:17px;" maxlength="4" value="${userdata.userfaxco }"/>(국가코드, 국내는 생략가능)<br>
													<c:set var="fax" value="${fn:split(userdata.userfax,'-')}" />
													<input type="text" class="text" id="cuserfax1" name="cuserfax1" title="지역번호 입력" style="width:72px;height:17px;margin-left:  53px;margin-top: 5px" maxlength="3" value="${fax[0]}" />
													-
													<input type="text" class="text" id="cuserfax2" name="cuserfax2" title="중간 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" value="${fax[1]}" />
													-
													<input type="text" class="text" id="cuserfax3" name="cuserfax3" title="마지막 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" value="${fax[2]}" />
												</li>
											</ul>
										</td>
									</tr>
									<tr>
										<th scope="row">우편물수령지</th>
										<td>
											<input type="radio" name="postuserselect" value="1" <c:if test="${userdata2.postuserselect eq '1'}"> checked</c:if> id="post1" class="check"  />
											<label for="new">자택과 동일</label>
											<input type="radio" name="postuserselect" value="2" <c:if test="${userdata2.postuserselect ne '1'}"> checked</c:if> id="post2" class="check"  />
											<label for="new">소속과 동일</label>
											<%--
											<input type="checkbox" name="post1" id="post1" class="check" onclick="if(this.checked){sameaddr(1);}" />
											<label for="new">자택과 동일</label>
											<input type="checkbox" name="post2" id="post2" class="check" onclick="if(this.checked){sameaddr(2);}" />
											<label for="new">소속과 동일</label>
											</br>
											<input type="text" class="text" id="postuseraddrno1" name="postuseraddrno1" title="우편번호 입력" style="width:104px;height:17px;" value="${fn:substring(userdata2.postuseraddrno,0,3)}" readonly />
											-
											<input type="text" class="text" id="postuseraddrno2" name="postuseraddrno2" title="우편번호 입력" style="width:104px;height:17px;" value="${fn:substring(userdata2.postuseraddrno,3,6)}" readonly />
											<a href="javascript:postsearch('post');" id="postsearch"><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호찾기" /></a>
											<input type="text" class="text block" id="postuseraddr" name="postuseraddr" title="주소 입력" style="width:315px;height:17px;" value="${userdata2.postuseraddr}" readonly />
											<input type="text" class="text block" id="postuseraddr2" name="postuseraddr2" title="상세주소 입력" style="width:315px;height:17px;" value="${userdata2.postuseraddr2}" /> --%>
										</td>
									</tr>

									<tr>
										<th scope="row"><label for="referee">추천인</label></th>
										<td>
											<input type="text" class="text" id="referee" title="추천인 입력" style="width:226px;height:17px;" value="${userdata2.nominatornm}" />
											<input type="hidden" class="text" id="refereeNo" name="nominator" value="${userdata2.nominator}"/>
											<a href="javascript:searchUser();"><img src="/usr/image/common/btn/btn_search06.gif" alt="추천인 검색" /></a>
										</td>
										<script type="text/javascript">
											function searchUser(){
												var url = "/front/user/popupUserListForJoin.html";
												var windowName = "search_user";
												var windowWidth = 468;
												var windowHeight = 360;
												var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
												var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
												var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
												window.open(url, windowName, windowSize);
											}
											function select_user(userno, userid, username){
												$("#referee").val(username);
												$("#refereeNo").val(userno);
											}
										</script>
									</tr>
									<%-- <tr>
										<th scope="row"><label for="recommen">추천서</label></th>
										<td>
											<input type="file" name="recommen" id="recommen" />

											<input type="hidden" name="nominatsave" value="${userdata2.nominatsave}" />
											<input type="hidden" name="nominattext" value="${userdata2.nominattext}" />

											<c:if test="${userdata2.nominattext ne null}">
												</br>현재추천서 : <a href="/usr/upload/board_thumb/${userdata2.nominatsave}" target="_blank" >${userdata2.nominattext}</a>
											</c:if>

										</td>
									</tr> --%>
								</tbody>
							</table>
							<h5 class="sstit">학력정보</h5>
							<div class="btn-r03">
								<a class="blue" href="javascript:addeducation();"><img src="/usr/image/common/btn/btn_info_add.gif" alt="학력정보 추가" /></a>
								<a class="gray" href="javascript:deleducation();"><img src="/usr/image/common/btn/btn_info_delete.gif" alt="학력정보 삭제" /></a>
							</div>
							<p class="text09">아래에서부터 순차적으로 삭제됩니다.</p>
							<p class="text10"><img src="/usr/image/common/icon/icon_star.png" alt="별표" /> 학 력(국가명, 학교명 및 학위를 정확히 기재합니다.)</p>
							<!-- <p><img src="/usr/image/common/icon/icon_star.png" alt="별표" /> 학 력(국가명, 학교명 및 학위를 정확히 기재합니다.)</p> -->
							<table class="board-write type" id="academic" name="academic" summary="학력, 졸업년도, 학위, 학교, 학과">
								<caption>학력정보</caption>
								<colgroup>
									<col style="width:20%;" />
									<col style="width:80%;" />
								</colgroup>
								<tr class="first">
									<th scope="row"><label for="education">최종학력</label></th>
									<td>
										<select id="" name="lasteducation" >
											<option value="">--최종학력선택--</option>
											<c:forEach var="each" items="${education}" varStatus="loop">
												<option value="${each.code}" <c:if test="${userdata2.lasteducation eq each.code}">selected</c:if>>${each.codeNm}</option>
											</c:forEach>
										</select>
										<!-- * 학력별로 한개씩만 입력할 수 있습니다. -->
									</td>
								</tr>
								<c:forEach var="academiclist" items="${useracademiclist}" varStatus="loop">
									<tbody id="academicbody${loop.count}" name="academicbody">
										<tr class="first">
											<th scope="row"><label for="education">학력</label></th>
											<td>
												<select id="education${loop.count}" name="education" >
													<option value="">----학력선택----</option>
													<c:forEach var="each" items="${education}" varStatus="status2">
														<option value="${each.code}" <c:if test="${academiclist.education eq each.code}">selected</c:if>>${each.codeNm}</option>
													</c:forEach>
												</select>
												<!-- * 학력별로 한개씩만 입력할 수 있습니다. -->
											</td>
										</tr>
										<tr>
											<th scope="row"><label for="graduation">졸업년도</label></th>
											<td>
												<input type="hidden" id="graduationyear${loop.count}" value="${academiclist.graduation}" />
												<select id="graduation${loop.count}" name="graduation" style="width:150px;">
													<option value="">졸업년도 선택</option>
												</select>
											</td>
										</tr>
										<tr>
											<th scope="row"><label for="degrees">학 위</label></th>
											<td>
												<select id="degrees${loop.count}" name="degrees" style="width:150px;">
													<option value="">----학위 선택----</option>
													<c:forEach var="each" items="${degrees}" varStatus="status2">
														<option value="${each.code}" <c:if test="${academiclist.degrees eq each.code}">selected</c:if>>${each.codeNm}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<th scope="row"><label for="school">학 교</label></th>
											<td>
												<%-- <select id="selectschool${status.count}" name="university" style="width:200px;">
													<option value="">학교선택</option>
												</select> --%>
												<input type="text" class="text" id="writeschool${loop.count}" name="university2" title="학교이름 입력" style="width:226px;height:17px;" value="${academiclist.university2 }" />
												<p class="text">* 대학 및 기타 학교는 직접 기입해주세요!<br />외국대학의 경우 학교명뒤에 국적을 입력하세요. (반드시 한글로 입력) <br />예) 미시간대(미) </p>
											</td>
										</tr>
										<tr>
											<th scope="row"><label for="lesson">학 과</label></th>
											<td><input type="text" class="text" id="lesson${loop.count}" name="major" title="학과이름 입력" style="width:315px;height:17px;" value="${academiclist.major }" /></td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
							<h5 class="sstit">경력정보</h5>
							<table class="board-write" summary="기간, 경력사항">
								<caption>경력정보</caption>
								<colgroup>
									<col style="width:40%;" />
									<col style="width:60%;" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col" class="first">기간</th>
										<th scope="col">경력사항</th>
									</tr>
								</thead>
								<tbody class="type02">
									<tr>
										<td class="first" name="career" >
											<fmt:parseDate value="${usercreerlist[0].csdate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="syeardata1" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="syear1" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="smonthdata1" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="smonth1" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월 ~
											<input type="hidden" id="csdate1" name="csdate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
											<input type="checkbox" id="nowcheck1" value="Y" style="vertical-align: middle;" <c:if test="${usercreerlist[0].nowcheck eq 'Y'}">checked="checked"</c:if>>현재
											<input type="hidden" id="nowcheckId1" name="nowcheck" value="${usercreerlist[0].nowcheck }"/>
											<fmt:parseDate value="${usercreerlist[0].cedate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="eyeardata1" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="eyear1" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="emonthdata1" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="emonth1" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월
											<input type="hidden" id="cedate1" name="cedate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
										</td>
										<td>
											<input type="text" class="text" id="ctext1" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[0].careerdata }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="career" >
											<fmt:parseDate value="${usercreerlist[1].csdate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="syeardata2" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="syear2" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="smonthdata2" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="smonth2" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월 ~
											<input type="hidden" id="csdate2" name="csdate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
											<input type="checkbox" id="nowcheck2" value="Y" style="vertical-align: middle;" <c:if test="${usercreerlist[1].nowcheck eq 'Y'}">checked="checked"</c:if>>현재
											<input type="hidden" id="nowcheckId2" name="nowcheck" value="${usercreerlist[0].nowcheck }"/>
											<fmt:parseDate value="${usercreerlist[1].cedate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="eyeardata2" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="eyear2" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="emonthdata2" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="emonth2" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월
											<input type="hidden" id="cedate2" name="cedate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
										</td>
										<td>
											<input type="text" class="text" id="ctext2" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[1].careerdata }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="career" >
											<fmt:parseDate value="${usercreerlist[2].csdate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="syeardata3" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="syear3" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="smonthdata3" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="smonth3" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월 ~
											<input type="hidden" id="csdate3" name="csdate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
											<input type="checkbox" id="nowcheck3" value="Y" style="vertical-align: middle;" <c:if test="${usercreerlist[2].nowcheck eq 'Y'}">checked="checked"</c:if>>현재
											<input type="hidden" id="nowcheckId3" name="nowcheck" value="${usercreerlist[0].nowcheck }"/>
											<fmt:parseDate value="${usercreerlist[2].cedate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="eyeardata3" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="eyear3" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="emonthdata3" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="emonth3" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월
											<input type="hidden" id="cedate3" name="cedate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
										</td>
										<td>
											<input type="text" class="text" id="ctext3" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[2].careerdata }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="career" >
											<fmt:parseDate value="${usercreerlist[3].csdate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="syeardata4" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="syear4" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="smonthdata4" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="smonth4" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월 ~
											<input type="hidden" id="csdate4" name="csdate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
											<input type="checkbox" id="nowcheck4" value="Y" style="vertical-align: middle;" <c:if test="${usercreerlist[3].nowcheck eq 'Y'}">checked="checked"</c:if>>현재
											<input type="hidden" id="nowcheckId4" name="nowcheck" value="${usercreerlist[0].nowcheck }"/>
											<fmt:parseDate value="${usercreerlist[3].cedate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="eyeardata4" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="eyear4" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="emonthdata4" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="emonth4" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월
											<input type="hidden" id="cedate4" name="cedate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
										</td>
										<td>
											<input type="text" class="text" id="ctext4" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[3].careerdata }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="career" >
											<fmt:parseDate value="${usercreerlist[4].csdate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="syeardata5" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="syear5" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="smonthdata5" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="smonth5" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월 ~
											<input type="hidden" id="csdate5" name="csdate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
											<input type="checkbox" id="nowcheck5" value="Y" style="vertical-align: middle;" <c:if test="${usercreerlist[4].nowcheck eq 'Y'}">checked="checked"</c:if>>현재
											<input type="hidden" id="nowcheckId5" name="nowcheck" value="${usercreerlist[0].nowcheck }"/>
											<fmt:parseDate value="${usercreerlist[4].cedate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="eyeardata5" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="eyear5" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="emonthdata5" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="emonth5" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월
											<input type="hidden" id="cedate5" name="cedate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
										</td>
										<td>
											<input type="text" class="text" id="ctext5" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[4].careerdata }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="career" >
											<fmt:parseDate value="${usercreerlist[5].csdate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="syeardata6" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="syear6" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="smonthdata6" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="smonth6" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월 ~
											<input type="hidden" id="csdate6" name="csdate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
											<input type="checkbox" id="nowcheck6" value="Y" style="vertical-align: middle;" <c:if test="${usercreerlist[5].nowcheck eq 'Y'}">checked="checked"</c:if>>현재
											<input type="hidden" id="nowcheckId6" name="nowcheck" value="${usercreerlist[0].nowcheck }"/>
											<fmt:parseDate value="${usercreerlist[5].cedate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="hidden" id="eyeardata6" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy' />" />
											<select id="eyear6" style="width:60px;" onchange="makedate()" >
												<option value="">----</option>
											</select>년
											<input type="hidden" id="emonthdata6" value="<fmt:formatDate type='both' value='${isoDate}' pattern='MM' />" />
											<select id="emonth6" style="width:40px;" onchange="makedate()" >
												<option value="">----</option>
											</select>월
											<input type="hidden" id="cedate6" name="cedate" title="기간 입력" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" />
										</td>
										<td>
											<input type="text" class="text" id="ctext6" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[5].careerdata }" />
										</td>
									</tr>
								</tbody>
							</table>
							<h5 class="sstit">수상경력</h5>
							<table class="board-write" summary="수상일, 수상명칭, 수여기관">
								<caption>수상경력</caption>
								<colgroup>
									<col style="width:20%;" />
									<col style="width:40%;" />
									<col style="width:40%;" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col" class="first">수상일</th>
										<th scope="col">수상명칭</th>
										<th scope="col">수여기관</th>
									</tr>
								</thead>
								<tbody class="type02">
									<tr>
										<td class="first" name="award" >
											<fmt:parseDate value="${userawardlist[0].awarddate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="awarddt1" name="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="awardnm1" name="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[0].awardnm }" />
										</td>
										<td>
											<input type="text" class="text" id="awardinst1" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[0].awardinst }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="award" >
											<fmt:parseDate value="${userawardlist[1].awarddate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="awarddt2" name="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="awardnm2" name="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[1].awardnm }" />
										</td>
										<td>
											<input type="text" class="text" id="awardinst2" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[1].awardinst }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="award" >
											<fmt:parseDate value="${userawardlist[2].awarddate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="awarddt3" name="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="awardnm3" name="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[2].awardnm }" />
										</td>
										<td>
											<input type="text" class="text" id="awardinst3" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[2].awardinst }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="award" >
											<fmt:parseDate value="${userawardlist[3].awarddate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="awarddt4" name="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="awardnm4" name="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[3].awardnm }" />
										</td>
										<td>
											<input type="text" class="text" id="awardinst4" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[3].awardinst }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="award" >
											<fmt:parseDate value="${userawardlist[4].awarddate }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="awarddt5" name="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="awardnm5" name="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[4].awardnm }" />
										</td>
										<td>
											<input type="text" class="text" id="awardinst5" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userawardlist[4].awardinst }" />
										</td>
									</tr>
								</tbody>
							</table>
							<h5 class="sstit">자격사항</h5>
							<table class="board-write" summary="취득일, 자격명칭, 인증기관">
								<caption>자격사항</caption>
								<colgroup>
									<col style="width:20%;" />
									<col style="width:40%;" />
									<col style="width:40%;" />
								</colgroup>
								<thead>
									<tr>
										<th scope="col" class="first">취득일</th>
										<th scope="col">자격명칭</th>
										<th scope="col">인증기관</th>
									</tr>
								</thead>
								<tbody class="type02">
									<tr>
										<td class="first" name="license" >
											<fmt:parseDate value="${userlicenslist[0].getdodt }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="getdodt1" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="getdonm1" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[0].licensnm }" />
										</td>
										<td>
											<input type="text" class="text" id="getdoinst1" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[0].licensinst }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="license" >
											<fmt:parseDate value="${userlicenslist[1].getdodt }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="getdodt2" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="getdonm2" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[1].licensnm }" />
										</td>
										<td>
											<input type="text" class="text" id="getdoinst2" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[1].licensinst }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="license" >
											<fmt:parseDate value="${userlicenslist[2].getdodt }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="getdodt3" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="getdonm3" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[2].licensnm }" />
										</td>
										<td>
											<input type="text" class="text" id="getdoinst3" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[2].licensinst }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="license" >
											<fmt:parseDate value="${userlicenslist[3].getdodt }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="getdodt4" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="getdonm4" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[3].licensnm }" />
										</td>
										<td>
											<input type="text" class="text" id="getdoinst4" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[3].licensinst }" />
										</td>
									</tr>
									<tr>
										<td class="first" name="license" >
											<fmt:parseDate value="${userlicenslist[4].getdodt }" pattern="yyyy-MM-dd" var="isoDate" />
											<input type="text" class="Wdate" class="text" id="getdodt5" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyyMMdd' />" readonly />
										</td>
										<td>
											<input type="text" class="text" id="getdonm5" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[4].licensnm }" />
										</td>
										<td>
											<input type="text" class="text" id="getdoinst5" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${userlicenslist[4].licensinst }" />
										</td>
									</tr>
								</tbody>
							</table>

						</c:if>
						<!-- <p class="text02">회원가입을 완료하시면 (사)대한국토ㆍ도시계획학회에서 제공하는 모든 서비스를 이용하실 수 있습니다.</p> -->
						<div class="btn-c">
							<a id="submit_btn" href="#none"><img src="/usr/image/common/btn/btn_modify02.gif" alt="가입하기" /></a>
							<a href="/?menuno=2342"><img src="/usr/image/common/btn/btn_cencle.gif" alt="취 소" /></a>
						</div>
					</form>
				</div>
			</div>
		</div>