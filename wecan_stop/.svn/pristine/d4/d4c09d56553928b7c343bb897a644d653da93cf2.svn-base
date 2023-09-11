<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<link rel="stylesheet" href="/usr/skin/member/default/css/join.css" type="text/css" />
<!--여기서부터 사용하세요-->
<div id="skin">
<form name="frm" method="post">
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<div id="join_wrap3">		
		<div class="terms">
			${result.conts4} }
			<!--내용부분
			<div class="jo_guide" style="background:url('images/join_bg3.gif') -10px -60px no-repeat;margin-bottom:30px;">
				<h2><img src="/usr/skin/member/default/images/join_txt01.gif" alt="서울친환경유통센터 홈페이지에 오신것을 환영 합니다." /></h2>
				<ul>
					<li><img src="/usr/skin/member/default/images/join_txt02.gif" alt="서울시농수산물공사 친환경유통센터 홈페이지는 인터넷 실명제를 통한 건전한 인터넷 문화 정착과 회원간의 신뢰성 확보 및 보다 엄선되고 고객 개개인에 맞춘 정보를 제공하기 위하여 실명 인증 절차를 거쳐 회원등록을 받고 있습니다." /></li>
				</ul>
			</div>			
			<h5 class="jo_tit"><img src="/usr/skin/member/default/images/join_txt2_1.gif" alt="회원가입 절차" /></h5>
			<ul class="join_img">
				<li><img src="/usr/skin/member/default/images/ring01.gif" alt="약관동의" /><span><img src="/usr/skin/member/default/images/arr_1.gif" alt="다음순서" /></span></li>
				<li><img src="/usr/skin/member/default/images/ring02.gif" alt="실명인증" /><span><img src="/usr/skin/member/default/images/arr_1.gif" alt="다음순서" /></span></li>
				<li><img src="/usr/skin/member/default/images/ring03.gif" alt="회원정보인증" /><span><img src="/usr/skin/member/default/images/arr_1.gif" alt="다음순서" /></span></li>
				<li><img src="/usr/skin/member/default/images/ring04.gif" alt="가입완료" /></li>
			</ul>
			//-->
			<h5 class="jo_tit1"><img src="/usr/skin/member/default/images/join_txt2_3.gif" alt="필수 입력사항" /></h5>
			<div id="mem_table01">
				<table cellspacing="0" summary="회원가입_입력사항" class="a_bord">
					<caption>회원가입_입력사항</caption>
					<colgroup>
						<col width="20%">
						<col width="">
					</colgroup>
					<thead></thead>
					<tbody>
					<tr>
						<th><label for="userid"><span class="tred">*</span> 아이디(ID)</label></th>
						<td><input type="text" id="userid" name="userid" class="box_id" maxlength="12" /> <span class="tblue"> (4~12자 영문, 숫자만 가능)</span></td>
					</tr>
					<tr>
						<th><label for="userpasswd"><span class="tred">*</span> 비밀번호</label></th>
						<td><input type="password" id="userpasswd" name="userpasswd" class="box_pw" /> <span class="tblue"> (4자리이상)</span></td>
					</tr>
					<tr>
						<th><label for="userpasswdchk"><span class="tred">*</span> 비밀번호 확인</label></th>
						<td><input type="password" id="userpasswdchk" name="userpasswdchk" class="box_pw" /></td>
					</tr>
					<tr>
						<th><label for="userhint"><span class="tred">*</span> 비밀번호힌트</label></th>
						<td>
							<select id="userhint" name="userhint" class="pw_hint">
								<option value="">선택</option>
								<option value="1">어머니의 성함은?</option>
								<option value="2">아버지의 성함은?</option>
								<option value="3">자신의 보물1호는?</option>
								<option value="4">좋아하는 연예인?</option>
								<option value="5">집주소는?</option>
							</select>
						</td>
					</tr>
					<tr>
						<th><label for="useranswer"><span class="tred">*</span> 힌트답변</label></th>
						<td><input type="text" id="useranswer" name="useranswer" class="pw_hint_s" /></td>
					</tr>
					<tr>
						<th><label for="username"><span class="tred">*</span> 이 름</label></th>
						<td><input type="text" id="username" name="username" class="box_name" /></td>
					</tr>
					<tr>
						<th><label for="useremailid"><span class="tred">*</span> 이메일</label></th>
						<td><input type="text" id="useremailid" name="useremailid" class="box_email" /> @ <input type="text" id="useremaildomain" name="useremaildomain" class="box_email" />
							<label for="useremail" class="untitle">이메일선택</label>
							<select id="useremail" name="useremail" class="email1">
								<option value="">직접입력</option>
								<option value="daum.net">다음</option>
								<option value="naver.com">네이버</option>
								<option value="nate.com">네이트</option>
								<option value="hanmail.com">한메일</option>
							</select>
						</td>
					</tr>
					<tr>
						<th rowspan="3"><span class="tred">*</span> 주소입력</th>
						<td style="border-style:none"><label for="useraddrno1" class="untitle">우편번호1</label><input type="text" id="useraddrno1" name="useraddrno1" class="box_add" maxlength="3" /> - <label for="useraddrno2" class="untitle">우편번호2</label><input type="text" id="useraddrno2" name="useraddrno2" class="box_add" maxlength="3" /> <a href="#"><img src="/usr/skin/member/default/images/btn_add.gif"  alt="우편번호검색" /></a></td>
					</tr>
					<tr>
						<td style="border-style:none"><label for="useraddr1" class="untitle">주소1</label><input type="text" id="useraddr1" name="useraddr1" class="box_add_s" /></td>
					</tr>
					<tr>
						<td><label for="useraddr2" class="untitle">주소2</label><input type="text" id="useraddr2" name="useraddr2" class="box_add_s" /></td>
					</tr>
					<tr>
						<th><label for="usertel1"><span class="tred">*</span> 일반전화</label></th>
						<td><select id="usertel1" name="usertel1" class="phon">
								<option value="">선택</option>
								<option value="02">02</option>
								<option value="031">031</option>
								<option value="032">032</option>
								<option value="033">033</option>
								<option value="041">041</option>
								<option value="042">042</option>
								<option value="043">043</option>
								<option value="051">051</option>
								<option value="052">052</option>
								<option value="053">053</option>
								<option value="054">054</option>
								<option value="055">055</option>
								<option value="061">061</option>
								<option value="062">062</option>
								<option value="063">063</option>
								<option value="064">064</option>
							</select> -
							<label for="usertel2" class="untitle">전화1</label><input type="text" id="usertel2" name="usertel2" class="box_phon" maxlength="4" /> -
							<label for="usertel3" class="untitle">전화2</label><input type="text" id="usertel3" name="usertel3" class="box_phon_s" maxlength="4" />
						</td>
					</tr>
					<tr>
						<th><label for="usermobile1"><span class="tred">*</span> 휴대전화</label></th>
						<td><select id="usermobile1" name="usermobile1" class="phon">
								<option value="">선택</option>
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="018">018</option>
								<option value="019">019</option>
							</select> -
							<label for="usermobile2" class="untitle">번호1</label><input type="text" id="usermobile2" name="usermobile2" class="box_phon" maxlength="4" /> -
							<label for="usermobile3" class="untitle">번호2</label><input type="text" id="usermobile3" name="usermobile3" class="box_phon_s" maxlength="4" />
						</td>
					</tr>
					</tbody>
				</table>
				<p class="me_btn01"><input type="image" src="/usr/skin/member/default/images/btn_ok2.gif" alt="확인"> <a href="javascript:void(0);"><img src="/usr/skin/member/default/images/btn_can.gif" alt="취소"></a></p>
			</div><!--/mem_table01-->
		</div><!--members-->
	</div><!--/join_wrap3-->
</form>
</div><!--/skin-->
<!--/여기까지 사용하세요-->