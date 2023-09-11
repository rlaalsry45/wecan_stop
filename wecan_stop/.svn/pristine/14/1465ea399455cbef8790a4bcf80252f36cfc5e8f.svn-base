$(function(){
	$("#ju_search .add_jbtn a").click(function(event){
		$("#dong").val($("#dong").val().replace(/^\s+|\s+$/g,""));
		if ($("#dong").val().length==0) {
			alert("찾고자하는 주소를 입력하세요.");
			$("#dong").focus();
			return;
		}
		$(".search-resualt .search tbody").empty();
		$(".search-resualt .search tbody").append("<tr><td colspan='2' align='center'>조회중입니다.<br>네트워크 상태에 따라 시간이 소요될 수 있습니다.<br>빠른 검색을 위해 도로번호 및 지번을 정확히 입력하세요.</td></tr>");
//		var IE = !jQuery.support.boxModel ? "openapi" : "openapied";
		//var searchType = $(':radio[name="searchType"]:checked').val();
		//var query = [{name:'IE',value:IE},{name:'query',value:$("#dong").val()}];
		var query = [{name:'query',value:$("#dong").val()}];
		
		$.getJSON("/post.html",query,function(json){
			console.log(json);
			$(".search-resualt .search tbody").empty();
			if (json["postlist"].length==0){
//				if($("#searchType:checked").val() == "3"){
//					$(".search-resualt .search tbody").append("<tr><td colspan='2' align='center'>기록이 없습니다.<br />예) 삼성동 25</td></tr>");	
//				}else if($("#searchType:checked").val() == "1"){
//					$(".search-resualt .search tbody").append("<tr><td colspan='2' align='center'>기록이 없습니다.<br />예) 반포대로 58</td></tr>");
//				}else{
//					$(".search-resualt .search tbody").append("<tr><td colspan='2' align='center'>기록이 없습니다.<br />예) 국립중앙박물관</td></tr>");
//				}
				
				$(".search-resualt .search tbody").append("<tr><td colspan='2' align='center'>기록이 없습니다.<br />" +
						"- 도로명 + 건물번호 (예) 도움5로 19<br/>" +
						"- 건물명 (예) 우정사업본부<br/>" +
						"- 읍/면/동/리 + 지번 (예) 어진동 307-19<br/>" +
						"- 사서함 + 사서함번호 (예) 광화문우체국사서함 45<br/>" +
						"</td></tr>");
				
			}
			else{
				$.each(json["postlist"],function(idx,item){
					$.each(item, function(key, value){
						$(".search-resualt .search tbody").append(
							'<tr>\
							<td><a href="#">'+key+'</a></td>\
							<td>'+value+'</td>\
						</tr>'
						);
					});
				});
				$(".search-resualt .search a").bind("click", function(){
					var initial = $("#initial").val();
					//self.opener.document.getElementById(initial+"useraddrno1").value = $(this).text().match(/^\d{3}/);
					//self.opener.document.getElementById(initial+"useraddrno2").value = $(this).text().match(/\d{3}$/);
					self.opener.document.getElementById(initial+"useraddrno1").value = $(this).text();
					self.opener.document.getElementById(initial+"useraddr").value = $(this).parent().next("td").text();
					self.opener.document.getElementById(initial+"useraddr2").focus();
					event.preventDefault();
					self.close();
				});
			}
		});
		event.preventDefault();
	});

	$("#ju_search .add_close a").click(function(event){
		self.close();
		event.preventDefault();
	});
	
	$("input").keypress(function(event) {
	    if (event.which == 13) {
	        event.preventDefault();
	        $("#ju_search .add_jbtn a").click();
	    }
	});
	
	$("input").focus();
});