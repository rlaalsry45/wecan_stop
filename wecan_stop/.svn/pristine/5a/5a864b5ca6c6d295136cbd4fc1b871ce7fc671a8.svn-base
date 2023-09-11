package com.z5.zcms.admsys.authority.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.authority.domain.ZAuthHierachyVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZAuthHierachyDAOImpl extends EgovComAbstractDAO implements ZAuthHierachyDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZAuthHierachyDAO.";
	
	@Override
	public Integer authListCount(ZAuthHierachyVO zAuthHierachyVO) {
		return (Integer) super.selectByPk(sqlMapNs+"authListCount",zAuthHierachyVO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ZAuthHierachyVO> getAuthList(ZAuthHierachyVO zAuthHierachyVO) {
		return (List<ZAuthHierachyVO>) super.list(sqlMapNs+"getAuthList", zAuthHierachyVO);
	}

	@Override
	public void authInsert(ZAuthHierachyVO zAuthHierachyVO) {
		insert(sqlMapNs + "authInsert", zAuthHierachyVO);
	}

	@Override
	public void deleteAuth(List<Integer> authno) throws Exception{
		delete(sqlMapNs + "deleteAuth", authno);
	}

	@Override
	public List<ZAuthHierachyVO> delCheck(List<Integer> authno) {
		return (List<ZAuthHierachyVO>) super.list(sqlMapNs+"delCheck", authno);
	}

	@Override
	public Integer authduplicationch(ZAuthHierachyVO zAuthHierachyVO) {
		return (Integer) super.selectByPk(sqlMapNs+"authduplicationch",zAuthHierachyVO);
	}

}
