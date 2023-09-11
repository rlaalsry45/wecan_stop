<%@page import="com.z5.zcms.util.FileManager" %>
<%@ page language="java" import="twitter4j.internal.org.json.JSONObject" %>
<%@ page import="java.io.PrintWriter" %>
<%@include file="auth.jsp" %>
<%
    /*
     *	connector filemanager.jsp
     *
     *	@license	MIT License
     *	@author		Dick Toussaint <d.tricky@gmail.com>
     *	@copyright	Authors
     */
    FileManager fm = new FileManager(getServletContext(), request);

    JSONObject responseData = null;

    String mode = "";
    boolean putTextarea = false;
    if (!auth(request)) {
        fm.error(fm.lang("AUTHORIZATION_REQUIRED"));
    } else {
        try {
            out.clear();
            out = pageContext.pushBody();

            if (request.getMethod().equals("GET")) {
                if (request.getParameter("mode") != null && request.getParameter("mode") != "") {
                    mode = request.getParameter("mode");
                    if (mode.equals("getinfo")) {
                        if (fm.setGetVar("path", request.getParameter("path"))) {
                            responseData = fm.getInfo();
                        }
                    } else if (mode.equals("getfolder")) {
                        System.out.println(request.getParameter("path"));
                        if (fm.setGetVar("path", request.getParameter("path"))) {
                            responseData = fm.getFolder();
                        }
                    } else if (mode.equals("rename")) {
                        if (fm.setGetVar("old", request.getParameter("old")) &&
                                fm.setGetVar("new", request.getParameter("new"))) {
                            responseData = fm.rename();
                        }
                    } else if (mode.equals("delete")) {
                        if (fm.setGetVar("path", request.getParameter("path"))) {
                            responseData = fm.delete();
                        }
                    } else if (mode.equals("addfolder")) {
                        if (fm.setGetVar("path", request.getParameter("path")) &&
                                fm.setGetVar("name", request.getParameter("name"))) {
                            responseData = fm.addFolder();
                        }
                    } else if (mode.equals("download")) {
                        if (fm.setGetVar("path", request.getParameter("path"))) {
                            fm.download(response);
                        }
                    } else if (mode.equals("preview")) {
                        if (fm.setGetVar("path", request.getParameter("path"))) {
                            fm.preview(response);
                        }
                    } else {
                        fm.error(fm.lang("MODE_ERROR"));
                    }
                }
            } else if (request.getMethod().equals("POST")) {
                mode = "upload";
                responseData = fm.add();
                putTextarea = true;
            }

        } catch (Exception e) { // no error handling}
            e.printStackTrace();
        }
    }
    if (responseData == null) {
        responseData = fm.getError();
    }
    if (responseData != null) {
        PrintWriter pw          = response.getWriter();
        String      responseStr = responseData.toString();
        if (putTextarea)
            responseStr = "<textarea>" + responseStr + "</textarea>";
        //fm.log("c:\\logfilej.txt", "mode:" + mode + ",response:" + responseStr);
        pw.print(responseStr);
        pw.close();
    }
%>
