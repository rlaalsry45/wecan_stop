package com.z5.zcms.admsys.js.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import com.z5.zcms.admsys.js.service.ZjsService;
import com.z5.zcms.admsys.js.dao.ZjsDAO;
import com.z5.zcms.admsys.js.domain.ZjsVo;

@Transactional
@Service
public class ZjsServiceImpl extends AbstractServiceImpl implements ZjsService {

    @Autowired
    private ZjsDAO zjsDAO;
    
    public void insert(ZjsVo vo) throws Exception {
    	zjsDAO.insert(vo);
    }

    public void update(ZjsVo vo) throws Exception {
    	zjsDAO.update(vo);
    }

    public void delete(List<Integer> arrDeleteNo) throws Exception {
    	zjsDAO.delete(arrDeleteNo);
    }

    public ZjsVo selectbypk(ZjsVo vo) throws Exception {
    	ZjsVo resultVO = zjsDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

	public Integer listCount(ZjsVo vo) {
		return this.zjsDAO.listCount(vo);
	}

	public List<ZjsVo> getList(ZjsVo vo) {
		return this.zjsDAO.getlist(vo);
	}
	
	public List<ZjsVo> getListAll(ZjsVo vo) {
		return this.zjsDAO.getlistAll(vo);
	}

}
