package com.z5.zcms.admsys.auth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.auth.domain.Auth;
import com.z5.zcms.admsys.auth.domain.AuthVo;
import com.z5.zcms.admsys.auth.domain.GAuthEmp;
import com.z5.zcms.admsys.user.domain.ZUserVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class AuthDAOImpl extends EgovComAbstractDAO implements AuthDAO {

	Logger log = Logger.getLogger(this.getClass());

	private final String sqlMapNs = "Auth.";

	@Override
	@SuppressWarnings("unchecked")
	public List<AuthVo> authList(AuthVo authVo) {
		return (List<AuthVo>) list(sqlMapNs+"authList", authVo);
	}

	@Override
	public void authListSel(Auth auth) {
		insert(sqlMapNs+"authListSel", auth);
	}

	@Override
	public void authAdminListSel(Auth auth) {
		insert(sqlMapNs+"authAdminListSel", auth);
	}

	@Override
	public void authDelete(Auth auth) {
		delete(sqlMapNs+"authDelete", auth);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> authSubMenuList(Auth auth) {
		return (List<String>) list(sqlMapNs+"authSubMenuList", auth);
	}

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
	public List<GAuthEmp> authEmpList(GAuthEmp gAuthEmp) {
		return (List<GAuthEmp>) list(sqlMapNs+"authEmpList", gAuthEmp);
	}

	@Override
	public int listCount(GAuthEmp gAuthEmp) {
		return (Integer) selectByPk(sqlMapNs + "listCount", gAuthEmp);
	}

	@Override
	public void authMutiDelete(Auth auth) {
		delete(sqlMapNs+"authMutiDelete", auth);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> authMenus(String authno) {
		return (List<Integer>) list(sqlMapNs+"authMenus", authno);
	}
	
	@Override
	public void delete(List<String> arrDeleteNo) {
		delete(sqlMapNs+"delete", arrDeleteNo);
	}

	@Override
	public void insertEmp(GAuthEmp gAuthEmp) {
		delete(sqlMapNs+"insertEmp", gAuthEmp);
	}

	@Override
	public List<ZUserVo> chargeList(ZUserVo zUserVo) {
		return (List<ZUserVo>) list(sqlMapNs+"chargeList", zUserVo);
	}

	@Override
	public int chargeListCount(ZUserVo zUserVo) {
		return (Integer) selectByPk(sqlMapNs + "chargeListCount", zUserVo);
	}
	
}
