package com.z5.zcms.admsys.counsel.service;

import java.util.List;

import com.z5.zcms.admsys.counsel.domain.CounselVO;

public interface CounselService {

	public Integer insertCounsel(CounselVO counselVO);

	public CounselVO getMonthChatCounsel(CounselVO counselVO);
	public CounselVO getMonthBoardCounsel(CounselVO counselVO);
	public CounselVO getMonthKakaotalkCounsel(CounselVO counselVO);
	public CounselVO getMonthCounsel(CounselVO counselVO);
	public CounselVO getYearChatCounsel(CounselVO counselVO);
	public CounselVO getYearBoardCounsel(CounselVO counselVO);
	public CounselVO getYearKakaotalkCounsel(CounselVO counselVO);
	public CounselVO getYearCounsel(CounselVO counselVO);	
	public CounselVO getCounselRelation(CounselVO counselVO);
	public CounselVO getCounselNat01Relation(CounselVO counselVO);
	public CounselVO getCounselNat02Relation(CounselVO counselVO);
	public CounselVO getCounselCou01Relation(CounselVO counselVO);
	public CounselVO getCounselCou02Relation(CounselVO counselVO);
	public CounselVO getCounselCou03Relation(CounselVO counselVO);
	public CounselVO getCounselChannel(CounselVO counselVO);
	public CounselVO getCounselNat01Channel(CounselVO counselVO);
	public CounselVO getCounselNat02Channel(CounselVO counselVO);
	public CounselVO getCounselType(CounselVO counselVO);
	public CounselVO getCounselNat01Type(CounselVO counselVO);
	public CounselVO getCounselNat02Type(CounselVO counselVO);
	public CounselVO getCounselCou01Type(CounselVO counselVO);
	public CounselVO getCounselCou02Type(CounselVO counselVO);
	public CounselVO getCounselCou03Type(CounselVO counselVO);
	public CounselVO getCounselRegion(CounselVO counselVO);
	public CounselVO getCounselCou01Region(CounselVO counselVO);
	public CounselVO getCounselCou02Region(CounselVO counselVO);
	public CounselVO getCounselCou03Region(CounselVO counselVO);
	public CounselVO getCounselTime(CounselVO counselVO);
	public CounselVO getCounselCou01Time(CounselVO counselVO);
	public CounselVO getCounselCou02Time(CounselVO counselVO);
	public CounselVO getCounselCou03Time(CounselVO counselVO);
	public CounselVO getCounselAge(CounselVO counselVO);
	public CounselVO getCounselCou01Age(CounselVO counselVO);
	public CounselVO getCounselCou02Age(CounselVO counselVO);
	public CounselVO getCounselCou03Age(CounselVO counselVO);
	public CounselVO getCounselGender(CounselVO counselVO);
	public CounselVO getCounselCou01Gender(CounselVO counselVO);
	public CounselVO getCounselCou02Gender(CounselVO counselVO);
	public CounselVO getCounselCou03Gender(CounselVO counselVO);
	
}
