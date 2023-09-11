<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="../../header.jsp" flush="true" />
<script type="text/javascript">

function callcontury(val){
	if(val=='')return;
	$.ajax({
		async:false ,
	    type:"POST",
	    url: '/admsys/site/koreastudy/getcountry.html',
	    dataType : 'text',
	    data: 'continent='+ val ,
	    processData: false,
	    error    : function(r) {

	    },
	    success: function(data) {
	    	var s='';
	    	s+='<select name="continent_code" id="continent_code"  style="width:200px">';
	    	s+='<option value="">Select</option>';
	    	s+=data;
	    	s+='</select> ';
	        document.getElementById('continent_code').outerHTML=s;
	    }
	  });

}

var catecode='${input.category_code}';
<c:if test="${input.category_code==null || input.category_code=='A0001'}">
var cate=1;
</c:if>

<c:if test="${input.category_code=='A0002'}">
var cate=2;
						  </c:if>
<c:if test="${input.category_code=='B0000'}">
var cate=3;
						  </c:if>
<c:if test="${input.category_code=='C0001'}">
var cate=4;
</c:if>
function openwin(typ,idx){
	if(typ=='view'){
		window.open('/home/koreastudy/view.html?typ='+ cate + '&idx='+idx,'_view','width=800px,height=800px');

	}else if(typ=='update'){

		window.open('/admsys/site/koreastudy/update.html?typ='+ cate + '&idx='+idx,'_update','width=500px,height=600px');
	}else{
		window.open('/admsys/site/koreastudy/insert.html?typ='+ cate + '&idx='+idx,'_reg','width=500px,height=600px');
	}

}

</script>
	<div id="container">
		<jsp:include page="../../lnb.jsp" flush="true" />
		<div id="r_side">
			<div class="cont_top">
				<div class="location">
					<p>
						<a href="/admsys/site/site/" title="홈으로 이동">HOME</a>
						&gt;
						<a href="/admsys/site/koreastudy/" title="홈페이지관리로 이동">한국학연구정보 관리</a>
						&gt;
						<span>한국할연구정보 목록</span>
					</p>
				</div><!--/location-->
			</div><!--/cont_top-->
			<form:form modelAttribute="zsiteVo" name="frm" method="post">
				<div class="search">
					<div class="srch_right">
						<ul>
							<li class="srch_right_left"><img src="/cms/image/srch_icon.jpg" alt="검색영역" /></li>
							<li class="srch_right_left">

							<input type="radio" name="category_code" value="A0001" <c:if test="${input.category_code==null || input.category_code=='A0001'}">
														    checked
														  </c:if>  onclick="document.forms[0].action='?pageIndex=1';document.forms[0].submit();">Universities
							<input type="radio" name="category_code" value="A0002" <c:if test="${input.category_code=='A0002'}">
														    checked
														  </c:if>   onclick="document.forms[0].action='?pageIndex=1';document.forms[0].submit();" >Centers
							<input type="radio" name="category_code" value="B0000" <c:if test="${input.category_code=='B0000'}">
														    checked
														  </c:if>   onclick="document.forms[0].action='?pageIndex=1';document.forms[0].submit();" >Associations
							<input type="radio" name="category_code" value="C0001" <c:if test="${input.category_code=='C0001'}">
														    checked
														  </c:if>   onclick="document.forms[0].action='?pageIndex=1';document.forms[0].submit();"  >Research Institutes



								<select name="continent" id="continent"   onChange="callcontury(this.value)" style="width:200px">
													  <option value="">Select</option>
														<option value='CT0012'  <c:if test="${input.continent=='CT0012'}">
														    selected
														  </c:if> >Africa</option>
														<option value='CT0014'  <c:if test="${input.continent=='CT0014'}">
														    selected
														  </c:if> >Central America</option>
														<option value='CT0005'  <c:if test="${input.continent=='CT0005'}">
														    selected
														  </c:if> >East Asia</option>
														<option value='CT0006'  <c:if test="${input.continent=='CT0006'}">
														    selected
														  </c:if> >Eastern Europe</option>
														<option value='CT0001'  <c:if test="${input.continent=='CT0001'}">
														    selected
														  </c:if> >Latin America</option>
														<option value='CT0013'  <c:if test="${input.continent=='CT0013'}">
														    selected
														  </c:if> >Middle East</option>
														<option value='CT0015'  <c:if test="${input.continent=='CT0015'}">
														    selected
														  </c:if> >N.A.</option>
														<option value='CT0009'  <c:if test="${input.continent=='CT0009'}">
														    selected
														  </c:if> >North Africa</option>
														<option value='CT0008'  <c:if test="${input.continent=='CT0008'}">
														    selected
														  </c:if> >North America</option>
														<option value='CT0003'  <c:if test="${input.continent=='CT0003'}">
														    selected
														  </c:if> >Oceania</option>
														<option value='CT0007'  <c:if test="${input.continent=='CT0007'}">
														    selected
														  </c:if> >Russia</option>
														<option value='CT0004'  <c:if test="${input.continent=='CT0004'}">
														    selected
														  </c:if> >South-East Asia</option>
														<option value='CT0002'  <c:if test="${input.continent=='CT0002'}">
														    selected
														  </c:if> >Southern Asia</option>
														<option value='CT0010'  <c:if test="${input.continent=='CT0010'}">
														    selected
														  </c:if>  >West Europe</option>
						        </select>
								<select name="continent_code" id="continent_code" style="width:200px">
												    <option value="">Select</option>
								</select>
								<script type="text/javascript">
									callcontury( document.getElementById('continent').value);
									document.getElementById('continent_code').value="${input.continent_code}";

								</script>

								<c:if test="${input.category_code==null || input.category_code!='B0000'}">


								<select name="pcolumn">
										<option value=''             >Select</option>
										<option value='univ_name_e' <c:if test="${input.pcolumn=='univ_name_e'}">
														    selected
														  </c:if> >University</option>
										<option value='depa_name_e' <c:if test="${input.pcolumn=='depa_name_e'}">
														    selected
														  </c:if> >Department</option>
										<option value='leader_e'    <c:if test="${input.pcolumn=='leader_e'}">
														    selected
														  </c:if> >Director</option>
							    </select>
							     </c:if>
								 <c:if test="${input.category_code=='B0000'}">
								 <select name="pcolumn">
										<option value='' >Select</option>
										<option value='ass_name_e' <c:if test="${input.pcolumn=='univ_name_e'}">
														    selected
														  </c:if> >Associations</option>

							    </select>
							    </c:if>
								 <input type="text" title="검색어 입력" class="text" value="${input.keyword}" name="keyword" style="width:150">

							</li>
							<li class="srch_btn_go">
								<input type="image" src="/cms/image/srch_btn_go.jpg" alt="검색" onclick="document.forms[0].action='?pageIndex=1'" />
							</li>
						</ul>
					</div><!--/srch_right-->
				</div><!--/search-->
				<div class="page_title">
					<h3>
						<img src="/cms/image/koreastudy/sub_tit_hanguk.jpg" alt="홈페이지목록" />
					</h3>
				</div>
				<div id="content">
					<div class="main_btn">

						<ul class="site_register">
							<li>
								<a href="javascript:openwin('insert','');"><img alt="홈페이지 등록" src="/cms/image/koreastudy/common_btn_add.jpg" /></a>
							</li>
						</ul>
					</div><!--/main_btn-->
					<div class="main_table">
						<!---게시판 영역------------------------->
					 <c:if test="${input.category_code==null || input.category_code=='A0001'}">

						<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리목록">
							<caption>관리목록</caption>
							<colgroup>

								<col width="5%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="70" />
							</colgroup>


							<thead>
								<tr>

									<th>No</th>
									<th>
										Region
										</th>
										<th>
										Country
										</th>
										<th>
										University(kr)
										</th>
										<th>
										University(en)
										</th>
										<th>
										 Department(kr)
										</th>
										<th>
										  Department(en)
										</th>
										<th>

										</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">

									<tr>

										<td>
											<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
										</td>
										<td>
										${each.cd_name_e}

										</td>

										<td>
										${each.cnty_name_e}

										</td>
										<td>
										<a href="javascript:openwin('view','${each.idx}')"  >
										   ${each.d_name_k}
										</a>

										</td>
										<td>
											${each.d_name_e}
										</td>
										<td>
										<a href="javascript:openwin('view','${each.idx}')"  >
										   ${each.name_k}
										</a>

										</td>
										<td>
											${each.name_e}
										</td>
										<td>
											<a href="javascript:openwin('update','${each.idx}')"  ><img alt="수정" src="/cms/image/common_btn_modify.jpg" /></a>

										</td>
									</tr>
								</c:forEach>
								<c:if test="${input.total==0}">
									<tr>
										<td colspan="9" style="padding:20;">기록이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
					  </c:if>


					 <c:if test="${input.category_code=='A0002'}">

						<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리목록">
							<caption>관리목록</caption>
							<colgroup>
								<col width="5%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="70" />
							</colgroup>


							<thead>
								<tr>

									<th>No</th>
									<th>
										Region
										</th>
										<th>
										Country
										</th>
										<th>
										University(kr)
										</th>
										<th>
										University(en)
										</th>
										<th>
										 Center(kr)
										</th>
										<th>
										 Center(en)
										</th>
										<th>

										</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">

									<tr>

										<td>
											<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
										</td>

										<td>
										${each.cd_name_e}

										</td>

										<td>
										${each.cnty_name_e}

										</td>
										<td>
										<a href="javascript:openwin('view','${each.idx}')"  >
										   ${each.d_name_k}
										</a>

										</td>
										<td>
											${each.d_name_e}
										</td>
										<td>
										<a href="javascript:openwin('view','${each.idx}')"  >
										   ${each.name_k}
										</a>

										</td>
										<td>
											${each.name_e}
										</td>

										<td>
											<a href="javascript:openwin('update','${each.idx}')"  ><img alt="수정" src="/cms/image/common_btn_modify.jpg" /></a>

										</td>
									</tr>
								</c:forEach>
								<c:if test="${input.total==0}">
									<tr>
										<td colspan="9" style="padding:20;">기록이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
					  </c:if>

					   <c:if test="${input.category_code=='B0000'}">

						<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리목록">
							<caption>관리목록</caption>
							<colgroup>

								<col width="5" />


								<col width="25%" />
								<col width="25%" />
								<col width="25%" />
								<col width="25%" />
								<col width="70" />
							</colgroup>


							<thead>
								<tr>
									 <th>No</th>
									<th>
										Region
										</th>
										<th>
										Country
										</th>
										<th>
										Associations(kr)
										</th>
										<th>
										Associations(en)
										</th>

										<th>

										</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">

									<tr>

										<td>
											<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
										</td>
										<td>
										${each.cd_name_e}

										</td>

										<td>
										${each.cnty_name_e}

										</td>
										<td>
										<a href="javascript:openwin('view','${each.idx}')"  >
										   ${each.d_name_k}
										</a>

										</td>
										<td>
											${each.d_name_e}
										</td>

										<td>
											<a href="javascript:openwin('update','${each.idx}')"  ><img alt="수정" src="/cms/image/common_btn_modify.jpg" /></a>

										</td>
									</tr>
								</c:forEach>
								<c:if test="${input.total==0}">
									<tr>
										<td colspan="9" style="padding:20;">기록이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
					  </c:if>
					  <c:if test="${input.category_code=='C0001'}">

						<table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리목록">
							<caption>관리목록</caption>
							<colgroup>
									<col width="5%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="15%" />
								<col width="70" />
							</colgroup>


							<thead>
								<tr>
									 <th>No</th>
									<th>
										Region
										</th>
										<th>
										Country
										</th>
										<th>
										Institute(kr)
										</th>
										<th>
										Institute(en)
										</th>
										 <th>
										Program(kr)
										</th>
										<th>
										Program(en)
										</th>
										<th>

										</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="each" varStatus="loop">

									<tr>

										<td>
											<c:out value='${input.total-(input.pageIndex-1)*input.pageSize-loop.index}' />
										</td>
										<td>
										${each.cd_name_e}

										</td>

										<td>
										${each.cnty_name_e}

										</td>
										<td>
										<a href="javascript:openwin('view','${each.idx}')"  >
										   ${each.d_name_k}
										</a>

										</td>
										<td>
											${each.d_name_e}
										</td>
										<td>
										<a href="javascript:openwin('view','${each.idx}')"  >
										   ${each.name_k}
										</a>

										</td>
										<td>
											${each.name_e}
										</td>
										<td>
											<a href="javascript:openwin('update','${each.idx}')"  ><img alt="수정" src="/cms/image/common_btn_modify.jpg" /></a>

										</td>
									</tr>
								</c:forEach>
								<c:if test="${input.total==0}">
									<tr>
										<td colspan="9" style="padding:20;">기록이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
					  </c:if>
						<pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}' />
						<!---/게시판 영역------------------------->
					</div><!--/main_table-->
				</div><!--/content-->
			</form:form>
		</div><!--/r_side-->
	</div><!--/container-->
</div><!--/wrap-->
<c:import url="../../footer.jsp" />
</body>
</html>