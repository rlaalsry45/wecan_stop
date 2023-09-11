<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <script type="text/javascript" src="/usr/js/admsys/user/join.js"></script>
            <div id="contents">
                <div class="contents_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/user/organization/">회원관리</a> <strong>${typeMap[orgData.orgUserType]} 회원정보 수정</strong>
                    </div>
                </div>
                <div class="cont-right">
				<div id="content">
					<ul class="homepagebbs">
						<li class="bg">
							<h3 class="member">${typeMap[orgData.orgUserType]} 기본정보</h3>
						</li>
                    <form name="frm" method="post" action="/admsys/user/organization/update.html">
					<input type="hidden" name="userType" value="${orgData.orgUserType}" />
					<input type="hidden" name="orgUserNo" value="${orgData.orgUserNo}" />
					<input type="hidden" name="orgNo" value="${orgData.orgNo}" />

					<table id="main_table" class="main_table1 bgneno" summary="회원번호, 담당자 부서, 약정자 부서, 회비내역, 가입일">
                            <caption>단체회원 기본정보</caption>
                            <colgroup>
                                <col style="width:15%;" />
                                <col style="width:35%;" />
                                <col style="width:15%;" />
                                <col style="width:35%;" />
                            </colgroup>
                            <tbody>
							<tr>
								<th scope="row">회원번호</th>
								<td class="Tbod Tleft">
									<input type="text" class="text" title="회원번호" maxlength="20" style="height:23px;width:200px;" value="${userData.userno}"  disabled="disabled" />
								</td>
								<th scope="row">가입일</th>
								<td class="Tbod Tleft">
									<fmt:parseDate value="${userData.userdatereg }" pattern="yyyyMMddHHmmss" var="isoDate" />
									<input type="text" class="text" style="height:23px;width:200px;" value="<fmt:formatDate type='both' value='${isoDate}' pattern='yyyy-MM-dd' />" disabled="disabled"/>
								</td>
							</tr>
							<tr>
								<th class="Tbornone" scope="row"><label class="on_d" for="userid">아이디</label></th>
								<td class="Tleft" colspan="3">
									<input type="text" class="text" id="userid" name="userid" title="아이디" maxlength="20" style="height:23px;width:200px;" value="${userData.userid}" readonly />
									영문, 숫자(특수문자 제외)
								</td>
							</tr>
							<tr>
								<th class="Tbornone" scope="row"><label class="on_d" for="userpasswd">비밀번호</label></th>
								<td class="Tleft">
									<input type="password" class="text" id="userpasswd" name="userpasswd" title="비밀번호" style="height:23px;width:200px;" />
									<span class="notes">6자 이상의 영문+숫자<!-- (입력하지 않을경우 기존 비밀번호 사용) --></span>
								</td>
								<th class="Tbornone" scope="row"><label class="on_d" for="userpasswdchk">비밀번호 확인</label></th>
								<td class="Tleft">
									<input type="password" class="text" id="userpasswdchk" name="userpasswdchk" title="비밀번호 재확인" style="height:23px;width:200px;" />
								</td>
							</tr>
                            </tbody>
                        </table>
                        <table id="main_table" class="main_table1 bgneno" summary="회사명, 대표자, 회원종류, 구독부수, 우편물수령지, 사업자등록번호, 업종, 업태, 홈페이지">
                            <caption>회원 기본정보</caption>
                            <colgroup>
                                <col style="width:15%;" />
                                <col style="width:35%;" />
                                <col style="width:15%;" />
                                <col style="width:35%;" />
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th scope="row"><label class="on_d" for="orgName">
                                    <c:if test="${orgData.orgUserType eq '1' }">회사명</c:if>
                                    <c:if test="${orgData.orgUserType eq '2' }">기관명</c:if>
                                    </label></th>
                                    <td class="Tbod Tleft"><input type="text" id="orgName" name="orgName" value="${orgData.orgName}" title="회사명" style="height:23px;width:250px;" /></td>
                                    <c:if test="${orgData.orgUserType eq '1' }">
                                        <th scope="row"><label class="on_d" for="orgDelegate">대표자</label></th>
                                        <td class="Tbod Tleft">
                                            <input type="text" id="orgDelegate" name="orgDelegate" value="${orgData.orgDelegate}" title="대표자" style="height:23px;width:100px;"/>
                                            <select name="orgDelegateJob" id="orgDelegateJob" style="height:27px;">
                                                <option value="">대표자직책</option>
                                                <c:forEach var="job" items="${jobCode}" varStatus="loop">
                                                    <option value="${job.code}" <c:if test="${orgData.orgDelegateJob eq job.code}">selected</c:if>>${job.codeNm}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </c:if>
                                    <c:if test="${orgData.orgUserType eq '2' }">
                                        <th scope="row"><label class="on_d" for="orgDelegate">담당자</label></th>
                                        <td class="Tbod Tleft">
                                            <input type="text" class="text" id="orgOfficer" name="orgOfficer" value="${orgData.orgOfficer}" title="담당자" style="width:100px;" />
                                        </td>
                                    </c:if>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label class="on_d" for="orgMemberType">회원종류</label></th>
                                    <td class="Tleft">
                                        <select name="orgMemberType" id="orgMemberType" style="height:27px;">
                                            <option value="">회원종류</option>
                                            <c:if test="${orgData.orgUserType eq '1' }">
                                                <c:forEach var="memType" items="${memTypeCode}" varStatus="loop">
                                                    <option value="${memType.code}" <c:if test="${orgData.orgMemberType eq memType.code}">selected</c:if>>${memType.codeNm}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </td>
                                    <th class="Tbornone" scope="row"><label class="off_d" for="orgCopyofUIS">부수</label></th>
                                    <td class="Tleft">
                                        도시정보 : <input type="text" class="text" id="orgCopyofUIS" name="orgCopyofUIS" value="${orgData.orgCopyofUIS}" title="도시정보 부수" style="height:23px;width:30px;" />
                                        학회지 : <input type="text" class="text" id="orgCopyofJKPA" name="orgCopyofJKPA" value="${orgData.orgCopyofJKPA}" title="학회지 부수" style="height:23px;width:30px;" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label class="on_d" for="receiveAddr_1">우편물 수령</label></th>
                                    <td class="Tleft">
                                        <input type="radio" class="radio0" id="receiveAddr_1" name="orgReceiveAddr" value="1" <c:if test="${orgData.orgReceiveAddr eq '1'}">checked</c:if>/>
                                        <label class="on" for="receiveAddr_1">
                                        <c:if test="${orgData.orgUserType eq '1' }">담당자부서</c:if>
                                        <c:if test="${orgData.orgUserType eq '2' }">직장</c:if>
                                        </label>
                                        <input type="radio" class="radio0" id="receiveAddr_2" name="orgReceiveAddr" value="2" <c:if test="${orgData.orgReceiveAddr eq '2'}">checked</c:if>/>
                                        <label class="on" for="receiveAddr_2">
                                        <c:if test="${orgData.orgUserType eq '1' }">약정자부서</c:if>
                                        <c:if test="${orgData.orgUserType eq '2' }">기타</c:if>
                                        </label>
                                    </td>
                                    <%--<th scope="row"><label for="orgNote" style="background:none;">기타</label></th>
                                    <td>
                                        <input type="text" class="text" id="orgNote" name="orgNote" value="${orgData.orgNote}" title="기타" style="width:300px;" />
                                    </td>--%>
                                    <th class="Tbornone" scope="row"><label class="off_d" for="orgCorpRegisNo" style="background:none;">사업자등록번호</label></th>
                                    <td class="Tleft">
                                        <input type="text" class="text" id="orgCorpRegisNo" name="orgCorpRegisNo" value="${orgData.orgCorpRegisNo}" title="사업자등록번호" style="height:23px;width:200px;" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label class="on_d" for="userstatus">회원상태</label></th>
                                    <td class="Tleft">

                                    <c:choose>
                                        <c:when test="${userData.useroutrequest eq '0' && userData.enabled eq '0'}">
                                            <input type=radio class="radio0" name="userStatus" id="userStatus" value="0"> 정상
                                            <input type=radio class="radio0" name="userStatus" id="userStatus" value="1">  휴식
                                            <input type=radio class="radio0" name="userStatus" id="userStatus" value="2" checked="checked"> 탈퇴
                                        </c:when>
                                        <c:otherwise>
                                            <c:if test="${userData.annualPause  eq '1'}">
                                                <input type=radio class="radio0" name="userStatus" id="userStatus" value="0"> 정상
                                                <input type=radio class="radio0" name="userStatus" id="userStatus" value="1" checked="checked">  휴식
                                                <input type=radio class="radio0" name="userStatus" id="userStatus" value="2"> 탈퇴
                                            </c:if>
                                            <c:if test="${userData.annualPause  ne '1'}">
                                                <input type=radio class="radio0" name="userStatus" id="userStatus" value="0" checked="checked"> 정상
                                                <input type=radio class="radio0" name="userStatus" id="userStatus" value="1">  휴식
                                                <input type=radio class="radio0" name="userStatus" id="userStatus" value="2"> 탈퇴
                                            </c:if>
                                        </c:otherwise>
                                    </c:choose>
                                        &nbsp;<a href="javascript:changeStatus('${userData.userno}')" class="btn-small5">변경</a>
                                    </td>
                                </tr>

                                <tr>
                                    <th class="Tbornone" scope="row"><label for="orgBizType" class="off_d">사업종류</label></th>
                                    <td colspan="3" class="Tleft">
                                        (업종 / 업태)
                                        <input type="text" class="text" id="orgBizType" name="orgBizType" value="${orgData.orgBizType}" title="업종" style="height:23px;width:200px;" /> / <input type="text" class="text" id="orgBizCondition" name="orgBizCondition" value="${orgData.orgBizCondition}" title="업태" style="height:23px;width:200px;" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="orgWebsite" class="off_d">홈페이지</label></th>
                                    <td colspan="3" class="Tleft">
                                        <input type="text" class="text" id="orgWebsite" name="orgWebsite" value="${orgData.orgWebsite}" title="홈페이지" style="height:23px;width:300px;" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="orgWebsite" class="off_d">메모</label></th>
                                    <td colspan="3" class="Tleft">
                                        <textarea name="orgMemo"  id="orgMemo" rows="10" cols="170" maxlength="2000" class="textarea02"><c:out value="${orgData.orgMemo}"/></textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <div class="page_title"><h4>
                        <c:if test="${orgData.orgUserType eq '1' }">담당자 부서</c:if>
                        <c:if test="${orgData.orgUserType eq '2' }">직장</c:if>
                        </h4></div>
						<table id="main_table" class="main_table1 bgneno" summary="부서, 담당자, 직책, E-MAIL, 우편번호, 주소, 전화, FAX">
                            <caption>담당자부서 정보</caption>
                            <colgroup>
                                <col style="width:15%;" />
                                <col style="width:35%;" />
                                <col style="width:15%;" />
                                <col style="width:35%;" />
                            </colgroup>
                            <tbody class="type">
                                <tr>
                                    <th scope="row"><label for="adr1Dept" class="off_d">부서</label></th>
                                    <td class="Tbod Tleft" colspan="3">
                                        <input type="text" class="text" id="adr1Dept" name="adr1Dept" value="${orgData.adr1Dept}" title="부서" style="height:23px;width:200px;" />
                                    </td>
                                </tr>
                                <tr>
                                    <c:if test="${orgData.orgUserType eq '1' }">
                                    <th class="Tbornone" scope="row"><label for="adr1Officer" class="off_d">담당자</label></th>
                                    <td class="Tleft"><input type="text" class="text" id="adr1Officer" name="adr1Officer" value="${orgData.adr1Officer}" title="담당자" style="height:23px;width:100px;" /></td>
                                    </c:if>
                                    <th class="Tbornone" scope="row"><label for="adr1Job" class="off_d">직책</label></th>
                                    <td class="Tleft">
                                        <select id="adr1Job" name="adr1Job" style="height:27px;"">
                                            <option value="">직책</option>
                                            <c:forEach var="job" items="${jobCode}" varStatus="loop">
                                                <option value="${job.code}" <c:if test="${orgData.adr1Job eq job.code}">selected</c:if>><c:out value='${job.codeNm}' /></option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="adr1Email_id" class="off_d">E-MAIL</label></th>
                                    <td class="Tleft" colspan="3">
                                    <c:set var="useremail" value="${fn:split(orgData.adr1Email,'@')}" />
                                        <input type="text" class="text" id="adr1Email_id" name="adr1Email_id" title="이메일 주소" style="height:23px;width:100px;" value="${useremail[0]}" />
                                        @
                                        <input type="text" class="text" id="adr1Email_domain" name="adr1Email_domain" title="이메일 주소" style="height:23px;width:100px;" value="${useremail[1]}" />
                                        <select id="selectdomain" style="height:27px;"">
                                            <option value="">직접입력</option>
                                            <c:forEach var="domain" items="${domainCode}" varStatus="loop">
                                                <option value="${domain.code}" <c:if test="${orgData.adr1Email eq domain.code}">selected</c:if>>${domain.codeNm}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="f_useraddrno1" class="off_d">우편번호</label></th>
                                    <td class=" Tleft" colspan="3">
                                        <input type="text" class="text" id="f_useraddrno1" name="adr1PostCode1" value="${orgData.adr1PostCode}" title="우편번호" style="height:23px;width:100px;" readonly onClick="javascript:postsearch('f_');"/>
                                        <%-- -
                                        <input type="text" class="text" id="f_useraddrno2" name="adr1PostCode2" value="${fn:substring(orgData.adr1PostCode,3,6)}" title="우편번호" style="width:104px;height:17px;" readonly/ onClick="javascript:postsearch('f_');"> --%>
                                        <a class="btmore05" href="javascript:postsearch('f_');" id="postsearch">우편번호찾기</a>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="f_useraddr" class="off_d">주소</label></th>
                                    <td class="Tleft" colspan="3">
                                        <input type="text" class="text" id="f_useraddr" name="adr1Addr" value="${orgData.adr1Addr}" title="주소" style="height:23px;width:300px;" readonly onClick="javascript:postsearch('f_');"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="f_useraddr2" class="off_d">나머지주소</label></th>
                                    <td class="Tleft" colspan="3">
                                        <input type="text" class="text" id="f_useraddr2" name="adr1AddrDetail" value="${orgData.adr1AddrDetail}" title="상세주소" style="height:23px;width:300px;" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="adr1Phone1" class="off_d">전화</label></th>
                                    <td class="Tleft" >
                                    <c:set var="adr1Phone" value="${fn:split(orgData.adr1Phone,'-')}" />
                                        <input type="text" class="text" id="adr1Phone1" name="adr1Phone1" value="${adr1Phone[0]}" title="지역번호" style="height:23px;width:70px;" maxlength="3" />
                                        -
                                        <input type="text" class="text" id="adr1Phone2" name="adr1Phone2" value="${adr1Phone[1]}" title="중간 네자리번호" style="height:23px;width:70px;" maxlength="4" />
                                        -
                                        <input type="text" class="text" id="adr1Phone3" name="adr1Phone3" value="${adr1Phone[2]}" title="마지막 네자리번호" style="height:23px;width:100px;" maxlength="4" />
                                    </td>
                                    <th class="Tbornone" scope="row"><label for="adr1Fax1" class="off_d">FAX</label></th>
                                    <td class="Tleft" >
                                    <c:set var="adr1Fax" value="${fn:split(orgData.adr1Fax,'-')}" />
                                        <input type="text" class="text" id="adr1Fax1" name="adr1Fax1" value="${adr1Fax[0]}" title="지역번호" style="height:23px;width:70px;" maxlength="3" />
                                        -
                                        <input type="text" class="text" id="adr1Fax2" name="adr1Fax2" value="${adr1Fax[1]}" title="중간 네자리번호" style="height:23px;width:70px;" maxlength="4" />
                                        -
                                        <input type="text" class="text" id="adr1Fax3" name="adr1Fax3" value="${adr1Fax[2]}" title="마지막 네자리번호" style="height:23px;width:70px;" maxlength="4" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <div class="page_title"><h4>
                        <c:if test="${orgData.orgUserType eq '1' }">약정자 부서</c:if>
                        <c:if test="${orgData.orgUserType eq '2' }">기타</c:if>
                        </h4></div>
						<table id="main_table" class="main_table1 bgneno" summary="부서, 담당자, 직책, E-MAIL, 우편번호, 주소, 전화, FAX">
                            <caption>약정자 부서 정보</caption>
                            <colgroup>
                                <col style="width:15%;" />
                                <col style="width:35%;" />
                                <col style="width:15%;" />
                                <col style="width:35%;" />
                            </colgroup>
                            <tbody class="type">
                                <c:if test="${orgData.orgUserType eq '1' }">
                                <tr>
                                    <th scope="row"><label for="adr2Dept" class="off_d">부서</label></th>
                                    <td class="Tbod Tleft" colspan="3">
                                        <input type="text" class="text" id="adr2Dept" name="adr2Dept" title="부서" style="height:23px;width:100px;" value="${orgData.adr2Dept}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="adr2Officer" class="off_d">담당자</label></th>
                                    <td class="Tleft"><input type="text" class="text" id="adr2Officer" name="adr2Officer" value="${orgData.adr2Officer}" title="담당자" style="height:23px;width:100px;" /></td>
                                    <th class="Tbornone" scope="row"><label for="adr2Job" class="off_d">직책</label></th>
                                    <td class="Tleft">
                                        <select id="adr2Job" name="adr2Job" style="height:27px;">
                                            <option value="">직책</option>
                                            <c:forEach var="job" items="${jobCode}" varStatus="loop">
                                                <option value="${job.code}" <c:if test="${orgData.adr2Job eq job.code}">selected</c:if>>${job.codeNm}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                </c:if>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="s_useraddrno1" class="off_d">우편번호</label></th>
                                    <td class="Tleft" colspan="3">
                                        <input type="text" class="text" id="s_useraddrno1" name="adr2PostCode1" value="${orgData.adr2PostCode}" title="우편번호" style="height:23px;width:100px;" readonly onClick="javascript:postsearch('s_');"/>
                                        <%--<input type="text" class="text" id="s_useraddrno2" name="adr2PostCode2" value="${fn:substring(orgData.adr2PostCode,3,6)}" title="우편번호" style="width:104px;height:17px;" readonly/ onClick="javascript:postsearch('s_');">--%>
                                        <a class="btmore05" href="javascript:postsearch('s_');" id="postsearch">우편번호찾기</a>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="s_useraddr" class="off_d">주소</label></th>
                                    <td class="Tleft" colspan="3">
                                        <input type="text" class="text" id="s_useraddr" name="adr2Addr" value="${orgData.adr2Addr}" title="주소" style="height:23px;width:300px;" readonly onClick="javascript:postsearch('s_');"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="s_useraddr2" class="off_d">나머지주소</label></th>
                                    <td class="Tleft" colspan="3">
                                        <input type="text" class="text" id="s_useraddr2" name="adr2AddrDetail" value="${orgData.adr2AddrDetail}" title="상세주소" style="height:23px;width:300px;" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="Tbornone" scope="row"><label for="adr2Phone1" class="off_d">전화</label></th>
                                    <td class="Tleft">
                                    <c:set var="adr2Phone" value="${fn:split(orgData.adr2Phone,'-')}" />
                                        <input type="text" class="text" id="adr2Phone1" name="adr2Phone1" value="${adr2Phone[0]}" title="지역번호" style="height:23px;width:70px;" maxlength="3" />
                                        -
                                        <input type="text" class="text" id="adr2Phone2" name="adr2Phone2" value="${adr2Phone[1]}" title="중간 네자리번호" style="height:23px;width:70px;"  maxlength="4" />
                                        -
                                        <input type="text" class="text" id="adr2Phone3" name="adr2Phone3" value="${adr2Phone[2]}" title="마지막 네자리번호" style="height:23px;width:70px;"  maxlength="4" />
                                    </td>
                                    <th class="Tbornone" scope="row"><label for="adr2Fax1" class="off_d">FAX</label></th>
                                    <td class="Tleft">
                                    <c:set var="adr2Fax" value="${fn:split(orgData.adr2Fax,'-')}" />
                                        <input type="text" class="text" id="adr2Fax1" name="adr2Fax1" value="${adr2Fax[0]}" title="지역번호" style="height:23px;width:70px;"  maxlength="3" />
                                        -
                                        <input type="text" class="text" id="adr2Fax2" name="adr2Fax2" value="${adr2Fax[1]}" title="중간 네자리번호" style="height:23px;width:70px;"  maxlength="4" />
                                        -
                                        <input type="text" class="text" id="adr2Fax3" name="adr2Fax3" value="${adr2Fax[2]}" title="마지막 네자리번호" style="height:23px;width:70px;"  maxlength="4" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <c:if test="${orgData.orgUserType eq '1' }">
                        <h4 class="sstit">회비내역</h4>
                        <div class="top_bt">
                            <a href="#none" onclick="addDuesInfo('${param.userno}')" class="btmore07">회비내역추가</a>
                            <a href="#none" onclick="editDuesInfo('${param.userno}')" class="btmore07">회비내역수정</a>
                        </div>
                        <script type="text/javascript">
                            function addDuesInfo(userno){
                                var url = "/admsys/dues/addDuesInfo.html?userno="+userno+"&act=org"
                                var windowName = "addDuesInfo";
                                var windowWidth = 1000;
                                var windowHeight = 300;
                                var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
                                var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
                                var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
                                window.open(url, windowName, windowSize);
                            }
                            function editDuesInfo(userno){
                                var url = "/admsys/dues/editDuesInfo.html?userno="+userno+"&act=org"
                                var windowName = "addDuesInfo";
                                var windowWidth = 1300;
                                var windowHeight = 600;
                                var windowLeft = parseInt((screen.availWidth/2) - (windowWidth/2));
                                var windowTop = parseInt((screen.availHeight/2) - (windowHeight/2));
                                var windowSize = "width=" + windowWidth + ",height=" + windowHeight + ",left=" + windowLeft + ",top=" + windowTop + ",screenX=" + windowLeft + ",screenY=" + windowTop;
                                window.open(url, windowName, windowSize);
                            }
                        </script>
						<table id="main_table" class="main_table1 bgneno" summary="회비내역">
                            <caption>회비내역</caption>
                            <colgroup>
                                <col  />
                                <col style="width:10%;" />
                                <col style="width:8%;" />
                                <col style="width:15%;" />
                                <!-- <col style="width:20%;" /> -->
                                <col style="width:25%;" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th scope="col" class="first">회비종류</th>
                                    <th scope="col">금액</th>
                                    <th scope="col">납입년도</th>
                                    <th scope="col">납입일</th>
                                    <!-- <th scope="col">기간</th> -->
                                    <th scope="col">비고</th>
                                </tr>
                            </thead>
                            <tbody class="type02">
                                <c:forEach items="${dueslist}" var="each" varStatus="loop">
                                    <c:if test="${each.annualPause ne '9'}" >
                                        <tr>
                                            <td><c:out value='${each.oProductNM}' /></td>
                                            <td><c:out value='${each.oAmt}' /></td>
                                            <td><c:out value='${each.limitYearMonth}' /></td>
                                            <td>
                                                <c:if test="${each.payconfirm eq '1' }">
                                                    <fmt:parseDate value="${each.regdate}" pattern="yyyy-MM-dd HH:mm:SS" var="isoDate" />
                                                    <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd" />
                                                </c:if>
                                            </td>
                                            <%-- <td><c:out value='${data.startYearMonth}' />~<c:out value='${data.limitYearMonth}' /></td> --%>
                                            <td><c:out value='${each.etc}' />
                                            [<c:if test="${each.payconfirm eq '1' }">납부</c:if>
                                            <c:if test="${each.payconfirm eq '0' || each.payconfirm eq null}">미납</c:if>
                                            <c:if test="${each.payconfirm eq '9' }">취소</c:if>]
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </tbody>
                        </table>
                        </c:if>
                        <div class="btn-c-B">
                            <a class="btmore04" id="submit_btn" href="#none">수정하기</a>
                            <a class="btmore05" href="index.html?orgusertype=${orgData.orgUserType}">취 소</a>
                        </div>
                    </form>
					</li>
				</ul>
				</div>
                </div>
                <!--/con-right-->
            </div>
            <!--/contents-->
<jsp:include page="../../end.jsp" flush="true" />