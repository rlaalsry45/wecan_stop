<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<script type="text/javascript">
    function check_satisfaction() {
        var matches = [];
        $(".answer_val:checked").each(function () {
            matches.push(this.value);
        });
        console.log(matches);
        if (matches.length == 0) {
            alert("Please pick survey!");
            return false;
        }

        console.log("action:" + document.forms.satisfaction_counsel.action);
        document.forms.satisfaction_counsel.submit();
        return true;
    }
</script>

<!-- 만족도조사 영역 -->
<c:if test="${result.mainview=='1'}">
	<input type="hidden" id="satisfactionno" name="satisfactionno" value="${result.satisfactionno}"/>
    <input type="hidden" id="question" name="question" value="${questionNum}"/>
    <c:forEach items="${fn:split(result.added,'Æ')}" var="question" varStatus="status">
		<c:set value="${fn:split(question,'Œ')}" var="askmeta"/>
        <c:set value="${askmeta[0]}" var="opttype"/>
        <c:set value="${askmeta[1]}" var="opttitle"/>
        <c:set value="${status.count}" var="questionCount"/>
        <c:choose>
        	<c:when test="${opttype=='2'||opttype=='1'}"><c:set value="60" var="tit_len"/></c:when>
        	<c:when test="${opttype=='3'||opttype=='4'}"><c:set value="100" var="tit_len"/></c:when>
        </c:choose>
        <c:if test="${opttype=='2'||opttype=='1'}">
			<dl>
		    	<dt>${status.count}. ${opttitle}</dt>
		        <dd class="pt_20 pr_0">
		        	<ul>
			        	<c:forEach items="${askmeta}" var="opt" begin="2" end="${fn:length(askmeta)}" step="1" varStatus="status">
			            	<c:set value="${status.count}" var="optCount"/>
			            	<li><input type="radio" id="askno${questionCount}_${optCount}" class="num0${optCount}" name="askno${questionCount}" value="${optCount}"> <label for="askno${questionCount}_${optCount}">${opt}</label></li>
			        	</c:forEach>
			        </ul>
		        	<p><span><img src="/usr/images/sub/btn-number_2.png" alt="4번"></span> <span><img src="/usr/images/sub/btn-number_3.png" alt="5번"></span>를 선택하신 경우 그렇게 생각하는 사유를 말씀해 주세요.</p>
		        	<div class="text_area">
		        		<label class="textareaContainer"><textarea id="answer${questionCount}" name="answer${questionCount}" rows="2" style="resize: none;" placeholder="의견을 입력해주세요."></textarea></label>
		        	</div>
			    </dd>
			</dl>
	    </c:if>
    </c:forEach>
</c:if>
<c:if test="${hasLiveSatisfaction=='none'}">
    <dl>
    	<dt>진행중인 만족도조사가 없습니다.</dt>
    </dl>
</c:if>