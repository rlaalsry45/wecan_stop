<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
		
	 if ("true"=="${close}"){
		$("#skin${layerpopupcount}").hide();
	}
	$(function(){
		
		$("#skin${layerpopupcount}").center${layerpopupcount}().show();
		$("#layerclose${layerpopupcount}").bind("click",function(event){

			if ($("#close${layerpopupcount}").is(":checked")){
				/* var frm = $("form[name='layerpopup_default${layerpopupcount}']");
				frm.submit(); */
				
				$.ajax({ 
					type: 'post' 
					, async: true 
					, url: '/skin/layerpopup/default/layerpopup_cookie.html' 
					, data: "menuno=${param.menuno}&layerpopupno=${layerpopupVo.layerpopupno}"
					, success: function(data) { 
						
					} 
					, error: function(data, status, err) { 
						alert('서버와의 통신이 실패했습니다.'); 
					}
				
				});
			}
			
			$("#skin${layerpopupcount}").hide();
			
		});
	});
	jQuery.fn.center${layerpopupcount} = function () {
		
		this.css("position","absolute");
		this.css("top","${windowTop}px");
		this.css("left","${windowLeft}px");
		
		/* if("${layerpopupmcount}"=="1"){
			this.css("top",Math.max(0,(($(window).height()-$(this).outerHeight())/2)+$(window).scrollTop())+${layerpopupcount}*330-495+"px");
			//this.css("left",Math.max(0, (($(window).width()-$(this).outerWidth())/2)+$(window).scrollLeft()));
			this.css("left",Math.max(0,(($(window).width()-$(this).outerWidth())/2)+$(window).scrollLeft())+${layerpopupcount}*-495+"px");
		}else if("${layerpopupmcount}"=="2"){
			this.css("top",Math.max(0,(($(window).height()-$(this).outerHeight())/2)+$(window).scrollTop()));
			this.css("left",Math.max(0,(($(window).width()-$(this).outerWidth())/2)+$(window).scrollLeft())+${layerpopupcount}*330-495+"px");
		}else if("${layerpopupmcount}"=="3"){
			this.css("top",Math.max(0,(($(window).height()-$(this).outerHeight())/2)+$(window).scrollTop()));
			this.css("left",Math.max(0,(($(window).width()-$(this).outerWidth())/2)+$(window).scrollLeft())+${layerpopupcount}* 330-660+"px");
		}else{
			this.css("top",Math.max(0,(($(window).height()-$(this).outerHeight())/2)+$(window).scrollTop())+${layerpopupcount}*30+"px");
			this.css("left",Math.max(0,(($(window).width()-$(this).outerWidth())/2)+$(window).scrollLeft())+${layerpopupcount}*50-200+"px");
		} */
		return this;
	}
</script>
	<!-- 레이어 팝업 -->
	
	<div id="skin${layerpopupcount}" style="width:${windowWidth}px;height:${windowHeight+35}px;background:#f1f0ef;z-index:999;display:none">
		<div class="layer-pop">
			<form name="layerpopup_default${layerpopupcount}" method="post" action="/skin/layerpopup/default/layerpopup_cookie.html">
				<input type="hidden" name="menuno" value="${param.menuno}" />
				<input type="hidden" name="layerpopupno" value="${layerpopupVo.layerpopupno}" />
				<c:if test="${layerpopupVo.popupimg != null }" >
					<div class="popup_img"  style="padding:5px 5px 0 5px;">
						<img src="/usr/upload/layerpopup/${layerpopupVo.popupimg}" width="${windowWidth-10}px" alt="팝업이미지">
					</div>
				</c:if>
				<div style="margin:5px 0 0 10px;width:${windowWidth-20}px;overflow:hidden;">
					<strong style="font-size:16px;line-height:18px;color:#333333;">${layerpopupVo.title}</strong>
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${layerpopupVo.popupimg != null }"> --%>
<%-- 							<p style="margin-top:5px;font-size:14px;line-height:18px;color:#666666;">${layerpopupVo.conts}</p> --%>
<%-- 						</c:when> --%>
<%-- 						<c:otherwise> --%>
<%-- 							<p style="margin-top:5px;font-size:14px;line-height:18px;color:#666666;">${layerpopupVo.conts}</p> --%>
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>
				<div class="layerpopup_footer" style="width:100%;height:25px;padding-top:6px;background:#000000;text-align:right;position:absolute;bottom:0;left:0;">
					<!--오늘 하루 이 창을 열지 않음 시작-->
					<c:if test='${layerpopupVo.today == "1"}'>
						<span class="layerpopup_today"><input type="checkbox" id="close${layerpopupcount}" style="vertical-align:-2px;" /> <label for="close" style="color:#ffffff;">오늘 하루 이 창을 열지 않음</label></span>
					</c:if>
					<!--/오늘 하루 이 창을 열지 않음 끝-->
					<span style="margin:0 10px;"><a href="javascript:void(0);" id="layerclose${layerpopupcount}"><img style="vertical-align:top;" src="/usr/skin/layerpopup/default/images/btn_popup_close.png" alt="닫기" border="0"/></a></span>
				</div>
			</form>
		</div>
	</div>
</div>
	<!-- 레이어 팝업 -->
