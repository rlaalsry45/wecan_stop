<%@ page contentType="text/html;charset=utf-8" %>
<link rel="stylesheet" type="text/css" href="/var/alertify/alertify.css"/>
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/var/alertify/alertify.js"></script>
<script type="text/javascript">
	var subname = "${subname}";
    var href = "${href}";
    var menu = "${menu}";
    var back = "${back}";
    var data = "${data}";
    var msg = "${msg}";

    if(msg) alert(msg);
    
    var goto = "/";
    
    if(subname) goto += subname+"/";
    
    if (menu) {
        goto += "?menuno=${menu}"
    } else if (href) {
        goto = "${href}";
    }

    var to_subname = "/";
    
    if(subname) to_subname += subname+"/";
    
    if (back) {
        goto += "&_to="+to_subname+"?menuno=" + back;
    }
    if (data) {
        goto += "&" + data;
    }
    
    location.href = goto;
</script>
