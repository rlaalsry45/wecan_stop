package com.z5.zcms.admsys.user.dao;

import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;

import java.util.List;

public interface ZUserLogDAO {

    void insertLog(ZUserVo zUserVo);

    void updateUserMemo(ZUserVo zUserVo);

    Integer selectUserid(ZUserVo zUserVo);

    void updateCnt(ZUserVo zUserVo);

    Integer selectLoginCount(ZUserVo zUserVo);

    List<ZUserVo> selectVisitLog(ZUserVo zUserVo);

    List<ZUserVo> selectLog(ZUserVo zUserVo);

    void insertVisitLog(ZUserVo zUserVo);

    void updateVisitLog(ZUserVo zUserVo);

	Integer listWorkCount(ZUserVo zUserVo);
	
	List<ZUserVo> selectWorkLog(ZUserVo zUserVo);
	
	List<ZUserVo> listExcelWork(ZUserVo zUserVo);
	
	Integer listCustCount(ZUserVo zUserVo);
	
	List<ZUserVo> selectCustLog(ZUserVo zUserVo);
	
	Integer listDownCount(ZUserVo zUserVo);
	
	List<ZUserVo> selectDownLog(ZUserVo zUserVo);
	
	List<ZUserVo> listExcelCust(ZUserVo zUserVo);
	
	public List<ZmenuVo> getlist(ZmenuVo zmenuVo);
	
	void insertCustLog(ZUserVo zUserVo);
	
	public void delete(ZUserVo zUserVo);
	
	public void batchDel(ZUserVo zUserVo);
	
	public void downLog(ZUserVo zUserVo);
	
	String selectUseyn(ZUserVo zUserVo);
	
}
