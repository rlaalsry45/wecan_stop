package com.z5.zcms.admsys.css.web;

import com.z5.zcms.admsys.css.domain.ZcssHisVo;
import com.z5.zcms.admsys.css.domain.ZcssVo;
import com.z5.zcms.admsys.css.service.ZcssHisService;
import com.z5.zcms.admsys.css.service.ZcssService;
import com.z5.zcms.admsys.css.service.ZcssUseService;
import com.z5.zcms.admsys.validator.CssValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import egovframework.com.cmm.service.EgovProperties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admsys/site/css/")
public class ZcssController {

    private final Logger log = Logger.getLogger(this.getClass());
    private final String RETURN_URL = "/zcms/admsys/site/css/";
    @Autowired
    private ZcssService zcssService;
    @Autowired
    private ZcssUseService zcssUseService;
    @Autowired
    private ZcssHisService zcssHisService;
    @Autowired
    private CssValidator cssValidator;

    @RequestMapping(value = {"", "index.html"})
    public String selectZcssList(
        @ModelAttribute("zcssVo") ZcssVo zcssVo, Model model, HttpServletRequest req) throws Exception {

        try {
            DataTable input = new DataTable(req);

            int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex = input.getInt("pageIndex") - 1;
            String sdate     = input.get("sdate");
            String edate     = input.get("edate");
            String keyword   = input.get("keyword");
            int    m         = pageIndex * pageSize;
            int    n         = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zcssVo.setCond1("");
            } else {
                zcssVo.setCond1(input.get("cond1"));
            }
            if (keyword.equals("")) {
                zcssVo.setCond2("");
            } else {
                zcssVo.setCond2(input.get("cond2"));
            }

            zcssVo.setSdate(input.get("sdate"));
            zcssVo.setEdate(input.get("edate"));
            zcssVo.setKeyword(input.get("keyword"));
            zcssVo.setM(m);
            zcssVo.setN(n);

            int total = this.zcssService.listCount(zcssVo);
            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<ZcssVo> list = this.zcssService.getList(zcssVo);

            model.addAttribute("list", list);
            model.addAttribute("input", input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return RETURN_URL + "index";
    }


    //insert GET
    @RequestMapping(value = "insert.html", method = RequestMethod.GET)
    public String insert(HttpSession session, Model model) throws Exception {
        try {
            ZcssVo       zcssVo = new ZcssVo();
            List<ZcssVo> list   = zcssService.getListAll(zcssVo);
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RETURN_URL + "insert";
    }


    //insert POST
    @RequestMapping(value = "insert.html", method = RequestMethod.POST)
    public String insertSubmit(@ModelAttribute("zcssVo") ZcssVo zcssVo, BindingResult err, HttpServletRequest req, HttpSession session) throws Exception {

        this.cssValidator.validate(zcssVo, err);

        DataTable input = new DataTable(req);
        try {
            String cssupload = EgovProperties.getPathProperty("Globals.common.css");
            //System.out.println(cssupload);
            //System.out.println("input.get(cssconts)"+input.get("cssconts"));
            //System.out.println("zcssVo.getCssconts()"+zcssVo.getCssconts());
            String cssfilesave = FileUtil.writeFile(cssupload, "css", input.get("cssconts"));

            if (!cssfilesave.equals("")) {
                input.put("cssfilesave", cssfilesave);
                zcssVo.setCssfilesave(cssfilesave);
                this.zcssService.insert(zcssVo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "redirect:/admsys/site/css/index.html";

    }

    //Delete
    @Transactional
    @RequestMapping("delete.html")
    public String delete(
        @RequestParam("cssno") int[] cssno,
        @ModelAttribute("zcssVo") ZcssVo zcssVo, BindingResult err, HttpServletRequest req)
        throws Exception {

        List<Integer> arrDeleteNo = new ArrayList<Integer>(cssno.length);
        for (int i = 0; i < cssno.length; i++) {
            arrDeleteNo.add(cssno[i]);
        }

        zcssService.delete(arrDeleteNo);
        zcssUseService.delete(arrDeleteNo);

        return "redirect:/admsys/site/css/index.html";
    }

    //Update GET
    @RequestMapping(value = "update.html", method = RequestMethod.GET)
    public String updateView(
        @ModelAttribute("zcssVo") ZcssVo zcssVo, HttpServletRequest req, Model model)
        throws Exception {

        DataTable dreq     = new DataTable(req);
        int       cssno    = dreq.getInt("cssno");
        int       csshisno = dreq.getInt("csshisno");
        String    mode     = dreq.get("mode");

        try {

            if (mode.equals("restore")) {
                //System.out.println("restore 들어옴");
                //System.out.println("csshisno"+csshisno);
                ZcssHisVo zcssHisVo = new ZcssHisVo();
                zcssHisVo.setCsshisno(csshisno);
                ZcssVo detail = zcssHisService.selectbypk(zcssHisVo); //csshisVo를 cssVo로 변환시켜서 가지고 옮
                model.addAttribute("detail", detail);
            } else if (mode.equals("delete")) {
                //cssHis 삭제
                //System.out.println("delete 들어옴");
                ZcssHisVo zcssHisVo = new ZcssHisVo();
                zcssHisVo.setCsshisno(csshisno);
                zcssHisService.delete(zcssHisVo);

                //cssno에 해당하는 정보를 가지고 와서 다시 뿌려줌
                zcssVo.setCssno(cssno);
                ZcssVo detail = this.zcssService.selectbypk(zcssVo);
                model.addAttribute("detail", detail);
            } else {

                zcssVo.setCssno(cssno);
                ZcssVo detail = this.zcssService.selectbypk(zcssVo);
                model.addAttribute("detail", detail);

            }

            //List<ZcssVo> list = zcssService.getListAll(zcssVo);
            List<ZcssVo> list = zcssService.getListAllForUpdate(zcssVo);
            model.addAttribute("list", list);
            model.addAttribute("cssno", cssno);

            ZcssHisVo zcssHisVo = new ZcssHisVo();
            zcssHisVo.setCssno(cssno);
            List<ZcssHisVo> hislist = this.zcssHisService.getList(zcssHisVo);
            model.addAttribute("hislist", hislist);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RETURN_URL + "update";
    }

    //Update Post
    @Transactional
    @RequestMapping(value = "update.html", method = RequestMethod.POST)
    public String updateSubmit(@ModelAttribute("zcssVo") ZcssVo zcssVo, BindingResult err, HttpServletRequest req, HttpSession session, Model model) throws Exception {

        try {
            DataTable input = new DataTable(req);
            boolean   yn    = false;

            String cssupload = EgovProperties.getPathProperty("Globals.common.css");
            if (input.get("cssfilesave").equals("")) {

                String cssfilesave = FileUtil.writeFile(cssupload, "css", input.get("cssconts"));
                input.put("cssfilesave", cssfilesave);
            } else {
                yn = FileUtil.editFile(cssupload, input.get("cssfilesave"), input.get("cssconts"));
            }

            if (!input.get("cssfilesave").equals("") || yn) {

                //history 저장
                //System.out.println("input.get(userid) : "+input.get("userid"));
                //System.out.println("input.get(cssno) : "+input.get("cssno"));
                if (input.get("csshis").equals("1")) {
                    ZcssHisVo zcssHisVo = new ZcssHisVo();
                    zcssHisVo.setUserid(input.get("userid"));
                    zcssHisVo.setCssno(input.getInt("cssno"));
                    zcssHisService.insert(zcssHisVo);
                }

                //zcss update
                zcssVo.setCsstitle(input.get("csstitle"));
                zcssVo.setCsstype(input.get("csstype"));
                zcssVo.setCssfileorg(input.get("cssfileorg"));
                zcssVo.setCssfilesave(input.get("cssfilesave"));
                zcssVo.setCssconts(input.get("cssconts"));
                zcssVo.setCssmemo(input.get("cssmemo"));
                zcssVo.setCsshis(input.get("csshis"));
                zcssVo.setUserid(input.get("userid"));
                zcssVo.setCssno(input.getInt("cssno"));

                zcssService.update(zcssVo);

                model.addAttribute("cssno", zcssVo.getCssno());
                model.addAttribute("updatesuccess", "true");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/admsys/site/css/update.html";
    }
}
