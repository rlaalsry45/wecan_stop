function viewloader() {
    //화면의 높이와 너비를 구한다.
    var height = $(document).height();
//      var maskWidth = $(document).width();
    var width  = window.document.body.clientWidth;

    var mask = "<div id='mask' style='position:absolute; z-index:9000; background-color:#000000; display:none; left:0; top:0;'></div>";
    var limg = '';
    limg += "<div id='loadingImg' style='position:absolute; left:50%; top:40%; display:none; z-index:10000;'>";
    limg += "    <img src='/com/art/loading.gif'/>";
    limg += "</div>";

    //화면에 레이어 추가
    $('body').append(mask).append(limg);

    //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
    $('#mask').css({'width': width, 'height': height, 'opacity': '0.3'});

    //마스크 표시
    $('#mask').show();

    //로딩중 이미지 표시
    $('#loadingImg').show();

    return true;
}

function hideloader() {
    $('#mask, #loadingImg').hide();
    $('#mask, #loadingImg').remove();
    return true;
}
