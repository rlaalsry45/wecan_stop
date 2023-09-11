/*$(document).ready(function() {

	$('.main_slide').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        dots: true,
        infinite: true,
        cssEase: 'linear',
        arrows: true,
        prevArrow: '<div class="slick-prev"></div>',
        nextArrow: '<div class="slick-next"></div>',
        variableWidth: false,
        draggable: false,
        autoplay: false,
        autoplaySpeed: 1500
    });

});*/

$(function() {
   $('#main_bn').ulslide({
      statusbar: true,
      width: 570,
      height: 600, 
      affect: 'slide', 
      axis: 'x', 	
      navigator: '#main_bn_btn a',
      duration: 400, 
	  autoslide: 3000 
    });
});


