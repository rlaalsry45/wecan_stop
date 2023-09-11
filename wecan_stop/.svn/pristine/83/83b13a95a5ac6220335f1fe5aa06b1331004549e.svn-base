package com.z5.zcms.admsys.cyberCounsel.service;

import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselReviewVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WFamilyViolenceVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.frontsys.front.domain.MenuStaffVO;
import com.z5.zcms.util.DataTable;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

//@Service superbolt
public interface WCyberCounselService {

	// 사이버상담후기
	Model index_counselReview(WCounselReviewVo reqVo, DataTable input, Model model) throws Exception;
	
	// 가정폭력감수성진단
	Model index_familyViolence(WFamilyViolenceVo reqVo, DataTable input, Model model) throws Exception;    
	
	// 상담일지 관리
	Model index_counselLog(WCounselLogVo reqVo, DataTable input, Model model) throws Exception;    
    public void registration(WCounselLogVo reqVo) throws Exception;  
	public WCounselLogVo view(WCounselLogVo reqVo) throws Exception;    
	void actionUpdate(WCounselLogVo reqVo) throws Exception;	
	void delete(WCounselLogVo reqVo) throws Exception;
	String getCounselNum(WCounselLogVo reqVo) throws Exception;
	
	// 게시판상담 관리
	Model index_boardCounsel(WBoardCounselVo reqVo, DataTable input, Model model) throws Exception;
	public WBoardCounselVo view_boardCounsel(WBoardCounselVo reqVo) throws Exception;
	public void registration_boardCounsel(WBoardCounselVo reqVo) throws Exception;
	void delete_boardCounsel(WBoardCounselVo reqVo) throws Exception;
    
    // selectbox value 셋팅
    List<Map<String,Object>> selectboxValueSet(String param) throws Exception;;
	

}

