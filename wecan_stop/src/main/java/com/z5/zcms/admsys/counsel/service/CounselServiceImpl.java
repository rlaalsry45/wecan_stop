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
	public List<CounselVO> getCounselRelation(CounselVO counselVO) {
		return (List<CounselVO>) counselDAO.getCounselRelation(counselVO);
	}

	@Override
	public List<CounselVO> getCounselAge(CounselVO counselVO) {
		return (List<CounselVO>) counselDAO.getCounselAge(counselVO);
	}

	@Override
	public List<CounselVO> getCounselType(CounselVO counselVO) {
		return (List<CounselVO>) counselDAO.getCounselType(counselVO);
	}

	@Override
	public List<CounselVO> getCounselTime(CounselVO counselVO) {
		return (List<CounselVO>) counselDAO.getCounselTime(counselVO);
	}

	@Override
	public List<CounselVO> getCounselList(CounselVO counselVO) {
		return (List<CounselVO>) counselDAO.getCounselList(counselVO);
	}
	
}
