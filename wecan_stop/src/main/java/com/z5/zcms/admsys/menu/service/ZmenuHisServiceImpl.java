package com.z5.zcms.admsys.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.menu.dao.ZmenuHisDAO;
import com.z5.zcms.admsys.menu.domain.ZmenuHisVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZmenuHisServiceImpl  extends AbstractServiceImpl implements ZmenuHisService{
	
	@Autowired
    private ZmenuHisDAO zmenuHisDAO;
	
	public List<ZmenuHisVo> getList(ZmenuHisVo vo) {
		return this.zmenuHisDAO.getlist(vo);
	}
	
	public void insert(ZmenuHisVo vo) throws Exception {
    	zmenuHisDAO.insert(vo);
    }

	public ZmenuVo selectbypk(ZmenuHisVo vo) throws Exception {
		ZmenuVo resultVO = zmenuHisDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
	
	public List<ZmenuHisVo> getHisListbySitenoAndMenuno(ZmenuHisVo vo) throws Exception {
		return this.zmenuHisDAO.getHisListbySitenoAndMenuno(vo);
    }
	
	public void delete(ZmenuHisVo vo) throws Exception{
		zmenuHisDAO.delete(vo);
	}
	
	public void deleteAll(List<String> vo)  throws Exception{
		zmenuHisDAO.deleteAll(vo);
	}
	
	
	public void deleteMenuWithSiteno(ZmenuHisVo vo) {
		zmenuHisDAO.deleteMenuWithSiteno(vo);
	}
	
}
