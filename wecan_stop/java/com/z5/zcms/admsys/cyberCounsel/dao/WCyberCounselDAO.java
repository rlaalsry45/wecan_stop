package com.z5.zcms.admsys.cyberCounsel.dao;

import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WChatOldVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselReviewVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounseleeVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WFamilyViolenceVo;

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
	public String registration(WCounselLogVo reqVo); 
	public WCounselLogVo view(WCounselLogVo reqVo);
	public void actionUpdate(WCounselLogVo reqVo);	
	public void delete(WCounselLogVo reqVo);    
	public int searchCounselNum();
	public List<Map<String,Object>> selectboxValueSet(String param);
	public String getCounselNum(WCounselLogVo reqVo);
    public Integer listCount_delete(WCounselLogVo reqVo);
    public List<WCounselLogVo> getList_delete(WCounselLogVo reqVo);
	public void deleteRestore(WCounselLogVo reqVo);
	public Integer victim_count(WCounselLogVo reqVo);
	public void victim_actionReg(WCounselLogVo reqVo);	
	public void victim_actionUpdate(WCounselLogVo reqVo);	
	public Integer attacker_count(WCounselLogVo reqVo);
	public void attacker_actionReg(WCounselLogVo reqVo);	
	public void attacker_actionUpdate(WCounselLogVo reqVo);
	public void actionUpdYn(WCounselLogVo reqVo);
	public String getUpdYn(WCounselLogVo reqVo);
	public void actionUpdate2(WCounselLogVo reqVo);
	
    // 게시판상담 관리
    public Integer listCount_boardCounsel(WBoardCounselVo reqVo);
    public List<WBoardCounselVo> getList_boardCounsel(WBoardCounselVo reqVo);	
	public WBoardCounselVo view_boardCounsel(WBoardCounselVo reqVo);    
	public void registration_boardCounsel(WBoardCounselVo reqVo);
	public void modify_boardCounsel(WBoardCounselVo reqVo);
	public void hitUpdate_boardCounsel(WBoardCounselVo reqVo);
	public void delete_boardCounsel(WBoardCounselVo reqVo);
	public void passwdInit_boardCounsel(WBoardCounselVo reqVo);
	public List<WBoardCounselVo> getFileList_boardCounsel(WBoardCounselVo reqVo);	
	
    // 내담자 관리
    public Integer listCount_counselee(WCounseleeVo reqVo);
    public List<WCounseleeVo> getList_counselee(WCounseleeVo reqVo);
    
    // 구)채팅상담 이력
    public Integer listCount(WChatOldVo reqVo);
    public List<WChatOldVo> getList(WChatOldVo reqVo);
    public WChatOldVo view(WChatOldVo reqVo);
    
}
