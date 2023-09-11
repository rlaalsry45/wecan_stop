package com.z5.zcms.admsys.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.auth.dao.MenuAuthDAO;
import com.z5.zcms.admsys.auth.domain.AuthAdminVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuPermissionInfoListVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuPermissionVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuVo;
import com.z5.zcms.admsys.auth.domain.MenuAuthVo;

@Service
public class MenuAuthServiceImpl implements MenuAuthService {

	@Autowired
	private MenuAuthDAO menuAuthDAO;

	@Override
	public List<MenuAuthVo> authMenuAllList(MenuAuthVo menuAuthVo){
		return menuAuthDAO.authMenuAllList(menuAuthVo);
	}

	@Override
	public List<MenuAuthVo> authMenuList(MenuAuthVo menuAuthVo){
		return menuAuthDAO.authMenuList(menuAuthVo);
	}
	
	@Override
	public MenuAuthVo authMenuInfo(MenuAuthVo menuAuthVo) {
		return menuAuthDAO.authMenuInfo(menuAuthVo);
	}

	@Override
	public List<MenuAuthVo> authMenuListForInitCheck(MenuAuthVo menuAuthVo) {
		return menuAuthDAO.authMenuListForInitCheck(menuAuthVo);
	}

	@Override
	public int registrationFunctionInfo(FunctionPerMenuVo vo) {
		return menuAuthDAO.registrationFunctionInfo(vo);
	}

	@Override
	public List<FunctionPerMenuVo> retrieveFunctionInfo(FunctionPerMenuVo vo) {
		return menuAuthDAO.retrieveFunctionInfo(vo);
	}

	@Override
	public int deleteFunctionInfo(FunctionPerMenuVo vo) {
		return menuAuthDAO.deleteFunctionInfo(vo);
	}

	@Override
	public List<Integer> retrieveGroupNoList() {
		return menuAuthDAO.retrieveGroupNoList();
	}

	@Override
	public void registrationFunctionPerMenuPermission(List<FunctionPerMenuPermissionVo> permList) {
		menuAuthDAO.registrationFunctionPerMenuPermission(permList);
	}

	@Override
	public int updatePermissionAllowYN(FunctionPerMenuPermissionVo no) {
		return menuAuthDAO.updatePermissionAllowYN(no);
	}

	@Override
	public int deleteFunctionInfoWithPermission(FunctionPerMenuPermissionVo fVo) {
		return menuAuthDAO.deleteFunctionInfoWithPermission(fVo);
	}

	@Override
	public List<FunctionPerMenuPermissionInfoListVo> retrievePerList(FunctionPerMenuPermissionInfoListVo vo) {
		return menuAuthDAO.retrievePerList(vo);
	}

	@Override
	public int updateMenuViewYN(AuthAdminVo vo) {
		return menuAuthDAO.updateMenuViewYN(vo);
	}
}
