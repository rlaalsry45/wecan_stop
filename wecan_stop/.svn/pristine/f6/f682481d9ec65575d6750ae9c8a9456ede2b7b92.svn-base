package com.z5.zcms.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import org.springframework.util.SerializationUtils;

import com.oreilly.servlet.Base64Decoder;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.idgnr.impl.Base64;

/**
 * <pre>
 * com.z5.zcms.util
 * StringUtil.java
 * </pre>
 *
 * @Author : 김문석
 * @Date : 2013. 4. 3.
 * @Version :
 */
public class StringUtil {

    public static String getStackTraceAsString(Throwable e) {
        ByteArrayOutputStream bytes  = new ByteArrayOutputStream();
        PrintWriter           writer = new PrintWriter(bytes, true);
        e.printStackTrace(writer);
        return bytes.toString();
    }

    public static String[] split(String str, String delim) {
        // Use a Vector to hold the splittee strings
        Vector<String> v = new Vector<String>();

        // Use a StringTokenizer to do the splitting
        StringTokenizer tokenizer = new StringTokenizer(str, delim);
        while (tokenizer.hasMoreTokens()) {
            v.addElement(tokenizer.nextToken());
        }

        String[] ret = new String[v.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = v.elementAt(i);
        }

        return ret;
    }

    public static String toHangul(String str) {
        return str;
        /*
        if (str == null)
            return null;

        String returnStr = null;
        try {
           // returnStr = new String(str.getBytes("8859_1"), "KSC5601");
              returnStr = new String(str.getBytes("KSC5601"), "8859_1");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(System.out);
        }

        return returnStr;
        */
    }

    public static String toEng(String str) {
        return str;
    	/*
        if (str == null)
            return null;

        String returnStr = null;
        try {
           // returnStr = new String(str.getBytes("8859_1"), "KSC5601");
            returnStr = new String(str.getBytes("8859_1"), "KSC5601" );

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(System.out);
        }

        return returnStr;
        */
    }

    public static String toCP850(String str) {
    	/*
        if (str == null)
            return null;

        String returnStr = null;
        try {
            returnStr = new String(str.getBytes("KSC5601"), "CP850");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(System.out);
        }

        return returnStr;
        */
        return str;
    }

    /*
       public static String toEng(String str) {
            if (str == null)
                return null;

            String returnStr = null;
            try {
                returnStr = new String(str.getBytes("KSC5601"), "8859_1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace(System.out);
            }

            return returnStr;
        }
    */
    public static String toKorean(String str) {
        return toHangul(str);
    }

    public static String toKor(String str) {
        return toHangul(str);
    }


    public static String replace(String source, char oldchar, String newstr) {

        StringBuffer stringbuffer = new StringBuffer();
        int          i            = 0;
        for (int j = source.length(); i < j; i++) {
            char c = source.charAt(i);
            if (c == oldchar)
                stringbuffer.append(newstr);
            else
                stringbuffer.append(c);
        }

        return stringbuffer.toString();
    }

    public static String replace(String in, String from, String to) {
        StringBuffer sb        = new StringBuffer(in.length() * 2);
        String       posString = in.toLowerCase();
        String       cmpString = from.toLowerCase();
        int          i         = 0;
        boolean      done      = false;
        while (i < in.length() && !done) {
            int start = posString.indexOf(cmpString, i);
            if (start == -1) {
                done = true;
            } else {
                sb.append(in.substring(i, start) + to);
                i = start + from.length();
            }
        }
        if (i < in.length()) {
            sb.append(in.substring(i));
        }
        return sb.toString();
    }

    public static String addSlashes(String s) {
        if (s == null) return s;
        String f = "\"";
        String r = "\\\"";

        int index = s.indexOf(f);
        while (index != -1) {
            s = s.substring(0, index) + r + s.substring(index + f.length());
            index += r.length();
            index = s.indexOf(f, index);
        }
        return nl2blk(s);
    }

    public static String nl2blk(String s) {
        s = s.replaceAll("\\n", "");
        s = s.replaceAll("\\r", "");
        return s;
    }

    public static String replaceNull(String str) {
        return replaceNull(str, "");
    }

    public static String replaceNull(String str, String dvalue) {
        if (str == null || str.equals("")) str = dvalue;
        return str;
    }

    public static String left(String str, int len) {
        if (str == null || str.equals("")) str = "";
        else if (str.length() >= len) str = str.substring(0, len) + "..";

        return str;
    }

    public static String TagEliminator(String str) {
        String retval = "";
        retval = HtmlParser.getConvData(str).replaceAll("P \\{margin-top:2px;margin-bottom:2px;\\}", "");

        return retval;

    }

    public static String TagEliminator(String str, int len) {

        String retval = TagEliminator(str);
        if (retval.length() >= len) retval = left(retval, len);

        return retval;

    }

    public static String AddComma(String str) {

        String  retval = "";
        boolean minus  = false;

        if (str.length() == 0) return "";
        if (str.substring(0, 1).equals("-")) {
            minus = true;
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++) {
            retval += str.substring(i, i + 1);
            if ((str.length() - i - 1) % 3 == 0) retval += ",";
        }
        retval = retval.substring(0, retval.length() - 1);
        if (minus) retval = "-" + retval;

        return retval;

    }

    public static String AddComma(int val) {

        return AddComma(Integer.toString(val));

    }

    public static String nl2br(String str) {

        return str.replaceAll("\n", "<br>\n");

    }

    public static String printDate(String str) {

        String fmt = str;
        int    siz = str.length();

        if (siz >= 14) {
            fmt = str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8) + " " + str.substring(8, 10) + ":" + str.substring(10, 12) + ":" + str.substring(12, 14);
        } else if (siz >= 12) {
            fmt = str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8) + " " + str.substring(8, 10) + ":" + str.substring(10, 12);
        } else if (siz >= 8) {
            fmt = str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
        }

        return fmt;
    }

    public static String printDate2(String str) {

        if (str.length() == 12) {
            return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8) + " " + str.substring(8, 10) + ":" + str.substring(10, 12);
        } else return str;

    }

    public static String printDate8(String str) {

        if (str.length() == 14) {
            return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
        } else return str;

    }

    public static String printDateMD(String str) {

        if (str.length() == 14) {
            return str.substring(4, 6) + "-" + str.substring(6, 8);
        } else return str;

    }

    public static String printDateS() {
        Calendar                   cal       = Calendar.getInstance();
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("MM.dd(E)");
        return formatter.format(cal.getTime());
    }

    public static String ramdomMix() {

        Random rnd = new Random();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < 10; i++) {

            if (rnd.nextBoolean()) {
                buf.append((char) ((rnd.nextInt(26)) + 97));
            } else {
                buf.append((rnd.nextInt(10)));
            }

        }
        //System.out.println(buf);
        return buf.toString();

    }

    /* string : Encode / Decode */
    public static String encryptString(String str) {

        // encrypt key
        byte keyChar[] = {0x01, 0x03, 0x01, 0x05, 0x01, 0x03, 0x01, 0x01};

        // target to encrypt

        // make array to string length
        byte codeChar[] = new byte[str.getBytes().length];

        // convert string to byte
        codeChar = str.getBytes();


        // XOR calculation
        for (int i = 0, j = 0; i < str.getBytes().length; i++) {

            // convert byte type after ^(XOR) calculating with 1 letter of string and 1 letter of key
            codeChar[i] = (byte) (codeChar[i] ^ keyChar[j]);

            j = (++j < keyChar.length ? j : 0);
        }

        return new String(codeChar);

    }


    /* cut String : original string, length, suffix */
    /* last empty will delete */
    public static String getCutUTFString(String str, int len, String tail) {

        if (str.length() <= len) {
            return str;
        }

        StringCharacterIterator sci    = new StringCharacterIterator(str);
        StringBuffer            buffer = new StringBuffer();
        buffer.append(sci.first());

        for (int i = 1; i < len; i++) {
            if (i < len - 1) {
                buffer.append(sci.next());
            } else {
                char c = sci.next();
                // if last charater is not empty
                if (c != 32) {
                    buffer.append(c);
                }
            }
        }

        buffer.append(tail);

        return buffer.toString();
    }

    public static boolean isNumeric(String str) {

        if (str.length() == 0) {
            return false;
        }

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum   = pattern.matcher(str);

        return !isNum.matches() ? false : true;
    }

    public static String delSpace(String[] str) {

        if (null == str) return "";

        return Arrays.toString(str).replaceAll("^\\[| |(, )?]$", "");
    }

    public static String delSpace2(String[] str) {

        if (null == str) return "";

        return Arrays.toString(str).replaceAll("^\\[| |\\]$", "");
    }

    public static String delComma(String str) {

        if (null == str) return "";

        return str.replaceAll("^\\[| |\\]$", "");
    }

    /*  지정한  정수의  개수  만큼  빈칸("  ")을  스트링을  구한다.
     *
     *  @param  int  문자  개수
     *  @return  String  지정된  개수  만큼의  빈칸들로  연결된  String
     */
    public static String spaces(int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    /*  지정한  정수의  개수  만큼  빈칸("  ")을  스트링을  구한다.
     *  절단된  String의  바이트  수가  자를  바이트  개수보다  모자라지  않도록  한다.
     *
     *  @param  str  원본  String
     *  @param  int  자를  바이트  개수
     *  @return  String  절단된  String
     */
    public static String cutStringByBytes(String str, int length) {
        byte[] bytes   = str.getBytes();
        int    len     = bytes.length;
        int    counter = 0;
        if (length >= len) {
            return str + spaces(length - len);
        }
        for (int i = length - 1; i >= 0; i--) {
            if (((int) bytes[i] & 0x80) != 0) counter++;
        }
        return new String(bytes, 0, length + (counter % 2));
    }


    /*  지정한  정수의  개수  만큼  빈칸("  ")을  스트링을  구한다.
     *  절단된  String의  바이트  수가  자를  바이트  개수를  넘지  않도록  한다.
     *
     *  @param  str  원본  String
     *  @param  int  자를  바이트  개수
     *  @return  String  절단된  String
     */
    public static String cutInStringByBytes(String str, int length) {
        byte[] bytes   = str.getBytes();
        int    len     = bytes.length;
        int    counter = 0;
        if (length >= len) {
            return str + spaces(length - len);
        }
        for (int i = length - 1; i >= 0; i--) {
            if (((int) bytes[i] & 0x80) != 0) counter++;
        }
        return new String(bytes, 0, length - (counter % 2));
    }

    /*
     * szText: 입력받는 원본 문자열
     * szKey: 시작할 키워드
     * nLength: 자를 길이
     * nPrev: 시작할 키워드 이전 포함할 문자의 길이
     * isNotag: HTML 태그 제거 여부
     * isAdddot: 생략 "..." 표시 출력 여부
     * commentcnt: 코멘트 개수
     */
    public static String stringCut(String szText, String szKey, int nLength, int nPrev, boolean isNotag, boolean isAdddot, int commentcnt) {

        if (null == szText || szText.trim().isEmpty()) return "";

        Pattern p = Pattern.compile("<(/?)([^<>]*)?>", Pattern.CASE_INSENSITIVE);  // 태그제거 패턴

        if (isNotag) {
            szText = p.matcher(szText).replaceAll("");
        }  // 태그 제거
        szText = szText.replaceAll("&", "&");
        szText = szText.replaceAll("(!/|\r|\n| )", "");  // 공백제거

        if (nLength <= 0) return szText;

        int nLengthPrev = 0;
        if (null != szKey && !szKey.trim().isEmpty()) {
            nLengthPrev = (szText.indexOf(szKey) == -1) ? 0 : szText.indexOf(szKey);  // 일단 위치찾고
            if (nLengthPrev > 0) {
                String tmp     = szKey.substring(0, nLengthPrev);
                char[] newChar = null;
                char[] tmpArr  = tmp.toCharArray();
                if (tmpArr.length >= nPrev) {
                    int                  sLen = 0;
                    ArrayList<Character> s    = new ArrayList<Character>();
                    for (int i = tmpArr.length - 1; i > 0; i--) {
                        sLen = tmpArr[i] < 256 ? sLen + 1 : sLen + 2;
                        if (sLen <= nPrev) s.add(tmpArr[i]);
                        else break;
                    }
                    if (!s.isEmpty()) {
                        Character[] character = s.toArray(new Character[0]);
                        newChar = new char[character.length];
                        for (int i = character.length - 1; i > 0; i--) {
                            newChar[character.length - (i + 1)] = character[i].charValue();
                        }
                    }
                    return (newChar != null) ? new String(newChar) : "";
                } else {
                    return tmp;
                }
            }
        }

        byte[] strbyte = null;

        if (commentcnt > 0) {
            nLength -= ("[" + commentcnt + "]").length();
        }

        strbyte = szText.getBytes();

        if (strbyte.length <= nLength) {
            return szText;
        }

        char[]               charArray = szText.toCharArray();
        ArrayList<Character> s         = new ArrayList<Character>();

        int     sLen = 0;
        boolean flag = false;
        for (int i = 0; i < charArray.length; i++) {
            sLen = charArray[i] < 256 ? sLen + 1 : sLen + 2;
            if (sLen <= nLength) s.add(charArray[i]);
            else {
                flag = true;
                break;
            }
        }

        Character[] character = s.toArray(new Character[0]);
        char[]      newChar   = new char[character.length];
        for (int i = 0; i < character.length; i++) {
            newChar[i] = character[i].charValue();
        }

        String returnStr = commentcnt > 0 ? new String(newChar) + "[" + commentcnt + "]" : new String(newChar);

        if (isAdddot && flag) returnStr += "...";

        return returnStr;
    }

    /**
     * 내용 : 객체에 대해서 직렬화후 BASE64 형태의 String으로 돌려준다.
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 3.
     * method_name : setBase64
     *
     * @param instance
     * @return
     * @throws IOException
     */
    public static String makeBase64ForObject(Object instance) throws IOException {

        return new String(Base64.encode(SerializationUtils.serialize(instance.toString())));

    }

    /**
     * 내용 : Base64형태의 직렬화된 String을 Decoding 하여 원래의 Object형태로 돌려준다. 형변환을 실시할것
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 3.
     * method_name : getObject
     *
     * @param base64String
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static String getObjectFromBase64(String base64String) throws IOException, ClassNotFoundException {
        //System.out.println(SerializationUtils.deserialize(Base64Decoder.decodeToBytes( base64String )));
        return (String) SerializationUtils.deserialize(Base64Decoder.decodeToBytes(base64String));

    }


    /**
     * 내용 : no, type, skin을 받아서 org.jsoup.nodes.Element를 만들어 반환한다.
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 3.
     * method_name : makeElement
     *
     * @param no
     * @param type
     * @param skin
     * @return
     * @throws IOException
     */
    public static Element makeElement(Object no, String type, String skin) throws IOException {
        Document doc   = new Document("");
        Element  param = doc.createElement("call");
        param.attr("type", type);
        param.attr("no", (String) no);
        param.attr("skin", skin);

        return param;

    }

    /**
     * 내용 : no, type, skin을 받아서 org.jsoup.nodes.Element를 만들어 Base64로 만들어 String을 반환.
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 3.
     * method_name : makeElementAndBase64
     *
     * @param no
     * @param type
     * @param skin
     * @return
     * @throws IOException
     */
    public static String makeElementAndBase64(Object no, String type, String skin) throws IOException {
        Document doc   = new Document("");
        Element  param = doc.createElement("call");
        param.attr("type", type);
        param.attr("no", (String) no);
        param.attr("skin", skin);

        return makeBase64ForObject(param);

    }

    /**
     * 내용 : 비밀번호 난수 발생
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 24.
     * method_name : getRandomString
     *
     * @return
     */
    public static String getRandomString() {
        StringBuffer sb = new StringBuffer();

        sb.append((char) ((Math.random() * 26) + 65));//첫글자는 대문자로 바꿈
        for (int i = 0; i < 3; i++) {//대문자 3글자 생성
            sb.append((char) ((Math.random() * 26) + 65));
        }


        sb.append((char) ((Math.random() * 10) + 48));

        for (int i = 0; i < 4; i++) {//소문자 4글자 생성
            sb.append((char) ((Math.random() * 26) + 97));
        }

        sb.append((char) ((Math.random() * 10) + 48));

        //sb.setCharAt(((int)(Math.random()*3)+1), sc.charAt((int)(Math.random()*sc.length()-1)));//대문자3개중 하나를 특수문자로 치환
        //sb.setCharAt(((int)(Math.random()*4)+4), sc.charAt((int)(Math.random()*sc.length()-1)));//소문자4개중 하나를 특수문자로 치환

        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 내용 : InputStream을 string 으로 전환하는 메소드
     * 작성자 : 김문석
     * 작성시간  : 2013. 4. 25.
     * method_name : getStringFromInputStream
     *
     * @param is
     * @return String
     */
    public static String getStringFromInputStream(InputStream is) {

        InputStreamReader sr = null;
        BufferedReader    br = null;
        StringBuilder     sb = new StringBuilder();

        try {

            sr = new InputStreamReader(is, StandardCharsets.UTF_8);
            br = new BufferedReader(sr);

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException ignored) {
//            e.printStackTrace();
        } finally {
            if (sr != null) {
                try { sr.close(); } catch (IOException ignored) { }
            }
            if (br != null) {
                try { br.close(); } catch (IOException ignored) { }
            }
        }

        return sb.toString();

    }

    /**
     * 내용 : fullurl을 가져오는 메소드
     * 작성자 : 김문석
     * 작성시간  : 2014. 5. 26.
     * method_name : getFullURL
     *
     * @param is
     * @return
     */
    public static String getFullURI(HttpServletRequest request) {
        String requestURI  = request.getRequestURI();
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURI;
        } else {
            return requestURI + "?" + queryString;
        }
    }


    //html 소스에서 테그를 제거하고 순수 내용만 뽑아낸다.
    public static String html2text(String html) {
        if (html == null) {
            return "";
        }
        return Jsoup.parse(html).text();
    }

    //도메인과 포트를 자동으로 구성하여 돌려준다.
    //port가 80인경우 http://도메인
    //80이 아닌경우 http://도메인:port의 형태로 돌려준다.
    public static String getServerNameWithPortNumber(HttpServletRequest request) {
        String port = Integer.toString(request.getServerPort());
        if (port.isEmpty() || port.equals("80")) {
            return "http://" + request.getServerName();
        } else {
            if (request.isSecure()) {
                return "https://" + request.getServerName();
            } else {
                return "http://" + request.getServerName() + ":" + port;
            }
        }
    }


    /**
     * 김문석
     *
     * @param parameter
     * @return XSS 대비 메소드
     * html테그를 치환한다.
     */

    public static String setHTMLTagTOSpecialCharacters(String value) {

        if (value == null) {
            return null;
        }

        StringBuffer strBuff = new StringBuffer();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            switch (c) {
                case '<':
                    strBuff.append("&lt;");
                    break;
                case '>':
                    strBuff.append("&gt;");
                    break;
                case '&':
                    strBuff.append("&amp;");
                    break;
                case '"':
                    strBuff.append("&quot;");
                    break;
                case '\'':
                    strBuff.append("&apos;");
                    break;
                default:
                    strBuff.append(c);
                    break;
            }
        }

        value = strBuff.toString();

        return value;
    }

    /**
     * AntiSamy cross domain script prevent
     * 김문석 20141110
     */

    public static String getCleanHTML(String value) {
        String result = null;
        if (value == null) {
            return null;
        }
        try {
            String       antisamyXmlPath = EgovProperties.getPathProperty("Globals.antisamy");
            Policy       policy          = Policy.getInstance(antisamyXmlPath);
            CleanResults cs              = new AntiSamy().scan(value, policy, AntiSamy.SAX);
            result = cs.getCleanHTML();
        } catch (PolicyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * XSS 방지 처리.
     *
     * @param data
     * @return
     */
    public static String unscript(String data) {
        if (data == null || data.trim().equals("")) {
            return "";
        }

        String ret = data;

        ret = ret.replaceAll("<(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;script");
        ret = ret.replaceAll("</(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;/script");

        ret = ret.replaceAll("<(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;object");
        ret = ret.replaceAll("</(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;/object");

        ret = ret.replaceAll("<(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;applet");
        ret = ret.replaceAll("</(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;/applet");

        ret = ret.replaceAll("<(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");
        ret = ret.replaceAll("</(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");

        ret = ret.replaceAll("<(F|f)(O|o)(R|r)(M|m)", "&lt;form");
        ret = ret.replaceAll("</(F|f)(O|o)(R|r)(M|m)", "&lt;form");

        ret = ret.replaceAll("(A|a)(L|l)(E|e)(R|r)(T|t)", "");

        return ret;
    }

    /**
     * 현재시간 String으로 가져오기
     */

    public static String getCurrentTimeMillis() {
        long             time    = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String           strDT   = dayTime.format(new Date(time));
        return (strDT);
    }
    
    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }
}
