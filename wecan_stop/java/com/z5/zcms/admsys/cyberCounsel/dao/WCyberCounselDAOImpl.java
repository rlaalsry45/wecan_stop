package com.z5.zcms.admsys.cyberCounsel.dao;

import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WChatOldVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselReviewVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounseleeVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WFamilyViolenceVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WCyberCounselDAOImpl extends EgovComAbstractDAO implements WCyberCounselDAO {

    private final String sqlMapNs = "w_counselReview.";
    private final String sqlMapNs_familyViolence = "w_familyViolence.";
    private final String sqlMapNs_counselLog = "w_counselLog.";
    private final String sqlMapNs_boardCounsel = "w_boardCounsel.";
    private final String sqlMapNs_counselee = "w_counselee.";
    private final String sqlMapNs_counselLogVictim = "w_counselLogVictim.";
    private final String sqlMapNs_counselLogAttacker = "w_counselLogAttacker.";
    private final String sqlMapNs_chatOld = "w_chatOld.";
    
    Logger log = Logger.getLogger(this.getClass());

    // 사이버상담후기    
    public Integer listCount(WCounselReviewVo reqVo) {
        return (Integer) select(sqlMapNs + "listCount", reqVo);
    }

    @SuppressWarnings("unchecked")
    public List<WCounselReviewVo> getList(WCounselReviewVo reqVo) {
        return (List<WCounselReviewVo>) super.list(sqlMapNs + "getList", reqVo);
    }
    
    @SuppressWarnings("unchecked")
    public List<WCounselReviewVo> getListTotal(WCounselReviewVo reqVo) {
    	return (List<WCounselReviewVo>) super.list(sqlMapNs + "getListTotal", reqVo);
    }
    
    // 가정폭력감수성진단
    public Integer listCount_familyViolence(WFamilyViolenceVo reqVo) {
    	return (Integer) select(sqlMapNs_familyViolence + "listCount", reqVo);
    }
    
    @SuppressWarnings("unchecked")
    public List<WFamilyViolenceVo> getList_familyViolence(WFamilyViolenceVo reqVo) {
    	return (List<WFamilyViolenceVo>) super.list(sqlMapNs_familyViolence + "getList", reqVo);
    }
    
    @SuppressWarnings("unchecked")
    public List<WFamilyViolenceVo> getListTotal_familyViolence(WFamilyViolenceVo reqVo) {
    	return (List<WFamilyViolenceVo>) super.list(sqlMapNs_familyViolence + "getListTotal", reqVo);
    }
    
    // 상담일지 관리
    public Integer listCount(WCounselLogVo reqVo) {
        return (Integer) select(sqlMapNs_counselLog + "listCount", reqVo);
    }

    @SuppressWarnings("unchecked")
    public List<WCounselLogVo> getList(WCounselLogVo reqVo) {
        return (List<WCounselLogVo>) super.list(sqlMapNs_counselLog + "getList", reqVo);
    }

	@Override
	public String registration(WCounselLogVo reqVo) {
		return (String)super.insert(sqlMapNs_counselLog + "actionRegistration", reqVo);
	}
	
	@Override
	public WCounselLogVo view(WCounselLogVo reqVo) {
		return (WCounselLogVo)super.select(sqlMapNs_counselLog + "view", reqVo);
	}	
	
	@Override
    public int searchCounselNum() {
        return (int) select(sqlMapNs_counselLog + "searchCounselNum");
    }	
	
	@Override
    public List<Map<String,Object>> selectboxValueSet(String param) {
        return (List<Map<String, Object>>) super.list(sqlMapNs_counselLog + "selectboxValueSet", param);
    }	
	
	@Override
	public void actionUpdate(WCounselLogVo reqVo) {
		super.update(sqlMapNs_counselLog + "actionUpdate", reqVo);
	}	
	
	@Override
	public void delete(WCounselLogVo reqVo) {
		super.update(sqlMapNs_counselLog + "delete", reqVo);
	}	
	
	@Override
    public String getCounselNum(WCounselLogVo reqVo) {
        return (String) select(sqlMapNs_counselLog + "getCounselNum");
    }		
	
    public Integer listCount_delete(WCounselLogVo reqVo) {
        return (Integer) select(sqlMapNs_counselLog + "listCount_delete", reqVo);
    }

    @SuppressWarnings("unchecked")
    public List<WCounselLogVo> getList_delete(WCounselLogVo reqVo) {
        return (List<WCounselLogVo>) super.list(sqlMapNs_counselLog + "getList_delete", reqVo);
    }	
    
	@Override
	public void deleteRestore(WCounselLogVo reqVo) {
		super.update(sqlMapNs_counselLog + "deleteRestore", reqVo);
	}    
	
    // 게시판상담 관리
    public Integer listCount_boardCounsel(WBoardCounselVo reqVo) {
        return (Integer) select(sqlMapNs_boardCounsel + "listCount", reqVo);
    }    

    @SuppressWarnings("unchecked")
    public List<WBoardCounselVo> getList_boardCounsel(WBoardCounselVo reqVo) {
        return (List<WBoardCounselVo>) super.list(sqlMapNs_boardCounsel + "getList", reqVo);
    }	
    
	@Override
	public WBoardCounselVo view_boardCounsel(WBoardCounselVo reqVo) {
		return (WBoardCounselVo)super.select(sqlMapNs_boardCounsel + "view", reqVo);
	}    
	
	@Override
	public void registration_boardCounsel(WBoardCounselVo reqVo) {
		super.update(sqlMapNs_boardCounsel + "actionRegistration", reqVo);
	}	
	
	@Override
	public void modify_boardCounsel(WBoardCounselVo reqVo) {
		super.update(sqlMapNs_boardCounsel + "actionModify", reqVo);
	}	
	
	@Override
	public void hitUpdate_boardCounsel(WBoardCounselVo reqVo) {
		super.update(sqlMapNs_boardCounsel + "hitUpdate", reqVo);
	}	
	
	@Override
	public void delete_boardCounsel(WBoardCounselVo reqVo) {
		super.update(sqlMapNs_boardCounsel + "delete", reqVo);
	}	
	
	
    // 내담자 관리
    public Integer listCount_counselee(WCounseleeVo reqVo) {
        return (Integer) select(sqlMapNs_counselee + "listCount_counselee", reqVo);
    }

    @SuppressWarnings("unchecked")
    public List<WCounseleeVo> getList_counselee(WCounseleeVo reqVo) {
        return (List<WCounseleeVo>) super.list(sqlMapNs_counselee + "getList_counselee", reqVo);
    }

	@Override
	public Integer victim_count(WCounselLogVo reqVo) {
		return (Integer) select(sqlMapNs_counselLogVictim + "count", reqVo);
	}

	@Override
	public void victim_actionReg(WCounselLogVo reqVo) {
		super.insert(sqlMapNs_counselLogVictim + "actionRegistration", reqVo);	
	}

	@Override
	public void victim_actionUpdate(WCounselLogVo reqVo) {
		super.update(sqlMapNs_counselLogVictim + "actionUpdate", reqVo);
	}

	@Override
	public Integer attacker_count(WCounselLogVo reqVo) {
		return (Integer) select(sqlMapNs_counselLogAttacker + "count", reqVo);
	}

	@Override
	public void attacker_actionReg(WCounselLogVo reqVo) {
		super.insert(sqlMapNs_counselLogAttacker + "actionRegistration", reqVo);
	}

	@Override
	public void attacker_actionUpdate(WCounselLogVo reqVo) {
		super.update(sqlMapNs_counselLogAttacker + "actionUpdate", reqVo);
	}

	@Override
	public void passwdInit_boardCounsel(WBoardCounselVo reqVo) {
		super.update(sqlMapNs_boardCounsel + "actionPasswdInit", reqVo);
	}

	@Override
	public void actionUpdYn(WCounselLogVo reqVo) {
		super.update(sqlMapNs_counselLog + "actionUpdYn", reqVo);	
	}

	@Override
	public String getUpdYn(WCounselLogVo reqVo) {
		return (String) select(sqlMapNs_counselLog + "getUpdYn", reqVo);
	}

	@Override
	public void actionUpdate2(WCounselLogVo reqVo) {
		super.update(sqlMapNs_counselLog + "actionUpdate2", reqVo);
	}

	// 구)채팅상담 이력
	public Integer listCount(WChatOldVo reqVo) {
		return (Integer) select(sqlMapNs_chatOld + "listCount", reqVo);
	}

	@SuppressWarnings("unchecked")
	public List<WChatOldVo> getList(WChatOldVo reqVo) {
		return (List<WChatOldVo>) super.list(sqlMapNs_chatOld + "getList", reqVo);
	}

	@Override
	public WChatOldVo view(WChatOldVo reqVo) {
		return (WChatOldVo)super.select(sqlMapNs_chatOld + "view", reqVo);
	}

	@Override
	public List<WBoardCounselVo> getFileList_boardCounsel(WBoardCounselVo reqVo) {
		return (List<WBoardCounselVo>) super.list(sqlMapNs_boardCounsel + "getFileList", reqVo);
	}

}
