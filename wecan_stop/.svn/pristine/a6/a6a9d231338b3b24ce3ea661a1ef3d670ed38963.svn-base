package com.z5.zcms.frontsys.front.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.frontsys.front.domain.GovUserInfoVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class FrontCheckGovDAOImpl extends EgovComAbstractDAO implements FrontCheckGovDAO {
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "wCheckGov.";

	@Override
	public GovUserInfoVo checkGovFirstStep(String ORGANIZATION_ID) {
		return (GovUserInfoVo)super.select(sqlMapNs+"checkGovFirstStep", ORGANIZATION_ID);
	}
	
	

}
