<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />

<style>
.chost_btn {display:inline-block;padding:0 15px;height:23px;line-height:23px;font-size:12px;color:#fff;background:#495a74;border:0px;}
table td.chost_table_body{text-align:left;}
</style>
<script language="JavaScript">
<!--
    function Detail(fieldname, code, codename) {
        //window.open("p_user_srch_field.html?code=" + code + "&codename=" + codename+"&fieldname="+fieldname, "", "width=260,height=300");
        window.open("p_user_srch_field.html?code=" + code + "&fieldname="+fieldname, "", "width=260,height=300");
    }

    function Checkform1() {
        if (frm1.sc_sec9.value == "") {
            alert("승인여부를 선택하세요.");
            frm1.sc_sec9.focus();
            return false;
        }
    }

    function Checkform2() {
        var value, add_value;

        if (frm2.sc_sec9.value == "") {
            alert("승인여부를 선택하세요.");
            frm2.sc_sec9.focus();
            return false;
        }

        /*  if((frm2.sc_sec21.value!="") && (frm2.sc_sec26.value=="")) {
         alert("회비 납부여부를 선택하세요.");
         frm2.sc_sec26.focus();
         return false;
         }*/
        if (frm2.sc_sec26.value == "1") {
            /*
            if(frm2.sc_sec21.value=="") {
                alert("회비 종류를 선택하세요.");
                frm2.sc_sec21.focus();
                return false;
            }
            if(frm2.sc_sec22.value=="") {
                alert("회비 검색기간을 선택하세요.");
                frm2.sc_sec22.focus();
                return false;
            }
             */
            if (frm2.sc_sec24.value == "") {
                alert("회비 검색기간을 선택하세요.");
                frm2.sc_sec24.focus();
                return false;
            }
            /*
             if(frm2.sc_sec26.value=="") {
             alert("회비 납부여부를 선택하세요.");
             return false;
             }
             */
        }

        if (frm2.sc_sec31.value != "") {
            /*if(frm2.sc_sec32.value=="") {
                alert("검색기간을 선택하세요.");
                frm2.sc_sec32.focus();
                return false;
            }

            if(frm2.sc_sec35.value=="") {
                alert("검색기간을 선택하세요.");
                frm2.sc_sec35.focus();
                return false;
            }*/

        }
        if (frm2.sf_sec2.value == "") {
            alert("보여질 필드를 하나이상 선택하세요.");
            return false;
        }

        add_value = "";
        for (i = 0; i < frm2.sf_sec2.length; i++) {
            if (frm2.sf_sec2.options[i].selected) {
                value = frm2.sf_sec2.options[i].value;
                add_value += value + "::";
            }
        }
        frm2.sf_sec1.value = add_value;

    }

    function CheckPrt() {
        if (frm2.printflag.checked == true) {
            fList = frm2.sf_sec1;
            fList.options[0].selected = true;

        }
    }
//-->
</script>
                <div id="contents">
                    <div class="contants_top">
						<div class="location">
							<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/user/common/">회원관리</a> <strong>회원다중검색</strong>
						</div>
					</div>
                    <div id="content">
						<ul class="homepagebbs">
							<li class="bg"><h3 class="member">회원다중검색</h3></li>
							<li>
								<form name="frm2" method="post" action="result.html" onSubmit="return Checkform2()">
								<table class="main_table1 bgneno" summary="검색조건, 정렬조건, 필드선택">
								<colgroup>
									<col style="width:10%" />
									<col style="width:10%" />
									<col style="width:15%" />
									<col style="width:15%" />
									<col />
									<col style="width:15%" />
									<col style="width:15%" />
								</colgroup>
								<tr>
									<th rowspan="14" class="Tleft">검색조건</th>
									<td class="rborder Tbod">회원구분</td>
									<td class="Tbod Tleft" colspan="5">
									<select name="work_grade" style="height:27px;width:170px;">
											<option value="">----- 전체 -----</option>
											<option value="1">정회원</option>
											<option value="2">종신회원</option>
											<option value="3">준회원</option>
											<option value="6">외부심사위원</option>
									</select>
									<input type="button" class="chost_btn_s3" value="상 세" onClick="Detail('sc_sec1_val','KPA201', '회원구분')">
									<input type="text" size="40" name="sc_sec1_val" style="height:23px;width:170px;">
									<select name="sd_sec1" style="height:27px;">
										<option value="and">AND</option>
										<option value="or">OR</option>
									</select></td>
								</tr>
								<tr>
									<td align="center" class="rborder">지회</td>
									<td class="chost_table_body" colspan="5">
									<select name="branch" style="height:27px;width:170px;">
										<option value="">----- 전체 -----</option>
										<option value="1">부산울산경남지회</option>
										<option value="2">대구경북지회</option>
										<option value="3">강원지회</option>
										<option value="4">광주전남지회</option>
										<option value="5">대전세종충청지회</option>
										<option value="6">전라북도지회</option>
										<option value="7">제주지회</option>
									</select>
									<input type="button" class="chost_btn_s3" value="상 세" onClick="Detail('sc_sec2_val', 'KPA202', '지회구분')">
									<input type="text" size="40" name="sc_sec2_val" style="height:23px;width:170px;">
									<select name="sd_sec2" style="height:27px;">
											<option value="and">AND</option>
											<option value="or">OR</option>
									</select></td>
								</tr>
								<tr>
									<td class="rborder">직장</td>
									<td class="chost_table_body" colspan="5">
									<select name="workplace" style="height:27px;width:170px;">
											<option value="">----- 전체 -----</option>
											<option value="01">대학교수</option>
											<option value="02">연구소</option>
											<option value="03">대학원생</option>
											<option value="04">건설회사</option>
											<option value="05">건축사사무소</option>
											<option value="06">공공기관</option>
											<option value="07">구조사무</option>
											<option value="08">기타회사</option>
											<option value="09">중고교</option>
											<option value="10">외국인</option>
											<option value="11">기타</option>
											<option value="12">대학생</option>
											<option value="13">기술용역</option>
											<option value="14">엔지니어링</option>
											<option value="15">도시경관/도시계획</option>
									</select>
									<input type="button" class="chost_btn_s3" value="상 세" onClick="Detail('sc_sec4_val', 'KPA206', '직장종류')">
										<input type="text" size="40" name="sc_sec4_val"	style="height:23px;width:170px;">
										<select
										name="sd_sec4" style="height:27px;">
											<option value="and">AND</option>
											<option value="or">OR</option>
									</select></td>
								</tr>
								<tr>
									<td class="rborder">임원</td>
									<td class="chost_table_body" colspan="5"><select
										name="executive" style="height:27px;width:170px;">
											<option value="">----- 전체 -----</option>
											<option value="01">회장</option>
											<option value="02">이사</option>
											<option value="03">상임이사</option>
											<option value="04">고문</option>
											<option value="05">지회장</option>
											<option value="06">부단장</option>
											<option value="07">공동단장</option>
											<option value="08">학술담당부회장</option>
											<option value="09">부회장/지회장</option>
											<option value="10">감사</option>
											<option value="11">재정담당부회장</option>
											<option value="12">지방부회장</option>
											<option value="13">기술계부회장</option>
											<option value="14">산학부회장</option>

									</select>
									<input type="button" class="chost_btn_s3"	value="상 세" onClick="Detail('sc_sec5_val', 'KPA203', '임원')">
										<input type="text" size="40" name="sc_sec5_val" style="height:23px;width:170px;">
										<select	name="sd_sec5" style="height:27px;">
											<option value="and">AND</option>
											<option value="or">OR</option>
										</select></td>
								</tr>
								<tr>
									<td class="rborder">위원회</td>
									<td class="chost_table_body" colspan="5">
										<select	name="committee" style="height:27px;width:170px;">
											<option value="">----- 전체 -----</option>
											<option value="01">학회지 편집위원회</option>
											<option value="02">도시정보지 편집위원회</option>
											<option value="03">학술위원회</option>
											<option value="04">국제학술교류위원회</option>
											<option value="05">회관건립추진위원회</option>
											<option value="06">도시계획 전문인 영역확대 위원회</option>
											<option value="07">농촌도시계획연구위원회</option>
											<option value="08">도시의날행사추진및도시대상평가단</option>
											<option value="09">통일국토연구위원회</option>
											<option value="10">Young Scholar Society</option>
											<option value="11">국토도시교육원</option>
											<option value="12">국토도시정책위원회</option>
											<option value="13">계획이론역사연구위원회</option>
											<option value="14">지역경제계획연구위원회</option>
											<option value="15">방재&middot;안전연구위원회</option>
											<option value="16">창조도시연구위원회</option>
											<option value="17">국토도시아카데미</option>
											<option value="18">국토·도시관련제도연구위원회</option>
											<option value="19">APPR 위원회</option>
											<option value="20">계획인증 및 학문분류위원회</option>
											<option value="21">교재편찬 위원회</option>
											<option value="22">북한도시연구위원회</option>
											<option value="23">부동산정책연구위원회</option>
											<option value="24">녹색교통연구위원회</option>
											<option value="25">입체도시계획연구위원회</option>
											<option value="26">도시재생연구위원회</option>
											<option value="27">명품도시연구위원회</option>
											<option value="28">행정중심복합도시기획조정단</option>
											<option value="29">마을만들기 연구위원회</option>
											<option value="30">U-City 연구위원회</option>
											<option value="31">경관 연구위원회</option>
											<option value="32">지자체정책자문 및 국토도시포럼</option>
											<option value="33">지구단위계획연구위원회</option>
											<option value="34">국가균형발전연구단</option>
											<option value="35">학회운영개선특별위원회</option>
											<option value="36">건강도시연구위원회</option>
											<option value="37">광역경제권연구위원회</option>
											<option value="38">교통물류연구위원회</option>
											<option value="39">도시개발컨설팅연구위원회</option>
											<option value="40">도시마케팅연구위원회</option>
											<option value="41">생태도시연구위원회</option>
											<option value="42">해외도시개발연구위원회</option>
											<option value="43">GIS연구위원회</option>
											<option value="44">계획실명제추진단</option>
											<option value="45">국토도시디자인대전추진단</option>
											<option value="46">기획위원회</option>
											<option value="47">도시환경설계위원회</option>
											<option value="48">녹색성장연구위원회</option>
											<option value="49">비법정도시계획연구위원회</option>
											<option value="50">토지이용교통통합연구위원회</option>
											<option value="51">IJUS 위원회</option>
											<option value="52">APPR 위원회</option>
											<option value="53">교육위원회</option>
											<option value="54">도시의 날 추진위원회</option>
											<option value="55">도시대상 평가단</option>
											<option value="56">산학협력특별위원회</option>
											<option value="57">YSS특별위원회</option>
											<option value="58">도시계획사연구위원회</option>
											<option value="59">도시경제.산업연구위원회</option>
											<option value="60">도시환경.에너지연구위원회</option>
											<option value="61">지역개발연구위원회</option>
											<option value="62">도시.부동산개발연구위원회</option>
											<option value="63">주거복지연구위원회</option>
											<option value="64">도시설계연구위원회</option>
											<option value="65">3D도시계획 및 경관연구위원회</option>
											<option value="66">오픈스페이스연구위원회</option>
											<option value="67">역사보전연구위원회</option>
											<option value="68">도시문화연구위원회</option>
											<option value="69">도시방재연구위원회</option>
											<option value="70">주택 및 부동산연구위원회</option>
											<option value="71">도시 및 주거환경정비위원회</option>
											<option value="72">순환형도시계획연구위원회</option>
									</select>
									<input type="button" class="chost_btn_s3" value="상 세" onClick="Detail('sc_sec11_val', 'KPA204', '임원')">
									<input type="text" size="40" name="sc_sec11_val" style="height:23px;width:170px;">
									<select name="sd_sec11" style="height:27px;">
											<option value="and">AND</option>
											<option value="or">OR</option>
									</select></td>
								</tr>
								<tr>
									<td class="rborder">학력</td>
									<td class="chost_table_body" colspan="5">
									<select name="lasteducation" style="height:27px;width:170px;">
											<option value="">----- 전체 -----</option>
											<option value="0">학사</option>
											<option value="1">석사</option>
											<option value="2">박사</option>
											<option value="3">기타</option>
									</select>
									<input type="button" class="chost_btn_s3" value="상 세" onClick="Detail('sc_sec12_val', 'KPA207', '학력')">
									<input type="text" size="40" name="sc_sec12_val" style="height:23px;width:170px;">
									<select name="sd_sec12" style="height:27px;">
											<option value="and">AND</option>
											<option value="or">OR</option>
									</select></td>
								</tr>
								
								<tr>
									<td class="rborder">학교</td>
									
									<td colspan="5" class="Tleft">
										<input  type="text" size="30" name="university" style="height:23px;width:200px;"/>
									</td>

								</tr>
								<tr>
									<td class="rborder">학위</td>
									<td class="Tleft">
										<select name="degrees" style="height:27px;">
											<option value="">-- 선택 --</option>
											<option value="0">졸업</option>
											<option value="1">수료</option>
											<option value="2">재학중</option>
										</select></td>
									<td class="rborder lborder">중지여부</td>
									<td class="Tleft">
										<select name="annualpause" style="height:27px;">
											<option value="">-- 선택 --</option>
											<option value="2">정상회원</option>
											<option value="1">휴식회원</option>

										</select></td>
									<td class="rborder lborder">성별</td>
									<td class="Tleft">
										<select	name="usersex" style="height:27px;">
											<option value="">-- 선택 --</option>
											<option value="1">남자</option>
											<option value="2">여자</option>
										</select></td>
								</tr>
								<tr>
									<td class="rborder">승인여부</td>
									<td class="Tleft">
										<select name="semimemberconfirm" style="height:27px;">
											<option value="">-- 선택 --</option>
											<option value="1" selected="selected">승인</option>
											<option value="0">승인대기</option>
											<option value="9">삭제된회원</option>
										</select></td>
									<td align="center" class="rborder lborder">우편물 보류</td>
									<td class="Tleft">
										<select name="postal" style="height:27px;">
											<option value="">-- 선택 --</option>
											<option value="Y">정상</option>
											<option value="N">발송안됨</option>
										</select></td>
									<td align="center" class="rborder lborder">단체회원</td>
									<td class="Tleft">
										<select name="groupuser" style="height:27px;">
											<option value="">-- 선택 --</option>
											<option value="N">No</option>
											<option value="Y">Yes</option>
										</select></td>
								</tr>
								<tr>
									<td class="rborder">납부방법</td>
									<td class="Tleft" colspan="5">
										<select	name="paytype" style="height:27px;">
											<option value="">-- 선택 --</option>
											<option value="1">온라인(신용카드,계좌이체) 납부</option>
											<option value="2">지로납부</option>
										</select></td>

								</tr>
								<tr>
									<td class="rborder">검색어</td>
									<td class="Tleft" colspan="7">
										<select name="searchtype" style="height:27px;">
											<option value="">-- 선택 --</option>
											<option value="1">회원번호</option>
											<option value="2">이름</option>
											<option value="3">ID</option>
											<option value="4">직장명</option>
										</select>
										<input type="text" name="keyword" style="height:23px;width:200px;"> ex) * like 검색시 검색어 앞에 %를 입력해주세요.</td>
								</tr>
								<tr>
									<td class="rborder">회원번호</td>
									<td colspan="5" class="Tleft">
										<input type="text" name="usernostart" size="10" style="height:23px;width:100px;"> ~ <input type="text" name="usernoend" size="10" style="height:23px;width:100px;"> * 숫자만 입력해주세요.</td>
								</tr>
								<tr>
									<td class="rborder">기간</td>
									<td width="110" class="Tleft">
										<select name="sdatetype" style="width:100px;height:27px;">
											<option value="">-- 선택 --</option>
											<option value="1">입회날짜</option>
											<option value="2">생년월일</option>
										</select></td>
									<td class="Tleft" colspan="4">
										<select name="sdateys" style="height:27px;">
											<option value="">----</option>
											<option value="2020">2020</option>
											<option value="2019">2019</option>
											<option value="2018">2018</option>
											<option value="2017">2017</option>
											<option value="2016">2016</option>
											<option value="2015">2015</option>
											<option value="2014">2014</option>
											<option value="2013">2013</option>
											<option value="2012">2012</option>
											<option value="2011">2011</option>
											<option value="2010">2010</option>
											<option value="2009">2009</option>
											<option value="2008">2008</option>
											<option value="2007">2007</option>
											<option value="2006">2006</option>
											<option value="2005">2005</option>
											<option value="2004">2004</option>
											<option value="2003">2003</option>
											<option value="2002">2002</option>
											<option value="2001">2001</option>
											<option value="2000">2000</option>
											<option value="1999">1999</option>
											<option value="1998">1998</option>
											<option value="1997">1997</option>
											<option value="1996">1996</option>
											<option value="1995">1995</option>
											<option value="1994">1994</option>
											<option value="1993">1993</option>
											<option value="1992">1992</option>
											<option value="1991">1991</option>
											<option value="1990">1990</option>
											<option value="1989">1989</option>
											<option value="1988">1988</option>
											<option value="1987">1987</option>
											<option value="1986">1986</option>
											<option value="1985">1985</option>
											<option value="1984">1984</option>
											<option value="1983">1983</option>
											<option value="1982">1982</option>
											<option value="1981">1981</option>
											<option value="1980">1980</option>
											<option value="1979">1979</option>
											<option value="1978">1978</option>
											<option value="1977">1977</option>
											<option value="1976">1976</option>
											<option value="1975">1975</option>
											<option value="1974">1974</option>
											<option value="1973">1973</option>
											<option value="1972">1972</option>
											<option value="1971">1971</option>
											<option value="1970">1970</option>
											<option value="1969">1969</option>
											<option value="1968">1968</option>
											<option value="1967">1967</option>
											<option value="1966">1966</option>
											<option value="1965">1965</option>
											<option value="1964">1964</option>
											<option value="1963">1963</option>
											<option value="1962">1962</option>
											<option value="1961">1961</option>
											<option value="1960">1960</option>
											<option value="1959">1959</option>
											<option value="1958">1958</option>
											<option value="1957">1957</option>
											<option value="1956">1956</option>
											<option value="1955">1955</option>
											<option value="1954">1954</option>
											<option value="1953">1953</option>
											<option value="1952">1952</option>
											<option value="1951">1951</option>
											<option value="1950">1950</option>
											<option value="1949">1949</option>
											<option value="1948">1948</option>
											<option value="1947">1947</option>
											<option value="1946">1946</option>
											<option value="1945">1945</option>
											<option value="1944">1944</option>
											<option value="1943">1943</option>
											<option value="1942">1942</option>
											<option value="1941">1941</option>
											<option value="1940">1940</option>
											<option value="1939">1939</option>
											<option value="1938">1938</option>
											<option value="1937">1937</option>
											<option value="1936">1936</option>
											<option value="1935">1935</option>
											<option value="1934">1934</option>
											<option value="1933">1933</option>
											<option value="1932">1932</option>
											<option value="1931">1931</option>
											<option value="1930">1930</option>
											<option value="1929">1929</option>
											<option value="1928">1928</option>
											<option value="1927">1927</option>
											<option value="1926">1926</option>
											<option value="1925">1925</option>
											<option value="1924">1924</option>
											<option value="1923">1923</option>
											<option value="1922">1922</option>
											<option value="1921">1921</option>
											<option value="1920">1920</option>
											<option value="1919">1919</option>
											<option value="1918">1918</option>
											<option value="1917">1917</option>
											<option value="1916">1916</option>
											<option value="1915">1915</option>
											<option value="1914">1914</option>
											<option value="1913">1913</option>
											<option value="1912">1912</option>
											<option value="1911">1911</option>
											<option value="1910">1910</option>
											<option value="1909">1909</option>
											<option value="1908">1908</option>
											<option value="1907">1907</option>
											<option value="1906">1906</option>
											<option value="1905">1905</option>
											<option value="1904">1904</option>
											<option value="1903">1903</option>
											<option value="1902">1902</option>
											<option value="1901">1901</option>
										</select> 년 <select name="sdatems" style="height:27px;">
											<option value="">--</option>
											<option value="01">01</option>
											<option value="02">02</option>
											<option value="03">03</option>
											<option value="04">04</option>
											<option value="05">05</option>
											<option value="06">06</option>
											<option value="07">07</option>
											<option value="08">08</option>
											<option value="09">09</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
										</select> 월 <select name="sdateds" style="height:27px;">
											<option value="">--</option>
											<option value="01">01</option>
											<option value="02">02</option>
											<option value="03">03</option>
											<option value="04">04</option>
											<option value="05">05</option>
											<option value="06">06</option>
											<option value="07">07</option>
											<option value="08">08</option>
											<option value="09">09</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
											<option value="31">31</option>
										</select> 일 ~ <select name="sdateye" style="height:27px;">
											<option value="">----</option>
											<option value="2020">2020</option>
											<option value="2019">2019</option>
											<option value="2018">2018</option>
											<option value="2017">2017</option>
											<option value="2016">2016</option>
											<option value="2015">2015</option>
											<option value="2014">2014</option>
											<option value="2013">2013</option>
											<option value="2012">2012</option>
											<option value="2011">2011</option>
											<option value="2010">2010</option>
											<option value="2009">2009</option>
											<option value="2008">2008</option>
											<option value="2007">2007</option>
											<option value="2006">2006</option>
											<option value="2005">2005</option>
											<option value="2004">2004</option>
											<option value="2003">2003</option>
											<option value="2002">2002</option>
											<option value="2001">2001</option>
											<option value="2000">2000</option>
											<option value="1999">1999</option>
											<option value="1998">1998</option>
											<option value="1997">1997</option>
											<option value="1996">1996</option>
											<option value="1995">1995</option>
											<option value="1994">1994</option>
											<option value="1993">1993</option>
											<option value="1992">1992</option>
											<option value="1991">1991</option>
											<option value="1990">1990</option>
											<option value="1989">1989</option>
											<option value="1988">1988</option>
											<option value="1987">1987</option>
											<option value="1986">1986</option>
											<option value="1985">1985</option>
											<option value="1984">1984</option>
											<option value="1983">1983</option>
											<option value="1982">1982</option>
											<option value="1981">1981</option>
											<option value="1980">1980</option>
											<option value="1979">1979</option>
											<option value="1978">1978</option>
											<option value="1977">1977</option>
											<option value="1976">1976</option>
											<option value="1975">1975</option>
											<option value="1974">1974</option>
											<option value="1973">1973</option>
											<option value="1972">1972</option>
											<option value="1971">1971</option>
											<option value="1970">1970</option>
											<option value="1969">1969</option>
											<option value="1968">1968</option>
											<option value="1967">1967</option>
											<option value="1966">1966</option>
											<option value="1965">1965</option>
											<option value="1964">1964</option>
											<option value="1963">1963</option>
											<option value="1962">1962</option>
											<option value="1961">1961</option>
											<option value="1960">1960</option>
											<option value="1959">1959</option>
											<option value="1958">1958</option>
											<option value="1957">1957</option>
											<option value="1956">1956</option>
											<option value="1955">1955</option>
											<option value="1954">1954</option>
											<option value="1953">1953</option>
											<option value="1952">1952</option>
											<option value="1951">1951</option>
											<option value="1950">1950</option>
											<option value="1949">1949</option>
											<option value="1948">1948</option>
											<option value="1947">1947</option>
											<option value="1946">1946</option>
											<option value="1945">1945</option>
											<option value="1944">1944</option>
											<option value="1943">1943</option>
											<option value="1942">1942</option>
											<option value="1941">1941</option>
											<option value="1940">1940</option>
											<option value="1939">1939</option>
											<option value="1938">1938</option>
											<option value="1937">1937</option>
											<option value="1936">1936</option>
											<option value="1935">1935</option>
											<option value="1934">1934</option>
											<option value="1933">1933</option>
											<option value="1932">1932</option>
											<option value="1931">1931</option>
											<option value="1930">1930</option>
											<option value="1929">1929</option>
											<option value="1928">1928</option>
											<option value="1927">1927</option>
											<option value="1926">1926</option>
											<option value="1925">1925</option>
											<option value="1924">1924</option>
											<option value="1923">1923</option>
											<option value="1922">1922</option>
											<option value="1921">1921</option>
											<option value="1920">1920</option>
											<option value="1919">1919</option>
											<option value="1918">1918</option>
											<option value="1917">1917</option>
											<option value="1916">1916</option>
											<option value="1915">1915</option>
											<option value="1914">1914</option>
											<option value="1913">1913</option>
											<option value="1912">1912</option>
											<option value="1911">1911</option>
											<option value="1910">1910</option>
											<option value="1909">1909</option>
											<option value="1908">1908</option>
											<option value="1907">1907</option>
											<option value="1906">1906</option>
											<option value="1905">1905</option>
											<option value="1904">1904</option>
											<option value="1903">1903</option>
											<option value="1902">1902</option>
											<option value="1901">1901</option>
										</select> 년 <select name="sdateme" style="height:27px;">
											<option value="">--</option>
											<option value="01">01</option>
											<option value="02">02</option>
											<option value="03">03</option>
											<option value="04">04</option>
											<option value="05">05</option>
											<option value="06">06</option>
											<option value="07">07</option>
											<option value="08">08</option>
											<option value="09">09</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
										</select> 월 <select name="sdatede" style="height:27px;">
											<option value="">--</option>
											<option value="01">01</option>
											<option value="02">02</option>
											<option value="03">03</option>
											<option value="04">04</option>
											<option value="05">05</option>
											<option value="06">06</option>
											<option value="07">07</option>
											<option value="08">08</option>
											<option value="09">09</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
											<option value="31">31</option>
									</select> 일</td>
								</tr>
								<tr>
									<td class="rborder">회비</td>
									<td class="Tleft">
										<select name="duetype" style="width: 100px;height:27px;">
											<option value="">-- 선택 --</option>
											<option value="1">연회비</option>
											<option value="2">임원회비</option>
										</select>
									</td>
									<td class="Tleft" colspan="4">
									<select name="duestart" style="height:27px;">
											<option value="">----</option>
											<option value="2020">2020</option>
											<option value="2019">2019</option>
											<option value="2018">2018</option>
											<option value="2017">2017</option>
											<option value="2016">2016</option>
											<option value="2015">2015</option>
											<option value="2014">2014</option>
											<option value="2013">2013</option>
											<option value="2012">2012</option>
											<option value="2011">2011</option>
											<option value="2010">2010</option>
											<option value="2009">2009</option>
											<option value="2008">2008</option>
											<option value="2007">2007</option>
											<option value="2006">2006</option>
											<option value="2005">2005</option>
											<option value="2004">2004</option>
											<option value="2003">2003</option>
											<option value="2002">2002</option>
											<option value="2001">2001</option>
											<option value="2000">2000</option>
									</select> 년 ~
									<select name="dueend" style="height:27px;">
											<option value="">----</option>
											<option value="2020">2020</option>
											<option value="2019">2019</option>
											<option value="2018">2018</option>
											<option value="2017">2017</option>
											<option value="2016">2016</option>
											<option value="2015">2015</option>
											<option value="2014">2014</option>
											<option value="2013">2013</option>
											<option value="2012">2012</option>
											<option value="2011">2011</option>
											<option value="2010">2010</option>
											<option value="2009">2009</option>
											<option value="2008">2008</option>
											<option value="2007">2007</option>
											<option value="2006">2006</option>
											<option value="2005">2005</option>
											<option value="2004">2004</option>
											<option value="2003">2003</option>
											<option value="2002">2002</option>
											<option value="2001">2001</option>
											<option value="2000">2000</option>
									</select> 년
									<select name="duepaytype" style="height:27px;">
											<option value="">--- 선택 ---</option>
											<option value="1">납부</option>
											<option value="0">미납</option>
									</select></td>
								</tr>
								<tr>
									<th colspan="2" class="Tbornone Tleft">정렬조건</th>
									<td class="Tleft" colspan="5">
									<select	name="st_sec1" style="height:27px;">
											<option value="useridx">회원번호</option>
											<option value="username">이름</option>
											<option value="userid">ID</option>
											<option value="useraddrno">우편번호</option>
									</select>
									<select name="st_sec2" style="height:27px;">
											<option value="1">오름차순</option>
											<option value="2">내림차순</option>
									</select>
									<select name="st_sec3" style="height:27px;">
											<option value="">-----------</option>
											<option value="useridx">회원번호</option>
											<option value="username">이름</option>
											<option value="userid">ID</option>
											<option value="useraddrno">우편번호</option>
									</select>
									<select name="st_sec4" style="height:27px;">
											<option value="1">오름차순</option>
											<option value="2">내림차순</option>
									</select>
									<select name="st_sec5" style="height:27px;">
											<option value="">-----------</option>
											<option value="useridx">회원번호</option>
											<option value="username">이름</option>
											<option value="userid">ID</option>
											<option value="useraddrno">우편번호</option>
									</select>
									<select name="st_sec6" style="height:27px;">
											<option value="1">오름차순</option>
											<option value="2">내림차순</option>
									</select></td>
								</tr>
								<tr>
									<th colspan="2" class="Tbornone Tleft">필드선택</th>
									<td colspan="5">
										<table>
										<tr>
											<td class="tnone">
											<input type="hidden" name="sf_sec1">
											<div class="checkbox_column">
											<ul>
												<li><input type="checkbox" name="column" id="column_check01" value="01" checked="checked"/><label for="column_check01" class="in_label">ID</label></li>
												<li><input type="checkbox" name="column" id="column_check02" value="02" checked="checked"/><label for="column_check02" class="in_label">한글이름</label></li>
												<li><input type="checkbox" name="column" id="column_check03" value="03"/><label for="column_check03" class="in_label">영문이름</label></li>
												<li><input type="checkbox" name="column" id="column_check04" value="04"/><label for="column_check04" class="in_label">한문이름</label></li>
												<li><input type="checkbox" name="column" id="column_check05" value="05" checked="checked"/><label for="column_check05" class="in_label">생년월일</label></li>
												<li><input type="checkbox" name="column" id="column_check06" value="06" checked="checked"/><label for="column_check06" class="in_label">E-mail</label></li>
												<li><input type="checkbox" name="column" id="column_check07" value="07"/><label for="column_check07" class="in_label">우편물수령</label></li>
											</ul>
											<ul>
												<li><input type="checkbox" name="column" id="column_check08" value="08"/><label for="column_check08" class="in_label">핸드폰</label></li>
												<li><input type="checkbox" name="column" id="column_check10" value="10" checked="checked"/><label for="column_check10" class="in_label">지회</label></li>
												<li><input type="checkbox" name="column" id="column_check11" value="11" checked="checked"/><label for="column_check11" class="in_label">입회날짜</label></li>
												<li><input type="checkbox" name="column" id="column_check12" value="12"/><label for="column_check12" class="in_label">자택주소</label></li>
												<li><input type="checkbox" name="column" id="column_check13" value="13"/><label for="column_check13" class="in_label">자택우편번호</label></li>
												<li><input type="checkbox" name="column" id="column_check14" value="14"/><label for="column_check14" class="in_label">자택전화번호</label></li>
												<li><input type="checkbox" name="column" id="column_check15" value="15"/><label for="column_check15" class="in_label">직장명</label></li>
											</ul>
											<ul>
												<li><input type="checkbox" name="column" id="column_check16" value="16"/><label for="column_check16" class="in_label">부서</label></li>
												<li><input type="checkbox" name="column" id="column_check17" value="17"/><label for="column_check17" class="in_label">직책</label></li>
												<li><input type="checkbox" name="column" id="column_check18" value="18"/><label for="column_check18" class="in_label">회사주소</label></li>
												<li><input type="checkbox" name="column" id="column_check19" value="19"/><label for="column_check19" class="in_label">회사우편번호</label></li>
												<li><input type="checkbox" name="column" id="column_check20" value="20"/><label for="column_check20" class="in_label">회사전화번호</label></li>
												<li><input type="checkbox" name="column" id="column_check21" value="21"/><label for="column_check21" class="in_label">회사FAX</label></li>
												<li><input type="checkbox" name="column" id="column_check22" value="22"/><label for="column_check22" class="in_label">받을곳 우편번호</label></li>
											</ul>
											<ul>
												<li><input type="checkbox" name="column" id="column_check23" value="23"/><label for="column_check23" class="in_label">받을곳 주소</label></li>
												<li><input type="checkbox" name="column" id="column_check42" value="42"/><label for="column_check42" class="in_label">받을곳 상세주소</label></li>
												<li><input type="checkbox" name="column" id="column_check24" value="24" checked="checked"/><label for="column_check24" class="in_label">회원종류</label></li>
												<li><input type="checkbox" name="column" id="column_check25" value="25"/><label for="column_check25" class="in_label">임원</label></li>
												<li><input type="checkbox" name="column" id="column_check26" value="26"/><label for="column_check26" class="in_label">위원회</label></li>
												<li><input type="checkbox" name="column" id="column_check27" value="27"/><label for="column_check27" class="in_label">학사졸업년도</label></li>
												<li><input type="checkbox" name="column" id="column_check28" value="28"/><label for="column_check28" class="in_label">학사학교</label></li>
											</ul>
											<ul>
												<li><input type="checkbox" name="column" id="column_check29" value="29"/><label for="column_check29" class="in_label">학사학과</label></li>
												<li><input type="checkbox" name="column" id="column_check30" value="30"/><label for="column_check30" class="in_label">석사졸업년도</label></li>
												<li><input type="checkbox" name="column" id="column_check31" value="31"/><label for="column_check31" class="in_label">석사학교</label></li>
												<li><input type="checkbox" name="column" id="column_check32" value="32"/><label for="column_check32" class="in_label">석사학과</label></li>
												<li><input type="checkbox" name="column" id="column_check33" value="33"/><label for="column_check33" class="in_label">박사졸업년도</label></li>
												<li><input type="checkbox" name="column" id="column_check34" value="34"/><label for="column_check34" class="in_label">박사학교</label></li>
												<li><input type="checkbox" name="column" id="column_check35" value="35"/><label for="column_check35" class="in_label">박사학과</label></li>
											</ul>
											<ul>
												<li><input type="checkbox" name="column" id="column_check36" value="36"/><label for="column_check36" class="in_label">최종학력</label></li>
												<li><input type="checkbox" name="column" id="column_check37" value="37"/><label for="column_check37" class="in_label">직종</label></li>
												<li><input type="checkbox" name="column" id="column_check38" value="38"/><label for="column_check38" class="in_label">추천인</label></li>
												<li><input type="checkbox" name="column" id="column_check50" value="50"/><label for="column_check50" class="in_label">회비</label></li>
												<li><input type="checkbox" name="column" id="column_check39" value="39"/><label for="column_check39" class="in_label">납부방법</label></li>
												<li></li>
												<li></li>
											</ul>
											 </div>
											</td>
										</tr>
										</table>
									</td>
								</tr>
							</table>

										<div class="btn-c">
											<input type="submit" class="chost_btn_s" value="검 색">
										</div>
								</form>
				</li>
			</ul>
            </div>
            </div><!--/contents-->
    </div><!--/container-->
</div><!--/wrap-->
</body>
</html>
