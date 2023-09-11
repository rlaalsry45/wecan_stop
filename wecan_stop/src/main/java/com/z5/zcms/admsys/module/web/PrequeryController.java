package com.z5.zcms.admsys.module.web;

import com.z5.zcms.admsys.ftp.domain.AccessLogVo;
import com.z5.zcms.admsys.ftp.domain.DownloadLogVo;
import com.z5.zcms.admsys.ftp.service.FtpService;
import com.z5.zcms.admsys.module.domain.ZSatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;
import com.z5.zcms.admsys.module.service.SurveyService;
import com.z5.zcms.admsys.prequery.domain.PrequeryVO;
import com.z5.zcms.admsys.prequery.service.PrequeryService;
import com.z5.zcms.util.CookieUtil;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.SecuritySessionUtil;
import egovframework.com.cmm.service.EgovProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.z5.zcms.util.ZPrint.*;

@Controller
@SuppressWarnings("unused")
public class PrequeryController {

    @Autowired
    PrequeryService prequeryService;
    @Autowired
    FtpService ftpService;
    
    private Logger log = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/admsys/module/prequery/index.html")
    public String list(
        @ModelAttribute("PrequeryVO") PrequeryVO prequeryVO
        , Model model, HttpServletRequest req) throws Exception {

    	String userId = SecuritySessionUtil.getUserid(req);
    	AccessLogVo accessLogVo = new AccessLogVo();
		accessLogVo.setIp(req.getRemoteAddr());
		accessLogVo.setAction("사전질의 관리");
		accessLogVo.setRegId(userId);
		ftpService.registration_accessLog(accessLogVo);
		
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
        	prequeryVO.setCond1("");
        } else {
        	prequeryVO.setCond1(input.get("cond1"));
        }
        if (keyword.equals("")) {
        	prequeryVO.setCond2("");
        } else {
        	prequeryVO.setCond2(input.get("cond2"));
        }
        prequeryVO.setSdate(input.get("sdate").replaceAll("-", ""));
        prequeryVO.setEdate(input.get("edate").replaceAll("-", ""));
        prequeryVO.setKeyword(input.get("keyword"));
        prequeryVO.setM(m);
        prequeryVO.setN(n);

        int total = this.prequeryService.listCount(prequeryVO);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<PrequeryVO> list = this.prequeryService.prequeryList(prequeryVO);

        model.addAttribute("list", list);
        model.addAttribute("input", input);

        return "/zcms/admsys/module/prequery/index";
    }
    
    @RequestMapping(value = "/admsys/module/prequery/view.html")
    public String view(
        @ModelAttribute("PrequeryVO") PrequeryVO prequeryVO
        , Model model, HttpServletRequest req) throws Exception {

    	DataTable input    = new DataTable(req);
    	PrequeryVO vo = this.prequeryService.prequery(prequeryVO);

        model.addAttribute("vo", vo);
        model.addAttribute("input", input);

        return "/zcms/admsys/module/prequery/view";
    }
    
    @RequestMapping(value = "/admsys/module/prequery/index_excel.html", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
    public Map<String,Object> index_excel(@ModelAttribute("PrequeryVO") PrequeryVO prequeryVO, Model model, HttpServletRequest req) throws Exception {
      
    	Map<String,Object> map = new HashMap<String,Object>();

	  try{
		  
		  String userId = SecuritySessionUtil.getUserid(req);
  		  DownloadLogVo downloadLogVo = new DownloadLogVo();
		  downloadLogVo.setDataName("진단관리-사전질의 관리");
		  downloadLogVo.setReason("업무상 필요로 다운로드");
		  downloadLogVo.setRegId(userId);
		  ftpService.registration_downloadLog(downloadLogVo);
		  
		  DataTable input    = new DataTable(req);
          String sdate     = input.get("sdate");
          String edate     = input.get("edate");
          String keyword   = input.get("keyword");
   
          if (sdate.equals("") && edate.equals("")) {
        	  prequeryVO.setCond1("");
          } else {
        	  prequeryVO.setCond1(input.get("cond1"));
          }
          if (keyword.equals("")) {
        	  prequeryVO.setCond2("");
          } else {
        	  prequeryVO.setCond2(input.get("cond2"));
          }

          prequeryVO.setSdate(input.get("sdate").replaceAll("-", ""));
          prequeryVO.setEdate(input.get("edate").replaceAll("-", ""));
          prequeryVO.setKeyword(input.get("keyword"));
          prequeryVO.setM(0);
          prequeryVO.setN(99999999);
          
          List<PrequeryVO> list = this.prequeryService.prequeryList(prequeryVO);
	  	    
	  	  map.put("list", list);
		  map.put("resultCode", "success");
	  }catch(Exception e){
  		e.printStackTrace();
  	  }

      return map;
    }
}
