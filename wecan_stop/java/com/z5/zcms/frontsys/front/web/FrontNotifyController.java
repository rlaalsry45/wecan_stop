package com.z5.zcms.frontsys.front.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.service.WCyberCounselService;
import com.z5.zcms.admsys.notify.domain.NotifyVO;
import com.z5.zcms.admsys.notify.service.NotifyService;
import com.z5.zcms.util.StringUtil;


@Controller
@RequestMapping(value = {"/front/notify/"})
public class FrontNotifyController{

    private static final long serialVersionUID = -6186035809545657687L;

    @Autowired
    NotifyService	notifyService;
    @Autowired
    WCyberCounselService wCyberCounselService;
    
    private Logger log = Logger.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "insertNotify.html")
    public Map<String, Object> insertNotify(Model model, HttpServletRequest req, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        try {
        	WCounselLogVo reqVo = new WCounselLogVo();
    		String counselNo = wCyberCounselService.getCounselNum(reqVo);
        	NotifyVO notifyVO = new NotifyVO();
        	notifyVO.setCounselNo(session.getAttribute("counselNo").toString());
        	notifyVO.setNotifyBusiness(req.getParameter("business"));
        	notifyVO.setNotifyCounselclassification(req.getParameter("counselclassification"));
        	notifyVO.setNotifyContent(req.getParameter("content"));
        	notifyVO.setRegId("admin");
        	notifyService.insertNotify(notifyVO);

        	map.put("resultCode", "success");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return map;
    }
    
}
