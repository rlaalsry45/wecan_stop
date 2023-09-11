$(document).ready(function(){
	$('.toggle_view').on("click", function() {
		//console.log($(this).closest("ul"));
		if($(this).closest("ul").hasClass("view_open") == false) {
			showSubView($(this));
			$(this).closest("ul").addClass("view_open");
		} else {
			hideSubView($(this));
			$(this).closest("ul").removeClass("view_open");
		}
	});
	$('#view_all').on("click", function() {
		if($(this).hasClass("all-view_open") == false) {
			$('.btn_view_b').each(function() {
				showSubView($(this));
				$(this).closest("ul").addClass("view_open");
			});
			$(this).addClass("all-view_open");
		} else {
			$('.btn_view_b').each(function() {
				hideSubView($(this));
				$(this).closest("ul").removeClass("view_open");
			});
			$(this).removeClass("all-view_open");
		}
	});
});

function showSubView(obj) {
	var isu_id = null;
	obj.closest("ul").find("li.subject > a").css({'font-weight':'bold', 'color':'orange', 'font-size':'14px'});
	var view_table = obj.closest(".list-type-new").find(".board-list");
	//view_table.find("tbody").empty("tr");
	view_table.css('display', 'block');
	isu_id = obj.closest("ul").attr("id");
	//console.log(view_table.find("tbody > tr").length);
	if(view_table.find("tbody > tr").length == 0) {
		getArticle(view_table, isu_id);
	}
}

function hideSubView(obj) {
	obj.closest("ul").find("li.subject > a").css({'font-weight':'normal', 'color':'#000cff', 'font-size':'13px'});
	var view_table = obj.closest(".list-type-new").find(".board-list");
	//view_table.find("tbody").empty("tr");
	view_table.css('display', 'none');
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
					cont += "<tr>" +
							"<td class='subject'>" +
							"<a href='#' onclick='sendForm(\"" + data.articleList[i]['atcl_ID'] + "\")'>" +
							"[p." + data.articleList[i]['atcl_START'] + "] " + data.articleList[i]['atcl_NAME'] + 
							"</a>" +
							"</td>" +
							"<td>" + data.articleList[i]['atcl_AUTHOR'] + 
							"</td>" +
							//"<td>" +
							//"<img src='/usr/image/common/icon/icon_file.gif' alt='첨부파일' />" +
							//"</td>" +
							"</tr>";
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

function sendForm(no){
	var frm = document.frmJournalList;
	frm.art_id.value = no;
	var view_menu_no = frm.view_menu_no.value;
		//console.log(view_menu_no);
	if(view_menu_no) {
		frm.action = "/?menuno=" + frm.view_menu_no.value;
	} else {
		frm.action = "/journal/front/journalArticleView.html";
	}
	frm.submit();
}