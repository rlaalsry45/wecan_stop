package com.z5.zcms.security.SSO.dao;

import com.z5.zcms.security.SSO.domain.ZSSOVO;

public interface ZSSODAO {

	ZSSOVO getUserInfoKF(ZSSOVO zSSOVO) throws Exception;

	void insertSSOUser(ZSSOVO zSSOVO) throws Exception;

	ZSSOVO getUserInfoUserSSO(ZSSOVO zSSOVO) throws Exception;

	void updateSSOPassword(ZSSOVO zSSOVO) throws Exception;

	void updateSSOPasswordNull(ZSSOVO zSSOVO);
	
}
