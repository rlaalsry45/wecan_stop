<%@page import="com.z5.zcms.admsys.user.domain.ZUserVo" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="com.z5.zcms.util.SecuritySessionUtil" %>
<%!
/**
 *	Check if user is authorized
 *
 *	@return boolean true is access granted, false if no access
 */
	public boolean auth(HttpServletRequest request) {
		// You can insert your own code over here to check if the user is authorized.
		if(SecuritySessionUtil.isAdmin(request)) return true;
		else return false;
	}
%>