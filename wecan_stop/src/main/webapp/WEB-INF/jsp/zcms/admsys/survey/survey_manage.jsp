<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true"/>

<style>
    .country {
        border: none !important;;
        display: block;
        margin-bottom: 20px;
        overflow: hidden;
        padding-top: 15px;
        width: 100% !important;
        margin-top: 20px;
    }

    .country li {
        float: left;
        margin-bottom: 60px;
        text-align: center;
        width: 7.6923%;
    }

    .country li img {
        width: 70%;
    }

    .country li p {
        font-size: 1em;
        margin-top: 5px;
        color: #3c4753;
    }
</style>

<jsp:include page="../lnb.jsp" flush="true"/>
<div id="contents">
    <script type="text/javascript">
        $(document).ready(function () {
            $("#delete").bind("click", function (ev) {
                ev.preventDefault();
                console.log("checked " + $(":checkbox[name='event']:checked").length);
                if ($(":checkbox[name='event']:checked").length <= 0) {
                    alert("삭제하려는 설문을 선택하여 주세요!");
                    return false;
                }
                if (confirm('선택하신 설문들을 삭제 하시겠습니까?')) {
                    $(this).unbind();
                    var events    = $(":checkbox[name=event]:checked").map(function () {
                        return $(this).val();
                    }).get();
                    location.href = "surveyDelete.html?event=" + events;
                    return true;
                }
                return false;
            });

            $("#matrix").bind("click", function (ev) {
                ev.preventDefault();
                //console.log("checked " + $(":checkbox[name='event']:checked").length);
                if ($(":checkbox[name='event']:checked").length != 1) {
                    alert("하나의 설문을 선택하여 주세요!");
                    return false;
                }
                if (confirm('선택하신 문항을 불러 오시겠습니까?')) {
                    $(this).unbind();
                    location.href = "surveyMatrix.html?event=" + $(":checkbox[name='event']:checked").attr('value');
                    return true;
                }
                return false;
            });
        });
    </script>
    <div class="contents_top">
        <div class="location">
            <a href="/admsys/dashboard/index.html">HOME</a>
            <a href="/admsys/survey/surveyManage.html">업무관리</a>
            <strong>로드맵관리</strong>
        </div>
        <div class="TopSearch">
            <span>SEARCH AREA</span>
            <input type=text name="keyword" value="<c:out value='${input.keyword}' />" class="bor1ddd" style="width:128px;"/>
            <input class="bt01" type="submit" value="검색" onclick="document.forms[0].action='?pageIndex=1'"/>
        </div>
    </div>
    <form:form modelAttribute="sdsSurveyEventVo" name="frm" method="post">
        <div id="content">
            <ul class="homepagebbs">
                <li class="bg">
                    <h3 class="sub">로드맵 관리</h3>
                </li>
                <li>
                    <ul class="country">
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=bd">
                                <img src="/com/art/flag/bd.jpg" alt="Bangladesh"/>
                                <p>Bangladesh</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=bt">
                                <img src="/com/art/flag/bt.jpg" alt="Bhutan"/>
                                <p>Bhutan</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=kh">
                                <img src="/com/art/flag/kh.jpg" alt="Cambodia"/>
                                <p>Cambodia</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=cn">
                                <img src="/com/art/flag/cn.jpg" alt="China"/>
                                <p>China</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=in">
                                <img src="/com/art/flag/in.jpg" alt="India"/>
                                <p>India</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=id">
                                <img src="/com/art/flag/id.jpg" alt="Indonesia"/>
                                <p>Indonesia</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=jp">
                                <img src="/com/art/flag/jp.jpg" alt="Japan"/>
                                <p>Japan</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=kz">
                                <img src="/com/art/flag/kz.jpg" alt="Kazakhstan"/>
                                <p>Kazakhstan</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=kg">
                                <img src="/com/art/flag/kg.jpg" alt="Kyrgyzstan"/>
                                <p>Kyrgyzstan</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=kp">
                                <img src="/com/art/flag/kp.jpg" alt="North Korea"/>
                                <p>North Korea</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=kr">
                                <img src="/com/art/flag/kr.jpg" alt="South Korea"/>
                                <p>South Korea</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=la">
                                <img src="/com/art/flag/la.jpg" alt="Laos"/>
                                <p>Laos</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=my">
                                <img src="/com/art/flag/my.jpg" alt="Malaysia"/>
                                <p>Malaysia</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=mv">
                                <img src="/com/art/flag/mv.jpg" alt="Maldives"/>
                                <p>Maldives</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=mn">
                                <img src="/com/art/flag/mn.jpg" alt="Mongolia"/>
                                <p>Mongolia</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=mm">
                                <img src="/com/art/flag/mm.jpg" alt="Myanmar"/>
                                <p>Myanmar</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=pk">
                                <img src="/com/art/flag/pk.jpg" alt="Pakistan"/>
                                <p>Pakistan</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=ph">
                                <img src="/com/art/flag/ph.jpg" alt="Philippines"/>
                                <p>Philippines</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=lk">
                                <img src="/com/art/flag/lk.jpg" alt="Sri Lanka"/>
                                <p>Sri Lanka</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=tj">
                                <img src="/com/art/flag/tj.jpg" alt="Tajikistan"/>
                                <p>Tajikistan</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=th">
                                <img src="/com/art/flag/th.jpg" alt="Thailand"/>
                                <p>Thailand</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=tm">
                                <img src="/com/art/flag/tm.jpg" alt="Turkmenistan"/>
                                <p>Turkmenistan</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=vn">
                                <img src="/com/art/flag/vn.jpg" alt="Viet Nam"/>
                                <p>Viet Nam</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=af">
                                <img src="/com/art/flag/af.jpg" alt="Afghanistan"/>
                                <p>Afghanistan</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=pg">
                                <img src="/com/art/flag/pg.jpg" alt="Papua New Guinea"/>
                                <p>Papua New Guinea</p>
                            </a>
                        </li>
                        <li>
                            <a href="/admsys/survey/surveyUpdate.html?countrycode=ir">
                                <img src="/com/art/flag/ir.jpg" alt="Iran"/>
                                <p>Iran</p>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--/content-->
    </form:form>
</div>
<!--/contents-->
<jsp:include page="../end.jsp" flush="false"/>
