<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/vendor/jquery.ui.widget.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.iframe-transport.js"/>'></script>
<script type='text/javascript' src='<c:url value="/com/js/fileupload/jquery.fileupload.js"/>'></script>
<ul class="homepagebbs">
	<li class="bg"><h3 class="sub">언론모니터링 <c:choose>
				<c:when test="${mode eq 'reg'}">등록</c:when>
				<c:when test="${mode eq 'view'}">보기</c:when></c:choose>
				</h3>
	<li>
		<div class="main_table" style="min-height:400px;">
			
			<input type="hidden" id="NO" name="NO" value="${data.NO}" />
			<input type="hidden" id="pmode" name="pmode" value="${mode}" />
			
			<!--언론모니터링 등록 영역-->
			<table class="main_table1" summary="언론모니터링 등록 항목을 보여줍니다.">
				<tr>
					<td>기사명</td>
					<td style="text-align: left;"><input type="text" id="article_title" name="article_title" value="${data.article_title}" /></td>
				</tr>
				<tr>
					<td>연관 상담 번호</td>
					<td style="text-align: left;">
						<ul id="consultingUL" style="column-count: 3;">
						<c:forEach items="${conList}" var="a" varStatus="ai">
							<li data-no="${a.con_ac_no}" id="culli_${a.con_ac_no}">${a.consulting_action_no}
							<a id="dv_${a.con_ac_no}" class="btmore01" href="#" onclick="javascript:conView('${a.con_ac_no}');return false;">View</a>
							<a id="dd_${a.con_ac_no}" class="btmore01" href="#" onclick="javascript:delConsultingList('${a.con_ac_no}');return false;">X</a></li>
						</c:forEach>
						</ul>
						<a id="searchConsultingSrchListPop" class="btmore01" href="javascript:return void(0);">상담 등록</a>
					</td>
				</tr>
				<tr>
					<td>연관 조치 번호</td>
					<td style="text-align: left;">
						<ul id="actionUL" style="column-count: 3;">
						<c:forEach items="${acList}" var="a" varStatus="ai">
							<li data-no="${a.con_ac_no}" id="aulli_${a.con_ac_no}">${a.consulting_action_no}
								<a id="av_${a.con_ac_no}" class="btmore01" href="#" onclick="javascript:actView('${a.con_ac_no}');return false;">View</a>
								<a id="aa_${a.con_ac_no}" class="btmore01" href="#" onclick="javascript:delActionList('${a.con_ac_no}');return false;">X</a>
							</li>
						</c:forEach>
						</ul>
						<a id="searchActionSrchListPop" class="btmore01" href="javascript:return void(0);">조치 등록</a>
					</td>
				</tr>
				<tr>
					<td>URL</td>
					<td style="text-align: left;">
						<input type="text" id="rel_event_url" name="rel_event_url" value="${data.rel_event_url}" />
							<a class="btmore01" href="${data.rel_event_url}" target="_blank">View</a>
					</td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td style="text-align: left;">
						<a id="pressUploadBtn" class="btmore05" onclick="return attach();">+ 파일 등록</a>
						<input id="upload" type="file" name="file" 
								data-url="/admsys/commonFile/attach.html" 
								data-form-data='{menu_cate: "press",menu_no:"${data.NO}"}'
								multiple style="opacity: 0; filter:alpha(opacity: 0);"><br/>
						<ul id="fileListUL" style="column-count: 2;">
						<c:forEach items="${fileList}" var="f" varStatus="fi">
							<li data-no="${f.NO}" data-type="old" id="ulliFile_${f.NO}">${f.file_name}
								<a id="bb_${f.NO}" class="btmore01" href="#" onclick="javascript:pickup('${f.NO}');return false;">받기</a>
								<a id="cc_${f.NO}" class="btmore01" href="#" onclick="javascript:detach('${f.NO}','${f.file_name}');return false;">삭제</a>
							</li>
						</c:forEach>
						</ul>
					</td>
				</tr>
			</table>
			<!--/상담일지 등록 영역-->
		</div>
		<!--/main_table-->
		<div class="top_bt">
	       	<a id="press_registration_cancel" class="btmore01" href="javascript:return false;">취소</a>
	       	<c:choose>
				<c:when test="${mode eq 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
							<a id="press_registration_data" class="btmore01" href="javascript:void(0);">등록</a>
						</c:if>
					</c:forEach>
				</c:when>
				<c:when test="${mode ne 'reg'}">
					<c:forEach items="${perm}" var="p" varStatus="ini">
						<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
							<a id="press_edit_data" class="btmore01" href="javascript:void(0);">수정</a>
						</c:if>
					</c:forEach>
				</c:when>						
			</c:choose>
		</div>	   
	</li>
</ul>
<script>
	var edit_save_flag="edit";
	
	var mode = '${mode}';
	
	$(function(){
		if ( mode == 'reg' ) {
			//all enable
			elementsDisabled(true);
			//blank data
		} else if ( mode == 'view' ) {
			//all disable
			elementsDisabled(false);
			$("#press_registration_cancel").text("목록");
			//fill data
		} else if ( mode == 'edit' ) {
			//all enable
			//fill data
		} else {
			//???
		}
		
        $('#upload').fileupload({
            dataType: 'json',
            done    : function (e, data) {
            	appendFileInfo(data.result[0].name, data.result[0].no);
            }
        });
        
    	$("#searchActionSrchListPop").click(function(){
    		PopupCenter('/admsys/orgculturedigmng/picdigmng.html?mode=POP','popupSearchCAList','1000','700');
    	});
    	
    	$("#searchConsultingSrchListPop").click(function(){
    		PopupCenter('/admsys/consultingmng/consulting.html?mode=POP','popupSearchCAList','1000','700');	
    	});
    	
    	$("#press_registration_cancel").click(function(){
    		if ( mode == "view" && edit_save_flag == 'edit' ) {
    			location.reload();
    			//location.href = "<c:url value='/admsys/administration/index.html' />";
    		} else {
        		if(confirm("취소하시겠습니까?")){
        			if ( mode == "reg" ) {
        				location.reload();
        				//location.href = "<c:url value='/admsys/administration/index.html' />";
        			} else if ( mode == "view" ) {
        				if(edit_save_flag == 'save') {
            	  			$("#editReason").hide();
                			$("#editReasonHistoryList").show();
                			elementsDisabled(false);
                			$("#press_edit_data").text("수정");
                			$("#press_registration_cancel").text("목록");
                			edit_save_flag = "edit";
        				}
        			}
        		}
    		}
    	});
    	
    	$("#press_edit_data").click(function(){
    		if(edit_save_flag == 'save') {

    			if(confirm("수정 하시겠습니까?")){
    				
/*     				if ( $("#rel_event_url").val() != "" ) {
    					if ( $("#protocol_type").val() == "" ) {
    						alert("주소 입력시 http, https 유형을 선택 해 주셔야 합니다. 주소칸에 http, https 를 입력 하시면 안됩니다.");
    						$("#protocol_type").focus();
    						return;
    					}
    				} */
    				
    				var str = $('#PressVo').serialize();
    				
    				var actionULArray = new Array();
    				actionULArray = getUL_li_no("actionUL");
    				
        			var consultingULArray = new Array();
        			consultingULArray = getUL_li_no("consultingUL");
    				
    				var fileULArray = new Array();
    				fileULArray = getUL_li_no("fileListUL");
    				
    				$.ajax({
    					  type: 'POST',
    					  url: "/admsys/administration/press_update.html",
    					  data: str 
    					  		+	"&con_ac_type=ac" 
    					  		+	"&actionNoList="+actionULArray
    					  		+	"&consultingNoList="+consultingULArray
    					  		+	"&fileList="+fileULArray,
    					  success: function(result){
    						  if ( result.retStatus == "SUCCESS" ) {
    							  alert("수정 하였습니다.");
    						  } else {
    							  alert("수정에 실패 하였습니다.");
    						  }
    					  },
    					  error:function(){
    						  alert("수정중 오류가 발생하였습니다.");  
    					  }
    				})
    			}
    		}else if(edit_save_flag == 'edit') {
    			if(confirm("수정 하시겠습니까?")){
    				elementsDisabled(true);
    				edit_save_flag="save";
    				$("#editReason").show();
    				$("#editReasonHistoryList").hide();
    				$("#press_edit_data").text("저장");
    				$("#press_registration_cancel").text("취소");
    			}
    		}
    	});
    	
    	$("#press_registration_data").click(function(){
    		if(confirm("등록 하시겠습니까?")){
    			var str = $('#PressVo').serialize();
    			var actionULArray = new Array();
    			actionULArray = getUL_li_no("actionUL");
    			
    			var consultingULArray = new Array();
    			consultingULArray = getUL_li_no("consultingUL");
    			
    			var fileULArray = new Array();
    			fileULArray = getUL_li_no("fileListUL");
    			
    			$.ajax({
    				  type: 'POST',
    				  url: "/admsys/administration/press_registration.html",
    				  data: str 
    				  		+ "&con_ac_type=ac" 
    				  		+ "&actionNoList="+actionULArray
    				  		+ "&consultingNoList="+consultingULArray
    				  		+ "&fileList="+fileULArray,
    				  traditional: true,
    				  success: function(result){
    					  if ( result.retStatus == "SUCCESS" ) {
    						  alert("등록 하였습니다.");
    						  var lastInsertNo = result.no;
    						  viewDetailPage(lastInsertNo);
    					  } else {
    						  alert("등록에 실패 하였습니다.");
    					  }
    				  },
    				  error:function(){
    					  alert("등록중 오류가 발생하였습니다.");  
    				  }
    			})
    		}
    	});
	});

	
	
	function elementsDisabled(disabled) {
		if ( disabled == false ) {
			$('#contents input').attr('disabled', 'disabled');
			$('#contents select').attr('disabled', 'disabled');
			$('#contents textarea').attr('disabled', 'disabled');
			$('#searchConsultingSrchListPop').hide();
			$('#searchActionSrchListPop').hide();
			$("a[id^=aa_]").hide();
			$("a[id^=cc_]").hide();
			$("a[id^=dd_]").hide();
			$("#pressUploadBtn").hide();
		} else if ( disabled == true ) {
			$('#contents input').removeAttr('disabled');
			$('#contents select').removeAttr('disabled');
			$('#contents textarea').removeAttr('disabled');
			$('#searchConsultingSrchListPop').show();
			$('#searchActionSrchListPop').show();
			$("a[id^=aa_]").show();
			$("a[id^=cc_]").show();
			$("a[id^=dd_]").show();
			$("#pressUploadBtn").show();
		}
		

		// 예외 항목
		//$("#userId").attr("disabled", false);
	}

	function delActionList(no) {
		$("#actionUL #aulli_"+no).remove();
	}
	
	function addACtion(objList) {
		var ulLen = $("#actionUL li").length;
		if( ulLen == 0 ) {
			for( var i=0;i < objList.length; i++ ) {
				$("#actionUL").append('<li data-no="'+objList[i].no+'" id="aulli_'+objList[i].no+'">'+objList[i].an
						+'<a id="av_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:actView('+objList[i].no+');return false;">View</a>'
						+'<a id="aa_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delActionList('+objList[i].no+');return false;">X</a></li>');
			}
		} else {
			var ulArray = new Array();
			for( var i = 0; i < ulLen; i++ ) {	
				var liNo = $("#actionUL li:eq("+i+")").data("no");
				ulArray.push(liNo);
			}
			for( var i=0;i < objList.length; i++ ) {				
				var wNo = objList[i].no;
				var exists = true;
				for( var j=0; j < ulArray.length; j++){
					if ( wNo == ulArray[j] ) {
						exists = false;
						break;
					}
				}

				if ( exists ) {
					$("#actionUL").append('<li data-no="'+objList[i].no+'" id="aulli_'+objList[i].no+'">'+objList[i].an
							+'<a id="av_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:actView('+objList[i].no+');return false;">View</a>'
							+'<a id="aa_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delActionList('+objList[i].no+');return false;">X</a></li>');
				}					
			}
		}
	}
	
	function delConsultingList(no) {
		$("#consultingUL #culli_"+no).remove();
	}
	
	function addConsulting(objList) {
		var ulLen = $("#consultingUL li").length;
		if( ulLen == 0 ) {
			for( var i=0;i < objList.length; i++ ) {
				$("#consultingUL").append('<li data-no="'+objList[i].no+'" id="culli_'+objList[i].no+'">'+objList[i].an
						+'<a id="dv_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:conView('+objList[i].no+');return false;">View</a>'
						+'<a id="dd_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delConsultingList('+objList[i].no+');return false;">X</a></li>');
			}
		} else {
			var ulArray = new Array();
			for( var i = 0; i < ulLen; i++ ) {	
				var liNo = $("#consultingUL li:eq("+i+")").data("no");
				ulArray.push(liNo);
			}
			for( var i=0;i < objList.length; i++ ) {				
				var wNo = objList[i].no;
				var exists = true;
				for( var j=0; j < ulArray.length; j++){
					if ( wNo == ulArray[j] ) {
						exists = false;
						break;
					}
				}

				if ( exists ) {
					$("#consultingUL").append('<li data-no="'+objList[i].no+'" id="culli_'+objList[i].no+'">'+objList[i].an
							+'<a id="dv_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:conView('+objList[i].no+');return false;">View</a>'
							+'<a id="dd_'+objList[i].no+'" class="btmore01" href="#" onclick="javascript:delConsultingList('+objList[i].no+');return false;">X</a></li>');
				}					
			}
		}
	}

    function attach() {
        $("#upload").trigger('click');
        return false;
    }
    
    function pickup(no) {
        document.location = "/admsys/commonFile/download.html?no=" + encodeURIComponent(no);
        return false;
    }

    function detach(no, name) {
        alertify.confirm(name + ' 파일을 삭제 하시겠습니까?', function (e) {
            if (e) {
                $.get("/admsys/commonFile/detach.html?no=" + no, function (result) {
                    if (result) {
                    	$("#fileListUL #ulliFile_"+no).remove();
                    }
                });
            }
        });
        return false;
    }
    
    function appendFileInfo(name, no) {
    	$("#fileListUL").append('<li data-no="'+no+'" data-type="new" id="ulliFile_'+no+'">'+name+
				'<a id="bb_'+no+'" class="btmore01" href="#" onclick="javascript:pickup('+no+');return false;">받기</a>'+
				'<a id="cc_'+no+'" class="btmore01" href="#" onclick="javascript:detach('+no+',\''+name+'\');return false;">삭제</a>'+
				'</li>');

    }
    
    function getUL_li_no(ulId){
		var ulArray = new Array();
		var ulLen = $("#"+ulId+" li").length;
		for( var i = 0; i < ulLen; i++ ) {	
			var liNo = $("#"+ulId+" li:eq("+i+")").data("no");
			
			if ( ulId == 'fileListUL' ) {
				var liType = $("#"+ulId+" li:eq("+i+")").data("type");
				if ( liType == "new" ) {
					ulArray.push(liNo);
				}
			} else {
				ulArray.push(liNo);
			}
			
		}
		return ulArray;
    }
    
	function conView(no) {
		PopupCenter('/admsys/consultingmng/consulting_view_pop.html?NO='+no, 'conView','1000','700');
	}

	function actView(no) {
		PopupCenter('/admsys/orgculturedigmng/picdigmng_view_pop.html?actionNO='+no, 'actView','1000','700');
	}
</script>