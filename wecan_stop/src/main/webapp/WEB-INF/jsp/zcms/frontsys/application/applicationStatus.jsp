<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pt" uri="/WEB-INF/tld/pagingTag.tld"%>

<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<html>
<head>
<title>한국여성인권진흥원 성희롱방지 조직문화진단</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="X-UA-Compatible" content="IE=10"/>
<link rel="stylesheet" type="text/css" href="/usr/css/admin_system.css"/>

<style>
.cont_wrap{padding:70px 0 90px; border-bottom:10px solid #f5f5f5}
.w_1170{max-width:1170px; width:100%; position:relative; margin:0 auto;}
.right_cont{padding-left:370px; min-height:300px;}
.p_t{color:#757575; font-size:20px; font-weight:bold;margin-top:20px;margin-left:5px;}
.txt_box > p{color:rgba(0,0,0,0.8); font-size:13px; line-height:1.94; word-break: keep-all; margin-top:10px;margin-left:5px;}
</style>
</head>
<body id="admin_system">
<div class="cont_wrap">
	<div class="w_1170">
		<div class="right_cont">
			<p class="p_t">성희롱 방지 조직문화 진단 신청 진행현황</p>
			<div class="txt_box">
               <p>현재 진행상황 및 처리결과를 확인하실 수 있습니다.</p>
            </div>
			<br>
			<br>
			<div class="divStatus <c:if test='${step_status eq "1"}'>divStatusSelect</c:if>">신청</div>
			<div class="divStatus <c:if test='${step_status eq "2"}'>divStatusSelect</c:if>">접수대기</div>
			<div class="divStatus <c:if test='${step_status eq "3"}'>divStatusSelect</c:if>">접수승인</div>
			<div class="divStatus <c:if test='${step_status eq "4"}'>divStatusSelect</c:if>">접수불가</div>
			<div class="divStatus <c:if test='${step_status eq "5"}'>divStatusSelect</c:if>" style="margin-top:10px;">심사대기</div>
			<div class="divStatus <c:if test='${step_status eq "6"}'>divStatusSelect</c:if>" style="margin-top:10px;">심사거절</div>
			<div class="divStatus <c:if test='${step_status eq "7"}'>divStatusSelect</c:if>" style="margin-top:10px;">심사승인</div>
			<div class="divStatus <c:if test='${step_status eq "8"}'>divStatusSelect</c:if>" style="margin-top:10px;">진단 완료</div>
		</div>
		<!-- right content -->
	</div>
</div>
</body>
</html>