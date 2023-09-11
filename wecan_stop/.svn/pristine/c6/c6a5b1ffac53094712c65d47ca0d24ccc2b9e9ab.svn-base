package com.z5.zcms.admsys.auth.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.auth.dao.EmpSchDAO;
import com.z5.zcms.admsys.auth.domain.GAuthEmp;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class EmpSchServiceImpl extends AbstractServiceImpl implements EmpSchService {

	@Autowired
	EmpSchDAO empSchDao;

	@Override
	public List<GAuthEmp> hqList() {
		return this.empSchDao.hqList();
	}
	
	@Override
	public List<GAuthEmp> deptList(GAuthEmp gAuthEmp) {
		return this.empSchDao.deptList(gAuthEmp);
	}
	
	@Override
	public List<GAuthEmp> empList(GAuthEmp gAuthEmp) {
		return this.empSchDao.empList(gAuthEmp);
	}

	@Override
	public List<Map<String, String>> groupList(GAuthEmp gAuthEmp) {
		return this.empSchDao.groupList(gAuthEmp);
	}
}