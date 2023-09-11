package com.z5.zcms.admsys.auth.service;

import java.util.List;

import com.z5.zcms.admsys.auth.domain.Auth;
import com.z5.zcms.admsys.auth.domain.AuthVo;
import com.z5.zcms.admsys.auth.domain.GAuthEmp;
import com.z5.zcms.admsys.user.domain.ZUserVo;

public interface AuthService {

	public List<AuthVo> authList(AuthVo authVo);
	public void authListSel(Auth auth);
	public void authAdminListSel(Auth auth);
	public void authDelete(Auth auth);
	public List<String> authSubMenuList(Auth auth);
	public List<GAuthEmp> hqList();
	public List<GAuthEmp> deptList(GAuthEmp gAuthEmp);
	public int listCount(GAuthEmp gAuthEmp);
	public List<GAuthEmp> authEmpList(GAuthEmp gAuthEmp);
	public void authMutiDelete(Auth auth);
	public List<Integer> authMenus(String authno);
	
	public void delete(List<String> arrDeleteNo);
	
	public List<ZUserVo> chargeList(ZUserVo zUserVo);
	public int chargeListCount(ZUserVo zUserVo);
	
	public List<GAuthEmp> authEmpListExcel(GAuthEmp gAuthEmp);
}

