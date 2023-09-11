$(document).ready(function(){
	$('.toggle_view').on("click", function() {
		var sub_obj = $(this).closest("tr").find("ul.sub_col");
		// sub_obj.css('border', '5px solid red'); return;
		if(sub_obj.hasClass("view_open") == false) {
			showSubView(sub_obj);
			sub_obj.addClass("view_open");
		} else {
			hideSubView(sub_obj);
			sub_obj.removeClass("view_open");
		}

	});
	$('#view_all').on("click", function() {
		if($(this).hasClass("all-view_open") == false) {
			$('ul.sub_col').each(function() {
				showSubView($(this));
				$(this).addClass("view_open");
			});
			$(this).addClass("all-view_open");
		} else {
			$('ul.sub_col').each(function() {
				hideSubView($(this));
				$(this).removeClass("view_open");
			});
			$(this).removeClass("all-view_open");
		}
	});

});

function showSubView(obj) {
	var isu_id = null;
	obj.closest("td.title_col").find("ul > li.isu_title").find("a").addClass("toggle_txt");
	obj.closest("table").find("td").addClass("collapse");
	obj.css('display', 'block');
	isu_id = obj.attr("id");
	if(obj.find("li").length == 0) {
		getArticle(obj, isu_id);
	}
}

function hideSubView(obj) {
	obj.closest("td.title_col").find("ul > li.isu_title").find("a").removeClass("toggle_txt");
	obj.closest("table").find("td").removeClass("collapse");
	obj.css('display', 'none');
}

function getArticle(obj, isu_id) {
	if(isu_id != null) {
			//console.log(isu_id);
		var params = "isu_id=" + isu_id;
		var canvas = obj;
		$.ajax({
			type : "POST", 
			data : params, 
			datatype:"json", 
			cache : false, 
			url : "/journal/front/getArticleList.html", 
			success : function(data) {
				//console.log(isu_id);
				var cont = "";
				for (var i = 0; i <data.articleList.length; i++) {
					cont += "<li class='art_title'>" +
							"<span class='page_num'>[p." + data.articleList[i]['atcl_START'] + "]</span> " +
							"<a href='#' class='atcl_name'>" + data.articleList[i]['atcl_NAME'] + "</a>" +
							"<a href='#line_" + isu_id + "' class='btn-small6' onClick=\"updateUisSpecial($(this), '" + data.articleList[i]['isu_ID'] + "','" + data.articleList[i]['atcl_ID'] + "')\"" +
							"alt='특집으로 지정'>" + "SPECIAL" + "</a>" +
							"</li>" +
							"<li class='author'>" + data.articleList[i]['atcl_AUTHOR'] + 
							"</li>";
				}
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

function updateUisSpecial(obj, isu_id, atcl_id) {
		// console.log(obj); 
	if(atcl_id != null) {
			// console.log(atcl_id); //return;
		var params = "isu_id=" + isu_id + "&atcl_id=" + atcl_id;
		// var canvas = obj.closest("tr").find("td.specialist > span");
		var canvas = obj.closest("tr");
		$.ajax({
			type : "POST", 
			data : params, 
			datatype:"json", 
			cache : false, 
			url : "/admsys/journal/updateUisSpecial.html", 
			success : function(data) {
					// console.log(data); return;
				if(data.data == "1") {
					alert("수정하였습니다.");
					getIssueSpecialInfo(canvas, atcl_id);
					// location.reload();
					return;
				} else {
					console.log("Failed");
				}
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

function getIssueSpecialInfo(obj, atcl_id) {
	if(atcl_id != null) {
			//console.log(isu_id);
		var params = "atcl_id=" + atcl_id;
		var tit_canv = obj.find(".toggle_txt");
		var aut_canv = obj.find("td.specialist > span");
			// console.log(tit_canv); console.log(aut_canv); return;
		$.ajax({
			type : "POST", 
			data : params, 
			datatype:"json", 
			cache : false, 
			url : "/admsys/journal/getIssueSpecial.html", 
			success : function(data) {
				var title = data.issueSpecial['isu_TITLE'];
				var author = data.issueSpecial['isu_SPECIALIST'];
					// console.log(author); return;
				tit_canv.text(title);
				aut_canv.text(author);
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

function getJournalInfo(jnl_id,isu_year,isu_id, type){
	
	if(type == 'book'){
		window.open('/admsys/journal/journalArticleView.html?jnl_id='+jnl_id+'&isu_type=book&isu_id='+isu_id,'','width=800,height=616,top=50,left=50,scrollbars=yes');
	}else{
		window.open('/admsys/journal/journalArticleList.html?jnl_id='+jnl_id+'&isu_year='+isu_year+'&isu_id='+isu_id,'','width=800,height=616,top=50,left=50,scrollbars=yes');
	}
	
	
}

/*
function getIssueAuthorInfo(obj, atcl_id) {
	if(atcl_id != null) {
			//console.log(isu_id);
		var params = "atcl_id=" + atcl_id;
		var canvas = obj;
		$.ajax({
			type : "POST", 
			data : params, 
			datatype:"json", 
			cache : false, 
			url : "/admsys/journal/getIssueAuthor.html", 
			success : function(data) {
				var author = data.issueAuthor['isu_SPECIALIST'];
					// console.log(author); return;
				canvas.text(author);
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
*/