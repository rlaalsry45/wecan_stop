package com.z5.zcms.admsys.auth.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.auth.domain.GAuthEmp;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class EmpSchDAOImpl extends EgovComAbstractDAO implements EmpSchDAO {

	private final String sqlMapNs = "Auth.";

	@Override
	@SuppressWarnings("unchecked")
	public List<GAuthEmp> hqList() {
		return (List<GAuthEmp>) list(sqlMapNs+"hqList", null);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<GAuthEmp> deptList(GAuthEmp gAuthEmp) {
		return (List<GAuthEmp>) list(sqlMapNs+"deptList", gAuthEmp);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<GAuthEmp> empList(GAuthEmp gAuthEmp) {
		return (List<GAuthEmp>) list(sqlMapNs+"empList", gAuthEmp);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> groupList(GAuthEmp gAuthEmp) {
		return (List<Map<String, String>>) list(sqlMapNs+"groupList", gAuthEmp);
	}
}
