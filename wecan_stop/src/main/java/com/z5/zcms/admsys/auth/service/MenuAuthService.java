package com.z5.zcms.admsys.auth.service;

import java.util.List;

import com.z5.zcms.admsys.auth.domain.AuthAdminVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuPermissionInfoListVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuPermissionVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuVo;
import com.z5.zcms.admsys.auth.domain.MenuAuthVo;

public interface MenuAuthService {
	public List<MenuAuthVo> authMenuAllList(MenuAuthVo menuAuthVo);
	public List<MenuAuthVo> authMenuList(MenuAuthVo menuAuthVo);
	public MenuAuthVo authMenuInfo(MenuAuthVo menuAuthVo);
	public List<MenuAuthVo> authMenuListForInitCheck(MenuAuthVo menuAuthVo);
	public int registrationFunctionInfo(FunctionPerMenuVo vo);
	public List<FunctionPerMenuVo> retrieveFunctionInfo(FunctionPerMenuVo vo);
	public int deleteFunctionInfo(FunctionPerMenuVo vo);
	public List<Integer> retrieveGroupNoList();
	public void registrationFunctionPerMenuPermission(List<FunctionPerMenuPermissionVo> permList);
	public int updatePermissionAllowYN(FunctionPerMenuPermissionVo vo);
	public int deleteFunctionInfoWithPermission(FunctionPerMenuPermissionVo fVo);
	public List<FunctionPerMenuPermissionInfoListVo> retrievePerList(FunctionPerMenuPermissionInfoListVo vo);
	public int updateMenuViewYN(AuthAdminVo vo);
	public void registrationFunctionPerMenuPermissionWhenAddGroupNo(FunctionPerMenuPermissionVo vo);
	public String adminPermissionMenuYn(String userId);
}