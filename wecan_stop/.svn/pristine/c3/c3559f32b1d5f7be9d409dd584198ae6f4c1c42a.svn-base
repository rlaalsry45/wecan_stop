<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html;">
<title>▒▒▒ ▒▒▒</title>
<!-- <link rel="stylesheet" href="../css/style.css" type="text/css"> -->
<style>
body, form, p{
	margin:0px;
	padding:0px;
}
body, tr, td, p, form, textarea, div, span, input, caption{
	font-family:"돋움체", "굴림체", Seoul;
	font-size:12px;
	line-height:18px;
	color:#666666;
}
img{
	border:0px;
}
a:link{
	color:#525252;text-decoration:none;
}
a:active{
	color:#525252;text-decoration:none;
}
a:visited{
	color:#525252;text-decoration:none;
}
a:hover{
	color:#0E89C2;text-decoration:underline;
}

a.noti:link{
	color:#525252;text-decoration:none;
}
a.noti:active{
	color:#525252;text-decoration:none;
}
a.noti:visited{
	color:#525252;text-decoration:none;
}
a.noti:hover{
	color:#CC0066;text-decoration:underline;
}

/***************************************************************/
#topmenu{
	padding-bottom:12px;
}
#conts{
	width:979px;padding-bottom:15px;
}
#conts_left{
	float:left;width:199px;padding-left:15px;padding-right:10px;
}
#leftmenu{
	padding-top:10px; overflow:hidden;
}
#conts_right{
	float:right;width:755px;
}
#conts_body{
	padding-top:20px;padding-bottom:30px;
}
#banner{
	clear:both;padding-left:15px;
}
#copyright{
	clear:both;padding-left:15px;
}
/*************** 로그인 ****************/
#login{
	width:198px;
}
.login{
	background:url(/usr/image/login/bg_login_mid.gif) repeat-y center;width:198px;
}
.login_input{
	float:left;padding:10px 0px 0px 14px;
}
#login_input_id input{
	border:1px solid #c0c0c0;width:103px;height:21px;background:url(/usr/image/login/bg_input_id.gif) no-repeat 3px 3px;
}
#login_input_pass{
	padding-top:2px;
}
#login_input_pass input{
	border:1px solid #c0c0c0;width:103px;height:21px;background:url(/usr/image/login/bg_input_pass.gif) no-repeat 3px 3px;
}
.btn_login{
	float:right;padding:10px 14px 12px 0px;
}
.btn_logout{
	float:right;padding:10px 14px 7px 0px;
}
.btn_etc_login{
	clear:both;padding:0px 14px;
}
.btn_etc_login div{
	background:url(/usr/image/login/dotline_login.gif) repeat-x top center;padding-top:7px;padding-bottom:7px;
}
.btn_etc_login span{
	padding:0px 5px;
}
.btn_etc_logout{
	clear:both;padding:0px 14px;
}
.btn_etc_logout div{
	background:url(/usr/image/login/dotline_login.gif) repeat-x top center;padding-top:9px;padding-bottom:7px;
}
.btn_etc_logout span{
	padding:0px 5px;
}
.login_txt{
	float:left;padding:10px 0px 0px 14px;
}
.login_txt div{
	padding:6px 0px 5px 5px;background-color:#f2f2f2;width:103px;
}
.login_txt span{
	font-weight:bold;
}
.admin_memo{
	clear:both;font-size:11px;letter-spacing:-1px;padding-bottom:5px;color:#999999;
}
.admin_memo img{
	margin-bottom:-3px;
}
.admin_memo span{
	font-weight:bold;color:#666666;
}
/*************** 메인 ****************/
.journals{
	background:url(/usr/image/login/bg_login_mid.gif) repeat-y center;padding:20px 14px 10px 14px;
}
.journals div{
	text-align:center; padding-bottom:5px;
}
#main_notis{
	float:left;width:440px;padding-left:7px;
}
#main_notis ul{
	list-style:none;margin:0px;padding:0px;padding-top:5px;
}
#main_notis li{
	padding:2px 0px;
	clear:both;
	/*height:16px;*/
}
.noti_txtframe{
	float:left;width:340px;
}
.noti_bullet{
	float:left;padding:6px 8px 0px 5px;
}
.noti_txt{
	float:left;width:325px;overflow:hidden;text-overflow:ellipsis;
}
.noti_date{
	float:right;width:65px;
}
.noti_padding{
	padding-top:12px;clear:both;
}
#main_intro{
	float:right;
}
/*************** 서브 ****************/
.contstab{
	text-align:center;
	padding-bottom:30px;
}
.contstab div{
	background:url(/cms/image/tab_line.gif) repeat-x bottom;text-align:left;
}
.contstab img{
	margin-right:3px;
}
.contstab2{
	text-align:center;
	padding-bottom:10px;
}
.contstab2 div{
	background:url(/cms/image/tab_line.gif) repeat-x bottom;text-align:left;
}
.contstab2 img{
	margin-right:3px;
}
.subdiv_greeting{
	text-align:justify;
	padding:0px 30px;
	line-height:20px;
}
.subdiv_name{
	text-align:right;
	font-weight:bold;
	padding:0px 30px;
	padding-top:20px;
}

.paper_table {
	FONT-SIZE: 9pt;
	COLOR: #333333;
	BACKGROUND: #CCCCCC;
	LINE-HEIGHT: 160%;
	FONT-STYLE: normal;
	FONT-FAMILY: Arial, 돋움;
	TEXT-DECORATION: none
	}


.paper_tr_header {
	FONT-SIZE: 9pt;
	BACKGROUND: #eeeeee;
	LINE-HEIGHT: 160%;
	FONT-STYLE: normal;
	FONT-FAMILY: Arial, 돋움;
	TEXT-DECORATION: none;

	}
.paper_td_header {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	COLOR: #3399CC;
	BACKGROUND: #eeeeee;
	FONT-WEIGHT: bold;
	TEXT-DECORATION: none
	}
.paper_tr_body {
	FONT-SIZE: 9pt;
	COLOR: #333333;
	BACKGROUND: #ffffff;
	LINE-HEIGHT: 160%;
	FONT-STYLE: normal;
	FONT-FAMILY: Arial, 돋움;
	TEXT-DECORATION: none
	}

.paper_td_body {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	color: #666666;
	BACKGROUND: #ffffff;
	TEXT-DECORATION: none
	}
.paper_btn_sch {
	font-family: "돋움";
	font-size: 11px;
	line-height: 16px;
	text-decoration: none;
	color: #FFFFFF;
	margin: 0px;
	padding: 1px 0px 0px;
	background-color: #7998b7;
	clear: both;
}
.paper_btn {
	font-family: "돋움";
	font-size: 11px;
	line-height: 16px;
	text-decoration: none;
	color: #FFFFFF;
	margin: 0px;
	padding: 1px 0px 0px;
	background-color: #7998b7;
	clear: both;
	cursor:hand;
}

.chost_table {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	color: #666666;
	BACKGROUND: #ffffff;
	TEXT-DECORATION: none
}

.chost_header {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	color: #3271b1;
	TEXT-DECORATION: none
}

.chost_table_header {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	color: #3271b1;
	BACKGROUND: #eeeeee;
	TEXT-DECORATION: none
}

.chost_table_body {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	color: #666666;
	BACKGROUND: #FFFFFF;
	TEXT-DECORATION: none;

}

.chost_table_body_ {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	color: #43C65C;
	BACKGROUND: #FFFFFF;
	TEXT-DECORATION: none;

}

.chost_table_register {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	color: #666666;
	BACKGROUND: #ffffff;
	TEXT-DECORATION: none
}

.chost_table_register_header {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	color: #3271b1;
	BACKGROUND: #efefef;
	TEXT-DECORATION: none
}

.chost_table_register_body {
	font-family: "굴림";
	font-size: 9pt;
	line-height: 20px;
	color: #666666;
	BACKGROUND: #FFFFFF;
	TEXT-DECORATION: none;

}

.chost_btn_sch {
	font-family: "돋움";
	font-size: 11px;
	line-height: 16px;
	text-decoration: none;
	color: #FFFFFF;
	margin: 0px;
	padding: 1px 0px 0px;
	background-color: #6091c3;
	clear: both;
}

.chost_btn {display:inline-block;padding:0 15px;height:23px;line-height:23px;font-size:12px;color:#fff;background:#495a74;border:0px;}
</style>
<script language="javascript">
<!--
	function Add(fieldname) {

		var text, value, f;
		text = "";
		value = "";
		fieldList = frm5.field_list;
		f = false;

		for (i = 0; i < fieldList.length; i++) {
			if (fieldList.options[i].selected) {
				add_text = fieldList.options[i].text;
				add_value = fieldList.options[i].value;
				text += add_text + " ";
				value += add_value + ",";
				f = true;
			}
		}

		if (f) {
			text = text.substring(0, text.length - 1);
			value = value.substring(0, value.length - 1);
		}

		//	opener.frm.sc_sec1_txt.value = text;
		opener.frm2.${fieldname}.value = value;

		self.close();

	}
//-->
</script>
</head>

<body>
	<table border="0" width="240">
		<tr>
			<td width="100%">
				<form name="frm5">
					<table cellpadding="2" cellspacing="1" border="0"
						class="chost_table" width="100%">

						<%-- <tr>
							<td width="100%" align="center" class="chost_table_header"
								background="/cms/image/table_bg_pattern.gif">${codename}</td>
						</tr> --%>
						<tr>
							<td class="chost_table_body">&nbsp;검색할 필드들을 모두 선택하세요.</td>
						</tr>
						<tr>
							<td class="chost_table_body">&nbsp;
							<select name="field_list" multiple size="10" style="width: 220px">
								<c:forEach items="${list}" var="each" varStatus="loop">
									<option value="${each.code}">${each.codeNm}</option>
								</c:forEach>

							</select>
							</td>
						</tr>

					</table>
					<br>

					<table border="0" width="100%" class="t2" cellpadding="3"
						cellspacing="0" bordercolor="#333333"
						bordercolordark="chost_table_body" bordercolorlight="#333333">
						<tr>
							<td width="100%" align="center">
							<input type="button" class=chost_btn value="확   인" onClick="Add('${fieldname}')">
							<input type="button" class=chost_btn value="닫   기" onClick="self.close()">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td width="100%"></td>
		</tr>
	</table>

</body>

</html>



