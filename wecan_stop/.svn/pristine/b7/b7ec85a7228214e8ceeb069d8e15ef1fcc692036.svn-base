package com.z5.zcms.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.z5.zcms.util.ZPrint.error;
import static com.z5.zcms.util.ZPrint.print;

public class Browser {

    public static boolean isIE(String userAgent) {
        if (StringUtils.isNotBlank(userAgent)) {
            return userAgent.toUpperCase().contains("MSIE") || userAgent.toUpperCase().contains("TRIDENT");
        }
        return false;
    }

    public static boolean isIE(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (StringUtils.isNotBlank(userAgent)) {
            return userAgent.toUpperCase().contains("MSIE") || userAgent.toUpperCase().contains("TRIDENT");
        }
        return false;
    }

    public static String fileName(String userAgent, String fileName) {
        try {
            if (StringUtils.isNotBlank(userAgent) && StringUtils.isNotBlank(fileName)) {
                String fn = fileName.replaceAll("\\s{2,}", " ").trim();
                if (isIE(userAgent)) {
                    return URLEncoder.encode(fn, "utf-8").replaceAll("\\+", "%20");
                } else {
                    return new String(fn.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public static void download(HttpServletRequest request, HttpServletResponse response, String path, String name) {
        try {
            File file = new File(path);
            if (file.exists()) {
                print(path + " : " + Converter.fileSize(file));
                int    fileSize = (int) file.length();
                String fileName = fileName(request.getHeader("User-Agent"), name);

                response.setBufferSize(fileSize);
                response.setContentType("application/octet-stream");
                response.setHeader("Accept-Ranges", "bytes");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
                response.setHeader("Content-Transfer-Encoding", "binary");
                response.setContentLength(fileSize);

                InputStream  fis = new FileInputStream(file);
                OutputStream out = response.getOutputStream();
                try {
                    byte[] buffer = new byte[4096];
                    int    bytes;
                    while ((bytes = fis.read(buffer)) != -1) {
                        out.write(buffer, 0, bytes);
                    }
                    out.flush();
                } finally {
                    try { fis.close(); } catch (IOException ignored) { }
                    try { out.close(); } catch (IOException ignored) { }
                    Runtime.getRuntime().gc(); // By superbolt for big file
                }
            } else {
                error("Not found " + path);
                response.setContentType("text/html");
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("utf-8");

                PrintWriter pw = response.getWriter();
                pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
                pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"ko\" xml:lang=\"ko\">");
                pw.println("<head>");
                pw.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
                pw.println("<script type='text/javascript'>");
                pw.println("  alert('" + name + "' + ' 파일이 없습니다!');");
                pw.println("  history.go(-1);");
                pw.println("</script>");
                pw.println("</head>");
                pw.println("</html>");
                pw.flush();
                pw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
