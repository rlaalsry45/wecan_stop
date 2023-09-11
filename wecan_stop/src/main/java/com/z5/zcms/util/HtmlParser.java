package com.z5.zcms.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import javax.servlet.http.HttpSession;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HtmlParser {
    private static StringBuffer out_text = null;
    private static int parser_ok = 0;
    private static Map<String, String> referencesMap = new HashMap<String, String>();

    static {
        referencesMap.put("'", "\\'");
        referencesMap.put("\"", "\\\"");
        referencesMap.put("\\", "\\\\");

        referencesMap.put("\n", "\\\n");
        referencesMap.put("\0", "\\\0");
        referencesMap.put("\b", "\\\b");
        referencesMap.put("\r", "\\\r");
        referencesMap.put("\t", "\\\t");
        referencesMap.put("\f", "\\\f");
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    public HtmlParser() {
    }

    public static String getConvData(String htmlData) {
        out_text = new StringBuffer();

        if (htmlData.indexOf("<meta") != -1) {
            String temp = "";
            while (htmlData.indexOf("<meta") != -1) {
                temp = htmlData.substring(0, htmlData.indexOf("<meta"));
                htmlData = htmlData.substring(htmlData.indexOf(">", htmlData.indexOf("<meta")) + 1, htmlData.length());
                htmlData = temp + htmlData;
            }
        }

        try {
            HTMLEditorKit.ParserCallback callback = new HTMLEditorKit.ParserCallback() {
                @Override
                public void handleStartTag(HTML.Tag tag, MutableAttributeSet a, int pos) {
                    if (tag.equals(HTML.Tag.BODY)) parser_ok = 1;
                }

                @Override
                public void handleText(char[] data, int pos) {
                    if (parser_ok == 1) {
                        for (int k = 0; k < data.length; k++) {
                            if (data[k] == (char) 160) data[k] = (char) 32;
                            else out_text.append(data[k]);
                        }
                    }
                }
            };

            new ParserDelegator().parse(new StringReader(htmlData), callback, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out_text.toString();
    }

    /**
     * Given a string, this method replaces all occurrences of
     * '<' with '&lt;', all occurrences of '>' with
     * '&gt;', and (to handle cases that occur inside attribute
     * values), all occurrences of double quotes with
     * '"' and all occurrences of '&' with '&'.
     * Without such filtering, an arbitrary string
     * could not safely be inserted in a Web page.
     */

    public static String filter(String input) {

        if (input == null) {
            return "";
        }

        if (!hasSpecialChars(input)) {
            return (input);
        }

        StringBuffer filtered = new StringBuffer(input.length());

        char c;

        for (int i = 0; i < input.length(); i++) {

            c = input.charAt(i);

            if (c == '<') {
                filtered.append("&lt;");
            } else if (c == '>') {
                filtered.append("&gt;");
            } else if (c == '"') {
                filtered.append("&quot;");
            } else if (c == '&') {
                filtered.append("&#38;");
            } else {
                filtered.append(c);
            }
        }

        return (filtered.toString());
    }

    public static String filterReply(String input) {

        if (!hasSpecialChars(input)) {
            return (input);
        }

        StringBuffer filtered = new StringBuffer(input.length());

        char c;

        for (int i = 0; i < input.length(); i++) {

            c = input.charAt(i);

            if (c == '<') {
                filtered.append("&lt;");
            } else if (c == '>') {
                filtered.append("&gt;");
            } else if (c == '"') {
                filtered.append("&quot;");
            } else if (c == '&') {
                filtered.append("&#38;");
            } else {
                filtered.append(c);
            }
        }

        return (filtered.toString());
    }

    public static boolean hasSpecialChars(String input) {

        boolean flag = false;

        if ((input != null) && (input.length() > 0)) {

            char c;

            for (int i = 0; i < input.length(); i++) {

                c = input.charAt(i);

                switch (c) {
                    case '<':
                        flag = true;
                        break;
                    case '>':
                        flag = true;
                        break;
                    case '"':
                        flag = true;
                        break;
                    case '&':
                        flag = true;
                        break;
                }
            }
        }

        return flag;
    }

    //escape sql tag with the source code.
    public static String MYSQLEncoder(String source) {
        if (source == null)
            return "";

        StringBuffer sbuffer = new StringBuffer(source.length());

        for (int i = 0; i < source.length(); i++) {
            String c = source.substring(i, i + 1);

            //System.out.println("c=" + c);
            //System.out.println(referencesMap.get(c));

            if (referencesMap.get(c) != null) {
                sbuffer.append(referencesMap.get(c));
            } else {
                sbuffer.append(c);
            }
        }
        return sbuffer.toString();
    }

    public static DataTable ztagsParser(String HTML, DataTable input) throws ClassNotFoundException, IOException {

        StringBuffer stringBufferJS = new StringBuffer();
        StringBuffer stringBufferCSS = new StringBuffer();
        DataTable result = new DataTable();

        Document doc;
        Elements ztags;

        ArrayList<String> htmlfile = new ArrayList<String>();

        String act = input.get("act");
        //String join_type = input.get("type");
        //print("act: " + act + " ztag:" + input.get("ztag"));

        //세션을 검색하여, 인증을 받았고 회원가입을 시도하는 경우act값을 변경한다.
        HttpSession session = input.getRequest().getSession();

//        if (!join_type.equals("2")) { //개인회원일 경우에만 체
//            if (act.equals("join")) {
//                String niceName = (String) session.getAttribute("niceName");
//                if (niceName == null || niceName.equals("")) {
//                    act = "join_chk";
//                }
//            } else if (act.equals("join_chk")) {
//                String niceName = (String) session.getAttribute("niceName");
//                if (!(niceName == null || niceName.equals(""))) {
//                    act = "join";
//                }
//            }
//        }

        //외국인가입의 경우 그냥 바로 join으로 넘긴다.
//        String foreigner = input.get("foreigner");
//        if (foreigner.equals("1")) {
//            session.setAttribute("foreigner", "1");
//            act = "join_foreigner";
//        }

        if ((act.equals("usermodify_chk") || act.equals("usermodify")) &&
            (session.getAttribute("zUserVo") == null || session.getAttribute("zUserVo") == "")) {
            act = "login";
        }

        if ("write".equals(act) ||
            "finish".equals(act) ||
            "edit".equals(act) ||
            "reply".equals(act) ||
//            "view".equals(act) ||
            "terms".equals(act) ||
            "find".equals(act) ||
            "modify".equals(act) ||
            "result".equals(act) ||
            "regmng".equals(act) ||
            "wrongauth".equals(act)) {
            doc = Jsoup.parseBodyFragment(StringUtil.getObjectFromBase64(input.get("ztag")));
            ztags = doc.select("call");
            result.put("parthtml", HTML.split("<(c|C)(a|A)((l|L){2}).+?>", ztags.size() + 1));
            String skin = ztags.get(0).attr("skin");
            String type = ztags.get(0).attr("type");

            if ("board".equals(type)) {
                stringBufferJS.append("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/var/ckeditor/ckeditor.js\"></script>\n");
            }

            stringBufferJS.append("<script type=\"text/javascript\" src=\"/com/js/jquery-1.12.3.min.js\"></script>\n");
            stringBufferJS.append("<script type=\"text/javascript\" src=\"/com/js/jquery.form.js\"></script>\n");
            stringBufferJS.append("<script type=\"text/javascript\" src=\"/com/js/loader.js\"></script>\n");

            stringBufferCSS.append("<link rel=\"stylesheet\" href=\"/usr/skin/" + type + "/" + skin + "/css/" + type + ".css\" type=\"text/css\" />\n");

            if ("board".equals(type)) {
                if ("view".equals(act) || "regmng".equals(act)) {
                    stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/skin/board/" + skin + "/js/" + act + ".js\" defer></script>\n");
                } else {
                    stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/skin/board/" + skin + "/js/write.js\" defer></script>\n");
                    stringBufferJS.append("<script type=\"text/javascript\" src=\"/cms/js/My97DatePicker/WdatePicker.js\" defer></script>\n");
                }
            } else {
                stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/skin/" + type + "/" + skin + "/js/" + act + ".js\" defer></script>\n");
            }

            String file = act + ".html";
            if ("board".equals(type)) {
                if ("edit".equals(act) || "reply".equals(act)) {
                    file = "write.html";
                }
            }

            htmlfile.add("/skin/" + type + "/" + skin + "/" + file);
        } else {
            doc = Jsoup.parseBodyFragment(HTML);
            ztags = doc.select("call");
            result.put("parthtml", HTML.split("<(c|C)(a|A)((l|L){2}).+?>", ztags.size() + 1));
            if (ztags.size() > 0) {

                String skin = ztags.get(0).attr("skin");
                String type = ztags.get(0).attr("type");

                stringBufferJS.append("<link rel=\"stylesheet\" href=\"/var/alertify/alertify.css\"/>\n"); // by superbolt
                if ("board".equals(type)) {
                    stringBufferJS.append("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/var/ckeditor/ckeditor.js\"></script>\n");
                }

                stringBufferJS.append("<script type=\"text/javascript\" src=\"/com/js/jquery-1.12.3.min.js\"></script>\n");
                stringBufferJS.append("<script type=\"text/javascript\" src=\"/com/js/jquery.form.js\"></script>\n");
                stringBufferJS.append("<script type=\"text/javascript\" src=\"/var/alertify/alertify.js\"></script>\n"); // by superbolt
                for (Element each : ztags) {
                    if ("banner".equals(each.attr("type"))) {
                        stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/js/banner.js\" defer></script>\n");
                        break;
                    }
                }

                Elements ztags_b = ztags.clone();

                for (int i = 0; i < ztags_b.size() - 1; i++) {
                    for (int j = ztags_b.size() - 1; j > i; j--) {
                        if (ztags_b.get(i).attr("type").equals(ztags_b.get(j).attr("type"))) {
                            if (ztags_b.get(i).attr("skin").equals(ztags_b.get(j).attr("skin"))) {
                                ztags_b.remove(j);
                            }
                        }
                    }
                }

                for (Element ztag : ztags_b) {
                    if (!(ztag.attr("type").equals("popup") || ztag.attr("type").equals("layerpopup"))) {
                        type = ztag.attr("type").isEmpty() ? "board" : ztag.attr("type");
                        skin = ztag.attr("skin").isEmpty() ? "default" : ztag.attr("skin");
                        stringBufferCSS.append("<link rel=\"stylesheet\" href=\"/usr/skin/" + type + "/" + skin + "/css/" + type + ".css\" type=\"text/css\" />\n");
                        if ("".equals(act) || "/PrvwPage".equals(act)) {
                            if ("board".equals(type)) {
                                if (input.getInt("menuno") > 0) {
                                    act = ztag.attr("act").isEmpty() ? "list" : ztag.attr("act");
                                    stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/skin/" + type + "/" + skin + "/js/" + act + ".js\" defer></script>\n");
                                } else {
                                    stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/skin/" + type + "/" + skin + "/js/latest.js\" defer></script>\n");
                                }
                            } else if ("member".equals(type)) {
                                stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/skin/" + type + "/" + skin + "/js/login.js\" defer></script>\n");
                            } else {
                                stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/skin/" + type + "/" + skin + "/js/" + type + ".js\" defer></script>\n");
                            }
                        } else {
                            stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/skin/" + type + "/" + skin + "/js/" + act + ".js\" defer></script>\n");
                        }
                    }/*else{
                        type = ztag.attr("type").isEmpty() ? "board" : ztag.attr("type");
						skin = ztag.attr("skin").isEmpty() ? "default" : ztag.attr("skin");
						stringBufferJS.append("<script type=\"text/javascript\" src=\"/usr/skin/"+type+"/"+skin+"/js/"+type+".js\" defer></script>\n");
					}*/
                }

                for (int i = 0; i < ztags.size(); i++) {
                    type = ztags.get(i).attr("type").isEmpty() ? "board" : ztags.get(i).attr("type");
                    skin = ztags.get(i).attr("skin").isEmpty() ? "default" : ztags.get(i).attr("skin");

                    String file = act + ".html";
                    if ("board".equals(type)) {
                        file = input.getInt("menuno") > 0 ? (ztags.get(i).attr("act").isEmpty() ? "list.html" : ztags.get(i).attr("act") + ".html") : "latest.html";

                        if (act.equals("view")) file = "view.html";

                    } else if ("member".equals(type)) {
                        file = "login.html";

                        //회원가입, ID/PW찾기 시 사용
                        if ("find_id".equals(act) ||
                            "find_pw".equals(act) ||
                            "find_inst".equals(act) ||
                            "join_type".equals(act) ||
                            "join_agree".equals(act) ||
                            "join_chk".equals(act) ||
                            "complete".equals(act) ||
                            "join".equals(act) ||
                            "userout".equals(act) ||
                            "usermodify".equals(act) ||
                            "usermodifypw".equals(act) ||
                            "usermodify_chk".equals(act) ||
                            "join_foreigner".equals(act) ||
                            "join_foreigner_chk".equals(act) ||
                            "login_foreigner".equals(act) ||
                            "usermodify_foreigner".equals(act) ||
                            "usermodify_foreigner_chk".equals(act)) {
                            file = act + ".html";
                        }
                    } else {
                        file = type + ".html";
                    }//html로 바꿀것, popup은 html로 되어 있음
                    htmlfile.add("/skin/" + type + "/" + skin + "/" + file);
                }
            }
        }

        result.put("ztags", ztags);
        result.put("jsfile", stringBufferJS);
        result.put("cssfile", stringBufferCSS);
        result.put("htmlfile", htmlfile);

        return result;
    }
}
