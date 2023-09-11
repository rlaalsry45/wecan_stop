package com.z5.zcms.util;

/**
 * 유형 설명을 삽입하십시오.
 * 작성 날짜: (2003-10-06 오후 9:51:29)
 *
 * @author:
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.Base64Decoder;
import com.z5.zcms.admsys.common.domain.SerialContainer;

import egovframework.rte.fdl.idgnr.impl.Base64;

public class CookieUtil {
    /**
     * CookieUtil 생성자 주석.
     */
    public CookieUtil() {
        super();
    }


    /**
     * 쿠키값을 구한다.
     * 작성시간 2003-04-05 오후 12:30
     * @param request            페이지 요청
     * @param cookieName    쿠키이름
     * @return returnValue        쿠키값
     */
    public static String get(HttpServletRequest request, String cookieName) {
        String cookieValue = getCookieValue(request, cookieName);
        return cookieValue;
    }


    /**
     * 쿠키값을 구한다.
     * 작성시간 2003-04-05 오후 12:30
     * @param request            페이지 요청
     * @param cookieName    쿠키이름
     * @return returnValue        쿠키값
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        String cookieValue = "";

        Cookie[] callCookies = request.getCookies();
        if (callCookies != null) {
            for (int i = 0; i < callCookies.length; i++) {
                if (callCookies[i].getName().equals(cookieName)) {
                    cookieValue = callCookies[i].getValue();
                    break;
                }
            }
        }

        return cookieValue;
    }


    /**
     * 쿠키값을 구한다.
     * 작성시간 2003-04-05 오후 12:30
     * @param request            페이지 요청
     * @param cookieName    쿠키이름
     * @return returnValue        쿠키값
     */
    public static int getInt(HttpServletRequest request, String cookieName) {
        String cookieValue = getCookieValue(request, cookieName);
        return Integer.parseInt(cookieValue);
    }


    /**
     * 쿠키값을 구한다.
     * 작성시간 2003-04-05 오후 12:30
     * @param request            페이지 요청
     * @param cookieName    쿠키이름
     * @return returnValue        쿠키값
     */
    public static long getLong(HttpServletRequest request, String cookieName) {
        String cookieValue = getCookieValue(request, cookieName);
        return Long.parseLong(cookieValue);
    }


    /**
     * 로그인 여부를 반환한다.
     * 작성시간 2003-04-05 오후 2:52
     * @param request                페이지 요청
     * @param cookieName        쿠키이름
     * @return isLogin                로그인 여부(로그인 했으면 true, 아니면 false)
     */
    public static boolean isLogin(HttpServletRequest request, String cookieName) {
        boolean isLogin = false;

        Cookie[] callCookies = request.getCookies();

        for (int i = 0; i < callCookies.length; i++) {
            if (callCookies[i].getName().equals(cookieName)) {
                isLogin = true;
                break;
            }
        }

        return isLogin;
    }


    /**
     * 로그인 쿠키를 생성한다.
     * 작성시간 2003-04-05 오후 2:28
     * @param request            페이지 요청
     * @param cookieName    쿠키이름
     */
    public static void setLogin(HttpServletResponse response, String cookieName) {
        String loginok     = "loginok";     // 쿠키 값
        Cookie loginCookie = new Cookie(cookieName, loginok);            //아이디와 패스워드가 맞으면 쿠키 생성
        loginCookie.setMaxAge(-1);
        loginCookie.setPath("");
        response.addCookie(loginCookie);
    }


    /**
     * 로그인 쿠키를 제거한다.
     * 작성시간 2003-04-05 오후 2:28
     * @param request            페이지 요청
     * @param cookieName    쿠키이름
     */
    public static void setLogout(HttpServletResponse response, String cookieName) {
        String loginok     = "loginok";     // 쿠키 값
        Cookie loginCookie = new Cookie(cookieName, loginok);
        loginCookie.setMaxAge(0);
        loginCookie.setPath("");
        response.addCookie(loginCookie);
    }


    /**
     * 로그인 쿠키를 생성한다.
     * 작성시간 2003-04-05 오후 2:28
     * @param request            페이지 요청
     * @param cookieName    쿠키이름
     */
    public static void set(
            HttpServletRequest request,
            HttpServletResponse response,
            String cookieName,
            String cookieValue) {

        Cookie ck = new Cookie(cookieName, cookieValue);
        ck.setMaxAge(-1);
        ck.setPath("/");
        response.addCookie(ck);
    }

    public static void setVisitor(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(DateUtil.remainSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 로그인 쿠키를 생성한다.
     * 작성시간 2013-03-28
     * @param request        페이지 요청
     * @param cookieName    쿠키이름
     * @param vo            직렬화할객체(반드시 serializable울 implements한것)
     * @throws IOException
     */
    public static void setObject(HttpServletRequest request,
                                 HttpServletResponse response, String cookieName, Object instance) throws IOException {
        SerialContainer cc = new SerialContainer();
        cc.setInstance(instance);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream    oos  = new ObjectOutputStream(baos);
        oos.writeObject(cc);
        oos.close();
        String cookieValue = new String(Base64.encode(baos.toByteArray()));
        //System.out.println(cookieValue);

        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        cookie.setDomain("." + request.getServerName());
        //System.out.println("."+request.getServerName());
        response.addCookie(cookie);


    }

    /**
     * 내용 : 쿠키에서 직렬화된 객체를 가져와 Objcet형태로 돌려준다.
     * 작성자 : 김문석
     * 작성시간  : 2013. 3. 29.
     * method_name : getVo
     * @param request
     * @param cookieName
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object getObject(HttpServletRequest request, String cookieName) throws IOException, ClassNotFoundException {
        String cookieValue = getCookieValue(request, cookieName);
        if (cookieValue == null || cookieValue.equals("")) return null;

        byte[]            data = Base64Decoder.decodeToBytes(cookieValue);
        ObjectInputStream ois  = new ObjectInputStream(new ByteArrayInputStream(data));
        Object            o    = ois.readObject();
        ois.close();

        SerialContainer instance = (SerialContainer) o;

        return instance.getInstance();
    }


    /**
     * 로그인 쿠키를 생성한다.
     * 작성시간 2003-04-05 오후 2:28
     * @param request            페이지 요청
     * @param cookieName    쿠키이름
     */
    public static void setLogin(HttpServletRequest request, HttpServletResponse response, String cookieName) {

        DataTable dt = new DataTable(request);

        String userid      = dt.get("sAdminID");     // 쿠키 값
        Cookie loginCookie = new Cookie(cookieName, userid);            //아이디와 패스워드가 맞으면 아이디가 담긴 쿠키 생성
        loginCookie.setMaxAge(-1);
        loginCookie.setPath("");
        response.addCookie(loginCookie);
    }

    /**
     * 로그인 쿠키를 생성한다.
     * 작성시간 2003-04-05 오후 2:28
     * @param request            페이지 요청
     * @param cookieName    쿠키이름
     */
    public static void setLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            String cookieName,
            String cookieValue) {

        DataTable dt = new DataTable(request);

        String userid      = dt.get("sAdminID");     // 쿠키 값
        Cookie loginCookie = new Cookie(cookieName, userid);            //아이디와 패스워드가 맞으면 아이디가 담긴 쿠키 생성
        loginCookie.setMaxAge(-1);
        loginCookie.setPath("");
        response.addCookie(loginCookie);
    }
}
