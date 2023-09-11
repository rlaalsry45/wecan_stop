package com.z5.zcms.admsys.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.main.dao.ZmainDAO;
import com.z5.zcms.admsys.main.domain.ZmainVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class ZmainServiceImpl extends AbstractServiceImpl implements ZmainService {

    @Autowired
    private ZmainDAO zmainDAO;
    
    public void insert(ZmainVo vo) throws Exception {
    	zmainDAO.insert(vo);
    }

    public void update(ZmainVo vo) throws Exception {
    	zmainDAO.update(vo);
    }

    public void delete(List<Integer> arrDeleteNo) throws Exception {
    	zmainDAO.delete(arrDeleteNo);
    }

    public ZmainVo selectbypk(ZmainVo vo) throws Exception {
    	ZmainVo resultVO = zmainDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
    
    public ZmainVo selectbyfk(ZmainVo vo) throws Exception {
    	ZmainVo resultVO = zmainDAO.selectbyfk(vo);
    	return resultVO;
    }

	public Integer listCount(ZmainVo vo) {
		return this.zmainDAO.listCount(vo);
	}

	public List<ZmainVo> getList(ZmainVo vo) {
		return this.zmainDAO.getlist(vo);
	}
	
	public List<ZmainVo> getListAll(ZmainVo vo) {
		return this.zmainDAO.getlistAll(vo);
	}
	
	public List<ZmainVo> getListCfg(ZmainVo vo) {
		return this.zmainDAO.getlistCfg(vo);
	}
	
    public void updatesiteno(ZmainVo vo) throws Exception {
    	zmainDAO.updatesiteno(vo);
    }
    
    public void updatesitetitle(ZmainVo vo) throws Exception {
    	zmainDAO.updatesitetitle(vo);
    }

	public ZmainVo getMaxno(ZmainVo vo) {
		return (ZmainVo)zmainDAO.getMaxno(vo);
		
	}

	public int getMaxMainno(int mainno) throws Exception {
		return zmainDAO.getMaxMainno(mainno);
	}

}
