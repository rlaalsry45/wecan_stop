<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />

<style>
.chost_btn {display:inline-block;padding:0 15px;height:23px;line-height:23px;font-size:12px;color:#fff;background:#495a74;border:0px;}
table td.Tleft{text-align:left;}
</style>
<script language="JavaScript">
$(function() {
    /*년도 selectbox 만들기. */
    var date  = new Date();
    var year  = date.getFullYear();
    var syear = "";
      for(var i = 0 ; i < 80 ; i++ ) {
        syear += "<option value='"+(year - i)+"'>"+(year - i)+"</option>";
    }
    $("#sdate").append(syear);
    $("#edate").append(syear);

});

function frmCheck() {
    if($("#search").val() == "1"){
        if($("#sdate").val() != ""){
            if($("#edate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#edate").focus();
                return false;
            }
            if($("#paytype").val() == ""){
                alert("회비납부 여부를 선택세요.");
                $("#paytype").focus();
                return false;
            }
        }

        if($("#edate").val() != ""){
            if($("#sdate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#sdate").focus();
                return false;
            }
            if($("#paytype").val() == ""){
                alert("회비납부 여부를 선택세요.");
                $("#paytype").focus();
                return false;
            }
        }

        if($("#paytype").val() != ""){
            if($("#sdate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#sdate").focus();
                return false;
            }

            if($("#edate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#edate").focus();
                return false;
            }
        }
    }

    if($("#search").val() == "2") {
        if($("#sdate").val() != "") {
            if($("#paytype").val() == "") {
                alert("회비납부 여부를 선택세요.");
                $("#paytype").focus();
                return false;
            }

            if($("#edate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#edate").focus();
                return false;
            }

            if($("#paytype2").val() == ""){
                alert("회비납부 여부를 선택세요.");
                $("#paytype2").focus();
                return false;
            }

        }

        if($("#edate").val() != ""){
            if($("#sdate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#sdate").focus();
                return false;
            }
            if($("#paytype").val() == ""){
                alert("회비납부 여부를 선택세요.");
                $("#paytype").focus();
                return false;
            }
            if($("#paytype2").val() == ""){
                alert("회비납부 여부를 선택세요.");
                $("#paytype2").focus();
                return false;
            }
        }

        if($("#paytype").val() != ""){
            if($("#sdate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#sdate").focus();
                return false;
            }

            if($("#edate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#edate").focus();
                return false;
            }
            if($("#paytype2").val() == ""){
                alert("회비납부 여부를 선택세요.");
                $("#paytype2").focus();
                return false;
            }

        }

        if($("#paytype2").val() != ""){
            if($("#sdate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#sdate").focus();
                return false;
            }

            if($("#edate").val() == ""){
                alert("검색년도를 선택하세요.");
                $("#edate").focus();
                return false;
            }
            if($("#paytype").val() == ""){
                alert("회비납부 여부를 선택세요.");
                $("#paytype2").focus();
                return false;
            }
        }

        if($("#cond7").val() != ""){
            if($("#cond8").val() == ""){
                alert("회원번호를 입력하세요.");
                $("#cond8").focus();
                return false;
            }
        }
        if($("#cond8").val() != ""){
            if($("#cond7").val() == ""){
                alert("회원번호를 입력하세요.");
                $("#cond7").focus();
                return false;
            }
        }

    }
    return true;
}
</script>

            <div id="contents">
				<div class="contants_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/user/common/">회원관리</a> <strong><c:if test="${orgusertype eq '1' }">
						<c:if test="${search eq '1' }">단체회원</c:if>
						<c:if test="${search eq '2' }">단체회원  회비</c:if>
					</c:if>
					<c:if test="${orgusertype eq '2' }">기증회원</c:if> 검색</strong>
                    </div>
                </div>
				<div id="content">
				<ul class="homepagebbs">
					<li class="bg"><h3 class="member">
					<c:if test="${orgusertype eq '1' }">
						<c:if test="${search eq '1' }">단체회원</c:if>
						<c:if test="${search eq '2' }">단체회원  회비</c:if>
					</c:if>
					<c:if test="${orgusertype eq '2' }">기증회원</c:if> 검색</h3>
					</li>
					<li>
						<form name="frm" method="post" action="index.html" onsubmit="return frmCheck();">
						<input type="hidden" name="search" id="search" value="${search }"/>
						<input type="hidden" name="orgusertype" value="${orgusertype }"/>
						<c:if test="${orgusertype eq '1' }">
							<c:if test="${search eq '1' }">
							<table class="main_table1 bgneno" summary="검색조건, 정렬조건">
							<caption>단체회원검색</caption>
							<colgroup>
								<col style="width:10%" />
								<col style="width:10%" />
								<col />
							</colgroup>
								<tr>
									<th rowspan="5" class="Tleft">검색조건</th>
									<td align="center" class="rborder Tbod">검색어</td>
									<td class="Tbod Tleft">
										<select name="cond6" id="cond6" style="height:27px;">
											<option value="1">회사명</option>
											<option value="2">대표자명</option>
											<option value="3">회원번호</option>
										</select>
										<input type="text" name="keyword" style="height:23px;width:140px;"><!-- *like 검색시 검색어 앞에 %를 입력해주세요. -->
									</td>
								</tr>
								<tr>
									<td class="rborder">회원번호</td>
									<td colspan="2" class="Tleft"><input type="text" name="cond7" id="cond7" style="height:23px;width:100px;"> ~ <input type="text" name="cond8" id="cond8" style="height:23px;width:100px;"></td>
								</tr>
								<tr>
									<td class="rborder">회원종류</td>
									<td colspan="2" class="Tleft">
										<select name="cond9" id="cond9" style="height:27px;">
											<option value="">선택</option>
												<c:forEach var="memType" items="${memTypeCode}" varStatus="loop">
													<option value="${memType.code}">${memType.codeNm}</option>
												</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td class="rborder">회원상태</td>
									<td colspan="2" class="Tleft" >
										<input type="radio" class="radio0" name="cond10" id="cond10" value="1" checked="checked"> 정상
										<input type="radio" class="radio0" name="cond10" id="cond10" value="9"> 탈퇴
										<input type="radio" class="radio0" name="cond10" id="cond10" value="0">  휴식
									</td>
								</tr>
								<tr>
									<td class="rborder">회비</td>
									<td colspan="2" class="Tleft">
										<select id="sdate" style="height:27px;" name="sdate">
											<option value="">--선택--</option>
										</select> 년 ~
										<select id="edate" style="height:27px;" name="edate">
											<option value="">--선택--</option>
										</select> 년
										<select name="paytype" id="paytype" style="height:27px;">
											<option value="">--선택--</option>
											<option value="1">납부</option>
											<option value="2">미납</option>
										</select>
									</td>
								</tr>
								<tr>
									<th colspan="2" class="Tbornone Tleft">정렬조건</th>
									<td class="Tleft" colspan="3">
									<select name="st_sec1" style="height:27px;">
											<option value="orgUserNo">회원번호</option>
											<option value="orgName">회사명</option>
											<option value="adr1Officer">담당자명</option>
									</select>
									<select name="st_sec2" style="height:27px;">
											<option value="1">오름차순</option>
											<option value="2">내림차순</option>
									</select>
									</td>
								</tr>
							</table>
							<div class="btn-c">
								<input type="submit" class="chost_btn_s" value="검 색">
							</div>

							</c:if>
							<c:if test="${search eq '2' }">
									<table class="main_table1 bgneno" summary="검색조건, 정렬조건">
									<caption>단체회원 회비 검색</caption>
									<colgroup>
										<col style="width:10%" />
										<col style="width:10%" />
										<col style="" />
									</colgroup>
									<tr>
										<th rowspan="2" class="Tleft">검색조건</th>
										<td align="center" class="rborder Tbod">회비</td>
										<td  class="rborder Tbod Tleft">
										<select id="sdate" style="height:27px;" name="sdate">
											<option value="">--선택--</option>
										</select>년
										<select name="paytype"  id="paytype" style="height:27px;">
											<option value="">--선택--</option>
											<option value="1">납부</option>
											<option value="2">미납</option>
										</select>
										<select name="andOr"  id="andOr" style="height:27px;">
											<option value="and">AND</option>
											<option value="or">OR</option>
										</select>
										<select id="edate" style="height:27px;"  name="edate">
											<option value="">--선택--</option>
										</select>년
										<select name="paytype2"  id="paytype2" style="height:27px;">
											<option value="">--선택--</option>
											<option value="1">납부</option>
											<option value="2">미납</option>
										</select>
										</td>
									</tr>
									<tr>
										<td align="center" class="rborder">회원번호</td>
										<td colspan="2" class="Tleft">
											<input type="text" name="cond7" id="cond7" style="height:23px;width:100px;" /> ~ <input type="text" name="cond8"  id="cond8" style="height:23px;width:100px;" />
										</td>
									</tr>
									<tr>
										<th colspan="2" class="Tbornone Tleft">정렬조건</th>
										<td colspan="2" class="Tleft" >
										<select name="st_sec1" style="height:27px;">
												<option value="orgUserNo">회원번호</option>
												<option value="orgName">회사명</option>
												<option value="adr1Officer">담당자명</option>
										</select>
										<select name="st_sec2" style="height:27px;">
												<option value="1">오름차순</option>
												<option value="2">내림차순</option>
										</select>
										</td>
									</tr>
									</table>
									<div class="btn-c">
										<input type="submit" class="chost_btn_s" value="검 색">
									</div>

							</c:if>
							</c:if>
							<c:if test="${orgusertype eq '2' }">
								<table class="main_table1 bgneno" summary="검색조건, 정렬조건">
								<caption> 기증회원 검색</caption>
								<colgroup>
									<col style="width:10%" />
									<col style="width:10%" />
									<col style="" />
								</colgroup>
								<tr>
									<th rowspan="3" class="Tleft">검색조건</th>
									<td align="center" class="rborder Tbod">검색어</td>
									<td class="rborder Tbod Tleft">
									<select name="cond6" id="cond6" style="height:27px;">
											<option value="1">기관명</option>
											<option value="2">담당자명</option>
											<option value="3">회원번호</option>
									</select> <input type="text" name="keyword" style="height:23px;width:140px;"><!-- *like 검색시 검색어 앞에 %를 입력해주세요. --></td>
								</tr>
								<tr>
									<td align="center" class="rborder">회원번호</td>
									<td colspan="2" class="Tleft"><input type="text" name="cond7" style="height:23px;width:100px;"> ~ <input type="text" name="cond8" style="height:23px;width:100px;"></td>
								</tr>
								<tr>
									<td align="center" class="rborder">회원상태</td>
									<td colspan="2" class="semimemberconfirm" style="text-align:left;">
										<input type=radio class="radio" name="cond10" id="cond10" value="1" checked="checked" style="vertical-align:middle;margin-left:10px;"> 정상
										<input type=radio class="radio" name="cond10" id="cond10" value="9" style="vertical-align:middle;margin-left:10px;"> 탈퇴
										<input type=radio class="radio" name="cond10" id="cond10" value="0" style="vertical-align:middle;margin-left:10px;"> 휴식

									</td>
								</tr>

								<tr>
									<th colspan="2" style="text-align:center" class="Tbornone Tleft">정렬조건</th>
									<td class="Tleft" colspan="2">
									<select name="st_sec1" style="height:27px;">
											<option value="orgUserNo">회원번호</option>
											<option value="orgName">기관명</option>
											<option value="orgDelegate">담당자명</option>
									</select>
									<select name="st_sec2" style="height:27px;">
											<option value="1">오름차순</option>
											<option value="2">내림차순</option>
									</select>
									</td>
								</tr>
							</table>
							<div class="btn-c">
								<input type="submit" class="chost_btn_s" value="검 색">
							</div>
							</c:if>
                         </form>
					</li>
				</ul>
			</div>
            </div><!--/contents-->
        </div><!--/container-->
    </div><!--/wrap-->
</body>
</html>
