<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<link rel="stylesheet" href="/usr/css/style.css" type="text/css" />
<link rel="stylesheet" href="/cms/css/bannerstyle.css" type="text/css" />
<link rel="stylesheet" href="/usr/css/base.css" type="text/css" />
<script type="text/javascript" src="/ajaxtags/js/prototype.js"></script>
<script type="text/javascript" src="/ajaxtags/js/scriptaculous/scriptaculous.js"></script>
<script type="text/javascript" src="/ajaxtags/js/overlibmws/overlibmws.js"></script>
<script type="text/javascript" src="/ajaxtags/js/ajaxtags.js"></script>
<script type="text/javascript">


function checkForm_u(){

	var st =st_date.value+ st_date2.value+st_date3.value;
	var end =end_date.value+ end_date2.value+end_date3.value;


	if(typeof(m_width)!= "undefined" && m_width.value.trim() == "" && document.getElementById('open_win' + 3).checked==true){
		alert("width를 입력하세요");
		m_width.focus();
		return false;
	}
	if(typeof(m_height)!= "undefined" && m_height.value.trim() == ""  && document.getElementById('open_win' + 3).checked==true){
		alert("height를 입력하세요");
		m_height.focus();
		return false;
	}

	if( st.length<12){
		alert("게시시작일자를 입력하세요");
		st_date.focus();
		return false;
	}
 	if(  end.length<12){
		alert("게시종료일자를 입력하세요");
		end_date.focus();
		return false;
	}
	if(typeof(title)!="undefined" && title.value.trim() == ""){
		alert("제목을 입력하세요");
		title.focus();
		return false;
	}
	if(typeof(ranking)!= "undefined" && ranking.value.trim() == ""){
		alert("순위를 입력하세요");
		ranking.focus();
		return false;
	}
	if(typeof(img_url)!= "undefined" && img_url.value.trim() == ""){
		alert("링크를 입력하세요");
		img_url.focus();
		return false;
	}
	if((read1.checked==true || read2.checked==true || read3.checked==true ) && typeof(link_url)!= "undefined" && link_url.value.trim() == ""){
		alert("url를 입력하세요");
		link_url.focus();
		return false;
	}
	if((read1.checked==true || read2.checked==true || read3.checked==true ) && typeof(img_alt)!= "undefined" && img_alt.value.trim() == ""){
		alert("alt를 입력하세요");
		img_alt.focus();
		return false;
	}
	if((read1.checked==true || read2.checked==true || read3.checked==true ) &&  typeof(img_title)!= "undefined" && img_title.value.trim() == ""){
		alert("title를 입력하세요");
		img_title.focus();
		return false;
	}
	if(read4.checked==true && typeof(bbsno)!= "undefined" && bbsno.value.trim() == ""){
		alert("게시판번호를 입력하세요");
		bbsno.focus();
		return false;
	}
	if(read4.checked==true &&  typeof(ztag)!= "undefined" && ztag.value.trim() == ""){
		alert("태그를 입력하세요");
		ztag.focus();
		return false;
	}
	if(read4.checked==true && typeof(siteno)!= "undefined" && siteno.value.trim() == ""){
		alert("사이트번호를 입력하세요");
		siteno.focus();
		return false;
	}
	if(read4.checked==true && typeof(re_menu)!= "undefined" && siteno.value.trim() == ""){
		alert("매뉴번호를 입력하세요");
		re_menu.focus();
		return false;
	}

	st_date.value=st;
	end_date.value=end;


}

var msgtit=['(상세 페이지 이동)','(새 창 열림)','(Link to the Page)','(Open in new Window)'];

//배너지정활성화
  function enableinput(inp ,f){


	document.getElementById('open_win' + inp).checked=true;

	enablobj('bbsno',f);
	enablobj('ztag',f);
	enablobj('siteno',f);
	enablobj('re_menu',f);
	enablobj('link_url',!f);

	if(inp=='3')f=false;
	else f=true;
	enablobj('m_width',f);
	enablobj('m_height',f);
	var im=0;
	if(${type}>=200 && ${type}<299)im+=2;
	var m='';
	if(inp==1 ){

		m=msgtit[im+0];
	}else if(inp==2 ||inp==3 ) m=msgtit[im+1];
	document.getElementById("aaa").innerHTML=m;

}

function enablobj(en,f){
     document.getElementById(en).disabled = f;


}

</script>
</head>
<body>

<div id="container">
	<jsp:include page="../../lnb.jsp" flush="true" />
	<div id="r_side">
		<div class="cont_top">
			<div class="location">
				<p>
					<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
					&gt;
					<a href="/admsys/site/site/" title="홈페이지관리로 이동">홈페이지관리</a>
					&gt;
					<!-- <a href="/admsys/site/main/" title="메인페이지로 이동">메인페이지관리</a>
					&gt; -->
					<span>메인페이지 등록</span>
				</p>
			</div><!--/location-->
		</div><!--/cont_top-->
		<div class="page_title"><h3><img src="/usr/image/title/ctit_banner.gif" alt="메인 배너관리" /></h3></div>
		<div id="content">
			<form:form attributeModel="zmainbannerVO" enctype="multipart/form-data" name="frm" method="post" onsubmit="return checkForm_u()">
			<div class="main_table">
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="분류선택, 배너추가, 노출배너">
					<caption>메인 배너관리</caption>
					<colgroup>
						<col width="10%" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">분류선택</th>
							<td>
				<!-- 배너관리 -->
							<c:if test="${type <200}">
							    <input class="radio0" type="radio" checked="" value="100" name="type" <c:if test="${type =='100'}">checked</c:if> /> 재단행사안내
								<input class="radio1" type="radio" value="101" name="type" <c:if test="${type =='101'}">checked</c:if> /> 재단주요활동
						     </c:if>
						   	 <c:if test="${type >=200 && type <=299}">
							    <input class="radio0" type="radio" checked="" value="200" name="type" <c:if test="${type =='200'}">checked</c:if> />  Curret Programs
								<input class="radio1" type="radio" value="201" name="type" <c:if test="${type =='201'}">checked</c:if> />   KF Activities
						     </c:if>
				<!-- 5개국어 메인 배너관리 -->
						     <c:if test="${type == 403}">
							    <input class="radio0" type="radio" checked="" value="403" name="type" <c:if test="${type =='403'}">checked</c:if> /> 중국
						     </c:if>
						     <c:if test="${type == 404}">
							    <input class="radio0" type="radio" checked="" value="404" name="type" <c:if test="${type =='404'}">checked</c:if> /> 일본
						     </c:if>
						     <c:if test="${type ==405}">
							    <input class="radio0" type="radio" checked="" value="405" name="type" <c:if test="${type =='405'}">checked</c:if> /> 러시아
							 </c:if>
							 <c:if test="${type ==406}">
							    <input class="radio0" type="radio" checked="" value="406" name="type" <c:if test="${type =='406'}">checked</c:if> /> 독일
							 </c:if>
						     <c:if test="${type ==407}">
							    <input class="radio0" type="radio" checked="" value="407" name="type" <c:if test="${type =='407'}">checked</c:if> /> 베트남
						     </c:if>
				<!-- 5개국어 재단활동 배너관리 -->
							<c:if test="${type == 303}">
							    <input class="radio0" type="radio" checked="" value="303" name="type" <c:if test="${type =='303'}">checked</c:if> /> 중국
							</c:if>
							<c:if test="${type == 304}">
							    <input class="radio0" type="radio" checked="" value="304" name="type" <c:if test="${type =='304'}">checked</c:if> /> 일본
							</c:if>
							<c:if test="${type ==305}">
							    <input class="radio0" type="radio" checked="" value="305" name="type" <c:if test="${type =='305'}">checked</c:if> /> 러시아
							</c:if>
							<c:if test="${type ==306}">
							    <input class="radio0" type="radio" checked="" value="306" name="type" <c:if test="${type =='306'}">checked</c:if> /> 독일
							</c:if>
							<c:if test="${type ==307}">
							    <input class="radio0" type="radio" checked="" value="307" name="type" <c:if test="${type =='307'}">checked</c:if> /> 베트남
							</c:if>
						   </td>
						</tr>
						<tr>
							<th scope="row">옵션선택</th>
							<td>
								<input class="radio2" id="read1" type="radio"  value="0" name="read" checked="" onclick="enableinput(1,true)"/> 현재창
								<input class="radio2" id="read2" type="radio" value="0" name="read" onclick="enableinput(2,true)"> 새 창 열림
								<input class="radio2" id="read3" type="radio" value="0" name="read" onclick="enableinput(3,true)"> 팝업
								<span >
									<strong>Width : </strong><input id="m_width" name="m_width" type="text" size="5" autocomplete="off">
									<strong>Height : </strong><input id="m_height" name="m_height" type="text" size="5" autocomplete="off">
								</span>
								<input class="radio3" type="radio" value="1" name="read" id="read4" onclick="enableinput(1,false)"/> 게시판


								<input style="display:none" id="open_win1" type="radio"  value="1" name="open_win" checked=true  />
								<input style="display:none" id="open_win2" type="radio" value="2" name="open_win" >
								<input style="display:none" id="open_win3" type="radio" value="3" name="open_win"  >
							</td>
						</tr>
						<tr>
							<th scope="row">게시기간</th>
							<td>
								<input class="radio3" type="input" size="8"  maxlength="8" name="st_date" id="st_date"  autocomplete="off"/>년월일
								<input class="radio3" type="input" size="2"  maxlength="2" id="st_date2" value="00"autocomplete="off"/>시간
								<input class="radio3" type="input" size="2"  maxlength="2" id="st_date3"  value="00"autocomplete="off"/>분 ~
								<input class="radio3" type="input" size="8"  maxlength="8" name="end_date" id="end_date"  autocomplete="off"/>년월일
								<input class="radio3" type="input" size="2"  maxlength="2" id="end_date2"  value="23"autocomplete="off"/>시간
								<input class="radio3" type="input" size="2"  maxlength="2" id="end_date3"  value="59"autocomplete="off"/>분
								<span style="color: red;">※ 기간 표기 방법은 "2013년 12월 5일"인 경우 20131205로 표기합니다.</span>
							</td>
						</tr>



						<tr>
							<th scope="row">노출배너</th>
							<td>
								<!-- <input class="radio0" type="radio" checked="" value="0" name="lang"> 455px X 233px
								<input class="radio1" type="radio" value="1" name="lang"> 678px X 233px
								<em class="type">※ 678px x 233px 체크의 경우 내용이 없이 이미지만 등록하는 경우에 해당됩니다.</em> -->
								<div class="img-text">
									<img name="preview" id="preview"
									alt='Korea Foundation Global Seminar' />
							<c:if test="${type >= 0 && type <= 400 }">
									<ul>
										<li>
											<label for="title">제목</label>
											<input id="title" class="bor1ddd" type="text" title="제목 입력" value="" size="75" name="title" autocomplete="off" />
											<p>※ 30자 이내로 작성합니다. 내용이 많은 경우 자동 줄임처리됩니다.</p>
										</li>
										<li>
											<label for="conts">내용</label>
											<textarea id="conts" name="conts" rows="5" cols="71" onkeyup="checkLength(this)" autocomplete="off" maxlength="100"></textarea>
											<p>※ 100자 이내로 작성합니다. 내용이 많은 경우 자동 줄임처리됩니다.</p>
										</li>
									</ul>
							</c:if>
								</div>
								<span class="type">
									<input type="file" name="file" id="file"  value="미리보기 "  >
									<a href="#" class="close"><img src="/cms/image/btn_delete05.gif" onclick="removeImg()" alt="닫기" /></a>
									<c:if test="${type < 300 }">
									<span style="color: red;">※ 이미지 사이즈는 455px X 233px 입니다.</span>
									</c:if>
									<c:if test="${type >= 300 && type <=307}">
									<span style="color: red;">※ 이미지 사이즈는 114px X 87px 입니다.</span>
									</c:if>
									<c:if test="${type >= 400 && type <=407}">
									<span style="color: red;">※ 이미지 사이즈는 548px X 243px 입니다.</span>
									</c:if>
								</span>
								<ul class="ranking">
									<c:if test="${type < 300 }">
									<li>
										<label for="ranking">순번</label>
										<select id="ranking" name="ranking">
										</select>
									</li>
									</c:if>
									<li>
										<label for="link_url">링크</label>
										<input id="link_url" class="bor1ddd" type="text" title="제목 입력" value="" size="75" name="link_url" autocomplete="off" />
									</li>
									<li>
										<label for="img_alt">alt</label>
										<input id="img_alt" class="bor1ddd" type="text" title="대체텍스트 입력" value="" size="150" name="img_alt" autocomplete="off" />
									</li>
									<li>
										<label></label>
										<span style="color: red;">※웹접근성 대응을 위해 이미지에 적힌 모든 내용을 넣어주세요.</span>
									</li>
									<li>
										<label for="img_title">title</label>
										<input id="img_title" class="bor1ddd" type="text" title="대체텍스트 입력" value="" size="150" name="img_title" autocomplete="off" />
										<span id="aaa" style="color: red;"></span>
									</li>
									<li>
										<label></label>
										<span style="color: red;">※웹접근성 대응을 위해 현재 창인 경우(상세 페이지 이동)이라는 문구가 자동으로 붙습니다.</span>
									</li>
								</ul>
							</td>
						</tr>
						<tr>
							<th scope="row" >게시판링크</th>
							<td>
								<ul class="ranking" id="">
									<li>
										<label for="re_menu">메뉴번호</label>
										<input id="re_menu" type="text" class="bor1ddd" name="re_menu" title=메뉴번호 value="" size="75"  autocomplete="off" />
									</li>
									<li>
										<label for="bbsno">게시물번호</label>
										<input id="bbsno" type="text" class="bor1ddd" name="bbsno" title="게시물번호" value="" size="75" autocomplete="off"/><br/>
									</li>
									<li>
										<label for="ztag">Z-태그</label>
										<input id="ztag"  type="text" class="bor1ddd" name="ztag" title="Z-태그" value="" size="75" autocomplete="off"/><br/>
									</li>
									<li>
										<label for="siteno">사이트번호</label>
										<input id="siteno" type="text" class="bor1ddd" name="siteno" title="사이트번호" value="" size="75" autocomplete="off"/>
									</li>
								</ul>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="confirm">
				<p>
					<!-- <a href="javascript:void(0);" onclick="submit();"><img src="/cms/image/btn_confirm.jpg" alt="등록" /></a> -->
					<input type="image" src="/cms/image/btn_confirm.jpg" alt="등록"/>
					<a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/zmainbanner/index.html?type=${type}'">
						<img src="/cms/image/btn_cancel.jpg" alt="취소" />
					</a>
				</p>
			</div><!--/confirm-->
			</form:form>
		</div>
		</div><!--/r_side-->
	</div><!--/container-->
<c:import url="../../footer.jsp" />
<script type="text/javascript">

enableinput(1,true);
var sorg=document.getElementById('preview').src;

//imgInp 파일 객체 아이디
//blah 이미지 객체 아이디

//파일 삭제시
function removeImg(){
	        document.getElementById('file').outerHTML = document.getElementById('file').outerHTML;
	        document.getElementById('preview').src=sorg;
	    	document.getElementById('file').onchange=function(){
                readURL(this);
           };

}


function readURL(input) {
    if (input.fileList && input.fileList[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {

       	 document.getElementById('preview').src= e.target.result ;
        }
        reader.readAsDataURL(input.fileList[0]);
    }
}


document.getElementById('file').onchange=function(){
    readURL(this);
};


function rankSet(cnt){
	var opt =document.createElement('option');
	opt.value='';
	opt.text='순위';
	document.getElementById('ranking').appendChild(opt);
	for(var i=1;i<=cnt;i++){
		opt =document.createElement('option');
		opt.value=i;
		opt.text=i;
		document.getElementById('ranking').appendChild(opt);
	}
	if(cnt==1)rankSelect(1);
}

rankSet(${total}+1);

function rankSelect(idx){
	 document.getElementById('ranking').selectIndex=idx;
}


function checkLength(){
	var frm=document.getElementById('conts');
	if(frm.value.length>200){
		alert("글자수 100자로 제한됩니다.");
		frm.value= frm.value.substring(0,200);
		frm.focus();
	}

	}





</script>
</body>

