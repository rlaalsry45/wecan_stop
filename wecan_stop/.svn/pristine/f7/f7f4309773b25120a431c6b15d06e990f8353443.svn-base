<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/zcms/include.jsp" %>
<!--여기서부터 사용하세요-->
<script type="text/javascript">
window.onload = function(){
	 if("true"=="${sessionout}"){
		alert("Wrong access.");
		window.location.href="/";
	 }
}
</script>


<form name="frm" method="post">
	<input type="hidden" name="ztag" id="ztag" value="${ztag}" />
	<input type="hidden" name="act" id="act" value="${act}" />
	<input type="hidden" name="usertype" id="usertype" value="${usertype}" />
	<input type="hidden" name="menuno" id="menuno" value="${menuno}" />
	
	
	
	<h3 class="ctit">Membership Registration</h3>
	<p class="text">For questions about logging in, please call at 02-2151-6547 or 02-2046-8558.</p>
	<ul class="member-kind en">
		<li class="first kind"><span>Select<br />Membership<br />Type</span></li>
		<li class="name"><span>Real Name<br />Verification</span></li>
		<li class="term"><span>Legal<br />Agreements</span></li>
		<li class="info on"><span>Enter Member<br />Information</span></li>
		<li class="email"><span>E-mail<br />Verification</span></li>
		<li class="finish"><span>Registration<br />Complete</span></li>
	</ul>
	<h4 class="sctit">Membership Information</h4>
	<p class="text">If you have a e-mail ID in KF support business application portal site (https://apply.kf.or.kr) membership website, you can use the same ID..</p>
	<div class="email">
		KF to support business application portal site with a members email id
		<div class="btn-l"><a href="javascript:cnjOpen('/usr/skin/member/kf/epmsUserCheck.html','cnjopen',776,400)"><img src="/usr/image/common/btn/btn_id.gif" alt="아이디 찾기" /></a></div>
	</div>
	<p class="text">E-mail verification is required for the protection of your personal information.</p>

	<table class="board-write" summary="E-mail, Password, Re-enter Password, Name (in native language), Name (English), Name (English), E-mail subscription ">
		<caption>Membership Information</caption>
		<colgroup>
			<col style="width:30%;" />
			<col style="width:70%;" />
		</colgroup>
		<tbody>
			<tr>
				<th scope="row"><label for="emaill">E-mail</label></th>
				<td><input type="text" name="userid" id="userid"  class="text" title="E-mail" style="width:196px;height:18px;" /> * Email (ID) is used for authentication to.</td>
			</tr>
			<tr>
				<th scope="row"><label for="password">Password</label></th>
				<td><input type="password" name="userpasswd" id="userpasswd" class="text" title="Password" style="width:196px;height:18px;" /></td>
			</tr>
			<tr>
				<th scope="row"><label for="rpassword">Re-enter Password</label></th>
				<td><input type="password" name="userpasswdchk" id="userpasswdchk" class="text" title="Re-enter Password" style="width:196px;height:18px;" /></td>
			</tr>
			<tr>
				<th scope="row"><label for="name">Name (in native language)</label></th>
				<td><input type="text" name="username" id="username"  <c:if test="${usertype eq 'a' }"> value="${username}" readonly</c:if>   class="text" title="모국어로 이름 입력" style="width:196px;height:18px;" /></td>
				<!-- <td><input type="text" name="username" id="username"  class="text" title="Name (in native language)" style="width:196px;height:18px;" /></td> -->
			</tr>
			<tr>
				<th scope="row"><label for="name2">Name (English)</label></th>
				<td><input type="text" name="username2" id="username2" class="text" title="Name (English)" style="width:196px;height:18px;" /></td>
			</tr>
			<c:if test="${usertype eq 'b' }">
			<tr>
				<th scope="row"><label for="name">Name (parent name)</label></th>
				<td><input type="text" name="parentname" id="parentname"  value="${username}" readonly  class="text" title="Name (parent name)" style="width:196px;height:18px;" /></td>
				<!-- <td><input type="text" name="parentname" id="parentname"   class="text" title="모국어로 이름 입력" style="width:196px;height:18px;" /></td> -->
			</tr>
			</c:if>
		</tbody>
	</table>
	<p class="text">Select the entry</p>
	<table class="board-write" summary="E-mail subscription">
		<caption>Membership Information</caption>
		<colgroup>
			<col style="width:30%;" />
			<col style="width:70%;" />
		</colgroup>
		<tbody>
			<tr>
				<th scope="row">E-mail subscription </th>
				<td class="type">
					<input type="checkbox" name="newsletter1" id="new" class="check" value="1" />
					<label for="new">What’s New</label>
					<input type="checkbox" name="newsletter2" id="newsletter" class="check"  value="2" />
					<label for="newsletter">KF Newsletter</label>
					<input type="checkbox" name="newsletter3"id="focus" class="check"  value="3" />
					<label for="focus">Korea Focus</label>
					<input type="checkbox" name="newsletter4" id="kf" class="check"  value="4" />
					<label for="kf">Koreana</label>
				</td>
			</tr>
		</tbody>
	</table>
	<div class="btn-c">
		<a href="javascript:void(0)"><img id="submit_b" src="/usr/image/common/btn/btn_join02.gif" alt="Register" /></a>
		<a href="/"><img src="/usr/image/common/btn/btn_cancle.gif" alt="cancel" /></a>
	</div>
</form>