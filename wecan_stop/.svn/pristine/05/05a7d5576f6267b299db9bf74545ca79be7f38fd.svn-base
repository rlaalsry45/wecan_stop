//var selidx = 1;// 화면 로드시 활성화할 메뉴인덱스를 설정(selidx를 전역변수로 설정함은 비활성일 경우 원래 선택한 메뉴를 활성화 하기 위함이다.)
// var meues = {1:"site",2:"tpl",3:"board",4:"report",5:"module",6:"user",7:"admin"};
//var meues = {1:"site",2:"archv",3:"user",4:"admin",5:"evnt",6:"posts",7:"report", 8:"srch", 9:"reply"};
//var menulen;
/*
 window.onload = function(){
 menulen = 0;
 for (var key in meues){
 menulen++;
 if(window.location.pathname.indexOf(meues[key])>0){
 selidx = key;
 navMenu(key,'on');
 }
 }
 };

 function navMenu(idx, flag)
 {
 idx = flag=="off" ? selidx : idx; // 활성일 경우 선택한 메뉴의 인텍스 사용, 비활성일때 원래 선택한 메뉴(selidx)를 활성화 시킨다.
 for (var i=1; i<=menulen; i++){
 if (idx==i){
 document.getElementById("menu"+idx).src = '/cms/image/gnb_btn_'+idx+'_on.gif';
 //if (document.getElementById("submenu"+idx)!=null) document.getElementById("submenu"+idx).className = "gnbon";
 }
 else{
 if (document.getElementById("menu"+i)!=null)
 document.getElementById("menu"+i).src = '/cms/image/gnb_btn_'+i+'.gif';
 //if (document.getElementById("submenu"+i)!=null) document.getElementById("submenu"+i).className = "gnboff";
 }
 }
 }
 */

//textarea tab 작동
(function($) {
	$(function () {

		$('textarea').keydown(function (e) {
			if (e.keyCode == 9) {
				// get caret position/selection
				var start = this.selectionStart;
				var end = this.selectionEnd;

				var $this = $(this);
				var value = $this.val();

				// set textarea value to: text before caret + tab + text after caret
				$this.val(value.substring(0, start)
					+ '\t'
					+ value.substring(end));

				// put caret at right position again (add one for the tab)
				this.selectionStart = this.selectionEnd = start + 1;

				// prevent the focus lose
				e.preventDefault();
			}
		});

	});
})(jQuery);

function checkAll(value, name) {
    var choice = value;
    if (typeof value !== 'boolean') {
        choice = document.getElementById('batch').checked;
    } else {
        document.getElementById('batch').checked = choice;
    }

    var list = document.getElementsByName(name);
    for (var ndex = 0; ndex < list.length; ndex++) {
        list[ndex].checked = choice;
    }

    return choice;
}

function del(name,type) {
	var text = "정말 삭제하시겠습니까?";
	
	if(type=="res") text = "복구하시겠습니까?";
	
    if (confirm(text)) {
        if (checkForm(name,type)) {
            document.forms[0].action = name === 'urlno' || name === 'cno' ? '?act=delete' : 'delete.html';
            if (name === 'urlno') {
                var urlnos = $(':checkbox[name=urlno]:checked').map(function () {return $(this).val();}).get();
                var opens = $('[src$=\'btn_opened.jpg\']').map(function () {return $(this).attr('id');}).get();
                document.forms[0].action += '&urlnos=' + urlnos + '&opens=' + opens;
            } else if (name === 'cno') {
                document.forms[0].action += '&' + window.location.search.replace('?', '');
            }
            document.forms[0].submit();
        }
    }
    return false;
}

function batchDel() {
	if (confirm('정말 일괄 삭제하시겠습니까? \n\n로그 전부가 삭제됩니다.')) {
		document.forms[0].action = "batchDel.html";
		document.forms[0].submit();
	}
    return false;
}

function searchDel() {
	if (confirm('정말 검색결과를 삭제하시겠습니까? \n\n검색된 로그 전부가 삭제됩니다.')) {
		document.forms[0].action = "searchDel.html";
		document.forms[0].submit();
	}
	return false;
}

function resign(name) {
    if (confirm('정말 탈퇴하시겠습니까?')) {
        if (checkForm(name)) {
            document.forms[0].action = 'resign.html';
            document.forms[0].submit();
        }
    }
    return false;
}

function delattach() {
    if (confirm('정말 삭제하시겠습니까?')) {
        document.frm.act.value = 'delattach';
        document.frm.submit();
    }
}

function copyMain(obj, key) {
    if (checkForm(obj, key)) {
        document.frm.action = '?act=' + key;
        document.frm.submit();
    }
}

function select(arg) {
    with (document.frm) {
        var source = arg;
        var dest = arg.replace('source', 'dest');
        var flag = false;
        for (var i = 0; i < eval(source).length; i++) {
            flag = false;
            if (eval(source).options[i].selected) {
                var oOption = document.createElement('OPTION');
                oOption.text = eval(source).options[i].text;
                oOption.value = eval(source).options[i].value;
                for (var j = 0; j < eval(dest).length; j++) {
                    if (eval(dest).options[j].value == eval(source).options[i].value) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    eval(dest).add(oOption);
                }
                eval(source).options[i].selected = false;
            }
        }
    }
}

function deselect(arg) {
    with (document.frm) {
        for (var i = eval(arg).length - 1; i >= 0; i--) {
            if (eval(arg).options[i].selected) {
                eval(arg).options.remove(i);
            }
        }
    }
}

/***************************************************************************************************************
 //more javascript from z5
 * 만든시간：2011.12.23
 * 만 든 이：yjlzq
 * 설    명：리스트 박스 상호간 항목 이동 메소드(여러개 항목 이동도 가능)
 *
 * 주요메소드：
 * 1， moveUp(oSelect,isToTop)              －－－ 리스트 박스의 선택항목(여러개 항목도 가능)을 타겟 리스트 박스의 상위로 이동, 최상위로 이동할것인지 설정가능
 * 2， moveDown(oSelect,isToBottom)         －－－ 리스트 박스의 선택항목(여러개 항목도 가능)을 타겟 리스트 박스의 하위로 이동, 최하위로 이동할것인지 설정가능
 * 3， moveSelected(oSourceSel,oTargetSel)  －－－ 원 리스트 박스와 타겟 리스트 박스 사이에 서로 선택 항목 이동
 * 4， moveAll(oSourceSel,oTargetSel)       －－－ 원 리스트 박스와 타겟 리스트 박스 사이에 서로 전부 항목 이동
 * 5， deleteSelectItem(oSelect)            －－－ 선택 항목 삭제
 *
 ****************************************************************************************************************/

var browser_chk = false; //브라우저체크 true:익스플로러, false: 그외브라우저

var Browser = {
    chk: navigator.userAgent.toLowerCase()
}

Browser = {
    ie     : Browser.chk.indexOf('msie') != -1,
    ie6    : Browser.chk.indexOf('msie 6') != -1,
    ie7    : Browser.chk.indexOf('msie 7') != -1,
    ie8    : Browser.chk.indexOf('msie 8') != -1,
    ie9    : Browser.chk.indexOf('msie 9') != -1,
    ie10   : Browser.chk.indexOf('msie 10') != -1,
    opera  : !!window.opera,
    safari : Browser.chk.indexOf('safari') != -1,
    safari3: Browser.chk.indexOf('applewebkir/5') != -1,
    mac    : Browser.chk.indexOf('mac') != -1,
    chrome : Browser.chk.indexOf('chrome') != -1,
    firefox: Browser.chk.indexOf('firefox') != -1
}

if (Browser.ie) {
    browser_chk = true;
    // 브라우저가 IE9, 10일 때 실행할 코드
}


/**
 * 선택된 항목 위로 이동
 *
 * oSelect: 원 리스트 박스
 * isToTop: 최상위로 이동할것인지 설정하며 기타 항목은 그 아래로 순차적으로 이동한다.
 *            true이면 최상위로 이동, false이면 반대, 디폴트 값은false
 */

function moveUp(oSelect, isToTop) {
    with (document.frm) {
        oSelect = eval(oSelect);

        // 디폴트는 최상위 이동이 아님
        if (isToTop == null) isToTop = false;
        // 여러개 선택 가능할 경우 ------------------------------------------------------------------

        if (oSelect.multiple) {
            for (var selIndex = 0; selIndex < oSelect.options.length; selIndex++) {
                // 최상위 이동으로 설정 했을 경우
                if (isToTop) {
                    if (oSelect.options[selIndex].selected) {
                        var transferIndex = selIndex;
                        while (transferIndex > 0 && !oSelect.options[transferIndex - 1].selected) {
                            oSelect.options[transferIndex].swapNode(oSelect.options[transferIndex - 1]);
                            transferIndex--;
                        }
                    }
                }
                // 최상위 이동으로 설정 하지 않았을 경우
                else {
                    if (oSelect.options[selIndex].selected) {

                        if (selIndex > 0) {
                            if (!oSelect.options[selIndex - 1].selected) {

                                if (browser_chk) {
                                    oSelect.options[selIndex].swapNode(oSelect.options[selIndex - 1]);
                                } else {
                                    var selText = oSelect.options[selIndex].text;      // Selected Item Text
                                    var selValue = oSelect.options[selIndex].value;    // Selected Item Value

                                    var oldText = oSelect.options[selIndex - 1].text;
                                    var oldValue = oSelect.options[selIndex - 1].value;
                                    oSelect.options[selIndex - 1].text = selText;
                                    oSelect.options[selIndex - 1].value = selValue;
                                    oSelect.options[selIndex].text = oldText;
                                    oSelect.options[selIndex].value = oldValue;

                                    oSelect.selectedIndex = selIndex - 1
                                }

                            }

                        }
                    }
                }
            }
        }
        // 한개만 선택 가능한 경우 --------------------------------------------------------------------
        else {
            var selIndex = oSelect.selectedIndex;
            if (selIndex <= 0) return;
            // 최상위 이동으로 설정 했을 경우
            if (isToTop) {
                while (selIndex > 0) {
                    oSelect.options[selIndex].swapNode(oSelect.options[selIndex - 1]);
                    selIndex--;
                }
            }
            // 최상위 이동으로 설정 하지 않았을 경우
            else {
                oSelect.options[selIndex].swapNode(oSelect.options[selIndex - 1]);
            }
        }
    }
}

/**
 * 선택한 항목을 하위로 이동
 *
 * oSelect: 원 리스트 박스
 * isToTop: 최하위로 이동할것인지 설정하며 기타 항목은 그 위로 순차적으로 이동한다.
 *            true이면 최하위로 이동, false이면 반대, 디폴트 값은false
 */
function moveDown(oSelect, isToBottom) {
    with (document.frm) {
        oSelect = eval(oSelect);
        // 디폴트는 최하위 이동이 아님
        if (isToBottom == null) isToBottom = false;
        var selLength = oSelect.options.length - 1;
        // 여러개 선택 가능할 경우 ------------------------------------------------------------------
        if (oSelect.multiple) {
            for (var selIndex = oSelect.options.length - 1; selIndex >= 0; selIndex--) {
                // 최하위 이동으로 설정 했을 경우
                if (isToBottom) {
                    if (oSelect.options[selIndex].selected) {
                        var transferIndex = selIndex;
                        while (transferIndex < selLength && !oSelect.options[transferIndex + 1].selected) {
                            oSelect.options[transferIndex].swapNode(oSelect.options[transferIndex + 1]);
                            transferIndex++;
                        }
                    }
                }
                // 최하위 이동으로 설정 하지 않았을 경우
                else {
                    if (oSelect.options[selIndex].selected) {
                        if (selIndex < selLength) {
                            if (!oSelect.options[selIndex + 1].selected) {
                                if (browser_chk) {
                                    oSelect.options[selIndex].swapNode(oSelect.options[selIndex + 1]);
                                } else {

                                    var selText = oSelect.options[selIndex].text;      // Selected Item Text
                                    var selValue = oSelect.options[selIndex].value;    // Selected Item Value

                                    var oldText = oSelect.options[selIndex + 1].text;
                                    var oldValue = oSelect.options[selIndex + 1].value;
                                    oSelect.options[selIndex + 1].text = selText;
                                    oSelect.options[selIndex + 1].value = selValue;
                                    oSelect.options[selIndex].text = oldText;
                                    oSelect.options[selIndex].value = oldValue;

                                    oSelect.selectedIndex = selIndex + 1
                                }
                            }

                        }


                    }
                }
            }
        }
        // 한개만 선택 가능한 경우 --------------------------------------------------------------------
        else {
            var selIndex = oSelect.selectedIndex;
            if (selIndex >= selLength - 1) return;
            // 최하위 이동으로 설정 했을 경우
            if (isToBottom) {
                while (selIndex < selLength - 1) {
                    oSelect.options[selIndex].swapNode(oSelect.options[selIndex + 1]);
                    selIndex++;
                }
            }
            // 최하위 이동으로 설정 하지 않았을 경우
            else {
                oSelect.options[selIndex].swapNode(oSelect.options[selIndex + 1]);
            }
        }
    }
}

/**
 * 리스트 박스중의 부분 항목을 이동(value값을 기준으로 항목 이동하기 때문에 빈값의 value를 허용하지 않음)
 *
 * oSourceSel: 원 리스트박스
 * oTargetSel: 타겟 리스트 박스
 */
function moveSelected(oSourceSel, oTargetSel) {
    // value값과 text값을 임시 저장할 배열
    var arrSelValue = new Array();
    var arrSelText = new Array();
    // 배열에 선택된 항목을 저장(value값을 저장함)
    var arrValueTextRelation = new Array();
    var index = 0; // 배열을 항목을 추가할시 보조 인덱스로 사용

    // 원 리스트 박스의 전부 항목을 배열에 추가 및 value와 선택된 항목간의 관계를 맺어준다.
    for (var i = 0; i < oSourceSel.options.length; i++) {
        if (oSourceSel.options[i].selected) {
            // 저장
            arrSelValue[index] = oSourceSel.options[i].value;
            arrSelText[index] = oSourceSel.options[i].text;
            // value와 선택된 항목간의 대응관계를 맺어준다.
            arrValueTextRelation[arrSelValue[index]] = oSourceSel.options[i];
            index++;
        }
    }

    // 배열의 항목들을 타겟 리스트 박스에 추가하고 원 리스트 박스 중의 상응한 항목을 삭제해준다.
    for (var i = 0; i < arrSelText.length; i++) {
        // 추가
        var oOption = document.createElement('option');
        oOption.text = arrSelText[i];
        oOption.value = arrSelValue[i];
        oTargetSel.add(oOption);
        // 원 리스트 박스의 상응한 항목 삭제한다.
        oSourceSel.removeChild(arrValueTextRelation[arrSelValue[i]]);
    }
}

/**
 * 리스트 박스의 전부 항목을 이동한다.
 *
 * oSourceSel: 원 리스트박스
 * oTargetSel: 타겟 리스트 박스
 */
function moveAll(oSourceSel, oTargetSel) {
    // value값과 text값을 임시 저장할 배열
    var arrSelValue = new Array();
    var arrSelText = new Array();

    // 원 리스트 박스의 전부 항목을 배열에 저장한다.
    for (var i = 0; i < oSourceSel.options.length; i++) {
        arrSelValue[i] = oSourceSel.options[i].value;
        arrSelText[i] = oSourceSel.options[i].text;
    }

    // 배열의 값을 타겟 리스트 박스에 추가한다.
    for (var i = 0; i < arrSelText.length; i++) {
        var oOption = document.createElement('option');
        oOption.text = arrSelText[i];
        oOption.value = arrSelValue[i];
        oTargetSel.add(oOption);
    }

    // 원 래스트 박스의 항목을 삭제하면 이동이 완료된다.
    oSourceSel.innerHTML = '';
}

/**
 * 선택 항목 삭제
 *
 * oSelect: 원 리스트 박스
 */
function deleteSelectItem(oSelect) {
    for (var i = 0; i < oSelect.options.length; i++) {
        if (i >= 0 && i <= oSelect.options.length - 1 && oSelect.options[i].selected) {
            oSelect.options[i] = null;
            i--;
        }
    }
}

function displayRow(displaytype, page) {
    if (page == 'site') {
        if (displaytype == '01') {
            document.getElementById('02').style.display = 'none';
            document.getElementById('04').style.display = 'none';
            document.getElementById('05').style.display = 'none';
            document.getElementById('06').style.display = 'none';
            document.getElementById('123').style.display = '';
        } else if (displaytype == '02') {
            document.getElementById('02').style.display = '';
            document.getElementById('04').style.display = 'none';
            document.getElementById('05').style.display = 'none';
            document.getElementById('06').style.display = 'none';
            document.getElementById('123').style.display = 'none';
        } else if (displaytype == '03') {
            document.getElementById('02').style.display = 'none';
            document.getElementById('04').style.display = 'none';
            document.getElementById('05').style.display = 'none';
            document.getElementById('06').style.display = 'none';
            document.getElementById('123').style.display = 'none';
        } else if (displaytype == '04') {
            document.getElementById('02').style.display = 'none';
            document.getElementById('04').style.display = '';
            document.getElementById('05').style.display = 'none';
            document.getElementById('06').style.display = 'none';
            document.getElementById('123').style.display = 'none';
        } else if (displaytype == '05') {
            document.getElementById('02').style.display = 'none';
            document.getElementById('04').style.display = 'none';
            document.getElementById('05').style.display = '';
            document.getElementById('06').style.display = 'none';
            document.getElementById('123').style.display = 'none';
        } else if (displaytype == '06') {
            document.getElementById('02').style.display = 'none';
            document.getElementById('04').style.display = 'none';
            document.getElementById('05').style.display = 'none';
            document.getElementById('06').style.display = '';
            document.getElementById('123').style.display = 'none';
        }
    } else if (page == 'main') {
        document.getElementById(displaytype).style.display = '';
        if (displaytype.indexOf('txtarea') == 0) {
            var num = displaytype.substr('txtarea'.length);
            document.getElementById('selbbs' + num).style.display = 'none';
        } else if (displaytype.indexOf('selbbs') == 0) {
            var num = displaytype.substr('selbbs'.length);
            document.getElementById('txtarea' + num).style.display = 'none';
        }
    } else if (page == 'css' || page == 'js' || page == 'tpl') {
        if (displaytype == '01') {
            if (fileform) fileform.close();
        } else if (displaytype == '02') {
            openwin(page + 'conts');
        }
    } else if (page == 'board') {
        if (displaytype == '01') {
            document.getElementById('02').style.display = 'none';
        } else if (displaytype == '02') {
            document.getElementById('02').style.display = '';
            document.getElementsByName('tblname')[0].focus();
        }
    }
}

function selArea(type) {
    if (type == '3') {
        document.getElementById('txtarea').style.display = 'none';
        document.getElementById('editorarea').style.display = '';

        if (document.getElementById('mainconts')) {
            CKEDITOR.instances['ckeditorConts'].setData(document.getElementById('mainconts').value);
        }
        if (document.getElementById('menuconts')) {
            CKEDITOR.instances['ckeditorConts'].setData(document.getElementById('menuconts').value);
        }
        if (document.getElementById('tplconts')) {
            CKEDITOR.instances['ckeditorConts'].setData(document.getElementById('tplconts').value);
        }
        if (document.getElementById('cfgconts')) {
            CKEDITOR.instances['ckeditorConts'].setData(document.getElementById('cfgconts').value);
        }
        if (document.getElementById('conts')) {
            CKEDITOR.instances['ckeditorConts'].setData(document.getElementById('conts').value);
        }
    } else {
        document.getElementById('txtarea').style.display = '';
        if (document.getElementById('mainconts')) {
            document.getElementById('mainconts').value = CKEDITOR.instances['ckeditorConts'].getData();
        }
        if (document.getElementById('menuconts')) {
            document.getElementById('menuconts').value = CKEDITOR.instances['ckeditorConts'].getData();
        }
        if (document.getElementById('tplconts')) {
            document.getElementById('tplconts').value = CKEDITOR.instances['ckeditorConts'].getData();
        }
        if (document.getElementById('cfgconts')) {
            document.getElementById('cfgconts').value = CKEDITOR.instances['ckeditorConts'].getData();
        }
        if (document.getElementById('conts')) {
            document.getElementById('conts').value = CKEDITOR.instances['ckeditorConts'].getData();
        }

        document.getElementById('editorarea').style.display = 'none';
    }
}

function selArea2(type, index) {
    if (type == '3') {
        document.getElementById('txtarea' + index).style.display = 'none';
        document.getElementById('editorarea' + index).style.display = '';
        Editor.switchEditor(index);
        Editor.modify({
            content: document.getElementById('conts' + index)
        });
    } else {
        document.getElementById('txtarea' + index).style.display = '';
        document.getElementById('editorarea' + index).style.display = 'none';
        Editor.switchEditor(index);
        document.getElementById('conts' + index).value = Editor.getContent();
    }
}

function change(arg) {
    with (document.frm) {
        if (arg == 'sv_category') {
            sv_category.style.display = '';
            keyword.style.display = 'none';
            sv_category.focus();
        } else {
            sv_category.style.display = 'none';
            keyword.style.display = '';
            keyword.focus();
        }
    }
}

var fileform;

function openwin(arg, key) {
    if (fileform) fileform.close();
    if (arg == 'board') {
        fileform = window.open('/admsys/board/run/boardCopy.html?' + key, 'BoardCopy', 'width=750, height=150, resizable=yes, location=no, scrollbars=yes');
    } else if (arg == 'site') {
        fileform = window.open('/admsys/inc/copysite.html?' + key, 'SiteCopy', 'width=750, height=250, resizable=yes, location=no, scrollbars=yes');
    } else if (arg == 'cate') {
        fileform = window.open('/admsys/board/run/boardCate.html?' + key, 'BoardCate', 'width=850, height=600, resizable=yes, location=no, scrollbars=yes');
    } else if (arg == 'ztag') {
        fileform = window.open('/admsys/inc/ztag.html', 'Ztag', 'width=850, height=600, resizable=yes, location=no, scrollbars=yes');
    } else if (arg == 'posts') {
        fileform = window.open('/admsys/board/posts/index.html?' + key, 'BoardPosts', 'width=1000,height=660, resizable=yes, location=no, scrollbars=yes');
    } else {
        fileform = window.open('/admsys/inc/selfile.html?target=' + arg, 'fileupload', 'width=350,height=50');
    }
}

function setconts(arg) {
    with (document.frm) {
        if (eval(arg).length > 0) {
            var str = '';
            for (var i = 0; i < eval(arg).length; i++) {
                if (eval(arg).options[i].selected) {
                    str += '@import url("/usr/css/' + eval(arg).options[i].value.split('^')[1] + '");' + '\r\n';
                }
            }
            cssconts.value += str;
            cssconts.scrollTop = cssconts.scrollHeight;
        }
    }
}

function dupchk(arg) {
    if (arg == 1) {
        if (document.frm.sitedomain.value == '') {
            document.frm.dupflag.value = '0';
            return;
        }
    } else {
        if (document.frm.tblname.value == '') {
            document.frm.dupflag.value = '0';
            return;
        }
    }
    var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {// code for IE6, IE5
        xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.frm.dupflag.value = xmlhttp.responseText.replace(/(^\s*)|(\s*$)/g, '');
        }
    };
    xmlhttp.open('POST', '/admsys/inc/dupchk.html', false);
    xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    if (arg == 1) {
        xmlhttp.send('dupflag=' + arg + '&sitedomain=' + document.frm.sitedomain.value);
    } else {
        xmlhttp.send('dupflag=' + arg + '&tblname=' + document.frm.tblname.value);
    }
}

function dupalert() {
    if (document.frm.dupflag.value == '0') {
        if (typeof (document.frm.sitedomain) != 'undefined') {
            alert('중복된 도메인이 존재합니다.');
            document.frm.sitedomain.select();
            document.frm.sitedomain.focus();
        } else {
            alert('중복된 게시판 테이블명이 존재합니다.');
            document.frm.tblname.select();
            document.frm.tblname.focus();
        }
        return false;
    }
}

function addrlist(arg) {
    with (document.frm) {
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
        }

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var str = xmlhttp.responseText.replace(/(^\s*)|(\s*$)/g, '');
                var arr = str.split('Æ');

                for (var i = 1; i < arr.length - 1; i++) {
                    eval('addr' + i).length = 1;
                    var tmp = arr[i].split('^');
                    for (var j = 0; j < tmp.length; j++) {
                        eval('addr' + i).options[eval('addr' + i).length] = new Option(tmp[j], tmp[j]);
                    }
                }

                var sel = arr[0].split('^');

                for (i = 0; i < addr1.length; i++) {
                    if (addr1.options[i].value == sel[0]) {
                        addr1.selectedIndex = i;
                        break;
                    }
                }
                for (i = 0; i < addr2.length; i++) {
                    if (addr2.options[i].value == sel[1]) {
                        addr2.selectedIndex = i;
                        break;
                    }
                }
                for (i = 0; i < addr3.length; i++) {
                    if (addr3.options[i].value == sel[2]) {
                        addr3.selectedIndex = i;
                        break;
                    }
                }

                var tmp = arr[arr.length - 1].split('^');
                point.length = 1;
                for (var j = 0; j < tmp.length; j++) {
                    var opt = tmp[j].split('|');
                    point.options[point.length] = new Option(opt[0], opt[1]);
                }
            }
        };
        xmlhttp.open('POST', '/admsys/inc/addrlist.jsp', false);
        xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xmlhttp.send('addr1=' + addr1.value + '&addr2=' + addr2.value + '&addr3=' + addr3.value);
    }
}

function copytoclipboard(text) {
    var textArea = document.createElement("textarea");
    textArea.value = text;
    document.body.appendChild(textArea);
    textArea.select();
    document.execCommand("Copy");
    textArea.remove();
    return false;
}

function restore(arg) {
    if (arg == 1) {
        document.frm.sitecfgdtd.value = '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">';
    } else {
        document.frm.sitecfghtm.value = '<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">';
    }
}

/*
 function addRow(idx){
 var unique = Date.parse(new Date());
 var str = "<input type=radio class=\"radio0\" name=\"sitemaincontstype"+unique+"\" value=\"1\" checked onclick=displayRow('txtarea"+unique+"','main') />직접입력\n";
 str += "<input type=radio class=\"radio1\" name=\"sitemaincontstype"+unique+"\" value=\"2\" onclick=displayRow('selbbs"+unique+"','main') />최근글 선택\n";
 str += "<div style=\"float:right;margin-top:5px\">";
 str += "<a href=\"javascript:void(0)\" onclick=addRow(this.parentNode.parentNode.parentNode.rowIndex)><img src=\"/cms/image/btn_lnb_plus.jpg\" alt=\"행 추가\"/></a>";
 str += "&nbsp;<a href=\"javascript:void(0)\" onclick=delRow(this.parentNode.parentNode.parentNode.rowIndex)><img src=\"/cms/image/btn_lnb_minus.jpg\" alt=\"해당 행 삭제\"/></a>";
 str += "</div>";
 str += "<div id=\"txtarea"+unique+"\"><textarea class=\"bor1ddd\" name=\"sitemainconts\" style=\"width:99%\" rows=\"15\"></textarea></div>\n";
 str += "<div id=\"selbbs"+unique+"\" style=\"display:none;\">\n";
 str += "<select name=\"sitemainbbsnos\">";
 str += document.getElementsByName("sitemainbbsnos")[0].innerHTML;
 str += "</select>\n";
 str += "<select name=\"sitemainbbsskins\">";
 str += document.getElementsByName("sitemainbbsskins")[0].innerHTML;
 str += "</select>\n";
 str += "</div>\n";
 var newCol = document.getElementById("input_table").insertRow(idx+1).insertCell(0);
 newCol.style.borderStyle = "none";
 newCol.style.padding = "0px";
 newCol.innerHTML = str;
 }

 function delRow(idx){
 if (document.getElementById("input_table").rows.length>1){
 document.getElementById("input_table").deleteRow(idx);
 }
 }
 */


function addRow(no) {

    var result_count = $('#result_count').val();

    for (var i = 1; i <= result_count; i++) {

        var new_value = Number($('#new_result_no_' + i).val());

        if (no < new_value) {
            $('#new_result_no_' + i).val(new_value + 1);
        }
    }


    for (var i = no; i < document.getElementById("question").rows.length; i++) {
        $('#addRow_' + (i + 1)).attr('href', 'javascript:addRow(' + (i + 2) + ')');
        $('#delRow_' + (i + 1)).attr('href', 'javascript:delRow(' + (i + 2) + ')');

        document.getElementById('question').rows[i].cells[0].children[0].rows[1].cells[1].children[0].name = 'ask' + (i + 2);

        for (var j = 2; j < document.getElementById("question").rows[i].cells[0].children[0].rows.length; j++) {
            document.getElementById('question').rows[i].cells[0].children[0].rows[j].cells[1].children[0].name = 'opt' + (i + 2);
        }

    }

    for (var i = document.getElementById('question').rows.length; i > no; i--) {
        $('#addRow_' + i).attr('id', 'addRow_' + (i + 1));
        $('#delRow_' + i).attr('id', 'delRow_' + (i + 1));
        $('#trRow_' + i).attr('id', 'trRow_' + (i + 1));

        $('#opt-type_1_' + i).attr({id: 'opt-type_1_' + (i + 1), name: 'opt-type' + (i + 1)});
        $('#opt-type_2_' + i).attr({id: 'opt-type_2_' + (i + 1), name: 'opt-type' + (i + 1)});

        $('#opttype_1_' + i).attr({id: 'opttype_1_' + (i + 1), name: 'opttype' + (i + 1)});
        $('#opttype_2_' + i).attr({id: 'opttype_2_' + (i + 1), name: 'opttype' + (i + 1)});
        $('#opttype_3_' + i).attr({id: 'opttype_3_' + (i + 1), name: 'opttype' + (i + 1)});
        $('#opttype_4_' + i).attr({id: 'opttype_4_' + (i + 1), name: 'opttype' + (i + 1)});

    }

//	for (var i=no;i<document.getElementById("question").rows.length;i++){
//
//
//		alert(document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[0].name)
//		alert(document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[1].rows[1].cells[0].children[0].name)
//
//		if(typeof document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[0] != "undefined") {
//			document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[0].name = "opt-type"+(i+2);
//		}
//		if(typeof document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[1] != "undefined") {
//			document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[1].name = "opt-type"+(i+2);
//		}
//		if(typeof document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[2] != "undefined") {
//			document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[2].children[0].name = "opttype"+(i+2);
//			document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[2].children[1].name = "opttype"+(i+2);
//		}
//		if(typeof document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[3] != "undefined") {
//			document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[3].children[0].name = "opttype"+(i+2);
//			document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[3].children[1].name = "opttype"+(i+2);
//		}
//
//		document.getElementById("question").rows[i].cells[0].children[0].rows[1].cells[1].children[0].name = "ask"+(i+2);
//		for (var j=2;j<document.getElementById("question").rows[i].cells[0].children[0].rows.length;j++){
//			document.getElementById("question").rows[i].cells[0].children[0].rows[j].cells[1].children[0].name = "opt"+(i+2);
//		}
//	}

    var oTR = document.getElementById('question').insertRow(no);
    oTR.setAttribute('id', 'trRow_' + (no + 1));
    /*var oTH = document.createElement("th");
     oTR.appendChild(oTH);
     oTH.setAttribute("class", "checkbox_research");
     oTH.setAttribute("style", "vertical-align: middle;");
     oTH.setAttribute("className", "checkbox_research");
     oTH.innerHTML = "<input type='checkbox' / >";*/
    var oTD = oTR.insertCell(-1);
    oTD.setAttribute('class', 'checkbox_research');
    oTD.setAttribute('className', 'checkbox_research');
    oTD.innerHTML =
        '<table class="main_table1 bgneno" summary="형식, 문항, 1, 2">\
            <colgroup>\
                <col width="50">\
                <col>\
                <col width="100" />\
            </colgroup>\
            <tr>\
                <th class="Tleft lborder">형식</th>\
                <td class="Tbod rborder Tleft">\
                    <input type="radio" value="opt-1" class="radio0" id="opt-type_1_' + (no + 1) + '" name="opt-type' + (no + 1) + '" checked="checked">객관식\
					<input type="radio" value="opt-2" class="radio0" id="opt-type_2_' + (no + 1) + '" name="opt-type' + (no + 1) + '" style="margin-left:5px;">주관식\
					<span class="opt-1" style="margin-left:50px;">\
						<input type="radio" value="2" class="radio0" id="opttype_2_' + (no + 1) + '" name="opttype' + (no + 1) + '" checked="checked">단일선택\
						<input type="radio" value="1" class="radio0" id="opttype_1_' + (no + 1) + '" name="opttype' + (no + 1) + '" >중복선택\
					</span>\
					<span class="opt-2" style="display:none;margin-left:50px;">\
						<input type="radio" value="3" class="radio0" id="opttype_3_' + (no + 1) + '" name="opttype' + (no + 1) + '">단답형\
						<input type="radio" value="4" class="radio0" id="opttype_4_' + (no + 1) + '" name="opttype' + (no + 1) + '">서술형\
					</span>\
					<td class="Tbod rborder Tleft"  id="rowspan_' + (no + 1) + '" rowspan="4"><a id="delRow_' + (no + 1) + '" href="javascript:delRow(' + (no + 1) + ')"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /> 문항삭제</a></td>\
				</td>\
			</tr>\
			<tr>\
				<th class="Tbornone Tleft lborder">문항</th>\
				<td class="Tleft rborder"><input type="text" name="ask' + (no + 1) + '" class="bor1ddd" size="100" style="padding-left:10px" value="질문하실 내용을 입력 하세요." onfocus="if(this.value==\'질문하실 내용을 입력 하세요.\') this.value=\'\'" onblur="if(this.value==\'\') this.value=\'질문하실 내용을 입력 하세요.\'" /></td>\
			</tr>\
			<tr class="answer-item">\
				<th class="Tbornone Tleft lborder">1</td>\
				<td class="Tleft rborder"><input type="text" name="opt' + (no + 1) + '" class="bor1ddd" size="110" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this,' + (no + 1) + ')"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>\
			</tr>\
			<tr class="answer-item">\
				<th class="Tbornone Tleft lborder">2</td>\
				<td class="Tleft rborder"><input type="text" name="opt' + (no + 1) + '" class="bor1ddd" size="110" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>\
			</tr>\
		</table>\
		<a id="addRow_' + (no + 1) + '" href="javascript:addRow(' + (no + 1) + ')"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /> 문항추가</a>';
    //기타의견입력 삭제
    /*oTD.innerHTML =
     '<table summary="항목">\
     <colgroup>\
     <col width="50">\
     <col>\
     </colgroup>\
     <tr>\
     <th>형식</th>\
     <td><input type="radio" value="1" checked onclick="showOPt(this)">중복선택&nbsp;&nbsp;<input type="radio" value="2" onclick="showOPt(this)">단일선택&nbsp;&nbsp;<input type="radio" value="3" onclick="hideOPt(this)">기타의견입력</td>\
     </tr>\
     <tr>\
     <th>문항</th>\
     <td><input type="text" class="bor1ddd" size="120" style="padding-left:10px" value="질문하실 내용을 입력 하세요." onfocus="if(this.value==\'질문하실 내용을 입력 하세요.\') this.value=\'\'" onblur="if(this.value==\'\') this.value=\'질문하실 내용을 입력 하세요.\'" /></td>\
     </tr>\
     <tr>\
     <td>1</td>\
     <td><input type="text" class="bor1ddd" size="115" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>\
     </tr>\
     <tr>\
     <td>2</td>\
     <td><input type="text" class="bor1ddd" size="115" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>\
     </tr>\
     </table>';*/
    document.frm.question.value = document.getElementById('question').rows.length;

}

function delRow(no) {


    var len = document.getElementById('question').rows.length;

    if (len == 1) {
        alert('더이상 삭제하실 수 없습니다.');
    } else {

        var result_count = $('#result_count').val();

        for (var i = 1; i <= result_count; i++) {

            var new_value = Number($('#new_result_no_' + i).val());

            if (no < new_value) {
                $('#new_result_no_' + i).val(new_value - 1);
            }
        }


        for (var i = no; i < len; i++) {
            $('#addRow_' + (i + 1)).attr('href', 'javascript:addRow(' + (i) + ')');
            $('#delRow_' + (i + 1)).attr('href', 'javascript:delRow(' + (i) + ')');

            document.getElementById('question').rows[i].cells[0].children[0].rows[1].cells[1].children[0].name = 'ask' + (i);

            for (var j = 2; j < document.getElementById("question").rows[i].cells[0].children[0].rows.length; j++) {
                document.getElementById('question').rows[i].cells[0].children[0].rows[j].cells[1].children[0].name = 'opt' + (i);
            }

            $('#opt-type_1_' + (i + 1)).attr({id: 'opt-type_1_' + i, name: 'opt-type' + i});
            $('#opt-type_2_' + (i + 1)).attr({id: 'opt-type_2_' + i, name: 'opt-type' + i});

            $('#opttype_1_' + (i + 1)).attr({id: 'opttype_1_' + i, name: 'opttype' + i});
            $('#opttype_2_' + (i + 1)).attr({id: 'opttype_2_' + i, name: 'opttype' + i});
            $('#opttype_3_' + (i + 1)).attr({id: 'opttype_3_' + i, name: 'opttype' + i});
            $('#opttype_4_' + (i + 1)).attr({id: 'opttype_4_' + i, name: 'opttype' + i});

        }

        for (var i = len; i > no; i--) {

            $('#addRow_' + (i)).attr('id', 'addRow_' + (i - 1));
            $('#delRow_' + (i)).attr('id', 'delRow_' + (i - 1));
            $('#trRow_' + (i)).attr('id', 'trRow_' + (i - 1));

        }
        $('#trRow_' + no).remove();

//	var flag = false;
//	for (var i=0;i<len;i++){
//		if (document.getElementById("question").rows[i].cells[0].children[0].checked){
//			flag = true;
//			break;
//		}
//	}
//	if (!flag){
//		alert("삭제 하실 항목을 선택 해주세요.");
//	}
//	else{
        /*for (var i=len-1;i>=0;i--){
         if (document.getElementById("question").rows[i].cells[0].children[0].checked){
         document.getElementById('question').deleteRow(i);
         }
         }*/
        /*for (var i=0;i<document.getElementById("question").rows.length;i++){
         if(typeof document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[0] != "undefined") {
         document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[0].name = "opt-type"+(i+1);
         }
         if(typeof document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[1] != "undefined") {
         document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[1].name = "opt-type"+(i+1);
         }
         if(typeof document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[2] != "undefined") {
         document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[2].children[0].name = "opttype"+(i+1);
         document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[2].children[1].name = "opttype"+(i+1);
         }
         if(typeof document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[3] != "undefined") {
         document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[3].children[0].name = "opttype"+(i+1);
         document.getElementById("question").rows[i].cells[0].children[0].rows[0].cells[1].children[3].children[1].name = "opttype"+(i+1);
         }
         document.getElementById("question").rows[i].cells[0].children[0].rows[1].cells[1].children[0].name = "ask"+(i+1);
         for (var j=2;j<document.getElementById("question").rows[i].cells[0].children[0].rows.length;j++){
         document.getElementById("question").rows[i].cells[0].children[0].rows[j].cells[1].children[0].name = "opt"+(i+1);
         }
         }*/

    }
    document.frm.question.value = document.getElementById('question').rows.length;
    $('#new_result_count').val($('[id^=\'new_result_no_\']').length);
}

function addSubRow(obj, no) {
    var oTBL = obj.parentNode.parentNode.parentNode;
    console.log(oTBL);
    var oTR = oTBL.insertRow(obj.parentNode.parentNode.rowIndex + 1);

    var oTH = document.createElement('th');
    oTR.appendChild(oTH);
    oTH.setAttribute('class', 'Tbornone Tleft lborder');
    var oTD = oTR.insertCell(-1);
    oTD.setAttribute('class', 'Tleft rborder');
    oTD.innerHTML = '<input type="text" id="" name="' + obj.parentNode.children[0].name + '" class="bor1ddd" size="110" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this,' + no + ')"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a>';
    var len = oTBL.rows.length;
    for (var i = 2; i < len; i++) {
        oTBL.rows[i].className = 'answer-item';
        oTBL.rows[i].cells[0].innerText = i - 1;
    }

    $('#rowspan_' + no).attr('rowspan', len);
}

/*
 function addRow(){
 var oTR = document.getElementById('question').insertRow(-1);
 var oTH = document.createElement("th");
 oTR.appendChild(oTH);
 oTH.setAttribute("class", "checkbox_research");
 oTH.setAttribute("className", "checkbox_research");
 oTH.innerHTML = "<input type='checkbox'/ >";
 var oTD = oTR.insertCell(-1);
 oTD.setAttribute("class", "checkbox_research");
 oTD.setAttribute("className", "checkbox_research");
 oTD.innerHTML =
 '<table summary="항목">\
 <colgroup>\
 <col width="50">\
 <col>\
 </colgroup>\
 <tr>\
 <th>형식</th>\
 <td>\
 <input type="radio" value="opt-1" class="opt-type" checked="checked">객관식\
 <input type="radio" value="opt-2" class="opt-type" style="margin-left:5px;">주관식\
 <span class="opt-1" style="margin-left:50px;">\
 <input type="radio" value="2" checked="checked">단일선택\
 <input type="radio" value="1">중복선택\
 </span>\
 <span class="opt-2" style="display:none;margin-left:50px;">\
 <input type="radio" value="3">단답형\
 <input type="radio" value="4">서술형\
 </span>\
 </tr>\
 <tr>\
 <th>문항</th>\
 <td><input type="text" class="bor1ddd" size="100" style="padding-left:10px" value="질문하실 내용을 입력 하세요." onfocus="if(this.value==\'질문하실 내용을 입력 하세요.\') this.value=\'\'" onblur="if(this.value==\'\') this.value=\'질문하실 내용을 입력 하세요.\'" /></td>\
 </tr>\
 <tr class="answer-item">\
 <td>1</td>\
 <td><input type="text" class="bor1ddd" size="115" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>\
 </tr>\
 <tr class="answer-item">\
 <td>2</td>\
 <td><input type="text" class="bor1ddd" size="115" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>\
 </tr>\
 </table>';
 //기타의견입력 삭제
 oTD.innerHTML =
 '<table summary="항목">\
 <colgroup>\
 <col width="50">\
 <col>\
 </colgroup>\
 <tr>\
 <th>형식</th>\
 <td><input type="radio" value="1" checked onclick="showOPt(this)">중복선택&nbsp;&nbsp;<input type="radio" value="2" onclick="showOPt(this)">단일선택&nbsp;&nbsp;<input type="radio" value="3" onclick="hideOPt(this)">기타의견입력</td>\
 </tr>\
 <tr>\
 <th>문항</th>\
 <td><input type="text" class="bor1ddd" size="120" style="padding-left:10px" value="질문하실 내용을 입력 하세요." onfocus="if(this.value==\'질문하실 내용을 입력 하세요.\') this.value=\'\'" onblur="if(this.value==\'\') this.value=\'질문하실 내용을 입력 하세요.\'" /></td>\
 </tr>\
 <tr>\
 <td>1</td>\
 <td><input type="text" class="bor1ddd" size="115" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>\
 </tr>\
 <tr>\
 <td>2</td>\
 <td><input type="text" class="bor1ddd" size="115" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>\
 </tr>\
 </table>';
 for (var i=0;i<document.getElementById("question").rows.length;i++){
 if(typeof document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[0] != "undefined") {
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[0].name = "opt-type"+(i+1);
 }
 if(typeof document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[1] != "undefined") {
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[1].name = "opt-type"+(i+1);
 }
 if(typeof document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[2] != "undefined") {
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[2].children[0].name = "opttype"+(i+1);
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[2].children[1].name = "opttype"+(i+1);
 }
 if(typeof document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[3] != "undefined") {
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[3].children[0].name = "opttype"+(i+1);
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[3].children[1].name = "opttype"+(i+1);
 }
 document.getElementById("question").rows[i].cells[1].children[0].rows[1].cells[1].children[0].name = "ask"+(i+1);
 for (var j=2;j<document.getElementById("question").rows[i].cells[1].children[0].rows.length;j++){
 document.getElementById("question").rows[i].cells[1].children[0].rows[j].cells[1].children[0].name = "opt"+(i+1);
 }
 }
 document.frm.question.value = document.getElementById("question").rows.length;
 }

 function delRow(){
 var len = document.getElementById("question").rows.length;
 var flag = false;
 for (var i=0;i<len;i++){
 if (document.getElementById("question").rows[i].cells[0].children[0].checked){
 flag = true;
 break;
 }
 }
 if (!flag){
 alert("삭제 하실 항목을 선택 해주세요.");
 }
 else{
 for (var i=len-1;i>=0;i--){
 if (document.getElementById("question").rows[i].cells[0].children[0].checked){
 document.getElementById('question').deleteRow(i);
 }
 }
 for (var i=0;i<document.getElementById("question").rows.length;i++){
 if(typeof document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[0] != "undefined") {
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[0].name = "opt-type"+(i+1);
 }
 if(typeof document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[1] != "undefined") {
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[1].name = "opt-type"+(i+1);
 }
 if(typeof document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[2] != "undefined") {
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[2].children[0].name = "opttype"+(i+1);
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[2].children[1].name = "opttype"+(i+1);
 }
 if(typeof document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[3] != "undefined") {
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[3].children[0].name = "opttype"+(i+1);
 document.getElementById("question").rows[i].cells[1].children[0].rows[0].cells[1].children[3].children[1].name = "opttype"+(i+1);
 }
 document.getElementById("question").rows[i].cells[1].children[0].rows[1].cells[1].children[0].name = "ask"+(i+1);
 for (var j=2;j<document.getElementById("question").rows[i].cells[1].children[0].rows.length;j++){
 document.getElementById("question").rows[i].cells[1].children[0].rows[j].cells[1].children[0].name = "opt"+(i+1);
 }
 }
 }
 document.frm.question.value = document.getElementById("question").rows.length;
 }

 function addSubRow(obj){
 var oTBL = obj.parentNode.parentNode.parentNode;	//console.log(oTBL);
 var oTR = oTBL.insertRow(obj.parentNode.parentNode.rowIndex+1);
 var oTD = oTR.insertCell(-1);
 oTD.innerHTML = '<td></td>';
 var oTD = oTR.insertCell(-1);
 oTD.innerHTML = '<td><input type="text" name="'+obj.parentNode.children[0].name+'" class="bor1ddd" size="115" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>';
 var len = oTBL.rows.length;
 for (var i=2;i<len;i++){
 oTBL.rows[i].className = "answer-item";
 oTBL.rows[i].cells[0].innerText = i-1;
 }
 }*/

function reviveSubRow(obj) {
    // console.log(obj);
    var oTBL = obj.parentNode.parentNode.parentNode;	//console.log(oTBL);
    var oTR = oTBL.insertRow(obj.parentNode.parentNode.rowIndex + 2);
    var oTD = oTR.insertCell(-1);
    oTD.innerHTML = '<td></td>';
    var oTD = oTR.insertCell(-1);
    var rownum = oTBL.parentNode.parentNode.parentNode.rowIndex + 1;
    oTD.innerHTML = '<td><input type="text" name="opt' + rownum + '" class="bor1ddd" size="115" value="" /> <a href="javascirpt:void(0)" onclick="addSubRow(this)"><img src="/cms/image/btn_plus_small.jpg" alt="추가" style="vertical-align:middle" /></a> <a href="javascirpt:void(0)" onclick="delSubRow(this)"><img src="/cms/image/btn_minus_small.jpg" alt="삭제" style="vertical-align:middle" /></a></td>';
    var len = oTBL.rows.length;
    for (var i = 2; i < len; i++) {
        oTBL.rows[i].className = 'answer-item';
        oTBL.rows[i].cells[0].innerText = i - 1;
    }
}

function delSubRow(obj) {
    var idx = obj.parentNode.parentNode.rowIndex;
    var oTBL = obj.parentNode.parentNode.parentNode;
    var len = oTBL.rows.length;
    if (len > 3) {
        oTBL.deleteRow(idx);
        for (var i = 2; i < len - 1; i++) {
            oTBL.rows[i].cells[0].innerText = i - 1;
        }
    }
}


function addImg(){
	var oTR = document.getElementById('banner').insertRow(-1);
	var oTH = document.createElement("th");
	oTR.appendChild(oTH);
	oTH.setAttribute("class", "checkbox_research");
	oTH.setAttribute("className", "checkbox_research");
	oTH.innerHTML = "<input type='checkbox'/ >";
	var oTD = oTR.insertCell(-1);
	oTD.setAttribute("class", "checkbox_research");
	oTD.setAttribute("className", "checkbox_research");
	var cnt = document.getElementById("banner").rows.length;
	var conts = '<table class="main_table1 bgneno" summary="이미지, alt, 링크">\
			<colgroup>\
			<col width="50">\
			<col>\
		</colgroup>\
		<tr>\
			<th class="Tleft lborder">이미지</th>\
			<td class="Tbod rborder Tleft">\
				<table border="1">\
					<tr>\
						<th class="Tbornone Tleft lborder">PC</th>\
						<td><input type="file"/> <img style="border:0px;width:10px" src="/cms/image/delet.gif" alt="삭제" onclick="delAttach(this)" /></td>\
						<th class="Tbornone Tleft lborder">모바일<br>(옵션)</th>\
						<td><input type="file"/><img style="border:0px;width:10px" src="/cms/image/delet.gif" alt="삭제" onclick="mdelAttach(this)" /></td>\
					</tr>\
				</table>\
			</td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder">alt</th>\
			<td class="Tleft rborder"><input type="text" class="bor1ddd" size="110" style="padding-left:10px" /></td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder">링크</th>\
			<td class="Tleft rborder"><input type="text" class="bor1ddd" size="110" style="padding-left:10px" /></td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder" scope="row">링크이동</th>\
			<td class="Tleft">\
				<input type=radio class="radio0" name="linktype" value="1" checked />\
				새창\
				<input type=radio class="radio1" name="linktype" value="2" />\
				현재창\
			</td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder">상태</th>\
			<td class="Tleft rborder">\
			<input type="radio" value="Y" checked="checked"/>무제한 보기<br>\
			<input type="radio" value="D" />기간지정';
	conts += "<input id=\"d4311"+cnt+"\" class=\"Wdate\" type=\"text\" onFocus=\"WdatePicker({maxDate:'#F{$dp.$D(\\'d4312"+cnt+"\\')}'})\" style=\"width:128px;\"/>~\
			<input id=\"d4312"+cnt+"\" class=\"Wdate\" type=\"text\" onFocus=\"WdatePicker({minDate:'#F{$dp.$D(\\'d4311"+cnt+"\\')}'})\" style=\"width:128px;\" /><br>";
	conts += '<input type="radio" value="N"/>감추기</td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder">MEMO</th>\
			<td class="Tleft rborder"><textarea class="bor1ddd" style="width:95%" rows="6"></textarea></td>\
		</tr>\
	</table>';
	
	oTD.innerHTML = conts;
	for (var i=0;i<document.getElementById("banner").rows.length;i++){
		document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[1].children[0].name = "file"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[3].children[0].name = "mfile"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[1].cells[1].children[0].name = "filealt"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[2].cells[1].children[0].name = "filelink"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[3].cells[1].children[0].name = "filelinktype"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[3].cells[1].children[1].name = "filelinktype"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[0].name = "filestatus"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[2].name = "filestatus"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[3].name = "filesdate"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[4].name = "fileedate"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[6].name = "filestatus"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[5].cells[1].children[0].name = "filememo"+(i+1);
	}
	document.frm.cnt.value = document.getElementById("banner").rows.length;
}

function addImg2(){
	var oTR = document.getElementById('banner').insertRow(-1);
	var oTH = document.createElement("th");
	oTR.appendChild(oTH);
	oTH.setAttribute("class", "checkbox_research");
	oTH.setAttribute("className", "checkbox_research");
	oTH.innerHTML = "<input type='checkbox' class='fileno' / >";
	var oTD = oTR.insertCell(-1);
	oTD.setAttribute("class", "checkbox_research");
	oTD.setAttribute("className", "checkbox_research");
	var cnt = document.getElementById("banner").rows.length;
	var conts = '<table class="main_table1 bgneno" summary="이미지, alt, 링크">\
			<colgroup>\
			<col width="150">\
			<col>\
		</colgroup>\
		<tr>\
			<th class="Tleft lborder">이미지\
				<li>\
					<label for="ranking">순번</label>\
					<select id="ranking" name="rankno" class="ranking">\
					</select>\
				</li>\
			</th>\
			<td class="Tbod rborder Tleft">\
				<table border="1">\
					<tr>\
						<th class="Tbornone Tleft lborder">PC</th>\
						<td><input type="file"/> <img style="border:0px;width:10px" src="/cms/image/delet.gif" alt="삭제" onclick="delAttach(this)" /></td>\
						<th class="Tbornone Tleft lborder">모바일<br>(옵션)</th>\
						<td><input type="file"/><input type="hidden"/><input type="hidden"/>\
						<img style="border:0px;width:10px" src="/cms/image/delet.gif" alt="삭제" onclick="mdelAttach(this)" /></td>\
					</tr>\
				</table>\
			</td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder">alt</th>\
			<td class="Tleft rborder"><input type="text" class="bor1ddd" size="110" style="padding-left:10px" /></td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder">링크</th>\
			<td class="Tleft rborder"><input type="text" class="bor1ddd" size="110" style="padding-left:10px" /></td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder" scope="row">링크이동</th>\
			<td class="Tleft">\
				<input type=radio class="radio0" name="linktype" value="1" checked />\
				새창\
				<input type=radio class="radio1" name="linktype" value="2" />\
				현재창\
			</td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder">상태</th>\
			<td class="Tleft rborder">\
			<input type="radio" value="Y" checked="checked"/>무제한 보기<br>\
			<input type="radio" value="D" />기간지정';
	conts += "<input id=\"d4311"+cnt+"\" class=\"Wdate\" type=\"text\" onFocus=\"WdatePicker({maxDate:'#F{$dp.$D(\\'d4312"+cnt+"\\')}'})\" style=\"width:128px;\"/>~\
			<input id=\"d4312"+cnt+"\" class=\"Wdate\" type=\"text\" onFocus=\"WdatePicker({minDate:'#F{$dp.$D(\\'d4311"+cnt+"\\')}'})\" style=\"width:128px;\" /><br>";
	conts += '<input type="radio" value="N"/>감추기</td>\
		</tr>\
		<tr>\
			<th class="Tbornone Tleft lborder">MEMO</th>\
			<td class="Tleft rborder"><textarea class="bor1ddd" name="filememo1" style="width:95%" rows="6"></textarea></td>\
		</tr>\
		</table>';
	
	
	oTD.innerHTML = conts;
	
	for (var i=0;i<document.getElementById("banner").rows.length;i++){
		document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[1].children[0].name = "file"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[1].children[1].value = i
		document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[3].children[0].name = "mfile"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[3].children[1].name = "hmfileorg"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[3].children[2].name = "hmfilesave"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[1].cells[1].children[0].name = "filealt"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[2].cells[1].children[0].name = "filelink"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[3].cells[1].children[0].name = "filelinktype"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[3].cells[1].children[1].name = "filelinktype"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[0].name = "filestatus"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[2].name = "filestatus"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[3].name = "filesdate"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[4].name = "fileedate"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[6].name = "filestatus"+(i+1);
		document.getElementById("banner").rows[i].cells[1].children[0].rows[5].cells[1].children[0].name = "filememo"+(i+1);
	}
	document.frm.cnt.value = document.getElementById("banner").rows.length;
}

function delImg(){
	var len = document.getElementById("banner").rows.length;
	var flag = false;
	for (var i=0;i<len;i++){
		if (document.getElementById("banner").rows[i].cells[0].children[0].checked){
			flag = true;
			break;
		}
	}
	if (!flag){
		alert("삭제 하실 항목을 선택 해주세요.");
	}
	else{
		for (var i=len-1;i>=0;i--){
			if (document.getElementById("banner").rows[i].cells[0].children[0].checked){
				document.getElementById('banner').deleteRow(i);
			}
		}
		for (var i=0;i<document.getElementById("banner").rows.length;i++){
			document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[1].children[0].name = "file"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[1].children[1].value = i
			document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[3].children[0].name = "mfile"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[3].children[1].name = "hmfileorg"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[0].cells[1].children[0].rows[0].cells[3].children[2].name = "hmfilesave"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[1].cells[1].children[0].name = "filealt"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[2].cells[1].children[0].name = "filelink"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[3].cells[1].children[0].name = "filelinktype"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[3].cells[1].children[1].name = "filelinktype"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[0].name = "filestatus"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[2].name = "filestatus"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[3].name = "filesdate"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[4].name = "fileedate"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[4].cells[1].children[6].name = "filestatus"+(i+1);
			document.getElementById("banner").rows[i].cells[1].children[0].rows[5].cells[1].children[0].name = "filememo"+(i+1);
		}
	}
	document.frm.cnt.value = document.getElementById("banner").rows.length;
}

function delAttach(obj) {
    if (obj.parentNode.children[0].tagName == 'INPUT') {
        obj.parentNode.children[0].outerHTML = obj.parentNode.children[0].outerHTML;
    } else {
        var idx = obj.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.rowIndex + 1;
        obj.parentNode.innerHTML = '<input type="file" name="file' + idx + '" /> <img style="border:0px;width:10px" src="/cms/image/delet.gif" alt="삭제" onclick="delAttach(this)" />';
    }
}

function setSize(arg) {
    document.getElementsByName('width')[0].value = arg.split('X')[0];
    document.getElementsByName('height')[0].value = arg.split('X')[1];
}

function showOPt(obj) {
    //var idx = obj.parentNode.parentNode.rowIndex;
    var oTBL = obj.parentNode.parentNode.parentNode;
    var len = oTBL.rows.length;
    for (var i = 2; i < len; i++) {
        oTBL.rows[i].style.display = '';
    }
}

function hideOPt(obj) {
    //var idx = obj.parentNode.parentNode.rowIndex;
    var oTBL = obj.parentNode.parentNode.parentNode;
    var len = oTBL.rows.length;
    for (var i = 2; i < len; i++) {
        oTBL.rows[i].style.display = 'none';
    }
}

function controll(obj) {
    if (obj.checked) {
        document.getElementsByName('rsmsyn')[0].disabled = false;
        //document.getElementsByName("aprovyn")[0].disabled = false;
        //document.getElementsByName("usepasswordyn")[0].disabled = false;
        //document.getElementById("label4").color = "";
        document.getElementById('label2').color = '';
        document.getElementById('label3').color = '';
    } else {
        document.getElementsByName('rsmsyn')[0].disabled = true;
        document.getElementsByName('rsmsyn')[0].checked = false;
        //document.getElementsByName("aprovyn")[0].disabled = true;
        //document.getElementsByName("aprovyn")[0].checked = false;
        //document.getElementsByName("usepasswordyn")[0].disabled = true;
        //document.getElementsByName("usepasswordyn")[0].checked = false;
        //document.getElementById("label4").color = "gray";
        document.getElementById('label2').color = 'gray';
        document.getElementById('label3').color = 'gray';
    }
}

function refer(arg) {
    document.frm.menuno_r.value = arg;
    document.frm.act.value = 'refer';
    document.frm.submit();
}

function excel() {
    document.frm.action = '/admsys/inc/excel.html';
    document.frm.excel_val.value = document.getElementById('excel_table').outerHTML;
    document.frm.submit();
}

function addFile(e) {
    $obj = $(e.target).parent().parent();
    $obj.clone().insertAfter($obj);
    $.each($('input[type=file]'), function (index, element) {
        $(element).attr('name', 'attachFile' + (index + 1));
    });
}

function delFile(e, arg) {
    $obj = $(e.target).parent().parent();
    if (arg == 1) {
        if ($('input[type=file]', $obj.parent().parent()).length > 1) {
            $obj.remove();
        }
    } else {
        $obj.remove();
    }
    $.each($('input[type=file]'), function (index, element) {
        $(element).attr('name', 'attachFile' + (index + 1));
    });
}

var isIE = !!window.ActiveXObject;

function sendKossda(arg1, arg2, arg3, arg4) {
    if (arg4 == '2') {
        var charset;
        if (isIE) {
            charset = document.charset;
            document.charset = 'euc-kr';
        }
        document.form_kossda.userid.value = arg1;
        document.form_kossda.username.value = arg2;
        document.form_kossda.email.value = arg3;
        document.form_kossda.KossdaStatus.value = arg4;
        document.form_kossda.submit();
        if (isIE) {
            document.charset = charset;
        }
    } else {
        alert('인증이 되지 않은 회원입니다.');
    }
}

String.prototype.trim = function () {return this.replace(/^\s+|\s+$/g, '');};
String.prototype.ltrim = function () {return this.replace(/^\s+/, '');};
String.prototype.rtrim = function () {return this.replace(/\s+$/, '');};

/************************
 * 상단 롤링텍스트 링크 *
 ************************/

function scrolling(objId, sec1, sec2, speed, height) {
    this.objId = objId;
    this.sec1 = sec1;
    this.sec2 = sec2;
    this.speed = speed;
    this.height = height;
    this.h = 0;
    this.div = document.getElementById(this.objId);
    this.htmltxt = this.div.innerHTML;
    this.div.innerHTML = this.htmltxt + this.htmltxt;
    this.div.isover = false;
    this.div.onmouseover = function () {this.isover = true;};
    this.div.onmouseout = function () {this.isover = false;};
    var self = this;
    this.div.scrollTop = 0;
    window.setTimeout(function () {self.play();}, this.sec1);
}

scrolling.prototype = {
    play: function () {
        var self = this;
        if (!this.div.isover) {
            this.div.scrollTop += this.speed;
            if (this.div.scrollTop > this.div.scrollHeight / 2) {
                this.div.scrollTop = 0;
            } else {
                this.h += this.speed;
                if (this.h >= this.height) {
                    if (this.h > this.height || this.div.scrollTop % this.height != 0) {
                        this.div.scrollTop -= this.h % this.height;
                    }
                    this.h = 0;
                    window.setTimeout(function () {self.play();}, this.sec1);
                    return;
                }
            }
        }
        window.setTimeout(function () {self.play();}, this.sec2);
    },
    prev: function () {
        if (this.div.scrollTop == 0) {
            this.div.scrollTop = this.div.scrollHeight / 2;
        }
        this.div.scrollTop -= this.height;
    },
    next: function () {
        if (this.div.scrollTop == this.div.scrollHeight / 2) {
            this.div.scrollTop = 0;
        }
        this.div.scrollTop += this.height;
    }
};

function openadmsyspopup(url) {
    window.open(url, 'openbbs', 'resizable=no, status=no, scrollbars=yes, toolbar=no, menubar=no, width=1024, height=600');
}

