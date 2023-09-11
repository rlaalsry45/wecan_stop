<%@ page contentType="text/html;charset=utf-8" %>
<%-- <%
	/*System.out.println((String)request.getHeader("referer")) ;
	System.out.println(request.getRequestURI()) ;
	System.out.println(request.getPathInfo());
	System.out.println(request.getQueryString());
	System.out.println(request.getPathTranslated());
	System.out.println(request.getContextPath());
	System.out.println(request.getAttribute("javax.servlet.error.request_uri"));*/


	if((request.getServerName().equals("sub.ginue.ac.kr") || request.getServerName().equals("edu.ginue.ac.kr") )){
		String param = (String)request.getAttribute("javax.servlet.error.request_uri");
		if (param.equals("/art")
				|| param.equals("/korean")
				|| param.equals("/pedagogy")
				|| param.equals("/inedu")
				|| param.equals("/oia")
				|| param.equals("/ggedu")
				|| param.equals("/broadcasting")
				|| param.equals("/korean")
				|| param.equals("/computer")
				|| param.equals("/ethics")
				|| param.equals("/physical")
				|| param.equals("/english")
				|| param.equals("/infant")
				|| param.equals("/counseling")
				|| param.equals("/mentor")
				|| param.equals("/art")
				|| param.equals("/dormitory")
				|| param.equals("/graduate_admission")
				|| param.equals("/scientific")
				|| param.equals("/support")
				|| param.equals("/social")
				|| param.equals("/consulting")
				|| param.equals("/rndb")
				|| param.equals("/graduate")
				|| param.equals("/elder")
				|| param.equals("/fund")
				|| param.equals("/admission")
				|| param.equals("/ace")
				|| param.equals("/sciencegifted")
				|| param.equals("/gglife")
				|| param.equals("/mathematics")
				|| param.equals("/ctl")
				|| param.equals("/englishedu")
				|| param.equals("/practical")
				|| param.equals("/music")
				|| param.equals("/science")
				|| param.equals("/spedagogy")
				|| param.equals("/ier")
				|| param.equals("/dongmoon")
				|| param.equals("/inlife")

				){
			System.out.println(request.getProtocol()+request.getServerName() +param+"/");
			response.sendRedirect((request.isSecure()?"https://":"http://")+request.getServerName() +param+"/");
		}
	}
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>시스템 점검 중</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="/usr/css/base.css"/>
    <link rel="stylesheet" type="text/css" href="/usr/css/style.css"/>
    <script language="javascript">
        function fncGoAfterErrorPage() {
            history.back(-2);
        }
    </script>
    <style>
        .error_wrap {
            width: 790px;
            height: 295px;
            position: relative;
            background: url(/usr/art/common/bg_error_img.jpg) no-repeat 0 0;
            margin: 200px auto 0 auto;
        }

        .error_wrap dl {
            width: 340px;
            position: absolute;
            top: 42px;
            left: 374px;
        }

        .error_wrap dl dt {
            font-size: 35px;
            font-weight: 800;
            letter-spacing: -7px;
            color: #d23552;
            width: 100%;
            padding-bottom: 15px;
        }

        .error_wrap dl dd {
            float: left;
            width: 100%;
            margin-left: 0px;
            font-size: 16px;
            font-weight: 600;
            line-height: 20px;
            letter-spacing: -2px;
            padding-bottom: 10px;
            color: #444444;
        }

        .error_wrap dl dd.mailing {
            font-size: 12px;
            letter-spacing: normal;
        }

        .error_wrap dl dd.mailing a {
            color: #000;
            text-decoration: none;
        }

        .error_wrap dl dd.btn_back {
            margin-top: 15px;
        }

        .error_wrap dl dd.btn_back a {
            color: #fff;
            font-weight: 600;
            text-decoration: none;
            font-size: 12px;
            width: 136px;
            height: 39px;
            text-align: center;
            line-height: 39px;
            background:url(/usr/image/common/bg_btn_back.jpg) no-repeat 0 0;
            overflow: hidden;
            display: block;
        }
    </style>
</head>
<body>
<div class="error_wrap">
    <dl>
        <dt>잘못된 서비스 요청입니다.</dt>
        <dd>URL 주소 등을 다시 확인하신 후 다시 접속하거나, 계속 문제가 발생한 경우 문의해 주시기 바랍니다.</dd>
        <dd class="mailing"><a href="http:///nes21.co.kr"></a></dd>
        <dd class="btn_back"><a href="javascript:fncGoAfterErrorPage();">뒤로가기</a></dd>
    </dl>
</div>

</body>
</html>
