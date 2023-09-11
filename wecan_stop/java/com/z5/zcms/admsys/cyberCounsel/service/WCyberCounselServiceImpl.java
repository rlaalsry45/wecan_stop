package com.z5.zcms.admsys.cyberCounsel.service;

import com.z5.zcms.admsys.chat.dao.ChatDAO;
import com.z5.zcms.admsys.chat.domain.ChatVO;
import com.z5.zcms.admsys.cyberCounsel.dao.WCyberCounselDAO;
import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WChatOldVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselReviewVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounseleeVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WFamilyViolenceVo;
import com.z5.zcms.admsys.orgculturedigmng.dao.ZOrgCultureDigMngDAO;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.frontsys.front.domain.MenuStaffVO;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WCyberCounselServiceImpl extends AbstractServiceImpl implements WCyberCounselService {

    @Autowired
    private WCyberCounselDAO wCyberCounselDAO;
    
    @Autowired
    private ChatDAO chatDAO;

    // 사이버상담후기
	@Override
	public Model index_counselReview(WCounselReviewVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        int total = this.wCyberCounselDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WCounselReviewVo> list = this.wCyberCounselDAO.getList(reqVo);
        List<WCounselReviewVo> listTotal = this.wCyberCounselDAO.getListTotal(reqVo);

        for(WCounselReviewVo wcVo : listTotal) {
        	double num1_1_Count = wcVo.getNum_1_1_count();
        	double num1_2_Count = wcVo.getNum_1_2_count();
        	double num1_3_Count = wcVo.getNum_1_3_count();
        	double num1_4_Count = wcVo.getNum_1_4_count();
        	double num1_5_Count = wcVo.getNum_1_5_count();
        	double num1_total_Count = wcVo.getNum_1_total_count();
        	
        	double num2_1_Count = wcVo.getNum_2_1_count();
        	double num2_2_Count = wcVo.getNum_2_2_count();
        	double num2_3_Count = wcVo.getNum_2_3_count();
        	double num2_4_Count = wcVo.getNum_2_4_count();
        	double num2_total_Count = wcVo.getNum_2_total_count();
        	
        	double num_1_sum = wcVo.getNum_1_sum();
        	double num_1_count = wcVo.getNum_1_count();
        	
        	double num1_1_Percent = Math.round(num1_1_Count/num1_total_Count*10000)/100.0;
        	double num1_2_Percent = Math.round(num1_2_Count/num1_total_Count*10000)/100.0;
        	double num1_3_Percent = Math.round(num1_3_Count/num1_total_Count*10000)/100.0;
        	double num1_4_Percent = Math.round(num1_4_Count/num1_total_Count*10000)/100.0;
        	double num1_5_Percent = Math.round(num1_5_Count/num1_total_Count*10000)/100.0;
            
        	double num2_1_Percent = Math.round(num2_1_Count/num2_total_Count*10000)/100.0;
        	double num2_2_Percent = Math.round(num2_2_Count/num2_total_Count*10000)/100.0;
        	double num2_3_Percent = Math.round(num2_3_Count/num2_total_Count*10000)/100.0;
        	double num2_4_Percent = Math.round(num2_4_Count/num2_total_Count*10000)/100.0;
        	
        	double fivePoint = Math.round(wcVo.getFivePoint()*100)/100.0;
        	
            model.addAttribute("num1_1_Percent",num1_1_Percent);
            model.addAttribute("num1_2_Percent",num1_2_Percent);
            model.addAttribute("num1_3_Percent",num1_3_Percent);
            model.addAttribute("num1_4_Percent",num1_4_Percent);
            model.addAttribute("num1_5_Percent",num1_5_Percent);
            
            model.addAttribute("num2_1_Percent",num2_1_Percent);
            model.addAttribute("num2_2_Percent",num2_2_Percent);
            model.addAttribute("num2_3_Percent",num2_3_Percent);
            model.addAttribute("num2_4_Percent",num2_4_Percent);
            model.addAttribute("num_1_sum",num_1_sum);
            model.addAttribute("num_1_count",num_1_count);
            model.addAttribute("fivePoint",fivePoint);
        }
        model.addAttribute("list", list);
        model.addAttribute("listTotal", listTotal);
        model.addAttribute("input", input);
        
		return model;
	}
	
	// 가정폭력감수성진단
	@Override
	public Model index_familyViolence(WFamilyViolenceVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        int total = this.wCyberCounselDAO.listCount_familyViolence(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WFamilyViolenceVo> list = this.wCyberCounselDAO.getList_familyViolence(reqVo);
        List<WFamilyViolenceVo> listTotal = this.wCyberCounselDAO.getListTotal_familyViolence(reqVo);

        for(WFamilyViolenceVo wcVo : listTotal) {
        	double num1_1_Count = wcVo.getNum_1_1_count();
        	double num1_2_Count = wcVo.getNum_1_2_count();
        	double num1_total_Count = wcVo.getNum_1_total_count();
        	
        	double num2_1_Count = wcVo.getNum_2_1_count();
        	double num2_2_Count = wcVo.getNum_2_2_count();
        	double num2_total_Count = wcVo.getNum_2_total_count();
        	
        	double num3_1_Count = wcVo.getNum_3_1_count();
        	double num3_2_Count = wcVo.getNum_3_2_count();
        	double num3_total_Count = wcVo.getNum_3_total_count();
        	
        	double num4_1_Count = wcVo.getNum_4_1_count();
        	double num4_2_Count = wcVo.getNum_4_2_count();
        	double num4_total_Count = wcVo.getNum_4_total_count();
        	
        	double num5_1_Count = wcVo.getNum_5_1_count();
        	double num5_2_Count = wcVo.getNum_5_2_count();
        	double num5_total_Count = wcVo.getNum_5_total_count();
        	
        	double num6_1_Count = wcVo.getNum_6_1_count();
        	double num6_2_Count = wcVo.getNum_6_2_count();
        	double num6_total_Count = wcVo.getNum_6_total_count();
        	
        	double num7_1_Count = wcVo.getNum_7_1_count();
        	double num7_2_Count = wcVo.getNum_7_2_count();
        	double num7_total_Count = wcVo.getNum_7_total_count();
        	
        	double num8_1_Count = wcVo.getNum_8_1_count();
        	double num8_2_Count = wcVo.getNum_8_2_count();
        	double num8_total_Count = wcVo.getNum_8_total_count();
        	
        	double num9_1_Count = wcVo.getNum_9_1_count();
        	double num9_2_Count = wcVo.getNum_9_2_count();
        	double num9_total_Count = wcVo.getNum_9_total_count();
        	
        	double num10_1_Count = wcVo.getNum_10_1_count();
        	double num10_2_Count = wcVo.getNum_10_2_count();
        	double num10_total_Count = wcVo.getNum_10_total_count();
        	
        	
        	double num_1_sum = wcVo.getNum_1_sum();
        	double num_1_count = wcVo.getNum_1_count();
        	
        	double num_2_sum = wcVo.getNum_2_sum();
        	double num_2_count = wcVo.getNum_2_count();
        	
        	double num_3_sum = wcVo.getNum_3_sum();
        	double num_3_count = wcVo.getNum_3_count();
        	
        	double num_4_sum = wcVo.getNum_4_sum();
        	double num_4_count = wcVo.getNum_4_count();
        	
        	double num_5_sum = wcVo.getNum_5_sum();
        	double num_5_count = wcVo.getNum_5_count();
        	
        	double num_6_sum = wcVo.getNum_6_sum();
        	double num_6_count = wcVo.getNum_6_count();
        	
        	double num_7_sum = wcVo.getNum_7_sum();
        	double num_7_count = wcVo.getNum_7_count();
        	
        	double num_8_sum = wcVo.getNum_8_sum();
        	double num_8_count = wcVo.getNum_8_count();
        	
        	double num_9_sum = wcVo.getNum_9_sum();
        	double num_9_count = wcVo.getNum_9_count();
        	
        	double num_10_sum = wcVo.getNum_10_sum();
        	double num_10_count = wcVo.getNum_10_count();
        	
        	
        	double num1_1_Percent = Math.round(num1_1_Count/num1_total_Count*10000)/100.0;
        	double num1_2_Percent = Math.round(num1_2_Count/num1_total_Count*10000)/100.0;
            
        	double num2_1_Percent = Math.round(num2_1_Count/num2_total_Count*10000)/100.0;
        	double num2_2_Percent = Math.round(num2_2_Count/num2_total_Count*10000)/100.0;
        	
        	double num3_1_Percent = Math.round(num3_1_Count/num3_total_Count*10000)/100.0;
        	double num3_2_Percent = Math.round(num3_2_Count/num3_total_Count*10000)/100.0;
        	
        	double num4_1_Percent = Math.round(num4_1_Count/num4_total_Count*10000)/100.0;
        	double num4_2_Percent = Math.round(num4_2_Count/num4_total_Count*10000)/100.0;
        	
        	double num5_1_Percent = Math.round(num5_1_Count/num5_total_Count*10000)/100.0;
        	double num5_2_Percent = Math.round(num5_2_Count/num5_total_Count*10000)/100.0;
        	
        	double num6_1_Percent = Math.round(num6_1_Count/num6_total_Count*10000)/100.0;
        	double num6_2_Percent = Math.round(num6_2_Count/num6_total_Count*10000)/100.0;
        	
        	double num7_1_Percent = Math.round(num7_1_Count/num7_total_Count*10000)/100.0;
        	double num7_2_Percent = Math.round(num7_2_Count/num7_total_Count*10000)/100.0;
        	
        	double num8_1_Percent = Math.round(num8_1_Count/num8_total_Count*10000)/100.0;
        	double num8_2_Percent = Math.round(num8_2_Count/num8_total_Count*10000)/100.0;
        	
        	double num9_1_Percent = Math.round(num9_1_Count/num9_total_Count*10000)/100.0;
        	double num9_2_Percent = Math.round(num9_2_Count/num9_total_Count*10000)/100.0;
        	
        	double num10_1_Percent = Math.round(num10_1_Count/num10_total_Count*10000)/100.0;
        	double num10_2_Percent = Math.round(num10_2_Count/num10_total_Count*10000)/100.0;
        	
            model.addAttribute("num1_1_Percent",num1_1_Percent);
            model.addAttribute("num1_2_Percent",num1_2_Percent);
            
            model.addAttribute("num2_1_Percent",num2_1_Percent);
            model.addAttribute("num2_2_Percent",num2_2_Percent);
            
            model.addAttribute("num3_1_Percent",num3_1_Percent);
            model.addAttribute("num3_2_Percent",num3_2_Percent);
            
            model.addAttribute("num4_1_Percent",num4_1_Percent);
            model.addAttribute("num4_2_Percent",num4_2_Percent);
            
            model.addAttribute("num5_1_Percent",num5_1_Percent);
            model.addAttribute("num5_2_Percent",num5_2_Percent);
            
            model.addAttribute("num6_1_Percent",num6_1_Percent);
            model.addAttribute("num6_2_Percent",num6_2_Percent);
            
            model.addAttribute("num7_1_Percent",num7_1_Percent);
            model.addAttribute("num7_2_Percent",num7_2_Percent);
            
            model.addAttribute("num8_1_Percent",num8_1_Percent);
            model.addAttribute("num8_2_Percent",num8_2_Percent);
            
            model.addAttribute("num9_1_Percent",num9_1_Percent);
            model.addAttribute("num9_2_Percent",num9_2_Percent);
            
            model.addAttribute("num10_1_Percent",num10_1_Percent);
            model.addAttribute("num10_2_Percent",num10_2_Percent);

            
            model.addAttribute("num_1_sum",num_1_sum);
            model.addAttribute("num_1_count",num_1_count);
            
            model.addAttribute("num_2_sum",num_2_sum);
            model.addAttribute("num_2_count",num_2_count);
            
            model.addAttribute("num_3_sum",num_3_sum);
            model.addAttribute("num_3_count",num_3_count);
            
            model.addAttribute("num_4_sum",num_4_sum);
            model.addAttribute("num_4_count",num_4_count);
            
            model.addAttribute("num_5_sum",num_5_sum);
            model.addAttribute("num_5_count",num_5_count);
            
            model.addAttribute("num_6_sum",num_6_sum);
            model.addAttribute("num_6_count",num_6_count);
            
            model.addAttribute("num_7_sum",num_7_sum);
            model.addAttribute("num_7_count",num_7_count);
            
            model.addAttribute("num_8_sum",num_8_sum);
            model.addAttribute("num_8_count",num_8_count);
            
            model.addAttribute("num_9_sum",num_9_sum);
            model.addAttribute("num_9_count",num_9_count);
            
            model.addAttribute("num_10_sum",num_10_sum);
            model.addAttribute("num_10_count",num_10_count);
            
        }
        model.addAttribute("list", list);
        model.addAttribute("listTotal", listTotal);
        model.addAttribute("input", input);
        
		return model;
	}	
	
	// 상담일지 관리
	@Override
	public Model index_counselLog(WCounselLogVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        if (!StringUtil.isEmpty(input.get("sdate"))
        		&& !StringUtil.isEmpty(input.get("edate"))) {
        	reqVo.setSdate(input.get("sdate").replaceAll("-", ""));
        	reqVo.setEdate(input.get("edate").replaceAll("-", ""));
        }
        
        int total = this.wCyberCounselDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WCounselLogVo> list = this.wCyberCounselDAO.getList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}	
	
	@Override
	public String registration(WCounselLogVo reqVo) throws Exception {
		
//		int searchNum;
//		searchNum = wCyberCounselDAO.searchCounselNum()+1;
//		
//		LocalDate now = LocalDate.now();
//		int yearInt = now.getYear();
//		String year = Integer.toString(yearInt);		
//		int month = now.getMonthValue();
//		int day = now.getDayOfMonth();
//		
//		String counselNo = year + String.format("%02d",month) + String.format("%02d",day) + String.format("%05d",searchNum);
//		reqVo.setCounselNo(counselNo);
		
		return this.wCyberCounselDAO.registration(reqVo);
	}	

	@Override
	public WCounselLogVo view(WCounselLogVo reqVo) throws Exception {
		return this.wCyberCounselDAO.view(reqVo);
	}	
	
	@Override
	public List<Map<String,Object>> selectboxValueSet(String param) throws Exception {
		return this.wCyberCounselDAO.selectboxValueSet(param);
	}		
	
	@Override
	public void actionUpdate(WCounselLogVo reqVo) throws Exception {
		this.wCyberCounselDAO.actionUpdate(reqVo);
	}	
	
	@Override 
	public void delete(WCounselLogVo reqVo) throws Exception {
		this.wCyberCounselDAO.delete(reqVo);
	}
	
	@Override 
	public String getCounselNum(WCounselLogVo reqVo) throws Exception {
		return this.wCyberCounselDAO.getCounselNum(reqVo);
	}	
	
	// 상담일지 삭제함 관리
	@Override
	public Model index_counselLog_delete(WCounselLogVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        if(!StringUtils.isEmpty(reqVo.getSdate())) {
        	reqVo.setSdate(reqVo.getSdate().replaceAll("-", ""));
        }
        
        if(!StringUtils.isEmpty(reqVo.getEdate())) {
        	reqVo.setEdate(reqVo.getEdate().replaceAll("-", ""));
        }
        
        int total = this.wCyberCounselDAO.listCount_delete(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WCounselLogVo> list = this.wCyberCounselDAO.getList_delete(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}		
	
	@Override 
	public void deleteRestore(WCounselLogVo reqVo) throws Exception {
		this.wCyberCounselDAO.deleteRestore(reqVo);
	}	
	
	// 게시판상담 관리
	@Override
	public Model index_boardCounsel(WBoardCounselVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        if (!StringUtil.isEmpty(input.get("sdate"))
        		&& !StringUtil.isEmpty(input.get("edate"))) {
        	reqVo.setSdate(input.get("sdate").replaceAll("-", ""));
        	reqVo.setEdate(input.get("edate").replaceAll("-", ""));
        }
        
        int total = this.wCyberCounselDAO.listCount_boardCounsel(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WBoardCounselVo> list = this.wCyberCounselDAO.getList_boardCounsel(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}		
	
	@Override
	public WBoardCounselVo view_boardCounsel(WBoardCounselVo reqVo) throws Exception {
		this.wCyberCounselDAO.hitUpdate_boardCounsel(reqVo);
		return this.wCyberCounselDAO.view_boardCounsel(reqVo);
	}	
	
	@Override
	public void registration_boardCounsel(WBoardCounselVo reqVo) throws Exception {
		this.wCyberCounselDAO.registration_boardCounsel(reqVo);
	}	
	
	@Override
	public void modify_boardCounsel(WBoardCounselVo reqVo) throws Exception {
		this.wCyberCounselDAO.modify_boardCounsel(reqVo);
	}	
	
	@Override 
	public void delete_boardCounsel(WBoardCounselVo reqVo) throws Exception {
		this.wCyberCounselDAO.delete_boardCounsel(reqVo);
	}	
	
	
	// 내담자 관리
	@Override
	public Model index_counselee(WCounseleeVo reqVo, DataTable input, Model model) throws Exception  {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;
        
        reqVo.setM(m);
        reqVo.setN(n);
        
        int total = this.wCyberCounselDAO.listCount_counselee(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));
        
        List<WCounseleeVo> list = this.wCyberCounselDAO.getList_counselee(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public List<WBoardCounselVo> boardCounsel_excel(WBoardCounselVo reqVo)
			throws Exception {
      
		reqVo.setM(0);
        reqVo.setN(99999999);
        
		return this.wCyberCounselDAO.getList_boardCounsel(reqVo);
	}

	@Override
	public List<WCounselLogVo> counselLog_excel(WCounselLogVo reqVo) throws Exception {
		reqVo.setM(0);
        reqVo.setN(99999999);
        
        return this.wCyberCounselDAO.getList(reqVo);
	}

	@Override
	public int victim_count(WCounselLogVo reqVo) throws Exception {
		return this.wCyberCounselDAO.victim_count(reqVo);
	}

	@Override
	public void victim_actionReg(WCounselLogVo reqVo) throws Exception {
		this.wCyberCounselDAO.victim_actionReg(reqVo);
		
	}

	@Override
	public void victim_actionUpdate(WCounselLogVo reqVo) throws Exception {
		this.wCyberCounselDAO.victim_actionUpdate(reqVo);
		
	}

	@Override
	public int attacker_count(WCounselLogVo reqVo) throws Exception {
		return this.wCyberCounselDAO.attacker_count(reqVo);
	}

	@Override
	public void attacker_actionReg(WCounselLogVo reqVo) throws Exception {
		this.wCyberCounselDAO.attacker_actionReg(reqVo);
		
	}

	@Override
	public void attacker_actionUpdate(WCounselLogVo reqVo) throws Exception {
		this.wCyberCounselDAO.attacker_actionUpdate(reqVo);
	}

	@Override
	public void passwdInit_boardCounsel(WBoardCounselVo reqVo) throws Exception {
		this.wCyberCounselDAO.passwdInit_boardCounsel(reqVo);
	}

	@Override
	public void actionUpdYn(WCounselLogVo reqVo) throws Exception {
		this.wCyberCounselDAO.actionUpdYn(reqVo);	
	}

	@Override
	public String getUpdYn(WCounselLogVo reqVo) throws Exception {
		return this.wCyberCounselDAO.getUpdYn(reqVo);	
	}

	@Override
	public void actionUpdate2(WCounselLogVo reqVo) throws Exception {
		this.wCyberCounselDAO.actionUpdate2(reqVo);
	}

	@Override
	public List<WCounselLogVo> counselLog_delete_excel(WCounselLogVo reqVo) throws Exception {
		reqVo.setM(0);
        reqVo.setN(99999999);
        
        return this.wCyberCounselDAO.getList_delete(reqVo);
	}

	@Override
	public List<ChatVO> chatCounsel_excel(ChatVO reqVo) throws Exception {
		reqVo.setM(0);
        reqVo.setN(99999999);
        
        return this.chatDAO.getList(reqVo);
	}

	// 구)채팅상담 이력
	@Override
	public Model index_chatOld(WChatOldVo reqVo, DataTable input, Model model) throws Exception {
		int pageSize = input.getInt("pageSize", Integer.parseInt(EgovProperties.getProperty("Globals.list.count")));
        if (input.getInt("pageIndex") == 0) {
            input.put("pageIndex", 1);
        }
        int    pageIndex  = input.getInt("pageIndex") - 1;
        int    m          = pageIndex * pageSize;
        int    n          = pageSize;

        reqVo.setM(m);
        reqVo.setN(n);
        
        if (!StringUtil.isEmpty(input.get("sdate"))
        		&& !StringUtil.isEmpty(input.get("edate"))) {
        	reqVo.setSdate(input.get("sdate").replaceAll("-", ""));
        	reqVo.setEdate(input.get("edate").replaceAll("-", ""));
        }
        
        if (!StringUtil.isEmpty(input.get("csdate"))
        		&& !StringUtil.isEmpty(input.get("cedate"))) {
        	reqVo.setCsdate(input.get("csdate").replaceAll("-", ""));
        	reqVo.setCedate(input.get("cedate").replaceAll("-", ""));
        }
        
        int total = this.wCyberCounselDAO.listCount(reqVo);
        input.put("pageSize", pageSize);
        input.put("total", total);
        input.put("pageMax", (int) Math.ceil((double) total / pageSize));

        List<WChatOldVo> list = this.wCyberCounselDAO.getList(reqVo);
        
        model.addAttribute("list", list);
        model.addAttribute("input", input);
        
		return model;
	}

	@Override
	public WChatOldVo view(WChatOldVo reqVo) throws Exception {
		return this.wCyberCounselDAO.view(reqVo);
	}

	@Override
	public List<WChatOldVo> chatOld_excel(WChatOldVo reqVo) throws Exception {
		reqVo.setM(0);
        reqVo.setN(99999999);
        
        return this.wCyberCounselDAO.getList(reqVo);
	}
	
	@Override
	public List<WBoardCounselVo> fileList_boardCounsel(WBoardCounselVo reqVo) throws Exception {
		return this.wCyberCounselDAO.getFileList_boardCounsel(reqVo);
	}	
	
}
