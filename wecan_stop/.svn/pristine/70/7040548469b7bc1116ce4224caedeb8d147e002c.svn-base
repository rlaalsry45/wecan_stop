<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>

<html>
	<head>
		<title></title>
	</head>
	<body>
		<div id="content">
			<ul class="homepagebbs">
				<li class="bg"><h3 class="sub">언론모니터링 상세 팝업</h3>
				<li>
					<div class="main_table">
						
						<input type="hidden" id="NO" name="NO" value="${data.NO}" />
						<input type="hidden" id="pmode" name="pmode" value="${mode}" />
						
						<!--언론모니터링 등록 영역-->
						<table class="main_table1" summary="언론모니터링 등록 항목을 보여줍니다.">
							<tr>
								<td>기사명</td>
								<td style="text-align: left;"><input type="text" id="article_title" name="article_title" value="${data.article_title}" /></td>
							</tr>
							<tr>
								<td>연관 상담 번호</td>
								<td style="text-align: left;">
									<ul id="consultingUL" style="column-count: 3;">
									<c:forEach items="${conList}" var="a" varStatus="ai">
										<li data-no="${a.con_ac_no}" id="culli_${a.con_ac_no}">${a.consulting_action_no}<a id="dd_${a.con_ac_no}" class="btmore01" href="#" onclick="javascript:delConsultingList('${a.con_ac_no}');return false;">X</a></li>
									</c:forEach>
									</ul>
									<a id="searchConsultingSrchListPop" class="btmore01" href="javascript:return void(0);">상담 등록</a>
								</td>
							</tr>
							<tr>
								<td>연관 조치 번호</td>
								<td style="text-align: left;">
									<ul id="actionUL" style="column-count: 3;">
									<c:forEach items="${acList}" var="a" varStatus="ai">
										<li data-no="${a.con_ac_no}" id="aulli_${a.con_ac_no}">${a.consulting_action_no}<a id="aa_${a.con_ac_no}" class="btmore01" href="#" onclick="javascript:delActionList('${a.con_ac_no}');return false;">X</a></li>
									</c:forEach>
									</ul>
									<a id="searchActionSrchListPop" class="btmore01" href="javascript:return void(0);">조치 등록</a>
								</td>
							</tr>
							<tr>
								<td>URL</td>
								<td style="text-align: left;">${data.rel_event_url}
										<a class="btmore01" href="${data.rel_event_url}" target="_blank">보기</a>
								</td>
							</tr>
							<tr>
								<td>첨부파일</td>
								<td style="text-align: left;">
									<a id="pressUploadBtn" class="btmore05" onclick="return attach();">+ 파일 등록</a>
									<input id="upload" type="file" name="file" 
											data-url="/admsys/commonFile/attach.html" 
											data-form-data='{menu_cate: "press",menu_no:"${data.NO}"}'
											multiple style="opacity: 0; filter:alpha(opacity: 0);"><br/>
									<ul id="fileListUL" style="column-count: 2;">
									<c:forEach items="${fileList}" var="f" varStatus="fi">
										<li data-no="${f.NO}" data-type="old" id="ulliFile_${f.NO}">${f.file_name}
											<a id="bb_${f.NO}" class="btmore01" href="#" onclick="javascript:pickup('${f.NO}');return false;">받기</a>
											<a id="cc_${f.NO}" class="btmore01" href="#" onclick="javascript:detach('${f.NO}','${f.file_name}');return false;">삭제</a>
										</li>
									</c:forEach>
									</ul>
								</td>
							</tr>
						</table>
						<!--/상담일지 등록 영역-->
					</div>
					<!--/main_table-->
					<div class="btn-c">
	        			<a class="btmore09" href="javascript:self.close();">닫기</a>
	    			</div>
				</li>
			</ul>
		</div>
	</body>
</html>
<script>
	var edit_save_flag="edit";
	
	var mode = '${mode}';
	
	$(function(){
		elementsDisabled(false);
		
	});

	function elementsDisabled(disabled) {
		if ( disabled == false ) {
			$('.homepagebbs input').attr('disabled', 'disabled');
			$('.homepagebbs select').attr('disabled', 'disabled');
			$('.homepagebbs textarea').attr('disabled', 'disabled');
			$('#searchConsultingSrchListPop').hide();
			$('#searchActionSrchListPop').hide();
			$("a[id^=aa_]").hide();
			$("a[id^=cc_]").hide();
			$("a[id^=dd_]").hide();
			$("#pressUploadBtn").hide();
		} else if ( disabled == true ) {
			$('.homepagebbs input').removeAttr('disabled');
			$('.homepagebbs select').removeAttr('disabled');
			$('.homepagebbs textarea').removeAttr('disabled');
			$('#searchConsultingSrchListPop').show();
			$('#searchActionSrchListPop').show();
			$("a[id^=aa_]").show();
			$("a[id^=cc_]").show();
			$("a[id^=dd_]").show();
			$("#pressUploadBtn").show();
		}
		

		// 예외 항목
		//$("#userId").attr("disabled", false);
	}
    
    function pickup(no) {
        document.location = "/admsys/commonFile/download.html?no=" + encodeURIComponent(no);
        return false;
    }
</script>