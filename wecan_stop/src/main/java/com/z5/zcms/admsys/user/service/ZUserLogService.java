/**
 *
 */
package com.z5.zcms.admsys.user.service;

import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.DataTable;

import java.util.List;

/**
 * @author 김문석
 */
public interface ZUserLogService {

    /**
     * MethodName : inserLog
     * ClassName  : ZUserLogService
     * Comment   :
     * 작성자    : 김문석
     * 작성일    : 2014. 1. 3. 오후 5:13:50
     */
    void insertLog(ZUserVo zUserVo) throws Exception;

    void updateUserMemo(ZUserVo zUserVo) throws Exception;

    Integer selectUserid(ZUserVo zUserVo);

    void updateCnt(ZUserVo zUserVo) throws Exception;

    Integer selectLoginCount(ZUserVo zUserVo);

    List<ZUserVo> selectVisitLog(ZUserVo zUserVo) throws Exception;

    List<ZUserVo> selectLog(ZUserVo zUserVo);

    void insertVisitLog(ZUserVo zUserVo) throws Exception;

    void updateVisitLog(ZUserVo zUserVo) throws Exception;
	
	Integer listWorkCount(ZUserVo zUserVo);
    
    List<ZUserVo> selectWorkLog(ZUserVo zUserVo);
    
    List<ZUserVo> listExcelWork(ZUserVo zUserVo);
    
    Integer listCustCount(ZUserVo zUserVo);
    
    List<ZUserVo> selectCustLog(ZUserVo zUserVo);
    
    public Integer listDownCount(ZUserVo zUserVo);
    
    public List<ZUserVo> selectDownLog(ZUserVo zUserVo);
    
    List<ZUserVo> listExcelCust(ZUserVo zUserVo);
    
    public void insertCustLog(ZUserVo zUserVo) throws Exception;
    
    public void delete(DataTable dt) throws Exception;
    
    public void batchDel(DataTable dt) throws Exception;
    
    public void searchDel(DataTable dt) throws Exception;
    
    public void downLog(DataTable dt) throws Exception;
    
    String selectUseyn(ZUserVo zUserVo);
    
    public int chkPassDay(ZUserVo zUserVo);
    
    public void updatepassword(ZUserVo zUserVo);
    
}