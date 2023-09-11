package com.z5.zcms.admsys.schdule.web;


import com.z5.zcms.admsys.schdule.domain.ZSchduleVO;
import com.z5.zcms.admsys.schdule.service.ZSchduleServiceImpl;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.ZPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.param;


@RequestMapping("/admsys/module/")
@Controller
public class CalendarAdminController {

    @Autowired
    private ZSchduleServiceImpl zschduleService;

    /**
     * 메인페이지/캘린더관리조회
     *
     * @param model
     * @return "/zcms/admsys/module/calendar/index.html"
     * @throws Exception
     */
    @RequestMapping(value = "calendar/index.html")
    public String calendarlist(Map commandMap, ModelMap model, HttpServletRequest request, ZSchduleVO zSchduleVO) throws Exception {
        ZPrint.enter();
        param(request);
        try {
            DataTable input = new DataTable(request);

            int pageSize  = input.getInt("pageSize", 20);
            int pageIndex = input.getInt("pageIndex") - 1;
            int m         = pageIndex * pageSize;
            int n         = pageSize;

            int total = (Integer) zschduleService.selectCalendarManageListCnt(zSchduleVO);

            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List calendarList = zschduleService.selectCalendarManageList(zSchduleVO);
            model.addAttribute("calendarList", calendarList);
            model.addAttribute("input", input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/zcms/admsys/module/calendar/index";
    }

    //Update GET
    @RequestMapping(value = "calendar/modify.html", method = RequestMethod.GET)
    public String updateView(
        @ModelAttribute("ZSchduleVO") ZSchduleVO zSchduleVO,
        HttpServletRequest req,
        Model model
    ) throws Exception {

        ZPrint.enter();
        param(req);

        try {
            ZSchduleVO data = this.zschduleService.selectCalendarManage(zSchduleVO);
            model.addAttribute("data", data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/module/calendar/update";
    }

    @RequestMapping(value = "calendar/modify.html", method = RequestMethod.POST)
    public String update_confirm(
        @ModelAttribute("ZSchduleVO") ZSchduleVO zSchduleVO,
        HttpServletRequest request,
        Model model
    ) throws Exception {

        ZPrint.enter();
        param(request);

        try {
            this.zschduleService.setCalendarManage(zSchduleVO);//기존의 관리자인가? -> true
            model.addAttribute("modifysuccess", true);
        } catch (Exception e) {
            model.addAttribute("modifyfail", false);
            e.printStackTrace();
        }

        return "redirect:/admsys/module/calendar/index.html";
    }

    // insert GET
    @RequestMapping(value = "calendar/insert.html", method = RequestMethod.GET)
    public String insertView() throws Exception {
        ZPrint.enter();
        return "/zcms/admsys/module/calendar/insert";
    }

    @RequestMapping(value = "calendar/insert.html", method = RequestMethod.POST)
    public String insert_confirm(
        @ModelAttribute("ZSchduleVO") ZSchduleVO zSchduleVO,
        HttpServletRequest request,
        Model model
    ) throws Exception {

        ZPrint.enter();
        param(request);

        try {
            this.zschduleService.insertCalendarManage(zSchduleVO);//기존의 관리자인가? -> true
            model.addAttribute("insertsuccess", true);
        } catch (Exception e) {
            model.addAttribute("insertfail", false);
            e.printStackTrace();
        }

        return "redirect:/admsys/module/calendar/index.html";
    }

    @RequestMapping(value = "calendar/delete.html")
    public String delete_confirm(
        ZSchduleVO zschduleVO,
        Map commandMap,
        ModelMap model,
        HttpServletRequest request
    ) throws Exception {

        ZPrint.enter();
        param(request);

        try {
            zschduleService.deletecalendar(zschduleVO);
            zschduleService.deleteAllSchdul(zschduleVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admsys/module/calendar/index.html";
    }
}

