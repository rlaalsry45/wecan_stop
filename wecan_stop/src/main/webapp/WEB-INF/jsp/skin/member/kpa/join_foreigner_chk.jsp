<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
	$(function () {
		/* gnb */
		$("#gnb > li").eq(5).addClass("on");
	});
	var lnbnum=1;
	var lnbsubnum=0;

	function foreigner_join(){
		if(confirm("It's available only for foreigners. Continue?")){
			window.location.href="/${subname}/?menuno=2612&foreigner=1";
		}
	}
</script>
<style>
a.btn_foreigner{display:inline-block;background:#495a74;height:41px;line-height:41px;color:#fff;font-size:16px;font-weight:600;padding:0 30px;}
</style>
<div class="cont-right">
	<h3 class="ctit">JOIN</h3>
	<div class="join-box-bottom">
		<div class="join-box-top">
			<div class="principal">
				<strong>If you are to be our member, you can have more services.</strong>
				<ul class="clist02">
			<li style="font-size:12px;">Korea Planning Association has the policy to check your request ID to avoid duplication.</li>
		</ul>
				<a href="javascript:foreigner_join();" class="btn_foreigner">Foreigner Registration</a>
			</div>
		</div>
	</div>
</div>
