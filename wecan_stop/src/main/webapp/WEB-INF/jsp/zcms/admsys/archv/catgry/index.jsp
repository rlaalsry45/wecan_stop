<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />

<jsp:include page="../../lnb.jsp" flush="true" />
<div id="contents">	
	<div class="contents_top">
              <div class="location">
                  <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/archv/catgry/">아카이브</a> <strong>분류관리</strong>
              </div>
          </div>
          
          <div id="content">
           <ul class="homepagebbs">
               <li class="bg"><h3 class="bbs">분류관리</h3></li>
               <li>
                   <div class="main_table">
                    <table class="main_table1" summary="분류,분류추가">
					<caption>분류관리</caption>
					<colgroup>
						<col width="20%" />
						<col /> 
					</colgroup>
					<tr>
						<td class="bnone_color bgneno"><div id="ztree_tree"></div></td>
						<td class="bnone_color bgneno"><div id="ztree_form"></div></td>
					</tr>
					</table>
				 </li>
              </ul>
			</div><!--/main_table-->
		</div><!--/content-->
	</div><!--/container-->
${js_url }
 