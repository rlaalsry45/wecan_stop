<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko">
<head>
    <title>디버그 페이지</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/usr/css/base.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/usr/css/style.css"/>"/>
    <script type="text/javascript" src="<c:url value="/com/js/jquery-1.12.3.min.js"/>"></script>
    <style type="text/css">
        /* roboto-mono-regular - latin */
        @font-face {
            font-family: 'Roboto Mono';
            font-style: normal;
            font-weight: 400;
            src: url('/com/font/roboto-mono-v6-latin-regular.eot'); /* IE9 Compat Modes */
            src: local('Roboto Mono'), local('RobotoMono-Regular'),
            url('/com/font/roboto-mono-v6-latin-regular.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
            url('/com/font/roboto-mono-v6-latin-regular.woff2') format('woff2'), /* Super Modern Browsers */
            url('/com/font/roboto-mono-v6-latin-regular.woff') format('woff'), /* Modern Browsers */
            url('/com/font/roboto-mono-v6-latin-regular.ttf') format('truetype'), /* Safari, Android, iOS */
            url('/com/font/roboto-mono-v6-latin-regular.svg#RobotoMono') format('svg'); /* Legacy iOS */
        }
        th, td {
            border-bottom: 1px solid #ddd;
            font-family:Roboto Mono,sans-serif;
            font-size:9pt;
        }
    </style>
</head>
<body>
<div class="bg">
    <ul style="text-align: center; margin-left: 5%; width: 90%;">
        <li style="margin-bottom: 10px;">
            <h3>Heap Memory Statistics [MB]</h3>
            <a class="btn-r" href="${pageContext.request.contextPath}/zcms/gc.html">+ 가비지 콜렉터 +</a>
        </li>
        <li>
            <table>
                <caption>Heap Memory Statistics [MB]</caption>
                <colgroup>
                    <col width="20%"/>
                    <col width="20%"/>
                    <col width="20%"/>
                    <col width="20%"/>
                    <col width="20%"/>
                </colgroup>
                <thead>
                <tr>
                    <th>Time</th>
                    <th>Used</th>
                    <th>Free</th>
                    <th>Total</th>
                    <th>Max</th>
                </tr>
                </thead>
                <tbody id="viewer">
                <tr>
                    <td>${time}</td>
                    <td>${used}</td>
                    <td>${free}</td>
                    <td>${total}</td>
                    <td>${max}</td>
                </tr>
                </tbody>
            </table>
        </li>
    </ul>
</div>
<script type="text/javascript">
    var count = 0;
    var timer = 5000; // 5 seconds

    function refresh() {
        record();
        setTimeout(refresh, timer);
    }
    setTimeout(refresh, timer);

    function record() {
        count++;
        var html;
        var view = $('#viewer');
        $.get("/zcms/ms/get.html", function (list) {
            if (count >= 40) {
                count = 0;
                view.empty();
            }

            html = '<tr>';
            html += '<td>' + list['time'] + '</td>';
            html += '<td>' + list['used'] + '</td>';
            html += '<td>' + list['free'] + '</td>';
            html += '<td>' + list['total'] + '</td>';
            html += '<td>' + list['max'] + '</td>';
            html += '</tr>';
            view.append(html);
        });
        return false;
    }
</script>
</body>
</html>
