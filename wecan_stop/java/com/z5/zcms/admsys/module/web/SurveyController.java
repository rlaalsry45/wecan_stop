package com.z5.zcms.admsys.module.web;

import com.z5.zcms.admsys.module.domain.ZSurveyHisVo;
import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;
import com.z5.zcms.admsys.module.service.SurveyService;
import com.z5.zcms.admsys.validator.SurveyValidator;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.FileUtil;
import egovframework.com.cmm.service.EgovProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

@Controller
public class SurveyController {

    @Autowired
    private SurveyService   surveyService;
    @Autowired
    private SurveyValidator surveyValidator;

    @RequestMapping(value = "/admsys/module/survey/index.html")
    public String list(
        @ModelAttribute("zSurveyVo") ZSurveyVo zSurveyVo
        , Model model, HttpServletRequest req) throws Exception {

        DataTable input    = new DataTable(req);
        int       pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
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
            zSurveyVo.setCond1("");
        } else {
            zSurveyVo.setCond1(input.get("cond1"));
        }
        if (keyword.equals("")) {
            zSurveyVo.setCond2("");
        } else {
            zSurveyVo.setCond2(input.get("cond2"));
        }

        zSurveyVo.setSdate(input.get("sdate").replaceAll("-", ""));
        zSurveyVo.setEdate(input.get("edate").replaceAll("-", ""));
        zSurveyVo.setKeyword(input.get("keyword"));
        zSurveyVo.setM(m);
        zSurveyVo.setN(n);

        int total = this.surveyService.listCount(zSurveyVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<ZSurveyVo> list = this.surveyService.getSurveyList(zSurveyVo);

        model.addAttribute("list", list);
        model.addAttribute("input", input);

        return "/zcms/admsys/module/survey/index";
    }

    @RequestMapping(value = "/admsys/module/survey/insert.html", method = RequestMethod.GET)
    public String insert(Model model) {
        String            cmsSurvey = EgovProperties.getPathProperty("Globals.skin.survey");
        ArrayList<String> skinList  = FileUtil.getSkin(cmsSurvey);
        model.addAttribute("skinlist", skinList);
        return "/zcms/admsys/module/survey/insert";
    }

    @RequestMapping(value = "/admsys/module/survey/insert.html", method = RequestMethod.POST)
    public String insertSubmit(HttpServletRequest req, @ModelAttribute("zSurveyVo") ZSurveyVo zSurveyVo, BindingResult err) {

        this.surveyValidator.validate(zSurveyVo, err);

        int            len = Integer.parseInt(req.getParameter("question"));
        Vector<String> vet = new Vector<String>();

        for (int i = 1; i <= len; i++) {
            if (req.getParameter("opttype" + i) != null) {
                if (req.getParameter("opttype" + i).equals("3") || req.getParameter("opttype" + i).equals("4")) {
                    vet.add(req.getParameter("opttype" + i) + "Œ" + req.getParameter("ask" + i));
                } else {
                    String[] tmp = req.getParameterValues("opt" + i);
                    for (int k = 0; k < tmp.length; k++) {
                        if (tmp[k].trim().equals("")) tmp[k] = "null";
                    }
                    vet.add(req.getParameter("opttype" + i) + "Œ" + req.getParameter("ask" + i) + "Œ" + StringUtils.join(tmp, "Œ"));
                }
            }
        }

        String add = StringUtils.join(vet.toArray(), "Æ");
        zSurveyVo.setAdded(add);

        String surveyId = surveyService.getSurveyIdSeq();
        zSurveyVo.setSurveyid(surveyId);
        this.surveyService.surveyWrite(zSurveyVo);
        return "redirect:/admsys/module/survey/index.html";
    }

    @RequestMapping(value = "/admsys/module/survey/update.html", method = RequestMethod.GET)
    public String update(
        @ModelAttribute("zSurveyVo") ZSurveyVo zSurveyVo,
        @ModelAttribute("zSurveyHisVo") ZSurveyHisVo zSurveyHisVo,
        @RequestParam(value = "mode", required = false) String mode,
        HttpServletRequest req,
        Model model) {

        String            cmsSurvey = EgovProperties.getPathProperty("Globals.skin.survey");
        ArrayList<String> skinList  = FileUtil.getSkin(cmsSurvey);
        model.addAttribute("skinlist", skinList);

        if ("restore".equals(mode)) {
            model.addAttribute("detail", (ZSurveyHisVo) this.surveyService.surveyDetail(zSurveyHisVo));
        } else {
            if ("delete".equals(mode)) {
                this.surveyService.surveyHisDelete(zSurveyHisVo);
            }
            model.addAttribute("detail", (ZSurveyVo) this.surveyService.surveyDetail(zSurveyVo));
        }

        List<ZSurveyHisVo> hislist = this.surveyService.getSurveyHisList(zSurveyVo);
        model.addAttribute("hislist", hislist);

        return "/zcms/admsys/module/survey/update";
    }

    @RequestMapping(value = "/admsys/module/survey/update.html", method = RequestMethod.POST)
    public String updateSubmit(HttpServletRequest req, @ModelAttribute("zSurveyVo") ZSurveyVo zSurveyVo, BindingResult err, HttpSession session) {
        try {
            String userid = (String) session.getAttribute("userid");
            if (userid == null || userid.equals("")) {
                userid = "byterus";
            }
            zSurveyVo.setUserid(userid);

            int            len   = Integer.parseInt(req.getParameter("question"));
            String         added = "";
            Vector<String> vet   = new Vector<String>();

            for (int i = 1; i <= len; i++) {
                if (req.getParameter("opttype" + i).equals("3") || req.getParameter("opttype" + i).equals("4")) {
                    vet.add(req.getParameter("opttype" + i) + "Œ" + req.getParameter("ask" + i));
                } else {
                    String[] tmp = req.getParameterValues("opt" + i);
                    for (int k = 0; k < tmp.length; k++) {
                        if (tmp[k].trim().equals("")) tmp[k] = "null";
                    }
                    vet.add(req.getParameter("opttype" + i) + "Œ" + req.getParameter("ask" + i) + "Œ" + StringUtils.join(tmp, "Œ"));
                }
            }

            added = StringUtils.join(vet.toArray(), "Æ");

            zSurveyVo.setAdded(added);

            this.surveyService.surveyEdit(zSurveyVo);


            //결과 업데이트

            String result_count     = req.getParameter("result_count");
            String new_result_count = req.getParameter("new_result_count");

            ZSurveyResultVo zSurveyResultVo = new ZSurveyResultVo();

            if (Integer.parseInt(result_count) > Integer.parseInt(new_result_count)) {

                for (int i = 1; i <= Integer.parseInt(result_count); i++) {

                    String result_no = req.getParameter("new_result_no_" + i);

                    if (result_no != null) { //문항이 늘어났을경우 결과에 대한 값을 업데이트 시켜줘야 한다.
                        if (i != Integer.parseInt(result_no)) { //문항 순서가 틀릴경우에만 업데이트 시켜준다.
                            zSurveyResultVo.setSurveyno(zSurveyVo.getSurveyno());
                            zSurveyResultVo.setAskno(i);
                            zSurveyResultVo.setChange_askno(result_no);
                            this.surveyService.surveyResultUpdate(zSurveyResultVo);
                        }
                    } else {  //만약 기존 문항이 사라졌을경우 결과도 삭제시켜준다.
                        zSurveyResultVo.setSurveyno(zSurveyVo.getSurveyno());
                        zSurveyResultVo.setAskno(i);
                        this.surveyService.surveyResultChangeDelete(zSurveyResultVo);
                    }
                }

            } else {

                for (int i = Integer.parseInt(result_count); i > 0; i--) {

                    String result_no = req.getParameter("new_result_no_" + i);

                    if (result_no != null) { //문항이 늘어났을경우 결과에 대한 값을 업데이트 시켜줘야 한다.
                        if (i != Integer.parseInt(result_no)) { //문항 순서가 틀릴경우에만 업데이트 시켜준다.
                            zSurveyResultVo.setSurveyno(zSurveyVo.getSurveyno());
                            zSurveyResultVo.setAskno(i);
                            zSurveyResultVo.setChange_askno(result_no);
                            this.surveyService.surveyResultUpdate(zSurveyResultVo);
                        }
                    } else {  //만약 기존 문항이 사라졌을경우 결과도 삭제시켜준다.
                        zSurveyResultVo.setSurveyno(zSurveyVo.getSurveyno());
                        zSurveyResultVo.setAskno(i);
                        this.surveyService.surveyResultChangeDelete(zSurveyResultVo);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/module/survey/index.html";
    }

    @RequestMapping(value = "/admsys/module/survey/result.html", method = RequestMethod.GET)
    public String result(@ModelAttribute("zSurveyResultVo") ZSurveyResultVo zSurveyResultVo, @ModelAttribute("zSurveyVo") ZSurveyVo zSurveyVo, BindingResult err, Model model) {
        try {
            zSurveyVo = (ZSurveyVo) this.surveyService.surveyDetail(zSurveyVo);

            String               s1 = zSurveyVo.getSdate();
            String               s2 = zSurveyVo.getEdate();
            java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Calendar   c  = java.util.Calendar.getInstance();
            try {
                java.util.Date dt1 = df.parse(s1);
                java.util.Date dt2 = df.parse(s2);
                if (c.getTime().getTime() < dt1.getTime()) {
                    zSurveyVo.setUseyn("진행전");
                } else if (c.getTime().getTime() > dt2.getTime()) {
                    zSurveyVo.setUseyn("완료");
                } else {
                    zSurveyVo.setUseyn("진행중");
                }
            } catch (java.text.ParseException e) {
                System.err.println("날자 형식이 정확하지 않습니다.");
            }

            String str    = zSurveyVo.getAdded();
            int    askcnt = 0;
            if (!str.equals("")) {
                askcnt = str.split("Æ").length;
            }

            String[] ask_cnt = new String[askcnt];
            for (int i = 1; i <= askcnt; i++) {
                String answer    = str.split("Æ")[i - 1];
                int    answercnt = answer.split("Œ").length - 2;
                if (answercnt == 0) answercnt = 1;
                String[] cnt = new String[answercnt];

                zSurveyResultVo.setSurveyno(zSurveyVo.getSurveyno());
                zSurveyResultVo.setAskno(i);
                zSurveyResultVo.setAnswer("");

                if (answer.split("Œ")[0].equals("3")) {
                    cnt[0] = String.valueOf(this.surveyService.listCount(zSurveyResultVo));
                } else {
                    for (int j = 1; j <= answercnt; j++) {
                        zSurveyResultVo.setAnswer("" + j);
                        cnt[j - 1] = String.valueOf(this.surveyService.listCount(zSurveyResultVo));
                    }
                }

                ask_cnt[i - 1] = StringUtils.join(cnt, "Œ");
            }

            zSurveyVo.setQacnt(StringUtils.join(ask_cnt, "Æ"));
            model.addAttribute("result", zSurveyVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/module/survey/result";
    }

    @RequestMapping(value = "/admsys/module/survey/delete.html")
    public String delete(@RequestParam("surveyno") Integer[] surveyno) {
        List<Integer> arrDeleteNo = Arrays.asList(surveyno);

        this.surveyService.surveyDelete(arrDeleteNo);

        return "redirect:/admsys/module/survey/index.html";
    }

}
