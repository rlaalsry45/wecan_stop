package com.z5.zcms.security.SSO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.user.domain.ZUserVo;
import com.z5.zcms.security.SSO.dao.ZSSODAO;
import com.z5.zcms.security.SSO.domain.ZSSOVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class ZSSOServiceImpl extends AbstractServiceImpl implements ZSSOService{

	@Autowired
	private ZSSODAO zSSODAO;

	@Override
	public ZSSOVO getUserInfoKF(ZSSOVO zSSOVO) throws Exception {
		return (ZSSOVO)this.zSSODAO.getUserInfoKF(zSSOVO);
	}

	@Override
	public void insertSSOUser(ZSSOVO zSSOVO) throws Exception {
		this.zSSODAO.insertSSOUser(zSSOVO);
	}

	@Override
	public ZSSOVO getUserInfoUserSSO(ZSSOVO zSSOVO) throws Exception {
		return (ZSSOVO)this.zSSODAO.getUserInfoUserSSO(zSSOVO);
	}

	@Override
	public void updateSSOPassword(ZSSOVO zSSOVO) throws Exception {
		this.zSSODAO.updateSSOPassword(zSSOVO);
	}

	@Override
	public void updateSSOPasswordNull(ZSSOVO zSSOVO) {
		this.zSSODAO.updateSSOPasswordNull(zSSOVO);
		
	}
}


