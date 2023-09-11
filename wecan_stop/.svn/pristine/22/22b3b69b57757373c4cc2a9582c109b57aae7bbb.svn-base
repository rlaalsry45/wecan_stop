package com.z5.zcms.admsys.cyberCounsel.dao;

import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselReviewVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WFamilyViolenceVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.user.domain.SearchUser;
import com.z5.zcms.frontsys.front.domain.MenuStaffVO;

import java.util.List;
import java.util.Map;

public interface WCyberCounselDAO {

	// 사이버상담후기
    public Integer listCount(WCounselReviewVo reqVo);
    public List<WCounselReviewVo> getList(WCounselReviewVo reqVo);
    public List<WCounselReviewVo> getListTotal(WCounselReviewVo reqVo);

    // 가정폭력감수성진단
    public Integer listCount_familyViolence(WFamilyViolenceVo reqVo);
    public List<WFamilyViolenceVo> getList_familyViolence(WFamilyViolenceVo reqVo);
    public List<WFamilyViolenceVo> getListTotal_familyViolence(WFamilyViolenceVo reqVo);

    // 상담일지 관리
    public Integer listCount(WCounselLogVo reqVo);
    public List<WCounselLogVo> getList(WCounselLogVo reqVo);
	public void registration(WCounselLogVo reqVo); 
	public WCounselLogVo view(WCounselLogVo reqVo);
	public void actionUpdate(WCounselLogVo reqVo);	
	public void delete(WCounselLogVo reqVo);    
	public int searchCounselNum();
	public List<Map<String,Object>> selectboxValueSet(String param);
	public String getCounselNum(WCounselLogVo reqVo);
	
    // 게시판상담 관리
    public Integer listCount_boardCounsel(WBoardCounselVo reqVo);
    public List<WBoardCounselVo> getList_boardCounsel(WBoardCounselVo reqVo);	
	public WBoardCounselVo view_boardCounsel(WBoardCounselVo reqVo);    
	public void registration_boardCounsel(WBoardCounselVo reqVo);
	public void hitUpdate_boardCounsel(WBoardCounselVo reqVo);
	public void delete_boardCounsel(WBoardCounselVo reqVo);
	
}
