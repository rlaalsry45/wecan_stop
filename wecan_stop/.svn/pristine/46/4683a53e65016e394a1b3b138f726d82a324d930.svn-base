<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script language="javascript">
	function openSnsWin(opensns) {
		var winObj;
		winObj = window.open(opensns,"","width=560, height=520, scrollbars=yes, resizable=yes");
	} 
	function _sns2(type,title){

		var snsTitle = encodeURI(title);
		var snsUrl = encodeURIComponent (location.href); 

		var snsCopy = encodeURI("한국국제교류재단");
		var opensns = "";
	 
		if(type == "facebook"){
			opensns +="http://www.facebook.com/sharer.php?u="+snsUrl;
			opensns += "&&t="+snsTitle;
			openSnsWin(opensns);
			//window.open(opensns,'blank','width=400px,height=300px');
		}else if(type == "me2day"){
			opensns += "http://me2day.net/posts/new?new_post[body]=";
			opensns += "\""+snsTitle+"\":"+snsUrl;
			opensns += "&new_post[tags]="+snsCopy;
			openSnsWin(opensns);
			//window.open(opensns,'blank','width=400px,height=300px');
		}else if(type == "twitter"){
			opensns += "http://twitter.com/share?url="+snsUrl;
			opensns += "&text="+snsTitle;
			openSnsWin(opensns);
			//window.open(opensns,'blank','width=400px,height=300px');
			//openSnsWin(opensns);
			//BitlyClient.shorten('http://www.dailian.co.kr/news/news_view.htm?id=293718', 'BitlyCB.shortenResponse');
		}else if(type == "wifi"){
			opensns += "http://me2day.net/posts/new?new_post[body]=";
			opensns += "\""+snsTitle+"\":"+snsUrl;
			opensns += "&new_post[tags]="+snsCopy;
			openSnsWin(opensns);
			//window.open(opensns,'blank','width=400px,height=300px');
		}else if(type == "print"){
			var initBody = document.body.innerHTML;
			/*window.onbeforeprint = function(){
				//document.body.innerHTML = getElementById('container').innerHTML;
				document.body.innerHTML = $(".l-cont").html();
			}
			window.onafterprint = function(){
				document.body.innerHTML = initBody
			}*/
			document.body.innerHTML = $(".contents").html();
			window.print(); 
		}

	}
</script>


<div class="c-sns">
	<a href="javascript:_sns2('twitter','${menutitle}');"><img src="/usr/image/common/icon/icon_twitter03.gif" alt="트위터" /></a>
	<a href="javascript:_sns2('facebook','${menutitle}');"><img src="/usr/image/common/icon/icon_facebook03.gif" alt="페이스북" /></a>
	<a href="javascript:_sns2('wifi');"><img src="/usr/image/common/icon/icon_wifi.gif" alt="RSS" /></a>
	<a href="javascript:_sns2('print');"><img src="/usr/image/common/icon/icon_print.gif" alt="프린트" /></a>
</div>  