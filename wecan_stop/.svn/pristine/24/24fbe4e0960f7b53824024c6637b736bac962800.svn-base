<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<c:set var="birthYear" value="${fn:substring(user.userbirth, 0, 4)}" />
<c:set var="birthMonth" value="${fn:substring(user.userbirth, 4, 6)}" />
<c:set var="birthDay" value="${fn:substring(user.userbirth, 6, 8)}" />
<c:set var="fMonth" value="${fn:substring(birthMonth, 0, 1)}" />
<c:set var="fMonth2" value="${fn:substring(birthMonth, 1, 2)}" />
<c:if test="${fMonth eq '0'}">
	<c:set var="birthMonth" value="${fMonth2}" />
</c:if>
<c:set var="fDay" value="${fn:substring(birthDay, 0, 1)}" />
<c:set var="fDay2" value="${fn:substring(birthDay, 1, 2)}" />
<c:if test="${fDay eq '0'}">
	<c:set var="birthDay" value="${fDay2}" />
</c:if>
<script type="text/javascript">

window.onload=function(){
	 if("true"=="${param.sessionout}"){
		 alert("세션시간이 끝났습니다. 다시 로그인해 주세요");
		 window.location.href="/?menuno="+"${param.menuno}";
	 }
	 if("true"=="${param.modifysuccess}"){
		 alert("회원정보가 수정되었습니다.");
		 window.location.href="/";
	 }
}

<c:if test="${user.work_grade eq '2'}">
$(function(){

	var date   = new Date();
    var year   = date.getFullYear();
    str = "<option value=''>선택</option>";
    for(var i = 0 ; i < 80 ; i++ ) {
    	if((year - i) == '${birthYear }'){
    		str += "<option value='"+(year - i)+"' selected>"+(year - i)+"</option>";
    	}else{
    		str += "<option value='"+(year - i)+"'>"+(year - i)+"</option>";
    	}

    }
    $("#userbirthyear").append(str);

    str = "<option value=''>선택</option>";
    for(var i = 1 ; i < 13 ; i++ ) {

    	if(i == '${birthMonth }'){
    		str += "<option value='"+i+"' selected>"+i+"</option>";
    	}else{
    		str += "<option value='"+i+"'>"+i+"</option>";
    	}
	}
    $("#userbirthmonth").append(str);

    str = "<option value=''>선택</option>";
    for(var i = 1 ; i < 32 ; i++ ) {

    	if(i == '${birthDay }'){
    		str += "<option value='"+i+"' selected>"+i+"</option>";
    	}else{
    		str += "<option value='"+i+"'>"+i+"</option>";
    	}
	}
    $("#userbirthday").append(str);

});
</c:if>


function checkJoin(act){
	$("#act").val(act);
	$("#frm2").submit();
}
</script>
<style>
#paging a, #paging strong , #paging span {margin-left: 1px;width: 42px;}
</style>
<input type="hidden" id="type" value="${user.work_grade }" />
<input type="hidden" id="btn_id" />

<form name="frm" id="frm2" action="/?menuno=${param.menuno }" method="post">
<input type="hidden" name="act" id="act"/>
</form>
<section id="contents-wrap">
	<div class="inner-wrap">
		<div class="contents">

			<h3 class="center">회원정보수정</h3>
			<form name="frm" id="frm" method="post">
			<input type="hidden" name="act" id="act"/>
			<input type="hidden" name="menuno" id="menuno" value="${param.menuno }" />
			<input type="hidden" name="userbirth" id="userbirth" />
					<c:if test="${user.work_grade eq '1'}">
					<div class="necessary">
						<p><span class="ico-necessary">체크</span>는 필수입력 사항입니다.</p>
					</div>

					<div class="tbl-box">
					<fieldset>
						<legend>일반회원 회원정보 입력</legend>
						<table class="tbl-type01">
						<caption>일반회원 가입폼</caption>
						<colgroup><col style="width:180px"><col style="width:*"></colgroup>
						<tbody>
							<tr>
								<th>성명</th>
								<td>${user.username}</td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td>
								<c:set var="birthYear" value="${fn:substring(user.userbirth, 0, 4)}" />
								<c:set var="birthMonth" value="${fn:substring(user.userbirth, 4, 6)}" />
								<c:set var="birthDay" value="${fn:substring(user.userbirth, 6, 8)}" />
									<div class="select-box">
										<select id="userbirthyear">
											<option value="${birthYear }">${birthYear }</option>
										</select>
									</div>
									<div class="select-box">
										<select id="userbirthmonth">
											<option value="${birthMonth }">${birthMonth }</option>
										</select>
									</div>
									<div class="select-box">
										<select id="userbirthday">
											<option value="${birthDay }">${birthDay }</option>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<th>아이디</th>
								<td>${user.userid}</td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td>
									<div class="select-box">
										<label for="lb-hp">선택</label>

										<c:set var="usertel" value="${fn:split(user.usertel,'-')}"/>
										<select name="usertel1" id="usertel1">
											<option <c:if test="${usertel[0] eq null}" > selected="selected"</c:if> value="">선택</option>
											<option <c:if test="${usertel[0] eq '010'}"> selected="selected"</c:if> value="010">010</option>
											<option <c:if test="${usertel[0] eq '02'}" > selected="selected"</c:if> value="02">02</option>
											<option <c:if test="${usertel[0] eq '031'}"> selected="selected"</c:if> value="031">031</option>
											<option <c:if test="${usertel[0] eq '032'}"> selected="selected"</c:if> value="032">032</option>
											<option <c:if test="${usertel[0] eq '033'}"> selected="selected"</c:if> value="033">033</option>
											<option <c:if test="${usertel[0] eq '041'}"> selected="selected"</c:if> value="041">041</option>
											<option <c:if test="${usertel[0] eq '042'}"> selected="selected"</c:if> value="042">042</option>
											<option <c:if test="${usertel[0] eq '043'}"> selected="selected"</c:if> value="043">043</option>
											<option <c:if test="${usertel[0] eq '044'}"> selected="selected"</c:if> value="044">044</option>
											<option <c:if test="${usertel[0] eq '051'}"> selected="selected"</c:if> value="051">051</option>
											<option <c:if test="${usertel[0] eq '052'}"> selected="selected"</c:if> value="052">052</option>
											<option <c:if test="${usertel[0] eq '053'}"> selected="selected"</c:if> value="053">053</option>
											<option <c:if test="${usertel[0] eq '054'}"> selected="selected"</c:if> value="054">054</option>
											<option <c:if test="${usertel[0] eq '055'}"> selected="selected"</c:if> value="055">055</option>
											<option <c:if test="${usertel[0] eq '050'}"> selected="selected"</c:if> value="0505">0505</option>
											<option <c:if test="${usertel[0] eq '061'}"> selected="selected"</c:if> value="061">061</option>
											<option <c:if test="${usertel[0] eq '062'}"> selected="selected"</c:if> value="062">062</option>
											<option <c:if test="${usertel[0] eq '063'}"> selected="selected"</c:if> value="063">063</option>
											<option <c:if test="${usertel[0] eq '064'}"> selected="selected"</c:if> value="064">064</option>
											<option <c:if test="${usertel[0] eq '070'}"> selected="selected"</c:if> value="070">070</option>
										</select>
									</div> <span>-</span>
									<input type="text" id="usertel2" name="usertel2" maxlength="4" value="${usertel[1]}" class="w10p"> <span>-</span>
									<input type="text" id="usertel3" name="usertel3" maxlength="4" value="${usertel[2]}" class="w10p">
								</td>
							</tr>
							<tr>
								<th><span class="ico-necessary">체크</span>휴대폰 번호</th>
								<td>
									<div class="select-box">
										<label for="lb-cp">선택</label>
										<c:set var="usermobile" value="${fn:split(user.usermobile,'-')}"/>
										<select name="usermobile1" id="usermobile1">
											<option <c:if test="${usermobile[0] eq null}" > selected="selected"</c:if> value="">선택</option>
											<option <c:if test="${usermobile[0] eq '010'}"> selected="selected"</c:if> value="010">010</option>
											<option <c:if test="${usermobile[0] eq '011'}"> selected="selected"</c:if> value="011">011</option>
											<option <c:if test="${usermobile[0] eq '016'}"> selected="selected"</c:if> value="016">016</option>
											<option <c:if test="${usermobile[0] eq '017'}"> selected="selected"</c:if> value="017">017</option>
											<option <c:if test="${usermobile[0] eq '018'}"> selected="selected"</c:if> value="018">018</option>
											<option <c:if test="${usermobile[0] eq '019'}"> selected="selected"</c:if> value="019">019</option>
										</select>
									</div> <span>-</span>
									<input type="text" id="usermobile2" name="usermobile2" maxlength="4" value="${usermobile[1]}" class="w10p"> <span>-</span>
									<input type="text" id="usermobile3" name="usermobile3" maxlength="4" value="${usermobile[2]}" class="w10p">
								</td>
							</tr>
							<tr>
								<th><label for="lb-email"><span class="ico-necessary">체크</span>이메일주소</label></th>
								<td>
									<c:set var="useremail" value="${fn:split(user.useremail,'@')}"/>

									<input type="text" id="useremailid" name="useremailid" value="${useremail[0] }" class="w10p"> <span>@</span>
									<input type="text" id="useremaildomain" name="useremaildomain" value="${useremail[1] }" class="w20p">
									<div class="select-box">
										<label for="lb-email-select">직접입력</label>
										<select id="selectdomain" >
											<option value="" selected="selected">직접입력</option>
											<option value="hotmail.com">hotmail.com</option>
											<option value="hanmail.net">hanmail.net</option>
											<option value="daum.net">daum.net</option>
											<option value="naver.com">naver.com</option>
											<option value="nate.com">nate.com</option>
											<option value="gmail.com">gmail.com</option>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<th><label for="lb-zip"><span class="ico-necessary">체크</span>주소</label></th>
								<td>
									<input type="text" id="useraddrno1" name="useraddrno1" class="w10p" value="${user.useraddrno }" readonly="readonly"><a href="#pop-zipcode" id="useraddrno_btn" class="btn-tbl">우편번호 찾기</a>
									<hr class="space">
									<input type="text" id="useraddr" name="useraddr" value="${user.useraddr }" class="w50p" readonly="readonly">
									<input type="text" id="useraddr2" name="useraddr2" value="${user.useraddr2 }" class="w30p">
								</td>
							</tr>
						</tbody>
						</table>

						</fieldset>
					</div>
					</c:if>

					<c:if test="${user.work_grade eq '2'}">
					<h4>기업체 정보</h4>
					<div class="necessary">
						<p><span class="ico-necessary">체크</span>는 필수입력 사항입니다.</p>
					</div>

					<div class="tbl-box">
					<fieldset>
						<legend>기업체 정보 입력</legend>
						<table class="tbl-type01">
						<caption>기업회원 기업체 정보 입력</caption>
						<colgroup><col style="width:180px"><col style="width:*"></colgroup>
						<tbody>
							<tr>
								<th>아이디</th>
								<td>${user.userid}</td>
							</tr>
							<tr>
								<th><span class="ico-necessary">체크</span>기업명</th>
								<td>${user.comname}</td>
							</tr>
							<tr>
								<th><span class="ico-necessary">체크</span>사업자번호</th>
								<td>${user.licenseeno}</td>
							</tr>
							<tr>
								<th><span class="ico-necessary">체크</span>회사 전화번호</th>
								<td>
									<div class="select-box">
										<c:set var="comtel" value="${fn:split(user.comtel,'-')}"/>
										<select name="comtel1" id="comtel1">
											<option <c:if test="${comtel[0] eq null}" > selected="selected"</c:if> value="">선택</option>
											<option <c:if test="${comtel[0] eq '02'}" > selected="selected"</c:if> value="02">02</option>
											<option <c:if test="${comtel[0] eq '031'}"> selected="selected"</c:if> value="031">031</option>
											<option <c:if test="${comtel[0] eq '032'}"> selected="selected"</c:if> value="032">032</option>
											<option <c:if test="${comtel[0] eq '033'}"> selected="selected"</c:if> value="033">033</option>
											<option <c:if test="${comtel[0] eq '041'}"> selected="selected"</c:if> value="041">041</option>
											<option <c:if test="${comtel[0] eq '042'}"> selected="selected"</c:if> value="042">042</option>
											<option <c:if test="${comtel[0] eq '043'}"> selected="selected"</c:if> value="043">043</option>
											<option <c:if test="${comtel[0] eq '044'}"> selected="selected"</c:if> value="044">044</option>
											<option <c:if test="${comtel[0] eq '051'}"> selected="selected"</c:if> value="051">051</option>
											<option <c:if test="${comtel[0] eq '052'}"> selected="selected"</c:if> value="052">052</option>
											<option <c:if test="${comtel[0] eq '053'}"> selected="selected"</c:if> value="053">053</option>
											<option <c:if test="${comtel[0] eq '054'}"> selected="selected"</c:if> value="054">054</option>
											<option <c:if test="${comtel[0] eq '055'}"> selected="selected"</c:if> value="055">055</option>
											<option <c:if test="${comtel[0] eq '050'}"> selected="selected"</c:if> value="0505">0505</option>
											<option <c:if test="${comtel[0] eq '061'}"> selected="selected"</c:if> value="061">061</option>
											<option <c:if test="${comtel[0] eq '062'}"> selected="selected"</c:if> value="062">062</option>
											<option <c:if test="${comtel[0] eq '063'}"> selected="selected"</c:if> value="063">063</option>
											<option <c:if test="${comtel[0] eq '064'}"> selected="selected"</c:if> value="064">064</option>
											<option <c:if test="${comtel[0] eq '070'}"> selected="selected"</c:if> value="070">070</option>
										</select>


									</div> <span>-</span>
									<input type="text" id="comtel2" name="comtel2" maxlength="4" value="${comtel[1]}" class="w10p"> <span>-</span>
									<input type="text" id="comtel3" name="comtel3" maxlength="4" value="${comtel[2]}" class="w10p">
								</td>
							</tr>
							<tr>
								<th>팩스번호</th>
								<td>
									<div class="select-box">
										<label for="lb-fax">선택</label>
										<c:set var="userfax" value="${fn:split(user.userfax,'-')}"/>
										<select name="userfax1" id="userfax1">
											<option <c:if test="${userfax[0] eq null}" > selected="selected"</c:if> value="">선택</option>
											<option <c:if test="${userfax[0] eq '02'}" > selected="selected"</c:if> value="02">02</option>
											<option <c:if test="${userfax[0] eq '031'}"> selected="selected"</c:if> value="031">031</option>
											<option <c:if test="${userfax[0] eq '032'}"> selected="selected"</c:if> value="032">032</option>
											<option <c:if test="${userfax[0] eq '033'}"> selected="selected"</c:if> value="033">033</option>
											<option <c:if test="${userfax[0] eq '041'}"> selected="selected"</c:if> value="041">041</option>
											<option <c:if test="${userfax[0] eq '042'}"> selected="selected"</c:if> value="042">042</option>
											<option <c:if test="${userfax[0] eq '043'}"> selected="selected"</c:if> value="043">043</option>
											<option <c:if test="${userfax[0] eq '044'}"> selected="selected"</c:if> value="044">044</option>
											<option <c:if test="${userfax[0] eq '051'}"> selected="selected"</c:if> value="051">051</option>
											<option <c:if test="${userfax[0] eq '052'}"> selected="selected"</c:if> value="052">052</option>
											<option <c:if test="${userfax[0] eq '053'}"> selected="selected"</c:if> value="053">053</option>
											<option <c:if test="${userfax[0] eq '054'}"> selected="selected"</c:if> value="054">054</option>
											<option <c:if test="${userfax[0] eq '055'}"> selected="selected"</c:if> value="055">055</option>
											<option <c:if test="${userfax[0] eq '050'}"> selected="selected"</c:if> value="0505">0505</option>
											<option <c:if test="${userfax[0] eq '061'}"> selected="selected"</c:if> value="061">061</option>
											<option <c:if test="${userfax[0] eq '062'}"> selected="selected"</c:if> value="062">062</option>
											<option <c:if test="${userfax[0] eq '063'}"> selected="selected"</c:if> value="063">063</option>
											<option <c:if test="${userfax[0] eq '064'}"> selected="selected"</c:if> value="064">064</option>
											<option <c:if test="${userfax[0] eq '070'}"> selected="selected"</c:if> value="070">070</option>
										</select>


									</div> <span>-</span>
									<input type="text" id="userfax2" name="userfax2" maxlength="4" value="${userfax[1]}" class="w10p"> <span>-</span>
									<input type="text" id="userfax3" name="userfax3" maxlength="4" value="${userfax[2]}" class="w10p">
								</td>
							</tr>
							<tr>
								<th><label for="lb-zip"><span class="ico-necessary">체크</span>회사주소</label></th>
								<td>
									<input type="text" id="comaddrno" name="comaddrno" class="w10p" value="${user.comaddrno }" readonly="readonly"><a href="#pop-zipcode" id="comaddrno_btn" class="btn-tbl">우편번호 찾기</a>
									<hr class="space">
									<input type="text" id="comaddr" name="comaddr" value="${user.comaddr }" class="w50p" readonly="readonly">
									<input type="text" id="comaddr2" name="comaddr2" value="${user.comaddr2 }" class="w30p">
								</td>
							</tr>
							<tr>
								<th><label for="lb-name"><span class="ico-necessary">체크</span>대표자명</label></th>
								<td><input type="text" id="username" name="username" value="${user.username }" class="w30p"></td>
							</tr>
							<tr>
								<th><span class="ico-necessary">체크</span>대표자 휴대폰 번호</th>
								<td>
									<div class="select-box">
										<label for="lb-cp">선택</label>

										<c:set var="usermobile" value="${fn:split(user.usermobile,'-')}"/>
										<select name="usermobile1" id="usermobile1">
											<option <c:if test="${usermobile[0] eq null}" > selected="selected"</c:if> value="">선택</option>
											<option <c:if test="${usermobile[0] eq '010'}"> selected="selected"</c:if> value="010">010</option>
											<option <c:if test="${usermobile[0] eq '011'}"> selected="selected"</c:if> value="011">011</option>
											<option <c:if test="${usermobile[0] eq '016'}"> selected="selected"</c:if> value="016">016</option>
											<option <c:if test="${usermobile[0] eq '017'}"> selected="selected"</c:if> value="017">017</option>
											<option <c:if test="${usermobile[0] eq '018'}"> selected="selected"</c:if> value="018">018</option>
											<option <c:if test="${usermobile[0] eq '019'}"> selected="selected"</c:if> value="019">019</option>
										</select>
									</div> <span>-</span>
									<input type="text" id="usermobile2" name="usermobile2" maxlength="4" value="${usermobile[1]}" class="w10p"> <span>-</span>
									<input type="text" id="usermobile3" name="usermobile3" maxlength="4" value="${usermobile[2]}" class="w10p">
								</td>
							</tr>
							<tr>
								<th><span class="ico-necessary">체크</span>대표자 생년월일</th>
								<td>
										<div class="select-box">
											<select id="userbirthyear">
											</select>
										</div>
										<div class="select-box">
											<select id="userbirthmonth">
											</select>
										</div>
										<div class="select-box">
											<select id="userbirthday">
											</select>
										</div>
									</td>
								</td>
							</tr>
							<tr>
								<th><label for="lb-zip2"><span class="ico-necessary">체크</span>대표자 주소</label></th>
								<td>
									<input type="text" id="useraddrno1" name="useraddrno1" class="w10p" value="${user.useraddrno }" readonly="readonly"><a href="#pop-zipcode" id="useraddrno_btn" class="btn-tbl">우편번호 찾기</a>
									<hr class="space">
									<input type="text" id="useraddr" name="useraddr" value="${user.useraddr }" class="w50p" readonly="readonly">
									<input type="text" id="useraddr2" name="useraddr2" value="${user.useraddr2 }" class="w30p">
								</td>
							</tr>
							<tr>
								<th><label for="lb-name2"><span class="ico-necessary">체크</span>담당자명</label></th>
								<td><input type="text" id="chargername" name="chargername" value="${user.chargername }" class="w30p"></td>
							</tr>
							<tr>
								<th><span class="ico-necessary">체크</span>담당자 휴대폰 번호</th>
								<td>
									<div class="select-box">
										<label for="lb-cp2">선택</label>
										<c:set var="chargemobile" value="${fn:split(user.chargemobile,'-')}"/>
										<select name="chargemobile1" id="chargemobile1">
											<option <c:if test="${chargemobile[0] eq null}" > selected="selected"</c:if> value="">선택</option>
											<option <c:if test="${chargemobile[0] eq '010'}"> selected="selected"</c:if> value="010">010</option>
											<option <c:if test="${chargemobile[0] eq '011'}"> selected="selected"</c:if> value="011">011</option>
											<option <c:if test="${chargemobile[0] eq '016'}"> selected="selected"</c:if> value="016">016</option>
											<option <c:if test="${chargemobile[0] eq '017'}"> selected="selected"</c:if> value="017">017</option>
											<option <c:if test="${chargemobile[0] eq '018'}"> selected="selected"</c:if> value="018">018</option>
											<option <c:if test="${chargemobile[0] eq '019'}"> selected="selected"</c:if> value="019">019</option>
										</select>
									</div> <span>-</span>
									<input type="text" id="chargemobile2" name="chargemobile2" maxlength="4" value="${chargemobile[1]}" class="w10p"> <span>-</span>
									<input type="text" id="chargemobile3" name="chargemobile3" maxlength="4" value="${chargemobile[2]}" class="w10p">
								</td>
							</tr>



							<tr>
								<th><label for="lb-email"><span class="ico-necessary">체크</span>담당자 이메일</label></th>
								<td>
									<c:set var="chargeremail" value="${fn:split(user.chargeremail,'@')}"/>
									<input type="text" id="chargeremailid" name="chargeremailid" value="${chargeremail[0]}" class="w10p"> <span>@</span>
									<input type="text" id="chargeremaildomain" name="chargeremaildomain" value="${chargeremail[1]}" class="w20p">
									<div class="select-box">
										<label for="lb-email-select">직접입력</label>
										<select id="selectdomain2">
											<option selected="selected">직접입력</option>
											<option>hotmail.com</option>
											<option>hanmail.net</option>
											<option>daum.net</option>
											<option>naver.com</option>
											<option>nate.com</option>
											<option>gmail.com</option>
										</select>
									</div>
								</td>
							</tr>
						</tbody>
						</table>
						</fieldset>
					</div>
					</c:if>
					<div class="btns-box ar">
						<a href="/" class="btn-basic border">취소</a>
						<a href="#none" id="submit_btn" class="btn-basic">확인</a>
					</div>
			</form>
			<div class="tmg50">
				<div class="border-tb-box half pointC modify">
					<section class="member-choice-box">
						<h4>비밀번호 변경</h4>
						<p>비밀번호 변경을 원하실 경우 하단 ‘비밀번호 변경’ 버튼을 클릭하여 진행해 주세요.</p>
						<div class="ac">
							<a href="#none" onclick="checkJoin('usermodifypw')" class="btn-basic">비밀번호 변경</a>
						</div>
					</section>
					<section class="member-choice-box">
						<h4>회원탈퇴</h4>
						<p>회원탈퇴를 원하실 경우 하단 ‘회원탈퇴’ 버튼을 클릭하여 진행해 주세요</p>
						<div class="ac">
							<a href="#none" onclick="checkJoin('userout')" class="btn-basic">회원탈퇴</a>
						</div>
					</section>
				</div>
			</div>

		</div>
	</div>
</section>
<!--[e] contents -->


<div id="dimmed"></div>
<!-- [s] 우편번호 팝업 -->
<div id="pop-zipcode" class="pop-wrap">
	<div class="pop-wrap-inner zipcode">
		<header>
			<h2>우편번호 검색</h2>
		</header>
		<section class="pop-contents">
			<nav class="sub-text-tab tab">
				<a href="" class="on">주소검색(도로명, 지번)</a>
				<!-- <a href="">도로명주소</a> -->
			</nav>

			<!-- [s] addr -->
			<div class=.pop-cont tab-cont">
				<p>
					<!-- <strong>검색방법 : 시·도 및 시·군·구 선택 → 읍, 면, 동으로 입력</strong><br> -->
					예) <span class="fBlk">도화동, 도화</span>, 도화동 560, 도화동 현대아파트, 도움5로 19
				</p>
				</p>
				<div class="pop-search">
					<dl>
						<!-- <dt>시도</dt>
						<dd>
							<div class="select-box">
								<label for="lb-sido">서울특별시</label>
								<select id="lb-sido">
									<option selected="selected">서울특별시</option>
								</select>
							</div>
						</dd>
						<dt>시군구</dt>
						<dd>
							<div class="select-box">
								<label for="lb-sido">종로구</label>
								<select id="lb-sido">
									<option selected="selected">종로구</option>
								</select>
							</div>
						</dd> -->
						<dt><label for="lb-addr">주소</label></dt>
						<dd>
							<input type="text" class="w50p" id="dong" onKeyDown="if(event.keyCode == 13){pop_postcode()}"> <a href="#none" onclick="pop_postcode()" class="btn-tbl small">검색</a>
						</dd>
					</dl>
				</div>
			</div>
			<!-- [e] addr -->

			<!-- [s] addr -->
			<!-- <div class=.pop-cont tab-cont">
				<p>
					<input type="radio" id="lb-zip01"><label for="lb-zip01">도로명+건물번호</label>
					<input type="radio" id="lb-zip02"><label for="lb-zip02">동(읍/면/리)명+건물(아파트)명</label>
					<input type="radio" id="lb-zip03"><label for="lb-zip03">동(읍/면/동)명+지번</label>
				</p>
				<div class="pop-search">
					<dl>
						<dt>시도</dt>
						<dd>
							<div class="select-box">
								<label for="lb-sido">서울특별시</label>
								<select id="lb-sido">
									<option selected="selected">서울특별시</option>
								</select>
							</div>
						</dd>
						<dt>시군구</dt>
						<dd>
							<div class="select-box">
								<label for="lb-sido">종로구</label>
								<select id="lb-sido">
									<option selected="selected">종로구</option>
								</select>
							</div>
						</dd>
						<dt><label for="lb-road">도로명</label></dt>
						<dd>
							<input type="text" class="w50p" id="lb-road">
						</dd>
						<dt><label for="lb-addr02">주소</label></dt>
						<dd>
							<input type="text" class="w30p" id="lb-addr02">
							<input type="text" class="w30p"> <a href="" class="btn-tbl small">검색</a>
						</dd>
						<dt><label for="lb-building">건물명</label></dt>
						<dd>
							<input type="text" class="w50p" id="lb-building"> <a href="" class="btn-tbl small">검색</a>
						</dd>
					</dl>
				</div>
			</div> -->
			<!-- [e] addr -->
			<div class="pop-result">
				<p></p>
				<div class="pop-result-scroll">
					<table>
					<caption>우편번호 조회결과</caption>
					<colgroup><col style="width:11%;"><col style="width:18%"><col style="width:*"><col style="width:15%;"></colgroup>
					<thead>
						<tr>
							<th>NO</th>
							<th>우편번호</th>
							<th>주소</th>
							<th>선택</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="4">조회된 결과가 없습니다.</td>
						</tr>
						<!-- <tr>
							<td>1</td>
							<td>서울특별시 종로구 창신2동</td>
							<td>110-542</td>
							<td><a href="" class="btn-tbl small">선택</a></td>
						</tr>
						<tr>
							<td>1</td>
							<td>서울특별시 종로구 창신2동</td>
							<td>110-542</td>
							<td><a href="" class="btn-tbl small">선택</a></td>
						</tr> -->
					</tbody>
					</table>
				</div>
			</div>
			<div id="paging"></div>
		</section>
		<a href="#pop-confirm" class="pop-close heading">레이어 팝업닫기</a>
	</div>
</div>
<!-- [e] 우편번호 팝업 -->
