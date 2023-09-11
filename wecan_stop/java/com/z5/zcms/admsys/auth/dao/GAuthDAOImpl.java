package com.z5.zcms.admsys.auth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.auth.domain.GAuth;
import com.z5.zcms.admsys.auth.domain.GAuthVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class GAuthDAOImpl extends EgovComAbstractDAO implements GAuthDAO {

	Logger log = Logger.getLogger(this.getClass());

	private final String sqlMapNs = "Auth.";

	@Override
	@SuppressWarnings("unchecked")
	public List<GAuthVo> gAuthList(GAuthVo gAuthVo) {
		return (List<GAuthVo>) list(sqlMapNs+"gAuthList", gAuthVo);
	}

	@Override
	public void gAuthListSel(GAuth gAuth) {
		insert(sqlMapNs+"gAuthListSel", gAuth);
	}

	@Override
	public void gAuthDelete(GAuth gAuth) {
		if (null==gAuth.getAuth_no()){
			delete(sqlMapNs+"gAuthGroupDel1", gAuth.getArrDeleteNo());
			delete(sqlMapNs+"gAuthGroupDel2", gAuth.getArrDeleteNo());
			delete(sqlMapNs+"gAuthGroupDel3", gAuth.getArrDeleteNo());
		}
		else {
			delete(sqlMapNs+"gAuthDelete", gAuth);
		}
	}

	@Override
	public void gAuthCreate(GAuthVo gAuthVo) {
		insert(sqlMapNs+"gAuthCreate", gAuthVo);
	}

	@Override
	public void gAuthSetGroup(GAuth gAuth) {
		insert(sqlMapNs+"gAuthSetGroup", gAuth);
	}

	@Override
	public void gAuthAdminSetGroup(GAuth gAuth) {
		insert(sqlMapNs+"gAuthAdminSetGroup", gAuth);
	}

	@Override
	public void gAuthDefaultGroup(GAuth gAuth) {
		insert(sqlMapNs+"gAuthDefaultGroup", gAuth);
	}

	@Override
	public int gAuthGroupCheck(GAuth gAuth)	{
		return (Integer)this.getSqlMapClientTemplate().queryForObject(sqlMapNs+"gAuthGroupCheck", gAuth);
	}
}
