package com.z5.zcms.frontsys.front.web;


import static com.z5.zcms.util.ZPrint.enter;
import static com.z5.zcms.util.ZPrint.param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import antlr.StringUtils;
import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;


@Controller
public class FrontMenuController{

    private static final long serialVersionUID = -6186035809545657686L;

    @Autowired
    EgovCmmUseService	egovCmmUseService;
    
    private Logger log = Logger.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/getCountyList.html")
    public Map<String, Object> getCountyList(HttpServletRequest request) {
        enter();
        param(request);

        Map<String, Object> map = new HashMap<String, Object>();

        try {

        	ComDefaultCodeVO vo = new ComDefaultCodeVO();
        	vo.setCodeId("REGION");
        	vo.setCode(request.getParameter("origin").substring(4,6));
        	List<CmmnDetailCode> countyList = egovCmmUseService.selectCmmSubCodeDetail(vo);

            map.put("countyList", countyList);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return map;
    }
    
}
