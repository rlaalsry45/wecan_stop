<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<link rel="stylesheet" href="/usr/css/20140704_3090680450533111.css" type="text/css" />
<link rel="stylesheet" href="/usr/skin/member/kpa/css/member.css" type="text/css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/usr/js/admsys/user/join.js"></script>
<style>
div#container{background:none;}
div#header{background:none;height:75px;}
div.cont_top{height:18px;}
div.location{float:right;padding:0;}
div.location p{font:11px '돋움';letter-spacing:-1px;padding-right:10px;}
div.location p a{font:11px '돋움';color:#999;}
div.location p span{font-weight:bold;}
.page_title {margin-top:10px;padding:0;}
.page_title h2{padding:0;}
.cont-right{width:97%;margin-left:15px;padding:20px 0px;}
label {display:inline;}
table.mgtype20 {margin-top:10px;}
.notes {display:inline-block;font-size:11px;}
select {height: 23px;}
</style>
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="#none" title="홈으로 이동">HOME</a>
						&gt;
						<a href="#none" title="회원 목록으로 이동">회원 관리</a>
						&gt;
						<span>${typeMap[userType]} 회원정보 추가</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<div class="cont-right">

			<div class="page_title"><h2>${typeMap[userType]} 기본정보</h2></div>
			<form name="frm" method="post" action="/admsys/user/organization/insert.html">
			<input type="hidden" name="userType" value="${userType}" />
			<input type="hidden" name="orgUserType" value="${userType}" />
				<table class="board-write" summary="아이디, 비밀번호">
					<caption>아이디 비밀번호 등록</caption>
					<colgroup>
						<col style="width:15%;" />
						<col style="width:35%;" />
						<col style="width:15%;" />
						<col style="width:35%;" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row"><label for="userid">아이디</label></th>
							<td colspan="3">
								<input type="text" class="text" id="userid" name="userid" title="아이디" maxlength="20" style="width:226px;" value="" />
								영문, 숫자(특수문자 제외)
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="userpasswd">비밀번호</label></th>
							<td>
								<input type="password" class="text" id="userpasswd" name="userpasswd" title="비밀번호" style="width:150px;" />
								<span class="notes">6자 이상의 영문+숫자<!-- (입력하지 않을경우 기존 비밀번호 사용) --></span>
							</td>
							<th scope="row"><label for="userpasswdchk">비밀번호 확인</label></th>
							<td>
								<input type="password" class="text" id="userpasswdchk" name="userpasswdchk" title="비밀번호 재확인" style="width:150px;" />
							</td>
						</tr>
					</tbody>
				</table>
				<table class="board-write" summary="회사명, 대표자, 회원종류, 구독부수, 우편물수령지, 사업자등록번호, 업종, 업태, 홈페이지">
					<caption>회원 기본정보</caption>
					<colgroup>
						<col style="width:15%;" />
						<col style="width:35%;" />
						<col style="width:15%;" />
						<col style="width:35%;" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row"><label for="orgName">
							<c:if test="${userType eq '1' }">회사명</c:if>
							<c:if test="${userType eq '2' }">기관명</c:if>
							</label></th>
							<td><input type="text" class="text" id="orgName" name="orgName" title="회사명" style="width:226px;" value="" /></td>

							<c:if test="${userType eq '1' }">
								<th scope="row"><label for="orgDelegate">대표자</label></th>
								<td>
									<input type="text" class="text" id="orgDelegate" name="orgDelegate" title="대표자" style="width:100px;" value="" />
									<select name="orgDelegateJob" id="orgDelegateJob">
										<option value="">선택</option>
										<c:forEach var="job" items="${jobCode}" varStatus="loop">
											<option value="${job.code}">${job.codeNm}</option>
										</c:forEach>
									</select>
								</td>
							</c:if>
							<c:if test="${userType eq '2' }">
								<th scope="row"><label for="orgDelegate">담당자</label></th>
								<td>
									<input type="text" class="text" id="orgOfficer" name="orgOfficer" title="담당자" style="width:100px;" value="" />
								</td>
							</c:if>
						</tr>
						<tr>
							<th scope="row"><label for="orgMemberType">회원종류</label></th>
							<td>
								<select name="orgMemberType" id="orgMemberType">
									<option value="">선택</option>
									<c:if test="${userType eq '1' }">
										<c:forEach var="memType" items="${memTypeCode}" varStatus="loop">
											<option value="${memType.code}">${memType.codeNm}</option>
										</c:forEach>
									</c:if>
								</select>
							</td>
							<th scope="row"><label for="orgCopyofUIS" style="background:none;">부수입력</label></th>
							<td>
								도시정보 : <input type="text" class="text" id="orgCopyofUIS" name="orgCopyofUIS" title="도시정보 부수" style="width:30px;" value="" />
								학회지 : <input type="text" class="text" id="orgCopyofJKPA" name="orgCopyofJKPA" title="학회지 부수" style="width:30px;" value="" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="receiveAddr_1">우편물 수령</label></th>
							<td>
								<input type="radio" style="vertical-align:middle;margin-left:10px;" class="radio" id="receiveAddr_1" name="orgReceiveAddr" value="1" checked="checked"/>
								<label for="receiveAddr_1">
								<c:if test="${userType eq '1' }">담당자부서</c:if>
								<c:if test="${userType eq '2' }">직장</c:if>
								</label>
								<input type="radio" style="vertical-align:middle;margin-left:10px;" class="radio" id="receiveAddr_2" name="orgReceiveAddr" value="2" />
								<label for="receiveAddr_2">
								<c:if test="${userType eq '1' }">약정자부서</c:if>
								<c:if test="${userType eq '2' }">기타</c:if>
								</label>
							</td>
							<!-- <th scope="row"><label for="orgNote" style="background:none;">기타</label></th>
							<td>
								<input type="text" class="text" id="orgNote" name="orgNote" title="기타" style="width:300px;" value="" />
							</td> -->
							<th scope="row"><label for="orgCorpRegisNo" style="background:none;">사업자등록번호</label></th>
							<td>
								<input type="text" class="text" id="orgCorpRegisNo" name="orgCorpRegisNo" title="사업자등록번호" style="width:226px;" value="" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="orgBizType" style="background:none;">사업종류</label></th>
							<td colspan="3">
								(업종 / 업태)
								<input type="text" class="text" id="orgBizType" name="orgBizType" title="업종" style="width:150px;" value="" /> / <input type="text" class="text" id="orgBizCondition" name="orgBizCondition" title="업태" style="width:250px;" value="" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="orgWebsite" style="background:none;">홈페이지</label></th>
							<td colspan="3">
								<input type="text" class="text" id="orgWebsite" name="orgWebsite" title="홈페이지" style="width:300px;" value="http://" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="orgWebsite" style="background:none;">메모</label></th>
							<td colspan="3">
								<textarea name="orgMemo"  id="orgMemo" rows="10" cols="170" maxlength="2000" class="textarea02"><c:out value="${paperSubmitInfo.PSMEMO}"/></textarea>
							</td>
						</tr>
					</tbody>
				</table>

				<div class="page_title"><h2>
				<c:if test="${userType eq '1' }">담당자 부서</c:if>
				<c:if test="${userType eq '2' }">직장</c:if>
				</h2></div>
				<table class="board-write mgtype20" summary="부서, 담당자, 직책, E-MAIL, 우편번호, 주소, 전화, FAX">
					<caption>담당자부서 정보</caption>
					<colgroup>
						<col style="width:15%;" />
						<col style="width:35%;" />
						<col style="width:15%;" />
						<col style="width:35%;" />
					</colgroup>
					<tbody class="type">
						<tr>
							<th scope="row"><label for="adr1Dept" style="background:none;">부서</label></th>
							<td colspan="3">
								<input type="text" class="text" id="adr1Dept" name="adr1Dept" title="부서" style="width:226px;" value="" />
							</td>
						</tr>
						<tr>
							<c:if test="${userType eq '1' }">
								<th scope="row"><label for="adr1Officer">담당자</label></th>
								<td><input type="text" class="text" id="adr1Officer" name="adr1Officer" title="담당자" style="width:100px;" value="" /></td>
							</c:if>
							<th scope="row"><label for="adr1Job">직책</label></th>
							<td <c:if test="${userType eq '2' }">colspan="3"</c:if>>
								<select id="adr1Job" name="adr1Job">
									<option value="">직책</option>
									<c:forEach var="job" items="${jobCode}" varStatus="loop">
										<option value="${job.code}">${job.codeNm}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="adr1Email_id" style="background:none;">E-MAIL</label></th>
							<td colspan="3">
								<input type="text" class="text" id="adr1Email_id" name="adr1Email_id" title="이메일 주소" style="width:104px;height:17px;" />
								@
								<input type="text" class="text" id="adr1Email_domain" name="adr1Email_domain" title="이메일 주소" style="width:103px;height:17px;" />
								<select id="selectdomain" style="width:101px;">
									<option value="">직접입력</option>
									<c:forEach var="domain" items="${domainCode}" varStatus="loop">
										<option value="${domain.code}">${domain.codeNm}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="f_useraddrno1" style="background:none;">우편번호</label></th>
							<td colspan="3">
								<input type="text" class="text" id="f_useraddrno1" name="adr1PostCode1" title="우편번호" style="width:104px;height:17px;" readonly onClick="javascript:postsearch('f_');"/>
								<!-- -
								<input type="text" class="text" id="f_useraddrno2" name="adr1PostCode2" title="우편번호" style="width:104px;height:17px;" readonly/ onClick="javascript:postsearch('f_');"> -->
								<a href="javascript:postsearch('f_');" id="postsearch"><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호찾기" /></a>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="f_useraddr" style="background:none;">주소</label></th>
							<td colspan="3">
								<input type="text" class="text" id="f_useraddr" name="adr1Addr" title="주소" style="width:415px;height:17px;" readonly onClick="javascript:postsearch('f_');"/>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="f_useraddr2" style="background:none;">나머지주소</label></th>
							<td colspan="3">
								<input type="text" class="text" id="f_useraddr2" name="adr1AddrDetail" title="상세주소" style="width:415px;height:17px;" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="adr1Phone1" style="background:none;">전화</label></th>
							<td>
								<input type="text" class="text" id="adr1Phone1" name="adr1Phone1" title="지역번호" style="width:72px;" maxlength="3" value="" />
								-
								<input type="text" class="text" id="adr1Phone2" name="adr1Phone2" title="중간 네자리번호" style="width:71px;" maxlength="4" value="" />
								-
								<input type="text" class="text" id="adr1Phone3" name="adr1Phone3" title="마지막 네자리번호" style="width:71px;" maxlength="4" value="" />
							</td>
							<th scope="row"><label for="adr1Fax1" style="background:none;">FAX</label></th>
							<td>
								<input type="text" class="text" id="adr1Fax1" name="adr1Fax1" title="지역번호" style="width:72px;" maxlength="3" value="" />
								-
								<input type="text" class="text" id="adr1Fax2" name="adr1Fax2" title="중간 네자리번호" style="width:71px;" maxlength="4" value="" />
								-
								<input type="text" class="text" id="adr1Fax3" name="adr1Fax3" title="마지막 네자리번호" style="width:71px;" maxlength="4" value="" />
							</td>
						</tr>
					</tbody>
				</table>

				<div class="page_title"><h2>
				<c:if test="${userType eq '1' }">약정자 부서</c:if>
				<c:if test="${userType eq '2' }">기타</c:if>
				</h2></div>
				<table class="board-write mgtype20" summary="부서, 담당자, 직책, E-MAIL, 우편번호, 주소, 전화, FAX">
					<caption>약정자 부서 정보</caption>
					<colgroup>
						<col style="width:15%;" />
						<col style="width:35%;" />
						<col style="width:15%;" />
						<col style="width:35%;" />
					</colgroup>
					<tbody class="type">
						<c:if test="${userType eq '1' }">
							<tr>
								<th scope="row"><label for="adr2Dept" style="background:none;">부서</label></th>
								<td colspan="3">
									<input type="text" class="text" id="adr2Dept" name="adr2Dept" title="부서" style="width:226px;" value="" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="adr2Officer">담당자</label></th>
								<td><input type="text" class="text" id="adr2Officer" name="adr2Officer" title="담당자" style="width:100px;" value="" /></td>
								<th scope="row"><label for="adr2Job">직책</label></th>
								<td>
									<select id="adr2Job" name="adr2Job">
										<option value="">직책</option>
										<c:forEach var="job" items="${jobCode}" varStatus="loop">
											<option value="${job.code}">${job.codeNm}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
						</c:if>
						<tr>
							<th scope="row"><label for="s_useraddrno1" style="background:none;">우편번호</label></th>
							<td colspan="3">
								<input type="text" class="text" id="s_useraddrno1" name="adr2PostCode1" title="우편번호" style="width:104px;height:17px;" readonly onClick="javascript:postsearch('s_');"/>
								<!-- -
								<input type="text" class="text" id="s_useraddrno2" name="adr2PostCode2" title="우편번호" style="width:104px;height:17px;" readonly/ onClick="javascript:postsearch('s_');"> -->
								<a href="javascript:postsearch('s_');" id="postsearch"><img src="/usr/image/common/btn/btn_code.gif" alt="우편번호찾기" /></a>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="s_useraddr" style="background:none;">주소</label></th>
							<td colspan="3">
								<input type="text" class="text" id="s_useraddr" name="adr2Addr" title="주소" style="width:415px;height:17px;" readonly onClick="javascript:postsearch('s_');"/>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="s_useraddr2" style="background:none;">나머지주소</label></th>
							<td colspan="3">
								<input type="text" class="text" id="s_useraddr2" name="adr2AddrDetail" title="상세주소" style="width:415px;height:17px;" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="adr2Phone1" style="background:none;">전화</label></th>
							<td>
								<input type="text" class="text" id="adr2Phone1" name="adr2Phone1" title="지역번호" style="width:72px;" maxlength="3" value="" />
								-
								<input type="text" class="text" id="adr2Phone2" name="adr2Phone2" title="중간 네자리번호" style="width:71px;" maxlength="4" value="" />
								-
								<input type="text" class="text" id="adr2Phone3" name="adr2Phone3" title="마지막 네자리번호" style="width:71px;" maxlength="4" value="" />
							</td>
							<th scope="row"><label for="adr2Fax1" style="background:none;">FAX</label></th>
							<td>
								<input type="text" class="text" id="adr2Fax1" name="adr2Fax1" title="지역번호" style="width:72px;" maxlength="3" value="" />
								-
								<input type="text" class="text" id="adr2Fax2" name="adr2Fax2" title="중간 네자리번호" style="width:71px;" maxlength="4" value="" />
								-
								<input type="text" class="text" id="adr2Fax3" name="adr2Fax3" title="마지막 네자리번호" style="width:71px;" maxlength="4" value="" />
							</td>
						</tr>
					</tbody>
				</table>
				<div class="btn-c05">
					<a id="submit_btn" href="#none" class="blue">등록하기</a>
					<a href="index.html?orgusertype=${userType }" class="gray">취소</a>
				</div>
			</form>
			</div>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>