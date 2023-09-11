package com.z5.zcms.admsys.tpl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.tpl.dao.ZtplHisDAO;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.admsys.tpl.domain.ZtplHisVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZtplHisServiceImpl  extends AbstractServiceImpl implements ZtplHisService{
	
	@Autowired
    private ZtplHisDAO ztplHisDAO;
	
	public List<ZtplHisVo> getList(ZtplHisVo vo) {
		return this.ztplHisDAO.getlist(vo);
	}
	
	public void insert(ZtplHisVo vo) throws Exception {
    	ztplHisDAO.insert(vo);
    }

	public ZtplVo selectbypk(ZtplHisVo vo) throws Exception {
		ZtplVo resultVO = ztplHisDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
	
	public void delete(ZtplHisVo vo) throws Exception{
		ztplHisDAO.delete(vo);
	}
}
