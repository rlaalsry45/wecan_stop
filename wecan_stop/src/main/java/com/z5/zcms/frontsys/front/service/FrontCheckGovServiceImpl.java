package com.z5.zcms.frontsys.front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.frontsys.front.dao.FrontCheckGovDAO;
import com.z5.zcms.frontsys.front.domain.GovUserInfoVo;

@Service
public class FrontCheckGovServiceImpl implements FrontCheckGovService {

	@Autowired
	private FrontCheckGovDAO frontCheckGovDAO; 
	
	@Override
	public GovUserInfoVo checkGovFirstStep(String ORGANIZATION_ID) {
		return frontCheckGovDAO.checkGovFirstStep(ORGANIZATION_ID);
	}	

}
