<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
	window.ready=function(){
		 if("true"=="${param.joinsuccess}"){
			 frm_finish.submit();
		 }
	}
</script>
<form name="frm_finish" method="post" action="/?menuno=14">
	<input type="hidden" name="ztag" id="ztag" value="rO0ABXQAMTxjYWxsIHR5cGU9Im1lbWJlciIgbm89IjEiIHNraW49ImJhdHRlcnkiPjwvY2FsbD4=" />
	<input type="hidden" name="act" value="finish" />
</form>
	<!-- //콘텐츠영역 -->
	<div id="contentsArea">
		<div class="boxC">
			<!-- //왼쪽영역 -->
			<div class="leftBox"><a name="menu"></a>
				<dl class="leftNvBox">
					<dd class="titleBg6">
						<ul>
							<li class="title"><img src="/usr/skin/member/battery/images/leftTitle6.png" alt="MYPAGE" /></li>
							<li class="ex"><img src="/usr/image/nv/leftTitle1_ex.png" alt="환경을 위한 이차전지산업지원시스템" /></li>
						</ul>
					</dd>
					<dd><a href="/?menuno=14" class="dep">로그인</a>
<!-- 						<ul>
							<li><a href="#" class="onn">- Co-free 양극소재 개발</a></li>
							<li><a href="#">- EV용 LMO 개발</a></li>
							<li><a href="#">- 전해액 첨가제 개발</a></li>
							<li><a href="#">- (2013년)</a></li>
							<li><a href="#">- (2014년)</a></li>
							<li><a href="#">- (2015년)</a></li>
							<li><a href="#">- (2016년)</a></li>
							<li><a href="#">- (2017년)</a></li>
						</ul> -->
					</dd>
					<form name="frm_terms_left" method="post" action="/?menuno=14">
					<input type="hidden" name="ztag" id="ztag" value="rO0ABXQAMTxjYWxsIHR5cGU9Im1lbWJlciIgbm89IjEiIHNraW49ImJhdHRlcnkiPjwvY2FsbD4=" />
					<input type="hidden" name="act" value="terms" />
					<dd>

						<a href="javascript:void(0)" onclick="frm_terms_left.submit()" class="on">회원가입</a>
						<!-- <a href="/member/join.htm" class="dep">회원가입</a> -->
						<!--<ul>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
						</ul>-->
					</dd>
				</form>
				<form name="frm_find" method="post" action="/?menuno=14">
					<input type="hidden" name="ztag" id="ztag" value="rO0ABXQAMTxjYWxsIHR5cGU9Im1lbWJlciIgbm89IjEiIHNraW49ImJhdHRlcnkiPjwvY2FsbD4=" />
					<input type="hidden" name="act" value="find" />
					<dd>
						<a href="javascript:void(0)" onclick="frm_find.submit()" class="dep">아이디/비밀번호찾기</a>
						<!-- <a href="/member/index3.htm" class="dep">아이디/비밀번호찾기</a> -->
						<!--<ul>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
						</ul>-->
					</dd>
				</form>
					<dd><a href="/?menuno=37" class="dep">사이트맵</a>
						<!--<ul>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
							<li><a href="#">2차메뉴</a></li>
						</ul>-->
					</dd>
				</dl>
			</div>
			<!-- 왼쪽영역// -->

<div class="rightBox">

			<!-- //서브상단 -->
			<div class="subTopimg"><a name="cont"></a>
				<!-- //타이틀 -->
				<div class="subTop_j6"></div>
				<ul>
					<li class="subTitle"><h1><img src="/usr/skin/member/battery/images/sub06_01_03.jpg" alt="회원가입" /></h1></li>
					<li class="subEx"><img src="/usr/image/nv/sub_ex.gif" alt="항상 환경을 생각하는 녹색산업 선도형 한국국제교류재단" /></li>
				</ul>
				<!-- 타이틀// -->
			</div>
			<!-- 서브상단// -->

		<!-- //본문 -->
		<div class="subContentsBox">
			<form name="frm" method="post">
			<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
			<input type="hidden" name="act" id="act" value="${act}" />
			<input type="hidden" name="userbirth" id="userbirth" value="${userbirth}" />
			<input type="hidden" name="usersex" id="usersex" value="${usersex}" />
			<input type="hidden" name="username" id="username" value="${username}" />
			<div class="sub02_intro04" id="con1">
				<!-- //사업개요 -->
				<div><img src="/usr/skin/member/battery/images/sub06_01_01_02_03.jpg" alt="" /></div>
				<!-- 사업개요// -->
				<div class="stitle03">
					<ul style="margin-top:24px;">
						<li><img src="/usr/skin/member/battery/images/sub06_01_01_02_07.gif" alt="" /></li>
						<li style="border-top:2px solid #539dcc;margin-top:8px;height:24px;border-bottom:1px solid #cfcfcf;padding-top:16px;">
							<span style="color:#565656;font-weight:bold;padding-left:90px;">회원구분</span><span style="padding:15px;">|</span>
							<span><input type="radio" name="usertype" id="usertype0" value="0" checked="checked" /> 일반회원</span>
							<span style="padding-left:30px;"><input type="radio" name="usertype" id="usertype1" value="1" /> 과제회원</span>
						</li>
					</ul>
					<ul style="margin-top:34px;">
						<li><img src="/usr/skin/member/battery/images/sub06_01_01_02_10.gif" alt="" /></li>
						<li>
						<table cellpadding="0" cellspacing="0" style="width:740px;margin-top:8px;border-top:2px solid #539dcc;">
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 아이디</td>
							<td class="td2">|</td>
							<td class="td3"><input type="text" name="userid" id="userid" class="td4" /> <!-- <img src="/usr/skin/member/battery/images/sub06_01_01_02_14.gif" alt="" /> --> 4~16자의 영문,/숫자만 입력 가능</td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 비밀번호</td>
							<td class="td2">|</td>
							<td class="td3"><input type="password" name="userpasswd" id="userpasswd" class="td4" /></td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 비밀번호 확인</td>
							<td class="td2">|</td>
							<td class="td3"><input type="password" name="userpasswdchk" id="userpasswdchk" class="td4" /> 4~16자의 영문,/숫자만 입력 가능</td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 이름</td>
							<td class="td2">|</td>
							<td class="td3">${username}<%-- <input type="text" name="username" id="username" class="td4" value="${username}" readonly/> --%></td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 이메일</td>
							<td class="td2">|</td>
							<td class="td3" height="62">
								<input type="text" name="useremailid" id="useremailid" class="td4" /> @
								<input type="text" class="td4" name="useremaildomain" id="useremaildomain" />
								<select name="useremail" id="useremail"	style="height:21px;">
									<option value="0">직접입력</option>
									<option>hotmail.com</option>
									<option>yahoo.co.kr</option>
									<option>hanmir.com</option>
									<option>naver.com</option>
									<option>empal.com</option>
									<option>hitel.net</option>
									<option>kebi.com</option>
									<option>netian.com</option>
									<option>nate.com</option>
									<option>dreamwiz.com</option>
									<option>orgio.net</option>
									<option>korea.com</option>
									<option>hanmail.net</option>
									<option>wail.co.kr</option>
									<option>lycos.co.kr</option>
									<option>chol.com</option>
									<option>intizen.com</option>
									<option>freechal.com</option>
								</select> <br /> <font style="line-height:20px;">비밀번호 분실 시 임시비밀번호가 발송됩니다. 정확하게 기재하여 주시기 바랍니다.</font>
							</td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 우편번호</td>
							<td class="td2">|</td>
							<td class="td3">
								<input type="text" name="useraddrno1" id="useraddrno1" maxlength="3" class="td5" /> -
								<input type="text" name="useraddrno2" id="useraddrno2" maxlength="3" class="td5" />
								<a href="#none" id="postsearch"><img src="/usr/skin/member/battery/images/sub06_01_01_02_18.gif" alt="우편번호검색" /></a>
							</td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 주소(거주지)</td>
							<td class="td2">|</td>
							<td class="td3">
								<input type="text" name="useraddr" id="useraddr" class="td4" size="50"/>
								<input type="text" name="useraddr2" id="useraddr2" class="td4" size="50"/>
							</td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 전화번호</td>
							<td class="td2">|</td>
							<td class="td3">
							<select name="usertel1" id="usertel1" style="height:20px;">
								<option>02</option>
								<option>031</option>
								<option>032</option>
								<option>033</option>
								<option>041</option>
								<option>042</option>
								<option>043</option>
								<option>051</option>
								<option>052</option>
								<option>053</option>
								<option>054</option>
								<option>055</option>
								<option>061</option>
								<option>062</option>
								<option>063</option>
								<option>064</option>
								<option>010</option>
								<option>011</option>
								<option>012</option>
								<option>016</option>
								<option>017</option>
								<option>019</option>
								<option>070</option>
							</select> -
							<input type="text" name="usertel2" id="usertel2" class="td5" maxlength="4" /> - <input type="text" name="usertel3" id="usertel3" class="td5" maxlength="4" /></td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 휴대폰</td>
							<td class="td2">|</td>
							<td class="td3">
							<select name="usermobile1" id="usermobile1" style="height:20px;">
								<option>02</option>
								<option>031</option>
								<option>032</option>
								<option>033</option>
								<option>041</option>
								<option>042</option>
								<option>043</option>
								<option>051</option>
								<option>052</option>
								<option>053</option>
								<option>054</option>
								<option>055</option>
								<option>061</option>
								<option>062</option>
								<option>063</option>
								<option>064</option>
								<option>010</option>
								<option>011</option>
								<option>012</option>
								<option>016</option>
								<option>017</option>
								<option>019</option>
								<option>070</option>
							</select> -
							<input type="text" name="usermobile2" id="usermobile2" class="td5" maxlength="4"/> - <input type="text" name="usermobile3" id="usermobile3" class="td5" maxlength="4" /></td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 회사명</td>
							<td class="td2">|</td>
							<td class="td3"><input type="text" name="usercompanyname" id="usercompanyname" class="td4" /></td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 직책</td>
							<td class="td2">|</td>
							<td class="td3"><input type="text" name="usercompanystatus" id="usercompanystatus" class="td4" /></td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> 과제번호</td>
							<td class="td2">|</td>
							<td class="td3">
								<select  disabled name="usertaskno" id="usertaskno" class="td6">
									<option>10041094 (Co-free 양극소재개발) </option>
									<option>10042840 (EV용 LMO 개발)</option>
									<option>10041142 (전해액 첨가제 개발)</option>
									<option>10042948 (EV용 리튬이차전지) </option>
									<option>10041141 (기반구축)</option>
									<option>10041127 (사업화 연계)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font>과제회원구분</td>
							<td class="td2">|</td>
							<td class="td3"><span>구분
								<select disabled name="usertasksection" id="usertasksection" class="td5">
									<option>주관기관</option>
									<option>참여기관</option>
								</select></span>
								<span style="margin-left:43px;">과제역할(직책)
									<select disabled name="usertaskstatus" id="usertaskstatus" class="td5">
										<option>과제책임자</option>
										<option>실무담당자</option>
										<option>참여연구원</option>
									</select>
								</span>
							</td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> SMS 수신동의</td>
							<td class="td2">|</td>
							<td class="td3" height="62" style="line-height:23px"><font style="color:#515151;">SMS수신을 동의 하시면 홈페이지 최신정보를 받아보실 수 잇습니다. 동의하십니까?</font><br />
								<span><input type="radio" name="usersms" id="usersms"  value="y" checked /> 예(수신동의)</span>
								<span style="margin-left:15px;"><input type="radio" name="usersms" id="usersms" value="n"/> 아니오(수신동의하지않음)</span>
							</td>
						</tr>
						<tr>
							<td class="td1"><font style="color:#f25c39;">*</font> E-mail 수신동의</td>
							<td class="td2">|</td>
							<td class="td3" height="62" style="line-height:23px"><font style="color:#515151;">E-MAIL 수신을 동의 하시면 뉴스레터와 홈페이지 최신정보를 받아보실 수 잇습니다. 동의하십니까?</font><br />
								<span><input type="radio" name="usermailling" id="usermailling" value="y" checked /> 예(수신동의)</span>
								<span style="margin-left:15px;"><input type="radio" name="usermailling" id="usermailling" value="n" /> 아니오(수신동의하지않음)</span>
							</td>
						</tr>
						<tr><td height="12px;"></td></tr>
						<tr>
							<td colspan="3" align="center"><span style="margin-right:8px;"><img id="submit_b" src="/usr/skin/member/battery/images/sub06_01_01_02_22.gif" border="0" alt="가입완료" /></a></span><span><a href="/?menuno=14"><img src="/usr/skin/member/battery/images/sub06_01_01_02_24.gif" border="0" alt="취소하기" /></a></span></td>
						</tr>
						</table>
						</li>
					</ul>
				</div>
			</div>
			</form>
		</div>
		<!-- 본문// -->

		</div>
	</div>
<!--/여기까지 사용하세요-->