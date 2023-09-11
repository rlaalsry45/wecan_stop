package com.z5.zcms.security.SSO.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.security.SSO.domain.ZSSOVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZSSODAOImpl extends EgovComAbstractDAO implements ZSSODAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZSSO.";

	@Override
	public ZSSOVO getUserInfoKF(ZSSOVO zSSOVO) {
		return (ZSSOVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getUserInfoKF", zSSOVO); 
	}

	@Override
	public void insertSSOUser(ZSSOVO zSSOVO) throws Exception {
		insert(sqlMapNs + "insertSSOUser",  zSSOVO);
	}

	@Override
	public ZSSOVO getUserInfoUserSSO(ZSSOVO zSSOVO) throws Exception {
		return (ZSSOVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getUserInfoUserSSO", zSSOVO); 
	}

	@Override
	public void updateSSOPassword(ZSSOVO zSSOVO) throws Exception {
		update(sqlMapNs+"updateSSOPassword", zSSOVO);
	}

	@Override
	public void updateSSOPasswordNull(ZSSOVO zSSOVO) {
		update(sqlMapNs+"updateSSOPasswordNull", zSSOVO);
		
	}
	
}

