package com.z5.zcms.admsys.counsel.dao;

import java.util.List;

import com.z5.zcms.admsys.counsel.domain.CounselVO;

public interface CounselDAO {

	public Integer insertCounsel(CounselVO counselVO);
	public List<CounselVO> getCounselRelation(CounselVO counselVO);
	public List<CounselVO> getCounselAge(CounselVO counselVO);
	public List<CounselVO> getCounselType(CounselVO counselVO);
	public List<CounselVO> getCounselTime(CounselVO counselVO);
	public List<CounselVO> getCounselList(CounselVO counselVO);
}
