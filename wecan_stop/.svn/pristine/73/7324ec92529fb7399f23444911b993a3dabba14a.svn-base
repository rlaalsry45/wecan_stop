function popup_close() {
    $(".popup_wrap").hide();
    $("#oemail").val("");
    $("#opasswd2nd").val("");
    return false;
}

function isEmail(email) {
	var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email);
}

function isPhone(phone) {
	var regex = /^010-?([0-9]{3,4})-?([0-9]{4})$/;
	return regex.test(phone);
}

function autoHypenPhone(str){
      str = str.replace(/[^0-9]/g, '');
      var tmp = '';
      if( str.length < 4){
          return str;
      }else if(str.length < 7){
          tmp += str.substr(0, 3);
          tmp += '-';
          tmp += str.substr(3);
          return tmp;
      }else if(str.length < 11){
          tmp += str.substr(0, 3);
          tmp += '-';
          tmp += str.substr(3, 3);
          tmp += '-';
          tmp += str.substr(6);
          return tmp;
      }else{              
          tmp += str.substr(0, 3);
          tmp += '-';
          tmp += str.substr(3, 4);
          tmp += '-';
          tmp += str.substr(7);
          return tmp;
      }
  
      return str;
}

function notKor(input){
	if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var v = $(input).val();
		$(input).val(v.replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ));
	}
}

function isPwd(pwd){
	var num = pwd.search(/[0-9]/g);
 	var eng = pwd.search(/[a-z]/ig);
 	var spe = pwd.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

 	if(pwd.length < 8 || pwd.length > 20){
		alert("비밀번호는 8자리 ~ 20자리 이내로 입력해주세요.");
  		return false;
 	}else if(pwd.search(/\s/) != -1){
  		alert("비밀번호는 공백 없이 입력해주세요.");
  		return false;
 	}else if(num < 0 || eng < 0 || spe < 0 ){
  		alert("비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
  		return false;
 	}else {
    	return true;
 	}
}

function getTimeString(second) {
	var minute = '' + (Math.floor(second / 60));
	var dividedSec = second % 60;
	if (dividedSec < 10) {
		dividedSec = '0' + dividedSec;
	}
	return minute + ":" + dividedSec;
}

function getToday(){
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var date = now.getDate();

    month = month >=10 ? month : "0" + month;
    date  = date  >= 10 ? date : "0" + date;

    return today = ""+year + month + date;
}

function getDate(){
	var now = new Date();
	var week = ["일", "월", "화", "수", "목", "금", "토"]; 
	var dayOfWeek = week[now.getDay()]; 
	return dayOfWeek;
}