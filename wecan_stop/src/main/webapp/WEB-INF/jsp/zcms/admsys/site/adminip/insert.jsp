<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <script type="text/javascript">
            function isIPCheck(form_nm, ele_nm){

                var inText = form_nm.value;
                var ret;

                    for (var i = 0; i < inText.length; i++) {
                        ret = inText.charCodeAt(i);
                            if (!((ret > 47) && (ret < 58) || (ret == 46))) {
                                alert('정상적인 IP번호가 아닙니다.');
                                form_nm.value = "";
                                form_nm.focus();
                                return false;
                            }
                    }
                    return true;
            }
             $(document).ready(function(){
                    $("#global_ip").change(function(){
                        if($("#global_ip [value=2]").attr("checked", true)){
                                $("#ip4").attr("disabled", true);
                        }

                        });
                    $("#global_fullip").change(function(){
                        if($("#global_ip [value=1]").attr("checked", true)){
                            $("#ip4").attr("disabled", false);
                        }
                    });

            });

            function checkForm(){

                if($("[name=ip]").val() == null || $("[name=ip]").val().trim() == "" ){
                    alert("ip를 입력하세요");
                    $("[name=ip]").focus();
                    return;
                }
                if($("[name=ip2]").val() == null || $("[name=ip2]").val().trim() == "" ){
                    alert("ip를 입력하세요");
                    $("[name=ip2]").focus();
                    return;
                }
                if($("[name=ip3]").val() == null || $("[name=ip3]").val().trim() == "" ){
                    alert("ip를 입력하세요");
                    $("[name=ip3]").focus();
                    return;
                }
                if($("#global_fullip").is(":checked")==true ){
                    if($("[name=ip4]").val() == null || $("[name=ip4]").val().trim() == "" ){
                        alert("ip를 입력하세요");
                        $("[name=ip4]").focus();
                        return;
                    }
                }
                if($("[name=name]").val() == null || $("[name=name]").val().trim() == ""){
                    alert("이름을 입력하세요");
                    $("[name=name]").focus();
                    return;
                }
                if($("[name=adminip_permit]").is(":checked")!=true ){
                    alert("승인여부를 입력하세요");
                    $("[name=adminip_permit]").focus();
                    return;
                }
                $.ajax({
                      type : "POST"
                    , data : $("#frm").serialize()
                    //, data : "ip="+$("#ip").val()+"."+$("#ip2").val()+"."+$("#ip3").val()+"."+$("#ip4").val()
                    ,datatype:"json"
                    , cache : false
                    , url : "/admsys/site/adminip/doublecheck.html"
                    , success : function(data){
                            if(data =='true' ){
                                frm.submit();

                            }else{
                                alert("이미 사용중인 IP입니다.");
                                $("#ip").val('');
                                $("#ip2").val('');
                                $("#ip3").val('');
                                $("#ip4").val('');
                                $("#ip").focus();
                                return;
                            }
                        }
                     , error : function(data, status, err){
                        alert("서버와의 통신이 실패했습니다.");
                        return;
                    }
                });

            }
            </script>
            <div id="contents">
                <div class="contents_top">
                    <div class="location">
                        <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>시스템 접속 IP 등록</strong>
                    </div>
                </div>
                <form:form modelAttribute="adminIPVO" name="frm"  method="post" id="frm">
                    <input name="act" type="hidden" value="insert" />
                    <input name="dupflag" id="dupflag" type="hidden" value="0" />
                    <div id="content">
                        <ul class="homepagebbs">
                            <li class="bg"><h3 class="setting">시스템 접속 IP 등록</h3></li>
                            <li>
                                <div class="main_table">
                                    <!--게시판 영역-->
                                    <table class="main_table1" summary="분류, IP 번호, 이름, 메모, 승인">
                                        <caption>사이트 추가</caption>
                                        <colgroup>
                                            <col width="150">
                                            <col width="">
                                        </colgroup>
                                        <tr>
                                            <th class="Tleft">분류</th>
                                            <td class="Tbod Tbod Tleft">
                                                <input class="radio1" type="radio" name="global_ip"  id="global_fullip"value="1" <c:if test="${global_ip =='1'}">checked</c:if> /> 개별 IP
                                                <input class="radio1" type="radio" name="global_ip" id="global_ip" value="2" <c:if test="${global_ip =='2'}">checked</c:if>/> 대역 IP
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">IP 번호</th>
                                            <td class="Tleft">
                                                <input type="text" name="ip"  id="ip"  class="bor1ddd" size="3"  maxlength="3" onkeyup="javascript:isIPCheck(this)" /> .
                                                <input type="text" name="ip2" id="ip2" class="bor1ddd" size="3"  maxlength="3" onkeyup="javascript:isIPCheck(this)" /> .
                                                <input type="text" name="ip3" id="ip3" class="bor1ddd" size="3"  maxlength="3" onkeyup="javascript:isIPCheck(this)" /> .
                                                <input type="text" name="ip4" id="ip4" class="bor1ddd" size="3"  maxlength="3" onkeyup="javascript:isIPCheck(this)" />
                                                <span class="text" style="color: crimson;">&nbsp;( 숫자만 입력 가능합니다. )</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">이름</th>
                                            <td class="Tleft">
                                                <input type="text" name="name" id="name" class="bor1ddd" size="50" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">메모</th>
                                            <td class="Tleft">
                                                <input type="text" name="memo"  id="memo" class="bor1ddd" size="50" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th class="Tbornone Tleft">승인</th>
                                            <td class="Tleft">
                                                <input class="radio1" type="radio" name="adminip_permit" id="adminip_permit" value="1" checked />
                                                사용
                                                <input class="radio1" type="radio" name="adminip_permit" id="adminip_permit" value="2" />
                                                중지
                                            </td>
                                        </tr>
                                    </table>
                                    <!--/게시판 영역-->
                                </div>
                                <!--/main_table-->
                                <div class="btn-c-B">
                                    <a class="btmore04" href="javascript:checkForm();">등록</a>
                                    <a class="btmore09" onclick="if(window.confirm('입력한 내용이 삭제되고 리스트화면으로 이동합니다.\r\n그래도 진행 하시겠습니까?')) this.href='/admsys/site/adminip/index.html'" href="javascript:void(0);">취소</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!--/content-->
                </form:form>
            </div>
            <!--/contents-->
<jsp:include page="../../end.jsp" flush="true" />