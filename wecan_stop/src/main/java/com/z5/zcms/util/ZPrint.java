package com.z5.zcms.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by Jayden on 7/3/16.
 */
public class ZPrint {

    private final static boolean DEBUG_FLAG = true;

    public static void enter() {
        if (DEBUG_FLAG) {
            String full = Thread.currentThread().getStackTrace()[2].getClassName();
            String name = full.substring(full.lastIndexOf(".") + 1);
            String func = Thread.currentThread().getStackTrace()[2].getMethodName();
            int    line = Thread.currentThread().getStackTrace()[2].getLineNumber();

            System.out.println(String.format("\n[%-25s %4d] %s()", name, line, func));
        }
    }

    public static void enter(String message) {
        if (DEBUG_FLAG) {
            String full = Thread.currentThread().getStackTrace()[2].getClassName();
            String name = full.substring(full.lastIndexOf(".") + 1);
            String func = Thread.currentThread().getStackTrace()[2].getMethodName();
            int    line = Thread.currentThread().getStackTrace()[2].getLineNumber();

            System.out.println(String.format("\n[%-25s %4d] %s(%s)", name, line, func, message));
        }
    }

    public static void enter(HttpServletRequest request) {
        if (DEBUG_FLAG) {
            String full = Thread.currentThread().getStackTrace()[2].getClassName();
            String name = full.substring(full.lastIndexOf(".") + 1);
            String func = Thread.currentThread().getStackTrace()[2].getMethodName();
            int    line = Thread.currentThread().getStackTrace()[2].getLineNumber();

            System.out.print(String.format("\n[%-25s %4d] %s(", name, line, func));
            Enumeration names = request.getParameterNames();
            int         index = 0;
            while (names.hasMoreElements()) {
                String each = (String) names.nextElement();
                if (each != null) {
                    String[] data = request.getParameterValues(each);
                    if (data != null && data.length > 0) {
                        if (index > 0) System.out.print(" ");
                        if (data.length == 1) {
                            System.out.print(String.format("%s:%s", each, data[0]));
                        } else {
                            for (int ndx = 0; ndx < data.length; ++ndx) {
                                System.out.print(String.format("%s%s[%d]:%s", (ndx > 0 ? " ":""), each, ndx, data[ndx]));
                            }
                        }
                        index++;
                    }
                }
            }
            System.out.println(")");
        }
    }

    public static void print(String message) {
        if (DEBUG_FLAG && message != null) {
            String full = Thread.currentThread().getStackTrace()[2].getClassName();
            String name = full.substring(full.lastIndexOf(".") + 1);
            int    line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            System.out.println(String.format("[%-25s %4d] %s", name, line, message));
        }
    }

    public static void print(String message, Object[] list) {
        if (DEBUG_FLAG) {
            String full = Thread.currentThread().getStackTrace()[2].getClassName();
            String name = full.substring(full.lastIndexOf(".") + 1);
            int    line = Thread.currentThread().getStackTrace()[2].getLineNumber();

            System.out.print(String.format("\n[%-25s %4d] %s", name, line, message));
            if (list != null) {
                System.out.print(String.format(" = %2d [", list.length));
                boolean flag = false;
                for (Object item : list) {
                    if (flag) {
                        System.out.print(",");
                    }
                    if (item instanceof String) {
                        System.out.print(String.format(" %s", item));
                    } else if (item instanceof Integer) {
                        System.out.print(String.format(" %2d", item));
                    }
                    flag = true;
                }
            } else {
                System.out.print(String.format(" = %2d [", 0));
            }
            System.out.println(" ]");
        }
    }

    public static void print(String message, Collection collection) {
        if (DEBUG_FLAG) {
            String full = Thread.currentThread().getStackTrace()[2].getClassName();
            String name = full.substring(full.lastIndexOf(".") + 1);
            int    line = Thread.currentThread().getStackTrace()[2].getLineNumber();

            System.out.print(String.format("[%-25s %4d] %s", name, line, message));
            if (collection != null && !collection.isEmpty()) {
                System.out.print(String.format(" = %2d [%s]", collection.size(), StringUtils.join(collection, "|")));
            }
            System.out.println();
        }
    }

    public static void print(String message, Map map) {
        if (DEBUG_FLAG) {
            String full = Thread.currentThread().getStackTrace()[2].getClassName();
            String name = full.substring(full.lastIndexOf(".") + 1);
            int    line = Thread.currentThread().getStackTrace()[2].getLineNumber();

            System.out.print(String.format("[%-25s %4d] %s", name, line, message));
            if (map != null) {
                System.out.print(" = { ");
                Set     sets = map.entrySet();
                boolean flag = false;
                for (Object set : sets) {
                    Entry entry = (Entry) set;
                    if (flag) {
                        System.out.print(", ");
                    }
                    System.out.print(String.format("%s: '%s'", entry.getKey(), entry.getValue()));
                    flag = true;
                }
                System.out.print(" }");
            }
            System.out.println();
        }
    }

    public static void error(String message) {
        if (DEBUG_FLAG) {
            String full = Thread.currentThread().getStackTrace()[2].getClassName();
            String name = full.substring(full.lastIndexOf(".") + 1);
            int    line = Thread.currentThread().getStackTrace()[2].getLineNumber();
            System.out.println(String.format("[%-25s %4d] ERROR, %s", name, line, message));
        }
    }

    public static void param(HttpServletRequest request) {
        Enumeration params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String name = (String) params.nextElement();
            if (name != null) {
                String[] data = request.getParameterValues(name);
                if (data != null && data.length > 0) {
                    if (data.length == 1) {
                        System.out.println(String.format("    %28s   = %s", name, data[0]));
                    } else {
                        for (int ndx = 0; ndx < data.length; ++ndx) {
                            System.out.println(String.format("    %28s[%d]   = %s", name, ndx, data[ndx]));
                        }
                    }
                }
            }
        }
    }

    public static void attrs(HttpServletRequest request) {
        String full = Thread.currentThread().getStackTrace()[2].getClassName();
        String name = full.substring(full.lastIndexOf(".") + 1);
        int    line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        System.out.println(String.format("[%-25s %4d] HTTP request attributes", name, line));

        Enumeration attrs = request.getAttributeNames();
        while (attrs.hasMoreElements()) {
            String key = (String) attrs.nextElement();
            System.out.print(String.format("+ %s => ", key));

            Object value = request.getAttribute(key);
            if (value instanceof String || value instanceof StringBuffer || value instanceof Boolean || value instanceof Integer || value instanceof DataTable) {
                System.out.println(value.toString());
            } else if (value instanceof Collection) {
                Collection c = (Collection) value;
                System.out.println(String.format("%2d [%s]", c.size(), StringUtils.join(c, "|")));
            } else if (value instanceof Map) {
                Map m = (Map) value;
                System.out.println(String.format("%d %s", m.size(), Arrays.toString(m.entrySet().toArray())));
            } else {
                System.out.println(ToStringBuilder.reflectionToString(value, ToStringStyle.SHORT_PREFIX_STYLE));
            }
        }
    }
}
