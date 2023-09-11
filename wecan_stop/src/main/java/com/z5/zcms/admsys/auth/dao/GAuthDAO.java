package com.z5.zcms.admsys.auth.dao;

import java.util.List;

import com.z5.zcms.admsys.auth.domain.GAuth;
import com.z5.zcms.admsys.auth.domain.GAuthVo;

public interface GAuthDAO {
	public List<GAuthVo> gAuthList(GAuthVo gAuthVo);
	public void gAuthListSel(GAuth gAuth);
	public void gAuthDelete(GAuth gAuth);
	public void gAuthCreate(GAuthVo gAuthVo);
	public void gAuthSetGroup(GAuth gAuth);
	public void gAuthAdminSetGroup(GAuth gAuth);
	public void gAuthDefaultGroup(GAuth gAuth);
	public int gAuthGroupCheck(GAuth gAuth);
}
