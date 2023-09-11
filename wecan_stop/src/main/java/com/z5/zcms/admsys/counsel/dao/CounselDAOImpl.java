package com.z5.zcms.admsys.counsel.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.chat.domain.ChatVO;
import com.z5.zcms.admsys.counsel.domain.CounselVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class CounselDAOImpl extends EgovComAbstractDAO implements CounselDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "CounselDAO.";
	
	@Override
	public Integer insertCounsel(CounselVO counselVO) {
		return (Integer)insert(sqlMapNs+"insertCounsel",counselVO);
	}

	@Override
	public List<CounselVO> getCounselRelation(CounselVO counselVO) {
		return (List<CounselVO>)list(sqlMapNs+"getCounselRelation",counselVO);
	}

	@Override
	public List<CounselVO> getCounselAge(CounselVO counselVO) {
		return (List<CounselVO>)list(sqlMapNs+"getCounselAge",counselVO);
	}

	@Override
	public List<CounselVO> getCounselType(CounselVO counselVO) {
		return (List<CounselVO>)list(sqlMapNs+"getCounselType",counselVO);
	}

	@Override
	public List<CounselVO> getCounselTime(CounselVO counselVO) {
		return (List<CounselVO>)list(sqlMapNs+"getCounselTime",counselVO);
	}

	@Override
	public List<CounselVO> getCounselList(CounselVO counselVO) {
		return (List<CounselVO>)list(sqlMapNs+"getCounselList",counselVO);
	}

}
