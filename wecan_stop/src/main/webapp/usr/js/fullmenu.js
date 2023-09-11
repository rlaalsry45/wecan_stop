$(document).ready(function () {
    $("#view").click(function () {
        $("#fullmenu").slideDown("fast");
        return false;
    });
    $(".close").click(function () {
        $("#fullmenu").hide();
        return false;
    });
});