package com.z5.zcms.admsys.auth.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.auth.domain.AuthAdminVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuPermissionInfoListVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuPermissionVo;
import com.z5.zcms.admsys.auth.domain.FunctionPerMenuVo;
import com.z5.zcms.admsys.auth.domain.MenuAuthVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class MenuAuthDAOImpl extends EgovComAbstractDAO implements MenuAuthDAO {

	private final String sqlMapNs = "Auth.";

	@Override
	@SuppressWarnings("unchecked")
	public List<MenuAuthVo> authMenuAllList(MenuAuthVo menuAuthVo){
		return (List<MenuAuthVo>) list(sqlMapNs+"authMenuAllList", null);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MenuAuthVo> authMenuList(MenuAuthVo menuAuthVo){
		return (List<MenuAuthVo>) list(sqlMapNs+"authMenuList", menuAuthVo);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public MenuAuthVo authMenuInfo(MenuAuthVo menuAuthVo) {
		return (MenuAuthVo)selectByPk(sqlMapNs+"authMenuInfo", menuAuthVo);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MenuAuthVo> authMenuListForInitCheck(MenuAuthVo menuAuthVo) {
		return (List<MenuAuthVo>) list(sqlMapNs+"authMenuListForInitCheck", menuAuthVo);
	}

	@Override
	public int registrationFunctionInfo(FunctionPerMenuVo vo) {
		return (int)super.insert(sqlMapNs+"registrationFunctionInfo", vo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FunctionPerMenuVo> retrieveFunctionInfo(FunctionPerMenuVo vo) {		
		return (List<FunctionPerMenuVo>) list(sqlMapNs+"retrieveFunctionInfo", vo);
	}

	@Override
	public int deleteFunctionInfo(FunctionPerMenuVo vo) {
		return super.delete(sqlMapNs+"deleteFunctionInfo", vo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> retrieveGroupNoList() {
		return (List<Integer>)super.list(sqlMapNs+"retrieveGroupNoList");
	}

	@Override
	public void registrationFunctionPerMenuPermission(List<FunctionPerMenuPermissionVo> permList) {
		super.insert(sqlMapNs+"registrationFunctionPerMenuPermission", permList);
	}

	@Override
	public int updatePermissionAllowYN(FunctionPerMenuPermissionVo no) {
		return super.update(sqlMapNs+"updatePermissionAllowYN", no);
	}

	@Override
	public int deleteFunctionInfoWithPermission(FunctionPerMenuPermissionVo fVo) {
		return super.update(sqlMapNs+"deleteFunctionInfoWithPermission", fVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FunctionPerMenuPermissionInfoListVo> retrievePerList(FunctionPerMenuPermissionInfoListVo vo) {
		return (List<FunctionPerMenuPermissionInfoListVo>)super.list(sqlMapNs+"retrievePerList", vo);
	}

	@Override
	public int updateMenuViewYN(AuthAdminVo vo) {
		return super.update(sqlMapNs+"updateMenuViewYN", vo);
	}

	@Override
	public void registrationFunctionPerMenuPermissionWhenAddGroupNo(FunctionPerMenuPermissionVo vo) {
		super.insert(sqlMapNs+"registrationFunctionPerMenuPermissionWhenAddGroupNo", vo);
		
	}

	@Override
	public String adminPermissionMenuYn(String userId) {
		return (String)super.selectByPk(sqlMapNs+"adminPermissionMenuYn", userId);
	}
}