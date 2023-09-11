<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pt" uri="/WEB-INF/tld/pagingTag.tld" %>

<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!-- <div class="content"> -->
    <div class="popup_wrap">
        <div class="bg"></div>
        <div class="popup w_720">
            <div class="agency_search_popcon">
                <p class="pop_t">기관 조회</p>
                <div class="agency_search">
                    <form>
                        <div class="search_box"><div class="input_box"><input type="text" placeholder="기관명을 입력해주세요."></div><button>검색</button></div>
                        <div class="search_list">
                            <table>
                                <tr>
                                    <th class="t_right">번호</th>
                                    <th>기관명</th>
                                    <th>기관주소</th>
                                    <th>기관 연락처</th>
                                </tr>
                                <tr>
                                    <td><input type="radio">05</td>
                                    <td>한국여성인권진흥원</td>
                                    <td>전라북도 전주시 덕진구 중동로 63</td>
                                    <td>061-345-3114</td>
                                </tr>
                                <tr>
                                    <td><input type="radio">04</td>
                                    <td>한국출판문화진흥원</td>
                                    <td>서울특별시 중구 서소문로 50 센트럴플레이스 3층</td>
                                    <td>02-735-1050</td>
                                </tr>
                                <tr>
                                    <td><input type="radio">03</td>
                                    <td>한국전력공사</td>
                                    <td>전라남도 나주시 전력로55(빛가람동 120)</td>
                                    <td>061-345-3115</td>
                                </tr>
                                <tr>
                                    <td><input type="radio">02</td>
                                    <td>한국전력공사</td>
                                    <td>경상북도 김천시 혁신8로 77 (율곡동 한국도로공사)</td>
                                    <td>1588-2504</td>
                                </tr>
                                <tr>
                                    <td><input type="radio">01</td>
                                    <td>한국전력공사</td>
                                    <td>대구광역시 동구 첨단로 120</td>
                                    <td>053)670-0114</td>
                                </tr>
                            </table>
                        </div>
                        <p>상급 기관 조회가 안 되실 경우 시스템 관리자 02)000-0000 으로 문의 부탁드립니다.</p>
                        <div class="btn_box">
                            <ul>
                                <li><a href="">취소</a></li>
                                <li><a href="" class="b_feac25">완료</a></li>
                            </ul>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
    $("a[id^=showInfo_]").click(function(){
    	$(".board_cont").hide();
    	
    	var no = $(this).attr("id").split("_")[1];
    	
    	var reqOwner = $("#cn_"+no).val();
    	var reqOrg = $("#on_"+no).val();
    	var reqDate = $("#dataReqDate_"+no).text();
    	var reqStatus = $("#dataReqStatus_"+no).text();
    	var responseTxt = $("#dataResponseTxt_"+no).val();
    	
    	$("#reqOwner").text(reqOwner);
    	$("#reqOrg").text(reqOrg);
    	$("#reqStatus").text(reqStatus);
    	$("#reqDate").text(reqDate);
    	$("#responseTxt").text(responseTxt);
    	$(".board_cont").show();
    	
    });
    </script>
<!-- </div> -->