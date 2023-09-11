package com.z5.zcms.admsys.archv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.frontsys.archv.dao.ArchvCatgryDAO;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgry;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvLangOpt;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
@Transactional
public class ArchvCatgryServiceImpl extends EgovAbstractServiceImpl implements ArchvCatgryService {

	@Autowired
	ArchvCatgryDAO archvCatgryDAO;

	public List<ArchvCatgry> list(ArchvCatgry archvCatgry) throws Exception {
		return this.archvCatgryDAO.list(archvCatgry);
	}

	@Override
	public int create(ArchvCatgry archvCatgry) throws Exception {

		ArchvCatgryVO a	= this.archvCatgryDAO.getNamePath(archvCatgry.getPrnt_catgry_cd());
		String[] b		= a.getPath().split("/");
		//String c		= EgovProperties.getPathProperty("Globals.archive.depth.limit");
		int d			= 4; // 3단계 (+1) 추가 계산
/*
		if (c != null || ! "".equals(c)) {
			d = new Integer(c);
		}
*/
		if (b.length <= d) {	// 3단계 이하면 분류생성
			this.archvCatgryDAO.create(archvCatgry);
			return 1;
		}
		else {
			return 2;	// 4단계 이상은 분류생성불가
		}
	}

	@Override
	public int del(ArchvCatgry archvCatgry) throws Exception {
		Integer cnt = this.archvCatgryDAO.is_exst_prnt(archvCatgry);
		Integer archv_cnt = this.archvCatgryDAO.is_exst_archv(archvCatgry);

		if (cnt.intValue() > 0) {
			return 2;	// 하위 분류가 있어서 삭제 거부
		}
		else if (archv_cnt.intValue() > 0) {
			return 3;	// 등록된 archv 자료가 있어서 삭제 거부
		}
		else
			return this.archvCatgryDAO.del(archvCatgry);
	}

	@Override
	public int update(ArchvCatgry archvCatgry) throws Exception {
		return this.archvCatgryDAO.update(archvCatgry);
	}

	@Override
	public ArchvCatgryVO getNamePath(String no) throws Exception {
		return this.archvCatgryDAO.getNamePath(no);
	}

	@Override
	public List<ArchvCatgryVO> getCatgryLang(ArchvCatgryVO archvCatgryVO) {
		return this.archvCatgryDAO.getCatgryLang(archvCatgryVO);
	}

	@Override
	public List<ArchvLangOpt> getCatgryLangOpt(Object object) {
		return this.archvCatgryDAO.getCatgryLangOpt(object);
	}

	@Override
	public void updateCatgryLang(ArchvCatgryVO archvCatgryVO) {
		this.archvCatgryDAO.updateCatgryLang(archvCatgryVO);
	}

}
