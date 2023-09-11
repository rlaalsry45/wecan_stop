package com.z5.zcms.admsys.main.web;

import com.z5.zcms.admsys.main.domain.ZmainHisVo;
import com.z5.zcms.admsys.main.domain.ZmainVo;
import com.z5.zcms.admsys.main.service.ZmainHisService;
import com.z5.zcms.admsys.main.service.ZmainService;
import com.z5.zcms.admsys.validator.MainValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import egovframework.com.cmm.service.EgovProperties;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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
//import com.z5.zcms.admsys.main.service.ZmainUseService;


@Controller
public class ZmainController {

    @Autowired
    private ZmainService zmainService;

/*	@Autowired
	private ZmainUseService zmainUseService;*/

    @Autowired
    private ZmainHisService zmainHisService;

    @Autowired
    private MainValidator mainValidator;

    @RequestMapping(value = {"/admsys/site/main/", "/admsys/site/main/index.html"})
    public String selectZmainList(
            @ModelAttribute("zmainVo") ZmainVo zmainVo
            , Model model, HttpServletRequest req) throws Exception {

        DataTable input = new DataTable(req);

        try {
            int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int pageIndex = input.getInt("pageIndex") - 1;
            String sdate = input.get("sdate");
            String edate = input.get("edate");
            String mainstatus = input.get("mainstatus");
            String keyword = input.get("keyword");
            int m = pageIndex * pageSize;
            int n = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                zmainVo.setCond1("");
            } else {
                zmainVo.setCond1(input.get("cond1"));
            }

            if (keyword.equals("")) {
                zmainVo.setCond2("");
            } else {
                zmainVo.setCond2(input.get("cond2"));
            }

            if (mainstatus.equals("")) {
                zmainVo.setMainstatus("");
            } else {
                zmainVo.setMainstatus(input.get("mainstatus"));
            }

            zmainVo.setSdate(input.get("sdate").replace("-", ""));
            zmainVo.setEdate(input.get("edate").replace("-", ""));
            zmainVo.setKeyword(input.get("keyword"));
            zmainVo.setM(m);
            zmainVo.setN(n);

            int total = this.zmainService.listCount(zmainVo);

            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            //이용하지 않아서 삭제 20141203 김문석
            List<ZmainVo> list = this.zmainService.getList(zmainVo);
            model.addAttribute("list", list);

            model.addAttribute("input", input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/site/main/index";
    }

    //insert GET
    @RequestMapping(value = "/admsys/site/main/insert.html", method = RequestMethod.GET)
    public String insert(HttpSession session, Model model) throws Exception {

        return "/zcms/admsys/site/main/insert";
    }


    //insert POST
    @RequestMapping(value = "/admsys/site/main/insert.html", method = RequestMethod.POST)
    public String insertSubmit(@ModelAttribute("zmainVo") ZmainVo zmainVo, BindingResult err, HttpServletRequest req, HttpSession session) throws Exception {
        this.mainValidator.validate(zmainVo, err);

        DataTable input = new DataTable(req);
        try {
            String HTML = input.get("maincontstype").equals("1") ? input.get("mainconts") : input.get("ckeditorConts");
            System.out.println(HTML);
            Document doc = Jsoup.parseBodyFragment(HTML);
            Elements ztags = doc.select("call");

            zmainVo.setMainconts(HTML);
            zmainVo.setMaintags(ztags.toString());
            zmainVo.setMaincontstype(input.get("maincontstype"));

            int mainno = 0;
            mainno = zmainService.getMaxMainno(mainno);
            zmainVo.setMainno(mainno);

            this.zmainService.insert(zmainVo);

            if (mainno > 0) {
                //template jsp 생성
                ZmainVo vo = this.zmainService.selectbypk(zmainVo);//tpltile과 tplposition으로 방금 입력한 tpl의 no를 가지고 온다.

                if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.main"), Integer.toString(vo.getMaxno()), zmainVo.getMainconts()
                )) {
                    System.out.println("tpl template making successed");
                } else {
                    System.out.println("tpl template making error");
                }
            } else {
                System.out.println("tpl template making failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/site/main/index.html";
    }

    //Delete
    @RequestMapping("/admsys/site/main/delete.html")
    public String delete(
            @RequestParam("mainno") int[] mainno,
            @ModelAttribute("zmainVo") ZmainVo zmainVo, BindingResult err, HttpServletRequest req)
            throws Exception {

        List<Integer> arrDeleteNo = new ArrayList<Integer>(mainno.length);
        for (int i = 0; i < mainno.length; i++) {
            arrDeleteNo.add(mainno[i]);
        }

        zmainService.delete(arrDeleteNo);
//        zmainUseService.delete(arrDeleteNo);

        return "redirect:/admsys/site/main/index.html";
    }

    //Update GET
    @RequestMapping(value = "/admsys/site/main/update.html", method = RequestMethod.GET)
    public String updateView(
            @ModelAttribute("zmainVo") ZmainVo zmainVo, HttpServletRequest req, Model model)
            throws Exception {

        DataTable dreq = new DataTable(req);
        int mainno = dreq.getInt("mainno");
        int mainhisno = dreq.getInt("mainhisno");
        String mode = dreq.get("mode");

        try {

            if (mode.equals("restore")) {
                ZmainHisVo zmainHisVo = new ZmainHisVo();
                zmainHisVo.setMainhisno(mainhisno);
                ZmainVo detail = zmainHisService.selectbypk(zmainHisVo); //mainhisVo를 mainVo로 변환시켜서 가지고 옮
                model.addAttribute("detail", detail);
            } else if (mode.equals("delete")) {
                //mainHis 삭제
                ZmainHisVo zmainHisVo = new ZmainHisVo();
                zmainHisVo.setMainhisno(mainhisno);
                zmainHisService.delete(zmainHisVo);

                //mainno에 해당하는 정보를 가지고 와서 다시 뿌려줌
                zmainVo.setMainno(mainno);
                ZmainVo detail = this.zmainService.selectbypk(zmainVo);
                model.addAttribute("detail", detail);
            } else {

                zmainVo.setMainno(mainno);
                ZmainVo detail = this.zmainService.selectbypk(zmainVo);
                model.addAttribute("detail", detail);

            }

            List<ZmainVo> list = zmainService.getListAll(zmainVo);
            model.addAttribute("list", list);
            model.addAttribute("mainno", mainno);

            ZmainHisVo zmainHisVo = new ZmainHisVo();
            zmainHisVo.setMainno(mainno);
            List<ZmainHisVo> hislist = this.zmainHisService.getList(zmainHisVo);
            model.addAttribute("hislist", hislist);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/site/main/update";
    }

    //Update Post
    @Transactional
    @RequestMapping(value = "/admsys/site/main/update.html", method = RequestMethod.POST)
    public String updateSubmit(@ModelAttribute("zmainVo") ZmainVo zmainVo, BindingResult err, HttpServletRequest req, HttpSession session) throws Exception {

        try {
            DataTable input = new DataTable(req);
            String HTML = input.get("maincontstype").equals("1") ? input.get("mainconts") : input.get("ckeditorConts");
            Document doc = Jsoup.parseBodyFragment(HTML);
            Elements ztags = doc.select("call");

            if (input.get("mainhis").equals("1")) {

                ZmainHisVo zmainHisVo = new ZmainHisVo();
                zmainHisVo.setUserid(input.get("userid"));
                zmainHisVo.setMainno(input.getInt("mainno"));
                zmainHisService.insert(zmainHisVo);
            }

            //zmain update
            zmainVo.setMainconts(HTML);
            zmainVo.setMaincontstype(input.get("maincontstype"));
            zmainVo.setUserid(input.get("userid"));
            zmainVo.setMaintags(ztags.toString());
            zmainVo.setMainno(input.getInt("mainno"));

            zmainService.update(zmainVo);

            //template jsp 생성
            if (FileUtil.makeJspTemplate(EgovProperties.getPathProperty("Globals.template.main"), Integer.toString(zmainVo.getMainno()), zmainVo.getMainconts()
            )) {
                System.out.println("tpl template update successed");
            } else {
                System.out.println("tpl template update failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/admsys/site/main/index.html";
    }
}
