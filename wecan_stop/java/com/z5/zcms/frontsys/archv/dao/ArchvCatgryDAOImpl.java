package com.z5.zcms.frontsys.archv.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.frontsys.archv.domain.ArchvCatgry;
import com.z5.zcms.frontsys.archv.domain.ArchvCatgryVO;
import com.z5.zcms.frontsys.archv.domain.ArchvLangOpt;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ArchvCatgryDAOImpl extends EgovComAbstractDAO implements ArchvCatgryDAO {

	private final String sqlNS = "ArchvCatgry.";

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvCatgry> list(ArchvCatgry archvCatgry) throws Exception {
		return this.getSqlMapClientTemplate().queryForList(this.sqlNS + "list", archvCatgry);
	}

	@Override
	public void create(ArchvCatgry archvCatgry) throws Exception {
		this.getSqlMapClientTemplate().insert(this.sqlNS + "create", archvCatgry);
	}

	@Override
	public int del(ArchvCatgry archvCatgry) throws Exception {
		return this.getSqlMapClientTemplate().delete(this.sqlNS + "del", archvCatgry);
	}

	@Override
	public Integer is_exst_prnt(ArchvCatgry archvCatgry) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject(this.sqlNS + "is_exst_prnt", archvCatgry);
	}

	@Override
	public int update(ArchvCatgry archvCatgry) throws Exception {
		return this.getSqlMapClientTemplate().update(this.sqlNS + "update", archvCatgry);
	}

	@Override
	public ArchvCatgryVO getNamePath(String no) throws Exception {
		return (ArchvCatgryVO) this.getSqlMapClientTemplate().queryForObject(this.sqlNS + "getNamePath", Integer.valueOf(no));
	}

	@Override
	public Integer is_exst_archv(ArchvCatgry archvCatgry) throws Exception {
		return (Integer) this.getSqlMapClientTemplate().queryForObject(this.sqlNS + "is_exst_in_archv", archvCatgry);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvCatgryVO> getCatgryLang(ArchvCatgryVO archvCatgryVO) {
		return this.getSqlMapClientTemplate().queryForList(this.sqlNS + "getCatgryLang", archvCatgryVO);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArchvLangOpt> getCatgryLangOpt(Object object) {
		return this.getSqlMapClientTemplate().queryForList(this.sqlNS + "getCatgryLangOpt", object);
	}

	@Override
	public void updateCatgryLang(ArchvCatgryVO archvCatgryVO) {
		this.getSqlMapClientTemplate().update(this.sqlNS + "updateCatgryLang", archvCatgryVO);
	}
}
