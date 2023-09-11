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
	public CounselVO getMonthChatCounsel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getMonthChatCounsel",counselVO);
	}

	@Override
	public CounselVO getMonthBoardCounsel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getMonthBoardCounsel",counselVO);
	}

	@Override
	public CounselVO getMonthKakaotalkCounsel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getMonthKakaotalkCounsel",counselVO);
	}

	@Override
	public CounselVO getMonthCounsel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getMonthCounsel",counselVO);
	}

	@Override
	public CounselVO getYearChatCounsel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getYearChatCounsel",counselVO);
	}

	@Override
	public CounselVO getYearBoardCounsel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getYearBoardCounsel",counselVO);
	}

	@Override
	public CounselVO getYearKakaotalkCounsel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getYearKakaotalkCounsel",counselVO);
	}

	@Override
	public CounselVO getYearCounsel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getYearCounsel",counselVO);
	}

	@Override
	public CounselVO getCounselRelation(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselRelation",counselVO);
	}

	@Override
	public CounselVO getCounselNat01Relation(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselNat01Relation",counselVO);
	}

	@Override
	public CounselVO getCounselNat02Relation(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselNat02Relation",counselVO);
	}

	@Override
	public CounselVO getCounselCou01Relation(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou01Relation",counselVO);
	}

	@Override
	public CounselVO getCounselCou02Relation(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou02Relation",counselVO);
	}

	@Override
	public CounselVO getCounselCou03Relation(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou03Relation",counselVO);
	}

	@Override
	public CounselVO getCounselChannel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselChannel",counselVO);
	}

	@Override
	public CounselVO getCounselNat01Channel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselNat01Channel",counselVO);
	}

	@Override
	public CounselVO getCounselNat02Channel(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselNat02Channel",counselVO);
	}

	@Override
	public CounselVO getCounselType(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselType",counselVO);
	}

	@Override
	public CounselVO getCounselNat01Type(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselNat01Type",counselVO);
	}

	@Override
	public CounselVO getCounselNat02Type(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselNat02Type",counselVO);
	}

	@Override
	public CounselVO getCounselCou01Type(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou01Type",counselVO);
	}

	@Override
	public CounselVO getCounselCou02Type(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou02Type",counselVO);
	}

	@Override
	public CounselVO getCounselCou03Type(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou03Type",counselVO);
	}

	@Override
	public CounselVO getCounselRegion(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselRegion",counselVO);
	}

	@Override
	public CounselVO getCounselCou01Region(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou01Region",counselVO);
	}

	@Override
	public CounselVO getCounselCou02Region(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou02Region",counselVO);
	}

	@Override
	public CounselVO getCounselCou03Region(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou03Region",counselVO);
	}

	@Override
	public CounselVO getCounselTime(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselTime",counselVO);
	}

	@Override
	public CounselVO getCounselCou01Time(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou01Time",counselVO);
	}

	@Override
	public CounselVO getCounselCou02Time(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou02Time",counselVO);
	}

	@Override
	public CounselVO getCounselCou03Time(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou03Time",counselVO);
	}

	@Override
	public CounselVO getCounselAge(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselAge",counselVO);
	}

	@Override
	public CounselVO getCounselCou01Age(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou01Age",counselVO);
	}

	@Override
	public CounselVO getCounselCou02Age(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou02Age",counselVO);
	}

	@Override
	public CounselVO getCounselCou03Age(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou03Age",counselVO);
	}

	@Override
	public CounselVO getCounselGender(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselGender",counselVO);
	}

	@Override
	public CounselVO getCounselCou01Gender(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou01Gender",counselVO);
	}

	@Override
	public CounselVO getCounselCou02Gender(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou02Gender",counselVO);
	}

	@Override
	public CounselVO getCounselCou03Gender(CounselVO counselVO) {
		return (CounselVO)select(sqlMapNs+"getCounselCou03Gender",counselVO);
	}
}
