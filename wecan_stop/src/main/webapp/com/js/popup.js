function start_popup(id) {
    $(".pop-wrap").hide();
    $("#dimmed").show();

    var mypup = $('#' + id);
    var pop_w = $(mypup).outerWidth();
    var pop_h = $(mypup).outerHeight();
    var win_h = $(window).height();
    var win_t = $(window).scrollTop();

    var left_p = (pop_w) / 2;
    var top_p  = 0;
    if (pop_h >= win_h) {
        top_p = 0;
    } else {
        top_p = (win_h / 2) - (pop_h / 2) + win_t;
    }

    $(mypup).show().css({
        "margin-left": -(left_p),
        "top"        : top_p
    });
    return false;
}

function cease_popup(id) {
    $('#' + id).hide();
    $("#dimmed").hide();
}

/*2021-12-06*/
function PopupCenter(url, title, w, h) {  
    // Fixes dual-screen position                         Most browsers      Firefox  
    var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;  
    var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;  
              
    width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;  
    height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;  
              
    var left = ((width / 2) - (w / 2)) + dualScreenLeft;  
    var top = ((height / 2) - (h / 2)) + dualScreenTop;  
    var newWindow = window.open(url, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);  
  
    // Puts focus on the newWindow  
    if (window.focus) {  
        newWindow.focus();  
    }  
}


(function($) {
	$(document).ready(function () {
		$("[data-rel=pop]").click(function () {
			$(".pop-wrap").hide();
			$("#dimmed").show();

			if ($(this).attr("href") == "#pop-zipcode") {
				$(".pop-zipcode-cont").hide();
				$(".pop-zipcode-cont").eq(0).show();
			}

			var pop_w = $($(this).attr("href")).outerWidth();
			var pop_h = $($(this).attr("href")).outerHeight();

			var win_h = $(window).height();
			var win_t = $(window).scrollTop();

			var left_p = (pop_w) / 2;
			var top_p  = 0;
			if (pop_h < win_h) {
				top_p = (win_h / 2) - (pop_h / 2) + win_t;
			}

			$($(this).attr("href")).show().css({
				"margin-left": -(left_p),
				"top"        : top_p
			});
			return false;
		});

		// popup close
		$(".pop-close").click(function () {
			$(this).closest(".pop-wrap").hide();
			$("#dimmed").hide();
			return false;
		});

		// popup cancel
		$(".pop-cancel").click(function () {
			$($(this).attr("href")).find(".pop-close").trigger("click");
			return false;
		});

		// display name when attach file
		$(":input[type=file]").change(function () {
			$(this).parent().prev().val($(this).val());
		});
	});
})(jQuery);
