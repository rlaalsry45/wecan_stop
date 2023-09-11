package com.z5.zcms.frontsys.archv.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.frontsys.archv.domain.ArchvOpt;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ArchvOptDAOImpl extends EgovComAbstractDAO implements ArchvOptDAO {

	private final String sqlNS = "ArchvOpt.";

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvOpt> list() throws Exception {
		return this.getSqlMapClientTemplate().queryForList(sqlNS + "list");
	}

}
