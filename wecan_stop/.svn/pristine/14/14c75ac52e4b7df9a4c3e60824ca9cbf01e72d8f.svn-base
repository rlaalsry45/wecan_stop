package com.z5.zcms.property;

import com.z5.zcms.util.Validator;
import com.z5.zcms.util.ZPrint;
import egovframework.com.cmm.service.EgovProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

import static egovframework.com.cmm.service.EgovProperties.getDocBase;

/**
 * Created by jayden on 18/05/2018.
 */
public class ZCMSProperties {

    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final int    PAGEITEMS = Integer.parseInt(EgovProperties.getProperty("Globals.list.count"));

    public static String frontPage(HttpServletRequest req) {
        final String path = "/zcms/frontsys/target";
        String       page = path + "/error";

        if (req != null) {
            String attr = (String) req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
            if (StringUtils.isNotBlank(attr)) {
                page = path + attr.substring(0, attr.lastIndexOf("."));
            }
        }

//        ZPrint.print("FRONT PAGE : " + page);
        return Validator.path(page);
    }

    public static String adminPage(HttpServletRequest req) {
        String page = "/zcms/adminsys/target/error";

        if (req != null) {
            String attr = (String) req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
            if (StringUtils.isNotBlank(attr)) {
                page = "/zcms/" + attr.substring(0, attr.lastIndexOf("."));
            }
        }

//        ZPrint.print("ADMIN PAGE : " + page);
        return Validator.path(page);
    }

    public static String adminPage(HttpServletRequest req, String... params) {
        StringBuilder page = new StringBuilder("/zcms/adminsys/target/error");

        if (req != null) {
            String attr = (String) req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
            if (StringUtils.isNotBlank(attr)) {
                page = new StringBuilder("redirect:" + attr.substring(0, attr.lastIndexOf("/")));
                for (int index = 0; index < params.length; ++index) {
                    switch (index) {
                        case 0:
                            page.append("/").append(params[index]).append(".html");
                            break;
                        case 1:
                            page.append("?").append(params[index]);
                            break;
                        default:
                            page.append("&").append(params[index]);
                            break;
                    }
                }
            }
        }

//        ZPrint.print("ADMIN PAGE : " + page);
        return Validator.path(page.toString());
    }

    public static String excelPage(HttpServletRequest req) {
        String page = "/zcms/adminsys/target/error";

        if (req != null) {
            String attr = (String) req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
            if (StringUtils.isNotBlank(attr)) {
                page = "/zcms/" + attr.substring(0, attr.lastIndexOf(".")) + "Excel";
            }
        }

        ZPrint.print("EXCEL PAGE : " + page);
        return Validator.path(page);
    }

    public static String echo(Integer menu) {
        String page = "redirect:/?menuno=" + menu;
//        ZPrint.print("menu '" + page + "'");
        return page;
    }

    public String echo(Integer menu, String args) {
        String page = "redirect:/?menuno=" + menu + args;
//        ZPrint.print("menu '" + page + "'");
        return page;
    }

    public static String path(String path) {
        return Validator.path(getDocBase() + SEPARATOR + path);
    }
}
