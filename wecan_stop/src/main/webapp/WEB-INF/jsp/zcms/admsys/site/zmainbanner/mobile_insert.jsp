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

	//2013-11-16 오명호
	if(typeof(title)!="undefined" && title.value.trim() == ""){
		alert("제목을 입력하세요");
		title.focus();
		return false;
	}
	if(   st.length<12){
		alert("게시시작일자를 입력하세요");
		st_date.focus();
		return false;
	}
	if(  end.length<12){
		alert("게시종료일자를 입력하세요");
		end_date.focus();
		return false;
	}
	if(typeof(ranking)!= "undefined" && ranking.value.trim() == ""){
		alert("순위를 입력하세요");
		ranking.focus();
		return false;
	}
	if(typeof(link_url)!= "undefined" && link_url.value.trim() == ""){
		alert("링크를 입력하세요");
		link_url.focus();
		return false;
	}
	if(typeof(day)!= "undefined" && day.value.trim() == ""){
		alert("날짜를 입력하세요");
		day.focus();
		return false;
	}


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
			<input type="hidden"   name="type" value="${type}"  />
			<div class="main_table">
				<table class="input_table" border="1" cellspacing="0" cellpadding="2" width="100%" summary="분류선택, 배너추가, 노출배너">
					<caption>메인 배너관리</caption>
					<colgroup>
						<col width="10%" />
						<col />
					</colgroup>
					<tbody>
					   <tr>
							<th scope="row">게시기간</th>
							<td>
								<input class="radio3" type="input" size="8"  maxlength="8" name="st_date" id="st_date"  autocomplete="off"/>년월일
								<input class="radio3" type="input" size="2"  maxlength="2" id="st_date2" value="00" autocomplete="off"/>시간
								<input class="radio3" type="input" size="2"  maxlength="2" id="st_date3"  value="00" autocomplete="off"/>분 ~
								<input class="radio3" type="input" size="8"  maxlength="8" name="end_date" id="end_date"  autocomplete="off"/>년월일
								<input class="radio3" type="input" size="2"  maxlength="2" id="end_date2"  value="00" autocomplete="off"/>시간
								<input class="radio3" type="input" size="2"  maxlength="2" id="end_date3"  value="00" autocomplete="off"/>분
							</td>
						</tr>
						<tr>
							<th scope="row">노출배너</th>
							<td>
								<div class="img-text">
									<img name="preview" id="preview"
									alt='Korea Foundation Global Seminar' />
									<ul>
										<li>
											<label for="title">제목</label>
											<input id="title" class="bor1ddd" type="text" title="제목 입력" value="" size="74" name="title" autocomplete="off"/>
											<p>※ 30자 이내로 작성합니다. 내용이 많은 경우 자동 줄임처리됩니다.</p>
										</li>
										<li>
											<label for="conts">내용</label>
											<textarea id="conts" name="conts" rows="5" cols="71" autocomplete="off"></textarea>
											<p>※ 30자 이내로 작성합니다. 내용이 많은 경우 자동 줄임처리됩니다.</p>
										</li>
									   <li style="padding-top:10px;padding-bottom:10px;">
											<label for="ranking">순위</label>
											<select id="ranking" name="ranking"></select>
										</li>
										<li style="padding-top:10px;padding-bottom:10px;">
											<label for="link_url">링크</label>
											<input id="link_url" class="bor1ddd" type="text" title="제목 입력" value="" size="74" name="link_url"  autocomplete="off"/>
										</li>
										<li>
											<label for="day">날짜</label>
											<input id="day" name="day" size="74" type="text" value="" title="날짜" autocomplete="off"/>
											<p>※ '-'입력해야합니다. </p>
										</li>

									</ul>
								</div>
								<span class="type">
									<input type="file" name="file" id="file"  value="미리보기 "  >
									<a href="#" class="close">
									<img src="/cms/image/btn_delete05.gif" onclick="removeImg()" alt="닫기" /></a>
								</span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="confirm">
				<p>
					<!-- <a href="javascript:void(0);" onclick="submit();"><img src="/cms/image/btn_confirm.jpg" alt="등록" /></a> -->
					<input type="image" src="/cms/image/btn_confirm.jpg" alt="등록"/>
					<a href="javascript:void(0);" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/zmainbanner/index.html'">
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

</script>
</body>

