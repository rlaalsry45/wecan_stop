package com.z5.zcms.admsys.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.main.dao.ZmainHisDAO;
import com.z5.zcms.admsys.main.domain.ZmainHisVo;
import com.z5.zcms.admsys.main.domain.ZmainVo;


import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZmainHisServiceImpl  extends AbstractServiceImpl implements ZmainHisService{
	
	@Autowired
    private ZmainHisDAO zmainHisDAO;
	
	public List<ZmainHisVo> getList(ZmainHisVo vo) {
		return this.zmainHisDAO.getlist(vo);
	}
	
	public void insert(ZmainHisVo vo) throws Exception {
    	zmainHisDAO.insert(vo);
    }

	public ZmainVo selectbypk(ZmainHisVo vo) throws Exception {
		ZmainVo resultVO = zmainHisDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
	
	public void delete(ZmainHisVo vo) throws Exception{
		zmainHisDAO.delete(vo);
	}
	
}
