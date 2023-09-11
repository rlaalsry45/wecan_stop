<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <script type="text/javascript">
            $(function() {
                $('.main_table1 tbody img').bind("click",function() {
                    var attr = $(this).attr("id");
                    if (typeof attr !== 'undefined' && attr !== false) {
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

                var urlnos = $.url().param('urlnos');
                var opens = $.url().param('opens');
                /* if (urlnos){
                    $.each(urlnos.split(","), function(index, v) {
                        $(":checkbox[name=urlno][value="+v+"]").prop("checked", true);
                    });
                } */
                if (opens) {
                    $.each(opens.split(","), function(index, v) {
                    });
                }

                $(":button, #confirm").click(function(){
                    var urlnos = $(":checkbox[name=urlno]:checked").map(function(){return $(this).val();}).get();
                    var opens = $("[src$='btn_opened.jpg']").map(function(){return $(this).attr('id');}).get();
                    var act = "insert";
                    if ($(this).attr("type") == "button") {
                        if ($(this).attr('id') != "topmenu") {
                            act += "&urlno="+ $(this).closest("tr").find(":checkbox").val().split("_")[1];
                            opens += ","+$(this).closest("tr").find(":checkbox").val();
                        }
                    } else {
                        act = "update";
                    }
                    document.frm.action = "?act="+act+"&urlnos="+urlnos+"&opens="+opens;
                    document.frm.submit();
                });
                
                $("[id^=view_val_][type=checkbox]").bind("click",function(){
                	var item = $(this);
                    var param;
                    var vURLNO = item.val();
                    var confirmText = "보이도록";
                    
                    if ( item.is(":checked") == true ) {
                        param={urlno:vURLNO, view_yn:'Y'};
                    } else if ( item.is(":checked") == false ) {
                        param={urlno:vURLNO, view_yn:'N'};
                        confirmText = "안보이도록";
                    }
                    
            		if(confirm(confirmText+" 하시겠습니까?")){
            			$.ajax({
            				type: 'POST',
            				url: "/admsys/setting/admin/updateMenuViewYN.html",
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

            function order(arg) {
                var urlnos = $(":checkbox[name=urlno]:checked").map(function(){return $(this).val();}).get();
                var opens = $("[src$='btn_opened.jpg']").map(function(){return $(this).attr('id');}).get();
                window.location.href = arg + "&urlnos=" + urlnos + "&opens=" + opens;
            }

            if ($.url().param('flag')=="1"){
                alert("처리 되었습니다.");
            }
            else if ($.url().param('flag')=="2"){
                self.close();
            }
            
            //2021-11-24
            function registrationFuncName(urlno){
            	
            	var fncNM_text = $("#fncSel_"+urlno+" option:selected").text();
            	var fncNM_value =$("#fncSel_"+urlno).val();
            	
            	if ( fncNM_value == '' ) {
            		$("#fncSel__"+urlno).focus();
            		alert("기능명을 입력해 주세요.");
            		return false;
            	}

            	var param={URLNO:urlno,"FUNCTION_NAME":fncNM_text,"FUNCTION_TYPE":fncNM_value};
            	
				if(confirm("등록 하시겠습니까?")){
					$.ajax({
						type: 'POST',
						url: "/admsys/setting/admin/registrationFuncName.html",
						data: param,
						success: function(result){
							if ( result.retStatus == "SUCCESS" ) {
								var fList = result.funcList;
								$("#fncSel_"+urlno).val("");        						  
								$("#flArea_"+urlno).html("");
								
								var chkStr = "";

								for ( var i = 0; i < fList.length; i++) {
									var temp = fList[i];
									chkStr += '<input type="checkbox" id="fncCB_'+urlno+'_'+temp.no+'" name="fncCB_'+urlno+'" value="'+temp.no+'"/>'+temp.function_NAME+"("+temp.function_TYPE+")";
								}
								$("#flArea_"+urlno).html(chkStr);
									alert("등록 하였습니다.");
									return false;
								} else {
									alert("등록에 실패 하였습니다.");
								}
							},
							error:function(){
								alert("등록중 오류가 발생하였습니다.");  
							}
					})
				}        		
			}

 			function deleteFunctionInfo(urlno){
				var dataList = new Array();

				var chk_val = $(':checkbox[name=fncCB_'+urlno+']:checked').map(function () {
					var obj = new Object();
					obj = parseInt($(this).val());
					dataList.push(obj);
				});
            	
				if(confirm("삭제 하시겠습니까?")){
					$.ajax({
						type: 'POST',
						url: "/admsys/setting/admin/deleteFunctionInfo.html",
						data: {"URLNO":urlno, "delList":dataList},
						traditional:true,
						success: function(result){
							if ( result.retStatus == "SUCCESS" ) {
								var fList = result.funcList;        						  
								$("#flArea_"+urlno).html("");
								
								var chkStr = "";

								for ( var i = 0; i < fList.length; i++) {
									var temp = fList[i];
									chkStr += '<input type="checkbox" id="fncCB_'+urlno+'_'+temp.no+'" name="fncCB_'+urlno+'" value="'+temp.no+'"/>'+temp.function_NAME+"("+temp.function_TYPE+")";
								}
								$("#flArea_"+urlno).html(chkStr);
									alert("삭제 하였습니다.");
									return false;
								} else {
									alert("삭제에 실패 하였습니다.");
								}
							},
							error:function(){
								alert("삭제중 오류가 발생하였습니다.");  
							}
						})
					}        		
				}
            </script>

            <div id="contents">
                <div class="contents_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>관리자메뉴관리</strong>
                    </div>
                </div>

                <form:form modelAttribute="authAdminVo" method="post" name="frm" onsubmit="return checkForm()">
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg">
                                <h3 class="setting">관리자메뉴관리</h3>
                                <div class="user_btn">
                                    <input class="chost_btn_s4" type="button" id="topmenu" value="+ 최상위 메뉴 등록" />
                                </div>
                            </li>
                            <li>
                                <div class="top_bt">
                                    <a class="btmore07" href="javascript:checkAll(true,'urlno');">전체선택</a>
                                    <a class="btmore07" href="javascript:checkAll(false,'urlno');">전체해제</a>
                                    <a class="btmore05" href="javascript:del('urlno');">삭제</a>
                                </div>
                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1" border="1" cellspacing="0" cellpadding="0" width="100%" summary="메뉴전체보기">
                                        <caption>메뉴전체보기</caption>
                                        <colgroup>
                                            <col width="5%" />
                                            <col width="30%" />
                                            <col width="70px" />
                                            <col width="" />
                                            <col width="132px" />
                                        </colgroup>
                                        <thead>
                                            <tr>
                                                <th>
                                                    <input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','urlno')" />
                                                </th>
                                                <th>
                                                    <span style="float:left">
                                                        <img src="/cms/image/btn_lnb_open.gif" alt="전체열림">
                                                        <img src="/cms/image/btn_lnb_close.gif" alt="전체닫힘">
                                                    </span>
                                                </th>
                                                <th>순서</th>
                                                <th>링크</th>
                                                <th>관리</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${authAdminUrllist}" var="each">
                                                <tr id="${each.urllevel}_${each.urlparentno}_${each.urltopno}">
                                                    <td>
                                                        <input class="bor_none" name="urlno" value="${each.urllevel+1}_${each.urlno}_${each.urltopno}" type="checkbox" />
                                                        <input type="hidden" name="hurlno" value="${each.urlno}" />
                                                        <input type="hidden" name="hconfirmyn" value="${each.confirmyn}" />
                                                    </td>
                                                    <td class='menu_d${each.urllevel}'>
                                                        <c:if test='${each.cnt!="1"}'>
                                                            <img src="/cms/image/btn_opened.jpg" id="${each.urllevel+1}_${each.urlno}_${each.urltopno}" />
                                                        </c:if>
                                                        <c:if test='${each.cnt=="1"}'>
                                                            <img src="/cms/image/btn_space.jpg" />
                                                        </c:if>
                                                        <input name="urltitle" type="text" class="bor1ddd" style="width:90%" value="${each.urltitle}" />
                                                    </td>
                                                    <td>
                                                        <c:url value="index.html" var="url">
                                                            <c:param name="mode" value="order" />
                                                            <c:param name="urlno" value="${each.urlno}" />
                                                            <c:param name="act" value="" />
                                                        </c:url>
                                                        <a class="bt" href="#none" onclick="order('${url}u')">올리기</a><a class="next" href="#none" onclick="order('${url}d')">내리기</a>
                                                    </td>
                                                    <td>
                                                        <input name="urllink" type="text" class="bor1ddd" style="width:80%" value="<c:out value="${each.urllink}" escapeXml="true" />" />
                                                        <input type="checkbox" id="view_val_${each.urlno}" name="view_val_${each.urlno}" value="${each.urlno}" <c:if test='${each.view_yn eq "Y"}'>checked</c:if> />VIEW ON/OFF
                                                    </td>
                                                    <td>
                                                        <input class="chost_btn_s3" type="button" value="하위 메뉴 등록" />
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${empty authAdminUrllist}">
                                                <tr><td colspan="5">기록이 없습니다.</td></tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                    <!--/게시판 영역-->
                                </div>
                                <!--/main_table-->
                                <div class="btn-c">
                                    <input class="chost_btn_s" id="confirm" type="submit" value="확인">
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../../end.jsp" flush="true" />
