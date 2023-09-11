$(function(){
	$("#submit_b").click(function(){
		if ($("#userid").val()==""||!isEmail($("#userid").val())){
			alert("Please observe e-mail format.");
			$("#userid").focus();
			$("#userid").select();
			return false;
		}else{
		//frm.attr("action","/skin/member/kf/do_find.html");
		//frm.submit();
			var postdata = "userid="+$("#userid").val()+"&ztag="+encodeURI($("#ztag").val())+"&menuno="+$("#menuno").val();
			$.ajax({ 
				type: 'post' 
				, async: true 
				, url: '/usr/skin/member/kf/do_find.html' 
				, data: postdata
				, success: function(data) { 
					if (data=="success"){
						alert("Email has been sent. Please check your email.");
						window.location.href="/";
					}
					else{
						alert("Communication with the server failed.");
						
					}

				} 
				, error: function(data, status, err) { 
					alert('Communication with the server failed.'); 
				}

			});
		}

	});
	
	function isEmail(email) {
		var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		return regex.test(email);
	}
});