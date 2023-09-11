package com.z5.zcms.admsys.notify.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.notify.domain.NotifyVO;
import com.z5.zcms.admsys.notify.service.NotifyService;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.service.EgovProperties;


@Controller
@RequestMapping(value = {"/admsys/notify/"})
public class NotifyController{

    private static final long serialVersionUID = -6186035809545657688L;

    @Autowired
    NotifyService	notifyService;
    
    private Logger log = Logger.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "getNotifyList.html")
    public Map<String, Object> getNotifyList(Model model, HttpServletRequest req, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        try {
        	
        	NotifyVO notifyVO = new NotifyVO();
        	notifyVO.setNotifyBusiness(req.getParameter("business"));
        	int notifyCnt = notifyService.getNotifyCnt(notifyVO);
        	map.put("notifyCnt", notifyCnt);
        	
        	notifyVO = new NotifyVO();
        	notifyVO.setNotifyBusiness(req.getParameter("business"));
        	notifyVO.setM(0);
            notifyVO.setN(5);
        	List<NotifyVO> notifyList = notifyService.getNotifyList(notifyVO);
        	map.put("notifyList", notifyList);

        	map.put("resultCode", "success");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "updateNotify.html")
    public Map<String, Object> updateNotify(Model model, HttpServletRequest req, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        try {
        	NotifyVO notifyVO = new NotifyVO();
    		notifyVO = new NotifyVO();
    		notifyVO.setNotifyNo(Integer.parseInt(req.getParameter("notifyNo")));
    		notifyVO.setNotifyBusiness(req.getParameter("business"));
    		notifyVO.setNotifyConfirmyn("Y");
    		notifyVO.setUpdId("admin");
        	notifyService.updateNotify(notifyVO);
        	
        	map.put("resultCode", "success");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "getNotifyCnt.html")
    public Map<String, Object> getNotifyCnt(Model model, HttpServletRequest req, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        try {
        	NotifyVO notifyVO = new NotifyVO();
        	notifyVO.setNotifyBusiness(req.getParameter("business"));
        	int notifyCnt = notifyService.getNotifyCnt(notifyVO);
        	
        	map.put("notifyCnt", notifyCnt);
        	map.put("resultCode", "success");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return map;
    }
    
    /**
     * 알림 관리 컨트롤러
     *
     * @param model
     * @return "/zcms/admsys/notify/notifylist.html"
     * @throws Exception
     */
    
    @RequestMapping(value = "notifylist.html")
    public String notifylist(HttpServletRequest request, Model model) throws Exception {
    	
    	DataTable     input = new DataTable(request);
        List<NotifyVO> list  = null;

        int pageSize = 10;
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;

        NotifyVO notifyVO = new NotifyVO();
        notifyVO.setNotifyBusiness("Z00301");
        notifyVO.setM(m);
        notifyVO.setN(n);
        
        int total = 0;
        try {
            total = notifyService.getNotifyCnt(notifyVO);

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        try {
        	list = notifyService.getNotifyList(notifyVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
    	
        return "/zcms/admsys/notify/list";
    }  
    
    @ResponseBody
    @RequestMapping(value = "getMaxNotify.html")
    public Map<String, Object> getMaxNotify(Model model, HttpServletRequest req, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        try {

        	NotifyVO notifyVO = new NotifyVO();
        	NotifyVO notify = notifyService.getMaxNotify(notifyVO);
        	map.put("notify", notify);

        	map.put("resultCode", "success");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return map;
    }
    
}
