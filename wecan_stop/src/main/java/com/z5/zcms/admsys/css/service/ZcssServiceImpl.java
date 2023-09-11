package com.z5.zcms.admsys.css.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import com.z5.zcms.admsys.css.service.ZcssService;
import com.z5.zcms.admsys.css.dao.ZcssDAO;
import com.z5.zcms.admsys.css.domain.ZcssVo;

@Transactional
@Service
public class ZcssServiceImpl extends AbstractServiceImpl implements ZcssService {

    @Autowired
    private ZcssDAO zcssDAO;
    
    public void insert(ZcssVo vo) throws Exception {
    	//log.debug(vo.toString());
    	zcssDAO.insert(vo);
    }

    public void update(ZcssVo vo) throws Exception {
    	zcssDAO.update(vo);
    }

    public void delete(List<Integer> arrDeleteNo) throws Exception {
    	zcssDAO.delete(arrDeleteNo);
    }

    public ZcssVo selectbypk(ZcssVo vo) throws Exception {
    	ZcssVo resultVO = zcssDAO.selectbypk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

	public Integer listCount(ZcssVo vo) {
		return this.zcssDAO.listCount(vo);
	}

	public List<ZcssVo> getList(ZcssVo vo) {
		return this.zcssDAO.getlist(vo);
	}
	
	public List<ZcssVo> getListAll(ZcssVo vo) {
		return this.zcssDAO.getlistAll(vo);
	}
	
	public List<ZcssVo> getListAllForUpdate(ZcssVo vo) {
		return this.zcssDAO.getListAllForUpdate(vo);
	}
    
}
