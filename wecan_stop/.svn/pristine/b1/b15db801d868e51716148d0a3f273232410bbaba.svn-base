var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL      = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};

function ready(event) {
    if (event.type === 'submit' || ((event.type === 'keydown' || event.type === 'keypress') && event.keyCode === 13)) {
        if (document.getElementById('username').value === '') {
            document.getElementById('username').focus();
            return false;
        }
        if (document.getElementById('password').value === '') {
            document.getElementById('password').focus();
            return false;
        }
        var shaPw = CryptoJS.SHA256($('#password').val()).toString(); 
        $('#password').val(shaPw);
        //document.getElementById('signin').submit();
        return true;
        
    }
}

$(document).ready(function () {
    if (document.getElementById('username').value === '') {
        document.getElementById('username').focus();
    }
    else if (document.getElementById('password').value === '') {
        document.getElementById('password').focus();
    }

    if (getUrlParameter('fail') === 'true') {
        $('#alert-ng').css('display', '');
    } else if (getUrlParameter('pwfail') ==='true') {
        $('#alert-ng').css('display', '');
    }
});
