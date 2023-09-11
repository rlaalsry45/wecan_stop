<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<style type="text/css">
	#wrap{position:relative; width:100%;}

	a, a:hover, a:visited { text-decoration:none; }
	ul li { list-style : none; }

	#main_bn {
		margin:0 auto;
		width:450px;
		height:338px;
	}
	#main_bn img {
		width:100%;
		height:auto;
	}
    #main_bn_btn {
        list-style-type:none;
		position:absolute;
		bottom:5px; left:5px;
    }
    #main_bn_btn span {
        float: left; display:inline-block; width:20px; height:20px; margin-right:5px; 
    }
</style>

<script>

function getCookie(name) 
{ 
    var obj = name + "="; 
    var x = 0; 
    while ( x <= document.cookie.length ) 
    { 
       var y = (x+obj.length); 
       if ( document.cookie.substring( x, y ) == obj ) 
       { 
          if ((endOfCookie=document.cookie.indexOf( ";", y )) == -1 ) 
               endOfCookie = document.cookie.length;
          return unescape( document.cookie.substring( y, endOfCookie ) ); 
       } 
       x = document.cookie.indexOf( " ", x ) + 1; 
            
       if ( x == 0 ) break; 
    }
    return ""; 
}

if(getCookie("divpop2") !="Y"){
	window.open('/skin/popup/default/popup.html?popupno=6', 'winpopup2', 'width=490,height=675,left=100,top=0')
}

</script>
