package com.z5.zcms.frontsys.front.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.module.domain.SatisfactionVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;
import com.z5.zcms.admsys.module.service.SatisfactionService;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.admsys.user.service.ZUserService;
import com.z5.zcms.util.ZPrint;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.impl.CmmUseDAO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class FrontMenuServiceImpl extends AbstractServiceImpl implements FrontMenuService {

    @Autowired
    CmmUseDAO	cmmUseDAO;
    
    @Autowired
    SatisfactionService satisfactionService;

	@Autowired
    ZUserService zUserService;
    
	@Override
	public void getMenuno229(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
    	vo.setCodeId("GENDER");
    	List<CmmnDetailCode> genderList = cmmUseDAO.selectCmmCodeDetail(vo);
    	
    	vo = new ComDefaultCodeVO();
    	vo.setCodeId("NATION");
    	List<CmmnDetailCode> nationList = cmmUseDAO.selectCmmCodeDetail(vo);
    	
    	vo = new ComDefaultCodeVO();
    	vo.setCodeId("RELATION");
     	List<CmmnDetailCode> relationList = cmmUseDAO.selectCmmCodeDetail(vo);
    	 
    	vo = new ComDefaultCodeVO();
    	vo.setCodeId("AGE");
     	List<CmmnDetailCode> ageList = cmmUseDAO.selectCmmCodeDetail(vo);
     	
     	vo = new ComDefaultCodeVO();
     	vo.setCodeId("REGION");
     	vo.setCode("ORIGIN");
    	List<CmmnDetailCode> originList = cmmUseDAO.selectCmmSubCodeDetail(vo);
    	
    	vo = new ComDefaultCodeVO();
    	vo.setCodeId("TYPE");
     	List<CmmnDetailCode> typeList = cmmUseDAO.selectCmmCodeDetail(vo);
     	
     	request.setAttribute("genderList", genderList);
     	request.setAttribute("nationList", nationList);
     	request.setAttribute("relationList", relationList);
     	request.setAttribute("ageList", ageList);
     	request.setAttribute("originList", originList);
     	request.setAttribute("typeList", typeList);

     	session.getServletContext().getRequestDispatcher("/front/parse/template/menu/229_1c.html").include(request, response);
    }

	@Override
	public void getMenuno236(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
    	vo.setCodeId("GENDER");
    	List<CmmnDetailCode> genderList = cmmUseDAO.selectCmmCodeDetail(vo);
    	
    	vo = new ComDefaultCodeVO();
    	vo.setCodeId("NATION");
    	List<CmmnDetailCode> nationList = cmmUseDAO.selectCmmCodeDetail(vo);
    	
    	vo = new ComDefaultCodeVO();
    	vo.setCodeId("RELATION");
     	List<CmmnDetailCode> relationList = cmmUseDAO.selectCmmCodeDetail(vo);
    	 
    	vo = new ComDefaultCodeVO();
    	vo.setCodeId("AGE");
     	List<CmmnDetailCode> ageList = cmmUseDAO.selectCmmCodeDetail(vo);
     	
     	vo = new ComDefaultCodeVO();
     	vo.setCodeId("REGION");
     	vo.setCode("ORIGIN");
    	List<CmmnDetailCode> originList = cmmUseDAO.selectCmmSubCodeDetail(vo);
    	
    	vo = new ComDefaultCodeVO();
    	vo.setCodeId("TYPE");
     	List<CmmnDetailCode> typeList = cmmUseDAO.selectCmmCodeDetail(vo);
     	
     	request.setAttribute("genderList", genderList);
     	request.setAttribute("nationList", nationList);
     	request.setAttribute("relationList", relationList);
     	request.setAttribute("ageList", ageList);
     	request.setAttribute("originList", originList);
     	request.setAttribute("typeList", typeList);
     	
     	session.getServletContext().getRequestDispatcher("/front/parse/template/menu/236_1c.html").include(request, response);
	}

	@Override
	public void getMenuno239(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		
		String serverName = request.getServerName();
     	String chatPort = EgovProperties.getProperty("Globals.chat.port");
     	String chatServer = "http://" + serverName + ":" + chatPort + "/?token=";
     	
     	String chatUrl = "";
     	if("8080".equals(String.valueOf(request.getServerPort()))) {
     		chatUrl = chatServer + EgovProperties.getProperty("Globals.chat.token.local");
     	}else {
     		chatUrl = chatServer + EgovProperties.getProperty("Globals.chat.token");
     	}
     	
    	request.setAttribute("chatUrl", chatUrl);
    	
    	session.getServletContext().getRequestDispatcher("/front/parse/template/menu/239_1c.html").include(request, response);
	}

	@Override
	public void getMenuno258(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		
		String orgId = session.getAttribute("ORGANIZATION_ID").toString();
		String userid = session.getAttribute("govUserID").toString();
		
		ZUserVo zUserVo = new ZUserVo();
		zUserVo.setUserid(userid);
		zUserVo.setUserauth("5");
		zUserVo.setChargeorgid(orgId);
		ZUserVo zUserVoRes = zUserService.getInfo(zUserVo);
		
    	request.setAttribute("org_code", zUserVoRes.getChargeorgid());
    	request.setAttribute("org_name", zUserVoRes.getOrgNm());
    	
    	session.getServletContext().getRequestDispatcher("/front/parse/template/menu/258_1c.html").include(request, response);
		
	}
    
}
