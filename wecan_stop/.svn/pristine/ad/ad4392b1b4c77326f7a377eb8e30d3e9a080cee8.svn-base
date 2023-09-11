package com.z5.zcms.admsys.cyberCounsel.dao;

import com.z5.zcms.admsys.cyberCounsel.domain.WBoardCounselVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselLogVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WCounselReviewVo;
import com.z5.zcms.admsys.cyberCounsel.domain.WFamilyViolenceVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.admsys.user.domain.SearchUser;
import com.z5.zcms.frontsys.front.domain.MenuStaffVO;
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
	public void registration(WCounselLogVo reqVo) {
		super.insert(sqlMapNs_counselLog + "actionRegistration", reqVo);
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
	public void hitUpdate_boardCounsel(WBoardCounselVo reqVo) {
		super.update(sqlMapNs_boardCounsel + "hitUpdate", reqVo);
	}	
	
	@Override
	public void delete_boardCounsel(WBoardCounselVo reqVo) {
		super.update(sqlMapNs_boardCounsel + "delete", reqVo);
	}	

}
