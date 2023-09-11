<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
function input_menuscore(menuno,siteno){
	
	var score = $(".radio:checked").val();
	if(score == undefined){
		alert('만족도를 선택하여 주시기 바랍니다');
		return;
	}
	
	 $.ajax({ 
		type: 'post' 
		, url: '/front/menuscore/input/'+menuno+'/'+siteno+'/'+score+'.html' 
		, success: function(data) {
			//console.log(data);
			if(data=='1'){
				alert('만족도가 입력되었습니다. 감사합니다.');
			}else if(date='99'){
				alert('해당페이지에 대한 만족도를 이미 입력하셨습니다. 감사합니다. ');
			}else{
				alert('서버와의 통신이 실패했습니다. 다시 한번 시도해 주시기 바랍니다.');
			}

		} 
		, error: function(data, status, err) { 
			alert('서버와의 통신이 실패했습니다.'); 
		}
	});
}
</script>
<div class="select001">
	<strong>이 페이지에서 제공하는 정보에 만족하셨습니까?</strong>
	<div>
		<label for="select">매우만족</label>
		<input type="radio" id="select" class="radio" name="select" value="5" />
		<label for="select2">만족</label>
		<input type="radio" id="select2" class="radio" name="select" value="4" />
		<label for="select3">보통</label>
		<input type="radio" id="select3" class="radio" name="select" value="3" />
		<label for="select4">불만</label>
		<input type="radio" id="select4" class="radio" name="select" value="2" />
		<label for="select5">매우불만</label>
		<input type="radio" id="select5" class="radio" name="select" value="1" />
		<a href="javascript:input_menuscore('${menuno}','${siteno}')"><img src="/usr/images/common/btn_conf.gif" alt="확인" /></a>
	</div>
</div>