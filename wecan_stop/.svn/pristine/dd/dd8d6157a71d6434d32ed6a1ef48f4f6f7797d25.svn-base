package com.z5.zcms.admsys.board.web;

import com.z5.zcms.admsys.board.dao.ZBoardDAO;
import com.z5.zcms.admsys.board.domain.ZBoardAuthVo;
import com.z5.zcms.admsys.board.domain.ZBoardVo;
import com.z5.zcms.admsys.board.service.FrontBoardService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
@RequestMapping(value="/admsys/board/posts")
public class BoardPostsController {

    @Autowired
    FrontBoardService frontBoardService;

    @Autowired
    ZBoardDAO zBoardDAO;

    @RequestMapping(value="index.html")
    public void index(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");

            DataTable req = new DataTable(request);

            String skin = "";
            String act = "";
            if (!req.get("ztag").isEmpty()){
                Document doc = Jsoup.parseBodyFragment(StringUtil.getObjectFromBase64(req.get("ztag")));
                Elements ztags = doc.select("call");
                req.put("boardno", ztags.get(0).attr("no"));
                req.put("skin", ztags.get(0).attr("skin"));
            }

            skin = req.get("skin");
            act = req.get("act","list");

            String page = act;
            if (act.equals("edit")||act.equals("reply")) page = "write";

            ZBoardAuthVo zBoardAuthVo = new ZBoardAuthVo();
            zBoardAuthVo.setRole_l("99");
            zBoardAuthVo.setRole_v("99");
            zBoardAuthVo.setRole_w("99");
            zBoardAuthVo.setRole_m("99");
            zBoardAuthVo.setRole_d("99");
            zBoardAuthVo.setRole_m_nm("99");
            zBoardAuthVo.setRole_r("99");
            zBoardAuthVo.setRole_c("99");
            zBoardAuthVo.setRole_n("99");
            session.setAttribute("frontAuthPassport",zBoardAuthVo);
            session.setAttribute("mode","99");
            session.setAttribute("mode2","1");

            ZBoardVo zBoardVo = new ZBoardVo();
            zBoardVo.setBoardno(req.getInt("boardno"));
            zBoardVo.setSkin(skin);
            zBoardVo = frontBoardService.config(zBoardVo);
            int siteno = zBoardDAO.boardUseSite(zBoardVo.getBoardno());

            StringBuffer stringBuffer = new StringBuffer();

            PrintWriter out = response.getWriter();
            stringBuffer.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
            stringBuffer.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"ko\" lang=\"ko\">\n");
            stringBuffer.append("<head>\n");
            stringBuffer.append("<title>게시글관리</title>\n");
            stringBuffer.append("<meta http-equiv=\"Content-Script-Type\" content=\"text/javascript\" />\n");
            stringBuffer.append("<meta http-equiv=\"Content-Style-Type\" content=\"text/css\" />\n");
            stringBuffer.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
            stringBuffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");

            stringBuffer.append("<link rel=\"stylesheet\" href=\"/cms/gen/css/20181030_509462539539593.css\" type=\"text/css\" />\n");
            stringBuffer.append("<link rel=\"stylesheet\" href=\"/cms/gen/css/20181030_509403664601784.css\" type=\"text/css\" />\n");
            stringBuffer.append("<link rel=\"stylesheet\" href=\"/cms/gen/css/20180420_783945179257592.css\" type=\"text/css\" />\n");
            
            stringBuffer.append("<link rel=\"stylesheet\" href=\"/usr/skin/board/"+skin+"/css/board.css\" type=\"text/css\" />\n");
            stringBuffer.append("<script type=\"text/javascript\" src=\"/com/js/jquery-1.12.3.min.js\"></script>\n");
            stringBuffer.append("<script type=\"text/javascript\" src=\"/com/js/jquery.form.js\"></script>\n");
            stringBuffer.append("<script type=\"text/javascript\" src=\"/cms/gen/js/20181113_77387721743325.js\"></script>\n");
            if (!(act.equals("view")||act.equals("list"))){
                if (zBoardVo.getEditoryn().equals("1")){
                    stringBuffer.append("<link rel=\"stylesheet\" href=\"/var/editor/css/editor.css\" type=\"text/css\" charset=\"utf-8\"/>\n");
                    stringBuffer.append("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/var/editor/js/editor_loader.js\"></script>\n");
                    stringBuffer.append("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/var/ckeditor/ckeditor.js\"></script>\n");
                }
            }
            stringBuffer.append("<script type=\"text/javascript\" src=\"/usr/skin/board/"+skin+"/js/"+page+".js\" defer></script>\n");
            stringBuffer.append("<script type=\"text/javascript\" src=\"/cms/js/My97DatePicker/WdatePicker.js\" defer></script>\n");

            stringBuffer.append("</head>\n");
            stringBuffer.append("<body>\n");
            out.println(stringBuffer.toString());

            request.setAttribute("siteno", siteno);
            request.setAttribute("menuno", -9999);
            request.setAttribute("no", req.get("boardno"));
            request.setAttribute("skin", skin);
            request.setAttribute("act", act);
            request.setAttribute("bbshit", req.getInt("bbshit", 1));
            request.setAttribute("subname","admsys/board/posts");
            request.setAttribute("cateflag", req.get("cateflag"));

            session.getServletContext().getRequestDispatcher("/skin/board/"+skin+"/"+page+".html").include(request, response);
            stringBuffer.setLength(0);
            stringBuffer.append("\n</body>\n");
            stringBuffer.append("</html>\n");
            out.println(stringBuffer.toString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
