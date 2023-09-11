package egovframework.com.cmm.service;

import com.z5.zcms.util.Validator;
import egovframework.com.cmm.EgovWebUtil;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * Class Name : EgovProperties.java
 * Description : properties값들을 파일로부터 읽어와   Globals클래스의 정적변수로 로드시켜주는 클래스로
 * 문자열 정보 기준으로 사용할 전역변수를 시스템 재시작으로 반영할 수 있도록 한다.
 * Modification Information
 * <p>
 * 수정일         수정자                   수정내용
 * -------    --------    ---------------------------
 * 2009.01.19    박지욱          최초 생성
 * 2011.07.20    서준식        Globals파일의 상대경로를 읽은 메서드 추가
 *
 * @author 공통 서비스 개발팀 박지욱
 * @version 1.0
 * @see
 * @since 2009. 01. 19
 */

public class EgovProperties {

    //파일구분자
    private static final char FILE_SEPARATOR = File.separatorChar;

    //프로퍼티값 로드시 에러발생하면 반환되는 에러문자열
    private static final String ERR_CODE      = " EXCEPTION OCCURRED";
    private static final String ERR_CODE_FNFE = " EXCEPTION(FNFE) OCCURRED";
    private static final String ERR_CODE_IOE  = " EXCEPTION(IOE) OCCURRED";

    //프로퍼티 파일의 물리적 위치
    private static final String PATH_PREFIX
        = EgovProperties.class.getResource("").getPath().substring(0, EgovProperties.class.getResource("").getPath().lastIndexOf("com"));

    private static String PROPERTIES_FILE;
    private static String SERVER_DOC_BASE;

    static {
        if (PATH_PREFIX.contains("WEB-INF")) {
            SERVER_DOC_BASE = PATH_PREFIX.substring(0, PATH_PREFIX.lastIndexOf("WEB-INF"));
        } else {
            SERVER_DOC_BASE = PATH_PREFIX.substring(0, PATH_PREFIX.lastIndexOf("out"))
                    + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR + "webapp";
        }
        System.out.println("DOCBASE: " + SERVER_DOC_BASE);

        String properties = Validator.isTrue(System.getProperty("profiles.private")) ? "private.properties" : "globals.properties";
        PROPERTIES_FILE = PATH_PREFIX + "egovProps" + FILE_SEPARATOR + properties;
        System.out.println("PROFILE: " + PROPERTIES_FILE);
    }

    public static String getDocBase() {
        return SERVER_DOC_BASE;
    }

    /**
     * 인자로 주어진 문자열을 Key값으로 하는 상대경로 프로퍼티 값을 절대경로로 반환한다(Globals.java 전용)
     *
     * @param keyName String
     * @return String
     */
    public static String getPathProperty(String keyName) {
    	 
    	
        FileInputStream fis = null;
        try {
            Properties props = new Properties();
            fis = new FileInputStream(EgovWebUtil.filePathBlackList(PROPERTIES_FILE));
            props.load(new BufferedInputStream(fis));
            String value = SERVER_DOC_BASE + System.getProperty("file.separator") + props.getProperty(keyName).trim();
            
            return value.replaceAll("/+", "/").replaceAll("\\+", "\\");
        } catch (FileNotFoundException fne) {
            return ERR_CODE_FNFE;
        } catch (IOException ioe) {
            return ERR_CODE_IOE;
        } catch (Exception e) {
            debug(e);
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (Exception ex) {
                debug(ex);
            }
        }
        return ERR_CODE;
    }


    /**
     * 인자로 주어진 문자열을 Key값으로 하는 프로퍼티 값을 반환한다(Globals.java 전용)
     *
     * @param keyName String
     * @return String
     */
    public static String getProperty(String keyName) {
        debug(PROPERTIES_FILE + " : " + keyName);
        FileInputStream fis = null;
        try {
            Properties props = new Properties();
            fis = new FileInputStream(EgovWebUtil.filePathBlackList(PROPERTIES_FILE));
            props.load(new BufferedInputStream(fis));
            return props.getProperty(keyName).trim();
        } catch (FileNotFoundException fne) {
            return ERR_CODE_FNFE;
        } catch (IOException ioe) {
            return ERR_CODE_IOE;
        } catch (Exception e) {
            debug(e);
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (Exception ex) {
                debug(ex);
            }
        }
        return ERR_CODE;
    }

    /**
     * 주어진 파일에서 인자로 주어진 문자열을 Key값으로 하는 프로퍼티 상대 경로값을 절대 경로값으로 반환한다
     *
     * @param fileName String
     * @param key      String
     * @return String
     */
    public static String getPathProperty(String fileName, String key) {
        FileInputStream fis = null;
        try {
            java.util.Properties props = new java.util.Properties();
            fis = new FileInputStream(EgovWebUtil.filePathBlackList(fileName));
            props.load(new BufferedInputStream(fis));
            return PATH_PREFIX + "egovProps" + System.getProperty("file.separator") + props.getProperty(key);
        } catch (FileNotFoundException fne) {
            return ERR_CODE_FNFE;
        } catch (IOException ioe) {
            return ERR_CODE_IOE;
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (Exception ex) {
                debug(ex);  // 2011.10.10 보안점검 후속조치
            }
        }
    }


    /**
     * 주어진 파일에서 인자로 주어진 문자열을 Key값으로 하는 프로퍼티 값을 반환한다
     *
     * @param fileName String
     * @param key      String
     * @return String
     */
    public static String getProperty(String fileName, String key) {
        FileInputStream fis = null;
        try {
            java.util.Properties props = new java.util.Properties();
            fis = new FileInputStream(EgovWebUtil.filePathBlackList(fileName));
            props.load(new BufferedInputStream(fis));
            return props.getProperty(key);
        } catch (FileNotFoundException fne) {
            return ERR_CODE_FNFE;
        } catch (IOException ioe) {
            return ERR_CODE_IOE;
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (Exception ex) {
                //ex.printStackTrace();
                //System.out.println("IGNORE: " + ex);  // 2011.10.10 보안점검 후속조치
                Logger.getLogger(EgovProperties.class).debug("IGNORED: " + ex.getMessage());
            }
        }
    }

    /**
     * 주어진 프로파일의 내용을 파싱하여 (key-value) 형태의 구조체 배열을 반환한다.
     *
     * @param property String
     * @return ArrayList
     */
    public static ArrayList loadPropertyFile(String property) {

        // key - value 형태로 된 배열 결과
        ArrayList keyList = new ArrayList();

        String          src = property.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
        FileInputStream fis = null;
        try {
            File srcFile = new File(EgovWebUtil.filePathBlackList(src));
            if (srcFile.exists()) {

                java.util.Properties props = new java.util.Properties();
                fis = new FileInputStream(src);
                props.load(new BufferedInputStream(fis));
                fis.close();

                int         i     = 0;
                Enumeration plist = props.propertyNames();
                if (plist != null) {
                    while (plist.hasMoreElements()) {
                        Map    map = new HashMap();
                        String key = (String) plist.nextElement();
                        map.put(key, props.getProperty(key));
                        keyList.add(map);
                    }
                }
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            debug(ex);  // 2011.10.10 보안점검 후속조치
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (Exception ex) {
                //ex.printStackTrace();
                //System.out.println("IGNORE: " + ex);  // 2011.10.10 보안점검 후속조치
                Logger.getLogger(EgovProperties.class).debug("IGNORED: " + ex.getMessage());
            }
        }

        return keyList;
    }

    /**
     * 시스템 로그를 출력한다.
     *
     * @param obj Object
     */
    private static void debug(Object obj) {
        if (obj instanceof java.lang.Exception) {
            //((Exception)obj).printStackTrace();
            //System.out.println("DEBUG: " + obj);  // 2011.10.10 보안점검 후속조치
            Logger.getLogger(EgovProperties.class).debug("IGNORED: " + ((Exception) obj).getMessage());
        }
    }
}
