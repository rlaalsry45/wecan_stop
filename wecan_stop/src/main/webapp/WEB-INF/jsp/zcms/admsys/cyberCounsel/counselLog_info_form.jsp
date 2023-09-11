<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="homepagebbs">
	<li class="bg"><h3 class="sub">상담일지 등록</h3>
	<li>
		<div class="main_table" style="min-height:400px;">
			
			<input type="hidden" name="counselNo" value="${data.counselNo}" />
			
			<!--상담일지 등록 영역-->
			<table class="main_table1" summary="상담일지 등록 항목을 보여줍니다.">
				<tr>
					<td style="width:100px;text-align:right;">상담구분</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" name="counselClassification" id="counselClassification">
							<option value="0">선택해주세요</option>						
						</select>
					</td>
				</tr>
				<tr>
					<td style="width:100px;text-align:right;">성별</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" name="counselGender" id="counselGender" value="${data.counselGender}">
							<option value="0">선택해주세요</option>						
						</select>
					</td>
				</tr>
				<tr>
					<td style="width:100px;text-align:right;">국적</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" name="counselNation" id="counselNation" value="${data.counselNation}">
							<option value="0">선택해주세요</option>						
						</select>
					</td>
				</tr>
				<tr>
					<td style="width:100px;text-align:right;">관계</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" name="counselRelation" id="counselRelation" value="${data.counselRelation}">
							<option value="0">선택해주세요</option>						
						</select>
					</td>
				</tr>
				<tr>
					<td style="width:100px;text-align:right;">나이</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" name="counselAge" id="counselAge" value="${data.counselAge}">
							<option value="0">선택해주세요</option>						
						</select>
					</td>
				</tr>
				<tr>
					<td style="width:100px;text-align:right;">지역</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px; class="selectFst" onchange="categoryChange(this)" name="counselRegionParent" id="counselRegionParent">
							<option value="z">선택해주세요</option>
							<option value="REG001">서울특별시</option>
							<option value="REG011">부산광역시</option>
							<option value="REG010">대구광역시</option>
							<option value="REG003">인천광역시</option>
							<option value="REG015">광주광역시</option>
							<option value="REG007">대전광역시</option>
							<option value="REG012">울산광역시</option>
							<option value="REG017">세종특별자치시</option>
							<option value="REG016">제주특별자치도</option>
							<option value="REG004">강원도</option>
							<option value="REG002">경기도</option>
							<option value="REG009">경상남도</option>
							<option value="REG008">경상북도</option>
							<option value="REG013">전라북도</option>
							<option value="REG014">전라남도</option>
							<option value="REG006">충청남도</option>
							<option value="REG005">충청북도</option>
						</select>
						 &nbsp;
						<select style="width:200px;height:25px;" class="selectSnd" name="counselRegion" id="counselRegion">
							<option>선택해주세요</option>
						</select>
					</td>
				</tr>
				<tr>
					<td style="width:100px;text-align:right;">유형</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" name="counselType" id="counselType" value="${data.counselType}">
							<option value="0">선택해주세요</option>						
						</select>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">상담내용</td>
					<td style="text-align:left;">
						<textarea style="width:1100px;height:200px;" name="counselContent" id="counselContent"/>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">권익위상담번호</td>
					<td style="text-align:left;">
						<input style="width:200px;height:25px;" type="text" name="acrcNum" value="${data.acrcNum}"/>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">의뢰인명</td>
					<td style="text-align:left;">
						<input style="width:200px;height:25px;" type="text" name="counselClientName" value="${data.counselClientName}"/>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">휴대전화</td>
					<td style="text-align:left;">
						<input style="width:200px;height:25px;" type="text" name="counselTelNum" value="${data.counselTelNum}"/>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">접수채널</td>
					<td style="text-align:left;">
						<input style="width:200px;height:25px;" type="text" name="counselReceiptChannel" value="${data.counselReceiptChannel}"/>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">지속상담구분</td>
					<td style="text-align:left;">
						<select style="width:200px;height:25px;" class="selectSnd" name="counselCountinue" id="counselCountinue" value="${data.counselCountinue}">
							<option>선택해주세요</option>
							<option>지속상담</option>
							<option>일반상담</option>
						</select>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">조치내용</td>
					<td style="text-align:left;">
						<input style="width:1100px;height:25px;" type="text" name="counselActionContent" id="counselActionContent"/>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">조치내용상세</td>
					<td style="text-align:left;">
						<textarea style="width:1100px;height:200px;" name="counselActionContentDetail" id="counselActionContentDetail"/>
					</td>
				</tr>								
			
			</table>
			<!--/상담일지 등록 영역-->
		</div>
		<!--/main_table-->
		<div class="top_bt">
	       	<a id="action_registration_cancel" class="btmore01" href="javascript:return false;">취소</a>
	       	
	       	<c:choose>
				<c:when test="${mode eq 'reg'}"><a id="action_registration_data" class="btmore01" href="javascript:void(0);">등록</a></c:when>
				<c:when test="${mode ne 'reg'}"><a id="action_edit_data" class="btmore01" href="javascript:void(0);">수정</a></c:when>						
			</c:choose>
		</div>	   
	</li>
</ul>
<script>

	$(document).ready(function() {
		
	});

	var edit_save_flag="edit";
	var mode = '${mode}';console.log(mode);
	$(function(){
		setSelectBox();
		if ( mode == 'reg' ) {
			//all enable
			elementsDisabled(true);
			//blank data
		} else if ( mode == 'view' ) {
			//all disable
			elementsDisabled(false);
			//fill data
		} else if ( mode == 'edit' ) {
			//all enable
			//fill data			
		}
			
	});

	$("#action_registration_cancel").click(function(){
		if(confirm("취소하시겠습니까?")){
			if(mode == 'reg'){
				location.href = "<c:url value='/admsys/cyberCounsel/counselLog.html' />";
			}else if(mode == 'view'){
				location.href = "<c:url value='/admsys/cyberCounsel/counselLog.html' />";
/* 				elementsDisabled(false);
				$("#action_edit_data").text("수정");
				edit_save_flag = "edit"; */
			}
		}
	})
	
	$("#action_edit_data").click(function(){
		var txtVal = $("#action_edit_data").text();
		
		if(edit_save_flag == 'save') {
			if(confirm("저장 하시겠습니까?")){
				var str = $('#WCounselLogVO').serialize();
				console.log(str);
				$.ajax({
					  type: 'POST',
					  url: "/admsys/cyberCounsel/counselLog_update.html",
					  data: str,
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
				$("#action_edit_data").text("저장");
			}
		}
	})
	
	
	$("#action_registration_data").click(function(){
		if(confirm("등록 하시겠습니까?")){
			var str = $('#WCounselLogVO').serialize();
			console.log("reg:"+str);
			$.ajax({
				  type: 'POST',
				  url: "/admsys/cyberCounsel/counselLog_registration.html",
				  data: str,
				  success: function(result){
					  if ( result.retStatus == "SUCCESS" ) {
						  alert("등록 하였습니다.");console.log("AAA:"+result.no);
/* 						  var lastInsertNo = result.no;
						  viewDetailPage(lastInsertNo); */
						  location.href = "<c:url value='/admsys/cyberCounsel/counselLog.html' />";						  
					  } else {
						  alert("등록에 실패 하였습니다.");
					  }
				  },
				  error:function(){
					  alert("등록중 오류가 발생하였습니다.");  
				  }
			})
		}
	})
	
	function elementsDisabled(disabled) {
		if ( disabled == false ) {
			$('#contents input').attr('disabled', 'disabled');
			$('#contents select').attr('disabled', 'disabled');
			$('#contents textarea').attr('disabled', 'disabled');
		} else if ( disabled == true ) {
			$('#contents input').removeAttr('disabled');
			$('#contents select').removeAttr('disabled');
			$('#contents textarea').removeAttr('disabled');
		}
		
	}

	// selectbox value 셋팅
	function setSelectBox(){
		selectBoxValueSet('counselGender','GENDER');
		selectBoxValueSet('counselNation','NATION');
		selectBoxValueSet('counselClassification','COUNSEL');
		selectBoxValueSet('counselRelation','RELATION');
		selectBoxValueSet('counselAge','AGE');
		selectBoxValueSet('counselType','TYPE');
	}
	
	function selectBoxValueSet(id, paramText){
		var param = {};
		param["param"] = paramText;
		
	    $.ajax({
	         type: "POST"
	        ,url: "/admsys/cyberCounsel/selectbox.html"
	        ,data: param
	        ,dataType: "json"
	        ,success: function(data){
	        	for(var i in data){
	            	$('#'+id).append("<option value='"+data[i].code+"'>"+data[i].codeNm+"</option>");	            
	        	}
	        	if(mode == 'view'){
	    			$("#counselClassification").val('${data.counselClassification}');
	    			$("#counselGender").val('${data.counselGender}');
	    			$("#counselNation").val('${data.counselNation}');
	    			$("#counselRelation").val('${data.counselRelation}');
	    			$("#counselAge").val('${data.counselAge}');
	    			
	    			  var content_a = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
	    			  var value_a = ["R01001","R01002","R01003","R01004","R01005","R01006","R01007","R01008","R01009","R01010","R01011","R01012","R01013","R01014","R01015","R01016","R01017","R01018","R01019","R01020","R01021","R01022","R01023","R01024","R01025"];
	    			  
	    			  var content_b = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
	    			  var value_b = ["R11001","R11002","R11003","R11004","R11005","R11006","R11007","R11008","R11009","R11010","R11011","R11012","R11013","R11014","R11015","R11016"];
	    			  
	    			  var content_c = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
	    			  var value_c = ["R10001","R10002","R10003","R10004","R10005","R10006","R10007","R10008"];
	    			  
	    			  var content_d = ["계양구","남동구","동구","부평구","미추홀구","서구","연수구","중구","강화군","옹진군"];
	    			  var value_d = ["R03001","R03002","R03003","R03004","R03005","R03006","R03007","R03008","R03009","R03010"];
	    			  
	    			  var content_e = ["광산구","남구","동구","북구","서구"];
	    			  var value_e = ["R15001","R15002","R15003","R15004","R07001"];
	    	  
	    			  var content_f = ["대덕구","동구","서구","유성구","중구"];
	    			  var value_f = ["R07002","R07003","R07004","R07005","R07006"];
	    	  
	    			  var content_g = ["남구","동구","북구","중구","울주군"];
	    			  var value_g = ["R12001","R12002","R12003","R12004","R12005"];
	    			  
	    			  var content_h = [" - "];
	    			  var value_h = ["R17001"];
	    			  
	    			  var content_i = ["제주시","서귀포시"];
	    			  var value_i = ["R16001","R16002"];
	    	  
	    			  var content_j = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
	    			  var value_j = ["R04001","R04002","R04003","R04004","R04005","R04006","R04007","R04008","R04009","R04010","R04011","R04012","R04013","R04014","R04015","R04016","R04017","R04018"];
	    	  
	    			  var content_k = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","여주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","연천군"];
	    			  var value_k = ["R02001","R02002","R02003","R02004","R02005","R02006","R02007","R02008","R02009","R02010","R02011","R02012","R02013","R02014","R02015","R02016","R02017","R02018","R02019","R02020","R02021","R02022","R02023","R02024","R02025","R02026","R02027","R02028","R02029","R02030","R02031"];

	    			  var content_l = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
	    			  var value_l = ["R09001","R09002","R09003","R09004","R09005","R09006","R09007","R09008","R09009","R09010","R09011","R09012","R09013","R09014","R09015","R09016","R09017","R09018","R09019","R09020"];
	    		  
	    			  var content_m = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","양양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
	    			  var value_m = ["R08001","R08002","R08003","R08004","R08005","R08006","R08007","R08008","R08009","R08010","R08011","R08012","R08013","R08014","R08015","R08016","R08017","R08018","R08019","R08020","R08021","R08022","R08023"];

	    			  var content_n = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
	    			  var value_n = ["R13001","R13002","R13003","R13004","R13005","R13006","R13007","R13008","R13009","R13010","R13011","R13012","R13013","R13014"];

	    			  var content_o = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
	    			  var value_o = ["R14001","R14002","R14003","R14004","R14005","R14006","R14007","R14008","R14009","R14010","R14011","R14012","R14013","R14014","R14015","R14016","R14017","R14018","R14019","R14020","R14021","R14022"];

	    			  var content_p = ["계룡시","공주시","논산시","당진시","보령시","서산시","아산시","천안시","금산군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
	    			  var value_p = ["R06001","R06002","R06003","R06004","R06005","R06006","R06007","R06008","R06009","R06010","R06011","R06012","R06013","R06014","R06015","R06016"];

	    			  var content_q = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
	    			  var value_q = ["R05001","R05002","R05003","R05004","R05005","R05006","R05007","R05008","R05009","R05010","R05011","R05012"];
	    			  
	    			  var content_z = ["선택해주세요"];
	    			  
	    			  var target = document.getElementById("counselRegion");
	    			 
	    			  if('${data.counselRegionParent}' == "REG001") {var t = content_a; var v = value_a;}
	    			  else if('${data.counselRegionParent}' == "REG011") {var t = content_b; var v = value_b;} 
	    			  else if('${data.counselRegionParent}' == "REG010") {var t = content_c; var v = value_c;}
	    			  else if('${data.counselRegionParent}' == "REG003") {var t = content_d; var v = value_d;}
	    			  else if('${data.counselRegionParent}' == "REG015") {var t = content_e; var v = value_e;}
	    			  else if('${data.counselRegionParent}' == "REG007") {var t = content_f; var v = value_f;}
	    			  else if('${data.counselRegionParent}' == "REG012") {var t = content_g; var v = value_g;}
	    			  else if('${data.counselRegionParent}' == "REG017") {var t = content_h; var v = value_h;}
	    			  else if('${data.counselRegionParent}' == "REG016") {var t = content_i; var v = value_i;}
	    			  else if('${data.counselRegionParent}' == "REG004") {var t = content_j; var v = value_j;}
	    			  else if('${data.counselRegionParent}' == "REG002") {var t = content_k; var v = value_k;}
	    			  else if('${data.counselRegionParent}' == "REG009") {var t = content_l; var v = value_l;}
	    			  else if('${data.counselRegionParent}' == "REG008") {var t = content_m; var v = value_m;}
	    			  else if('${data.counselRegionParent}' == "REG013") {var t = content_n; var v = value_n;}
	    			  else if('${data.counselRegionParent}' == "REG014") {var t = content_o; var v = value_o;}
	    			  else if('${data.counselRegionParent}' == "REG006") {var t = content_p; var v = value_p;}
	    			  else if('${data.counselRegionParent}' == "REG005") {var t = content_q; var v = value_q;}
	    			  else if('${data.counselRegionParent}' == "z") {var t = content_z;}
	    			  
	    			  target.options.length = 0;
	    			 
	    			  for (x in t) {
	    			    var opt = document.createElement("option");
	    			    opt.value = v[x];
	    			    opt.innerHTML = t[x];
	    			    target.appendChild(opt);
	    			  }

	    			$("#counselRegionParent").val('${data.counselRegionParent}');
	    			$("#counselRegion").val('${data.counselRegion}');	
	    			$("#counselType").val('${data.counselType}');
	    			$("#counselContent").val('${data.counselContent}');
	    			$("#counselCountinue").val('${data.counselCountinue}');
	    			$("#counselActionContent").val('${data.counselActionContent}');
	    			$("#counselActionContentDetail").text('${data.counselActionContentDetail}');
	        	}
	        	
	        },error: function(data){
	        	alert("에러");
	        }        
	    });	
	}

	// 행정구역 선택 selectbox
	function categoryChange(e) {
		  var content_a = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
		  var value_a = ["R01001","R01002","R01003","R01004","R01005","R01006","R01007","R01008","R01009","R01010","R01011","R01012","R01013","R01014","R01015","R01016","R01017","R01018","R01019","R01020","R01021","R01022","R01023","R01024","R01025"];
		  
		  var content_b = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
		  var value_b = ["R11001","R11002","R11003","R11004","R11005","R11006","R11007","R11008","R11009","R11010","R11011","R11012","R11013","R11014","R11015","R11016"];
		  
		  var content_c = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
		  var value_c = ["R10001","R10002","R10003","R10004","R10005","R10006","R10007","R10008"];
		  
		  var content_d = ["계양구","남동구","동구","부평구","미추홀구","서구","연수구","중구","강화군","옹진군"];
		  var value_d = ["R03001","R03002","R03003","R03004","R03005","R03006","R03007","R03008","R03009","R03010"];
		  
		  var content_e = ["광산구","남구","동구","북구","서구"];
		  var value_e = ["R15001","R15002","R15003","R15004","R07001"];
  
		  var content_f = ["대덕구","동구","서구","유성구","중구"];
		  var value_f = ["R07002","R07003","R07004","R07005","R07006"];
  
		  var content_g = ["남구","동구","북구","중구","울주군"];
		  var value_g = ["R12001","R12002","R12003","R12004","R12005"];
		  
		  var content_h = [" - "];
		  var value_h = ["R17001"];
		  
		  var content_i = ["제주시","서귀포시"];
		  var value_i = ["R16001","R16002"];
  
		  var content_j = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
		  var value_j = ["R04001","R04002","R04003","R04004","R04005","R04006","R04007","R04008","R04009","R04010","R04011","R04012","R04013","R04014","R04015","R04016","R04017","R04018"];
  
		  var content_k = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","여주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","연천군"];
		  var value_k = ["R02001","R02002","R02003","R02004","R02005","R02006","R02007","R02008","R02009","R02010","R02011","R02012","R02013","R02014","R02015","R02016","R02017","R02018","R02019","R02020","R02021","R02022","R02023","R02024","R02025","R02026","R02027","R02028","R02029","R02030","R02031"];

		  var content_l = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
		  var value_l = ["R09001","R09002","R09003","R09004","R09005","R09006","R09007","R09008","R09009","R09010","R09011","R09012","R09013","R09014","R09015","R09016","R09017","R09018","R09019","R09020"];
	  
		  var content_m = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","양양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
		  var value_m = ["R08001","R08002","R08003","R08004","R08005","R08006","R08007","R08008","R08009","R08010","R08011","R08012","R08013","R08014","R08015","R08016","R08017","R08018","R08019","R08020","R08021","R08022","R08023"];

		  var content_n = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
		  var value_n = ["R13001","R13002","R13003","R13004","R13005","R13006","R13007","R13008","R13009","R13010","R13011","R13012","R13013","R13014"];

		  var content_o = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
		  var value_o = ["R14001","R14002","R14003","R14004","R14005","R14006","R14007","R14008","R14009","R14010","R14011","R14012","R14013","R14014","R14015","R14016","R14017","R14018","R14019","R14020","R14021","R14022"];

		  var content_p = ["계룡시","공주시","논산시","당진시","보령시","서산시","아산시","천안시","금산군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
		  var value_p = ["R06001","R06002","R06003","R06004","R06005","R06006","R06007","R06008","R06009","R06010","R06011","R06012","R06013","R06014","R06015","R06016"];

		  var content_q = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
		  var value_q = ["R05001","R05002","R05003","R05004","R05005","R05006","R05007","R05008","R05009","R05010","R05011","R05012"];
		  
		  var content_z = ["선택해주세요"];
		  
		  var target = document.getElementById("counselRegion");
		 
		  if(e.value == "REG001") {var t = content_a; var v = value_a;}
		  else if(e.value == "REG011") {var t = content_b; var v = value_b;} 
		  else if(e.value == "REG010") {var t = content_c; var v = value_c;}
		  else if(e.value == "REG003") {var t = content_d; var v = value_d;}
		  else if(e.value == "REG015") {var t = content_e; var v = value_e;}
		  else if(e.value == "REG007") {var t = content_f; var v = value_f;}
		  else if(e.value == "REG012") {var t = content_g; var v = value_g;}
		  else if(e.value == "REG017") {var t = content_h; var v = value_h;}
		  else if(e.value == "REG016") {var t = content_i; var v = value_i;}
		  else if(e.value == "REG004") {var t = content_j; var v = value_j;}
		  else if(e.value == "REG002") {var t = content_k; var v = value_k;}
		  else if(e.value == "REG009") {var t = content_l; var v = value_l;}
		  else if(e.value == "REG008") {var t = content_m; var v = value_m;}
		  else if(e.value == "REG013") {var t = content_n; var v = value_n;}
		  else if(e.value == "REG014") {var t = content_o; var v = value_o;}
		  else if(e.value == "REG006") {var t = content_p; var v = value_p;}
		  else if(e.value == "REG005") {var t = content_q; var v = value_q;}
		  else if(e.value == "z") {var t = content_z;}
		  
		  target.options.length = 0;
		 
		  for (x in t) {
		    var opt = document.createElement("option");
		    opt.value = v[x];
		    opt.innerHTML = t[x];
		    target.appendChild(opt);
		  } 
		}		

</script>