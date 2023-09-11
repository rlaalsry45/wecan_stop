<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp"%>
<% pageContext.setAttribute("crlf","\r\n"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="/cms/css/aprov/popup.css" /> 
<script type="text/javascript" src="/com/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">

function callcontury(val){
	if(val=='')return;
	$.ajax({
		async:false ,
	    type:"POST", 
	    url: '/admsys/koreastudy/getcountry.html',
	    dataType : 'text',
	    data: 'continent='+ val ,
	    processData: false,
	    error    : function(r) {
	         
	    },
	    success: function(data) { 
	    	var s='';  
	    	s+='<select name="country" id="country"  style="width:200px">';
	    	s+='<option value="">Select</option>';
	    	s+=data;
	    	s+='</select> ';
	        document.getElementById('country').outerHTML=s;
	    }
	  });
	
}

function valid(){
	if(document.getElementById('continent').value==''){
		alert('Region 을 선택 하세요');
		return false;
	}
	if(document.getElementById('country').value==''){
		alert('Country 을 선택 하세요');
		return false;
	}
	return true;
}


function save(){
	if(! valid())return;
	if(!confirm('저장 하시겠습니까?'))return;
	document.forms[0].action='/admsys/koreastudy/tran.html'; 
	document.getElementById('target').value="1";
	document.forms[0].submit();
	
}

function update(){
	if(! valid())return;
	if(!confirm('저장 하시겠습니까?'))return;
	document.getElementById('target').value="2";
	document.forms[0].action='/admsys/koreastudy/tran.html'; 
	document.forms[0].submit();
}
 
function del(){
	if(!confirm('삭제 하시겠습니까?'))return;
	document.getElementById('target').value="3";
	document.forms[0].action='/admsys/koreastudy/tran.html'; 
	document.forms[0].submit();
}

</script>
</head>
<body>
<form:form method="post" id="koreastudy" name="koreastudy"  >
		 
				<input type="hidden" id="target" name="target" />   
		        	 <input type="hidden" id="tbody_idx" name="tbody_idx" value="${detail.tbody_idx}"/>  
				<input type="hidden" id="idx" name="idx" value="${detail.idx}"/>   
	<div id="popup-wrap" class="type">
		<h1><img src="/cms/image/aprov/popup/tit/ptit_atmosphere.gif" alt="컨텐츠 배포 승인요청" /></h1>
		<div id="container">
			
			<c:choose>
							 
							<c:when test='${detail.idx==""  }'>
			<table><tr>
						<th>구분
						</th>
						<td>
						<input type="radio" name="category_code" value="A0001"  onclick="location.href='insert.html?typ=1&idx=';"
														    
														    >Universities
							<input type="radio" name="category_code" value="A0002" onclick="location.href='insert.html?typ=2&idx=';"  >Centers
							<input type="radio" name="category_code" checked value="B0000"  >Associations
							<input type="radio" name="category_code" value="C0001"  onclick="location.href='insert.html?typ=4&idx=';" >Research Institutes
							
						</td>
						</tr>
						</table>
						</c:when>
						<c:otherwise> 
						
						  <input type="hidden" id="category_code" name="category_code" value="${detail.category_code}"/>  
						</c:otherwise>
						</c:choose>
			
		  <div class="l-cont">
			<h3 class="ctit">기관</h3>
				  <table class="input_table" summary="Region, Country, State/Province, Association, President, Address, Tel, Fax, E-mail, Website, Est., Affiliation, Plenary meeting">
					  <caption>기관</caption>
					  <colgroup>
						  <col style="width:30%;" />
						  <col style="width:30%;" />
						  <col />
					  </colgroup>
					  <tbody>
						  <tr class="first">
							  <th scope="row" class="first" colspan="2">Region</th>
							  <td class="subject"><select name="continent" id="continent"   onchange="callcontury(this.value)" style="width:200px">
							    <option value="">Select</option>
							    <option value='CT0012'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0012'}">
														    selected
														  </c:if>
							    >Africa
    
								  
							    
							    </option>
							    <option value='CT0014'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0014'}">
														    selected
														  </c:if>
							    >Central America
    
								  
							    
							    </option>
							    <option value='CT0005'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0005'}">
														    selected
														  </c:if>
							    >East Asia
    
								  
							    
							    </option>
							    <option value='CT0006'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0006'}">
														    selected
														  </c:if>
							    >Eastern Europe
    
								  
							    
							    </option>
							    <option value='CT0001'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0001'}">
														    selected
														  </c:if>
							    >Latin America
    
								  
							    
							    </option>
							    <option value='CT0013'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0013'}">
														    selected
														  </c:if>
							    >Middle East
    
								  
							    
							    </option>
							    <option value='CT0015'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0015'}">
														    selected
														  </c:if>
							    >N.A.
    
								  
							    
							    </option>
							    <option value='CT0009'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0009'}">
														    selected
														  </c:if>
							    >North Africa
    
								  
							    
							    </option>
							    <option value='CT0008'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0008'}">
														    selected
														  </c:if>
							    >North America
    
								  
							    
							    </option>
							    <option value='CT0003'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0003'}">
														    selected
														  </c:if>
							    >Oceania
    
								  
							    
							    </option>
							    <option value='CT0007'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0007'}">
														    selected
														  </c:if>
							    >Russia
    
								  
							    
							    </option>
							    <option value='CT0004'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0004'}">
														    selected
														  </c:if>
							    >South-East Asia
    
								  
							    
							    </option>
							    <option value='CT0002'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0002'}">
														    selected
														  </c:if>
							    >Southern Asia
    
								  
							    
							    </option>
							    <option value='CT0010'  
    
								  
							    
							    <c:if test="${detail.continent=='CT0010'}">
														    selected
														  </c:if>
							    >West Europe
    
								  
							    
							    </option>
							    </select></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" colspan="2">Country</th>
							  <td class="subject"><select name="country" id="country" style="width:200px">
							    <option value="">Select</option>
							    </select>
							    <script type="text/javascript">
									callcontury( document.getElementById('continent').value);
									document.getElementById('country').value="${detail.country}";
									
                                </script></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" rowspan="3">Association</th>
							  <td style="text-align:center;">(korean)</td>
							  <td class="subject"><input type="text" class="text" name="d_name_k" id="d_name_k" value="${detail.d_name_k}"/></td>
						  </tr>
						  <tr>
						  	<td style="text-align:center;">(english)</td>
							<td class="subject"><input type="text" class="text" name="d_name_e" id="d_name_e" value="${detail.d_name_e}"/></td>
						  </tr>
						  <tr>
							<td style="text-align:center;">(vernacular)</td>
  							<td class="subject"><input type="text" class="text" name="d_name_o" id="d_name_o" value="${detail.d_name_o}"/></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" rowspan="3">President</th>
							  <td style="text-align:center;">(korean)</td>
							  <td class="subject"><input type="text" class="text" name="leader_k" id="leader_k" value="${detail.leader_k}"/></td>
						  </tr>
						  <tr>
						  	<td style="text-align:center;">(english)</td>
  							<td class="subject"><input type="text" class="text" name="leader_e" id="leader_e" value="${detail.leader_e}"/></td>
  						  </tr>
  						  <tr>
							 <td style="text-align:center;">(vernacular)</td>
  							 <td class="subject"><input type="text" class="text" name="leader_o" id="leader_o" value="${detail.leader_o}"/></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" colspan="2">Address</th>
							  <td class="subject"><input type="textbox" name="address" id="address" value="${detail.address}"/></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" colspan="2">Tel</th>
							  <td class="subject"><input type="textbox" name="tel" id="tel" value="${detail.tel}"/></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" colspan="2">Fax</th>
							  <td class="subject"><input type="textbox" name="fax" id="fax" value="${detail.fax}"/></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" colspan="2">E-mail</th>
							  <td class="subject"><input type="textbox" name="email" id="email" value="${detail.email}"/></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" colspan="2">Website</th>
							  <td class="subject"><input type="textbox" name="ahomepage" id="ahomepage" value="${detail.ahomepage}"/></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" colspan="2">Est.</th>
							  <td class="subject"><input type="textbox" name="creation_day" id="creation_day" value="${detail.creation_day}"/></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" colspan="2">Affiliation</th>
							  <td class="subject"><input type="textbox" name="organization" id="organization" value="${detail.organization}"/></td>
						  </tr>
						  <tr>
							  <th scope="row" class="first" colspan="2">Plenary meeting</th>
							  <td class="subject"><input type="textbox" name="forum" id="forum" value="${detail.forum}"/></td>
						  </tr>
					  </tbody>
				  </table>
					 
				   </div>
			 
			 
			
			<div class="btn-c">
				
						<c:choose>
						
						<c:when test='${detail.idx==""  }'>
							  
									<a href="javascript:save();"><img alt="" src="/cms/image/koreastudy/btn_save.jpg"></a>
									<a href="javascript:self.close();"><img alt="취소" src="/cms/image/aprov/btn/btn_cancel.jpg"></a>
			 
							</c:when> 
							 
							
							
							<c:otherwise> 
							    <a href="javascript:update();"><img alt="" src="/cms/image/koreastudy/btn_save.jpg"></a>
							     <a href="javascript:del();"><img alt="" src="/cms/image/koreastudy/btn_del.jpg"></a>
							 	<a href="javascript:self.close();"><img alt="취소" src="/cms/image/aprov/btn/btn_cancel.jpg"></a>
							 </c:otherwise>
							 
							 </c:choose>
				  
				 
			
			</div>
			
		</div>
		<a href="javascript:self.close();" class="close"><img src="/cms/image/aprov/popup/btn/btn_close.gif" alt="close" /></a>
	</div> 
</form:form>
<script type="text/javascript">
 
</script>
 
</body>
</html>