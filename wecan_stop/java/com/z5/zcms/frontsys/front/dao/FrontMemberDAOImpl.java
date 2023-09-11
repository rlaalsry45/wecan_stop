package com.z5.zcms.frontsys.front.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.frontsys.front.domain.FrontMemberVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class FrontMemberDAOImpl extends EgovComAbstractDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "Haksa.";
	
	public FrontMemberVo haksaLogin(FrontMemberVo vo){
        return (FrontMemberVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"login", vo); 
    }


}
