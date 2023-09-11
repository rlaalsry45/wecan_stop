function getComment(survey, ask) {
	if(survey != null) {
			//console.log(survey);
		var params = "survey=" + survey + "&ask=" + ask;
		var canvas = $("#comment" + ask);
		$.ajax({
			type : "POST", 
			data : params, 
			datatype:"json", 
			cache : false, 
			url : "/survey/front/getCommentList.html", 
			success : function(data) {
				var cont = "";
				for (var i = 0; i <data.commentList.length; i++) {
					var num = i+1;
					if(num < 10) num = "0" + num;
					cont += "<li>" + num + ". " + data.commentList[i]['answer'] + "</li>";
				}
				if(cont == "") cont = "<li>등록된 답변이 없습니다.</li>";
				canvas.append(cont);
				cont = null;
			}, 
			error : function(data, status, err) {
				alert("서버와의 통신이 실패했습니다.");
				return;
			}
		}); 
	} else {
		alert("잘못된 호출 입니다.");
	}
}
function check_expired(expiredTime, href_url) {
	if(expiredTime == "true") {
		alert("설문조사 기간이 만료되었습니다.");
	} else {
		location.href = href_url;
	}
}