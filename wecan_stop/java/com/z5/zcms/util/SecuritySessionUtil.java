package com.z5.zcms.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.security.ZNonTargetAuthenticationSuccessHandler;
import com.z5.zcms.security.ZSavedAuthenticationSuccessHandler;

/**
 * <pre>
 * com.z5.zcms.util
 * SecuritySessionUtil.java
 * </pre>
 *
 * @Author : 김문석
 * @Date : 2013. 4. 11.
 * @Version :
 */
public class SecuritySessionUtil {

    @Autowired
    PasswordEncoder passwordEncoder;


    /**
     * 내용 : 일반로그인의 경우도 시큐리티 권한을 사용할수 있도록 세션을 삽입한다.
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 11.
     * method_name : setSecuritySession
     *
     * @param request
     * @param response
     * @param authenticationManager -> autowired로 bean에서 가져와서 인자로 넣어줄것
     * @throws IOException
     * @throws ServletException
     */
    public static void setSecuritySession(HttpServletRequest request, HttpServletResponse response, AuthenticationManager authenticationManager) throws IOException, ServletException {
        String userId   = request.getParameter("userid");
        String password = request.getParameter("userpasswd");

        UsernamePasswordAuthenticationToken authRequest    = new UsernamePasswordAuthenticationToken(userId, password);
        Authentication                      authentication = authenticationManager.authenticate(authRequest);
        persistAuthentication(authentication, request.getSession());
        ZSavedAuthenticationSuccessHandler helper = new ZSavedAuthenticationSuccessHandler();
        helper.onAuthenticationSuccess(request, response, authentication);
    }

    private static void persistAuthentication(Authentication authentication, HttpSession session) {
        SecurityContext securityContext = new SecurityContextImpl();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
    }

    public static void setSecuritySessionNonTarger(HttpServletRequest request, HttpServletResponse response, AuthenticationManager authenticationManager) throws IOException, ServletException {
        String userId   = request.getParameter("userid");
        String password = request.getParameter("userpasswd");

        UsernamePasswordAuthenticationToken authRequest    = new UsernamePasswordAuthenticationToken(userId, password);
        Authentication                      authentication = authenticationManager.authenticate(authRequest);
        persistAuthentication(authentication, request.getSession());
        ZNonTargetAuthenticationSuccessHandler helper = new ZNonTargetAuthenticationSuccessHandler();
        helper.onAuthenticationSuccess(request, response, authentication);
    }

    /**
     * 내용 : 시큐리티 세션전체를 찍어본다
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 12.
     * method_name : toString
     *
     * @param request
     */
    public static void toString(HttpServletRequest request) {
        System.out.println("세션확인==============================================================");
        HttpSession    session        = request.getSession();
        Enumeration<?> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = (String) attributeNames.nextElement();
            if (name.equals("SPRING_SECURITY_CONTEXT")) {
                SecurityContext value = (SecurityContext) session.getAttribute(name);
                System.out.println("name = " + name + " , value = " + value.toString());
//              System.out.println("authentication : " + authentication.toString());
//	            System.out.println("principal : " + principal);
//	            System.out.println("details : " + details.toString());
//	            System.out.println("username : " + username);
//	            System.out.println("password : " + password);
            }
        }
        System.out.println("==================================================================");
    }

    /**
     * 내용 : 시큐리티 세션의 아이디를 가져온다.
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 12.
     * method_name : getUserid
     *
     * @param request
     * @return
     */
    public static String getUserid(HttpServletRequest request) {
        HttpSession    session        = request.getSession();
        Enumeration<?> attributeNames = session.getAttributeNames();
        String         userid         = "";
        while (attributeNames.hasMoreElements()) {
            String name = (String) attributeNames.nextElement();
            if (name.equals("SPRING_SECURITY_CONTEXT")) {
                SecurityContext value          = (SecurityContext) session.getAttribute(name);
                Authentication  authentication = value.getAuthentication();
                userid = authentication.getName();
            }
        }
        return userid;
    }

    /**
     * 내용 : 시큐리티 권한모두를 list로 받아 온다.
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 11.
     * method_name : getAuths
     *
     * @param request
     */
    public static List<String> getAuths(HttpServletRequest request) {
        HttpSession                            session        = request.getSession();
        Enumeration<?>                         attributeNames = session.getAttributeNames();
        List<String>                           authsArray     = new ArrayList<String>();
        Collection<? extends GrantedAuthority> auths;

        while (attributeNames.hasMoreElements()) {
            String name = (String) attributeNames.nextElement();
            if (name.equals("SPRING_SECURITY_CONTEXT")) {
                SecurityContext value          = (SecurityContext) session.getAttribute(name);
                Authentication  authentication = value.getAuthentication();
                auths = authentication.getAuthorities();
                Iterator<?> iauths = auths.iterator();
                while (iauths.hasNext()) {
                    authsArray.add(iauths.next().toString());
                }
            }
        }
        return authsArray;
    }

    public static boolean isAuth(HttpServletRequest request, String auth) {
        List<String> list = getAuths(request);
        for (String each : list) {
            if (each.equals(auth)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSuper(HttpServletRequest request) {
        return SecuritySessionUtil.isAuth(request, "ROLE_SUPER");
    }

    public static boolean isAdmin(HttpServletRequest request) {
        return SecuritySessionUtil.isAuth(request, "ROLE_ADMIN");
    }

    public static boolean isUser(HttpServletRequest request, String user) {
        return user.equals(getUserid(request));
    }

    public static boolean member(HttpServletRequest request) {
        return SecuritySessionUtil.isAuth(request, "ROLE_USER") && !SecuritySessionUtil.isAuth(request, "ROLE_ADMIN");
    }

    public static boolean login(HttpServletRequest request) {
        return request.getSession().getAttribute("zUserVo") != null;
    }

    public static ZUserVo getUserVo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (ZUserVo) session.getAttribute("zUserVo");
    }

    public static String getLoginid(HttpServletRequest request) {
        ZUserVo vo = getUserVo(request);
        return vo.getUserid();
    }

}
