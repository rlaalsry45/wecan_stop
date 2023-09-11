<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<jsp:include page="/admsys/header.html" flush="true" />
<jsp:include page="../../lnb.jsp" flush="true" />
            <div id="contents">
			 <div class="contents_top">
                        <div class="location">
                            <a href="/admsys/dashboard/index.html">HOME</a> <a href="/admsys/site/site/index.html">시스템관리</a> <a href="/admsys/setting/commonCode/index.html">업무관리</a> <strong>공통코드관리</strong>
                        </div>
			</div>

                <div id="content">
				 <ul class="homepagebbs">
					<li class="bg">
						<h3 class="bbs">공통코드관리</h3>
					</li>
					<li>
                    <iframe width="100%"  height="950px" src="/sym/ccm/cca/EgovCcmCmmnCodeList.do" scrolling="no" frameborder="0"/>
					</li>
				</ul>
					
                </div><!--/content-->
            </div><!--/r_side-->
        </div><!--/container-->
    </div><!--/wrap-->
</body>
</html>