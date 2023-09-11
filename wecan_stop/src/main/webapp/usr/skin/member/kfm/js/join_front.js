$(function(){
	
	var frm = $("form[name='frm']");
	$("#submit_a").click(function(){
		$("#usertype").val("a");
		frm.submit();
	});
	$("#submit_b").click(function(){
		$("#usertype").val("b");
		frm.submit();
	});
	$("#submit_c").click(function(){
		$("#usertype").val("c");
		$("#act").val("terms");
		frm.submit();
	});
});