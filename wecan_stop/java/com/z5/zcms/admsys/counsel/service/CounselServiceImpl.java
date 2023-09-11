package com.z5.zcms.admsys.counsel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.counsel.dao.CounselDAO;
import com.z5.zcms.admsys.counsel.domain.CounselVO;

@Service
public class CounselServiceImpl implements CounselService{
	
	@Autowired
    private CounselDAO counselDAO;

	@Override
	public Integer insertCounsel(CounselVO counselVO) {
		return counselDAO.insertCounsel(counselVO);
	}
	
	@Override
	public CounselVO getMonthChatCounsel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getMonthChatCounsel(counselVO);
	}

	@Override
	public CounselVO getMonthBoardCounsel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getMonthBoardCounsel(counselVO);
	}

	@Override
	public CounselVO getMonthKakaotalkCounsel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getMonthKakaotalkCounsel(counselVO);
	}

	@Override
	public CounselVO getMonthCounsel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getMonthCounsel(counselVO);
	}

	@Override
	public CounselVO getYearChatCounsel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getYearChatCounsel(counselVO);
	}

	@Override
	public CounselVO getYearBoardCounsel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getYearBoardCounsel(counselVO);
	}

	@Override
	public CounselVO getYearKakaotalkCounsel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getYearKakaotalkCounsel(counselVO);
	}

	@Override
	public CounselVO getYearCounsel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getYearCounsel(counselVO);
	}

	@Override
	public CounselVO getCounselRelation(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselRelation(counselVO);
	}

	@Override
	public CounselVO getCounselNat01Relation(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselNat01Relation(counselVO);
	}

	@Override
	public CounselVO getCounselNat02Relation(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselNat02Relation(counselVO);
	}

	@Override
	public CounselVO getCounselCou01Relation(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou01Relation(counselVO);
	}

	@Override
	public CounselVO getCounselCou02Relation(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou02Relation(counselVO);
	}

	@Override
	public CounselVO getCounselCou03Relation(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou03Relation(counselVO);
	}

	@Override
	public CounselVO getCounselChannel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselChannel(counselVO);
	}

	@Override
	public CounselVO getCounselNat01Channel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselNat01Channel(counselVO);
	}

	@Override
	public CounselVO getCounselNat02Channel(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselNat02Channel(counselVO);
	}

	@Override
	public CounselVO getCounselType(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselType(counselVO);
	}

	@Override
	public CounselVO getCounselNat01Type(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselNat01Type(counselVO);
	}

	@Override
	public CounselVO getCounselNat02Type(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselNat02Type(counselVO);
	}

	@Override
	public CounselVO getCounselCou01Type(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou01Type(counselVO);
	}

	@Override
	public CounselVO getCounselCou02Type(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou02Type(counselVO);
	}

	@Override
	public CounselVO getCounselCou03Type(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou03Type(counselVO);
	}

	@Override
	public CounselVO getCounselRegion(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselRegion(counselVO);
	}

	@Override
	public CounselVO getCounselCou01Region(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou01Region(counselVO);
	}

	@Override
	public CounselVO getCounselCou02Region(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou02Region(counselVO);
	}

	@Override
	public CounselVO getCounselCou03Region(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou03Region(counselVO);
	}

	@Override
	public CounselVO getCounselTime(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselTime(counselVO);
	}

	@Override
	public CounselVO getCounselCou01Time(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou01Time(counselVO);
	}

	@Override
	public CounselVO getCounselCou02Time(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou02Time(counselVO);
	}

	@Override
	public CounselVO getCounselCou03Time(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou03Time(counselVO);
	}

	@Override
	public CounselVO getCounselAge(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselAge(counselVO);
	}
	
	@Override
	public CounselVO getCounselCou01Age(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou01Age(counselVO);
	}

	@Override
	public CounselVO getCounselCou02Age(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou02Age(counselVO);
	}

	@Override
	public CounselVO getCounselCou03Age(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou03Age(counselVO);
	}

	@Override
	public CounselVO getCounselGender(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselGender(counselVO);
	}

	@Override
	public CounselVO getCounselCou01Gender(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou01Gender(counselVO);
	}

	@Override
	public CounselVO getCounselCou02Gender(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou02Gender(counselVO);
	}

	@Override
	public CounselVO getCounselCou03Gender(CounselVO counselVO) {
		return (CounselVO) counselDAO.getCounselCou03Gender(counselVO);
	}
	
}
