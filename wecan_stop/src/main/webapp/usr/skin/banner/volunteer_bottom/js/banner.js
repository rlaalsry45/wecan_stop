var bn = new js_rolling('bannerList');
bn.set_direction(4);
bn.move_gap = 1; // 움직이는 픽셀단위
bn.time_dealy = 25; // 움직이는 타임딜레이
bn.time_dealy_pause = 0; // 하나의 대상이 새로 시작할 때 멈추는 시간, 0 이면 적용 안함
bn.start();
//]]>
function bn_pause(){
	bn.pause();
	$(".fb_stop").css("display","none");
	$(".fb_start").css("display","");
}
function bn_start(){
	bn.resume();
	$(".fb_stop").css("display","");
	$(".fb_start").css("display","none");
}