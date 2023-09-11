package com.z5.zcms.admsys.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.menu.domain.ZmenuVo;
import com.z5.zcms.admsys.user.domain.ZUserVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZUserLogDaoImpl extends EgovComAbstractDAO implements ZUserLogDAO {

    private final String sqlMapNs = "ZUserLog.";

    @Override
    public void insertLog(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        super.insert(sqlMapNs + "insertLog", zUserVo);
    }

    @Override
    public void updateUserMemo(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        super.update(sqlMapNs + "updateUserMemo", zUserVo);
    }

    @Override
    public Integer selectUserid(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        //super.select(sqlMapNs+"selectUserid", zUserVo);
        return (Integer) super.selectByPk(sqlMapNs + "selectUserid", zUserVo);
    }

    @Override
    public Integer selectLoginCount(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        //super.select(sqlMapNs+"selectUserid", zUserVo);
        return (Integer) super.selectByPk(sqlMapNs + "selectLoginCount", zUserVo);
    }

    @Override
    public void updateCnt(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        super.update(sqlMapNs + "updateCnt", zUserVo);
    }


    @SuppressWarnings("unchecked")
    public List<ZUserVo> selectVisitLog(ZUserVo zUserVo) {
        return (List<ZUserVo>)super.list(sqlMapNs + "selectVisitLog", zUserVo);
    }

    @Override
    public List<ZUserVo> selectLog(ZUserVo zUserVo) {
        return (List<ZUserVo>)super.list(sqlMapNs + "selectLog", zUserVo);
    }

    @Override
    public void insertVisitLog(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        super.insert(sqlMapNs + "insertVisitLog", zUserVo);
    }

    @Override
    public void updateVisitLog(ZUserVo zUserVo) {
        // TODO Auto-generated method stub
        super.update(sqlMapNs + "updateVisitLog", zUserVo);
    }

	@Override
	public Integer listWorkCount(ZUserVo zUserVo) {
		// TODO Auto-generated method stub
		//super.select(sqlMapNs+"selectUserid", zUserVo);
		return (Integer) super.selectByPk(sqlMapNs + "listWorkCount", zUserVo);
	}

	@Override
	public List<ZUserVo> selectWorkLog(ZUserVo zUserVo) {
		return (List<ZUserVo>)super.list(sqlMapNs + "selectWorkLog", zUserVo);
	}

	@Override
	public List<ZUserVo> listExcelWork(ZUserVo zUserVo) {
		return (List<ZUserVo>)super.list(sqlMapNs + "listExcelWork", zUserVo);
	}
	
	@Override
	public Integer listCustCount(ZUserVo zUserVo) {
		// TODO Auto-generated method stub
		//super.select(sqlMapNs+"selectUserid", zUserVo);
		return (Integer) super.selectByPk(sqlMapNs + "listCustCount", zUserVo);
	}
	
	@Override
	public List<ZUserVo> selectCustLog(ZUserVo zUserVo) {
		return (List<ZUserVo>)super.list(sqlMapNs + "selectCustLog", zUserVo);
	}
	
	@Override
	public Integer listDownCount(ZUserVo zUserVo) {
		// TODO Auto-generated method stub
		return (Integer) super.selectByPk(sqlMapNs + "listDownCount", zUserVo);
	}
	
	@Override
	public List<ZUserVo> selectDownLog(ZUserVo zUserVo) {
		return (List<ZUserVo>)super.list(sqlMapNs + "selectDownLog", zUserVo);
	}
	
	@Override
	public List<ZUserVo> listExcelCust(ZUserVo zUserVo) {
		return (List<ZUserVo>)super.list(sqlMapNs + "listExcelCust", zUserVo);
	}

	@SuppressWarnings("unchecked")
	public List<ZmenuVo> getlist(ZmenuVo zmenuVo) {
		return (List<ZmenuVo>)super.list(sqlMapNs+"getlist", zmenuVo);
	}

    @Override
    public void insertCustLog(ZUserVo zUserVo) {
        super.insert(sqlMapNs + "insertCustLog", zUserVo);
    }
    
    @Override
    public void delete(ZUserVo zUserVo) {
    	super.delete(sqlMapNs + "delete", zUserVo);
    }
    
    @Override
	public void batchDel(ZUserVo zUserVo) {
    	super.delete(sqlMapNs + "batchDel", zUserVo);
	}
    
    @Override
    public void downLog(ZUserVo zUserVo) {
    	super.insert(sqlMapNs + "downLog", zUserVo);
    }

	@Override
	public String selectUseyn(ZUserVo zUserVo) {
		 return (String) super.selectByPk(sqlMapNs + "selectUseyn", zUserVo);
	}
}