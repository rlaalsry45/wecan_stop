package com.z5.zcms.admsys.auth.service;

import java.util.List;
import java.util.Map;

import com.z5.zcms.admsys.auth.domain.GAuthEmp;

public interface EmpSchService {
	public List<GAuthEmp> hqList();
	public List<GAuthEmp> deptList(GAuthEmp gAuthEmp);
	public List<GAuthEmp> empList(GAuthEmp gAuthEmp);
	public List<Map<String, String>> groupList(GAuthEmp gAuthEmp);
}