<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
<script type="text/javascript">
$(function(){
    $('.main_table1 tbody img').bind("click",function(){
        var attr = $(this).attr("id");
        if (typeof attr !== 'undefined' && attr !== false){
            if ($(this).attr("src").indexOf("closed")!=-1){
                $(this).attr("src","/cms/image/btn_opened.jpg");
                $(this).attr("alt","열림");
                $(this).closest("tr").siblings("#"+$(this).attr("id")).show();
            }
            else{
                $(this).attr("src","/cms/image/btn_closed.jpg");
                $(this).attr("alt","닫힘");
                if ($(this).attr("id").match(/^\d+/)=="1"){
                    var id = $(this).attr("id").match(/\d+$/);
                    $(this).closest("tr").siblings("tr[id$='_"+id+"']").hide();
                    $(this).closest("tr").siblings("tr[id$='_"+id+"']").find("img[id$='"+id+"']").attr("src","/cms/image/btn_closed.jpg");
                }
                else{
                    $(this).closest("tr").siblings("#"+$(this).attr("id")).hide();
                }
            }
        }
    });
    $('.main_table1 thead img').bind("click",function(){
        if ($(this).attr("src").indexOf("open")!=-1){
            $(".main_table1 tbody img[id]").attr("src","/cms/image/btn_opened.jpg");
            $('.main_table1 tbody tr').show();
        }
        else{
            $(".main_table1 tbody img[id]").attr("src","/cms/image/btn_closed.jpg");
            $(".main_table1 tbody tr:not([id^='0'])").hide();
        }
    });
    $(":checkbox[name=urlno]").bind("click",function(){
        var item = $(this);
        var flag = item.prop("checked");
        if ($(":checkbox[name=opt]").prop("checked")){
            item.closest("tr").find("img").attr("src", flag ? "/cms/image/btn_opened.jpg" : "/cms/image/btn_closed.jpg");
            var obj = item.closest("tr").siblings("#"+item.val());
            function selAll(obj){
                obj.find("img").attr("src", flag ? "/cms/image/btn_opened.jpg" : "/cms/image/btn_closed.jpg");
                obj.each(function(){
                    if (flag) $(this).show().find(":checkbox").prop("checked", true);
                    else $(this).hide().find(":checkbox").prop("checked", false);
                    if ($(this).find(":checkbox").closest("tr").siblings("#"+$(this).find(":checkbox").val()).length > 0 ){
                        selAll($(this).find(":checkbox").closest("tr").siblings("#"+$(this).find(":checkbox").val()));
                    }
                });
            }
            selAll(obj);
        }
    });
    var urlnos = $.url().param('urlnos');
    var opens = $.url().param('opens');
    if (urlnos){
        $.each(urlnos.split(","), function(index, v) {
            $(":checkbox[name=urlno][value="+v+"]").prop("checked", true);
        });
    }
    if (opens){
        $.each(opens.split(","), function(index, v) {
            $('#' + v).trigger('click');
        });
    }
    $(":button").click(function(){
        if ($(this).parent().get(0).tagName=="DIV"){
            <c:if test="${empty list}">
                alert("콘텐츠 등록 후 해당 그룹/운영자를 선택 해주세요.");
                return;
            </c:if>
            <c:if test="${not empty list}">
                if ($(":checkbox[name=urlno]:checked").length==0){
                    alert("관리권한울 부여 할 콘텐츠를 선택 해주세요.");
                    return;
                }

                var urlnos = $(":checkbox[name=urlno]:checked").map(function(){return $(this).val();}).get();
                var opens = $("[src$='btn_opened.jpg']").map(function(){return $(this).attr('id');}).get();
                if ($(this).index()==2){
                    window.open("../auth/searchGroup.html?urlnos="+urlnos+"&opens="+opens, "popupFindGroup", "directories=no,toolbar=no,width=950,height=700");
                }else if ($(this).index()==3){
                    window.open("searchEmp.html?urlnos="+urlnos+"&opens="+opens, "popupFindEmp", "directories=no,toolbar=no,width=950,height=700");
                }
            </c:if>
        }
    });
    
    
    $("[id^=allowChkBox_][type=checkbox]").bind("click",function(){
        var item = $(this);
        //var flag = item.prop("checked");
        var param;
        var vNO = item.val();
        var confirmText = "등록";
        
        if ( item.is(":checked") == true ) {
            param={NO:vNO, ALLOW_YN:'Y'};
        } else if ( item.is(":checked") == false ) {
            param={NO:vNO, ALLOW_YN:'N'};
            confirmText = "해제";
        }
        
		if(confirm(confirmText+" 하시겠습니까?")){
			$.ajax({
				type: 'POST',
				url: "/admsys/setting/admin/updatePermissionAllowYN.html",
				data: param,
				success: function(result){
					if ( result.retStatus == "SUCCESS" ) {
							alert(confirmText+" 하였습니다.");
							return false;
						} else {
							alert(confirmText+"에 실패 하였습니다.");
						}
					},
					error:function(){
						alert(confirmText+"중 오류가 발생하였습니다.");  
					}
			})
		} else {
			if ( item.is(":checked") == true ) {
				item.prop("checked", false);
			} else {
				item.prop("checked", true);
			}
		}
    });
});
function delAuth(flag,urlno,no,gno,eno){
    var urlnos = $(":checkbox[name=urlno]:checked").map(function(){return $(this).val();}).get();
    var opens = $("[src$='btn_opened.jpg']").map(function(){return $(this).attr('id');}).get();
    if ($(":checkbox[name=opt]").prop("checked")){
        if (confirm("선택하신 그룹/운영자의 해당 콘텐츠(하위 메뉴 포함)에 대한 관리권한을 삭제 하시겠습니까?")){
            no = flag=='G' ? gno : eno;
            document.frm.action = "authDelete.html?flag="+flag+"&urlno="+urlno+"&no="+no+"&urlnos="+urlnos+"&opens="+opens;
            document.frm.submit();
        }
    }
    else {
        if (confirm("선택하신 그룹/운영자의 해당 콘텐츠에 대한 관리권한을 삭제 하시겠습니까?")){
            document.frm.action = "authDelete.html?no="+no+"&urlnos="+urlnos+"&opens="+opens;
            document.frm.submit();
        }
    }
}
</script>
            <div id="contents">
				<div class="contents_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/user/common/">환경설정</a> <strong>관리자메뉴권한관리</strong>
                    </div>
                </div>

                <form:form name="frm" method="post">
                <div id="content">
					<ul class="homepagebbs">
						<li class="bg"><h3 class="setting">관리자메뉴권한관리</h3>
							<div class="user_btn">
							<input class="bor_none" name="opt" id="opt" type="checkbox" style="vertical-align:middle;" />
							<label class="on" for="opt">하위메뉴포함</label>
							<input class="chost_btn_s4" type="button" value="그룹설정" />
							<!-- <input class="chost_btn_s4" type="button" value="운영자설정" /></div> -->
								</li>
						<li>
						<div class="top_bt">
                                <a class="btmore07" href="javascript:checkAll(true,'urlno');">전체선택</a>
                                <a class="btmore07" href="javascript:checkAll(false,'urlno');">전체해제</a>
                                <a class="btmore05" href="javascript:del('urlno');">삭제</a>
                            </div>
                    <div class="main_table">
                        <!---게시판 영역------------------------->
                        <table class="main_table1"  summary="메뉴전체보기">
                            <caption>메뉴전체보기</caption>
                            <colgroup>
                                <col width="5%" />
                                <col width="5%" />
                                <col width="" />
                                <col width="65%" />
                            </colgroup>
                            <thead>
                                <tr>
                                    <th>
                                        <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','urlno')" />
                                    </th>
                                    <th>번호</th>
                                    <th><span style="float:left"><img src="/cms/image/btn_lnb_open.gif" alt="전체열림"> <img src="/cms/image/btn_lnb_close.gif" alt="전체닫힘"></span>제목</th>
                                    <th style="padding:0px">
                                        <div id="css_table">
                                            <div class="css_td_r">운영담당자/그룹</div>
                                            <div class="css_td_r">권한기능목록</div>
                                            <!-- <div class="css_td_r">기관</div>
                                            <div class="css_td_r">부서/팀</div>
                                            <div class="css_td_r">전화번호</div> -->
                                            <div class="css_td">관리</div>
                                        </div>
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="each">
                                    <tr style="display:<c:if test='${each.urllevel!="0"}'>none</c:if>" id="${each.urllevel}_${each.urlparentno}_${each.urltopno}">
                                        <td>
                                            <input class="bor_none" name="urlno" value="${each.urllevel+1}_${each.urlno}_${each.urltopno}" type="checkbox"/>
                                        </td>
                                        <td>${each.urlno}</td>
                                        <td class='menu_d${each.urllevel}'>
                                            <c:if test='${each.cnt!="1"}'><img src="/cms/image/btn_closed.jpg" id="${each.urllevel+1}_${each.urlno}_${each.urltopno}" /></c:if>
                                            ${each.urltitle}<c:if test='${each.cnt!="1"}'>(${each.cnt-1})</c:if>
                                        </td>
                                        <td style="padding:0px">
                                            <div id="css_table">
                                            <c:forEach items="${each.authemp}" var="emp" varStatus="loop">
                                                <div class="css_tr">
                                                    <div class="css_td_r<c:if test="${not loop.last}" >b</c:if>">${emp.emp_nm}${emp.groupnm}</div>
													<c:choose>
														<c:when test="${fn:length(each.fpList) > 0 }">
															<c:forEach items="${each.fpList}" var="fp" varStatus="fpLoop">
																	<c:if test="${(emp.groupno eq fp.GROUPNO) and (each.urlno eq fp.URLNO)}">
																		<div class="css_td_r<c:if test="${not loop.last}" >b</c:if>">
																			<input type="checkbox" id="allowChkBox_${each.urlno}_${emp.groupno}_${fp.FUNCTIONNO}" 
																					name="allowChkBox_${each.urlno}_${emp.groupno}_${fp.FUNCTIONNO}" 
																					value="${fp.NO}" <c:if test="${fp.ALLOW_YN eq 'Y'}">checked</c:if> />${fp.FUNCTION_NAME}
																		</div>
																	</c:if>                                               
															</c:forEach>
														</c:when>
														<c:otherwise>
															<div class="css_td_r<c:if test="${not loop.last}" >b</c:if>">지정된 기능이 없습니다.</div>			
														</c:otherwise>
													</c:choose>
											
                                                    <!-- <div class="css_td_r<c:if test="${not loop.last}" >b</c:if>">${emp.hq_nm}</div>
                                                    <div class="css_td_r<c:if test="${not loop.last}" >b</c:if>">${emp.dept_nm}</div>
                                                    <div class="css_td_r<c:if test="${not loop.last}" >b</c:if>">${emp.tel_offc}</div> -->
                                                    <div class="css_td<c:if test="${not loop.last}" >_b</c:if>">
                                                        <input class="chost_btn_s6" type="button" value="권한 해제" style="width:70px;height:20px" onclick="delAuth('<c:if test="${empty emp.emp_nm}">G</c:if>','${each.urlno}','${emp.no}','${emp.groupno}','${emp.emp_no}')"/>
                                                    </div>
                                                 </div>
                                            </c:forEach>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <!---/게시판 영역------------------------->
                    </div><!--/main_table-->
					</li>
				</ul>
                </div><!--/content-->
                </form:form>
            </div><!--/contents-->
        </div><!--/container-->
    </div><!--/wrap-->
</body>
</html>
