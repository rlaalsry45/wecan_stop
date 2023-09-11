package com.z5.zcms.frontsys.archv.dao;

import java.util.List;

import com.z5.zcms.frontsys.archv.domain.ArchvCatgry;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvLangOpt;

public interface ArchvCatgryDAO {

	public List<ArchvCatgry> list(ArchvCatgry archvCatgry) throws Exception;
	public void create(ArchvCatgry archvCatgry) throws Exception;
	public int update(ArchvCatgry archvCatgry) throws Exception;
	public int del(ArchvCatgry archvCatgry) throws Exception;
	public Integer is_exst_prnt(ArchvCatgry archvCatgry) throws Exception;
	public Integer is_exst_archv(ArchvCatgry archvCatgry) throws Exception;
	public ArchvCatgryVO getNamePath(String no) throws Exception;
	public List<ArchvCatgryVO> getCatgryLang(ArchvCatgryVO archvCatgryVO);
	public List<ArchvLangOpt> getCatgryLangOpt(Object object);
	public void updateCatgryLang(ArchvCatgryVO archvCatgryVO);

}
