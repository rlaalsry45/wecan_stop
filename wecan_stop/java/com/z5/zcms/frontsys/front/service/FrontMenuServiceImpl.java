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
	public void getMenuno246(HttpServletRequest request, HttpServletResponse response, HttpSession session)
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

     	session.getServletContext().getRequestDispatcher("/front/parse/template/menu/246_1c.html").include(request, response);
		
	}
    
}
