package com.z5.zcms.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;

import static egovframework.com.cmm.service.EgovFileMngUtil.getTimeStamp;

public class FileUtil {

    public static String UploadFileMove(String fn, String path, String url) {
        return UploadFileMove(fn, path, url, "");
    }

    public static String UploadFileMove(String fn, String path, String url, String given_fn) {
        String newfn = "";

        if (fn != null && !fn.equals("")) {
            Long   nano    = System.nanoTime();
            String nanoStr = nano.toString();
            File   f       = new File(path + "/" + fn);
            String tmp[]   = fn.split("\\.");
            String ext     = tmp[tmp.length - 1];
            if (given_fn.equals(""))
                newfn = DateUtil.getShortDateString() + "_" + nanoStr + "." + ext.toLowerCase();
            else
                newfn = given_fn + "." + ext;

            if (f != null) {
                File f2 = new File(path + "/" + newfn);
                f.renameTo(f2);
            }
            //return url + "/" + newfn;
            return newfn;
        }
        return null;
    }

    public static String readFile(String fn) throws IOException {
        String         fileData = null;
        BufferedReader br       = null;
        try {
            br = new BufferedReader(new FileReader(fn));

            StringBuffer readBuf = new StringBuffer();
            String       line    = null;

            while ((line = br.readLine()) != null) {
                readBuf.append(line);
                readBuf.append("\n");
            }

            fileData = readBuf.toString();
        } catch (FileNotFoundException _fnfe) {
            throw new FileNotFoundException("file not found");
        } catch (IOException _ie) {
            throw new IOException("While read a file, input/output error occurred.");
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return fileData;
    }

    public static boolean deleteFile(String fn) {
        try {

            String[] fns = fn.split(",");
            for (String name : fns) {
                File file = new File(name.replaceAll("//", "/"));
                file.delete();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return false;

    }

    public static String writeFile(String path, String ext, String contents) {
        try {
            Long   nano = System.nanoTime();
            String late = DateUtil.getShortDateString() + "_" + nano.toString() + "." + ext;

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path + File.separator + late), "UTF-8"), true);
            pw.println(contents);
            pw.close();
            return late;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "";
    }

    public static String makeNewFileName(String src) {
        String[] spot = src.split("\\.");
        String   name = getTimeStamp();
        return spot.length == 1 ? name : name + "." + spot[spot.length - 1].toLowerCase();
    }

    public static boolean editFile(String path, String fn, String contents) {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path + File.separator + fn), "UTF-8"), true);
            pw.println(contents);
            pw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public static boolean copyFolder(String source, String dest) {
        try {

            String[] cmd       = null;
            int      exitValue = 1;

            dest = dest.replaceAll(" ", "");

            if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") > -1) {
/*				cmd = new String[6];
				cmd[0] = "cmd";
				cmd[1] = "/c";
				cmd[2] = "xcopy";
				cmd[3] = "/e/c/r/t/y";
				cmd[4] = source;
				cmd[5] = dest+File.separator;

				exitValue = Runtime.getRuntime().exec(cmd).waitFor();
*/
                FileUtils.copyDirectory(new File(source), new File(dest), false);

                return true;
            } else {
                cmd = new String[4];
                cmd[0] = "/bin/cp";
                cmd[1] = "-af";
                cmd[2] = source + File.separator;
                cmd[3] = dest;

                String[] delcmd = new String[3];
                delcmd[0] = "/bin/rm";
                delcmd[1] = "-rf";
                delcmd[2] = dest;

                if (Runtime.getRuntime().exec(delcmd).waitFor() == 0) {
                    exitValue = Runtime.getRuntime().exec(cmd).waitFor();
                }
            }

            return exitValue == 0 ? true : false;

        } catch (Exception e) {

            System.out.println(e.toString());

            return false;

        }

/*		try {

			FileUtils.copyDirectory(new File(source), new File(dest), false);

			return true;

		}catch (Exception e) {
			System.out.println(e.toString());

			return false;
		}*/
    }

    public static boolean createFolder(String folder) {

        try {
            File    dirFile = new File(folder);
            boolean bFile   = dirFile.exists();
            if (bFile == true) {
                return true;
            } else {
                bFile = dirFile.mkdirs();
                if (bFile == true) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {

            System.out.println(e.toString());

            return false;

        }
    }

    public static boolean editFolder(String source, String dest) {
        try {

            File srcDir = new File(source);
            return srcDir.renameTo(new File(dest));
        } catch (Exception e) {

            System.out.println(e.toString());

            return false;

        }
    }

    public static boolean deleteFolder(String dest) {
        try {

            String[] fns = dest.split(",");

            for (String fp : fns) {
                File f = new File(fp);
                FileUtils.deleteDirectory(f);
            }

            return true;

        } catch (Exception e) {

            System.out.println(e.toString());

            return false;

        }
    }

    public static ArrayList<String> getSkin(String folder) {

        ArrayList<String> filelist = new ArrayList<String>();

        try {

            File dir = new File(folder);

            File[] files = dir.listFiles();

            for (File val : files) {
                if (val.isDirectory()) {
                    filelist.add(val.getName());
                }
            }

            Collections.sort(filelist);

            return filelist;
        } catch (Exception e) {

            System.out.println(e.toString());

            return filelist;

        }
    }

    public static ArrayList<String> getSkinByType(String folder) {

        ArrayList<String> filelist = new ArrayList<String>();

        try {

            int flag = 0;
            if (folder.indexOf("common") > 0) {
                flag = 0;
                folder = folder.replace("common", "");
            } else {
                flag = 1;
                folder = folder.replace("photoGallery", "");
            }

            File dir = new File(folder);

            File[] files = dir.listFiles();

            for (File val : files) {
                if (val.isDirectory()) {
                    if (flag == 0) {
                        if (val.getName().indexOf("photo") == -1) {
                            filelist.add(val.getName());
                        }
                    } else {
                        if (val.getName().indexOf("photo") == 0) {
                            filelist.add(val.getName());
                        }
                    }
                }
            }

            Collections.sort(filelist);

            return filelist;
        } catch (Exception e) {

            System.out.println(e.toString());

            return filelist;

        }
    }

    public static void downFile(DataTable file) throws UnsupportedEncodingException {

        String              bbsfileorg  = file.get("bbsfileorg");
        String              bbsfilesave = file.get("bbsfilesave");
        String              bbsfiletype = file.get("bbsfiletype");
        String              boardupload = file.get("boardupload");
        HttpServletResponse response    = (HttpServletResponse) file.getObject("res");

        bbsfileorg = java.net.URLEncoder.encode(bbsfileorg, "UTF-8");

        response.reset();
        response.setContentType(bbsfiletype);
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Content-Disposition", "attachment; filename=" + bbsfileorg + ";");

        String fn = boardupload + File.separator + bbsfilesave;

        File f = new File(fn);
        response.setContentLength((int) f.length());

        byte b[] = new byte[5 * 1024 * 1024];
        if (f.isFile()) {
            try {

                BufferedInputStream is = new BufferedInputStream(new FileInputStream(f));

                BufferedOutputStream os   = new BufferedOutputStream(response.getOutputStream());
                int                  read = 0;
                while ((read = is.read(b)) != -1) {
                    os.write(b, 0, read);
                }
                os.flush();
                os.close();
                is.close();

            } catch (Exception e) {}
        }
    }

    public static void downFile(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String userAgent = request.getHeader("User-Agent");

        String bbsfileorg  = (String) request.getAttribute("fileorg");
        String bbsfilesave = (String) request.getAttribute("filesave");
        String bbsfiletype = (String) request.getAttribute("filetype");

//		bbsfileorg = java.net.URLEncoder.encode(bbsfileorg,"UTF-8");

        response.reset();
        response.setContentType(bbsfiletype);
        response.setHeader("Accept-Ranges", "bytes");

        if (userAgent.indexOf("MSIE 5.5") > -1) { // MS IE 5.5 이하
            response.setHeader("Content-Disposition", "filename=\"" + URLEncoder.encode(bbsfileorg, "UTF-8").replaceAll("\\+", "\\ ") + "\";");
        } else if (userAgent.indexOf("MSIE") > -1) { // MS IE (보통은 6.x 이상 가정)
            response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(bbsfileorg, "UTF-8").replaceAll("\\+", "\\ ") + "\";");
        } else if (userAgent.indexOf("Trident") > -1) { // MS IE 11
            response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(bbsfileorg, "UTF-8").replaceAll("\\+", "\\ ") + "\";");
        } else if (userAgent.indexOf("Firefox") > -1) { // Firefox
            response.setHeader("Content-Disposition", "filename=\"" + URLEncoder.encode(bbsfileorg, "UTF-8").replaceAll("\\+", "\\ ") + "\";");
        } else { // 기타
            response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(bbsfileorg.getBytes("euc-kr"), "latin1").replaceAll("\\+", "\\ ") + "\";");
        }


        String fn = bbsfilesave;

        File f = new File(fn);
        response.setContentLength((int) f.length());

        byte b[] = new byte[5 * 1024 * 1024];
        if (f.isFile()) {
            try {

                BufferedInputStream is = new BufferedInputStream(new FileInputStream(f));

                BufferedOutputStream os   = new BufferedOutputStream(response.getOutputStream());
                int                  read = 0;
                while ((read = is.read(b)) != -1) {
                    os.write(b, 0, read);
                }
                os.flush();
                os.close();
                is.close();

            } catch (Exception e) {}
        }
    }


    public static boolean makeJspTemplate(String path, String no, String contents) {
        if (StringUtils.isNotBlank(contents)) {
            contents = "<%@ page contentType=\"text/html;charset=utf-8\"%>\n" + "<%@ include file=\"/WEB-INF/jsp/zcms/include.jsp\" %>\n" + contents;
        }

        try {
            String      fn = no + "." + "jsp";
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path + File.separator + fn), "utf-8"));
            pw.println(contents);
            pw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public static ArrayList<String> subDirList(String source) {
        ArrayList<String> list  = new ArrayList<String>();
        source = new File(source).getAbsolutePath();
        File              dir   = new File(source);
        File[]            files = dir.listFiles();
        try {
        	if (files!=null) {
	            for (File file : files) {
	                if (file.isFile()) {
	                    list.add(file.getName());
	//                    System.out.println("\t 파일 이름 = " + file.getName());
	                }
					else if(file.isDirectory()){
						System.out.println("디렉토리 이름 = " + file.getName());
						subDirList(file.getCanonicalPath().toString());
					}
	            }
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void fileUrl(String addr, String name, String path) {
        InputStream  is = null;
        OutputStream os = null;

        try {
            URL    url;
            byte[] buf;
            int    detach, attach = 0;

            url = new URL(addr);
            os = new BufferedOutputStream(new FileOutputStream(path + System.getProperty("file.separator") + name));

            URLConnection uc = url.openConnection();
            is = uc.getInputStream();
            buf = new byte[1024];
            while ((detach = is.read(buf)) != -1) {
                os.write(buf, 0, detach);
                attach += detach;
            }
            System.out.println("Downloaded Successfully.");
            System.out.println("File name:\"" + name + "\"\nNo of bytes :" + attach);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	//public static final String FILE_SEPARATOR = File.separator;
 
	public static String getRealFilePath(String path) {
		if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
			path = path.replace("/", FILE_SEPARATOR).replace("\\", FILE_SEPARATOR).replace("\\\\","").replaceFirst(FILE_SEPARATOR, "");
		}
		return path;
	}
 
	public static String getHttpURLPath(String path) {
		return path.replace("\\", "/");
	}
}

