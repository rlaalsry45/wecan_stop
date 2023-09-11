$(function () {

    $.fn.setHidden = function (n, v) {
        if ($("input[name='" + n + "']", $(this)).length > 0) $("input[name='" + n + "']", $(this)).val(v);
        else $("<input>").attr("type", "hidden").attr("name", n).val(v).appendTo($(this));
    };

    $.fn.getHidden = function (n) {
        return $("input[name='" + n + "']", $(this)).val();
    };

    var frm     = null;
    var nextObj = null;
    /*
     $.fn.selArea = function(i,f){
     frm = $(f).closest("form");
     if (i=="3"){
     $("#txtarea",frm).hide();
     $("#editorarea",frm).show();
     $("#editorarea",frm).load("/var/editor/bbseditor.htm");
     }
     else{
     $("#txtarea",frm).show();
     $("#editorarea",frm).hide();
     }
     };
     */
    var options = {
        success : function (item) {
            //console.log(item);
            var act = frm.getHidden('act');
            if (item["msg"]) {
                if (act == "attachdel") {
                    if (confirm(item["msg"])) {
                        frm.setHidden('flag', '1');
                        frm.ajaxSubmit(options);
                        return false;
                    }
                }
                else if (act == "setsecret") {
                    var bbspasswd = window.prompt(item["msg"], '');
                    if (bbspasswd == null || bbspasswd.replace(/^\s+|\s+$/g, "") == "") {
                        $("[name='bbssecret']", frm).removeAttr("checked");
                    }
                    else {
                        frm.setHidden('bbspasswd', bbspasswd);
                    }
                }
                else {
                    alert(item["msg"]);
                    if (act == "write" || act == "edit" || act == "reply") {
                        $(":input[name='" + item["field"] + "']", frm).focus();
                    }
                }
            }
            else {
                if (act == "cate") {
                    if (nextObj) {
                        //console.log(item);
                        var cnt = 0;
                        for (var k in item) {
                            var str = item[k];
                            if (cnt > 0) nextObj = nextObj.next("select[name^='cates']");
                            if (str.length > 0) {
                                $.each(str, function (index, element) {
                                    nextObj.append("<option value='" + element["cno"] + "'>" + element["cname"] + "</option>");
                                });
                            }
                            cnt++;
                            nextObj.show();
                        }
                        nextObj.nextAll("select[name^='cates']").hide();
                    }
                }
                else {
                    if (act == "write") {
                        frm.setHidden("act", "list");
                        frm.setHidden("cates", "");
                        frm.setHidden("after_write", "after_write");
                        frm.setHidden("pageIndex", "1");
                    }
                    else if (act == "edit" || act == "reply") {
                        frm.setHidden("bbshit", 0);
                        frm.setHidden("after_write", "after_write");
                        frm.setHidden("bbsno", item["bbsno"]);
                        frm.setHidden("act", "view");

                    }
                    else if (act == "attachdel") {
                        frm.setHidden("bbshit", 0);
                        frm.setHidden("act", "edit");
                    }
                    if (frm.getHidden("editoryn") == "1") frm.submit();//Editor.save();
                    else frm.submit();
                }
            }
        },
        url     : "/skin/board/Valid.html",
        type    : 'post',
        dataType: 'json'
        //clearForm    : true,
        //resetForm    : true
    };

    $.fn.submitForm = function (f, a, n) {
        frm = $(f).closest("form");
        //alert($(f).prop("tagName"));
        frm.setHidden('act', a);
        if (a == "write" || a == "edit" || a == "reply") {
            if (frm.getHidden("editoryn") == "1") $("textarea[name='bbsconts']", frm).val("<p>"+CKEDITOR.instances.bbsconts.document.getBody().getHtml()+"</p>");
            if (a != "write") frm.setHidden('bbsno', n);
            frm.ajaxSubmit(options);
            return false;
        }
        else if (a == "attachdel") {
            if (n.split("^")[0] == '0') {
                var obj = $(f).parent().find(":file");
                obj.after(obj.clone(true).val(""));
                obj.remove();
            }
            else {
                frm.setHidden('bbsno', n.split("^")[1]);
                frm.setHidden('fno', n.split("^")[0]);
                frm.setHidden('flag', '0');
                frm.ajaxSubmit(options);
            }
            return false;
        }
        else if (a == "down") {
            frm.setHidden('fno', n);
            var frmaction = frm.attr("action");
            frm.attr("action", "/skin/board/Valid.html");
            if (frm.getHidden("editoryn") == "1") frm.submit();//Editor.save();
            else frm.submit();
            $(f).text($(f).text().replace(/\[(\d+)\]$/g, function ($0, $1) {
                return "[" + (++$1) + "]";
            }));
            frm.attr("action", frmaction);
        }
        else if (a == "setsecret") {
            frm.setHidden('bbspasswd', '');
            frm.setHidden('bbsno', n);
            if ($("[name='bbssecret']:checked", frm).length > 0) {
                frm.ajaxSubmit(options);
                return false;
            }
        }
        else if (a == "cate") {
            if ($(f).nextAll("select[name^='cates']").length > 0) {
                nextObj = $(f).next("select[name^='cates']");
                $.each($(f).nextAll("select[name^='cates']"), function (idx, item) {
                    if ($("option:first", $(item)).val() != '') $("option", $(f).nextAll("select[name^='cates']")).remove();
                    else $("option:not(:first)", $(f).nextAll("select[name^='cates']")).remove();
                });
                frm.setHidden('cno', $(f).val());
                frm.ajaxSubmit(options);
                return false;
            }
        }
        else {
            $("select[name^='cates']", frm).empty();
            frm.setHidden("key", "bbstitle");
            frm.setHidden("keword", "");
            frm.setHidden("pageIndex", "1");
            if (frm.getHidden("editoryn") == "1") frm.submit();//Editor.save();
            else frm.submit();
        }
    };
});

var submitForm = function (f, a, n) {
    console.log("f:" + f + " a:" + a + " n:" + n);
    $().submitForm(f, a, n);
    return a == "setsecret" ? true : false;
};
try {
	var sorg1 = document.getElementById('preview1').src;
	//썸네일이미지 삭제
	function removeImg1() {
	    document.getElementById('thumb').outerHTML = document.getElementById('thumb').outerHTML;
	    document.getElementById('preview1').src    = sorg1;
	    document.getElementById('thumb').onchange  = function () {
	        readURL1(this);
	    };
	}
	function readURL1(input) {
	    if (input.files && input.files[0]) {
	        var reader    = new FileReader();
	        reader.onload = function (e) {
	            document.getElementById('preview1').src = e.target.result;
	        };
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	document.getElementById('thumb').onchange = function () {
	    readURL1(this);
	};
}catch(e){}

function addFee() {
    var tblappend = $("li[name=cal]").length;
    var feeno     = tblappend + 1;

    $("#cal_zone").append('<li id="cal' + feeno + '" name="cal">\
 			\n제목 :<input id="ctitle' + feeno + '"  name="ctitle"type="text" style="width:230px;height:17px" />\
 			\n시작 :<input id="sdate' + feeno + '"  name="sdate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:\'yyyyMMddHHmm\'})" readonly />\
 			\n종료 :<input id="edate' + feeno + '" name="edate" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:\'yyyyMMddHHmm\'})" readonly />\
 			\n</li>');
}
function delFee() {
    var tblappend = $("li[name=cal]").length;
    if (tblappend > 1)
        $("#cal" + tblappend).remove();
}
