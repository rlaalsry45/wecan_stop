function closeLayer( obj ) {
    $(obj).parent().parent().hide();
}

/* 클릭 클릭시 클릭을 클릭한 위치 근처에 레이어가 나타난다. */
(function($) {
	$(function(){
		$('.imgSelect').click(function(e) {
			// popupLayer class
			var width = $(this).next().width();
			var height = $(this).next().height();

			// 레이어가 나타날 위치를 셋팅한다.
			var top = e.clientY + 5 + (window.pageYOffset || document.documentElement.scrollTop);
			var left = e.clientX + 10 + (window.pageXOffset || document.documentElement.scrollLeft);

			// 레이어가 화면 크기를 벗어나면 위치를 바꾸어 배치한다.
			if (top + height > window.innerHeight) {
				top -= height;
			}
			if (left + width > window.innerWidth) {
				left -= width;
			}

			// 레이어 위치를 바꾸었더니 상단기준점(0,0) 밖으로 벗어난다면 상단기준점(0,0)에 배치하자.
			if (top < 0) top = 0;
			if (left < 0) left = 0;

			//console.log("left:" + left + "  top:" + top);
			$(this).next().css({ "top": top, "left": left, "position": "absolute" }).show();
		});
		 $('.popupLayer').draggable();
	});
})(jQuery);