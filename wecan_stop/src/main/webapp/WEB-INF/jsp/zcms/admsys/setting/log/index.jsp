<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
<style>
.graph {height: 20px;background-color: #f5f5f5;border-radius: 4px;margin-bottom: 8px; width:100%}
.graph-bar.active {-webkit-animation: graph-bar 2s linear infinite;-o-animation: graph-bar 2s linear infinite;animation: graph-bar 2s linear infinite}
.graph-bar {background-image: linear-gradient(45deg,rgba(255,255,255,.15) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.15) 50%,rgba(255,255,255,.15) 75%,transparent 75%,transparent);background-size: 20px 20px}
.graph-bar {float: left;width: 0;height: 100%;line-height: 20px;color: #fff;text-align: right;background-color: #337ab7;-webkit-transition: all .6s ease;-o-transition: all .6s ease;transition: all .6s ease}
</style>

	<c:set var="fntyp1" value="N"/>
	<c:forEach items="${perm}" var="p" varStatus="ini">
		<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_1' and p.ALLOW_YN eq 'Y' }">
			<c:set var="fntyp1" value="Y"/>
			
           <div id="contents">
                    <div class="contents_top">
						<div class="location">
							<a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <strong>접속기록 조회</strong>
						</div>
					</div>
                    <div id="content">
					<form:form modelAttribute="zUserVo" name="frm" method="post">
					<ul class="homepagebbs">
					<c:if test="${input.work_grade eq '2' }"><c:set var="li_title" value="주제별"/></c:if>
					<c:set var="li_title" value="관리자접속로그"/>
					<c:if test="${input.work_grade eq '1' }"><c:set var="li_title" value="개인회원 접속 로그"/></c:if>
					<c:if test="${input.work_grade eq '2' }"><c:set var="li_title" value="협력기관 접속 로그"/></c:if>
						<li class="bg"><h3 class="sub">접속기록 조회 : ${li_title }</h3></li>
						<li>
						<input type="hidden" name="work_grade" value="${input.work_grade }" />
						<input type="hidden" name="cond1" value="logdate"/>
						<input type="hidden" name="total" value="${input.total}"/>
		                    <table class="main_table1 bgneno">
		                        <caption>주제검색</caption>
		                        <colgroup>
		                            <col width="10%">
		                            <col width="90%">
		                        </colgroup>
		                        <tbody>
		                        <tr>
		                            <th class="">접속일</th>
		                            <td class="Tbod Tleft">
		                                <div class="category">
											<fmt:parseDate value="${input.sdate}" pattern="yyyy-MM-dd" var="isd" />
											<fmt:parseDate value="${input.edate}" pattern="yyyy-MM-dd" var="ied" />
											<input type="date" id="d4311" name="sdate" value="<fmt:formatDate type="both" value="${isd}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">~
											<input type="date" id="d4312" name="edate" value="<fmt:formatDate type="both" value="${ied}" pattern="yyyy-MM-dd" />" min="1970-01-01" max="2030-12-31" placeholder="년/월/일" style="width: 160px;">                            
	                                    </div>
		                            </td>
		                        </tr>
		                        <tr>
		                            <th class="Tbornone">검색어 입력</th>
		                            <td class="Tleft">
		                                <select style="height:27px;" name="cond2">
		                                	<option value="">전체</option>
		                                	<option value="userid" <c:if test="${input.cond2=='userid'}"><c:out value='selected'/></c:if>>ID</option>
		                                	<option value="username" <c:if test="${input.cond2=='username'}"><c:out value='selected'/></c:if>>이름</option>
				                            <option value="logip" <c:if test="${input.cond2=='logip'}"><c:out value='selected'/></c:if>>IP</option>
				                        </select>
				                        <input type=text name="keyword" value="<c:out value='${input.keyword}' />" class="bor1ddd" style="width:50%;"/>
		                            </td>
		                        </tr>
		                        </tbody>
		                    </table>
		                    <div class="btn-c">
		                        <input class="bt01" type="submit" id="search" title="검색조건에 부합되는 로그를 조회해옵니다." value="검색"/>
		                    </div>
		                </li>
						<li>
						<div class="top_bt">
						&nbsp;총 ${input.total}건
							<%-- <a class="btmore07" href="javascript:checkAll(true,'seq');">전체선택</a>
							<a class="btmore07" href="javascript:checkAll(false,'seq');">선택해제</a>
							<a class="btmore05" href="javascript:del('seq');" title="선택한 로그를 삭제합니다.">삭제</a> --%>
							<div class="user_btn">
								<%-- <a class="btmore01" href="javascript:searchDel();" title="검색결과 전부를 삭제합니다.">검색삭제</a>
								<a class="btmore01" href="javascript:batchDel();" title="로그 전부를 삭제합니다.">일괄삭제</a>
								<a class="btmore01" href="/admsys/setting/log/excel.html?work_grade=${input.work_grade}&cond1=logdate&sdate=${input.sdate}&edate=${input.edate}&cond2=${input.cond2}&keyword=${input.keyword}" title="로그 전부를 엑셀파일로 다운합니다.">엑셀다운</a> --%>
								<c:forEach items="${perm}" var="p" varStatus="ini">
									<c:if test="${p.FUNCTION_TYPE eq 'FNTYP_4' and p.ALLOW_YN eq 'Y' }">
										<a class="btmore01" href="javascript:excelDownload();" title="로그 전부를 엑셀파일로 다운합니다.">엑셀다운</a>
									</c:if>
								</c:forEach>
							</div>
						</div>
						<div class="main_table">
                            <!---게시판 영역------------------------->
                            <table class="main_table1" border="1" cellspacing="1" cellpadding="2" width="100%" summary="관리자 접속 로그 리스트">
                                <caption>관리자 접속 로그 리스트</caption>
                                <colgroup>
                                	<%-- <col width="5%"/> --%>
                                	<col width="12%"/>
                                    <col width="22%"/>
                                    <col width="22%"/>
                                    <col width="22%"/>
                                    <col width="22%"/>
                                </colgroup>
                                <thead>
                                    <tr>
                                        <%-- <th><input class="bor_none" id="batch" type="checkbox" onclick="javascript:checkAll('','seq')" /></th> --%>
                                    	<th>번호</th>
                                        <th>일시</th>
										<th>ID</th>
										<th>이름</th>
									  	<th>IP주소</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="data" items="${list}" varStatus="status">
                                	<tr>
                                		<%-- <td><input class="bor_none" name="seq" value="${data.seq}" type="checkbox" /></td> --%>
                                		<td><c:out value='${input.total-(input.pageIndex-1)*input.pageSize-status.index}'/></td>
                                		<td>${fn:substring(data.logdate, 0, 19)}</td>
                                    	<td>${data.userid}</td>
                                    	<td>${data.username}</td>
                                		<td>${data.logip}<c:if test="${data.device=='1'}">(PC)</c:if><c:if test="${data.device=='2'}">(MOBILE)</c:if><c:if test="${data.device=='3'}">(TABLET)</c:if></td>
                                	</tr>
                                    </c:forEach>
                                    <c:if test="${empty list }"><tr><td colspan="5">검색된 결과가 없습니다.</td></tr></c:if>
                                </tbody>
                            </table>
                            <pt:pageOut pageIndex='${input.pageIndex}' pageMax='${input.pageMax}'/>
                        </div><!--/main_table-->
						</li>
					</ul>
					</form:form>
                    </div><!--/content-->
        
        </c:if>
	</c:forEach>
	<c:if test="${fn:length(perm) > 0 && fntyp1 eq 'N'}">
      	<div id="contents">
           	<div id="content">
                <ul class="homepagebbs">
                    <li class="bg"><h3 class="sub">접근 권한이 없습니다.</h3></li>
                 </ul>
             </div>
         </div>
    </c:if>
	<c:if test="${fn:length(perm) == 0}">
		<div id="contents">
           	<div id="content">
                <ul class="homepagebbs">
                    <li class="bg"><h3 class="sub">접근 권한이 없습니다.</h3></li>
                 </ul>
             </div>
         </div>
	</c:if>	        
        
  <jsp:include page="../../end.jsp" flush="false" />
  
  <script>
		function excelDownload() {
			var eForm = $("#zUserVo").serialize();

			$.ajax({
				type : 'POST',
				url : "/admsys/setting/log/index_excel.html",
				data : eForm,
				traditional : true,
				success : function(result) {
					exportExcel(result.list);
				},
				error : function(e) {
					alert("엑셀 다운로드중 오류가 발생하였습니다." + e.responseText);
				}
			});
		}

		function s2ab(s) {
			var buf = new ArrayBuffer(s.length); //convert s to arrayBuffer
			var view = new Uint8Array(buf); //create uint8array as viewer
			for (var i = 0; i < s.length; i++)
				view[i] = s.charCodeAt(i) & 0xFF; //convert to octet
			return buf;
		}
		function exportExcel(data) {
			// step 1. workbook 생성
			var wb = XLSX.utils.book_new();

			// step 2. 시트 만들기 
			var newWorksheet = excelHandler.getWorksheet(data);

			// step 3. workbook에 새로만든 워크시트에 이름을 주고 붙인다.  
			XLSX.utils.book_append_sheet(wb, newWorksheet, excelHandler
					.getSheetName());

			// step 4. 엑셀 파일 만들기 
			var wbout = XLSX.write(wb, {
				bookType : 'xlsx',
				type : 'binary'
			});

			// step 5. 엑셀 파일 내보내기 
			saveAs(new Blob([ s2ab(wbout) ], {
				type : "application/octet-stream"
			}), excelHandler.getExcelFileName());
		}

		var excelHandler = {
			getExcelFileName : function() {
				return '로그인 기록.xlsx';
			},
			getSheetName : function() {
				return '로그인 기록';
			},
			getExcelData : function(data) {
				var arr = new Array();

				var device = '';
				var i = 0, len = data.length;
				while (i < len) {
					if (data[i].device == '1') {
						device = '(PC)';
					} else if (data[i].device == '2') {
						device = '(MOBILE)';
					} else {
						device = '(TABLET)';
					}

					arr[i] = {
						'번호' : len - i,
						'일시' : data[i].logdate.substring(0, 19),
						'ID' : data[i].userid,
						'이름' : data[i].username,
						'IP주소' : data[i].logip + device
					}

					i++;
				}

				return arr;
			},
			getWorksheet : function(data) {
				return XLSX.utils.json_to_sheet(this.getExcelData(data));
			}
		}
	</script>
	