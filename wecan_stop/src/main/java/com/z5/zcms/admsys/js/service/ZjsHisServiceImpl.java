package com.z5.zcms.admsys.js.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.js.dao.ZjsHisDAO;
import com.z5.zcms.admsys.js.domain.ZjsHisVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;


import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZjsHisServiceImpl  extends AbstractServiceImpl implements ZjsHisService{
	
	@Autowired
    private ZjsHisDAO zjsHisDAO;
	
	public List<ZjsHisVo> getList(ZjsHisVo vo) {
		return this.zjsHisDAO.getlist(vo);
	}
	
	public void insert(ZjsHisVo vo) throws Exception {
    	//log.debug(vo.toString());
    	zjsHisDAO.insert(vo);
    }

	public ZjsVo selectbypk(ZjsHisVo vo) throws Exception {
		ZjsVo resultVO = zjsHisDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
	
	public void delete(ZjsHisVo vo) throws Exception{
		zjsHisDAO.delete(vo);
	}
	
}
