<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script>
	$(function(){
				$.ajax({
					  type: 'POST',
					  url: "/front/archv/wecanNoticeList.html",
					  data:{emp_no : "main"},					  
					  success: function(result){
						  $("#mainNoticeAreaDiv").html(result);
					  },
					  error:function(e){
						  alert("조회중 오류가 발생하였습니다."+e.responseText  );
					  }
				});
	});

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

if(getCookie("wecanpopup2") !="Y"){
	window.open('/skin/popup/default/popup.html?popupno=4', 'wecanpopup2', 'width=480,height=504,left=0,top=0')
}
</script>
