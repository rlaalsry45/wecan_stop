$(function(){
	$("#ju_search .add_jbtn a").click(function(event){
		$(".search-resualt .search tbody").empty();
		$(".search-resualt .search tbody").append("<tr><td colspan='2' align='center'>조회중입니다...</td></tr>");
		var IE = $.browser.msie ? "openapi" : "openapied";
		var query = [{name:'act',value:'post'},{name:'IE',value:IE},{name:'query',value:$("#dong").val()}];
		$.getJSON("/skin/member/default/post.html",query,function(json){
			//console.log(json);
			$(".search-resualt .search tbody").empty();
			if (json["postlist"].length==0){
				$(".search-resualt .search tbody").append("<tr><td colspan='2' align='center'>기록이 없습니다.</td></tr>");
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
					self.opener.document.getElementById("useraddrno1").value = $(this).text().match(/^\d{3}/);
					self.opener.document.getElementById("useraddrno2").value = $(this).text().match(/\d{3}$/);
					self.opener.document.getElementById("useraddr1").value = $(this).parent().next("td").text();
					self.opener.document.getElementById("useraddr2").focus();
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
});