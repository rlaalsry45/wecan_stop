function checkForm(obj, arg) {
    with (document.frm) {
        if (typeof(userid) != "undefined" && userid.value.trim() == "") {
            alert("아이디를 입력하세요.");
            userid.focus();
            return false;
        }

        if (typeof(userpw) != "undefined" && userpw.value.trim() == "") {
            alert("비밀번호를 입력하세요.");
            userpw.focus();
            return false;
        }
        
        if (typeof(userpw) != "undefined" && userpw.value.trim() != "") {
        	var shaPw = CryptoJS.SHA256(userpw.value).toString(); 
        	userpw.value = shaPw;
        }

        if (typeof(sitedomain) != "undefined") {
            if (sitedomain.value.trim() == "") {
                alert("사용하실 도메인을 입력하세요.");
                sitedomain.focus();
                return false;
            }
            else {
                if (typeof(origindomain) != "undefined") {
                    if (origindomain.value != sitedomain.value.trim()) {
                        if (typeof(dupflag) != "undefined" && dupflag.value == "0") {
                            alert("중복된 도메인이 존재합니다.");
                            sitedomain.focus();
                            return false;
                        }
                    }
                }
                else {
                    if (typeof(dupflag) != "undefined" && dupflag.value.trim() == "0") {
                        alert("중복된 도메인이 존재합니다.");
                        sitedomain.focus();
                        return false;
                    }
                }
            }
        }
        /*
                if(typeof(sitecfgmain)!="undefined" && sitecfgmain.value.trim() == ""){
                    alert("메인페이지를 선택해 주세요.");
                    sitecfgmain.focus();
                    return false;
                }
        */
        if (typeof(sitetitle) != "undefined" && sitetitle.value.trim() == "") {
            alert("홈페이지명을 입력하세요.");
            sitetitle.focus();
            return false;
        }

        if (typeof(sitewebtitle) != "undefined" && sitewebtitle.value.trim() == "") {
            alert("홈페이지 타이틀을 입력하세요.");
            sitewebtitle.focus();
            return false;
        }

        if (typeof(obj) != "undefined") {
            var flag = false;
            for (var i = 0; i < document.getElementsByName(obj).length; i++) {
                if (document.getElementsByName(obj)[i].checked) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                var message = arg == "copy" ? "복사" : "삭제";
                
                if(arg == "res") message = "복구";
                
                alert(message + "하실 항목을 선택 해주세요.");
                return false;
            }
            else {
                return true;
            }
        }

        if (typeof(main_css_dest) != "undefined") {
            var tmpArr = new Array();
            for (var i = 0; i < main_css_dest.options.length; i++) {
                tmpArr.push(main_css_dest.options[i].value);
            }
            sitecfgmaincss.value = tmpArr.join();
        }

        if (typeof(sub_css_dest) != "undefined") {
            var tmpArr = new Array();
            for (var i = 0; i < sub_css_dest.options.length; i++) {
                tmpArr.push(sub_css_dest.options[i].value);
            }
            if (typeof(sitecfgsubcss) != "undefined") sitecfgsubcss.value = tmpArr.join();
            if (typeof(menusubcss) != "undefined") menusubcss.value = tmpArr.join();
        }

        if (typeof(main_js_dest) != "undefined") {
            var tmpArr = new Array();
            for (var i = 0; i < main_js_dest.options.length; i++) {
                tmpArr.push(main_js_dest.options[i].value);
            }
            sitecfgmainjs.value = tmpArr.join();
        }

        if (typeof(sub_js_dest) != "undefined") {
            var tmpArr = new Array();
            for (var i = 0; i < sub_js_dest.options.length; i++) {
                tmpArr.push(sub_js_dest.options[i].value);
            }
            if (typeof(sitecfgsubjs) != "undefined") sitecfgsubjs.value = tmpArr.join();
            if (typeof(menusubjs) != "undefined") menusubjs.value = tmpArr.join();

        }

        if (typeof(tpl_t_dest) != "undefined") {
            var tmpArr = new Array();
            for (var i = 0; i < tpl_t_dest.options.length; i++) {
                tmpArr.push(tpl_t_dest.options[i].value);
            }
            if (typeof(sitecfgtoptpl) != "undefined") sitecfgtoptpl.value = tmpArr.join();
            if (typeof(menuttpl) != "undefined") menuttpl.value = tmpArr.join();
        }

        if (typeof(tpl_l_dest) != "undefined") {
            var tmpArr = new Array();
            for (var i = 0; i < tpl_l_dest.options.length; i++) {
                tmpArr.push(tpl_l_dest.options[i].value);
            }
            if (typeof(sitecfglefttpl) != "undefined") sitecfglefttpl.value = tmpArr.join();
            if (typeof(menultpl) != "undefined") menultpl.value = tmpArr.join();
        }

        if (typeof(tpl_r_dest) != "undefined") {
            var tmpArr = new Array();
            for (var i = 0; i < tpl_r_dest.options.length; i++) {
                tmpArr.push(tpl_r_dest.options[i].value);
            }
            if (typeof(sitecfgrighttpl) != "undefined") sitecfgrighttpl.value = tmpArr.join();
            if (typeof(menurtpl) != "undefined") menurtpl.value = tmpArr.join();
        }

        if (typeof(tpl_b_dest) != "undefined") {
            var tmpArr = new Array();
            for (var i = 0; i < tpl_b_dest.options.length; i++) {
                tmpArr.push(tpl_b_dest.options[i].value);
            }
            if (typeof(sitecfgbottomtpl) != "undefined") sitecfgbottomtpl.value = tmpArr.join();
            if (typeof(menubtpl) != "undefined") menubtpl.value = tmpArr.join();

        }

        if (typeof(maintitle) != "undefined") {
            if (maintitle.value.trim() == "") {
                alert("메인(인트로)페이지 제목을 입력하세요.");
                maintitle.focus();
                return false;
            }
        }

        //if(typeof(sitemainconts)!="undefined" && sitemainconts.value == ""){
        //	alert("메인(인트로)소스코드를 입력하세요.");
        //	sitemainconts.focus();
        //	return false;
        //}

        if (typeof(menutitle) != "undefined") {
            if (act.value != "/PrvwPage") {
                if (menutitle.value.trim() == "") {
                    alert("메뉴명을 입력하세요.");
                    menutitle.focus();
                    return false;
                }
            }
            if (menutype[1].checked && menusubno.value == "0") {
                alert("하위메뉴를 지정해주세요.");
                menutype[1].focus();
                return false;
            }
        }

        if (typeof(tpltitle) != "undefined" && tpltitle.value.trim() == "") {
            alert("템를릿명을 입력하세요.");
            tpltitle.focus();
            return false;
        }

        if (typeof(csstitle) != "undefined" && csstitle.value.trim() == "") {
            alert("CSS명을 입력하세요.");
            csstitle.focus();
            return false;
        }

        if (typeof(jstitle) != "undefined" && jstitle.value.trim() == "") {
            alert("JS명을 입력하세요.");
            jstitle.focus();
            return false;
        }

        if (typeof(cfgtbltitle) != "undefined" && cfgtbltitle.value.trim() == "") {
            alert("제목을 입력하세요.");
            cfgtbltitle.focus();
            return false;
        }

        if (typeof(boardtitle) != "undefined" && boardtitle.value.trim() == "") {
            alert("게시판제목을 입력하세요.");
            boardtitle.focus();
            return false;
        }

        if (typeof(cfgskin) != "undefined" && cfgskin.value.trim() == "") {
            alert("스킨을 선택해주세요.");
            cfgskin.focus();
            return false;
        }

        if (typeof(skin) != "undefined" && skin.value.trim() == "") {
            alert("스킨을 선택해주세요.");
            skin.focus();
            return false;
        }

        if (typeof(sdate) != "undefined" && sdate.value.trim() == "") {
            alert("시작일시를 입력해주세요.");
            sdate.focus();
            return false;
        }

        if (typeof(edate) != "undefined" && edate.value.trim() == "") {

            alert("종료일시를 입력해주세요.");
            edate.focus();
            return false;
        }

        if (typeof(sv_name) != "undefined" && sv_name.value.trim() == "") {
            alert("서비스명을 입력하세요.");
            sv_name.focus();
            return false;
        }

        if (typeof(sv_table) != "undefined" && sv_table.value.trim() == "") {
            alert("Table명을 입력하세요.");
            sv_table.focus();
            return false;
        }

        if (typeof(point) != "undefined" && point.selectedIndex == 0) {
            alert("지역을 선택하세요.");
            return false;
        }

        if (typeof(adminid) != "undefined" && adminid.value.trim() == "") {
            alert("관리자 아이디를 입력하세요.");
            return false;
        }
    }

    return true;
}
