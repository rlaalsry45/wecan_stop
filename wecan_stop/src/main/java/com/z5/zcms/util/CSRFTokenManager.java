package com.z5.zcms.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cklee E-mail: ykslck@gmail.com
 * @version create：2014年3月28日 下午12:24:26
 * Class declaration
 * 토큰 생성 유틸리티
 */
public class CSRFTokenManager {
    /**

     * The token parameter name

     */

    static final String CSRF_PARAM_NAME = "CSRFToken";



    /**

     * The location on the session which stores the token

     */

    public static final  String CSRF_TOKEN_FOR_SESSION_ATTR_NAME = CSRFTokenManager.class

            .getName() + ".tokenval";



    public static String getTokenForSession(HttpSession session) {

        String token = null;



        // I cannot allow more than one token on a session - in the case of two

        // requests trying to

        // init the token concurrently

        synchronized (session) {

            token = (String) session.getAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME);

            if (null == token) {

                token = UUID.randomUUID().toString();

                session.setAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME, token);

            }

        }

        return token;

    }



    /**

     * Extracts the token value from the request

     *

     * @param request

     * @return

     */

    public static String getTokenFromRequest(HttpServletRequest request) {

        return request.getParameter(CSRF_PARAM_NAME);

    }

    /**

     * Extracts the token value from the header

     *

     * @param request

     * @return

     */

    public static String getTokenFromHeader(HttpServletRequest request) {

    	return request.getHeader(CSRF_PARAM_NAME);

    }

    public static void setToken(HttpServletRequest request, HttpServletResponse response) {
    	String token = UUID.randomUUID().toString();
    	request.setAttribute(CSRF_PARAM_NAME, token);
    	HttpSession session = request.getSession();
    	session.setAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME, token);
    }



    private CSRFTokenManager() {

    };
}
