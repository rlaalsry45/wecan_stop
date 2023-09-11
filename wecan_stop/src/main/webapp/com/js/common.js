(function($){
    $.setCookie = function(name, value, expiredays){
        var todayDate = new Date();
        todayDate.setDate( todayDate.getDate() + expiredays );
        document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
    },
    $.getCookie = function(name){
        var found = false, start, end, i = 0;
        while(i <= document.cookie.length) {
            start = i;
            end = start + name.length;

            if(document.cookie.substring(start, end) == name) {
               found = true;
               break;
            }
            i++;
        }
        if(found == true) {
            start = end + 1;
            end = document.cookie.indexOf(";", start);
            if(end < start)
                end = document.cookie.length;
            return document.cookie.substring(start, end);
        }
        return "";
    },
    $.isEmpty = function(str){
        if(str == null || str.replace(/ /gi,"") == ""){
            return true;
        }
        return false;
    },
    $.getByteLen = function(str){
        var byteLength = 0;
        for (var inx = 0; inx < str.length; inx++) {
            var oneChar = escape(str.charAt(inx));
            if ( oneChar.length == 1 ) {
                byteLength ++;
            } else if (oneChar.indexOf("%u") != -1) {
                byteLength += 3;
            } else if (oneChar.indexOf("%") != -1) {
                byteLength += oneChar.length/3;
            }
        }
        return byteLength;
    },
    $.modalDialog = function(type, msg, func){
        var icon = (type === "error") ? "alert" : "info";
        var msgHtml = '<p>'
            + '<span class="ui-icon ui-icon-'+icon+'" style="float: left; margin: 0 7px 50px 0;"></span>'
            + msg
            + '</p>';
        $("#dialog-message").html(msgHtml);
        $( "#dialog-message" ).dialog({
            title : "동부손사",
            modal : true,
            buttons : [
                {
                    text: "확인",
                    click: function() {
                        $( this ).dialog( "close" );
                        if(func !== undefined) func();
                        //$(this).dialog( "destroy" );
                    }
                }
            ]
        });

    },

    $.excelUpload = function(option){
        var set = {
                param : {}
        };
        set = $.extend({}, set, option);
        if($("form[name='excelUp']").length == 0){
            var form = $('<form name="excelUp" method="post" action="/excelUploadServlet" enctype="multipart/form-data" target="excelup_ifr" />');
            $.each(set.param, function(k, v){
                form.append('<input type="hidden" name="'+k+'" value="'+v+'"/>');
            });
            form.append('<input type="file" class="file" name="upload" id="upload" />');
            $("#dialog-message").html("").append(form);
            $("body").append('<iframe id="excelup_ifr" name="excelup_ifr" src="about:none" style="width:0px;height:0px;"></iframe>');
        }

        $( "#dialog-message" ).dialog({
            height : 80,
            title : "엑셀업로드",
            resizable: false,
            close: function( event, ui ) {

            }
        });
        $("#upload").change(function(){
            var file = $(this).val().replace(/\\/g, "/");
            fileName = file.substring((file.lastIndexOf("/")+1));
            format = fileName.substring((fileName.lastIndexOf(".")+1));
            if(format.toLowerCase() === "xls" || format.toLowerCase() === "xlsx"){
                $("form[name='excelUp']").submit();

                $( "#dialog-message" ).dialog( "close" );
            }else{
                alert("엑셀 파일만 업로드 가능합니다.");
            }
        });
    },

    $.excelDownload = function(option){
        var set = {
                url : "",
                param : {},
                fileName : ""
        };
        set = $.extend({}, set, option);
        if($("form[name='exceldown']").length == 0){
            var form = $('<form name="exceldown" method="post" action="'+set.url+'" target="exceldown_ifr" />');
            $.each(set.param, function(k, v){
                form.append('<input type="hidden" name="'+k+'" value="'+v+'"/>');
            });
            form.append('<input type="hidden" name="fileName" value="'+set.fileName+'"/>');
            $("body").append(form);
        }
        if($("#exceldown_ifr").length == 0) $("body").append('<iframe id="exceldown_ifr" name="exceldown_ifr" src="about:none" style="width:0px;height:0px;"></iframe>');
        $("form[name='exceldown']").submit();
    },

    $.erAjaxSubmit = function(option){
        var set = {
                url : "",
                param : {},
                success : null,
                complate : null
        };
        set = $.extend({}, set, option);
        $("#clickBlocking").show();
        $.post(
            set.url,
            set.param,
            function(data){
                var jsonData = jQuery.parseJSON(data);
                if(set.success !== null) set.success(jsonData);
            }
        )
        .complete(function(jqXHR, textStatus){
            $("#clickBlocking").hide();
            if(set.complate !== null) set.complate(jqXHR, textStatus);
        });
    },

    $.fn.ajaxCode = function(option, selected){
        return this.each(function(){
            var set = {
                    width : 0,
                    type : "domain",
                    domain : "",
                    input : "select",
                    firstOption : null,
                    selection : null
            };
            set = $.extend({}, set, option);
            var ts = $(this);
            var url = (set.type === "domain") ? "/common/domainAjaxSearchList.action" : "/common/codeAjaxSearchList.action";
            $.ajaxSetup({ cache: false });
            $.post(
                    url,
                    {cdDmnId : set.domain},
                    function(data){
                        var jsonData = jQuery.parseJSON(data);
                        if(set.input === "select"){
                            if(set.firstOption != null){
                                ts.remove("option");
                                ts.append('<option value="'+set.firstOption.value+'">'+set.firstOption.name+'</option>');
                            }else{
                                ts.find("option:gt(0)").remove("option");
                            }
                            if(jsonData.result === "success"){
                                $.each(jsonData.list, function(i, obj){
                                    var id = (set.type === "domain") ? obj.cdDmnId : obj.cdId;
                                    var name = (set.type === "domain") ? obj.cdDmnNm : obj.cdNm;
                                    ts.append('<option value="'+id+'"'+((selected === id) ? ' selected="selected"':'')+'>'+name+'</option>');
                                });
                                if(set.selection != null){
                                    ts.on("change", function(){
                                        var val = $(this).val();
                                        set.selection(val);
                                    });
                                }
                            }
                        }else if(set.input === "checkbox" || set.input === "radio"){
                            $.each(jsonData.list, function(i, obj){
                                var id = (set.type === "domain") ? obj.cdDmnId : obj.cdId;
                                var name = (set.type === "domain") ? obj.cdDmnNm : obj.cdNm;
                                var sel = (selected === undefined || selected.indexOf(id) == -1) ? "" : " checked=\"checked\"";
                                var ip = $('<input type="'+set.input+'" name="'+ts.attr("id")+'" id="'+ts.attr("id")+i+'" value="'+id+'" title="'+name+'" '+sel+'/>');
                                var lb = $('<lable for="'+ts.attr("id")+i+'">'+name+'</lable>');
                                ip.after(lb).click(function(){
                                    set.selection(id);
                                });
                                ts.append(ip);
                            });
                        }else if(set.input === "customSel"){
                            if(set.firstOption != null){
                                ts.append('<input type="hidden" name="'+ts.attr("id")+'" value=""/>');
                            }
                            var newObj = [];
                            if(set.firstOption != null){
                                newObj.push({name:set.firstOption.name, value:set.firstOption.value});
                            }
                            $.each(jsonData.list, function(i, obj){
                                var value = (set.type === "domain") ? obj.cdDmnId : obj.cdId;
                                var name = (set.type === "domain") ? obj.cdDmnNm : obj.cdNm;
                                newObj.push({name:name, value:value});
                            });
                            ts.append('<ul class="selList" style="display:none;" />');
                            $.each(newObj, function(i, obj){
                                if(obj.value === selected){
                                    ts.find("input[name='"+ts.attr("id")+"']").val(obj.value);
                                    ts.find("input[name='"+ts.attr("id")+"']").after('<a href="#empty-anchor" title="선택">'+obj.name+'</a>');
                                }else{
                                    var li = $('<li><a href="#empty-anchor" title="선택" id="'+ts.attr("id")+'_'+obj.value+'">'+obj.name+'</a></li>');
                                    ts.find("ul").append(li);
                                }
                            });
                            if(set.width > 0){
                                ts.css("width", set.width+"px");
                                ts.find("a").css("width", (set.width-35)+"px");
                            }
                            ts.find("input[name='"+ts.attr("id")+"']").next("a").on("click", function(){
                                if(ts.find("ul").css("display") === "none") ts.find("ul").show();
                                else ts.find("ul").hide();
                                return false;
                            });
                            ts.find("ul").find("a").on("click", function(){
                                var sn = ts.find("input[name='"+ts.attr("id")+"']").next("a").text();
                                var sv = ts.find("input[name='"+ts.attr("id")+"']").val();
                                var id = $(this).attr("id").split("_");
                                ts.find("input[name='"+ts.attr("id")+"']").next("a").text($(this).text());
                                ts.find("input[name='"+ts.attr("id")+"']").val(id[id.length-1]);
                                $(this).text(sn);
                                $(this).attr("id", ts.attr("id")+"_"+sv);
                                ts.find("ul").hide();
                                ts.find("input[name='"+ts.attr("id")+"']").next("a").focus();
                                return false;
                            });
                        }
                    }
            );
        });
    },

    $.fn.erFileUpload = function(option){
        return this.each(function(){
            var set = {
                    multiple : false,
                    width : 0,
                    height : 0,
                    allowExtension : ["doc","docx","hwp","jpg","gif","pdf","ppt","pptx","xls","xlsx","zip","png","txt"]
            };
            set = $.extend({}, set, option);
            var extension = "";
            var tsid = $(this).attr("id"), ts = $(this), changeChk = false;
            var width = (set.width == 0) ? $(this).width()+71 : set.width;
            var height = (set.height == 0 || !set.multiple) ? 20 : set.height;
            var inputwrap = $('<div id="er-uploader_iwrap_'+tsid+'" style="position:relative;margin:0;padding:0;"></div>');
            var btnspan = $('<span style="display:block;width:0px;maring:0;padding:0;text-indent:-9999px;overflow:hidden;">파일 업로드</span>');
            var btnAdd = $('<a id="er-uploader_add_'+tsid+'" href="#empty-anchor" id="ff" title="파일 업로드" style="display:block;width:64px;height:23px;margin:0;margin-left:5px;padding:0;background:url(/cms/image/btn_file_add.png);" />');
            btnAdd.append(btnspan).css({"position":"absolute","top":"0px","left":(ts.width()+5)+"px"});
            var wrap = $('<div id="er-uploader_outbox_'+tsid+'" style="position:relative;margin:0;padding:0;width:'+width+'px;"></div>');
            ts.wrap(wrap);
            ts.wrap(inputwrap);
            var fhcss = {height:"20px"};
            if($.browser.msie) fhcss.margin = "1px 0px 1px";
            ts.css(fhcss).after(btnAdd);
            ts.keypress(function(e){
                if(e.which == 13) $(this).trigger("click");
            })
            .change(function(){
                if($(this).val() !== "") changeChk = true;
                var file = $(this).val().replace(/\\/g, "/");
                fileName = file.substring((file.lastIndexOf("/")+1));
                extension = fileName.substring((fileName.lastIndexOf(".")+1));
            });

            var pgl = $('<div id="er-uploader_progresslabel_'+tsid+'" style="position: absolute;left: 45%;top: 1px;font-size:11px;font-weight: bold;text-shadow: 1px 1px 0 #fff;">Loading...</div>');
            var overlay = $('<div id="er-uploader_overlay_'+tsid+'" style="display:none;height: 100%;background:url(/cms/image/animated-overlay.gif) repeat-x;filter: alpha(opacity=25);opacity: 0.25" />');
            var pgvalue = $('<div id="er-uploader_value_'+tsid+'" style="display:none;width:0%;height:100%;background: #cccccc url(/cms/image/ui-bg_highlight-soft_75_cccccc_1x100.png) 50% 50% repeat-x;"/>');
            var pgb = $('<div id="er-uploader_progressbar_'+tsid+'" style="position:relative;display:none;height:18px;border:1px solid #ccc;border-radius:3px;background: #ffffff url(/cms/image/ui-bg_flat_75_ffffff_40x100.png) 50% 50% repeat-x;" />').append(pgl).append(overlay).append(pgvalue);
            $("#er-uploader_outbox_"+tsid).append(pgb);

            var flistul = $('<table cellpadding="0" cellspacing="0" style="table-layout:fixed;width:'+(width-18)+'px;border:0;margin:0;padding:0;font-family:dotum,Helvetica,sans-serif;font-size:12px;"><tbody></tbody></table>');
            var flistbox = $('<div id="er-uploader_list_'+tsid+'" style="position:relative;width:'+width+'px;height:'+height+'px;margin:0;padding:0;vertical-align:top;border:1px solid #ccc;overflow:hidden;overflow-y:auto;background-color:#fff;" tabindex="0" />').append(flistul);
            $("#er-uploader_outbox_"+tsid).append(flistbox);

            $('<iframe id="er-uploader_ifr_'+tsid+'" name="er-uploader_ifr_'+tsid+'" src="about:none" style="width:0px;height:0px;"></iframe>').appendTo("body");

            //erUpload/ErFileUploadServlet
            var action = (ts.parents("form").attr("action") === undefined) ? "" : ts.parents("form").attr("action");
            var target = (ts.parents("form").attr("target") === undefined) ? "" : ts.parents("form").attr("target");
            $("#er-uploader_add_"+tsid).click(function(){
                if(!changeChk){
                    alert("업호드할 파일을 선택해 주세요.");
                    ts.focus();
                    return false;
                }
                if(jQuery.inArray(extension.toLowerCase(), set.allowExtension) == -1){
                    alert("["+set.allowExtension.join(",")+"] 형식의 파일만 업로드가 가능합니다.");
                    ts.focus();
                    return false;
                }
                if(!set.multiple && $("#er-uploader_list_"+tsid+" > table > tbody > tr").length > 0){
                    alert("이미 업로드 되어 있는 파일을 삭제하시고 업로드해 주세요.");
                    $("#er-uploader_list_"+tsid+" > table > tbody > tr").find("td:last").find("a").focus();
                    return false;
                }
                ts.parents("form").append('<input type="hidden" name="erFileUpName" value="'+tsid+'"/>');
                ts.parents("form").attr("action", "/erUpload/ErFileUploadServlet").attr("target", "er-uploader_ifr_"+tsid);
                ts.parents("form").submit();
                $("#er-uploader_progressbar_"+tsid).css("display", "block");
                $("#er-uploader_value_"+tsid).css("display", "none");
                $("#er-uploader_overlay_"+tsid).css("display", "block");
                $("#er-uploader_progresslabel_"+tsid).text("Loading...");
                $("#er-uploader_add_"+tsid).attr("disabled", true);

                $.ajaxSetup({ cache: false });
                //jQuery.globalEval("var erup = '"+tsid+"';");
                jQuery.globalEval("var erupact"+tsid+" = '"+action+"';");
                jQuery.globalEval("var eruptgt"+tsid+" = '"+target+"';");
                getProgress(true, tsid);

            });

        });

    };
})(jQuery);

function uploadSuccessAdd(id, org, alias, bytes){//er-uploader_list
    var add = '<tr style="height:18px;" id="'+alias+'">'
            + '<td style="overflow:hidden;white-space:nowrap; text-overflow:ellipsis;padding:0 0 0 3px !important;background:none;border:0;"><a href="/erUpload/ErFileDownloadServlet?aliasName='+alias+'&orgName='+org+'" target="er-uploader_ifr_'+id+'" title="다운로드" style="text-decoration:none;">('+bytes+')'+org+'</a></td>'
            + '<td style="width:17px;text-align:center;padding-right:3px;padding:0 !important;background:none;border:0;">'
            + '<a href="/erUpload/ErFileDeleteServlet?tg='+id+'&aliasName='+alias+'&orgName='+org+'" target="er-uploader_ifr_'+id+'" title="삭제" style="display:block;width:11px;height:11px;text-decoration:none;color:#999;border:1px solid #ccc;background:#fff url(/cms/image/del_file.png) no-repeat center center;"><span style="width:0px;text-indent:-9999px;overflow:hidden;">'+org+'</span></a>'
            + '</td>'
            + '</tr>';
    $("#er-uploader_list_"+id+" > table > tbody").append(add);
    $("input[name='"+id+"']").parents("form").append('<input type="hidden" name="er-uploader_aufn_'+id+'" value="'+alias+'/'+org+'/'+bytes+'" />');
}

function uploadFileDel(id, file, org){
    $("#er-uploader_list_"+id+" > table > tbody").find("tr[id='"+file+"']").remove();

    $("input[name='er-uploader_aufn_"+id+"']").each(function(){
        if($(this).val().indexOf(file) != -1){
            $(this).remove();
            return false;
        }
    });

    $("#er-uploader_list_"+id).focus();
}

function updateProgress(val, erup){
    $("#er-uploader_progresslabel_"+erup).text(val+"%");
    $("#er-uploader_value_"+erup).css("width",val+"%");
}

function getProgress(start, erup){
    var d = new Date();
    var n = d.getTime();
    $.ajax({
        url: "/erUpload/ErFileUploadServlet?_ttm="+n,
        cache: false,
        success: function(data) {
            if(start){
                $("#er-uploader_overlay_"+erup).css("display", "none");
                $("#er-uploader_value_"+erup).css("display", "block");
            }
            var percent = parseInt(data);
            if (percent<100){
                var v = parseInt($.browser.version.split(".")[0]);
                if($.browser.msie && v < 10){
                    window.setTimeout("getProgress("+false+", '"+erup+"')", 100);
                    window.setTimeout("updateProgress("+percent+", '"+erup+"')", 100);
                }else{
                    setTimeout(getProgress(false, erup), 100);
                    setTimeout(updateProgress(percent, erup), 100);
                }
            }else if(percent == 1000){
                alert("파일 업로드에 실패하였습니다.");
                $("input[name='"+erup+"']").parents("form").attr("action", eval("erupact"+erup));
                $("input[name='"+erup+"']").parents("form").attr("target", eval("eruptgt"+erup));
                $("#er-uploader_add_"+erup).removeAttr("disabled");
                $("#er-uploader_progressbar_"+erup).css("display", "none");
                $("#er-uploader_overlay_"+erup).css("display", "none");
                $("#er-uploader_value_"+erup).css("display", "none").css("width", "");
                $("#er-uploader_progresslabel_"+erup).text("Loading...");
                $("input[name='"+erup+"']").focus();
                return false;
            }else{
                updateProgress(100, erup);
                $("input[name='"+erup+"']").parents("form").attr("action", eval("erupact"+erup));
                $("input[name='"+erup+"']").parents("form").attr("target", eval("eruptgt"+erup));
                $("#er-uploader_add_"+erup).removeAttr("disabled");
                $("#er-uploader_progressbar_"+erup).css("display", "none");
                $("#er-uploader_overlay_"+erup).css("display", "none");
                $("#er-uploader_value_"+erup).css("display", "none").css("width", "");
                $("#er-uploader_progresslabel_"+erup).text("Loading...");
            }
        }
    });
}

function excelUploadResult(result, grid, message){
    alert(message);
    if(result === "success"){
        $("#excelup_ifr").remove();
        $( "#dialog-message" ).html("");
        $( "#dialog-message" ).dialog( "destroy" );
        $("#"+grid).trigger("reloadGrid");
    }
}

attchFileFormat = function(value, options, rowObject){
    var ext = (value === "" || value === undefined) ? "" : value.substring(value.lastIndexOf(".")+1).toLowerCase();
    var r = "";
    if(ext !== ""){
        var icon = "text";
        if(ext.indexOf("doc") != -1) icon = "doc";
        else if(ext.indexOf("hwp") != -1) icon = "hwp";
        else if(ext.indexOf("pdf") != -1) icon = "pdf";
        else if(ext.indexOf("ppt") != -1) icon = "ppt";
        else if(ext.indexOf("xls") != -1) icon = "xls";
        else if(ext.indexOf("zip") != -1) icon = "zip";
        else if(ext.indexOf("jpg") != -1 || ext.indexOf("gif") != -1 || ext.indexOf("bmp") != -1 || ext.indexOf("png") != -1) icon = "jpg";

        r = '<img src="/usr/image/icon-'+icon+'.gif" alt="'+value+'"/>';
    }
    return r;
};

repleyFomatter = function(value, options, rowObject){
    var r = "";
    if(value.indexOf("REPLY") != -1){

        var i = parseInt(value.substring(0, value.indexOf("REPLY")))-1;
        r = '<span style="margin-left:'+(10*i)+';margin-right:5px;"><img src="/usr/image/reply.png" style="width:13px;" /></span>'+value.substring(value.indexOf("REPLY")+5);
    }else r = value;
    return r;
};

function PopUp(url, w, h, scroll){
    var winl=(screen.width-w)/2;
    var wint=(screen.height-h)/2;

    if(w=='100%') w=window.availWidth;
    if(!scroll) scroll='no';
    window.open(url,null,'width='+w+',height='+h+',top='+wint+',left='+winl+',resizable=no,scrollbars='+scroll+',toolbars=no,status=no,menu=no');
}

function dialogsPw(mode, id, seq, no, obj){
    if(mode === "view"){
        if($.getCookie(id) !== no){
            var ly = '<div id="layPw" class="layPops" style="width:340px;" tabindex="0">';
                ly+= '<div class="wrap">';
                ly+= '<dl>';
                    ly+= '<dt>비밀번호입력</dt>';
                    ly+= '<dd class="pwWrap">';
                        ly+= '<p class="txt">글을 작성하실 때 설정하신 비밀번호를 입력하셔야 <br />내용을 확인하실 수 있습니다. </p>';
                        ly+= '<div class="pwBox">';
                                ly+= '<label for="bbsWrtPw">비밀번호</label><input type="password" id="bbsWrtPw" name="bbsWrtPw" title="비밀번호" />';
                        ly+= '</div>';
                        ly+= '<div class="btns">';
                            ly+= '<a href="#empty-anchor" id="btnBbsPw"><img src="/usr/image/common/btn/btnt_confirm.gif" alt="확인" /></a>';
                            ly+= '<a href="#empty-anchor" id="dialogClose" title="팝업닫기"><img src="/usr/image/common/btn/btnt_cancel.gif" alt="취소" /></a>';
                        ly+= '</div>';
                    ly+= '</dd>';
                ly+= '</dl>';
                ly+= '<div class="close">';
                    ly+= '<a href="#empty-anchor" id="dialogClose"><img src="/usr/image/common/btn/btns_layclose.gif" alt="팝업닫기" /></a>';
                ly+= '</div>';
                ly+= '</div>';
                ly+= '</div>';


            $("#layPw").remove();
            $("#dialogShadow").show().after(ly);
            $("#layPw").focus();

            $("a[id='dialogClose']").click(function(){
                $("#dialogShadow").hide();
                $(obj).focus();
                $("#layPw").remove();
            });

            $("#btnBbsPw").click(function(){
                if($("#bbsWrtPw").val() === ""){
                    alert("비밀번호를 입력해 주세요.");
                    $("#bbsWrtPw").focus();
                    return false;
                }
                $.erAjaxSubmit({
                    url : "qnaPassword.action",
                    param : {bbsId:id, bbsPrtNo:no, bbsWrtPw:$("#bbsWrtPw").val()},
                    success : function(data){
                        if(data.result === "success"){
                            $.setCookie(id, no, 1);
                            $("form[name='searchFrm']").append('<input type="hidden" name="bbsNo" value="'+seq+'"/>');
                            $("form[name='searchFrm']").attr("action", "qnaView.action").attr("target", "_self");
                            $("form[name='searchFrm']").submit();
                        }else{
                            alert(data.message);
                            $("#bbsWrtPw").val("").focus();
                            return false;
                        }
                    }
                });
            });
        }else{
            $("form[name='searchFrm']").append('<input type="hidden" name="bbsNo" value="'+seq+'"/>');
            $("form[name='searchFrm']").attr("action", "qnaView.action").attr("target", "_self");
            $("form[name='searchFrm']").submit();
        }
    }else{
        var ly = '<div id="layPw" class="layPops" style="width:340px;" tabindex="0">';
        ly+= '<div class="wrap">';
        ly+= '<dl>';
            ly+= '<dt>비밀번호입력</dt>';
            ly+= '<dd class="pwWrap">';
                ly+= '<p class="txt">글을 작성하실 때 설정하신 비밀번호를 입력하셔야 <br />삭제 하실 수 있습니다. </p>';
                ly+= '<div class="pwBox">';
                        ly+= '<label for="bbsWrtPw">비밀번호</label><input type="password" id="bbsWrtPw" name="bbsWrtPw" title="비밀번호" />';
                ly+= '</div>';
                ly+= '<div class="btns">';
                    ly+= '<a href="#empty-anchor" id="btnBbsPw"><img src="/usr/image/common/btn/btnt_confirm.gif" alt="확인" /></a>';
                    ly+= '<a href="#empty-anchor" id="dialogClose" title="팝업닫기"><img src="/usr/image/common/btn/btnt_cancel.gif" alt="취소" /></a>';
                ly+= '</div>';
            ly+= '</dd>';
        ly+= '</dl>';
        ly+= '<div class="close">';
            ly+= '<a href="#empty-anchor" id="dialogClose"><img src="/usr/image/common/btn/btns_layclose.gif" alt="팝업닫기" /></a>';
        ly+= '</div>';
        ly+= '</div>';
        ly+= '</div>';


        $("#layPw").remove();
        $("#dialogShadow").show().after(ly);
        $("#layPw").focus();

        $("a[id='dialogClose']").click(function(){
            $("#dialogShadow").hide();
            $(obj).focus();
            $("#layPw").remove();
        });

        $("#btnBbsPw").click(function(){
            if($("#bbsWrtPw").val() === ""){
                alert("비밀번호를 입력해 주세요.");
                $("#bbsWrtPw").focus();
                return false;
            }
            $.erAjaxSubmit({
                url : "qnaDelete.action",
                param : {bbsId:id, bbsNo:seq, bbsWrtPw:$("#bbsWrtPw").val()},
                success : function(data){
                    if(data.result === "success"){
                        $("form[name='write']").attr("action", "qnaList.action").attr("target", "_self");
                        $("form[name='write']").submit();
                    }else{
                        alert(data.message);
                        $("#bbsWrtPw").val("").focus();
                        return false;
                    }
                }
            });
        });
    }
}


//if(typeof JSON!=="object"){JSON={}}(function(){function f(n){return n<10?"0"+n:n}if(typeof Date.prototype.toJSON!=="function"){Date.prototype.toJSON=function(key){return isFinite(this.valueOf())?this.getUTCFullYear()+"-"+f(this.getUTCMonth()+1)+"-"+f(this.getUTCDate())+"T"+f(this.getUTCHours())+":"+f(this.getUTCMinutes())+":"+f(this.getUTCSeconds())+"Z":null};String.prototype.toJSON=Number.prototype.toJSON=Boolean.prototype.toJSON=function(key){return this.valueOf()}}var cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,escapable=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,gap,indent,meta={"\b":"\\b","\t":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"},rep;function quote(string){escapable.lastIndex=0;return escapable.test(string)?'"'+string.replace(escapable,function(a){var c=meta[a];return typeof c==="string"?c:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})+'"':'"'+string+'"'}function str(key,holder){var i,k,v,length,mind=gap,partial,value=holder[key];if(value&&typeof value==="object"&&typeof value.toJSON==="function"){value=value.toJSON(key)}if(typeof rep==="function"){value=rep.call(holder,key,value)}switch(typeof value){case"string":return quote(value);case"number":return isFinite(value)?String(value):"null";case"boolean":case"null":return String(value);case"object":if(!value){return"null"}gap+=indent;partial=[];if(Object.prototype.toString.apply(value)==="[object Array]"){length=value.length;for(i=0;i<length;i+=1){partial[i]=str(i,value)||"null"}v=partial.length===0?"[]":gap?"[\n"+gap+partial.join(",\n"+gap)+"\n"+mind+"]":"["+partial.join(",")+"]";gap=mind;return v}if(rep&&typeof rep==="object"){length=rep.length;for(i=0;i<length;i+=1){if(typeof rep[i]==="string"){k=rep[i];v=str(k,value);if(v){partial.push(quote(k)+(gap?": ":":")+v)}}}}else{for(k in value){if(Object.prototype.hasOwnProperty.call(value,k)){v=str(k,value);if(v){partial.push(quote(k)+(gap?": ":":")+v)}}}}v=partial.length===0?"{}":gap?"{\n"+gap+partial.join(",\n"+gap)+"\n"+mind+"}":"{"+partial.join(",")+"}";gap=mind;return v}}if(typeof JSON.stringify!=="function"){JSON.stringify=function(value,replacer,space){var i;gap="";indent="";if(typeof space==="number"){for(i=0;i<space;i+=1){indent+=" "}}else{if(typeof space==="string"){indent=space}}rep=replacer;if(replacer&&typeof replacer!=="function"&&(typeof replacer!=="object"||typeof replacer.length!=="number")){throw new Error("JSON.stringify")}return str("",{"":value})}}if(typeof JSON.parse!=="function"){JSON.parse=function(text,reviver){var j;function walk(holder,key){var k,v,value=holder[key];if(value&&typeof value==="object"){for(k in value){if(Object.prototype.hasOwnProperty.call(value,k)){v=walk(value,k);if(v!==undefined){value[k]=v}else{delete value[k]}}}}return reviver.call(holder,key,value)}text=String(text);cx.lastIndex=0;if(cx.test(text)){text=text.replace(cx,function(a){return"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})}if(/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]").replace(/(?:^|:|,)(?:\s*\[)+/g,""))){j=eval("("+text+")");return typeof reviver==="function"?walk({"":j},""):j}throw new SyntaxError("JSON.parse")}}}());
