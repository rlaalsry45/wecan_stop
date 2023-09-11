package com.z5.zcms.admsys.authority.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.authority.dao.ZAuthHierachyDAO;
import com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO;

@Service
public class ZAuthHierachyServiceImpl implements ZAuthHierachyServiec{
	
	@Autowired
    private ZAuthHierachyDAO zAuthHierachyDAO;

	@Override
	public Integer authListCount(ZAuthHierachyVO zAuthHierachyVO) {
		return this.zAuthHierachyDAO.authListCount(zAuthHierachyVO);
	}

	@Override
	public List<ZAuthHierachyVO> getAuthList(ZAuthHierachyVO zAuthHierachyVO) {
		return this.zAuthHierachyDAO.getAuthList(zAuthHierachyVO);
	}

	@Override
	public void authInsert(ZAuthHierachyVO zAuthHierachyVO) {
    	this.zAuthHierachyDAO.authInsert(zAuthHierachyVO);
	}

	@Override
	public void deleteAuth(List<Integer> authno) throws Exception{
    	this.zAuthHierachyDAO.deleteAuth(authno);
	}

	@Override
	public List<ZAuthHierachyVO> delCheck(List<Integer> authno) {
		return this.zAuthHierachyDAO.delCheck(authno);
	}

	@Override
	public Integer authduplicationch(ZAuthHierachyVO zAuthHierachyVO) {
		return this.zAuthHierachyDAO.authduplicationch(zAuthHierachyVO);
	}
	
}
