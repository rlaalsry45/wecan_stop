package com.z5.zcms.admsys.css.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.css.dao.ZcssHisDAO;
import com.z5.zcms.admsys.css.domain.ZcssHisVo;
import com.z5.zcms.admsys.css.domain.ZcssVo;


import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZcssHisServiceImpl  extends AbstractServiceImpl implements ZcssHisService{
	
	@Autowired
    private ZcssHisDAO zcssHisDAO;
	
	public List<ZcssHisVo> getList(ZcssHisVo vo) {
		return this.zcssHisDAO.getlist(vo);
	}
	
	public void insert(ZcssHisVo vo) throws Exception {
    	//log.debug(vo.toString());
    	zcssHisDAO.insert(vo);
    }

	public ZcssVo selectbypk(ZcssHisVo vo) throws Exception {
		ZcssVo resultVO = zcssHisDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
	
	public void delete(ZcssHisVo vo) throws Exception{
		zcssHisDAO.delete(vo);
	}
	
}
