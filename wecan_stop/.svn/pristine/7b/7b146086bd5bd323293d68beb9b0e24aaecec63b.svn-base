package com.z5.zcms.admsys.adminip.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.adminip.domain.AdminIPVO;
import com.z5.zcms.admsys.adminip.service.AdminIPService;
import com.z5.zcms.admsys.common.domain.ComSetVO;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;

@Controller
public class AdminIPController {

    @Autowired
    private AdminIPService adminIPService;

    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "login.html")
    public String UserIP(
        @ModelAttribute("AdminIPVO") AdminIPVO adminIPVO,
        HttpServletRequest req, HttpServletResponse rep, Model model, HttpSession session
    ) {
    	
        //frontsys에 inportal 이 들어오면 login.html 로 보낸다. 
        if ( StringUtils.contains(hostname(req), "wecan.stop.or.kr") ) {
            return "redirect:/?menuno=246";
        }

        boolean          ok = false;
        ComDefaultCodeVO vo = new ComDefaultCodeVO();

        try {
            vo.setCodeId("ZCM002"); //admin IP 접근 사용여부
            List<CmmnDetailCode> list = cmmUseService.selectCmmCodeDetail(vo);
            if (list.size() > 0) {
                if (list.get(0).getCode().equals("Y")) {
                    ok = true;
                }
            }

            vo.setCodeId("ZCM003"); //프로젝트 이름  
            vo.setCode("Z00302");
            list = cmmUseService.selectCmmCodeDetail(vo);
            if (list.size() > 0) {
            	session.setAttribute("projectName", list.get(0).getCodeNm());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ok) {
            String      address = req.getRemoteAddr();
            try {
                String[] part = address.split("\\.");
                String   addr = part[0] + "." + part[1] + "." + part[2];

                adminIPVO.setUsercutip(addr);
                adminIPVO.setUserfullip(address);

                int cnt = adminIPService.getIPCount(adminIPVO);
                if (cnt > 0) {//카운트 대역대 추가
                    model.addAttribute("adminip", "true");
                }
                else {
                    session.invalidate();
                    model.addAttribute("adminip", "false");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            model.addAttribute("adminip", "true");
        }

        return "/zcms/admsys/site/adminip/login";
    }

    @SuppressWarnings("unused")
    @RequestMapping(value = "/admsys/site/adminip/index.html")
    public String selectadminipList(
        @ModelAttribute("AdminIPVO") AdminIPVO adminIPVO,
        Model model
        , HttpSession session
        , HttpServletRequest req) throws Exception {

        DataTable input = new DataTable(req);  //input에 대이타테이블을넣고

        try {
            int    pageSize   = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
            String adminIpUse = ((ComSetVO) session.getAttribute("ComSetVO")).getAdminIPCheck();//ZsavedAuthenticationSuccessHandler에서 해당 세션을 넣음
            pageSize = 10;
            if (input.getInt("pageIndex") == 0) {
                input.put("pageIndex", 1);
            }
            int    pageIndex  = input.getInt("pageIndex") - 1;
            String sdate      = input.get("sdate"); //달력검색날앞
            String edate      = input.get("edate"); //달력검색날뒤
            String mainstatus = input.get("mainstatus");
            String keyword    = input.get("keyword"); //검색창에 검색글을 담음
            int    sitestatus = input.getInt("sitestatus");
            int    m          = pageIndex * pageSize;
            int    n          = pageSize;

            if (sdate.equals("") && edate.equals("")) {
                adminIPVO.setCond1("");
            }
            else {
                adminIPVO.setCond1(input.get("cond1"));
            }
            if (keyword.equals("")) {
                adminIPVO.setCond2("");
            }
            else {
                adminIPVO.setCond2(input.get("cond2"));
            }
            if (mainstatus.equals("")) {
                adminIPVO.setMainstatus("");
            }
            else {
                adminIPVO.setMainstatus(input.get("mainstatus"));
            }

            adminIPVO.setSdate(input.get("sdate")); // VO에서 sdate를 불러옴
            adminIPVO.setEdate(input.get("edate")); // VO에서 sdate를 불러옴
            adminIPVO.setKeyword(input.get("keyword")); // VO에서 keyword를 불러옴
            adminIPVO.setM(m);
            adminIPVO.setN(n);

            int total = this.adminIPService.IPCount(adminIPVO);

            input.put("pageSize", pageSize);
            input.put("total", total);
            input.put("pageMax", (int) Math.ceil((double) total / pageSize));

            List<AdminIPVO> list = this.adminIPService.getList(adminIPVO);
            model.addAttribute("no", adminIPVO.getNo());
            model.addAttribute("list", list);
            model.addAttribute("input", input);
            model.addAttribute("adminIpUse", adminIpUse);

            //model.addAttribute("adminip_url", EgovProperties.getPathProperty("Globals.upload.adminip.url"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/site/adminip/index";
    }

    //IP insert GET
    @RequestMapping(value = "/admsys/site/adminip/insert.html", method = RequestMethod.GET)
    public String insert(
        HttpSession session, Model model,
        @ModelAttribute("AdminIPVO") AdminIPVO adminIPVO
    ) throws Exception {

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/site/adminip/insert";

    }

    //IP insert POST
    @RequestMapping(value = "/admsys/site/adminip/insert.html", method = RequestMethod.POST)
    public String insertSubmit(
        HttpServletRequest req, HttpServletResponse rep,
        @ModelAttribute("AdminIPVO") AdminIPVO adminIPVO
        , Model model
    ) throws Exception {
        int no = 0;
        //int ip = 0;
        try {
            String userid = SecuritySessionUtil.getUserid(req);
            adminIPVO.setUserid(userid);
            this.adminIPService.insert(adminIPVO);
            no = this.adminIPService.getCurrvalSequence(adminIPVO);/*마지막으로 입력된 값을 보여줌*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("insertsuccess", "true");
        model.addAttribute("no", no);
        return "redirect:/admsys/site/adminip/update.html";

    }


    //IP delect
    @RequestMapping(value = "/admsys/site/adminip/delete.html")
    public String ipDelect(
        @RequestParam("no") int[] no,
        @ModelAttribute("AdmimIPVO") AdminIPVO adminIPVO, BindingResult err, HttpServletRequest req
    ) throws Exception {

        List<Integer> arrDeleteNo = new ArrayList<Integer>(no.length);
        for (int i = 0; i < no.length; i++) {
            arrDeleteNo.add(no[i]);
        }
        for (int i = 0; i < no.length; i++) {
            adminIPVO.setNo(no[i]);
        }

        adminIPService.delete(arrDeleteNo);
        return "redirect:/admsys/site/adminip/index.html";

    }

    //IP update GET
    @RequestMapping(value = "/admsys/site/adminip/update.html", method = RequestMethod.GET)
    public String updateView(
        @RequestParam("no") int no,
        @ModelAttribute("AdminIPVO") AdminIPVO adminIPVO,
        HttpSession session,
        Model model
    ) throws Exception {

        try {

            AdminIPVO detail = (AdminIPVO) adminIPService.selectUP(no);
            model.addAttribute("no", adminIPVO.getNo());
            model.addAttribute("detail", detail);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/zcms/admsys/site/adminip/update";
    }

    //IP update POST
    @RequestMapping(value = "/admsys/site/adminip/update.html", method = RequestMethod.POST)
    public String updateSubmit(
        @ModelAttribute("AdminIPVO") AdminIPVO adminIPVO
        , @RequestParam("no") int no
        , Model model
    ) throws Exception {

        try {

            adminIPVO.setNo(no);
            adminIPService.update(adminIPVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("modifysuccess", "true");
        model.addAttribute("no", no);
        return "redirect:/admsys/site/adminip/update.html";

    }

    //IP doublecheck
    @ResponseBody
    @RequestMapping(value = "/admsys/site/adminip/doublecheck.html")
    public String doublecheck(
        //@RequestParam("ip") String ip,
        @ModelAttribute("AdminIPVO") AdminIPVO adminIPVO
    ) throws Exception {

        try {
            String ip = null;
            if (adminIPVO.getIp4() == null || adminIPVO.getIp4().isEmpty()) {
                ip = adminIPVO.getIp() + "." + adminIPVO.getIp2() + "." + adminIPVO.getIp3(); /*대역별ip체크하기위해서 9자리까지만ip에담음*/
            }
            else {
                ip = adminIPVO.getIp() + "." + adminIPVO.getIp2() + "." + adminIPVO.getIp3() + "." + adminIPVO.getIp4();/*개별ip체크하기위해서12자리모두 ip에 담음*/
            }
            adminIPVO.setIp(ip);
            int count = adminIPService.checkIPDouble(adminIPVO);/*동일한 IP값을 찾음*/
            if (count == 0) {
                return "true";
            }
            else {
                return "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }

    }
    
    private String hostname(HttpServletRequest request) {
        String hostname = EgovProperties.getProperty("Globals.server.name");
        if (request != null) {
            hostname = StringUtils.removeStart(request.getServerName(), "www.");
            //운영에서는 이렇게 사용(특수한 경우에만 사용)
            if ("localhost".equals(hostname) || "127.0.0.1".equals(hostname)) {
                hostname = EgovProperties.getProperty("Globals.server.name");
            }
        }
        return hostname;
    }
}
