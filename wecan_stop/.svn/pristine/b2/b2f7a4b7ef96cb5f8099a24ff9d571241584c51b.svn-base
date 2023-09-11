<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file = "/WEB-INF/jsp/zcms/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자::카테고리 설정</title>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
<meta name="Keywords" content="z5 cms"/>
<meta name="decription" content="z5 cms"/>
<meta name="author" content="z5 cms"/>
<meta name="classification" content="z5 cms"/>
<link rel="stylesheet" type="text/css" href="/cms/css/democratic.css" />
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/cms/js/func.js"></script>
<script type="text/javascript" src="/cms/js/valid.js"></script>
<script type="text/javascript">
$(function(){
    $(":checkbox[name=cno]").add(":radio[name^=cstatus]").bind("click",function(){
        var type = $(this).attr("type");
        var flag = type=="checkbox" ? $(this).prop("checked") : $(this).closest("tr").find(":radio").index(this);
        var obj = (type=="checkbox"||flag==1) ? $(this).closest("tr").nextAll("#"+$(this).closest("tr").children().eq(0).attr("id")) : $(this).closest("tr").prevAll("#"+$("td[id="+$(this).closest("tr").attr("id")+"]").closest("tr").attr("id")).filter(":first");
        function selAll(obj){
            obj.each(function(){
                if (type=="checkbox") $(this).find(":checkbox").prop("checked", flag);
                else $(this).find(":radio").eq(flag).prop("checked", true);
                var tr = (type=="checkbox"||flag==1) ? $(this).nextAll("#"+$(this).children().eq(0).attr("id")) : $(this).prevAll("#"+$("td[id="+$(this).attr("id")+"]").closest("tr").attr("id")).filter(":first");
                if (tr.length > 0 ) selAll(tr)
            });
        }
        selAll(obj);
    });

    $('.main_table1 tr').children().filter("th,td").click(function(event) {
        if (event.target.type !== 'checkbox') {
            $(':checkbox', this).trigger('click');
        }
    });

    $(window).on('beforeunload ',function() {
        return clear();
    });
    function clear(){
        document.frm.action = "?act=clear&boardno=${param.boardno}";
        document.frm.submit();
    }
});

window.onload = function(){
    if ("${param.flag}"=="1"){
        //alert("처리되었습니다.");
        self.close();
    }
}
</script>
</head>
<body style="background:#dfe8ea;">
    <div id="content" style="margin:10px 10px 0 10px;">
        <form:form modelAttribute="zCateVo" method="post" name="frm">
        <ul class="homepagebbs">
            <li class="bg">
                <h3 class="sub">게시판 카테고리 설정</h3>
                <div class="user_btn01">
                    <input class="chost_btn_s4" type="submit" value="+ 신규 카테고리 등록" onClick="this.form.action='?act=insert&boardno=${param.boardno}';"/>
                </div>
            </li>
            <li>
                <div class="top_bt">
                    <a class="btmore07" href="javascript:checkAll(true,'cno');">전체선택</a>
                    <a class="btmore07" href="javascript:checkAll(false,'cno');">전체해제</a>
                    <a class="btmore05" href="javascript:del('cno');">삭제</a>
                </div>
                <div class="main_table">
                    <!--게시판 영역-->
                    <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="800" summary="게시판 카테고리 설정">
                        <caption>게시판 카테고리 설정</caption>
                        <colgroup>
                            <col width="5%" />
                            <col width="" />
                            <col width="70" />
                            <col width="150" />
                            <col width="150" />
                            <col width="120" />
                        </colgroup>
                        <thead>
                            <tr>
                            <th><input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','cno')"/></th>
                            <th>분류명</th>
                            <th>순서</th>
                            <th>상태</th>
                            <th>등록일</th>
                            <th>관리</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${detail.cateList}" var="each" varStatus="loop">
                            <tr id="${each.clevel}_${each.cparentno}_${each.ctopno}">
                                <td id="${each.clevel+1}_${each.cno}_${each.ctopno}">
                                    <input class="bor_none" name="cno" value="${each.cno}" type="checkbox" />
                                    <input type="hidden" name="hcno" value="${each.cno}" />
                                </td>
                                <td class='menu_d${each.clevel}'>
                                    <input name="cname" type="text" class="bor1ddd" value="${each.cname}" style="width:100%" />
                                </td>
                                <td>
									<input class="bor_none" type="image" src="/cms/image/btn_lnb_close.gif" alt="올리기" onClick="this.form.action='?act=u&boardno=${param.boardno}&cno=${each.cno}'"/>
									<input class="bor_none" type="image" src="/cms/image/btn_lnb_open.gif" alt="내리기" onClick="this.form.action='?act=d&boardno=${param.boardno}&cno=${each.cno}'"/>
                                </td>
                                <td>
                                    <input class="radio0" type="radio" id="cstatus${loop.index}1" name="cstatus${loop.index}" value="1" <c:if test="${each.cstatus=='1'}">checked</c:if>/>
                                    <label class="on" for="cstatus${loop.index}1">사용</label>
                                    <input class="radio1" type="radio" id="cstatus${loop.index}2" name="cstatus${loop.index}" value="0" <c:if test="${each.cstatus=='0'}">checked</c:if>/>
                                    <label class="on" for="cstatus${loop.index}2">사용안함</label>
                                </td>
                                <td>
                                    <fmt:parseDate value="${each.datereg}" pattern="yyyyMMddHHmmss" var="isoDate" />
                                    <fmt:formatDate type="both" value="${isoDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </td>
                                <td>
                                    <input  class="chost_btn_s7" type="submit" value="하위카테고리등록" onClick="this.form.action='?act=insert&boardno=${param.boardno}&cno=${each.cno}'" />
                                </td>
                            </tr>
                            </c:forEach>
                            <c:if test="${empty detail.cateList}">
                            <tr>
                                <td colspan="6" style="padding:20;">기록이 없습니다.</td>
                            </tr>
                            </c:if>
                        </tbody>
                    </table>
                    <!--/게시판 영역-->
                </div>
                <!--/main_table-->
                <div class="btn-c">
						<input class="chost_btn_s" type="submit" value="확인" onclick="this.form.action='?act=update&boardno=${param.boardno}';" />
                        <a class="btmore09" href="#" onClick="self.close();">닫기</a>
                </div>
                <!--/confirm-->
            </li>
        </ul>
        </form:form>
        <!--/bbs_category_popup-->
    </div>
    <!--/wrap-->
</body>
</html>
