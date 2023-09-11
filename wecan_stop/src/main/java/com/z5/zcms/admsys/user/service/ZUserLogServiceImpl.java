/**
 *
 */
package com.z5.zcms.admsys.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.user.dao.ZUserLogDAO;
import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.util.DataTable;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @author Administrator
 */

@Service
@Transactional
public class ZUserLogServiceImpl extends AbstractServiceImpl implements ZUserLogService {

    @Autowired
    private ZUserLogDAO zUserLogDAO;

    /**
     * MethodName : inserLog
     * ClassName  : ZUserLogService
     * Comment   :
     * 작성자    : 김문석
     * 작성일    : 2014. 1. 3. 오후 5:21:16
     *
     * @see com.z5.zcms.admsys.user.service.ZUserLogService#inserLog(com.z5.zcms.admsys.user.domain.ZUserVo)
     */
    @Override
    public void insertLog(ZUserVo zUserVo) throws Exception {
        // TODO ZUserLogDAO와 ZUserLogDAOImpl을 com.z5.zcms.admsys.user.dao 에 생성하여 작업할것
        this.zUserLogDAO.insertLog(zUserVo);
        // TODO zUserLog.xml을 zUser.xml과 동일 위치에 생성하여 작업할것
    }

    @Override
    public void updateUserMemo(ZUserVo zUserVo) throws Exception {
        // TODO Auto-generated method stub
        this.zUserLogDAO.updateUserMemo(zUserVo);

    }

    @Override
    public Integer selectUserid(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        return (Integer) this.zUserLogDAO.selectUserid(zUserVo);

    }

    @Override
    public Integer selectLoginCount(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        return (Integer) this.zUserLogDAO.selectLoginCount(zUserVo);

    }

    @Override
    public void updateCnt(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        this.zUserLogDAO.updateCnt(zUserVo);
    }

    @Override
    public List<ZUserVo> selectVisitLog(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        return this.zUserLogDAO.selectVisitLog(zUserVo);
    }

    @Override
    public List<ZUserVo> selectLog(ZUserVo zUserVo){
        return this.zUserLogDAO.selectLog(zUserVo);
    }

    @Override
    public void insertVisitLog(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        this.zUserLogDAO.insertVisitLog(zUserVo);

    }

    @Override
    public void updateVisitLog(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        this.zUserLogDAO.updateVisitLog(zUserVo);

    }

	@Override
    public Integer listWorkCount(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        return (Integer) this.zUserLogDAO.listWorkCount(zUserVo);

    }
    
    @Override
    public List<ZUserVo> selectWorkLog(ZUserVo zUserVo){
        return this.zUserLogDAO.selectWorkLog(zUserVo);
    }
    
    @Override 
    public List<ZUserVo> listExcelWork(ZUserVo zUserVo){
        return this.zUserLogDAO.listExcelWork(zUserVo);
    }
    
    @Override
    public Integer listCustCount(ZUserVo zUserVo) {
    	// TODO Auto-generated method stub
    	return (Integer) this.zUserLogDAO.listCustCount(zUserVo);
    	
    }
    
    @Override
    public List<ZUserVo> selectCustLog(ZUserVo zUserVo){
    	return this.zUserLogDAO.selectCustLog(zUserVo);
    }
    
    @Override
    public Integer listDownCount(ZUserVo zUserVo) {
    	// TODO Auto-generated method stub
    	return (Integer) this.zUserLogDAO.listDownCount(zUserVo);
    	
    }
    
    @Override
    public List<ZUserVo> selectDownLog(ZUserVo zUserVo){
    	return this.zUserLogDAO.selectDownLog(zUserVo);
    }
    
    @Override 
    public List<ZUserVo> listExcelCust(ZUserVo zUserVo){
    	return this.zUserLogDAO.listExcelCust(zUserVo);
    }
    
    @Override 
    public void insertCustLog(ZUserVo zUserVo) throws Exception{
    	this.zUserLogDAO.insertCustLog(zUserVo);
    }
    
    @Override 
	public void delete(DataTable dt) throws Exception{
		
    	ZUserVo zUserVo = new ZUserVo();
		List<Integer> intList = new ArrayList<Integer>();
		for (String delNo : dt.getValues("seq")) intList.add(Integer.valueOf(delNo));
		zUserVo.setArrDeleteNo(intList);
		zUserVo.setTablePrefix(dt.get("tablePrefix"));

		this.zUserLogDAO.delete(zUserVo);
	}
    
    @Override     
    public void batchDel(DataTable dt) throws Exception{
    	ZUserVo zUserVo = new ZUserVo();
		zUserVo.setTablePrefix(dt.get("tablePrefix"));
    	
    	this.zUserLogDAO.batchDel(zUserVo);
    }
    
    @SuppressWarnings("unchecked")
	@Override     
    public void searchDel(DataTable dt) throws Exception{
    	ZUserVo zUserVo = new ZUserVo();
		
    	List<Integer> intList = new ArrayList<Integer>();
		
		List<ZUserVo> list = (List<ZUserVo>) dt.getObject("list");
		
		for (int i = 0; i < list.size(); i++) {
			intList.add(list.get(i).getSeq());
		}
		zUserVo.setArrDeleteNo(intList);
    	zUserVo.setTablePrefix(dt.get("tablePrefix"));
    	
    	this.zUserLogDAO.batchDel(zUserVo);
    }
	
    @Override       
    public void downLog(DataTable dt) throws Exception{
    	ZUserVo zUserVo = new ZUserVo();  	
    	zUserVo.setDownid(dt.get("downid"));
    	zUserVo.setDownname(dt.get("downname"));
    	zUserVo.setDownip(dt.get("downip"));
    	zUserVo.setDevice(dt.get("device"));
    	zUserVo.setDownmenu(dt.get("downmenu"));
    	zUserVo.setDowndetail(dt.get("downdetail"));
    	zUserVo.setDownreason(dt.get("downreason"));
    	
    	this.zUserLogDAO.downLog(zUserVo);
    }
    
    @Override
	public String selectUseyn(ZUserVo zUserVo) {
		 return (String) this.zUserLogDAO.selectUseyn(zUserVo);
	}

	@Override
	public int chkPassDay(ZUserVo zUserVo) {
		
		return this.zUserLogDAO.chkPassDay(zUserVo);

	}

	@Override
	public void updatepassword(ZUserVo zUserVo) {
		this.zUserLogDAO.updatepassword(zUserVo);
		
	}
}