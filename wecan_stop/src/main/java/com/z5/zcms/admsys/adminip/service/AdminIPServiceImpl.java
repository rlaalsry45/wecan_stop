package com.z5.zcms.admsys.adminip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.adminip.dao.AdminIPDAO;
import com.z5.zcms.admsys.adminip.domain.AdminIPVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class AdminIPServiceImpl extends AbstractServiceImpl implements AdminIPService{
	
	@Autowired
	private AdminIPDAO adminIPDAO;
	
	@Override
	public List<AdminIPVO> getList(AdminIPVO adminIPVO) {
		return this.adminIPDAO.getList(adminIPVO);
	}

	@Override
	public int getIPCount(AdminIPVO adminIPVO) throws Exception {
		return this.adminIPDAO.getIPCount(adminIPVO);
	}

	@Override
	public void delete(List<Integer> arrDeleteNo) throws Exception {
		adminIPDAO.delete(arrDeleteNo);
	}

	@Override
	public AdminIPVO selectUP(int no) {
		return (AdminIPVO)adminIPDAO.selectUP(no);
	}

	@Override
	public void update(AdminIPVO adminIPVO) throws Exception{
		adminIPDAO.update(adminIPVO);
	}

	@Override
	public void insert(AdminIPVO adminIPVO) throws Exception{
		adminIPDAO.insert(adminIPVO);
	}

	@Override
	public Integer IPCount(AdminIPVO adminIPVO) throws Exception {
		return this.adminIPDAO.IPCount(adminIPVO);
	}

	@Override
	public int checkIPDouble(AdminIPVO adminIPVO) throws Exception{
		return this.adminIPDAO.checkIPDouble(adminIPVO);
	}

	@Override
	public int getCurrvalSequence(AdminIPVO adminIPVO){
		return this.adminIPDAO.getCurrvalSequence(adminIPVO);
	}

}
