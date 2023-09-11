package com.z5.zcms.security.SSO.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.security.SSO.domain.GinueSSOVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class GinueSSODAOImpl extends EgovComAbstractDAO implements GinueSSODAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "GinueSSO.";

	@Override
	public GinueSSOVO getUserInfoKF(GinueSSOVO ginueSSOVO) {
		return (GinueSSOVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getUserInfoKF", ginueSSOVO); 
	}
	
	@Override
	public GinueSSOVO getAdminInfoForGinue(GinueSSOVO ginueSSOVO) {
		return (GinueSSOVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getAdminInfoForGinue", ginueSSOVO); 
	}

	@Override
	public void insertSSOUser(GinueSSOVO ginueSSOVO) throws Exception {
		insert(sqlMapNs + "insertSSOUser",  ginueSSOVO);
	}
	
	@Override
	public void insertSSOAuthority(GinueSSOVO ginueSSOVO) throws Exception {
		insert(sqlMapNs + "insertSSOAuthority",  ginueSSOVO);
	}

	@Override
	public GinueSSOVO getUserInfoUserSSO(GinueSSOVO ginueSSOVO) throws Exception {
		return (GinueSSOVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getUserInfoUserSSO", ginueSSOVO); 
	}

	@Override
	public void updateSSOPassword(GinueSSOVO ginueSSOVO) throws Exception {
		update(sqlMapNs+"updateSSOPassword", ginueSSOVO);
	}

	@Override
	public void updateSSOPasswordNull(GinueSSOVO ginueSSOVO) throws Exception{
		update(sqlMapNs+"updateSSOPasswordNull", ginueSSOVO);
		
	}

	@Override
	public void deleteSSOAuthority(GinueSSOVO ginueSSOVO) throws Exception {
		delete(sqlMapNs+"deleteSSOAuthority", ginueSSOVO);
	}

	@Override
	public void deleteSSOUser(GinueSSOVO ginueSSOVO) throws Exception {
		delete(sqlMapNs+"deleteSSOUser", ginueSSOVO);
		
	}
	
}

