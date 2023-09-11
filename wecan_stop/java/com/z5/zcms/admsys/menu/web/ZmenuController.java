package com.z5.zcms.admsys.menu.web;


import com.z5.zcms.admsys.menu.domain.ZmenuHisVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.menu.service.ZmenuHisService;
import com.z5.zcms.admsys.menu.service.ZmenuService;
import com.z5.zcms.admsys.site.domain.ZsiteVo;
import com.z5.zcms.admsys.site.service.ZsiteService;
import com.z5.zcms.admsys.validator.MenuValidator;
import com.z5.zcms.util.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ZmenuController {

    @Autowired
    private ZmenuService zmenuService;

    @Autowired
    private ZmenuHisService zmenuHisService;

    @Autowired
    private MenuValidator menuValidator;

    @Autowired
    private ZsiteService siteService;

    //zmenu index --> zsite의 service를 사용한다.
    @RequestMapping(value = "/admsys/site/menu/index.html")
    public String selectZmenuList(
            @ModelAttribute("zsiteVo") ZsiteVo zsiteVo
            , Model model, HttpServletRequest req) throws Exception {

        DataTable input = new DataTable(req);

        model = zmenuService.index(zsiteVo, input, model);

        return "/zcms/admsys/site/menu/index";
    } 


    //index2
    @RequestMapping(value = "/admsys/site/menu/list.html")
    public String selectZmenuList2(
            @ModelAttribute("zmenuVo") ZmenuVo zmenuVo
            , Model model, HttpServletRequest req) throws Exception {

        DataTable input = new DataTable(req);

        try {
            if (input.get("mode").equals("order")) {
                zmenuService.orderChange(input, zmenuVo);
            } else {
                zmenuService.listView(input, model);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return input.get("mode").equals("order") ? "redirect:/admsys/site/menu/list.html?siteno=" + req.getParameter("siteno") + "&menuno=" + req.getParameter("menuno") + "&opens=" + req.getParameter("opens") : "/zcms/admsys/site/menu/list";
    }


    //insert GET

    @RequestMapping(value = "/admsys/site/menu/insert.html")
    public String insert(HttpSession session, Model model, HttpServletRequest req) throws Exception {

        try {
            DataTable input = new DataTable(req);
            model.addAttribute("input", input);

            if (input.get("act").equals("insert")) {
                model = zmenuService.insert(input, model, req);
                model.addAttribute("siteno", input.getInt("siteno"));
                model.addAttribute("insertsuccess", "true");
                model.addAttribute("selectId", input.get("selectId"));
                return "redirect:/admsys/site/menu/update.html";
            }

            model = zmenuService.insertView(input, model);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/site/menu/insert";
    }//insert


    //Delete
    @RequestMapping(value = "/admsys/site/menu/delete.html", method = RequestMethod.POST)
    public String delete(
            @ModelAttribute("zmenuVo") ZmenuVo zmenuVo, BindingResult err, HttpServletRequest req, Model model)
            throws Exception {

        int siteno = Integer.parseInt(req.getParameter("siteno"));
        String[] deleteMenuno = req.getParameterValues("menuno");
        try {
            if (deleteMenuno.length != 0) {
                zmenuService.delete(siteno, deleteMenuno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("siteno", siteno);
        return "redirect:/admsys/site/menu/list.html";

    }//delete


    //Delete
    @RequestMapping(value = "/admsys/site/menu/deleteHis.html", method = RequestMethod.POST)
    public String deleteHis(
            @ModelAttribute("zmenuHisVo") ZmenuHisVo zmenuHisVo, BindingResult err, HttpServletRequest req, Model model)
            throws Exception {

        String[] menuhisno = req.getParameterValues("menuhisno");
        try {
            if (menuhisno.length != 0) {

                List<String> arrDeleteNo = new ArrayList<String>(menuhisno.length);
                for (int i = 0; i < menuhisno.length; i++) {
                    arrDeleteNo.add(menuhisno[i]);
                }

                zmenuHisService.deleteAll(arrDeleteNo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("deletesuccess", "true");
        model.addAttribute("menuno", req.getParameter("menuno"));
        model.addAttribute("siteno", req.getParameter("siteno"));
        model.addAttribute("selectId", req.getParameter("selectId"));
        model.addAttribute("opens", req.getParameter("opens"));
        return "redirect:/admsys/site/menu/update.html";

    }//delete


    //Update GET
    @RequestMapping(value = "/admsys/site/menu/update.html")
    public String updateView(HttpServletRequest req, Model model) throws Exception {

        DataTable input = new DataTable(req);

        try {
            //menu update
            if (input.get("act").equals("update")) {
                model = zmenuService.update(input, model, req);
                model.addAttribute("siteno", input.getInt("siteno"));
                model.addAttribute("menuno", input.getInt("menuno"));
                model.addAttribute("updatesuccess", "true");
                model.addAttribute("selectId", input.get("selectId"));
                model.addAttribute("opens", input.get("opens"));
                model.addAttribute("input", input);
                return "redirect:/admsys/site/menu/update.html";
            }

            //history delete
            if (input.get("mode").equals("delete")) {
                ZmenuHisVo zmenuHisVoDel = new ZmenuHisVo();
                zmenuHisVoDel.setMenuhisno(input.getInt("menuhisno"));
                zmenuHisService.delete(zmenuHisVoDel);
            }

            //update view
            model = zmenuService.updateView(input, model);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/site/menu/update";
    }//update


    //미리보기 2016.05.02 문영걸
    @RequestMapping("/admsys/site/menu/menuPreview.html")
    public String menuPreview(HttpServletRequest req, Model model, HttpServletResponse response)
            throws Exception {

        DataTable input = new DataTable(req);
        String result = null;
        try {
            result = zmenuService.preview(input, model, req, response);
            model.addAttribute("siteno", input.getInt("siteno"));
            model.addAttribute("menuno", input.getInt("menuno"));
            model.addAttribute("updatesuccess", "true");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/admsys/site/menu/popup.html")
    public String menuPopup(HttpServletRequest request, Model model) {

        List<ZsiteVo> sitelist = null;
        String siteno = null;
        try {

            sitelist = siteService.getListAll();
            siteno = request.getParameter("siteno");

            if (siteno == null) {
                siteno = Integer.toString(sitelist.get(0).getSiteno());
            }

            this.zmenuService.menuPopup(Integer.valueOf(siteno).intValue(), model);


        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("siteno", siteno);
        model.addAttribute("sitelist", sitelist);
        model.addAttribute("ftn", request.getParameter("ftn"));
        return "/zcms/admsys/site/menu/menu_popup";
    }

    @RequestMapping("/admsys/site/menu/title_path.html")
    public
    @ResponseBody
    Map<String, String> getTitlePath(HttpServletRequest request, Model model) {

        Map<String, String> map = new HashMap<String, String>();
        String path = null;
        try {
            path = this.zmenuService.getTitlePath(Integer.valueOf(request.getParameter("menuno")).intValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("result", path);
        return map;
    }

}//class
