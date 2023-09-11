<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<link rel='stylesheet' href='/com/css/jquery-1.10.3-ui.css' />
<script src='/com/js/jquery-1.10.3-ui.js'></script>
<c:if test="${su eq 'true' }">
<script type="text/javascript">
	alert("이미 가입되어 있습니다.\n로그인해 주시거나 아이디/비밀번호찾기를 이용해 주시기 바랍니다..");
	document.location.href="/eng/?menuno=${menuno}";
</script>
</c:if>
<c:if test="${su ne 'true' }">
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript">
$(function () {
	/* gnb */
	$("#gnb > li").eq(5).addClass("on");
});
var lnbnum=1;
var lnbsubnum=0;

history.navigationMode = 'compatible'; // 오페라, 사파리 뒤로가기 막기
function _no_Back(){window.history.forward(0);}

/* window.onload=function(){
	 if("true"=="${su}"){
		 alert("이미 가입되어 있습니다.\n로그인해 주시거나 아이디/비밀번호찾기를 이용해 주시기 바랍니다.");
		 document.location.href="/?menuno=${menuno}";
	 }
} */

function addeducation(){
	var tblappend = $("tbody[name=academicbody]").length;
	var academicno = tblappend+1;
	$("#academic").append('<tbody id="academicbody'+academicno+'" name="academicbody">\
			\n<tr class="first">\
			\n<th scope="row"><label for="education">Academic ability</label></th>\
			\n<td>\
			\n<select id="education'+academicno+'" name="education" >\
			\n<option value="">----Academic ability----</option>\
			\n<c:forEach var="each" items="${education}" varStatus="loop">\
			\n<option value="${each.code}">${each.codeNm}</option>\
			\n</c:forEach>\
			\n</select>\
			\n* You can enter only one at a time by Education .\
			\n</td>\
			\n</tr>\
			\n<tr>\
			\n<th scope="row"><label for="graduation">Year of graduation</label></th>\
			\n<td>\
			\n<select id="graduation'+academicno+'" name="graduation" style="width:150px;">\
			\n<option value="">Year of graduation</option>\
			\n</select>\
			\n</td>\
			\n</tr>\
			\n<tr>\
			\n<th scope="row"><label for="degrees">Degree</label></th>\
			\n<td>\
			\n<select id="degrees'+academicno+'" name="degrees" style="width:150px;">\
			\n<option value="">---Degree----</option>\
			\n<c:forEach var="each" items="${degrees}" varStatus="status2">\
			\n<option value="${each.code}">${each.codeNm}</option>\
			\n</c:forEach>\
			\n</select>\
			\n</td>\
			\n</tr>\
			\n<tr>\
			\n<th scope="row"><label for="school">School</label></th>\
			\n<td>\
			\n<input type="text" class="text" id="writeschool'+academicno+'" name="university2" title="학교이름 입력" style="width:226px;height:17px;" />\
			\n</td>\
			\n</tr>\
			\n<tr>\
			\n<th scope="row"><label for="lesson">Major</label></th>\
			\n<td><input type="text" class="text" id="lesson'+academicno+'" name="major" title="학과이름 입력" style="width:315px;height:17px;" /></td>\
			\n</tr>\
			\n</body>');
	makeyearselect(academicno);
}
//첨부파일 확장자 체크
function check_ext(e){

	var temp = $(e).val();
	var ext = temp.substring(temp.lastIndexOf(".") + 1).toLowerCase();

	var exts = ['jpg','bmp','png','gif'];
	if (exts.indexOf(ext) < 0) {
		alert(exts+' 파일종류만 첨부가 가능합니다');
		$(e).val('');
		return false;
	}
	/* if(e.fileList[0].size/1024/1024 > pfilecapacity){// 단위는 M
		$(e).val('');
		alert('파일 용량이 '+pfilecapacity+'M 이하의 파일만 첨부가 가능합니다');
		return false;

	} 	  */
}
</script>
<style>
h5.sstit{margin-top:20px;}
</style>
<body onload="_no_Back();" onpageshow="if(event.persisted)_no_Back();">
</body>
				<div class="cont-right">
					<h3 class="ctit">Foreigner Registration</h3>
					<!-- h4 class="stit">Registration</h4 -->
					<!-- p class="text03">개인회원(정회원,준회원)을 기준으로 가입을 신청하는 곳입니다. 단체회원(기업,기관,단체회원은 학회사무국으로 연락 주십시오).</p -->
					<!--<h5 class="sstit">신상정보 </h5>-->
					<p class="text"><img src="/usr/image/common/icon/icon_star.png" alt="별표" /> is required.</p>
					<form name="frm" id="frm" method="post"  enctype="multipart/form-data">
						<input type="hidden" name="act" id="act" value="join" />
						<input type="hidden" name="menuno" id="menuno" value="${menuno }" />
						<input type="hidden" name="subname" id="subname" value="${subname }" />
						<input type="hidden" name="foreigner" value="1" />
						<table class="board-write" summary="아이디, 비밀번호, 비밀번호 확인, 성명(한글), 성명(한자), 성명(영문), 생년월일, E-mail, 우편물 수령">
							<caption>회원등록</caption>
							<colgroup>
								<col style="width:20%;" />
								<col style="width:80%;" />
							</colgroup>
							<tbody>
								<tr>
									<th scope="row"><label for="id">ID</label></th>
									<td>
										<input type="text" class="text" id="userid" name="userid" title="아이디 입력" maxlength="8" style="width:226px;height:17px;" />
										<!-- <a href="javascript:"><img src="/usr/image/common/btn/btn_reduplic.gif" alt="중복확인" /></a> -->
										4~8 english letters, numbers (excluding special characters)
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="pass">PASSWORD</label></th>
									<td><input type="password" class="text" id="userpasswd" name="userpasswd" title="비밀번호 입력" style="width:226px;height:17px;" /> more than 6 (english letters, numbers)</td>
								</tr>
								<tr>
									<th scope="row"><label for="pass02">PASSWORD CONFIRM</label></th>
									<td><input type="password" class="text" id="userpasswdchk" name="userpasswdchk" title="비밀번호 재확인 입력" style="width:226px;height:17px;" /></td>
								</tr>
								<tr>
									<th scope="row"><label for="kname">Name<br />(English)</label></th>
									<td><input type="text" class="text" id="username" name="username" title="한글이름 입력" style="width:226px;height:17px;" value="" /> (ex: James, Johns)</td>
								</tr>
								<tr>
									<th scope="row"><label for="cname" style="background:none;">Name<br />(Chinese)</label></th>
									<td><input type="text" class="text" id="usercname" name="usercname" title="한자이름 입력" style="width:226px;height:17px;" /></td>
								</tr>
								<!-- tr>
									<th scope="row"><label for="ename" style="background:none;">Name (National Language)</label></th>
									<td><input type="text" class="text" id="userename" name="Username2" title="영문이름 입력" style="width:226px;height:17px;" /></td>
								</tr -->
								<tr>
									<th scope="row"><label for="years">BIRTHDAY</label></th>
									<td class="select">
										<input type="text" class="text datepicker" name="userbirth" id="years" title="생년월일" style="width:144px;height:17px;" value="" readonly/>
										<input type="radio" checked class="radio" id="guy" name="usersex" value="1" style="vertical-align:middle;" />
										<label for="guy">MAN</label>
										<input type="radio" class="radio" id="girl" name="usersex" value="0" style="vertical-align:middle;" />
										<label for="girl">WOMAN</label>
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="email">E-MAIL</label></th>
									<td>
										<input type="text" class="text" id="useremailid" name="useremailid" title="이메일 주소 입력" style="width:104px;height:17px;" />
										@
										<input type="text" class="text" id="useremaildomain" name="useremaildomain" title="이메일 주소 입력" style="width:103px;height:17px;" />

										<!-- select id="selectdomain" style="width:101px;height:21px;">
											<option value="">직접입력</option>
											<c:forEach var="domain" items="${emaildomain}" varStatus="loop">
												<option value="${domain.code}">${domain.codeNm}</option>
											</c:forEach>
										</select -->
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="newsletter1">Receiving Email</label></th>
									<td>
										<label for="newsletter1">Agree</label><input type="radio" value="1" checked class="text" id="newsletter1" name="newsletter1" title="이메일 수신" style="border:0px;vertical-align:middle;" />
										<label for="newsletter2">Not agree</label><input type="radio" value="0" class="text" id="newsletter2" name="newsletter1" title="이메일 수신" style="border:0px;vertical-align:middle;" />
									</td>
								</tr>
							</tbody>
						</table>
						<table class="board-write mgtype20" summary="프로필 사진, 회원종류, 지회선택, 자택, 직장/대학원, 추천인, 추천서">
							<caption>회원등록</caption>
							<colgroup>
								<col style="width:20%;" />
								<col style="width:80%;" />
							</colgroup>
							<tbody>
								<!-- <tr>
									<th scope="row">프로필 사진</th>
									<td>
										<div class="profile">
											<span><img id="photo" name="photo" style="width:90px;height:120px;" src="/usr/image/member/no_images.gif" alt="프로필 사진" /></span>

											<input type="file" name="imgfile" id="photofile" />

											<p>3*4 사이즈에 맞게 올려주세요</p>
										</div>
									</td>
								</tr> -->
								<tr>
									<th scope="row"><label for="category">Member Type</label></th>
									<td>
										<select id="category" name="work_grade">
											<option value="">---Member Type---</option>
											<option value="1">Regular Member</option>
											<option value="2">Life-Member</option>
											<option value="3">Associate Member(undergraduate)</option>
										</select>
										<!-- ※ 회원종류 안내 : 준회원 가입은 자격여부을 위해 학회에 문의 -->
									</td>

									<script type="text/javascript">
										$(function() {
										    $("#category").change(function(){
										    	if($("#category").val() == '3'){
										    		alert("In case of Associate Member(undergraduate), you must be approved by Admininistrator After submitting the document file. Please attach a proof of enrollment (within 3 months)");
										    		$("#semimemberdocutr").show();
										    	}else{
										    		$("#semimemberdocutr").hide();
										    	}
										    });
										});
									</script>
								</tr>
								<tr id="semimemberdocutr" style="display:none;">
									<th scope="row">proof of enrollment</th>
									<td>
										<input type="file" name="semimemberdocu" id="semimemberdocu" onchange="return check_ext(this);" />
									</td>
								</tr>
								<tr>
									<th scope="row">Branch</th>
									<td>
										<select id="branch" name="branch">
											<option value="">------------</option>
											<c:forEach var="each" items="${branch}" varStatus="loop">
												<option value="${each.code}">${each.codeNm}</option>
											</c:forEach>
										</select><!-- 제주 부산울산경남, 대전세종충청 -->
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="category">Home</label></th>
									<td>
										<input type="text" class="text" id="useraddrno1" name="useraddrno1" title="우편번호 입력" style="width:104px;height:17px;" readonly/>
										<!-- -
										<input type="text" class="text" id="useraddrno2" name="useraddrno2" title="우편번호 입력" style="width:104px;height:17px;" readonly/> -->
										<!--<a href="javascript:postsearch();" id="postsearch"><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호찾기" /></a>-->
										<a href="javascript:postsearch();" id="postsearch" class="btn_gray" style="height:24px;line-height:24px;font-size:12px;padding:0 10px;">Zip code</a>
										<input type="text" class="text block" id="useraddr" name="useraddr" title="주소 입력" style="width:415px;height:17px;" readonly/>
										<input type="text" class="text block" id="useraddr2" name="useraddr2" title="상세주소 입력" style="width:415px;height:17px;" />
										<ul class="type02">
											<li>
												<label for="hand">Mobile</label>
												<input type="text" class="text" id="usermobile1" name="usermobile1" title="지역번호 입력" style="width:72px;height:17px;" maxlength="3" />
												-
												<input type="text" class="text" id="usermobile2" name="usermobile2" title="중간 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" />
												-
												<input type="text" class="text" id="usermobile3" name="usermobile3" title="마지막 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" />
											</li>
											<li>
												<label for="phone">Tel</label>
												<input type="text" class="text"name="usertelco" title="국가코드" style="width:72px;height:17px;" maxlength="4" /> (Country Code)<br>
												&nbsp;<input type="text" class="text" id="usertel1" name="usertel1" title="지역번호 입력" style="width:72px;height:17px;margin-left:  53px;margin-top: 5px" maxlength="3" />
												-
												<input type="text" class="text" id="usertel2" name="usertel2" title="중간 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" />
												-
												<input type="text" class="text" id="usertel3" name="usertel3" title="마지막 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" />
											</li>
										</ul>
									</td>
								</tr>
								<tr>
									<th scope="row">Affiliation</th>
									<td>
										<input type="text" class="text" id="cuseraddrno1" name="cuseraddrno1" title="우편번호 입력" style="width:104px;height:17px;" readonly/>
										<!-- -
										<input type="text" class="text" id="cuseraddrno2" name="cuseraddrno2" title="우편번호 입력" style="width:104px;height:17px;" readonly/> -->
										<!--<a href="javascript:postsearch('c')"><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호찾기" /></a>-->
										<a href="javascript:postsearch('c')" class="btn_gray" style="height:24px;line-height:24px;font-size:12px;padding:0 10px;">Zip code</a>
										<input type="text" class="text block" id="cuseraddr" name="usercaddr" title="주소 입력" style="width:415px;height:17px;" readonly/>
										<input type="text" class="text block" id="cuseraddr2" name="usercaddr2" title="상세주소 입력" style="width:415px;height:17px;" />
										<ul class="type02">
											<li>
												<label for="rectal" style="width:125px;">Name of work place</label>
												<input type="text" class="text" id="rectal" name="usercompanyname" title="직장명 입력" style="width:200px;height:17px;" />
											</li>
											<li>
												<label for="department" style="width:78px;">Department</label>
												<input type="text" class="text" id="department" name="dept_full_nm" title="부서명 입력" style="width:200px;height:17px;" />
											</li>
											<li>
												<label for="title" style="width:78px;">Position</label>
												<input type="text" class="text" id="title" name="usercompanystatus" title="직책 입력" style="width:200px;height:17px;" />
											</li>
											<li>
												<label for="phone02" style="width:78px;">Tel</label>
												<input type="text" class="text"name="tel_offcco" title="국가코드" style="width:72px;height:17px;" maxlength="4" /> (Country Code)<br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="text" id="cusertel1" name="cusertel1" title="지역번호 입력" style="width:72px;height:17px;margin-left:  53px;margin-top: 5px" maxlength="3" />
												-
												<input type="text" class="text" id="cusertel2" name="cusertel2" title="중간 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" />
												-
												<input type="text" class="text" id="cusertel3" name="cusertel3" title="마지막 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" />
											</li>
											<li>
												<label for="FAX" style="width:78px;">FAX</label>
												<input type="text" class="text"name="userfaxco" title="국가코드" style="width:72px;height:17px;" maxlength="4" /> (Country Code)<br>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="text" id="cuserfax1" name="cuserfax1" title="지역번호 입력" style="width:72px;height:17px;margin-left:  53px;margin-top: 5px" maxlength="3" />
												-
												<input type="text" class="text" id="cuserfax2" name="cuserfax2" title="중간 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" />
												-
												<input type="text" class="text" id="cuserfax3" name="cuserfax3" title="마지막 네자리번호 입력" style="width:71px;height:17px;" maxlength="4" />
											</li>
										</ul>
									</td>
								</tr>
								<tr>
									<th scope="row">Postal Receipt</th>
									<td>
										<input type="radio" name="postuserselect" value="1" checked id="post1" class="check"  />
										<label for="post1">same to home</label>
										<input type="radio" name="postuserselect" value="2" id="post2" class="check"  />
										<label for="post2">same to Affiliation</label>

										<!--
										<span style="padding-bottom:5px;display:blcok;overflow:hidden;height:20px;float:left;width:100%;">
										<input type="checkbox" name="post1" id="post1" class="check" onclick="if(this.checked){sameaddr(1);}" />
										<label for="post1">자택과 동일</label>&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="post2" id="post2" class="check" onclick="if(this.checked){sameaddr(2);}" />
										<label for="post2">소속과 동일</label>
										</span>

										</br>
										<input type="text" class="text" id="postuseraddrno1" name="postuseraddrno1" title="우편번호 입력" style="width:104px;height:17px;" readonly />
										-
										<input type="text" class="text" id="postuseraddrno2" name="postuseraddrno2" title="우편번호 입력" style="width:104px;height:17px;" readonly />
										<a href="javascript:postsearch('post');" id="postsearch"><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호찾기" /></a>
										<input type="text" class="text block" id="postuseraddr" name="postuseraddr" title="주소 입력" style="width:315px;height:17px;" readonly />
										<input type="text" class="text block" id="postuseraddr2" name="postuseraddr2" title="상세주소 입력" style="width:315px;height:17px;" /> -->
									</td>
								</tr>

								<!-- tr>
									<th scope="row"><label for="referee">추천인</label></th>
									<td>
										<input type="text" class="text" id="referee" title="추천인 입력" style="width:226px;height:17px;" />
										<input type="hidden" class="text" id="refereeNo" name="nominator" />
										<a href="javascript:searchUser();"><img src="/usr/image/common/btn/btn_search06.gif" alt="추천인 검색" /></a>
									</td>
									<!-- script>
										function searchUser(){
											var url = "/front/user/popupUserListForJoin.html";
											var windowName = "search_user";
											var windowWidth = 468;
											var windowHeight = 560;
											var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
											var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
											var windowSize = "scrollbars=yes, width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
											window.open(url, windowName, windowSize);
										}
										function select_user(userno, userid, username){
											$("#referee").val(userno);
											$("#refereeNo").val(userno);
										}
									</script -->
								</tr -->
								<!-- <tr>
									<th scope="row"><label for="recommen">추천서</label></th>
									<td>

										<input type="file" name="recommen" id="recommen" />

									</td>
								</tr> -->
							</tbody>
						</table>
						<h5 class="sstit">Academic ability</h5>
						<div class="btn-r02">
							<a class="btn_blue" style="height:26px;line-height:26px;" href="javascript:addeducation();">Add Academic ability</a>
							<a class="btn_gray" style="height:26px;line-height:26px;" href="javascript:deleducation();">Delete Academic ability</a>
						</div>
						<!-- p class="text09">아래에서부터 순차적으로 삭제됩니다.</p>
						<p class="text10"><img src="/usr/image/common/icon/icon_star.png" alt="별표" /> 학 력(국가명, 학교명 및 학위를 정확히 기재합니다.)</p -->
						<!-- <p><img src="/usr/image/common/icon/icon_star.png" alt="별표" /> 학 력(국가명, 학교명 및 학위를 정확히 기재합니다.)</p> -->
						<table class="board-write type" id="academic" name="academic" summary="학력, 졸업년도, 학위, 학교, 학과">
							<caption>학력정보</caption>
							<colgroup>
								<col style="width:40%;" />
								<col style="width:60%;" />
							</colgroup>
							<tbody id="academicbody1" name="academicbody">
								<tr class="first">
									<th scope="row"><label for="education">highest level of education</label></th>
									<td>
										<select id="lasteducation" name="lasteducation" >
											<option value="">--highest level of education--</option>
											<c:forEach var="each" items="${education}" varStatus="loop">
												<option value="${each.code}">${each.codeNm}</option>
											</c:forEach>
										</select>
										<!-- * 학력별로 한개씩만 입력할 수 있습니다. -->
									</td>
								</tr>
								<tr class="first">
									<th scope="row"><label for="education">Academic ability</label></th>
									<td>
										<select id="education1" name="education" >
											<option value="">----Academic ability----</option>
											<c:forEach var="each" items="${education}" varStatus="loop">
												<option value="${each.code}">${each.codeNm}</option>
											</c:forEach>
										</select>
										* You can enter only one at a time by Education .
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="graduation">Year of graduation</label></th>
									<td>
										<select id="graduation1" name="graduation" style="width:150px;">
											<option value="">Year of graduation</option>
										</select>
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="degrees">Degree</label></th>
									<td>
										<select id="degrees1" name="degrees" style="width:150px;">
											<option value="">----Degree----</option>
											<c:forEach var="each" items="${degrees}" varStatus="status2">
												<option value="${each.code}">${each.codeNm}</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="school">School</label></th>
									<td>
										<!-- <select id="selectschool1" name="university" style="width:200px;">
											<option value="">학교선택</option>
										</select> -->
										<input type="text" class="text" id="writeschool1" name="university2" title="학교이름 입력" style="width:226px;height:17px;" />
										<!-- p class="text">* 대학 및 기타 학교는 직접 기입해주세요!<br />외국대학의 경우 학교명뒤에 국적을 입력하세요. (반드시 한글로 입력) <br />예) 미시간대(미) </p -->
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="lesson">Major</label></th>
									<td><input type="text" class="text" id="lesson1" name="major" title="학과이름 입력" style="width:315px;height:17px;" /></td>
								</tr>
							</tbody>
						</table>
						<h5 class="sstit">Career</h5>
						<table class="board-write" summary="기간, 경력사항">
							<caption>경력정보</caption>
							<colgroup>
								<col style="width:50%;" />
								<col style="width:50%;" />
							</colgroup>
							<thead>
								<tr>
									<th scope="col" class="first">Period</th>
									<th scope="col">Contents</th>
								</tr>
							</thead>
							<tbody class="type02">
								<tr>
									<td class="first" name="career" >
										<select id="syear1" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select> Y
										<select id="smonth1" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M ~
										<input type="hidden" id="csdate1" name="csdate" title="기간 입력" />
										<input type="checkbox" id="nowcheck1" value="Y" style="vertical-align: middle;">now
										<input type="hidden" id="nowcheckId1" name="nowcheck""/>
										<select id="eyear1" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="emonth1" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M
										<input type="hidden" id="cedate1" name="cedate" title="기간 입력" />
									</td>
									<td>
										<input type="text" class="text" id="ctext1" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[0].careerdata }" />
									</td>
								</tr>
								<tr>
									<td class="first" name="career" >
										<select id="syear2" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="smonth2" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M ~
										<input type="hidden" id="csdate2" name="csdate" title="기간 입력" />
										<input type="checkbox" id="nowcheck2" value="Y" style="vertical-align: middle;">now
										<input type="hidden" id="nowcheckId2" name="nowcheck""/>
										<select id="eyear2" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="emonth2" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M
										<input type="hidden" id="cedate2" name="cedate" title="기간 입력" />
									</td>
									<td>
										<input type="text" class="text" id="ctext2" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[1].careerdata }" />
									</td>
								</tr>
								<tr>
									<td class="first" name="career" >
										<select id="syear3" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="smonth3" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M ~
										<input type="hidden" id="csdate3" name="csdate" title="기간 입력" />
										<input type="checkbox" id="nowcheck3" value="Y" style="vertical-align: middle;">now
										<input type="hidden" id="nowcheckId3" name="nowcheck""/>
										<select id="eyear3" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="emonth3" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M
										<input type="hidden" id="cedate3" name="cedate" title="기간 입력" />
									</td>
									<td>
										<input type="text" class="text" id="ctext3" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[2].careerdata }" />
									</td>
								</tr>
								<tr>
									<td class="first" name="career" >
										<select id="syear4" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="smonth4" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M ~
										<input type="hidden" id="csdate4" name="csdate" title="기간 입력" />
										<input type="checkbox" id="nowcheck4" value="Y" style="vertical-align: middle;">now
										<input type="hidden" id="nowcheckId4" name="nowcheck""/>
										<select id="eyear4" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="emonth4" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M
										<input type="hidden" id="cedate4" name="cedate" title="기간 입력" />
									</td>
									<td>
										<input type="text" class="text" id="ctext4" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[3].careerdata }" />
									</td>
								</tr>
								<tr>
									<td class="first" name="career" >
										<select id="syear5" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="smonth5" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M ~
										<input type="hidden" id="csdate5" name="csdate" title="기간 입력" />
										<input type="checkbox" id="nowcheck5" value="Y" style="vertical-align: middle;">now
										<input type="hidden" id="nowcheckId5" name="nowcheck""/>
										<select id="eyear5" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="emonth5" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M
										<input type="hidden" id="cedate5" name="cedate" title="기간 입력" />
									</td>
									<td>
										<input type="text" class="text" id="ctext5" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[4].careerdata }" />
									</td>
								</tr>
								<tr>
									<td class="first" name="career" >
										<select id="syear6" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="smonth6" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M ~
										<input type="hidden" id="csdate6" name="csdate" title="기간 입력" />
										<input type="checkbox" id="nowcheck6" value="Y" style="vertical-align: middle;">now
										<input type="hidden" id="nowcheckId6" name="nowcheck""/>
										<select id="eyear6" style="width:60px;" onchange="makedate()" >
											<option value="">----</option>
										</select>Y
										<select id="emonth6" style="width:40px;" onchange="makedate()" >
											<option value="">----</option>
										</select>M
										<input type="hidden" id="cedate6" name="cedate" title="기간 입력" />
									</td>
									<td>
										<input type="text" class="text" id="ctext6" name="careerdata" title="경력사항 입력" style="width:350px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" value="${usercreerlist[5].careerdata }" />
									</td>
								</tr>
							</tbody>
						</table>
						<h5 class="sstit">Award winning career</h5>
						<table class="board-write" summary="수상일, 수상명칭, 수여기관">
							<caption>수상경력</caption>
							<colgroup>
								<col style="width:20%;" />
								<col style="width:40%;" />
								<col style="width:40%;" />
							</colgroup>
							<thead>
								<tr>
									<th scope="col" class="first">Date</th>
									<th scope="col">Title</th>
									<th scope="col">Organization</th>
								</tr>
							</thead>
							<tbody class="type02">
								<tr>
									<td class="first" name="award" >
										<input type="text" class="Wdate" class="text" id="awarddt1" name="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="awardnm1" name="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="awardinst1" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
								<tr>
									<td class="first" name="award" >
										<input type="text" class="Wdate" class="text" id="awarddt2" name="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="awardnm2" name="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="awardinst2" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
								<tr>
									<td class="first" name="award" >
										<input type="text" class="Wdate" class="text" id="awarddt3" nama="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="awardnm3" nama="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="awardinst3" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
								<tr>
									<td class="first" name="award" >
										<input type="text" class="Wdate" class="text" id="awarddt4" name="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="awardnm4" name="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="awardinst4" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
								<tr>
									<td class="first" name="award" >
										<input type="text" class="Wdate" class="text" id="awarddt5" name="awarddate" title="수상일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="awardnm5" name="awardnm" title="수상명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="awardinst5" name="awardinst" title="수여기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
							</tbody>
						</table>
						<h5 class="sstit">Certification</h5>
						<table class="board-write" summary="취득일, 자격명칭, 인증기관">
							<caption>자격사항</caption>
							<colgroup>
								<col style="width:20%;" />
								<col style="width:40%;" />
								<col style="width:40%;" />
							</colgroup>
							<thead>
								<tr>
									<th scope="col" class="first">Date</th>
									<th scope="col">Title</th>
									<th scope="col">Orgnization</th>
								</tr>
							</thead>
							<tbody class="type02">
								<tr>
									<td class="first" name="license" >
										<input type="text" class="Wdate" class="text" id="getdodt1" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="getdonm1" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="getdoinst1" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
								<tr>
									<td class="first" name="license" >
										<input type="text" class="Wdate" class="text" id="getdodt2" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="getdonm2" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="getdoinst2" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
								<tr>
									<td class="first" name="license" >
										<input type="text" class="Wdate" class="text" id="getdodt3" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="getdonm3" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="getdoinst3" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
								<tr>
									<td class="first" name="license" >
										<input type="text" class="Wdate" class="text" id="getdodt4" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="getdonm4" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="getdoinst4" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
								<tr>
									<td class="first" name="license" >
										<input type="text" class="Wdate" class="text" id="getdodt5" name="getdodt" title="취득일 입력" style="width:100px;height:17px;" onFocus="WdatePicker({dateFmt:'yyyyMMdd'})" readonly />
									</td>
									<td>
										<input type="text" class="text" id="getdonm5" name="licensnm" title="자격명칭 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
									<td>
										<input type="text" class="text" id="getdoinst5" name="licensinst" title="인증기관 입력" style="width:200px;height:17px;" onkeydown="if(event.keyCode == 188) event.returnValue = false;" />
									</td>
								</tr>
							</tbody>
						</table>
						<!-- p class="text02">회원가입을 완료하시면 (사)대한국토ㆍ도시계획학회에서 제공하는 모든 서비스를 이용하실 수 있습니다.</p -->
						<div class="btn-c">
							<a id="submit_btn" href="#none" class="btn_blue">Submit</a>
							<a href="/" class="btn_gray">Cancel</a>
						</div>
					</form>
				</div>
			</div>
		</div>
</c:if>
