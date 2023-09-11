package com.z5.zcms.admsys.adminip.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.adminip.domain.AdminIPVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class AdminIPDAOImpl extends EgovComAbstractDAO implements AdminIPDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "adminIPDAO.";

	
	@Override
	public Integer IPCount(AdminIPVO adminIPVO) {
		return (Integer) super.selectByPk(sqlMapNs+"IPCount",adminIPVO);
	}

	@Override
	public List<AdminIPVO> getList(AdminIPVO adminIPVO) {
		return (List<AdminIPVO>) super.list(sqlMapNs+"list", adminIPVO);
	}

	@Override
	public void delete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs+"delete", arrDeleteNo);
	}

	@Override
	public void update(AdminIPVO adminIPVO) {
		update(sqlMapNs+"update", adminIPVO);
	}

	@Override
	public void insert(AdminIPVO adminIPVO) {
		insert(sqlMapNs+"insert", adminIPVO);
	}

	@Override
	public AdminIPVO selectUP(int no) {
		return (AdminIPVO)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectUP", no);
	}

	@Override
	public int getIPCount(AdminIPVO adminIPVO) {
		return (Integer)selectByPk(sqlMapNs+"getIPCount", adminIPVO);
	}

	@Override
	public int checkIPDouble(AdminIPVO adminIPVO) {
		return (Integer)selectByPk(sqlMapNs+"checkIPDouble",  adminIPVO);
	}

	@Override
	public int getCurrvalSequence(AdminIPVO adminIPVO) {
		return (Integer)selectByPk(sqlMapNs+"getCurrvalSequence", adminIPVO);
	}



}
